package jw6jw6jw6.school.labs;
public class Test2
{
	
	public static void main (String args[])
	{
		helpers.setalpha();
		helpers.setcode();
		helpers.input();
		helpers.work();
		helpers.compare();
	}
	
}

class helpers
{
	public static String temp=" ";
	public static char temp1[]=new char[100];
	boolean toolong=false;
	private static char [] alpha = new char[26];
	private static String[] code = new String[26];

	public static void setalpha()
	{
		for (int x = 0; x <=25; x++)
			alpha[x] = (char) (x+97);

		//Take the comments off of the following to see what is in alpha
		/*for (int x = 0; x <=25; x++)
			uni.notify(alpha[x] + " ");*/

	}

	public static void setcode()
	{
		code [0] = "*";
		code [1] = "!";
		code [2] = "++";
		code [3] = "//";
		code [4] = "**";
		code [5] = "&^";
		code [6] = "@";
		code [7] = "@$";
		code [8] = "***";
		code [9] = ")";
		code [10] = "&&";
		code [11] = "#";
		code [12] = "^*";
		code [13] = "#%&";
		code [14] = "****";
		code [15] = "!$*";
		code [16] = "$";
		code [17] = "==";
		code [18] = "&";
		code [19] = "#!!";
		code [20] = "*****";
		code [21] = "^^#";
		code [22] = "%";
		code [23] = "^";
		code [24] = "(";
		code [25] = "*";
	}
	public static void input()
	{
		temp=uni.ask("Enter a String");
		System.out.println(temp.length() <= 100 ? " " :"TOO LONG!");
	}
	public static void work()
	{
		int length=temp.length();
		for(int x=0; x<length;x++)
		{
			temp1[x]=temp.charAt(x);
		}
	}
	public static void compare()
	{
		String temp3=" ";
		int length=temp.length();
		for(int x=0; x<length;x++)
		{
			for(int y=0;y<25;y++)
			{
				if(temp1[x]==alpha[y])
				{
					temp3+=String.valueOf(code[y]);
					break;
				}
				else
					continue;
			}
		}
		uni.notify(temp3);
	}
}

