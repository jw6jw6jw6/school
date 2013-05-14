package jw6jw6jw6.school.server;

import java.net.*;
import java.util.TreeMap;
import java.io.*;

public class MoneyServer extends Thread
{
   private ServerSocket serverSocket;
   private static TreeMap<Integer,Double> Money = new TreeMap<Integer,Double>();
   
   public MoneyServer(int port) throws IOException
   {
      serverSocket = new ServerSocket(port);
   }
   
   public void transfer(int acct, int acct2, double amount)
   {
	   boolean find1 = false, find2 = false;
	   for(int x = 0; x < Money.size(); x++)
	   {
		   if(Money.get(x) == acct)
			   find1 = true;
		   if(Money.get(x) == acct2)
			   find2 = true;
	   }
	   if(find1 && find2)
	   {
		   Double tmp = Money.get(acct);
		   Money.put(acct, tmp - amount);
		   tmp = Money.get(acct2);
		   Money.put(acct2, tmp + amount);
	   }	   
   }

   public void run()
   {
      while(true)
      {
         try
         {
            System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
            java.net.Socket server = serverSocket.accept();
            System.out.println("[CONNECTED]" + server.getRemoteSocketAddress());
            DataOutputStream out = new DataOutputStream(server.getOutputStream());
            out.writeUTF("Thank you for connecting to the Bank of good fortune, Do you have an account? (1 for yes, 2 for no)");
            DataInputStream in = new DataInputStream(server.getInputStream());
            String tmp = in.readUTF();
            Double forwards = 0.0;
            if(Integer.parseInt(tmp) == 1)
            {
            	out.writeUTF("Enter user ID");
            	String user = in.readUTF();
            	if(Money.containsKey(Integer.parseInt(user)))
            	{
            	forwards = Money.get(Integer.parseInt(user));
            	out.writeUTF("You have "+forwards+" Forwards");
            	out.writeUTF("Would you like to transfer Forwards?");
            	tmp = in.readUTF();
            	if(Integer.parseInt(tmp) == 1)
            	{
            		out.writeUTF("Enter ID to transfer Forwards to");
            		transfer(Integer.parseInt(user),Integer.parseInt(in.readUTF()),Double.parseDouble(in.readUTF()));
            	}
            	}
            	else
            		out.writeUTF("User ID not found!");
            }
            else
            {
            	out.writeUTF("Would you like to open an account?");
            	tmp = in.readUTF();
            	System.out.println(tmp);
            	if(Integer.parseInt(tmp) == 1)
            		Money.put(Money.size(), 0.0);
            	int tmp1 = Money.size();
            	out.writeUTF("Your Account has been created, your user ID is " + tmp1);
            }
            out.writeUTF("Ending Connection");
//            server.close();
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