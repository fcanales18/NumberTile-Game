package tilegame;

/*
Franco Canales
COP3337 - U07
Hand.java
A hand class that simulates number tiles that can be added onto or subtracted, 
returns a specific tile's index, or can check if a hand is empty.

I affirm that this program is entirely my own work and 
none of it is the work of any other person.
*/
import java.util.ArrayList ;

/**
 * Constructs a list of NumberTiles as a hand for each player.
 */
public class Hand
{
    private ArrayList<NumberTile> hand ;  // An array list of NumberTile objects
    private final static int INITIAL_SIZE = 5 ;  // starting hand size
    
    /** 
     * A list that will take 5 NumberTile objects.
     */
    public Hand()
    {
        hand = new ArrayList<>() ;  //Constructs an ArrayList to hold the tiles
        NumberTile newTile = new NumberTile(); //Creates NumberTile object
        
        //Adds 5 number tile objects to list (hand)
        for (int i = 0; i < INITIAL_SIZE; i++)
        {
            hand.add(newTile) ; //adds a NumberTile object to array list 'hand'
        }   
    }
  
    /** 
     * Retrieves NumberTile object at index specified from the hand ArrayList.
     * @param index location of the tile in the hand
     * @return tile at the index specified from the ArrayList hand
     */
    public NumberTile get(int index)
    {
       return hand.get(index) ; 
    }
    
    /** 
     * Number of tiles in the hand.
     * @return number of tiles in this hand ArrayList
     */
    public int getSize()
    {
       return hand.size() ;
    }
    
    /** 
     * Adds a new NumberTile to this Hand
     */
    public void addTile()
    {
       hand.add(new NumberTile()) ;
    }
    
    /** 
     * Removes the NumberTile at the specified index from this hand.
     * @param index the location of the tile that needs to be removed
     */
    public void removeTile(int index)
    {
        hand.remove(index) ;
    }
    
    /** 
     * Checks if the hand is empty.
     * @return returns true if hand is empty and false otherwise
     */
    public boolean isEmpty()
    {
       return hand.isEmpty() ; //calls isEmpty method to check if hand has tiles
    }
    /**
     * Returns the contents of a player's hand as a multi-line string.
     * @return If empty, then it returns as '[empty]'. If hand has tiles, it
     * will display it as a multi-line string.
     */
    public String toString()
    {
       if (isEmpty())  //Checks if the hand has tiles, and if so, displays it
       {
         return "[empty]" ;
       } else 
       {
         return hand.toString() ;  
       }
    }
}