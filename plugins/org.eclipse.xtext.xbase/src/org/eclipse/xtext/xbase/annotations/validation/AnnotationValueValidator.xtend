/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.validation

import org.eclipse.xtext.common.types.JvmEnumerationLiteral
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmIdentifiableElement
import org.eclipse.xtext.common.types.JvmPrimitiveType
import org.eclipse.xtext.validation.ValidationMessageAcceptor
import org.eclipse.xtext.xbase.XBooleanLiteral
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.XFeatureCall
import org.eclipse.xtext.xbase.XListLiteral
import org.eclipse.xtext.xbase.XMemberFeatureCall
import org.eclipse.xtext.xbase.XNumberLiteral
import org.eclipse.xtext.xbase.XStringLiteral
import org.eclipse.xtext.xbase.XTypeLiteral
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation
import org.eclipse.xtext.xbase.validation.IssueCodes

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AnnotationValueValidator {
	
	def void validateAnnotationValue(XExpression value, ValidationMessageAcceptor acceptor) {
		if (!isValidAnnotationValue(value, true)) {
			acceptor.acceptError("The value for an annotation attribute must be a constant expression", value, null,
				ValidationMessageAcceptor::INSIGNIFICANT_INDEX, IssueCodes::ANNOTATIONS_ILLEGAL_ATTRIBUTE);
		}
	}
	
	protected def dispatch boolean isValidAnnotationValue(XExpression expression, boolean allowNesting) {
		return false
	}
	protected def dispatch boolean isValidAnnotationValue(Void nullValue, boolean allowNesting) {
		// indicates a syntax error
		// consider the thing to be valid
		return true
	}
	protected def dispatch boolean isValidAnnotationValue(XBooleanLiteral expression, boolean allowNesting) {
		return true
	}
	protected def dispatch boolean isValidAnnotationValue(XNumberLiteral expression, boolean allowNesting) {
		return true
	}
	protected def dispatch boolean isValidAnnotationValue(XStringLiteral expression, boolean allowNesting) {
		return true
	}
	protected def dispatch boolean isValidAnnotationValue(XTypeLiteral expression, boolean allowNesting) {
		return true
	}
	protected def dispatch boolean isValidAnnotationValue(XAnnotation expression, boolean allowNesting) {
		return true
	}
	protected def dispatch boolean isValidAnnotationValue(XListLiteral expression, boolean allowNesting) {
		if (allowNesting) {
			return expression.elements.forall[ isValidAnnotationValue(it, false) ]
		}
		return false
	}
	protected def dispatch boolean isValidAnnotationValue(XFeatureCall expression, boolean allowNesting) {
		if (expression.typeLiteral || expression.packageFragment)
			return true
		return expression.feature.isValidAnnotationValue
	}
	protected def dispatch boolean isValidAnnotationValue(XMemberFeatureCall expression, boolean allowNesting) {
		if (expression.typeLiteral || expression.packageFragment)
			return true
		return expression.feature.isValidAnnotationValue
	}
	protected def dispatch boolean isValidAnnotationValue(XAnnotationElementValueBinaryOperation expression, boolean allowNesting) {
		return expression.leftOperand.isValidAnnotationValue(false) && expression.rightOperand.isValidAnnotationValue(false)
	}
	
	protected def dispatch boolean isValidAnnotationValue(JvmIdentifiableElement identifiable) {
		return false
	}
	protected def dispatch boolean isValidAnnotationValue(JvmField field) {
		if (field.static) {
			// Let's be optimistic here
			val fieldType = field.type
			val rawType = fieldType.type
			if (rawType instanceof JvmPrimitiveType) {
				return true
			}
			return fieldType.identifier == "java.lang.String"
		}
		return false
	}
	protected def dispatch boolean isValidAnnotationValue(JvmEnumerationLiteral enumLiteral) {
		return true
	}

}
