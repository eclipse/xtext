/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ResolvedTypeLiteral extends AbstractResolvedReference<XAbstractFeatureCall> implements IFeatureLinkingCandidate {

	protected ResolvedTypeLiteral(XAbstractFeatureCall featureCall, JvmIdentifiableElement resolvedElement, ExpressionTypeComputationState state) {
		super(featureCall, resolvedElement, state);
		if (featureCall.isExplicitOperationCallOrBuilderSyntax()) {
			throw new IllegalArgumentException("Cannot be a type literal: " + String.valueOf(featureCall));
		}
	}

	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}

	public boolean isStatic() {
		return false;
	}

	public boolean isExtension() {
		return false;
	}

	public boolean isTypeLiteral() {
		return true;
	}
	
	public boolean isPackageFragment() {
		XAbstractFeatureCall featureCall = getFeatureCall();
		if (featureCall instanceof XFeatureCall)
			return ((XFeatureCall) featureCall).isPackageFragment();
		if (featureCall instanceof XMemberFeatureCall)
			return ((XMemberFeatureCall) featureCall).isPackageFragment();
		return false;
	}

	@Override
	protected List<XExpression> getArguments() {
		return Collections.emptyList();
	}

	@Override
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return this;
	}

	@Override
	protected List<LightweightTypeReference> getSyntacticTypeArguments() {
		return Collections.emptyList();
	}
	
	@Override
	public void applyToComputationState() {
		if (isPackageFragment()) {
			return;
		}
		super.applyToComputationState();
	}
	
	@Nullable
	protected ParameterizedTypeReference getRawTypeForName(Class<?> clazz, ITypeReferenceOwner owner) {
		JvmType clazzType = owner.getServices().getTypeReferences().findDeclaredType(clazz, owner.getContextResourceSet());
		if (clazzType == null) {
			return null;
		}
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, clazzType);
		return result;
	}
	
	@Override
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		if (feature instanceof JvmType) {
			ITypeReferenceOwner owner = getState().getReferenceOwner();
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

}
