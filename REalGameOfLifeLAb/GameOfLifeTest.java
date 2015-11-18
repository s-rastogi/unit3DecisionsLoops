
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import info.gridworld.actor.Actor;

/**
 * The test class GameOfLifeTest.
 *
 * @author  @saahil rastogi
 * @version 10 November 2015
 */
public class GameOfLifeTest
{
    /**
     *  constructor for test class GameOfLifeTest
     */
    public GameOfLifeTest()
    {
    }

    /**
     * Sets up the test .
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testInitialState()
    {
        /* expected pattern for initial state
         *  (X: alive; -: dead)
         * 
         *    0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
         *  0 - - - - - - - - - - - - - - - - - - -
         *  1 - - - - - x - - - - - - - - - - - - - 
         *  2 - - - - x - x - - - - - - - - - - - - 
         *  3 - - - x - - - x - - - - - - - - - - - 
         *  4 - - - x - - - x - - - - - - - - - - - 
         *  5 - - - - x - x - - - - - - - - - - - -
         *  6 - - - - - x - - - - - - - - - - - - -
         *  7 - - - - - - - - - - - - - - - - - - -
         *  8 - - - - - - - - - - - - - - - - - - -
         *  9 - - - - - - - - - - - - - - - - - - -
         * 10 - - - - - - - - - - - - - - - - - - -
         * 11 - - - - - - - - - - - - - - - - - - -
         * 12 - - - - - - - - - - - - - - - - - - -
         * 13 - - - - - - - - - - - - - - - - - - -
         * 14 - - - - - - - - - - - - - - - - - - -
         * 15 - - - - - - - - - - - - - - - - - - -
         */
        
        GameOfLife game = new GameOfLife();
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();

        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                //alive cell is not null while the dead cell is null
                Actor cell = game.getActor(row, col);

                //Asserts if the actor is null; based on the position.
                if(     (row == 2 && col == 5) ||
                        (row == 3 && col == 4) ||
                        (row == 3 && col == 6) ||
                        (row == 4 && col == 3) ||
                        (row == 4 && col == 7) ||
                        (row == 5 && col == 3) || 
                        (row == 5 && col == 7) ||
                        (row == 6 && col == 4) ||
                        (row == 6 && col == 6) ||
                        (row == 7 && col == 5))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else // else, the cell should be dead; assert that the actor is null
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
    }

    @Test
    public void testFinalState()
    {
        /* expected pattern for final state
         *  (X: alive; -: dead)
         * 
           *  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
         *  0 - - - - - - - - - - - - - - - - - - -
         *  1 - - - - - - - - - - - - - - - - - - -
         *  2 - - - - x x x - - - - - - - - - - - -
         *  3 - - - x - - - x - - - - - - - - - - - 
         *  4 - - - - - - - - - - - - - - - - - - - 
         *  5 - - - - - - - - - - - - - - - - - - - 
         *  6 - - - x - - - x - - - - - - - - - - -
         *  7 - - - - x x x - - - - - - - - - - - -
         *  8 - - - - - - - - - - - - - - - - - - -
         *  9 - - - - - - - - - - - - - - - - - - -
         * 10 - - - - - - - - - - - - - - - - - - -
         * 11 - - - - - - - - - - - - - - - - - - -
         * 12 - - - - - - - - - - - - - - - - - - -
         * 13 - - - - - - - - - - - - - - - - - - -
         * 14 - - - - - - - - - - - - - - - - - - -
         * 15 - - - - - - - - - - - - - - - - - - -
         */
        GameOfLife game = new GameOfLife();
      
        final int ROWS = game.getNumRows();
        final int COLS = game.getNumCols();
        game.createNextGeneration();
        game.createNextGeneration();
        
        for(int row = 0; row < ROWS; row++)
        {
            for(int col = 0; col < COLS; col++)
            {
                // the alive cell is a not null actor and a dead cell is a null actor cause he is dead
                Actor cell = game.getActor(row, col);

                // Asserts if the actor is null; based on the position.
                if(     (row == 2 && col == 4) ||
                        (row == 2 && col == 5) ||
                        (row == 2 && col == 6) ||
                        (row == 3 && col == 3) ||
                        (row == 3 && col == 7) ||
                        (row == 6 && col == 3) || 
                        (row == 6 && col == 7) ||
                        (row == 7 && col == 4) ||
                        (row == 7 && col == 5) ||
                        (row == 7 && col == 6))
                {
                    assertNotNull("expected alive cell at (" + row + ", " + col + ")", cell);
                }
                else //  the actor is null - the cell is dead
                {
                    assertNull("expected dead cell at (" + row + ", " + col + ")", cell);
                }
            }
        }
        
    }
}

