/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.annotations.validation;

import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.validation.ConstantExpressionValidator;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xbase.validation.NotResolvedFeatureException;

import com.google.common.collect.Iterables;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AnnotationValueValidator extends ConstantExpressionValidator {
	public void validateAnnotationValue(XExpression value, ValidationMessageAcceptor acceptor) {
		try {
			if (!isValidAnnotationValue(value)) {
				acceptor.acceptError("The value for an annotation attribute must be a constant expression", value, null,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE);
			}
		} catch (NotResolvedFeatureException e) {
			// do nothing
		}
	}

	protected boolean _isValidAnnotationValue(XExpression expression) {
		return super.isConstant(expression);
	}

	protected boolean _isValidAnnotationValue(Void nullValue) {
		return true;
	}

	protected boolean _isValidAnnotationValue(XListLiteral expression) {
		return expression.getElements().isEmpty()
				|| Iterables.all(expression.getElements(), this::isValidAnnotationValue);
	}

	protected boolean _isValidAnnotationValue(XAnnotation expression) {
		return true;
	}

	protected boolean _isValidAnnotationValue(XAbstractFeatureCall expression) {
		if (expression.isTypeLiteral()) {
			return true;
		}
		return super.isConstant(expression);
	}

	protected boolean isValidAnnotationValue(XExpression expression) {
		if (expression instanceof XListLiteral) {
			return _isValidAnnotationValue((XListLiteral) expression);
		} else if (expression instanceof XAbstractFeatureCall) {
			return _isValidAnnotationValue((XAbstractFeatureCall) expression);
		} else if (expression instanceof XAnnotation) {
			return _isValidAnnotationValue((XAnnotation) expression);
		} else if (expression != null) {
			return _isValidAnnotationValue(expression);
		}
		return _isValidAnnotationValue((Void) null);
	}
}
