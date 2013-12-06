/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import com.google.common.base.Objects;
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
import org.eclipse.xtend.lib.macro.declaration.MutableTypeDeclaration;
import org.eclipse.xtend.lib.macro.declaration.TypeReference;
import org.eclipse.xtend.lib.macro.expression.Expression;
import org.eclipse.xtext.common.types.JvmAnnotationType;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class XtendAnnotationReferenceImpl extends AbstractElementImpl<XAnnotation> implements AnnotationReference {
  public AnnotationTypeDeclaration getAnnotationTypeDeclaration() {
    AnnotationTypeDeclaration _switchResult = null;
    JvmType _annotationType = this.getAnnotationType();
    final JvmType type = _annotationType;
    boolean _matched = false;
    if (!_matched) {
      if (type instanceof JvmAnnotationType) {
        _matched=true;
        CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
        MutableTypeDeclaration _typeDeclaration = _compilationUnit.toTypeDeclaration(((JvmDeclaredType)type));
        _switchResult = ((AnnotationTypeDeclaration) _typeDeclaration);
      }
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
      if (!_matched) {
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
      }
      if (!_matched) {
        if (proxy instanceof JvmType) {
          _matched=true;
          _switchResult = ((JvmType)proxy);
        }
      }
      _xblockexpression = (_switchResult);
    }
    return _xblockexpression;
  }
  
  public Expression getExpression(final String property) {
    boolean _and = false;
    boolean _equals = Objects.equal(property, "value");
    if (!_equals) {
      _and = false;
    } else {
      XAnnotation _delegate = this.getDelegate();
      XExpression _value = _delegate.getValue();
      boolean _notEquals = (!Objects.equal(_value, null));
      _and = (_equals && _notEquals);
    }
    if (_and) {
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      XAnnotation _delegate_1 = this.getDelegate();
      XExpression _value_1 = _delegate_1.getValue();
      return _compilationUnit.toExpression(_value_1);
    }
    XAnnotation _delegate_2 = this.getDelegate();
    EList<XAnnotationElementValuePair> _elementValuePairs = _delegate_2.getElementValuePairs();
    final Function1<XAnnotationElementValuePair,Boolean> _function = new Function1<XAnnotationElementValuePair,Boolean>() {
      public Boolean apply(final XAnnotationElementValuePair it) {
        JvmOperation _element = it.getElement();
        String _simpleName = _element.getSimpleName();
        boolean _equals = Objects.equal(_simpleName, property);
        return Boolean.valueOf(_equals);
      }
    };
    XAnnotationElementValuePair _findFirst = IterableExtensions.<XAnnotationElementValuePair>findFirst(_elementValuePairs, _function);
    XExpression _value_2 = null;
    if (_findFirst!=null) {
      _value_2=_findFirst.getValue();
    }
    final XExpression expression = _value_2;
    boolean _notEquals_1 = (!Objects.equal(expression, null));
    if (_notEquals_1) {
      CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
      return _compilationUnit_1.toExpression(expression);
    }
    return null;
  }
  
  public Object getValue(final String property) {
    boolean _and = false;
    boolean _equals = Objects.equal(property, "value");
    if (!_equals) {
      _and = false;
    } else {
      XAnnotation _delegate = this.getDelegate();
      XExpression _value = _delegate.getValue();
      boolean _notEquals = (!Objects.equal(_value, null));
      _and = (_equals && _notEquals);
    }
    if (_and) {
      CompilationUnitImpl _compilationUnit = this.getCompilationUnit();
      XAnnotation _delegate_1 = this.getDelegate();
      XExpression _value_1 = _delegate_1.getValue();
      return _compilationUnit.evaluate(_value_1, null);
    }
    XAnnotation _delegate_2 = this.getDelegate();
    EList<XAnnotationElementValuePair> _elementValuePairs = _delegate_2.getElementValuePairs();
    final Function1<XAnnotationElementValuePair,Boolean> _function = new Function1<XAnnotationElementValuePair,Boolean>() {
      public Boolean apply(final XAnnotationElementValuePair it) {
        JvmOperation _element = it.getElement();
        String _simpleName = _element.getSimpleName();
        boolean _equals = Objects.equal(_simpleName, property);
        return Boolean.valueOf(_equals);
      }
    };
    final XAnnotationElementValuePair annoValue = IterableExtensions.<XAnnotationElementValuePair>findFirst(_elementValuePairs, _function);
    XExpression _value_2 = null;
    if (annoValue!=null) {
      _value_2=annoValue.getValue();
    }
    final XExpression expression = _value_2;
    boolean _notEquals_1 = (!Objects.equal(expression, null));
    if (_notEquals_1) {
      CompilationUnitImpl _compilationUnit_1 = this.getCompilationUnit();
      JvmOperation _element = annoValue.getElement();
      JvmTypeReference _returnType = null;
      if (_element!=null) {
        _returnType=_element.getReturnType();
      }
      return _compilationUnit_1.evaluate(expression, _returnType);
    }
    AnnotationTypeDeclaration _annotationTypeDeclaration = this.getAnnotationTypeDeclaration();
    AnnotationTypeElementDeclaration _findDeclaredAnnotationTypeElement = _annotationTypeDeclaration.findDeclaredAnnotationTypeElement(property);
    return _findDeclaredAnnotationTypeElement.getDefaultValue();
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
}
