package model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import model.GameEngine;
import model.GameModel;
import model.Player;

/**
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Project Title: Battleships
 * Purpose:       1)implements the GameModel interface
 *                2)models, stores and retrieves data
 *                3)handles multiple players
 *                4)handles game history
 * Package:       model 
 * Source:        own work 
 */
//copied from zip/
public class GameEngine implements GameModel
{
   //attributes
   private Map<Integer,Player> players = new TreeMap<Integer,Player>();
   private Map<Double,GameRecord> records = new TreeMap<Double,GameRecord>(Collections.reverseOrder());
   private int gameID = 1;
   private int playerID = 1;
   private boolean noGameHistory = false;
   
   //constructors
   public GameEngine()
   {
      readInGameHistory();
   }

   
   //Player housekeeping
   public void addPlayer(Player p){
      p.setPlayerID(playerID);
      players.put(playerID++,p);}
   
   public void deleteAllPlayers() {
      for(Player p : players.values()) {
         System.out.println("deleteAllPlayers: "+p.toString());
         players.remove(p.getPlayerID());}}
   
   public Player getPlayer(int key) {
      return players.get(key);}
   
   public Collection<Player> getAllPlayers(){
      return players.values();}
   
   
   //GameRecord housekeeping
   public void addGameStats(GameRecord r){
      records.put((r.getRating())+(gameID++/1000.0),r);}

   public Collection<GameRecord> getAllGameStats(){
      return records.values();};
   
   public Collection<GameRecord> getHallOfFame(){
      ArrayList<GameRecord> a = new ArrayList<GameRecord>();
      int count = 0;
      Set<Entry<Double, GameRecord>> set = records.entrySet();
      Iterator<Entry<Double, GameRecord>> it = set.iterator();
      while(it.hasNext() && count<5) {
         Entry<Double, GameRecord> me = it.next();
         a.add((GameRecord) me.getValue());
         count++;}
      return a;
   }
   
   public boolean detectEndGame() {
      //detect end of game here
      return true;
   };

   
   //Persistence
   public void readInGameHistory() {
//      System.out.println("readInGameHistory:");
      //read file, one 'GameRecord' object per record
      try(FileInputStream in = new FileInputStream(Paths.get(HISTORY_FILE).toFile())){
         ObjectInputStream ois = new ObjectInputStream(in);
         GameRecord record = null;
         while((record=(GameRecord)ois.readObject())!=null){
//            System.out.println("Reading from file: "+record.getWinner());
            this.addGameStats(record);}}
      catch(EOFException e) {return;} 
      catch(ClassNotFoundException e) {e.printStackTrace();}
      catch(FileNotFoundException e) {noGameHistory = true;}
      catch(IOException e) {e.printStackTrace();}
   }
   
   public void writeOutGameHistory() {
      //create (if does not exist) and write new file, one 'GameRecord' object per record
      try(FileOutputStream out = new FileOutputStream(Paths.get(HISTORY_FILE).toFile(),false)){
         ObjectOutputStream oos = new ObjectOutputStream(out);
         for(GameRecord record : records.values()) {
            oos.writeObject(record);}}
      catch(FileNotFoundException e) {e.printStackTrace();}
      catch(IOException e) {e.printStackTrace();}
   }
}
