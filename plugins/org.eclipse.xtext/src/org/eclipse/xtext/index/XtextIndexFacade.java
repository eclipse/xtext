/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.index;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextIndexFacade implements IXtextIndexFacade {

	private IResourceDescription.Manager.Registry resourceDescriptionsManager;
	
	public Iterable<IEObjectDescription> findAllDescriptionsFor(EObject object) {
		if (object.eIsProxy())
			throw new IllegalArgumentException("object may not be a proxy: " + object);
		IResourceDescription.Manager descriptionManager = resourceDescriptionsManager.getResourceDescriptionManager(object.eResource().getURI(), null);
		if (descriptionManager == null)
			throw new IllegalStateException("Cannot find description manager for " + object);
		IResourceDescription description = descriptionManager.getResourceDescription(object.eResource());
		return description.getExportedObjectsForEObject(object);
	}

	public Iterable<IEObjectDescription> findAllEObjects(IContainer in, final EClass type) {
		return Iterables.concat(Iterables.transform(in.getResourceDescriptions(), new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				IResourceDescription resourceDescription = getActualResourceDescription(from);
				return resourceDescription.getExportedObjects(type);
			}
		}));
	}

	public Iterable<IEObjectDescription> findAllEObjects(IContainer in, final EClass type, final String name) {
		return Iterables.concat(Iterables.transform(in.getResourceDescriptions(), new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				IResourceDescription resourceDescription = getActualResourceDescription(from);
				return resourceDescription.getExportedObjects(type, name);
			}
		}));
	}
	
	protected IResourceDescription getActualResourceDescription(IResourceDescription persisted) {
		return persisted;
	}
	
	public IResourceDescription.Manager.Registry getResourceDescriptionsManager() {
		return resourceDescriptionsManager;
	}
	
	public void setResourceDescriptionsManager(IResourceDescription.Manager.Registry resourceDescriptionsManager) {
		this.resourceDescriptionsManager = resourceDescriptionsManager;
	}
}
