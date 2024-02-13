package imagury.cipher;

import java.util.HashMap;
import java.util.Map;

/**
 * Head class for morse-code encryption and decryption.
 * Morse uses a special alphabet with one equivalent to each character,
 * consisting out of dashes (-) and dots (.).
 * @since JLight 0.2.0
 * @author Imagury 
 *
 */
public class MorseCode {

	static Map<String, String> alph = new HashMap<String, String>();
	static Map<String, String> alph_rev = new HashMap<String, String>();

	private static void init_alphabet() {
		String[] latin = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l","m", "n", "o", "p", "q", 
				"r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ",", ".", "?", " ", "!", "/", ":", "+", "-", "="};
		String[] morse = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", 
				".-.","...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----","..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.","-----", "--..--", ".-.-.-", "..--..", 
				"/", "-.-.--", "-..-.", "---...", ".-.-.", "-....-", "-...-"};

		for(int i = 0; i < latin.length; i++) {
			alph.put(latin[i], morse[i]);
			alph_rev.put(morse[i], latin[i]);
		}
	}

	/**
	 * Encrypts a given string with the Morse Code alphabet.
	 * Not yet implemented characters in the input string will be left out.
	 * @return String
	 * @see String
	 * @param toEncrypt - input string to be encrypted.
	 * @since JLight 0.2.0
	 * @author Imagury 
	 */
	public static String encrypt(String toEncrypt) {
		init_alphabet();
		toEncrypt = toEncrypt.toLowerCase();
		StringBuilder sb = new StringBuilder();
		for (Character c : toEncrypt.toCharArray()) {
			String app = alph.get(String.valueOf(c));
			if(app != null) {
				sb.append(app);
				sb.append(" ");
			}
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}

	/**
	 * Decrypts a given string with the Morse Code alphabet.
	 * Not yet implemented characters in the input string will be left out.
	 * @return String
	 * @see String
	 * @param toDecrypt - input string to be decrypted.
	 * @since JLight 0.2.0
	 * @author Imagury 
	 */
	public static String decrypt(String toDecrypt) {
		init_alphabet();
		StringBuilder sb = new StringBuilder();
		String[] array = toDecrypt.split(" ");
		for(String s : array) {
			String app = alph_rev.get(s);
			if(app != null) {
				sb.append(app);
			}
		}
		return sb.toString();
	}
}
