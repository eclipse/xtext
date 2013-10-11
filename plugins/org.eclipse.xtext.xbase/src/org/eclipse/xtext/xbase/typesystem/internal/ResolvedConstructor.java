/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ILinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ResolvedConstructor extends AbstractResolvedReference<XConstructorCall> implements IConstructorLinkingCandidate {

	public ResolvedConstructor(XConstructorCall constructorCall, JvmConstructor constructor, ExpressionTypeComputationState state) {
		super(constructorCall, constructor, state);
	}
	
	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return this;
	}
	
	public JvmConstructor getConstructor() {
		return (JvmConstructor) getFeature();
	}
	
	public XConstructorCall getConstructorCall() {
		return getExpression();
	}

	@Override
	protected List<XExpression> getArguments() {
		return getConstructorCall().getArguments();
	}
	
	@Override
	protected List<LightweightTypeReference> getSyntacticTypeArguments() {
		return Lists.transform(getConstructorCall().getTypeArguments(), getState().getResolvedTypes().getConverter());
	}
	
	@Override
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		return new FeatureLinkHelper().getDeclaredTypeParameters(getConstructor());
	}
	
}
