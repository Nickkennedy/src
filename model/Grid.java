package model;

/**
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Project Title: Battleships
 * Purpose:       1)Holds the double array of cells making up the playing grid
 * Package:       model
 * Source:        own work 
 */
//copied from zip/
public class Grid 
{
   //attributes
   Cell[][] grid;
   
   //constructor
   public Grid()
   {
      grid = new Cell[GameModel.GRID_SIZE][GameModel.GRID_SIZE];
      resetGrid();
   }
   
   //methods
   public Cell[][] getGrid(){
      return grid;}
   
   public Cell getGridCell(int row, int col){
      return grid[row][col];}
      
   public void setGridCell(Cell cell, int row, int col){
      grid[row][col] = cell;
      return;}
   
   public void resetGrid() {
      for(int row=0; row<GameModel.GRID_SIZE; row++){
         for(int col=0; col<GameModel.GRID_SIZE; col++){
            grid[row][col] = new Cell(CellStatus.EMPTY,null);}}
   }
}
//