package imagury.system;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Head class for editing and managing files.
 * @since JLight 0.1.0
 * @author Imagury 
 *
 */
public class FileEditable extends File {

	private static final long serialVersionUID = -295518103315416765L;
	private String pathname;

	/**
	 * Head class for editing and managing files.
	 * This constructor creates a new FileEditable from a file path.
	 * @since JLight 0.1.0
	 * @author Imagury 
	 *
	 */
	public FileEditable(String pathname) {
		super(pathname);
		this.pathname = pathname;
	}
	
	/**
	 * Head class for editing and managing files.
	 * This constructor creates a new FileEditable from a given file.
	 * @since JLight 0.1.0
	 * @author Imagury 
	 *
	 */
	public FileEditable(File file) {
		super(file.getAbsolutePath());
		this.pathname = file.getAbsolutePath();
	}

	/**
	 * Returns the content from the declared file. The output will be returned in UTF-8 encoding.
	 * @return String
	 * @throws IOException
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public String getContent() throws IOException{
		return new String (Files.readAllBytes(Paths.get(this.pathname)));
	}

	/**
	 * Creates a duplicated file at the given path.
	 * @param toPath - output path for the copied file.
	 * @throws IOException
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public void copy(String toPath) throws IOException {
		File n = new File(toPath);
		FileEditable ne = new FileEditable(n);
		String write = this.getContent();
		ne.write(write);
	}

	/**
	 * Writes to a file. (Overwrites the old content)
	 * @see #appendToFile(String)
	 * @param toWrite
	 * @throws IOException
	 * @since JLight 0.1.0
	 * @author Imagury 
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
	 * @since JLight 0.1.0
	 * @author Imagury 
	 */
	public void append(String toAppend) throws IOException{
		FileWriter w = new FileWriter(this.pathname, true);
		w.write(toAppend);
		w.close();
	}
}
