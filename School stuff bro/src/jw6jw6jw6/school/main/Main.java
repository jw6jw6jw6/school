package jw6jw6jw6.school.main;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public class Main
{
	public static void main(String args[])
	{
		initDisplay();
		initGL();
		init();
		while(!Display.isCloseRequested())
		{
			glClear(GL_COLOR_BUFFER_BIT);
			glLoadIdentity();
			
			//game calculate
			//game render
			
			Display.update();
			Display.sync(60);
		}
		exit();
	}

	private static void initDisplay() 
	{
		try 
		{
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
			Display.setVSyncEnabled(true);
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
	}

	private static void exit()
	{
		Display.destroy();
	}

}
