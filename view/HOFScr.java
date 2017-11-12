package view;

import model.GameModel;
import model.GameRecord;

public class HOFScr 
{
   //constructor
   public HOFScr(GameModel m)
   {
      int i = 0;
      System.out.println("    ======================================");
      System.out.println("    |           Hall Of Fame             |");       
      System.out.println("    |                                    |");                                          
      System.out.println("    | rank winner ships shots/hit rating |");
      if(m.getHallOfFame().size()==0) {
      System.out.println("    |      you are the first players!    |");};          
      for(GameRecord r : m.getHallOfFame()) { 
      System.out.println("    |   "+(++i)+"   "+r.toString()+"  |");};        
      System.out.println("    ======================================");
      System.out.println("");}
}