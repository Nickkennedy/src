package model;
//copied from zip/
public class Cell 
{
   //attributes
   CellStatus cellstate = null;
   ShipType shiptype = null;
   
   //constructor
   public Cell(CellStatus cs, ShipType st){
      cellstate = cs;
      shiptype = st;}
   public Cell(CellStatus cs) {
      cellstate = cs;
      shiptype = null;
   }
   
   //getters
   public CellStatus getCellState() {
      return cellstate;}
   public ShipType getShipType() {
      return shiptype;}
   public String getCellDspChar(){
      switch(cellstate){
         case EMPTY: return " ";
         case HIT:   return "X";
         case MISS:  return "!";
         case SHIP:  return "O";
         default:    return " ";}}
   
   //setters
   public void setCell(CellStatus cs, ShipType st){
      cellstate = cs;
      shiptype = st;
      return;}
   
   //helpers
   public String toString() {
      return "Hi";
//      return cellstate.name() + " " + shiptype.name();
   }
}
//