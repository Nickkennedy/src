package view;

import java.util.Scanner;

//import grid.SplashScreen;
import model.Player;

public class PlayScr {

	public static Scanner KEYBOARD = new Scanner(System.in);
	public static Scanner attacker = new Scanner(System.in);
	public static String text;
	public static String attack;
	public static int col = 0;
	public static int row = 0;
	public static int attackint;

	public PlayScr(Scanner s, Player p) {
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		System.out.println("					   " + p.getPlayerAlias() + "									");
		System.out.println("	   	 My Ships					My Shots");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("     A   B   C   D   E   F   G   H   I   J  	    A   B   C   D   E   F   G   H   I   J");
		System.out.println("--------------------------------------------	--------------------------------------------");
		// I and P are used for formatting purposes
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
		System.out.print("\nEnter Coordinates and press Enter to Fire:");
		text = s.next();
		p.loadPlayerShot(text);
	}

	public static void whotoattach(Scanner scan) {
		System.out.print("Which Enermy would you like to fire upon?");
		attack = scan.nextLine();
		validenermyentry(attack);
	}

	public static void validenermyentry(String s) {
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
//		if (attackint > SplashScreen.intnumberplayer) {
//			System.out.println("Invalid enermy. Try again.");
//			whotoattach(attacker);
//		}
	}
}