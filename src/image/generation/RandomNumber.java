package image.generation;

import java.util.Random;

import image.enums.NumberSign;
import image.exception.NumberCastException;

/**
 * Header class for number-generating methods and constructors.
 * @author Image (cursustemporum)
 *
 */
public class RandomNumber {

	static boolean lastBool = false;
	static int lastInt = 0;
	static byte lastByte = 0;
	static short lastShort = 0;
	static long lastLong = 0;
	static float lastFloat = 0;
	static double lastDouble = 0.0;
	static Number last = 0;

	/**
	 * Header Constructor for using random numbers. Access this class' methods by creating an instance of it.
	 */
	public RandomNumber() {}

	/**
	 * Header Constructor for using random numbers. For 'type', put in the type of number related to java. (Byte, Short, Integer, Long, Float, Double).
	 * Multiple number types can be created and recalled in one instance at any time.
	 * This very constructor is just used to shorten code. Recommended to use default generating constructors.
	 * Returns a random number.
	 * @return Number
	 */
	@Deprecated
	public RandomNumber(Class<?extends Number> type) {
		if(type.equals(Integer.class)) {
			lastInt = generateInt();
			last = lastInt;
		}else if(type.equals(Byte.class)) {
			lastByte = generateByte();
			last = lastByte;
		}else if(type.equals(Short.class)) {
			lastShort = generateShort();
			last = lastShort;
		}else if(type.equals(Long.class)) {
			lastLong = generateLong();
			last = lastLong;
		}else if(type.equals(Float.class)) {
			lastFloat = generateFloat();
			last = lastFloat;
		}else if(type.equals(Double.class)) {
			lastDouble = generateDouble();
			last = lastDouble;
		}else{
			throw new IllegalArgumentException(type.toString() + "is not a valid number type.");
		}
	}

	/**
	 * Header Constructor for using random numbers. For 'type', put in the type of number related to java. (Byte, Short, Integer, Long, Float, Double).
	 * Multiple number types can be created and recalled in one instance at any time.
	 * Returns a random number with set sign.
	 * @return Number
	 */
	@Deprecated
	public RandomNumber(Number type, NumberSign sign) {
		if(type instanceof Integer) {
			lastInt = generateInt(sign);
			last = lastInt;
		}else if(type instanceof Byte) {
			lastByte = generateByte();
			last = lastByte;
		}else if(type instanceof Short) {
			lastShort = generateShort(sign);
			last = lastShort;
		}else if(type instanceof Long) {
			lastLong = generateLong(sign);
			last = lastLong;
		}else if(type instanceof Float) {
			lastFloat = generateFloat(sign);
			last = lastFloat;
		}else if(type instanceof Double) {
			lastDouble = generateDouble(sign);
			last = lastDouble;
		}else{
			throw new IllegalArgumentException(type.toString() + "is not a valid number type.");
		}
	}

	/**
	 * Header Constructor for using random numbers. For 'type', put in the type of number related to java. (Byte, Short, Integer, Long, Float, Double).
	 * Multiple number types can be created and recalled in one instance at any time.
	 * Returns a random number with set sign and max limit.
	 * @return Number
	 */
	@Deprecated
	public RandomNumber(Number type, NumberSign sign, double max) {
		if(type instanceof Integer) {
			try {
				int maxB = Integer.parseInt(String.valueOf(max));
				lastInt = generateInt(sign, maxB);
				last = lastInt;
			} catch (NumberCastException e) {
				e.printStackTrace();
			}
		}else if(type instanceof Byte) {
			try {
				byte maxB = Byte.parseByte(String.valueOf(max));
				lastByte = generateByte(maxB);
				last = lastByte;
			} catch (NumberCastException e) {
				e.printStackTrace();
			}
		}else if(type instanceof Short) {
			try {
				Short maxB = Short.parseShort(String.valueOf(max));
				lastShort = (short) generateShort(sign, maxB);
				last = lastShort;
			} catch (NumberCastException e) {
				e.printStackTrace();
			}
		}else if(type instanceof Long) {
			lastLong = generateLong(sign);
			last = lastLong;
		}else if(type instanceof Float) {
			lastFloat = generateFloat(sign);
			last = lastFloat;
		}else if(type instanceof Double) {
			lastDouble = generateDouble(sign);
			last = lastDouble;
		}else{
			throw new IllegalArgumentException(type.toString() + "is not a valid number type.");
		}
	}

	/**
	 * Generates a random boolean.<b>
	 * Alternative: Random byte/short/number with reach 0 to 1.
	 * @return Boolean
	 * @see Boolean
	 * @see Random
	 */
	public boolean generateBool() {
		boolean fin = false;
		Random random = new Random();
		fin = random.nextBoolean();
		lastBool = fin;
		return fin;
	}

