/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.xtext;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IShadowedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * This specialization of the {@link ResourceDescriptionsProvider} filters
 * locally defined elements from the resource descriptions during the indexing phase.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - Extracted to be reusable in Maven build
 * @since 2.8
 */
public abstract class AbstractProjectAwareResourceDescriptionsProvider extends ResourceDescriptionsProvider {
	
	@Inject CompilerPhases compilerPhases;
	
	/**
	 * And if we are in the indexing phase, we don't want to see the local resources.
	 */
	@Override 
	public IResourceDescriptions getResourceDescriptions(ResourceSet resourceSet) {
		IResourceDescriptions result = super.getResourceDescriptions(resourceSet);
		if (compilerPhases.isIndexing(resourceSet)) {
			// during indexing we don't want to see any local files
			String projectName = getProjectName(resourceSet);
			if(projectName != null) {
				final String encodedProjectName = URI.encodeSegment(projectName, true);
				Predicate<URI> predicate = new Predicate<URI>() {
					@Override
					public boolean apply(URI uri) {
						return isProjectLocal(uri, encodedProjectName);
					}

				};
				if (result instanceof IShadowedResourceDescriptions) {
					return new ShadowedFilteringResourceDescriptions(result, predicate);
				} else {
					return new FilteringResourceDescriptions(result, predicate);
				}
			}	
		} 
		return result;
	}
	
	/**
	 * @since 2.9
	 */
	protected boolean isProjectLocal(URI uri, final String encodedProjectName) {
		if (uri == null || uri.segmentCount() < 2 || !uri.isPlatformResource())
			return false;
		else 
			return !uri.segment(1).equals(encodedProjectName);
	}

	protected abstract String getProjectName(ResourceSet resourceSet);
	
	/**
	 * Resource descriptions implementation that allows to filter a delegate instance
	 * based on the URI of the resource description.
	 * 
	 * @since 2.8
	 */
	protected static class FilteringResourceDescriptions implements IResourceDescriptions {
		
		private IResourceDescriptions delegate;
		private Predicate<URI> filter;
		
		public FilteringResourceDescriptions(IResourceDescriptions delegate, Predicate<URI> filter) {
			super();
			this.delegate = delegate;
			this.filter = filter;
		}
		
		protected IResourceDescriptions getDelegate() {
			return delegate;
		}
		
		protected Predicate<URI> getFilter() {
			return filter;
		}
		
		@Override 
		public Iterable<IResourceDescription> getAllResourceDescriptions() {
			return filter(delegate.getAllResourceDescriptions(), new Predicate<IResourceDescription>() {
				@Override
				public boolean apply(IResourceDescription input) {
					return filter.apply(input.getURI());
				}
			});
		}
		
		@Override 
		public IResourceDescription getResourceDescription(URI normalizedURI) {
			if (filter.apply(normalizedURI)) { 
				return delegate.getResourceDescription(normalizedURI);
			}
			return null;
		}
		
		private Iterable<IEObjectDescription> filtered(Iterable<IEObjectDescription> eObjectDescriptions) {
			return filter(eObjectDescriptions, new Predicate<IEObjectDescription>() {
				@Override
				public boolean apply(IEObjectDescription input) {
					return filter.apply(input.getEObjectURI());
				}
			});
		}
		
		@Override
		public Iterable<IEObjectDescription> getExportedObjects() {
			return filtered(delegate.getExportedObjects());
		}
		
		@Override 
		public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
			return filtered(delegate.getExportedObjects(type,name,ignoreCase));
		}
		
		@Override 
		public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
			return filtered(delegate.getExportedObjectsByObject(object));
		}
		
		@Override 
		public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
			return filtered(delegate.getExportedObjectsByType(type));
		}
		
		@Override 
		public boolean isEmpty() {
			return Iterables.isEmpty(getAllResourceDescriptions());
		}
	}
	
	/**
	 * Resource descriptions implementation that allows to filter a delegate instance
	 * based on the URI of the resource description. Fulfills the contract of 
	 * IShadowedResourceDescriptions.
	 * 
	 * @since 2.8
	 */
	protected static class ShadowedFilteringResourceDescriptions extends FilteringResourceDescriptions implements IShadowedResourceDescriptions {

		public ShadowedFilteringResourceDescriptions(IResourceDescriptions delegate, Predicate<URI> filter) {
			super(delegate, filter);
		}

		@Override
		public boolean isShadowed(EClass type, QualifiedName name, boolean ignoreCase) {
			boolean result = ((IShadowedResourceDescriptions) getDelegate()).isShadowed(type, name, ignoreCase);
			return result;
		}
		
	}
}

