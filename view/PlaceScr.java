package view;

import java.util.Scanner;
import model.Cell;
import model.CellStatus;
import model.DirectionType;
import model.Player;
import model.ShipType;
import view.GridScr;

/**
 * @author Christopher Musamba
 * with help
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

	// constructor
	public PlaceScr() {
		temp = 4;
	}

	/*
	 * public public static void shiptypeinput() { // displays the ships left
	 * System.out.println("Ships available"); for (int i = 0; i < ship.length;
	 * i++) { System.out.println(" " + ship[i]); }
	 * 
	 * @SuppressWarnings("resource") Scanner shiptypeinput = new
	 * Scanner(System.in); System.out.println(
	 * "Enter your ship type (e.g. Battleship):"); shiptype =
	 * shiptypeinput.nextLine(); if(validshiptype(shiptype) == false){
	 * shiptypeinput(); } }
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

	public String getDirection(Scanner s) {
		System.out.print("Enter orientation: (l)eft, (r)ight, (u)p, (d)own ");
		direction = s.nextLine();
		direction = direction.toUpperCase();
		if (validdirection(direction) == false){
			getDirection(s);
		}
		return direction;
	}

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

	public boolean validdirection(String s){
		switch(s){
		 case "RIGHT": return true;
		 case "DOWN": return true;
		 case "LEFT": return true;
		 case "UP": return true;
		}
		return false;
	}

	public static void placeShips(Player p) {

		if (Direction.equals("RIGHT")) {
			for (int i = col; i <= col + tempship.getLength(); i++) {
				p.getPlayerShips().setGridCell(tempcell, row, i);
				;
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

	public boolean remainingShips() {
		// System.out.println("remainingShips="+temp);
		if (temp >= 0) {
			temp--;
			return true;
		}
		return false;
	}

}
//