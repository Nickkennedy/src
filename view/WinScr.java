package view;

import java.util.Scanner;

import model.GameModel;
import model.Player;
import view.HOFScr;

public class WinScr 
{   
   //constructor.
   public WinScr(Scanner s, Player p, GameModel m){
      System.out.println("\n          "+p.getPlayerAlias()+" has Won the game!");
      new HOFScr(m);
      //get input here
      }
}