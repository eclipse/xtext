/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.google.common.annotations.Beta;

/**
 * This contribution allows to participate in the {@link ToBeBuiltComputer}, e.g. language
 * specific dependencies may be traversed in addition to the plain project contents.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public interface IToBeBuiltComputerContribution {

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
	 * The storage was removed. Discard associated information and schedule transitive changes.
	 * @return <code>true</code> if the storage was processed by the contribution.
	 */
	boolean removeStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor);
	
	/**
	 * The storage was updated. Update associated information and schedule transitive changes.
	 * @return <code>true</code> if the storage was processed by the contribution.
	 */
	boolean updateStorage(ToBeBuilt toBeBuilt, IStorage storage, IProgressMonitor monitor);
	
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
	
	/**
	 * Add all the projects to the result, that may affect the resources in this projects.
	 * The XtextBuilder will return the collected set of projects as the interesting projects after
	 * each build round.
	 * 
	 * @see IncrementalProjectBuilder#build
	 * 
	 * @since 2.19
	 */
	default void addInterestingProjects(IProject thisProject, Set<IProject> result) {
		// per default nothing to do
	}
}
