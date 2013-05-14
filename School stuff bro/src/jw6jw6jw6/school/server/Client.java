package jw6jw6jw6.school.server;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client
{
   public static void main(String [] args)
   {
	   Scanner input = new Scanner(System.in);
      String serverName = "127.0.0.1";
      int port = 85;
      try
      {
         System.out.println("Connecting to " + serverName + " on port " + port);
         Socket client = new Socket(serverName, port);
         System.out.println("Connected to " + client.getRemoteSocketAddress());
         OutputStream outToServer = client.getOutputStream();
         DataOutputStream out = new DataOutputStream(outToServer);
         InputStream inFromServer = client.getInputStream();
         DataInputStream in = new DataInputStream(inFromServer);
         System.out.println(in.readUTF());
         String temp = input.nextLine();
         out.writeUTF(temp);
         if(Integer.parseInt(temp) == 1)
         {
        	 System.out.println(in.readUTF());
        	 out.writeUTF(input.nextLine());
        	 System.out.println(in.readUTF());
        	 System.out.println(in.readUTF());
         }
         else
         {
//        	 System.err.println("ELSE");
        	 System.out.println(in.readUTF());
        	 out.writeUTF(input.nextLine());
        	 System.out.println(in.readUTF());
         }
         client.close();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}