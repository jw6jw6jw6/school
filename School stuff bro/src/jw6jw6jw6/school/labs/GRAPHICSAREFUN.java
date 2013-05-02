package jw6jw6jw6.school.labs;
import java.awt.*;
import java.applet.*;
import java.util.Random;
public class GRAPHICSAREFUN extends Applet
{
	static int fill[]=new int[100000];
	Random rand=new Random();
	public void paint(Graphics g)
	{
		
		boolean done=false;
		while(!done)
		{
			int q=0;
			while(q<1000)
			{
			for(int x = 0;x < 1000;x++)
			{
				for(int y=0; x<1000; y++)
				{
					setcolor(g);
					int x1=rand.nextInt(2400);
					int y1=rand.nextInt(900);
					int diameter=5;//rand.nextInt(5);
					g.fillRect(x1, y1, diameter, diameter);
				}
			}
			q++;
			}
		}
	}
	
	public void setcolor(Graphics g)
	{
		int color=rand.nextInt(2);
		switch(color)
		{
		case 0:g.setColor(Color.black);break;
		case 1:g.setColor(Color.white);break;
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