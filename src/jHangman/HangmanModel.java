package jHangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Nanak
 * 
 */
public class HangmanModel {

	private String hiddenWord = "";
	private String randomWord = "";
	private String wrongLetters = "";
//	private String[] wordList;
//	private int size;
	private int hangmanState;
	private char letter;
	private ArrayList<String> wordList = new ArrayList<String>();

	/**
	 * Liest die wordList ein
	 * @throws FileNotFoundException 
	 * 
	 */
	public void readWordList() throws FileNotFoundException{
		File f = new File("words.txt");
		String file = f.getAbsolutePath();
		System.out.println(file);
		Scanner s = new Scanner(new File(file));
		while (s.hasNext()){
		    wordList.add(s.next());
		}
		s.close();
	}
//	public void wordList() throws Exception {
//		File wordFile = new File("words.txt");
//		Scanner scanner = new Scanner(wordFile);
//		if (wordFile.exists()) {
//			while (scanner.hasNextInt()) {
//				size = scanner.nextInt();
//			}
//			wordList = new String[size];
//			for (int i = 0; i < size; i++) {
//				wordList[i] = scanner.nextLine();
//			}
//		}
//		scanner.close();
//	}

	public void chooseRandomWord() {
		if(wordList != null)
			randomWord = wordList.get((int)(Math.random()*((wordList.size()-1) + 1)));
			hiddenWord = randomWord.replaceAll(".", "*");
	}


	/**
	 * 
	 * @return the current state of the game
	 */
	public int getHangmanState() {
		return hangmanState;
	}

	/**
	 * 
	 * @param letter
	 *            the letter to set
	 */
	public void setLetter(char letter) {
		this.letter = letter;
	}

	/**
	 * 
	 * @return the random chosen word, replaced with stars '*'
	 */
	public String getHiddenWord() {
		return hiddenWord;
	}

	/**
	 * 
	 * @return the last user-chosen letter
	 */
	public char getLetter() {
		return letter;
	}
	
	/**
	 * 
	 * @return the wrongly guessed letters
	 */
	public String getWrongLetters(){
		return wrongLetters;
	}
	
	/**
	 * 
	 * @param letter the letter to add to the wrong letters
	 */
	public void addLetterToWrongLetters(char letter){
		wrongLetters += letter;
	}
	
	/**
	 * 
	 * @param hiddenWord the new, partial revealed hidden word
	 */
	public void setHiddenWord(String hiddenWord){
		this.hiddenWord = hiddenWord;
	}
	
	/**
	 * 
	 * @return the random chosen word
	 */
	public String getRandomWord(){
		return randomWord;
	}
	
	/**
	 * Increments the current hangman state
	 */
	public void increaseHangmanState(){
		hangmanState++;
	}
//	/**
//	 * 
//	 * @return the size of the wordlist
//	 */
//	public int getSize(){
//		return size;
//	}
	//
	// @Override
	// public String toString() {
	// return ""+hangmanState;
	// }
}
