package image.system;

/**
 * Head class for receiving system properties available by Java.
 * @author Image (cursustemporum)
 *
 */
public class SystemProperty {

	/**
	 * Returns the path used to find directories and jar archives containing class files.
	 * @return java.class.path
	 */
	public static String getJavaClassPath() {
		return System.getProperty("java.class.path");
	}
	
	/**
	 * Returns the Java home directory.
	 * @return java.home
	 */
	public static String getJavaHome() {
		return System.getProperty("java.home");
	}
	
	/**
	 * Returns the Java vendor name.
	 * @return java.vendor
	 */
	public static String getJavaVendor() {
		return System.getProperty("java.vendor");
	}
	
	/**
	 * Returns the Java vendor URL.
	 * @return java.vendor.url
	 */
	public static String getJavaVendorURL() {
		return System.getProperty("java.vendor.url");
	}
	
	/**
	 * Returns the Java version.
	 * @return java.version
	 */
	public static String getJavaVersion() {
		return System.getProperty("java.version");
	}
	
	/**
	 * Returns the character that separates parts of a file path. "/" (UNIX) and "\" (WINDOWS) are commonly used.
	 * @return file.separator
	 */
	public static String getSystemFileSeparator() {
		return System.getProperty("file.separator");
	}
	
	/**
	 * Returns the character/sequence that is used to separate lines in text files from the OS.
	 * @return line.separator
	 */
	public static String getSystemLineSeparator() {
		return System.getProperty("line.separator");
	}
	
	/**
	 * Returns the path separator used in the java class path.
	 * @return path.separator
	 */
	public static String getSystemPathSeparator() {
		return System.getProperty("path.separator");
	}
	
	/**
	 * Returns the current OS architecture type.
	 * @return os.arch
	 */
	public static String getSystemArchitecture() {
		return System.getProperty("os.arch");
	}
	
	/**
	 * Returns the current OS name.
	 * @return os.name
	 */
	public static String getSystemName() {
		return System.getProperty("os.name");
	}
	
	/**
	 * Returns the current OS version.
	 * @return os.version
	 */
	public static String getSystemVersion() {
		return System.getProperty("os.version");
	}
	
	/**
	 * Returns the directory user files are located in.
	 * @return
	 */
	public static String getUserHomeDirectory() {
		return System.getProperty("user.home");
	}
	
	/**
	 * Returns the directory the current program was started in.
	 * @return user.dir
	 */
	public static String getUserWorkingDirectory() {
		return System.getProperty("user.dir");
	}
	
	/**
	 * Returns the system username.
	 * @return user.name
	 */
	public static String getUserName() {
		return System.getProperty("user.name");
	}
	
}
