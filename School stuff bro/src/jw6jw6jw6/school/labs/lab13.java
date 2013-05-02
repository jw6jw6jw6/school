package jw6jw6jw6.school.labs;
import java.util.*;
public class lab13
{
	static Stack<String> pez = new Stack<String>();
	static Stack<String> tpaz =new Stack<String>();
	static int ycount=0;
	static int pezcount=0;
	static int tcount=0;
	static int tpezcount=0;
	public static void main(String args[])
	{
		uni.notify("WELCOME TO YOUR PEZ DESPENSER");
		pest();
		fill();
		uni.notify("Your pez dispenser\n"+pez+"");
		ryellow();
		refill();
		uni.notify("Your pez after your pesky yonger brother ate all "+ycount+" of the yellow pez\n"+pez);
	}
	
	public static void refill()
	{
		while(!tpaz.isEmpty())
		{
			pez.push(tpaz.pop());
		}
	}
	
	public static void ryellow()
	{
		while(tcount<12&pezcount>0)
		{
			String temp=pez.pop();
			pezcount--;
			if(temp.equalsIgnoreCase("Yellow"))
			{
				uni.notify("Your little brother ate a yellow pez! D:");
				ycount++;
			}
			else
			{
				tpaz.push(temp);
				tpezcount++;
			}
		}
	}
	
	public static void fill()
	{
		String print="";
		while(pezcount<12)
		{
			String temp=color();
			pez.push(temp);
			print+="Pushing "+temp+"\n";
			pezcount++;
		}
		uni.notify(print);
	}
	
	public static String pest()
	{
		Random rand=new Random();
		int temp=rand.nextInt(6);
		switch(temp)
		{
		case 0: return "little brother";
		case 1: return "sister";
		case 2:	return "dog";
		case 3:	return "cat";
		case 4: return "fish";
		case 5: return "Turtle";
		}
		return "Failure";
	}
	
	public static String color()
	{
		Random rand=new Random();
		int temp=rand.nextInt(4);
		switch(temp)
		{
		case 0: return "Yellow";
		case 1: return "Pink";
		case 2:	return "Green";
		case 3:	return "Orange";
		}
		return "Failure";
	}
}
