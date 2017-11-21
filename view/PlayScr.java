package view;

import java.util.Scanner;

import model.Player;
import model.ShipType;
/**
 * @author Nicholas Kennedy s3674937
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Purpose:       1)Prints out the players grid with all the latest cell data.
 *                2)Asks the user to enter in coordinates.
 *                3)If the user is playing more then 2 players, asks the user which player they want to fire on.
 * Location:      View 
 */
//copied from zip/
public class PlayScr {

	public static String coords;
	public static String attack;
	public static int attackint;
	private SplashScr splash;

	//Constructor
	public PlayScr(){};
	
	

   public String getShotCoords(Scanner s, GridScr g, Player p) {
      boolean first = true;
      g.display(p);
      System.out.print("\nEnter Coordinates and press Enter to Fire: ");
      do{
         if(!first) System.out.print("Invalid Coordinates! Enter again and press Enter to Fire: ");
         first = false;
         coords = s.nextLine();}
      while(!p.areCoordsValid(coords));
      return coords;
   }
	
	//If the user chooses to play multiplayer. it asks the uses to choose which enemy they want to fire on.
	public static void whotoattack(Scanner s) {
		System.out.print("Which Enemy would you like to fire upon?");
		attack = s.nextLine();
		validenemyentry(s, attack);
	}
	
	//Checks to see if the users entry was valid.
	public static void validenemyentry(Scanner s, String str) {
		//Loops through all game options and checks i its valid. If not, asks the user to try again. 
		if (str.equals("1")) {
			attackint = 1;
		} else if (str.equals("2")) {
			attackint = 2;
		} else if (str.equals("3")) {
			attackint = 3;
		} else if (str.equals("4")) {
			attackint = 4;
		} else {
			System.out.println("Invalid enemy. Try again.");
			whotoattack(s);
		}
	}

	public int getPlayerCount() {
		return splash.getCount();
	}

	public String[] getPlayerAliases(Player p) {
		return splash.getAliases();
	}
	
	public void dspShot(GridScr g, Player p) {
		g.display(p);
	}
}
//