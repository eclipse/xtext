/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.lib.macro.file;

import com.google.common.annotations.Beta;

/**
 * A service which provides information about the location of a path.
 * 
 * @author Sven Efftinge
 * @noimplement This interface is not intended to be implemented by clients.
 */
@Beta
public interface FileLocations {

	/**
	 * Returns the source folder the given handle is contained in or
	 *         <code>null</code> if the given {@link Path} is not
	 *         located in a source folder.
	 *         
	 * @param path an absolute path to a resource
	 * @return the source folder the given handle is contained in or
	 *         <code>null</code> if the given {@link Path} is not
	 *         located in a source folder.
	 * @see Path
	 */
	Path getSourceFolder(Path path);

	/**
	 * Returns the target folder for the given source folder or <code>null</code> if the given
	 * folder is not a source folder or doesn't have a configured target folder.
	 * 
	 * @param sourceFolder the source folder to find the configured target folder for.
	 * @return the target folder
	 */
	Path getTargetFolder(Path sourceFolder);

	
	/**
	 * Returns the project root for the given resource handle.
	 * 
	 * @param path an absolute path 
	 * @return the project's root
	 */
	Path getProjectFolder(Path path);
}
