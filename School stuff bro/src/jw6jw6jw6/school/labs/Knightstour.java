package jw6jw6jw6.school.labs;
import java.util.Random;
public class Knightstour {
	static int[][]board = new int[8][8];
	static int globalCount = 0;
	static int[][] countBoard = new int[8][8];
	static int moveCounter = 0; 
	
	public static void main(String[] args) {
		init(board);
		init(countBoard);
		Random rand=new Random();
		int X=rand.nextInt(7);
		int Y=rand.nextInt(7);
		System.out.println(trayseII(0,Y,X));
		
		System.out.println(globalCount);
		print(countBoard);
		
		
	}
public static boolean trayseII(int count, int y, int x){
		
	countBoard[y][x] = moveCounter;
	moveCounter++;
		
		
	board[y][x] = count;
	if(count >= 64)
	{
		return true;
	}
	//up 2 left 1
	else if (y > 1 && x > 0 && board[y-2][x-1] == -1 && trayseII(count + 1, y-2, x-1))  {  
          return true;    }
	
    //up 2 right 1
    else if(y > 1 && x < 7 && board[y-2][x+1] == -1 && trayseII(count + 1,y-2,x+1)){    
         return true;  }
	
	
    //down 2 right 1
    else if(y < 6 && x < 7 && board[y+2][x+1]== -1 && trayseII(count + 1,y+2,x+1)){
    	 return true;}
	
    //down 2 left 1
    else if(y < 6 && x > 0 && board[y+2][x-1]== -1 && trayseII(count + 1,y+2,x-1)){
    	 return true;}
    
    //right 2 up 1
    else if(x < 6 && y > 0 && board[y-1][x+2]== -1 && trayseII(count + 1,y-1,x+2)){
    	 return true;}
	
    //right 2 down 1
    else if(x < 6 && y < 7 && board[y+1][x+2]== -1 && trayseII(count + 1,y+1,x+2)){
    	return true;}
    
    //left 2 up 1
    else if(x > 1 && y > 0 && board[y-1][x-2]== -1 && trayseII(count + 1,y-1,x-2)){
    	 return true;}
	
    //left 2 down 1
    else if(x > 1 && y < 7 && board[y+1][x-2]== -1 && trayseII(count + 1,y+1,x-2)){
    	 return true;}
    
    if(count >= 57)
    	globalCount = count;
	
    return false;
	
}
	public static void init(int[][] array){
		for(int i = 0; i < array[0].length; i++){
			for(int a = 0; a < array.length; a++){
				array[i][a] = -1;
			}
		}
	}
	public static void print(int[][] array){
		boolean flag = false;
		for(int i = 0; i < array[0].length; i++){
			System.out.println();
			flag = false;
			for(int a = 0; a < array.length; a++){
				if(flag){
						System.out.print("   " + array[i][a]);
						flag = false;
				}
				else{
					if(array[i][a] < 10){
						System.out.print("  " + array[i][a]);
						flag = true;
					}
					else{
						System.out.print("  " + array[i][a]);
					}
				}
			}
		}
	}
}
