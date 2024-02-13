package imagury.generation;

/**
 * An enum with pre-defined border settings for generating strings from the ASCII table.
 * Used in string-generating methods.
 * @param EVERYTHING (NUL - ÿ)
 * @param READABLE (SPACE - ~)
 * @param NUMBERS (0 - 9)
 * @param ALPHABET_BIG (A - Z)
 * @param ALPHABET_SMALL (a - z)
 * @param ALPHABET (A - z)
 * @param ALPHANUMERIC (0 - z)
 * @param EXTENDED (¡ - ÿ)
 * @see <a href="https://www.rapidtables.com/code/text/ascii-table.html">ASCII Table (Online)</a>
 * @since JLight 0.3.0
 * @author Imagury 
 */
public enum GenerationBorders {
	EVERYTHING(0, 255),
	READABLE(32, 126),
	NUMBERS(48, 57),
	ALPHABET_BIG(65, 90),
	ALPHABET_SMALL(97, 122),
	ALPHABET(65, 122),
	ALPHANUMERIC(48, 122),
	EXTENDED(161, 255);

	GenerationBorders(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	private int start;
	private int end;
	
	protected final int getStart() {
		return start;
	}
	
	protected final int getEnd() {
		return end;
	}
}
