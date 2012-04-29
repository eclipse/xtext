/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.typesystem.internal;

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
	private final ResolvedTypes resolution;

	public ResolutionBasedComputationResult(XExpression expression, ResolvedTypes resolution) {
		this.expression = expression;
		this.resolution = resolution;
	}

	public JvmTypeReference getActualExpressionType() {
		return resolution.getActualType(expression);
	}

	public JvmTypeReference getActualType(JvmIdentifiableElement element) {
		return resolution.getActualType(element);
	}

	public XExpression getExpression() {
		return expression;
	}

	public JvmTypeReference getExpectedExpressionType() {
		return resolution.getExpectedType(expression);
	}

}
