/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ObservableTypeExpectation extends TypeExpectation {

	@NonNullByDefault // bug in null stuff
	interface Observer {
		void accept(ObservableTypeExpectation expectation, LightweightTypeReference actual, ConformanceHint conformanceHint);
	}
	
	private final Observer observer;
	
	public ObservableTypeExpectation(LightweightTypeReference expectedType, AbstractTypeComputationState state, boolean returnType, Observer observer) {
		super(expectedType, state, returnType);
		this.observer = observer;
	}
	
	@Override
	public void acceptActualType(LightweightTypeReference type, ConformanceHint conformanceHint) {
		observer.accept(this, type, conformanceHint);
		super.acceptActualType(type, conformanceHint);
	}

	@Override
	public ObservableTypeExpectation copyInto(TypeReferenceOwner referenceOwner) {
		LightweightTypeReference expectedType = internalGetExpectedType();
		if (expectedType == null || expectedType.isOwnedBy(referenceOwner))
			return this;
		return new ObservableTypeExpectation(expectedType.copyInto(referenceOwner), getState(), isReturnType(), observer);
	}
	
}
