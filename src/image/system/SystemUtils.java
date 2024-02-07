package image.system;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * Header class for system-based utilities.
 * @author Image (cursustemporum)
 *
 */
public class SystemUtils {
	
	/**
	 * Copies a declared string to the OS' clipboard.
	 * @param toCopy
	 */
	public void copyToClipboard(String toCopy) {
		StringSelection stringSelection = new StringSelection(toCopy);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
	}
}
