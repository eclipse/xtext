/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.util

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XSwitchExpressions {

	@Inject
	extension IBatchTypeResolver

	@Inject
	extension SwitchConstantExpressionsInterpreter

	/**
	 * Determine whether the given switch expression is valid for Java version 6 or lower.
	 */
	def isJavaSwitchExpression(XSwitchExpression it) {
		val switchType = switchVariableType
		if (switchType === null) {
			return false
		}
		if (switchType.isSubtypeOf(Integer.TYPE)) {
			return true
		}
		if (switchType.isSubtypeOf(Enum)) {
			return true
		}
		false
	}

	/**
	 * Determine whether the given switch expression is valid for Java version 7 or higher.
	 */
	def isJava7SwitchExpression(XSwitchExpression it) {
		val switchType = switchVariableType
		if (switchType === null) {
			return false
		}
		if (switchType.isSubtypeOf(Integer.TYPE)) {
			return true
		}
		if (switchType.isSubtypeOf(Enum)) {
			return true
		}
		if (switchType.isSubtypeOf(String)) {
			return true
		}
		false
	}

	def isJavaCaseExpression(XSwitchExpression it, XCasePart casePart) {
		if (casePart.typeGuard !== null) {
			return false
		}
		val ^case = casePart.^case
		if (^case === null) {
			return false
		}
		extension val resolvedTypes = resolveTypes
		val caseType = ^case.actualType
		if (caseType === null) {
			return false
		}
		val switchType = switchVariableType
		if (!switchType.isAssignableFrom(caseType)) {
			return false
		}
		true
	}
	
	def getSwitchVariableType(XSwitchExpression it) {
		extension val resolvedTypes = resolveTypes
		val declaredParam = declaredParam
		if (declaredParam === null) {
			return ^switch.actualType
		}
		val paramType = declaredParam.actualType
		return paramType ?: ^switch.actualType
	}
	
	def isConstant(XCasePart casePart) {
		val ^case = casePart.^case
		if (^case === null) {
			return false
		}
		try {
			^case.evaluate
			return true
		} catch (ConstantExpressionEvaluationException e) {
			return false
		}
	}
	
	def XExpression getThen(XCasePart casePart, XSwitchExpression switchExpression) {
		val then = casePart.then
		if (then !== null) {
			return then
		}
		val casePartIndex = switchExpression.cases.indexOf(casePart)
		if (casePartIndex == -1) {
			return null
		}
		val count = switchExpression.cases.size
		if (casePartIndex == count - 1) {
			return switchExpression.^default
		}
		if (casePartIndex + 1 < count) {
			return switchExpression.cases.get(casePartIndex + 1).getThen(switchExpression)
		}
		return null
	}

}
