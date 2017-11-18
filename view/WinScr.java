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
	    endGameSelection(s);
	}
	/// Detects whether a player has any ships alive, returns either true or false. Updated  18/11 Rob

	
	public static boolean endGameDetection(Player p) {
		boolean gameOver = false;
		if(p.getShipsLeft()==0) {
			gameOver=true;
		}
		return gameOver;
		
	}
	
	/// Waits until the user selects a valid input.
	
	public static String endGameSelection(Scanner s) {
		
		String selection;
				
		selection = s.nextLine().toUpperCase();
		while(!selection.matches("Y|X")) {
			selection = s.nextLine().toUpperCase();
		}
		return selection;
	}	
}
