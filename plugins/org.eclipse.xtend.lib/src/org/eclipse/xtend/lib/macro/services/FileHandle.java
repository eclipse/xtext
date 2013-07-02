package org.eclipse.xtend.lib.macro.services;

import java.io.InputStream;
import java.io.OutputStream;

import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Procedures;

import com.google.common.annotations.Beta;

/**
 * Representation of a file.
 * 
 * @author Anton Kosyakov
 * 
 */
@Beta
public interface FileHandle extends ResourceHandle {

	/**
	 * Returns the contents of this file as string.
	 * 
	 * 
	 * @return the contents of this file as string
	 */
	String getContents();

	/**
	 * <p>
	 * Opens the input stream on the contents of this file and passes it into
	 * the given function.
	 * </p>
	 * <p>
	 * After invocation of the function this method closes the input stream.
	 * </p>
	 * 
	 * @param function
	 *            - the function which processes the input stream
	 * 
	 */
	void read(Procedures.Procedure1<InputStream> function);

	/**
	 * <p>
	 * Opens the output stream and writes the contents which is provided by the
	 * given function.
	 * </p>
	 * <p>
	 * After writing of the contents into the file closes the output stream.
	 * </p>
	 * 
	 * @param function
	 *            - the function which provides the contents as string
	 */
	void writeContents(Functions.Function1<FileHandle, CharSequence> function);

	/**
	 * <p>
	 * Opens the output stream and passes it into the given function.
	 * </p>
	 * <p>
	 * After invocation of the function closes the output stream.
	 * </p>
	 * 
	 * @param function
	 *            - the function which processes the output stream
	 */
	void write(Procedures.Procedure1<OutputStream> function);

}
