/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IFeatureNames;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.computation.IFeatureLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeLiteralLinkingCandidate extends AbstractPendingLinkingCandidate<XAbstractFeatureCall> implements IFeatureLinkingCandidate, IFeatureNames {

	public TypeLiteralLinkingCandidate(XAbstractFeatureCall featureCall, IIdentifiableElementDescription description,
			ExpressionTypeComputationState state) {
		super(featureCall, description, state);
		if (featureCall.isExplicitOperationCallOrBuilderSyntax()) {
			throw new IllegalArgumentException(String.valueOf(featureCall));
		}
	}
	
	@Override
	protected IFeatureLinkingCandidate getThis() {
		return this;
	}

	/**
	 * Returns the actual arguments of the expression. These do not include the
	 * receiver.  
	 */
	@Override
	protected List<XExpression> getArguments() {
		return Collections.emptyList();
	}

	@Override
	protected String getFeatureTypeName() {
		return "type";
	}

	@Override
	public int getArityMismatch() {
		return 0;
	}
	
	@Override
	protected List<XExpression> getSyntacticArguments() {
		return Collections.emptyList();
	}
	
	@Override
	public boolean isExtension() {
		return false;
	}
	
	@Override
	protected boolean hasReceiver() {
		return false;
	}
	
	public boolean isStatic() {
		return false;
	}
	
	public boolean isTypeLiteral() {
		return true;
	}

	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}
	
	@Override
	protected List<LightweightTypeReference> getSyntacticTypeArguments() {
		return Collections.emptyList();
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
	
	@Override
	public void applyToComputationState() {
		super.applyToComputationState();
	}
	
	public void applyToModel() {
		resolveLinkingProxy(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, XbasePackage.XABSTRACT_FEATURE_CALL__FEATURE);
	}
	
	@Override
	protected void internalSetValue(InternalEObject featureCall, EReference structuralFeature, JvmIdentifiableElement newValue) {
		super.internalSetValue(featureCall, structuralFeature, newValue);
		if (featureCall instanceof XFeatureCall) {
			((XFeatureCall) featureCall).setTypeLiteral(true);
		} else if (featureCall instanceof XMemberFeatureCall) {
			((XMemberFeatureCall) featureCall).setTypeLiteral(true);
		}
	}

}
