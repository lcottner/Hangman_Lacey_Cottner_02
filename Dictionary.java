import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
*The Dictionary program pulls words from a 
* text file and instantiates them into an array.
*
* @author  Lacey Cottner
* @version 1.0
* @since   2021-01-01
*/
public class Dictionary {
String [] words= new String [200];	
int i=0;

	public Dictionary(){
		readFile();
	}
	
	/**
	   * This method is used to read the text file Words and
	   * transfer them into the array words.
	   * 
	   * @param args unused.
	   * @return nothing.
	   */
	public void readFile() {
		try {
		File file =  new File("Words");
		Scanner scan=new Scanner(file);
		while (i<200) {
			words[i]=scan.nextLine();
			i=i+1;
		}
		scan.close();
		}
		catch (FileNotFoundException e) {
			System.out.println("An error has occured");
		}
		
	}
	/**
	   * This method is used to read the text file Words and
	   * transfer them into the array words.
	   * 
	   * @param args unused.
	   * @return String This returns a String in one index of the array
	   */
	public String chooseWord() {
		return words[(int)Math.floor(Math.random()*201)];
	}
}
