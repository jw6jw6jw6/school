package jw6jw6jw6.school.main;

import jw6jw6jw6.school.asteroids.Asteroid;
import jw6jw6jw6.school.asteroids.Bullet;

public class Physics
{
	public static boolean collidesInBox(Asteroid a, Bullet b, float sideLength)
	{
		if(Math.abs(a.getX() - b.getX()) <= sideLength && Math.abs(a.getY() - b.getY()) <= sideLength)
			return true;
		return false;
	}
}
/*public static boolean collision(Asteroid a, Bullet b)
	{
		if(a.getX()-8 >= b.getX() && a.getX()+8 <= b.getX() && a.getY()-8 >= b.getY() && a.getY()+8 <= b.getY()-8)
			return true;
		return false;
	}
	*/

//System.out.println(objects.size());
//for(int x=0; x<asteroids.size(); x++)
//{
//	for(int y=0; y<objects.size(); y++)
//	{
//		if(asteroids.get(x).getX()+8 >= objects.get(y).getX() && asteroids.get(x).getX()-8 <= objects.get(y).getX())
//		{
//			if(asteroids.get(x).getY()+8 >= objects.get(y).getY() && asteroids.get(x).getY()-8 <= objects.get(y).getY()-8)
//			{
//				if(y==0)
//					uni.notify("YOU LOSE");
//				asteroids.get(x).shouldBeUnloaded = true;
//				objects.get(y).shouldBeUnloaded = true;
//				System.out.println("HIT!");
//			}
//		}
//	}
//}
//}