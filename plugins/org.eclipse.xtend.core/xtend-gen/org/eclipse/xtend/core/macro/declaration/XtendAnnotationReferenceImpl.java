/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.macro.declaration.AbstractElementImpl;
import org.eclipse.xtend.core.macro.declaration.CompilationUnitImpl;
import org.eclipse.xtend.lib.macro.declaration.AnnotationReference;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.AnnotationTypeElementDeclaration;
import org.eclipse.xtend.lib.macro.declaration.EnumerationValueDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmMember;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
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
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      TypeDeclaration _typeDeclaration = _compilationUnit.toTypeDeclaration(((JvmDeclaredType)type));
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
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      boolean _isIndexing = _compilationUnit.isIndexing();
      boolean _not = (!_isIndexing);
      if (_not) {
        XAnnotation _delegate = this.getDelegate();
        return _delegate.getAnnotationType();
      }
      JvmType _switchResult = null;
      XAnnotation _delegate_1 = this.getDelegate();
      Object _eGet = _delegate_1.eGet(XAnnotationsPackage.Literals.XANNOTATION__ANNOTATION_TYPE, false);
      final Object proxy = _eGet;
      boolean _matched = false;
      if (proxy instanceof EObject) {
        boolean _eIsProxy = ((EObject)proxy).eIsProxy();
        if (_eIsProxy) {
          _matched=true;
          final URI uri = ((InternalEObject) proxy).eProxyURI();
          XAnnotation _delegate_2 = this.getDelegate();
          Resource _eResource = _delegate_2.eResource();
          ResourceSet _resourceSet = _eResource.getResourceSet();
          EObject _eObject = _resourceSet.getEObject(uri, true);
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
    boolean _notEquals = (!Objects.equal(value, null));
    if (_notEquals) {
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      return _compilationUnit.toExpression(value);
    }
    return null;
  }
  
  @Override
  public Object getValue(final String property) {
    final XExpression value = this.findValue(property);
    boolean _notEquals = (!Objects.equal(value, null));
    if (_notEquals) {
      return this.translateAnnotationValue(value, property);
    }
    AnnotationTypeDeclaration _annotationTypeDeclaration = this.getAnnotationTypeDeclaration();
    AnnotationTypeElementDeclaration _findDeclaredAnnotationTypeElement = _annotationTypeDeclaration.findDeclaredAnnotationTypeElement(property);
    return _findDeclaredAnnotationTypeElement.getDefaultValue();
  }
  
  protected XExpression findValue(final String property) {
    XExpression _xblockexpression = null;
    {
      boolean _and = false;
      boolean _equals = Objects.equal(property, "value");
      if (!_equals) {
        _and = false;
      } else {
        XAnnotation _delegate = this.getDelegate();
        XExpression _value = _delegate.getValue();
        boolean _notEquals = (!Objects.equal(_value, null));
        _and = _notEquals;
      }
      if (_and) {
        XAnnotation _delegate_1 = this.getDelegate();
        return _delegate_1.getValue();
      }
      XAnnotation _delegate_2 = this.getDelegate();
      EList<XAnnotationElementValuePair> _elementValuePairs = _delegate_2.getElementValuePairs();
      final Function1<XAnnotationElementValuePair, Boolean> _function = new Function1<XAnnotationElementValuePair, Boolean>() {
        @Override
        public Boolean apply(final XAnnotationElementValuePair it) {
          JvmOperation _element = it.getElement();
          String _simpleName = _element.getSimpleName();
          return Boolean.valueOf(Objects.equal(_simpleName, property));
        }
      };
      XAnnotationElementValuePair _findFirst = IterableExtensions.<XAnnotationElementValuePair>findFirst(_elementValuePairs, _function);
      XExpression _value_1 = null;
      if (_findFirst!=null) {
        _value_1=_findFirst.getValue();
      }
      _xblockexpression = _value_1;
    }
    return _xblockexpression;
  }
  
  protected Object translateAnnotationValue(final XExpression value, final String property) {
    XAnnotation _delegate = this.getDelegate();
    final JvmType annotationType = _delegate.getAnnotationType();
    if ((annotationType instanceof JvmAnnotationType)) {
      EList<JvmMember> _members = ((JvmAnnotationType)annotationType).getMembers();
      Iterable<JvmOperation> _filter = Iterables.<JvmOperation>filter(_members, JvmOperation.class);
      final Function1<JvmOperation, Boolean> _function = new Function1<JvmOperation, Boolean>() {
        @Override
        public Boolean apply(final JvmOperation it) {
          String _simpleName = it.getSimpleName();
          return Boolean.valueOf(Objects.equal(_simpleName, property));
        }
      };
      final JvmOperation operation = IterableExtensions.<JvmOperation>findFirst(_filter, _function);
      boolean _notEquals = (!Objects.equal(operation, null));
      if (_notEquals) {
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        TypeReferences _typeReferences = _compilationUnit.getTypeReferences();
        JvmTypeReference _returnType = operation.getReturnType();
        final boolean array = _typeReferences.isArray(_returnType);
        CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
        JvmTypeReference _returnType_1 = operation.getReturnType();
        return _compilationUnit_1.translateAnnotationValue(value, _returnType_1, array);
      }
    }
    CompilationUnitImpl _compilationUnit_2 = this.getCompilationUnit();
    return _compilationUnit_2.translateAnnotationValue(value, null, false);
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
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
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
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
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
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
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
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
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
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
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
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
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
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
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
      boolean _equals = Objects.equal(value, null);
      if (_equals) {
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
