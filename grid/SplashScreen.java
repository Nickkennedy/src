package grid;

//import Scanner
import java.util.Scanner;

//class declaration
class SplashScreen {
	// constants
	private final String PROJECT;

	private final String TITLE;
	private final String COURSE;
	private final String STUDY_PERIOD;
	private final String YEAR;

	private final String WORD;
	private final String STUDENT_1;
	private final String STUDENT_1_NUMBER;
	private final String STUDENT_2;
	private final String STUDENT_2_NUMBER;
	private final String STUDENT_3;
	private final String STUDENT_3_NUMBER;
	private final String STUDENT_4;
	private final String STUDENT_4_NUMBER;

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
	public String getTitle() {
		return TITLE;
	}

	public String getCourse() {
		return COURSE;
	}

	public String getStudyPeriod() {
		return STUDY_PERIOD;
	}

	public String getYear() {
		return YEAR;
	}

	public String getProject() {
		return PROJECT;
	}

	public String getWord() {
		return WORD;
	}

	public String getName1() {
		return STUDENT_1;
	}

	public String getSt1_Number() {
		return STUDENT_1_NUMBER;
	}

	public String getName2() {
		return STUDENT_2;
	}

	public String getSt2_Number() {
		return STUDENT_2_NUMBER;
	}

	public String getName3() {
		return STUDENT_3;
	}

	public String getSt3_Number() {
		return STUDENT_3_NUMBER;
	}

	public String getName4() {
		return STUDENT_4;
	}

	public String getSt4_Number() {
		return STUDENT_4_NUMBER;
	}

	// method that prints the screen output
	public void displayScreen() {
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
}

// class declaration
public class SplashScreenDemo {
	// instantiating objects
	static SplashScreen scrn = new SplashScreen();
	static Scanner input = new Scanner(System.in);

	// declaring variables
	static int numberOfPlayers;
	static String wrd = "Players";
	static String player_1;
	static String player_2;

	// main method
	public static void main(String[] args) {
		// call to displayScreen()
		scrn.displayScreen();

		System.out.println("\n\n\n\n\n\n\n\n\n\n\t\t\t\t\t" + wrd);

		// prompt for number of players
		System.out.print("Enter number of players (up to 2): ");
		numberOfPlayers = input.nextInt();
		// consume trailing new line
		input.nextLine();

		// prompt for player 1 alias
		System.out.print("\nEnter alias for player 1: ");
		player_1 = input.nextLine();
	}

}