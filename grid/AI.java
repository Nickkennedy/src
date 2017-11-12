package grid;

import java.util.Random;

public class AI {
	static String [][] lasthit = new String [1][1];
	static String [][] chase = new String [4][10];
	
	public static int random(int a){
		Random rand = new Random();
		int  n = rand.nextInt(10) + 1;
		a = n;
		return a;
	}
	
	public static void aifire(){
		int row = 0;
		int col = 0;
		
		grid.hitcheck(random(row),random(col));
		
	}
}
