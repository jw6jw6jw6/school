package jw6jw6jw6.school.asteroids;

import java.util.ArrayList;
import java.util.Iterator;

import jw6jw6jw6.school.main.Game;
import jw6jw6jw6.school.main.GameObject;
import jw6jw6jw6.school.main.Physics;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Asteroids extends Game
{
	private Ship ship;
	private ArrayList<Asteroid> asteroids =  new ArrayList<Asteroid>();
	
	public void init()
	{
		ship = new Ship(Display.getWidth()/2, Display.getHeight()/2);
		asteroids.add(new Asteroid(0,0));
	}
	
	public void runTick()
	{
		System.out.println(asteroids.size());
		if(Keyboard.isKeyDown(Keyboard.KEY_2))
		{
			asteroids.add(new Asteroid(400,300));
			System.out.println("Asteroid Created!:" +asteroids.size());
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE))
		{
			objects.add(new Bullet(ship));
		}
		
		for(GameObject object : objects)
			if(object instanceof Bullet)
				for(Asteroid a : asteroids)
					if(Physics.collidesInBox(a, (Bullet)object, 8f))
					{
						a.setUnload(true);
						object.setUnload(true);
					}
		
		ship.runTick();
		super.runTick();
		Iterator<Asteroid> iterator = asteroids.iterator();
		while(iterator.hasNext())
		{
			Asteroid a = iterator.next();
			if(a.getUnload())
			{
				iterator.remove();
				continue;
			}
			a.runTick();
		}
	}
	
	public void render()
	{
		super.render();
		for(Asteroid a : asteroids)
			a.render();
		
		ship.render();
	}
}
