package view;

import java.util.Scanner;

import grid.SplashScreen;
import grid.grid;
import model.Player;

public class PlayScr {

	public static Scanner KEYBOARD = new Scanner(System.in);
	public static Scanner attacker = new Scanner(System.in);
	public static String text;
	public static String attack;
	public static int col = 0;
	public static int row = 0;
	public static int attackint;
	public static int currentplayer = 1;

	public PlayScr(Scanner s, Player p1) {
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		System.out.println("					   	" + p1.getPlayerAlias() + "									");
		System.out.println("	   	 My Ships					My Shots");
		System.out.println(
				"--------------------------------------------------------------------------------------------");
		System.out.println("     A   B   C   D   E   F   G   H   I   J  	    A   B   C   D   E   F   G   H   I   J");
		System.out
				.println("--------------------------------------------	--------------------------------------------");
		// I and P are used for formatting purposes
		int i = 0;
		int p = 0;

		// PLAYER 1
		if (currentplayer == 1) {
			for (p = 0; p < 10; p++) {
				if (p != 9) {
					System.out.print(p + 1 + " ");
				} else
					System.out.print(p + 1);
				for (i = 0; i < 10; i++) {
					System.out.print(" | " + grid.p1shipsarray[p][i]);
				}
				if (i == 10) {
					System.out.print(" |	");
					if (p != 9) {
						System.out.print(p + 1 + " ");
					} else
						System.out.print(p + 1);
					for (int si = 0; si < 10; si++) {
						System.out.print(" | " + grid.p1shipsarray[p][si]);
					}
				}
				System.out.print(" | \n");
				System.out.println(
						"--------------------------------------------	--------------------------------------------");
			}
		}
	}

	public static String getShotCoords(String s) {

		System.out.print("Enter Coordinates and press Enter to Fire:");
		text = KEYBOARD.next();
		validentry(text);
		return text;
	}

	public static void validentry(String s) {
		// Converts the keyboard entry into a char (column) and string (row)
		char colchar = s.charAt(0);
		String rowchar = s.substring(1);

		if (colchar == 'A' || colchar == 'a')
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
		else {
			System.out.println("Invalid column");
			getShotCoords(s);
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
		else {
			System.out.println("Invalid Row");
			getShotCoords(s);
		}
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
		if (attackint > SplashScreen.intnumberplayer) {
			System.out.println("Invalid enermy. Try again.");
			whotoattach(attacker);
		}
	}
}