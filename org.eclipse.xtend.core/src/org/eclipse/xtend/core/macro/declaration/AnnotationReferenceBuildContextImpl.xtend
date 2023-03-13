/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import com.google.common.collect.Iterators
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmAnnotationValue
import org.eclipse.xtext.common.types.JvmArrayType
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue
import org.eclipse.xtext.common.types.JvmByteAnnotationValue
import org.eclipse.xtext.common.types.JvmCharAnnotationValue
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue
import org.eclipse.xtext.common.types.JvmEnumerationType
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue
import org.eclipse.xtext.common.types.JvmGenericType
import org.eclipse.xtext.common.types.JvmIntAnnotationValue
import org.eclipse.xtext.common.types.JvmLongAnnotationValue
import org.eclipse.xtext.common.types.JvmOperation
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.common.types.JvmShortAnnotationValue
import org.eclipse.xtext.common.types.JvmStringAnnotationValue
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.TypesPackage

import static org.eclipse.xtend.core.macro.ConditionUtils.*

import static extension org.eclipse.xtext.EcoreUtil2.*
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author kosyakov - Initial contribution and API
 */
class AnnotationReferenceBuildContextImpl implements AnnotationReferenceBuildContext {
	
	@Accessors JvmAnnotationReference delegate
	@Accessors CompilationUnitImpl compilationUnit
	
	protected def findOperation(String name) {
		checkJavaIdentifier(name, "name")

		val annotationType = delegate.annotation
		val jvmOperation = annotationType.declaredOperations.findFirst[simpleName == name]
		if (jvmOperation === null) {
			throw new IllegalArgumentException('''The annotation property '«name»' is not declared on the annotation type '«annotationType.identifier»'.''')
		}
		return jvmOperation
	}
	
	protected def remove(String name) {
		val op = findOperation(name) // IllegalArgument if it doesn't exist
		return remove(op)
	}
	
	protected def remove(JvmOperation op) {
		return Iterators.removeIf(delegate.explicitValues.iterator) [ op == operation || (operation === null && op.simpleName == 'value') ]
	}
	
	protected def findOperation(String name, boolean mustBeArray) {
		val result = findOperation(name)
		val returnType = result.returnType?.type
		if (mustBeArray && returnType?.eClass != TypesPackage.Literals.JVM_ARRAY_TYPE) {
			throw new IllegalArgumentException("Cannot assign array value to simple annotation property")
		}
		return result
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
		setValues(name, values, String.name, mustBeArray)
	}
	
	def dispatch void internalSet(String name, Boolean value, boolean mustBeArray) {
		val boolean[] arr = #[value.booleanValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, boolean[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, "boolean", mustBeArray)
	}
	
	def dispatch void internalSet(String name, Integer value, boolean mustBeArray) {
		val int[] arr = #[value.intValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, int[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, "int", mustBeArray)
	}
	
	def dispatch void internalSet(String name, Short value, boolean mustBeArray) {
		val short[] arr = #[value.shortValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, short[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, "short", mustBeArray)
	}
	
	def dispatch void internalSet(String name, Long value, boolean mustBeArray) {
		val long[] arr = #[value.longValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, long[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, "long", mustBeArray)
	}
	
	def dispatch void internalSet(String name, Double value, boolean mustBeArray) {
		val double[] arr = #[value.doubleValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, double[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, "double", mustBeArray)
	}
	
	def dispatch void internalSet(String name, Float value, boolean mustBeArray) {
		val float[] arr = #[value.floatValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, float[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, "float", mustBeArray)
	}
	
	def dispatch void internalSet(String name, Character value, boolean mustBeArray) {
		val char[] arr = #[value.charValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, char[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, "char", mustBeArray)
	}
	
	def dispatch void internalSet(String name, Byte value, boolean mustBeArray) {
		val byte[] arr = #[value.byteValue]
		_internalSet(name, arr, false)
	}
	
	def dispatch void internalSet(String name, byte[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, "byte", mustBeArray)
	}
	
