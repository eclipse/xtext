/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.IResourceIndexer;
import org.eclipse.xtext.builder.builderState.BuilderState;
import org.eclipse.xtext.builder.builderState.BuilderStateFactory;
import org.eclipse.xtext.builder.builderState.BuilderStateManager;
import org.eclipse.xtext.builder.builderState.impl.EObjectDescriptionImpl;
import org.eclipse.xtext.builder.builderState.impl.ResourceDescriptionImpl;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.collect.Collections2;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class ResourceIndexer implements IResourceIndexer {

	@Inject
	private BuilderStateManager builderStateManager;

	@Inject
	private IResourceDescription.Manager.Registry resourceDescriptionManagerRegistry;

	@Inject
	private StorageUtil storageUtil;

	@Inject
	private ResourceProvider resourceProvider;

	public void setResourceDescriptionManagerRegistry(IResourceDescription.Manager.Registry resourceDescriptionManagerRegistry) {
		this.resourceDescriptionManagerRegistry = resourceDescriptionManagerRegistry;
	}

	public IResourceDescription.Manager.Registry getResourceDescriptionManagerRegistry() {
		return resourceDescriptionManagerRegistry;
	}

	public void setBuilderStateManager(BuilderStateManager builderStateManager) {
		this.builderStateManager = builderStateManager;
	}

	public void setResourceProvider(ResourceProvider resourceProvider) {
		this.resourceProvider = resourceProvider;
	}

	public void setStorageUtil(StorageUtil storageUtil) {
		this.storageUtil = storageUtil;
	}

	public Set<String> delete(final IStorage storage) {
		final URI uri = resourceProvider.getURI(storage);
		if (uri == null)
			return Collections.emptySet();

		return builderStateManager.modify(new IUnitOfWork<Set<String>, BuilderState>() {
			public Set<String> exec(BuilderState state) throws Exception {
				IResourceDescription description = state.getResourceDescription(uri);
				if (description==null) 
					return Collections.emptySet();
				return delete((ResourceDescriptionImpl) description);
			}
		});
	}

	/**
	 * @param storage
	 * @return whether children of the given storage shall be asked
	 */
	public Set<String> addOrUpdate(final IStorage storage) {
		final Resource resource = resourceProvider.getResource(storage);
		if (resource == null)
			return Collections.emptySet();
		return builderStateManager.modify(new IUnitOfWork<Set<String>, BuilderState>() {
			public Set<String> exec(BuilderState state) throws Exception {
				ResourceDescriptionImpl res = (ResourceDescriptionImpl) state.getResourceDescription(resource.getURI());
				if (res==null) {
					
				}
				Set<String> exportedNames = getExportedNames(res);
				cleanAndUpdate(res, resource, storage);
				addExportedEObjects(resource, res);
				exportedNames.addAll(getExportedNames(res));
				return exportedNames;
			}

		});
	}

	protected Set<String> getExportedNames(IResourceDescription res) {
		HashSet<String> set = new HashSet<String>();
		for (IEObjectDescription desc : res.getExportedObjects()) {
			set.add(desc.getName());
		}
		return set;
	}

	protected void addExportedEObjects(final Resource resource, ResourceDescriptionImpl target) {
		IResourceDescription description = getResourceDescription(resource);
		Iterable<IEObjectDescription> objects = description.getExportedObjects();

		List<IEObjectDescription> descriptions = new ArrayList<IEObjectDescription>();
		for (IEObjectDescription ieObjectDescription : objects) {
			IEObjectDescription copy = createPersistableCopy(ieObjectDescription);
			descriptions.add(copy);
		}
		sortByName(descriptions);
		target.getExportedObjects().addAll(descriptions);
	}

	protected IResourceDescription getResourceDescription(Resource resource) {
		IResourceDescription.Manager descriptionManager = resourceDescriptionManagerRegistry.getResourceDescriptionManager(resource.getURI(),null);
		IResourceDescription description = descriptionManager.getResourceDescription(resource);
		return description;
	}

	protected void cleanAndUpdate(ResourceDescriptionImpl target, Resource resource, IStorage storage) {
		target.getImportedNames().clear();
		target.getExportedObjects().clear();
		target.setPathToStorage(storageUtil.toExternalString(storage));
		target.setURI(resource.getURI());
	}

	protected void sortByName(List<IEObjectDescription> eObjectDescriptions) {
		Collections.sort(eObjectDescriptions, new Comparator<IEObjectDescription>() {
			public int compare(IEObjectDescription o1, IEObjectDescription o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
	}

	protected IEObjectDescription createPersistableCopy(IEObjectDescription ieObjectDescription) {
		EObjectDescriptionImpl desc = (EObjectDescriptionImpl) BuilderStateFactory.eINSTANCE.createEObjectDescription();
		desc.setEClass(ieObjectDescription.getEClass());
		desc.setFragment(ieObjectDescription.getEObjectURI().fragment());
		desc.setName(ieObjectDescription.getName());
		for (String key : ieObjectDescription.getUserDataKeys()) {
			desc.getUserData().put(key, ieObjectDescription.getUserData(key));
		}
		return desc;
	}

	protected ResourceDescriptionImpl createResourceDescriptor(IResourceDescription resource, IStorage storage) {
		ResourceDescriptionImpl description = (ResourceDescriptionImpl) BuilderStateFactory.eINSTANCE.createResourceDescription();
		description.getImportedNames().addAll(Collections2.forIterable(resource.getImportedNames()));
		for (IEObjectDescription desc : resource.getExportedObjects()) {
			EObjectDescriptionImpl objectDescription = (EObjectDescriptionImpl) BuilderStateFactory.eINSTANCE.createEObjectDescription();
			objectDescription.setEClass(desc.getEClass());
			objectDescription.setFragment(desc.getEObjectURI().fragment());
			objectDescription.setName(desc.getName());
			for (String key : desc.getUserDataKeys()) {
				objectDescription.getUserData().put(key, desc.getUserData(key));
			}
		}
		return description;
	}

	protected String getProjectName(IStorage storage) {
		if (storage instanceof IResource) {
			return ((IResource) storage).getProject().getName();
		}
		throw new UnsupportedOperationException("Couldn't handle storage " + storage);
	}

	public Set<String> delete(ResourceDescriptionImpl persistent) {
		Set<String> affectedStrings = new HashSet<String>();
		for (IEObjectDescription description : persistent.getExportedObjects()) {
			affectedStrings.add(description.getName());
		}
		((BuilderState)persistent.eContainer()).getResourceDescriptions().remove(persistent);
		return affectedStrings;
	}
}
