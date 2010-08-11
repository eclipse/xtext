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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ResourceDescriptionsUpdater.class)
public interface IResourceDescriptionsUpdater {

	Collection<IResourceDescription.Delta> transitiveUpdate(IResourceDescriptions oldState, ResourceSet rs,
			Set<URI> toBeUpdated, Set<URI> toBeDeleted, IProgressMonitor monitor);
	
	Collection<IResourceDescription.Delta> clean(IResourceDescriptions oldState, Set<URI> toBeDeleted, IProgressMonitor monitor);
	
}
