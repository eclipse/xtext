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

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureScopeSessionWithDynamicExtensions extends AbstractNestedFeatureScopeSession {

	private final Map<XExpression, LightweightTypeReference> extensionProviders;
	private final IResolvedFeatures.Provider resolvedFeaturesProvider;

	public FeatureScopeSessionWithDynamicExtensions(AbstractFeatureScopeSession parent,
			Map<XExpression, LightweightTypeReference> extensionProviders,
			IResolvedFeatures.Provider resolvedFeaturesProvider) {
		super(parent);
		this.extensionProviders = extensionProviders;
		this.resolvedFeaturesProvider = resolvedFeaturesProvider;
	}
	
	@Override
	protected void addExtensionProviders(List<ExpressionBucket> result) {
		ExpressionBucket bucket = new ExpressionBucket(getId(), extensionProviders, resolvedFeaturesProvider);
		result.add(bucket);
		super.addExtensionProviders(result);
	}
	
	@Override
	public List<ExpressionBucket> getExtensionProviders() {
		List<ExpressionBucket> result = Lists.newArrayListWithCapacity(3);
		addExtensionProviders(result);
		return result;
	}

}
