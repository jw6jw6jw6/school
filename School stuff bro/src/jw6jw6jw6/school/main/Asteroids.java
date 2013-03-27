package jw6jw6jw6.school.main;

import java.util.Iterator;

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
		if(Keyboard.isKeyDown(Keyboard.KEY_2))
			objects.add(new Asteroid(400,300));
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			objects.add(new Bullet((Ship)objects.get(0)));
		}
		super.runTick();
		new Physics().collision();
	}
	
	public void render()
	{
		Iterator<GameObject> iterator = objects.iterator();
		GameObject object = iterator.next();
		while(iterator.hasNext())
			iterator.next().render();
		object.render();
	}
}
