/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Collection;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.inject.ImplementedBy;

/**
 * Strategy that implements the transitive analysis of dependencies among resources. 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ResourceDescriptionsUpdater.class)
public interface IResourceDescriptionsUpdater {

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	Collection<IResourceDescription.Delta> transitiveUpdate(IResourceDescriptions oldState, ResourceSet rs,
			Set<URI> toBeUpdated, Set<URI> toBeDeleted, IProgressMonitor monitor);
	
	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	Collection<IResourceDescription.Delta> clean(IResourceDescriptions oldState, Set<URI> toBeDeleted, IProgressMonitor monitor);
	
}
