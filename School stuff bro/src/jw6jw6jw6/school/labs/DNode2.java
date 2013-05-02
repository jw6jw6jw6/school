package jw6jw6jw6.school.labs;

public class DNode2 
{
	public Object value;
	private DNode2 next,back;
	
	public DNode2(Object inval, DNode2 innext, DNode2 inback)
	{
		value = inval;
		next = innext;
		back = inback;
	}
	
	public void setvalue(Object val){value = val;}
	public Object getvalue() { return value;}
	public void setnext(DNode2 nex){next = nex;}
	public void setback(DNode2 bac){back = bac;}
	public DNode2 getnext() { return next;}
	public DNode2 getback() { return back;}
}
