package view;

import java.util.Scanner;

import controller.PlayMode;
import model.DirectionType;
import model.GameModel;
import model.Player;
import model.ShipType;
import view.UI;

/***
 * @author Kevin Purnell s3611540 & Nicholas Kennedy s3674937
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Project Title: Battleships
 * Purpose:       1)implements the UI interface as GUI
 *                2)controls screen display
 *                3)pulls user input from screens
 * Package:       view 
 * Source:        own work 
 */
   public class GUIDriver implements UI
   {
      //attributes
      Scanner s = new Scanner(System.in);
      private SplashGUI ss;
      private PlaceGUI ps;
      private PlayGUI plays;
      private GridScr grid;
      private HandoffGUI hs;
      private WinGUI ws;
      
      //constructor.
      public GUIDriver(){
         grid = new GridScr();
      }
      
      //Splash Screen
      public void dspSplashScr(GameModel m){
         ss = new SplashGUI(s, m);}
      public int getPlayerCount() {
         return ss.getCount();}
      public PlayMode getPlayMode() {
         return ss.getMode();
      }
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
      public void dspPlayScr(Player e, Player p){
         plays = new PlayGUI(s,p);}
      public String getShotCoords(Player p){
         return plays.getShotCoords(p);}
      public void dspShot(){}
      
      //Handoff Screen   
      public void dspHandoffScr(Player last, Player current, String placeorplay){
         hs = new HandoffGUI(s,last,current);}
      
      //Win Screen   
      public boolean dspWinScr(Player p, GameModel m){
         ws = new WinGUI(s,p,m);
         return true;}
 }