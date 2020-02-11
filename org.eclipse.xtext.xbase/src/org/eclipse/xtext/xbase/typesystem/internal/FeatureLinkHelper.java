/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XPostfixOperation;
import org.eclipse.xtext.xbase.XUnaryOperation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureLinkHelper {
	
	/* @Nullable */
	public XExpression getSyntacticReceiver(XExpression expression) {
		if (expression instanceof XAbstractFeatureCall) {
			if (expression instanceof XFeatureCall) {
				return null;
			}
			if (expression instanceof XMemberFeatureCall) {
				return ((XMemberFeatureCall) expression).getMemberCallTarget();
			}
			if (expression instanceof XAssignment) {
				return ((XAssignment) expression).getAssignable();
			}
			if (expression instanceof XBinaryOperation) {
				return ((XBinaryOperation) expression).getLeftOperand();
			}
			if (expression instanceof XUnaryOperation) {
				return ((XUnaryOperation) expression).getOperand();
			}
			if (expression instanceof XPostfixOperation) {
				return ((XPostfixOperation) expression).getOperand();
			}
		}
		return null;
	}

	public List<XExpression> getSyntacticArguments(XAbstractFeatureCall expression) {
		if (expression instanceof XFeatureCall) {
			return ((XFeatureCall) expression).getFeatureCallArguments();
		}
		if (expression instanceof XMemberFeatureCall) {
			return ((XMemberFeatureCall) expression).getMemberCallArguments();
		}
		if (expression instanceof XAssignment) {
			return Collections.singletonList(((XAssignment) expression).getValue());
		}
		if (expression instanceof XBinaryOperation) {
			return Collections.singletonList(((XBinaryOperation) expression).getRightOperand());
		}
		// explicit condition to make sure we thought about it
		if (expression instanceof XUnaryOperation) {
			return Collections.emptyList();
		}
		if (expression instanceof XPostfixOperation) {
			return Collections.emptyList();
		}
		return Collections.emptyList();
	}
	
	public List<JvmTypeParameter> getDeclaredTypeParameters(JvmConstructor constructor) {
		List<JvmTypeParameter> constructorTypeParameters = constructor.getTypeParameters();
		if (constructorTypeParameters.isEmpty()) {
			JvmDeclaredType createdType = constructor.getDeclaringType();
			if (createdType instanceof JvmTypeParameterDeclarator) {
				return ((JvmTypeParameterDeclarator) createdType).getTypeParameters();
			}
		} else {
			JvmDeclaredType createdType = constructor.getDeclaringType();
			if (createdType instanceof JvmTypeParameterDeclarator) {
				List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) createdType).getTypeParameters();
				if (typeParameters.isEmpty()) {
					return constructorTypeParameters;
				}
				List<JvmTypeParameter> result = Lists.newArrayList(constructorTypeParameters);
				result.addAll(typeParameters);
				return result;
			}
			return constructorTypeParameters;
		}
		return Collections.emptyList();
	}
	
	/* @Nullable */
	public LightweightTypeReference getExpectedReceiverType(JvmIdentifiableElement linkedFeature, LightweightTypeReference receiverType) {
		if (receiverType.isMultiType() && linkedFeature instanceof JvmMember) {
			LightweightTypeReference declaratorReference = receiverType.getOwner().newParameterizedTypeReference(((JvmMember) linkedFeature).getDeclaringType());
			if (!declaratorReference.isAssignableFrom(receiverType.toJavaType())) {
				for(LightweightTypeReference multiTypeComponent: receiverType.getMultiTypeComponents()) {
					if (declaratorReference.isAssignableFrom(multiTypeComponent)) {
						return multiTypeComponent;
					}
				}
			} else {
				return declaratorReference;
			}
		} else if (receiverType.isSynonym() && linkedFeature instanceof JvmMember) {
			List<LightweightTypeReference> components = receiverType.getMultiTypeComponents();
			return components.get(components.size() - 1);
		}
		return receiverType;
	}
	
}
