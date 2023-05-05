/**
 * Copyright (c) 2016, 2023 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.findReferences.IReferenceFinder;
import org.eclipse.xtext.findReferences.TargetURICollector;
import org.eclipse.xtext.findReferences.TargetURIs;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public abstract class AbstractHierarchyBuilder implements IHierarchyBuilder {
	private IReferenceFinder.IResourceAccess resourceAccess;

	private IResourceDescriptions indexData;

	@Inject
	private IReferenceFinder referenceFinder;

	@Inject
	private TargetURICollector targetURICollector;

	@Inject
	private Provider<TargetURIs> targetURIProvider;

	@Inject
	private IHierarchyNodeLocationProvider hierarchyNodeLocationProvider;

	@Inject
	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	protected <R extends Object> R readOnly(URI objectURI, IUnitOfWork<R, EObject> work) {
		return getResourceAccess().readOnly(objectURI, (ResourceSet resourceSet) -> {
			EObject targetObject = resourceSet.getEObject(objectURI, true);
			return work.exec(targetObject);
		});
	}

	protected IEObjectDescription getDescription(URI objectURI) {
		IResourceDescription resourceDescription = getIndexData().getResourceDescription(objectURI.trimFragment());
		if (resourceDescription == null) {
			return null;
		}
		for (IEObjectDescription o : resourceDescription.getExportedObjects()) {
			if (Objects.equal(o.getEObjectURI(), objectURI)) {
				return o;
			}
		}
		return null;
	}

	protected IEObjectDescription getDescription(EObject object) {
		if (object == null) {
			return null;
		}
		return IterableExtensions.head(getIndexData().getExportedObjectsByObject(object));
	}

	protected boolean isAssignable(EClass superType, EClassifier type) {
		if (type instanceof EClass) {
			return EcoreUtil2.isAssignableFrom(superType, ((EClass) type));
		}
		return false;
	}

	protected IReferenceFinder.IResourceAccess getResourceAccess() {
		return resourceAccess;
	}

	public void setResourceAccess(IReferenceFinder.IResourceAccess resourceAccess) {
		this.resourceAccess = resourceAccess;
	}

	protected IResourceDescriptions getIndexData() {
		return indexData;
	}

	public void setIndexData(IResourceDescriptions indexData) {
		this.indexData = indexData;
	}

	protected IReferenceFinder getReferenceFinder() {
		return referenceFinder;
	}

	public void setReferenceFinder(IReferenceFinder referenceFinder) {
		this.referenceFinder = referenceFinder;
	}

	protected TargetURICollector getTargetURICollector() {
		return targetURICollector;
	}

	public void setTargetURICollector(TargetURICollector targetURICollector) {
		this.targetURICollector = targetURICollector;
	}

	protected Provider<TargetURIs> getTargetURIProvider() {
		return targetURIProvider;
	}

	public void setTargetURIProvider(Provider<TargetURIs> targetURIProvider) {
		this.targetURIProvider = targetURIProvider;
	}

	protected IHierarchyNodeLocationProvider getHierarchyNodeLocationProvider() {
		return hierarchyNodeLocationProvider;
	}

	public void setHierarchyNodeLocationProvider(IHierarchyNodeLocationProvider hierarchyNodeLocationProvider) {
		this.hierarchyNodeLocationProvider = hierarchyNodeLocationProvider;
	}

	protected IResourceServiceProvider.Registry getResourceServiceProviderRegistry() {
		return resourceServiceProviderRegistry;
	}

	public void setResourceServiceProviderRegistry(IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
		this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
	}
}
