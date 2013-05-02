package jw6jw6jw6.school.labs;
import java.io.*;
import java.util.ArrayList;
public class lab11
{
	static public float sbalance[]=new float[20];
	static public  float trans[][]=new float[21][];
	static public  float ebalance[]=new float[20];
	static public  ArrayList<String> arrayfile = new ArrayList<String>();
	public static void main(String evanlikestrains[])throws IOException
	{
		input();
		transactions();
		calcnewbal();
		hub();
	}

	public static void input()throws IOException
	{
		File file = new File("lab11.txt");
		file.createNewFile();
		BufferedReader inStream = new BufferedReader(new FileReader(file));
		String inString;
		int x=0;
		while((inString = inStream.readLine()) != null)
		{
			if(x<20)
			{
				sbalance[x]=Float.parseFloat(inString);
			}
			else
				arrayfile.add(inString);
			x++;
		}
		inStream.close();

	}

	public static void print()
	{
		System.out.println(arrayfile);
//		for(int x=0;x<20;x++)
//		{
//			System.out.println(sbalance[x]);
//		}
	}

	public static void transactions()
	{
		for(int x=0;x<20;x++)
		{
			int temp=Integer.parseInt(arrayfile.get(0));
			arrayfile.remove(0);
			trans[x]=new float[temp];
			for(int y=0;y<temp;y++)
			{
				trans[x][y]=Float.parseFloat(arrayfile.get(y));
			}
			for(int y=0;y<temp;y++)
			{
				arrayfile.remove(0);
			}
//			print();
		}
	}
	
	public static void printtrans()
	{
		for(int x=0;x<20l;x++)
		{
			int temp=trans[x].length;
			for(int y=0;y<temp;y++)
			{
				System.out.print(trans[x][y]+"\t");
			}
			System.out.println();
		}
	}

	public static void calcnewbal()
	{
		for(int x=0;x<20;x++)
		{
			int temp=trans[x].length;
			for(int y=0;y<temp;y++)
			{
				ebalance[x]+=trans[x][y];
			}
			ebalance[x]+=sbalance[x];
			System.out.println();
		}
	}

	public static void report()
	{
		for(int x=0;x<20;x++)
		{
			System.out.println("Customer "+x);
			System.out.println("Starting Balance: $"+sbalance[x]);
			System.out.println("Transactions:");
			int temp=trans[x].length;
			for(int y=0;y<temp;y++)
			{
				System.out.println("$"+trans[x][y]);
			}
			System.out.println("Ending Balance: $"+ebalance[x]);
			System.out.println();
			System.out.println();
		}
	}
	
	public static void report1(int customer)
	{
		System.out.println("Customer number "+customer);
		System.out.println("Starting Balance: $"+sbalance[customer]);
		System.out.println("Transactions: ");
		int temp=trans[customer].length;
		for(int y=0;y<temp;y++)
		{
			System.out.println("$"+trans[customer][y]);
		}
		System.out.println("Ending Balance: $"+ebalance[customer]);
	}
	
	public static void help()
	{
		uni.notify("Help \n To select the report type enter the NUMBER for the type of report you would like");
	}
	
	public static void hub()
	{
		uni.notify("Welcome to the Bank.");
		String temp=uni.ask("Have you used the bank client v1.0 before?");
		if(temp.equalsIgnoreCase("no"))
			help();
		temp=uni.ask("What type of report would you like to generate? \n 1.All customers \n 2. Invidivual Customers");
		int temp1=Integer.parseInt(temp);
		if(temp1==1)
			report();
		else
			if(temp1==2)
			{
				temp=uni.ask("What customer number would you like to generate a report for?");
				temp1=Integer.parseInt(temp);
				temp1-=1;
				report1(temp1);
			}
			else
				uni.notify("Invalid entry");
	}
}
