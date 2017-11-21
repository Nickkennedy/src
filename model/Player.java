package model;
import model.Cell; 
import model.Grid;

/**
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Project Title: Battleships
 * Purpose:       1)Models the Player's state and behaviour
 *                2)Holds the Player statistics
 * Package:       model
 * Source:        own work 
 */
//copied from zip/
public class Player
{
   //attributes
   int myID = 0;
   String myAlias = "";
   Grid myShips = null;
   Grid myShots = null;
   int myShotCount = 0;
   int myHitCount = 0;
   int hitsTaken = 0;
   int shipsLeft = 0;
   
   //constructor.
   public Player(String a){
      myID = 0; 
      myAlias = a;
      myShips = new Grid();
      myShots = new Grid();
      myShotCount = 0;
      myHitCount = 0;
      hitsTaken = 0;
      shipsLeft = 0;}
   
   //getters & setters
   public int getPlayerID() {
      return myID;}
   
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

   public void setPlayerID(int ID) {
      myID = ID;}
   
   //information getters
   public boolean willShipFit(String coords, ShipType shiptype, DirectionType direction){
//      System.out.println("Player: willShipFit " + coords );
      //convert coordinates from string ("C4") to row, col index from 0
      int[] index = {0,0};
      index = translateCoords(coords);
      int row = index[0], col = index[1];
      int length = shiptype.getLength();
      
      //check boundary conditions
      switch(direction) {
         case UP:   if((row-(length-1))<0)                     return false; else break;
         case DOWN: if((row+(length-1))>GameModel.GRID_SIZE-1) return false; else break;
         case LEFT: if((col-(length-1))<0)                     return false; else break;
         case RIGHT:if((col+(length-1))>GameModel.GRID_SIZE-1) return false; else break;
         default:                                              return false;}
//      switch(direction) {
//         case UP:   System.out.println("UP    "+row+" to "+(row-(length-1))); if((row-(length-1))<0)                     return false; else break;
//         case DOWN: System.out.println("DOWN  "+row+" to "+(row+(length-1))); if((row+(length-1))>GameModel.GRID_SIZE-1) return false; else break;
//         case LEFT: System.out.println("LEFT  "+col+" to "+(col-(length-1))); if((col-(length-1))<0)                     return false; else break;
//         case RIGHT:System.out.println("RIGHT "+col+" to "+(col+(length-1))); if((col+(length-1))>GameModel.GRID_SIZE-1) return false; else break;
//         default:                                       return false;}
      //check if another ship present (need to check all positions)
      for(int i=0; i<length; i++) {
         switch(direction) {
            case UP:   {if(isShipPresent("",row-i,col)) return false; else break;}
            case DOWN: {if(isShipPresent("",row+i,col)) return false; else break;}
            case LEFT: {if(isShipPresent("",row,col-i)) return false; else break;}
            case RIGHT:{if(isShipPresent("",row,col+i)) return false; else break;}
            default:   {                                return false;}
      }  }
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
      if(myShips.getGrid()[index[0]][index[1]].getCellState()!=CellStatus.SHIP){
         return false;}
      else{
         return true;}}
   
   public boolean anyShipsLeft() {
      if(getShipsLeft()==0) return false;
      else return true;
   }
   
