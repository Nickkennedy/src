package model;

import java.util.Collection;

public interface GameModel 
{
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