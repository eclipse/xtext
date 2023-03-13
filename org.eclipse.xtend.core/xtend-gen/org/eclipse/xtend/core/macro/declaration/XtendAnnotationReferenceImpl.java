/**
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendAnnotationReferenceImpl extends AbstractElementImpl<XAnnotation> implements AnnotationReference {
  @Override
  public AnnotationTypeDeclaration getAnnotationTypeDeclaration() {
    AnnotationTypeDeclaration _switchResult = null;
    JvmType _annotationType = this.getAnnotationType();
    final JvmType type = _annotationType;
    boolean _matched = false;
    if (type instanceof JvmAnnotationType) {
      _matched=true;
      TypeDeclaration _typeDeclaration = this.getCompilationUnit().toTypeDeclaration(((JvmDeclaredType)type));
      _switchResult = ((AnnotationTypeDeclaration) _typeDeclaration);
    }
    if (!_matched) {
      _switchResult = null;
    }
    return _switchResult;
  }

  public JvmType getAnnotationType() {
    JvmType _xblockexpression = null;
    {
      boolean _isIndexing = this.getCompilationUnit().isIndexing();
      boolean _not = (!_isIndexing);
      if (_not) {
        return this.getDelegate().getAnnotationType();
      }
      JvmType _switchResult = null;
      Object _eGet = this.getDelegate().eGet(XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, false);
      final Object proxy = _eGet;
      boolean _matched = false;
      if (proxy instanceof EObject) {
        boolean _eIsProxy = ((EObject)proxy).eIsProxy();
        if (_eIsProxy) {
          _matched=true;
          final URI uri = ((InternalEObject) proxy).eProxyURI();
          EObject _eObject = this.getDelegate().eResource().getResourceSet().getEObject(uri, true);
          return ((JvmType) _eObject);
        }
      }
      if (!_matched) {
        if (proxy instanceof JvmType) {
          _matched=true;
          _switchResult = ((JvmType)proxy);
        }
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }

  @Override
  public Expression getExpression(final String property) {
    final XExpression value = this.findValue(property);
    if ((value != null)) {
      return this.getCompilationUnit().toExpression(value);
    }
    return null;
  }

  @Override
  public Object getValue(final String property) {
    final XExpression value = this.findValue(property);
    if ((value != null)) {
      return this.translateAnnotationValue(value, property);
    }
    return this.getAnnotationTypeDeclaration().findDeclaredAnnotationTypeElement(property).getDefaultValue();
  }

  protected XExpression findValue(final String property) {
    XExpression _xblockexpression = null;
    {
      if ((Objects.equal(property, "value") && (this.getDelegate().getValue() != null))) {
        return this.getDelegate().getValue();
      }
      final Function1<XAnnotationElementValuePair, Boolean> _function = (XAnnotationElementValuePair it) -> {
        String _simpleName = it.getElement().getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, property));
      };
      XAnnotationElementValuePair _findFirst = IterableExtensions.<XAnnotationElementValuePair>findFirst(this.getDelegate().getElementValuePairs(), _function);
      XExpression _value = null;
      if (_findFirst!=null) {
        _value=_findFirst.getValue();
      }
      _xblockexpression = _value;
    }
    return _xblockexpression;
  }

  protected Object translateAnnotationValue(final XExpression value, final String property) {
    final JvmType annotationType = this.getDelegate().getAnnotationType();
    if ((annotationType instanceof JvmAnnotationType)) {
      final Function1<JvmOperation, Boolean> _function = (JvmOperation it) -> {
        String _simpleName = it.getSimpleName();
        return Boolean.valueOf(Objects.equal(_simpleName, property));
      };
      final JvmOperation operation = IterableExtensions.<JvmOperation>findFirst(Iterables.<JvmOperation>filter(((JvmAnnotationType)annotationType).getMembers(), JvmOperation.class), _function);
      if ((operation != null)) {
        final boolean array = this.getCompilationUnit().getTypeReferences().isArray(operation.getReturnType());
        return this.getCompilationUnit().translateAnnotationValue(value, operation.getReturnType(), array);
      }
    }
    return this.getCompilationUnit().translateAnnotationValue(value, null, false);
  }

  @Override
  public AnnotationReference getAnnotationValue(final String name) {
    Object _value = this.getValue(name);
    return ((AnnotationReference) _value);
  }

  @Override
  public AnnotationReference[] getAnnotationArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((AnnotationReference[]) _value);
  }

  @Override
  public boolean[] getBooleanArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((boolean[]) _value);
  }

  @Override
  public boolean getBooleanValue(final String name) {
    Boolean _xblockexpression = null;
    {
      final Object value = this.getValue(name);
      if ((value == null)) {
        return false;
      }
      _xblockexpression = ((Boolean) value);
    }
    return (_xblockexpression).booleanValue();
  }

  @Override
  public byte[] getByteArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((byte[]) _value);
  }

  @Override
  public byte getByteValue(final String name) {
    Byte _xblockexpression = null;
    {
      final Object value = this.getValue(name);
      if ((value == null)) {
        return ((byte) 0);
      }
      _xblockexpression = ((Byte) value);
    }
    return (_xblockexpression).byteValue();
  }

  @Override
  public char[] getCharArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((char[]) _value);
  }

  @Override
  public char getCharValue(final String name) {
    Character _xblockexpression = null;
    {
      final Object value = this.getValue(name);
      if ((value == null)) {
        return ((char) 0);
      }
      Character _switchResult = null;
      boolean _matched = false;
      if (value instanceof Byte) {
        _matched=true;
        _switchResult = Character.valueOf(((char) ((Byte) value).byteValue()));
      }
      if (!_matched) {
        _switchResult = ((Character) value);
      }
      _xblockexpression = _switchResult;
    }
    return (_xblockexpression).charValue();
  }

  @Override
  public TypeReference getClassValue(final String name) {
    Object _value = this.getValue(name);
    return ((TypeReference) _value);
  }

  @Override
  public TypeReference[] getClassArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((TypeReference[]) _value);
  }

  @Override
  public double[] getDoubleArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((double[]) _value);
  }

  @Override
  public double getDoubleValue(final String name) {
    Double _xblockexpression = null;
    {
      final Object value = this.getValue(name);
      if ((value == null)) {
        return 0;
      }
      Double _switchResult = null;
      boolean _matched = false;
      if (value instanceof Character) {
        _matched=true;
        _switchResult = Double.valueOf(((double) ((Character) value).charValue()));
      }
      if (!_matched) {
        if (value instanceof Byte) {
          _matched=true;
          _switchResult = Double.valueOf(((double) ((Byte) value).byteValue()));
        }
      }
      if (!_matched) {
        if (value instanceof Short) {
          _matched=true;
          _switchResult = Double.valueOf(((double) ((Short) value).shortValue()));
        }
      }
      if (!_matched) {
        if (value instanceof Integer) {
          _matched=true;
          _switchResult = Double.valueOf(((double) ((Integer) value).intValue()));
        }
      }
      if (!_matched) {
        if (value instanceof Long) {
          _matched=true;
          _switchResult = Double.valueOf(((double) ((Long) value).longValue()));
        }
      }
      if (!_matched) {
        if (value instanceof Float) {
          _matched=true;
          _switchResult = Double.valueOf(((double) ((Float) value).floatValue()));
        }
      }
      if (!_matched) {
        _switchResult = ((Double) value);
      }
      _xblockexpression = _switchResult;
    }
    return (_xblockexpression).doubleValue();
  }

  @Override
  public EnumerationValueDeclaration getEnumValue(final String name) {
    Object _value = this.getValue(name);
    return ((EnumerationValueDeclaration) _value);
  }

  @Override
  public EnumerationValueDeclaration[] getEnumArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((EnumerationValueDeclaration[]) _value);
  }

  @Override
  public float[] getFloatArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((float[]) _value);
  }

  @Override
  public float getFloatValue(final String name) {
    Float _xblockexpression = null;
    {
      final Object value = this.getValue(name);
      if ((value == null)) {
        return 0;
      }
      Float _switchResult = null;
      boolean _matched = false;
      if (value instanceof Character) {
        _matched=true;
        _switchResult = Float.valueOf(((float) ((Character) value).charValue()));
      }
      if (!_matched) {
        if (value instanceof Byte) {
          _matched=true;
          _switchResult = Float.valueOf(((float) ((Byte) value).byteValue()));
        }
      }
      if (!_matched) {
        if (value instanceof Short) {
          _matched=true;
          _switchResult = Float.valueOf(((float) ((Short) value).shortValue()));
        }
      }
      if (!_matched) {
        if (value instanceof Integer) {
          _matched=true;
          _switchResult = Float.valueOf(((float) ((Integer) value).intValue()));
        }
      }
      if (!_matched) {
        if (value instanceof Long) {
          _matched=true;
          _switchResult = Float.valueOf(((float) ((Long) value).longValue()));
        }
      }
      if (!_matched) {
        _switchResult = ((Float) value);
      }
      _xblockexpression = _switchResult;
    }
    return (_xblockexpression).floatValue();
  }

  @Override
  public int[] getIntArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((int[]) _value);
  }

  @Override
  public int getIntValue(final String name) {
    Integer _xblockexpression = null;
    {
      final Object value = this.getValue(name);
      if ((value == null)) {
        return 0;
      }
      Integer _switchResult = null;
      boolean _matched = false;
      if (value instanceof Character) {
        _matched=true;
        _switchResult = Integer.valueOf(((int) ((Character) value).charValue()));
      }
      if (!_matched) {
        if (value instanceof Byte) {
          _matched=true;
          _switchResult = Integer.valueOf(((int) ((Byte) value).byteValue()));
        }
      }
      if (!_matched) {
        if (value instanceof Short) {
          _matched=true;
          _switchResult = Integer.valueOf(((int) ((Short) value).shortValue()));
        }
      }
      if (!_matched) {
        _switchResult = ((Integer) value);
      }
      _xblockexpression = _switchResult;
    }
    return (_xblockexpression).intValue();
  }

  @Override
  public long[] getLongArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((long[]) _value);
  }

  @Override
  public long getLongValue(final String name) {
    Long _xblockexpression = null;
    {
      final Object value = this.getValue(name);
      if ((value == null)) {
        return 0;
      }
      Long _switchResult = null;
      boolean _matched = false;
      if (value instanceof Character) {
        _matched=true;
        _switchResult = Long.valueOf(((long) ((Character) value).charValue()));
      }
      if (!_matched) {
        if (value instanceof Byte) {
          _matched=true;
          _switchResult = Long.valueOf(((long) ((Byte) value).byteValue()));
        }
      }
      if (!_matched) {
        if (value instanceof Short) {
          _matched=true;
          _switchResult = Long.valueOf(((long) ((Short) value).shortValue()));
        }
      }
      if (!_matched) {
        if (value instanceof Integer) {
          _matched=true;
          _switchResult = Long.valueOf(((long) ((Integer) value).intValue()));
        }
      }
      if (!_matched) {
        _switchResult = ((Long) value);
      }
      _xblockexpression = _switchResult;
    }
    return (_xblockexpression).longValue();
  }

  @Override
  public short[] getShortArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((short[]) _value);
  }

  @Override
  public short getShortValue(final String name) {
    Short _xblockexpression = null;
    {
      final Object value = this.getValue(name);
      if ((value == null)) {
        return ((short) 0);
      }
      Short _switchResult = null;
      boolean _matched = false;
      if (value instanceof Byte) {
        _matched=true;
        _switchResult = Short.valueOf(((short) ((Byte) value).byteValue()));
      }
      if (!_matched) {
        _switchResult = ((Short) value);
      }
      _xblockexpression = _switchResult;
    }
    return (_xblockexpression).shortValue();
  }

  @Override
  public String[] getStringArrayValue(final String name) {
    Object _value = this.getValue(name);
    return ((String[]) _value);
  }

  @Override
  public String getStringValue(final String name) {
    Object _value = this.getValue(name);
    return ((String) _value);
  }
}
