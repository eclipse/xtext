/*******************************************************************************
a * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class NoExpectation extends AbstractReturnAwareTypeExpectation {

	public NoExpectation(AbstractTypeComputationState state, boolean returnType) {
		super(state, returnType);
	}

	/* @Nullable */
	public LightweightTypeReference getExpectedType() {
		return null;
	}

	public boolean isNoTypeExpectation() {
		return true;
	}
	
	@Override
	public boolean isVoidTypeAllowed() {
		return true;
	}
	
	public ITypeExpectation copyInto(ITypeReferenceOwner referenceOwner) {
		return this;
	}
}
