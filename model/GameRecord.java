package model;

import java.io.Serializable;

@SuppressWarnings("serial")
/**
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Purpose:       1)holds a game static record
 *                2)is the object written to file (persistence)
 * Location:      Model 
 * Source:        own work 
 */
//copied from zip/
public class GameRecord implements Serializable
{
   //attributes
   private String winner;
   private int shipsleft;
   private int shotsfired;
   private int hitsonenemy;
   private double hitrate;
   private double rating;
   
   //constructor
   public GameRecord(String name, int ships, int shots, int hits)
   {
      this.winner = name;
      this.shipsleft = ships;
      this.shotsfired = shots;
      this.hitsonenemy = hits;
      this.hitrate = (shots*1.0)/hits;
      this.rating = (ships / this.hitrate) * 100;
   }
   
   //getters
   public double getRating() {return rating;}
   public String getWinner() {return winner;}

   //helper
   public String toString() {
      return (String.format("%-7s",   winner)+" "+shipsleft+"      "
            +String.format("%1$,.1f",Math.round(hitrate*100)/100.0)+"     "
            +(String.format("%1$,.1f",Math.round(rating*100)/100.0)));}
}
//