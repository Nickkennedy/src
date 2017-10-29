package grid;

import java.util.Scanner;

public class grid {
	//Creates the arrays needed for 2 players. 
	static String[][] p1shiparray = new String [10][10];
	static String[][] p1shotsarray = new String [10][10];
	static String[][] p2shotsarray = new String [10][10];
	static String[][] p2shipsarray = new String [10][10];
	static int [] player = {1,2,3,4};	
	static Scanner KEYBOARD = new Scanner(System.in); 
	static String text; //Needed for the keyboard entry
	
	//Sets the starting values of the string arrays
	public static void startvalue(String[][] array){
		for(int p = 0; p <10; p++){
			for(int i = 0; i < 10; i++){
				array[p][i] = " ";
			}
		}
	}

	//prints out heads and grids
	public static void printships(int s){
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("					   Player " + player[s] +"									");
		System.out.println("	   	 My Ships					My Shots");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("     A   B   C   D   E   F   G   H   I   J  	    A   B   C   D   E   F   G   H   I   J");
		System.out.print("--------------------------------------------	--------------------------------------------");
		int i = 0;
		int p = 0;
		for(p = 0; p < 10; p++){
			if(p ==0){
				System.out.print("\n");
			}
			if(p != 9){
				System.out.print(p + 1 + " ");	
			}
			else 
				System.out.print(p + 1);
			
			for(i = 0; i < 10; i++){
				System.out.print(" | " + p1shiparray[p][i]);
			}
			
			if(i == 10){
				System.out.print(" |	");
				
				if(p != 9){
					System.out.print(p + 1 + " ");	
				}
				
				else 
					System.out.print(p + 1);
				
				for(int si = 0; si < 10; si++){
					System.out.print(" | " + p1shotsarray[p][si]);
				}
			}
			
			System.out.print(" | \n");
			System.out.println("--------------------------------------------	--------------------------------------------");
			}
		
		keyboad(KEYBOARD); 
		
	}
	
	//Takes keyboard antry and passes it to be checked
	public static void keyboad(Scanner scan){ 
		System.out.print("Enter Coordinates and press Enter to Fire:");
		text= scan.nextLine(); 
		validentry(text);
	}
	
	//Checks to see if the string entered is valid. If not, returns error
	public static void validentry(String s){
		char colchar= s.charAt(0);
		String rowchar= s.substring(1);
		int col = 0;
		int row = 0;

		if (colchar == 'A' || colchar == 'a' )
			col = 0;
		else if (colchar == 'B' || colchar == 'b')
			col = 1;
		else if (colchar == 'C' || colchar == 'c')
			col = 2;
		else if (colchar == 'D' || colchar == 'd')
			col = 3;
		else if (colchar == 'E' || colchar == 'e')
			col = 4;
		else if (colchar == 'F' || colchar == 'f')
			col = 5;
		else if (colchar == 'G' || colchar == 'g')
			col = 6;
		else if (colchar == 'H' || colchar == 'h')
			col = 7;
		else if (colchar == 'I' || colchar == 'i')
			col = 8;
		else if (colchar == 'J' || colchar == 'j')
			col = 9;
		else{
			System.out.println("Invalid column");
			keyboad(KEYBOARD);
		}
		
		if (rowchar.contentEquals("1"))
			row = 0;
		else if (rowchar.contentEquals("2"))
			row = 1;	
		else if (rowchar.contentEquals("3"))
			row = 2;	
		else if (rowchar.contentEquals("4"))
			row = 3;	
		else if (rowchar.contentEquals("5"))
			row = 4;	
		else if (rowchar.contentEquals("6"))
			row = 5;	
		else if (rowchar.contentEquals("7"))
			row = 6;	
		else if (rowchar.contentEquals("8"))
			row = 7;	
		else if (rowchar.contentEquals("9"))
			row = 8;	
		else if (rowchar.contentEquals("10"))
			row = 9;	
		else{
			System.out.println("Invalid Row");
			keyboad(KEYBOARD);
		}
		hitcheck(col,row);
	}
	
	//Now that the keyboard entry is valid, see if its a hit
	public static void hitcheck(int a, int b){
		if(p1shiparray[b][a].equals("S")){
			System.out.println("Hit!");
			p1shiparray[b][a] = "X";
			printships(0);
		}
		else {
			System.out.println("Miss");
			p1shotsarray[b][a] = "M";
			printships(0);
		}
	}

	public static void main(String[] args) {
		startvalue(p1shiparray);
		startvalue(p1shotsarray);
		printships(0);
	}
}
