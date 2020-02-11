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
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * A scope that contains static features. The features may be obtained implicitly from a given type ({@code receiver} is
 * {@code null}), or the features may be obtained from an instance which would render them invalidly accessed.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticFeatureScope extends AbstractStaticOrInstanceFeatureScope {

	private final TypeBucket bucket;
	private final XExpression receiver;
	private final LightweightTypeReference receiverType;

	public StaticFeatureScope(
			IScope parent,
			IFeatureScopeSession session,
			XAbstractFeatureCall featureCall,
			XExpression receiver,
			LightweightTypeReference receiverType,
			TypeBucket bucket,
			OperatorMapping operatorMapping) {
		super(parent, session, featureCall, operatorMapping);
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.bucket = bucket;
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
			addDescription(name, feature, allDescriptions);
		}
		return allDescriptions;
	}

	@Override
	protected void addDescription(QualifiedName name, JvmFeature feature, List<IEObjectDescription> result) {
		if (feature.isStatic()) {
			addToList(createDescription(name, feature, bucket), result);
		} else if (receiver == null && receiverType == null) {
			addToList(createInstanceDescription(name, feature, bucket), result);
		}
	}
	
	protected IEObjectDescription createDescription(QualifiedName name, JvmFeature feature, TypeBucket bucket) {
		if (receiver != null) {
			return new StaticFeatureDescriptionWithSyntacticReceiver(name, feature, receiver, receiverType, bucket.getId(), getSession().isVisible(feature));
		}
		if (receiverType != null) {
			return new StaticFeatureDescriptionWithImplicitReceiver(name, feature, receiverType, bucket.getId(), getSession().isVisible(feature));
		}
		return new StaticFeatureDescription(name, feature, bucket.getId(), getSession().isVisible(feature));
	}
	
	protected IEObjectDescription createInstanceDescription(QualifiedName name, JvmFeature feature, TypeBucket bucket) {
		return new InstanceFeatureDescriptionWithoutReceiver(name, feature, bucket.getId(), getSession().isVisible(feature));
	}

	@Override
	protected List<IEObjectDescription> getAllLocalElements() {
		Set<JvmFeature> allFeatures = Sets.newLinkedHashSet();
		for(JvmType type: bucket.getTypes()) {
			if (type instanceof JvmDeclaredType) {
				Iterable<JvmFeature> features = ((JvmDeclaredType) type).getAllFeatures();
				Iterables.addAll(allFeatures, features);
			}
		}
		if (allFeatures.isEmpty())
			return Collections.emptyList();
		List<IEObjectDescription> allDescriptions = Lists.newArrayListWithCapacity(allFeatures.size());
		for(JvmFeature feature: allFeatures) {
			if (feature.isStatic() || (receiver == null && receiverType == null)) {
				addDescriptions(feature, allDescriptions);
			}
		}
		return allDescriptions;
	}
	
	protected LightweightTypeReference getReceiverType() {
		return receiverType;
	}
	
	protected XExpression getReceiver() {
		return receiver;
	}
	
	protected TypeBucket getBucket() {
		return bucket;
	}

}
