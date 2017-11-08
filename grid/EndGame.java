import java.util.Scanner;

public class EndGame {
	
	///Displays end game screen.
	
	public static void printEndGameScreen(Player p) {
		
		System.out.println("\n\n\n\n\n\n\t\t\t\t\t =================");
	    System.out.println("\t\t\t\t\t NOSRC Battleships");
	    System.out.println("\t\t\t\t\t =================");
	    
	    HallOfFame.printDetails();
	    
	    System.out.println("\n\t\t\t\t\t =================");
	    System.out.println("\n\t\t\t\tCongratulations " + p.getName() + " has won the game!!!");
	    
	    System.out.println("\n\t\t\t\t\tTo play again enter 'Y'");
	    System.out.println("\t\t\t\t\t To exit enter 'X'");
	    System.out.print("\t\t\t\t\t    Selection: ");
	}
	/// Detects whether all of a players ships have been hit. Will need to be changed depending on how 
	/// we decide to program players/ ships. Will return either true or false
	
	public static boolean endGameDetection(ShipTypes[]  s) {
		boolean gameOver = false;
		int total = 0;
		for (int count = 0; count<2; count++) {
			total +=  s[count].getHitPoints();
		}
		if(total==0) {
			gameOver=true;
		}
		return gameOver;
		
		
	}
	/// Waits until the user selects a valid input.
	
	public static String endGameSelection() {
		
		String selection;
		
		Scanner sc = new Scanner(System.in);
		
		selection = sc.nextLine().toUpperCase();
		while(!selection.matches("Y|X")) {
			selection = sc.nextLine().toUpperCase();
		}
		sc.close();
		return selection;
	}
	
}
