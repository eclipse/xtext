/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.references;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class BaseTypeExpectation implements LightweightTypeExpectation {

	private final TypeReferenceOwner owner;
	private final OwnedConverter converter;

	protected BaseTypeExpectation(TypeReferenceOwner owner) {
		this.owner = owner;
		this.converter = new OwnedConverter(owner);
	}
	
	public OwnedConverter getConverter() {
		return converter;
	}
	
	public void acceptActualType(JvmTypeReference type, ConformanceHint hint) {
		acceptActualType(getConverter().toLightweightReference(type), hint);
	}

	@Nullable
	public final JvmTypeReference getExpectedType() {
		LightweightTypeReference result = internalGetExpectedType();
		if (result != null) {
			return result.toTypeReference();
		}
		return null;
	}
	
	public TypeReferenceOwner getReferenceOwner() {
		return owner;
	}
	
}
