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

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class FeatureScopeSessionWithDynamicExtensions extends AbstractNestedFeatureScopeSession {

	private final Map<XExpression, LightweightTypeReference> extensionProviders;

	public FeatureScopeSessionWithDynamicExtensions(AbstractFeatureScopeSession parent,
			Map<XExpression, LightweightTypeReference> extensionProviders) {
		super(parent);
		this.extensionProviders = extensionProviders;
	}
	
	@Override
	protected void addExtensionProviders(List<ExpressionBucket> result) {
		ExpressionBucket bucket = new ExpressionBucket(getId(), extensionProviders);
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
