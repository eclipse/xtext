/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures.Provider;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
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
