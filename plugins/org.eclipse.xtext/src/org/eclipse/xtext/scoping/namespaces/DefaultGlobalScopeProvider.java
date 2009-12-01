/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.namespaces;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class DefaultGlobalScopeProvider extends AbstractScopeProvider implements IGlobalScopeProvider {
	public static final String NAMED_BUILDER_SCOPE = "org.eclipse.xtext.scoping.namespaces.DefaultGlobalScopeProvider.BUILDER_SCOPE";

	@Inject
	private IContainer.Manager containerManager;

	@Inject
	private IResourceDescription.Manager descriptionManager;

	//	@Inject(optional=true)  did not work - that's why I'll register a dummy binding for now
	@Inject
	@Named(NAMED_BUILDER_SCOPE)
	private Provider<IResourceDescriptions> builderScopeResourceDescriptions;

	@Inject
	private Provider<IResourceDescriptions> resourceDescriptions;

	public void setBuilderScopeResourceDescriptions(Provider<IResourceDescriptions> resourceDescriptions) {
		this.builderScopeResourceDescriptions = resourceDescriptions;
	}

	public void setResourceDescriptions(Provider<IResourceDescriptions> resourceDescriptions) {
		this.resourceDescriptions = resourceDescriptions;
	}

	public IResourceDescriptions getResourceDescriptions(EObject ctx) {
		Map<Object, Object> loadOptions = ctx.eResource().getResourceSet().getLoadOptions();
		IResourceDescriptions result = resourceDescriptions.get();
		if (loadOptions.containsKey(NAMED_BUILDER_SCOPE)) {
			result = builderScopeResourceDescriptions.get();
		}
		if (result instanceof IResourceDescriptions.IContextAware) {
			((IResourceDescriptions.IContextAware) result).setContext(ctx);
		}
		return result;
	}

	public IScope getScope(final EObject context, EReference reference) {
		IScope result = IScope.NULLSCOPE;
		List<IContainer> containers = getVisibleContainers(context);
		Collections.reverse(containers);
		Iterator<IContainer> iter = containers.iterator();
		while (iter.hasNext()) {
			IContainer container = iter.next();
			result = createIndexScope(result, container, reference);
		}
		return result;
	}

	protected List<IContainer> getVisibleContainers(EObject context) {
		// TODO read state from ResourceSet
		IResourceDescription description = descriptionManager.getResourceDescription(context.eResource());
		List<IContainer> containers = containerManager.getVisibleContainers(description,
				getResourceDescriptions(context));
		return containers;
	}

	protected SimpleScope createIndexScope(IScope parent, final IContainer container, final EReference reference) {
		return new SimpleScope(parent, null) {

			@Override
			public Iterable<IEObjectDescription> internalGetContents() {
				return container.findAllEObjects(reference.getEReferenceType());
			}

			@Override
			public IEObjectDescription getContentByName(String name) {
				Iterable<IEObjectDescription> allDescriptions = container.findAllEObjects(
						reference.getEReferenceType(), name);
				Iterator<IEObjectDescription> iter = allDescriptions.iterator();
				IEObjectDescription result = null;
				while (iter.hasNext()) {
					if (result != null)
						return null;
					result = iter.next();
				}
				if (result != null)
					return result;
				return getOuterScope().getContentByName(name);
			}

			@Override
			public IEObjectDescription getContentByEObject(EObject object) {
				Iterable<IEObjectDescription> allDescriptions = findAllDescriptionsFor(object);
				Iterator<IEObjectDescription> iter = allDescriptions.iterator();
				boolean hadNext = false;
				while (iter.hasNext()) {
					hadNext = true;
					IEObjectDescription result = iter.next();
					if (isValidForEObject(result))
						return result;
				}
				if (hadNext)
					return null;
				return getOuterScope().getContentByEObject(object);
			}

			private boolean isValidForEObject(IEObjectDescription result) {
				Iterable<IEObjectDescription> allDescriptionsByName = container.findAllEObjects(reference
						.getEReferenceType(), result.getName());
				Iterator<IEObjectDescription> iter = allDescriptionsByName.iterator();
				IEObjectDescription inverted = null;
				while (iter.hasNext()) {
					if (inverted != null)
						return false;
					inverted = iter.next();
				}
				return inverted != null && inverted.getEObjectURI().equals(result.getEObjectURI());
			}
		};
	}

	private IResourceServiceProvider.Registry resourceServiceProviderRegistry;

	public Iterable<IEObjectDescription> findAllDescriptionsFor(EObject object) {
		if (object.eIsProxy())
			throw new IllegalArgumentException("object may not be a proxy: " + object);
		IResourceDescription.Manager descriptionManager = resourceServiceProviderRegistry.getResourceServiceProvider(
				object.eResource().getURI(), null).getResourceDescriptionManager();
		if (descriptionManager == null)
			throw new IllegalStateException("Cannot find description manager for " + object);
		IResourceDescription description = descriptionManager.getResourceDescription(object.eResource());
		return description.getExportedObjectsForEObject(object);
	}

	protected IResourceDescription getActualResourceDescription(IResourceDescription persisted) {
		return persisted;
	}

	public IResourceServiceProvider.Registry getResourceServiceProviderRegistry() {
		return resourceServiceProviderRegistry;
	}

	public void setResourceServiceProviderRegistry(IResourceServiceProvider.Registry resourceDescriptionsManager) {
		this.resourceServiceProviderRegistry = resourceDescriptionsManager;
	}

}
