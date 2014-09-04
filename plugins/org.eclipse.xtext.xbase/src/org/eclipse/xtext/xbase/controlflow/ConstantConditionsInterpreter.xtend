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
import java.util.ArrayList
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XCastedExpression
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
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard

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
			val context = new EvaluationContext(resolvedTypes, new RecursionGuard)
			val evaluationResult = evaluate(context)
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
	
	def EvaluationResult evaluate(XExpression expression, EvaluationContext context) {
		if (context.visiting.tryNext(expression)) {
			try {
				return internalEvaluate(expression, context)
			} finally {
				context.visiting.done(expression)
			}
		} else {
			return EvaluationResult.NOT_A_CONSTANT
		}
	}
	
	def dispatch EvaluationResult internalEvaluate(XExpression expression, EvaluationContext context) {
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def dispatch EvaluationResult internalEvaluate(Void nullValue, EvaluationContext context) {
		throw new ConstantExpressionEvaluationException("null")
	}

	def dispatch EvaluationResult internalEvaluate(XNumberLiteral it, EvaluationContext context) {
		val value = numberValue(javaType)
		return new EvaluationResult(value, context.resolvedTypes.getActualType(it).primitive)
	}

	def dispatch EvaluationResult internalEvaluate(XAbstractFeatureCall it, EvaluationContext context) {
		val feature = it.feature
		if (feature.eIsProxy) {
			return EvaluationResult.NOT_A_CONSTANT
		}
		switch feature {
			JvmType case !typeLiteral: {
				return new EvaluationResult(new ThisReference(feature), false)
			}
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
					if (actualReceiver != null) {
						val receiver = evaluate(actualReceiver, context)
						if (receiver.notAConstant) {
							return receiver
						}
						val associatedExpression = feature.associatedExpression
						if (associatedExpression != null) {
							val result = associatedExpression.evaluateAssociatedExpression(context)
							if (result.value instanceof ThisReference)
								return EvaluationResult.NOT_A_CONSTANT
							return new EvaluationResult(result.value, false)
						} else {
							val list = switch v: receiver.value {
								JvmIdentifiableElement,
								ThisReference: <Object>newArrayList(v)
								List<Object>: new ArrayList(v)
							}
							list.add(feature)
							return new EvaluationResult(list, false)
						}
					} else {
						val associatedExpression = feature.associatedExpression
						if (associatedExpression != null) {
							val result = associatedExpression.evaluateAssociatedExpression(context)
							return new EvaluationResult(result.value, false)
						} else {
							return new EvaluationResult(newArrayList(feature), false)
						}
					}
				}
			}
			XVariableDeclaration case !feature.writeable && feature.right != null: {
				return feature.right.evaluateAssociatedExpression(context)
			}
			JvmFormalParameter: {
				switch container : feature.eContainer {
					XSwitchExpression case container.^switch != null: {
						return container.^switch.evaluate(context)
					}
					default: return new EvaluationResult(feature, false)
				}
			}
		}
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def EvaluationResult evaluateAssociatedExpression(XExpression it, EvaluationContext context) {
		switch it {
			XAbstractFeatureCall case feature instanceof JvmEnumerationLiteral: {
				val arg = evaluate(context);
				return new EvaluationResult(arg.value, false)
			}
			default: evaluate(context)
		}
	}
	
	def dispatch EvaluationResult internalEvaluate(XNullLiteral it, EvaluationContext context) {
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
	
	def dispatch EvaluationResult internalEvaluate(XUnaryOperation it, EvaluationContext context) {
		if (isFromXbaseLibrary) {
			val arg = operand.evaluate(context)
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
	
	def dispatch EvaluationResult internalEvaluate(XBinaryOperation it, EvaluationContext context) {
		if (isFromXbaseLibrary) {
			val left = leftOperand.evaluate(context) 
			val right = rightOperand.evaluate(context)
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
					case '===': {
						if (left.notAConstant || right.notAConstant) {
							return EvaluationResult.NOT_A_CONSTANT
						}
						return new EvaluationResult(left.equalValue(right), left.compileTimeConstant && right.compileTimeConstant)
					}
					case '!=', 
					case '!==': {
						if (left.notAConstant || right.notAConstant) {
							return EvaluationResult.NOT_A_CONSTANT
						}
						val result = left.equalValue(right)
						switch(result) {
							Boolean: return new EvaluationResult(!result, left.compileTimeConstant && right.compileTimeConstant)
							default: return new EvaluationResult(result, left.compileTimeConstant && right.compileTimeConstant)
						}
					}
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
	
	def dispatch EvaluationResult internalEvaluate(XCastedExpression expression, EvaluationContext context) {
		return evaluate(expression.target, context)
	}

	def dispatch EvaluationResult internalEvaluate(XStringLiteral it, EvaluationContext context) {
		return new EvaluationResult(value, true)
	}

	def dispatch EvaluationResult internalEvaluate(XBooleanLiteral it, EvaluationContext context) {
		return new EvaluationResult(isTrue, true)
	}

	def dispatch EvaluationResult internalEvaluate(XTypeLiteral it, EvaluationContext context) {
		return new EvaluationResult(it, true)
	}

}

@Data
class EvaluationContext {
	IResolvedTypes resolvedTypes
	RecursionGuard<EObject> visiting
}

@Data
class ThisReference {
	JvmType type
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
	
	def boolean isNotAConstant() {
		return value == NOT_A_CONSTANT.value
	}
	
	def Object equalValue(EvaluationResult other) {
		return equalValue(value, other.value)
	}
	
	private def dispatch Object equalValue(Object myValue, Object otherValue) {
		return myValue == otherValue
	}
	private def dispatch Object equalValue(Void myValue, Object otherValue) {
		return false
	}
	private def dispatch Object equalValue(Object myValue, JvmIdentifiableElement otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(Object myValue, ThisReference otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(ThisReference myValue, Object otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(ThisReference myValue, ThisReference otherValue) {
		return myValue == otherValue
	}
	private def dispatch Object equalValue(Void myValue, JvmIdentifiableElement otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(Object myValue, List<?> otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(Void myValue, List<?> otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(Void myValue, JvmType otherValue) {
		return false
	}
	private def dispatch Object equalValue(Void myValue, Void otherValue) {
		return true
	}
	private def dispatch Object equalValue(Object myValue, Void otherValue) {
		return false
	}
	private def dispatch Object equalValue(JvmIdentifiableElement myValue, Void otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(JvmIdentifiableElement myValue, Object otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(List<?> myValue, Void otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(List<?> myValue, Object otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(List<?> myValue, List<?> otherValue) {
		return myValue == otherValue
	}
	private def dispatch Object equalValue(JvmIdentifiableElement myValue, JvmIdentifiableElement otherValue) {
		return myValue == otherValue
	}
	private def dispatch Object equalValue(JvmFormalParameter myValue, JvmFormalParameter otherValue) {
		if (myValue == otherValue) {
			return Boolean.TRUE
		}
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(JvmEnumerationLiteral myValue, JvmIdentifiableElement otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(JvmIdentifiableElement myValue, JvmEnumerationLiteral otherValue) {
		return NOT_A_CONSTANT.value
	}
	private def dispatch Object equalValue(JvmEnumerationLiteral myValue, JvmEnumerationLiteral otherValue) {
		return myValue == otherValue
	}
	private def dispatch Object equalValue(JvmType myValue, Void otherValue) {
		return false
	}
	private def dispatch Object equalValue(XTypeLiteral myValue, XTypeLiteral otherTypeLiteral) {
		return myValue.type == otherTypeLiteral.type && myValue.arrayDimensions == otherTypeLiteral.arrayDimensions
	}
	private def dispatch Object equalValue(JvmType myValue, XTypeLiteral otherTypeLiteral) {
		return myValue == otherTypeLiteral.type && otherTypeLiteral.arrayDimensions.empty
	}
	private def dispatch Object equalValue(XTypeLiteral myValue, JvmType otherType) {
		return myValue.type == otherType && myValue.arrayDimensions.empty
	}
	private def dispatch Object equalValue(JvmType myValue, ThisReference otherValue) {
		return false
	}
	private def dispatch Object equalValue(ThisReference myValue, JvmType otherValue) {
		return false
	}
	private def dispatch Object equalValue(XTypeLiteral myValue, ThisReference otherType) {
		return false
	}
	private def dispatch Object equalValue(ThisReference myValue, XTypeLiteral otherType) {
		return false
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