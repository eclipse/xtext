/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.core.macro.declaration.ExpressionImpl;
import org.eclipse.xtend.core.macro.declaration.JvmAnnotationTypeDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.JvmElementImpl;
import org.eclipse.xtend.core.macro.declaration.JvmEnumerationValueDeclarationImpl;
import org.eclipse.xtend.core.macro.declaration.TypeReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.XtendAnnotationReferenceImpl;
import org.eclipse.xtend.core.macro.declaration.XtendEnumerationValueDeclarationImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.MutableAnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtend.lib.macro.services.ProblemSupport;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.lib.CollectionExtensions;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
    final JvmOperation op = this.findOperation(property);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _values = _delegate.getValues();
    final Function1<JvmAnnotationValue,Boolean> _function = new Function1<JvmAnnotationValue,Boolean>() {
      public Boolean apply(final JvmAnnotationValue it) {
        boolean _or = false;
        JvmOperation _operation = it.getOperation();
        boolean _equals = Objects.equal(_operation, op);
        if (_equals) {
          _or = true;
        } else {
          boolean _and = false;
          JvmOperation _operation_1 = it.getOperation();
          boolean _equals_1 = Objects.equal(_operation_1, null);
          if (!_equals_1) {
            _and = false;
          } else {
            String _simpleName = op.getSimpleName();
            boolean _equals_2 = Objects.equal(_simpleName, "value");
            _and = _equals_2;
          }
          _or = _and;
        }
        return Boolean.valueOf(_or);
      }
    };
    final JvmAnnotationValue annotationValue = IterableExtensions.<JvmAnnotationValue>findFirst(_values, _function);
    boolean _matched = false;
    if (!_matched) {
      if (annotationValue instanceof JvmCustomAnnotationValue) {
        _matched=true;
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        EList<Object> _values_1 = ((JvmCustomAnnotationValue)annotationValue).getValues();
        Object _head = IterableExtensions.<Object>head(_values_1);
        return _compilationUnit.toExpression(((XExpression) _head));
      }
    }
    return null;
  }
  
  public Object getValue(final String property) {
    try {
      final JvmOperation op = this.findOperation(property);
      JvmAnnotationReference _delegate = this.getDelegate();
      EList<JvmAnnotationValue> _values = _delegate.getValues();
      final Function1<JvmAnnotationValue,Boolean> _function = new Function1<JvmAnnotationValue,Boolean>() {
        public Boolean apply(final JvmAnnotationValue it) {
          boolean _or = false;
          JvmOperation _operation = it.getOperation();
          boolean _equals = Objects.equal(_operation, op);
          if (_equals) {
            _or = true;
          } else {
            boolean _and = false;
            JvmOperation _operation_1 = it.getOperation();
            boolean _equals_1 = Objects.equal(_operation_1, null);
            if (!_equals_1) {
              _and = false;
            } else {
              String _simpleName = op.getSimpleName();
              boolean _equals_2 = Objects.equal(_simpleName, "value");
              _and = _equals_2;
            }
            _or = _and;
          }
          return Boolean.valueOf(_or);
        }
      };
      final JvmAnnotationValue annotationValue = IterableExtensions.<JvmAnnotationValue>findFirst(_values, _function);
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(op, null));
      if (!_notEquals) {
        _and = false;
      } else {
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        TypeReferences _typeReferences = _compilationUnit.getTypeReferences();
        JvmTypeReference _returnType = op.getReturnType();
        boolean _isArray = _typeReferences.isArray(_returnType);
        _and = _isArray;
      }
      final boolean isArrayType = _and;
      boolean _notEquals_1 = (!Objects.equal(annotationValue, null));
      if (_notEquals_1) {
        CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
        return _compilationUnit_1.translateAnnotationValue(annotationValue, isArrayType);
      }
    } catch (final Throwable _t) {
      if (_t instanceof ConstantExpressionEvaluationException) {
        final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
        CompilationUnitImpl _compilationUnit_2 = this.getCompilationUnit();
        ProblemSupport _problemSupport = _compilationUnit_2.getProblemSupport();
        String _message = e.getMessage();
        _problemSupport.addError(this, _message);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return null;
  }
  
  public void set(final String name, final Object value) {
    this.internalSet(name, value);
  }
  
  protected void _internalSet(final String name, final Void value) {
    this.remove(name);
  }
  
  protected void _internalSet(final String name, final Object values) {
    Class<? extends Object> _class = values.getClass();
    String _name = _class.getName();
    String _plus = ("Cannot set annotation values of type " + _name);
    throw new IllegalArgumentException(_plus);
  }
  
  protected void _internalSet(final String name, final String value) {
    final String[] arr = { value };
    this._internalSet(name, arr);
  }
  
  protected void _internalSet(final String name, final String[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmStringAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
    newValue.setOperation(op);
    EList<String> _values = newValue.getValues();
    CollectionExtensions.<String>addAll(_values, values);
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final Boolean value) {
    boolean _booleanValue = value.booleanValue();
    final boolean[] arr = new boolean[] { _booleanValue };
    this._internalSet(name, arr);
  }
  
  protected void _internalSet(final String name, final boolean[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmBooleanAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
    newValue.setOperation(op);
    EList<Boolean> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Boolean>)Conversions.doWrapArray(values)));
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final Integer value) {
    int _intValue = value.intValue();
    final int[] arr = new int[] { _intValue };
    this._internalSet(name, arr);
  }
  
  protected void _internalSet(final String name, final int[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmIntAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
    newValue.setOperation(op);
    EList<Integer> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Integer>)Conversions.doWrapArray(values)));
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final Short value) {
    short _shortValue = value.shortValue();
    final short[] arr = new short[] { _shortValue };
    this._internalSet(name, arr);
  }
  
  protected void _internalSet(final String name, final short[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmShortAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
    newValue.setOperation(op);
    EList<Short> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Short>)Conversions.doWrapArray(values)));
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final Long value) {
    long _longValue = value.longValue();
    final long[] arr = new long[] { _longValue };
    this._internalSet(name, arr);
  }
  
  protected void _internalSet(final String name, final long[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmLongAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
    newValue.setOperation(op);
    EList<Long> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Long>)Conversions.doWrapArray(values)));
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final Double value) {
    double _doubleValue = value.doubleValue();
    final double[] arr = new double[] { _doubleValue };
    this._internalSet(name, arr);
  }
  
  protected void _internalSet(final String name, final double[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmDoubleAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
    newValue.setOperation(op);
    EList<Double> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Double>)Conversions.doWrapArray(values)));
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final Float value) {
    float _floatValue = value.floatValue();
    final float[] arr = new float[] { _floatValue };
    this._internalSet(name, arr);
  }
  
  protected void _internalSet(final String name, final float[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmFloatAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
    newValue.setOperation(op);
    EList<Float> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Float>)Conversions.doWrapArray(values)));
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final Character value) {
    char _charValue = value.charValue();
    final char[] arr = new char[] { _charValue };
    this._internalSet(name, arr);
  }
  
  protected void _internalSet(final String name, final char[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmCharAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
    newValue.setOperation(op);
    EList<Character> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Character>)Conversions.doWrapArray(values)));
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final Byte value) {
    byte _byteValue = value.byteValue();
    final byte[] arr = new byte[] { _byteValue };
    this._internalSet(name, arr);
  }
  
  protected void _internalSet(final String name, final byte[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmByteAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
    newValue.setOperation(op);
    EList<Byte> _values = newValue.getValues();
    _values.addAll(((Collection<? extends Byte>)Conversions.doWrapArray(values)));
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final TypeReference value) {
    this._internalSet(name, new TypeReference[] { value });
  }
  
  protected void _internalSet(final String name, final TypeReference[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmTypeAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
    newValue.setOperation(op);
    final Procedure1<TypeReference> _function = new Procedure1<TypeReference>() {
      public void apply(final TypeReference it) {
        boolean _matched = false;
        if (!_matched) {
          if (it instanceof TypeReferenceImpl) {
            _matched=true;
            EList<JvmTypeReference> _values = newValue.getValues();
            CompilationUnitImpl _compilationUnit = ((TypeReferenceImpl)it).getCompilationUnit();
            JvmTypeReference _jvmTypeReference = _compilationUnit.toJvmTypeReference(it);
            _values.add(_jvmTypeReference);
          }
        }
      }
    };
    IterableExtensions.<TypeReference>forEach(((Iterable<TypeReference>)Conversions.doWrapArray(values)), _function);
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final EnumerationValueDeclaration value) {
    this._internalSet(name, new EnumerationValueDeclaration[] { value });
  }
  
  protected void _internalSet(final String name, final EnumerationValueDeclaration[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmEnumAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
    newValue.setOperation(op);
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
        if (!_matched) {
          if (it instanceof XtendEnumerationValueDeclarationImpl) {
            _matched=true;
            throw new IllegalArgumentException("Cannot set source elements.");
          }
        }
      }
    };
    IterableExtensions.<EnumerationValueDeclaration>forEach(((Iterable<EnumerationValueDeclaration>)Conversions.doWrapArray(values)), _function);
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final XtendAnnotationReferenceImpl value) {
    final JvmOperation op = this.findOperation(name);
    final JvmCustomAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmCustomAnnotationValue();
    newValue.setOperation(op);
    EList<Object> _values = newValue.getValues();
    XAnnotation _delegate = value.getDelegate();
    _values.add(_delegate);
    this.remove(op);
    JvmAnnotationReference _delegate_1 = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate_1.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final ExpressionImpl value) {
    final JvmOperation op = this.findOperation(name);
    final JvmCustomAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmCustomAnnotationValue();
    newValue.setOperation(op);
    EList<Object> _values = newValue.getValues();
    XExpression _delegate = value.getDelegate();
    _values.add(_delegate);
    this.remove(op);
    JvmAnnotationReference _delegate_1 = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate_1.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  protected void _internalSet(final String name, final AnnotationReference value) {
    this._internalSet(name, new AnnotationReference[] { value });
  }
  
  protected void _internalSet(final String name, final AnnotationReference[] values) {
    ConditionUtils.checkIterable(((Iterable<? extends Object>)Conversions.doWrapArray(values)), "values");
    final JvmOperation op = this.findOperation(name);
    final JvmAnnotationAnnotationValue newValue = TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue();
    newValue.setOperation(op);
    final Procedure1<AnnotationReference> _function = new Procedure1<AnnotationReference>() {
      public void apply(final AnnotationReference it) {
        boolean _matched = false;
        if (!_matched) {
          if (it instanceof JvmAnnotationReferenceImpl) {
            _matched=true;
            EList<JvmAnnotationReference> _values = newValue.getValues();
            JvmAnnotationReference _delegate = ((JvmAnnotationReferenceImpl)it).getDelegate();
            JvmAnnotationReference _cloneWithProxies = EcoreUtil2.<JvmAnnotationReference>cloneWithProxies(_delegate);
            _values.add(_cloneWithProxies);
          }
        }
        if (!_matched) {
          if (it instanceof XtendAnnotationReferenceImpl) {
            _matched=true;
            throw new IllegalArgumentException("Multiple source annotations cannot be set as values. Please the the expression not the value.");
          }
        }
      }
    };
    IterableExtensions.<AnnotationReference>forEach(((Iterable<AnnotationReference>)Conversions.doWrapArray(values)), _function);
    this.remove(op);
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    _explicitValues.add(newValue);
  }
  
  public boolean remove(final String name) {
    final JvmOperation op = this.findOperation(name);
    return this.remove(op);
  }
  
  private boolean remove(final JvmOperation op) {
    JvmAnnotationReference _delegate = this.getDelegate();
    EList<JvmAnnotationValue> _explicitValues = _delegate.getExplicitValues();
    Iterator<JvmAnnotationValue> _iterator = _explicitValues.iterator();
    final Predicate<JvmAnnotationValue> _function = new Predicate<JvmAnnotationValue>() {
      public boolean apply(final JvmAnnotationValue it) {
        boolean _or = false;
        JvmOperation _operation = it.getOperation();
        boolean _equals = Objects.equal(op, _operation);
        if (_equals) {
          _or = true;
        } else {
          boolean _and = false;
          JvmOperation _operation_1 = it.getOperation();
          boolean _equals_1 = Objects.equal(_operation_1, null);
          if (!_equals_1) {
            _and = false;
          } else {
            String _simpleName = op.getSimpleName();
            boolean _equals_2 = Objects.equal(_simpleName, "value");
            _and = _equals_2;
          }
          _or = _and;
        }
        return _or;
      }
    };
    return Iterators.<JvmAnnotationValue>removeIf(_iterator, _function);
  }
  
  private JvmOperation findOperation(final String name) {
    ConditionUtils.checkJavaIdentifier(name, "name");
    AnnotationTypeDeclaration _annotationTypeDeclaration = this.getAnnotationTypeDeclaration();
    final JvmAnnotationType jvmAnnoType = ((JvmAnnotationTypeDeclarationImpl) _annotationTypeDeclaration).getDelegate();
    Iterable<JvmOperation> _declaredOperations = jvmAnnoType.getDeclaredOperations();
    final Function1<JvmOperation,Boolean> _function = new Function1<JvmOperation,Boolean>() {
      public Boolean apply(final JvmOperation it) {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, name));
      }
    };
    final JvmOperation jvmOperation = IterableExtensions.<JvmOperation>findFirst(_declaredOperations, _function);
    boolean _equals = Objects.equal(jvmOperation, null);
    if (_equals) {
      String _identifier = jvmAnnoType.getIdentifier();
      String _plus = ((("The annotation property \'" + name) + "\' is not declared on the annotation type \'") + _identifier);
      String _plus_1 = (_plus + "\'.");
      throw new IllegalArgumentException(_plus_1);
    }
    return jvmOperation;
  }
  
  public void setExpression(final String name, final Expression value) {
    this.internalSet(name, value);
  }
  
  public void setAnnotationValue(final String name, final AnnotationReference... value) {
    this.internalSet(name, value);
  }
  
  public void setBooleanValue(final String name, final boolean... value) {
    this._internalSet(name, value);
  }
  
  public void setByteValue(final String name, final byte... value) {
    this._internalSet(name, value);
  }
  
  public void setCharValue(final String name, final char... value) {
    this._internalSet(name, value);
  }
  
  public void setClassValue(final String name, final TypeReference... value) {
    this._internalSet(name, value);
  }
  
  public void setDoubleValue(final String name, final double... value) {
    this._internalSet(name, value);
  }
  
  public void setEnumValue(final String name, final EnumerationValueDeclaration... value) {
    this._internalSet(name, value);
  }
  
  public void setFloatValue(final String name, final float... value) {
    this._internalSet(name, value);
  }
  
  public void setIntValue(final String name, final int... value) {
    this._internalSet(name, value);
  }
  
  public void setLongValue(final String name, final long... value) {
    this._internalSet(name, value);
  }
  
  public void setShortValue(final String name, final short... value) {
    this._internalSet(name, value);
  }
  
  public void setStringValue(final String name, final String... value) {
    this._internalSet(name, value);
  }
  
  public AnnotationReference getAnnotationValue(final String name) {
    Object _value = this.getValue(name);
    return ((AnnotationReference) _value);
  }
  
  public AnnotationReference[] getAnnotationArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((AnnotationReference[]) _value);
  }
  
  public boolean[] getBooleanArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((boolean[]) _value);
  }
  
  public boolean getBooleanValue(final String name) {
    Object _value = this.getValue(name);
    return (((Boolean) _value)).booleanValue();
  }
  
  public byte[] getByteArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((byte[]) _value);
  }
  
  public byte getByteValue(final String name) {
    Object _value = this.getValue(name);
    return (((Byte) _value)).byteValue();
  }
  
  public char[] getCharArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((char[]) _value);
  }
  
  public char getCharValue(final String name) {
    Object _value = this.getValue(name);
    return (((Character) _value)).charValue();
  }
  
  public TypeReference getClassValue(final String name) {
    Object _value = this.getValue(name);
    return ((TypeReference) _value);
  }
  
  public TypeReference[] getClassArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((TypeReference[]) _value);
  }
  
  public double[] getDoubleArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((double[]) _value);
  }
  
  public double getDoubleValue(final String name) {
    Object _value = this.getValue(name);
    return (((Double) _value)).doubleValue();
  }
  
  public EnumerationValueDeclaration getEnumValue(final String name) {
    Object _value = this.getValue(name);
    return ((EnumerationValueDeclaration) _value);
  }
  
  public EnumerationValueDeclaration[] getEnumArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((EnumerationValueDeclaration[]) _value);
  }
  
  public float[] getFloatArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((float[]) _value);
  }
  
  public float getFloatValue(final String name) {
    Object _value = this.getValue(name);
    return (((Float) _value)).floatValue();
  }
  
  public int[] getIntArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((int[]) _value);
  }
  
  public int getIntValue(final String name) {
    Object _value = this.getValue(name);
    return (((Integer) _value)).intValue();
  }
  
  public long[] getLongArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((long[]) _value);
  }
  
  public long getLongValue(final String name) {
    Object _value = this.getValue(name);
    return (((Long) _value)).longValue();
  }
  
  public short[] getShortArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((short[]) _value);
  }
  
  public short getShortValue(final String name) {
    Object _value = this.getValue(name);
    return (((Short) _value)).shortValue();
  }
  
  public String[] getStringArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((String[]) _value);
  }
  
  public String getStringValue(final String name) {
    Object _value = this.getValue(name);
    return ((String) _value);
  }
  
  public void internalSet(final String name, final Object value) {
    if (value instanceof EnumerationValueDeclaration) {
      _internalSet(name, (EnumerationValueDeclaration)value);
      return;
    } else if (value instanceof Byte) {
      _internalSet(name, (Byte)value);
      return;
    } else if (value instanceof Double) {
      _internalSet(name, (Double)value);
      return;
    } else if (value instanceof Float) {
      _internalSet(name, (Float)value);
      return;
    } else if (value instanceof Integer) {
      _internalSet(name, (Integer)value);
      return;
    } else if (value instanceof Long) {
      _internalSet(name, (Long)value);
      return;
    } else if (value instanceof Short) {
      _internalSet(name, (Short)value);
      return;
    } else if (value instanceof ExpressionImpl) {
      _internalSet(name, (ExpressionImpl)value);
      return;
    } else if (value instanceof XtendAnnotationReferenceImpl) {
      _internalSet(name, (XtendAnnotationReferenceImpl)value);
      return;
    } else if (value instanceof Boolean) {
      _internalSet(name, (Boolean)value);
      return;
    } else if (value instanceof Character) {
      _internalSet(name, (Character)value);
      return;
    } else if (value instanceof String) {
      _internalSet(name, (String)value);
      return;
    } else if (value instanceof AnnotationReference) {
      _internalSet(name, (AnnotationReference)value);
      return;
    } else if (value instanceof TypeReference) {
      _internalSet(name, (TypeReference)value);
      return;
    } else if (value instanceof boolean[]) {
      _internalSet(name, (boolean[])value);
      return;
    } else if (value instanceof byte[]) {
      _internalSet(name, (byte[])value);
      return;
    } else if (value instanceof char[]) {
      _internalSet(name, (char[])value);
      return;
    } else if (value instanceof double[]) {
      _internalSet(name, (double[])value);
      return;
    } else if (value instanceof float[]) {
      _internalSet(name, (float[])value);
      return;
    } else if (value instanceof int[]) {
      _internalSet(name, (int[])value);
      return;
    } else if (value instanceof String[]) {
      _internalSet(name, (String[])value);
      return;
    } else if (value == null) {
      _internalSet(name, (Void)null);
      return;
    } else if (value instanceof long[]) {
      _internalSet(name, (long[])value);
      return;
    } else if (value instanceof AnnotationReference[]) {
      _internalSet(name, (AnnotationReference[])value);
      return;
    } else if (value instanceof EnumerationValueDeclaration[]) {
      _internalSet(name, (EnumerationValueDeclaration[])value);
      return;
    } else if (value instanceof TypeReference[]) {
      _internalSet(name, (TypeReference[])value);
      return;
    } else if (value instanceof short[]) {
      _internalSet(name, (short[])value);
      return;
    } else if (value != null) {
      _internalSet(name, value);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(name, value).toString());
    }
  }
}
