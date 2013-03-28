package jw6jw6jw6.school.main;

import jw6jw6jw6.school.asteroids.Asteroids;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Main
{
	private static Game game = new Asteroids();
	public static boolean running = true;
	private static long lastSystemTime = System.currentTimeMillis();
	
	public static void main(String args[])
	{
		initDisplay();
		initGL();
		init();
		while(!Display.isCloseRequested() && running)
		{
			glClear(GL_COLOR_BUFFER_BIT);
			glLoadIdentity();
			
			long currentTime = System.currentTimeMillis();
			
			if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE))
				running = false;
			//game calculate
			//game render
			game.runTick(currentTime-lastSystemTime);
			game.render();
			/*if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
			{
			glColor3f(2f,0,0);
			glBegin(GL_QUADS);
			glVertex2f(15,47);
			glVertex2f(15,43);
			glVertex2f(19,43);
			glVertex2f(19,47);
			glEnd();
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_X))
			{
			glColor3f(0.5f,0.5f,1.0f);
			glBegin(GL_QUADS);
			glVertex2f(100,100);
			glVertex2f(100+200,100);
			glVertex2f(100+200,100+200);
			glVertex2f(100,100+200);
			glEnd();
			}*/
			
			lastSystemTime = currentTime;
			
			Display.update();
			Display.sync(game.getFrameRate());
		}
		exit();
	}

	private static void initDisplay() 
	{
		try 
		{
			Display.setDisplayMode(new DisplayMode(game.getSizeWidth(),game.getSizeHeight()));
			Display.create();
			Display.setVSyncEnabled(game.getVSync());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void initGL()
	{
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,Display.getWidth(),0,Display.getHeight(), -1, 1);
		glMatrixMode(GL_MODELVIEW);
		glClearColor(0,0,0,1);
		glDisable(GL_DEPTH_TEST);
	}

	private static void init()
	{
		//init game
		game.init();
	}

	private static void exit()
	{
		game.exit();
		Display.destroy();
	}

}
