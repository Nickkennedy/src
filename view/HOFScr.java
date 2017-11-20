package view;

import model.GameModel;
import model.GameRecord;
/**
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Project Title: Battleships
 * Purpose:       1)display the "Hall-of-Fame" sub-screen
 * Package:       view 
 * Source:        own work
 */
//copied from zip/
public class HOFScr 
{
   //constructor
   public HOFScr(GameModel m)
   {
      int i = 0;
      System.out.println("\t\t\t======================================");
      System.out.println("\t\t\t|           Hall Of Fame             |");       
      System.out.println("\t\t\t|                                    |");                                          
      System.out.println("\t\t\t| rank winner ships shots/hit rating |");
      if(m.getHallOfFame().size()==0) {
      System.out.println("\t\t\t|      you are the first players!    |");};          
      for(GameRecord r : m.getHallOfFame()) { 
      System.out.println("\t\t\t|   "+(++i)+"   "+r.toString()+"  |");};        
      System.out.println("\t\t\t======================================");
      System.out.println("");}
}
//