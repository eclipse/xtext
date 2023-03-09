/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class TypeExpectation extends AbstractReturnAwareTypeExpectation {

	private final LightweightTypeReference reference;

	public TypeExpectation(/* @Nullable */ LightweightTypeReference reference, AbstractTypeComputationState state, boolean returnType) {
		super(state, returnType);
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
	public TypeExpectation copyInto(ITypeReferenceOwner referenceOwner) {
		if (reference == null || reference.isOwnedBy(referenceOwner))
			return this;
		return new TypeExpectation(reference.copyInto(referenceOwner), getState(), isReturnType());
	}

}
