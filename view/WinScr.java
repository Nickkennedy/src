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
	
	public WinScr(Player p, GameModel m) {
		
		System.out.println("\n\n\n\n\n\n\t\t\t\t\t =================");
	    System.out.println("\t\t\t\t\t NOSRC Battleships");
	    System.out.println("\t\t\t\t\t =================");
	    
	    new HOFScr(m);
	    
	    System.out.println("\n\t\t\t\t\t =================");
	    System.out.println("\n\t\t\t\tCongratulations " + p.getPlayerAlias() + " has won the game!!!");
	    
	    System.out.println("\n\t\t\t\t\tTo play again enter 'Y'");
	    System.out.println("\t\t\t\t\t To exit enter 'X'");
	    System.out.print("\t\t\t\t\t    Selection: ");
	    endGameSelection();
	}
	/// Detects whether all of a players ships have been hit. Will need to be changed depending on how 
	/// we decide to program players/ ships. Will return either true or false. Updated 10/11 Rob
	
/*	public static boolean endGameDetection(Player p) {
		boolean gameOver = false;
		int total = p.BATTLESHIP.getHitPoints() + p.CARRIER.getHitPoints()
		+ p.SUBMARINE.getHitPoints() + p.DESTROYER.getHitPoints() + p.PATROL.getHitPoints();
		if(total==0) {
			gameOver=true;
		}
		return gameOver;
		
	}
*/	
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
