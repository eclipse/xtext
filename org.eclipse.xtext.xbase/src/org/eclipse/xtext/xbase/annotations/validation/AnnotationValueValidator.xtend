/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.annotations.validation

import org.eclipse.xtext.validation.ValidationMessageAcceptor
import org.eclipse.xtext.xbase.XAbstractFeatureCall
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation
import org.eclipse.xtext.xbase.validation.ConstantExpressionValidator
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.eclipse.xtext.xbase.XListLiteral
import org.eclipse.xtext.xbase.validation.NotResolvedFeatureException

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AnnotationValueValidator extends ConstantExpressionValidator {
	
	def void validateAnnotationValue(XExpression value, ValidationMessageAcceptor acceptor) {
		try {
			if (!isValidAnnotationValue(value)) {
				acceptor.acceptError("The value for an annotation attribute must be a constant expression", value, null,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE);
			}
		} catch (NotResolvedFeatureException e) {
			// do nothing
		}
	}
	
	protected def dispatch boolean isValidAnnotationValue(XExpression expression) {
		return super.isConstant(expression)
	}
	
	protected def dispatch boolean isValidAnnotationValue(Void nullValue) {
		// indicates a syntax error
		// consider the thing to be valid
		return true
	}
	
	protected def dispatch boolean isValidAnnotationValue(XListLiteral expression) { 
		expression.elements.empty || expression.elements.forall[isValidAnnotationValue]
	}
	
	protected def dispatch boolean isValidAnnotationValue(XAnnotation expression) {
		return true
	}
	
	protected def dispatch boolean isValidAnnotationValue(XAbstractFeatureCall expression) {
		if (expression.typeLiteral)
			return true
		return super.isConstant(expression)
	}
	
}
