package jw6jw6jw6.school.labs;
import java.applet.Applet;
import java.awt.Graphics;

public class lab15try2 extends Applet
{
	public boolean flip;
	public void paint(Graphics g)
	{
		draw(g,0,0,100,false,0);
	}
	
	public void draw(Graphics g, int x, int y, int size, boolean flip, int count)
	{
		if(count<9)
		{
			g.fillRect(x, y, size, size);
			count++;
			size/=2;
			x+=size*2+10;
			y+=size;
			draw(g,x,y,size,flip,count);
		}
		if(count==9)
		{
			System.out.println("Flip");
			x=0;
			y=120;
			size=1;
			count++;
			count++;
			flip=true;
			draw(g,x,y,size,flip,count);
		}
		if(flip && count < 19)
		{
			System.out.println(x+" "+y+" "+size);
			g.fillRect(x, y, size, size);
			x+=size+10;
			size*=2;
			count++;
			draw(g,x,y,size,flip,count);
		}
	}

}