	def dispatch void internalSet(String name, TypeReference value, boolean mustBeArray) {
		_internalSet(name, #[value], false)
	}
	
	def dispatch void internalSet(String name, TypeReference[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, TypeReference.name, mustBeArray)
	}
	
	def dispatch void internalSet(String name, EnumerationValueDeclaration[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, values.head?.declaringType?.qualifiedName, mustBeArray)
	}
	
	def dispatch void internalSet(String name, XtendAnnotationReferenceImpl value, boolean mustBeArray) {
		setValues(name, value, null, mustBeArray)
	}
	
	def dispatch void internalSet(String name, AnnotationReference value, boolean mustBeArray) {
		_internalSet(name, #[value], false)
	}
	
	def dispatch void internalSet(String name, AnnotationReference[] values, boolean mustBeArray) {
		checkIterable(values, "values")
		setValues(name, values, values.head?.annotationTypeDeclaration?.qualifiedName, mustBeArray)
	}
	
	def dispatch void internalSet(String name, EnumerationValueDeclaration value, boolean mustBeArray) {
		_internalSet(name, #[value], false)
	}
	
	protected def void setValues(String name, Object values, String componentType, boolean mustBeArray) {
		val op = findOperation(name, mustBeArray)
		val newValue = op.createAnnotationValue(values)
		newValue.operation = op
		newValue.setValue(values, componentType, mustBeArray)
		remove(op);
		delegate.explicitValues.add(newValue)
	}
	
	protected def createAnnotationValue(JvmOperation op, Object values) {
		val returnType = op.returnType?.type
		
		switch type : if (returnType instanceof JvmArrayType) returnType.componentType else returnType {
			JvmPrimitiveType: {
				switch type.simpleName {
					case "boolean": TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue
					case "double": TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue
					case "float": TypesFactory.eINSTANCE.createJvmFloatAnnotationValue
					case "long": TypesFactory.eINSTANCE.createJvmLongAnnotationValue
					case "int": TypesFactory.eINSTANCE.createJvmIntAnnotationValue
					case "short": TypesFactory.eINSTANCE.createJvmShortAnnotationValue
					case "char": TypesFactory.eINSTANCE.createJvmCharAnnotationValue
					case "byte": TypesFactory.eINSTANCE.createJvmByteAnnotationValue
					default: throw new IllegalStateException('Unknown type: ' + type)
				}
			}
			JvmGenericType: {
				switch type.identifier {
					case String.name: TypesFactory.eINSTANCE.createJvmStringAnnotationValue
					case Class.name: TypesFactory.eINSTANCE.createJvmTypeAnnotationValue
					default:  throw new IllegalStateException('Unknown type: ' + type)
				}
			}
			JvmEnumerationType: TypesFactory.eINSTANCE.createJvmEnumAnnotationValue
			JvmAnnotationType: {
				if (values instanceof XtendAnnotationReferenceImpl) {
					TypesFactory.eINSTANCE.createJvmCustomAnnotationValue
				} else {
					TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue
				}
			}
			default: throw new IllegalStateException('Unknown type: ' + type)
		}
	}
	
	protected def dispatch void setValue(JvmAnnotationValue it, Object value, String componentType, boolean mustBeArray) {
		if (componentType === null) {
			throwNotApplicable(value.class.name)
		}
		if (mustBeArray || operation.returnType?.type?.eClass == TypesPackage.Literals.JVM_ARRAY_TYPE) {
			throwNotApplicable(componentType + "[]")
		}
		throwNotApplicable(componentType)
	}
	
	protected def dispatch void setValue(JvmTypeAnnotationValue it, TypeReference[] value, String componentType, boolean mustBeArray) {
		values += value.filter(TypeReferenceImpl).map[
			compilationUnit.toJvmTypeReference(it)
		]
	}
	
	protected def dispatch void setValue(JvmEnumAnnotationValue it, EnumerationValueDeclaration[] value, String componentType, boolean mustBeArray) {
		checkType(componentType, mustBeArray)
		for (enumValue : value) {
			switch enumValue {
				JvmEnumerationValueDeclarationImpl : {
					values.add(enumValue.delegate)
				}
				XtendEnumerationValueDeclarationImpl : {
					throw new IllegalArgumentException("Cannot set source elements.")
				}
			}
		}
	}
	
	protected def dispatch void setValue(JvmAnnotationAnnotationValue it, AnnotationReference[] value, String componentType, boolean mustBeArray) {
		checkType(componentType, mustBeArray)
		for (annotationValue : value) {
			switch annotationValue {
				JvmAnnotationReferenceImpl: {
					values.add(annotationValue.delegate.cloneWithProxies)
				}
				XtendAnnotationReferenceImpl: {
					throw new IllegalArgumentException("Multiple source annotations cannot be set as values. Please the the expression not the value.")
				}
			}
		}
	}
	
	protected def dispatch void setValue(JvmCustomAnnotationValue it, XtendAnnotationReferenceImpl value, String componentType, boolean mustBeArray) {
		values.add(value.delegate)
	}
	
	protected def dispatch void setValue(JvmStringAnnotationValue it, String[] value, String componentType, boolean mustBeArray) {
		values += value
	}
	
	protected def dispatch void setValue(JvmBooleanAnnotationValue it, boolean[] value, String componentType, boolean mustBeArray) {
		values += value
	}
	
	protected def dispatch void setValue(JvmDoubleAnnotationValue it, double[] value, String componentType, boolean mustBeArray) {
		values += value
	}
	
	protected def dispatch void setValue(JvmDoubleAnnotationValue it, float[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as double]
	}
	
	protected def dispatch void setValue(JvmDoubleAnnotationValue it, long[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as double]
	}
	
	protected def dispatch void setValue(JvmDoubleAnnotationValue it, int[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as double]
	}
	
	protected def dispatch void setValue(JvmDoubleAnnotationValue it, short[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as double]
	}
	
	protected def dispatch void setValue(JvmDoubleAnnotationValue it, byte[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as double]
	}
	
	protected def dispatch void setValue(JvmDoubleAnnotationValue it, char[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as double]
	}
	
	protected def dispatch void setValue(JvmFloatAnnotationValue it, float[] value, String componentType, boolean mustBeArray) {
		values += value
	}
	
	protected def dispatch void setValue(JvmFloatAnnotationValue it, long[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as float]
	}
	
	protected def dispatch void setValue(JvmFloatAnnotationValue it, int[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as float]
	}
	
	protected def dispatch void setValue(JvmFloatAnnotationValue it, short[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as float]
	}
	
	protected def dispatch void setValue(JvmFloatAnnotationValue it, byte[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as float]
	}
	
	protected def dispatch void setValue(JvmFloatAnnotationValue it, char[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as float]
	}
	
	protected def dispatch void setValue(JvmLongAnnotationValue it, long[] value, String componentType, boolean mustBeArray) {
		values += value
	}
	
	protected def dispatch void setValue(JvmLongAnnotationValue it, int[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as long]
	}
	
	protected def dispatch void setValue(JvmLongAnnotationValue it, short[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as long]
	}
	
	protected def dispatch void setValue(JvmLongAnnotationValue it, byte[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as long]
	}
	
	protected def dispatch void setValue(JvmLongAnnotationValue it, char[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as long]
	}
	
	protected def dispatch void setValue(JvmIntAnnotationValue it, int[] value, String componentType, boolean mustBeArray) {
		values += value
	}
	
	protected def dispatch void setValue(JvmIntAnnotationValue it, short[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as int]
	}
	
	protected def dispatch void setValue(JvmIntAnnotationValue it, byte[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as int]
	}
	
	protected def dispatch void setValue(JvmIntAnnotationValue it, char[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as int]
	}
	
	protected def dispatch void setValue(JvmShortAnnotationValue it, short[] value, String componentType, boolean mustBeArray) {
		values += value
	}
	
	protected def dispatch void setValue(JvmShortAnnotationValue it, byte[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as short]
	}
	
	protected def dispatch void setValue(JvmCharAnnotationValue it, char[] value, String componentType, boolean mustBeArray) {
		values += value
	}
	
	protected def dispatch void setValue(JvmCharAnnotationValue it, byte[] value, String componentType, boolean mustBeArray) {
		value.forEach[v | values += v as char]
	}
	
	protected def dispatch void setValue(JvmByteAnnotationValue it, byte[] value, String componentType, boolean mustBeArray) {
		values += value
	}
	
	protected def checkType(JvmAnnotationValue it, String componentType, boolean mustBeArray) {
		if (componentType === null) {
			return
		}
		val returnType = operation.returnType?.type
		if (mustBeArray || returnType?.eClass == TypesPackage.Literals.JVM_ARRAY_TYPE) {
			checkTypeName(returnType.annotationValueTypeName, componentType + "[]")
		} else {
			checkTypeName(returnType.annotationValueTypeName, componentType)
		}
	}
	
	protected def throwNotApplicable(JvmAnnotationValue it, String valueType) {
		throw new IllegalArgumentException(isNotApplicableMessage(valueType, operation.returnType?.type.annotationValueTypeName))
	}
	
	protected def getAnnotationValueTypeName(JvmType type) {
		switch result: type?.identifier?.replace("$", ".") {
			case 'java.lang.Class': TypeReference.name
			case 'java.lang.Class[]': TypeReference.name + "[]"
			default: result
		}
	}

}
