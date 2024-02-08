package image.system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Head class for editing and managing files.
 * @author Image (cursustemporum)
 *
 */
public class FileEditable extends File {

	private static final long serialVersionUID = -295518103315416765L;
	private String pathname;

	/**
	 * Head class for editing and managing files.
	 * @author Image (cursustemporum)
	 *
	 */
	public FileEditable(String pathname) {
		super(pathname);
		this.pathname = pathname;
	}

	/**
	 * Returns file content.
	 * @return String
	 * @throws IOException
	 */
	public String getContent() throws IOException{
		return new String (Files.readAllBytes(Paths.get(this.pathname)));
	}
	
	/**
	 * Creates a duplicated file at the given path.
	 * @param toPath - output path for the copied file.
	 * @throws IOException
	 */
	public void copy(String toPath) throws IOException {
		String write = this.getContent();
		write(write);
	}
	
	/**
	 * Writes to a file. (Overwrites the old content)
	 * @see #appendToFile(String)
	 * @param toWrite
	 * @throws IOException
	 */
	public void write(String toWrite) throws IOException{
		FileWriter w = new FileWriter(this.pathname, false);
		w.write(toWrite);
		w.close();
	}
	
	/**
	 * Appends to a file. (Keeps the old content) <p>
	 * @see #writeToFile(String)
	 * @param toAppend
	 * @throws IOException
	 */
	public void append(String toAppend) throws IOException{
		FileWriter w = new FileWriter(this.pathname, true);
		w.write(toAppend);
		w.close();
	}
}
