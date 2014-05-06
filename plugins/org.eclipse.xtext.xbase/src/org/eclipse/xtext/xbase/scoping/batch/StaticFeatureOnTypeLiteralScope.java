/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticFeatureOnTypeLiteralScope extends StaticFeatureScope implements IFeatureNames {

	@NonNullByDefault
	protected StaticFeatureOnTypeLiteralScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall, XExpression receiver,
			LightweightTypeReference receiverType, TypeBucket bucket, OperatorMapping operatorMapping) {
		super(parent, session, featureCall, receiver, receiverType, bucket, operatorMapping);
		if (bucket.getTypes().size() != 1) {
			throw new IllegalArgumentException("Unexpected bucket structure");
		}
	}

	@Override
	protected IEObjectDescription createDescription(QualifiedName name, JvmFeature feature, TypeBucket bucket) {
		return new StaticFeatureDescriptionWithTypeLiteralReceiver(name, feature, getReceiver(), getReceiverType(), bucket.getId(), getSession().isVisible(feature));
	}
	
	@Override
	protected Collection<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		if (THIS.equals(name)) {
			return Collections.singletonList(EObjectDescription.create(name, getTypeLiteral()));
		} else if (SUPER.equals(name)) {
			JvmType receiverRawType = getTypeLiteral();
			if (receiverRawType instanceof JvmDeclaredType) {
				JvmTypeReference superType = getExtendedClass((JvmDeclaredType) receiverRawType);
				if (superType != null)
					return Collections.singletonList(EObjectDescription.create(name, superType.getType()));
			}
			return Collections.emptyList();
		}
		return super.getLocalElementsByName(name);
	}
	
	@Nullable
	protected JvmTypeReference getExtendedClass(JvmDeclaredType type) {
		// TODO move JvmGenericType.getExtendedClass to JvmDeclaredType
		for(JvmTypeReference candidate: type.getSuperTypes()) {
			if (candidate.getType() instanceof JvmGenericType && !((JvmGenericType) candidate.getType()).isInterface())
				return candidate;
		}
		return null;
	}
	
	protected JvmType getTypeLiteral() {
		return getBucket().getTypes().get(0);
	}
}

