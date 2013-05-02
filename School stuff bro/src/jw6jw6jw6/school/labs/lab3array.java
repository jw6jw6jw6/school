package jw6jw6jw6.school.labs;
import javax.swing.JOptionPane;
public class lab3array
{
	static String names[]=new String[25];
	static int count=0;
	static boolean run=true,stop=false;
	
	public static void main(String args[])
	{
		home();
	}
	
	public static void home()
	{
		notify("Welcome to lab. Please prepare yourself to insert names.");
		input();
	}
	
	public static void edithub()
	{
		while(run)
		{
		String temp=ask("Would you like to edit/add/remove a name. Enter yes/no.");
		if(temp.equals("no"))
			return;
		temp=ask("Enter:\n 1 for edit.\n 2 for add.\n 3 for remove.\n 4 To display the list.\n 5 for exit.");
		int t=Integer.parseInt(temp);
		switch(t)
		{
		case 1:edit();break;
		case 2:add();break;
		case 3:remove();break;
		case 4:print();break;
		case 5:run=false; return;
		default: notify("Invalid option");
		}
		}
	}
	
	public static void edit()
	{
		stop=false;
		String temp=ask("What name would you like to edit?");
		remove1(temp);
		if(!stop)
		{
		String temp1=ask("What would you like to change "+temp+" to?");
		add1(temp1);
		}
	}
	
	public static void add()
	{
		boolean found=false;
		int g=-1;
		String temp=ask("What name would you like to add?");
		for(int f=0;f<count-1;f++)
		{
			//System.out.println(temp.compareTo(names[f+1]));
			//System.out.println(names[f]+" "+names[f+1]);
			if(temp.compareTo(names[f])>0 && temp.compareTo(names[f+1])<0)
			{
				g=f+1;
				//notify("Found at position "+f);
				found=true;
			}
		}
		if(!found)
		{
			if(temp.compareTo(names[count-1])>0)
				{
				g=count;
				found=true;
				}
		}
		if(!found)
		{
			if(temp.compareTo(names[0])<0)
			{
				g=0;
				found=true;
			}
		}
		if(found)
		{
			//notify("The value of count is: "+count);
			//notify("The value of 'g' is:"+g);
			for(int d=count;d>=g;d--)
			{
				names[d+1]=names[d];
			}
			names[g]=temp;
			count++;
			print();
		}
		else
			notify("Unable to add name");
		edithub();
	}
	
	public static void remove()
	{
		boolean found=false;
		int g=-1;
		String temp=ask("What name would you like to remove?");
		for(int f=0;f<count;f++)
		{
			if(temp.equals(names[f]))
			{
				g=f;
				notify("Found at position "+f);
				found=true;
			}
		}
		if(!found)
		{
			notify("Name not found.");
			edithub();
		}
		else
		{
			//notify("Name found. Position "+g+"\n Value found is "+names[g]);
			for(int r=g;r<count;r++)
			{
			//notify("Changing "+names[r]+" to "+names[r+1]);
			names[r]=names[r+1];
			}
			names[count]=null;
			count--;
			print();
		}
			
	}
	
	public static void input()
	{
		
		String temp=ask("Input names. Seperate with a comma and a space.");
		String temp1[]=temp.split(", ");
		count=temp1.length;
		for(int g=0; g<count;g++)
		{
			names[g]=temp1[g];
		}
		sort1(names,count);
		edithub();
	}
	public static void print()
	{
		for(int y=0;y<count;y++)
		{
			notify(names[y]);
		}
	}
	
	public static String ask(String string)
	{
		String temp=JOptionPane.showInputDialog(string);
		return temp;
	}
	
	public static void notify(String string)
	{
		JOptionPane.showMessageDialog(null,string);
	}
	
	public static String[] sort1(String names[], int count)
	{
        String temp="";
        for(int i=0;i<count;i++)
        {
            for(int j=i+1;j<count;j++)
            {
               if(names[i].compareTo(names[j])>0)
               {
                   temp = names[i];
                   names[i]=names[j];
                   names[j]=temp;
                   
               }
            }
        }
        print();
        return names;
	}
	public static void add1(String temp)
	{
		boolean found=false;
		int g=-1;
		for(int f=0;f<count-1;f++)
		{
			//System.out.println(temp.compareTo(names[f+1]));
			//System.out.println(names[f]+" "+names[f+1]);
			if(temp.compareTo(names[f])>0 && temp.compareTo(names[f+1])<0)
			{
				g=f+1;
				//notify("Found at position "+f);
				found=true;
			}
		}
		if(!found)
		{
			if(temp.compareTo(names[count-1])>0)
				{
				g=count;
				found=true;
				}
		}           
		if(found)
		{
			//notify("The value of count is: "+count);
			//notify("The value of 'g' is:"+g);
			for(int d=count;d>=g;d--)
			{
				names[d+1]=names[d];
			}
			names[g]=temp;
			count++;
			print();
		}
		else
			stop=true;
	}
	public static void remove1(String temp)
	{
		boolean found=false;
		int g=-1;
		for(int f=0;f<count;f++)
		{
			if(temp.equals(names[f]))
			{
				g=f;
				//notify("Found at position "+f);
				found=true;
			}
		}
		if(!found)
		{
			notify("Name not found.");
		}
		else
		{
			//notify("Name found. Position "+g+"\n Value found is "+names[g]);
			for(int r=g;r<count;r++)
			{
			//notify("Changing "+names[r]+" to "+names[r+1]);
			names[r]=names[r+1];
			}
			names[count]=null;
			count--;
		}
			
	}
	
	
}
//used:x,y