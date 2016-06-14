/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.file;

import java.io.InputStream;
import java.net.URI;

import com.google.common.annotations.Beta;

/**
 * 
 * Support for accessing the file system.
 * 
 * @author Anton Kosyakov
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface FileSystemSupport {

	/**
	 * @param path
	 * @return the children of the folder the given path points to; 
	 * 		   empty iterable if the path points to a non existent file or folder
	 * @exception IllegalArgumentException if it is not possible to get children of a given path for some reason 
	 */
	Iterable<? extends Path> getChildren(Path path);
	
	/**
	 * @param path the path
	 * @return whether the given path points to an existent file.
	 */
	boolean exists(Path path);
	
	/**
	 * @param path
	 * @return whether the given path points to an existent folder
	 */
	boolean isFolder(Path path);
	
	/**
	 * @param path
	 * @return whether the given path points to an existent file
	 */
	boolean isFile(Path path);
	
	/**
	 * @param path
	 * @return  A <code>long</code> value representing the time the file was
     *          last modified, measured in milliseconds since the epoch
     *          (00:00:00 GMT, January 1, 1970), or <code>0L</code> if the
     *          file does not exist.
	 */
	long getLastModification(Path path);
	
	/**
	 * Returns the name of a charset to be used when decoding the contents of this 
	 * file into characters. 
	 * 
	 * @param path the path
	 * @return the name of a charset
	 * @exception IllegalArgumentException if it is not possible to get charset of a given path for some reason
	 */
	String getCharset(Path path);

	/**
	 * Returns the contents of this file as a char sequence.
	 * 
	 * @param path the path
	 * @return an input stream containing the contents of the file
	 * @exception IllegalArgumentException if the path points to a non existent file
	 */
	CharSequence getContents(Path path);
	
	/**
	 * Returns an open input stream on the contents of this file.
	 * 
	 * @param path the path
	 * @return an input stream containing the contents of the file
	 * @exception IllegalArgumentException if the path points to a non existent file
	 */
	InputStream getContentsAsStream(Path path);
	
	/**
	 * <p>
	 * Returns the URI representing the given path.
	 * </p>
	 * 
	 * <p>
	 * <b>Warning</b>: Don't use this method to get write access.
	 * </p>
	 * 
	 * @param path
	 *            the path
	 * @return the URI representing the given path or <code>null</code> if the path points to a non existent file or a folder.
	 */
	URI toURI(Path path);
}
