package controller;
import model.GameEngine;
import model.GameModel;
import model.GameRecord;
import model.Player;
import view.ScrDriver;
import view.UI;

/**
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Project Title: Battleships
 * Purpose:       1)handles game play logic
 *                2)handles different playing modes
 * Package:       controller
 * Source:        own work 
 */
//copied from zip/
public class GameLogic 
{
   //attributes
   private GameModel data;
   private UI ui;
   private PlayMode playMode = PlayMode.STANDARD;
   private int playerCount=2;
   private Boolean win=false, exit=false;
   private Player player = null, enemy = null, winner = null;
   String coords = "";

   
   //contructor -main game logic
   public GameLogic()
   {
      //create game 
      ui = new ScrDriver();
//      ui = new GUIDriver();    //uncomment to get GUI screens
      data = new GameEngine();   //uncomment to get char screens

      //play game
      do {
         //display splash screen & get game configuration from the players
         ui.dspSplashScr(data);
         processGameConfigInput();
            
         //each player place their ships
//         System.out.println("before placing ships: no players="+playerCount);
         for(int i=1; i<=playerCount; i++){
            if(i!=1) ui.dspHandoffScr(data.getPlayer(1), data.getPlayer(i));
            ui.dspPlaceScr(data.getPlayer(i));}
//         System.out.println("after placing ships: ");
            
         //play the game using the selected 'Play Mode'
         playMode = PlayMode.STANDARD;
         switch(playMode){
            case STANDARD:  playStandardMode(); break;
            case AI:        playAIMode();       break;
            case SKIRMISH3: playSkirmish3Mode();break;
            case SKIRMISH4: playSkirmish4Mode();break;
            case TEAM:      playTeamMode();     break;    
            default: System.out.println("Unknown Play Mode!");}   
                     
         //display winner, ask if another game, record game stats
         exit = ui.dspWinScr(winner,data);
         data.addGameStats(new GameRecord(winner.getPlayerAlias(),winner.getShipsLeft(),
               winner.getShotCount(),winner.getHitCount()));
         
      } while(!exit);
      //write out game stats to file   
      data.writeOutGameHistory();
   }

   
   
   
   //play mode helper methods
   private void playStandardMode() {
      System.out.println("GameLogic: playStandardMode: ");
      do {
         for(int i=1; i<=playerCount; i++){
            if(i==1) {
               ui.dspHandoffScr(data.getPlayer(2), data.getPlayer(i));
               ui.dspPlayScr   (data.getPlayer(2), data.getPlayer(i));
               if(data.getPlayer(2).getShipsLeft()==0) win=true;}
            else {
               ui.dspHandoffScr(data.getPlayer(1), data.getPlayer(i));
               ui.dspPlayScr   (data.getPlayer(1), data.getPlayer(i));
               if(data.getPlayer(1).getShipsLeft()==0) win=true;}
            if(win) winner = data.getPlayer(i);
         }
      } while(!win); }

   private void playAIMode() {}

   private void playSkirmish3Mode() {}

   private void playSkirmish4Mode() {}

   private void playTeamMode() {}

   
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
//