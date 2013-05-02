package jw6jw6jw6.school.labs;
import java.awt.*;
import java.applet.*;
import java.util.Random;
import java.util.UUID;
public class test2extended extends Applet
{
	public void paint(Graphics g)
	{
		grid(g);
		int x=0;
		while(x<1000)
		{
		draw1.dots(g);
		draw1.lines(g);
		draw1.rectangles(g);
		draw1.square(g);
		draw1.roundrect(g);
		draw1.perfectcircle(g);
		draw1.words(g);
		draw1.circles(g);
		}
	}	
	
	public void grid(Graphics g)
	{
		g.drawLine(250,0,250,650);
		g.drawLine(500,0,500,650);
		g.drawLine(750,0,750,650);
		g.drawLine(0,325,1000,325);
	}
}

class draw1
{
	static Random rand=new Random();
	public static void dots(Graphics g)
	{
		for(int x=0;x<=10000;x++)
		{
			setcolor(g);
			int x1=rand.nextInt(248);
			int y1=rand.nextInt(323);
			int diameter=rand.nextInt(5);
			g.fillOval(x1, y1, diameter, diameter);
		}
	}
	
	public static void lines(Graphics g)
	{
		for(int x=0;x<=1000;x++)
		{
			setcolor(g);
			int x1=rand.nextInt(248);
			x1+=250;
			int y1=rand.nextInt(323);
			int x2=rand.nextInt(248);
			x2+=250;
			int y2=rand.nextInt(248);
			g.drawLine(x1, y1, x2, y2);
		}
	}
	
	public static void rectangles(Graphics g)
	{
		for(int x=0;x<=1000;x++)
		{
			setcolor(g);
			int x1=rand.nextInt(248);
			x1+=500;
			int y1=rand.nextInt(323);
			int width=rand.nextInt(100);
			int height=rand.nextInt(50);
			while(x1+width>=750)
				width--;
			while(y1+height>=320)
				height--;
			g.fillRect(x1, y1, width, height);
			
		}
	}
	
	public static void square(Graphics g)
	{
		for(int x=0;x<=500;x++)
		{
			setcolor(g);
			int x1=rand.nextInt(248);
			x1+=0;
			int y1=rand.nextInt(323);
			y1+=325;
			int width=rand.nextInt(100);
			while(x1+width>=250)
				width--;
			g.fillRect(x1, y1, width, width);
			
		}
	}
	
	public static void roundrect(Graphics g)
	{
		for(int x=0;x<=500;x++)
		{
			setcolor(g);
			int x1=rand.nextInt(248);
			x1+=250;
			int y1=rand.nextInt(323);
			y1+=325;
			int width=rand.nextInt(100);
			int arcWidth=rand.nextInt(300);
			int arcHeight=rand.nextInt(300);
			while(x1+width>=500)
				width--;
			g.fillRoundRect(x1, y1, width, width, arcWidth, arcHeight);
			
		}
	}
	
	public static void perfectcircle(Graphics g)
	{
		for(int x=0;x<=500;x++)
		{
			setcolor(g);
			int x1=rand.nextInt(248);
			x1+=500;
			int y1=rand.nextInt(323);
			y1+=325;
			int arcWidth=rand.nextInt(300);
			int height=rand.nextInt(100);
			while(x1+arcWidth>=750)
				arcWidth--;
			g.fillOval(x1, y1, arcWidth, height);
		}
	}
	
	public static void words(Graphics g)
	{
		
		for(int x=0;x<=500;x++)
		{
			setcolor(g);
			String uuid = UUID.randomUUID().toString();
			int x1=rand.nextInt(248);
			x1+=750;
			int y1=rand.nextInt(323);
			y1+=335;
			g.drawString(uuid, x1, y1);
		}
	}
	
	public static void circles(Graphics g)
	{
		for(int x=0;x<=500;x++)
		{
			setcolor(g);
			int x1=rand.nextInt(248);
			x1+=750;
			int y1=rand.nextInt(323);
			y1+=0;
			int width=rand.nextInt(200);
			while(y1+width>=328)
				width--;
			while(x1+width>=1000)
				width--;
			g.fillOval(x1, y1, width, width);
		}
	}
	public static void setcolor(Graphics g)
	{
		int color=rand.nextInt(11);
		switch(color)
		{
		case 0:g.setColor(Color.red);break;
		case 1:g.setColor(Color.magenta);break;
		case 2:g.setColor(Color.darkGray) ;break;
		case 3:g.setColor(Color.green) ;break;
		case 4:g.setColor(Color.yellow) ;break;
		case 5:g.setColor(Color.pink) ;break;
		case 6:g.setColor(Color.blue) ;break;
		case 7:g.setColor(Color.gray) ;break;
		case 8:g.setColor(Color.black) ;break;
		case 9:g.setColor(Color.orange) ;break;
		case 10:g.setColor(Color.lightGray) ;break;
		case 11:g.setColor(Color.cyan) ;break;
		default: System.out.println("?");
		}
	}
}
