import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

/**
 * Game of Life lab. Demonstrates how to create and populate the game using the GridWorld.
 * demonstrates how to provide accessor methods to make the class testable by unit tests.
 * 
 * @author @saahil rastogi
 * @version 10 November 2015
 */
public class GameOfLife
{
    // the world that has a graphics and is a grid
    private ActorWorld world;

    // board will have 15 rows and 15 columns
    private final int ROWS = 15;
    private final int COLS = 15;

    //constants for the location of the cells initially alive 
    private final int x1 = 5, y1 = 2;
    private final int x2 = 4, y2 = 3;
    private final int x3 = 6, y3 = 3;
    private final int x4 = 3, y4 = 4;
    private final int x5 = 7, y5 = 4;
    private final int x6 = 3, y6 = 5;
    private final int x7 = 7, y7 = 5;
    private final int x8 = 4, y8 = 6;
    private final int x9 = 6, y9 = 6;
    private final int x10 = 5, y10 = 7;
    
    /**
     * Default constructor for objects of class GameOfLife
     * 
     * @post    the game will be initialized and populated with the initial state of cells
     * 
     */
    public GameOfLife()
    {
        // create the grid, of the specified size, that contains Actors
        BoundedGrid<Actor> grid = new BoundedGrid<Actor>(ROWS, COLS);

        // create a world based on the grid
        world = new ActorWorld(grid);

        // populate the game
        populateGame();

        // display the newly constructed and populated world
        world.show();

    }

    /**
     * Creates the actors and inserts them into their initial starting positions in the grid
     *
     * @pre     the grid has been created
     * @post    all actors that comprise the initial state of the game have been added to the grid
     * 
     */
    private void populateGame()
    {
        // the grid of Actors that maintains the state of the game
        Grid<Actor> grid = world.getGrid();

        //create and add rocks to the locations
        Rock rock1 = new Rock();
        Location loc1 = new Location(y1, x1);
        grid.put(loc1, rock1);

        Rock rock2 = new Rock();
        Location loc2 = new Location(y2, x2);
        grid.put(loc2, rock2);

        Rock rock3 = new Rock();
        Location loc3 = new Location(y3, x3);
        grid.put(loc3, rock3);

        Rock rock4 = new Rock();
        Location loc4 = new Location(y4, x4);
        grid.put(loc4, rock4);

        Rock rock5 = new Rock();
        Location loc5 = new Location(y5, x5);
        grid.put(loc5, rock5);
        
        Rock rock6 = new Rock();
        Location loc6 = new Location(y6, x6);
        grid.put(loc6, rock6);

        Rock rock7 = new Rock();
        Location loc7 = new Location(y7, x7);
        grid.put(loc7, rock7);
        
        Rock rock8 = new Rock();
        Location loc8 = new Location(y8, x8);
        grid.put(loc8, rock8);
        
        Rock rock9 = new Rock();
        Location loc9 = new Location(y9, x9);
        grid.put(loc9, rock9);
        
        Rock rock10 = new Rock();
        Location loc10 = new Location(y10, x10);
        grid.put(loc10, rock10);
        
        
    }

    /**
     * Generates the next generation based on the rules of the Game of Life and updates the grid
     * associated with the world
     *
     * @pre     the game has been initialized
     * @post    the world has been populated with a new grid containing the next generation
     * 
     */
    public void createNextGeneration()
    {
        /** Schmitt tip of the day- create a new grid dont try to change previous grid so make a a new grid:)
         */

        // create the grid, of the specified size, that contains Actors

        Grid<Actor> grid = world.getGrid(); //gets grid
        BoundedGrid<Actor> gridNew = new BoundedGrid<Actor>(ROWS, COLS);//creates new grid

        for (int x=0; x<COLS; x++)
        { 
            for (int y=0; y<ROWS; y++)
            {
                Location loc = new Location(x,y);
                int neighbors = grid.getNeighbors(loc).size();
                if (getActor(x,y)==null)
                {
                    if (neighbors == 3)
                    {
                        gridNew.put(new Location(x,y),new Rock());

                    }
                }
                else 
                {
                    if (neighbors == 3||neighbors ==2)
                    {
                        gridNew.put(new Location(x,y),new Rock());

                    }
                }
            }
        }
        world.setGrid(gridNew);         
        world.show();
    }

    /**
     * Returns the actor at the specified row and column
     *
     * @param   row the row (zero-based index) of the actor to return
     * @param   col the column (zero-based index) of the actor to return
     * @pre     the grid has been created
     * @return  the actor at the specified row and column
     */
    public Actor getActor(int row, int col)
    {
        Location loc = new Location(row, col);
        Actor actor = world.getGrid().get(loc);
        return actor;
    }

    /**
     * Returns the number of rows in the game board
     *
     * @return    the number of rows in the game board
     */
    public int getNumRows()
    {
        return ROWS;
    }

    /**
     * Returns the number of columns in the game board
     *
     * @return    the number of columns in the game board
     */
    public int getNumCols()
    {
        return COLS;
    }

    /**
     * Creates an instance of this class. 
     *
     */
    public static void main(String[] args)
    throws InterruptedException
    {
        GameOfLife game = new GameOfLife();
        for (int i=0; i<15; i++)
        {
            Thread.sleep(1000); 
            game.createNextGeneration();

        }
    }
} 
