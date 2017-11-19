package view;

// import Scanner
import java.util.Scanner;

import model.Cell;
import model.CellStatus;
import model.Player;
import model.ShipType;

//import grid.SplashScreen;
// declare class
public class PlaceScr {
	static String[] ship = { "PATROL", "SUBMARINE", "DESTROYER", "BATTLESHIP", "CARRIER" };
	public static int col;
	public static int row;
	static int shiptype;
	static String Coords;
	static String Direction;
	static ShipType tempship = null;
	static Cell tempcell = new Cell(CellStatus.EMPTY);
	static int temp = 4;
	private static PlayScr play = new PlayScr();

	public PlaceScr() {

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
	public static String getPlaceCoords(Player p) {
	   System.out.println("PlaceScr: getPlaceCoords() player="+p.getPlayerAlias());
		if (shiptype == 5)
			shiptype = 0;
		GridScr.dspPlayScr(p);
		@SuppressWarnings("resource")
		Scanner CoordsInput = new Scanner(System.in);
		System.out.println("Enter coordinates (e.g. C4) to place your " + ship[shiptype] + ":");
		Coords = CoordsInput.nextLine();
		validentry(Coords);
		validshiptype(shiptype);
		shiptype++;
		return Coords;
	}

	public void getDirection() {
		@SuppressWarnings("resource")
		Scanner DirectionInput = new Scanner(System.in);
		System.out.println("Enter orienation(e.g. right):");
		Direction = DirectionInput.nextLine();
		Direction = Direction.toUpperCase();
		if (validgetDirection(Direction) == false)
			getDirection();
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
		}
	}

	public static boolean validgetDirection(String s) {
		if (s.equals("RIGHT")) {
			return true;
		}
		if (s.equals("LEFT")) {
			return true;
		}
		if (s.equals("DOWN")) {
			return true;
		}
		if (s.equals("UP")) {
			return true;
		}
		return false;
	}

	public boolean validcoords(String coords, String orientation, int lenght) {
		validentry(coords);
		if (col + lenght > 9 && orientation == "RIGHT") {
			System.out.println("Ship to long. Try again");
			return false;
		} else if (col + lenght <= 0 && orientation == "LEFT") {
			System.out.println("Ship to long. Try again");
			return false;
		} else if (row + lenght > 0 && orientation == "UP") {
			System.out.println("Ship to long. Try again");
			return false;
		} else if (col + lenght < 9 && orientation == "DOWN") {
			System.out.println("Ship to long. Try again");
			return false;
		} else
			return true;
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
		if (temp >= 0) {
			temp--;
			return true;
		}
		return false;
	}
}