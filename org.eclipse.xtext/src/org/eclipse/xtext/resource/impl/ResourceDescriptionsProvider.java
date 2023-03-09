/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescriptionsProvider;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * The {@link ResourceDescriptionsProvider} allows to obtain a readily configured instance of the
 * {@link IResourceDescriptions} depending on the use case and lifecylce of the resource set.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
public class ResourceDescriptionsProvider implements IResourceDescriptionsProvider {

	/**
	 * This flag configures Xtext's scoping for a {@link ResourceSet} for the (incremental) build. This should not be
	 * used by clients, since it is tailored for org.eclipse.xtext.builder.impl.XtextBuilder.
	 */
	public static final String NAMED_BUILDER_SCOPE = "org.eclipse.xtext.scoping.namespaces.DefaultGlobalScopeProvider.BUILDER_SCOPE";

	/**
	 * This flag configures Xtext's scoping for a {@link ResourceSet} to use Xtext's index shadowed by the dirty
	 * editors' state shadowed by the ResourceSet's contents.
	 * 
	 * I.e., scoping will look for a IResourceDescription first in the ResourecSet, then in dirty editors and then in
	 * the index.
	 * 
	 * If possible, don't use this this flag directly but use
	 * org.eclipse.xtext.ui.resource.LiveScopeResourceSetInitializer instead.
	 */
	public static final String LIVE_SCOPE = "org.eclipse.xtext.scoping.LIVE_SCOPE";

	/**
	 * This flag configures Xtext's scoping for a {@link ResourceSet} to use Xtext's index only. Dirty state and the
	 * ResourceSet's contents are ignored.
	 *
	 * @since 2.6
	 * */
	public static final String PERSISTED_DESCRIPTIONS = "org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.PERSISTED_DESCRIPTIONS";

	@Inject(optional = true)
	@Named(NAMED_BUILDER_SCOPE)
	private Provider<IResourceDescriptions> builderScopeResourceDescriptions;

	@Inject(optional = true)
	@Named(LIVE_SCOPE)
	private Provider<IResourceDescriptions> liveScopeResourceDescriptions;

	@Inject(optional = true)
	@Named(PERSISTED_DESCRIPTIONS)
	private Provider<IResourceDescriptions> persistedResourceDescriptions;

	@Inject(optional = true)
	private Provider<IResourceDescriptions> resourceDescriptions;

	public IResourceDescriptions getResourceDescriptions(Resource resource) {
		return getResourceDescriptions(resource.getResourceSet());
	}

	/**
	 * Provides the proper resource descriptions according to the context in which the resource set is used.
	 * 
	 * The context is indicated by the {@link ResourceSet#getLoadOptions() load options} of the resource set. Supported
	 * options are:
	 * 
	 * <ol>
	 * <li>{@link #NAMED_BUILDER_SCOPE}</li>
	 * <li>{@link #LIVE_SCOPE}</li>
	 * <li>{@link #PERSISTED_DESCRIPTIONS}</li>
	 * <li>If no such option is present the dirty editors are taken into account to contribute their contents to the
	 * index</li>
	 * </ol>
	 * 
	 * 
	 * The result is never <code>null</code>.
	 * 
	 * @param resourceSet
	 *            the resource set that is currently used.
	 * @return the {@link IResourceDescriptions} according to the usage context.
	 * 
	 * @since 2.1
	 */
	/* @NonNull */
	@Override
	public IResourceDescriptions getResourceDescriptions(/* @NonNull */ ResourceSet resourceSet) {
		String flag = getFlagFromLoadOptions(resourceSet);
		IResourceDescriptions result;
		if (NAMED_BUILDER_SCOPE.equals(flag)) {
			result = createBuilderScopeResourceDescriptions();
		} else if (LIVE_SCOPE.equals(flag)) {
			result = createLiveScopeResourceDescriptions();
		} else if (PERSISTED_DESCRIPTIONS.equals(flag)) {
			result = createPersistedResourceDescriptions();
		} else {
			result = ChunkedResourceDescriptions.findInEmfObject(resourceSet);
			if (result == null) {
				result = createResourceDescriptions();
			}
		}
		if (result instanceof IResourceDescriptions.IContextAware) {
			((IResourceDescriptions.IContextAware) result).setContext(resourceSet);
		}
		return result;
	}

	private String getFlagFromLoadOptions(ResourceSet resourceSet) {
		Map<Object, Object> loadOptions = resourceSet.getLoadOptions();
		String[] mutualExclusiveFlags = new String[] { NAMED_BUILDER_SCOPE, LIVE_SCOPE, PERSISTED_DESCRIPTIONS };
		String result = null;
		for (int i = 0; i < mutualExclusiveFlags.length; i++) {
			String candidate = mutualExclusiveFlags[i];
			if (loadOptions.containsKey(candidate)) {
				if (result == null) {
					result = candidate;
				} else {
					String msg = "Ambiguous scope for the resource set. Can't combine " + result + " and " + candidate;
					throw new IllegalStateException(msg);
				}
			}
		}
		return result;
	}

	/**
	 * The returned IResourceDescriptions represent the Xtext Index' state shadowed by the Editors Dirty State shadowed
	 * by the current ResourceSets contents.
	 */
	public IResourceDescriptions createLiveScopeResourceDescriptions() {
		return liveScopeResourceDescriptions.get();
	}

	/**
	 * The returned IResourceDescriptions are used by the Xtext Builder to update the Index.
	 */
	public IResourceDescriptions createBuilderScopeResourceDescriptions() {
		return builderScopeResourceDescriptions.get();
	}

	/**
	 * The returned IResourceDescriptions represent the Xtext Index' state shadowed by the Editors Dirty State.
	 */
	public IResourceDescriptions createResourceDescriptions() {
		return resourceDescriptions.get();
	}

	/**
	 * The returned IResourceDescriptions represent the Xtext Index' state (not shadowed by anything).
	 * 
	 * @since 2.6
	 * @throws IllegalStateException if the builder integration is not configured for this language but the persisted descriptions are requested
	 */
	public IResourceDescriptions createPersistedResourceDescriptions() {
		if (persistedResourceDescriptions == null) {
			throw new IllegalStateException("Language does not provide persisted descriptions.");
		}
		return persistedResourceDescriptions.get();
	}

	public void setBuilderScopeResourceDescriptions(Provider<IResourceDescriptions> resourceDescriptions) {
		this.builderScopeResourceDescriptions = resourceDescriptions;
	}

	public void setResourceDescriptions(Provider<IResourceDescriptions> resourceDescriptions) {
		this.resourceDescriptions = resourceDescriptions;
	}

	/**
	 * @since 2.6
	 */
	public void setLiveScopeResourceDescriptions(Provider<IResourceDescriptions> liveScopeResourceDescriptions) {
		this.liveScopeResourceDescriptions = liveScopeResourceDescriptions;
	}

	/**
	 * @since 2.6
	 */
	public void setPersistedResourceDescriptions(Provider<IResourceDescriptions> persistedResourceDescriptions) {
		this.persistedResourceDescriptions = persistedResourceDescriptions;
	}
}
