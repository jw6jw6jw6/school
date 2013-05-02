package jw6jw6jw6.school.labs;
import java.applet.*;
import java.awt.*;
public class lab5graphics extends Applet
{
	public void paint(Graphics g)
	{
		g.setColor(Color.blue);
		box1(g);
		g.setColor(Color.green);
		box2(g);
		g.setColor(Color.red);
		grid(g);
		g.setColor(Color.magenta);
		circle1(g);
		g.setColor(Color.cyan);
		oval1(g);
		g.setColor(Color.pink);
		rectangle(g);
		g.setColor(Color.orange);
		globe(g);
	}
	public void grid(Graphics g)
	{
		g.drawLine(300,0,300,600);
		g.drawLine(600, 0, 600, 600);
		g.drawLine(0, 300, 900, 300);
	}
	public void box1(Graphics g)
	{
		for(int x=0;x<300;x+=5)
		{
			g.drawLine(0,x,300,x);
		}
	}
	
	public void box2(Graphics g)
	{
		for(int x=300;x<600;x+=10)
		{
			g.drawLine(x,0,x,300);
		}
	}
	public void circle1(Graphics g)
	{
		int size=10;
		int x=750, y=150;
		for(int r=1;r<14;r++)
		{
			g.drawOval(x,y,size,size);
			size+=15;
			x-=8;
			y-=8;
		}
	}
	public void oval1(Graphics g)
	{
		int size=10;
		int x=150, y=450;
		for(int r=1;r<7;r++)
		{
			g.drawOval(x,y,size,100);
			size+=50;
			x-=25;
		}
	}
	public void rectangle(Graphics g)
	{
		int size=10;
		int x=450, y=450;
		for(int r=1;r<20;r++)
		{
			g.drawRect(x,y,size,size);
			size+=15;
			x-=8;
			y-=8;
		}
	}
	public void globe(Graphics g)
	{
		int size=2;
		int x=750, y=400;
		for(int r=1;r<20;r++)
		{
			g.drawOval(x,y,size,100);
			size+=5;
			x-=2;
		}
		x=712;y=438;size=2;
		for(int r=1;r<20;r++)
		{
			g.drawOval(x,y,100,size);
			size+=5;
			y-=2;
		}
	}
}
