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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ConstructorLinkingCandidate extends AbstractLinkingCandidate<IConstructorLinkingCandidate> implements IConstructorLinkingCandidate {

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
	protected List<JvmTypeReference> getExplicitTypeArguments() {
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
	
}
