package jHangman;

/**
 * 
 * @author Nanak
 *
 */
public class HangmanGamelogic {

	/**
	 * 
	 * @param randomWord the random chosen word
	 * @param letter the last user-chosen letter
	 */
	public String gamelogic(String randomWord, char letter){
		if(randomWord.contains(letter+"")){
			return "";
		} else {
			return "false";
		}
	}
	
}
