package jw6jw6jw6.school.labs;
import java.util.*;
import java.io.*;

public class Lab23 
{
	static ArrayList<String> lines = new ArrayList<String>();
	static Set<String> words = new TreeSet<String>();
	static String[] temp;
	static String input = "";
	public static void main(String args[])
	{
		input1();
		for(String le:lines)
		{
			le.toLowerCase();
			words.addAll(Arrays.asList(le.split("[\\W]+")));
		}
		System.out.println(words);
		System.out.println(words.size());
	}
	
	
	
	public static void input()
	{
		BufferedReader br = null;
		 
		try 
		{
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(new File("1342.txt")));
 
			while ((sCurrentLine = br.readLine()) != null)
			{
				input += sCurrentLine+" ";
			}
 
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void input1()
	{
		BufferedReader br = null;
		 
		try 
		{
 
			String sCurrentLine;
 
			br = new BufferedReader(new FileReader(new File("encyclopediabrit11th.txt")));
 
			while ((sCurrentLine = br.readLine()) != null)
			{
				lines.add(sCurrentLine);
			}
 
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
