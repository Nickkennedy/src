///Trying to see if my pulls work. Rob
public class Test {
	public static void main(String[] args) {
		
	Player playerOne = new Player("Rob", Ship.CARRIER, Ship.BATTLESHIP, Ship.DESTROYER, Ship.SUBMARINE, Ship.PATROL) {};
	Player playerTwo = new Player("Bill", Ship.CARRIER, Ship.BATTLESHIP, Ship.DESTROYER, Ship.SUBMARINE, Ship.PATROL) {};
	
	System.out.println(playerOne.getPlayerName() );
	System.out.println(playerTwo.getPlayerName());
	
	System.out.println(playerOne.CARRIER.name());
	System.out.println(playerTwo.BATTLESHIP.name());
	System.out.println(playerOne.BATTLESHIP.getHitPoints());
	
	playerOne.BATTLESHIP.setHitPoints(3);
	
	System.out.println(playerOne.BATTLESHIP.getHitPoints());
	}
}
