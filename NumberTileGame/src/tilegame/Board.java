package tilegame;

/*
Franco Canales
COP3337 - U07
Board.java
The Board Class is an ArrayList that takes in NumberTile objects and allows us
to be able to add NumberTiles onto it, check the number of tiles on the board,
and to return the board as a multi-line string.

I affirm that this program is entirely my own work and 
none of it is the work of any other person.
*/
import java.util.ArrayList ;

/**
 * Sets up a board in which number tiles can be added onto
 */
public class Board
{
    private ArrayList<NumberTile> board ;   // A list of NumberTile objects
    
    /**
     * Constructs a new Board containing a single NumberTile object
    */
    public Board()
    {
       board = new ArrayList<>() ;  //Creates a list named board
       board.add(new NumberTile()) ;  //Adds a numbertile object to list
    }
    
    /**
     * Returns the NumberTile at the specified index on this Board
     * @param index Position of the tile
     * @return Returns the Number Tile on the list at the index specified
    */
    public NumberTile getTile (int index)
    {
       return board.get(index) ;  //Calls 'get' method to retrieve tile at index
    }
    
    /** 
     * Gets size of board
     * @return Returns number of tiles in this board
     */
    public int getSize()
    {
       return board.size() ;  //Calls size method to retrieve number of elements
       
    }
    
    /** 
     * Insert a new tile into this Board at the specified index
     * @param index the position in which to add the tile
     * @param tile the tile object thats being inserted
     */
    public void addTile(int index, NumberTile tile)
    {
       board.add(index, tile) ;  //Adds tile to board at index specified
    }
    
    /**
     * Return a multi-line string containing all the tiles on this Board
     * @return returns the tiles on the board as a multi-line String object
     */
    public String toString()
    {
       return board.toString() ; //Shows board as a string
       
    }           
}
