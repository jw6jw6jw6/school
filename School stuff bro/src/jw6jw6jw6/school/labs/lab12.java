package jw6jw6jw6.school.labs;
import java.util.*;
public class lab12
{
	static Stack<Character> stack=new Stack<Character>();
	static String input="";
	static String fin="";
	static int size;
	static int count=0;
	public static void main(String args[])
	{
		input();
		hub();
		uni.notify("You input the equation "+input+"\nIn polish notation it would be seen as "+fin);
	}
	
	public static void input()
	{
		input=uni.ask("Enter a mathmatical expression");
		//uni.notify("Input was: \n"+input);
	}
	
	public static void hub()
	{
		size=input.length();
		while(count<size)
		{
			s1();
			s2();
			s3();
			s4();
		}
		while(!stack.isEmpty())
		{
			s5();
		}
	}
	
	public static void s1()
	{
		char temp=input.charAt(count);
		if(temp=='(')
		{
			while(!stack.isEmpty() && stack.peek()!='(')
			{
			stack.push(temp);
			count++;
			}
		}
	}
	
	public static void s2()
	{
		char temp=input.charAt(count);
		if(temp !='(' && temp !='+' && temp !='-' && temp !='*' && temp !='/' && temp !=')')
		{
			
			System.out.println();
			fin+=temp;
			count++;
			uni.notify("Using method 2. adding "+temp+" to "+fin+". Count="+count);
		}
	}
	
	public static void s3()
	{
		char temp=' ';
		if(count<size)
			temp=input.charAt(count);
		if(temp =='+' || temp =='-' || temp =='*' || temp =='/')
		{
			if(temp =='+' || temp =='-')
			{
				if(!stack.isEmpty() && (stack.peek()=='/' || stack.peek()=='*'))
				{
					stack.push(temp);
					count++;
					uni.notify("I added one to count because i added "+temp+" to the stack. count="+count);
				}
				else
				{
					stack.push(temp);
					count++;
					uni.notify("I added one to count because i added "+temp+" to the stack. count="+count);
				}
			}
			else
			{
				stack.push(temp);
				count++;
				uni.notify("I added one to count because i added "+temp+" to the stack. count="+count);
			}
		}
	}
	
	public static void s4()
	{
		char temp=' ';
		if(count<size)
			temp=input.charAt(count);
		if(temp=='(')
		{
			count++;
		}
		if(temp==')')
		{
			System.out.println("s4");
			boolean done=false;
			while(!done)
			{
				if(!stack.isEmpty() && stack.peek()=='(')
				{
					stack.pop();
					done=true;
					
				}
				else
				{
					if(!stack.isEmpty())
					{
					fin+=stack.pop();
					}
					else
						done=true;
				}
			}
			count++;
		}
	}
	
	public static void s5()
	{
		if(count>=size)
		{
			System.out.println("s5");
			while(!stack.isEmpty())
			{
				if(stack.peek()=='(' || stack.peek()==')')
				{
					stack.pop();
				}
				else
				{
					fin+=stack.pop();
				}
			}
		}
	}
}
