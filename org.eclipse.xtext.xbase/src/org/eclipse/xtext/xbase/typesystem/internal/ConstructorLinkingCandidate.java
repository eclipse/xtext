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
import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
import org.eclipse.xtext.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ConstructorLinkingCandidate extends AbstractPendingLinkingCandidate<XConstructorCall> implements IConstructorLinkingCandidate {

	public ConstructorLinkingCandidate(
			XConstructorCall constructorCall,
			IIdentifiableElementDescription description,
			ITypeExpectation expectation,
			ExpressionTypeComputationState state) {
		super(constructorCall, description, expectation, state);
	}

	@Override
	public JvmConstructor getConstructor() {
		return (JvmConstructor) getFeature();
	}
	
	@Override
	public XConstructorCall getConstructorCall() {
		return getExpression();
	}
	
	@Override
	protected ILinkingCandidate createAmbiguousLinkingCandidate(AbstractPendingLinkingCandidate<?> second) {
		return new AmbiguousConstructorLinkingCandidate(this, second);
	}

	@Override
	protected List<XExpression> getArguments() {
		return getConstructorCall().getArguments();
	}
	
	@Override
	protected int getConformanceFlags(int idx, boolean recompute) {
		if (idx == -1) {
			return ConformanceFlags.CHECKED_SUCCESS;
		}
		return super.getConformanceFlags(idx, recompute);
	}
	
	@Override
	protected LightweightTypeReference deferredBindTypeArgument(ITypeExpectation expectation, LightweightTypeReference type) {
		LightweightTypeReference result = super.deferredBindTypeArgument(expectation, type);
		LightweightTypeReference expectedType = expectation.getExpectedType();
		if (expectedType != null && getConstructorCall().getTypeArguments().isEmpty() && !result.isRawType() && !getDeclaredTypeParameters().isEmpty()) {
			if (!expectedType.isAssignableFrom(result, TypeConformanceComputationArgument.DEFAULT)) {
				LightweightTypeReference rawFeatureType = result.getRawTypeReference();
				if (expectedType.isAssignableFrom(rawFeatureType)) {
					result = rawFeatureType;
					getTypeParameterMapping().clear();
				}
			}
		}
		return result;
	}
	
	@Override
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		JvmDeclaredType declaringType = getConstructor().getDeclaringType();
		if (declaringType.isAbstract()) {
			String message = "Cannot instantiate the abstract type " + declaringType.getSimpleName();
			AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
					Severity.ERROR, 
					IssueCodes.ABSTRACT_CLASS_INSTANTIATION, 
					message, 
					getExpression(), 
					getDefaultValidationFeature(), -1, null);
			result.accept(diagnostic);
			return false;
		}
		return super.validate(result);
	}
	
	@Override
	protected boolean isBoundTypeArgumentSkipped(JvmTypeParameter type, Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping,
			ITypeReferenceOwner owner) {
		if (super.isBoundTypeArgumentSkipped(type, mapping, owner)) {
			if (getConstructor().getDeclaringType() != type.getDeclarator()) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	protected EReference getDefaultValidationFeature() {
		return XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR;
	}
	
	/* @Nullable */
	@Override
	protected EReference getInvalidArgumentsValidationFeature() {
		return null;
	}
	
	@Override
	protected String getFeatureTypeName() {
		return "constructor";
	}
	
	@Override
	protected String getSimpleFeatureName() {
		return getActualType(getFeature(), true).getHumanReadableName();
	}
	
	@Override
	public boolean isAnonymousClassConstructorCall() {
		return description.isAnonymousClassConstructorCall();
	}
	
	@Override
	protected List<JvmTypeReference> getPlainSyntacticTypeArguments() {
		return getConstructorCall().getTypeArguments();
	}
	
	@Override
	public void applyToModel(IResolvedTypes resolvedTypes) {
		resolveLinkingProxy(XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR, XbasePackage.XCONSTRUCTOR_CALL__CONSTRUCTOR);
		if (isAnonymousClassConstructorCall())
			getConstructorCall().setAnonymousClassConstructorCall(true);
	}
	
	@Override
	protected List<JvmTypeParameter> getDeclaredTypeParameters() {
		if (isAnonymousClassConstructorCall()) {
			JvmDeclaredType anonymousType = getConstructor().getDeclaringType();
			JvmTypeReference superType = Iterables.getLast(anonymousType.getSuperTypes());
			JvmType rawSuperType = superType.getType();
			if (rawSuperType instanceof JvmTypeParameterDeclarator) {
				return ((JvmTypeParameterDeclarator) rawSuperType).getTypeParameters();
			}
			return Collections.emptyList();
		}
		return new FeatureLinkHelper().getDeclaredTypeParameters(getConstructor());
	}
}
