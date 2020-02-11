/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.annotations.validation;

import java.util.Arrays;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.validation.ConstantExpressionValidator;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.eclipse.xtext.xbase.validation.NotResolvedFeatureException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationValueValidator extends ConstantExpressionValidator {
  public void validateAnnotationValue(final XExpression value, final ValidationMessageAcceptor acceptor) {
    try {
      boolean _isValidAnnotationValue = this.isValidAnnotationValue(value);
      boolean _not = (!_isValidAnnotationValue);
      if (_not) {
        acceptor.acceptError("The value for an annotation attribute must be a constant expression", value, null, 
          ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE);
      }
    } catch (final Throwable _t) {
      if (_t instanceof NotResolvedFeatureException) {
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  protected boolean _isValidAnnotationValue(final XExpression expression) {
    return super.isConstant(expression);
  }
  
  protected boolean _isValidAnnotationValue(final Void nullValue) {
    return true;
  }
  
  protected boolean _isValidAnnotationValue(final XListLiteral expression) {
    return (expression.getElements().isEmpty() || IterableExtensions.<XExpression>forall(expression.getElements(), ((Function1<XExpression, Boolean>) (XExpression it) -> {
      return Boolean.valueOf(this.isValidAnnotationValue(it));
    })));
  }
  
  protected boolean _isValidAnnotationValue(final XAnnotation expression) {
    return true;
  }
  
  protected boolean _isValidAnnotationValue(final XAbstractFeatureCall expression) {
    boolean _isTypeLiteral = expression.isTypeLiteral();
    if (_isTypeLiteral) {
      return true;
    }
    return super.isConstant(expression);
  }
  
  protected boolean isValidAnnotationValue(final XExpression expression) {
    if (expression instanceof XListLiteral) {
      return _isValidAnnotationValue((XListLiteral)expression);
    } else if (expression instanceof XAbstractFeatureCall) {
      return _isValidAnnotationValue((XAbstractFeatureCall)expression);
    } else if (expression instanceof XAnnotation) {
      return _isValidAnnotationValue((XAnnotation)expression);
    } else if (expression != null) {
      return _isValidAnnotationValue(expression);
    } else if (expression == null) {
      return _isValidAnnotationValue((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression).toString());
    }
  }
}
