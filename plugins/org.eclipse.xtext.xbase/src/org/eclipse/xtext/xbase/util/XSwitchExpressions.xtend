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
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException
import org.eclipse.xtext.xbase.typesystem.references.OwnedConverter
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XSwitchExpressions {

	@Inject
	extension IBatchTypeResolver

	@Inject
	extension SwitchConstantExpressionsInterpreter
	
	@Inject
	CommonTypeComputationServices services

	def isJavaSwitchExpression(XSwitchExpression it) {
		val switchType = switchVariableType
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
		val ^case = casePart.^case
		if (^case == null) {
			return false
		} 
		extension val resolvedTypes = resolveTypes
		val caseType = ^case.actualType
		if (caseType == null) {
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
		if (declaredParam == null) {
			return ^switch.actualType
		}
		val parameterType = declaredParam.parameterType
		if (parameterType == null) {
			return ^switch.actualType
		}
		val converter = new OwnedConverter(new StandardTypeReferenceOwner(services, it));
		converter.toLightweightReference(parameterType)
	}
	
	def isConstant(XCasePart casePart) {
		val ^case = casePart.^case
		if (^case == null) {
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
