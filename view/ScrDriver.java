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
import view.UI;
import view.WinScr;

/***
 * @author Kevin Purnell s3611540 & Nicholas Kennedy s3674937
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Project Title: Battleships
 * Purpose:       1)implements the UI interface
 *                2)controls screen display
 *                3)pulls user input from screens
 * Package:       view 
 * Source:        own work 
 */
public class ScrDriver implements UI {
   
	// attributes
	Scanner s = new Scanner(System.in);
	private SplashScr ss;
	private PlaceScr ps;
	private PlayScr plays;
	private GridScr grid;
	private WinScr ws;

	//constructor creates resources
	public ScrDriver() {
	   grid = new GridScr();	}

	//METHODS
	// Splash Screen
	public void dspSplashScr(GameModel m) {
		ss = new SplashScr(s, m);}

	public int getPlayerCount() {
		return ss.getCount();	}

	public String[] getPlayerAliases() {
		return ss.getAliases();}

	
	// Place Screen
	public void dspPlaceScr(Player p) {
	   //will keep presenting a request to place a ship until the ship fits
		ps = new PlaceScr();
		String coords = "";
		DirectionType direction = null;
		boolean fits = false;
		while (ps.remainingShips() == true){
		   do {
		      coords = ps.getPlaceCoords(s, grid, p);
		      direction = PlaceScr.validgetDirection(ps.getDirection(s));
		      fits = p.willShipFit(coords, PlaceScr.tempship, direction);
		      if(!fits){
		         PlaceScr.shipdoesntfit=true;
		         PlaceScr.shiptype--;}
		      else{
		         p.loadPlayerShip(coords,PlaceScr.tempship,direction);}
		   } while(!fits);
			if(PlaceScr.tempship == ShipType.CARRIER)
				grid.display(p);
		}
	}

	
	// Play Screen
	public void dspPlayScr(Player e, Player p) {
	   //will keep asking a player to shoot until that player misses or somwone looses all ships
	   boolean hit=false, stillHasShips=true;
		plays = new PlayScr();
		do {
		   String coords = plays.getShotCoords(s, grid, p);
		   hit = e.loadPlayerShot(false,true,coords); //load shot against the enemy
		   p.loadPlayerShot(hit, false, coords);      //load shot on own shot grid
		   stillHasShips = e.anyShipsLeft();          //does the enemy still have ships after our onslaught?
		} while(hit && stillHasShips);
		grid.display(p);
	 }

	
	// Handoff Screen
	public void dspHandoffScr(Player last, Player current, String placeorplay) {
		new HandoffScr(s, last, current, placeorplay);}
	

	// Win Screen
	public boolean dspWinScr(Player p, GameModel m) {
		ws = new WinScr(s, p, m);
		return ws.endGameSelection(s);}
}