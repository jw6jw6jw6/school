package jw6jw6jw6.school.labs;
import java.awt.*;
import java.applet.*;
import java.util.Random;
public class lab7encapgr extends Applet
{
	public void paint(Graphics g)
	{
		grid(g);
		lines(g);
		orectangles(g);
		frectangles(g);
		oovals(g);
		fovals(g);
		oarcs(g);
		farcs(g);
		cubes(g);
		opolly(g);
		fpolly(g);
		plines(g);
		rpixles(g);
	}
	
	public void grid(Graphics g)
	{
		g.drawRect(50,50,800,600);
		for(int x=250; x < 850; x+=200)
			g.drawLine(x, 50, x, 650);
		for(int x=250; x < 650; x+=200)
			g.drawLine(50, x, 850, x);
	}
	
	public void lines(Graphics g)
	{
		g.drawLine(65,65,240,220);
		g.drawLine(240,65,65,220);
	}
	
	public void orectangles(Graphics g)
	{
		g.drawRect(275, 65, 100, 50);
		g.drawRect(390, 65, 48, 100);
		g.drawRoundRect(275, 135, 85, 85, 25, 25);
		g.drawRoundRect(390, 180, 50, 50, 50, 50);
	}
	
	public void frectangles(Graphics g)
	{
		g.fillRect(475, 65, 100, 50);
		g.fillRect(590, 65, 48, 100);
		g.fillRoundRect(475, 135, 85, 85, 25, 25);
		g.fillRoundRect(590, 180, 50, 50, 50, 50);
	}
	
	public void oovals(Graphics g)
	{
		g.drawOval(675, 65, 100, 50);
		g.drawOval(790, 65, 48, 100);
		g.drawOval(675, 135, 85, 85);
		g.drawOval(790, 180, 50, 50);
	}
	
	public void fovals(Graphics g)
	{
		g.fillOval(75, 265, 100, 50);
		g.fillOval(190, 265, 48, 100);
		g.fillOval(75, 335, 85, 85);
		g.fillOval(190, 380, 50, 50);
	}
	
	public void oarcs(Graphics g)
	{
		g.drawArc(275, 265, 100, 50, 0, 180);
		g.drawArc(275, 335, 85, 85, 90, 270);
		g.drawArc(390, 380, 50, 50, 180, 270);
		g.drawArc(360, 240, 80, 130,180,180);
	}
	
	public void farcs(Graphics g)
	{
		g.drawArc(475, 265, 100, 50, 0, 180);
		g.drawArc(475, 335, 85, 85, 90, 270);
		g.drawArc(590, 380, 50, 50, 180, 270);
		g.drawArc(560, 240, 80, 130,180,180);
	}
	
	public void color(Graphics g, int color)
	{
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
	
	public void cubes(Graphics g)
	{
		color(g,0);
		g.fillRect(700, 270, 20, 20);
		color(g,1);
		g.fillRect(725, 270, 20, 20);
		color(g,2);
		g.fillRect(750, 270, 20, 20);
		color(g,3);
		g.fillRect(775, 270, 20, 20);
		
		color(g,4);
		g.fillRect(700, 300, 20, 20);
		color(g,5);
		g.fillRect(725, 300, 20, 20);
		color(g,6);
		g.fillRect(750, 300, 20, 20);
		color(g,7);
		g.fillRect(775, 300, 20, 20);
		
		color(g,8);
		g.fillRect(700, 330, 20, 20);
		color(g,9);
		g.fillRect(725, 330, 20, 20);
		color(g,10);
		g.fillRect(750, 330, 20, 20);
		color(g,11);
		g.fillRect(775, 330, 20, 20);
		
	}
	
	public void opolly(Graphics g)
	{
		int x[]=new int[6];
		int y[]=new int[6];
		x[0]=70;x[1]=90;x[2]=110;x[3]=120;x[4]=140;x[5]=80;
		y[0]=510;y[1]=550;y[2]=513;y[3]=530;y[4]=505;y[5]=500;
		g.drawPolygon(x,y,6);
		
		int x1[]=new int[10];
		int y1[]=new int[10];
		x1[0]=140;x1[1]=160;x1[2]=160;x1[3]=200;x1[4]=200;x1[5]=220;x1[6]=240;x1[7]=240;x1[8]=120;x1[9]=120;
		y1[0]=540;y1[1]=560;y1[2]=600;y1[3]=600;y1[4]=540;y1[5]=520;y1[6]=540;y1[7]=635;y1[8]=635;y1[9]=560;
		g.drawPolygon(x1,y1,10);
	}
	public void fpolly(Graphics g)
	{
		int x[]=new int[6];
		int y[]=new int[6];
		x[0]=270;x[1]=290;x[2]=310;x[3]=320;x[4]=340;x[5]=290;
		y[0]=510;y[1]=550;y[2]=513;y[3]=530;y[4]=505;y[5]=500;
		g.fillPolygon(x,y,6);
		
		int x1[]=new int[10];
		int y1[]=new int[10];
		x1[0]=340;x1[1]=360;x1[2]=360;x1[3]=400;x1[4]=400;x1[5]=420;x1[6]=440;x1[7]=440;x1[8]=320;x1[9]=320;
		y1[0]=540;y1[1]=560;y1[2]=600;y1[3]=600;y1[4]=540;y1[5]=520;y1[6]=540;y1[7]=635;y1[8]=635;y1[9]=560;
		g.fillPolygon(x1,y1,10);
	}
	
	public void plines(Graphics g)
	{
		int x[]=new int[6];
		int y[]=new int[6];
		x[0]=470;x[1]=490;x[2]=510;x[3]=520;x[4]=540;x[5]=490;
		y[0]=510;y[1]=550;y[2]=513;y[3]=530;y[4]=505;y[5]=500;
		g.drawPolyline(x,y,6);
		
		int x1[]=new int[10];
		int y1[]=new int[10];
		x1[0]=340;x1[1]=360;x1[2]=360;x1[3]=400;x1[4]=400;x1[5]=420;x1[6]=440;x1[7]=440;x1[8]=320;x1[9]=320;
		y1[0]=540;y1[1]=560;y1[2]=600;y1[3]=600;y1[4]=540;y1[5]=520;y1[6]=540;y1[7]=635;y1[8]=635;y1[9]=560;
		for(int w=0;w<10;w++)
			x1[w]+=200;
		g.drawPolyline(x1,y1,9);
	}
	
	public void rpixles(Graphics g)
	{
		Random rand=new Random();
		int y=rand.nextInt(11);
		for(int x=0;x<=10000;x++)
		{
			y=rand.nextInt(11);
			color(g,y);
			int x1=rand.nextInt(195);
			int y1=rand.nextInt(195);
			x1+=650;
			y1+=450;
			int diameter=rand.nextInt(5);
			g.fillOval(x1, y1, diameter, diameter);
		}
	}
	
}
