/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.resource.impl;

import static org.eclipse.emf.index.util.CollectionUtils.addAllIfNotNull;
import static org.eclipse.emf.index.util.CollectionUtils.findEquivalent;
import static org.eclipse.emf.index.util.CollectionUtils.toList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.impl.EObjectDescriptorImpl;
import org.eclipse.emf.index.impl.EReferenceDescriptorImpl;
import org.eclipse.emf.index.impl.ResourceDescriptorImpl;
import org.eclipse.emf.index.resource.IndexFeeder;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IndexFeederImpl implements IndexFeeder {

	private IndexStore index;

	private boolean isTransactionStarted;

	private Map<Resource, ResourceData> resourceDataCache = new HashMap<Resource, ResourceData>();
	private Map<EObject, EObjectData> eObjectDataCache = new HashMap<EObject, EObjectData>();
	private List<EReferenceData> eReferenceCache = new ArrayList<EReferenceData>();

	private Map<URI, ResourceDescriptor> resourceDescCacheUri = new HashMap<URI, ResourceDescriptor>();
	private Map<EObject, EObjectDescriptor> eObjectDescCache = new HashMap<EObject, EObjectDescriptor>();

	private List<EObjectDescriptor> allExistingEObjectDescs = new ArrayList<EObjectDescriptor>();
	private List<EReferenceDescriptor> allExistingEReferenceDescs = new ArrayList<EReferenceDescriptor>();

	@Inject
	public IndexFeederImpl(IndexStore indexStore) {
		this.index = indexStore;
		isTransactionStarted = false;
	}

	public void begin() {
		clearAllCaches();
		isTransactionStarted = true;
	}

	public void createResourceDescriptor(Resource resource, Map<String, String> userData) {
		assertTransactionStarted();
		ResourceData resourceData = new ResourceData();
		resourceData.uri = resource.getURI().toString();
		resourceData.indexingDate = System.currentTimeMillis();
		resourceData.userData = userData;
		resourceDataCache.put(resource, resourceData);
	}

	public void createEObjectDescriptor(EObject eObject, String name, String displayName, Map<String, String> userData) {
		assertTransactionStarted();
		Resource eResource = eObject.eResource();
		if (eResource != null) {
			EObjectData eObjectData = new EObjectData();
			eObjectData.fragment = eResource.getURIFragment(eObject);
			eObjectData.name = name;
			eObjectData.displayName = displayName;
			eObjectData.userData = userData;
			eObjectDataCache.put(eObject, eObjectData);
		}
	}

	public void createEReferenceDescriptor(URI sourceURI, String eReferenceName, int index, URI targetURI) {
		assertTransactionStarted();
		if (sourceURI != null && eReferenceName != null && targetURI != null) {
			EReferenceData eReferenceData = new EReferenceData();
			eReferenceData.sourceURI = sourceURI;
			eReferenceData.targetURI = targetURI;
			eReferenceData.eReferenceName = eReferenceName;
			eReferenceData.index = index;
			eReferenceCache.add(eReferenceData);
		}
	}

	public void commit() {
		try {
			synchronized (index) {
				commitResourceDescriptors();
				commitEObjectDescriptors();
				commitEReferenceDescriptors();
				cleanUpStaleDescriptors();
			}
		}
		finally {
			isTransactionStarted = false;
			clearAllCaches();
		}
	}

	public void commitResourceDescriptors() {
		for (Entry<Resource, ResourceData> resourceEntry : resourceDataCache.entrySet()) {
			Resource resource = resourceEntry.getKey();
			ResourceData data = resourceEntry.getValue();
			ResourceDescriptor existingResourceDesc = index.resourceDAO().createQueryResource(resource)
					.executeSingleResult();
			ResourceDescriptor newResourceDescriptor = new ResourceDescriptorImpl(data.uri, data.indexingDate,
					data.userData);
			if (existingResourceDesc != null) {
				Collection<EObjectDescriptor> existingEObjectsInResource = toList(index.eObjectDAO()
						.createQueryEObjectsInResource(existingResourceDesc).executeListResult());
				addAllIfNotNull(allExistingEObjectDescs, existingEObjectsInResource);
				index.resourceDAO().modify(existingResourceDesc, newResourceDescriptor);
				putResourceDescriptor(resource, existingResourceDesc);
			}
			else {
				index.resourceDAO().store(newResourceDescriptor);
				putResourceDescriptor(resource, newResourceDescriptor);
			}
		}
	}

	private void putResourceDescriptor(Resource resource, ResourceDescriptor resourceDescriptor) {
		resourceDescCacheUri.put(resource.getURI(), resourceDescriptor);
	}

	public void commitEObjectDescriptors() {
		for (Entry<EObject, EObjectData> eObjectEntry : eObjectDataCache.entrySet()) {
			EObject eObject = eObjectEntry.getKey();
			EObjectData data = eObjectEntry.getValue();
			Resource resource = eObject.eResource();
			ResourceDescriptor resourceDesc = null;

			if (resource != null) {
				resourceDesc = findResourceDescriptor(resource.getURI());
			}
			else {
				resourceDesc = findResourceDescriptor(EcoreUtil.getURI(eObject).trimFragment());
			}
			EClassDescriptor eClassDescriptor = index.eClassDAO().createQueryEClass(eObject.eClass())
					.executeSingleResult();
			EObjectDescriptor newEObjectDesc = new EObjectDescriptorImpl(resourceDesc, data.fragment, data.name,
					data.displayName, eClassDescriptor, data.userData);
			EObjectDescriptor existingEObjectDesc = findEquivalent(allExistingEObjectDescs, newEObjectDesc);
			if (existingEObjectDesc != null) {
				Collection<EReferenceDescriptor> existingEReferenceDescsFrom = toList(index.eReferenceDAO()
						.createQueryEReferencesFrom(existingEObjectDesc.getFragmentURI()).executeListResult());
				addAllIfNotNull(allExistingEReferenceDescs, existingEReferenceDescsFrom);
				index.eObjectDAO().modify(existingEObjectDesc, newEObjectDesc);
				allExistingEObjectDescs.remove(existingEObjectDesc);
				eObjectDescCache.put(eObject, existingEObjectDesc);
			}
			else {
				index.eObjectDAO().store(newEObjectDesc);
				eObjectDescCache.put(eObject, newEObjectDesc);
			}
		}
	}

	public void commitEReferenceDescriptors() {
		for (EReferenceData data : eReferenceCache) {
			ResourceDescriptor sourceResourceDescriptor = findResourceDescriptor(data.sourceURI.trimFragment());
			ResourceDescriptor targetResourceDescriptor = findResourceDescriptor(data.targetURI.trimFragment());
			EReferenceDescriptor eReferenceDesc = new EReferenceDescriptorImpl(sourceResourceDescriptor, data.sourceURI
					.fragment(), data.eReferenceName, data.index, targetResourceDescriptor, data.targetURI.fragment());
			if (!allExistingEReferenceDescs.remove(eReferenceDesc)) {
				index.eReferenceDAO().store(eReferenceDesc);
			}
		}
	}

	public void cleanUpStaleDescriptors() {
		for (EObjectDescriptor eObjectDesc : allExistingEObjectDescs) {
			index.eObjectDAO().delete(eObjectDesc);
			String fragment = eObjectDesc.getFragment();
			ResourceDescriptor resourceDescriptor = eObjectDesc.getResourceDescriptor();
			Iterable<EReferenceDescriptor> danglingEReferences = index.eReferenceDAO().createQuery().sourceFragment(
					fragment).sourceResource(resourceDescriptor).executeListResult();
			for (EReferenceDescriptor danglingEReference : danglingEReferences) {
				index.eReferenceDAO().delete(danglingEReference);
			}
		}
		for (EReferenceDescriptor eReferenceDesc : allExistingEReferenceDescs) {
			index.eReferenceDAO().delete(eReferenceDesc);
		}
	}

	private ResourceDescriptor findResourceDescriptor(URI uri) {
		ResourceDescriptor resourceDescriptor = resourceDescCacheUri.get(uri);
		if (resourceDescriptor == null) {
			String uriAsString = uri.toString();
			resourceDescriptor = index.resourceDAO().createQuery().uri(uriAsString).executeSingleResult();
			if (resourceDescriptor == null) {
				resourceDescriptor = new ResourceDescriptorImpl(uriAsString, ResourceDescriptor.NEVER, null);
				index.resourceDAO().store(resourceDescriptor);
			}
		}
		return resourceDescriptor;
	}

	private void assertTransactionStarted() {
		if (!isTransactionStarted)
			throw new IllegalStateException("Not in transaction");
	}

	public void clearAllCaches() {
		resourceDataCache.clear();
		eObjectDataCache.clear();
		eReferenceCache.clear();
		resourceDescCacheUri.clear();
		eObjectDescCache.clear();
		allExistingEObjectDescs.clear();
		allExistingEReferenceDescs.clear();
	}

	private static class ResourceData {
		String uri;
		long indexingDate;
		Map<String, String> userData;
	}

	private static class EObjectData {
		String name;
		String fragment;
		String displayName;
		Map<String, String> userData;
	}

	private static class EReferenceData {
		URI sourceURI;
		URI targetURI;
		String eReferenceName;
		int index;
	}

}
