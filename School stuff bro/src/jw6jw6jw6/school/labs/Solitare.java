package jw6jw6jw6.school.labs;
import java.util.Random;
public class Solitare
{
	public static void main (String args[])
	{
		Cards.start();
		Cards.deal();
		Cards.print();
		Cards.findwinner();
	}
}

class Cards
{
	static Random rand=new Random();
	private static String[] deck = new String[52];
	private static boolean [] dealt = new boolean[52];
	private static int [][] game = new int[5][5];

	public static void start()
	{
		deck[0]= "Ace of Clubs";
		deck[1]= "Ace of Spades";
		deck[2]= "Ace of Hearts";
		deck[3]= "Ace of Diamonds";
		deck[4]= "2 of Clubs";
		deck[5]= "2 of Spades";
		deck[6]= "2 of Hearts";
		deck[7]= "2 of Diamonds";
		deck[8]= "3 of Clubs";
		deck[9]= "3 of Spades";
		deck[10]="3 of Hearts";
		deck[11]="3 of Diamonds";
		deck[12]="4 of Clubs";
		deck[13]="4 of Spades";
		deck[14]="4 of Hearts";
		deck[15]="4 of Diamonds";
		deck[16]="5 of Clubs";
		deck[17]="5 of Spades";
		deck[18]="5 of Hearts";
		deck[19]="5 of Diamonds";
		deck[20]="6 of Clubs";
		deck[21]="6 of Spades";
		deck[22]="6 of Hearts";
		deck[23]="6 of Diamonds";
		deck[24]="7 of Clubs";
		deck[25]="7 of Spades";
		deck[26]="7 of Hearts";
		deck[27]="7 of Diamonds";
		deck[28]="8 of Clubs";
		deck[29]="8 of Spades";
		deck[30]="8 of Hearts";
		deck[31]="8 of Diamonds";
		deck[32]="9 of Clubs";
		deck[33]="9 of Spades";
		deck[34]="9 of Hearts";
		deck[35]="9 of Diamonds";
		deck[36]="10 of Clubs";
		deck[37]="10 of Spades";
		deck[38]="10 of Hearts";
		deck[39]="10 of Diamonds";
		deck[40]="Jack of Clubs";
		deck[41]="Jack of Spades";
		deck[42]="Jack of Hearts";
		deck[43]="Jack of Diamonds";
		deck[44]="Queen of Clubs";
		deck[45]="Queen of Spades";
		deck[46]="Queen of Hearts";
		deck[47]="Queen of Diamonds";
		deck[48]="King of Clubs";
		deck[49]="King of Spades";
		deck[50]="King of Hearts";
		deck[51]="King of Diamonds";
		
		for (int x = 0; x <=51; x++)
			dealt[x] = false;
	
		for (int j = 0; j <=4; j++)
			for (int k = 0; k <=4; k++)
				game[j][k] = 0;
	}
	
	public static void deal()
	{
		int g=0;
		boolean broken=false;
		for(int x=0;x<5;x++)
			for(int y=0;y<5;y++)
			{
				do
				{
					int temp=getrandom(52);
					if(dealt[temp])
						broken=true;
					else
					{
						broken=false;
						g=temp;
					}
				}while(broken);
				dealt[g]=true;
				game[x][y]=parse(g);
			}
	}
	
	public static int parse(int g)
	{
		if(g<4)
			return 11;
		if(g >= 4 && g < 36)
		{
			String temp= deck[g].substring(0, 1);
			int temp1=Integer.parseInt(temp);
			return temp1;
		}
		else
		{
			return 10;
		}
	}
	
	public static void print()
	{
		for(int x=0;x<5;x++)
		{
			for(int y=0;y<5;y++)
			{
				System.out.print(game[x][y]+"\t");
			}
			System.out.println();
		}
	}
	
