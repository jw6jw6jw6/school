package jw6jw6jw6.school.main;

public abstract class GameObject
{
	protected float x, y;
	protected boolean shouldBeUnloaded = false;
	
	public GameObject(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public void render()
	{
	}
	
	public void runTick()
	{
	}
	
	public float getX()
	{
		return x;
	}
	
	public float getY()
	{
		return y;
	}
}
