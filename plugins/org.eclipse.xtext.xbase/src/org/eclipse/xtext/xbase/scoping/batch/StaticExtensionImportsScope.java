/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.List;

import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticExtensionImportsScope extends AbstractStaticImportsScope {

	private final OperatorMapping operatorMapping;
	private final XExpression receiver;
	private final LightweightTypeReference receiverType;

	public StaticExtensionImportsScope(IScope parent, IFeatureScopeSession session, XExpression receiver, LightweightTypeReference receiverType, XAbstractFeatureCall context, OperatorMapping operatorMapping) {
		super(parent, session, context);
		this.receiver = receiver;
		this.receiverType = receiverType;
		this.operatorMapping = operatorMapping;
	}

	@Override
	protected List<TypeBucket> getBuckets() {
		return getSession().getStaticallyImportedExtensionTypes();
	}
	
	@Override
	protected String getFeatureName(QualifiedName name) {
		QualifiedName methodName = operatorMapping.getMethodName(name);
		String simpleName = methodName == null ? name.toString() : methodName.toString();
		return simpleName;
	}
	
	@Override
	protected BucketedEObjectDescription createNamedDescription(QualifiedName name, JvmFeature feature,
			TypeBucket bucket) {
		return new BucketedEObjectDescription(name, feature, receiver, receiverType, bucket.getId());
	}
	
	@Override
	protected void addDescriptions(JvmFeature feature, TypeBucket bucket, List<IEObjectDescription> result) {
		QualifiedName featureName = QualifiedName.create(feature.getSimpleName());
		result.add(new BucketedEObjectDescription(featureName, feature, receiver, receiverType, bucket.getId()));
		QualifiedName operator = operatorMapping.getOperator(featureName);
		if (operator != null) {
			result.add(new BucketedEObjectDescription(operator, feature, receiver, receiverType, bucket.getId()));
		}
	}
}
