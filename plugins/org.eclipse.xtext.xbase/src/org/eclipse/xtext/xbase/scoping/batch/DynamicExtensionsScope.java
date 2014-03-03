/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import static com.google.common.collect.Iterables.*;

import java.beans.Introspector;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DynamicExtensionsScope extends AbstractSessionBasedExecutableScope {

	private final ExtensionScopeHelper helper;
	private final XExpression firstArgument;
	private final LightweightTypeReference argumentType;
	private final boolean implicit;
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> argumentTypeParameterMapping;

	public DynamicExtensionsScope(
			IScope parent,
			IFeatureScopeSession session, 
			XExpression firstArgument,
			LightweightTypeReference argumentType,
			boolean implicit,
			XAbstractFeatureCall context,
			OperatorMapping operatorMapping) {
		super(parent, session, context, operatorMapping);
		this.firstArgument = firstArgument;
		this.argumentType = argumentType;
		this.implicit = implicit;
		if (argumentType != null)
			this.helper = new ExtensionScopeHelper(argumentType);
		else
			this.helper = null;
	}
	
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getArgumentTypeParameterMapping() {
		if (argumentTypeParameterMapping == null) {
			argumentTypeParameterMapping = Collections.emptyMap();
			if (argumentType != null) {
				argumentTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(argumentType);
			}
		}
		return argumentTypeParameterMapping;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		List<ExpressionBucket> buckets = getBuckets();
		if (buckets.isEmpty()) {
			return Collections.emptyList();
		}
		List<IEObjectDescription> result = Lists.newArrayList();
		for (ExpressionBucket bucket : buckets) {
			Map<XExpression, LightweightTypeReference> extensionProviders = bucket.getExtensionProviders();
			for (Map.Entry<XExpression, LightweightTypeReference> extensionProvider : extensionProviders.entrySet()) {
				Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
				LightweightTypeReference extensionType = extensionProvider.getValue();
				List<JvmType> types = extensionType.getRawTypes();
				for (JvmType type : types) {
					if (type instanceof JvmDeclaredType) {
						IResolvedFeatures resolvedFeatures = bucket.getResolvedFeaturesProvider().getResolvedFeatures(type).getParameterizedView(extensionType);
						Iterable<JvmFeature> features = resolvedFeatures.getAllFeatures();
						Iterables.addAll(allFeatures, features);
					}
				}
				if (!allFeatures.isEmpty()) {
					Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(extensionType);
					for (JvmFeature feature : allFeatures) {
						if (!feature.isStatic()) {
							addDescriptions(feature, extensionProvider.getKey(), extensionType, receiverTypeParameterMapping, bucket, result);
						}
					}
				}
			}
		}
		return result;
	}

	protected void addDescriptions(JvmFeature feature, XExpression receiver, LightweightTypeReference receiverType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping, ExpressionBucket bucket, List<IEObjectDescription> result) {
		String simpleName = feature.getSimpleName();
		QualifiedName featureName = QualifiedName.create(simpleName);
		if (firstArgument != null && helper.isPossibleExtension(feature) && helper.isMatchingFirstParameter((JvmOperation) feature)) {
			IEObjectDescription description = doCreateExtensionDescription(featureName, feature, receiver, receiverType, receiverTypeParameterMapping, bucket);
			if (description != null) {
				result.add(description);
				String propertyName = toProperty(simpleName, feature);
				if (propertyName != null) {
					result.add(doCreateExtensionDescription(QualifiedName.create(propertyName), feature, receiver, receiverType, receiverTypeParameterMapping, bucket));
				}
			}
		}
		if (implicit) {
			IEObjectDescription description = createReceiverDescription(featureName, feature, receiver, receiverType, receiverTypeParameterMapping, bucket);
			if (description != null) {
				result.add(description);
				String propertyName = toProperty(simpleName, feature);
				if (propertyName != null) {
					result.add(createReceiverDescription(QualifiedName.create(propertyName), feature, receiver, receiverType, receiverTypeParameterMapping, bucket));
				}
			}
		}
		QualifiedName operator = getOperatorMapping().getOperator(featureName);
		if (operator != null) {
			if (firstArgument != null)
				result.add(doCreateExtensionDescription(operator, feature, receiver, receiverType, receiverTypeParameterMapping, bucket));
			if (implicit) {
				result.add(createReceiverDescription(operator, feature, receiver, receiverType, receiverTypeParameterMapping, bucket));
			}
		}
	}
	
	protected List<ExpressionBucket> getBuckets() {
		return getSession().getExtensionProviders();
	}
	
	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
		final List<ExpressionBucket> buckets = getBuckets();
		if (buckets.isEmpty()) {
			return Collections.emptyList();
		}
		final List<IEObjectDescription> result = Lists.newArrayList();
		
		for (final ExpressionBucket bucket : buckets) {
			Map<XExpression, LightweightTypeReference> extensionProviders = bucket.getExtensionProviders();
			for (Map.Entry<XExpression, LightweightTypeReference> extensionProvider : extensionProviders.entrySet()) {
				final LightweightTypeReference extensionType = extensionProvider.getValue();
				if (extensionType == null)
					throw new IllegalStateException("extensionType is null");
				final List<JvmType> types = extensionType.getRawTypes();
				final Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
				processFeatureNames(name, new NameAcceptor() {
					public void accept(String simpleName, int order) {
						for(JvmType type: types) {
							if (type instanceof JvmDeclaredType) {
								IResolvedFeatures resolvedFeatures = bucket.getResolvedFeaturesProvider().getResolvedFeatures(type).getParameterizedView(extensionType);
								Iterable<JvmFeature> features = resolvedFeatures.getAllFeatures(simpleName);
								Iterable<? extends JvmFeature> filtered = order==1 ? features : filter(features, JvmOperation.class);
								Iterables.addAll(allFeatures, filtered);
							}
						}
					}
				});
				if (!allFeatures.isEmpty()) {
					Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(extensionType);
					for(JvmFeature feature: allFeatures) {
						if (!feature.isStatic()) {
							if (firstArgument != null) {
								IIdentifiableElementDescription description = createExtensionDescription(name, feature, extensionProvider.getKey(), extensionType, receiverTypeParameterMapping, bucket);
								if (description != null)
									result.add(description);
							}
							if (implicit) {
								result.add(createReceiverDescription(name, feature, extensionProvider.getKey(), extensionType, receiverTypeParameterMapping, bucket));
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	protected BucketedEObjectDescription createExtensionDescription(QualifiedName name, JvmFeature feature, XExpression receiver, LightweightTypeReference receiverType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping, ExpressionBucket bucket) {
		if (helper == null || !helper.isPossibleExtension(feature)) {
			return null;
		}
		return doCreateExtensionDescription(name, feature, receiver, receiverType, receiverTypeParameterMapping, bucket);
	}

	protected BucketedEObjectDescription doCreateExtensionDescription(QualifiedName name, JvmFeature feature, XExpression receiver,
			LightweightTypeReference receiverType, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping,
			ExpressionBucket bucket) {
		if (implicit) {
			return new InstanceExtensionDescriptionWithImplicitFirstArgument(
					name,
					feature,
					receiver,
					receiverType,
					receiverTypeParameterMapping,
					EnumSet.of(ConformanceHint.SUCCESS, ConformanceHint.CHECKED),
					firstArgument,
					argumentType,
					getArgumentTypeParameterMapping(),
					bucket.getId(), 
					getSession().isVisible(feature));
		}
		return new InstanceExtensionDescription(
				name,
				feature,
				receiver,
				receiverType,
				receiverTypeParameterMapping,
				EnumSet.of(ConformanceHint.SUCCESS, ConformanceHint.CHECKED),
				firstArgument,
				argumentType,
				getArgumentTypeParameterMapping(),
				EnumSet.of(ConformanceHint.UNCHECKED),
				bucket.getId(),
				getSession().isVisible(feature));
	}
	
	protected BucketedEObjectDescription createReceiverDescription(QualifiedName name, JvmFeature feature, XExpression receiver,
			LightweightTypeReference receiverType, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping, ExpressionBucket bucket) {
		return new InstanceFeatureDescriptionWithImplicitReceiver(
				name,
				feature,
				receiver,
				receiverType, 
				receiverTypeParameterMapping,
				EnumSet.of(ConformanceHint.SUCCESS, ConformanceHint.CHECKED),
				bucket.getId(),
				getSession().isVisible(feature));
	}
	
	@Override
	protected String toProperty(String methodName, JvmFeature feature) {
		if (feature instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) feature;
			if (methodName.length() > 3 && (methodName.startsWith("get") && operation.getParameters().size() == 1 || methodName.startsWith("set") && operation.getParameters().size() == 2) && Character.isUpperCase(methodName.charAt(3))) {
				return Introspector.decapitalize(methodName.substring(3));
			}
			if (methodName.length() > 3 && methodName.startsWith("is") && Character.isUpperCase(methodName.charAt(2)) && operation.getParameters().size() == 1) {
				return Introspector.decapitalize(methodName.substring(2));
			}
		}
		return null;
	}
}
