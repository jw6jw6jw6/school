package jw6jw6jw6.school.server;

import java.net.*;
import java.io.*;

public class MoneyServer extends Thread
{
   private ServerSocket serverSocket;
   
   public MoneyServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
   }

   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            java.net.Socket server = serverSocket.accept();
            System.out.println("Just connected to " + server.getRemoteSocketAddress());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to the Bank of good fortune, please enter your username");
            DataInputStream in = new DataInputStream(server.getInputStream());
            String user =in.readUTF();
            DataInputStream in1 = new DataInputStream(server.getInputStream());
            String pin =in1.readUTF();
            int x=0;
            out.writeUTF("You have "+x+" Forwards");
            server.close();
         }catch(IOException e)
         {
            e.printStackTrace();
            break;
         }
      }
   }
   public static void main(String [] args)
   {
      int port = 85;
      try
      {
         Thread t = new MoneyServer(port);
         t.start();
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}