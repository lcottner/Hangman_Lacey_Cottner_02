import java.io.FileNotFoundException;
import java.util.Scanner;

/**
*The Application program implements an application that asks the user
*if they want to play Hangman and keeps track of the total win and
*loss rates.
*
* @author  Lacey Cottner
* @version 1.0
* @since   2021-01-01
*/
public class Application {
	
	/**
	   * This is the main method that asks the user if they
	   * want to play Hangman.
	   * 
	   * @param args unused.
	   * @return nothing.
	   */
	public static void main(String []args) {
		Scanner scan=new Scanner(System.in);
		Hangman myMan =new Hangman();
		
		System.out.println("Would you like to play? y/n");
		if (scan.nextLine().equals("y")) {
		myMan.playGame();
			while (true) {
				System.out.println("Would you like to play again? y/n");
				if (scan.nextLine().equals("y")) {
					myMan.playGame();
					
				}
				else {
					myMan.writeWL();
					break;
				}
			}
		}
		
			System.out.println("You had "+ myMan.wins + " wins and "+ myMan.losses + " losses this round");
			System.out.println("You have a total of "+ myMan.totalWins + " wins and " +myMan.totalLosses + " losses");
		
	}
}
