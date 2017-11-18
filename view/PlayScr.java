package view;

import java.util.Scanner;

//import grid.AI;
import model.DirectionType;
import model.GameModel;
//import grid.SplashScreen;
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
public class PlayScr implements UI {

	public static Scanner KEYBOARD = new Scanner(System.in);
	public static Scanner attacker = new Scanner(System.in);
	public static String text;
	public static String attack;
	public static int attackint;
	private SplashScr splash;
	private PlaceScr place;
	private HandoffScr handoff;
	private WinScr win;
	
	//Constructor
	public PlayScr(){};

	//Passes in a player and then prints their name and all of there Ships and shots.
	public void dspPlayScr(Player p) {
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("					   " + p.getPlayerAlias() + "									");
		System.out.println("	   	 My Ships					My Shots");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("     A   B   C   D   E   F   G   H   I   J  	    A   B   C   D   E   F   G   H   I   J");
		System.out.println("--------------------------------------------	--------------------------------------------");
		//i and P2 are nested values which help call each cell.
		int i = 0;
		int p2 = 0;
		for (p2 = 0; p2 < 10; p2++) {
			if (p2 != 9) {
				System.out.print(p2 + 1 + " ");
			} else
				System.out.print(p2 + 1);
			for (i = 0; i < 10; i++) {
				System.out.print(" | " + p.getPlayerShips().getGrid()[p2][i].getCellDspChar());
			}
			if (i == 10) {
				System.out.print(" |	");
				if (p2 != 9) {
					System.out.print(p2 + 1 + " ");
				} else
					System.out.print(p2 + 1);
				for (int si = 0; si < 10; si++) {
					System.out.print(" | " + p.getPlayerShots().getGrid()[p2][si].getCellDspChar());
				}
			}
			System.out.print(" | \n");
			System.out.println(
					"--------------------------------------------	--------------------------------------------");
		}
		//Asks the user where they want to fire upon.
		getShotCoords(p);
	}
	
	//If the user chooses to play multiplayer. it asks the uses to choose which enemy they want to fire on.
	public static void whotoattach(Scanner scan) {
		System.out.print("Which Enermy would you like to fire upon?");
		attack = scan.nextLine();
		validenermyentry(attack);
	}
	
	//Checks to see if the users entry was valid.
	public static void validenermyentry(String s) {
		//Loops through all game options and checks i its valid. If not, asks the user to try again. 
		if (s.equals("1")) {
			attackint = 1;
		} else if (s.equals("2")) {
			attackint = 2;
		} else if (s.equals("3")) {
			attackint = 3;
		} else if (s.equals("4")) {
			attackint = 4;
		} else {
			System.out.println("Invalid enermy. Try again.");
			whotoattach(attacker);
		}
	}

	public void dspSplashScr(GameModel m) {
		splash = new SplashScr(KEYBOARD, m);
	}

	public int getPlayerCount() {
		return splash.getCount();
	}

	public String[] getPlayerAliases(Player p) {
		return splash.getAliases();
	}

	public void dspPlaceScr(Player p) {
		place = new PlaceScr(KEYBOARD, p);
	}

	public String getPlaceCoords(Player p) {
		return null;
	}

	@Override
	public ShipType getShipType() {;
		return null;
	}

	public DirectionType getDirection() {
		return place.getDirection();
	}
	
	public void dspShot(Player p) {
		dspPlayScr(p);
	}

	public String getShotCoords(Player p) {
		System.out.print("\nEnter Coordinates and press Enter to Fire:");
		text = KEYBOARD.next();
		p.loadPlayerShot(text);
		return text;
	}

	public void dspHandoffScr(Player l, Player p) {
		handoff = new HandoffScr(KEYBOARD,l,p);
	}

	@SuppressWarnings("static-access")
	public boolean dspWinScr(Player p, GameModel m) {
		win = new WinScr(KEYBOARD,p,m);
		if( win.endGameDetection(p) == true)
			return true;
		else
			return false;
	}

	@Override
	public String[] getPlayerAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPlaceCoords() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void dspShot() {
		// TODO Auto-generated method stub
	}

	@Override
	public String getShotCoords() {
		// TODO Auto-generated method stub
		return null;
	}
}