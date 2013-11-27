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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ToBeBuiltComputerContribution {

	void removeProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor);
	void updateProject(ToBeBuilt toBeBuilt, IProject project, IProgressMonitor monitor) throws CoreException;
	
	boolean removeStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor);
	
	boolean isPossiblyHandled(IStorage storage);
	boolean isRejected(IFolder folder);
}
