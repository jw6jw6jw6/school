package jw6jw6jw6.school.main;
import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.opengl.Display;

public class Bullet extends GameObject
{
	private float direction;
	private float maxSpeed;
	
	public Bullet(Ship ship)
	{
		super(ship.getX(), ship.getY());
		this.direction = ship.getDirection();
		maxSpeed = ship.getmaxSpeed() +1;
//		maxSpeed = .3f;
	}
	
	public void runTick()
	{
		x += maxSpeed*Math.cos(Math.toRadians(direction));
		y += maxSpeed*Math.sin(Math.toRadians(direction));
		
		if(x < 0 || x > Display.getWidth() || y < 0 || y > Display.getHeight())
			shouldBeUnloaded=true;
	}
	
	public void render()
	{
		glPushMatrix();
		{
			glColor3f(1,0,0);
			glTranslatef(x,y,0);
			glBegin(GL_QUADS);
			{
				glVertex3f(-2,2,0);
				glVertex3f(-2,-2,0);
				glVertex3f(2,-2,0);
				glVertex3f(2,2,0);
				
			}
			glEnd();
		}
		glPopMatrix();
	}
}
