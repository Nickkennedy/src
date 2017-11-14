package view;
import model.GameModel;
import model.GameRecord;
/**
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Purpose:       Display the "Hall-of-Fame" sub-screen
 * Location:      Model 
 * Source:        own work
 */
public class HOFGUI 
{
   //constructor
   public HOFGUI(GameModel m)
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