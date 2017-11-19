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

public class ScrDriver implements UI {
	// attributes
	Scanner s = new Scanner(System.in);
	private SplashScr ss;
	private PlaceScr ps;
	@SuppressWarnings("unused")
	private PlayScr plays;
	private GridScr grid;
	@SuppressWarnings("unused")
	private HandoffScr hs;
	@SuppressWarnings("unused")
	private WinScr ws;

	// constructor.
	public ScrDriver() {
	}

	// Splash Screen
	public void dspSplashScr(GameModel m) {
		ss = new SplashScr(s, m);
	}

	public int getPlayerCount() {
		return ss.getCount();
	}

	public String[] getPlayerAliases() {
		return ss.getAliases();
	}

	
	// Place Screen
	@SuppressWarnings("static-access")
	public void dspPlaceScr(Player p) {
		ps = new PlaceScr();
		grid = new GridScr();
		
		while (ps.remainingShips() == true){
			String coords = ps.getPlaceCoords(p);
			System.out.println("ScrDriver: dspPlaceScr: coords input="+coords);
			p.loadPlayerShip(coords,PlaceScr.tempship,PlaceScr.validgetDirection(ps.getDirection()));	
			if(PlaceScr.tempship == ShipType.CARRIER)
				grid.dspPlayScr(p);
		}
	}
	
   public String getPlaceCoords(Player p) {
      return ps.getPlaceCoords(p);}
   
	// public ShipType getShipType() {
	// return (ps).getShipType();
	// }

	// Play Screen
	public void dspPlayScr(Player p) {
		plays = new PlayScr();
	}

	public String getShotCoords(Player p) {
		// return plays.getShotCoords(null);
		return "";
	}

	public void dspShot() {
	}

	// Handoff Screen
	public void dspHandoffScr(Player last, Player current) {
		hs = new HandoffScr(s, last, current);
	}

	// Win Screen
	public boolean dspWinScr(Player p, GameModel m) {
		ws = new WinScr(s, p, m);
		return true;
	}



	@Override
	public ShipType getShipType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DirectionType getDirection() {
		// TODO Auto-generated method stub
		return null;
	}



}