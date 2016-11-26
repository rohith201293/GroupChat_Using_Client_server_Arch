# GroupChat_Using_Client_server_Arch


This Application is developed  using core Java. This application is runned on console.



Contents:

HttpServer: This is the server File where the requests from  each client is handled and sent to clients.

TCP  CLient: This is the client side application through which user can connect to Server  running on particular code.


#  Description:

This is a console application, which uses TCP/IP protocol to  establish the connection  between client and server.  
It consits  of two files HttpServer which is a server file.  TCP which is a Client File.

In this Application, Number of client can connect to the server running with in same network. Each client can Send the Message to other client connected.

Specality:

In this Application, client can filter the clients to  whom he/she want to send the message. all the rest will not  receive  that particular message.


#  Running the  Application:

To the run the application, you need to have Java installed on  you device.

Steps:

Open the  Command prompt/IDE.

Fisrt,  Start Server. With arguments.(arguments  will be port number on  which sever  should  listen. EX:5951)

If  running  through a command prompt, use following Commands.
  
  Javac HttpServer.java // compile
  
  Java  Httpserver 5951 //  run the code.
  
  running the clients:
  
  Javac TCP.java // compile
  
  Java  TCP 192.168.0.1 5951 //  run the code.

since the clients are differentiated through  the sockets, you can connect  the other clinets in the same system or the other  system  with  in same network.

I would suggest to Connect a minimum 3  clients to check the special functionlity of the application.

#  Sending  Message:

TO  send Message to all Clients connected,

all:Message

To Send Message to particular clients ignoring some,

Client-2:Client-4: Message
Client-3: Message.



Thank You For your time.


