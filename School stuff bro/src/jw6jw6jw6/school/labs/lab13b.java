package jw6jw6jw6.school.labs;
import java.util.*;
public class lab13b
{
	static Stack<Character> b = new Stack<Character>();
	static String a="";
	static int size;
	static boolean ERROR=false;
	public static void main(String args[])
	{
		input();
		breakapart();
		compare();
		if(ERROR)
		{
			uni.notify("After hours of exhausting work we determined your word is not a palendrome");
		}
		else
		{
			uni.notify("After hours of nerveracking work we are proud to crown your word as a palendrome");
		}
	}
	
	public static void input()
	{
		a=uni.ask("Enter a word that you beleive to be a palendrome, without caps!!!! Our hard working team will do our best to determine\nif you have infact found a palindrome. We use intricate work that would drive any sane person crazy.");
	}
	
	public static void breakapart()
	{
		size = a.length();
		for(int x=0; x < size; x++)
		{
			char temp=a.charAt(x);
			b.push(temp);
		}
	}
	
	public static void compare()
	{
		for(int x=0; x<size; x++)
		{
			char temp = b.pop();
			if(a.charAt(x) != temp)
			{
				ERROR=true;
				break;
			}
		}
	}
}
