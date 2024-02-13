package imagury.system;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * Head class for system-based utilities.
 * @since JLight 0.1.0
 * @author Imagury 
 *
 */
public class SystemUtils {

	/**
	 * Copies a given string to the OS's clipboard.
	 * @param toCopy
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public void copyToClipboard(String toCopy) {
		StringSelection stringSelection = new StringSelection(toCopy);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
