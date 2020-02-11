/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;

/**
 * Representation of a resource that is currently edited. The accessible 
 * values may represent a cached, intermediate state of the resource. They 
 * are not necessarily a live view on the underlying resource. 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IDirtyResource {

	/**
	 * @return the content of the resource as text, never <code>null</code>. May be the content of a 
	 * snapshot.
	 * @see InitializationAware#getContentsIfInitialized()
	 */
	String getContents();
	
	/**
	 * @return the current content of the underlying document or resource as text, never <code>null</code>.
	 * @see InitializationAware#getActualContentsIfInitialized()
	 */
	String getActualContents();
	
	/**
	 * @return the description of the resource, never <code>null</code>.
	 * @see InitializationAware#getDescriptionIfInitialized()
	 */
	IResourceDescription getDescription();
	
	/**
	 * @return the URI of the resource, never <code>null</code>.
	 */
	URI getURI();

	/**
	 * An extension interface for {@link IDirtyResource}
	 * 
	 * @since 2.4
	 */
	interface NormalizedURISupportExtension extends IDirtyResource {
		/**
		 * @return the normalized URI of the resource, never <code>null</code>.
		 */
		URI getNormalizedURI();
	}
	
	/**
	 * An extension interface for {@link IDirtyResource}.
	 * 
	 * Still provisional
	 * 
	 * @since 2.8
	 * @noreference This interface is not intended to be referenced by clients.
	 * @noextend This interface is not intended to be extended by clients.
	 * @noimplement This interface is not intended to be implemented by clients.
	 */
	interface ICurrentStateProvidingExtension {
		
		/**
		 * @noreference This method is not intended to be referenced by clients.
		 * @nooverride This default method is not intended to be re-implemented or extended by clients.
		 */
		public ResourceStorageLoadable getResourceStorageLoadable(); 
	}
	
	/**
	 * Allows to query the dirty resource for its initialization state.
	 * 
	 * @author Sebastian Zarnekow - Initial contribution and API
	 * @since 2.8
	 * @noextend This interface is not intended to be extended by clients.
	 * @noimplement This interface is not intended to be implemented by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	interface InitializationAware extends IDirtyResource{

		/**
		 * Returns {@code true} if the resource is initialized.
		 */
		boolean isInitialized();
		
		/**
		 * Returns the content of the resource as text. If the dirty description
		 * is not yet initialized, returns {@code null}.
		 * 
		 * @see #getContents()
		 */
		String getContentsIfInitialized();
		
		/**
		 * Returns the current content of the underlying document or resource as text. If the dirty description
		 * is not yet initialized, returns {@code null}.
		 * 
		 * @see #getActualContents()
		 */
		String getActualContentsIfInitialized();
		
		/**
		 * @return the description of the resource or {@code null}, if the resource is not yet initialized.
		 * @see #getDescription()
		 */
		IResourceDescription getDescriptionIfInitialized();
		
	}
}
