/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeParameterDeclarator;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ConstructorLinkingCandidate extends AbstractLinkingCandidate implements IConstructorLinkingCandidate {

	public ConstructorLinkingCandidate(XConstructorCall constructorCall, IEObjectDescription description, AbstractTypeComputationState state) {
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
	protected Map<JvmTypeParameter, JvmTypeReference> getFeatureTypeParameterMapping() {
		JvmDeclaredType createdType = getConstructor().getDeclaringType();
		if (createdType instanceof JvmTypeParameterDeclarator) {
			List<JvmTypeReference> typeArguments = getConstructorCall().getTypeArguments();
			List<JvmTypeParameter> typeParameters = ((JvmTypeParameterDeclarator) createdType).getTypeParameters();
			if (!typeArguments.isEmpty()) {
				int max = Math.min(typeArguments.size(), typeParameters.size());
				Map<JvmTypeParameter, JvmTypeReference> result = Maps.newHashMapWithExpectedSize(max);
				for(int i = 0; i < max; i++) {
					result.put(typeParameters.get(i), typeArguments.get(i));
				}
				// TODO computed type references for the remaining type parameters
				return result;
			}
		}
		return super.getFeatureTypeParameterMapping();
	}

}
