/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureScopeSessionWithStaticTypes extends AbstractNestedFeatureScopeSession {

	private final List<? extends JvmType> staticFeatureProviders;
	private final List<? extends JvmType> extensionProviders;
	
	private List<TypeBucket> staticallyImportedTypes;
	private List<TypeBucket> staticallyImportedExtensions;
	private IResolvedFeatures.Provider resolvedFeaturesProvider;

	public FeatureScopeSessionWithStaticTypes(AbstractFeatureScopeSession featureScopeSession,
			List<? extends JvmType> staticFeatureProviders,
			List<? extends JvmType> extensionProviders,
			IResolvedFeatures.Provider resolvedFeaturesProvider) {
		super(featureScopeSession);
		this.staticFeatureProviders = staticFeatureProviders;
		this.extensionProviders = extensionProviders;
		this.resolvedFeaturesProvider = resolvedFeaturesProvider;
	}
	
	@Override
	public List<TypeBucket> getStaticallyImportedTypes() {
		if (staticallyImportedTypes != null)
			return staticallyImportedTypes;
		return staticallyImportedTypes = concatTypeBuckets(staticFeatureProviders, super.getStaticallyImportedTypes());
	}
	
	@Override
	public List<TypeBucket> getStaticallyImportedExtensionTypes() {
		if (staticallyImportedExtensions != null)
			return staticallyImportedExtensions;
		return staticallyImportedExtensions = concatTypeBuckets(extensionProviders, super.getStaticallyImportedExtensionTypes());
	}

	protected List<TypeBucket> concatTypeBuckets(List<? extends JvmType> types, List<TypeBucket> parentResult) {
		if (types.isEmpty()) {
			return parentResult;
		}
		List<TypeBucket> result = Lists.newArrayListWithCapacity(3);
		result.add(new TypeBucket(getId(), types, resolvedFeaturesProvider));
		result.addAll(parentResult);
		return result;
	}

}
