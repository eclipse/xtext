/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractStaticImportsScope extends AbstractSessionBasedExecutableScope {

	public AbstractStaticImportsScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall context, OperatorMapping operatorMapping) {
		super(parent, session, context, operatorMapping);
	}

	@Override
	protected List<IEObjectDescription> getAllLocalElements() {
		List<TypeBucket> buckets = getBuckets();
		if (buckets.isEmpty()) {
			return Collections.emptyList();
		}
		List<IEObjectDescription> result = Lists.newArrayList();
		for (TypeBucket bucket : buckets) {
			getAllLocalElements(bucket, result);
		}
		return result;
	}

	protected void getAllLocalElements(TypeBucket bucket, List<IEObjectDescription> result) {
		if (bucket.isRestrictingNames()) {
			for (Map.Entry<? extends JvmType, ? extends Set<String>> entry : bucket.getTypesToNames().entrySet()) {
				JvmType type = entry.getKey();
				if (type instanceof JvmDeclaredType) {
					getAllLocalElements(bucket, (JvmDeclaredType) type, entry.getValue(), result);
				}
			}
		} else {
			for (JvmType type : bucket.getTypes()) {
				if (type instanceof JvmDeclaredType) {
					getAllLocalElements(bucket, (JvmDeclaredType) type, result);
				}
			}
		}
	}

	protected void getAllLocalElements(TypeBucket bucket, JvmDeclaredType type, List<IEObjectDescription> result) {
		Iterable<JvmFeature> features = type.getAllFeatures();
		for (JvmFeature feature : features) {
			if (feature.isStatic()) {
				addDescriptions(feature, bucket, result);
			}
		}
	}

	protected void getAllLocalElements(TypeBucket bucket, JvmDeclaredType type, Set<String> restrictedNames, List<IEObjectDescription> result) {
		Iterable<JvmFeature> features = type.getAllFeatures();
		for (JvmFeature feature : features) {
			if (feature.isStatic() && restrictedNames.contains(feature.getSimpleName())) {
				addDescriptions(feature, bucket, result);
			}
		}
	}
	
	protected void addDescriptions(JvmFeature feature, TypeBucket bucket, List<IEObjectDescription> result) {
		String simpleName = feature.getSimpleName();
		IEObjectDescription description = createDescription(QualifiedName.create(simpleName), feature, bucket);
		if (description != null) {
			addToList(description, result);
			String propertyName = toProperty(simpleName, feature);
			if (propertyName != null) {
				addToList(createDescription(QualifiedName.create(propertyName), feature, bucket), result);
			}
		}
	}

	protected abstract List<TypeBucket> getBuckets();

	@Override
	protected List<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
		final List<TypeBucket> buckets = getBuckets();
		if (buckets.isEmpty()) {
			return Collections.emptyList();
		}
		final List<IEObjectDescription> result = Lists.newArrayList();
		processFeatureNames(name, new NameAcceptor() {
			@Override
			public void accept(String simpleName, int order) {
				for (TypeBucket bucket : buckets) {
					if (bucket.isRestrictingNames()) {
						for (Map.Entry<? extends JvmType, ? extends Set<String>> entry : bucket.getTypesToNames().entrySet()) {
							if (entry.getValue().contains(simpleName)) {
								processType(entry.getKey(), simpleName, order, bucket);
							}
						}
					} else {
						for (JvmType type : bucket.getTypes()) {
							processType(type, simpleName, order, bucket);
						}
					}
				}
			}

			protected void processType(JvmType type, String simpleName, int order, TypeBucket bucket) {
				if (type instanceof JvmDeclaredType) {
					List<JvmFeature> features = findAllFeaturesByName(type, simpleName, bucket.getResolvedFeaturesProvider());
					for(int i = 0, size = features.size(); i < size; i++) {
						JvmFeature feature = features.get(i);
						if (feature.isStatic() && (order == 1 || feature instanceof JvmOperation)) {
							IIdentifiableElementDescription description = createDescription(name, feature, bucket);
							if (description != null)
								addToList(description, result);
						}
					}
				}
			}
		});

		// TODO cache the result in the session explicitly for the static types
		// especially interesting for cache misses
		return result;
	}

	protected abstract BucketedEObjectDescription createDescription(QualifiedName name, JvmFeature feature, TypeBucket bucket);
}
