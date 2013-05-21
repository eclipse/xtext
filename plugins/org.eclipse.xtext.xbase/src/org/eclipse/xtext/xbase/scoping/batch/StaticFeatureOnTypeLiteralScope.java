/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import org.eclipse.jdt.annotation.NonNullByDefault;
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
public class StaticFeatureOnTypeLiteralScope extends StaticFeatureScope {

	@NonNullByDefault
	protected StaticFeatureOnTypeLiteralScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall, XExpression receiver,
			LightweightTypeReference receiverType, TypeBucket bucket, OperatorMapping operatorMapping) {
		super(parent, session, featureCall, receiver, receiverType, bucket, operatorMapping);
	}

	@Override
	protected IEObjectDescription createDescription(QualifiedName name, JvmFeature feature, TypeBucket bucket) {
		return new StaticFeatureDescriptionWithTypeLiteralReceiver(name, feature, getReceiver(), getReceiverType(), bucket.getId(), getSession().isVisible(feature));
	}
}

