/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import org.eclipse.xtext.util.RuntimeIOException;

/**
 * This interface extends {@link IFileSystemAccess} with the capability to check files for existence.
 *
 * @author Karsten Thoms - Initial contribution and API
 * @since 2.9
 */
public interface IFileSystemAccessExtension4 {

	/**
	 * Tests whether the file exists at the location denoted by the output configuration.
	 * @param path using '/' as path separator
	 * @param outputConfigurationName the name of the output configuration
	 * @return <code>true</code> when the file at the given path exists and is a normal file. Will return <code>false</code> when
	 * the path belongs to a directory.
	 */
	boolean isFile (String path, String outputConfigurationName) throws RuntimeIOException;
}
