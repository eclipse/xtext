/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import com.google.common.collect.Iterators
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend.lib.macro.expression.Expression
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.TypesPackage

import static org.eclipse.xtend.core.macro.ConditionUtils.*

import static extension org.eclipse.xtext.EcoreUtil2.*

/**
 * @author kosyakov - Initial contribution and API
 */
class AnnotationReferenceBuildContextImpl implements AnnotationReferenceBuildContext {
	
	@Property JvmAnnotationReference delegate
	@Property CompilationUnitImpl compilationUnit
	
	protected def findOperation(String name) {
		checkJavaIdentifier(name, "name")

		val annotationType = delegate.annotation
		val jvmOperation = annotationType.declaredOperations.findFirst[simpleName == name]
		if (jvmOperation == null) {
			throw new IllegalArgumentException('''The annotation property '«name»' is not declared on the annotation type '«annotationType.identifier»'.''')
		}
		return jvmOperation
	}
	
	protected def remove(String name) {
		val op = findOperation(name) // IllegalArgument if it doesn't exist
		return remove(op)
	}
	
	protected def remove(JvmOperation op) {
		return Iterators.removeIf(delegate.explicitValues.iterator) [ op == operation || (operation == null && op.simpleName == 'value') ]
	}
	
	protected def findOperation(String name, String componentType, boolean mustBeArray) {
		val result = findOperation(name)
		val returnType = result.returnType?.type
		if (componentType !== null) {
			if (mustBeArray || returnType?.eClass == TypesPackage.Literals.JVM_ARRAY_TYPE) {
				checkTypeName(returnType.annotationValueTypeName, componentType + "[]")
			} else {
				checkTypeName(returnType.annotationValueTypeName, componentType)
			}
		} else if (mustBeArray && returnType?.eClass != TypesPackage.Literals.JVM_ARRAY_TYPE) {
			throw new IllegalArgumentException("Cannot assign array value to simple annotation property")
		}
		return result
	}
	
	private def getAnnotationValueTypeName(JvmType type) {
		switch result: type?.identifier {
			case 'java.lang.Class': TypeReference.name
			case 'java.lang.Class[]': TypeReference.name + "[]"
			default: result
		}
	}
	
	override set(String name, Object value) {
		internalSet(name, value, false)
	}
	
	override setAnnotationValue(String name, AnnotationReference... value) {
		internalSet(name, value, value.length != 1)
	}
	
	override setBooleanValue(String name, boolean... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	override setByteValue(String name, byte... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	override setCharValue(String name, char... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	override setClassValue(String name, TypeReference... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	override setDoubleValue(String name, double... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	override setEnumValue(String name, EnumerationValueDeclaration... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	override setFloatValue(String name, float... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	override setIntValue(String name, int... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	override setLongValue(String name, long... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	override setShortValue(String name, short... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	override setStringValue(String name, String... value) {
		_internalSet(name, value, value.length != 1)
	}
	
	def dispatch void internalSet(String name, Void value, boolean mustBeArray) {
		remove(name)
	}
	
	def dispatch void internalSet(String name, Object values, boolean mustBeArray) {
		throw new IllegalArgumentException("Cannot set annotation values of type "+values.class.canonicalName) 
	}
	
	def dispatch void internalSet(String name, String value, boolean mustBeArray) {
		val String[] arr = #[value]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, String[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = findOperation(name, String.name, mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmStringAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Boolean value, boolean mustBeArray) {
		val boolean[] arr = #[value.booleanValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, boolean[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = findOperation(name, "boolean", mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Integer value, boolean mustBeArray) {
		val int[] arr = #[value.intValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, int[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = findOperation(name, "int", mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmIntAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Short value, boolean mustBeArray) {
		val short[] arr = #[value.shortValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, short[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = findOperation(name, "short", mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmShortAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Long value, boolean mustBeArray) {
		val long[] arr = #[value.longValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, long[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = findOperation(name, "long", mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmLongAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Double value, boolean mustBeArray) {
		val double[] arr = #[value.doubleValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, double[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = findOperation(name, "double", mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Float value, boolean mustBeArray) {
		val float[] arr = #[value.floatValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, float[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = findOperation(name, "float", mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Character value, boolean mustBeArray) {
		val char[] arr = #[value.charValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, char[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = findOperation(name, "char", mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmCharAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, Byte value, boolean mustBeArray) {
		val byte[] arr = #[value.byteValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, byte[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = findOperation(name, "byte", mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmByteAnnotationValue
		newValue.setOperation(op)
		newValue.values.addAll(values)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, TypeReference value, boolean mustBeArray) {
		_internalSet(name, #[value], false)
	}
	
	def dispatch void internalSet(String name, TypeReference[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = findOperation(name, TypeReference.name, mustBeArray)
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
	
	def dispatch void internalSet(String name, EnumerationValueDeclaration[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = if (values.length >= 1)
			findOperation(name, values.get(0).declaringType.qualifiedName, mustBeArray) 
		else
			findOperation(name, null, mustBeArray)
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
	
	def dispatch void internalSet(String name, XtendAnnotationReferenceImpl value, boolean mustBeArray) {
		val op = findOperation(name, null, mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmCustomAnnotationValue
		newValue.setOperation(op)
		newValue.values.add(value.delegate)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, AnnotationReference value, boolean mustBeArray) {
		_internalSet(name, #[value], false)
	}
	
	def dispatch void internalSet(String name, AnnotationReference[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		val op = if (values.length >= 1)
			findOperation(name, values.get(0).annotationTypeDeclaration.qualifiedName, mustBeArray) 
		else
			findOperation(name, null, mustBeArray)
		val newValue = TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue
		newValue.setOperation(op)
		values.forEach[
			switch it {
				JvmAnnotationReferenceImpl : {
					newValue.values.add(delegate.cloneWithProxies)
				}
				XtendAnnotationReferenceImpl : {
					throw new IllegalArgumentException("Multiple source annotations cannot be set as values. Please the the expression not the value.")
				}
			}
		]
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	def dispatch void internalSet(String name, EnumerationValueDeclaration value, boolean mustBeArray) {
		_internalSet(name, #[value], false)
	}
	
}