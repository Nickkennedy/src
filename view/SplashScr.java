package view;

import java.util.Scanner;

import model.GameModel;
import model.Player;
import view.HOFScr;

public class SplashScr 
{
   //attributes
   Scanner s;
   private int playerCount = 0;
   private String[] aliases = {"","","",""};
   private String alias ="";
   
   //constructor
   public SplashScr(Scanner s, GameModel m){
      //display splash screen here
      System.out.println("\nSplash Screen");
      new HOFScr(m);
      //get input here
   } 
   
   //getters
   public int getCount() {
      return playerCount;} 
   
   public String[] getAliases() {
      return aliases;}
   
  }