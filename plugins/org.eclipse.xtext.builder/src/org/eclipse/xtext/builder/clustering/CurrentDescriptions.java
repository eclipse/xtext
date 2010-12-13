/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Thomas Wolf <thomas.wolf@paranor.ch> - Performance optimization and JavaDoc
 */
public class CurrentDescriptions extends AdapterImpl implements IResourceDescriptions {

	/**
	 * New index.
	 */
	private final Map<URI, IResourceDescription> currentDescriptions = Maps.newLinkedHashMap();

	/**
	 * Create a new index based on an old one.
	 * 
	 * @param resourceSet
	 *            The resource set
	 * @param oldState
	 *            The old index
	 * @param initiallyDeleted
	 *            URIs of resources physically deleted
	 */
	public CurrentDescriptions(ResourceSet resourceSet, IResourceDescriptions oldState, Set<URI> initiallyDeleted) {
		// TW: Make a copy here...
		for (final IResourceDescription desc : oldState.getAllResourceDescriptions()) {
			final URI uri = desc.getURI();
			if (!initiallyDeleted.contains(uri)) {
				currentDescriptions.put(uri, desc);
			}
		}
		resourceSet.eAdapters().add(this);
	}

	/**
	 * Put a new resource description into the index, or remove one if the delta has no new description. A delta for a
	 * particular URI may be registered more than once; overwriting any earlier registration.
	 * 
	 * @param delta
	 *            The resource change.
	 */
	public void register(IResourceDescription.Delta delta) {
		final IResourceDescription newDesc = delta.getNew();
		if (newDesc == null) {
			currentDescriptions.remove(delta.getUri());
		} else {
			currentDescriptions.put(delta.getUri(), newDesc);
		}
	}

	/**
	 * Return the full contents of the index.
	 * 
	 * @return The index' contents.
	 */
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return currentDescriptions.values();
	}

	/**
	 * Return the resource description for a URI.
	 * 
	 * @param uri
	 *            The URI
	 * @return The resource description, or null if there is none.
	 */
	public IResourceDescription getResourceDescription(URI uri) {
		return currentDescriptions.get(uri);
	}

	/**
	 * @return <code>true</code> if the given type is class {@link CurrentDescriptions}. 
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return CurrentDescriptions.class.equals(type);
	}

	/**
	 * Context-aware instance of our index.
	 */
	public static class ResourceSetAware implements IResourceDescriptions.IContextAware {

		/** Base index. */
		private IResourceDescriptions delegate;

		/**
		 * Set the context.
		 * 
		 * @param ctx
		 *            The context
		 */
		public void setContext(Notifier ctx) {
			final ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
			delegate = (IResourceDescriptions) EcoreUtil.getAdapter(resourceSet.eAdapters(), CurrentDescriptions.class);
		}

		/**
		 * Return the full contents of the index.
		 * 
		 * @return The index' contents.
		 */
		public Iterable<IResourceDescription> getAllResourceDescriptions() {
			return delegate.getAllResourceDescriptions();
		}

		/**
		 * Return the resource description for a URI.
		 * 
		 * @param uri
		 *            The URI
		 * @return The resource description, or null if there is none.
		 */
		public IResourceDescription getResourceDescription(URI uri) {
			return delegate.getResourceDescription(uri);
		}

	}
}