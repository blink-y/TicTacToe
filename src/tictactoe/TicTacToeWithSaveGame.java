package tictactoe;

import java.io.PrintStream;

/**
 * TicTacToeWithSaveGame is a subclass of TicTacToe that supports saving the game history.
 * All Exception shall be handled in try-catch, without any remedial actions and prints no message,
 * such that the normal game play is not affected.
 * 
 * Hint: use System.out redirection strategy
 * 
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
public class TicTacToeWithSaveGame extends TicTacToe {
    
    private PrintStream ps;
    
    /**
     * Constructor prepares an object that is from subclass of TicTacToe.
     * This constructor simply redirects System.out to file "ttt.txt"
     * It shall use simple try-catch to silent all PrintStream related Exceptions.
     */
    public TicTacToeWithSaveGame()
    {
        /* Students' work here */
        /* Just a few lines of code; all the rest are handled in the superclass */
        super();
        System.out.println("TicTacToeWithSaveGame");
        try {
            System.setOut(new PrintStream(("ttt.txt")));
        } catch (Exception e) { 
        }
        




    }
    
    /**
     * GUI Application main thread starts here.
     * Underlying there is another AWT-EventQueue thread running.
     * The GUI system internally will "listen" to user actions and invoke relevant Listener methods.
     * @param args is a String array of command line arguments 
     */
    public static void main(String[] args) {
        new TicTacToeWithSaveGame();
        // After executing the constructor, the program is still running.
        // This is NOT the end of the whole application.
        // Java AWT GUI stuff will take over.
    }        
}
