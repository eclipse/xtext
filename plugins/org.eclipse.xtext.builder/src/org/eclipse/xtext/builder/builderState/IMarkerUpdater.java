/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.collect.ImmutableList;
import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(MarkerUpdaterImpl.class)
public interface IMarkerUpdater {
	/**
	 * updates the {@link org.eclipse.core.resources.IMarker} for all changed resources.
	 */
	public void updateMarker(ResourceSet resourceSet,
			ImmutableList<IResourceDescription.Delta> resourceDescriptionDeltas, IProgressMonitor monitor);
}
