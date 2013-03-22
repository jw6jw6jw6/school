package Lab22;
public class tree 
{
	private int value;
	private tree left;
	private tree right;
	
	public tree(int invalue, tree inleft, tree inright)
	{
		value = invalue;
		left = inleft;
		right = inright;
	}
	public int getvalue() {return value;}
	public tree getleft() {return left;}
	public tree getright() {return right;}
	public void setvalue(int invalue) {value = invalue;}
	public void setleft(tree inleft) {left = inleft;}
	public void setright(tree inright) {right = inright;}	
}
