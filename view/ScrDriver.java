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
	private GridScr grid;

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
	   System.out.println("ScrDriver: dspPlaceScr: Player="+p.getPlayerAlias());
		ps = new PlaceScr();
		grid = new GridScr();
		int temp = 4;
		
		while (ps.remainingShips(temp) == true){
			String coords = ps.getPlaceCoords(p);
			System.out.println("ScrDriver: dspPlaceScr: coords input="+coords);
			p.loadPlayerShip(coords,PlaceScr.tempship,PlaceScr.validgetDirection(ps.getDirection()));
			temp--;
			if(PlaceScr.tempship == ShipType.CARRIER){
				grid.dspPlayScr(p);
				PlaceScr.tempship = ShipType.PATROL;
			}
		}
	}
	
   public String getPlaceCoords(Player p) {
      return ps.getPlaceCoords(p);}
   
	// public ShipType getShipType() {
	// return (ps).getShipType();
	// }

	public String getShotCoords(Player p) {
		// return plays.getShotCoords(null);
		return "";
	}

	public void dspShot() {
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

	@Override
	public void dspHandoffScr(Player l, Player p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean dspWinScr(Player p, GameModel m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void dspPlayScr(Player p) {
		// TODO Auto-generated method stub
		
	}



}