   //mutators
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
//      System.out.println("Player: loadPlayerShip:  shipsLeft= "+shipsLeft);
      return true;}
   
   /* loadPlayerShot() records shots against both the enemy and the player
    * Different statistics are recorded if this player is the enemy*/
   public boolean loadPlayerShot(boolean hit, boolean enemy, String coords)
   {
      //convert coordinates from string ("C4") to row, col indexed from 0
      int[] index = {0,0};
      index = translateCoords(coords);
      ShipType st;
      
      //update the enemy's data
      if(enemy) {
         if(isShipPresent("", index[0], index[1])) {                             //determine if a hit
            st = myShips.getGridCell(index[0], index[1]).getShipType();          //determine type of ship hit 
            myShips.setGridCell(new Cell(CellStatus.HIT,st), index[0], index[1]);//mark a hit on enemy's screen
            hitsTaken++;                                                         //record stats
//            System.out.println("Player: loadPlayerShot:  before shipHasBeenSunk: shipsLeft= "+shipsLeft);
            if(shipHasBeenSunk(index[0], index[1])) shipsLeft--;                 //determine if ship sunk here
//            System.out.println("Player: loadPlayerShot:  after shipHasBeenSunk: shipsLeft= "+shipsLeft);
            return true;}                             //return true to indicate a hit against the enemy
         else {                                                                   
            myShips.setGridCell(new Cell(CellStatus.MISS), index[0], index[1]);  //mark a miss on enemy's screen
            return false;}                            //return false to indicate a miss against the enemy  
      }                                                                             
      //update the player's data                                                     
      else {                                                                         
         if(hit) {                                                                    
            myShots.setGridCell(new Cell(CellStatus.HIT), index[0], index[1]);   //mark hits on player's screen
            myShotCount++;                                                       //record stats
            myHitCount++;                                                        //record stats
            return true;}                             //return true (hit) -but not used
         else {                                                                   
            myShots.setGridCell(new Cell(CellStatus.MISS), index[0], index[1]);  //mark misses on player's screen
            myShotCount++;                                                       //record stats
            return false;}                            //return false (miss) -but not used      
      }
   }
   
   
   
   //helpers
   /*looks at cells around a hit to see if all ship cells have been hit*/
   private boolean shipHasBeenSunk(int row, int col) {
      //create the coords for the 4 cells adjacent to shot, correcting for boundaries
      int right = Math.min(GameModel.GRID_SIZE,col+1);
      int down  = Math.min(GameModel.GRID_SIZE,row+1);
      int left  = Math.max(0,col-1);
      int up    = Math.max(0,row-1);
//      System.out.println("Player: shipHasBeenSunk: row="+row+" col="+col+" right="+right+" down="+down+" left="+left+" up="+up);
            
      //retrieve the shiptypes of cells adjacent
      ShipType hitST = myShips.getGridCell(row, col).getShipType();
      ShipType rightST = myShips.getGridCell(row, right).getShipType();
      ShipType downST = myShips.getGridCell(down, col).getShipType();
      ShipType leftST = myShips.getGridCell(row, left).getShipType();
      ShipType upST = myShips.getGridCell(up, col).getShipType();
//      System.out.println("Player: shipHasBeenSunk:"+" hit="+hitST+" right="+rightST+" down="+downST+" left="+leftST+" up="+upST);

      //identify direction of ship
      String direction = "unknown";
      if(rightST != hitST) direction = "updown";
      if(downST  != hitST) direction = "leftright";
      if(leftST  != hitST) direction = "updown";
      if(upST    != hitST) direction = "leftright";
      
      //crawl along direction to determine if any ship cells are unhit
      if(direction.equals("leftright")) {
//         System.out.println("Player: shipHasBeenSunk:"+" direction="+direction);
         for(int i=0; i<GameModel.GRID_SIZE; i++) 
            if(   (myShips.getGridCell(row, i).getCellState() == CellStatus.SHIP) 
               && (myShips.getGridCell(row, i).getShipType()  == hitST)) return false;} //unhit cell detected, return false
      else {
//         System.out.println("Player: shipHasBeenSunk:"+" direction="+direction);
         for(int i=0; i<GameModel.GRID_SIZE; i++) 
            if(   (myShips.getGridCell(i, col).getCellState() == CellStatus.SHIP) 
               && (myShips.getGridCell(i, col).getShipType()  == hitST)) return false;} //unhit cell detected, return false         
      
      //no unhit cells found, return true (shipHasBeenSunk)
      return true;
   }  
   
   private int[] translateCoords(String coords) {
//      System.out.println("translateCoords: "+coords);
      int length = coords.length();
      int[] index = {0,0};
      char[] chars = coords.toCharArray();
      if(length==2) index[0]=Character.getNumericValue(chars[1])-1; 
      else          index[0] = 9;
//      System.out.println("translateCoords: "+coords+" chars[0]="+chars[0]+" chars[1]="+chars[1]);
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