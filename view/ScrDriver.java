package view;

import java.util.Scanner;
import model.GameModel;
import model.Grid;
import model.Player;
import model.ShipType;
import view.HandoffScr;
import view.PlaceScr;
import view.PlayScr;
import view.SplashScr;
import view.WinScr;
import view.UI;

/**
 * @author Kevin Purnell s3611540
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
//copied from zip/
public class ScrDriver implements UI {
	// attributes
	Scanner s = new Scanner(System.in);
	private SplashScr ss;
	private PlaceScr ps;
	private PlayScr plays;
	private GridScr grid;
	private HandoffScr hs;
	private WinScr ws;

	//constructor creates resources
	public ScrDriver() {
	   grid = new GridScr();	}

	// Splash Screen
	public void dspSplashScr(GameModel m) {
		ss = new SplashScr(s, m);}

	public int getPlayerCount() {
		return ss.getCount();	}

	public String[] getPlayerAliases() {
		return ss.getAliases();}

		
	
	// Place Screen
	public void dspPlaceScr(Player p) {
//	   System.out.println("ScrDriver: dspPlaceScr: Player="+p.getPlayerAlias());
		ps = new PlaceScr();
		
		while (ps.remainingShips() == true){
			String coords = ps.getPlaceCoords(s, grid, p);
//			System.out.println("ScrDriver: dspPlaceScr: coords input="+coords);
			p.loadPlayerShip(coords,PlaceScr.tempship,PlaceScr.validgetDirection(ps.getDirection(s)));	
			if(PlaceScr.tempship == ShipType.CARRIER)
				grid.display(p);
		}
	}

	// Play Screen
	public void dspPlayScr(Player e, Player p) {
	   System.out.println("ScrDriver: dspPlayScr: Player="+p.getPlayerAlias());
	   boolean hit;
		plays = new PlayScr();
		String coords = plays.getShotCoords(s, grid, p);
		hit = e.loadPlayerShot(false,true,coords);   //load shot against the enemy
		p.loadPlayerShot(hit, false, coords);        //load shot on own shot grid
		grid.display(p);
		
		//print out stats for debug
		System.out.println("ScrDriver: dspPlayScr: "
		      +" player: "      + p.getPlayerAlias()
		      +" shots by: "    + p.getShotCount()
            +" hits by: "     + p.getHitCount()
            +" ships left: "  + p.getShipsLeft()
            +" hits against: "+ p.getHitsAgainst());
		
	    System.out.println("ScrDriver: dspPlayScr: "
	            +" enemy: "       + e.getPlayerAlias()
	            +" shots by: "    + e.getShotCount()
	            +" hits by: "     + e.getHitCount()
	            +" ships left: "  + e.getShipsLeft()
	            +" hits against: "+ e.getHitsAgainst());
	 }

   public void dspShot() {
      // TODO Auto-generated method stub
      
   }

   

	// Handoff Screen
	public void dspHandoffScr(Player last, Player current) {
//	   System.out.println("ScrDriver: dspHandoffScr:");
		hs = new HandoffScr(s, last, current);}
	
	

	// Win Screen
	public boolean dspWinScr(Player p, GameModel m) {
		ws = new WinScr(s, p, m);
		return true;}


}
//