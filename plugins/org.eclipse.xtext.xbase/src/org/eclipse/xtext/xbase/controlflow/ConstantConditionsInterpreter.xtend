/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.controlflow

import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException
import org.eclipse.xtext.xbase.interpreter.Context
import org.eclipse.xtext.xbase.XExpression

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ConstantConditionsInterpreter extends EarlyExitInterpreter {

	def Boolean getBooleanConstantOrNull(XExpression it) {
		try {
			val constant = evaluate
			if (constant instanceof Boolean) {
				return constant
			}
			return null
		} catch (ConstantExpressionEvaluationException e) {
			return null
		}
	}
	
	def dispatch Object internalEvaluate(XNullLiteral it, Context ctx) {
		null
	}
	
	override protected evaluateBinaryOperation(XBinaryOperation binaryOperation, Object left, Object right) {
		if (left == null || right == null) {
			val op = binaryOperation.concreteSyntaxFeatureName
			switch op {
				case '==', 
				case '===': left === right
				case '!=',
				case '!==': left !== right
				default: throw new ConstantExpressionEvaluationException("Couldn't evaluate binary operator '" + op + "' on values " + left + " and " + right)
			}
		} else {
			super.evaluateBinaryOperation(binaryOperation, left, right)
		}
	}
	
}