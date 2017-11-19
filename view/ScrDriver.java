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

	// constructor.
	public ScrDriver() {}

	// Splash Screen
	public void dspSplashScr(GameModel m) {
		ss = new SplashScr(s, m);}

	public int getPlayerCount() {
		return ss.getCount();	}

	public String[] getPlayerAliases() {
		return ss.getAliases();}

	
	
	
	// Place Screen
	public void dspPlaceScr(Player p) {
	   System.out.println("ScrDriver: dspPlaceScr: Player="+p.getPlayerAlias());
		ps = new PlaceScr(s, p);
		grid = new GridScr();
		
		while (ps.remainingShips() == true){
			String coords = ps.getPlaceCoords(s, grid, p);
			System.out.println("ScrDriver: dspPlaceScr: coords input="+coords);
			p.loadPlayerShip(coords,PlaceScr.tempship,PlaceScr.validgetDirection(ps.getDirection()));	
			if(PlaceScr.tempship == ShipType.CARRIER)
				grid.display(p);
		}
	}
	


	// Play Screen
	public void dspPlayScr(Player p) {
		plays = new PlayScr(s,grid, p);}



	// Handoff Screen
	public void dspHandoffScr(Player last, Player current) {
	   System.out.println("ScrDriver: dspHandoffScr:");
		hs = new HandoffScr(s, last, current);}
	
	

	// Win Screen
	public boolean dspWinScr(Player p, GameModel m) {
		ws = new WinScr(s, p, m);
		return true;}

   @Override
   public void dspShot() {
      // TODO Auto-generated method stub
      
   }

}
//