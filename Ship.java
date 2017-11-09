public enum Ship{
		
	CARRIER(5, 5),
	BATTLESHIP(4, 4),
	DESTROYER(3, 3),
	SUBMARINE(2, 2),
	PATROL(1, 1);
		
	private int length;
	private int hitPoints;

	Ship(int length, int hitPoints){
		this.length = length;
		this.hitPoints = hitPoints;
	}
	public int getLength() {
		return length;
	}
	public int getHitPoints() {
		return hitPoints;
	}
	public void setHitPoints(int newHitPoints) {
		hitPoints = newHitPoints;
	}
}
