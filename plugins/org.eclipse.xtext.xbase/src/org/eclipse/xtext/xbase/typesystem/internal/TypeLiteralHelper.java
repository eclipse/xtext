/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeLiteralHelper {
	
	private ExpressionTypeComputationState state;

	protected TypeLiteralHelper(ExpressionTypeComputationState state) {
		this.state = state;
	}

	/* @Nullable */
	protected ParameterizedTypeReference getRawTypeForName(Class<?> clazz, ITypeReferenceOwner owner) {
		JvmType clazzType = owner.getServices().getTypeReferences().findDeclaredType(clazz, owner.getContextResourceSet());
		if (clazzType == null) {
			return null;
		}
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, clazzType);
		return result;
	}
	
	protected LightweightTypeReference getAsClassLiteral(JvmIdentifiableElement feature) {
		if (feature instanceof JvmType) {
			ITypeReferenceOwner owner = state.getReferenceOwner();
			ParameterizedTypeReference result = getRawTypeForName(Class.class, owner);
			if (result == null) {
				return new UnknownTypeReference(owner, "Class");
			}
			LightweightTypeReference argumentType = new ParameterizedTypeReference(owner, (JvmType) feature);
			if (argumentType.isPrimitiveVoid()) {
				ParameterizedTypeReference voidType = getRawTypeForName(Void.class, owner);
				if (voidType == null) {
					argumentType = new UnknownTypeReference(owner, Void.class.getName());
				} else {
					argumentType = voidType;
				}
			} else {
				argumentType = argumentType.getWrapperTypeIfPrimitive();
			}
			result.addTypeArgument(argumentType);
			return result;
		}
		throw new IllegalArgumentException(String.valueOf(feature));
	}
	
	protected void applyPackageFragment(XAbstractFeatureCall expression, JvmType type) {
		if (expression instanceof XMemberFeatureCall) {
			if (type instanceof JvmDeclaredType) {
				JvmDeclaredType declaredType = (JvmDeclaredType) type;
				if (declaredType.getDeclaringType() == null) {
					applyPackageFragment((XMemberFeatureCall) expression, declaredType);
				}
			}
		}
	}

	protected void applyPackageFragment(XMemberFeatureCall memberFeatureCall, JvmDeclaredType type) {
		XExpression target = memberFeatureCall.getMemberCallTarget();
		state.getResolvedTypes().acceptType(target, new NoExpectation(state, false), new ParameterizedTypeReference(state.getReferenceOwner(), type), false,
				ConformanceHint.SUCCESS, ConformanceHint.CHECKED);
		if (target instanceof XMemberFeatureCall) {
			applyPackageFragment((XMemberFeatureCall) target, type);
		}
	}
	
}
