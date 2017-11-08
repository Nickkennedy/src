package grid;

import java.util.Scanner;

public class grid {
	//Creates the arrays needed for 2 players. 
	static String[][] p1shipsarray = new String [10][10];
	static String[][] p1shotsarray = new String [10][10];
	static String[][] p2shipsarray = new String [10][10];
	static String[][] p2shotsarray = new String [10][10];	
	static Scanner KEYBOARD = new Scanner(System.in); 
	static String text; //Used for the keyboard entry
	static int col = 0;
	static int row = 0;
	static int currentplayer = 1; //Used to monitor which player is currently playing
	
	//Sets the starting value of " " for all items in the array
	public static void startvalue(String[][] array){
		for(int p = 0; p <10; p++){
			for(int i = 0; i < 10; i++){
				array[p][i] = " ";
			}
		}
	}

	//Prints out the current field for the user passed into the function. Please note that this is still coded to 2 player currently.
	public static void printships(){
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("					   Player " + currentplayer +"									");
		System.out.println("	   	 My Ships					My Shots");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("     A   B   C   D   E   F   G   H   I   J  	    A   B   C   D   E   F   G   H   I   J");
		System.out.println("--------------------------------------------	--------------------------------------------");
		// I and P are used for formatting purposes
		int i = 0; 
		int p = 0;
		
		//PLAYER 1
		if (currentplayer == 1){
		for(p = 0; p < 10; p++){
			if(p != 9){
				System.out.print(p + 1 + " ");	
			}
			else 
				System.out.print(p + 1);
			for(i = 0; i < 10; i++){
				System.out.print(" | " + p1shipsarray[p][i]);
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
		keyboad(KEYBOARD); //Once printed, allow the user to enter in a keyboard value.
		}
		
		// PLAYER 2
		else if(currentplayer == 2){
			for(p = 0; p < 10; p++){
				if(p != 9){
					System.out.print(p + 1 + " ");	
				}
				else 
					System.out.print(p + 1);
				for(i = 0; i < 10; i++){
					System.out.print(" | " + p2shipsarray[p][i]);
				}
				if(i == 10){
					System.out.print(" |	");
					if(p != 9){
						System.out.print(p + 1 + " ");	
					}	
					else 
						System.out.print(p + 1);
					for(int si = 0; si < 10; si++){
						System.out.print(" | " + p2shotsarray[p][si]);
					}
				}
				System.out.print(" | \n");
				System.out.println("--------------------------------------------	--------------------------------------------");
				}
			keyboad(KEYBOARD); //Once printed, allow the user to enter in a keyboard value.
		}
	}
	
	//Takes the keyboard entry and passes it to be check if it is valid
	public static void keyboad(Scanner scan){ 
		System.out.print("Enter Coordinates and press Enter to Fire:");
		text= scan.nextLine(); 
		validentry(text);
		hitcheck(col,row); //Now the program has the int values of the keyboard entry, pass to check if its a hit
	}
	
	//Checks to see if the string entered is valid. If not, returns error
	public static void validentry(String s){
		//Converts the keyboard entry into a char (column) and string (row)
		char colchar= s.charAt(0);
		String rowchar= s.substring(1);

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
	}
	
	//Once the keyboard entry has been converted to a set of ints, checks if its a hit. Assigns value to array depending on result
	public static void hitcheck(int a, int b){
		//PLAYER 1
		if(currentplayer == 1){
			if(p1shipsarray[b][a].equals("S")){
				System.out.println("Hit!");
				p1shotsarray[b][a] = "X";
				p2shipsarray[b][a] = "X";
			}
			else {
				System.out.println("Miss");
				p1shotsarray[b][a] = "M";
				p2shipsarray[b][a] = "M";
			}
		}
		//PLAYER 2
		else if(currentplayer == 2){
			if(p2shipsarray[b][a].equals("S")){
				System.out.println("Hit!");
				p2shotsarray[b][a] = "X";
				p1shipsarray[b][a] = "X";
			}
			else {
				System.out.println("Miss");
				p2shotsarray[b][a] = "M";
				p1shipsarray[b][a] = "M";
			}
		}
	}
}
