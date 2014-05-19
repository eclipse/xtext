/*******************************************************************************
a * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	public LightweightTypeReference getExpectedType() {
		return null;
	}

	public boolean isNoTypeExpectation() {
		return voidAllowed;
	}
	
	@Override
	public boolean isVoidTypeAllowed() {
		return voidAllowed;
	}
	
	public RootNoExpectation copyInto(ITypeReferenceOwner referenceOwner) {
		return this;
	}
	
}
