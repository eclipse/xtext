/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractStaticImportsScope extends AbstractSessionBasedScope {
	
	public AbstractStaticImportsScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall context) {
		super(parent, session, context);
	}
	
	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		List<TypeBucket> buckets = getBuckets();
		if (buckets.isEmpty()) {
			return Collections.emptyList();
		}
		List<IEObjectDescription> result = Lists.newArrayList();
		for(TypeBucket bucket: buckets) {
			for(JvmType type: bucket.getTypes()) {
				if (type instanceof JvmDeclaredType) {
					Iterable<JvmFeature> features = ((JvmDeclaredType) type).getAllFeatures();
					for(JvmFeature feature: features) {
						addDescriptions(feature, bucket, result);
					}
				}
			}
		}
		return result;
	}

	protected void addDescriptions(JvmFeature feature, TypeBucket bucket, List<IEObjectDescription> result) {
		result.add(new BucketedEObjectDescription(QualifiedName.create(feature.getSimpleName()), feature, bucket.getId()));
	}

	protected abstract List<TypeBucket> getBuckets();
	
	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		List<TypeBucket> buckets = getBuckets();
		if (buckets.isEmpty()) {
			return Collections.emptyList();
		}
		List<IEObjectDescription> result = Lists.newArrayList();
		String simpleName = getFeatureName(name);
		for(TypeBucket bucket: buckets) {
			for(JvmType type: bucket.getTypes()) {
				if (type instanceof JvmDeclaredType) {
					Iterable<JvmFeature> features = ((JvmDeclaredType) type).findAllFeaturesByName(simpleName);
					for(JvmFeature feature: features) {
						result.add(createNamedDescription(name, feature, bucket));
					}
				}
			}
		}
		// TODO cache the result in the session explicitly for the static types
		// especially interesting for cache misses
		return result;
	}

	protected BucketedEObjectDescription createNamedDescription(QualifiedName name, JvmFeature feature,
			TypeBucket bucket) {
		return new BucketedEObjectDescription(name, feature, bucket.getId());
	}
}
