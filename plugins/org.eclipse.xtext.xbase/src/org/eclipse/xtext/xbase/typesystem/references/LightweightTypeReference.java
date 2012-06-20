/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO document the purpose of this class
 *  - get rid of containment constraints
 *  - easier copying
 *  - isResolved
 */
@NonNullByDefault
public abstract class LightweightTypeReference {
	
	private TypeReferenceOwner owner;
	
	protected LightweightTypeReference(TypeReferenceOwner owner) {
		this.owner = owner;
	}

	public boolean isResolved() {
		return true;
	}
	
	protected TypeReferenceOwner getOwner() {
		return owner;
	}
	
	protected TypesFactory getTypesFactory() {
		return getOwner().getServices().getTypesFactory();
	}
	
	protected CommonTypeComputationServices getServices() {
		return getOwner().getServices();
	}
	
	protected boolean isValidInContext(TypeReferenceOwner owner) {
		if (isResolved()) {
			return true;
		}
		return owner == getOwner();
	}
	
	protected abstract JvmTypeReference toTypeReference();
	
	protected LightweightTypeReference copyInto(TypeReferenceOwner owner) {
		if (isResolved()) {
			return this;
		}
		return doCopyInto(owner);
	}

	protected abstract LightweightTypeReference doCopyInto(TypeReferenceOwner owner);
	
	@Override
	public abstract String toString();
	
}
