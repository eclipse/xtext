/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.typesystem.computation.ITypeComputationResult;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
public class ResolutionBasedComputationResult implements ITypeComputationResult {

	private final XExpression expression;
	private final TypeResolution resolution;

	public ResolutionBasedComputationResult(XExpression expression, TypeResolution resolution) {
		this.expression = expression;
		this.resolution = resolution;
	}

	public JvmTypeReference getActualExpressionType() {
		return resolution.getActualType(expression);
	}

	public JvmTypeReference getActualType(JvmIdentifiableElement element) {
		return resolution.getActualType(element);
	}

	public JvmTypeReference resolve(@Nullable JvmTypeReference unresolved) {
		// use the type data of the actual resolution to get grip on the
		// parameter substitutions
		throw new UnsupportedOperationException("TODO implement me");
	}

	public XExpression getExpression() {
		return expression;
	}

	public JvmTypeReference getExpectedExpressionType() {
		return resolution.getExpectedType(expression);
	}

}
