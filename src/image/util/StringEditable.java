package image.util;

/**
 * Head class for editing and strings.
 * @author Imagury (cursustemporum)
 *
 */
public class StringEditable {
	private String value = "";
	
	/**
	 * Head class for editing and strings.
	 * @author Imagury (cursustemporum)
	 *
	 */
	public StringEditable(String value) {
		this.value = value;
	}
	
	/**
	 * Returns the previously inserted string value of the StringEditable object.
	 * @author Imagury (cursustemporum)
	 */
	@Override
	public final String toString() {
		return value;
	}
	
	/**
	 * Changes the current string value of the StringEditable object.
	 * @param - New string to be attached to the StringEditable object
	 * @author Imagury (cursustemporum)
	 */
	public final void setString(String newString) {
		this.value = newString;
	}
	
	/**
	 * Inserts a given string snippet between each character of the main string.
	 * @param separator - String snippet to insert
	 * @author Imagury (cursustemporum)
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
	 * Inserts a given string snippet between each group of the main string.
	 * Each string-group has the maximal size of GROUPSIZE.
	 * @param separator - String snippet to insert
	 * @param groupSize - Maximal size of each string group.
	 * @author Imagury (cursustemporum)
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
	 * @author Imagury (cursustemporum)
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
}
