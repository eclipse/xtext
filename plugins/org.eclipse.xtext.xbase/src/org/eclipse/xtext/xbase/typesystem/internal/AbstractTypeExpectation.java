/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.typesystem.references.BaseTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public abstract class AbstractTypeExpectation extends BaseTypeExpectation {

	private final AbstractTypeComputationState state;

	protected AbstractTypeExpectation(AbstractTypeComputationState state) {
		this.state = state;
	}
	
	public boolean isVoidTypeAllowed() {
		LightweightTypeReference expectedType = internalGetExpectedType();
		// TODO avoid resolving the type ref
		if (expectedType != null && expectedType.isType(Void.TYPE)) {
			return true;
		}
		return false;
	}
	
	@Override
	protected OwnedConverter getConverter() {
		return state.getResolvedTypes().getConverter();
	}
	
	protected AbstractTypeComputationState getState() {
		return state;
	}
	
	@Override
	public String toString() {
		LightweightTypeReference expectedType = internalGetExpectedType();
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
