package jw6jw6jw6.school.labs;
public class Quest
{
	public static DNode2 front = null;
	public static DNode2 moving = null;
	public static DNode2 temp = null;
public static void main(String args[])
{
	add();
	print();
}

public static void add()
{
	String temp1 = uni.ask("Input string");
	int length = temp1.length();
	System.out.println(length);
	front = new DNode2(temp1.substring(0, 1),null,null);
	temp = front;
	
	for(int x = 1; x<length; x++)
	{
	moving = new DNode2(temp1.substring(x,x+1), null,null);
	temp.setnext(moving);
	moving.setback(temp);
	temp = moving;
	}
}

public static void print()
{
	moving = front;
	String text = "";
	while(moving != null)
	{
		text+=moving.getvalue()+" | ";
		moving = moving.getnext();
	}
	uni.notify("Your String is "+text);
	moving = front;
	while(moving.getnext() != null)
	{
		moving = moving.getnext();
	}
	text = "";
	while(moving != null)
	{
		text+=moving.getvalue()+" | ";
		moving = moving.getback();
	}
	uni.notify("Your String is "+text);
}
}
