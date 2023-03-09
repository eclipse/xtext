/*******************************************************************************
a * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
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
public class RootNoExpectation extends AbstractRootTypeExpectation {

	private boolean voidAllowed;

	public RootNoExpectation(AbstractTypeComputationState state, boolean voidAllowed) {
		super(state);
		this.voidAllowed = voidAllowed;
	}

	/* @Nullable */
	@Override
	public LightweightTypeReference getExpectedType() {
		return null;
	}

	@Override
	public boolean isNoTypeExpectation() {
		return voidAllowed;
	}
	
	@Override
	public boolean isVoidTypeAllowed() {
		return voidAllowed;
	}
	
	@Override
	public RootNoExpectation copyInto(ITypeReferenceOwner referenceOwner) {
		return this;
	}
	
}
