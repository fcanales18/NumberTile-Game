package tilegame;

/*
Franco Canales
COP3337 - U07
NumberTile.java
Constructs a tile of 4 sides with each side having a random integer from the
range of 1 to 9.

I affirm that this program is entirely my own work and 
none of it is the work of any other person.
*/
import java.util.ArrayList ;
import java.util.Random ;

/** 
 * NumberTile class is a square tile with a number from 1 to 9 on each side that
 * can be rotated and can be checked for the number on the left and right side
 * of number tile.
 */
public class NumberTile 
{
    private ArrayList<Integer> tile ;  // constructs a square tile
    private static final Random gen = new Random() ;  //Creates an object
                                                      //from the Random Class
      
    /** 
     * Creates a NumberTile object with 4 random integers 
     * in the range of 1 to 9.
     */
    public NumberTile() 
    {
       tile = new ArrayList<>() ;  //Constructs Tile as an ArrayList  
       //Adds 4 random integers from a range of 1 to 9 to the tile
       for (int i = 0; i < 4; i++) 
       {
           tile.add(gen.nextInt(9) + 1) ;  //Passes 4 integers from range 1 to 9
       }
    }
    
    /** 
     * Rotates this NumberTile 90 degrees clockwise.
     */
    public void rotate() 
    {
       int removedNumber = tile.remove(tile.size() - 1) ; //Removes bottom tile
       tile.add(0, removedNumber) ;  //Adds a number, which rotates tile
    }
    
    /** 
     * Returns The number on the left side of this NumberTile.
     * @return Returns the Integer at index 0 
     */
    public int getLeft()
    {
        return tile.get(0) ;  //Returns number at the left side of the tile
    }
    
    /** 
     * Returns The number on the right side of this NumberTile.
     * @return Returns integer at index 2
     */
    public int getRight() 
    {
        return tile.get(2) ;  //Returns number at the right side of the tile
    }
    
    /**
     * Returns this NumberTile as a square tile with 4 integers.
     * @return Returns a multi-line string with each integer of index at the 
     * top, bottom, left, and right position.
     */
    public String toString() 
    {
       return "\n   " + tile.get(1) + "\n"
                + tile.get(0) + "     " + tile.get(2) + "\n"
                + "   " + tile.get(3) + "\n" ;
    }    
} 
