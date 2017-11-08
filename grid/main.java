package grid;

public class main {
		
	//Sets the starting value of " " for all items in the array
	public static void main(String[] args) {
		grid.startvalue(grid.p1shipsarray);
		grid.startvalue(grid.p1shotsarray);
		grid.startvalue(grid.p2shipsarray);
		grid.startvalue(grid.p2shotsarray);
		//Endless loop of happiness :)
		for(int i =0; i < 5; i++){
			if (grid.currentplayer == 1){
				grid.printships();
				grid.currentplayer= 2;
				i = 0; //Creates never ending loop
			} 
			else if(grid.currentplayer == 2){
				grid.printships();
				grid.currentplayer= 1;
				i = 0; //Creates never ending loop
			}
		}
	}
}
