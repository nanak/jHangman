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
	int size = 0;

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

	public String[] getWordList() {
		return wordList;
	}
	
	
}
