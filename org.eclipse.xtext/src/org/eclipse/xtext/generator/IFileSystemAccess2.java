/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.xtext.util.RuntimeIOException;

/**
 * Abstraction for file system operations with the added value of a logical
 * path mapping (outlet).
 * 
 * This interface composes all the extension interfaces to {@link IFileSystemAccess}.
 * Further enhancements will be implemented directly in this interface. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noimplement This interface is not intended to be implemented by clients.
 * @since 2.9
 */
public interface IFileSystemAccess2 extends IFileSystemAccess, IFileSystemAccessExtension, IFileSystemAccessExtension2, IFileSystemAccessExtension3 {

	/**
	 * Tests whether the file exists at the location denoted by the output configuration.
	 * Returns {@code true} if the file at the described location exists and is a normal file
	 * (not a directory). Otherwise {@code false}.
	 * 
	 * @param path using '/' as path separator
	 * @param outputConfigurationName the name of the output configuration
	 * @return <code>true</code> when the file at the given path exists and is a normal file. Will return <code>false</code> when
	 * the path belongs to a directory.
	 */
	boolean isFile (String path, String outputConfigurationName) throws RuntimeIOException;
	
	/**
	 * Tests whether the file exists at the location in the default output configuration.
	 * Returns {@code true} if the file at the described location exists and is a normal file
	 * (not a directory). Otherwise {@code false}.
	 * 
	 * @param path using '/' as path separator
	 * @return <code>true</code> when the file at the given path exists and is a normal file. Will return <code>false</code> when
	 * the path belongs to a directory.
	 */
	boolean isFile (String path) throws RuntimeIOException;
	
}
