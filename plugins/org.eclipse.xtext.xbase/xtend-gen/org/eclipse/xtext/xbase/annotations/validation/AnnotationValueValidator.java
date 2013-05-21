/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.annotations.validation;

import com.google.common.base.Objects;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmField;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;
import org.eclipse.xtext.xbase.XBooleanLiteral;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XListLiteral;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XNumberLiteral;
import org.eclipse.xtext.xbase.XStringLiteral;
import org.eclipse.xtext.xbase.XTypeLiteral;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValueBinaryOperation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.validation.IssueCodes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationValueValidator {
  public void validateAnnotationValue(final XExpression value, final ValidationMessageAcceptor acceptor) {
    boolean _isValidAnnotationValue = this.isValidAnnotationValue(value, true);
    boolean _not = (!_isValidAnnotationValue);
    if (_not) {
      acceptor.acceptError("The value for an annotation attribute must be a constant expression", value, null, 
        ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE);
    }
  }
  
  protected boolean _isValidAnnotationValue(final XExpression expression, final boolean allowNesting) {
    return false;
  }
  
  protected boolean _isValidAnnotationValue(final Void nullValue, final boolean allowNesting) {
    return true;
  }
  
  protected boolean _isValidAnnotationValue(final XBooleanLiteral expression, final boolean allowNesting) {
    return true;
  }
  
  protected boolean _isValidAnnotationValue(final XNumberLiteral expression, final boolean allowNesting) {
    return true;
  }
  
  protected boolean _isValidAnnotationValue(final XStringLiteral expression, final boolean allowNesting) {
    return true;
  }
  
  protected boolean _isValidAnnotationValue(final XTypeLiteral expression, final boolean allowNesting) {
    return true;
  }
  
  protected boolean _isValidAnnotationValue(final XAnnotation expression, final boolean allowNesting) {
    return true;
  }
  
  protected boolean _isValidAnnotationValue(final XListLiteral expression, final boolean allowNesting) {
    if (allowNesting) {
      EList<XExpression> _elements = expression.getElements();
      final Function1<XExpression,Boolean> _function = new Function1<XExpression,Boolean>() {
          public Boolean apply(final XExpression it) {
            boolean _isValidAnnotationValue = AnnotationValueValidator.this.isValidAnnotationValue(it, false);
            return Boolean.valueOf(_isValidAnnotationValue);
          }
        };
      return IterableExtensions.<XExpression>forall(_elements, _function);
    }
    return false;
  }
  
  protected boolean _isValidAnnotationValue(final XFeatureCall expression, final boolean allowNesting) {
    boolean _or = false;
    boolean _isTypeLiteral = expression.isTypeLiteral();
    if (_isTypeLiteral) {
      _or = true;
    } else {
      boolean _isPackageFragment = expression.isPackageFragment();
      _or = (_isTypeLiteral || _isPackageFragment);
    }
    if (_or) {
      return true;
    }
    JvmIdentifiableElement _feature = expression.getFeature();
    return this.isValidAnnotationValue(_feature);
  }
  
  protected boolean _isValidAnnotationValue(final XMemberFeatureCall expression, final boolean allowNesting) {
    boolean _or = false;
    boolean _isTypeLiteral = expression.isTypeLiteral();
    if (_isTypeLiteral) {
      _or = true;
    } else {
      boolean _isPackageFragment = expression.isPackageFragment();
      _or = (_isTypeLiteral || _isPackageFragment);
    }
    if (_or) {
      return true;
    }
    JvmIdentifiableElement _feature = expression.getFeature();
    return this.isValidAnnotationValue(_feature);
  }
  
  protected boolean _isValidAnnotationValue(final XAnnotationElementValueBinaryOperation expression, final boolean allowNesting) {
    boolean _and = false;
    XExpression _leftOperand = expression.getLeftOperand();
    boolean _isValidAnnotationValue = this.isValidAnnotationValue(_leftOperand, false);
    if (!_isValidAnnotationValue) {
      _and = false;
    } else {
      XExpression _rightOperand = expression.getRightOperand();
      boolean _isValidAnnotationValue_1 = this.isValidAnnotationValue(_rightOperand, false);
      _and = (_isValidAnnotationValue && _isValidAnnotationValue_1);
    }
    return _and;
  }
  
  protected boolean _isValidAnnotationValue(final JvmIdentifiableElement identifiable) {
    return false;
  }
  
  protected boolean _isValidAnnotationValue(final JvmField field) {
    boolean _isStatic = field.isStatic();
    if (_isStatic) {
      final JvmTypeReference fieldType = field.getType();
      final JvmType rawType = fieldType.getType();
      if ((rawType instanceof JvmPrimitiveType)) {
        return true;
      }
      String _identifier = fieldType.getIdentifier();
      return Objects.equal(_identifier, "java.lang.String");
    }
    return false;
  }
  
  protected boolean _isValidAnnotationValue(final JvmEnumerationLiteral enumLiteral) {
    return true;
  }
  
  protected boolean isValidAnnotationValue(final XExpression expression, final boolean allowNesting) {
    if (expression instanceof XFeatureCall) {
      return _isValidAnnotationValue((XFeatureCall)expression, allowNesting);
    } else if (expression instanceof XListLiteral) {
      return _isValidAnnotationValue((XListLiteral)expression, allowNesting);
    } else if (expression instanceof XMemberFeatureCall) {
      return _isValidAnnotationValue((XMemberFeatureCall)expression, allowNesting);
    } else if (expression instanceof XBooleanLiteral) {
      return _isValidAnnotationValue((XBooleanLiteral)expression, allowNesting);
    } else if (expression instanceof XNumberLiteral) {
      return _isValidAnnotationValue((XNumberLiteral)expression, allowNesting);
    } else if (expression instanceof XStringLiteral) {
      return _isValidAnnotationValue((XStringLiteral)expression, allowNesting);
    } else if (expression instanceof XTypeLiteral) {
      return _isValidAnnotationValue((XTypeLiteral)expression, allowNesting);
    } else if (expression instanceof XAnnotation) {
      return _isValidAnnotationValue((XAnnotation)expression, allowNesting);
    } else if (expression instanceof XAnnotationElementValueBinaryOperation) {
      return _isValidAnnotationValue((XAnnotationElementValueBinaryOperation)expression, allowNesting);
    } else if (expression != null) {
      return _isValidAnnotationValue(expression, allowNesting);
    } else if (expression == null) {
      return _isValidAnnotationValue((Void)null, allowNesting);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(expression, allowNesting).toString());
    }
  }
  
  protected boolean isValidAnnotationValue(final JvmIdentifiableElement enumLiteral) {
    if (enumLiteral instanceof JvmEnumerationLiteral) {
      return _isValidAnnotationValue((JvmEnumerationLiteral)enumLiteral);
    } else if (enumLiteral instanceof JvmField) {
      return _isValidAnnotationValue((JvmField)enumLiteral);
    } else if (enumLiteral != null) {
      return _isValidAnnotationValue(enumLiteral);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(enumLiteral).toString());
    }
  }
}
