/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

/**
 * An internal provider for {@link IFeatureScopeTracker feature scope trackers} that disables
 * the feature scope tracking for the builder's resource set, since the tracking is only
 * necessary in the editor.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuilderAwareFeatureScopeTrackerProvider implements IFeatureScopeTracker.Provider {

	public IFeatureScopeTracker track(EObject root) {
		Resource resource = root.eResource();
		if (resource != null) {
			ResourceSet resourceSet = resource.getResourceSet();
			if (resourceSet != null) {
				Map<Object, Object> loadOptions = resourceSet.getLoadOptions();
				if (isBuilderScope(loadOptions)) {
					return IFeatureScopeTracker.NULL;
				}
				if (isLiveScope(loadOptions)) {
					return IFeatureScopeTracker.NULL;
				}
				if (!isPrimaryResource(resourceSet, resource)) {
					return IFeatureScopeTracker.NULL;
				}
			}
		}
		return new FeatureScopeTracker();
	}

	protected boolean isLiveScope(Map<Object, Object> loadOptions) {
		boolean liveScope = loadOptions.containsKey(ResourceDescriptionsProvider.LIVE_SCOPE);
		return liveScope;
	}

	protected boolean isPrimaryResource(ResourceSet resourceSet, Resource resource) {
		boolean result = resourceSet.getResources().get(0) == resource;
		return result;
	}

	protected boolean isBuilderScope(Map<Object, Object> loadOptions) {
		boolean builderScope = loadOptions.containsKey(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE);
		return builderScope;
	}

}
