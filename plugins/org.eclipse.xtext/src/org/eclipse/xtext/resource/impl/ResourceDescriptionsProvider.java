/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceDescriptionsProvider {

	public static final String NAMED_BUILDER_SCOPE = "org.eclipse.xtext.scoping.namespaces.DefaultGlobalScopeProvider.BUILDER_SCOPE";

	public static final String LIVE_SCOPE = "org.eclipse.xtext.scoping.LIVE_SCOPE";

	/** @since 2.6 */
	public static final String PERSISTED_DESCRIPTIONS = "org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.PERSISTED_DESCRIPTIONS";

	/** @since 2.6 */
	public static final String LIVE_MODEL_SCOPE = "org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.LIVE_MODEL_SCOPE";

	@Inject
	@Named(NAMED_BUILDER_SCOPE)
	private Provider<IResourceDescriptions> builderScopeResourceDescriptions;

	@Inject
	@Named(LIVE_SCOPE)
	private Provider<IResourceDescriptions> liveScopeResourceDescriptions;
	
	@Inject
	@Named(LIVE_MODEL_SCOPE)
	private Provider<IResourceDescriptions> liveModelScopeResourceDescriptions;
	
	@Inject
	@Named(PERSISTED_DESCRIPTIONS)
	private Provider<IResourceDescriptions> persistedResourceDescriptions;

	@Inject
	private Provider<IResourceDescriptions> resourceDescriptions;
	
	public IResourceDescriptions getResourceDescriptions(Resource resource) {
		return getResourceDescriptions(resource.getResourceSet());
	}
	
	/**
	 * Provides the proper resource descriptions according to the context in which the
	 * resource set is used.
	 * 
	 * The context is indicated by the {@link ResourceSet#getLoadOptions() load options} of 
	 * the resource set. Supported options are:
	 * 
	 * <ol>
	 * 	<li>{@link #NAMED_BUILDER_SCOPE} if the resource set is used in the builder.
	 *  <li>{@link #LIVE_SCOPE} if the resource set contains resources that are going to be 
	 *  	modified locally and should definitely shadow the context of the persisted 
	 *  	resource descriptions.</li>
	 *  <li>If no such option is present the dirty editors are taken into account to contribute
	 *  	their contents to the index</li>
	 * </ol>
	 * 
	 * 
	 * The result is never <code>null</code>.
	 * 
	 * @param resourceSet the resource set that is currently used.
	 * @return the {@link IResourceDescriptions} according to the usage context.
	 * 
	 * @since 2.1
	 */
	@NonNull
	public IResourceDescriptions getResourceDescriptions(@NonNull ResourceSet resourceSet) {
		Map<Object, Object> loadOptions = resourceSet.getLoadOptions();
		String[] mutualExclusiveFlags = new String[] { NAMED_BUILDER_SCOPE, LIVE_MODEL_SCOPE, LIVE_SCOPE, PERSISTED_DESCRIPTIONS };
		String flag = null;
		for (int i = 0; i < mutualExclusiveFlags.length; i++) {
			String candidate = mutualExclusiveFlags[i];
			if (loadOptions.containsKey(candidate)) {
				if (flag == null) {
					flag = candidate;
				} else {
					String msg = "Ambiguous scope for the resource set. Can't combine " + flag + " and " + candidate;
					throw new IllegalStateException(msg);
				}
			}
		}
		final IResourceDescriptions result;
		if (NAMED_BUILDER_SCOPE.equals(flag)) {
			result = createBuilderScopeResourceDescriptions();
		} else if (LIVE_SCOPE.equals(flag)) {
			result = createLiveScopeResourceDescriptions();
		} else if (LIVE_MODEL_SCOPE.equals(flag)) {
			result = createLiveModelScopeResourceDescriptions();
		} else if (PERSISTED_DESCRIPTIONS.equals(flag)) {
			result = createPersistedResourceDescriptions();
		} else {
			result = createResourceDescriptions();
		}
		if (result instanceof IResourceDescriptions.IContextAware) {
			((IResourceDescriptions.IContextAware) result).setContext(resourceSet);
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
	 * The returned IResourceDescriptions represent the Xtext Index' state shadowed by the current ResourceSets contents.
	 * 
	 * @since 2.6
	 */
	public IResourceDescriptions createLiveModelScopeResourceDescriptions() {
		return liveModelScopeResourceDescriptions.get();
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
	 * @since 2.6
	 */
	public IResourceDescriptions createPersistedResourceDescriptions() {
		return resourceDescriptions.get();
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
	public void setLiveModelScopeResourceDescriptions(Provider<IResourceDescriptions> liveModelScopeResourceDescriptions) {
		this.liveModelScopeResourceDescriptions = liveModelScopeResourceDescriptions;
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
