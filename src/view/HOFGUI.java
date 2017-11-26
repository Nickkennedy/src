package view;
import java.awt.*;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import model.GameModel;
import model.GameRecord;
/***
 * @author Kevin Purnell s3611540
 * @version 1.0
 * Subject:       CPT111 BITS 
 * Study Period:  SP3 2017
 * Purpose:       1)Display the "Hall-of-Fame" GUI sub-screen
 * Package:       view 
 * Source:        own work
 */
//copied from zip/
public class HOFGUI extends JPanel
{
   //attributes
   JTable gameHistory;
   SimpleDateFormat formatter = new SimpleDateFormat("dMMMyy hh:mm:ssa");
   String timeStamp;
   private static String[] headings = 
      {"Time","Points Bet","Player Roll","House Roll","Outcome","Points Balance"};
   private Object[][] bets = new Object[5][5];
   private Object[][] temp = new Object[4][5];

   //constructor
   public HOFGUI(GameModel m)
   {
      System.out.println("HOFGUI constructor:");
      //build panel and add subviews(if any)
//      this.setPreferredSize(GUI.PANEL2_SIZE);
//      this.setBackground(GUI.PANEL_COLOR);
//      this.setEnabled(false);
//      this.setLayout(new BorderLayout());
//      JLabel lb1 = new JLabel("Your Bet History");
//      lb1.setFont(GUI.TITLE_FONT);
//      lb1.setForeground(GUI.TITLE_COLOR);
//      this.add(lb1,BorderLayout.NORTH);
//      gameHistory = new JTable(bets,headings);
//      gameHistory.getTableHeader().setFont(GUI.HEADER_FONT);
//      gameHistory.setFont(GUI.TABLE_FONT);
      gameHistory.setRowHeight(32);
      gameHistory.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
      gameHistory.getColumnModel().getColumn(0).setPreferredWidth(260);
      gameHistory.getColumnModel().getColumn(1).setPreferredWidth(115);
      gameHistory.getColumnModel().getColumn(2).setPreferredWidth(220);
      gameHistory.getColumnModel().getColumn(3).setPreferredWidth(220);
      gameHistory.getColumnModel().getColumn(4).setPreferredWidth(120);
      gameHistory.getColumnModel().getColumn(5).setPreferredWidth(150);
      gameHistory.setEnabled(false);
      this.add(gameHistory,BorderLayout.CENTER);
      this.add(new JScrollPane(gameHistory));
   }

   //methods
//   public void loadAndDisplayHistory(int bet,DicePair pRR,DicePair hRR,GameStatus outcome,int newBalance)
//   {  
//      //get current date/time
//      Date dateTime = Calendar.getInstance().getTime();
//      this.timeStamp = formatter.format(dateTime);
//            
//      //deep copy first 4 rows to temp array 
//      for(int i=GUI.TABLE_ROWS-2; i>=0; i--) 
//         {System.arraycopy(bets[i], 0, temp[i], 0, GUI.TABLE_COLS);}
//            
//      //copy formatted results into 1st row
//      bets[0][0]=timeStamp;
//      bets[0][1]=bet;
//      bets[0][2]=pRR;
//      bets[0][3]=hRR;
//      bets[0][4]=outcome;
//      bets[0][5]=newBalance;
//            
//      //deep copy back temp array, starting at 2nd row
//      for(int i=0; i<GUI.TABLE_ROWS-1; i++) 
//         {System.arraycopy(temp[i], 0, bets[i+1], 0, GUI.TABLE_COLS);}
//           
//      //repaint the screen
//      betHistory.repaint();
//   }
//      int i = 0;
//      System.out.println("    ======================================");
//      System.out.println("    |           Hall Of Fame             |");       
//      System.out.println("    |                                    |");                                          
//      System.out.println("    | rank winner ships shots/hit rating |");
//      if(m.getHallOfFame().size()==0) {
//      System.out.println("    |      you are the first players!    |");};          
//      for(GameRecord r : m.getHallOfFame()) { 
//      System.out.println("    |   "+(++i)+"   "+r.toString()+"  |");};        
//      System.out.println("    ======================================");
//      System.out.println("");}
//
}