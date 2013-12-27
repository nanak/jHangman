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
	public String gamelogic(String randomWord, String hiddenWord, char letter, int hangmanState){
		if(randomWord.contains(letter+"")){
			StringBuilder newHiddenWord = new StringBuilder(hiddenWord);
			for(int i = 0; i < randomWord.length(); i++){
				if(randomWord.charAt(i) == letter){
					newHiddenWord.setCharAt(i, letter);
				}
			}

			return newHiddenWord.toString();
		} else if(!randomWord.contains(letter+"")) {
			return "false";
		} else {
		if(hangmanState >= 6)
			System.exit(0);
			return "false";
		}
	}
	
}
