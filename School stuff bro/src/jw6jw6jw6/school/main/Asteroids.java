package jw6jw6jw6.school.main;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Asteroids extends Game
{
	public void init()
	{
		objects.add(new Ship(Display.getWidth()/2, Display.getHeight()/2));
	}
	
	public void runTick()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			objects.add(new Bullet((Ship)objects.get(0)));
		}
		super.runTick();
	}
	
	public void shoot()
	{
		
	}
}
