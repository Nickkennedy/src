public class Player{
	
	private String playerName;
	Ship CARRIER;
	Ship BATTLESHIP;
	Ship DESTROYER;
	Ship SUBMARINE;
	Ship PATROL;
	
	Player(){		
	}	
	Player(String playerName, Ship carrier, Ship battleship, Ship destroyer, Ship submarine, Ship patrol){
		this.playerName = playerName;
		this.CARRIER = carrier;
		this.BATTLESHIP = battleship;
		this.DESTROYER = destroyer;
		this.SUBMARINE = submarine;
		this.PATROL = patrol;
	}
	public String getPlayerName() {
		return playerName; 
	}
	public void setName(String newPlayerName) {
		playerName = newPlayerName;
	}
}