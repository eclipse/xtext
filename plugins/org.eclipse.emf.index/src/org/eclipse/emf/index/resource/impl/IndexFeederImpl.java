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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.EReferenceDescriptor;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.IndexingException;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.impl.EObjectDescriptorImpl;
import org.eclipse.emf.index.impl.EReferenceDescriptorImpl;
import org.eclipse.emf.index.impl.ResourceDescriptorImpl;
import org.eclipse.emf.index.internal.LogFacade;
import org.eclipse.emf.index.resource.IndexFeeder;

import com.google.inject.Inject;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IndexFeederImpl implements IndexFeeder {

	private IndexStore index;

	@Inject(optional = true)
	private EcoreIndexFeeder ecoreIndexFeeder;

	private List<URI> deleteResourceURIs = new ArrayList<URI>();

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
	}

	public void deleteResourceDescriptor(URI resourceURI) throws IndexingException {
		for (Resource addedResources : resourceDataCache.keySet()) {
			if (addedResources.getURI().equals(resourceURI)) {
				throw new IndexingException("Cannot add and remove resource in the same transaction", resourceURI);
			}
		}
		deleteResourceURIs.add(resourceURI);
	}

	public void createResourceDescriptor(Resource resource, Map<String, Serializable> userData)
			throws IndexingException {
		URI resourceURI = resource.getURI();
		for (URI deleteResourceURI : deleteResourceURIs) {
			if (resourceURI.equals(deleteResourceURI)) {
				throw new IndexingException("Cannot add and remove resource in the same transaction", resourceURI);
			}
		}
		ResourceData resourceData = new ResourceData();
		resourceData.uri = resourceURI.toString();
		resourceData.indexingDate = System.currentTimeMillis();
		resourceData.userData = userData;
		resourceDataCache.put(resource, resourceData);
	}

	public void createEObjectDescriptor(EObject eObject, String name, String displayName,
			Map<String, Serializable> userData) {
		Resource eResource = eObject.eResource();
		if (eResource != null) {
			EObjectData eObjectData = new EObjectData();
			eObjectData.fragment = eResource.getURIFragment(eObject);
			eObjectData.name = name;
			eObjectData.displayName = displayName;
			eObjectData.userData = userData;
			eObjectDataCache.put(eObject, eObjectData);
		}
		else {
			LogFacade.logError("Cannot index an EObject that is not contained in a resource");
		}
	}

	public void createEReferenceDescriptor(URI sourceURI, String eReferenceName, int index, URI targetURI) {
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
				index.beginWrite();
				try {
					commitResourceDescriptors();
					commitEObjectDescriptors();
					commitEReferenceDescriptors();
					deleteStaleDescriptors();
				}
				finally {
					index.endWrite();
				}
			}
		}
		finally {
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
				Collection<EReferenceDescriptor> existingEReferencesFromResource = toList(index.eReferenceDAO()
						.createQuery().sourceResource(existingResourceDesc).executeListResult());
				addAllIfNotNull(allExistingEReferenceDescs, existingEReferencesFromResource);
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
			EClass eClass = eObject.eClass();
			EClassDescriptor eClassDescriptor = findEClassDescriptor(eClass);
			if (eClassDescriptor == null) {
				LogFacade.logError("Couldn't find EClassDescriptor for EClass " + eClass.getName());
				continue;
			}
			EObjectDescriptor newEObjectDesc = new EObjectDescriptorImpl(resourceDesc, data.fragment, data.name,
					data.displayName, eClassDescriptor, data.userData);
			EObjectDescriptor existingEObjectDesc = findEquivalent(allExistingEObjectDescs, newEObjectDesc);
			if (existingEObjectDesc != null) {
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

	private EClassDescriptor findEClassDescriptor(EClass eClass) {
		EClassDescriptor eClassDescriptor = index.eClassDAO().createQueryEClass(eClass).executeSingleResult();
		if (eClassDescriptor == null && ecoreIndexFeeder != null && eClass.getEPackage() != null) {
			ecoreIndexFeeder.index(eClass.getEPackage(), false);
			eClassDescriptor = index.eClassDAO().createQueryEClass(eClass).executeSingleResult();
		}
		return eClassDescriptor;
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

	public void deleteStaleDescriptors() {
		for (URI deleteResourceURI : deleteResourceURIs) {
			ResourceDescriptor deleteResourceDescriptor = index.resourceDAO().createQuery().uri(
					deleteResourceURI.toString()).executeSingleResult();
			if (deleteResourceDescriptor != null) {
				List<EObjectDescriptor> deleteEObjects = toList(index.eObjectDAO().createQueryEObjectsInResource(
						deleteResourceDescriptor).executeListResult());
				addAllIfNotNull(allExistingEObjectDescs, deleteEObjects);
				List<EReferenceDescriptor> deleteEReferences = toList(index.eReferenceDAO()
						.createQueryEReferencesFromResource(deleteResourceDescriptor).executeListResult());
				addAllIfNotNull(allExistingEReferenceDescs, deleteEReferences);
				index.resourceDAO().delete(deleteResourceDescriptor);
			}
		}
		for (EObjectDescriptor eObjectDesc : allExistingEObjectDescs) {
			index.eObjectDAO().delete(eObjectDesc);
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

	public void clearAllCaches() {
		resourceDataCache.clear();
		eObjectDataCache.clear();
		eReferenceCache.clear();
		resourceDescCacheUri.clear();
		eObjectDescCache.clear();
		allExistingEObjectDescs.clear();
		allExistingEReferenceDescs.clear();
		deleteResourceURIs.clear();
	}

	private static class ResourceData {
		String uri;
		long indexingDate;
		Map<String, Serializable> userData;
	}

	private static class EObjectData {
		String name;
		String fragment;
		String displayName;
		Map<String, Serializable> userData;
	}

	private static class EReferenceData {
		URI sourceURI;
		URI targetURI;
		String eReferenceName;
		int index;
	}

}
