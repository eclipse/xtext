/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

import com.google.inject.ImplementedBy;

/**
 * Allows to configure an arbitrary {@link ResourceSet} with an external content provider.
 * Such a resource sets may obtain the content for a resource from a dirty in-memory state
 * instead of the persistent state of the underlying IResource, file or similar.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(ExternalContentSupport.class)
public interface IExternalContentSupport {

	/**
	 * Lightweight abstraction for a contributor of external state. The state is not necessary up to date
	 * with respect to the open documents or the persisted resources. It may be a snapshot from a given point in time.
	 */
	interface IExternalContentProvider {
		
		/**
		 * Get the content that will shadow the persistent state.
		 * @return the actual content that should be parsed to load a resource.
		 */
		String getContent(URI uri);
		
		/**
		 * @return <code>true</code> if and only if external content should be used instead of the persistent one.
		 */
		boolean hasContent(URI uri);
		
		/**
		 * Some use cases may require the latest and most up to date content - mostly in a secured, transactional
		 * context such as a rename refactoring.
		 * 
		 * @return a view on the content provider that reflects always the latest state.
		 */
		IExternalContentProvider getActualContentProvider();
	}
	
	/**
	 * Configure the resource set with an provider of dirty or external content. The resource set will
	 * transparently use the external content to populate its resources. Subsequent calls
	 * will create sort of layers that allow to shadow previously provided content. 
	 * Neither of both arguments may be <code>null</code>.
	 */
	void configureResourceSet(ResourceSet resourceSet, IExternalContentProvider contentProvider);
	
}
