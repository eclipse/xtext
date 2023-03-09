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
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A scope that contains dynamic extension features, which are features that are contributed by an instance of a type.
 * 
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
	protected List<IEObjectDescription> getAllLocalElements() {
		List<ExpressionBucket> buckets = getBuckets();
		if (buckets.isEmpty()) {
			return Collections.emptyList();
		}
		List<IEObjectDescription> result = Lists.newArrayList();
		for (ExpressionBucket bucket : buckets) {
			getAllLocalElements(bucket, result);
		}
		return result;
	}

	protected void getAllLocalElements(ExpressionBucket bucket, List<IEObjectDescription> result) {
		Map<XExpression, LightweightTypeReference> extensionProviders = bucket.getExtensionProviders();
		for (Map.Entry<XExpression, LightweightTypeReference> extensionProvider : extensionProviders.entrySet()) {
			LightweightTypeReference extensionType = extensionProvider.getValue();
			Set<JvmFeature> allFeatures = getAllFeatures(extensionType, bucket.getResolvedFeaturesProvider());
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

	protected Set<JvmFeature> getAllFeatures(LightweightTypeReference extensionType, IResolvedFeatures.Provider resolvedFeaturesProvider) {
		Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
		List<JvmType> types = extensionType.getRawTypes();
		for (JvmType type : types) {
			if (type instanceof JvmDeclaredType) {
				IResolvedFeatures resolvedFeatures = resolvedFeaturesProvider.getResolvedFeatures(type).getParameterizedView(extensionType);
				List<JvmFeature> features = resolvedFeatures.getAllFeatures();
				allFeatures.addAll(features);
			}
		}
		return allFeatures;
	}

	protected void addDescriptions(JvmFeature feature, XExpression receiver, LightweightTypeReference receiverType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping, ExpressionBucket bucket, List<IEObjectDescription> result) {
		String simpleName = feature.getSimpleName();
		QualifiedName featureName = QualifiedName.create(simpleName);
		boolean validStaticState = isValidStaticState(receiver);
		if (firstArgument != null && helper.isPossibleExtension(feature) && helper.isMatchingFirstParameterDeepCheck((JvmOperation) feature)) {
			IEObjectDescription description = doCreateExtensionDescription(featureName, feature, receiver, receiverType, receiverTypeParameterMapping, bucket, validStaticState);
			if (description != null) {
				addToList(description, result);
				String propertyName = toProperty(simpleName, feature);
				if (propertyName != null) {
					addToList(doCreateExtensionDescription(QualifiedName.create(propertyName), feature, receiver, receiverType, receiverTypeParameterMapping, bucket, validStaticState), result);
				}
			}
		}
		if (implicit) {
			IEObjectDescription description = createReceiverDescription(featureName, feature, receiver, receiverType, receiverTypeParameterMapping, bucket, validStaticState);
			if (description != null) {
				addToList(description, result);
				String propertyName = super.toProperty(simpleName, feature);
				if (propertyName != null) {
					addToList(createReceiverDescription(QualifiedName.create(propertyName), feature, receiver, receiverType, receiverTypeParameterMapping, bucket, validStaticState), result);
				}
			}
		}
		QualifiedName operator = getOperatorMapping().getOperator(featureName);
		if (operator != null) {
			if (firstArgument != null)
				addToList(doCreateExtensionDescription(operator, feature, receiver, receiverType, receiverTypeParameterMapping, bucket, validStaticState), result);
			if (implicit) {
				addToList(createReceiverDescription(operator, feature, receiver, receiverType, receiverTypeParameterMapping, bucket, validStaticState), result);
			}
		}
	}

	protected List<ExpressionBucket> getBuckets() {
		return getSession().getExtensionProviders();
	}
	
	@Override
	protected List<IEObjectDescription> getLocalElementsByName(final QualifiedName name) {
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
					@Override
					public void accept(String simpleName, int order) {
						for(JvmType type: types) {
							if (type instanceof JvmDeclaredType) {
								IResolvedFeatures resolvedFeatures = bucket.getResolvedFeaturesProvider().getResolvedFeatures(type).getParameterizedView(extensionType);
								List<JvmFeature> features = resolvedFeatures.getAllFeatures(simpleName);
								if (order == 1) {
									allFeatures.addAll(features);
								} else {
									for(int i = 0, size = features.size(); i < size; i++) {
										JvmFeature feature = features.get(i);
										if (feature.eClass() == TypesPackage.Literals.JVM_OPERATION) {
											allFeatures.add(feature);
										}
									}
								}
							}
						}
					}
				});
				if (!allFeatures.isEmpty()) {
					Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(extensionType);
					for(JvmFeature feature: allFeatures) {
						if (!feature.isStatic()) {
							XExpression receiver = extensionProvider.getKey();
							boolean validStaticState = isValidStaticState(receiver);
							if (firstArgument != null) {
								IIdentifiableElementDescription description = createExtensionDescription(name, feature, receiver, extensionType, receiverTypeParameterMapping, bucket, validStaticState);
								if (description != null)
									addToList(description, result);
							}
							if (implicit) {
								addToList(createReceiverDescription(name, feature, receiver, extensionType, receiverTypeParameterMapping, bucket, validStaticState), result);
							}
						}
					}
				}
			}
		}
		return result;
	}

	protected boolean isValidStaticState(XExpression receiver) {
		boolean validStaticState = true;
		if (receiver instanceof XMemberFeatureCall) {
			XExpression thisReference = ((XMemberFeatureCall) receiver).getMemberCallTarget();
			if (thisReference instanceof XFeatureCall && ((XFeatureCall) thisReference).getFeature() instanceof JvmType) {
				validStaticState = getSession().isInstanceContext();
			}
		}
		return validStaticState;
	}
	
	protected BucketedEObjectDescription createExtensionDescription(QualifiedName name, JvmFeature feature, XExpression receiver, LightweightTypeReference receiverType,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping, ExpressionBucket bucket, boolean validStaticState) {
		if (helper == null || !helper.isPossibleExtension(feature)) {
			return null;
		}
		return doCreateExtensionDescription(name, feature, receiver, receiverType, receiverTypeParameterMapping, bucket, validStaticState);
	}

	protected BucketedEObjectDescription doCreateExtensionDescription(QualifiedName name, JvmFeature feature, XExpression receiver,
			LightweightTypeReference receiverType, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping,
			ExpressionBucket bucket, boolean validStaticState) {
		if (implicit) {
			return new InstanceExtensionDescriptionWithImplicitFirstArgument(
					name,
					feature,
					receiver,
					receiverType,
					receiverTypeParameterMapping,
					ConformanceFlags.CHECKED_SUCCESS,
					firstArgument,
					argumentType,
					getArgumentTypeParameterMapping(),
					bucket.getId(), 
					getSession().isVisible(feature),
					validStaticState);
		}
		return new InstanceExtensionDescription(
				name,
				feature,
				receiver,
				receiverType,
				receiverTypeParameterMapping,
				ConformanceFlags.CHECKED_SUCCESS,
				firstArgument,
				argumentType,
				getArgumentTypeParameterMapping(),
				ConformanceFlags.UNCHECKED,
				bucket.getId(),
				getSession().isVisible(feature),
				validStaticState);
	}
	
	protected BucketedEObjectDescription createReceiverDescription(QualifiedName name, JvmFeature feature, XExpression receiver,
			LightweightTypeReference receiverType, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping, ExpressionBucket bucket, boolean validStaticState) {
		return new InstanceFeatureDescriptionWithImplicitReceiver(
				name,
				feature,
				receiver,
				receiverType, 
				receiverTypeParameterMapping,
				ConformanceFlags.CHECKED_SUCCESS,
				bucket.getId(),
				getSession().isVisible(feature),
				validStaticState);
	}
	
	@Override
	protected String toProperty(String methodName, JvmFeature feature) {
		return toProperty(methodName, feature, 1, 2);
	}
}
