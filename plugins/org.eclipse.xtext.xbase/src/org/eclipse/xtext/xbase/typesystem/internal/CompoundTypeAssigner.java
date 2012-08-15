/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeAssigner;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationState;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class CompoundTypeAssigner implements ITypeAssigner {

	private final TypeAssigner[] assigners;
	private final ITypeReferenceOwner owner;

	public CompoundTypeAssigner(ITypeReferenceOwner owner, TypeAssigner[] assigners) {
		this.owner = owner;
		this.assigners = assigners;
	}

	public void assignType(JvmIdentifiableElement element, LightweightTypeReference expectedType) {
		for(ITypeAssigner assigner: assigners) {
			assigner.assignType(element, expectedType);
		}
	}

	public void assignType(JvmIdentifiableElement element, LightweightTypeReference actualDeclaredType,
			LightweightTypeReference expectedType) {
		for(ITypeAssigner assigner: assigners) {
			assigner.assignType(element, actualDeclaredType, expectedType);
		}
	}

	public ITypeComputationState getForkedState() {
		AbstractTypeComputationState[] states = new AbstractTypeComputationState[assigners.length];
		for(int i = 0; i < states.length; i++) {
			states[i] = assigners[i].getForkedState();
		}
		return new CompoundTypeComputationState(owner, states);
	}

	public LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference) {
		return new OwnedConverter(owner).toLightweightReference(reference);
	}
	
}
