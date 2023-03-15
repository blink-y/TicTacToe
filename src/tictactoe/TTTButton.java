package tictactoe;

import java.awt.Color;
import javax.swing.JButton;

/**
 * TTTButton is a subclass of JButton, representing a TicTacToe button in the game.
 * Given class, DO NOT MODIFY
 * @author pffung
 */
public class TTTButton extends JButton {
    
    /** internal state, could be 'X', 'O' or ' '; initially ' ' */
    private char side;
    
    /** default constructor */
    public TTTButton()
    {
        super();
        side = ' ';
    }

    /**
     * Get state of this button (a piece on the game board)
     * @return either 'X', 'O' or ' '
     */
    public char getPiece()
    {
        return side;
    }

    /**
     * Set state of this button by updating internal field side, changing text and color
     * @param player is either 'X' or 'O', accept uppercase only
     * @return true on success;
     *         false if parameter player is invalid;
     *         false if this button has taken side, i.e., occupied
     */
    public boolean setPiece(char player)
    {
        if (getPiece() != ' ')
            return false;
        
        switch (player)
        {
            case 'X':
                setForeground(Color.RED);
                break;
            case 'O':
                setForeground(Color.GREEN);
                break;
            default:
                return false;
        }
        this.side = player;
        this.setText("" + player);
        return true;
    }
}
