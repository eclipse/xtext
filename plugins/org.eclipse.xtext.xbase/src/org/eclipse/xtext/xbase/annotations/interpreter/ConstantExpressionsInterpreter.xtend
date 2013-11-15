package org.eclipse.xtext.xbase.annotations.interpreter

import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.xbase.XBinaryOperation
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XListLiteral
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference

class ConstantExpressionsInterpreter {
	
	/**
	 * Very limited poor-man's interpreter for annotation values.
	 * 
	 * for type literals it returns the JvmType
	 * for nested annotations it returns the XAnnotation
	 * 
	 * @param expression the expression to be evaluated
	 * @param expectedType the expected type, or <code>null</code> if no type expectation exists.
	 */
	def Object evaluate(XExpression expression, LightweightTypeReference expectedType) {
		switch expression {
			XStringLiteral : {
				if (expectedType?.simpleName=='char')
					expression.value.charAt(0)
				expression.value
			}
			XBooleanLiteral : expression.isTrue
			XNumberLiteral : {
				switch expectedType {
					case expectedType?.simpleName == 'long' : Long.valueOf(expression.value) 
					case expectedType?.simpleName == 'short' : Short.valueOf(expression.value) 
					case expectedType?.simpleName == 'byte' : Byte.valueOf(expression.value) 
					case expectedType?.simpleName == 'float' : Float.valueOf(expression.value) 
					case expectedType?.simpleName == 'double' : Double.valueOf(expression.value) 
					default: Integer.valueOf(expression.value) 
				}
			}
			// arrays?
			XTypeLiteral : expression.type
			XAnnotation : expression
			XListLiteral : {
				val results = expression.elements.map[evaluate(it, null)]
				switch (results.head) {
					String : {
						val String[] array = newArrayOfSize(results.size)
						results.toArray(array)
					}
					JvmType : {
						val JvmType[] array = newArrayOfSize(results.size)
						results.toArray(array)
					}
					Integer : {
						val Integer[] array = newArrayOfSize(results.size)
						results.toArray(array)
					}
				}
			}
			XBinaryOperation : {
				val leftVal = evaluate(expression.leftOperand, null)
				val rightVal = evaluate(expression.rightOperand, null)
				return leftVal.plus(rightVal)
			}
			default : throw new IllegalArgumentException("Couldn't interpret expression : "+expression+".")
		}
	} 
	
	def dispatch plus(Object a, Object b) {
		throw new IllegalArgumentException('was left:'+a+', right:'+b)
	}
	def dispatch plus(Integer a, Integer b) {
		a + b
	}
	def dispatch plus(String a, Object b) {
		a + b
	}
}