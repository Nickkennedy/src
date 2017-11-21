package view;

import java.util.Scanner;
import model.Cell;
import model.CellStatus;
import model.DirectionType;
import model.Player;
import model.ShipType;
import view.GridScr;

/**
 * @author Christopher Musamba & Nicholas Kennedy
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Purpose:       1) Allows the user to enter coordinates.
 *                2) Allows the user to Enter a direction.
 *                3) Validates the users input.
 */
//copied from zip/
// declare class
public class PlaceScr {
	static String[] ship = { "PATROL", "SUBMARINE", "DESTROYER", "BATTLESHIP", "CARRIER" };
	public static int col;
	public static int row;
	public static int shiptype;
	static String coords;
	static String Direction;
	static ShipType tempship = null;
	static Cell tempcell = new Cell(CellStatus.EMPTY);
	private int temp = 4;
	String direction;
	DirectionType dir;

	//Each time the constructor is called, it loads the temp value back to 4. This is key for the ship string array.
	public PlaceScr() {
		temp = 4;
	}
	
	/*The functions accepts a scanner, grid and player valuer and once called, will prompt the user to enter in there coordinates. 
	 * Once the user has entered in coordinates, it validates the string and ship type. 
	*/
	public String getPlaceCoords(Scanner s, GridScr g, Player p) {
		// System.out.println("PlaceScr: getPlaceCoords() player=" +
		// p.getPlayerAlias());
		if (shiptype == 5)
			shiptype = 0;
		g.display(p);
		System.out.print("\nEnter coordinates (e.g. C4) to place your " + ship[shiptype] + ": ");
		coords = s.nextLine();
		validentry(coords);
		validshiptype(shiptype);
		shiptype++;
		return coords;
	}
	
	/*	This function accepts a scanner and prompts the user to enter in their desired orientation.
	 * Once entered, it converts the string to uppercase and then checks that it was a valid input.
	 */
	public String getDirection(Scanner s) {
		System.out.print("Enter orientation: (l)eft, (r)ight, (u)p, (d)own ");
		direction = s.nextLine();
		direction = direction.toUpperCase();
		if (validdirection(direction) == false){
			getDirection(s);
		}
		return direction;
	}

	/* Validentry is designed to check that the user entered in valid coordinates and if so, assign the row and colum to int values. 
	 * 
	 */
	public static void validentry(String s) {
		// Converts the keyboard entry into a char (column) and string (row)
		char colchar = s.charAt(0);
		String rowchar = s.substring(1);

		switch (colchar) {
		case 'A': col = 0; break;
		case 'a': col = 0; break;
		case 'B': col = 1; break;
		case 'b': col = 1; break;
		case 'C': col = 2; break;
		case 'c': col = 2; break;
		case 'D': col = 3; break;
		case 'd': col = 3; break;
		case 'E': col = 4; break;
		case 'e': col = 4; break;
		case 'F': col = 5; break;
		case 'f': col = 5; break;
		case 'G': col = 6; break;
		case 'g': col = 6; break;
		case 'H': col = 7; break;
		case 'h': col = 7; break;
		case 'I': col = 8; break;
		case 'i': col = 8; break;
		case 'J': col = 9; break;
		case 'j': col = 9; break;
		default: System.out.println("Invalid column");
		}

		switch (rowchar) {
		case "1": col = 0; break;
		case "2": col = 1; break;
		case "3": col = 2; break;
		case "4": col = 3; break;
		case "5": col = 4; break;
		case "6": col = 5; break;
		case "7": col = 6; break;
		case "8": col = 7; break;
		case "9": col = 8; break;
		case "10": col = 9;	break;
		default:
			System.out.println("Invalid row");
		}
	}
	
	/*
	 * This method is passed a string and checks to see that the users input was a valid direction and if so, return the direction type.
	 */
	public static DirectionType validgetDirection(String s) {
		if (s.equals("RIGHT")) {
			return DirectionType.RIGHT;
		}
		if (s.equals("LEFT")) {
			return DirectionType.LEFT;
		}
		if (s.equals("DOWN")) {
			return DirectionType.DOWN;
		}
		if (s.equals("UP")) {
			return DirectionType.UP;
		}
		return DirectionType.valueOf(s);
	}

	/*
	 * This method is passed a int and checks to see that the users input was a valid ship type. The int value relates to the ship type in the string array.
	 */
	public static boolean validshiptype(int i) {

		if (i == 0) {
			tempship = ShipType.PATROL;
			return false;
		} else if (i == 1) {
			tempship = ShipType.SUBMARINE;
			return false;
		} else if (i == 2) {
			tempship = ShipType.DESTROYER;
			return false;
		} else if (i == 3) {
			tempship = ShipType.BATTLESHIP;
			return false;
		} else if (i == 4) {
			tempship = ShipType.CARRIER;
			return false;
		}
		tempship = null;
		return false;
	}

	/*
	 * This method is passed a string and checks to see that the users input was a valid direction and if so, returns true, else false.
	 */
	public boolean validdirection(String s){
		switch(s){
		 case "RIGHT": return true;
		 case "DOWN": return true;
		 case "LEFT": return true;
		 case "UP": return true;
		}
		return false;
	}
	
	/*
	 * This method is passed a player and within the method pulls the tempcell, row and col. Once these values have been pulled, it checks to see if the ship will see
	 * and if so, places the value of the cell to "O" which represents a ship.
	 */
	public static void placeShips(Player p) {
		if (Direction.equals("RIGHT")) {
			for (int i = col; i <= col + tempship.getLength(); i++) {
				p.getPlayerShips().setGridCell(tempcell, row, i);
			}
		} else if (Direction.equals("LEFT")) {
			for (int i = col; i < tempship.getLength() - 1; i--) {
				p.getPlayerShips().setGridCell(tempcell, row, i);
			}
		} else if (Direction.equals("UP")) {
			for (int i = row; i < tempship.getLength() - 1; i--) {
				p.getPlayerShips().setGridCell(tempcell, i, col);
			}
		} else if (Direction.equals("DOWN")) {
			for (int i = col; i < tempship.getLength() - 1; i++) {
				p.getPlayerShips().setGridCell(tempcell, i, col);
			}
		}
	}
	
	/*
	 * This boolean method is used to check if there are any more ships left to be places. 
	 */
	public boolean remainingShips() {
		if (temp >= 0) {
			temp--;
			return true;
		}
		return false;
	}
}