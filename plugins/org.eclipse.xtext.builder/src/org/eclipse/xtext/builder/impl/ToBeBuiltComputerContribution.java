/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * This contribution allows to participate in the {@link ToBeBuiltComputer}, e.g. language
 * specific dependencies may be traversed in addition to the plain project contents.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ToBeBuiltComputerContribution {

	/**
	 * Triggered by a clean build or for closed projects.
	 * 
	 * Remove all associated cached information.
	 */
	void removeProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor);
	
	/**
	 * Triggered by a full build. Update all associated information.
	 */
	void updateProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) throws CoreException;
	
	/**
	 * The storage was removed. Discard associated information.
	 */
	boolean removeStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor);
	
	/**
	 * Returns <code>true</code> if the given storage is possibly process-able by the builder.
	 * That is, the storage type can be processed by this contribution. 
	 */
	boolean isPossiblyHandled(IStorage storage);
	
	/**
	 * Returns <code>true</code> if the folder contains resources that are fully derived, e.g. they
	 * should not be processed by the Xtext builder.
	 */
	boolean isRejected(IFolder folder);
}
