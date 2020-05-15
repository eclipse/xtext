/*******************************************************************************
 * Copyright (c) 2020 Sebastian Zarnekow and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;
import org.eclipse.xtext.scoping.ICaseInsensitivityHelper;
import org.eclipse.xtext.scoping.impl.CaseInsensitivityHelper;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.INamesAreUniqueValidationHelper.Context;

import com.google.common.annotations.Beta;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Standard implementation of a {@link INamesAreUniqueValidationHelper.Context}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.22
 */
@Beta
public class DefaultUniqueNameContext implements INamesAreUniqueValidationHelper.Context {

	/**
	 * Base class for {@link INamesAreUniqueValidationHelper.ContextProvider}.
	 */
	public static abstract class BaseContextProvider implements INamesAreUniqueValidationHelper.ContextProvider {
		@Inject
		private IResourceServiceProvider.Registry resourceServiceProviderRegistry = IResourceServiceProvider.Registry.INSTANCE;
		@Inject
		private ICaseInsensitivityHelper caseInsensitivityHelper = new CaseInsensitivityHelper();

		protected IResourceServiceProvider getResourceServiceProvider(Resource r) {
			return resourceServiceProviderRegistry.getResourceServiceProvider(r.getURI());
		}

		protected IResourceDescription getResourceDescription(Resource resource) {
			IResourceDescription.Manager manager = getResourceDescriptionManager(resource);
			if (manager != null) {
				return manager.getResourceDescription(resource);
			}
			return null;
		}

		protected IResourceDescription.Manager getResourceDescriptionManager(Resource resource) {
			IResourceServiceProvider resourceServiceProvider = getResourceServiceProvider(resource);
			if (resourceServiceProvider == null) {
				return null;
			}
			return resourceServiceProvider.getResourceDescriptionManager();
		}

		protected ICaseInsensitivityHelper getCaseInsensitivityHelper() {
			return caseInsensitivityHelper;
		}

		protected void setResourceServiceProviderRegistry(
				IResourceServiceProvider.Registry resourceServiceProviderRegistry) {
			this.resourceServiceProviderRegistry = resourceServiceProviderRegistry;
		}
	}

	/**
	 * Base class for non-local unique name validation context providers.
	 */
	public static abstract class BaseGlobalContextProvider extends BaseContextProvider {
		@Inject
		private IResourceDescriptionsProvider indexAccess;

		protected IResourceDescriptions getIndex(Resource resource) {
			ResourceSet resourceSet = resource.getResourceSet();
			if (resourceSet == null) {
				return null;
			}
			return indexAccess.getResourceDescriptions(resourceSet);
		}

		protected boolean intersects(IResourceDescription left, IResourceDescription right, boolean caseSensitive) {
			for (IEObjectDescription description : left.getExportedObjects()) {
				Iterable<IEObjectDescription> exportedObjects = right.getExportedObjects(EcorePackage.Literals.EOBJECT,
						description.getName(), !caseSensitive);
				if (!Iterables.isEmpty(exportedObjects)) {
					return true;
				}
			}
			return false;
		}

		protected boolean isAffected(IResourceDescription.Delta delta, IResourceDescription candidate,
				boolean caseSensitive) {
			if (candidate.getURI().equals(delta.getUri())) {
				return false;
			}
			if (delta.getNew() != null && intersects(delta.getNew(), candidate, caseSensitive)) {
				return true;
			}
			if (delta.getOld() != null && intersects(delta.getOld(), candidate, caseSensitive)) {
				return true;
			}
			return false;
		}
	}

	/**
	 * <p>
	 * Provide a context for the entire index.
	 * </p><p>
	 * Drawback: If a resoure in a project A introduces a duplication with a resource in project B, an incremental build
	 * of A may fail to notify B, if B is a dependency of A. Triggering a clean build in B will subsequently create the
	 * validation problem / fix the validation problem there, too but in Eclipse, the incremental build will not provide
	 * the same level of consistency.
	 * </p>
	 */
	@Singleton
	public static class Global extends BaseGlobalContextProvider {

		@Override
		public Context tryGetContext(Resource resource, CancelIndicator cancelIndicator) {
			IResourceDescriptions index = getIndex(resource);
			if (index == null) {
				return null;
			}
			IResourceDescription description = getResourceDescription(resource);
			if (description != null) {
				return new DefaultUniqueNameContext(description, index, getCaseInsensitivityHelper(), cancelIndicator);
			}
			return null;
		}

		@Override
		public boolean isAffected(Collection<IResourceDescription.Delta> deltas, IResourceDescription candidate,
				IResourceDescriptions context) {
			for (IResourceDescription.Delta delta : deltas) {
				if (isAffected(delta, candidate, true)) {
					return true;
				}
			}
			return false;
		}

	}

