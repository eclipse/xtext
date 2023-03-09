/*******************************************************************************
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.controlflow;

import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter;

import com.google.common.base.Objects;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EarlyExitInterpreter extends SwitchConstantExpressionsInterpreter {
	public boolean isConstant(XExpression it, Object value) {
		try {
			Object constant = evaluate(it);
			return Objects.equal(value, constant);
		} catch (ConstantExpressionEvaluationException e) {
			return false;
		}
	}
}
