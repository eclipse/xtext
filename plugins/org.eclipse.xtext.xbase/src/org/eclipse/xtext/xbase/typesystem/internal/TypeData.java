/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.EnumSet;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class TypeData {
	private final XExpression expression;
	private final ITypeExpectation expectation;
	private final LightweightTypeReference type;
	private final EnumSet<ConformanceHint> hints;
	private final boolean returnType;

	public TypeData(
			XExpression expression, 
			ITypeExpectation expectation, 
			LightweightTypeReference type,
			EnumSet<ConformanceHint> hints,
			boolean returnType) {
		if (!hints.contains(ConformanceHint.CHECKED) && !hints.contains(ConformanceHint.UNCHECKED)) {
			throw new IllegalArgumentException("Invalid hints: " + hints);
		}
		this.expression = expression;
		this.expectation = expectation;
		this.type = type;
		this.hints = hints;
		this.returnType = returnType;
	}
	
	public boolean isOwnedBy(ITypeReferenceOwner owner) {
		return expectation.isOwnedBy(owner) && type.isOwnedBy(owner);
	}

	@Override
	public String toString() {
		return "TypeData [expectation=" + expectation + ", type=" + type
				+ ", conformanceHint=" + hints + ", returnType=" + returnType + "]";
	}
	
	public ITypeExpectation getExpectation() {
		return expectation;
	}
	
	public EnumSet<ConformanceHint> getConformanceHints() {
		return hints;
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