	/**
	 * Generates a random integer within the maximum integer limit.
	 * @return Integer
	 * @see Integer
	 * @see Random
	 */
	public int generateInt() {
		int fin = 0;
		Random random = new Random();
		fin = random.nextInt();
		lastInt = fin;
		return fin;
	}

	/**
	 * Generates a random integer with the number sign being fixed.
	 * @return Integer (fixed sign)
	 * @see Integer
	 * @see Random
	 * @param sign - declaration if the number is positive or negative
	 */
	public int generateInt(NumberSign sign) {
		int fin = 0;
		Random random = new Random();
		fin = random.nextInt();
		if(sign.equals(NumberSign.NEGATIVE)) {
			if(fin > 0) {
				fin = fin * -1;
			}
		}else if(sign.equals(NumberSign.POSITIVE)) {
			if(fin < 0) {
				fin = fin * -1;
			}
		}
		lastInt = fin;
		return fin;
	}

	/**
	 * Generates a random integer with the number sign 
	 * being fixed and a maximum number limit.
	 * @return Integer (fixed sign, number limit)
	 * @see Integer
	 * @see Random
	 * @param sign - declaration if the number is positive or negative
	 * @param maxValue - maximal value for the output integer.
	 */
	public int generateInt(NumberSign sign, int maxValue) {
		int fin = 0;
		Random random = new Random();
		fin = random.nextInt(maxValue);
		if(sign.equals(NumberSign.NEGATIVE)) {
			if(fin > 0) {
				fin = fin * -1;
			}
		}else if(sign.equals(NumberSign.POSITIVE)) {
			if(fin < 0) {
				fin = fin * -1;
			}
		}
		lastInt = fin;
		return fin;

	}

	/**
	 * Generates a random long within the maximum long limit.
	 * A maximum value does not exist here because of problems 
	 * in the code. Might be fixed very soon.
	 * @return Long
	 * @see Long
	 * @see Random
	 */
	public long generateLong() {
		long fin = 0;
		Random random = new Random();
		fin = random.nextLong();
		lastLong = fin;
		return fin;
	}

	/**
	 * Generates a random long with the number sign being fixed.
	 * A maximum value does not exist here because of problems 
	 * in the code. Might be fixed very soon.
	 * @return Long (fixed sign)
	 * @see Long
	 * @see Random
	 * @param sign - declaration if the number is positive or negative
	 */
	public long generateLong(NumberSign sign) {
		long fin = 0;
		Random random = new Random();
		fin = random.nextLong();
		if(sign.equals(NumberSign.NEGATIVE)) {
			if(fin > 0) {
				fin = fin * -1;
			}
		}else if(sign.equals(NumberSign.POSITIVE)) {
			if(fin < 0) {
				fin = fin * -1;
			}
		}
		lastLong = fin;
		return fin;
	}

	/**
	 * Generates a random short within the maximum short limit.
	 * Shorts are always positive in normal circumstances,
	 * this can be changed with the 'NumberSign' parameter.
	 * @return Short
	 * @see Short
	 * @see Random
	 */
	public short generateShort() {
		short fin = 0;
		Random random = new Random();
		fin = (short) random.nextInt(Short.MAX_VALUE + 1);
		lastShort = fin;
		return fin;
	}

	/**
	 * Generates a random short with the number sign being fixed.
	 * Shorts are always positive in normal circumstances,
	 * this can be changed with the 'NumberSign' parameter.
	 * @return Short (fixed sign)
	 * @see Short
	 * @see Random
	 * @param sign - declaration if the number is positive or negative
	 */
	public short generateShort(NumberSign sign) {
		short fin = 0;
		Random random = new Random();
		fin = (short) random.nextInt(Short.MAX_VALUE + 1);;
		if(sign.equals(NumberSign.NEGATIVE)) {
			if(fin > 0) {
				fin = (short) (fin * -1);
			}
		}else if(sign.equals(NumberSign.POSITIVE)) {
			if(fin < 0) {
				fin = (short) (fin * -1);
			}
		}
		lastShort = fin;
		return fin;
	}

	/**
	 * Generates a random short with the number sign 
	 * being fixed and a maximum number limit.
	 * Shorts are always positive in normal circumstances,
	 * this can be changed with the 'NumberSign' parameter.
	 * @return Short (fixed sign, number limit)
	 * @see Short
	 * @see Random
	 * @param sign - declaration if the number is positive or negative
	 * @param maxValue - maximal value for the output short.
	 */
	public int generateShort(NumberSign sign, short maxValue) {
		short fin = 0;
		Random random = new Random();
		fin = (short) random.nextInt(maxValue);
		if(sign.equals(NumberSign.NEGATIVE)) {
			if(fin > 0) {
				fin = (short) (fin * -1);
			}
		}else if(sign.equals(NumberSign.POSITIVE)) {
			if(fin < 0) {
				fin = (short) (fin * -1);
			}
		}
		lastShort = fin;
		return fin;
	}


