package model;
import model.Cell; 
import model.Grid;

public class Player
{
   //attributes
   String myAlias = "";
   Grid myShips = null;
   Grid myShots = null;
   int myShotCount = 0;
   int myHitCount = 0;
   int[] index = {0,0};
   
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
   
   public boolean willShipFit(String coords, ShipType shiptype, DirectionType direction){
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
      if(isShipPresent(coords,row,col)) return false;
      return true;}
   
   public boolean isShipPresent(String coords,int row,int col){
      System.out.println("Player: isShipPresent");
      index = translateCoords(coords);
      if(myShips.getGrid()[index[0]][index[1]].getCellState()==CellStatus.EMPTY){
         System.out.println("SHIP "+myShips.getGrid()[index[0]][index[1]].getCellState()+" AT row="+index[0]+" col="+index[1]);
         return false;}
      else{
         System.out.println("SHIP "+myShips.getGrid()[index[0]][index[1]].getCellState()+" AT row="+index[0]+" col="+index[1]);
         return true;}}
   
   //setters
   public boolean loadPlayerShip(String coords, ShipType shiptype, DirectionType direction){
      System.out.println("Player: loadPlayerShip");
      index = translateCoords(coords);
      int row = index[0], col = index[1];
      int length = shiptype.getLength();
      for(int i=0; i<length; i++) {
         switch(direction) {
            case UP:   {myShips.setGridCell(new Cell(CellStatus.SHIP,shiptype), row-i, col); break;}
            case DOWN: {myShips.setGridCell(new Cell(CellStatus.SHIP,shiptype), row+i, col); break;}
            case LEFT: {myShips.setGridCell(new Cell(CellStatus.SHIP,shiptype), row, col-i); break;}
            case RIGHT:{myShips.setGridCell(new Cell(CellStatus.SHIP,shiptype), row, col+i); break;}
            default:   {                                                                   ; break;}
      }  }
      return true;}
   
   public void loadPlayerShot(String coords){
      System.out.println("Player: loadPlayerShot");
      index = translateCoords(coords);
      System.out.println("translateCoords(): coords="+coords+"  row="+index[0]+" col="+index[1]);
      myShots.setGridCell(new Cell(CellStatus.HIT), index[0], index[1]);
      return;}
   
   //helpers
   private int[] translateCoords(String coords) {
      int[] index = {0,0};
      char[] chars = coords.toCharArray();
      index[0]=Character.getNumericValue(chars[1])-1;
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
      }
      return index; 
   }
}