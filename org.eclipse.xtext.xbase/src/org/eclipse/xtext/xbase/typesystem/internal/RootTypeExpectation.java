/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class RootTypeExpectation extends AbstractRootTypeExpectation {

	private final LightweightTypeReference reference;

	public RootTypeExpectation(/* @Nullable */ LightweightTypeReference reference, AbstractTypeComputationState state) {
		super(state);
		this.reference = reference;
	}
	
	@Override
	public boolean isNoTypeExpectation() {
		return false;
	}
	
	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedType() {
		return reference;
	}

	@Override
	public ITypeExpectation copyInto(ITypeReferenceOwner referenceOwner) {
		return new RootTypeExpectation(reference.copyInto(referenceOwner), getState());
	}
}
