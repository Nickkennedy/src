package grid;

import java.util.Random;
import model.Player;


public class AI {
	//Array used to build the string to fire on coordinates;
	static char co[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
	static String coord;
	//Stores value for the last know hit.
	static int LastKnownhitcol;
	static int LastKnownhitrow;
	static int LastKnownoption;
	
	//Creates a random int.
	public static int random(int a) {
		Random rand = new Random();
		int n = rand.nextInt(10) + 1;
		a = n;
		return a;
	}
	
	//The class definds where the AI will fire upon.
	public static void aifire(Player p) {
		int row = 0;
		int colint = 0;
		
		//If the previous shot was a hit, LastKnownoption rotates around the last known hit. Each time it hits it moves along.
		if (LastKnownhitcol >= 0) {
			if (LastKnownoption == 0) {
				coord = co[LastKnownhitcol] + Integer.toString(LastKnownhitrow + 1);
				LastKnownoption++;
			} else if (LastKnownoption == 1) {
				coord = co[LastKnownhitcol] + Integer.toString(LastKnownhitrow - 1);
				LastKnownoption++;
			} else if (LastKnownoption == 2) {
				coord = co[LastKnownhitcol + 1] + Integer.toString(LastKnownhitrow);
				LastKnownoption++;
			} else if (LastKnownoption == 3) {
				coord = co[LastKnownhitcol - 1] + Integer.toString(LastKnownhitrow);
				LastKnownoption = 0;
			}
		} else {
			//If there is no hit, create a string of 2 random ints.
			if (coord == "") {
				row = random(row);
				colint = random(colint);
				coord = co[colint] + Integer.toString(row);
			}
		}
		//Checks to see if the next shot will be a hit and if so, saves the coordinates on the last known row/col
		if (p.getPlayerShots().getGrid()[colint][row].getCellDspChar() == "X") {
			LastKnownhitcol = colint;
			LastKnownhitrow = row;
		}
		//Returns the string to fire upon. 
		p.loadPlayerShot(coord);
	}

}
