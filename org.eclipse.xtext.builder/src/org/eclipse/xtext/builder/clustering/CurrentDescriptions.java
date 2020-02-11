/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.clustering;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.builder.impl.BuildData;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Thomas Wolf <thomas.wolf@paranor.ch> - Performance optimization and JavaDoc
 */
public class CurrentDescriptions extends AdapterImpl implements IResourceDescriptions.IResourceSetAware {

	/**
	 * New index.
	 */
	private final ResourceDescriptionsData newData;
	
	private BuildData buildData;
	
	/**
	 * @since 2.4
	 */
	public BuildData getBuildData() {
		return buildData;
	}

	/**
	 * Create a new index based on an old one.
	 * 
	 * @param resourceSet
	 *            The resource set
	 * @param newData
	 *            the new index state.
	 */
	public CurrentDescriptions(ResourceSet resourceSet, ResourceDescriptionsData newData) {
		this.newData = newData;
		resourceSet.eAdapters().add(this);
	}
	
	
	/**
	 * Create a new index based on an old one.
	 * 
	 * @param resourceSet
	 *            The resource set
	 * @param newData
	 *            the new index state.
	 * @param buildData
	 * 			  the currently processed builddata
	 * @since 2.4            
	 */
	public CurrentDescriptions(ResourceSet resourceSet, ResourceDescriptionsData newData, BuildData buildData) {
		this(resourceSet, newData);
		this.buildData = buildData;
	}

	/**
	 * Put a new resource description into the index, or remove one if the delta has no new description. A delta for a
	 * particular URI may be registered more than once; overwriting any earlier registration.
	 * 
	 * @param delta
	 *            The resource change.
	 */
	public void register(IResourceDescription.Delta delta) {
		newData.register(delta);
	}

	/**
	 * Return the full contents of the index.
	 * 
	 * @return The index' contents.
	 */
	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return newData.getAllResourceDescriptions();
	}

	/**
	 * Return the resource description for a URI.
	 * 
	 * @param uri
	 *            The URI
	 * @return The resource description, or null if there is none.
	 */
	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		return newData.getResourceDescription(uri);
	}

	@Override
	public boolean isEmpty() {
		return newData.isEmpty();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		return newData.getExportedObjects();
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		return newData.getExportedObjects(type, name, ignoreCase);
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		return newData.getExportedObjectsByType(type);
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		return newData.getExportedObjectsByObject(object);
	}

	/**
	 * @return <code>true</code> if the given type is class {@link CurrentDescriptions}. 
	 */
	@Override
	public boolean isAdapterForType(Object type) {
		return CurrentDescriptions.class.equals(type);
	}

	/**
	 * @since 2.17
	 */
	@Override
	public ResourceSet getResourceSet() {
		Object target = getTarget();
		ResourceSet resourceSet = (ResourceSet) checkNotNull(target);
		return resourceSet;
	}

	/**
	 * Context-aware instance of our index.
	 */
	public static class ResourceSetAware implements IResourceDescriptions.IContextAware, IResourceDescriptions.IResourceSetAware {

		/** Base index. */
		private IResourceDescriptions delegate;
		
		public IResourceDescriptions getDelegate() {
			return delegate;
		}

		/**
		 * Set the context.
		 * 
		 * @param ctx
		 *            The context
		 */
		@Override
		public void setContext(Notifier ctx) {
			final ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
			delegate = (IResourceDescriptions) EcoreUtil.getAdapter(resourceSet.eAdapters(), CurrentDescriptions.class);
		}

		/**
		 * Return the full contents of the index.
		 * 
		 * @return The index' contents.
		 */
		@Override
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
		@Override
		public IResourceDescription getResourceDescription(URI uri) {
			return delegate.getResourceDescription(uri);
		}

		@Override
		public boolean isEmpty() {
			return delegate.isEmpty();
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjects() {
			return delegate.getExportedObjects();
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
			return delegate.getExportedObjects(type, name, ignoreCase);
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
			return delegate.getExportedObjectsByType(type);
		}

		@Override
		public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
			return delegate.getExportedObjectsByObject(object);
		}

		/**
		 * @since 2.17
		 */
		@Override
		public ResourceSet getResourceSet() {
			checkNotNull(delegate);
			IResourceSetAware resourceSetAware = (IResourceSetAware) delegate;
			ResourceSet resourceSet = resourceSetAware.getResourceSet();
			return resourceSet;
		}
	}
}