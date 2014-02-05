/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.interpreter

import com.google.inject.Inject
import java.util.Map
import java.util.Set
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.access.impl.ClassFinder
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class AbstractConstantExpressionsInterpreter {
	
	@Inject ConstantOperators constantOperators

	def dispatch Object internalEvaluate(XExpression expression, Context ctx) {
		throw notConstantExpression(expression)
	}
	
	def notConstantExpression(XExpression expression) {
		new ConstantExpressionEvaluationException("Not a constant expression : '" + expression?.toText + "'", expression)
	}
	
	def dispatch Object internalEvaluate(XCastedExpression expression, Context ctx) {
		internalEvaluate(expression.target, ctx)
	}

	def dispatch Object internalEvaluate(XStringLiteral it, Context ctx) {
		value
	}

	def dispatch Object internalEvaluate(XBooleanLiteral it, Context ctx) {
		isTrue
	}

	def dispatch Object internalEvaluate(XAnnotation literal, Context ctx) {
		literal
	}

	def dispatch Object internalEvaluate(XTypeLiteral it, Context ctx) {
		toTypeReference(type, arrayDimensions.size)
	}

	protected def toTypeReference(JvmType type, int arrayDimensions) {
		if (type == null)
			return null
		var JvmTypeReference resultTypeRef = TypesFactory.eINSTANCE.createJvmParameterizedTypeReference => [
			it.type = type
		]
		for (i : 0 ..< arrayDimensions) {
			val arrayRef = TypesFactory.eINSTANCE.createJvmGenericArrayTypeReference
			arrayRef.setComponentType(resultTypeRef);
			resultTypeRef = arrayRef
		}
		return resultTypeRef
	}

	def dispatch Object internalEvaluate(XBinaryOperation it, Context ctx) {
		val left = leftOperand.internalEvaluate(ctx)
		val right = rightOperand.internalEvaluate(ctx)
		val op = concreteSyntaxFeatureName
		switch op {
			case '+': constantOperators.plus(left, right)
			case '-': constantOperators.minus(left, right)
			case '*': constantOperators.multiply(left, right)
			case '/': constantOperators.divide(left, right)
			case '%': constantOperators.modulo(left, right)
			case '<': constantOperators.lessThan(left, right)
			case '>': constantOperators.greaterThan(left, right)
			case '<=': constantOperators.lessEquals(left, right)
			case '>=': constantOperators.greaterEquals(left, right)
			case '===': constantOperators.same(left, right)
			case '!==': constantOperators.notSame(left, right)
			case '==': constantOperators.same(left, right)
			case '!=': constantOperators.notSame(left, right)
			default: throw new ConstantExpressionEvaluationException("Couldn't evaluate binary operator '" + op + "' on values " + left + " and " + right)
		}
	}

	def dispatch Object internalEvaluate(XUnaryOperation it, Context ctx) {
		val value = operand.internalEvaluate(ctx)
		val op = concreteSyntaxFeatureName
		switch op {
			case '-': constantOperators.minus(value)
			case op=='!' && value instanceof Boolean: !(value as Boolean)
			case op=='+' && value instanceof Number: value
			default: throw new ConstantExpressionEvaluationException("Couldn't evaluate unary operator '" + value + "' on value " + value)
		}
	}

	protected def toText(XExpression expression) {
		NodeModelUtils.getNode(expression).text
	}

}

@Data class Context {
	JvmTypeReference expectedType
	ClassFinder classFinder
	Map<String, JvmIdentifiableElement> visibleFeatures
	Set<XExpression> alreadyEvaluating
	
	def cloneWithExpectation(JvmTypeReference newExpectation) {
		return new Context(newExpectation, classFinder, visibleFeatures, alreadyEvaluating)
	}
	
}

/**
 * Indicates a problem during evaluation
 */
class ConstantExpressionEvaluationException extends RuntimeException {

	XExpression expression
	
	new(String message) {
		super(message)
	}
	
	new(String message, XExpression expression) {
		this(message)
		this.expression = expression
	}

	def getExpression() {
		expression
	}
}

class UnresolvableFeatureException extends ConstantExpressionEvaluationException {
	
	new(String message, XExpression expression) {
		super(message, expression)
	}
	
}

class StackedConstantExpressionEvaluationException extends ConstantExpressionEvaluationException {
	
	JvmField field
	ConstantExpressionEvaluationException cause
	
	new(XExpression expression, JvmField field, ConstantExpressionEvaluationException cause) {
		super('Error during call to '+field.simpleName+' : ' +cause.message, expression)
		this.field = field
		this.cause = cause
	}
	
}
