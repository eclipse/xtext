/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.interpreter;

import org.eclipse.xtext.xbase.XExpression;

/**
 * Indicates a problem during evaluation
 */
public class ConstantExpressionEvaluationException extends RuntimeException {
	private static final long serialVersionUID = -6547435412253666390L;
	private XExpression expression;

	public ConstantExpressionEvaluationException(String message) {
		super(message);
	}

	public ConstantExpressionEvaluationException(String message, XExpression expression) {
		this(message);
		this.expression = expression;
	}

	public ConstantExpressionEvaluationException(String message, XExpression expression, Throwable cause) {
		super(message, cause);
		this.expression = expression;
	}

	public XExpression getExpression() {
		return expression;
	}
}
