/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping.batch;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFeature;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * A scope for the static features that are exposed by a type that was used, e.g.
 * {@code java.lang.String.valueOf(1)} where {@code valueOf(1)} is to be linked.
 * 
 * This scope includes qualified references to {@code this} and {@code super}. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class StaticFeatureOnTypeLiteralScope extends StaticFeatureScope implements IFeatureNames {

	public StaticFeatureOnTypeLiteralScope(IScope parent, IFeatureScopeSession session, XAbstractFeatureCall featureCall, XExpression receiver,
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
	protected List<IEObjectDescription> getLocalElementsByName(QualifiedName name) {
		if (THIS.equals(name)) {
			ITypeReferenceOwner owner = getReceiverType().getOwner();
			QualifiedThisOrSuperDescription description = new QualifiedThisOrSuperDescription(name, owner.newParameterizedTypeReference(getTypeLiteral()), getBucket().getId(), true, getReceiver());
			return Collections.<IEObjectDescription>singletonList(description);
		} else if (SUPER.equals(name)) {
			JvmType receiverRawType = getTypeLiteral();
			if (receiverRawType instanceof JvmDeclaredType) {
				ITypeReferenceOwner owner = getReceiverType().getOwner();
				JvmTypeReference superType = getExtendedClass((JvmDeclaredType) receiverRawType);
				JvmType referencedType;
				if (superType != null) {
					referencedType = superType.getType();
				} else {
					referencedType = receiverRawType;
				}
				QualifiedThisOrSuperDescription description = new QualifiedThisOrSuperDescription(name,
						owner.newParameterizedTypeReference(referencedType), getBucket().getId(), true, getReceiver());
				return Collections.<IEObjectDescription>singletonList(description);
			}
			return Collections.emptyList();
		}
		return super.getLocalElementsByName(name);
	}
	
	@Override
	protected List<IEObjectDescription> getAllLocalElements() {
		List<IEObjectDescription> result = super.getAllLocalElements();
		if (getSession().isInstanceContext() && !isExplicitStaticFeatureCall()) {
			ITypeReferenceOwner owner = getReceiverType().getOwner();
			QualifiedThisOrSuperDescription thisDescription = new QualifiedThisOrSuperDescription(THIS, owner.newParameterizedTypeReference(getTypeLiteral()), getBucket().getId(), true, getReceiver());
			addToList(thisDescription, result);
			JvmType receiverRawType = getTypeLiteral();
			if (receiverRawType instanceof JvmDeclaredType) {
				JvmTypeReference superType = getExtendedClass((JvmDeclaredType) receiverRawType);
				JvmType referencedType;
				if (superType != null) {
					referencedType = superType.getType();
				} else {
					referencedType = receiverRawType;					
				}
				QualifiedThisOrSuperDescription superDescription = new QualifiedThisOrSuperDescription(SUPER,
						owner.newParameterizedTypeReference(referencedType), getBucket().getId(), true, getReceiver());
				addToList(superDescription, result);
			}
		}
		return result;
	}
	
	private boolean isExplicitStaticFeatureCall() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) featureCall).isExplicitStatic();
		}
		return false;
	}

	/* @Nullable */
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

