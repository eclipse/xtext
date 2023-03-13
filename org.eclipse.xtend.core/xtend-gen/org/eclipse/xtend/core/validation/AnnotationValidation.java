/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.validation;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmGenericArrayTypeReference;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.annotations.validation.AnnotationValueValidator;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationValidation extends AbstractDeclarativeValidator {
  @Inject
  private AnnotationValueValidator annotationValueValidator;

  @Override
  protected List<EPackage> getEPackages() {
    return CollectionLiterals.<EPackage>newArrayList(XtendPackage.eINSTANCE, XbasePackage.eINSTANCE, XAnnotationsPackage.eINSTANCE);
  }

  @Check
  public void checkAnnotation(final XtendAnnotationType it) {
    Iterable<XtendField> _filter = Iterables.<XtendField>filter(it.getMembers(), XtendField.class);
    for (final XtendField it_1 : _filter) {
      {
        boolean _isValidAnnotationValueType = this.isValidAnnotationValueType(it_1.getType());
        boolean _not = (!_isValidAnnotationValueType);
        if (_not) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Invalid type ");
          String _simpleName = it_1.getType().getSimpleName();
          _builder.append(_simpleName);
          _builder.append(" for the annotation attribute ");
          String _name = it_1.getName();
          _builder.append(_name);
          _builder.append("; only primitive type, String, Class, annotation, enumeration are permitted or 1-dimensional arrays thereof");
          this.error(_builder.toString(), it_1, 
            XtendPackage.Literals.XTEND_FIELD__TYPE, 
            IssueCodes.INVALID_ANNOTATION_VALUE_TYPE);
        }
        XExpression _initialValue = it_1.getInitialValue();
        boolean _tripleNotEquals = (_initialValue != null);
        if (_tripleNotEquals) {
          this.annotationValueValidator.validateAnnotationValue(it_1.getInitialValue(), this);
        }
      }
    }
  }

  public boolean isValidAnnotationValueType(final JvmTypeReference reference) {
    JvmTypeReference _switchResult = null;
    boolean _matched = false;
    if (reference instanceof JvmGenericArrayTypeReference) {
      _matched=true;
      _switchResult = ((JvmGenericArrayTypeReference)reference).getComponentType();
    }
    if (!_matched) {
      _switchResult = reference;
    }
    final JvmTypeReference toCheck = _switchResult;
    if ((toCheck == null)) {
      return true;
    }
    JvmType _type = toCheck.getType();
    if ((_type instanceof JvmPrimitiveType)) {
      return true;
    }
    JvmType _type_1 = toCheck.getType();
    if ((_type_1 instanceof JvmEnumerationType)) {
      return true;
    }
    JvmType _type_2 = toCheck.getType();
    if ((_type_2 instanceof JvmAnnotationType)) {
      return true;
    }
    if ((Objects.equal(toCheck.getType().getQualifiedName(), "java.lang.String") || Objects.equal(toCheck.getType().getQualifiedName(), "java.lang.Class"))) {
      return true;
    }
    return false;
  }
}
