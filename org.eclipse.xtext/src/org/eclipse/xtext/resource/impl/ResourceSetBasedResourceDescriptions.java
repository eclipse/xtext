/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ISelectable;

import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 * @since 2.5
 */
public class ResourceSetBasedResourceDescriptions extends AbstractCompoundSelectable implements
		IResourceDescriptions.IContextAware, IResourceDescriptions.IResourceSetAware {

	private ResourceSet resourceSet;
	private ResourceDescriptionsData data;

	@Inject
	private IResourceServiceProvider.Registry registry;

	public void setRegistry(IResourceServiceProvider.Registry registry) {
		this.registry = registry;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		if (data != null) {
			return data.getAllResourceDescriptions();
		}
		return Iterables.filter(new Iterable<IResourceDescription>() {
			@Override
			public Iterator<IResourceDescription> iterator() {
				return new AbstractIterator<IResourceDescription>() {
					int index = 0;
					List<Resource> resources = resourceSet.getResources();

					@Override
					protected IResourceDescription computeNext() {
						if (resources.size() <= index)
							return endOfData();
						Resource resource = resources.get(index);
						index++;
						return getResourceDescription(resource.getURI());
					}
				};
			}
		}, Predicates.notNull());

	}

	@Override
	protected Iterable<? extends ISelectable> getSelectables() {
		return getAllResourceDescriptions();
	}

	@Override
	public boolean isEmpty() {
		if (data != null) {
			return data.isEmpty();
		}
		return resourceSet.getResources().isEmpty();
	}

	/**
	 * @since 2.1
	 */
	protected boolean hasDescription(URI uri) {
		if (data != null) {
			return data.getResourceDescription(uri) != null;
		}
		Resource resource = resourceSet.getResource(uri, false);
		return resource != null;
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		if (data != null) {
			return data.getResourceDescription(uri);
		}
		Resource resource = resourceSet.getResource(uri, false);
		if (resource == null)
			return null;
		IResourceServiceProvider resourceServiceProvider = registry.getResourceServiceProvider(uri);
		if (resourceServiceProvider == null)
			return null;
		Manager manager = resourceServiceProvider.getResourceDescriptionManager();
		if (manager == null)
			return null;
		return manager.getResourceDescription(resource);
	}

	@Override
	public void setContext(Notifier ctx) {
		this.resourceSet = EcoreUtil2.getResourceSet(ctx);
		if (resourceSet != null) {
			data = ResourceDescriptionsData.ResourceSetAdapter.findResourceDescriptionsData(resourceSet);
		}
	}
	
	protected ResourceDescriptionsData getData() {
		return data;
	}
	
	protected void setData(ResourceDescriptionsData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "[" + getClass().getSimpleName() + "\n  " + Joiner.on("\n  ").join(getAllResourceDescriptions()) + "\n]";
	}

	/**
	 * @since 2.5
	 */
	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		if (data != null) {
			return data.getExportedObjects();
		}
		return super.getExportedObjects();
	}

	/**
	 * @since 2.5
	 */
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		if (data != null) {
			return data.getExportedObjectsByType(type);
		}
		return super.getExportedObjectsByType(type);
	}

	/**
	 * @since 2.5
	 */
	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName qualifiedName, boolean ignoreCase) {
		if (data != null) {
			return data.getExportedObjects(type, qualifiedName, ignoreCase);
		}
		return super.getExportedObjects(type, qualifiedName, ignoreCase);
	}

	/**
	 * @since 2.5
	 */
	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		if (data != null) {
			return data.getExportedObjectsByObject(object);
		}
		return super.getExportedObjectsByObject(object);
	}

}
