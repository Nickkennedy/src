package view;

import model.GameModel;
import model.GameRecord;

public class HOFScr 
{ 
   public HOFScr(GameModel m)
   {
      int i = 0;
      System.out.println("    ======================================");
      System.out.println("    |           Hall Of Fame             |");       
      System.out.println("    |                                    |");                                          
      System.out.println("    | rank winner ships shots/hit rating |");
      for(GameRecord r : m.getHallOfFame()) { 
      System.out.println("    |   "+(++i)+"   "+r.toString()+"  |");};        
      System.out.println("    ======================================");
      System.out.println("");}
}