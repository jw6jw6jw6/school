package Lab22;
public class Main 
{
	public static tree root = null;
	public static tree moving = null;
	public static tree moving1 = null;
	public static tree temp1 = null;
	static boolean done = false;
	public static void main(String args[])
	{
		uni.notify("Fact: Silence will fall when the question is asked. The question you have been running from your whole life.");
		while(!done)
		{
			String[] list = {"Add", "Print","Exit"};
			String temp8 = uni.dialog(list, "Pick a command","Command Prompt");
			if(temp8.equals("Add"))
			{
				int value = uni.parse(uni.ask("<html><p style=\"font-size:15;color:red;\">NUMBER</p></html>"));
				add1(value,new tree(value,null,null),root);
			}
			if(temp8.equals("Print"))
				print();
			if(temp8.equals("Exit"))
				break;
		}
	}
	
	public static void  print()
	{
		for(int x = 0; x < 50; x++)
			System.out.println();
		
		String[] list = {"In Order", "Pre-Order","Post-Order","Height","Width"};
		String temp8 = uni.dialog(list, "Print in:","Command Prompt");
		if(temp8.equals("In Order"))
			inorder(root);
			else
				if(temp8.equals("Pre-Order"))
					preorder(root);
				else
					if(temp8.equals("Post-Order"))
						postorder(root);
					else
						if(temp8.equals("Height"))
						{
							uni.notify("The height is: "+heightOfBinaryTree(root));
						}
						else
							if(temp8.equals("Width"))
							{
								int temp99 = heightOfBinaryTree(root.getright()) + heightOfBinaryTree(root.getleft()) + 1;
								uni.notify("The width is: "+temp99);
							}
							else
								uni.notify("Im sorry, an error has orrcured. please notify the developer");
	}
	
	public static void inorder(tree p)
	{
		if(p != null)
		{
			inorder(p.getleft());
			if(p != root)
				System.out.println("Node Value: "+p.getvalue());
				else
					System.out.println("ROOT: " +p.getvalue());
			inorder(p.getright());
		}
	}
	
	public static void preorder(tree p)
	{
		if(p != null)
		{
			
			if(p != root)
				System.out.println("Node Value: "+p.getvalue());
				else
					System.out.println("ROOT: " +p.getvalue());
			inorder(p.getleft());
			inorder(p.getright());
		}
	}
	
	public static void postorder(tree p)
	{
		if(p != null)
		{
			inorder(p.getleft());
			inorder(p.getright());
			if(p != root)
			System.out.println("Node Value: "+p.getvalue());
			else
				System.out.println("ROOT: " +p.getvalue());
		}
	}
	
	public static void recprint(tree p) 
	{ 
		if(p == null)
		{
			System.err.println("HELP ME!!! dfghjklfrghjklfghjkfghjklfghjkgvbhnm");
			return;
		}
		if(p.getleft() != null)
		{
			recprint(p.getleft());
			System.out.print( p.getleft().getvalue()+ " "); 
			 
		}
		if(p.getright()!= null) 
		{
			recprint(p.getright());
			System.out.print( p.getright().getvalue() + " ");
			
		}
	}
	
	public static int heightOfBinaryTree(tree node)
	{
	    if (node == null)
	    {
	        return 0;
	    }
	    else
	    {
	        return 1 + Math.max(heightOfBinaryTree(node.getleft()), heightOfBinaryTree(node.getright()));
	    }
	}
	
	public static void add1(int value, tree newone, tree temp1)
	{
		if(root == null)
		{
			System.out.println("Why hello there, I see your trying to add a new tree with the root of "+value);
			root = new tree(value,null,null);
			return;
		}
		
		System.out.println(value);
		if(value < temp1.getvalue())
		{
			System.out.println("Smaller than");
			if(temp1.getleft() == null)
			{
				temp1.setleft(newone);
				return;
			}
			else
				add1(value,newone,temp1.getleft());
		}
		if(value > temp1.getvalue())
			System.out.println("greater than");
			if(temp1.getright() == null)
			{
				temp1.setright(newone);
				return;
			}
			else
				add1(value,newone,temp1.getright());
	}
	
	public static void add(int value)
	{
		tree newone = new tree(value,null,null);
		if(root == null)
		{
			System.out.println("Why hello there, I see your trying to add a new tree with the root of "+value);
			root = new tree(value,null,null);
			return;
		}
		System.out.println("Hello again, I see your trying to add a new branch/leaf with a value of "+value);
		boolean found = false;
		if(value < root.getvalue())
		{
			moving = root.getleft();
			while(!found)
			{
				if(moving == null)
				{
					root.setleft(newone);
					return;
				}
				else
				if(value < moving.getvalue())
				{
					if(moving.getleft() == null)
					{
						moving.setleft(newone);
						found = true;
						break;
					}
					else
					{
						moving = moving.getleft();
						continue;
					}
				}
			}
		}
		else
		{
		moving = root.getright();
		while(!found)
		{
			if(moving == null)
			{
				root.setright(newone);
				return;
			}
			else
			if(value > moving.getvalue())
			{
				if(moving.getright() == null)
				{
					moving.setright(newone);
					found = true;
					break;
				}
				else
				{
					moving = moving.getright();
					continue;
				}
			}
		}
		}
	}
	
	
	public static void print1()
	{
		moving = tree1.allleft(root);
		while(moving != root)
		{
			moving1 = root;
			while(moving1.getleft() != moving)
			{
				moving = moving1.getleft();
			}
			System.out.print(" "+moving.getvalue());
			moving = moving1;
		}
		System.out.println(" "+root.getvalue());
	}
	
}
