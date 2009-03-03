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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.index.ECrossReferenceDescriptor;
import org.eclipse.emf.index.EObjectDescriptor;
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ResourceDescriptor;
import org.eclipse.emf.index.ecore.EClassDescriptor;
import org.eclipse.emf.index.impl.ECrossReferenceDescriptorImpl;
import org.eclipse.emf.index.impl.EObjectDescriptorImpl;
import org.eclipse.emf.index.impl.Logger;
import org.eclipse.emf.index.impl.ResourceDescriptorImpl;
import org.eclipse.emf.index.resource.IndexFeeder;
import org.eclipse.emf.index.util.MultiMap;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IndexFeederImpl implements IndexFeeder {

	private IIndexStore index;

	private boolean isTransactionStarted;

	private Map<Resource, ResourceData> resourceDataCache = new HashMap<Resource, ResourceData>();
	private Map<EObject, EObjectData> eObjectDataCache = new HashMap<EObject, EObjectData>();
	private MultiMap<EObject, ECrossReferenceData> crossRefDataCache = new MultiMap<EObject, ECrossReferenceData>();

	private Map<Resource, ResourceDescriptor> resourceDescCache = new HashMap<Resource, ResourceDescriptor>();
	private Map<EObject, EObjectDescriptor> eObjectDescCache = new HashMap<EObject, EObjectDescriptor>();

	private List<EObjectDescriptor> allExistingEObjectDescs = new ArrayList<EObjectDescriptor>();
	private List<ECrossReferenceDescriptor> allExistingECrossRefDescs = new ArrayList<ECrossReferenceDescriptor>();

	public IndexFeederImpl(IIndexStore indexStore) {
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

	public void createECrossReferenceDescriptor(EObject owner, EReference eReference) {
		assertTransactionStarted();
		Resource eResource = owner.eResource();
		if (eResource != null) {
			ECrossReferenceData eCrossReferenceData = new ECrossReferenceData();
			eCrossReferenceData.eReference = eReference;
			crossRefDataCache.put(owner, eCrossReferenceData);
		}
	}

	public void commit() {
		try {
			synchronized (index) {
				commitResourceDescriptors();
				commitEObjectDescriptors();
				commitECrossReferenceDescriptors();
				cleanUpStaleDescriptors();
			}
		}
		finally {
			isTransactionStarted = false;
			clearAllCaches();
		}
	}

	private void commitResourceDescriptors() {
		for (Entry<Resource, ResourceData> resourceEntry : resourceDataCache.entrySet()) {
			Resource resource = resourceEntry.getKey();
			ResourceData data = resourceEntry.getValue();
			ResourceDescriptor existingResourceDesc = index.resourceDAO().createQueryResource(resource)
					.executeSingleResult();
			ResourceDescriptor newResourceDescriptor = new ResourceDescriptorImpl(data.uri, data.indexingDate,
					data.userData);
			if (existingResourceDesc != null) {
				Collection<EObjectDescriptor> existingEObjectsInResource = index.eObjectDAO()
						.createQueryEObjectsInResource(existingResourceDesc).executeListResult();
				addAllIfNotNull(allExistingEObjectDescs, existingEObjectsInResource);
				index.resourceDAO().modify(existingResourceDesc, newResourceDescriptor);
				resourceDescCache.put(resource, existingResourceDesc);
			}
			else {
				index.resourceDAO().store(newResourceDescriptor);
				resourceDescCache.put(resource, newResourceDescriptor);
			}
		}
	}

	private void commitEObjectDescriptors() {
		for (Entry<EObject, EObjectData> eObjectEntry : eObjectDataCache.entrySet()) {
			EObject eObject = eObjectEntry.getKey();
			EObjectData data = eObjectEntry.getValue();
			Resource resource = eObject.eResource();
			ResourceDescriptor resourceDesc = findResourceDescriptor(resource);
			EClassDescriptor eClassDescriptor = index.eClassDAO().createQueryEClass(eObject.eClass())
					.executeSingleResult();
			EObjectDescriptor newEObjectDesc = new EObjectDescriptorImpl(resourceDesc, data.fragment, data.name,
					data.displayName, eClassDescriptor, data.userData);
			EObjectDescriptor existingEObjectDesc = findEquivalent(allExistingEObjectDescs, newEObjectDesc);
			if (existingEObjectDesc != null) {
				Collection<ECrossReferenceDescriptor> existingECrossRefDescsFrom = index.eCrossReferenceDAO()
						.createQueryCrossReferencesFrom(existingEObjectDesc).executeListResult();
				addAllIfNotNull(allExistingECrossRefDescs, existingECrossRefDescsFrom);
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

	private void commitECrossReferenceDescriptors() {
		for (EObject source : crossRefDataCache.keySet()) {
			EObjectDescriptor sourceDesc = findEObjectDescriptor(source);
			if (sourceDesc != null) {
				for (ECrossReferenceData data : crossRefDataCache.get(source)) {
					if (data.eReference.isMany()) {
						List<?> targetList = (List<?>) source.eGet(data.eReference);
						for (int i = 0; i < targetList.size(); ++i) {
							indexECrossReference(sourceDesc, data.eReference, targetList.get(i), i);
						}
					}
					else {
						indexECrossReference(sourceDesc, data.eReference, source.eGet(data.eReference),
								ECrossReferenceDescriptor.NO_INDEX);
					}
				}
			}
		}
	}

	private void cleanUpStaleDescriptors() {
		for (EObjectDescriptor eObjectDesc : allExistingEObjectDescs) {
			index.eObjectDAO().delete(eObjectDesc);
		}
		for (ECrossReferenceDescriptor eCrossReferenceDesc : allExistingECrossRefDescs) {
			index.eCrossReferenceDAO().delete(eCrossReferenceDesc);
		}
	}

	private void indexECrossReference(EObjectDescriptor sourceDesc, EReference eReference, Object targetObject, int i) {
		if (!(targetObject instanceof EObject)) {
			Logger.logError("Target element #" + index + " of crossReference is not an EObject", new Exception());
			return;
		}
		EObjectDescriptor targetDesc = findEObjectDescriptor((EObject) targetObject);
		if (targetDesc != null) {
			ECrossReferenceDescriptor eCrossReferenceDesc = new ECrossReferenceDescriptorImpl(sourceDesc, eReference
					.getName(), targetDesc, i);
			if (!allExistingECrossRefDescs.remove(eCrossReferenceDesc)) {
				index.eCrossReferenceDAO().store(eCrossReferenceDesc);
			}
		}
	}

	private EObjectDescriptor findEObjectDescriptor(EObject eObject) {
		EObjectDescriptor eObjectDesc = eObjectDescCache.get(eObject);
		if (eObjectDesc == null) {
			Resource resource = eObject.eResource();
			if (resource == null)
				return null;
			ResourceDescriptor resourceDesc = findResourceDescriptor(resource);
			eObjectDesc = index.eObjectDAO().createQueryEObjectInResource(eObject, resourceDesc).executeSingleResult();
			if (eObjectDesc == null) {
				EClass eClass = eObject.eClass();
				EClassDescriptor eClassDesc = index.eClassDAO().createQueryEClass(eClass).executeSingleResult();
				if (eClassDesc == null) {
					Logger.logError("EClass " + eClass.getName() + " is not registered", new Exception());
					return null;
				}
				String fragment = resource.getURIFragment(eObject);
				eObjectDesc = new EObjectDescriptorImpl(resourceDesc, fragment, "<NOT INDEXED>", "<NOT INDEXED>",
						eClassDesc, null);
			}
		}
		return eObjectDesc;
	}

	private ResourceDescriptor findResourceDescriptor(Resource resource) {
		ResourceDescriptor resourceDescriptor = resourceDescCache.get(resource);
		if (resourceDescriptor == null)
			resourceDescriptor = index.resourceDAO().createQueryResource(resource).executeSingleResult();
		if (resourceDescriptor == null) {
			resourceDescriptor = new ResourceDescriptorImpl(resource.getURI().toString(), ResourceDescriptor.NEVER,
					null);
			index.resourceDAO().store(resourceDescriptor);
		}
		return resourceDescriptor;
	}

	private void assertTransactionStarted() {
		if (!isTransactionStarted)
			throw new IllegalStateException("Not in transaction");
	}

	private void clearAllCaches() {
		resourceDataCache.clear();
		eObjectDataCache.clear();
		crossRefDataCache.clear();

		resourceDescCache.clear();
		eObjectDescCache.clear();
		allExistingEObjectDescs.clear();
		allExistingECrossRefDescs.clear();
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

	private static class ECrossReferenceData {
		EReference eReference;
	}

}
