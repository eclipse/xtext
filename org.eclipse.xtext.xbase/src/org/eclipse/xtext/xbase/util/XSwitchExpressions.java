/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.util;

import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.xbase.XCasePart;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XSwitchExpression;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.interpreter.SwitchConstantExpressionsInterpreter;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

import com.google.inject.Inject;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
public class XSwitchExpressions {
	@Inject
	private IBatchTypeResolver batchTypeResolver;

	@Inject
	private SwitchConstantExpressionsInterpreter switchConstantExpressionsInterpreter;

	/**
	 * Determine whether the given switch expression is valid for Java version 6
	 * or lower.
	 */
	public boolean isJavaSwitchExpression(XSwitchExpression it) {
		LightweightTypeReference switchType = getSwitchVariableType(it);
		if (switchType == null) {
			return false;
		}
		if (switchType.isSubtypeOf(Integer.TYPE)) {
			return true;
		}
		if (switchType.isSubtypeOf(Enum.class)) {
			return true;
		}
		return false;
	}

	/**
	 * Determine whether the given switch expression is valid for Java version 7
	 * or higher.
	 */
	public boolean isJava7SwitchExpression(XSwitchExpression it) {
		LightweightTypeReference switchType = getSwitchVariableType(it);
		if (switchType == null) {
			return false;
		}
		if (switchType.isSubtypeOf(Integer.TYPE)) {
			return true;
		}
		if (switchType.isSubtypeOf(Enum.class)) {
			return true;
		}
		if (switchType.isSubtypeOf(String.class)) {
			return true;
		}
		return false;
	}

	public boolean isJavaCaseExpression(XSwitchExpression it, XCasePart casePart) {
		if (casePart.getTypeGuard() != null) {
			return false;
		}
		XExpression caseExpression = casePart.getCase();
		if (caseExpression == null) {
			return false;
		}
		IResolvedTypes resolvedTypes = batchTypeResolver.resolveTypes(it);
		LightweightTypeReference caseType = resolvedTypes.getActualType(caseExpression);
		if (caseType == null) {
			return false;
		}
		LightweightTypeReference switchType = getSwitchVariableType(it);
		if (!switchType.isAssignableFrom(caseType)) {
			return false;
		}
		return true;
	}

	public LightweightTypeReference getSwitchVariableType(XSwitchExpression it) {
		IResolvedTypes resolvedTypes = batchTypeResolver.resolveTypes(it);
		JvmFormalParameter declaredParam = it.getDeclaredParam();
		if (declaredParam == null) {
			return resolvedTypes.getActualType(it.getSwitch());
		}
		LightweightTypeReference paramType = resolvedTypes.getActualType(declaredParam);
		if (paramType != null) {
			return paramType;
		} else {
			return resolvedTypes.getActualType(it.getSwitch());
		}
	}

	public boolean isConstant(XCasePart casePart) {
		XExpression caseExpression = casePart.getCase();
		if (caseExpression == null) {
			return false;
		}
		try {
			switchConstantExpressionsInterpreter.evaluate(caseExpression);
			return true;
		} catch (ConstantExpressionEvaluationException e) {
			return false;
		}
	}

	public XExpression getThen(XCasePart casePart, XSwitchExpression switchExpression) {
		XExpression then = casePart.getThen();
		if (then != null) {
			return then;
		}
		int casePartIndex = switchExpression.getCases().indexOf(casePart);
		if (casePartIndex == -1) {
			return null;
		}
		int count = switchExpression.getCases().size();
		if (casePartIndex == count - 1) {
			return switchExpression.getDefault();
		}
		if (casePartIndex + 1 < count) {
			return getThen(switchExpression.getCases().get(casePartIndex + 1), switchExpression);
		}
		return null;
	}
}
