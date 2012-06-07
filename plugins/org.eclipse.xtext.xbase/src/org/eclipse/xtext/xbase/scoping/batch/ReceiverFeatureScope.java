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
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReceiverFeatureScope extends AbstractSessionBasedScope {

	private final TypeBucket bucket;
	private final OperatorMapping operatorMapping;
	private final JvmTypeReference receiverType;
	private final XExpression receiver;

	protected ReceiverFeatureScope(IScope parent, IFeatureScopeSession session, XExpression receiver, JvmTypeReference receiverType, XAbstractFeatureCall featureCall, TypeBucket bucket, OperatorMapping operatorMapping) {
		super(parent, session, featureCall);
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.bucket = bucket;
		this.operatorMapping = operatorMapping;
	}
	
	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		Set<JvmIdentifiableElement> allFeatures = Sets.newLinkedHashSet();
		String simpleName = getFeatureName(name);
		for(JvmType type: bucket.getTypes()) {
			if (type instanceof JvmDeclaredType) {
				Iterable<JvmFeature> features = ((JvmDeclaredType) type).findAllFeaturesByName(simpleName);
				Iterables.addAll(allFeatures, features);
			}
		}
		if (allFeatures.isEmpty())
			return Collections.emptyList();
		List<IEObjectDescription> allDescriptions = Lists.newArrayListWithCapacity(allFeatures.size());
		Map<JvmTypeParameter, MergedBoundTypeArgument> receiverTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(receiverType);
		for(JvmIdentifiableElement feature: allFeatures) {
			allDescriptions.add(new BucketedEObjectDescription(name, feature, receiver, receiverType, receiverTypeParameterMapping, bucket.getId()));
		}
		return allDescriptions;
	}
	
	@Override
	protected String getFeatureName(QualifiedName name) {
		QualifiedName methodName = operatorMapping.getMethodName(name);
		String simpleName = methodName == null ? name.toString() : methodName.toString();
		return simpleName;
	}

	@Override
	protected Iterable<IEObjectDescription> getAllLocalElements() {
		Set<JvmIdentifiableElement> allFeatures = Sets.newLinkedHashSet();
		for(JvmType type: bucket.getTypes()) {
			if (type instanceof JvmDeclaredType) {
				Iterable<JvmFeature> features = ((JvmDeclaredType) type).getAllFeatures();
				Iterables.addAll(allFeatures, features);
			}
		}
		if (allFeatures.isEmpty())
			return Collections.emptyList();
		List<IEObjectDescription> allDescriptions = Lists.newArrayListWithCapacity(allFeatures.size());
		Map<JvmTypeParameter, MergedBoundTypeArgument> receiverTypeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(receiverType);
		for(JvmIdentifiableElement feature: allFeatures) {
			QualifiedName featureName = QualifiedName.create(feature.getSimpleName());
			allDescriptions.add(new BucketedEObjectDescription(featureName, feature, receiver, receiverType, receiverTypeParameterMapping, bucket.getId()));
			QualifiedName operator = operatorMapping.getOperator(featureName);
			if (operator != null) {
				allDescriptions.add(new BucketedEObjectDescription(operator, feature, receiver, receiverType, receiverTypeParameterMapping, bucket.getId()));
			}
		}
		return allDescriptions;
	}

}
