/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.EnumSet;

import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class AbstractTypeExpectation implements ITypeExpectation {

	private final AbstractTypeComputationState state;

	protected AbstractTypeExpectation(AbstractTypeComputationState state) {
		this.state = state;
	}
	
	@Override
	public ITypeReferenceOwner getReferenceOwner() {
		return state.getReferenceOwner();
	}

	@Override
	public void acceptActualType(LightweightTypeReference type, ConformanceHint... hints) {
		acceptActualType(type, ConformanceHint.toFlags(hints));
	}
	
	@Override
	public void acceptActualType(LightweightTypeReference type, EnumSet<ConformanceHint> hints) {
		acceptActualType(type, ConformanceHint.toFlags(hints));
	}
	
	@Override
	public boolean isVoidTypeAllowed() {
		LightweightTypeReference expectedType = getExpectedType();
		if (expectedType != null && expectedType.isType(Void.TYPE)) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean isOwnedBy(ITypeReferenceOwner referenceOwner) {
		LightweightTypeReference expectedType = getExpectedType();
		return expectedType == null || expectedType.isOwnedBy(referenceOwner);
	}
	
	protected AbstractTypeComputationState getState() {
		return state;
	}
	
	protected ResolvedTypes getResolvedTypes() {
		return state.getResolvedTypes();
	}
	
	@Override
	public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter) {
		return getResolvedTypes().createUnboundTypeReference(expression, typeParameter);
	}
	
	@Override
	public String toString() {
		LightweightTypeReference expectedType = getExpectedType();
		String expectedTypeString = "";
		if (expectedType != null) {
			expectedTypeString = expectedType.toString();
		} else if (isNoTypeExpectation()) {
			expectedTypeString = "<no expectation>";
		} else if (isVoidTypeAllowed()) {
			expectedTypeString = "<void allowed>";
		} else {
			expectedTypeString = "<void not allowed>";
		}
		return getClass().getSimpleName() + " [expectation=" + expectedTypeString + "]";
	}
	
}
