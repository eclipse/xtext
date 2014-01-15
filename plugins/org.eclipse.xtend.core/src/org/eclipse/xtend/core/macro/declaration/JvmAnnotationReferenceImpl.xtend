/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.declaration.AnnotationReference
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend.lib.macro.expression.Expression
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException

import static org.eclipse.xtend.core.macro.ConditionUtils.*
import org.eclipse.xtext.common.types.JvmOperation
import com.google.common.collect.Iterators

class JvmAnnotationReferenceImpl extends JvmElementImpl<JvmAnnotationReference> implements MutableAnnotationReference {
	
	override getAnnotationTypeDeclaration() {
		compilationUnit.toTypeDeclaration(delegate.annotation) as AnnotationTypeDeclaration
	}
	
	override getExpression(String property) {
		val op = findOperation(property)
		val annotationValue = delegate.values.findFirst[ operation == op || (operation == null && op.simpleName == 'value') ]
		switch annotationValue {
			JvmCustomAnnotationValue : {
				return compilationUnit.toExpression(annotationValue.values.head as XExpression)
			}
		}
		return null
	}
	
	override getValue(String property) {
		try {
			val op = findOperation(property)
			val annotationValue = delegate.values.findFirst[ operation == op || (operation == null && op.simpleName == 'value') ]
			val isArrayType = op!=null && compilationUnit.typeReferences.isArray(op.returnType)
			if (annotationValue != null)
				return compilationUnit.translateAnnotationValue(annotationValue, isArrayType)
		} catch (ConstantExpressionEvaluationException e) {
			compilationUnit.problemSupport.addError(this, e.getMessage)
		}
		return null
	}
	
	override set(String name, Object value) {
		internalSet(name, value)
	}
	
	def dispatch void internalSet(String name, Void value) {
		remove(name)
	}
	
	def dispatch void internalSet(String name, Object values) {
		throw new IllegalArgumentException("Cannot set annotation values of type "+values.class.name) 
	}
	
	def dispatch void internalSet(String name, String value) {
		val String[] arr = #[value]
		_internalSet(name, arr)
	}
	
