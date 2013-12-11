/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro

import com.google.inject.Inject
import java.util.Map
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmArrayType
import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmMember
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeReference
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.common.types.access.TypeResource
import org.eclipse.xtext.common.types.access.impl.ClassFinder
import org.eclipse.xtext.naming.IQualifiedNameConverter
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.scoping.IScopeProvider
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XListLiteral
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.XUnaryOperation
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.imports.IImportsConfiguration
import org.eclipse.xtext.xbase.jvmmodel.ILogicalContainerProvider
import org.eclipse.xtext.xbase.lib.Conversions
import org.eclipse.xtext.xbase.typesystem.computation.NumberLiterals
import org.eclipse.xtext.xtype.XComputedTypeReference
import java.util.Set
import java.util.LinkedHashSet
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.xbase.XCastedExpression

/**
 * An interpreter for evaluating constant expressions in annotation values.
 * 
 * @author Sven Efftinge
 */
class ConstantExpressionsInterpreter {

	@Inject ILogicalContainerProvider containerProvider

	@Inject ProcessorInstanceForJvmTypeProvider classLoaderProvider

	@Inject extension NumberLiterals numberLiterals

	@Inject ConstantOperators constantOperators

	@Inject IScopeProvider scopeProvider

	@Inject IImportsConfiguration importSectionLocator

	@Inject IQualifiedNameConverter qualifiedNameConverter
	
	public def Object evaluate(XExpression expression, JvmTypeReference expectedType) {
		val classLoader = classLoaderProvider.getClassLoader(expression)
		val visibleFeatures = findVisibleFeatures(expression)
		val result = internalEvaluate(expression, 
			new Context(
				(if (expectedType instanceof XComputedTypeReference) null else expectedType), 
				new ClassFinder(classLoader), visibleFeatures,
				newLinkedHashSet()
			)
		)
		return result
	}
	
	/**
	 * looks up the static final fields which are accessible in unqualified form for the given expression.
	 * That essentially includes static imports and the fields declared in the containing types
	 */
	protected def Map<String, JvmIdentifiableElement> findVisibleFeatures(XExpression expression) {
		val result = newHashMap

		val section = importSectionLocator.getImportSection(expression.eResource as XtextResource)
		if(section != null) {
			for (imp : section.importDeclarations) {
				if(imp.static) {
					val type = imp.findTypeByName(imp.importedTypeName)
					switch type {
						JvmGenericType: {

							// add constant field
							for (feature : type.allFeatures.filter(JvmField).filter[static && final]) {
								result.put(feature.simpleName, feature)
							}
						}
						JvmEnumerationType: {

							// add enum values
							for (feature : type.literals) {
								result.put(feature.simpleName, feature)
							}
						}
					}
				}
			}
		}

		var container = switch cont : containerProvider.getNearestLogicalContainer(expression) {
			JvmGenericType: {
				cont
			}
			JvmMember: {
				cont.declaringType
			}
		}
		while (container != null) {
			for (feature : container.allFeatures.filter(JvmField).filter[static && final]) {
				result.put(feature.simpleName, feature)
			}
			container = container.declaringType
		}
		return result
	}
	
