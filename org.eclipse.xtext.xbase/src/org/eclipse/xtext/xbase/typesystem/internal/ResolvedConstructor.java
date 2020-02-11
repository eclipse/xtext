/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResolvedConstructor extends AbstractResolvedReference<XConstructorCall> implements IConstructorLinkingCandidate {

	public ResolvedConstructor(
			XConstructorCall constructorCall,
			JvmConstructor constructor,
			ITypeExpectation expectation, 
			ExpressionTypeComputationState state) {
		super(constructorCall, constructor, expectation, state);
	}
	
	@Override
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return this;
	}
	
	@Override
	public JvmConstructor getConstructor() {
		return (JvmConstructor) getFeature();
	}
	
	@Override
	public boolean isAnonymousClassConstructorCall() {
		return getConstructorCall().isAnonymousClassConstructorCall();
	}
	
	@Override
	public XConstructorCall getConstructorCall() {
		return getExpression();
	}

	@Override
	protected List<XExpression> getArguments() {
		return getConstructorCall().getArguments();
	}
	
	@Override
	protected List<JvmTypeReference> getPlainSyntacticTypeArguments() {
		return getConstructorCall().getTypeArguments();
	}
	
	@Override
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		return new FeatureLinkHelper().getDeclaredTypeParameters(getConstructor());
	}
	
}
