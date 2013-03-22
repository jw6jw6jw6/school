package Lab22;
public class tree1 
{
	public static tree allleft(tree in) 
	{
		if(in.getleft() != null)
		{
			in = in.getleft();
			allleft(in);
		}
		return in;
	}
}
