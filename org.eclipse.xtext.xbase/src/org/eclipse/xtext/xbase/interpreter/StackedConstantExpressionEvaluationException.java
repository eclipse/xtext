/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.interpreter;

import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.xbase.XExpression;

public class StackedConstantExpressionEvaluationException extends ConstantExpressionEvaluationException {
	private static final long serialVersionUID = -2953402800966199007L;

	public StackedConstantExpressionEvaluationException(XExpression expression, JvmField field,
			ConstantExpressionEvaluationException cause) {
		super("Error during call to " + field.getSimpleName() + " : " + cause.getMessage(), expression, cause);
	}
}
