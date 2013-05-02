package jw6jw6jw6.school.labs;
public class lab10pascal
{
	static int size=0;
	public static void main(String args[])
	{
		int array[][]=new int[input()][];
		int temp=1;
		for(int y=0;y<size;y++)
		{
			array[y]=new int[temp];
			temp+=1;
		}
		math(array);
		print(array);
	}
	
	public static int input()
	{
		String temp=uni.ask("Enter a NUMBER NOW!!!");
		size=Integer.parseInt(temp);
		return size;
	}
	
	public static void math(int[][] array)
	{
		for(int x=0;x<size;x++)
		{
			array[x][0]=1;
		}
		int z=0;
		for(int x=0;x<size;x++)
		{
			array[x][z]=1;
			z++;
		}
		int q=3;
		for(int y=2;y<size;y++)
		{
			for(int x=1;x<q-1;x++)
			{
				array[y][x]=array[y-1][x]+array[y-1][x-1];
			}
			q++;
		}
	}
	
	public static void print(int[][] array)
	{
		int z=1;
		for(int x=0;x<size;x++)
		{

			for(int y=0;y<z;y++)
			{
				System.out.print(array[x][y]+" ");
			}
			z++;
			System.out.println();
		}
//		System.out.println(array[4][0]+" "+array[4][1]+" "+array[4][2]+" "+array[4][3]+" "+array[4][4]);
	}
}
