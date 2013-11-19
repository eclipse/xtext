/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import java.util.Collection;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmElementImpl;
import org.eclipse.xtend.core.macro.declaration.JvmEnumerationValueDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;

@SuppressWarnings("all")
public class JvmAnnotationReferenceImpl extends JvmElementImpl<JvmAnnotationReference> implements MutableAnnotationReference {
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
        boolean _equals = Objects.equal(_valueName, property);
        if (_equals) {
          _or = true;
        } else {
          boolean _and = false;
          String _valueName_1 = it.getValueName();
          boolean _equals_1 = Objects.equal(_valueName_1, null);
          if (!_equals_1) {
            _and = false;
          } else {
            boolean _equals_2 = Objects.equal(property, "value");
            _and = (_equals_1 && _equals_2);
          }
          _or = (_equals || _and);
        }
        return Boolean.valueOf(_or);
      }
    };
    final JvmAnnotationValue annotationValue = IterableExtensions.<JvmAnnotationValue>findFirst(_values, _function);
    JvmAnnotationReference _delegate_1 = this.getDelegate();
    JvmAnnotationType _annotation = _delegate_1.getAnnotation();
    Iterable<JvmOperation> _declaredOperations = _annotation.getDeclaredOperations();
    final Function1<JvmOperation,Boolean> _function_1 = new Function1<JvmOperation,Boolean>() {
      public Boolean apply(final JvmOperation it) {
        String _simpleName = it.getSimpleName();
        boolean _equals = Objects.equal(_simpleName, property);
        return Boolean.valueOf(_equals);
      }
    };
    final JvmOperation op = IterableExtensions.<JvmOperation>findFirst(_declaredOperations, _function_1);
    boolean _and = false;
    boolean _notEquals = (!Objects.equal(op, null));
    if (!_notEquals) {
      _and = false;
    } else {
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      TypeReferences _typeReferences = _compilationUnit.getTypeReferences();
      JvmTypeReference _returnType = op.getReturnType();
      boolean _isArray = _typeReferences.isArray(_returnType);
      _and = (_notEquals && _isArray);
    }
    final boolean isArrayType = _and;
    boolean _notEquals_1 = (!Objects.equal(annotationValue, null));
    if (_notEquals_1) {
      CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
      return _compilationUnit_1.translateAnnotationValue(annotationValue, isArrayType);
    }
    boolean _and_1 = false;
    boolean _notEquals_2 = (!Objects.equal(op, null));
    if (!_notEquals_2) {
      _and_1 = false;
    } else {
      JvmAnnotationValue _defaultValue = op.getDefaultValue();
      boolean _notEquals_3 = (!Objects.equal(_defaultValue, null));
      _and_1 = (_notEquals_2 && _notEquals_3);
    }
    if (_and_1) {
      CompilationUnitImpl _compilationUnit_2 = this.getCompilationUnit();
      JvmAnnotationValue _defaultValue_1 = op.getDefaultValue();
      return _compilationUnit_2.translateAnnotationValue(_defaultValue_1, isArrayType);
    }
    return null;
  }
  
  public void set(final String name, final String... values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmStringAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
    boolean _notEquals = (!Objects.equal(name, null));
    if (_notEquals) {
      JvmOperation _findOperation = this.findOperation(name);
      newValue.setOperation(_findOperation);
    }
    EList<String> _values = newValue.getValues();
    CollectionExtensions.<String>addAll(_values, values);
    this.remove(name);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values_1 = _delegate.getValues();
    _values_1.add(newValue);
  }
  
  public void set(final String name, final boolean... values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmBooleanAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
    boolean _notEquals = (!Objects.equal(name, null));
    if (_notEquals) {
      JvmOperation _findOperation = this.findOperation(name);
      newValue.setOperation(_findOperation);
    }
    EList<Boolean> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Boolean>)Conversions.doWrapArray(values)));
    this.remove(name);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values_1 = _delegate.getValues();
    _values_1.add(newValue);
  }
  
  public void set(final String name, final int... values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmIntAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
    boolean _notEquals = (!Objects.equal(name, null));
    if (_notEquals) {
      JvmOperation _findOperation = this.findOperation(name);
      newValue.setOperation(_findOperation);
    }
    EList<Integer> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Integer>)Conversions.doWrapArray(values)));
    this.remove(name);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values_1 = _delegate.getValues();
    _values_1.add(newValue);
  }
  
  public void set(final String name, final double... values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmDoubleAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
    boolean _notEquals = (!Objects.equal(name, null));
    if (_notEquals) {
      JvmOperation _findOperation = this.findOperation(name);
      newValue.setOperation(_findOperation);
    }
    EList<Double> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Double>)Conversions.doWrapArray(values)));
    this.remove(name);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values_1 = _delegate.getValues();
    _values_1.add(newValue);
  }
  
  public void set(final String name, final TypeReference... values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmTypeAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
    boolean _notEquals = (!Objects.equal(name, null));
    if (_notEquals) {
      JvmOperation _findOperation = this.findOperation(name);
      newValue.setOperation(_findOperation);
    }
    final Procedure1<TypeReference> _function = new Procedure1<TypeReference>() {
      public void apply(final TypeReference it) {
        boolean _matched = false;
        if (!_matched) {
          if (it instanceof TypeReferenceImpl) {
            _matched=true;
            EList<JvmTypeReference> _values = newValue.getValues();
            LightweightTypeReference _delegate = ((TypeReferenceImpl)it).getDelegate();
            JvmTypeReference _typeReference = _delegate.toTypeReference();
            _values.add(_typeReference);
          }
        }
      }
    };
    IterableExtensions.<TypeReference>forEach(((Iterable<TypeReference>)Conversions.doWrapArray(values)), _function);
    this.remove(name);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values = _delegate.getValues();
    _values.add(newValue);
  }
  
  public void set(final String name, final EnumerationValueDeclaration... values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmEnumAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
    boolean _notEquals = (!Objects.equal(name, null));
    if (_notEquals) {
      JvmOperation _findOperation = this.findOperation(name);
      newValue.setOperation(_findOperation);
    }
    final Procedure1<EnumerationValueDeclaration> _function = new Procedure1<EnumerationValueDeclaration>() {
      public void apply(final EnumerationValueDeclaration it) {
        boolean _matched = false;
        if (!_matched) {
          if (it instanceof JvmEnumerationValueDeclarationImpl) {
            _matched=true;
            EList<JvmEnumerationLiteral> _values = newValue.getValues();
            JvmEnumerationLiteral _delegate = ((JvmEnumerationValueDeclarationImpl)it).getDelegate();
            _values.add(_delegate);
          }
        }
      }
    };
    IterableExtensions.<EnumerationValueDeclaration>forEach(((Iterable<EnumerationValueDeclaration>)Conversions.doWrapArray(values)), _function);
    this.remove(name);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values = _delegate.getValues();
    _values.add(newValue);
  }
  
  public boolean remove(final String name) {
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values = _delegate.getValues();
    final Function1<JvmAnnotationValue,Boolean> _function = new Function1<JvmAnnotationValue,Boolean>() {
      public Boolean apply(final JvmAnnotationValue it) {
        String _xifexpression = null;
        JvmOperation _operation = it.getOperation();
        boolean _equals = Objects.equal(_operation, null);
        if (_equals) {
          _xifexpression = "value";
        } else {
          JvmOperation _operation_1 = it.getOperation();
          String _simpleName = _operation_1.getSimpleName();
          _xifexpression = _simpleName;
        }
        boolean _equals_1 = Objects.equal(_xifexpression, name);
        return Boolean.valueOf(_equals_1);
      }
    };
    final JvmAnnotationValue found = IterableExtensions.<JvmAnnotationValue>findFirst(_values, _function);
    boolean _notEquals = (!Objects.equal(found, null));
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
        boolean _equals = Objects.equal(_simpleName, name);
        return Boolean.valueOf(_equals);
      }
    };
    final JvmOperation jvmOperation = IterableExtensions.<JvmOperation>findFirst(_declaredOperations, _function);
    boolean _equals = Objects.equal(jvmOperation, null);
    if (_equals) {
      String _identifier = jvmAnnoType.getIdentifier();
      String _plus = ((("The annotation property \'" + name) + "\' is not declared on the annotation type \'") + _identifier);
      String _plus_1 = (_plus + "\'.");
      IllegalArgumentException _illegalArgumentException = new IllegalArgumentException(_plus_1);
      throw _illegalArgumentException;
    }
    return jvmOperation;
  }
}
