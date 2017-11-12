package view;

import java.util.Scanner;

import model.DirectionType;
import model.GameModel;
import model.Player;
import model.ShipType;
import view.HandoffScr;
import view.PlaceScr;
import view.PlayScr;
import view.SplashScr;
import view.WinScr;
import view.UI;

public class ScrDriver implements UI
{
   //attributes
   Scanner s = new Scanner(System.in);
   private SplashScr ss;
   private PlaceScr ps;
   private PlayScr plays;
   private HandoffScr hs;
   private WinScr ws;
   
   //constructor
   public ScrDriver(){}
   
   //Splash Screen
   public void dspSplashScr(GameModel m){
      ss = new SplashScr(s, m);}
   public int getPlayerCount() {
      return ss.getCount();} 
   public String[] getPlayerAliases(){
      return ss.getAliases();}   

   //Place Screen   
   public void dspPlaceScr(Player p){
      ps = new PlaceScr(s,p);}
   public String getPlaceCoords(){
      return ps.getPlaceCoords();}
   public ShipType getShipType(){
      return ps.getShipType();}
   public DirectionType getDirection(){
      return ps.getDirection();}
   
   //Play Screen   
   public void dspPlayScr(Player p){
      plays = new PlayScr(s,p);}
   public String getShotCoords(){
      return plays.getShotCoords();}
   public void dspShot(){}
   
   //Handoff Screen   
   public void dspHandoffScr(Player l, Player p){
      hs = new HandoffScr(s,l,p);}
   
   //Win Screen   
   public void dspWinScr(Player p, GameModel m){
      ws = new WinScr(s,p,m);}
}