/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.controlflow

import com.google.common.base.Optional
import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XCastedExpression
import org.eclipse.xtext.xbase.XCatchClause
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XNullLiteral
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XSwitchExpression
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.XVariableDeclaration
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException
import org.eclipse.xtext.xbase.interpreter.ConstantOperators
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.scoping.XImportSectionNamespaceScopeProvider
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals

/**
 * Interpreter for expressions at development time that uses the static linking
 * information and hardcoded logic to apply binary operations on well known types. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Accessors(PROTECTED_GETTER)
class ConstantConditionsInterpreter {
	
	@Inject extension ILogicalContainerProvider

	@Inject extension NumberLiterals numberLiterals
	
	@Inject IBatchTypeResolver typeResolver
	
	@Inject ConstantOperators constantOperators

	def BooleanResult getBooleanConstantOrNull(XExpression it) {
		try {
			val resolvedTypes = typeResolver.resolveTypes(it)
			val evaluationResult = internalEvaluate(resolvedTypes)
			if (evaluationResult.value instanceof Boolean) {
				return new BooleanResult(evaluationResult.value as Boolean, evaluationResult.compileTimeConstant)
			}
			return null
		} catch (ConstantExpressionEvaluationException e) {
			return null
		} catch (IllegalArgumentException e) {
			return null
		}
	}
	
	def dispatch EvaluationResult internalEvaluate(XExpression expression, IResolvedTypes resolvedTypes) {
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalEvaluate(Void nullValue, IResolvedTypes resolvedTypes) {
		throw new ConstantExpressionEvaluationException("null")
	}

	def dispatch EvaluationResult internalEvaluate(XNumberLiteral it, IResolvedTypes resolvedTypes) {
		val value = numberValue(javaType)
		return new EvaluationResult(value, resolvedTypes.getActualType(it).primitive)
	}

	def dispatch EvaluationResult internalEvaluate(XAbstractFeatureCall it, IResolvedTypes resolvedTypes) {
		switch feature : feature {
			JvmType,
			JvmEnumerationLiteral: {
				return new EvaluationResult(feature, true)
			}
			JvmField: {
				if (feature.setConstant) {
					if (feature.constant) {
						return new EvaluationResult(feature.constantValue, true)
					}
				} else if (feature.final) {
					val associatedExpression = feature.associatedExpression
					if (associatedExpression != null) {
						val result = associatedExpression.evaluateAssociatedExpression(resolvedTypes)
						return new EvaluationResult(result.value, false)
					}
				}
			}
			XVariableDeclaration case !feature.writeable && feature.right != null: {
				return feature.right.evaluateAssociatedExpression(resolvedTypes)
			}
			JvmFormalParameter: {
				switch container : feature.eContainer {
					XSwitchExpression case container.^switch != null: {
						return container.^switch.internalEvaluate(resolvedTypes)
					}
					default: return new EvaluationResult(feature, false)
				}
			}
		}
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def EvaluationResult evaluateAssociatedExpression(XExpression it, IResolvedTypes resolvedTypes) {
		switch it {
			XAbstractFeatureCall case feature instanceof JvmEnumerationLiteral: {
				val arg = internalEvaluate(resolvedTypes);
				return new EvaluationResult(arg.value, false)
			}
			default: internalEvaluate(resolvedTypes)
		}
	}
	
	def dispatch EvaluationResult internalEvaluate(XNullLiteral it, IResolvedTypes resolvedTypes) {
		return new EvaluationResult(null, true)
	}
	
	def private boolean isFromXbaseLibrary(XAbstractFeatureCall it) {
		val feature = it.feature
		if (feature != null && feature.eIsProxy) {
			throw new IllegalArgumentException("proxy")
		}
		switch feature {
			JvmMember: feature?.declaringType?.packageName == XImportSectionNamespaceScopeProvider.XBASE_LIB.toString
			default: false
		}
	}
	
	def dispatch EvaluationResult internalEvaluate(XUnaryOperation it, IResolvedTypes resolvedTypes) {
		if (isFromXbaseLibrary) {
			val arg = operand.internalEvaluate(resolvedTypes)
			val op = concreteSyntaxFeatureName
			switch op {
				case '-': try {
					val result = constantOperators.minus(arg.value)
					return new EvaluationResult(result, arg.compileTimeConstant)
				} catch(ConstantExpressionEvaluationException e) {
					return EvaluationResult.NOT_A_CONSTANT
				}
				case op=='!' && arg.value instanceof Boolean: new EvaluationResult(!(arg.value as Boolean), arg.compileTimeConstant)
				case op=='+' && arg.value instanceof Number: arg
				default: EvaluationResult.NOT_A_CONSTANT
			}
		} else {
			return EvaluationResult.NOT_A_CONSTANT
		}
	}
	
	def dispatch EvaluationResult internalEvaluate(XBinaryOperation it, IResolvedTypes resolvedTypes) {
		if (isFromXbaseLibrary) {
			val left = leftOperand.internalEvaluate(resolvedTypes) 
			val right = rightOperand.internalEvaluate(resolvedTypes)
	
			try {
				val op = concreteSyntaxFeatureName
				val value = switch op {
					case '+': constantOperators.plus(left.value, right.value)
					case '-': constantOperators.minus(left.value, right.value)
					case '*': constantOperators.multiply(left.value, right.value)
					case '/': constantOperators.divide(left.value, right.value)
					case '%': constantOperators.modulo(left.value, right.value)
					case '<<': constantOperators.shiftLeft(left.value, right.value)
					case '>>': constantOperators.shiftRight(left.value, right.value)
					case '>>>': constantOperators.shiftRightUnsigned(left.value, right.value)
					case '<': constantOperators.lessThan(left.value, right.value)
					case '>': constantOperators.greaterThan(left.value, right.value)
					case '<=': constantOperators.lessEquals(left.value, right.value)
					case '>=': constantOperators.greaterEquals(left.value, right.value)
					case '&&': return internalLogicalAnd(left.value, right.value, left.compileTimeConstant && right.compileTimeConstant)
					case '||': return internalLogicalOr(left.value, right.value, left.compileTimeConstant && right.compileTimeConstant)
					case '==',
					case '===': return new EvaluationResult(left.equalValue(right), left.compileTimeConstant && right.compileTimeConstant) 
					case '!=',
					case '!==': return new EvaluationResult(!left.equalValue(right), left.compileTimeConstant && right.compileTimeConstant)
					default: return EvaluationResult.NOT_A_CONSTANT
				}
				return new EvaluationResult(value, left.compileTimeConstant && right.compileTimeConstant)
			} catch(ConstantExpressionEvaluationException e) {
				return EvaluationResult.NOT_A_CONSTANT
			}
		} else {
			return EvaluationResult.NOT_A_CONSTANT
		}
	}
	
	def dispatch EvaluationResult internalLogicalAnd(Object left, Object right, boolean compileTimeConstant) {
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalLogicalAnd(Boolean left, Boolean right, boolean compileTimeConstant) {
		return new EvaluationResult(left && right, compileTimeConstant)
	}
	
	def dispatch EvaluationResult internalLogicalAnd(Boolean left, Object right, boolean compileTimeConstant) {
		if (!left) {
			return new EvaluationResult(Boolean.FALSE, compileTimeConstant)
		}
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalLogicalAnd(Boolean left, Void right, boolean compileTimeConstant) {
		if (!left) {
			return new EvaluationResult(Boolean.FALSE, compileTimeConstant)
		}
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalLogicalAnd(Object left, Boolean right, boolean compileTimeConstant) {
		if (!right) {
			return new EvaluationResult(Boolean.FALSE, compileTimeConstant)
		}
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalLogicalAnd(Void left, Boolean right, boolean compileTimeConstant) {
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalLogicalOr(Object left, Object right, boolean compileTimeConstant) {
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalLogicalOr(Boolean left, Boolean right, boolean compileTimeConstant) {
		return new EvaluationResult(left || right, compileTimeConstant)
	}
	
	def dispatch EvaluationResult internalLogicalOr(Boolean left, Object right, boolean compileTimeConstant) {
		if (left) {
			return new EvaluationResult(Boolean.TRUE, compileTimeConstant)
		}
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalLogicalOr(Boolean left, Void right, boolean compileTimeConstant) {
		if (left) {
			return new EvaluationResult(Boolean.TRUE, compileTimeConstant)
		}
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalLogicalOr(Object left, Boolean right, boolean compileTimeConstant) {
		if (right) {
			return new EvaluationResult(Boolean.TRUE, compileTimeConstant)
		}
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalLogicalOr(Void left, Boolean right, boolean compileTimeConstant) {
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalEvaluate(XCastedExpression expression, IResolvedTypes resolvedTypes) {
		return internalEvaluate(expression.target, resolvedTypes)
	}

	def dispatch EvaluationResult internalEvaluate(XStringLiteral it, IResolvedTypes resolvedTypes) {
		return new EvaluationResult(value, true)
	}

	def dispatch EvaluationResult internalEvaluate(XBooleanLiteral it, IResolvedTypes resolvedTypes) {
		return new EvaluationResult(isTrue, true)
	}

	def dispatch EvaluationResult internalEvaluate(XTypeLiteral it, IResolvedTypes resolvedTypes) {
		return new EvaluationResult(it, true)
	}

}

@Data
package class EvaluationResult {
	
	protected static final EvaluationResult NOT_A_CONSTANT = new EvaluationResult(new Object(), false) {
		override equalValue(EvaluationResult other) {
			return false
		}
	}
	
	Object value
	boolean compileTimeConstant
	
	def boolean equalValue(EvaluationResult other) {
		return equalValue(value, other.value)
	}
	
	private def dispatch boolean equalValue(Object myValue, Object otherValue) {
		return myValue == otherValue
	}
	private def dispatch boolean equalValue(Void myValue, Object otherValue) {
		return false
	}
	private def dispatch boolean equalValue(Void myValue, Void otherValue) {
		return true
	}
	private def dispatch boolean equalValue(Object myValue, Void otherValue) {
		return false
	}
	private def dispatch boolean equalValue(XTypeLiteral myValue, XTypeLiteral otherTypeLiteral) {
		return myValue.type == otherTypeLiteral.type && myValue.arrayDimensions == otherTypeLiteral.arrayDimensions
	}
	private def dispatch boolean equalValue(JvmType myValue, XTypeLiteral otherTypeLiteral) {
		return myValue == otherTypeLiteral.type && otherTypeLiteral.arrayDimensions.empty
	}
	private def dispatch boolean equalValue(XTypeLiteral myValue, JvmType otherType) {
		return myValue.type == otherType && myValue.arrayDimensions.empty
	}
}

@Data
class BooleanResult {
	@Accessors(NONE) // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=440625
	Boolean value
	boolean compileTimeConstant
	
	def Optional<Boolean> getValue() {
		return Optional.fromNullable(value)
	}
}