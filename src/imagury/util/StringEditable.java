package imagury.util;

/**
 * Head class for editing and strings.
 * @since JLight 0.2.0
 * @author Imagury 
 *
 */
public class StringEditable {
	private String value = "";

	/**
	 * Head class for editing and strings.
	 * @since JLight 0.2.0
	 * @author Imagury 
	 *
	 */
	public StringEditable(String value) {
		this.value = value;
	}

	/**
	 * Returns the previously inserted string value of the StringEditable object.
	 * @since JLight 0.2.0
	 * @author Imagury 
	 */
	@Override
	public final String toString() {
		return value;
	}

	/**
	 * Changes the current string value of the StringEditable object.
	 * @param - New string to be attached to the StringEditable object
	 * @since JLight 0.2.0
	 * @author Imagury 
	 */
	public final void setString(String newString) {
		this.value = newString;
	}

	/**
	 * Inserts a given string snippet between each character of the main string.
	 * @param separator - String snippet to insert
	 * @since JLight 0.2.0
	 * @author Imagury 
	 */
	public final void intersect(String separator) {
		StringBuilder sb = new StringBuilder();
		for(char ch : value.toCharArray()) {
			sb.append(ch);
			sb.append(separator);
		}
		// Pop back
		sb.setLength(sb.length() - separator.length());
		setString(sb.toString());
	}

	/**
	 * The main String will be seperated into groups of GROUPSIZE.
	 * This method inserts a given string snippet between each group of the main string.
	 * @param separator - String snippet to insert
	 * @param groupSize - Maximal size of each string group.
	 * @since JLight 0.2.0
	 * @author Imagury 
	 */
	public final void intersect(String separator, int groupSize) {
		StringBuilder sb = new StringBuilder();
		String[] grouped = group(groupSize);
		for(String s : grouped) {
			sb.append(s);
			sb.append(separator);
		}
		// Pop back
		sb.setLength(sb.length() - separator.length());
		setString(sb.toString());
	}

	/**
	 * Creates a string array from the main string by separating it into groups.
	 * Each string-group has the maximal size of SIZE.
	 * @param size - Group size for grouping
	 * @return Grouped StringArray
	 * @since JLight 0.2.0
	 * @author Imagury 
	 */
	public final String[] group(int size) {
		int finalSize = (int) Math.ceil(value.length() / size)+1;
		String[] out = new String[finalSize];
		for(int i = 0; i < finalSize; i++) {
			// Get grouped substring
			int substr_end = 0;
			substr_end = (i+1)*size;
			if(substr_end > value.length())
				substr_end = value.length();

			String a = value.substring(i*size, substr_end);
			out[i] = a;
		}
		return out;
	}
	
	/**
	 * Reverses the main string by appending each character from the back.
	 * @return Inverted String
	 * @since JLight 0.3.0
	 * @author Imagury 
	 */
	public final void invert() {
		StringBuilder sb = new StringBuilder();
		for(int i = value.length(); i > 0; i--) {
			sb.append(value.charAt(i-1));
		}
		setString(sb.toString());
	}
}
