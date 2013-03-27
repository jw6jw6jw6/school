package jw6jw6jw6.school.main;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

public class Bullet extends GameObject
{
	private float direction;
	
	
	public Bullet(Ship ship)
	{
		super(ship.getX(), ship.getY());
		this.direction = ship.getDirection();
	}
	
	public void runTick()
	{
		x += .3f*Math.cos(Math.toRadians(direction));
		y += .3f*Math.sin(Math.toRadians(direction));
		
		if(x < 0 || x > Display.getWidth() || y < 0 || y > Display.getHeight())
			shouldBeUnloaded=true;
	}
	
	public void render()
	{
		glPushMatrix();
		{
			glTranslatef(x,y,0);
			glBegin(GL_QUADS);
			{
				glVertex3f(-4,4,0);
				glVertex3f(-4,-4,0);
				glVertex3f(4,-4,0);
				glVertex3f(4,4,0);
				
			}
			glEnd();
		}
		glPopMatrix();
	}
}
