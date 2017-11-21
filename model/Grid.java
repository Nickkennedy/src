package model;
//copied from zip/
public class Grid 
{
   //attributes
   Cell[][] grid;
   
   //constructor
   public Grid()
   {
      grid = new Cell[GameModel.GRID_SIZE][GameModel.GRID_SIZE];
      for(int row=0; row<GameModel.GRID_SIZE; row++){
         for(int col=0; col<GameModel.GRID_SIZE; col++){
            grid[row][col] = new Cell(CellStatus.EMPTY,null);}}
   }
   
   //methods
   public Cell[][] getGrid(){
      return grid;}
   
   public Cell getGridCell(int row, int col){
      return grid[row][col];}
      
   public void setGridCell(Cell cell, int row, int col){
      grid[row][col] = cell;
      return;}
}
//