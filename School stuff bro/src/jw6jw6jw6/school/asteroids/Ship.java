package jw6jw6jw6.school.asteroids;

import static org.lwjgl.opengl.GL11.*;
import jw6jw6jw6.school.main.GameObject;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Ship extends GameObject
{
	public Ship(float x, float y)
	{
		super(x, y);
	}
	
	public float getmaxSpeed()
	{
		return maxSpeed;
	}
	
	private float velX = 0, velY = 0;
	private float direction = 0;
	private float speedIncrement = .3f;
	private float maxSpeed = 4f;
	
	public void runTick(long time)
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
		{
			//x += 3 * Math.cos(Math.toRadians(direction));
			//y += 3 * Math.cos(Math.toRadians(direction));
			
			velX += speedIncrement*Math.cos(Math.toRadians(direction));
			velY += speedIncrement*Math.sin(Math.toRadians(direction));
		}
		else if(Keyboard.isKeyDown(Keyboard.KEY_S))
		{
			//x -= 3 * Math.cos(Math.toRadians(direction)) - Math.sin(Math.toRadians(direction));
			//y -= 3 * Math.cos(Math.toRadians(direction)) + Math.sin(Math.toRadians(direction));
			velX -= speedIncrement*Math.cos(Math.toRadians(direction));
			velY -= speedIncrement*Math.sin(Math.toRadians(direction));
		}
		else
		{
			velX /= 1+speedIncrement;
			velY /= 1+speedIncrement;
		}
		
		if(velX < -maxSpeed)
			velX = -maxSpeed;
		else if(velX > maxSpeed)
			velX = maxSpeed;
		
		if(velY < -maxSpeed)
			velY = -maxSpeed;
		else if(velY > maxSpeed)
			velY = maxSpeed;
		
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{
//			if(angle==0)
//				angle = 259;
//			else
//				angle -=1;
//			System.out.println(angle);
			direction += 5f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
		{
//			if(direction==259)
//				direction = 0;
//			else
//				direction +=1;
//			System.out.println(direction);
			direction -= 5f;
		}
		
		x += velX;
		y += velY;
		
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
			glTranslatef(x, y, 0);
			glColor3f(.1f,1,0);
			glRotatef(direction, 0, 0, 1);
			glBegin(GL_TRIANGLES);
			{
				glColor3f(1,0,0);
				glVertex3f(-10,10,0);
				glColor3f(0,0,1);
				glVertex3f(10,0,0);
				glColor3f(1,0,0);
				glVertex3f(-5,0,0);
				
				glColor3f(1,0,0);
				glVertex3f(-10,-10,0);
				glColor3f(0,0,1);
				glVertex3f(10,0,0);
				glColor3f(1,0,0);
				glVertex3f(-5,0,0);	
			}
			glEnd();
		}
		glPopMatrix();
	}
	
	public float getDirection()
	{
		return direction;
	}
}