	/**
	 * Generates a random float within the maximum float limit.
	 * A maximum value does not exist here because of problems 
	 * in the code. Might be fixed very soon.
	 * @return Float
	 * @see Float
	 * @see Random
	 */
	public float generateFloat() {
		float fin = 0;
		Random random = new Random();
		fin = random.nextFloat();
		lastFloat = fin;
		return fin;
	}

	/**
	 * Generates a random float with the number sign being fixed.
	 * A maximum value does not exist here because of problems 
	 * in the code. Might be fixed very soon.
	 * @return Float (fixed sign)
	 * @see Float
	 * @see Random
	 * @param sign - declaration if the number is positive or negative
	 */
	public float generateFloat(NumberSign sign) {
		float fin = 0;
		Random random = new Random();
		fin = random.nextFloat();
		if(sign.equals(NumberSign.NEGATIVE)) {
			if(fin > 0) {
				fin = fin * -1;
			}
		}else if(sign.equals(NumberSign.POSITIVE)) {
			if(fin < 0) {
				fin = fin * -1;
			}
		}
		lastFloat = fin;
		return fin;
	}


	/**
	 * Generates a random double within the maximum double limit.
	 * A maximum value does not exist here because of problems 
	 * in the code. Might be fixed very soon.
	 * @return Double
	 * @see Double
	 * @see Random
	 */
	public double generateDouble() {
		double fin = 0;
		Random random = new Random();
		fin = random.nextGaussian();
		lastDouble = fin;
		return fin;
	}

	/**
	 * Generates a random double with the number sign being fixed.
	 * A maximum value does not exist here because of problems 
	 * in the code. Might be fixed very soon.
	 * @return Double (fixed sign)
	 * @see Double
	 * @see Random
	 * @param sign - declaration if the number is positive or negative
	 */
	public double generateDouble(NumberSign sign) {
		double fin = 0;
		Random random = new Random();
		fin = random.nextGaussian();
		if(sign.equals(NumberSign.NEGATIVE)) {
			if(fin > 0) {
				fin = fin * -1;
			}
		}else if(sign.equals(NumberSign.POSITIVE)) {
			if(fin < 0) {
				fin = fin * -1;
			}
		}
		lastDouble = fin;
		return fin;
	}

	/**
	 * Generates a random byte within the maximum byte limit.
	 * @return Byte
	 * @see Byte
	 * @see Random
	 */
	public byte generateByte() {
		int fin = 0;
		fin = generateInt(NumberSign.POSITIVE, 127);
		lastByte = (byte) fin;
		return (byte) fin;
	}

	/**
	 * Generates a random byte within a custom limit and set number sign.
	 * @return Byte
	 * @see Byte
	 * @see Random
	 */
	public byte generateByte(byte max) {
		int fin = 0;
		fin = generateInt(NumberSign.POSITIVE, max);
		lastByte = (byte) fin;
		return (byte) fin;
	}

	/**
	 * Returns last Integer created using this class' methods. Multiple number types can be created and recalled in one instance at any time.
	 * @return Integer
	 */
	public int getLastInt() {
		return lastInt;
	}

	/**
	 * Returns last Byte created using this class' methods. Multiple number types can be created and recalled in one instance at any time.
	 * @return Byte
	 */
	public byte getLastByte() {
		return lastByte;
	}

	/**
	 * Returns last Short created using this class' methods. Multiple number types can be created and recalled in one instance at any time.
	 * @return Short
	 */
	public short getLastShort() {
		return lastShort;
	}

	/**
	 * Returns last Long created using this class' methods. Multiple number types can be created and recalled in one instance at any time.
	 * @return Long
	 */
	public long getLastLong() {
		return lastLong;
	}

	/**
	 * Returns last Float created using this class' methods. Multiple number types can be created and recalled in one instance at any time.
	 * @return Float
	 */
	public float getLastFloat() {
		return lastFloat;
	}

	/**
	 * Returns last Double created using this class' methods. Multiple number types can be created and recalled in one instance at any time.
	 * @return Double
	 */
	public double getLastDouble() {
		return lastDouble;
	}

	/**
	 * Returns last Number created using this class' methods. Multiple number types can be created and recalled in one instance at any time.
	 * @return Number
	 */
	public Number getLast() {
		return last;
	}
}