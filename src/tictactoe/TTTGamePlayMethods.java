package tictactoe;

/**
 * TTTGamePlayMethods is a list of methods
 * Given interface, DO NOT MODIFY
 * @author pffung
 */
public interface TTTGamePlayMethods {
    /**
     * User of current "turn" clicked on a TTTButton at (row, col), trying to make a move.
     * 0) echo user action on console screen
     * 1) setPiece 'X' or 'O' at the target button on the 2D array tttBoard;
     *    if failed (target occupied,) return without action
     * 2) update moveCount and PRINT(this) TicTacToe game
     * 3) if checkWin() got a winner, print "X Win" or "O Win"
     * 4) if no winner but draw game, print "Draw Game"
     * 5) on end game, disableTTTBoard(); otherwise changeTurn()
     * 6) return;
     * @param row of the clicked button
     * @param col of the clicked button
     */
    public void makeMove(int row, int col);
    
    /**
     * Check draw game condition based on moveCount.
     * @return true on draw game
     */
    public boolean checkDrawGame();
    
    /**
     * Check winner based on connect-3 condition.
     * @param row of the latest move
     * @param col of the latest move
     * @return true if current turn is a winner
     */
    public boolean checkWin(int row, int col);

    /**
     * Change turn AND print turn information.
     */
    public void changeTurn();

    /**
     * Disable all buttons one-by-one in the tttBoard array using the inherited JButton method setEnabled().
     */
    public void disableTTTBoard();
}
