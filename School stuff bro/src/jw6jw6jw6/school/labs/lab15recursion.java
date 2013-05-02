package jw6jw6jw6.school.labs;
import java.awt.*;
import java.applet.*;
import java.util.Random;
public class lab15recursion extends Applet
{
	public boolean flip;
	public void paint(Graphics g)
	{
		draw(g,0,0,200,15,0,flip,false);
	}

	
	public void draw(Graphics g,int tx,int ty,int size,int max,int count,boolean flip,boolean done)
	{
		if(count<9 && !done)
		{
			System.out.println("First method "+count);
		g.fillRect(tx, ty, size, size);
		tx+=size+5;
		ty+=size*.25;
		count++;
		size*=.75;
		draw(g,tx,ty,size,max,count,flip,false);
		}
		System.out.println(tx+" "+ty+" "+size+" "+max+" "+" "+count+" "+flip+" "+done);
		if(!flip && !done && count==9)
		{
			System.out.println("Flip");
			count+=7;
			tx=0;
			ty=400;
			size=1;
			flip=true;
		}
		
		if(count>15 && count<30)
		{
			System.out.println(count);
			g.fillRect(tx, ty, size, size);
			tx+=size+15;
			ty+=size;
			count++;
			size*=1.333334;
			draw(g,tx,ty,size,max,count,flip,false);
		}
		if(count>28)
			done=true;
	}
}