	public static int getrandom(int max)
	{
		int r=rand.nextInt(max);
		return r;
	}
	public static void findwinner()
	{
		String win;
		boolean pair;
		int max=0;
		int r0=game[0][0]+game[0][1]+game[0][2]+game[0][3]+game[0][4];
		int r1=game[1][0]+game[1][1]+game[1][2]+game[1][3]+game[1][4];
		int r2=game[2][0]+game[2][1]+game[2][2]+game[2][3]+game[2][4];
		int r3=game[3][0]+game[3][1]+game[3][2]+game[3][3]+game[3][4];
		int r4=game[4][0]+game[4][1]+game[4][2]+game[4][3]+game[4][4];
		
		int c0=game[0][0]+game[1][0]+game[2][0]+game[3][0]+game[4][0];
		int c1=game[0][1]+game[1][1]+game[2][1]+game[3][1]+game[4][1];
		int c2=game[0][2]+game[1][2]+game[2][2]+game[3][2]+game[4][2];
		int c3=game[0][3]+game[1][3]+game[2][3]+game[3][3]+game[4][3];
		int c4=game[0][4]+game[1][4]+game[2][4]+game[3][4]+game[4][4];
		
		for(int x=0;x<4;x++)
		{
			for(int y=x;y<4;y++)
			{
				if(game[x][0] == game[y][0])
					pair = true;
			}
		}
		if(pair = false)
			r0 = 0;
		pair = false;
		for(int x=0;x<4;x++)
		{
			for(int y=x;y<4;y++)
			{
				if(game[x][1] == game[y][1])
					pair = true;
			}
		}
		
		if(pair = false)
			r1 = 0;
		pair = false;
		for(int x=0;x<4;x++)
		{
			for(int y=x;y<4;y++)
			{
				if(game[x][2] == game[y][2])
					pair = true;
			}
		}
		if(pair = false)
			r2 = 0;
		pair = false;
		for(int x=0;x<4;x++)
		{
			for(int y=x;y<4;y++)
			{
				if(game[x][3] == game[y][3])
					pair = true;
			}
		}
		if(pair = false)
			r3 = 0;
		pair = false;
		for(int x=0;x<4;x++)
		{
			for(int y=x;y<4;y++)
			{
				if(game[x][4] == game[y][4])
					pair = true;
			}
		}
		if(pair = false)
			r4 = 0;
		pair = false;
		for(int x=0;x<4;x++)
		{
			for(int y=x;y<4;y++)
			{
				if(game[0][x] == game[0][y])
					pair = true;
			}
		}
		if(pair = false)
			c0 = 0;
		pair = false;
		for(int x=0;x<4;x++)
		{
			for(int y=x;y<4;y++)
			{
				if(game[1][x] == game[1][y])
					pair = true;
			}
		}
		if(pair = false)
			c1 = 0;
		pair = false;
		for(int x=0;x<4;x++)
		{
			for(int y=x;y<4;y++)
			{
				if(game[2][x] == game[2][y])
					pair = true;
			}
		}
		if(pair = false)
			c2 = 0;
		pair = false;
		for(int x=0;x<4;x++)
		{
			for(int y=x;y<4;y++)
			{
				if(game[3][x] == game[3][y])
					pair = true;
			}
		}
		if(pair = false)
			c3 = 0;
		pair = false;
		for(int x=0;x<4;x++)
		{
			for(int y=x;y<4;y++)
			{
				if(game[4][x] == game[4][y])
					pair = true;
			}
		}
		if(pair = false)
			c4 = 0;
		if(Math.max(r0,r1)==r0)
		{
			win="Row 0";
			max=r0;
		}
		else
		{
			win="Row 1";
			max=r1;
		}
		if(Math.max(max,r2)==r2)
		{
			win="Row 2";
			max=r2;
		}
		else
		{
			if(Math.max(max,r3)==r3)
			{
				win="Row 3";
				max=r3;
			}
			else
			{
				if(Math.max(max,r4)==r4)
				{
					win="Row 4";
					max=r4;
				}
				else
				{
					if(Math.max(max,c0)==c0)
					{
						win="Column 0";
						max=c0;
					}
					else
					{
						if(Math.max(max,c1)==c1)
						{
							win="Column 1";
							max=c1;
						}
						else
						{
							if(Math.max(max,c2)==c2)
							{
								win="Column 2";
								max=c2;
							}
							else
							{
								if(Math.max(max,c3)==c3)
								{
									win="Column 3";
									max=c3;
								}
								else
								{
									if(Math.max(max,c4)==c4)
									{
										win="Column 4";
										max=c4;
									}
									else
									{
										
									}
								}
							}
						}
					}
				}
			}
		}
		uni.notify(win+" is the winner with a value of "+max);
	}
}
