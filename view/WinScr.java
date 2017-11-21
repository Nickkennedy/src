/*package view;

import java.util.Scanner;

import model.GameModel;
import model.Player;
import view.HOFScr;

public class WinScr 
{   
   //constructor.
   public WinScr(Scanner s, Player p, GameModel m){
      System.out.println("\n          "+p.getPlayerAlias()+" has Won the game!");
      new HOFScr(m);
      //get input here
      }
}
*/
package view;

import java.util.Scanner;
import model.Player;
import model.GameModel;

/**
 * @author Robert Bessell
 * 
 */
//copied from zip/
public class WinScr {
	
	///Displays end game screen.
	
	public WinScr(Scanner s, Player p, GameModel m) {
		
		System.out.println("\n\n\n\n\n\n\t\t\t\t\t =================");
	    System.out.println("\t\t\t\t\t NOSRC Battleships");
	    System.out.println("\t\t\t\t\t =================");
	    
	    new HOFScr(m);
	    
	    System.out.println("\n\t\t\t\t\t =================");
	    System.out.println("\n\t\t\t\tCongratulations " + p.getPlayerAlias() + " has won the game!!!");
	    
	    System.out.println("\n\t\t\t\t\tTo play again enter 'Y'");
	    System.out.println("\t\t\t\t\t To exit enter 'X'");
	    System.out.print("\t\t\t\t\t    Selection: ");
	}
	
	/// Waits until the user selects a valid input.
	public boolean endGameSelection(Scanner s) {
		
		String selection;
				
		selection = s.nextLine().toUpperCase();
		while(!selection.matches("Y|X")) {
			selection = s.nextLine().toUpperCase();
		}
      if(selection.equals("X")) 
         return true;    //end the game
      else 
         return false;   //play another game
	}	
}