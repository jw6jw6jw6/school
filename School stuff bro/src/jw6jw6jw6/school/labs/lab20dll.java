package jw6jw6jw6.school.labs;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class lab20dll 
{
	public static DNode front = null;
	public static DNode f = null;
	public static DNode p = null;
	public static DNode temp = null;
	public static boolean quit = false;
	public static boolean first = false;
	public static int count =0;
	public static boolean added = false;
	public static boolean done = false;
	public static void main(String ifsomethingisinherejustignoreit[]) throws IOException
	{
//		String name="James";
//		int id = 159;
//		int age = 17;
//		double gpa = 3.3;
//		/*int id = Integer.parseInt(uni.ask("ID:"));
//		int age = uni.parse(uni.ask("age:"));
//		double gpa = uni.parseo(uni.ask("gpa:"));**/
//		first(gpa,name,age,id);
//		
//		name=uni.ask("2 Name:");
//		id = 159;
//		age = 17;
//		gpa = uni.parseo(uni.ask("gpa:"));
//		add(gpa,name,age,id);
//		
//		name=uni.ask("3 Name:");
//		id = 159;
//		age = 17;
//		gpa = uni.parseo(uni.ask("gpa:"));
//		add(gpa,name,age,id);
//		
//		name=uni.ask("4 Name:");
//		id = 159;
//		age = 17;
//		gpa = uni.parseo(uni.ask("gpa:"));
//		add(gpa,name,age,id);
//		
//		name=uni.ask("5 Name:");
//		id = 159;
//		age = 17;
//		gpa = uni.parseo(uni.ask("gpa:"));
//		add(gpa,name,age,id);
//		
//		name=uni.ask("6 Name:");
//		id = 159;
//		age = 17;
//		gpa = uni.parseo(uni.ask("gpa:"));
//		add(gpa,name,age,id);
		
		
		
		
		load();
//		first(0.2,"Jr2",43,186512);
//		add(0.3,"Jr3",43,186512);
//		add(0.5,"Jr4",43,186512);
//		add(0.1,"Jr1",43,186512);
//		add(0.9,"Jr5",43,186512);
//		add(3.2,"Jr8",43,186512);
//		add(2.3,"Jr7",43,186512);
//		add(1.2,"Jr6",43,186512);
//		add(4.0,"Jr9",43,186512);
//		uni.notify(findplace(4.0,"Jr9",43,186512)+" Should be 9");
//		add(5.2,"Jr10",43,186512);
//		add(6.2,"Jr11",43,186512);
//		add(7.2,"Jr12",43,186512);
//		add(5.3,"Jr13",43,186512);
//		add1(3.7,"Jr14",43,186512);
		
		count();
		print();
	}
	
	public static void error()
	{
		try{
			throw new Exception();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void load() throws IOException
	{
		File file = new File("students2.txt");
		System.out.println(file.canRead());
		BufferedReader inStream = new BufferedReader(new FileReader(file));
		//boolean done=false;
		String line;
		String name=inStream.readLine();
		int id = Integer.parseInt(inStream.readLine());
		int age = uni.parse(inStream.readLine());
		double gpa = uni.parseo(inStream.readLine());
		temp = new DNode(id,age,name,gpa,null,null);
		first(gpa,name,age,id);
		while((line=inStream.readLine())!=null)
		{
			name=line;
			id = Integer.parseInt(inStream.readLine());
			age = uni.parse(inStream.readLine());
			gpa = uni.parseo(inStream.readLine());
			add1(gpa,name,age,id);
		}
		inStream.close();
	}
	
	public static void add1(double gpa, String name, int age, int id)
	{
		p = front;
		int place = findplace(gpa,name,age,id);
		temp = new DNode(id,age,name,gpa,null,null);
		System.out.println(place);
		for(int x = 1; x<=place; x++)
		{
//			System.out.println(x);
			if(x == place)
			{
				System.out.println(temp.getname());
				if(p == front)
				{
					temp.setnext(p);
					front = temp;
					return;
				}
				if(p.getnext() == null)
				{
//					p.setnext(temp);
//					temp.setback(p);
//					return;
					p=front;
					while(p.getnext()!=null)
					{
						p=p.getnext();
					}
					f=p;
					f.setnext(temp);
					temp.setback(f);
					System.out.println("Added "+temp.getname()+" after "+f.getname());
				}
				f = p.getback();
				p = p.getnext();
				temp.setnext(p);
				temp.setback(f);
			}
			p = p.getnext();
		}
	}
	
	public static int findplace(double gpa, String name, int age, int id)
	{
		p = front;
		int count1=0;
		while(p != null && count1 < 35)
		{
			count1++;
			System.out.println(p.getgpa()+" vs "+gpa);
			if(uni.parseo(p.getgpa()) <= gpa)
			{
				return count1;
			}
			p = p.getnext();
		}
		return 0;
	}
	
	public static void add(double gpa, String name, int age, int id)
	{
		p = front;
		f=p;
		added = false;
		done = false;
		System.out.println("Method call 'add' with: "+gpa+" "+" "+name+" "+age+" "+id);
		temp = new DNode(id,age,name,gpa,null,null);
		if(front == null)
		{
			front = temp;
			return;
		}
		int count1 = 0;
		while(p != null && !done)
		{
			count1++;
			if(uni.parseo(p.getgpa()) >= gpa)
			{
				System.out.println(count1);
				System.out.println(temp.getname());
				if(p == front)
				{
					front();
				}
				else
				{
					l2();
				}
			}
			p = p.getnext();
		}
			if(!added)
			{
				notadded();
			}
	}
	
	public static void front()
	{
		System.out.println("added front");
		temp.setnext(p);
		p.setback(temp);
		front = temp;
		added = true;
		done = true;
	}
	public static void l2()
	{
		System.out.println("if 2");
		f=front;
		while(f.getnext() != p && f.getnext() != null)
		 {
//			 System.out.println("l2");
			 f = f.getnext();
		 }
//		f = p.getback();
		f.setnext(temp);
		temp.setnext(p);
		System.out.println("Set "+f.getname()+" before "+temp.getname());
		p.setback(temp);
		temp.setback(f);
		System.out.println(f.getname()+" goes to "+temp.getname());
		System.out.println(temp.getname()+" goes to "+p.getname());
		
		
		added=true;
	}
	
	public static void notadded()
	{
		System.out.println("!added yet");
		p=front;
		while(p.getnext()!=null)
		{
			p=p.getnext();
		}
		f=p;
		f.setnext(temp);
		temp.setback(f);
		System.out.println("Added "+temp.getname()+" after "+f.getname());
	}
	
	public static void first(double gpa, String name, int age, int id)
	{
		System.out.println("Method call 'first' with: "+gpa+" "+" "+name+" "+age+" "+id);
		temp = new DNode(id,age,name,gpa,null,null);
		front = temp;
	}
	
	public static void count()
	{
		int count1 = 0;
		p=front;
		while(p!= null)
		{
			p = p.getnext();
			count1++;
		}
		uni.notify(count1+"elements in the LL");
	}
	
	public static void print()
	{
		p=front;
		String add=" ";
		int count1=0;
		while(p != null)
		{
			add+=p.getname()+" "+p.getgpa()+" || ";
			p=p.getnext();
			count1++;
		}
		uni.notify(add);
		uni.notify(count1+"/"+count);
	}
}
