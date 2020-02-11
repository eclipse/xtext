/*******************************************************************************
a * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
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
public class NoExpectation extends AbstractReturnAwareTypeExpectation {

	public NoExpectation(AbstractTypeComputationState state, boolean returnType) {
		super(state, returnType);
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedType() {
		return null;
	}

	@Override
	public boolean isNoTypeExpectation() {
		return true;
	}
	
	@Override
	public boolean isVoidTypeAllowed() {
		return true;
	}
	
	@Override
	public ITypeExpectation copyInto(ITypeReferenceOwner referenceOwner) {
		return this;
	}
}
