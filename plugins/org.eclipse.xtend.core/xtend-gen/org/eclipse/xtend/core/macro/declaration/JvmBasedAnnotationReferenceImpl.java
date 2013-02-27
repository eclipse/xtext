/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.AbstractDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class JvmBasedAnnotationReferenceImpl extends AbstractDeclarationImpl<JvmAnnotationReference> implements MutableAnnotationReference {
  public AnnotationTypeDeclaration getAnnotationTypeDeclaration() {
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    JvmAnnotationReference _delegate = this.getDelegate();
    JvmAnnotationType _annotation = _delegate.getAnnotation();
    MutableTypeDeclaration _typeDeclaration = _compilationUnit.toTypeDeclaration(_annotation);
    return ((AnnotationTypeDeclaration) _typeDeclaration);
  }
  
  public Expression getExpression(final String property) {
    return null;
  }
  
  public Object getValue(final String property) {
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values = _delegate.getValues();
    final Function1<JvmAnnotationValue,Boolean> _function = new Function1<JvmAnnotationValue,Boolean>() {
        public Boolean apply(final JvmAnnotationValue it) {
          String _valueName = it.getValueName();
          boolean _equals = ObjectExtensions.operator_equals(_valueName, property);
          return Boolean.valueOf(_equals);
        }
      };
    final JvmAnnotationValue annotationValue = IterableExtensions.<JvmAnnotationValue>findFirst(_values, _function);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    return _compilationUnit.translateAnnotationValue(annotationValue);
  }
}
