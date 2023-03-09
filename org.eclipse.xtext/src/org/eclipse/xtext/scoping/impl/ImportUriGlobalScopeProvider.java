/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.ClasspathUriResolutionException;
import org.eclipse.xtext.resource.IClasspathUriResolver;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ImportUriGlobalScopeProvider extends AbstractGlobalScopeProvider {

	@Inject
	private ImportUriResolver importResolver;
	
	@Inject
	private Provider<LoadOnDemandResourceDescriptions> loadOnDemandDescriptions;
	
	@Inject
	private IResourceScopeCache cache;
	
	public ImportUriResolver getImportUriResolver() {
		return importResolver;
	}
	
	public void setImportResolver(ImportUriResolver importResolver) {
		this.importResolver = importResolver;
	}
	
	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}
	
	public IResourceDescriptions getResourceDescriptions(Resource resource, Collection<URI> importUris) {
		IResourceDescriptions result = getResourceDescriptions(resource);
		LoadOnDemandResourceDescriptions demandResourceDescriptions = loadOnDemandDescriptions.get();
		demandResourceDescriptions.initialize(result, importUris, resource);
		return demandResourceDescriptions;
	}

	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase, EClass type, Predicate<IEObjectDescription> filter) {
		final LinkedHashSet<URI> uniqueImportURIs = getImportedUris(resource);
		IResourceDescriptions descriptions = getResourceDescriptions(resource, uniqueImportURIs);
		List<URI> urisAsList = Lists.newArrayList(uniqueImportURIs);
		Collections.reverse(urisAsList);
		IScope scope = IScope.NULLSCOPE;
		for (URI uri : urisAsList) {
			scope = createLazyResourceScope(scope, uri, descriptions, type, filter, ignoreCase);
		}
		return scope;
	}
	
	/**
	 * The default acceptor for import URIs.
	 * 
	 * It normalizes potentially given class-path URIs.
	 * 
	 * @see ImportUriGlobalScopeProvider#createURICollector(Resource, Set)
	 * @since 2.5
	 */
	public static class URICollector implements IAcceptor<String> {
		
		private IClasspathUriResolver uriResolver;
		private Object uriContext;
		private Set<URI> result;

		public URICollector(ResourceSet resourceSet, Set<URI> result) {
			this.result = result;
			if (resourceSet instanceof XtextResourceSet) {
				uriResolver = ((XtextResourceSet) resourceSet).getClasspathUriResolver();
				uriContext = ((XtextResourceSet) resourceSet).getClasspathURIContext();
			}
		}

		public URI resolve(String uriAsString) throws IllegalArgumentException {
			URI uri = URI.createURI(uriAsString);
			if (uriResolver != null) {
				try {
					return uriResolver.resolve(uriContext, uri);
				} catch(ClasspathUriResolutionException e) {
					return uri;
				}
			}
			return uri;
		}

		@Override
		public void accept(String uriAsString) {
			if (uriAsString == null) {
				return;
			}
			try {
				URI importUri = resolve(uriAsString);
				if (importUri != null) {
					result.add(importUri);
				}
			} catch(IllegalArgumentException e) {
				// ignore, invalid uri given
			}
		}
	}

	protected LinkedHashSet<URI> getImportedUris(final Resource resource) {
		return cache.get(ImportUriGlobalScopeProvider.class.getName(), resource, new Provider<LinkedHashSet<URI>>(){
			@Override
			public LinkedHashSet<URI> get() {
				final LinkedHashSet<URI> uniqueImportURIs = new LinkedHashSet<URI>(5);
				IAcceptor<String> collector = createURICollector(resource, uniqueImportURIs);
				TreeIterator<EObject> iterator = resource.getAllContents();
				while (iterator.hasNext()) {
					EObject object = iterator.next();
					collector.accept(importResolver.apply(object));
				}
				Iterator<URI> uriIter = uniqueImportURIs.iterator();
				while(uriIter.hasNext()) {
					if (!EcoreUtil2.isValidUri(resource, uriIter.next()))
						uriIter.remove();
				}
				return uniqueImportURIs;
			}
		});
	}
	
	/**
	 * Provides the acceptor for import URI strings that will populate the given {@link Set set of URIs}.
	 * 
	 * The default implementation 
	 * creates a new {@link URICollector}. I creates the imported URIs and normalizes
	 * potentially given class-path URIs to platform or file URIs.
	 * 
	 * @since 2.5
	 */
	protected IAcceptor<String> createURICollector(Resource resource, Set<URI> collectInto) {
		ResourceSet resourceSet = resource.getResourceSet();
		return new URICollector(resourceSet, collectInto);
	}

	protected IScope createLazyResourceScope(IScope parent, final URI uri, final IResourceDescriptions descriptions,
			EClass type, final Predicate<IEObjectDescription> filter, boolean ignoreCase) {
		IResourceDescription description = descriptions.getResourceDescription(uri);
		return SelectableBasedScope.createScope(parent, description, filter, type, ignoreCase);
	}

	public void setLoadOnDemandDescriptions(Provider<LoadOnDemandResourceDescriptions> loadOnDemandDescriptions) {
		this.loadOnDemandDescriptions = loadOnDemandDescriptions;
	}

	public Provider<LoadOnDemandResourceDescriptions> getLoadOnDemandDescriptions() {
		return loadOnDemandDescriptions;
	}

}
