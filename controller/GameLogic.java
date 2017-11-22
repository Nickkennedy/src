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
   private Boolean exit=false;
   private Player w = null;
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
         //reset the game
         resetGame();
         
         //display splash screen & get game configuration from the players
         ui.dspSplashScr(data);
         processGameConfigInput();
            
         //each player places ships here
         for(int i=1; i<=playerCount; i++){
            if(i!=1) ui.dspHandoffScr(data.getPlayer(1), data.getPlayer(i),"place");
            ui.dspPlaceScr(data.getPlayer(i));}

         //handoff to play section 
         ui.dspHandoffScr(data.getPlayer(2), data.getPlayer(1),"place");
         
         //play the game using the selected 'Play Mode'
         playMode = PlayMode.STANDARD;
         switch(playMode){
            case STANDARD:  playStandardMode(); break;
            case AI:        playAIMode();       break;
            case SKIRMISH3: playSkirmish3Mode();break;
            case SKIRMISH4: playSkirmish4Mode();break;
            case TEAM:      playTeamMode();     break;    
            default: System.out.println("Unknown Play Mode!");}   
                     
         //record game stats in memory & disk; display winner; ask if another game
         data.addGameStats(new GameRecord(w.getPlayerAlias(),w.getShipsLeft(),w.getShotCount(),w.getHitCount()));  
         data.writeOutGameHistory();
         exit = ui.dspWinScr(w,data);
      } while(!exit);
   }

   
   
   
   //play mode helper methods
   private void playStandardMode() {
      boolean first = true, win = false;
      do {           //first player
//         System.out.println("GameLogic: playStandardMode: first="+first+" win="+win);
         if(!first) ui.dspHandoffScr(data.getPlayer(2), data.getPlayer(1),"play");
         first=false;
         ui.dspPlayScr(data.getPlayer(2), data.getPlayer(1));
//         System.out.println("GameLogic: after player 1: win="+win);
         if(!data.getPlayer(2).anyShipsLeft()){
            win=true; w = data.getPlayer(1);
//            System.out.println("GameLogic: after player 1 win eval: win="+win);
            }
         else {      //second player
            ui.dspHandoffScr(data.getPlayer(1), data.getPlayer(2),"play");
            ui.dspPlayScr(data.getPlayer(1), data.getPlayer(2));
//            System.out.println("GameLogic: after player 2: win="+win);
            if(!data.getPlayer(1).anyShipsLeft()){
               win=true; w = data.getPlayer(2);
//               System.out.println("GameLogic: after player 2 win eval: win="+win);
         }  }
      } while(!win);}

   private void playAIMode() {}

   private void playSkirmish3Mode() {}

   private void playSkirmish4Mode() {}

   private void playTeamMode() {}

   
   //helpers
   private void processGameConfigInput(){
      playerCount = ui.getPlayerCount();
      String[] aliases = ui.getPlayerAliases();
      data.addPlayer(new Player(aliases[0]));
      data.addPlayer(new Player(aliases[1]));
      playerCount = 2;}                          //'Core Features' default

   //clean out last games's players and reset state variables
   private void resetGame() {
      data.deleteAllPlayers();
      data.resetPlayerID();
      exit=false;
      w = null;
      coords = "";}
      
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