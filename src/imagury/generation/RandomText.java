package imagury.generation;

import java.util.Random;

/**
 * Head class for string- and character-generating methods.
 * @since JLight 0.1.0
 * @author Imagury 
 *
 */
public class RandomText {
	private static int defaultLeftLimit = GenerationBorders.ALPHANUMERIC.getStart();
	private static int defaultRightLimit = GenerationBorders.ALPHANUMERIC.getEnd();

	static String lastString = "";
	static char lastChar = ' ';

	/**
	 * Header Constructor for using random string and characters. Access this class' methods by creating an instance of it.
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public RandomText() {}

	/**
	 * Generates a random string within the lowercase alphabet.
	 * Default maximal length is set to 10.
	 * Source code copied from Baeldung.
	 * @return String
	 * @see String
	 * @see Random
	 * @see <a href="https://www.rapidtables.com/code/text/ascii-table.html">ASCII Table (Online)</a>
	 * @since JLight 0.1.0
	 * @author Imagury 
	 
	public static String generateString() {
		int leftLimit = defaultLeftLimit;
		int rightLimit = defaultRightLimit;
		int targetStringLength = 10;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) 
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String fin = buffer.toString();
		lastString = fin;
		return fin;
	}
	*/

	/**
	 * Generates a random string within the alphanumeric character list and fixed length.
	 * Source code copied from Baeldung.
	 * @return String (fixed length)
	 * @param length - fixed length for the output string.
	 * @see String
	 * @see Random
	 * @see <a href="https://www.rapidtables.com/code/text/ascii-table.html">ASCII Table (Online)</a>
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public static String generateString(int length) {
		int leftLimit = defaultLeftLimit;
		int rightLimit = defaultRightLimit;
		int targetStringLength = length;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) 
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String fin = buffer.toString();
		lastString = fin;
		return fin;
	}

	/**
	 * Generates a random string with fixed length.
	 * Included/Possible characters can be changed by adjusting leftLimit and rightLimit.
	 * It is recommended to check an ASCII Table (see below).
	 * Examples:<p>
	 * 97 - 122 : lowercase alphabet<p>
	 * 65 - 90 : uppercase alphabet<p>
	 * 32 - 126 : all properly printable ASCII characters<p>
	 * 48 - 57 : numerals from 0 through 9<p>
	 * Source code copied from Baeldung.
	 * @return String (fixed length and custom characters limits)
	 * @see String
	 * @param length
	 * @param leftLimit
	 * @param rightLimit
	 * @see Random
	 * @see <a href="https://www.rapidtables.com/code/text/ascii-table.html">ASCII Table (Online)</a>
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public static String generateString(int length, int leftLimit, int rightLimit) {
		int targetStringLength = length;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = leftLimit + (int) 
					(random.nextFloat() * (rightLimit - leftLimit + 1));
			buffer.append((char) randomLimitedInt);
		}
		String fin = buffer.toString();
		lastString = fin;
		return fin;
	}
	
	/**
	 * Generates a random string with fixed length.
	 * Included/Possible characters can be changed by adjusting GenerationBorders.
	 * @return String (fixed length and custom characters limits)
	 * @see String
	 * @param length
	 * @param GenerationBorders
	 * @see Random
	 * @see <a href="https://www.rapidtables.com/code/text/ascii-table.html">ASCII Table (Online)</a>
	 * @since JLight 0.3.0
	 * @author Imagury 
	 */
	public static String generateString(int length, GenerationBorders borders) {
		int targetStringLength = length;
		Random random = new Random();
		StringBuilder buffer = new StringBuilder(targetStringLength);
		for (int i = 0; i < targetStringLength; i++) {
			int randomLimitedInt = borders.getStart() + (int) 
					(random.nextFloat() * (borders.getEnd() - borders.getStart() + 1));
			buffer.append((char) randomLimitedInt);
		}
		String fin = buffer.toString();
		lastString = fin;
		return fin;
	}

	/**
	 * Generates a random character within the lowercase alphabet.
	 * @return Character
	 * @see Character
	 * @see Random
	 * @see <a href="https://www.rapidtables.com/code/text/ascii-table.html">ASCII Table (Online)</a>
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public static Character generateChar() {
		char c = generateString(1).charAt(0);
		lastChar = c;
		return c;
	}

	/**
	 * Generates a random character.
	 * Possible characters can be changed by changing leftLimit and rightLimit.
	 * Recommended to check with an ASCII Table (see below).
	 * Examples:<p>
	 * 97 - 122 : lowercase alphabet<p>
	 * 65 - 90 : uppercase alphabet<p>
	 * 32 - 126 : all properly printable ASCII characters<p>
	 * 48 - 57 : numerals from 0 through 9<p>
	 * @return Character
	 * @see Character
	 * @param leftLimit
	 * @param rightLimit
	 * @see Random
	 * @see <a href="https://www.rapidtables.com/code/text/ascii-table.html">ASCII Table (Online)</a>
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public static Character generateChar(int leftLimit, int rightLimit) {
		Character c = generateString(1, leftLimit, rightLimit).charAt(0);
		lastChar = c;
		return c;
	}

	/**
	 * Returns last String created using this class' methods.
	 * @return String
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public static String getLastString() {
		return lastString;
	}

	/**
	 * Returns last Character created using this class' methods.
	 * @return Character
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public static char getLastChar() {
		return lastChar;
	}
}
