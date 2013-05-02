package jw6jw6jw6.school.labs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lab20ATTEMPT2 
{
	public static DNode front = null;
	public static DNode temp = null;
	public static DNode temp2 = null;
	public static DNode moving = null;
	public static DNode newnode = null;
	
	public static void main(String ifsomethingisinherejustignoreit[]) throws IOException
	{
		load();
		print();
		System.out.println();
		System.out.println();
		honor();
		System.out.println();
		System.out.println();
		probation();
//		record();
//		delete();
		command();
	}
	
	public static void command()
	{
	boolean done = false;
	while(!done)
	{
		int num = uni.parse(uni.ask("Welcome to the RRHS Student Database, What would you like to do? \n1. Print \n2.Search\n3.Delete\n4.Competitors\n5.Add\n6.Exit"));
		switch(num)
		{
		case 1: print();System.out.println();System.out.println();honor();System.out.println();System.out.println();probation();break;
		case 2:record();break;
		case 3:delete();break;
		case 4:competitors();break;
		case 5: add(uni.parseo(uni.ask("Enter GPA")),uni.ask("Enter name"),uni.parse(uni.ask("Enter age")),uni.parse(uni.ask("Enter ID")));break;
		case 6:return;
		}
	}
	}
	
	public static void load() throws IOException
	{
		File file = new File("students2.txt");
//		System.out.println(file.canRead());
		BufferedReader inStream = new BufferedReader(new FileReader(file));
		String line;
		String name=inStream.readLine();
		int id = Integer.parseInt(inStream.readLine());
		int age = uni.parse(inStream.readLine());
		double gpa = uni.parseo(inStream.readLine());
		temp = new DNode(id,age,name,gpa,null,null);
		front = temp;
		while((line=inStream.readLine())!=null)
		{
			name=line;
			id = Integer.parseInt(inStream.readLine());
			age = uni.parse(inStream.readLine());
			gpa = uni.parseo(inStream.readLine());
			add(gpa,name,age,id);
		}
		inStream.close();
	}
	
	public static void add(double gpa, String name, int age, int id)
	{
		moving = front;
		newnode = new DNode(id,age,name,gpa,null,null);
//		System.out.println("Method call "+gpa+" "+name);
		
		while(moving != null)
		{
			if(uni.parseo(moving.getgpa())>gpa)
			{
//				System.out.println(name);
				if(moving == front)
				{
//					System.out.println("front");
					newnode.setnext(front);
					front.setback(newnode);
					front = newnode;
					return;
				}
				else
				{
//					System.out.println("else");
					temp = moving.getback();
					
					temp.setnext(newnode);
					newnode.setback(temp);
					
					moving.setback(newnode);
					newnode.setnext(moving);
					
					return;
				}
			}
			moving = moving.getnext();
		}
//		System.out.println("End");
		moving = front;
		while(moving.getnext()!=null)
		{
			moving = moving.getnext();
		}
		moving.setnext(newnode);
		newnode.setback(moving);
	}
	
	public static void print()
	{
//		System.out.println("Students");
		moving = front;
		while(moving.getnext() != null)
		{
			moving = moving.getnext();
		}
		System.out.println("Name      GPA    ID    Age");
		while(moving != null)
		{
			System.out.println(moving.getname()+" "+moving.getgpa()+" "+moving.getid());
			moving = moving.getback();
		}
	}
	
	public static void honor()
	{
		moving = front;
		while(moving.getnext() != null)
		{
			moving = moving.getnext();
		}
//		System.err.println("Name      GPA    ID    Age");
		while(moving != null)
		{
			if(uni.parseo(moving.getgpa()) >= 3.5)
				System.out.println(moving.getname()+" "+moving.getgpa()+" "+moving.getid());
			moving = moving.getback();
		}
	}
	
	public static void probation()
	{
		moving = front;
		while(moving != null)
		{
			if(uni.parseo(moving.getgpa()) < 2.0)
				System.out.println(moving.getname()+" "+moving.getgpa()+" "+moving.getid());
			moving = moving.getnext();
		}
	}
	
	public static void record()
	{
		boolean found = false;
		Double look = uni.parseo(uni.ask("Enter ID"));
		moving = front;
		while(moving != null)
		{
			if(uni.parseo(moving.getid()) == look)
			{
				found = true;
				break;
			}
			moving = moving.getnext();
		}
		if(found)
		{
		System.out.println("Student Recod for ID# "+moving.getid());
		System.out.println();
		System.out.println("Name: "+moving.getname());
		System.out.println("Age: "+moving.getage());
		System.out.println("GPA: "+moving.getgpa());
		}
		else
			System.out.println("Record not found.");
	}
	public static void competitors()
	{
			System.out.println();
			System.out.println();
			boolean found = false;
			Double look = uni.parseo(uni.ask("Enter ID"));
			int num = uni.parse(uni.ask("Enter # of competitors to view"));
			moving = front;
			while(moving != null)
			{
				if(uni.parseo(moving.getid()) == look)
				{
					found = true;
					break;
				}
				moving = moving.getnext();
			}
			moving = moving.getnext();
			num--;
			while(moving !=null && num >=0)
			{
				System.out.println();
				System.out.println();
				System.out.println("Student Recod for ID# "+moving.getid());
				System.out.println();
				System.out.println("Name: "+moving.getname());
				System.out.println("Age: "+moving.getage());
				System.out.println("GPA: "+moving.getgpa());
				moving = moving.getnext();
				num--;
			}
	}
	
	public static void delete()
	{
		boolean found = false;
		Double look = uni.parseo(uni.ask("Enter ID of student to DELETE. to cancle type '-1'"));
		moving = front;
		if(look == -1)
			return;
		while(moving.getnext() != null)
		{
			if(uni.parseo(moving.getid()) == look)
			{
				found = true;
				break;
			}
			moving = moving.getnext();
		}
		if(found)
		{
			if(moving == front)
			{
				temp2 = moving.getnext();
				front = temp2;
				temp2.setback(null);
				uni.notify(moving.getname()+" deleted");
				return;
			}
//			if(moving.getnext() != null)
//			{
//				temp = moving.getback();
//				temp.setnext(null);
//				uni.notify(moving.getname()+" deleted");
//				return;
//			}
			else
			{
			temp = moving.getback();
			temp2 = moving.getnext();
			temp.setnext(temp2);
			temp2.setback(temp);
			uni.notify(moving.getname()+" deleted");
			return;
			}
		}
			System.out.println("Student not found");
	}
}
