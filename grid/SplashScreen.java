package grid;

//import Scanner
import java.util.Scanner;

//class declaration
public class SplashScreen {
	// constants
	public static String PROJECT;

	public static String TITLE;
	public static String COURSE;
	public static String STUDY_PERIOD;
	public static String YEAR;

	public static String WORD;
	public static String STUDENT_1;
	public static String STUDENT_1_NUMBER;
	public static String STUDENT_2;
	public static String STUDENT_2_NUMBER;
	public static String STUDENT_3;
	public static String STUDENT_3_NUMBER;
	public static String STUDENT_4;
	public static String STUDENT_4_NUMBER;

	// constructor
	public SplashScreen() {
		PROJECT = "NORSC - Battleships";
		TITLE = "Assignment 2";
		COURSE = "Building IT Systems (COSC 2635)";
		STUDY_PERIOD = "Study Period 3";
		YEAR = "2017";

		WORD = "by";
		STUDENT_1 = "Robert Bessell";
		STUDENT_1_NUMBER = "s3597881";
		STUDENT_2 = "Nicholas Kennedy";
		STUDENT_2_NUMBER = "s3674967";
		STUDENT_3 = "Christopher Musamba";
		STUDENT_3_NUMBER = "s3579863";
		STUDENT_4 = "Kevin Purnell";
		STUDENT_4_NUMBER = "s3611540";

	}

	// getters
	public static String getTitle() {
		return TITLE;
	}

	public static String getCourse() {
		return COURSE;
	}

	public static String getStudyPeriod() {
		return STUDY_PERIOD;
	}

	public static String getYear() {
		return YEAR;
	}

	public static String getProject() {
		return PROJECT;
	}

	public static String getWord() {
		return WORD;
	}

	public static String getName1() {
		return STUDENT_1;
	}

	public static String getSt1_Number() {
		return STUDENT_1_NUMBER;
	}

	public static String getName2() {
		return STUDENT_2;
	}

	public static String getSt2_Number() {
		return STUDENT_2_NUMBER;
	}

	public static String getName3() {
		return STUDENT_3;
	}

	public static String getSt3_Number() {
		return STUDENT_3_NUMBER;
	}

	public static String getName4() {
		return STUDENT_4;
	}

	public static String getSt4_Number() {
		return STUDENT_4_NUMBER;
	}

	// method that prints the screen output
	public static void displayScreen() {
		// print project name
		System.out.println("\t\t=====================================================");
		System.out.printf("\t\t\t\t%s\n", getProject());
		System.out.println("\t\t=====================================================");

		// print banner
		System.out.printf("\t\t\t\t    %s\n", getTitle());
		System.out.printf("\t\t\t  %s\n", getCourse());
		System.out.printf("\t\t\t\t%s, %s\n", getStudyPeriod(), getYear());

		// print student details and date
		System.out.printf("\n\t\t\t\t\t %s\n", getWord());
		System.out.printf("\t\t\t       %s, %s\n", getName1(), getSt1_Number());
		System.out.printf("\t\t\t     %s, %s\n", getName2(), getSt2_Number());
		System.out.printf("\t\t\t    %s, %s\n", getName3(), getSt3_Number());
		System.out.printf("\t\t\t       %s, %s\n", getName4(), getSt4_Number());
		System.out.println("\n\t\t=====================================================");

	}

	public static int validplayer(String s) {
		int i = Integer.parseInt(s);

		if (i == 1)
			return 1;
		else if (i == 2)
			return 2;
		else if (i == 3)
			return 3;
		else if (i == 4)
			return 4;
		else
			System.out.println("In valud entry. Try again:");
		return i;

	}

	// class declaration
	// instantiating objects
	static SplashScreen scrn = new SplashScreen();
	static Scanner input = new Scanner(System.in);

	// declaring variables
	static int intnumberplayer;
	static String numberOfPlayers;
	static String wrd = "Players";
	static String player_1;
	static String player_2;

	public void playername() {
		if (intnumberplayer == 2) {
			// prompt for player 2 alias
			System.out.print("\nEnter alias for player 1: ");
			main.p.p1name = input.nextLine();
			System.out.print("\nEnter alias for player 2: ");
			main.p.p2name = input.nextLine();
		}
		if (intnumberplayer == 3) {
			// prompt for player 3 alias
			System.out.print("\nEnter alias for player 1: ");
			main.p.p1name = input.nextLine();
			System.out.print("\nEnter alias for player 2: ");
			main.p.p2name = input.nextLine();
			System.out.print("\nEnter alias for player 3: ");
			main.p.p3name = input.nextLine();
		}
		if (intnumberplayer == 4) {
			// prompt for player 4 alias
			System.out.print("\nEnter alias for player 1: ");
			main.p.p1name = input.nextLine();
			System.out.print("\nEnter alias for player 2: ");
			main.p.p2name = input.nextLine();
			System.out.print("\nEnter alias for player 3: ");
			main.p.p3name = input.nextLine();
			System.out.print("\nEnter alias for player 4: ");
			main.p.p4name = input.nextLine();
		}
	}
}