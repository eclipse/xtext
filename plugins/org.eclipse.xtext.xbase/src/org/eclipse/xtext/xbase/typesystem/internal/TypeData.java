/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeExpectation;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.TypeReferenceOwner;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeData {
	private final XExpression expression;
	private final LightweightTypeExpectation expectation;
	private final LightweightTypeReference type;
	private final ConformanceHint conformanceHint;
	private final boolean returnType;

	public TypeData(
			XExpression expression, 
			LightweightTypeExpectation expectation, 
			LightweightTypeReference type,
			ConformanceHint conformanceHint,
			boolean returnType) {
		this.expression = expression;
		this.expectation = expectation;
		this.type = type;
		this.conformanceHint = conformanceHint;
		this.returnType = returnType;
	}
	
	public TypeData copyInto(TypeReferenceOwner owner) {
		if (isOwnedBy(owner))
			return this;
		return new TypeData(expression, expectation.copyInto(owner), type.copyInto(owner), conformanceHint, returnType);
	}
	
	public boolean isOwnedBy(TypeReferenceOwner owner) {
		return expectation.isOwnedBy(owner) && type.isOwnedBy(owner);
	}

	@Override
	public String toString() {
		return "TypeData [expectation=" + expectation + ", type=" + type
				+ ", conformanceHint=" + conformanceHint + ", returnType=" + returnType + "]";
	}
	
	public LightweightTypeExpectation getExpectation() {
		return expectation;
	}
	
	public ConformanceHint getConformanceHint() {
		return conformanceHint;
	}
	
	public XExpression getExpression() {
		return expression;
	}
	
	public LightweightTypeReference getActualType() {
		return type;
	}
	
	public boolean isReturnType() {
		return returnType;
	}
}