	/**
	 * Provide a context for current {@link IContainer}.
	 */
	@Singleton
	public static class Container extends BaseGlobalContextProvider {

		@Inject
		private IContainer.Manager containerManager;

		@Override
		public Context tryGetContext(Resource resource, CancelIndicator cancelIndicator) {
			IResourceDescriptions index = getIndex(resource);
			if (index == null) {
				return null;
			}
			IResourceDescription description = getResourceDescription(resource);
			if (description == null) {
				return null;
			}
			IContainer container = containerManager.getContainer(description, index);
			return new DefaultUniqueNameContext(description, container, getCaseInsensitivityHelper(), cancelIndicator);
		}

		@Override
		public boolean isAffected(Collection<IResourceDescription.Delta> deltas, IResourceDescription candidate,
				IResourceDescriptions context) {
			IContainer container = containerManager.getContainer(candidate, context);
			for (IResourceDescription.Delta delta : deltas) {
				if (delta.getNew() == null) {
					if (intersects(delta.getOld(), candidate, true)) {
						return true;
					}
				} else if (container.getResourceDescription(delta.getUri()) != null) {
					if (isAffected(delta, candidate, true)) {
						return true;
					}
				}
			}
			return false;
		}

	}

	/**
	 * Provide a context for all visible {@link IContainer containers}.
	 */
	@Singleton
	public static class VisibleContainers extends BaseGlobalContextProvider {

		public static class Selectable extends AbstractCompoundSelectable {

			private final List<IContainer> containers;

			public Selectable(List<IContainer> containers) {
				this.containers = containers;
			}

			@Override
			protected Iterable<? extends ISelectable> getSelectables() {
				return containers;
			}

		}

		@Inject
		private IContainer.Manager containerManager;

		@Override
		public Context tryGetContext(Resource resource, CancelIndicator cancelIndicator) {
			IResourceDescriptions index = getIndex(resource);
			if (index == null) {
				return null;
			}
			IResourceDescription description = getResourceDescription(resource);
			if (description == null) {
				return null;
			}
			List<IContainer> containers = containerManager.getVisibleContainers(description, index);
			return new DefaultUniqueNameContext(description, new Selectable(containers), getCaseInsensitivityHelper(),
					cancelIndicator);
		}

		@Override
		public boolean isAffected(Collection<IResourceDescription.Delta> deltas, IResourceDescription candidate,
				IResourceDescriptions context) {
			List<IContainer> containers = containerManager.getVisibleContainers(candidate, context);
			for (IResourceDescription.Delta delta : deltas) {
				if (delta.getNew() == null) {
					if (intersects(delta.getOld(), candidate, true)) {
						return true;
					}
				} else {
					containers: for (IContainer container : containers) {
						if (container.getResourceDescription(delta.getUri()) != null) {
							if (isAffected(delta, candidate, true)) {
								return true;
							}
							break containers;
						}
					}
				}
			}
			return false;
		}

	}

	/**
	 * A case sensitive validation context that ensures unique names among the exported names per single resource.
	 */
	@Singleton
	public static class ExportedFromResource extends BaseContextProvider {

		@SuppressWarnings("deprecation")
		@Override
		public Context tryGetContext(Resource resource, CancelIndicator cancelIndicator) {
			IResourceDescription description = getResourceDescription(resource);
			if (description != null) {
				return new UniqueInResourceContext(description, cancelIndicator);
			}
			return null;
		}

	}

	private final IResourceDescription resourceDescription;
	private final ISelectable validationScope;
	private final CancelIndicator cancelIndicator;
	private final ICaseInsensitivityHelper caseInsensitivityHelper;

	public DefaultUniqueNameContext(IResourceDescription resourceDescription, ISelectable validationScope,
			ICaseInsensitivityHelper caseInsensitivityHelper, CancelIndicator cancelIndicator) {
		this.resourceDescription = resourceDescription;
		this.validationScope = validationScope;
		this.caseInsensitivityHelper = caseInsensitivityHelper;
		this.cancelIndicator = cancelIndicator;
	}

	@Override
	public ISelectable getValidationScope(IEObjectDescription description, EClass clusterType) {
		return validationScope;
	}

	@Override
	public boolean isCaseSensitive(EObject object, EClass clusterType) {
		return !caseInsensitivityHelper.isIgnoreCase(object.eContainmentFeature());
	}

	@Override
	public Iterable<IEObjectDescription> getObjectsToValidate() {
		return resourceDescription.getExportedObjects();
	}

	@Override
	public CancelIndicator cancelIndicator() {
		return cancelIndicator;
	}

}
