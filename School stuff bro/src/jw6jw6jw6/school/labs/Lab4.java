package jw6jw6jw6.school.labs;
public class Lab4
{
	static String word="";
	static int length=0,count=0,incount=0;
	static boolean done=false,won=false;
	static String[] word1=new String [90];
	static String[] visual=new String[90];
	static boolean[] display=new boolean[5];
	static boolean[] guess=new boolean[90];
	public static void main(String[] args)
	{
		inputword();
		makefalse();
		prepword();
		prepboard();
		do
		{
		if(incount==5)
			break;
		print();
		Guess();
		check();
		}while(!done);
		if(won)
			uni.notify("YOU WON!!!");
		else
			uni.notify("HAHAHA! You lost!!!! LOSER!");
		
	}
	
	public static void makefalse()
	{
		for(int q=0;q>length;q++)
		{
			guess[q]=false;
		}
	}
	
	public static void inputword()
	{
		word=uni.ask("What would you like for the guess word to be?");
		uni.notify("Player two will have to guess the word "+word);
		word.toLowerCase();
	}
	
	public static void prepword()
	{
		length=word.length();
		for(int z=0;z<length;z++)
		{
			char temp2=word.charAt(z);
			word1[z]=Character.toString(temp2);
		}
	}
	
	public static void prepboard()
	{
		//uni.notify("Made it to prepboard");
		for(int z=0;z<length;z++)
		{
			visual[z]="_";
			if(word1[z].equals(" "))
			{
				visual[z]=" ";
			}
		}
	}
	
	public static void print()
	{
		System.out.println("||=============^");
		System.out.println("||             "+(display[0] ? "O" : " "));
		System.out.println("||           "+(display[1] ? "--+--" : " "));
		System.out.println("||             "+(display[2] ? "^" : " "));
		System.out.println("||            "+(display[3] ? "| |" : ""));
		System.out.println();
		for(int f=0;f<length;f++)
		{
			if(!guess[f])
			{
			System.out.print(visual[f]);
			}
			else
			{
			visual[f]=word1[f];
			System.out.print(visual[f]);
			
			}
		}
		//uni.notify("Made it to the end of print");
		System.out.println();
	}
	
	public static void Guess()
	{
		boolean change=false;
		String asdf="";
		asdf=uni.ask("Enter the letter you would like to guess.");
		for(int f=0;f<length;f++)
		{
			if(asdf.equals(word1[f]))
			{
				guess[f]=true;
				change=true;
			}
		}
		if(!change)
		{
			uni.notify("Incorect");
			incorrect();
		}
		for(int f=0;f<length;f++)
		{
			if(guess[f])
				visual[f]=word1[f];
		}
	}
	public static void incorrect()
	{
		
		display[incount]=true;
		incount++;
	}
	
	public static void check()
	{
		c:
		{
		uni.notify("Entered the chcek method.");
		boolean as=true;
		for(int f=0;f<length;f++)
		{
			if(visual[f].equals("_"))
			{
				as=false;
				continue;
			}
		}
		if(as)
		{
			done=true;
			won=true;
		}
		}
	}

	
}
