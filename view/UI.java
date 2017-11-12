package view;

import model.DirectionType;
import model.GameModel;
import model.Player;
import model.ShipType;

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
   public String getPlaceCoords();
   public ShipType getShipType();
   public DirectionType getDirection();
   
   //Play Screen
   public void dspPlayScr(Player p);
   public void dspShot();
   public String getShotCoords();
   
   //Handoff Screen
   public void dspHandoffScr(Player l, Player p);
   
   //Win Screen
   public boolean dspWinScr(Player p, GameModel m);
}