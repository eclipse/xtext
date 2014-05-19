/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeAssigner;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 * TODO JavaDoc, toString
 */
public class TypeAssigner implements ITypeAssigner {
	private final AbstractTypeComputationState state;

	protected TypeAssigner(AbstractTypeComputationState state) {
		this.state = state;
	}

	public AbstractTypeComputationState getForkedState() {
		return state;
	}

	public void assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference actualType) {
		assignType(element, actualType, true);
	}
	
	protected void assignType(JvmIdentifiableElement element, /* @Nullable */ LightweightTypeReference actualType, boolean addToChildScope) {
		if (actualType != null) {
			state.getResolvedTypes().setType(element, actualType);
		} else {
			state.getResolvedTypes().setType(element, new AnyTypeReference(state.getReferenceOwner()));
		}
		if (addToChildScope)
			state.addLocalToCurrentScope(element);
	}

	protected OwnedConverter getConverter() {
		return state.getResolvedTypes().getConverter();
	}
	
	public ITypeReferenceOwner getReferenceOwner() {
		return state.getReferenceOwner();
	}

	public LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference) {
		return getConverter().toLightweightReference(reference);
	}
}