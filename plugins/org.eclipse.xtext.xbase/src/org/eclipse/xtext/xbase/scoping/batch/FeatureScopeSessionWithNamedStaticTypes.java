/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures.Provider;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureScopeSessionWithNamedStaticTypes extends AbstractFeatureScopeSessionWithStaticTypes<Map<? extends JvmType, Set<String>>> {

	public FeatureScopeSessionWithNamedStaticTypes(AbstractFeatureScopeSession featureScopeSession,
			Map<? extends JvmType, Set<String>> staticFeatureProviders,
			Map<? extends JvmType, Set<String>> extensionProviders,
			IResolvedFeatures.Provider resolvedFeaturesProvider) {
		super(featureScopeSession, staticFeatureProviders, extensionProviders, resolvedFeaturesProvider);
	}
	
	@Override
	protected List<TypeBucket> concatTypeBuckets(Map<? extends JvmType, Set<String>> types, List<TypeBucket> parentResult, Provider resolvedFeaturesProvider) {
		if (types.isEmpty()) {
			return parentResult;
		}
		List<TypeBucket> result = Lists.newArrayListWithCapacity(3);
		result.add(new TypeWithRestrictedNamesBucket(getId(), types, resolvedFeaturesProvider));
		result.addAll(parentResult);
		return result;
	}
}
