/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import static com.google.common.collect.Lists.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.linking.impl.ImportedNamesAdapter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IResourceScopeCache;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultResourceDescription extends AbstractResourceDescription {

	private final static Logger log = Logger.getLogger(DefaultResourceDescription.class);

	private final Resource resource;

	private final URI uri;

	private IDefaultResourceDescriptionStrategy strategy;

	private IResourceScopeCache cache;

	public DefaultResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy,
				IResourceScopeCache cache) {
		this.resource = resource;
		this.strategy = strategy;
		this.cache = cache;
		this.uri = getNormalizedURI(resource);
	}

	/**
	 * For testing. Uses a {@link org.eclipse.xtext.util.IResourceScopeCache.NullImpl}.
	 */
	public DefaultResourceDescription(Resource resource, IDefaultResourceDescriptionStrategy strategy) {
		this(resource, strategy, new IResourceScopeCache.NullImpl());
	}
	
	@Override
	protected List<IEObjectDescription> computeExportedObjects() {
		if (!getResource().isLoaded()) {
			try {
				getResource().load(null);
			} catch (IOException e) {
				log.error(e.getMessage(), e);
				return Collections.<IEObjectDescription> emptyList();
			}
		}
		final List<IEObjectDescription> exportedEObjects = newArrayList();
		IAcceptor<IEObjectDescription> acceptor = new IAcceptor<IEObjectDescription>() {
			@Override
			public void accept(IEObjectDescription eObjectDescription) {
				exportedEObjects.add(eObjectDescription);
			}
		};
		TreeIterator<EObject> allProperContents = EcoreUtil.getAllProperContents(getResource(), false);
		while (allProperContents.hasNext()) {
			EObject content = allProperContents.next();
			if (!strategy.createEObjectDescriptions(content, acceptor))
				allProperContents.prune();
		}
		return exportedEObjects;
	}

	@Override
	public Iterable<QualifiedName> getImportedNames() {
		EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
		ImportedNamesAdapter adapter = ImportedNamesAdapter.find(getResource());
		if (adapter != null) {
			ImmutableSet<QualifiedName> result = ImmutableSet.copyOf(adapter.getImportedNames());
			return result;
		}
		return Collections.emptySet();
	}

	public Resource getResource() {
		return resource;
	}

	@Override
	public URI getURI() {
		return uri;
	}

	private static final String REFERENCE_DESCRIPTIONS_CACHE_KEY = DefaultReferenceDescription.class.getName()
			+ "#getReferenceDescriptions";

	@Override
	public Iterable<IReferenceDescription> getReferenceDescriptions() {
		return cache.get(REFERENCE_DESCRIPTIONS_CACHE_KEY, getResource(), new Provider<List<IReferenceDescription>>(){
			@Override
			public List<IReferenceDescription> get() {
				return computeReferenceDescriptions();
			}});
	}

	protected List<IReferenceDescription> computeReferenceDescriptions() {
		final List<IReferenceDescription> referenceDescriptions = Lists.newArrayList();
		IAcceptor<IReferenceDescription> acceptor = new IAcceptor<IReferenceDescription>() {
			@Override
			public void accept(IReferenceDescription referenceDescription) {
				referenceDescriptions.add(referenceDescription);
			}
		};
		EcoreUtil2.resolveLazyCrossReferences(resource, CancelIndicator.NullImpl);
		Map<EObject, IEObjectDescription> eObject2exportedEObjects = createEObject2ExportedEObjectsMap(getExportedObjects());
		TreeIterator<EObject> contents = EcoreUtil.getAllProperContents(this.resource, true);
		while (contents.hasNext()) {
			EObject eObject = contents.next();
			URI exportedContainerURI = findExportedContainerURI(eObject, eObject2exportedEObjects);
			if (!strategy.createReferenceDescriptions(eObject, exportedContainerURI, acceptor))
				contents.prune();
		}
		return referenceDescriptions;
	}

	protected Map<EObject, IEObjectDescription> createEObject2ExportedEObjectsMap(
			Iterable<IEObjectDescription> exportedObjects) {
		Map<EObject, IEObjectDescription> uri2exportedEObjects = Maps.newIdentityHashMap();
		for (IEObjectDescription eObjectDescription : exportedObjects) {
			uri2exportedEObjects.put(eObjectDescription.getEObjectOrProxy(), eObjectDescription);
		}
		return uri2exportedEObjects;
	}

	protected URI findExportedContainerURI(EObject referenceOwner,
			Map<EObject, IEObjectDescription> eObject2exportedEObjects) {
		EObject currentContainer = referenceOwner;
		while (currentContainer != null) {
			IEObjectDescription currentContainerEObjectDescription = eObject2exportedEObjects.get(currentContainer);
			if (currentContainerEObjectDescription != null) {
				return currentContainerEObjectDescription.getEObjectURI();
			}
			currentContainer = currentContainer.eContainer();
		}
		return null;
	}

	private static final String EOBJECT_LOOKUP_CACHE_KEY = DefaultReferenceDescription.class.getName() + "#getLookUp";

	@Override
	protected EObjectDescriptionLookUp getLookUp() {
		return cache.get(EOBJECT_LOOKUP_CACHE_KEY, getResource(), new Provider<EObjectDescriptionLookUp>() {
			@Override
			public EObjectDescriptionLookUp get() {
				if(lookup != null) 
					lookup.setExportedObjects(computeExportedObjects());
				else 
					lookup = new EObjectDescriptionLookUp(computeExportedObjects());
				return lookup;
			}
		});
	}
	
	@Override
	public String toString() {
		return "[" + getClass().getSimpleName() + " uri=" + getURI() + "]";
	}
}
