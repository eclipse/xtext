/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class RootTypeExpectation extends AbstractRootTypeExpectation {

	private final LightweightTypeReference reference;

	public RootTypeExpectation(LightweightTypeReference reference, AbstractTypeComputationState state) {
		super(state);
		this.reference = reference;
	}
	
	public boolean isNoTypeExpectation() {
		return false;
	}
	
	public LightweightTypeReference internalGetExpectedType() {
		return reference;
	}

	public LightweightTypeExpectation copyInto(ITypeReferenceOwner referenceOwner) {
		return new RootTypeExpectation(reference.copyInto(referenceOwner), getState());
	}
}
