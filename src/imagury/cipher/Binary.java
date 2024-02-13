package imagury.cipher;

import imagury.util.StringEditable;

/**
 * Head class for binary encryption and decryption.
 * As the name suggests, binary uses a number system with two digits (0, 1).
 * @since JLight 0.3.0
 * @author Imagury
 *
 */
public class Binary {

	private static int log2(int N){
		int result = (int)(Math.log(N) / Math.log(2));
		return result;
	}
	
	/**
	 * Encrypts a given number with the Binary number-system.
	 * @return String
	 * @see String
	 * @param toEncrypt - input number to be encrypted.
	 * @since JLight 0.3.0
	 * @author Imagury
	 */
	public static String encrypt(int toEncrypt) {
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();

		int runs = (int) Math.floor(log2(toEncrypt));

		for(int i = 0; i < runs+1; i++) {
			sb.append(toEncrypt % 2);
			toEncrypt = (int) Math.floor(toEncrypt / 2);
		}
		
		for(int i = sb.length(); i > 0; i--) {
			sb2.append(sb.charAt(i-1));
		}
		
		return sb2.toString();
	}
	
	/**
	 * This is the inversion of the original {@link #encrypt(int)} method.
	 * It decrypts a given binary-string from the Binary number-system.
	 * @return Integer
	 * @see Integer
	 * @param toDecrypt - input binary-string to be decrypted.
	 * @since JLight 0.3.0
	 * @author Imagury
	 */
	public static int decrypt(String toDecrypt) {
		int fin = 0;
		try {
			StringEditable se = new StringEditable(toDecrypt);
			se.invert();
			toDecrypt = se.toString();
			for(int i = 0; i < toDecrypt.length(); i++) {
				char[] arr = toDecrypt.toCharArray();
				int j = Integer.valueOf(String.valueOf(arr[i]));
				fin = (int) (fin + j * Math.pow(2, i));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		return fin;
	}
}
