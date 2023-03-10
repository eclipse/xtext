/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.ReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURIConverter;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Predicate;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Maintained for backwards compatibility reasons. Most methods delegate to the runtime implementation which in turn is
 * specialized to call methods of this class where appropriate. Most overriding scenarios should still work.
 * 
 * Clients are encouraged to drop this implementation in favor of the {@link DelegatingReferenceFinder}. 
 * Customizing should be applied to the {@link ReferenceFinder} instead.
 * 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 * @deprecated use {@link DelegatingReferenceFinder} instead.
 */
@Deprecated
public class DefaultReferenceFinder extends ReferenceFinder implements org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder, IReferenceFinderExtension1 {

	private IResourceDescriptions indexData;

	@Inject
	private TargetURIConverter converter;
	
	@Inject
	public DefaultReferenceFinder(IResourceDescriptions indexData,
			IResourceServiceProvider.Registry serviceProviderRegistry) {
		this(indexData, serviceProviderRegistry, new TargetURIConverter());
	}
	
	public DefaultReferenceFinder(IResourceDescriptions indexData,
			IResourceServiceProvider.Registry serviceProviderRegistry, 
			TargetURIConverter converter) {
		super(serviceProviderRegistry);
		this.indexData = indexData;
		this.converter = converter;
	}
	
	protected IResourceDescriptions getIndexData() {
		return indexData;
	}
	
	protected static class MyReferenceAcceptor extends ReferenceAcceptor implements IAcceptor<IReferenceDescription> {

		protected MyReferenceAcceptor(IAcceptor<IReferenceDescription> delegate, IResourceServiceProvider.Registry serviceProviderRegistry) {
			super(delegate, serviceProviderRegistry);
		}
	}
	
