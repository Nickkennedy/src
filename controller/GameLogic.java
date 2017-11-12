package controller;
import model.GameEngine;
import model.GameModel;
import model.GameRecord;
import model.Player;
import view.ScrDriver;
import view.UI;

public class GameLogic 
{
   //attributes
   private GameModel data;
   private UI ui;
   private PlayMode playMode = PlayMode.STANDARD;
   private int playerCount=2;
   private Boolean win=false, hit=false, blocked=false, exit=false;
   private int enemyID = 2;
   private Player player = null, enemy = null, winner = null;
   String coords = "";
   
   //contructor -main game logic
   public GameLogic(){
      //create game
      ui = new ScrDriver();
      data = new GameEngine();
      
      //play standard mode
      do {
         //splash screen
         ui.dspSplashScr(data);
         processGameConfigInput();
            
         //place ships
         for(int i=1; i<=playerCount; i++){
            if(i==1) enemy = null; else enemy = data.getPlayer(1);
            ui.dspHandoffScr(enemy, data.getPlayer(i));
            do {
               ui.dspPlaceScr(data.getPlayer(i));
               blocked = processPlaceInput(data.getPlayer(i));
               System.out.println("after processPlaceInput:" + blocked);
            } while(blocked);
         }
            
         //play game
         do {
            for(int i=1; i<=playerCount; i++){
               if(i==1) enemyID=2; else enemyID=1;
               ui.dspHandoffScr(data.getPlayer(enemyID), data.getPlayer(i));
               ui.dspPlayScr(data.getPlayer(i));
               processPlayInput();                
               data.getPlayer(enemyID).isShipPresent(coords,0,0);
               data.getPlayer(i).loadPlayerShot(coords);
               ui.dspShot();
               if(win = data.detectEndGame()) {winner = data.getPlayer(i);}
            }
         } while(!win);
            
         //display winner, ask if another game, record game stats
         exit = ui.dspWinScr(winner,data);
         data.addGameStats(new GameRecord("jill",1,36,8));
         
      } while(!exit);
      //write out game stats to file   
      data.writeOutGameHistory();
   }
   

   
   //helpers
   private void processGameConfigInput(){
      playerCount = ui.getPlayerCount();
      String[] aliases = ui.getPlayerAliases();
      String playerName = aliases[0];
      String enemyName = aliases[1];
      player = new Player("Fred");                       //test data
      enemy = new Player("Freda");                       //test data
      data.addPlayer(player);                            //test data
      data.addPlayer(enemy);                             //test data
      playerCount = 2;}                                  //test data
      
   
   private boolean processPlaceInput(Player p) {
      System.out.println("processPlaceInput:" + p.getPlayerAlias());
      coords = ui.getPlaceCoords();
      System.out.println("place coords: "+coords);
      p.isShipPresent(coords,0,0);
      return false;
   }
   
   private void processPlayInput(){
      System.out.println("processPlayInput:");
      coords = ui.getPlaceCoords();
      coords = "C5";
      enemy.isShipPresent(coords,0,0);
      player.loadPlayerShot(coords);
   }
   
   //load test data
   private void loadTestData(){
      data.addGameStats(new GameRecord("jack",1,32,5));  //test data
      data.addGameStats(new GameRecord("freda",3,21,5)); //test data
      data.addGameStats(new GameRecord("josh",2,25,5));  //test data
      data.addGameStats(new GameRecord("fred",3,20,5));  //test data
      data.addGameStats(new GameRecord("chuck",1,30,5)); //test data
      data.addGameStats(new GameRecord("mary",2,21,5));  //test data
      data.addGameStats(new GameRecord("john",2,25,5));  //test data
      data.addGameStats(new GameRecord("joel",3,20,5));  //test data
      for(GameRecord r : data.getAllGameStats()) {
         System.out.println("All Games: "+r.toString());}
      for(GameRecord r : data.getHallOfFame()) {
         System.out.println("HOF: "+r.toString());}
   }
}