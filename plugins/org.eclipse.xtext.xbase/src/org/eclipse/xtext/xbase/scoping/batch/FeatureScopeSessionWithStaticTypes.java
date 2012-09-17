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

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureScopeSessionWithStaticTypes extends AbstractNestedFeatureScopeSession {

	private final List<JvmType> staticFeatureProviders;
	private final List<JvmType> extensionProviders;

	public FeatureScopeSessionWithStaticTypes(AbstractFeatureScopeSession featureScopeSession,
			List<JvmType> staticFeatureProviders,
			List<JvmType> extensionProviders) {
		super(featureScopeSession);
		this.staticFeatureProviders = staticFeatureProviders;
		this.extensionProviders = extensionProviders;
	}
	
	@Override
	public List<TypeBucket> getStaticallyImportedTypes() {
		return concatTypeBuckets(staticFeatureProviders, super.getStaticallyImportedTypes());
	}
	
	@Override
	public List<TypeBucket> getStaticallyImportedExtensionTypes() {
		return concatTypeBuckets(extensionProviders, super.getStaticallyImportedExtensionTypes());
	}

	protected List<TypeBucket> concatTypeBuckets(List<JvmType> types, List<TypeBucket> parentResult) {
		if (types.isEmpty()) {
			return parentResult;
		}
		List<TypeBucket> result = Lists.newArrayListWithCapacity(3);
		result.add(new TypeBucket(getId(), types));
		result.addAll(parentResult);
		return result;
	}

}
