package view;

   import java.util.Scanner;

   import model.DirectionType;
   import model.GameModel;
   import model.Player;
   import model.ShipType;
   import view.UI;
 //copied from zip/
   public class GUIDriver implements UI
   {
      //attributes
      Scanner s = new Scanner(System.in);
      private SplashGUI ss;
      private PlaceGUI ps;
      private PlayGUI plays;
      private HandoffGUI hs;
      private WinGUI ws;
      
      //constructor.
      public GUIDriver(){}
      
      //Splash Screen
      public void dspSplashScr(GameModel m){
         ss = new SplashGUI(s, m);}
      public int getPlayerCount() {
         return ss.getCount();} 
      public String[] getPlayerAliases(){
         return ss.getAliases();}   

      //Place Screen   
      public void dspPlaceScr(Player p){
         do{
            ps = new PlaceGUI(s,p);
         } while(ps.remainingShips());} 
      public String getPlaceCoords(Player p){
         return ps.getPlaceCoords(p);}
      public ShipType getShipType(){
         return ps.getShipType();}
      public DirectionType getDirection(){
         return ps.getDirection();}
      
      //Play Screen   
      public void dspPlayScr(Player p){
         plays = new PlayGUI(s,p);}
      public String getShotCoords(Player p){
         return plays.getShotCoords(p);}
      public void dspShot(){}
      
      //Handoff Screen   
      public void dspHandoffScr(Player last, Player current){
         hs = new HandoffGUI(s,last,current);}
      
      //Win Screen   
      public boolean dspWinScr(Player p, GameModel m){
         ws = new WinGUI(s,p,m);
         return true;}
 }
   //