/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeExpectation;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class TypeData {
	private final XExpression expression;
	private final ITypeExpectation expectation;
	private final JvmTypeReference type;
	private final ConformanceHint conformanceHint;
	private final boolean returnType;

	public TypeData(
			XExpression expression, 
			ITypeExpectation expectation, 
			JvmTypeReference type,
			ConformanceHint conformanceHint,
			boolean returnType) {
		this.expression = expression;
		this.expectation = expectation;
		this.type = type;
		this.conformanceHint = conformanceHint;
		this.returnType = returnType;
	}

	@Override
	public String toString() {
		return "TypeData [expectation=" + expectation + ", type=" + type
				+ ", conformanceHint=" + conformanceHint + ", returnType=" + returnType + "]";
	}
	
	public ITypeExpectation getExpectation() {
		return expectation;
	}
	
	public ConformanceHint getConformanceHint() {
		return conformanceHint;
	}
	
	public XExpression getExpression() {
		return expression;
	}
	
	public JvmTypeReference getActualType() {
		return type;
	}
	
	public boolean isReturnType() {
		return returnType;
	}
}