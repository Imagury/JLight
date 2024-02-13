package imagury.math;

/**
 * Head class for logarithmic calculations.
 * @since JLight 0.3.0
 * @author Imagury 
 *
 */
public class Logarithm {

	/**
	 * Calculates the binary logarithm of ARGUMENT.
	 * @param argument - input number
	 * @return Binary logarithm of ARGUMENT
	 * @since JLight 0.3.0
	 * @author Imagury 
	 */
	public final static double log2(int argument){
		return Math.log(argument) / Math.log(2);
	}

	/**
	 * Calculates the logarithm of ARGUMENT with a custom BASE.
	 * @param argument - input number
	 * @param base - input base
	 * @return Logarithm of ARGUMENT
	 * @since JLight 0.3.0
	 * @author Imagury 
	 */
	public final static double log(int base, int argument) {
		return log2(argument) / log2(base);
	}
}
