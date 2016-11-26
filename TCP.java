import java.io.*;
import java.net.*;
import java.lang.*;

public class TCP {

	private  static int  DEST_PORT;
	private  static String SERVER_NAME;
	
	/**
	 * @param args
	 */
       public static BufferedReader in;
       public static String serverReply;	
       public static Socket clientSocket;
       public static String inputString;
       public static PrintWriter out;
       public static BufferedReader kbdReader = new BufferedReader(new InputStreamReader(System.in));
       static Thread t = new Thread(){
       public void run()
        {
        try{
      
        in=  new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        while(true)
        {
        
         serverReply=in.readLine();
                  
        if(serverReply!= null)
        {	
        	System.out.println(serverReply);
         }
        }
        }
       
        catch(Exception e)
        {
                System.out.println("Server Shutdown \t please re connect");
                       }
}
};

         static Thread t1= new Thread(){
         public void run()
         {
           while (true)
            {
              try{
     
  			  			 inputString = kbdReader.readLine();
				out = new PrintWriter(clientSocket.getOutputStream(), true);

			//Get the input and output streams of the socket
						//write the bytes out to the server
			out.println(inputString);
         }
         
         catch(Exception e)
         {
             System.out.println("Bye");
                 
       
         }
         }
         
}
};
 public static void run()
       {        	
        t.start();
		t1.start();
}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SERVER_NAME = args[0];
       DEST_PORT=Integer.parseInt(args[1]);
		try
		{
			//Get IP address object of server from hostname
			
			InetAddress dstIP = InetAddress.getByName(SERVER_NAME);
			
			//Create local socket and connect to server
			clientSocket = new Socket(dstIP, DEST_PORT);
			
			//Read text from Keyboard
			
         	
      			run();
			
			//read reply from server as a byte stream
				
		//	
	
		}	
				
		catch (Exception e)
		{
			System.out.println("Did not Connect please try again ");
		}
	}
}
