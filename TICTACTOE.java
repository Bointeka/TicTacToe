import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JOptionPane;

/** TicTacToe game using basic GUI elements. Tracks the scores of both
 *  players allowing for continous play.
 *  Jeremy Okeyo ||  5/25/2019
 *
*/

public class TICTACTOE extends JFrame implements ActionListener {
   public JButton[][] cells;
   public JButton exit;
   public JButton replay;
   public JButton cell;
   private String player = PLAYER_X;
   private GridBagLayout gridBag = new GridBagLayout();
   private GridBagConstraints area;
   private JOptionPane stat;
   private static final int SIZE = 3;
   private static final String PLAYER_X = ("X");
   private static final String PLAYER_O = ("O");
   private static final String EMPTY_CELL = ("-");
   private int topAlign;
   private int leftAlign;
   private final int DIMEN = 100;
   private static int X_win;
   private static int O_win; 
   private int[] score = new int[8]; //Keeps track of the game's play.
                                  //Corresponds with all possible winning plays
   private int noPlays;
   private final int MAXPLAYS = 8;                                     
   
   
   
   
   /**
      Contructs a new TicTacToe board with all its rules.
   */
   public TICTACTOE() {
      window();
   
   }
   
   /**
    * Sets up the TicTacToe board
   */ 
   private void window() {
      setLayout(gridBag);
      setLocation(500, 100);
      setPreferredSize(new Dimension(700, 700));
      boardLayout();
      pack();     
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setVisible(true);
   }
   
   /**
    * Sets up the TicTacToe board
   */
   private void boardLayout() {
      cells = new JButton[SIZE][SIZE];
      setTitle("TIC TAC TOE");
      for (int i = 0; i < SIZE; i++) {         
         leftAlign = 0;
         for (int j = 0; j < SIZE; j++) {
            cell = new JButton(EMPTY_CELL);
            cells[i][j] = cell;
            cells[i][j].setPreferredSize(new Dimension(100, 100));
            
            area = new GridBagConstraints();
            area.gridheight = area.REMAINDER;
            area.gridwidth = area.REMAINDER;
            area.gridheight = DIMEN;
            area.gridwidth = DIMEN;
            area.gridx = leftAlign;
            area.gridy = topAlign;
            add(cells[i][j], area);
            leftAlign += DIMEN;
            
            cells[i][j].addActionListener(this);
         }
         topAlign += DIMEN;
      }
   }
   
   /**
    * Registers the clicks of the user on the buttons.
    * @param action The button press.
   */
   @Override
   public void actionPerformed(ActionEvent action) {
      Object but = action.getSource();
      for (int i = 0; i < cells.length; i++) {
         for (int j = 0; j < cells[0].length; j++) {
            if (cells[i][j].equals(but) && cells[i][j].getText() == EMPTY_CELL) {
               cells[i][j].setText(player);
               gamePlay(player, j, i);
               gameOver();
               player = nextPlayer(player);
               noPlays++;
            }
         }
      }  
   }
   
   /**
    * Proceeds to the next player depending on the current player. Helper to 
    * actionPerformed()
    * @param player the current player
    * @return the next player
   */
   private String nextPlayer(String player) {
      if (player.equals(PLAYER_X)) {
         return PLAYER_O;
      }
      else {
         return PLAYER_X;
      }
   }
   
   /**
    * Tests whether any of the players created a winning trio. Helper to
    * isGameOver()
    * @param player the current player
    * @row   the row of the button pressed
    * @col   the column of the button pressed
    * 
   */
   private void gamePlay(String player, int row, int col) {
      int point = -1; 
      if (player.equals(PLAYER_X)) {
         point = 1;
      }
      score[col] += point;
      score[3 + row] += point;
      if (row == col) {
         score[6] += point;
      }
      if ((2 - col) == row) {
         score[7] += point;
      }

   }
   
   /**
    * Tests whether the game is over.
    * @return whether the game is over.
   */      
   private boolean isGameOver() {
      boolean gameOver = false;
      for (int i = 0; i < score.length; i++) {
         if (score[i] == 3) {
            gameOver = true;
            break;
         }         
         else if (score[i] == -3) {
            gameOver = true;
            break;  
         }       
         else if (noPlays == MAXPLAYS) {
            gameOver = true;
            break;
         }
         else {
            gameOver = false; 
         }                 
      }
      return gameOver;
   }
   
   /**
    * Creates a dialogue box that prompts the user if the game is over. 
   */
   private void gameOver() {
      boolean gameOver = isGameOver();
      if (gameOver) {
         Object[] options = {"Play Again?", "Exit"};
         if (player.equals(PLAYER_X)) {
            String dialog = "Player X has won. Score: X " + X_win + " O " +  O_win;
            X_win++;
            Object obj = dialog;
            stat = new JOptionPane();
            int choice = stat.showOptionDialog(null, obj, "Select to advance",
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, null);       
            option(choice);
         }
         else if (player.equals(PLAYER_O)) {
            String dialog = "Player O has won. Score: X " + X_win + " O " +  O_win;
            O_win++;
            Object obj = dialog;
            stat = new JOptionPane();
            int choice = stat.showOptionDialog(null, obj, "Select to advance", 
                    JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, options, null);       
            option(choice);
         }         
      } 
   }
   
   /**
    * Provides funtionality to the dialog boxes buttons.
      @param choice The choice selected by the user
   */
   public void option(int choice) {
      if (choice == 1) {
         dispose();
      }
      else {
         dispose();
         TICTACTOE game = new TICTACTOE();
      }
   }   
   
   //Used to test the program 
   public static void main(String[] args) {      
      TICTACTOE c = new TICTACTOE();
      
   }
}