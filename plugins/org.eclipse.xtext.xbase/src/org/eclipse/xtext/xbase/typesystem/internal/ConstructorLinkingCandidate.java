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
import java.util.Map;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.util.MergedBoundTypeArgument;
import org.eclipse.xtext.xbase.typesystem.util.VarianceInfo;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ConstructorLinkingCandidate extends AbstractLinkingCandidateWithTypeParameter<IConstructorLinkingCandidate> implements IConstructorLinkingCandidate {

	public ConstructorLinkingCandidate(XConstructorCall constructorCall, IEObjectDescription description, ExpressionTypeComputationState state) {
		super(constructorCall, description, state);
	}

	public XConstructorCall getConstructorCall() {
		return (XConstructorCall) getExpression();
	}

	public JvmConstructor getConstructor() {
		return (JvmConstructor) getFeature();
	}

	@Override
	protected List<XExpression> getSyntacticArguments() {
		return getConstructorCall().getArguments();
	}
	
	@Override
	protected List<JvmTypeReference> getTypeArguments() {
		return getConstructorCall().getTypeArguments();
	}
	
	@Override
	public List<JvmFormalParameter> getDeclaredParameters() {
		return getConstructor().getParameters();
	}
	
	@Override
	public List<JvmTypeParameter> getDeclaredTypeParameters() {
		JvmDeclaredType createdType = getConstructor().getDeclaringType();
		if (createdType instanceof JvmTypeParameterDeclarator) {
			return ((JvmTypeParameterDeclarator) createdType).getTypeParameters();
		}
		return Collections.emptyList();
	}
	
	@Override
	protected Map<JvmTypeParameter, MergedBoundTypeArgument> getFeatureTypeParameterMapping() {
		JvmDeclaredType createdType = getConstructor().getDeclaringType();
		if (createdType instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeReference> typeArguments = getConstructorCall().getTypeArguments();
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) createdType).getTypeParameters();
			if (!typeArguments.isEmpty()) {
				Map<JvmTypeParameter, MergedBoundTypeArgument> result = Maps.newLinkedHashMap();
				int max = Math.min(typeArguments.size(), typeParameters.size());
				for(int i = 0; i < max; i++) {
					result.put(typeParameters.get(i), new MergedBoundTypeArgument(typeArguments.get(i), VarianceInfo.INVARIANT));
				}
			}
		}
		super.initializeFeatureTypeParameterMapping(result);
	}
	
}
