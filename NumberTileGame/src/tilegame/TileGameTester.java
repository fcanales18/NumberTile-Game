package tilegame;

/*
Franco Canales
COP3337 - U07
TileGameTester.java
Simulates an instance of the game. Constructs a hand for player 1 and for
player 2, then forces both players to play, in accordance to the game rules,
until an outcome can be reached. Then asks if the user wants to play again.

I affirm that this program is entirely my own work and 
none of it is the work of any other person.
*/
import java.util.Scanner ;
/**
 * Test class for the tile game.
 */
public class TileGameTester
{
   public static void main(String[] args)
   {
       String userInput;  //Initializes a string to be used later 
       do
       {
        System.out.println("Starting a new game...") ;
        Hand player1 = new Hand() ; //Creates player 1 hand
        Hand player2 = new Hand() ;  //Creates player 2 hand
        String startingHand1 = player1.toString() ; //Saves player 1 initial hand
        String startingHand2 = player2.toString() ; //Saves player 2 initial hand
        System.out.println("\n***** Player 1's Starting Hand *****\n" 
                            + startingHand1
                            + "\n\n***** Player 2's Starting Hand *****\n" 
                            + startingHand2);
        //Creates tile game object 
        TileGame startGame = new TileGame (player1, player2) ; 
        startGame.play() ; //Starts the game
        System.out.println(startGame.getResults()) ; //Outputs the outcome
        
        Scanner scanner = new Scanner(System.in) ;
        System.out.println("Want to see the game again? "
                + "Type 'y' for yes and 'n' for no") ;
        userInput = scanner.nextLine() ;
        
        //Validates the user's input
        while (!(userInput.toLowerCase().equals("y")||
                 userInput.toLowerCase().equals("n")))
        {
            System.out.println("Invalid input. Please only type y or n") ;
            userInput = scanner.nextLine() ;
        } 
       //Starts the game again if user inputs 'y'
       }while(userInput.toLowerCase().equals("y")) ; 
   }
} 