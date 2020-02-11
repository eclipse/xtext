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
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A scope that contains static extension features, which are features that are contributed statically via an import.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticExtensionImportsScope extends AbstractStaticImportsScope {

	private final ExtensionScopeHelper helper;
	private final XExpression receiver;
	private final LightweightTypeReference receiverType;
	private final boolean implicit;

	public StaticExtensionImportsScope(IScope parent, IFeatureScopeSession session, 
			XExpression receiver, LightweightTypeReference receiverType, boolean implicit,
			XAbstractFeatureCall context, OperatorMapping operatorMapping) {
		super(parent, session, context, operatorMapping);
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.implicit = implicit;
		this.helper = new ExtensionScopeHelper(receiverType);
	}

	@Override
	protected List<TypeBucket> getBuckets() {
		return getSession().getStaticallyImportedExtensionTypes();
	}
	
	@Override
	protected List<IEObjectDescription> getAllLocalElements() {
		if (receiverType != null && !helper.isResolvedReceiverType()) {
			return Collections.emptyList();
		}
		return super.getAllLocalElements();
	}

	@Override
	protected void getAllLocalElements(TypeBucket bucket, JvmDeclaredType type, List<IEObjectDescription> result) {
		Iterable<JvmFeature> features = type.getAllFeatures();
		for(JvmFeature feature: features) {
			if (feature.isStatic() && helper.isPossibleExtension(feature) && helper.isMatchingFirstParameterDeepCheck((JvmOperation) feature)) {
				fastAddDescriptions(feature, bucket, result);
			}
		}
	}

	@Override
	protected void getAllLocalElements(TypeBucket bucket, JvmDeclaredType type, Set<String> restrictedNames, List<IEObjectDescription> result) {
		Iterable<JvmFeature> features = type.getAllFeatures();
		for(JvmFeature feature: features) {
			if (feature.isStatic() && restrictedNames.contains(feature.getSimpleName())
					&& helper.isPossibleExtension(feature) && helper.isMatchingFirstParameterDeepCheck((JvmOperation) feature)) {
				fastAddDescriptions(feature, bucket, result);
			}
		}
	}
	
	@Override
	protected BucketedEObjectDescription createDescription(QualifiedName name, JvmFeature feature,
			TypeBucket bucket) {
		if (!helper.isPossibleExtension(feature)) {
			return null;
		}
		if (!helper.isMatchingFirstParameter((JvmOperation) feature)) {
			return null;
		}
		return doCreateDescription(name, feature, bucket);
	}

	protected BucketedEObjectDescription doCreateDescription(QualifiedName name, JvmFeature feature, TypeBucket bucket) {
		if (implicit) {
			return new StaticExtensionFeatureDescriptionWithImplicitFirstArgument(name, feature, receiver, receiverType, bucket.getId(), getSession().isVisible(feature));
		}
		return new StaticExtensionFeatureDescription(name, feature, receiver, receiverType, bucket.getId(), getSession().isVisible(feature));
	}

	protected void fastAddDescriptions(JvmFeature feature, TypeBucket bucket, List<IEObjectDescription> result) {
		String simpleName = feature.getSimpleName();
		QualifiedName featureName = QualifiedName.create(simpleName);
		BucketedEObjectDescription description = doCreateDescription(featureName, feature, bucket);
		addToList(description, result);
		String propertyName = toProperty(simpleName, feature);
		if (propertyName != null) {
			addToList(doCreateDescription(QualifiedName.create(propertyName), feature, bucket), result);
		}
		if (!implicit) {
			QualifiedName operator = getOperatorMapping().getOperator(featureName);
			if (operator != null) {
				addToList(doCreateDescription(operator, feature, bucket), result);
			}
		}
	}
	
	@Override
	protected void addDescriptions(JvmFeature feature, TypeBucket bucket, List<IEObjectDescription> result) {
		String simpleName = feature.getSimpleName();
		QualifiedName featureName = QualifiedName.create(simpleName);
		BucketedEObjectDescription description = createDescription(featureName, feature, bucket);
		if (description != null) {
			addToList(description, result);
			String propertyName = toProperty(simpleName, feature);
			if (propertyName != null) {
				addToList(doCreateDescription(QualifiedName.create(propertyName), feature, bucket), result);
			}
			if (!implicit) {
				QualifiedName operator = getOperatorMapping().getOperator(featureName);
				if (operator != null) {
					addToList(doCreateDescription(operator, feature, bucket), result);
				}
			}
		}
	}
	
	@Override
	protected String toProperty(String methodName, JvmFeature feature) {
		return toProperty(methodName, feature, 1, 2);
	}
}
