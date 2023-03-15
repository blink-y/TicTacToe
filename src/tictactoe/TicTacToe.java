package tictactoe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 * TicTacToe of two players 'X' and 'O', taking turn to make moves.  At most there are 9 moves.
 * Students are expected to implement all the TTTGamePlayMethods in class TicTacToe.
 * @author pffung
 * 
 *** STUDENTS SHOULD FINISH THIS CLASS PROPERLY TO MAKE IT WORK!
 * 
 * CSCI1130 Java Assignment 6 TicTacToe
 *
 * Remark: Name your class, variables, methods, etc. properly. 
 * You should write comment for your work and follow good styles.
 *
 * I declare that the assignment here submitted is original except for source
 * material explicitly acknowledged, and that the same or closely related
 * material has not been previously submitted for another course. I also
 * acknowledge that I am aware of University policy and regulations on honesty
 * in academic work, and of the disciplinary guidelines and procedures
 * applicable to breaches of such policy and regulations, as contained in the
 * website.
 *
 * University Guideline on Academic Honesty:
 *     http://www.cuhk.edu.hk/policy/academichonesty
 * Faculty of Engineering Guidelines to Academic Honesty:
 *     https://www.erg.cuhk.edu.hk/erg/AcademicHonesty
 *
 * Section     : CSCI1130 A? B?
 * Student Name: xxx <fill in yourself>
 * Student ID  : xxx <fill in yourself>
 * Date        : xxx <fill in yourself>
 *
 */
public class TicTacToe extends JFrame implements ActionListener, TTTGamePlayMethods {
            
    /**
     * GUI Application main thread starts here.
     * Underlying there is another AWT-EventQueue thread running.
     * The GUI system internally will "listen" to user actions and invoke relevant Listener methods.
     * @param args is a String array of command line arguments 
     */
    public static void main(String[] args) {
        new TicTacToe();
        // After executing the constructor, the program is still running.
        // This is NOT the end of the whole application.
        // Java AWT GUI stuff will take over.
    }    


    
    /** given instance field declarations */
    
    /** tttBoard is a 2D array of TTTButton (that is a subclass of JButton) */
    protected TTTButton[][] tttBoard;
    /** moveCount starts from 0, increment by one on each valid move, max is 9 */
    protected int moveCount;
    /** turn indicates current player, either 'X' or 'O'; first player is always 'X' */
    protected char turn;


    
    /**
     * Constructor prepares an object that is from subclass of JFrame.
     * Given, students need NOT modify.
     */
    public TicTacToe()
    {
        // basic JFrame properties
        setTitle(getClass().getSimpleName());
        setSize(300, 350);
        setLocation(300, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // TicTacToe board user interface
        setLayout(new GridLayout(3, 3));
        tttBoard = new TTTButton[3][3];
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
            {
                String coord = "" + row + "," + col;
                tttBoard[row][col] = new TTTButton();
                tttBoard[row][col].setText(coord);
                tttBoard[row][col].setActionCommand(coord);
                tttBoard[row][col].addActionListener(this);
                add(tttBoard[row][col]);
            }
        
        setVisible(true);
        
        // fields initialization
        moveCount = 0;
        turn = 'X';

        // initial screen output
        System.out.println(getClass().getSimpleName());
        System.out.println("Initial empty board on screen:");
        System.out.println(this);
        System.out.println("Turn: " + turn + '\n');
    }

    /**
     * Implementation of abstract method in ActionListener interface.
     * This method is invoked by the Java GUI system internally (in an AWT thread.)
     * Given code, students need NOT modify.
     * @param event is encapsulating details of the button click
     */
    @Override
    public void actionPerformed(ActionEvent event)
    {
        String coord = event.getActionCommand();
        int row = coord.charAt(0) - '0';
        int col = coord.charAt(2) - '0';
        
        // send message to student's makeMove() method, providing row and col of the move
        makeMove(row, col);
    }
    
    /**
     * Overridden toString() method to represent the game as a String.
     * @return String representation of the board
     * Given, need not modify
     */
    @Override
    public String toString()
    {
        String result = "";
        for (int row = 0; row < 3; row++, result += '\n')
            for (int col = 0; col < 3; col++, result += " ")
                if (tttBoard[row][col].getPiece() == ' ')
                    result += "_";
                else
                    result += tttBoard[row][col].getPiece();
        return result;
    }
    
    
    
    /**
     * User of current "turn" clicked on a TTTButton at (row, col), trying to make a move.
     * 0) echo user action on console screen
     * 1) setPiece 'X' or 'O' at the target button on the 2D array tttBoard;
     *    if failed (target occupied,) return without action
     * 2) update moveCount and PRINT(this) TicTacToe game
     * 3) if check() got a winner, print "X Won" or "O Won"
     * 4) if no winner but draw game, print "Draw Game"
     * 5) on end game, disableTTTBoard(); otherwise changeTurn()
     * 6) return;
     * @param row of the clicked button
     * @param col of the clicked button
     */
    @Override
    public void makeMove(int row, int col)
    {
        // Given, echo user action on console screen
        System.out.println((moveCount+1) + ") Player " + turn + " clicked button at (" + row + ", " + col + ")");

        // STUDENT'S WORK HERE

        if (tttBoard[row][col].getPiece() == ' '){

            tttBoard[row][col].setPiece(turn);
            System.out.println(this);
            moveCount +=1;
            
            if (checkWin(row,col)){
                System.out.println(turn + " Won");
                disableTTTBoard();
            }
            else if (checkDrawGame()){
                System.out.println("Draw Game");
                disableTTTBoard();
            }
            else {
                changeTurn();
                System.out.println("Turn: " + turn + '\n');
            }
        }
    }
    
    // STUDENT'S WORK HERE
    
    /**
     * Check draw game condition based on moveCount.
     * @return true on draw game
     */
    @Override
    public boolean checkDrawGame(){
      return (moveCount == 9);
    };
    
    /**
     * Check winner based on connect-3 condition.
     * @param row of the latest move
     * @param col of the latest move
     * @return true if current turn is a winner
     */
    @Override
    public boolean checkWin(int row, int col){

      for (row =0; row <3; row++){
          int s=0;
          for (col =0; col <3; col++){
              if (tttBoard[row][col].getPiece() == turn){
                  s+= 1;
              }
              else{break;}
          }
          if (s==3){return true;}
      } 
      
      for (row =0; row <3; row++){
          int s=0;
          for (col =0; col <3; col++){
              if (tttBoard[col][row].getPiece() == turn){
                  s+= 1;
              }
              else{break;}
          }
          if (s==3){return true;}    
      }
      if (tttBoard[0][0].getPiece() == tttBoard[1][1].getPiece() && tttBoard[1][1].getPiece() == tttBoard[2][2].getPiece()){
          if(tttBoard[0][0].getPiece() == turn){
          return true;
            }
        }
      
      if (tttBoard[2][0].getPiece() == tttBoard[1][1].getPiece() && tttBoard[1][1].getPiece() == tttBoard[0][2].getPiece()){
            if(tttBoard[2][0].getPiece() == turn){
                 return true;
            }
        }
        return false;
    };
    
    @Override
    public void changeTurn(){
        switch (turn)
        {
            case 'X' -> turn = 'O';
            case 'O' -> turn = 'X';
        }
    };
    
    @Override
    public void disableTTTBoard(){
        for (int row = 0; row < 3; row++)
            for (int col = 0; col < 3; col++)
            {
                tttBoard[row][col].setEnabled(false);
            }

    };

    

    
    
    
    
    

} // end of class TicTacToe
