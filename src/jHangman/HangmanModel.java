package jHangman;

import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author Nanak
 * 
 */
public class HangmanModel {

	private String hiddenWord, hiddenDisplay, fileError;
	private String[] wordList;
	private int size = 0;
	private int hangmanState;
	private char letter;

	/**
	 * Liest die wordList ein
	 * 
	 * @throws Exception
	 */
	public void wordList() throws Exception {
		File wordFile = new File("words.txt");
		Scanner scanner = new Scanner(wordFile);
		if (wordFile.exists()) {
			while (scanner.hasNextInt()) {
				size = scanner.nextInt();
			}
			wordList = new String[size];
			for (int i = 0; i < size; i++) {
				wordList[i] = scanner.nextLine();
			}
		}
		System.out.println(size);
	}

	
	/**
	 * 
	 * @return the wordlist array
	 */
	public String[] getWordList() {
		return wordList;
	}
	
	/**
	 * 
	 * @return the current state of the game
	 */
	public int getHangmanState(){
		return hangmanState;
	}
	
	/**
	 * 
	 * @param letter the letter to set
	 */
	public void setLetter(char letter){
		this.letter = letter;
	}
	
	@Override
	public String toString() {
		return ""+hangmanState;
	}
}
