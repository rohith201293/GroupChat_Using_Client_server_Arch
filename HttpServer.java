/*
* Program: HTTPServer Response
* Author: Rohith Kumar 
* *
*/

//import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;

//import java.io.FileInputStream;

/**
 * @author Rohith Kumar 
 *
 */
 // ServerSocket svrSocket;
 

//static Thread[] l = new Thread[12]; 
public class HttpServer{
static ServerSocket svrSocket;
static Socket lst[]= new Socket[12];
static int c=0,d=0,q=0;
static String[] k =new String[15];
static String[] v =new String[15];
// static Socket[] group = new Socket[12]; 
public static BufferedReader kbdReader = new BufferedReader(new InputStreamReader(System.in));
static Hashtable<String, Socket> mylist = new Hashtable<String,Socket>(); 
static class Server extends Thread  {

     
        /**
         * @param args
         */
         
          Socket client;
          BufferedReader in;
          PrintWriter out;
          InetAddress clientIP;
          
             int count=0,count1=0,n;
          String Add[] = new String[12];
              String me=null;
           String[] roh = new String[15];
           int cou=0,cou1=0;
           
         Server(Socket client) throws SocketException
             {
               this.client = client;
                            }
         public  void morethanone(int cou,int connectionsize,String[] roh ,String[] v,InetAddress clientIP)
         {
             for(int loop1=0;loop1<cou;loop1++)
             {
           	  for(int loop2=0;loop2<connectionsize;loop2++)
           	  {
           	if(roh[loop1].startsWith("Client"))
           	{
           		
                         if(v[loop2].equals(roh[loop1])) 
                         {
		                Socket temp=mylist.get(v[loop2]);
		               try{
                   	   
                          out = new PrintWriter(temp.getOutputStream(), true);
                         if(temp.getInetAddress() != clientIP &&temp!=null)
                            {
                            if(me!=null)
                            {
                           out.println(Thread.currentThread().getName()+":"+roh[cou-1]);
                             }
                             }
                             }
		              catch(Exception e )
                      {
                          e.printStackTrace();
    
                      }
                         }
              	   
            }
             }
             }
        	 
         }
           
             public void run()  
               {  
               while(true)
               {  
               try{
                  
                             clientIP = client.getInetAddress();
                           System.out.println("Connected to " + clientIP.toString());
                          Add[count1]= clientIP.toString();
                           count1++;
                           
                          
                          
                                      }
                   catch(Exception e)
                  {
                     e.printStackTrace();
                       }          
                   
                                             

                                   
                         while(true)
   			                   {
                                  try{
                             in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                             me = in.readLine();
                             StringTokenizer st = new StringTokenizer(me,":");       
                             Enumeration names;
                             names= mylist.keys();
                             int connectionsize=mylist.size();
              	              
                            while(st.hasMoreTokens())
                             {
                            	 roh[cou]=st.nextToken();
                            	 cou++;
                            	 
                             }
                             while(names.hasMoreElements())
                            	{
                            	   v[cou1]=(String)names.nextElement();
                            	   cou1++;
                            	}
                             if(cou>2)
                             {
                            	 morethanone(cou,connectionsize,roh ,v, clientIP);
                             }
                             if(cou<=2)
                             {
                            	 if(roh[0].startsWith("all"))
                            	 {
                            		 for(int i=0;i<c;i++)
                                     {
                                                                                 
                                            try{
                                         	   
                                          out = new PrintWriter(lst[i].getOutputStream(), true);
                                         if(lst[i].getInetAddress() != clientIP &&lst[i]!=null)
                                            {
                                            if(me!=null)
                                            {
                                           out.println(Thread.currentThread().getName()+":"+roh[cou-1]);
                                             }
                                             }
                                             }
                                            
                                                 catch(Exception e )
                                                   {
                                                       e.printStackTrace();
                                 
                                                   }
                            		 
                            	 }
                            	 
                             }
                            	 if(roh[0].startsWith("Client"))
                            	 {
                            		 morethanone(cou,connectionsize,roh ,v, clientIP);
                            	 }
                             }
                       
                             cou=0;cou1=0;
                             
                            	}
                                     catch(Exception e)
                                     {
                                                                      
                                        System.out.println(Thread.currentThread().getName()+" terminated");
                                        Thread.currentThread().stop();
                              
                                                                                                                   
                                    }
                                    }
                                                                   
			 }
                   
               }
           }
 
              //}
                      public static void main(String[] argc)throws SocketException {
                // TODO Auto-generated method stub
                                  String s=argc [0];
                                  int DEST_PORT = Integer.parseInt(s);
                                   
                                     Server[] l = new Server[12];                  
                                        try{ 
                                        svrSocket = new ServerSocket(DEST_PORT);
                                                 while(true)
                                                  {
                                                   try{
                                         System.out.println("Waiting for client:");
                                          Socket   ClientSock= svrSocket.accept();
                                          lst[c]=ClientSock;
                                                       
                                                           l[c]= new Server(ClientSock); 
                                                           l[c].setName("Client-"+ (c+1));
                                                            mylist.put(l[c].getName(),ClientSock);                   
                                                            k[c]=l[c].getName();
                                                            l[c].start();
                                                            c++; 
                                                        
                                                        
                                                         }
                			catch (Exception e)
                		          {
                        			e.printStackTrace();
               				   }
        				}

                                }
                                       catch(Exception e)
                                       {
                                          e.printStackTrace();
                                       }

                                            }
                                                  }
                                                  
