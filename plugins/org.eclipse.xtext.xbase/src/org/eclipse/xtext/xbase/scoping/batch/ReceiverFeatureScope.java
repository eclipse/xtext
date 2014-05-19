/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import static com.google.common.collect.Iterables.*;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.override.IResolvedFeatures;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.IVisibilityHelper;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReceiverFeatureScope extends AbstractSessionBasedExecutableScope implements IVisibilityHelper {

	private final TypeBucket bucket;
	private final LightweightTypeReference receiverType;
	private final XExpression receiver;
	private final boolean implicit;
	private final JvmIdentifiableElement receiverFeature;
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> receiverTypeParameterMapping;

	protected ReceiverFeatureScope(IScope parent, IFeatureScopeSession session, XExpression receiver, LightweightTypeReference receiverType, boolean implicit,
			XAbstractFeatureCall featureCall, TypeBucket bucket, JvmIdentifiableElement receiverFeature, OperatorMapping operatorMapping) {
		super(parent, session, featureCall, operatorMapping);
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.implicit = implicit;
		this.bucket = bucket;
		this.receiverFeature = receiverFeature;
	}
	
	public boolean isVisible(@NonNull JvmMember member) {
		return getSession().isVisible(member, receiverType, receiverFeature);
	}
	
	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		final Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
		processFeatureNames(name, new NameAcceptor() {
			public void accept(String simpleName, int order) {
				for(JvmType type: bucket.getTypes()) {
					if (type instanceof JvmDeclaredType) {
						Iterable<JvmFeature> features = findAllFeaturesByName(type, simpleName, bucket.getResolvedFeaturesProvider());
						Iterable<? extends JvmFeature> filtered = order==1 ? features : filter(features, JvmOperation.class);
						Iterables.addAll(allFeatures, filtered);
					}
				}
			}
		});
		if (allFeatures.isEmpty())
			return Collections.emptyList();
		List<IEObjectDescription> allDescriptions = Lists.newArrayListWithCapacity(allFeatures.size());
		for(JvmFeature feature: allFeatures) {
			if (!feature.isStatic())
				allDescriptions.add(createDescription(name, feature, bucket));
		}
		return allDescriptions;
	}
	
	@Override
	protected Iterable<JvmFeature> findAllFeaturesByName(JvmType type, String simpleName, IResolvedFeatures.Provider resolvedFeaturesProvider) {
		IResolvedFeatures resolvedFeatures = resolvedFeaturesProvider.getResolvedFeatures(type).getParameterizedView(receiverType);
		return resolvedFeatures.getAllFeatures(simpleName);
	}

	protected IEObjectDescription createDescription(QualifiedName name, JvmFeature feature, TypeBucket bucket) {
		EnumSet<ConformanceHint> conformanceHints = bucket.getHints();
		if (implicit) {
			return new InstanceFeatureDescriptionWithImplicitReceiver(name, feature, receiver, receiverType, getReceiverTypeParameterMapping(), conformanceHints, bucket.getId(), isVisible(feature));
		} else {
			return new InstanceFeatureDescription(name, feature, receiver, receiverType, getReceiverTypeParameterMapping(), conformanceHints, bucket.getId(), isVisible(feature));
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
	protected Iterable<IEObjectDescription> getAllLocalElements() {
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
			if (!feature.isStatic() && !(implicit && getFeatureCall() instanceof XMemberFeatureCall)) {
				String simpleName = feature.getSimpleName();
				QualifiedName featureName = QualifiedName.create(simpleName);
				allDescriptions.add(createDescription(featureName, feature, bucket));
				QualifiedName operator = getOperatorMapping().getOperator(featureName);
				if (operator != null) {
					allDescriptions.add(createDescription(operator, feature, bucket));
					QualifiedName compoundOperator = getOperatorMapping().getCompoundOperator(operator);
					if (compoundOperator != null) {
						allDescriptions.add(createDescription(compoundOperator, feature, bucket));	
					}
				}
				String propertyName = toProperty(simpleName, feature);
				if (propertyName != null) {
					allDescriptions.add(createDescription(QualifiedName.create(propertyName), feature, bucket));	
				}
			}
		}
		return allDescriptions;
	}

}
