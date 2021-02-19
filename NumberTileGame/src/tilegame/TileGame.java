package tilegame;

/*
Franco Canales
COP3337 - U07
TileGame.java
Simulates a game in which each player will add a tile to the board,
in accordance to the rules, which will continue until a player, or both, 
have empty hands.

I affirm that this program is entirely my own work and 
none of it is the work of any other person.
*/

/**
 * A class that creates the logic for the tile game. Constructs an instance of
 * the game and takes in both players hand and returns the outcome of the game.
 */
public class TileGame 
{

    // instance vars
    private Board board ;    // the game board object of the Board class
    private Hand hand1 ;     // hand object that will simulate player 1 hand 
    private Hand hand2 ;     // hand object that will simulate player 2 hand
    private String winner ;  // the outcome of the game - one winner or tie

    /** 
     * Constructs the board and stores player 1 and player 2 hands
     * @param firstHand player's 1 hand
     * @param secondHand player's 2 hand
     */
    public TileGame(Hand firstHand, Hand secondHand) 
    {
        board = new Board() ; //Constructs game board
        hand1 = firstHand ; //Stores players 1 hand
        hand2 = secondHand ; //Stores players 2 hand
    }

    /** 
     * Players 1 and players 2 hand will continue to move and be rotated
     * until a hand is empty.
     */
    public void play() 
    {
        
        //Continues the game aslong as both hands are not empty
        while (hand1.getSize() > 0 && hand2.getSize() > 0) 
        {
            makeMove(hand1) ; //Forces player 1 hand to rotate if possible
            makeMove(hand2) ; //Forces player 2 hand to rotate if possible
        }
    }

    /*
    Checks each position if a tile can be inserted or not and if so, 
    returns the index of the available spot. If not, it returns a -1.
    */
    private int getIndexForFit(NumberTile tile) 
    {
        //Stores the size of board to be used to transverse the board
        int sizeOfBoard = board.getSize() ;
        //Checks each position of the tile if another tile can be inserted
        for (int i = 0; i < sizeOfBoard; i++) 
        {
            //Checks first tile against the board's first tile
            if (i == 0) 
            {
                //Checks if its the first tile
                if (tile.getRight() == board.getTile(0).getLeft()) 
                {
                    return i ; //Returns this index
                }
            }
            //Checks if tile is the last tile 
            if (i == sizeOfBoard - 1) 
            {
                //Checks if a new tile can be inserted as the new last tile
                if (tile.getLeft() == board.getTile(sizeOfBoard - 1).getRight()) 
                {
                    return sizeOfBoard; //Returns the position of this spot
                }
              //Checks for a spot between two existing tiles
            } else if (tile.getLeft() == board.getTile(i).getRight()
                    && tile.getRight() == board.getTile(i + 1).getLeft()) 
            {
                return i ; //Returns the position of this spot
            }
        }
        return -1 ; //Indicates that no new tile can be inserted
    }

    /*
    Uses the getIndexForFit method to check each consecutive tiles in the hand
    if one can be inserted into the board. ALso keeps track of turns.
    If a tile can be inserted, then it is inserted to the board and removed 
    from the hand. The tile can be rotated. If no tiles fit, then it adds a 
    new tile to the hand.
    */
    private void makeMove(Hand hand) 
    {
        int posOfTile = 0 ; //Tracks current tile in hand
        boolean hasPlayed = false ; //To keep track of a players turn

        //Allows a player to draw tiles if no move has been done
        while (!hasPlayed) 
        {
            //Continues until no more tiles in hand
            while (posOfTile < hand.getSize()) 
            {
                //Saves the initial player's hand
                NumberTile currentTile = hand.get(posOfTile) ; 
                int rotCounter = 0 ; //Keeps track of the number of rotations

                //Checks if the player's tile rotated 3 times 
                //and has not made a move
                while ((rotCounter <= 3) && (!hasPlayed)) 
                {
                    //Checks if the tile fits anywhere and stores that value
                    int index = getIndexForFit(currentTile) ; 

                    //Checks if its possible for a tile to be inserted somewhere
                    if (index != -1) 
                    {
                        //Inserts tile to that position
                        board.addTile(index, currentTile) ;
                        //Removes tile from player's hand
                        hand.removeTile(posOfTile) ;
                        //A player has made and concluded a move
                        hasPlayed = true ; 
                    } 
                    else //Rotates the tile
                    {
                        currentTile.rotate() ;
                        rotCounter++ ; //Makes sure that you can only rotate tile
                                      //3 times
                    }

                }
                posOfTile++ ; //Checks next tile
            }
            //Adds a new tile to hand if no moves were made
            if (!hasPlayed) 
            {
                hand.addTile() ; //Adds a new tile to hand 
            }
        }
    }

    /**
     * Return results of the game as a multi-line String containing
     * the final board, both both player's final hands, and the winner.
     * @return a multi-line string with the outcome of the game
     */
    public String getResults() 
    {
        //Checks if its a tie
        if (hand1.getSize() == 0 && hand2.getSize() == 0) 
        {
            winner = "It's a Tie!" ; //
        } 
        //Checks if player 1 won
        else if (hand1.getSize() == 0) 
        {
            winner = "Player 1 wins!" ; //Returns this outcome
            
        } else //Checks if player 2 won   
        {
            winner = "Player 2 wins!" ; //Returns this outcome
        }
        //Returns the outcome of the game in a more presentable way
        return "\n\n***** The Final Board *****\n" + board
                + "\n\n***** Player 1's Final Hand *****\n" + hand1
                + "\n\n***** Player 2's Final Hand *****\n" + hand2
                + "\n\n" + winner ;
    }
} 
