package image.web;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * Header class for websites.
 * @author Image (cursustemporum)
 *
 */
public class Website {

	private String URL;

	/**
	 * Header class for websites. Uses String type as declaration for the Website's URL.
	 * @author Image (cursustemporum)
	 * @param URL (String)
	 */
	public Website(String URL) {
		this.URL = URL;
	}
	
	/**
	 * Header class for websites. Uses URL type as declaration for the Website's URL.
	 * Recommended to use string-type declaration for a Website, because this constructor is calling the URL's host as a string.
	 * @author Image (cursustemporum)
	 * @param URL (URL-Object)
	 */
	public Website(URL URL) {
		this.URL = URL.getHost();
	}

	/**
	 * Returns a declared {@link #Website}'s URL.
	 * @return URL (String)
	 */
	public String getURL() {
		return this.URL;
	}

	/**
	 * Returns HTML content of a {@link Website}.
	 * Uses Mozilla/4.0 User-Agent as request property.
	 * @return HTML {@link #Website} content (String)
	 * @throws IOException
	 */
	public String readContent() throws IOException {
		String output = "";
		URL url = new URL(this.URL);
		URLConnection spoof = url.openConnection();
		spoof.setRequestProperty( "User-Agent", "Mozilla/4.0 (compatible; MSIE 5.5; Windows NT 5.0; H010818)" );
		BufferedReader in = new BufferedReader(new InputStreamReader(spoof.getInputStream()));
		String strLine = "";
		while ((strLine = in.readLine()) != null) {
			output += output + strLine;
		}
		return output;
	}

	/**
	 * Opens a declared {@link #Website} on your OS.
	 * @param URL
	 */
	public void open() {
		URI uri = URI.create(this.URL);
		try {
			Desktop.getDesktop().browse(uri);
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

	/**
	 * Downloads the HTML content of a declared {@link #Website}. Also a extension for {@link #readContent()}.
	 * @param fileOut - output path for the downloaded file
	 * @throws IOException
	 */
	@SuppressWarnings("unused")
	public void download(String fileOut) throws IOException {
		URL url = new URL(this.URL);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		double fileSize = (double) http.getContentLengthLong();
		BufferedInputStream in = new BufferedInputStream(http.getInputStream());
		FileOutputStream fos = new FileOutputStream(new File(fileOut));
		BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
		byte[] buffer = new byte[1024];
		double downloaded = 0.00;
		int read = 0;
		while((read = in.read(buffer, 0, 1024)) >= 0) {
			bout.write(buffer, 0, read);
			downloaded += read;
		}
		bout.close();
		in.close();
	}
}