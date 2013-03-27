package jw6jw6jw6.school.main;

import java.util.Iterator;

public class Physics extends Game
{
	public void collision()
	{
		Iterator<GameObject> iterator = objects.iterator();
		Iterator<GameObject> iterator2 = objects.iterator();
		GameObject object1 = iterator.next();
		object1 = iterator2.next();
		while(iterator.hasNext())
		{
			GameObject object = iterator.next();
			object1 = iterator2.next();
			if(object.getX() == object1.getX() && object.getY() == object1.getY())
			{
				iterator.remove();
				iterator2.remove();
				continue;
			}
			
			object.runTick();
		}
	}
}
