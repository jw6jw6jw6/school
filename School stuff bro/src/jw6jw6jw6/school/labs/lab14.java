package jw6jw6jw6.school.labs;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
public class lab14 extends Applet
{
	int x=0;
	Circle345 test=new Circle345(30);
	
	public void paint(Graphics g)
	{
		
//		if(x++ == 0)
//			test.input();
		while(x<=100000000)
		{
		test.drawCircle(g);
		test.queue();
		test.delete(g);
		test.hitEdge(this);
		test.setTLX();
		test.setTLY();
//		test.newData();
		test.delay();
		test.setcolor(g);
		x++;
//		repaint();
		}
	}
}
class  Circle345
{
	int topleftX=380, topleftY=280, diameter,incX,incY,maxcirc=10,countcirc;
	double TimeDelay;
	boolean addX=true, addY=false, first=false;
	Queue x = new LinkedList();
	Queue y = new LinkedList();
	public Circle345(int size)
	{
		diameter=size;
		incX=20;
		incY=20;
		input();
	}
	
	public void input()
	{
		maxcirc=Integer.parseInt(uni.ask("How many circles would you like to see at a time?"));
		maxcirc++;
		diameter=Integer.parseInt(uni.ask("What diameter would you like for the circles? (Recomended is 30)"));
		diameter++;
	}
	
	public void queue()
	{
		x.add(topleftX);
		y.add(topleftY);
	}
	
	public void delete(Graphics g)
	{
		countcirc++;
		if(countcirc >= maxcirc)
		{
			Object o= x.poll();
			String x1= o+"";
			Object o1= y.poll();
			String y1= o1+"";
//					number.intValue
		int tempx=Integer.parseInt(x1);
		int tempy=Integer.parseInt(y1);
		g.setColor(Color.white);
		g.fillOval(tempx,tempy,diameter,diameter);
		}
	}
	
	public void delay()
	{
		try{
			 Thread.currentThread();
			//do what you want to do before sleeping
			 Thread.sleep(25);//sleep for 1000 ms
			 //do what you want to do after sleeptig
			}
			catch(InterruptedException ie){
			//If this thread was intrrupted by nother thread 
			}
	}
	
	public void setcolor(Graphics g)
	{
		Random rand=new Random();
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
	
	public void setTLX()
	{
		if(addX)
		{
			//uni.notify("Add: "+incX+" To "+topleftX);
			topleftX+=incX;
		}
		else
		{
			topleftX-=incX;
		}
	}
	
	public void setTLY()
	{
		if(addY)
		{
			topleftY+=incY;
		}
		else
		{
			topleftY-=incY;
		}
	}
	
	public void newData()
	{
		Random rand=new Random();
//		incX=rand.nextInt(7);
		incX=10;
//		incY=rand.nextInt(7);
		incY=10;
	}
	
	public void drawCircle(Graphics g)
	{
		g.fillOval(topleftX,topleftY,diameter,diameter);
	}
	
	public void hitEdge(Applet app)
	{
			//uni.notify("Checking");
			if(topleftX<=0)
			{
				addX=true;
			}
			if(topleftX>=app.getWidth()-20)
			{
				addX=false;
			}
			if(topleftY<=0)
				addY=true;
			if(topleftY>=app.getHeight()-20)
				addY=false;
	}
}
