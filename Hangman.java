import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/**
*The Hangman program holds the main game
*algorithms of Hangman.
*
* @author  Lacey Cottner
* @version 1.0
* @since   2021-01-01
*/
public class Hangman {
	int wins=0;
	int losses=0;
	int totalWins;
	int totalLosses;
	String currentWord;
	Dictionary dict;
	
	Hangman(){
		dict=new Dictionary();
		loadWL();
		
	}
	/**
	   * This method loads the total amount of wins
	   * and losses from the WinLoss.txt file.
	   * 
	   * @param args unused.
	   * @return nothing.
	   */
	void loadWL(){
		try {
		File file =  new File("WinLoss");
		Scanner scan=new Scanner(file);
		String combo=scan.nextLine();
		int temp=combo.indexOf(",");
		
		totalWins=Integer.parseInt(combo.substring(0,temp));
		totalLosses=Integer.parseInt(combo.substring(temp+1));
		
		scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("An error has occured");
		}
	}
	
	/**
	   * This method writes to the WinLoss.txt file
	   * so that it now includes the new updated win
	   * and loss rates 
	   * 
	   * @param args unused.
	   * @return nothing.
	   */
	void writeWL() {
		try {
		      FileWriter myWriter = new FileWriter("WinLoss");
		      myWriter.write(String.valueOf(totalWins));
		      myWriter.write(",");
		      myWriter.write(String.valueOf(totalLosses));
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	/**
	   * This method is the main loop of Hangman
	   * and interacts with the player.
	   * 
	   * @param args unused.
	   * @return nothing.
	   */
	void playGame() {
		currentWord=dict.chooseWord();
		int close=currentWord.length();
		int count=5;
		boolean correct= false;
		boolean game=true;
		Scanner scan=new Scanner(System.in);
		
		String [] array=new String[currentWord.length()];
		
		for (int i=0; i<currentWord.length(); i++) {
			array[i]="_";
			System.out.printf(array[i]+" ");
		}
		
		System.out.printf("%nYou have "+count+" incorrect guesses left.%n");
		
		
		while(game==true) {
		correct=false;
		
		System.out.printf("What is your guess?");
		String guess=scan.nextLine();	
		System.out.printf("%n");
		
		for (int i=0;i<currentWord.length();i++) {
		if (guess.equals(currentWord.substring(i,i+1))) {
			array[i]=guess;
			correct=true;
			close=close-1;
		}
		
			System.out.printf(array[i]+" ");
		}
		
		if (correct==false)
		count=count-1;
			System.out.printf("%nYou have "+count+" incorrect guesses left.%n");
			
			if (close==0) {
				System.out.println("You won!");
				wins=wins+1;
				totalWins=totalWins+1;
				game=false;
			}
			if (count==0) {
				System.out.println("You are out of guesses. You lost");
				losses=losses+1;
				totalLosses=totalLosses+1;
				game=false;
			}
			
		}
		
	}
}
