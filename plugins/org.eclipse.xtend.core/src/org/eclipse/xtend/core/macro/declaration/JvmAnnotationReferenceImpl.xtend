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
	
	private def findOperation(String name) {
		checkJavaIdentifier(name, "name")
		
		val jvmAnnoType = (annotationTypeDeclaration as JvmAnnotationTypeDeclarationImpl).delegate
		val jvmOperation = jvmAnnoType.declaredOperations.findFirst[it.simpleName == name]
		if (jvmOperation == null) {
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
		switch value : getValue(name) {
			Boolean: value
			default: false
		}
	}
	
	override getByteArrayValue(String name) {
		getValue(name) as byte[]
	}
	
	override getByteValue(String name) {
		switch value : getValue(name) {
			Byte: value
			default: 0 as byte
		}
	}
	
	override getCharArrayValue(String name) {
		getValue(name) as char[]
	}
	
	override getCharValue(String name) {
		switch value : getValue(name) {
			Character: value
			default: 0 as char
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
		switch value : getValue(name) {
			Double: value
			default: 0 
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
		switch value : getValue(name) {
			Float: value
			default: 0 
		} 
	}
	
	override getIntArrayValue(String name) {
		getValue(name) as int[]
	}
	
	override getIntValue(String name) {
		switch value : getValue(name) {
			Integer: value
			default: 0 
		}
	}
	
	override getLongArrayValue(String name) {
		getValue(name) as long[]
	}
	
	override getLongValue(String name) {
		switch value : getValue(name) {
			Long: value
			default: 0 
		}
	}
	
	override getShortArrayValue(String name) {
		getValue(name) as short[]
	}
	
	override getShortValue(String name) {
		switch value : getValue(name) {
			Short: value
			default: 0 as short
		}
	}
	
	override getStringArrayValue(String name) {
		getValue(name) as String[]
	}
	
	override getStringValue(String name) {
		getValue(name) as String
	}
	
}