	protected def JvmType findTypeByName(EObject context, String qualifiedName) {
		val scope = scopeProvider.getScope(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
		val qn = qualifiedNameConverter.toQualifiedName(qualifiedName)
		return scope.getSingleElement(qn)?.getEObjectOrProxy as JvmType
	}

	def dispatch Object internalEvaluate(XExpression expression, Context ctx) {
		throw new ConstantExpressionEvaluationException("Not a constant expression : '" + expression.toText + "'", expression)
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

	def dispatch Object internalEvaluate(XNumberLiteral it, Context ctx) {
		val type = if (ctx.expectedType == null) 
			javaType
		else 
			getJavaType(ctx.expectedType.type,ctx.classFinder) as Class<? extends Number>
		
		numberValue(type)
	}

	def dispatch Object internalEvaluate(XTypeLiteral it, Context ctx) {
		toTypeReference(type, arrayDimensions.size)
	}

	def dispatch Object internalEvaluate(XAnnotation literal, Context ctx) {
		literal
	}

	def dispatch Object internalEvaluate(XListLiteral it, Context ctx) {
		val expectedComponentType = switch exp : ctx.expectedType {
			JvmGenericArrayTypeReference : {
				exp.componentType
			}
		}
		val elements = it.elements.map[
			internalEvaluate(ctx.cloneWithExpectation(expectedComponentType))
		]
		val Class<?> componentType = if (expectedComponentType != null) {
				expectedComponentType.type.getJavaType(ctx.classFinder)
			} else if(!elements.empty) {
				switch cl : elements.head.class {
					case Integer : Integer.TYPE 
					case Long : Long.TYPE 
					case Short : Short.TYPE 
					case Boolean : Boolean.TYPE 
					case Double : Double.TYPE 
					case Byte : Byte.TYPE 
					case Float: Float.TYPE
					default : cl
				}
			} else {
				Object
			}
		return Conversions.unwrapArray(elements, componentType)
	}

	def dispatch Object internalEvaluate(XFeatureCall it, Context ctx) {
		val featureName = concreteSyntaxFeatureName
		if (ctx.visibleFeatures.containsKey(featureName)) {
			return switch feature : ctx.visibleFeatures.get(featureName) {
				JvmEnumerationLiteral : {
					feature
				}
				JvmField : {
					evaluateField(it, feature, ctx)
				}
			}
		}
		val type = findTypeByName(featureName)
		if (type != null) {
			return toTypeReference(type,0)
		}
		throw new UnresolvableFeatureException("Couldn't resolve feature "+featureName, it)
	}

	def dispatch Object internalEvaluate(XMemberFeatureCall it, Context ctx) {
		val featureName = concreteSyntaxFeatureName
		try {
			val receiver = internalEvaluate(memberCallTarget, ctx)
			switch receiver {
				JvmTypeReference : {
					switch type : receiver.type {
						JvmEnumerationType : {
							val enumValue = type.literals.findFirst[simpleName==featureName]
							if (enumValue == null) {
								throw new ConstantExpressionEvaluationException("Couldn't find enum value "+featureName+" on enum "+receiver.simpleName, it)
							}
							return enumValue
						}
						JvmGenericType : {
							val field = type.allFeatures.filter(JvmField).findFirst[simpleName==featureName]
							if (field == null) {
								throw new ConstantExpressionEvaluationException("Couldn't find field "+featureName+" on type "+receiver.simpleName, it)
							}
							return evaluateField(it,field, ctx)
						}
					}
				}
			}
			throw new UnresolvableFeatureException("Unresolvable feature "+featureName+" on "+receiver, it) 
		} catch (UnresolvableFeatureException e) {
			val typeName = fullName
			val type = findTypeByName(typeName)
			if (type != null) {
				return toTypeReference(type, 0)
			} else {
				throw new UnresolvableFeatureException("Unresolvable type "+typeName, it)
			}
		}
	}
	
	def dispatch String getFullName(XExpression call) {
		throw new ConstantExpressionEvaluationException("The expression '"+call.toText+"' cannot be used as a receiver within a constant expression.")
	}
	
	def dispatch String getFullName(XMemberFeatureCall call) {
		val prefix = call.memberCallTarget.fullName
		return prefix+'.'+call.concreteSyntaxFeatureName
	}
	
	def dispatch String getFullName(XFeatureCall call) {
		call.concreteSyntaxFeatureName
	}
	
	protected def evaluateField(XAbstractFeatureCall call, JvmField field, Context context) {
		if (field.eResource instanceof TypeResource) {
			val clazz = getJavaType(field.declaringType, context.classFinder)
			return clazz.getField(field.simpleName)?.get(null)
		}
		val expression = containerProvider.getAssociatedExpression(field)
		if (context.alreadyEvaluating.contains(expression)) {
			throw new ConstantExpressionEvaluationException("Endless recursive evaluation detected.")
		}
		try {
			val visibleFeatures = findVisibleFeatures(expression)
			val set = new LinkedHashSet<XExpression>(context.alreadyEvaluating)
			set.add(expression)
			val ctx = new Context(field.type, context.classFinder, visibleFeatures, set)
			return internalEvaluate(expression, ctx)
		} catch (ConstantExpressionEvaluationException e) {
			throw new StackedConstantExpressionEvaluationException(call, field, e)
		}
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
			case '==': throw new ConstantExpressionEvaluationException("Please use the identity comparison operator '===' in constant expressions.")
			case '!=': throw new ConstantExpressionEvaluationException("Please use the identity comparison operator '!==' in constant expressions.")
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

	protected def Class<?> getJavaType(JvmType type, ClassFinder classFinder) throws ClassNotFoundException {
		if (type instanceof JvmArrayType) {
			var JvmType t = type
			var String dimensions = '' 
			while (t instanceof JvmArrayType) {
				dimensions = dimensions + '[]'
				t = (t as JvmArrayType).componentType
			}
			val componentClass = getJavaType(t, classFinder)
			return classFinder.forName(componentClass.name+dimensions)
		}
		if(type.identifier == 'java.lang.Class') {
			return JvmTypeReference
		}
		if(type instanceof JvmEnumerationType) {
			return JvmEnumerationLiteral
		}
		if(type instanceof JvmAnnotationType) {
			return XAnnotation
		}
		return classFinder.forName(type.identifier)
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
