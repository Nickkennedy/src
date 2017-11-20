package model;
import model.Cell; 
import model.Grid;
//copied from zip/
public class Player
{
   //attributes
   String myAlias = "";
   Grid myShips = null;
   Grid myShots = null;
   int myShotCount = 0;
   int myHitCount = 0;
   int hitsTaken = 0;
   int shipsLeft = 0;
   
   //constructor.
   public Player(String a){
      myAlias = a;
      myShips = new Grid();
      myShots = new Grid();}
   
   //getters
   public String getPlayerAlias(){
      return myAlias;}
   
   public Grid getPlayerShips(){
      return myShips;}
   
   public Grid getPlayerShots(){
      return myShots;}
   
   public int getShotCount(){
      return myShotCount;}
   
   public int getHitCount(){
      return myHitCount;}
   
   public int getShipsLeft(){
      return shipsLeft;}
   
   public int getHitsAgainst() {
      return hitsTaken;
   }

   
   public boolean willShipFit(String coords, ShipType shiptype, DirectionType direction){
      System.out.println("Player: willShipFit " + coords );
      //convert coordinates from string ("C4") to row, col index from 0
      int[] index = {0,0};
      index = translateCoords(coords);
      int row = index[0], col = index[1];
      int length = shiptype.getLength();
      
      //check boundary conditions
      switch(direction) {
         case UP:   System.out.println("UP    "+row+" to "+(row-(length-1))); if((row-(length-1))<0)                     return false; else break;
         case DOWN: System.out.println("DOWN  "+row+" to "+(row+(length-1))); if((row+(length-1))>GameModel.GRID_SIZE-1) return false; else break;
         case LEFT: System.out.println("LEFT  "+col+" to "+(col-(length-1))); if((col-(length-1))<0)                     return false; else break;
         case RIGHT:System.out.println("RIGHT "+col+" to "+(col+(length-1))); if((col+(length-1))>GameModel.GRID_SIZE-1) return false; else break;
         default:                                          return false;}
      //check if another ship present (need to check all positions)
      if(isShipPresent("",row,col)) return false;
      return true;}
   
   public boolean areCoordsValid(String coords) {
//      System.out.println("Player:  areCoordsValid: "+coords);
      int[] index = {0,0};
      index = translateCoords(coords);
      if((index[0]>=0 && index[0]<=9) && (index[1]>=0 && index[1]<=9)) {
//         System.out.println("Player:  areCoordsValid: row="+index[0]+" col="+index[1]+" valid");
         return true;}
      else {
//         System.out.println("Player:  areCoordsValid: row="+index[0]+" col="+index[1]+" invalid");
         return false;}}
   
   public boolean isShipPresent(String coords,int row,int col){
//      System.out.println("Player: isShipPresent " + coords );
      //allows coordinates in 2 forms; "C4" string, or row, col index from 0
      int[] index = {0,0};
      if(coords!="") index = translateCoords(coords);
      else {index[0] = row; index[1]=col;}
      
      //look at the content of the addressed cell
      if(myShips.getGrid()[index[0]][index[1]].getCellState()==CellStatus.EMPTY){
//         System.out.println("SHIP "+myShips.getGrid()[index[0]][index[1]].getCellState()+" AT row="+index[0]+" col="+index[1]);
         return false;}
      else{
//         System.out.println("SHIP "+myShips.getGrid()[index[0]][index[1]].getCellState()+" AT row="+index[0]+" col="+index[1]);
         return true;}}
   
   //setters
   public boolean loadPlayerShip(String coords, ShipType shiptype, DirectionType direction){
//      System.out.println("Player: loadPlayerShip");
      //convert coordinates from string ("C4") to row, col index from 0
      int[] index = {0,0};
      index = translateCoords(coords);
      int row = index[0], col = index[1];
      
      //load ship
      int length = shiptype.getLength();
      for(int i=0; i<length; i++) {
         switch(direction) {
            case UP:   {myShips.setGridCell(new Cell(CellStatus.SHIP,shiptype), row-i, col); break;}
            case DOWN: {myShips.setGridCell(new Cell(CellStatus.SHIP,shiptype), row+i, col); break;}
            case LEFT: {myShips.setGridCell(new Cell(CellStatus.SHIP,shiptype), row, col-i); break;}
            case RIGHT:{myShips.setGridCell(new Cell(CellStatus.SHIP,shiptype), row, col+i); break;}
            default:   {                                                                   ; break;}
      }  }
      shipsLeft++;
      System.out.println("Player: loadPlayerShip:  shipsLeft= "+shipsLeft);
      return true;}
   
   /* loadPlayerShot() records shots against both the enemy and the player
    * Different statistics are recorded if this player is the enemy
    */
   public boolean loadPlayerShot(boolean hit, boolean enemy, String coords){
      //convert coordinates from string ("C4") to row, col index from 0
      int[] index = {0,0};
      index = translateCoords(coords);
      
      //update the enemy's data
      if(enemy) {
         if(isShipPresent("", index[0], index[1])) {  //determine if a hit
            myShips.setGridCell(new Cell(CellStatus.HIT), index[0], index[1]);  //record a hit
            hitsTaken++;                              //record stats                         
                                                      //determine if ship sunk here            
            return true;}                             //return true to indicate a hit against the enemy
         else {                                                                   
            myShips.setGridCell(new Cell(CellStatus.MISS), index[0], index[1]); //record a miss
            return false;}                            //return false to indicate a miss against the enemy  
      }     
      //update the player's data
      else {
         if(hit) {
            myShots.setGridCell(new Cell(CellStatus.HIT), index[0], index[1]);
            myShotCount++;
            myHitCount++; 
            return true;}                             //return true -but not used
         else {
            myShots.setGridCell(new Cell(CellStatus.MISS), index[0], index[1]);
            myShotCount++;
            return false;}                            //return false -but not used      
      }
   }
   
   //helpers
   private int[] translateCoords(String coords) {
//      System.out.println("Player: translateCoords " + coords + " length="+coords.length());
      int length = coords.length();
      int[] index = {0,0};
      char[] chars = coords.toCharArray();
//      System.out.println("Player: translateCoords:  chars.length="+chars.length);
      if(length==2) index[0]=Character.getNumericValue(chars[1])-1; 
      else          index[0] = 9;
      switch(chars[0]) {
         case 'A': index[1]=0;break;
         case 'B': index[1]=1;break;
         case 'C': index[1]=2;break;
         case 'D': index[1]=3;break;
         case 'E': index[1]=4;break;
         case 'F': index[1]=5;break;
         case 'G': index[1]=6;break;
         case 'H': index[1]=7;break;
         case 'I': index[1]=8;break;
         case 'J': index[1]=9;break;
         case 'a': index[1]=0;break;
         case 'b': index[1]=1;break;
         case 'c': index[1]=2;break;
         case 'd': index[1]=3;break;
         case 'e': index[1]=4;break;
         case 'f': index[1]=5;break;
         case 'g': index[1]=6;break;
         case 'h': index[1]=7;break;
         case 'i': index[1]=8;break;
         case 'j': index[1]=9;break;
         default: index[1]=99;
      }
      return index; 
   }
}
//