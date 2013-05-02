package jw6jw6jw6.school.labs;
import java.awt.*;
import java.applet.*;
import java.util.Random;
import java.lang.*;
public class Lab6onedot extends Applet
{
	public void paint(Graphics g)
	{
		//g.drawOval(380, 280, 20, 20);
		magic test=new magic(30, 2000.0);
		int x=0;
		while(x<=1000000000)
		{
		test.drawCircle(g);
		test.delay();
		test.hitEdge();
		test.remove(g);
		test.setTLX();
		test.setTLY();
		test.setcolor(g);
		x++;
		}
	}
}
class  magic
{
	int topleftX=380, topleftY=280, diameter,incX,incY,delay=500,count=0;
	double TimeDelay;
	boolean addX=true, addY=false;
	public magic(int size,double timeDelay)
	{
		diameter=size;
		TimeDelay=timeDelay;
		incX=10;
		incY=10;
	}
	
	public void delay()
	{
		/*
		for(double k=1.0;k<TimeDelay;k+=.00009)
		{
			
		}
		*/
		if(count>200)
			delay+=3;
		else
			if(delay-10>=20)
				delay-=10;
		try{
			 //do what you want to do before sleeping
			 Thread.currentThread().sleep(delay);//sleep for 1000 ms
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
		incX+=5;
//		incY=rand.nextInt(7);
		incY+=5;
	}
	
	public void drawCircle(Graphics g)
	{
		g.fillOval(topleftX,topleftY,diameter,diameter);
	}
	public void remove(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval(topleftX,topleftY,diameter,diameter);
	}
	
	public void hitEdge()
	{
			//uni.notify("Checking");
			if(topleftX<=0)
			{
				addX=true;
			}
			if(topleftX>=750)
			{
				addX=false;
			}
			if(topleftY<=0)
				addY=true;
			if(topleftY>=550)
				addY=false;
	}
}
