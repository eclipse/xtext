/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtend.core.macro.ConditionUtils;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.services.AnnotationReferenceBuildContext;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmAnnotationAnnotationValue;
import org.eclipse.xtext.common.types.JvmAnnotationReference;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmAnnotationValue;
import org.eclipse.xtext.common.types.JvmArrayType;
import org.eclipse.xtext.common.types.JvmBooleanAnnotationValue;
import org.eclipse.xtext.common.types.JvmByteAnnotationValue;
import org.eclipse.xtext.common.types.JvmCharAnnotationValue;
import org.eclipse.xtext.common.types.JvmCustomAnnotationValue;
import org.eclipse.xtext.common.types.JvmDoubleAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumAnnotationValue;
import org.eclipse.xtext.common.types.JvmEnumerationType;
import org.eclipse.xtext.common.types.JvmFloatAnnotationValue;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.common.types.JvmIntAnnotationValue;
import org.eclipse.xtext.common.types.JvmLongAnnotationValue;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmPrimitiveType;
import org.eclipse.xtext.common.types.JvmShortAnnotationValue;
import org.eclipse.xtext.common.types.JvmStringAnnotationValue;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeAnnotationValue;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class AnnotationReferenceBuildContextImpl implements AnnotationReferenceBuildContext {
  @Accessors
  private JvmAnnotationReference delegate;

  @Accessors
  private CompilationUnitImpl compilationUnit;

  protected JvmOperation findOperation(final String name) {
    ConditionUtils.checkJavaIdentifier(name, "name");
    final JvmAnnotationType annotationType = this.delegate.getAnnotation();
    final Function1<JvmOperation, Boolean> _function = (JvmOperation it) -> {
      String _simpleName = it.getSimpleName();
      return Boolean.valueOf(Objects.equal(_simpleName, name));
    };
    final JvmOperation jvmOperation = IterableExtensions.<JvmOperation>findFirst(annotationType.getDeclaredOperations(), _function);
    if ((jvmOperation == null)) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The annotation property \'");
      _builder.append(name);
      _builder.append("\' is not declared on the annotation type \'");
      String _identifier = annotationType.getIdentifier();
      _builder.append(_identifier);
      _builder.append("\'.");
      throw new IllegalArgumentException(_builder.toString());
    }
    return jvmOperation;
  }

  protected boolean remove(final String name) {
    final JvmOperation op = this.findOperation(name);
    return this.remove(op);
  }

  protected boolean remove(final JvmOperation op) {
    final Predicate<JvmAnnotationValue> _function = (JvmAnnotationValue it) -> {
      return (Objects.equal(op, it.getOperation()) || ((it.getOperation() == null) && Objects.equal(op.getSimpleName(), "value")));
    };
    return Iterators.<JvmAnnotationValue>removeIf(this.delegate.getExplicitValues().iterator(), _function);
  }

  protected JvmOperation findOperation(final String name, final boolean mustBeArray) {
    final JvmOperation result = this.findOperation(name);
    JvmTypeReference _returnType = result.getReturnType();
    JvmType _type = null;
    if (_returnType!=null) {
      _type=_returnType.getType();
    }
    final JvmType returnType = _type;
    boolean _and = false;
    if (!mustBeArray) {
      _and = false;
    } else {
      EClass _eClass = null;
      if (returnType!=null) {
        _eClass=returnType.eClass();
      }
      boolean _notEquals = (!Objects.equal(_eClass, TypesPackage.Literals.JVM_ARRAY_TYPE));
      _and = _notEquals;
    }
    if (_and) {
      throw new IllegalArgumentException("Cannot assign array value to simple annotation property");
    }
    return result;
  }

  @Override
  public void set(final String name, final Object value) {
    this.internalSet(name, value, false);
  }

  @Override
  public void setAnnotationValue(final String name, final AnnotationReference... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this.internalSet(name, value, _notEquals);
  }

  @Override
  public void setBooleanValue(final String name, final boolean... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  @Override
  public void setByteValue(final String name, final byte... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  @Override
  public void setCharValue(final String name, final char... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  @Override
  public void setClassValue(final String name, final TypeReference... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  @Override
  public void setDoubleValue(final String name, final double... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  @Override
  public void setEnumValue(final String name, final EnumerationValueDeclaration... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  @Override
  public void setFloatValue(final String name, final float... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  @Override
  public void setIntValue(final String name, final int... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  @Override
  public void setLongValue(final String name, final long... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  @Override
  public void setShortValue(final String name, final short... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  @Override
  public void setStringValue(final String name, final String... value) {
    int _length = value.length;
    boolean _notEquals = (_length != 1);
    this._internalSet(name, value, _notEquals);
  }

  protected void _internalSet(final String name, final Void value, final boolean mustBeArray) {
    this.remove(name);
  }

  protected void _internalSet(final String name, final Object values, final boolean mustBeArray) {
    String _canonicalName = values.getClass().getCanonicalName();
    String _plus = ("Cannot set annotation values of type " + _canonicalName);
    throw new IllegalArgumentException(_plus);
  }

  protected void _internalSet(final String name, final String value, final boolean mustBeArray) {
    final String[] arr = { value };
    this._internalSet(name, arr, false);
  }

  protected void _internalSet(final String name, final String[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    this.setValues(name, values, String.class.getName(), mustBeArray);
  }

  protected void _internalSet(final String name, final Boolean value, final boolean mustBeArray) {
    boolean _booleanValue = value.booleanValue();
    final boolean[] arr = new boolean[] { _booleanValue };
    this._internalSet(name, arr, false);
  }

  protected void _internalSet(final String name, final boolean[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    this.setValues(name, values, "boolean", mustBeArray);
  }

  protected void _internalSet(final String name, final Integer value, final boolean mustBeArray) {
    int _intValue = value.intValue();
    final int[] arr = new int[] { _intValue };
    this._internalSet(name, arr, false);
  }

  protected void _internalSet(final String name, final int[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    this.setValues(name, values, "int", mustBeArray);
  }

  protected void _internalSet(final String name, final Short value, final boolean mustBeArray) {
    short _shortValue = value.shortValue();
    final short[] arr = new short[] { _shortValue };
    this._internalSet(name, arr, false);
  }

  protected void _internalSet(final String name, final short[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    this.setValues(name, values, "short", mustBeArray);
  }

  protected void _internalSet(final String name, final Long value, final boolean mustBeArray) {
    long _longValue = value.longValue();
    final long[] arr = new long[] { _longValue };
    this._internalSet(name, arr, false);
  }

  protected void _internalSet(final String name, final long[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    this.setValues(name, values, "long", mustBeArray);
  }

  protected void _internalSet(final String name, final Double value, final boolean mustBeArray) {
    double _doubleValue = value.doubleValue();
    final double[] arr = new double[] { _doubleValue };
    this._internalSet(name, arr, false);
  }

  protected void _internalSet(final String name, final double[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    this.setValues(name, values, "double", mustBeArray);
  }

  protected void _internalSet(final String name, final Float value, final boolean mustBeArray) {
    float _floatValue = value.floatValue();
    final float[] arr = new float[] { _floatValue };
    this._internalSet(name, arr, false);
  }

  protected void _internalSet(final String name, final float[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    this.setValues(name, values, "float", mustBeArray);
  }

  protected void _internalSet(final String name, final Character value, final boolean mustBeArray) {
    char _charValue = value.charValue();
    final char[] arr = new char[] { _charValue };
    this._internalSet(name, arr, false);
  }

  protected void _internalSet(final String name, final char[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    this.setValues(name, values, "char", mustBeArray);
  }

  protected void _internalSet(final String name, final Byte value, final boolean mustBeArray) {
    byte _byteValue = value.byteValue();
    final byte[] arr = new byte[] { _byteValue };
    this._internalSet(name, arr, false);
  }

  protected void _internalSet(final String name, final byte[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    this.setValues(name, values, "byte", mustBeArray);
  }

  protected void _internalSet(final String name, final TypeReference value, final boolean mustBeArray) {
    this._internalSet(name, new TypeReference[] { value }, false);
  }

  protected void _internalSet(final String name, final TypeReference[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    this.setValues(name, values, TypeReference.class.getName(), mustBeArray);
  }

  protected void _internalSet(final String name, final EnumerationValueDeclaration[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    EnumerationValueDeclaration _head = IterableExtensions.<EnumerationValueDeclaration>head(((Iterable<EnumerationValueDeclaration>)Conversions.doWrapArray(values)));
    EnumerationTypeDeclaration _declaringType = null;
    if (_head!=null) {
      _declaringType=_head.getDeclaringType();
    }
    String _qualifiedName = null;
    if (_declaringType!=null) {
      _qualifiedName=_declaringType.getQualifiedName();
    }
    this.setValues(name, values, _qualifiedName, mustBeArray);
  }

  protected void _internalSet(final String name, final XtendAnnotationReferenceImpl value, final boolean mustBeArray) {
    this.setValues(name, value, null, mustBeArray);
  }

  protected void _internalSet(final String name, final AnnotationReference value, final boolean mustBeArray) {
    this._internalSet(name, new AnnotationReference[] { value }, false);
  }

  protected void _internalSet(final String name, final AnnotationReference[] values, final boolean mustBeArray) {
    ConditionUtils.checkIterable(((Iterable<?>)Conversions.doWrapArray(values)), "values");
    AnnotationReference _head = IterableExtensions.<AnnotationReference>head(((Iterable<AnnotationReference>)Conversions.doWrapArray(values)));
    AnnotationTypeDeclaration _annotationTypeDeclaration = null;
    if (_head!=null) {
      _annotationTypeDeclaration=_head.getAnnotationTypeDeclaration();
    }
    String _qualifiedName = null;
    if (_annotationTypeDeclaration!=null) {
      _qualifiedName=_annotationTypeDeclaration.getQualifiedName();
    }
    this.setValues(name, values, _qualifiedName, mustBeArray);
  }

  protected void _internalSet(final String name, final EnumerationValueDeclaration value, final boolean mustBeArray) {
    this._internalSet(name, new EnumerationValueDeclaration[] { value }, false);
  }

  protected void setValues(final String name, final Object values, final String componentType, final boolean mustBeArray) {
    final JvmOperation op = this.findOperation(name, mustBeArray);
    final JvmAnnotationValue newValue = this.createAnnotationValue(op, values);
    newValue.setOperation(op);
    this.setValue(newValue, values, componentType, mustBeArray);
    this.remove(op);
    this.delegate.getExplicitValues().add(newValue);
  }

  protected JvmAnnotationValue createAnnotationValue(final JvmOperation op, final Object values) {
    JvmAnnotationValue _xblockexpression = null;
    {
      JvmTypeReference _returnType = op.getReturnType();
      JvmType _type = null;
      if (_returnType!=null) {
        _type=_returnType.getType();
      }
      final JvmType returnType = _type;
      JvmAnnotationValue _switchResult = null;
      JvmType _xifexpression = null;
      if ((returnType instanceof JvmArrayType)) {
        _xifexpression = ((JvmArrayType)returnType).getComponentType();
      } else {
        _xifexpression = returnType;
      }
      final JvmType type = _xifexpression;
      boolean _matched = false;
      if (type instanceof JvmPrimitiveType) {
        _matched=true;
        JvmAnnotationValue _switchResult_1 = null;
        String _simpleName = ((JvmPrimitiveType)type).getSimpleName();
        if (_simpleName != null) {
          switch (_simpleName) {
            case "boolean":
              _switchResult_1 = TypesFactory.eINSTANCE.createJvmBooleanAnnotationValue();
              break;
            case "double":
              _switchResult_1 = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
              break;
            case "float":
              _switchResult_1 = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
              break;
            case "long":
              _switchResult_1 = TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
              break;
            case "int":
              _switchResult_1 = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
              break;
            case "short":
              _switchResult_1 = TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
              break;
            case "char":
              _switchResult_1 = TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
              break;
            case "byte":
              _switchResult_1 = TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
              break;
            default:
              throw new IllegalStateException(("Unknown type: " + type));
          }
        } else {
          throw new IllegalStateException(("Unknown type: " + type));
        }
        _switchResult = _switchResult_1;
      }
      if (!_matched) {
        if (type instanceof JvmGenericType) {
          _matched=true;
          JvmAnnotationValue _switchResult_1 = null;
          String _identifier = ((JvmGenericType)type).getIdentifier();
          boolean _matched_1 = false;
          String _name = String.class.getName();
          if (Objects.equal(_identifier, _name)) {
            _matched_1=true;
            _switchResult_1 = TypesFactory.eINSTANCE.createJvmStringAnnotationValue();
          }
          if (!_matched_1) {
            String _name_1 = Class.class.getName();
            if (Objects.equal(_identifier, _name_1)) {
              _matched_1=true;
              _switchResult_1 = TypesFactory.eINSTANCE.createJvmTypeAnnotationValue();
            }
          }
          if (!_matched_1) {
            throw new IllegalStateException(("Unknown type: " + type));
          }
          _switchResult = _switchResult_1;
        }
      }
      if (!_matched) {
        if (type instanceof JvmEnumerationType) {
          _matched=true;
          _switchResult = TypesFactory.eINSTANCE.createJvmEnumAnnotationValue();
        }
      }
      if (!_matched) {
        if (type instanceof JvmAnnotationType) {
          _matched=true;
          JvmAnnotationValue _xifexpression_1 = null;
          if ((values instanceof XtendAnnotationReferenceImpl)) {
            _xifexpression_1 = TypesFactory.eINSTANCE.createJvmCustomAnnotationValue();
          } else {
            _xifexpression_1 = TypesFactory.eINSTANCE.createJvmAnnotationAnnotationValue();
          }
          _switchResult = _xifexpression_1;
        }
      }
      if (!_matched) {
        throw new IllegalStateException(("Unknown type: " + type));
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  protected void _setValue(final JvmAnnotationValue it, final Object value, final String componentType, final boolean mustBeArray) {
    if ((componentType == null)) {
      this.throwNotApplicable(it, value.getClass().getName());
    }
    boolean _or = false;
    if (mustBeArray) {
      _or = true;
    } else {
      JvmTypeReference _returnType = it.getOperation().getReturnType();
      JvmType _type = null;
      if (_returnType!=null) {
        _type=_returnType.getType();
      }
      EClass _eClass = null;
      if (_type!=null) {
        _eClass=_type.eClass();
      }
      boolean _equals = Objects.equal(_eClass, TypesPackage.Literals.JVM_ARRAY_TYPE);
      _or = _equals;
    }
    if (_or) {
      this.throwNotApplicable(it, (componentType + "[]"));
    }
    this.throwNotApplicable(it, componentType);
  }

  protected void _setValue(final JvmTypeAnnotationValue it, final TypeReference[] value, final String componentType, final boolean mustBeArray) {
    EList<JvmTypeReference> _values = it.getValues();
    final Function1<TypeReferenceImpl, JvmTypeReference> _function = (TypeReferenceImpl it_1) -> {
      return this.compilationUnit.toJvmTypeReference(it_1);
    };
    Iterable<JvmTypeReference> _map = IterableExtensions.<TypeReferenceImpl, JvmTypeReference>map(Iterables.<TypeReferenceImpl>filter(((Iterable<?>)Conversions.doWrapArray(value)), TypeReferenceImpl.class), _function);
    Iterables.<JvmTypeReference>addAll(_values, _map);
  }

  protected void _setValue(final JvmEnumAnnotationValue it, final EnumerationValueDeclaration[] value, final String componentType, final boolean mustBeArray) {
    this.checkType(it, componentType, mustBeArray);
    for (final EnumerationValueDeclaration enumValue : value) {
      boolean _matched = false;
      if (enumValue instanceof JvmEnumerationValueDeclarationImpl) {
        _matched=true;
        it.getValues().add(((JvmEnumerationValueDeclarationImpl)enumValue).getDelegate());
      }
      if (!_matched) {
        if (enumValue instanceof XtendEnumerationValueDeclarationImpl) {
          _matched=true;
          throw new IllegalArgumentException("Cannot set source elements.");
        }
      }
    }
  }

  protected void _setValue(final JvmAnnotationAnnotationValue it, final AnnotationReference[] value, final String componentType, final boolean mustBeArray) {
    this.checkType(it, componentType, mustBeArray);
    for (final AnnotationReference annotationValue : value) {
      boolean _matched = false;
      if (annotationValue instanceof JvmAnnotationReferenceImpl) {
        _matched=true;
        it.getValues().add(EcoreUtil2.<JvmAnnotationReference>cloneWithProxies(((JvmAnnotationReferenceImpl)annotationValue).getDelegate()));
      }
      if (!_matched) {
        if (annotationValue instanceof XtendAnnotationReferenceImpl) {
          _matched=true;
          throw new IllegalArgumentException("Multiple source annotations cannot be set as values. Please the the expression not the value.");
        }
      }
    }
  }

  protected void _setValue(final JvmCustomAnnotationValue it, final XtendAnnotationReferenceImpl value, final String componentType, final boolean mustBeArray) {
    it.getValues().add(value.getDelegate());
  }

  protected void _setValue(final JvmStringAnnotationValue it, final String[] value, final String componentType, final boolean mustBeArray) {
    EList<String> _values = it.getValues();
    Iterables.<String>addAll(_values, ((Iterable<? extends String>)Conversions.doWrapArray(value)));
  }

  protected void _setValue(final JvmBooleanAnnotationValue it, final boolean[] value, final String componentType, final boolean mustBeArray) {
    EList<Boolean> _values = it.getValues();
    Iterables.<Boolean>addAll(_values, ((Iterable<? extends Boolean>)Conversions.doWrapArray(value)));
  }

  protected void _setValue(final JvmDoubleAnnotationValue it, final double[] value, final String componentType, final boolean mustBeArray) {
    EList<Double> _values = it.getValues();
    Iterables.<Double>addAll(_values, ((Iterable<? extends Double>)Conversions.doWrapArray(value)));
  }

  protected void _setValue(final JvmDoubleAnnotationValue it, final float[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Float> _function = (Float v) -> {
      EList<Double> _values = it.getValues();
      _values.add(Double.valueOf(((double) (v).floatValue())));
    };
    ((List<Float>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmDoubleAnnotationValue it, final long[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Long> _function = (Long v) -> {
      EList<Double> _values = it.getValues();
      _values.add(Double.valueOf(((double) (v).longValue())));
    };
    ((List<Long>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmDoubleAnnotationValue it, final int[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Integer> _function = (Integer v) -> {
      EList<Double> _values = it.getValues();
      _values.add(Double.valueOf(((double) (v).intValue())));
    };
    ((List<Integer>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmDoubleAnnotationValue it, final short[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Short> _function = (Short v) -> {
      EList<Double> _values = it.getValues();
      _values.add(Double.valueOf(((double) (v).shortValue())));
    };
    ((List<Short>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmDoubleAnnotationValue it, final byte[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Byte> _function = (Byte v) -> {
      EList<Double> _values = it.getValues();
      _values.add(Double.valueOf(((double) (v).byteValue())));
    };
    ((List<Byte>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmDoubleAnnotationValue it, final char[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Character> _function = (Character v) -> {
      EList<Double> _values = it.getValues();
      _values.add(Double.valueOf(((double) (v).charValue())));
    };
    ((List<Character>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmFloatAnnotationValue it, final float[] value, final String componentType, final boolean mustBeArray) {
    EList<Float> _values = it.getValues();
    Iterables.<Float>addAll(_values, ((Iterable<? extends Float>)Conversions.doWrapArray(value)));
  }

  protected void _setValue(final JvmFloatAnnotationValue it, final long[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Long> _function = (Long v) -> {
      EList<Float> _values = it.getValues();
      _values.add(Float.valueOf(((float) (v).longValue())));
    };
    ((List<Long>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmFloatAnnotationValue it, final int[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Integer> _function = (Integer v) -> {
      EList<Float> _values = it.getValues();
      _values.add(Float.valueOf(((float) (v).intValue())));
    };
    ((List<Integer>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmFloatAnnotationValue it, final short[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Short> _function = (Short v) -> {
      EList<Float> _values = it.getValues();
      _values.add(Float.valueOf(((float) (v).shortValue())));
    };
    ((List<Short>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmFloatAnnotationValue it, final byte[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Byte> _function = (Byte v) -> {
      EList<Float> _values = it.getValues();
      _values.add(Float.valueOf(((float) (v).byteValue())));
    };
    ((List<Byte>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmFloatAnnotationValue it, final char[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Character> _function = (Character v) -> {
      EList<Float> _values = it.getValues();
      _values.add(Float.valueOf(((float) (v).charValue())));
    };
    ((List<Character>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmLongAnnotationValue it, final long[] value, final String componentType, final boolean mustBeArray) {
    EList<Long> _values = it.getValues();
    Iterables.<Long>addAll(_values, ((Iterable<? extends Long>)Conversions.doWrapArray(value)));
  }

  protected void _setValue(final JvmLongAnnotationValue it, final int[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Integer> _function = (Integer v) -> {
      EList<Long> _values = it.getValues();
      _values.add(Long.valueOf(((long) (v).intValue())));
    };
    ((List<Integer>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmLongAnnotationValue it, final short[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Short> _function = (Short v) -> {
      EList<Long> _values = it.getValues();
      _values.add(Long.valueOf(((long) (v).shortValue())));
    };
    ((List<Short>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmLongAnnotationValue it, final byte[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Byte> _function = (Byte v) -> {
      EList<Long> _values = it.getValues();
      _values.add(Long.valueOf(((long) (v).byteValue())));
    };
    ((List<Byte>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmLongAnnotationValue it, final char[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Character> _function = (Character v) -> {
      EList<Long> _values = it.getValues();
      _values.add(Long.valueOf(((long) (v).charValue())));
    };
    ((List<Character>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmIntAnnotationValue it, final int[] value, final String componentType, final boolean mustBeArray) {
    EList<Integer> _values = it.getValues();
    Iterables.<Integer>addAll(_values, ((Iterable<? extends Integer>)Conversions.doWrapArray(value)));
  }

  protected void _setValue(final JvmIntAnnotationValue it, final short[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Short> _function = (Short v) -> {
      EList<Integer> _values = it.getValues();
      _values.add(Integer.valueOf(((int) (v).shortValue())));
    };
    ((List<Short>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmIntAnnotationValue it, final byte[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Byte> _function = (Byte v) -> {
      EList<Integer> _values = it.getValues();
      _values.add(Integer.valueOf(((int) (v).byteValue())));
    };
    ((List<Byte>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmIntAnnotationValue it, final char[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Character> _function = (Character v) -> {
      EList<Integer> _values = it.getValues();
      _values.add(Integer.valueOf(((int) (v).charValue())));
    };
    ((List<Character>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmShortAnnotationValue it, final short[] value, final String componentType, final boolean mustBeArray) {
    EList<Short> _values = it.getValues();
    Iterables.<Short>addAll(_values, ((Iterable<? extends Short>)Conversions.doWrapArray(value)));
  }

  protected void _setValue(final JvmShortAnnotationValue it, final byte[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Byte> _function = (Byte v) -> {
      EList<Short> _values = it.getValues();
      _values.add(Short.valueOf(((short) (v).byteValue())));
    };
    ((List<Byte>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmCharAnnotationValue it, final char[] value, final String componentType, final boolean mustBeArray) {
    EList<Character> _values = it.getValues();
    Iterables.<Character>addAll(_values, ((Iterable<? extends Character>)Conversions.doWrapArray(value)));
  }

  protected void _setValue(final JvmCharAnnotationValue it, final byte[] value, final String componentType, final boolean mustBeArray) {
    final Consumer<Byte> _function = (Byte v) -> {
      EList<Character> _values = it.getValues();
      _values.add(Character.valueOf(((char) (v).byteValue())));
    };
    ((List<Byte>)Conversions.doWrapArray(value)).forEach(_function);
  }

  protected void _setValue(final JvmByteAnnotationValue it, final byte[] value, final String componentType, final boolean mustBeArray) {
    EList<Byte> _values = it.getValues();
    Iterables.<Byte>addAll(_values, ((Iterable<? extends Byte>)Conversions.doWrapArray(value)));
  }

  protected void checkType(final JvmAnnotationValue it, final String componentType, final boolean mustBeArray) {
    if ((componentType == null)) {
      return;
    }
    JvmTypeReference _returnType = it.getOperation().getReturnType();
    JvmType _type = null;
    if (_returnType!=null) {
      _type=_returnType.getType();
    }
    final JvmType returnType = _type;
    boolean _or = false;
    if (mustBeArray) {
      _or = true;
    } else {
      EClass _eClass = null;
      if (returnType!=null) {
        _eClass=returnType.eClass();
      }
      boolean _equals = Objects.equal(_eClass, TypesPackage.Literals.JVM_ARRAY_TYPE);
      _or = _equals;
    }
    if (_or) {
      ConditionUtils.checkTypeName(this.getAnnotationValueTypeName(returnType), (componentType + "[]"));
    } else {
      ConditionUtils.checkTypeName(this.getAnnotationValueTypeName(returnType), componentType);
    }
  }

  protected void throwNotApplicable(final JvmAnnotationValue it, final String valueType) {
    JvmTypeReference _returnType = it.getOperation().getReturnType();
    JvmType _type = null;
    if (_returnType!=null) {
      _type=_returnType.getType();
    }
    String _isNotApplicableMessage = ConditionUtils.isNotApplicableMessage(valueType, this.getAnnotationValueTypeName(_type));
    throw new IllegalArgumentException(_isNotApplicableMessage);
  }

  protected String getAnnotationValueTypeName(final JvmType type) {
    String _switchResult = null;
    String _identifier = null;
    if (type!=null) {
      _identifier=type.getIdentifier();
    }
    String _replace = null;
    if (_identifier!=null) {
      _replace=_identifier.replace("$", ".");
    }
    final String result = _replace;
    if (result != null) {
      switch (result) {
        case "java.lang.Class":
          _switchResult = TypeReference.class.getName();
          break;
        case "java.lang.Class[]":
          String _name = TypeReference.class.getName();
          _switchResult = (_name + "[]");
          break;
        default:
          _switchResult = result;
          break;
      }
    } else {
      _switchResult = result;
    }
    return _switchResult;
  }

  public void internalSet(final String name, final Object value, final boolean mustBeArray) {
    if (value instanceof EnumerationValueDeclaration) {
      _internalSet(name, (EnumerationValueDeclaration)value, mustBeArray);
      return;
    } else if (value instanceof Byte) {
      _internalSet(name, (Byte)value, mustBeArray);
      return;
    } else if (value instanceof Double) {
      _internalSet(name, (Double)value, mustBeArray);
      return;
    } else if (value instanceof Float) {
      _internalSet(name, (Float)value, mustBeArray);
      return;
    } else if (value instanceof Integer) {
      _internalSet(name, (Integer)value, mustBeArray);
      return;
    } else if (value instanceof Long) {
      _internalSet(name, (Long)value, mustBeArray);
      return;
    } else if (value instanceof Short) {
      _internalSet(name, (Short)value, mustBeArray);
      return;
    } else if (value instanceof XtendAnnotationReferenceImpl) {
      _internalSet(name, (XtendAnnotationReferenceImpl)value, mustBeArray);
      return;
    } else if (value instanceof Boolean) {
      _internalSet(name, (Boolean)value, mustBeArray);
      return;
    } else if (value instanceof Character) {
      _internalSet(name, (Character)value, mustBeArray);
      return;
    } else if (value instanceof String) {
      _internalSet(name, (String)value, mustBeArray);
      return;
    } else if (value instanceof AnnotationReference) {
      _internalSet(name, (AnnotationReference)value, mustBeArray);
      return;
    } else if (value instanceof TypeReference) {
      _internalSet(name, (TypeReference)value, mustBeArray);
      return;
    } else if (value instanceof boolean[]) {
      _internalSet(name, (boolean[])value, mustBeArray);
      return;
    } else if (value instanceof byte[]) {
      _internalSet(name, (byte[])value, mustBeArray);
      return;
    } else if (value instanceof char[]) {
      _internalSet(name, (char[])value, mustBeArray);
      return;
    } else if (value instanceof double[]) {
      _internalSet(name, (double[])value, mustBeArray);
      return;
    } else if (value instanceof float[]) {
      _internalSet(name, (float[])value, mustBeArray);
      return;
    } else if (value instanceof int[]) {
      _internalSet(name, (int[])value, mustBeArray);
      return;
    } else if (value instanceof String[]) {
      _internalSet(name, (String[])value, mustBeArray);
      return;
    } else if (value == null) {
      _internalSet(name, (Void)null, mustBeArray);
      return;
    } else if (value instanceof long[]) {
      _internalSet(name, (long[])value, mustBeArray);
      return;
    } else if (value instanceof AnnotationReference[]) {
      _internalSet(name, (AnnotationReference[])value, mustBeArray);
      return;
    } else if (value instanceof EnumerationValueDeclaration[]) {
      _internalSet(name, (EnumerationValueDeclaration[])value, mustBeArray);
      return;
    } else if (value instanceof TypeReference[]) {
      _internalSet(name, (TypeReference[])value, mustBeArray);
      return;
    } else if (value instanceof short[]) {
      _internalSet(name, (short[])value, mustBeArray);
      return;
    } else if (value != null) {
      _internalSet(name, value, mustBeArray);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(name, value, mustBeArray).toString());
    }
  }

  protected void setValue(final JvmAnnotationValue it, final Object value, final String componentType, final boolean mustBeArray) {
    if (it instanceof JvmCustomAnnotationValue
         && value instanceof XtendAnnotationReferenceImpl) {
      _setValue((JvmCustomAnnotationValue)it, (XtendAnnotationReferenceImpl)value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmAnnotationAnnotationValue
         && value instanceof AnnotationReference[]) {
      _setValue((JvmAnnotationAnnotationValue)it, (AnnotationReference[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmBooleanAnnotationValue
         && value instanceof boolean[]) {
      _setValue((JvmBooleanAnnotationValue)it, (boolean[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmByteAnnotationValue
         && value instanceof byte[]) {
      _setValue((JvmByteAnnotationValue)it, (byte[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmCharAnnotationValue
         && value instanceof byte[]) {
      _setValue((JvmCharAnnotationValue)it, (byte[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmCharAnnotationValue
         && value instanceof char[]) {
      _setValue((JvmCharAnnotationValue)it, (char[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmDoubleAnnotationValue
         && value instanceof byte[]) {
      _setValue((JvmDoubleAnnotationValue)it, (byte[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmDoubleAnnotationValue
         && value instanceof char[]) {
      _setValue((JvmDoubleAnnotationValue)it, (char[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmDoubleAnnotationValue
         && value instanceof double[]) {
      _setValue((JvmDoubleAnnotationValue)it, (double[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmDoubleAnnotationValue
         && value instanceof float[]) {
      _setValue((JvmDoubleAnnotationValue)it, (float[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmDoubleAnnotationValue
         && value instanceof int[]) {
      _setValue((JvmDoubleAnnotationValue)it, (int[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmDoubleAnnotationValue
         && value instanceof long[]) {
      _setValue((JvmDoubleAnnotationValue)it, (long[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmDoubleAnnotationValue
         && value instanceof short[]) {
      _setValue((JvmDoubleAnnotationValue)it, (short[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmEnumAnnotationValue
         && value instanceof EnumerationValueDeclaration[]) {
      _setValue((JvmEnumAnnotationValue)it, (EnumerationValueDeclaration[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmFloatAnnotationValue
         && value instanceof byte[]) {
      _setValue((JvmFloatAnnotationValue)it, (byte[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmFloatAnnotationValue
         && value instanceof char[]) {
      _setValue((JvmFloatAnnotationValue)it, (char[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmFloatAnnotationValue
         && value instanceof float[]) {
      _setValue((JvmFloatAnnotationValue)it, (float[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmFloatAnnotationValue
         && value instanceof int[]) {
      _setValue((JvmFloatAnnotationValue)it, (int[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmFloatAnnotationValue
         && value instanceof long[]) {
      _setValue((JvmFloatAnnotationValue)it, (long[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmFloatAnnotationValue
         && value instanceof short[]) {
      _setValue((JvmFloatAnnotationValue)it, (short[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmIntAnnotationValue
         && value instanceof byte[]) {
      _setValue((JvmIntAnnotationValue)it, (byte[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmIntAnnotationValue
         && value instanceof char[]) {
      _setValue((JvmIntAnnotationValue)it, (char[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmIntAnnotationValue
         && value instanceof int[]) {
      _setValue((JvmIntAnnotationValue)it, (int[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmIntAnnotationValue
         && value instanceof short[]) {
      _setValue((JvmIntAnnotationValue)it, (short[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmLongAnnotationValue
         && value instanceof byte[]) {
      _setValue((JvmLongAnnotationValue)it, (byte[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmLongAnnotationValue
         && value instanceof char[]) {
      _setValue((JvmLongAnnotationValue)it, (char[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmLongAnnotationValue
         && value instanceof int[]) {
      _setValue((JvmLongAnnotationValue)it, (int[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmLongAnnotationValue
         && value instanceof long[]) {
      _setValue((JvmLongAnnotationValue)it, (long[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmLongAnnotationValue
         && value instanceof short[]) {
      _setValue((JvmLongAnnotationValue)it, (short[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmShortAnnotationValue
         && value instanceof byte[]) {
      _setValue((JvmShortAnnotationValue)it, (byte[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmShortAnnotationValue
         && value instanceof short[]) {
      _setValue((JvmShortAnnotationValue)it, (short[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmStringAnnotationValue
         && value instanceof String[]) {
      _setValue((JvmStringAnnotationValue)it, (String[])value, componentType, mustBeArray);
      return;
    } else if (it instanceof JvmTypeAnnotationValue
         && value instanceof TypeReference[]) {
      _setValue((JvmTypeAnnotationValue)it, (TypeReference[])value, componentType, mustBeArray);
      return;
    } else if (it != null
         && value != null) {
      _setValue(it, value, componentType, mustBeArray);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, value, componentType, mustBeArray).toString());
    }
  }

  @Pure
  public JvmAnnotationReference getDelegate() {
    return this.delegate;
  }

  public void setDelegate(final JvmAnnotationReference delegate) {
    this.delegate = delegate;
  }

  @Pure
  public CompilationUnitImpl getCompilationUnit() {
    return this.compilationUnit;
  }

  public void setCompilationUnit(final CompilationUnitImpl compilationUnit) {
    this.compilationUnit = compilationUnit;
  }
}
