package jw6jw6jw6.school.labs;

public class DNode 
{
	private Object id,name,age,gpa;
	private DNode next,back;
	
	public DNode(Object inid, Object inage, Object inname,Object ingpa, DNode innext, DNode inback)
	{
		id = inid;
		name = inname;
		age = inage;
		gpa = ingpa;
		next = innext;
		back = inback;
	}
	
	public Object getname() { return name;}
	public void setname(Object val){name = val;}
	public void setgpa(Object val){gpa = val;}
	public void setage(Object val){age = val;}
	public Object getgpa() { return gpa;}
	public Object getage() { return age;}
	public Object getid() { return id;}
	public DNode getnext() { return next;}
	public DNode getback() { return back;}
	public void setid(Object val){id = val;}
	public void setnext(DNode nex){next = nex;}
	public void setback(DNode bac){back = bac;}
	
}
