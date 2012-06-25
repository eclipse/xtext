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

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class AnyTypeReference extends LightweightTypeReference {

	protected AnyTypeReference(TypeReferenceOwner owner) {
		super(owner);
	}

	@Override
	protected LightweightTypeReference doCopyInto(TypeReferenceOwner owner) {
		throw new UnsupportedOperationException();
	}

	@Override
	public JvmTypeReference toTypeReference() {
		return getTypesFactory().createJvmAnyTypeReference();
	}

	@Override
	public String toString() {
		return "null";
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitAnyTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitAnyTypeReference(this, param);
	}
	
	@Override
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitAnyTypeReference(this);
	}
	
	@Override
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitAnyTypeReference(this, param);
	}
}
