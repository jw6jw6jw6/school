package jw6jw6jw6.school.asteroids;

import java.util.ArrayList;
import java.util.Iterator;

import jw6jw6jw6.school.main.Game;
import jw6jw6jw6.school.main.GameObject;
import jw6jw6jw6.school.main.Main;
import jw6jw6jw6.school.main.Physics;
import jw6jw6jw6.school.main.uni;
import java.util.Random;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;

public class Asteroids extends Game
{
	private Random rand = new Random();
	private Ship ship;
	private int count = 0;
	private ArrayList<Asteroid> asteroids =  new ArrayList<Asteroid>();
	
	public void init()
	{
		ship = new Ship(Display.getWidth()/2, Display.getHeight()/2);
		asteroids.add(new Asteroid(0,0));
	}
	
	private long timer1 = 0;
	private long timer2 = 0;
	private long difficulty = 4000;
	
	public void runTick(long time)
	{
		timer1 += time;
		timer2 += time;
		if(timer1 >= difficulty)
		{
			asteroids.add(new Asteroid(rand.nextInt(Display.getWidth()),rand.nextInt(Display.getHeight())));
			timer1 = 0;
			difficulty-=10;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE) && timer2 > 200)
		{
			objects.add(new Bullet(ship));
			timer2 = 0;
		}
		
		for(GameObject object : objects)
			if(object instanceof Bullet)
				for(Asteroid a : asteroids)
					if(Physics.collidesInBox(a, (Bullet)object, 10f))
					{
						a.setUnload(true);
						object.setUnload(true);
						count++;
					}
		for(Asteroid a : asteroids)
			if(Physics.collidesInBox1(a, ship, 10f))
			{
				a.setUnload(true);
				Main.running = false;
				uni.notify("Game over! You killed "+count+" asteroids!");
			}
		
		ship.runTick(time);
		super.runTick(time);
		Iterator<Asteroid> iterator = asteroids.iterator();
		while(iterator.hasNext())
		{
			Asteroid a = iterator.next();
			if(a.getUnload())
			{
				iterator.remove();
				continue;
			}
			a.runTick(time);
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
