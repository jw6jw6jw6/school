package jw6jw6jw6.school.main;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Game
{
	public ArrayList<GameObject> objects = new ArrayList<GameObject>();
	
	public void runTick(long time)
	{
		Iterator<GameObject> iterator = objects.iterator();
		while(iterator.hasNext())
		{
			GameObject object = iterator.next();
			if(object.shouldBeUnloaded)
			{
				iterator.remove();
				continue;
			}
			
			object.runTick(time);
		}
	}
	
	public void render()
	{
		for(GameObject object : objects)
			object.render();
	}
	
	public void init()
	{
	}
	
	public void exit()
	{
	}
	
	public int getFrameRate()
	{
		return 60;
	}
	
	public int getSizeWidth()
	{
		return 800;
	}
	
	public int getSizeHeight()
	{
		return 600;
	}
	
	public boolean getVSync()
	{
		return true;
	}
}
