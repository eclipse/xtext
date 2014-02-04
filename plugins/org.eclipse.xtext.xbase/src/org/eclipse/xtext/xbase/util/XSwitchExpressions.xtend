/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.util

import com.google.inject.Inject
import org.eclipse.xtext.xbase.XCasePart
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.validation.ConstantExpressionValidator
import org.eclipse.xtext.xbase.XExpression

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XSwitchExpressions {

	@Inject
	extension IBatchTypeResolver

	@Inject
	extension ConstantExpressionValidator

	def isJavaSwitchExpression(XSwitchExpression it) {
		extension val resolvedTypes = resolveTypes
		val switchType = ^switch.actualType
		if (switchType == null) {
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

	def isJavaCaseExpression(XSwitchExpression it, XCasePart casePart) {
		if (casePart.typeGuard != null) {
			return false
		}
		if (!casePart.constant) {
			return false
		} 
		extension val resolvedTypes = resolveTypes
		val caseType = casePart.^case.actualType
		if (caseType == null) {
			return false
		}
		val switchType = ^switch.actualType
		if (!switchType.isAssignableFrom(caseType)) {
			return false
		}
		true
	}
	
	def isConstant(XCasePart casePart) {
		val ^case = casePart.^case
		if (^case == null) {
			return false
		}
		return ^case.constant
	}
	
	def XExpression getThen(XCasePart casePart, XSwitchExpression switchExpression) {
		val then = casePart.then
		if (then != null) {
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
