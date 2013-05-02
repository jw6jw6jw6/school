package jw6jw6jw6.school.labs;

public class Lab19LL 
{
	public static Node front = null;
	public static Node f = null;
	public static Node p = null;
	public static Node temp = null;
	public static boolean quit = false;
	
	public static void main(String args[])
	{
		initialinput();
		while(!quit)
		{
			command();
		}
	}
	
	public static void delete()
	{
		int del = uni.parse(uni.ask("What number would you like to delete?"));
		System.err.println("l1");
		p = front;
		boolean done = false;
		while(p!= null && !done)
		{
			System.err.println("l1");
			if(p.getnum()==del)
			{
				if(p == front)
				 {
					temp = p;
					 temp = temp.getNext();
					 front = temp;
					 done = true;
				 }
				else
				{
				 f=front;
				 while(f.getNext().getnum() != p.getnum())
				 {
					 System.err.println("l2");
					 f = f.getNext();
				 }
				 if(p.getNext() != null)
				 {
					 if(p == front)
					 {
						 front = temp;
					 }
					 temp = p;
					 temp = temp.getNext();
				 f.setNext(temp);
				 }
				 else
				 {
					 f.setNext(null);
				 }
				}
				done = true;
				print();
			}
			if(!done)
				p = p.getNext();
		}
	}
	
	public static void add()
	{
		p = front;
		f=p;
		int count=0;
		int temp1 = uni.parse(uni.ask("What number would you like to add?"));
		temp = new Node(temp1,null);
		boolean done = false;
		boolean added = false;
		while(p != null && !done)
		{
			if(p.getnum() > temp1)
			{
				if(p == front)
				{
					System.err.println("if 1");
					temp.setNext(p);
					front = temp;
					added = true;
					done = true;
				}
				else
				{
					System.err.println("if 2");
					f=front;
					while(f.getNext().getnum() != p.getnum() && f.getNext() != null)
//					for(int z=0;z!=count;z++)
					 {
						 System.out.println("l2");
						 f = f.getNext();
					 }
					f.setNext(temp);
					temp.setNext(p);
					added=true;
				}
			}
			count++;
			p = p.getNext();
		}
		if(!added)
		{
			System.err.println("No add yet");
			p=front;
			while(p!=null)
			{
				p=p.getNext();
			}
			boolean found = false;
			f = front;
			while(!found)
			{
				
				if(f.getNext() == p)
				{
					found = true;
				}
				else
				{
					f = f.getNext();
				}
			}
//			f=p;
			f.setNext(temp);
		}
		print();
	}
	
	public static void print()
	{
		p=front;
		String add="";
		while(p != null)
		{
			add+=p.getnum()+" ";
			p=p.getNext();
		}
		uni.notify("Your list is "+add);
	}
	
	public static void command()
	{
		int temp1 = uni.parse(uni.ask("What would you like to do?\n1.add\n2.Delete\n3.Print\n4.Quit\n5.Funny"));
		switch(temp1)
		{
		case 1: add(); break;
		case 2: delete(); break;
		case 3: print(); break;
		case 4: quit=true; break;
		case 5: uni.notify("404 Error:\nI am sorry the method you are looking for cannot be found"); break;
		default: uni.notify("404 Error:\nI am sorry the method you are looking for cannot be found"); break;
		}
	}
	
	public static void initialinput()
	{
		int fg = uni.parse(uni.ask("Input your first number."));
		int gf = uni.parse(uni.ask("Input your second number."));
		int temp1 = 0;
		
		if(fg>gf)
		{
			temp1=gf;
			gf=fg;
			fg=temp1;
		}
		p= new Node(fg, null);
		front = p;
		temp = p;
		
		
		p = new Node(gf, null);
		temp.setNext(p);
		temp = p;
		
	}
}