	def dispatch void internalSet(String name, String[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmStringAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Boolean value) {
		val boolean[] arr = #[value.booleanValue]
		_internalSet(name, arr)
	}
	
	def dispatch void internalSet(String name, boolean[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Integer value) {
		val int[] arr = #[value.intValue]
		_internalSet(name, arr)
	}
	
	def dispatch void internalSet(String name, int[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmIntAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Short value) {
		val short[] arr = #[value.shortValue]
		_internalSet(name, arr)
	}
	
	def dispatch void internalSet(String name, short[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmShortAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Long value) {
		val long[] arr = #[value.longValue]
		_internalSet(name, arr)
	}
	
	def dispatch void internalSet(String name, long[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmLongAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Double value) {
		val double[] arr = #[value.doubleValue]
		_internalSet(name, arr)
	}
	
	def dispatch void internalSet(String name, double[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Float value) {
		val float[] arr = #[value.floatValue]
		_internalSet(name, arr)
	}
	
	def dispatch void internalSet(String name, float[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Character value) {
		val char[] arr = #[value.charValue]
		_internalSet(name, arr)
	}
	
	def dispatch void internalSet(String name, char[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmCharAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Byte value) {
		val byte[] arr = #[value.byteValue]
		_internalSet(name, arr)
	}
	
	def dispatch void internalSet(String name, byte[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmByteAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, TypeReference value) {
		_internalSet(name, #[value])
	}
	
	def dispatch void internalSet(String name, TypeReference[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmTypeAnnotationValue
		newValue.setOperation(op)
		values.forEach[
			switch it {
				TypeReferenceImpl : {
					newValue.values += compilationUnit.toJvmTypeReference(it)
				}
			}
		]
		
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, EnumerationValueDeclaration value) {
		_internalSet(name, #[value])
	}
	
	def dispatch void internalSet(String name, EnumerationValueDeclaration[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue
		newValue.setOperation(op)
		values.forEach[
			switch it {
				JvmEnumerationValueDeclarationImpl : {
					newValue.values.add(delegate)
				}
				XtendEnumerationValueDeclarationImpl : {
					throw new IllegalArgumentException("Cannot set source elements.")
				}
			}
		]
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, XtendAnnotationReferenceImpl value) {
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmCustomAnnotationValue
		newValue.setOperation(op)
		newValue.values.add(value.delegate)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, ExpressionImpl value) {
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmCustomAnnotationValue
		newValue.setOperation(op)
		newValue.values.add(value.delegate)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, AnnotationReference value) {
		_internalSet(name, #[value])
	}
	
	def dispatch void internalSet(String name, AnnotationReference[] values) {
		checkIterable(values, "values")
		val op = findOperation(name)
		val newValue = TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue
		newValue.setOperation(op)
		values.forEach[
			switch it {
				JvmAnnotationReferenceImpl : {
					newValue.values.add(EcoreUtil2.cloneWithProxies(delegate))
				}
				XtendAnnotationReferenceImpl : {
					throw new IllegalArgumentException("Multiple source annotations cannot be set as values. Please the the expression not the value.")
				}
			}
		]
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	override remove(String name) {
		val op = findOperation(name) // IllegalArgument if it doesn't exist
		return remove(op)
	}
	
	private def remove(JvmOperation op) {
		return Iterators.removeIf(delegate.explicitValues.iterator) [ op == operation || (operation == null && op.simpleName == 'value') ]
	}
	
	private def findOperation(String name) {
		checkJavaIdentifier(name, "name")
		
		val jvmAnnoType = (annotationTypeDeclaration as JvmAnnotationTypeDeclarationImpl).delegate
		val jvmOperation = jvmAnnoType.declaredOperations.findFirst[it.simpleName == name]
		if (jvmOperation == null) {
			throw new IllegalArgumentException("The annotation property '"+name+"' is not declared on the annotation type '"+jvmAnnoType.identifier+"'.")
		}
		return jvmOperation
	}
	
	override setExpression(String name, Expression value) {
		internalSet(name, value)
	}
	
	override setAnnotationValue(String name, AnnotationReference... value) {
		internalSet(name, value)
	}
	
	override setBooleanValue(String name, boolean... value) {
		_internalSet(name, value)
	}
	
	override setByteValue(String name, byte... value) {
		_internalSet(name, value)
	}
	
	override setCharValue(String name, char... value) {
		_internalSet(name, value)
	}
	
	override setClassValue(String name, TypeReference... value) {
		_internalSet(name, value)
	}
	
	override setDoubleValue(String name, double... value) {
		_internalSet(name, value)
	}
	
	override setEnumValue(String name, EnumerationValueDeclaration... value) {
		_internalSet(name, value)
	}
	
	override setFloatValue(String name, float... value) {
		_internalSet(name, value)
	}
	
	override setIntValue(String name, int... value) {
		_internalSet(name, value)
	}
	
	override setLongValue(String name, long... value) {
		_internalSet(name, value)
	}
	
	override setShortValue(String name, short... value) {
		_internalSet(name, value)
	}
	
	override setStringValue(String name, String... value) {
		_internalSet(name, value)
	}
	
	override getAnnotationValue(String name) {
		getValue(name) as AnnotationReference
	}
	
	override getAnnotationArrayValue(String name) {
		getValue(name) as AnnotationReference[]
	}
	
	override getBooleanArrayValue(String name) {
		getValue(name) as boolean[]
	}
	
	override getBooleanValue(String name) {
		getValue(name) as Boolean
	}
	
	override getByteArrayValue(String name) {
		getValue(name) as byte[]
	}
	
	override getByteValue(String name) {
		getValue(name) as Byte
	}
	
	override getCharArrayValue(String name) {
		getValue(name) as char[]
	}
	
	override getCharValue(String name) {
		getValue(name) as Character
	}
	
	override getClassValue(String name) {
		getValue(name) as TypeReference
	}
	
	override getClassArrayValue(String name) {
		getValue(name) as TypeReference[]
	}
	
	override getDoubleArrayValue(String name) {
		getValue(name) as double[]
	}
	
	override getDoubleValue(String name) {
		getValue(name) as Double
	}
	
	override getEnumValue(String name) {
		getValue(name) as EnumerationValueDeclaration
	}
	
	override getEnumArrayValue(String name) {
		getValue(name) as EnumerationValueDeclaration[]
	}
	
	override getFloatArrayValue(String name) {
		getValue(name) as float[]
	}
	
	override getFloatValue(String name) {
		getValue(name) as Float
	}
	
	override getIntArrayValue(String name) {
		getValue(name) as int[]
	}
	
	override getIntValue(String name) {
		getValue(name) as Integer
	}
	
	override getLongArrayValue(String name) {
		getValue(name) as long[]
	}
	
	override getLongValue(String name) {
		getValue(name) as Long
	}
	
	override getShortArrayValue(String name) {
		getValue(name) as short[]
	}
	
	override getShortValue(String name) {
		getValue(name) as Short
	}
	
	override getStringArrayValue(String name) {
		getValue(name) as String[]
	}
	
	override getStringValue(String name) {
		getValue(name) as String
	}
	
}
