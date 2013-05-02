package jw6jw6jw6.school.labs;
import java.awt.*;
import java.applet.*;
public class Test extends Applet
{
	public void paint(Graphics g)
	{
		//g.drawline(int X, int Y, int X2, int, Y2);
		int f=63;
		do{
		line1(g,f);
		line2(g,f);
		line3(g,f);
		line4(g,f);
		}while(f==100);
	}
	
	public void line1(Graphics g,int f)
	{
		int y2=0;
		for(int x=0;x<66;x++)
		{
			g.drawLine(0,0,875,y2);
			y2+=10;
		}
	}
	
	public void line2(Graphics g,int f)
	{
		int y2=0;
		for(int x=0;x<f;x++)
		{
			g.drawLine(800,0,0,y2);
			y2+=10;
		}
	}
	
	public void line3(Graphics g,int f)
	{
		int y2=600;
		for(int x=0;x<f;x++)
		{
			g.drawLine(0,600,800,y2);
			y2-=10;
		}
	}
	
	public void line4(Graphics g,int f)
	{
		int y2=600;
		for(int x=0;x<f;x++)
		{
			g.drawLine(800,600,0,y2);
			y2-=10;
		}
	}
}
