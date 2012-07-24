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
import static java.util.Collections.*;
import static org.eclipse.xtext.util.Strings.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil.CrossReferencer;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.DefaultReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.base.Predicate;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
public class DefaultReferenceFinder implements IReferenceFinder {

	private static final Logger LOG = Logger.getLogger(DefaultReferenceFinder.class);

	private IResourceDescriptions indexData;

	private IResourceServiceProvider.Registry serviceProviderRegistry;

	@Inject
	public DefaultReferenceFinder(IResourceDescriptions indexData,
			IResourceServiceProvider.Registry serviceProviderRegistry) {
		super();
		this.indexData = indexData;
		this.serviceProviderRegistry = serviceProviderRegistry;
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
					findIndexedReferences(targetURIsAsSet, resourceDescription, referenceAcceptor,
							subMonitor.newChild(1));
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
			findAllIndexedReferences(referenceAcceptor, subMonitor, targetURIsAsSet);
		}
	}

	protected void findAllIndexedReferences(IAcceptor<IReferenceDescription> referenceAcceptor, SubMonitor subMonitor,
			Set<URI> targetURIsAsSet) {
		subMonitor.setWorkRemaining(size(indexData.getAllResourceDescriptions()));
		for (IResourceDescription resourceDescription : indexData.getAllResourceDescriptions()) {
			findIndexedReferences(targetURIsAsSet, resourceDescription, referenceAcceptor, subMonitor.newChild(1));
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
		Map<EObject, Collection<Setting>> localCrossRefs = CrossReferencer.find(singleton(resource));
		Map<EObject, URI> exportedElementsMap = null;
		for (URI targetURI : targetURIs) {
			try {
				EObject target = resource.getEObject(targetURI.fragment());
				if (target != null) {
					Collection<Setting> crossRefSettings = localCrossRefs.get(target);
					if (crossRefSettings != null) {
						for (Setting crossRefSetting : crossRefSettings) {
							EObject source = crossRefSetting.getEObject();
							if (crossRefSetting.getEStructuralFeature() instanceof EReference) {
								EReference reference = (EReference) crossRefSetting.getEStructuralFeature();
								int index = -1;
								if (reference.isMany()) {
									List<?> values = (List<?>) source.eGet(reference);
									for (int i = 0; i < values.size(); ++i) {
										if (target == values.get(i)) {
											index = i;
											break;
										}
									}
								}
								if (exportedElementsMap == null)
									exportedElementsMap = createExportedElementsMap(resource);
								IReferenceDescription localReferenceDescription = new DefaultReferenceDescription(
										source, target, reference, index, findClosestExportedContainerURI(source,
												exportedElementsMap));
								acceptor.accept(localReferenceDescription);
							}
						}
					}
				}
			} catch (Exception exc) {
				LOG.error("Error finding reference to " + notNull(targetURI), exc);
			}
		}
	}

	protected Map<EObject, URI> createExportedElementsMap(Resource resource) {
		URI uri = EcoreUtil2.getNormalizedURI(resource);
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

	protected void findIndexedReferences(Set<URI> targetURIs, IResourceDescription resourceDescription,
			IAcceptor<IReferenceDescription> acceptor, IProgressMonitor monitor) {
		for (IReferenceDescription referenceDescription : resourceDescription.getReferenceDescriptions()) {
			if (targetURIs.contains(referenceDescription.getTargetEObjectUri())) {
				acceptor.accept(referenceDescription);
			}
		}
	}
}
