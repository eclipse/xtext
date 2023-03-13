/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.macro.declaration

import org.eclipse.xtend.lib.macro.declaration.AnnotationReference
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration
import org.eclipse.xtend.lib.macro.declaration.TypeReference
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException

import static org.eclipse.xtend.core.macro.ConditionUtils.*

class JvmAnnotationReferenceImpl extends JvmElementImpl<JvmAnnotationReference> implements AnnotationReference {

	override getAnnotationTypeDeclaration() {
		compilationUnit.toTypeDeclaration(delegate.annotation) as AnnotationTypeDeclaration
	}
	
	override getExpression(String property) {
		val op = findOperation(property)
		val annotationValue = delegate.values.findFirst[ operation == op || (operation === null && op.simpleName == 'value') ]
		switch annotationValue {
			JvmCustomAnnotationValue : {
				val expression = annotationValue.values.head as XExpression
				if (expression !== null && compilationUnit.isBelongedToCompilationUnit(expression))
					return compilationUnit.toExpression(expression)
			}
		}
		return null
	}
	
	override getValue(String property) {
		try {
			val op = findOperation(property)
			val annotationValue = delegate.values.findFirst[ operation == op || (operation === null && op.simpleName == 'value') ]
			val isArrayType = op!==null && compilationUnit.typeReferences.isArray(op.returnType)
			if (annotationValue !== null)
				return compilationUnit.translateAnnotationValue(annotationValue, isArrayType)
		} catch (ConstantExpressionEvaluationException e) {
			compilationUnit.problemSupport.addError(this, e.getMessage)
		}
		return null
	}
	
	private def findOperation(String name) {
		checkJavaIdentifier(name, "name")
		
		val jvmAnnoType = (annotationTypeDeclaration as JvmAnnotationTypeDeclarationImpl).delegate
		val jvmOperation = jvmAnnoType.declaredOperations.findFirst[it.simpleName == name]
		if (jvmOperation === null) {
			throw new IllegalArgumentException("The annotation property '"+name+"' is not declared on the annotation type '"+jvmAnnoType.identifier+"'.")
		}
		return jvmOperation
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
		val value = getValue(name)
		if (value === null) {
			return false 
		}
		value as Boolean
	}
	
	override getByteArrayValue(String name) {
		getValue(name) as byte[]
	}
	
	override getByteValue(String name) {
		val value = getValue(name)
		if (value === null) {
			return 0 as byte
		}
		value as Byte
	}
	
	override getCharArrayValue(String name) {
		getValue(name) as char[]
	}
	
	override getCharValue(String name) {
		val value = getValue(name)
		if (value === null) {
			return 0 as char
		}
		switch value {
			Byte: value as char
			default: value as Character
		}
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
		val value = getValue(name)
		if (value === null) {
			return 0
		}
		switch value {
			Character: value as double
			Byte: value as double
			Short: value as double
			Integer: value as double
			Long: value as double
			Float: value as double
			default: value as Double
		}
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
		val value = getValue(name)
		if (value === null) {
			return 0
		}
		switch value {
			Character: value as float
			Byte: value as float
			Short: value as float
			Integer: value as float
			Long: value as float
			default: value as Float 
		} 
	}
	
	override getIntArrayValue(String name) {
		getValue(name) as int[]
	}
	
	override getIntValue(String name) {
		val value = getValue(name)
		if (value === null) {
			return 0
		}
		switch value {
			Character: value as int
			Byte: value as int
			Short: value as int
			default: value as Integer 
		}
	}
	
	override getLongArrayValue(String name) {
		getValue(name) as long[]
	}
	
	override getLongValue(String name) {
		val value = getValue(name)
		if (value === null) {
			return 0
		}
		switch value {
			Character: value as long
			Byte: value as long
			Short: value as long
			Integer: value as long
			default: value as Long
		}
	}
	
	override getShortArrayValue(String name) {
		getValue(name) as short[]
	}
	
	override getShortValue(String name) {
		val value = getValue(name)
		if (value === null) {
			return 0 as short
		}
		switch value {
			Byte: value as short
			default: value as Short
		}
	}
	
	override getStringArrayValue(String name) {
		getValue(name) as String[]
	}
	
	override getStringValue(String name) {
		getValue(name) as String
	}
	
}
