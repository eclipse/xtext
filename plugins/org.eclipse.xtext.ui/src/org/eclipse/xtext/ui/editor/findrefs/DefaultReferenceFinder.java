/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.findrefs;

import static com.google.common.collect.Iterables.*;
import static com.google.common.collect.Maps.*;
import static com.google.common.collect.Sets.*;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public class DefaultReferenceFinder implements IReferenceFinder, IReferenceFinderExtension1 {

	private IResourceDescriptions indexData;

	private IResourceServiceProvider.Registry serviceProviderRegistry;

	@Inject
	public DefaultReferenceFinder(IResourceDescriptions indexData,
			IResourceServiceProvider.Registry serviceProviderRegistry) {
		super();
		this.indexData = indexData;
		this.serviceProviderRegistry = serviceProviderRegistry;
	}
	
	protected IResourceDescriptions getIndexData() {
		return indexData;
	}

	public void findReferences(Iterable<URI> targetURIs, final Iterable<URI> sourceResourceURIs,
			ILocalResourceAccess localResourceAccess, IAcceptor<IReferenceDescription> referenceAcceptor,
			IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 2);
		if (!isEmpty(targetURIs) && !isEmpty(sourceResourceURIs)) {
			if (localResourceAccess != null) {
				Iterable<URI> localTargetURIs = filter(targetURIs, new Predicate<URI>() {
					public boolean apply(URI input) {
						return contains(sourceResourceURIs, input.trimFragment());
					}
				});
				findLocalReferences(localTargetURIs, localResourceAccess, referenceAcceptor, subMonitor.newChild(1));
			}
			Set<URI> targetURIsAsSet = newLinkedHashSet(targetURIs);
			subMonitor.setWorkRemaining(targetURIsAsSet.size());
			for (URI sourceResourceURI : sourceResourceURIs) {
				IResourceDescription resourceDescription = indexData.getResourceDescription(sourceResourceURI);
				if (resourceDescription != null)
					findReferences(targetURIsAsSet, resourceDescription, referenceAcceptor,
							subMonitor.newChild(1), localResourceAccess);
			}
		}
	}

	public void findAllReferences(Iterable<URI> targetURIs, ILocalResourceAccess localResourceAccess,
			IAcceptor<IReferenceDescription> referenceAcceptor, IProgressMonitor monitor) {
		SubMonitor subMonitor = SubMonitor.convert(monitor, 2);
		if (!isEmpty(targetURIs)) {
			if (localResourceAccess != null) {
				findLocalReferences(targetURIs, localResourceAccess, referenceAcceptor, subMonitor.newChild(1));
			}
			Set<URI> targetURIsAsSet = newLinkedHashSet(targetURIs);
			findAllIndexedReferences(referenceAcceptor, subMonitor, targetURIsAsSet, localResourceAccess);
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
	protected void findAllIndexedReferences(IAcceptor<IReferenceDescription> referenceAcceptor, SubMonitor subMonitor,
			Set<URI> targetURIsAsSet, ILocalResourceAccess localResourceAccess) {
		subMonitor.setWorkRemaining(size(indexData.getAllResourceDescriptions()));
		for (IResourceDescription resourceDescription : indexData.getAllResourceDescriptions()) {
			IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(resourceDescription.getURI());
			if (serviceProvider != null) {
				IReferenceFinder referenceFinder = serviceProvider.get(IReferenceFinder.class);
				if (referenceFinder instanceof IReferenceFinderExtension1) {
					IReferenceFinderExtension1 extension1 = (IReferenceFinderExtension1) referenceFinder;
					extension1.findReferences(targetURIsAsSet, resourceDescription, referenceAcceptor, subMonitor.newChild(1), localResourceAccess);
				} else {
					// don't use the language specific reference finder here for backwards compatibility reasons
					findReferences(targetURIsAsSet, resourceDescription, referenceAcceptor, subMonitor.newChild(1), localResourceAccess);
				}
			}
		}
	}

	protected void findLocalReferences(Iterable<URI> localTargets, ILocalResourceAccess localResourceAccess,
			final IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		if ((monitor != null && monitor.isCanceled()))
			return;
		final Multimap<URI, URI> resource2target = LinkedHashMultimap.create();
		for (URI targetURI : localTargets) {
			resource2target.put(targetURI.trimFragment(), targetURI);
		}
		final SubMonitor subMonitor = SubMonitor.convert(monitor, resource2target.keySet().size());
		for (final URI resourceURI : resource2target.keySet()) {
			if (subMonitor.isCanceled())
				return;
			localResourceAccess.readOnly(resourceURI, new IUnitOfWork.Void<ResourceSet>() {
				@Override
				public void process(ResourceSet resourceSet) throws Exception {
					Resource resource = resourceSet.getResource(resourceURI, true);
					findLocalReferencesInResource(resource2target.get(resourceURI), resource, acceptor);
				}
			});
			subMonitor.worked(1);
		}
	}

	protected void findLocalReferencesInResource(final Iterable<URI> targetURIs, Resource resource,
			final IAcceptor<IReferenceDescription> acceptor) {
		Set<URI> targetURISet = ImmutableSet.copyOf(targetURIs);
		Map<EObject, URI> exportedElementsMap = createExportedElementsMap(resource);
		for(EObject content: resource.getContents()) {
			findLocalReferencesFromElement(targetURISet, content, resource, acceptor, null, exportedElementsMap);
		}
	}
	
	@SuppressWarnings("unchecked")
	protected void findLocalReferencesFromElement(
			final Set<URI> targetURISet, 
			EObject sourceCandidate,
			Resource localResource,
			final IAcceptor<IReferenceDescription> acceptor, 
			URI currentExportedContainerURI, 
			Map<EObject, URI> exportedElementsMap) {
		URI sourceURI = null; 
		if(exportedElementsMap.containsKey(sourceCandidate)) { 
			currentExportedContainerURI = exportedElementsMap.get(sourceCandidate);
			sourceURI = currentExportedContainerURI;
		}
		for(EReference ref: sourceCandidate.eClass().getEAllReferences()) {
			if(sourceCandidate.eIsSet(ref)) {
				if(ref.isContainment()) {
					Object content = sourceCandidate.eGet(ref, false);
					if(ref.isMany()) {
						InternalEList<EObject> contentList = (InternalEList<EObject>) content;
						for(int i=0; i<contentList.size(); ++i) {
							EObject childElement = contentList.basicGet(i);
							if(!childElement.eIsProxy())
								findLocalReferencesFromElement(targetURISet, childElement, localResource, acceptor, currentExportedContainerURI, exportedElementsMap);
						}
					} else {
						EObject childElement = (EObject) content;
						if(!childElement.eIsProxy())
							findLocalReferencesFromElement(targetURISet, childElement, localResource, acceptor, currentExportedContainerURI, exportedElementsMap);
					}
				} else if (!ref.isContainer()) {
					Object value = sourceCandidate.eGet(ref, false);
					if(ref.isMany()) {
						InternalEList<EObject> values = (InternalEList<EObject>) value;
						for(int i=0; i< values.size(); ++i) {
							EObject refElement = resolveInternalProxy(values.basicGet(i), localResource);
							URI refURI= EcoreUtil2.getPlatformResourceOrNormalizedURI(refElement);
							if(targetURISet.contains(refURI)) {
								sourceURI = (sourceURI == null) ? EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceCandidate) : sourceURI;
								acceptor.accept(new DefaultReferenceDescription(
										sourceURI, refURI, ref, i, currentExportedContainerURI));
							}
						}
					} else {
						EObject refElement = resolveInternalProxy((EObject) value, localResource);
						URI refURI= EcoreUtil2.getPlatformResourceOrNormalizedURI(refElement);
						if(targetURISet.contains(refURI)) {
							sourceURI = (sourceURI == null) ? EcoreUtil2.getPlatformResourceOrNormalizedURI(sourceCandidate) : sourceURI;
							acceptor.accept(new DefaultReferenceDescription(
									sourceURI, refURI, ref, -1, currentExportedContainerURI));
						}
					}
				}
			}
		}
	}
	
	protected EObject resolveInternalProxy(EObject elementOrProxy, Resource resource) {
		if(elementOrProxy.eIsProxy() && ((InternalEObject) elementOrProxy).eProxyURI().trimFragment().equals(resource.getURI()))
			return EcoreUtil.resolve(elementOrProxy, resource);
		else
			return elementOrProxy;
	}
	
	protected Map<EObject, URI> createExportedElementsMap(Resource resource) {
		URI uri = EcoreUtil2.getPlatformResourceOrNormalizedURI(resource);
		IResourceServiceProvider resourceServiceProvider = serviceProviderRegistry.getResourceServiceProvider(uri);
		if (resourceServiceProvider == null) {
			return Collections.emptyMap();
		}
		IResourceDescription.Manager resourceDescriptionManager = resourceServiceProvider.getResourceDescriptionManager();
		if (resourceDescriptionManager == null) {
			return Collections.emptyMap();
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
		return exportedElementMap;
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
	public void findReferences(Set<URI> targetURIs, IResourceDescription resourceDescription, IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor, ILocalResourceAccess localResourceAccess) {
		for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
			if (targetURIs.contains(referenceDescription.getTargetEObjectUri())) {
				acceptor.accept(referenceDescription);
			}
		}
	}
}
