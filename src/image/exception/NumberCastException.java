package image.exception;

/**
 * Thrown when casting from one number type to another. Used in {@link image.generation.RandomNumber}.
 */
public class NumberCastException extends RuntimeException{
	private static final long serialVersionUID = 6291047287594821685L;
	
	/**
	 * Thrown when casting from one number type to another. Used in {@link image.generation.RandomNumber}.
	 */
	public NumberCastException() {
        super();
    }
	
	/**
	 * Thrown when casting from one number type to another. Used in {@link image.generation.RandomNumber}.
	 */
	public NumberCastException(String s) {
        super(s);
    }
	
	/**
	 * Thrown when casting from one number type to another. Used in {@link image.generation.RandomNumber}.
	 */
	public NumberCastException(String message, Throwable cause) {
        super(message, cause);
    }
	
	/**
	 * Thrown when casting from one number type to another. Used in {@link image.generation.RandomNumber}.
	 */
    public NumberCastException(Throwable cause) {
        super(cause);
    }
}
