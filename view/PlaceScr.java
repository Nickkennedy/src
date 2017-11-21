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
	public static int shiptype = 0;
	static String coords;
	static String Direction;
	static ShipType tempship = null;
	static boolean shipdoesntfit = false;
	static Cell tempcell = new Cell(CellStatus.EMPTY);
	private int temp = 4;
	String direction;
	DirectionType dir;

	//Each time the constructor is called, it loads the temp value back to 4. This is key for the ship string array.
	public PlaceScr() {
		temp = 4;
		shipdoesntfit = false;
	}
	
	/*The functions accepts a scanner, grid and player valuer and once called, will prompt the user to enter in there coordinates. 
	 * Once the user has entered in coordinates, it validates the string and ship type. 
	*/
	public String getPlaceCoords(Scanner s, GridScr g, Player p) {
		boolean first = true;
		if (shiptype == 5)
			shiptype = 0;
		g.display(p);
		if(shipdoesntfit) {
		   System.out.print("\nShip won't fit there. Try again: ");
		   shipdoesntfit = false;
		}
		System.out.print("\nEnter coordinates (e.g. C4) to place your " + ship[shiptype] + ": ");
		coords = s.nextLine();
		coords = coords.toUpperCase();
		validshiptype(shiptype);
	    do{
	    	if(p.areCoordsValid(coords) == false){
	    		System.out.print("Invalid coordinates!");
	    		System.out.print("\nEnter coordinates (e.g. C4) to place your " + ship[shiptype] + ": ");
	    		coords = s.nextLine();
	    		first = false;
	    	}
	    }
	    while(!p.areCoordsValid(coords));
	    shiptype++;
		return coords;
	}
	
	/*	This function accepts a scanner and prompts the user to enter in their desired orientation.
	 * Once entered, it converts the string to uppercase and then checks that it was a valid input.
	 */
	public String getDirection(Scanner s) {
		System.out.print("Enter orientation: left, right, up, down: ");
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
	public static boolean validentry(String s) {
		// Converts the keyboard entry into a char (column) and string (row)
		char colchar = s.charAt(0);
		String rowchar = s.substring(1);
		int temp = 0;
		
		switch (colchar) {
			case 'A': col = 0; temp++; break;
			case 'B': col = 1; temp++; break;
			case 'C': col = 2; temp++; break;
			case 'D': col = 3; temp++; break;
			case 'E': col = 4; temp++; break;
			case 'F': col = 5; temp++; break;
			case 'G': col = 6; temp++; break;
			case 'H': col = 7; temp++; break;
			case 'I': col = 8; temp++; break;
			case 'J': col = 9; temp++; break;
		default: System.out.println("Invalid column");
		}

		switch (rowchar) {
			case "1": col = 0; temp++; break;
			case "2": col = 1; temp++; break;
			case "3": col = 2; temp++; break;
			case "4": col = 3; temp++; break;
			case "5": col = 4; temp++; break;
			case "6": col = 5; temp++; break;
			case "7": col = 6; temp++; break;
			case "8": col = 7; temp++; break;
			case "9": col = 8; temp++; break;
			case "10": col = 9; temp++;	break;
		default:
			System.out.println("Invalid row");
		}
		
		if(temp == 2)
			return true;
		return false;
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
