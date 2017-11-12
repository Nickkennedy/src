package grid;

import java.awt.*;
import java.util.Scanner;

public class main {

	static SplashScreen scrn = new SplashScreen();
	static Scanner input = new Scanner(System.in);
	public static Player p = new Player();

	// Sets the starting value of " " for all items in the array
	public static void main(String[] args) {
		SplashScreen.displayScreen();
		// prompt for number of players
		System.out.print("Enter number of players (up to 4): ");
		SplashScreen.numberOfPlayers = input.next();

		// consume trailing new line
		input.nextLine();
		SplashScreen.intnumberplayer = SplashScreen.validplayer(SplashScreen.numberOfPlayers);

		if (SplashScreen.intnumberplayer == 1) {
			// prompt for player 1 alias
			System.out.print("\nEnter alias for player 1: ");
			p.p1name = input.nextLine();
		}

		if (SplashScreen.intnumberplayer == 2) {
			// prompt for player 2 alias
			System.out.print("\nEnter alias for player 1: ");
			p.p1name = input.nextLine();
			System.out.print("\nEnter alias for player 2: ");
			p.p2name = input.nextLine();
		}
		
		if (SplashScreen.intnumberplayer == 3) {
			// prompt for player 3 alias
			System.out.print("\nEnter alias for player 1: ");
			p.p1name = input.nextLine();
			System.out.print("\nEnter alias for player 2: ");
			p.p2name = input.nextLine();
			System.out.print("\nEnter alias for player 3: ");
			p.p3name = input.nextLine();
		}
		
		if (SplashScreen.intnumberplayer == 4) {
			// prompt for player 4 alias
			System.out.print("\nEnter alias for player 1: ");
			p.p1name = input.nextLine();
			System.out.print("\nEnter alias for player 2: ");
			p.p2name = input.nextLine();
			System.out.print("\nEnter alias for player 3: ");
			p.p3name = input.nextLine();
			System.out.print("\nEnter alias for player 4: ");
			p.p4name = input.nextLine();
		}

		if (SplashScreen.intnumberplayer == 1) {
			grid.startvalue(grid.p1shipsarray);
			grid.startvalue(grid.p1shotsarray);
			grid.startvalue(grid.p2shipsarray);
			grid.startvalue(grid.p2shotsarray);
			// Endless loop of happiness :)
			for (int i = 0; i < 5; i++) {
				if (grid.currentplayer == 1) {
					grid.printships();
					grid.currentplayer = 1;
					i = 0; // Creates never ending loop
				} else if (grid.currentplayer == 2) {
					AI.aifire();
					grid.currentplayer = 1;
					i = 0; // Creates never ending loop
				}
			}

		}

		if (SplashScreen.intnumberplayer == 2) {
			grid.startvalue(grid.p1shipsarray);
			grid.startvalue(grid.p1shotsarray);
			grid.startvalue(grid.p2shipsarray);
			grid.startvalue(grid.p2shotsarray);
			// Endless loop of happiness :)
			for (int i = 0; i < 5; i++) {
				if (grid.currentplayer == 1) {
					grid.printships();
					grid.currentplayer = 2;
					i = 0; // Creates never ending loop
				} if (grid.currentplayer == 2) {
					grid.printships();
					grid.currentplayer = 1;
					i = 0; // Creates never ending loop
				}
			}
		}

		if (SplashScreen.intnumberplayer == 3) {
			grid.startvalue(grid.p1shipsarray);
			grid.startvalue(grid.p1shotsarray);
			grid.startvalue(grid.p2shipsarray);
			grid.startvalue(grid.p2shotsarray);
			grid.startvalue(grid.p3shipsarray);
			grid.startvalue(grid.p3shotsarray);
			// Endless loop of happiness :)
			for (int i = 0; i < 5; i++) {
				if (grid.currentplayer == 1) {
					grid.printships();
					grid.currentplayer = 2;
					i = 0; // Creates never ending loop
				} if (grid.currentplayer == 2) {
					grid.printships();
					grid.currentplayer = 3;
					i = 0; // Creates never ending loop
				} if (grid.currentplayer == 3) {
					grid.printships();
					grid.currentplayer = 1;
					i = 0; // Creates never ending loop
				}
			}
		}

		if (SplashScreen.intnumberplayer == 4) {
			grid.startvalue(grid.p1shipsarray);
			grid.startvalue(grid.p1shotsarray);
			grid.startvalue(grid.p2shipsarray);
			grid.startvalue(grid.p2shotsarray);
			grid.startvalue(grid.p3shipsarray);
			grid.startvalue(grid.p3shotsarray);
			grid.startvalue(grid.p4shipsarray);
			grid.startvalue(grid.p4shotsarray);
			// Endless loop of happiness :)
			for (int i = 0; i < 5; i++) {
				if (grid.currentplayer == 1) {
					grid.printships();
					grid.currentplayer = 2;
					i = 0; // Creates never ending loop
				} if (grid.currentplayer == 2) {
					grid.printships();
					grid.currentplayer = 3;
					i = 0; // Creates never ending loop
				} if (grid.currentplayer == 3) {
					grid.printships();
					grid.currentplayer = 4;
					i = 0; // Creates never ending loop
				} if (grid.currentplayer == 4) {
					grid.printships();
					grid.currentplayer = 1;
					i = 0; // Creates never ending loop
				}
			}
		}
	}
}
