/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.controlflow

import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class EarlyExitInterpreter extends SwitchConstantExpressionsInterpreter {
	
	def boolean isConstant(XExpression it, Object value) {
		try {
			val constant = evaluate
			return value == constant
		} catch (ConstantExpressionEvaluationException e) {
			return false;
		}
	}
	
}