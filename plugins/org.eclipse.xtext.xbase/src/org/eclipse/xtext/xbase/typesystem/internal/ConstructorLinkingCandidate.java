/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.xtext.common.types.JvmConstructor;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XConstructorCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.IConstructorLinkingCandidate;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ConstructorLinkingCandidate implements IConstructorLinkingCandidate {

	private final XConstructorCall constructorCall;
	private final JvmConstructor constructor;
	private final AbstractTypeComputationState state;

	public ConstructorLinkingCandidate(XConstructorCall constructorCall, JvmConstructor constructor, AbstractTypeComputationState state) {
		this.constructorCall = constructorCall;
		this.constructor = constructor;
		this.state = state;
	}
	
	public JvmIdentifiableElement getFeature() {
		return getConstructor();
	}

	public List<XExpression> getArguments() {
		return constructorCall.getArguments();
	}

	public XConstructorCall getConstructorCall() {
		return constructorCall;
	}

	public JvmConstructor getConstructor() {
		return constructor;
	}
	
	public void apply() {
		state.getTypeResolution().setLinkingInformation(constructorCall, this);
		List<ITypeExpectation> expectations = state.getImmediateExpectations();
		for(ITypeExpectation expectation: expectations) {
			// TODO implement bounds / type parameter resolution
			expectation.acceptActualType(state.getTypeReferences().createTypeRef(constructor.getDeclaringType()), ConformanceHint.UNCHECKED);
		}
	}

}
