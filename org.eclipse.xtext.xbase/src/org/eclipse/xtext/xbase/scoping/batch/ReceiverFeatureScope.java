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
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A scope that returns the features of a given receiver type.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReceiverFeatureScope extends AbstractStaticOrInstanceFeatureScope implements IVisibilityHelper {

	private final TypeBucket bucket;
	private final LightweightTypeReference receiverType;
	private final XExpression receiver;
	private final boolean implicit;
	private final JvmIdentifiableElement receiverFeature;
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping;
	private final boolean validStaticState;

	public ReceiverFeatureScope(IScope parent, IFeatureScopeSession session, XExpression receiver, LightweightTypeReference receiverType, boolean implicit,
			XAbstractFeatureCall featureCall, TypeBucket bucket, JvmIdentifiableElement receiverFeature, OperatorMapping operatorMapping, boolean validStaticState) {
		super(parent, session, featureCall, operatorMapping);
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.implicit = implicit;
		this.bucket = bucket;
		this.receiverFeature = receiverFeature;
		this.validStaticState = validStaticState;
	}
	
	@Override
	public boolean isVisible(/* @NonNull */ JvmMember member) {
		return getSession().isVisible(member, receiverType, receiverFeature);
	}
	
	@Override
	protected List<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		final Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
		processFeatureNames(name, new NameAcceptor() {
			@Override
			public void accept(String simpleName, int order) {
				for(JvmType type: bucket.getTypes()) {
					if (type instanceof JvmDeclaredType) {
						List<JvmFeature> features = findAllFeaturesByName(type, simpleName, bucket.getResolvedFeaturesProvider());
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
		if (allFeatures.isEmpty())
			return Collections.emptyList();
		List<IEObjectDescription> allDescriptions = Lists.newArrayListWithCapacity(allFeatures.size());
		for(JvmFeature feature: allFeatures) {
			if (!feature.isStatic()) {
				addDescription(name, feature, allDescriptions);
			}
		}
		return allDescriptions;
	}
	
	@Override
	protected List<JvmFeature> findAllFeaturesByName(JvmType type, String simpleName, IResolvedFeatures.Provider resolvedFeaturesProvider) {
		IResolvedFeatures resolvedFeatures = resolvedFeaturesProvider.getResolvedFeatures(type).getParameterizedView(receiverType);
		return resolvedFeatures.getAllFeatures(simpleName);
	}

	protected IEObjectDescription createDescription(QualifiedName name, JvmFeature feature, TypeBucket bucket) {
		if (implicit) {
			return new InstanceFeatureDescriptionWithImplicitReceiver(name, feature, receiver, receiverType, getReceiverTypeParameterMapping(), bucket.getFlags(), bucket.getId(), isVisible(feature), validStaticState);
		} else {
			return new InstanceFeatureDescription(name, feature, receiver, receiverType, getReceiverTypeParameterMapping(), bucket.getFlags(), bucket.getId(), isVisible(feature));
		}
	}

	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getReceiverTypeParameterMapping() {
		if (receiverTypeParameterMapping == null) {
			receiverTypeParameterMapping = Collections.emptyMap();
			if (receiverType != null) {
				receiverTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(receiverType);
			}
		}
		return receiverTypeParameterMapping;
	}

	@Override
	protected List<IEObjectDescription> getAllLocalElements() {
		Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
		for(JvmType type: bucket.getTypes()) {
			if (type instanceof JvmDeclaredType) {
				IResolvedFeatures resolvedFeatures = bucket.getResolvedFeaturesProvider().getResolvedFeatures(type);
				allFeatures.addAll(resolvedFeatures.getAllFeatures());
			}
		}
		if (allFeatures.isEmpty())
			return Collections.emptyList();
		List<IEObjectDescription> allDescriptions = Lists.newArrayListWithCapacity(allFeatures.size());
		for(JvmFeature feature: allFeatures) {
			if (!feature.isStatic()) {
				addDescriptions(feature, allDescriptions);
			}
		}
		return allDescriptions;
	}

	@Override
	protected void addDescription(QualifiedName name, JvmFeature feature, List<IEObjectDescription> result) {
		addToList(createDescription(name, feature, bucket), result);
	}

}
