package view;

import java.util.Scanner;

import model.Cell;
import model.CellStatus;
import model.DirectionType;
import model.Player;
import model.ShipType;

public class PlaceScr 
{   
	
	static String[] ship = {"PATROL", "SUBMARINE", "DESTROYER", "BATTLESHIP", "CARRIER" };
	public static int col;
	public static int row;
	static int shiptype;
	static String Coords;
	static String Direction;
	static ShipType tempship = ShipType.setship();
	static Cell tempcell = new Cell(CellStatus.EMPTY);
	static int temp = 4;
   //constructor.
   public PlaceScr(Scanner s, Player p){
      //display ship placement screen here
      System.out.println("\nPlacement Screen");
      //get input here
      }

   public String getPlaceCoords() {
      // TODO Auto-generated method stub
      return "C5";
   }

   public ShipType getShipType() {
      // TODO Auto-generated method stub
      return null;
   }

   public DirectionType getDirection() {
      // TODO Auto-generated method stub
      return null;
   }
   
   public boolean remainingShips() {return false;}
}