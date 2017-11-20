package model;

import java.util.Collection;
/**
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Project Title: Battleships
 * Purpose:       1)Specifies the contract for writing and accessing data
 * Package:       model 
 * Source:        own work 
 */
//copied from zip/
public interface GameModel 
{
   //constants
   public static final int GRID_SIZE = 10;
   public static final String HISTORY_FILE = "C:\\tmp\\history.dat";

   //Player housekeeping
   public void addPlayer(Player p);
   public Player getPlayer(int key);
   public Collection<Player> getAllPlayers();
   public boolean detectEndGame();
   
   //GameRecord housekeeping
   public void addGameStats(GameRecord r);
   public Collection<GameRecord> getAllGameStats();
   public Collection<GameRecord> getHallOfFame();
   
   //Persistence
   public void readInGameHistory();
   public void writeOutGameHistory();
}
//