/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.declaration.AbstractDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationTypeDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class JvmAnnotationReferenceImpl extends AbstractDeclarationImpl<JvmAnnotationReference> implements MutableAnnotationReference {
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
          boolean _or = false;
          String _valueName = it.getValueName();
          boolean _equals = ObjectExtensions.operator_equals(_valueName, property);
          if (_equals) {
            _or = true;
          } else {
            boolean _and = false;
            String _valueName_1 = it.getValueName();
            boolean _equals_1 = ObjectExtensions.operator_equals(_valueName_1, null);
            if (!_equals_1) {
              _and = false;
            } else {
              boolean _equals_2 = ObjectExtensions.operator_equals(property, "value");
              _and = (_equals_1 && _equals_2);
            }
            _or = (_equals || _and);
          }
          return Boolean.valueOf(_or);
        }
      };
    final JvmAnnotationValue annotationValue = IterableExtensions.<JvmAnnotationValue>findFirst(_values, _function);
    CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
    return _compilationUnit.translateAnnotationValue(annotationValue);
  }
  
  public void set(final String name, final String... values) {
    final JvmStringAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
    boolean _notEquals = ObjectExtensions.operator_notEquals(name, null);
    if (_notEquals) {
      JvmOperation _findOperation = this.findOperation(name);
      newValue.setOperation(_findOperation);
    }
    EList<String> _values = newValue.getValues();
    CollectionExtensions.<String>addAll(_values, values);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values_1 = _delegate.getValues();
    _values_1.add(newValue);
  }
  
  public void set(final String name, final boolean... values) {
    final JvmBooleanAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
    boolean _notEquals = ObjectExtensions.operator_notEquals(name, null);
    if (_notEquals) {
      JvmOperation _findOperation = this.findOperation(name);
      newValue.setOperation(_findOperation);
    }
    EList<Boolean> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Boolean>)Conversions.doWrapArray(values)));
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values_1 = _delegate.getValues();
    _values_1.add(newValue);
  }
  
  public void set(final String name, final int... values) {
    final JvmIntAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
    boolean _notEquals = ObjectExtensions.operator_notEquals(name, null);
    if (_notEquals) {
      JvmOperation _findOperation = this.findOperation(name);
      newValue.setOperation(_findOperation);
    }
    EList<Integer> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Integer>)Conversions.doWrapArray(values)));
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values_1 = _delegate.getValues();
    _values_1.add(newValue);
  }
  
  public boolean remove(final String name) {
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values = _delegate.getValues();
    final Function1<JvmAnnotationValue,Boolean> _function = new Function1<JvmAnnotationValue,Boolean>() {
        public Boolean apply(final JvmAnnotationValue it) {
          JvmOperation _operation = it.getOperation();
          String _simpleName = _operation.getSimpleName();
          boolean _equals = ObjectExtensions.operator_equals(_simpleName, name);
          return Boolean.valueOf(_equals);
        }
      };
    final JvmAnnotationValue found = IterableExtensions.<JvmAnnotationValue>findFirst(_values, _function);
    boolean _notEquals = ObjectExtensions.operator_notEquals(found, null);
    if (_notEquals) {
      JvmAnnotationReference _delegate_1 = this.getDelegate();
      EList<JvmAnnotationValue> _values_1 = _delegate_1.getValues();
      _values_1.remove(found);
      return true;
    }
    return false;
  }
  
  private JvmOperation findOperation(final String name) {
    AnnotationTypeDeclaration _annotationTypeDeclaration = this.getAnnotationTypeDeclaration();
    final JvmAnnotationType jvmAnnoType = ((JvmAnnotationTypeDeclarationImpl) _annotationTypeDeclaration).getDelegate();
    Iterable<JvmOperation> _declaredOperations = jvmAnnoType.getDeclaredOperations();
    final Function1<JvmOperation,Boolean> _function = new Function1<JvmOperation,Boolean>() {
        public Boolean apply(final JvmOperation it) {
          String _simpleName = it.getSimpleName();
          boolean _equals = ObjectExtensions.operator_equals(_simpleName, name);
          return Boolean.valueOf(_equals);
        }
      };
    final JvmOperation jvmOperation = IterableExtensions.<JvmOperation>findFirst(_declaredOperations, _function);
    boolean _equals = ObjectExtensions.operator_equals(jvmOperation, null);
    if (_equals) {
      String _plus = ("The annotation property \'" + name);
      String _plus_1 = (_plus + "\' is not declared on the annotation type \'");
      String _identifier = jvmAnnoType.getIdentifier();
      String _plus_2 = (_plus_1 + _identifier);
      String _plus_3 = (_plus_2 + "\'.");
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus_3);
      throw _illegalArgumentException;
    }
    return jvmOperation;
  }
}
