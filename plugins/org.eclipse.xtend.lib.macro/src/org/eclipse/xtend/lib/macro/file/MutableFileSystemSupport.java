/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.file;

import java.io.InputStream;

import com.google.common.annotations.Beta;

/**
 * Allows modifications on the file system.
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface MutableFileSystemSupport extends FileSystemSupport {

	/**
	 * Writes the given contents to the given path.
	 * It will create the file if it doesn't exist, and create folders for all parents if they don't exist.
	 * 
	 * Implementors may decide to perform this method asynchronously. Clients should not rely on invocation timing. 
	 * 
	 * @param path the path to write the contents to
	 * @param contents the contents of the file
	 */
	void setContents(Path path, CharSequence contents);
	
	/**
	 * Sets the contents of this file to the bytes in the given input stream.
	 * The stream will be closed after the operation has finished.
	 * 
	 * Implementors may decide to perform this method asynchronously. Clients should not rely on invocation timing.
	 *
	 * @param path the path to the file
	 * @param source an input stream containing the new contents of the file
	 */
	void setContentsAsStream(Path path, InputStream source);
	
	/**
	 * <p>
	 * This method will be removed in future versions.
	 * Methods {@link #setContents} and {@link #setContentsAsStream(Path, InputStream)} create folders for all parents if they don't exist.
	 * </p>
	 * 
	 * Creates a directory for the given path and all its parents if necessary.
	 * 
	 * Implementors may decide to perform this method asynchronously. Clients should not rely on invocation timing.
	 * 
	 * @param path the path to the file
	 * @since 2.7
	 */
	@Deprecated
	void mkdir(Path path);
	
	/**
	 * Deletes the file or folder the given path points to. 
	 * If path points to a folder this method will also delete all its contents.
	 * 
	 * Implementors may decide to perform this method asynchronously. Clients should not rely on invocation timing.
	 * 
	 * @param path
	 * @since 2.7
	 */
	void delete(Path path);

}
