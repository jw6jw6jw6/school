package jw6jw6jw6.school.labs;
import java.io.*;

import javax.swing.JOptionPane;
public class uni
{

	public static String ask(String string)
	{
		String temp=JOptionPane.showInputDialog(string);
		return temp;
	}
	
	public static void notify(String string)
	{
		JOptionPane.showMessageDialog(null,string);
	}
	
	public static int parse(String string)
	{
		return Integer.parseInt(string);
	}

	public static double parseo(Object getgpa1) 
	{
		return Double.parseDouble(getgpa1.toString());
	}
}
