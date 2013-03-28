package jw6jw6jw6.school.asteroids;

import java.util.Random;

import jw6jw6jw6.school.main.GameObject;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex3f;

import org.lwjgl.opengl.Display;

public class Asteroid extends GameObject
{
	private float direction;
	private float maxSpeed;
	private Random rand = new Random();
	
	public Asteroid(float x, float y)
	{
		super(x, y);
		this.direction = rand.nextInt(360); 
		maxSpeed = 3f +1;
	}
	
	public void runTick(long time)
	{
		x += maxSpeed*Math.cos(Math.toRadians(direction));
		y += maxSpeed*Math.sin(Math.toRadians(direction));
		
		if(x < 0)
			x += Display.getWidth();
		else if(x > Display.getWidth())
			x -= Display.getWidth();
	
		if(y < 0)
			y += Display.getHeight();
		else if(y > Display.getHeight())
			y -= Display.getHeight();
	}
	
	public void render()
	{
		glPushMatrix();
		{
			glColor3f(1,0,0);
			glTranslatef(x,y,0);
			glBegin(GL_TRIANGLES);
			{
				glColor3f(.5f,.5f,0);
				glVertex3f(-10,10,0);
//				glColor3f(0,0,1);
				glVertex3f(10,0,0);
//				glColor3f(1,0,0);
				glVertex3f(-5,0,0);
			}
			glEnd();
		}
		glPopMatrix();
	}
	
}