	protected MyReferenceAcceptor toAcceptor(IAcceptor<IReferenceDescription> acceptor) {
		if (acceptor instanceof MyReferenceAcceptor)
			return (MyReferenceAcceptor) acceptor;
		return new MyReferenceAcceptor(acceptor, getServiceProviderRegistry());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void findReferences(TargetURIs targetURIs, IResourceDescription resourceDescription,
			IResourceAccess resourceAccess, Acceptor acceptor, IProgressMonitor monitor) {
		findReferences(targetURIs.asSet(), resourceDescription, (IAcceptor<IReferenceDescription>) acceptor, monitor, (ILocalResourceAccess) resourceAccess);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void findReferences(Predicate<URI> targetURIs, Resource resource, Acceptor acceptor, IProgressMonitor monitor) {
		findLocalReferencesInResource(targetURIs, resource, (IAcceptor<IReferenceDescription>) acceptor);
	}
	
	@Override
	protected IReferenceFinder getLanguageSpecificReferenceFinder(URI candidate) {
		// bogus old implementation did not dispatch properly for all candidates
		return this;
	}

	@Override
	public void findReferences(Iterable<URI> targetURIs, final Iterable<URI> sourceResourceURIs,
			ILocalResourceAccess localResourceAccess, IAcceptor<IReferenceDescription> referenceAcceptor,
			IProgressMonitor monitor) {
		TargetURIs converted = converter.fromIterable(targetURIs);
		HashSet<URI> sourceResourcesAsSet = Sets.newHashSet(sourceResourceURIs);
		super.findReferences(converted, sourceResourcesAsSet, localResourceAccess, indexData, toAcceptor(referenceAcceptor), monitor);
		if (localResourceAccess != null && !converted.isEmpty() && getClass() != DefaultReferenceFinder.class) {
			// All the references have already been collected, but if this method was overridden,
			// we have to call it again from here
			findLocalReferences(converted, localResourceAccess, referenceAcceptor, monitor);
		}
	}
	
	@Override
	public void findAllReferences(
			Iterable<URI> targetURIs,
			ILocalResourceAccess localResourceAccess,
			IAcceptor<IReferenceDescription> referenceAcceptor,
			IProgressMonitor monitor) {
		TargetURIs converted = converter.fromIterable(targetURIs);
		if (!converted.isEmpty()) {
			findAllIndexedReferences(referenceAcceptor, SubMonitor.convert(monitor, 1), converted.asSet(), localResourceAccess);
			if (localResourceAccess != null && !converted.isEmpty() && getClass() != DefaultReferenceFinder.class) {
				// All the references have already been collected, but if this method was overridden,
				// we have to call it again from here
				findLocalReferences(converted, localResourceAccess, referenceAcceptor, monitor);
			}
		}
		
	}

	/**
	 * @deprecated use {@link #findAllIndexedReferences(IAcceptor, SubMonitor, Set, org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.ILocalResourceAccess)}
	 */
	@Deprecated
	protected void findAllIndexedReferences(IAcceptor<IReferenceDescription> referenceAcceptor, SubMonitor subMonitor,
			Set<URI> targetURIsAsSet) {
		findAllIndexedReferences(referenceAcceptor, subMonitor, targetURIsAsSet, null);
	}
	
	/**
	 * @since 2.4
	 */
	protected void findAllIndexedReferences(
			IAcceptor<IReferenceDescription> referenceAcceptor,
			SubMonitor subMonitor,
			Set<URI> targetURIsAsSet,
			ILocalResourceAccess localResourceAccess) {
		TargetURIs targetURIs = converter.fromIterable(targetURIsAsSet);
		if (!targetURIs.isEmpty()) {
			subMonitor.setWorkRemaining(size(indexData.getAllResourceDescriptions()) / MONITOR_CHUNK_SIZE + 1);
			int i = 0;
			IProgressMonitor useMe = subMonitor.newChild(1);
			for (IResourceDescription resourceDescription : indexData.getAllResourceDescriptions()) {
				IResourceServiceProvider serviceProvider = getServiceProviderRegistry().getResourceServiceProvider(resourceDescription.getURI());
				if (serviceProvider != null) {
					IReferenceFinder referenceFinder = serviceProvider.get(IReferenceFinder.class);
					if (referenceFinder instanceof IReferenceFinderExtension1) {
						IReferenceFinderExtension1 extension1 = (IReferenceFinderExtension1) referenceFinder;
						extension1.findReferences(targetURIsAsSet, resourceDescription, referenceAcceptor, useMe, localResourceAccess);
					} else {
						// don't use the language specific reference finder here for backwards compatibility reasons
						findReferences(targetURIsAsSet, resourceDescription, referenceAcceptor, useMe, localResourceAccess);
					}
				}
				i++;
				if (i % MONITOR_CHUNK_SIZE == 0) {
					useMe = subMonitor.newChild(1);
				}
			}
		}
	}
	
	private static final int MONITOR_FIND_LOCAL_CHUNK_SIZE = 10;

	protected void findLocalReferences(
			Iterable<URI> localTargets,
			ILocalResourceAccess localResourceAccess,
			final IAcceptor<IReferenceDescription> acceptor,
			IProgressMonitor monitor) {
		if ((monitor != null && monitor.isCanceled()))
			throw new OperationCanceledException();

		final TargetURIs targetURIs = converter.fromIterable(localTargets);
		Collection<URI> resourceURIs = targetURIs.getTargetResourceURIs();
		final SubMonitor subMonitor = SubMonitor.convert(monitor, resourceURIs.size() / MONITOR_FIND_LOCAL_CHUNK_SIZE + 1);
		int i = 0;
		for(final URI resourceURI: resourceURIs) {
			if (subMonitor.isCanceled())
				throw new OperationCanceledException();
			localResourceAccess.readOnly(resourceURI, new IUnitOfWork.Void<ResourceSet>() {
				@Override
				public void process(ResourceSet resourceSet) throws Exception {
					Resource resource = resourceSet.getResource(resourceURI, true);
					DefaultReferenceFinder.super.findReferences(targetURIs, resource, toAcceptor(acceptor), subMonitor);
				}
			});
			i++;
			if (i % MONITOR_FIND_LOCAL_CHUNK_SIZE == 0)
				subMonitor.worked(1);
		}
	}

	protected void findLocalReferencesInResource(final Predicate<URI> targetURIs, Resource resource,
			final IAcceptor<IReferenceDescription> acceptor) {
		Map<EObject, URI> exportedElementsMap = createExportedElementsMap(resource);
		for(EObject content: resource.getContents()) {
			findLocalReferencesFromElement(targetURIs, content, resource, acceptor, null, exportedElementsMap);
		}
	}
	
	protected void findLocalReferencesFromElement(
			final Predicate<URI> targetURIs, 
			EObject sourceCandidate,
			Resource localResource,
			final IAcceptor<IReferenceDescription> acceptor, 
			URI currentExportedContainerURI, 
			Map<EObject, URI> exportedElementsMap) {
		super.findLocalReferencesFromElement(targetURIs, sourceCandidate, localResource, toAcceptor(acceptor));
	}
	
	@Deprecated
	protected Map<EObject, URI> createExportedElementsMap(final Resource resource) {
		return new ForwardingMap<EObject, URI>() {

			private Map<EObject, URI> delegate;
			
			@Override
			protected Map<EObject, URI> delegate() {
				if (delegate != null) {
					return delegate;
				}
				URI uri = EcoreUtil2.getPlatformResourceOrNormalizedURI(resource);
				IResourceServiceProvider resourceServiceProvider = getServiceProviderRegistry().getResourceServiceProvider(uri);
				if (resourceServiceProvider == null) {
					return delegate = Collections.emptyMap();
				}
				IResourceDescription.Manager resourceDescriptionManager = resourceServiceProvider.getResourceDescriptionManager();
				if (resourceDescriptionManager == null) {
					return delegate = Collections.emptyMap();
				}
				IResourceDescription resourceDescription = resourceDescriptionManager.getResourceDescription(resource);
				Map<EObject, URI> exportedElementMap = newIdentityHashMap();
				if (resourceDescription != null) {
					for (IEObjectDescription exportedEObjectDescription : resourceDescription.getExportedObjects()) {
						EObject eObject = resource.getEObject(exportedEObjectDescription.getEObjectURI().fragment());
						if (eObject != null)
							exportedElementMap.put(eObject, exportedEObjectDescription.getEObjectURI());
					}
				}
				return delegate = exportedElementMap;
			}

			
		};
	}

	/**
	 * @deprecated no longer used
	 */
	@Deprecated
	protected URI findClosestExportedContainerURI(EObject element, Map<EObject, URI> exportedElementsMap) {
		EObject current = element;
		while (current != null) {
			URI uri = exportedElementsMap.get(current);
			if (uri != null)
				return uri;
			current = current.eContainer();
		}
		return null;
	}

	/**
	 * @deprecated use {@link #findReferences(Set, IResourceDescription, IAcceptor, IProgressMonitor, org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder.ILocalResourceAccess)}
	 */
	@Deprecated
	protected void findIndexedReferences(Set<URI> targetURIs, IResourceDescription resourceDescription, IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		findReferences(targetURIs, resourceDescription, acceptor, monitor, null);
	}
	
	/**
	 * @since 2.4
	 */
	@Override
	public void findReferences(Set<URI> targetURIs, IResourceDescription resourceDescription, IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor, ILocalResourceAccess localResourceAccess) {
		super.findReferences(converter.fromIterable(targetURIs), resourceDescription, localResourceAccess, toAcceptor(acceptor), monitor);
	}
}
