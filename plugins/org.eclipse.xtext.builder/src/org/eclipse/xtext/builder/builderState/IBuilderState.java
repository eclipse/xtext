/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.collect.ImmutableList;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IBuilderState extends IResourceDescriptions {
	
	/**
	 * Updated the underlying {@link IResourceDescriptions} according to the passed URIs.
	 * It updates transitively affected {@link IResourceDescription} as well.
	 * 
	 * The change to the underlying {@link IResourceDescriptions} is guaranteed to be atomic.
	 * 
	 * @param toBeAddedOrUpdated - a map containing URI to String, where the String is the external representation of the underlying storage
	 * @param toBeRemoved - the uris to be removed
	 * 
	 * @return a list of changes in the form of deltas.
	 */
	public ImmutableList<IResourceDescription.Delta> update(Map<URI,IStorage> toBeAddedOrUpdated, Set<URI> toBeRemoved, IProgressMonitor monitor);
}
