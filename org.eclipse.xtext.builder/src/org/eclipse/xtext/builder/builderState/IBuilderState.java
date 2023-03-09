/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.impl.BuildData;
import org.eclipse.xtext.builder.impl.SetWithProjectNames;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.collect.ImmutableList;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public interface IBuilderState extends IResourceDescriptions, IResourceDescription.Event.Source {
	
	/**
	 * Updated the underlying {@link IResourceDescriptions} according to the passed URIs.
	 * It updates transitively affected {@link IResourceDescription} as well.
	 * 
	 * The change to the underlying {@link IResourceDescriptions} is guaranteed to be atomic.
	 * 
	 * @param buildData the underlying data for the update.
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be canceled.
	 * 
	 * @return a list of changes in the form of deltas.
	 */
	ImmutableList<IResourceDescription.Delta> update(BuildData buildData, IProgressMonitor monitor);
	
	/**
	 * Remove the descriptions for the given resource-uris from the {@link IResourceDescriptions}.
	 * The clean-operation is not transitive.
	 * 
	 * The change to the underlying {@link IResourceDescriptions} is guaranteed to be atomic.
	 * 
	 * @param toBeRemoved the uris or the cleaned resources. The set may be an instance of {@link SetWithProjectNames}
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be canceled.
	 *        
	 * @return a list of changes in the form of deltas.
	 * @see SetWithProjectNames
	 */
	ImmutableList<IResourceDescription.Delta> clean(Set<URI> toBeRemoved, IProgressMonitor monitor);
}
