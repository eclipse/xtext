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

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResolvedTypeLiteral extends AbstractResolvedReference<XAbstractFeatureCall> implements ITypeLiteralLinkingCandidate {

	private TypeLiteralHelper helper;

	protected ResolvedTypeLiteral(
			XAbstractFeatureCall featureCall,
			JvmIdentifiableElement resolvedElement,
			ITypeExpectation expectation,
			ExpressionTypeComputationState state) {
		super(featureCall, resolvedElement, expectation, state);
		this.helper = new TypeLiteralHelper(state);
	}

	public XAbstractFeatureCall getFeatureCall() {
		return getExpression();
	}

	public boolean isStatic() {
		return getFeatureCall().isStatic();
	}
	
	public JvmType getType() {
		return (JvmType) getFeature();
	}

	public boolean isExtension() {
		return getFeatureCall().isExtension();
	}

	@Override
	public boolean isTypeLiteral() {
		return getFeatureCall().isTypeLiteral();
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
	public List<LightweightTypeReference> getTypeArguments() {
		return Collections.emptyList();
	}
	
	@Override
	protected List<JvmTypeParameter> getDeclaredTypeParameters() {
		return Collections.emptyList();
	}

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
	
	@Override
	protected void preApply() {
		helper.applyPackageFragment(getExpression(), getType());
	}
	
	@Override
	protected LightweightTypeReference getDeclaredType(JvmIdentifiableElement feature) {
		return helper.getAsClassLiteral(feature);
	}

}
