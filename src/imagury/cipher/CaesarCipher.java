package imagury.cipher;

/**
 * Head class for caesar-cipher encryption and decryption.
 * The Caesar cipher uses a character-shifting algorithm which
 * iterates through the ASCII characters from 32 (SPACE) to 126 (~).
 * @since JLight 0.1.0
 * @author Imagury 
 */
public class CaesarCipher {

	/**
	 * Encrypts a given string with the Caesar Cipher method. It uses a character-shifting algorithm.
	 * Use the offset 94 for a full iteration through the available characters in the method. 
	 * AKA: It will return the exact same text that was put in.<p>
	 * Source code used from Baeldung.
	 * @return String
	 * @see String
	 * @param toEncrypt - input string for encryption.
	 * @param offset - offset of how much steps the alphabet is going to be shifted.
	 * @see <a href="https://www.rapidtables.com/code/text/ascii-table.html">ASCII Table (Online)</a>
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public static String encrypt(String toEncrypt, int offset) {
		StringBuilder result = new StringBuilder();
		for (char character : toEncrypt.toCharArray()) {
			int originalAlphabetPosition = character - ' ';
			int newAlphabetPosition = (originalAlphabetPosition + offset) % 94;
			char newCharacter = (char) (' ' + newAlphabetPosition);
			result.append(newCharacter);
		}
		return result.toString();
	}

	/**
	 * Reverse version of the {@link #encrypt(String, int)} method.
	 * Decrypts a given string with the Caesar Cipher method. It uses a character-shifting algorithm.
	 * Use the offset 94 for a full iteration through the available characters in the method. 
	 * AKA: It will return the exact same text that was put in.<p>
	 * Source code used from Baeldung.
	 * @return String
	 * @see String
	 * @param toDecrypt - input string for decryption.
	 * @param offset - offset of how much steps the alphabet is going to be shifted.
	 * @see <a href="https://www.rapidtables.com/code/text/ascii-table.html">ASCII Table (Online)</a>
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public static String decrypt(String toDecrypt, int offset) {
		return encrypt(toDecrypt, 94 - (offset % 94));
	}
}
