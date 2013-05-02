package jw6jw6jw6.school.labs;
import java.awt.*;
import java.applet.*;
import java.util.Random;
public class lab16recursio extends Applet
{
	//1400x768
		int origx=550,origy=280,origwidth=350,origheight=192,width=350,height=192;
		public void paint(Graphics g)
		{
			g.fillRect(550, 280, width, height);
			width*=.5;//550-175=375
			height*=.5;
			g.fillRect(463,232,width,height);
			g.fillRect(725,232,width, height);
			g.fillRect(463,376,width,height);
		}
}
