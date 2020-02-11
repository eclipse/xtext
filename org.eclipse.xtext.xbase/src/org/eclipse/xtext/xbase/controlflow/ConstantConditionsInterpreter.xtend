/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.controlflow

import com.google.common.base.Optional
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.ArrayList
import java.util.List
import java.util.Map
import java.util.Stack
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.resource.Resource
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
import org.eclipse.xtext.resource.persistence.StorageAwareResource
import org.eclipse.xtext.xbase.validation.ConstantExpressionValidator
import org.eclipse.xtext.xbase.XbasePackage

/**
 * Interpreter for expressions at development time that uses the static linking
 * information and hardcoded logic to apply binary operations on well known types. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Accessors(PROTECTED_GETTER)
class ConstantConditionsInterpreter {
	
	@Inject ILogicalContainerProvider logicalContainerProvider

	@Inject extension NumberLiterals numberLiterals
	
	@Inject ConstantOperators constantOperators
	
	@Accessors(NONE)
	@Inject Provider<EvaluationContext> evaluationContextProvider

	def BooleanResult getBooleanConstantOrNull(XExpression it) {
		try {
			val evaluationResult = doEvaluate(newEvaluationContext())
			if (evaluationResult.rawValue instanceof Boolean) {
				return new BooleanResult(evaluationResult.rawValue as Boolean, evaluationResult.compileTimeConstant)
			}
			return null
		} catch (ConstantExpressionEvaluationException e) {
			return null
		} catch (IllegalArgumentException e) {
			return null
		}
	}
	
	def EvaluationContext newEvaluationContext() {
		evaluationContextProvider.get
	}
	
	protected def EvaluationResult doEvaluate(XExpression expression, EvaluationContext context) {
		if (context.tryNext(expression)) {
			try {
				return internalEvaluate(expression, context)
			} finally {
				context.done(expression)
			}
		} else {
			return EvaluationResult.NOT_A_CONSTANT
		}
	}
	
	def IConstantEvaluationResult<Object> evaluate(XExpression expression, EvaluationContext context) {
		return expression.doEvaluate(context)
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
		val feature = getFeature(it, context)
		if (feature === null || feature.eIsProxy) {
			return EvaluationResult.NOT_A_CONSTANT
		}
		switch feature {
			JvmType case !typeLiteral: {
				return new EvaluationResult(new ThisReference(feature), false)
			}
			JvmType,
			JvmEnumerationLiteral: {
				return new EvaluationResult(feature, false)
			}
			JvmField: {
				if (feature.setConstant) {
					if (feature.constant) {
						return new EvaluationResult(feature.constantValue, true)
					}
				} else if (feature.final) {
					if (actualReceiver !== null) {
						val receiver = doEvaluate(actualReceiver, context)
						if (receiver.notAConstant) {
							return receiver
						}
						val associatedExpression = feature.associatedExpression
						if (associatedExpression !== null) {
							val result = associatedExpression.evaluateAssociatedExpression(context)
							if (result.rawValue instanceof ThisReference)
								return EvaluationResult.NOT_A_CONSTANT
							return new EvaluationResult(result.rawValue, false)
						} else {
							val list = switch v: receiver.rawValue {
								JvmIdentifiableElement,
								ThisReference: <Object>newArrayList(v)
								List<Object>: new ArrayList(v)
								default: throw new IllegalStateException('''Invalid rawValue: «receiver.rawValue»''')
							}
							list.add(feature)
							return new EvaluationResult(list, false)
						}
					} else {
						val associatedExpression = feature.associatedExpression
						if (associatedExpression !== null) {
							val result = associatedExpression.evaluateAssociatedExpression(context)
							return new EvaluationResult(result.rawValue, false)
						} else {
							return new EvaluationResult(newArrayList(feature), false)
						}
					}
				}
			}
			XVariableDeclaration case !feature.writeable && feature.right !== null: {
				return feature.right.evaluateAssociatedExpression(context)
			}
			JvmFormalParameter: {
				switch container : feature.eContainer {
					XSwitchExpression case container.^switch !== null: {
						return container.^switch.doEvaluate(context)
					}
					default: return new EvaluationResult(feature, false)
				}
			}
		}
		return EvaluationResult.NOT_A_CONSTANT
	}
	
	def getFeature(XAbstractFeatureCall call, EvaluationContext context) {
		var feature = call.eGet(XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, false) as JvmIdentifiableElement
		if (feature === null || feature.eIsProxy) {
			feature = context.resolvedTypes.getLinkedFeature(call)
		}
		return feature
	}
	
	def XExpression getAssociatedExpression(JvmField field) {
		val resource = field.eResource
		if (resource instanceof StorageAwareResource) {
			if (resource.isLoadedFromStorage) {
				return null
			}
		}
		return logicalContainerProvider.getAssociatedExpression(field)
	}
	
	def EvaluationResult evaluateAssociatedExpression(XExpression it, EvaluationContext context) {
		switch it {
			XAbstractFeatureCall case feature instanceof JvmEnumerationLiteral: {
				val arg = doEvaluate(context);
				return new EvaluationResult(arg.rawValue, false)
			}
			default: doEvaluate(context)
		}
	}
	
	def dispatch EvaluationResult internalEvaluate(XNullLiteral it, EvaluationContext context) {
		return new EvaluationResult(null, true)
	}
	
	def private boolean isFromXbaseLibrary(XAbstractFeatureCall it, EvaluationContext context) {
		val feature = getFeature(it, context)
		switch feature {
			JvmMember: feature?.declaringType?.packageName == XImportSectionNamespaceScopeProvider.XBASE_LIB.toString
			default: false
		}
	}
	
	def dispatch EvaluationResult internalEvaluate(XUnaryOperation it, EvaluationContext context) {
		if (isFromXbaseLibrary(context)) {
			val arg = operand.doEvaluate(context)
			val op = concreteSyntaxFeatureName
			switch op {
				case '-': try {
					val result = constantOperators.minus(arg.rawValue)
					return new EvaluationResult(result, arg.compileTimeConstant)
				} catch(ConstantExpressionEvaluationException e) {
					return EvaluationResult.NOT_A_CONSTANT
				}
				case op=='!' && arg.rawValue instanceof Boolean: new EvaluationResult(!(arg.rawValue as Boolean), arg.compileTimeConstant)
				case op=='+' && arg.rawValue instanceof Number: arg
				default: EvaluationResult.NOT_A_CONSTANT
			}
		} else {
			return EvaluationResult.NOT_A_CONSTANT
		}
	}
	
	def dispatch EvaluationResult internalEvaluate(XBinaryOperation it, EvaluationContext context) {
		if (isFromXbaseLibrary(context) && rightOperand !== null) {
			val left = leftOperand.doEvaluate(context) 
			val right = rightOperand.doEvaluate(context)
			try {
				val op = concreteSyntaxFeatureName
				val value = switch op {
					case '+': constantOperators.plus(left.rawValue, right.rawValue)
					case '-': constantOperators.minus(left.rawValue, right.rawValue)
					case '*': constantOperators.multiply(left.rawValue, right.rawValue)
					case '/': constantOperators.divide(left.rawValue, right.rawValue)
					case '%': constantOperators.modulo(left.rawValue, right.rawValue)
					case '<<': constantOperators.shiftLeft(left.rawValue, right.rawValue)
					case '>>': constantOperators.shiftRight(left.rawValue, right.rawValue)
					case '>>>': constantOperators.shiftRightUnsigned(left.rawValue, right.rawValue)
					case '<': constantOperators.lessThan(left.rawValue, right.rawValue)
					case '>': constantOperators.greaterThan(left.rawValue, right.rawValue)
					case '<=': constantOperators.lessEquals(left.rawValue, right.rawValue)
					case '>=': constantOperators.greaterEquals(left.rawValue, right.rawValue)
					case '&&': return internalLogicalAnd(left.rawValue, right.rawValue, left.compileTimeConstant && right.compileTimeConstant)
					case '||': return internalLogicalOr(left.rawValue, right.rawValue, left.compileTimeConstant && right.compileTimeConstant)
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
		return doEvaluate(expression.target, context)
	}

	def dispatch EvaluationResult internalEvaluate(XStringLiteral it, EvaluationContext context) {
		return new EvaluationResult(value, true)
	}

	def dispatch EvaluationResult internalEvaluate(XBooleanLiteral it, EvaluationContext context) {
		return new EvaluationResult(isTrue, true)
	}

	def dispatch EvaluationResult internalEvaluate(XTypeLiteral it, EvaluationContext context) {
		return new EvaluationResult(it, false)
	}

}

/**
 * @author Sebastian Zarnekow - Initial API and implementation
 */
