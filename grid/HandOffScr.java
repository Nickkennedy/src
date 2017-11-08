import java.util.Scanner;


public class HandOffScr {
   
   
  public static void printScreenOne(Player p){
     ///Displays message for the next player that the previous has placed all of their ships. Waits for user to press "Enter" to continue 
     
     System.out.println("\n\n\n\n\n\n\t\t\t\t\t =================");
     System.out.println("\t\t\t\t\t NOSRC Battleships");
     System.out.println("\t\t\t\t\t =================");
     
     System.out.println("\n\t\t\t\t"+ p.getName() + "has placed all of their ships");
     System.out.println("\n\t\t\t\t      Press \"ENTER\" to continue...");
  }
  public static void printScreenTwo(Player p){
     ///Displays message for the next player that the previous has had their turn. Waits for user to press "Enter" to continue.
     
     System.out.println("\n\n\n\n\n\n\t\t\t\t\t=================");
     System.out.println("\t\t\t\t\tNOSRC Battleships");
     System.out.println("\t\t\t\t\t=================");
     
     System.out.println("\n\t\t\t\t" + p.getName() + "  has finished their turn");
     System.out.println("\n\t\t\t\t  Press \"ENTER\" to continue...");
  }
  public static void promptKey(){
   
  ///The method enables to the user to enter the "Enter" keyboard command.
     
  Scanner scanner = new Scanner(System.in);
  scanner.nextLine();
  scanner.close();     
  }
}
