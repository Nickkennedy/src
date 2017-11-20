/*package view;

import java.util.Scanner;
import model.Player;

public class HandoffScr 
{
   //constructor.
   public HandoffScr(Scanner s, Player last, Player curr){
      //display screen
      System.out.println("\nHandoff Screen");
      //get keyboard input
   }
}
*/
/*package view;

import java.util.Scanner;
import model.Player;


public class HandoffScr {
   
   
  public static void printScreenOne(Player p){
     ///Displays message for the next player that the previous has placed all of their ships. Waits for user to press "Enter" to continue 
     
     System.out.println("\n\n\n\n\n\n\t\t\t\t\t =================");
     System.out.println("\t\t\t\t\t NOSRC Battleships");
     System.out.println("\t\t\t\t\t =================");
     
     System.out.println("\n\t\t\t\t"+ p.getPlayerAlias() + "has placed all of their ships");
     System.out.println("\n\t\t\t\t      Press \"ENTER\" to continue...");
  }
  public static void printScreenTwo(Player p){
     ///Displays message for the next player that the previous has had their turn. Waits for user to press "Enter" to continue.
     
     System.out.println("\n\n\n\n\n\n\t\t\t\t\t=================");
     System.out.println("\t\t\t\t\tNOSRC Battleships");
     System.out.println("\t\t\t\t\t=================");
     
     System.out.println("\n\t\t\t\t" + p.getPlayerAlias() + "  has finished their turn");
     System.out.println("\n\t\t\t\t  Press \"ENTER\" to continue...");
  }
  public static void promptKey(){
   
  ///The method enables to the user to enter the "Enter" keyboard command.
     
  Scanner scanner = new Scanner(System.in);
  scanner.nextLine();
  scanner.close();     
  }
}
*/
package view;

import java.util.Scanner;
import model.Player;
//copied from zip/
public class HandoffScr { 
   
public HandoffScr(Scanner s, Player last, Player current){
     ///Displays message for the next player that the previous has placed all of their ships. Waits for user to press "Enter" to continue 
     if(last==null) return;
     for(int count=0; count<10;count++) { 
    	 System.out.println("\n"); 
     }
     
     System.out.println("\n\n\n\n\n\n\t\t\t\t\t =================");
     System.out.println("\t\t\t\t\t NOSRC Battleships");
     System.out.println("\t\t\t\t\t =================");
     
     System.out.println("\n\t\t\t\t"+ last.getPlayerAlias() + " has finished his/her turn...");
     System.out.println("\n\t\t\t\t"+ current.getPlayerAlias() + ", Press \"ENTER\" to continue...");
    
     for(int count=0; count<5;count++) { 
    	 System.out.println("\n"); 
     }
     
     s.nextLine();
  }
}
//