/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import java.util.EnumSet;

import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;
import org.eclipse.xtext.xbase.typesystem.conformance.ConformanceHint;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class NoTypeResult implements ITypeComputationResult {

	public XExpression getExpression() {
		return null;
	}
	
	public LightweightTypeReference getActualExpressionType() {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	public LightweightTypeReference getReturnType() {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	public LightweightTypeReference getExpectedExpressionType() {
		throw new UnsupportedOperationException("TODO implement me");
	}

	public LightweightTypeReference getActualType(JvmIdentifiableElement element) {
		throw new UnsupportedOperationException("TODO implement me");
	}
	
	public EnumSet<ConformanceHint> getConformanceHints() {
		throw new UnsupportedOperationException("TODO implement me");
	}

}
