package model;

/***
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Project Title: Battleships
 * Purpose:       1)lists the different types of ships involved
 * Package:       model
 * Source:        own work 
 */
public enum ShipType 
{
   CARRIER   ("Carrier",5),
   BATTLESHIP("Battleship",4),
   DESTROYER ("Destroyer",3),
   SUBMARINE ("Submarine",2),
   PATROL    ("Patrol",1),;
   
   private final String name;
   private final int length;
   
   private ShipType(String name, int length) {
      this.name=name;
      this.length=length;}
   
   public String getName() {return name;}
   public int getLength()  {return length;}
}