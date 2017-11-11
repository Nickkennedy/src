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
   public int playerCount;
   private Boolean win=false, end=false;
   Player tmp;                                   //test data
   
   //contructor -main game logic
   public GameLogic(){
      //create game
      ui = new ScrDriver();
      data = new GameEngine();
//these two lines create the history file on disk. comment out once file is created
//      loadTestData();
//      data.writeOutGameHistory();
      
      //play standard mode
      do {
         do {
            displayWelcome();
            placeShips();
            win = play();
         } while(!win);
         displayWin(tmp);
         end = true;
      } while(!end);
      data.addGameStats(new GameRecord("jill",1,36,8));
      data.writeOutGameHistory();}
   

   
   //screen driver methods
   private void displayWelcome(){
      ui.dspSplashScr(data);
      playerCount = ui.getPlayerCount();
      String[] aliases = ui.getPlayerAliases();
      tmp = new Player("Fred");                          //test data
      data.addPlayer(tmp);                               //test data
      data.addPlayer(new Player("Freda"));}              //test data
   
   private void placeShips(){
      Player enemy = null;
      for(Player player : data.getAllPlayers()){   //for each player
         ui.dspHandoffScr(enemy, player);          //hand off to this player
         ui.dspPlaceScr(player);}}                 //display 'place' screen & place ships
   
   private boolean play() {
      Player enemy = null;
      String shotCoords = "";
      for(Player player : data.getAllPlayers()){
         ui.dspHandoffScr(enemy, player);
         enemy = player;
         ui.dspPlayScr(player);
         shotCoords = ui.getShotCoords();
         shotCoords = "C5";                              //test data
         player.loadPlayerShot(shotCoords);
         //detect if ship present
         enemy.isShipPresent(shotCoords,0,0);
         //if present change enemy grid
         //display shot on both my and enemy grids
      }
      return true;
   }
   
   private void displayWin(Player p) {
      ui.dspWinScr(p,data);}
   
   //helper
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