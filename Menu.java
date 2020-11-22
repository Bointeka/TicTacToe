import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JSpinner;


public class Menu extends JFrame implements ActionListener {
   private static final String ORIG = "TIC TAC TOE";
   private static final String OBST = "Obstruction";
   private JButton original;
   private JButton obstruct;
   private JButton load;
   private JButton exit;
   private GridBagConstraints cont;
   //private GridBagLayout layCont;
   
   public Menu() {
      menuLayout();
      pack();
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
   }
   
   private void menuLayout() {
      setTitle("TIC TAC TOE Collection");
      setPreferredSize(new Dimension(900, 900));
      setLocation(500,100);
      setLayout(new GridBagLayout());
      
   
      original = new JButton(ORIG);
      original.setPreferredSize(new Dimension(120, 45));
      original.addActionListener(this);
      cont = new GridBagConstraints();
      cont.insets = new Insets(50, 70, 0, 70);
      add(original, cont);
      
      obstruct = new JButton(OBST);
      obstruct.setPreferredSize(new Dimension(120, 45));
      obstruct.addActionListener(this);
      cont = new GridBagConstraints();
      cont.insets = new Insets(50, 70, 0, 70);
      cont.gridy = 50;
      add(obstruct, cont);
      
      load = new JButton("Load Game");
      load.setPreferredSize(new Dimension(120, 45));
      load.addActionListener(this);
      cont = new GridBagConstraints();
      cont.insets = new Insets(50, 70, 0, 70);
      cont.gridy = 100;
      add(load, cont);
      
      exit = new JButton("Exit Game");
      exit.setPreferredSize(new Dimension(120, 45));
      exit.addActionListener(this);
      cont = new GridBagConstraints();
      cont.insets = new Insets(50, 70, 50, 70);
      cont.gridy = 150;
      add(exit, cont);
   }
   
   private void boardSetup () { // asks for the size of the board OBSTRUCTION
   
   }
   
   @Override
   public void actionPerformed(ActionEvent event) {
      if (event.getSource().equals(original)) {
         TICTACTOE game = new TICTACTOE();
      }
      else if (event.getSource().equals(obstruct)) {
      
      }
      else if (event.getSource().equals(load)) {
      
      }
      else if (event.getSource().equals(exit)) {
         dispose();
      }
   }
   
   public static void main(String[] args) {
      Menu game =  new Menu();
      
   }
   
   
   
   

}