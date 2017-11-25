package view;
import java.util.Scanner;
import model.GameModel;
import model.Player;

/***
 * @author Robert Bessell
 * 
 */
//copied from zip/
public class WinScr {
	
	///Displays end game screen.
	
	public WinScr(Scanner s, Player p, GameModel m) {
		
		for(int count=0; count<5; count++) {
					System.out.println("\n");
		}
					
		
		System.out.println("\n\n\n\n\n\n\t\t\t\t =================");
	    System.out.println("\t\t\t\t NOSRC Battleships");
	    System.out.println("\t\t\t\t =================");
	    
	    new HOFScr(m);
	    
	    System.out.println("\n\t\t\t\t =================");
	    System.out.println("\n\t\t\tCongratulations " + p.getPlayerAlias() + " has won the game!!!");
	    
	    System.out.println("\n\t\t\t\tTo play again enter 'Y'");
	    System.out.println("\t\t\t\t To exit enter 'X'");
	}
	
	/// Waits until the user selects a valid input.
	public boolean endGameSelection(Scanner s) {
		
		String selection;						
				
		System.out.print("\t\t\t\t    Selection: ");
		selection = s.nextLine().toUpperCase();
		while(!selection.matches("Y|X")) {
			System.out.println("\t\t\t\tInvalid input try again!!!");
			System.out.print("\t\t\t\t    Selection: ");
		 	selection = s.nextLine().toUpperCase();
		}
		for(int count=0; count<5; count++) {
					System.out.println("\n");
		}
		if(selection.equals("X")) 
			return true;    //end the game
		else 
			return false;   //play another game
	}	
}