class EvaluationContext {
	@Inject IBatchTypeResolver typeResolver
	RecursionGuard<EObject> visiting = new RecursionGuard
	Map<Resource, IResolvedTypes> resolvedTypesPerResource = newHashMap
	Stack<IResolvedTypes> resolvedTypesStack = new Stack
	def tryNext(XExpression expression) {
		if (visiting.tryNext(expression)) {
			expression.resolveTypes
			return true
		}
		return false
	}
	def void addResolvedTypes(Resource resource, IResolvedTypes resolvedTypes) {
		resolvedTypesPerResource.put(resource, resolvedTypes)
	}
	private def void resolveTypes(XExpression expression) {
		val resource = expression.eResource
		var resolvedTypes = resolvedTypesPerResource.get(resource)
		if (resolvedTypes === null) {
			resolvedTypes = typeResolver.resolveTypes(expression)
			resolvedTypesPerResource.put(resource, resolvedTypes)
		}
		resolvedTypesStack.push(resolvedTypes)
	}
	def getResolvedTypes() {
		resolvedTypesStack.peek
	}
	def void done(XExpression expression) {
		resolvedTypesStack.pop
		visiting.done(expression)
	}
	
}

@Data
class ThisReference {
	JvmType type
}

@Data
package class EvaluationResult implements IConstantEvaluationResult<Object> {
	
	protected static final EvaluationResult NOT_A_CONSTANT = new EvaluationResult(new Object(), false) {
		override equalValue(EvaluationResult other) {
			return false
		}
	}
	
	Object rawValue
	boolean compileTimeConstant
	
	def boolean isNotAConstant() {
		return rawValue == NOT_A_CONSTANT.rawValue
	}
	
	override Optional<Object> getValue() {
		return Optional.fromNullable(rawValue)
	}
	
	def Object equalValue(EvaluationResult other) {
		return equalValue(rawValue, other.rawValue)
	}
	
	private def dispatch Object equalValue(Object myValue, Object otherValue) {
		return myValue == otherValue
	}
	private def dispatch Object equalValue(Void myValue, Object otherValue) {
		return false
	}
	private def dispatch Object equalValue(Object myValue, JvmIdentifiableElement otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(Object myValue, ThisReference otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(ThisReference myValue, Object otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(ThisReference myValue, ThisReference otherValue) {
		return myValue == otherValue
	}
	private def dispatch Object equalValue(Void myValue, JvmIdentifiableElement otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(Object myValue, List<?> otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(Void myValue, List<?> otherValue) {
		return NOT_A_CONSTANT.rawValue
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
	private def dispatch Object equalValue(JvmType myValue, JvmIdentifiableElement otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(JvmIdentifiableElement myValue, Void otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(JvmIdentifiableElement myValue, JvmType otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(JvmIdentifiableElement myValue, Object otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(List<?> myValue, Void otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(List<?> myValue, Object otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(List<?> myValue, List<?> otherValue) {
		val equalLists = myValue == otherValue
		if (equalLists) {
			return Boolean.TRUE
		}
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(JvmIdentifiableElement myValue, JvmIdentifiableElement otherValue) {
		return myValue == otherValue
	}
	private def dispatch Object equalValue(JvmFormalParameter myValue, JvmFormalParameter otherValue) {
		if (myValue == otherValue) {
			return Boolean.TRUE
		}
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(JvmEnumerationLiteral myValue, JvmIdentifiableElement otherValue) {
		return NOT_A_CONSTANT.rawValue
	}
	private def dispatch Object equalValue(JvmIdentifiableElement myValue, JvmEnumerationLiteral otherValue) {
		return NOT_A_CONSTANT.rawValue
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

/**
 * Represents a result of the {@link ConstantExpressionValidator}.
 * It carries the information if the result is a constant expression and 
 * it may also have information about the computed value of an expression.
 * The value may be null, which indicates that it could not be computed. Or it may be 
 * {@link Optional#absent()} if it was computed to be the literal value {@code null}. 
 */
interface IConstantEvaluationResult<T> {
	/**
	 * Returns the optional computation result. If the result is null, no value could be
	 * computed.
	 */
	def Optional<T> getValue()
	def boolean isCompileTimeConstant()
}

@Data
class BooleanResult implements IConstantEvaluationResult<Boolean> {
	@Accessors(NONE)
	Boolean value
	boolean compileTimeConstant
	
	override Optional<Boolean> getValue() {
		return Optional.fromNullable(value)
	}
}
