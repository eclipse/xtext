/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceFlags;
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
	private int flags;
	private final boolean returnType;

	public TypeData(
			XExpression expression, 
			ITypeExpectation expectation, 
			LightweightTypeReference type,
			int flags,
			boolean returnType) {
		ConformanceFlags.sanityCheck(flags);
		this.expression = expression;
		this.expectation = expectation;
		this.type = type;
		this.flags = flags;
		this.returnType = returnType;
	}
	
	public boolean isOwnedBy(ITypeReferenceOwner owner) {
		return expectation.isOwnedBy(owner) && type.isOwnedBy(owner);
	}

	@Override
	public String toString() {
		return "TypeData [expectation=" + expectation + ", type=" + type
				+ ", flags=" + ConformanceFlags.toString(flags) + ", returnType=" + returnType + "]";
	}
	
	public ITypeExpectation getExpectation() {
		return expectation;
	}
	
	public int getConformanceFlags() {
		return flags;
	}
	
	public void setConformanceFlags(int flags) {
		ConformanceFlags.sanityCheck(flags);
		this.flags = flags;
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