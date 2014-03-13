/**
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.typesystem;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AbstractTestingTypeReferenceOwner;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.CompoundTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.ParameterizedTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.Assert;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractAssignabilityTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  protected IXtendJvmAssociations _iXtendJvmAssociations;
  
  public List<JvmTypeParameter> getDeclaredTypeParameters() {
    return CollectionLiterals.<JvmTypeParameter>emptyList();
  }
  
  public void isAssignableFrom(final Class<?> lhs, final String rhs) {
    String _canonicalName = lhs.getCanonicalName();
    Pair<String, String> _mappedTo = Pair.<String, String>of(_canonicalName, null);
    this.isAssignableFrom(_mappedTo, rhs, true);
  }
  
  public void isAssignableFrom(final Class<?> lhs, final Class<?> rhs) {
    String _canonicalName = lhs.getCanonicalName();
    Pair<String, String> _mappedTo = Pair.<String, String>of(_canonicalName, null);
    String _canonicalName_1 = rhs.getCanonicalName();
    this.isAssignableFrom(_mappedTo, _canonicalName_1, true);
  }
  
  public void isAssignableFrom(final String lhs, final String rhs) {
    Pair<String, String> _mappedTo = Pair.<String, String>of(lhs, null);
    this.isAssignableFrom(_mappedTo, rhs, true);
  }
  
  public void isAssignableFromAny(final String lhs) {
    Pair<String, String> _mappedTo = Pair.<String, String>of(lhs, null);
    this.isAssignableFrom(_mappedTo, null, true);
  }
  
  public void isAssignableFrom(final String lhs, final Class<?> rhs) {
    Pair<String, String> _mappedTo = Pair.<String, String>of(lhs, null);
    String _canonicalName = rhs.getCanonicalName();
    this.isAssignableFrom(_mappedTo, _canonicalName, true);
  }
  
  public void isNotAssignableFrom(final Class<?> lhs, final String rhs) {
    String _canonicalName = lhs.getCanonicalName();
    Pair<String, String> _mappedTo = Pair.<String, String>of(_canonicalName, null);
    this.isAssignableFrom(_mappedTo, rhs, false);
  }
  
  public void isNotAssignableFrom(final String lhs, final String rhs) {
    Pair<String, String> _mappedTo = Pair.<String, String>of(lhs, null);
    this.isAssignableFrom(_mappedTo, rhs, false);
  }
  
  public void isNotAssignableFromAny(final String lhs) {
    Pair<String, String> _mappedTo = Pair.<String, String>of(lhs, null);
    this.isAssignableFrom(_mappedTo, null, false);
  }
  
  public void isAssignableFrom(final Pair<String, String> lhsAndParams, final String rhs) {
    this.isAssignableFrom(lhsAndParams, rhs, true);
  }
  
  public void isNotAssignableFrom(final Pair<String, String> lhsAndParams, final String rhs) {
    this.isAssignableFrom(lhsAndParams, rhs, false);
  }
  
  public void isAssignableFrom(final Pair<String, String> lhsAndParams, final String rhs, final boolean expectation) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("def ");
      {
        String _value = lhsAndParams.getValue();
        boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_value);
        boolean _not = (!_isNullOrEmpty);
        if (_not) {
          _builder.append("<");
          String _value_1 = lhsAndParams.getValue();
          _builder.append(_value_1, "");
          _builder.append("> ");
        }
      }
      _builder.append("void method(");
      String _key = lhsAndParams.getKey();
      String _fixup = this.fixup(_key);
      _builder.append(_fixup, "");
      _builder.append(" lhs, ");
      String _fixup_1 = this.fixup(rhs);
      _builder.append(_fixup_1, "");
      _builder.append(" rhs) {}");
      final String signature = _builder.toString();
      String _string = signature.toString();
      final XtendFunction function = this.function(_string);
      final JvmOperation operation = this._iXtendJvmAssociations.getDirectlyInferredOperation(function);
      LightweightTypeReference _xifexpression = null;
      String _key_1 = lhsAndParams.getKey();
      boolean _notEquals = (!Objects.equal(_key_1, null));
      if (_notEquals) {
        EList<JvmFormalParameter> _parameters = operation.getParameters();
        JvmFormalParameter _head = IterableExtensions.<JvmFormalParameter>head(_parameters);
        JvmTypeReference _parameterType = _head.getParameterType();
        _xifexpression = this.toLightweightReference(_parameterType);
      } else {
        _xifexpression = new AnyTypeReference(this);
      }
      final LightweightTypeReference lhsType = _xifexpression;
      LightweightTypeReference _xifexpression_1 = null;
      boolean _notEquals_1 = (!Objects.equal(rhs, null));
      if (_notEquals_1) {
        EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
        JvmFormalParameter _last = IterableExtensions.<JvmFormalParameter>last(_parameters_1);
        JvmTypeReference _parameterType_1 = _last.getParameterType();
        _xifexpression_1 = this.toLightweightReference(_parameterType_1);
      } else {
        _xifexpression_1 = new AnyTypeReference(this);
      }
      final LightweightTypeReference rhsType = _xifexpression_1;
      String _simpleName = lhsType.getSimpleName();
      String _plus = (_simpleName + " := ");
      String _simpleName_1 = rhsType.getSimpleName();
      String _plus_1 = (_plus + _simpleName_1);
      boolean _testIsAssignable = this.testIsAssignable(lhsType, rhsType);
      Assert.assertEquals(_plus_1, Boolean.valueOf(expectation), Boolean.valueOf(_testIsAssignable));
      if (expectation) {
        List<LightweightTypeReference> _allSuperTypes = lhsType.getAllSuperTypes();
        for (final LightweightTypeReference superType : _allSuperTypes) {
          boolean _or = false;
          boolean _isArray = superType.isArray();
          boolean _isArray_1 = lhsType.isArray();
          boolean _equals = (_isArray == _isArray_1);
          if (_equals) {
            _or = true;
          } else {
            boolean _isArray_2 = lhsType.isArray();
            boolean _isArray_3 = rhsType.isArray();
            boolean _equals_1 = (_isArray_2 == _isArray_3);
            _or = _equals_1;
          }
          if (_or) {
            String _string_1 = superType.toString();
            boolean _testIsAssignable_1 = this.testIsAssignable(superType, rhsType);
            Assert.assertEquals(_string_1, Boolean.valueOf(expectation), Boolean.valueOf(_testIsAssignable_1));
          }
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String fixup(final String type) {
    String _elvis = null;
    String _replace = null;
    if (type!=null) {
      _replace=type.replace("$$Procedure", "org.eclipse.xtext.xbase.lib.Procedures.Procedure");
    }
    String _replace_1 = null;
    if (_replace!=null) {
      _replace_1=_replace.replace("$Procedure", "org.eclipse.xtext.xbase.lib.Procedures$Procedure");
    }
    String _replace_2 = null;
    if (_replace_1!=null) {
      _replace_2=_replace_1.replace("$Function<", "com.google.common.base.Function<");
    }
    String _replace_3 = null;
    if (_replace_2!=null) {
      _replace_3=_replace_2.replace("$Predicate<", "com.google.common.base.Predicate<");
    }
    String _replace_4 = null;
    if (_replace_3!=null) {
      _replace_4=_replace_3.replace("$$Function", "org.eclipse.xtext.xbase.lib.Functions.Function");
    }
    String _replace_5 = null;
    if (_replace_4!=null) {
      _replace_5=_replace_4.replace("$Function", "org.eclipse.xtext.xbase.lib.Functions$Function");
    }
    if (_replace_5 != null) {
      _elvis = _replace_5;
    } else {
      _elvis = "Object";
    }
    return _elvis;
  }
  
  public boolean testIsAssignable(final LightweightTypeReference lhs, final LightweightTypeReference rhs) {
    boolean _doIsAssignable = this.doIsAssignable(lhs, lhs);
    Assert.assertTrue(_doIsAssignable);
    JvmTypeReference _typeReference = lhs.toTypeReference();
    LightweightTypeReference _lightweightReference = this.toLightweightReference(_typeReference);
    boolean _doIsAssignable_1 = this.doIsAssignable(lhs, _lightweightReference);
    Assert.assertTrue(_doIsAssignable_1);
    JvmTypeReference _typeReference_1 = rhs.toTypeReference();
    LightweightTypeReference _lightweightReference_1 = this.toLightweightReference(_typeReference_1);
    boolean _doIsAssignable_2 = this.doIsAssignable(rhs, _lightweightReference_1);
    Assert.assertTrue(_doIsAssignable_2);
    final boolean result = this.doIsAssignable(lhs, rhs);
    boolean _isPrimitiveVoid = rhs.isPrimitiveVoid();
    boolean _not = (!_isPrimitiveVoid);
    if (_not) {
      final WildcardTypeReference wcRhs = new WildcardTypeReference(this);
      LightweightTypeReference _wrapperTypeIfPrimitive = rhs.getWrapperTypeIfPrimitive();
      wcRhs.addUpperBound(_wrapperTypeIfPrimitive);
      boolean _doIsAssignable_3 = this.doIsAssignable(lhs, wcRhs);
      Assert.assertEquals(Boolean.valueOf(result), Boolean.valueOf(_doIsAssignable_3));
      final CompoundTypeReference compoundRhs = new CompoundTypeReference(this, true);
      compoundRhs.addComponent(rhs);
      ITypeReferenceOwner _owner = rhs.getOwner();
      CommonTypeComputationServices _services = _owner.getServices();
      TypeReferences _typeReferences = _services.getTypeReferences();
      ITypeReferenceOwner _owner_1 = rhs.getOwner();
      ResourceSet _contextResourceSet = _owner_1.getContextResourceSet();
      final JvmType object = _typeReferences.findDeclaredType(Object.class, _contextResourceSet);
      ITypeReferenceOwner _owner_2 = rhs.getOwner();
      ParameterizedTypeReference _parameterizedTypeReference = new ParameterizedTypeReference(_owner_2, object);
      compoundRhs.addComponent(_parameterizedTypeReference);
      String _plus = (lhs + " := ");
      String _string = compoundRhs.toString();
      String _plus_1 = (_plus + _string);
      boolean _doIsAssignable_4 = this.doIsAssignable(lhs, compoundRhs);
      Assert.assertEquals(_plus_1, Boolean.valueOf(result), Boolean.valueOf(_doIsAssignable_4));
    }
    return result;
  }
  
  public boolean doIsAssignable(final LightweightTypeReference lhs, final LightweightTypeReference rhs) {
    return lhs.isAssignableFrom(rhs);
  }
}
