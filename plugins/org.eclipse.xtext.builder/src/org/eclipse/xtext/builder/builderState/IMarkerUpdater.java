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
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.ui.validation.IResourceUIValidatorExtension;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(MarkerUpdaterImpl.class)
public interface IMarkerUpdater {
	/**
	 * Deletes or updates the {@link org.eclipse.core.resources.IMarker markers} for the given resource delta by 
	 * delegating to {@link IResourceUIValidatorExtension}.
	 * 
	 * @param resourceSet context resource set from which the updated resource may be obtained; may be {@code null}
	 *        if the delta represents a resource deletion.
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	public void updateMarkers(Delta delta, ResourceSet resourceSet, IProgressMonitor monitor);
}
