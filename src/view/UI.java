package view;

import model.GameModel;
import model.Player;

/***
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Project Title: Battleships
 * Purpose:       1)Specifies the contract for writing and reading screens
 * Package:       view 
 * Source:        own work 
 */
public interface UI 
{
   //Constants.
   public static final int SCR_SIZE = 20;

   //Splash Screen
   public void dspSplashScr(GameModel m);
   public int getPlayerCount();
   public String[] getPlayerAliases();
   
   //Place Screen
   public void dspPlaceScr(Player p);
   
   //Play Screen
   public void dspPlayScr(Player e, Player p);
   
   //Handoff Screen
   public void dspHandoffScr(Player l, Player p, String placeorplay);
   
   //Win Screen
   public boolean dspWinScr(Player p, GameModel m);
}