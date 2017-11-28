package view;

import java.util.Scanner;
import controller.PlayMode;
import model.GameModel;
import view.HOFScr;

/***
 * @author Christopher Musamba
 * with help
 */
//copied from zip/
public class SplashScr 
{
   // constants
   private static final String PROJECT = "NORSC - Battleships";
   private static final String TITLE = "Assignment 3";
   private static final String COURSE = "Building IT Systems (COSC 2635)";
   private static final String STUDY_PERIOD = "Study Period 3";
   private static final String YEAR = "2017";
   private static final String WORD = "by";
   private static final String STUDENT_1 = "Robert Bessell";
   private static final String STUDENT_1_NUMBER = "s3597881";
   private static final String STUDENT_2 = "Nicholas Kennedy";
   private static final String STUDENT_2_NUMBER = "s3674967";
   private static final String STUDENT_3 = "Christopher Musamba";
   private static final String STUDENT_3_NUMBER = "s3579863";
   private static final String STUDENT_4 = "Kevin Purnell";
   private static final String STUDENT_4_NUMBER = "s3611540";
   
   //attributes
   private int numberOfPlayers;
   private PlayMode playMode;
   private String[] aliases = {"","","",""};
   
   //constructor
   public SplashScr(Scanner s, GameModel m)
   {
      //display splash screen
      displayScreen();
      new HOFScr(m);
      
      //get game configuration and player names
      numberOfPlayers = inputNumberOfPlayers(s);
      playMode = inputPlayMode(s);
      for(int i=0; i<numberOfPlayers; i++) {
         aliases[i] = inputPlayerName(s,i);}
   }
   
   
   
   
   //getters
   public int getCount() {
      return numberOfPlayers;}
   
   public PlayMode getMode() {
      return playMode;}
   
   public String[] getAliases() {
      return aliases;}

   //helpers
   public static int inputNumberOfPlayers(Scanner input) {
      int i = -99;
      System.out.print("Enter number of players: (only '2' or '4' allowed) ");
      do {
         if(i != -99) System.out.print("Only 2 players (Core Feature) or 4 players (Extended Feature 'Teams') implemented. Try again: ");
         try {
            i = Integer.parseInt(input.nextLine());}
         catch(Exception e) {
            i = -98;}
      } while(i!=2 && i!=4);
      System.out.println("");
      return i;}
   
   public static PlayMode inputPlayMode(Scanner input) {
      String pm = null;
      System.out.print("Enter play mode: (S)tandard, S(K)irmish, (T)eam ");
      do {
         if(pm != null) System.out.print("Only S and T implemented. Try again: ");
         pm = input.nextLine().toUpperCase();
      } while(!(pm.length()==1 && (pm.equals("S")||(pm.equals("T")))));
      System.out.println("");
      switch(pm){
         case "S": return PlayMode.STANDARD;
         case "K": return PlayMode.STANDARD;
         case "T": return PlayMode.TEAM; 
         default:  return PlayMode.STANDARD;}}

   public static String inputPlayerName(Scanner input, int i) {
         System.out.print("Enter alias for player " + (i + 1) + ": ");
         String name = input.nextLine();
         return name;}
   
   public static void displayScreen() {
      // print project name
      System.out.println("\n\n\n");
      System.out.println("\t\t=====================================================");
      System.out.printf("\t\t\t\t%s\n", PROJECT);
      System.out.println("\t\t=====================================================");

      // print banner
      System.out.printf("\t\t\t\t    %s\n", TITLE);
      System.out.printf("\t\t\t  %s\n", COURSE);
      System.out.printf("\t\t\t\t%s, %s\n", STUDY_PERIOD, YEAR);

      // print student details and date
      System.out.printf("\n\t\t\t\t\t %s\n", WORD);
      System.out.printf("\t\t\t       %s, %s\n", STUDENT_1, STUDENT_1_NUMBER);
      System.out.printf("\t\t\t     %s, %s\n", STUDENT_2, STUDENT_2_NUMBER);
      System.out.printf("\t\t\t    %s, %s\n", STUDENT_3, STUDENT_3_NUMBER);
      System.out.printf("\t\t\t       %s, %s\n", STUDENT_4, STUDENT_4_NUMBER);
      System.out.println("\n\t\t=====================================================");
   }
}
//
