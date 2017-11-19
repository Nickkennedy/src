package view;

import model.Player;
//copied from zip/
public class GridScr
{
   //constructor
	public GridScr(){
	}
	
	//constructor
	public void GridScr(Player p){
		   display(p);}
		
	
	//method   
	public void display(Player p) {
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
	}
}
//