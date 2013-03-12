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
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.typesystem.AbstractTestingTypeReferenceOwner;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmFormalParameter;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmTypeParameter;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractAssignabilityTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  @Extension
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
  public List<JvmTypeParameter> getDeclaredTypeParameters() {
    List<JvmTypeParameter> _emptyList = CollectionLiterals.<JvmTypeParameter>emptyList();
    return _emptyList;
  }
  
  public void isAssignableFrom(final Class<? extends Object> lhs, final String rhs) {
    String _canonicalName = lhs.getCanonicalName();
    Pair<String,String> _mappedTo = Pair.<String, String>of(_canonicalName, null);
    this.isAssignableFrom(_mappedTo, rhs, true);
  }
  
  public void isAssignableFrom(final Class<? extends Object> lhs, final Class<? extends Object> rhs) {
    String _canonicalName = lhs.getCanonicalName();
    Pair<String,String> _mappedTo = Pair.<String, String>of(_canonicalName, null);
    String _canonicalName_1 = rhs.getCanonicalName();
    this.isAssignableFrom(_mappedTo, _canonicalName_1, true);
  }
  
  public void isAssignableFrom(final String lhs, final String rhs) {
    Pair<String,String> _mappedTo = Pair.<String, String>of(lhs, null);
    this.isAssignableFrom(_mappedTo, rhs, true);
  }
  
  public void isAssignableFromAny(final String lhs) {
    Pair<String,String> _mappedTo = Pair.<String, String>of(lhs, null);
    this.isAssignableFrom(_mappedTo, null, true);
  }
  
  public void isAssignableFrom(final String lhs, final Class<? extends Object> rhs) {
    Pair<String,String> _mappedTo = Pair.<String, String>of(lhs, null);
    String _canonicalName = rhs.getCanonicalName();
    this.isAssignableFrom(_mappedTo, _canonicalName, true);
  }
  
  public void isNotAssignableFrom(final Class<? extends Object> lhs, final String rhs) {
    String _canonicalName = lhs.getCanonicalName();
    Pair<String,String> _mappedTo = Pair.<String, String>of(_canonicalName, null);
    this.isAssignableFrom(_mappedTo, rhs, false);
  }
  
  public void isNotAssignableFrom(final String lhs, final String rhs) {
    Pair<String,String> _mappedTo = Pair.<String, String>of(lhs, null);
    this.isAssignableFrom(_mappedTo, rhs, false);
  }
  
  public void isNotAssignableFromAny(final String lhs) {
    Pair<String,String> _mappedTo = Pair.<String, String>of(lhs, null);
    this.isAssignableFrom(_mappedTo, null, false);
  }
  
  public void isAssignableFrom(final Pair<String,String> lhsAndParams, final String rhs) {
    this.isAssignableFrom(lhsAndParams, rhs, true);
  }
  
  public void isNotAssignableFrom(final Pair<String,String> lhsAndParams, final String rhs) {
    this.isAssignableFrom(lhsAndParams, rhs, false);
  }
  
  public void isAssignableFrom(final Pair<String,String> lhsAndParams, final String rhs, final boolean expectation) {
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
        LightweightTypeReference _lightweightReference = this.toLightweightReference(_parameterType);
        _xifexpression = _lightweightReference;
      } else {
        AnyTypeReference _anyTypeReference = new AnyTypeReference(this);
        _xifexpression = _anyTypeReference;
      }
      final LightweightTypeReference lhsType = _xifexpression;
      LightweightTypeReference _xifexpression_1 = null;
      boolean _notEquals_1 = (!Objects.equal(rhs, null));
      if (_notEquals_1) {
        EList<JvmFormalParameter> _parameters_1 = operation.getParameters();
        JvmFormalParameter _last = IterableExtensions.<JvmFormalParameter>last(_parameters_1);
        JvmTypeReference _parameterType_1 = _last.getParameterType();
        LightweightTypeReference _lightweightReference_1 = this.toLightweightReference(_parameterType_1);
        _xifexpression_1 = _lightweightReference_1;
      } else {
        AnyTypeReference _anyTypeReference_1 = new AnyTypeReference(this);
        _xifexpression_1 = _anyTypeReference_1;
      }
      final LightweightTypeReference rhsType = _xifexpression_1;
      boolean _testIsAssignable = this.testIsAssignable(lhsType, rhsType);
      Assert.assertEquals(Boolean.valueOf(expectation), Boolean.valueOf(_testIsAssignable));
      if (expectation) {
        List<LightweightTypeReference> _allSuperTypes = lhsType.getAllSuperTypes();
        for (final LightweightTypeReference superType : _allSuperTypes) {
          String _string_1 = superType.toString();
          boolean _testIsAssignable_1 = this.testIsAssignable(superType, rhsType);
          Assert.assertEquals(_string_1, Boolean.valueOf(expectation), Boolean.valueOf(_testIsAssignable_1));
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected String fixup(final String type) {
    String _elvis = null;
    String _replace = type==null?(String)null:type.replace("$Procedure", "org.eclipse.xtext.xbase.lib.Procedures$Procedure");
    String _replace_1 = _replace==null?(String)null:_replace.replace("$Function<", "com.google.common.base.Function<");
    String _replace_2 = _replace_1==null?(String)null:_replace_1.replace("$Predicate<", "com.google.common.base.Predicate<");
    String _replace_3 = _replace_2==null?(String)null:_replace_2.replace("$Function", "org.eclipse.xtext.xbase.lib.Functions$Function");
    if (_replace_3 != null) {
      _elvis = _replace_3;
    } else {
      _elvis = ObjectExtensions.<String>operator_elvis(_replace_3, "Object");
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
      WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(this);
      final WildcardTypeReference wcRhs = _wildcardTypeReference;
      LightweightTypeReference _wrapperTypeIfPrimitive = rhs.getWrapperTypeIfPrimitive();
      wcRhs.addUpperBound(_wrapperTypeIfPrimitive);
      boolean _doIsAssignable_3 = this.doIsAssignable(lhs, wcRhs);
      Assert.assertEquals(Boolean.valueOf(result), Boolean.valueOf(_doIsAssignable_3));
    }
    return result;
  }
  
  public boolean doIsAssignable(final LightweightTypeReference lhs, final LightweightTypeReference rhs) {
    return lhs.isAssignableFrom(rhs);
  }
  
  @Test
  public void testPrimitiveConversion_00() {
    this.isAssignableFrom("long", "int");
    this.isNotAssignableFrom("Long", "int");
    this.isAssignableFrom("long", "Integer");
    this.isNotAssignableFrom("Long", "Integer");
  }
  
  @Test
  public void testPrimitiveConversion_01() {
    this.isNotAssignableFrom("int", "long");
    this.isNotAssignableFrom("Integer", "long");
    this.isNotAssignableFrom("int", "Long");
    this.isNotAssignableFrom("Integer", "Long");
  }
  
  @Test
  public void testPrimitiveConversion_02() {
    this.isAssignableFrom("long", "byte");
    this.isNotAssignableFrom("Long", "byte");
    this.isAssignableFrom("long", "Byte");
    this.isNotAssignableFrom("Long", "Byte");
  }
  
  @Test
  public void testPrimitiveConversion_03() {
    this.isAssignableFrom("char", "byte");
    this.isNotAssignableFrom("Character", "byte");
    this.isAssignableFrom("char", "Byte");
    this.isNotAssignableFrom("Character", "Byte");
  }
  
  @Test
  public void testPrimitiveConversion_04() {
    this.isAssignableFrom("int", "int");
    this.isAssignableFrom("Integer", "int");
    this.isAssignableFrom("int", "Integer");
    this.isAssignableFrom("Integer", "Integer");
  }
  
  @Test
  public void testPrimitiveConversion_05() {
    this.isNotAssignableFrom("long", "float");
    this.isNotAssignableFrom("Long", "float");
    this.isNotAssignableFrom("long", "Float");
    this.isNotAssignableFrom("Long", "Float");
  }
  
  @Test
  public void testPrimitiveConversion_06() {
    this.isAssignableFrom("double", "float");
    this.isNotAssignableFrom("Double", "float");
    this.isAssignableFrom("double", "Float");
    this.isNotAssignableFrom("Double", "Float");
  }
  
  @Test
  public void testPrimitiveConversion_07() {
    this.isAssignableFrom("int", "Byte");
    this.isAssignableFrom("int", "Character");
  }
  
  @Test
  public void testPrimitiveConversion_08() {
    this.isAssignableFrom("java.io.Serializable", "int");
    this.isAssignableFrom("Number", "int");
  }
  
  @Test
  public void testStringAndInteger() {
    this.isNotAssignableFrom("String", "Integer");
  }
  
  @Test
  public void testPrimitiveToObject() {
    this.isAssignableFrom("Object", "int");
    this.isAssignableFrom("Object", "long");
    this.isAssignableFrom("Object", "byte");
    this.isAssignableFrom("Object", "short");
    this.isAssignableFrom("Object", "float");
    this.isAssignableFrom("Object", "double");
    this.isAssignableFrom("Object", "char");
    this.isAssignableFrom("Object", "boolean");
  }
  
  @Test
  public void testWildcardLowerBound_01() {
    this.isNotAssignableFrom("java.util.List<? super Integer>", "Iterable<? super String>");
    this.isNotAssignableFrom("java.util.List<? super Integer>", "Iterable");
    this.isNotAssignableFrom("java.util.List", "Iterable<? super String>");
    this.isNotAssignableFrom("java.util.List", "Iterable");
  }
  
  @Test
  public void testVoid_01() {
    this.isAssignableFrom("void", "void");
  }
  
  @Test
  public void testVoid_02() {
    this.isNotAssignableFrom("int", "void");
    this.isNotAssignableFrom("void", "int");
  }
  
  @Test
  public void testVoid_03() {
    this.isNotAssignableFrom("Object", "void");
    this.isNotAssignableFrom("void", "Object");
  }
  
  @Test
  public void testVoid_04() {
    this.isNotAssignableFrom("Void", "void");
    this.isNotAssignableFrom("void", "Void");
  }
  
  @Test
  public void testArrayType_01() {
    this.isAssignableFrom("String[]", "String[]");
    this.isAssignableFrom("CharSequence[]", "String[]");
    this.isAssignableFrom("Comparable[]", "String[]");
    this.isAssignableFrom("Comparable<String>[]", "String[]");
    this.isAssignableFrom("Comparable<? extends CharSequence>[]", "String[]");
  }
  
  @Test
  public void testArrayType_02() {
    this.isNotAssignableFrom("String[]", "CharSequence[]");
    this.isNotAssignableFrom("String[][]", "String[]");
    this.isNotAssignableFrom("String[]", "String[][]");
  }
  
  @Test
  public void testArrayType_03() {
    this.isAssignableFrom("Object[]", "CharSequence[]");
    this.isAssignableFrom("Object[]", "String[][]");
  }
  
  @Test
  public void testArrayType_04() {
    this.isAssignableFrom("Object", "CharSequence[]");
    this.isAssignableFrom("Cloneable", "CharSequence[]");
    this.isAssignableFrom("java.io.Serializable", "CharSequence[]");
  }
  
  @Test
  public void testIterableToArrayType_01() {
    this.isAssignableFrom("int[]", "Iterable<Integer>");
    this.isAssignableFrom("int[]", "Iterable<? extends Integer>");
  }
  
  @Test
  public void testIterableToArrayType_02() {
    this.isAssignableFrom("Integer[]", "Iterable<Integer>");
    this.isAssignableFrom("Integer[]", "Iterable<? extends Integer>");
  }
  
  @Test
  public void testListToArrayType_01() {
    this.isAssignableFrom("int[]", "Iterable<Integer>");
    this.isAssignableFrom("int[]", "Iterable<? extends Integer>");
    this.isNotAssignableFrom("int[]", "Iterable<? super Integer>");
  }
  
  @Test
  public void testListToArrayType_02() {
    this.isAssignableFrom("Integer[]", "java.util.List<Integer>");
    this.isAssignableFrom("Integer[]", "java.util.List<? extends Integer>");
    this.isAssignableFrom("Object[]", "java.util.List<? super Integer>");
    this.isNotAssignableFrom("Integer[]", "java.util.List<? super Integer>");
  }
  
  @Test
  public void testPrimitiveArrayType_01() {
    this.isNotAssignableFrom("double[]", "int[]");
    this.isNotAssignableFrom("int[]", "double[]");
  }
  
  @Test
  public void testPrimitiveArrayType_02() {
    this.isAssignableFrom("Object", "int[]");
    this.isAssignableFrom("Cloneable", "double[]");
    this.isAssignableFrom("java.io.Serializable", "double[]");
  }
  
  @Test
  public void testAnyToArray() {
    this.isAssignableFromAny("int[]");
    this.isAssignableFromAny("Object[]");
  }
  
  @Test
  public void testAnyToVoid() {
    this.isNotAssignableFromAny("void");
  }
  
  @Test
  public void testAnyToType() {
    this.isAssignableFromAny("Void");
    this.isAssignableFromAny("Object");
    this.isNotAssignableFromAny("int");
  }
  
  @Test
  public void testAnyToTypeParam() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "T");
    this.isAssignableFrom(_mappedTo, null, true);
  }
  
  @Test
  public void testArrayToAny() {
    this.isNotAssignableFrom(((String) null), "int[]");
    this.isNotAssignableFrom(((String) null), "Object[]");
  }
  
  @Test
  public void testVoidToAny() {
    this.isNotAssignableFrom(((String) null), "void");
  }
  
  @Test
  public void testTypeToAny() {
    this.isNotAssignableFrom(((String) null), "Void");
    this.isNotAssignableFrom(((String) null), "Object");
    this.isNotAssignableFrom(((String) null), "int");
  }
  
  @Test
  public void testAnyToAny() {
    this.isAssignableFromAny(null);
  }
  
  @Test
  public void testCharSequenceAndList_01() {
    this.isNotAssignableFrom("CharSequence", "java.util.List<? super String>");
    this.isNotAssignableFrom("java.util.List<? super String>", "CharSequence");
  }
  
  @Test
  public void testTypeParameter_01() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "T");
    this.isAssignableFrom(_mappedTo, "T");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("T[]", "T");
    this.isAssignableFrom(_mappedTo_1, "T[]");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("T", "T");
    this.isNotAssignableFrom(_mappedTo_2, "T[]");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("T[]", "T");
    this.isNotAssignableFrom(_mappedTo_3, "T");
  }
  
  @Test
  public void testTypeParameter_02() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("CharSequence", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo, "T");
  }
  
  @Test
  public void testTypeParameter_03() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("Iterable<?>", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo, "Iterable<T>");
  }
  
  @Test
  public void testTypeParameter_04() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("Iterable<? extends CharSequence>", "T extends CharSequence");
    this.isAssignableFrom(_mappedTo, "Iterable<T>");
  }
  
  @Test
  public void testTypeParameter_05() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("Object", "T");
    this.isAssignableFrom(_mappedTo, "T");
  }
  
  @Test
  public void testTypeParameter_06() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("String[]", "T extends String[]");
    this.isAssignableFrom(_mappedTo, "T");
  }
  
  @Test
  public void testTypeParameter_07() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("String[]", "T extends String");
    this.isAssignableFrom(_mappedTo, "T[]");
  }
  
  @Test
  public abstract void testTypeParameter_08();
  
  @Test
  public void testTwoTypeParameters_01() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "T, V extends T");
    this.isAssignableFrom(_mappedTo, "V");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("T[]", "T, V extends T");
    this.isAssignableFrom(_mappedTo_1, "V[]");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("T", "T, V extends T");
    this.isNotAssignableFrom(_mappedTo_2, "V[]");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("T[]", "T, V extends T");
    this.isNotAssignableFrom(_mappedTo_3, "V");
    Pair<String,String> _mappedTo_4 = Pair.<String, String>of("T[]", "T, V extends T[]");
    this.isAssignableFrom(_mappedTo_4, "V");
  }
  
  @Test
  public abstract void testTwoTypeParameters_02();
  
  @Test
  public abstract void testTwoTypeParameters_03();
  
  @Test
  public void testTwoTypeParameters_04() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "T, V");
    this.isNotAssignableFrom(_mappedTo, "V");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("V", "T, V");
    this.isNotAssignableFrom(_mappedTo_1, "T");
  }
  
  @Test
  public void testTwoTypeParameters_05() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "T extends CharSequence, V extends String");
    this.isNotAssignableFrom(_mappedTo, "V");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("V", "T extends CharSequence, V extends String");
    this.isNotAssignableFrom(_mappedTo_1, "T");
  }
  
  @Test
  public void testBug343089_01() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("Number", "T extends Number");
    this.isAssignableFrom(_mappedTo, "T");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("T", "T extends Number");
    this.isNotAssignableFrom(_mappedTo_1, "Number");
  }
  
  @Test
  public void testBug343089_02() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("java.io.Serializable", "T extends Number");
    this.isAssignableFrom(_mappedTo, "T");
  }
  
  @Test
  public void testBug343089_03() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("java.io.Serializable", "T extends Number");
    this.isAssignableFrom(_mappedTo, "T");
  }
  
  @Test
  public void testBug343089_04() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("T", "T");
    this.isNotAssignableFrom(_mappedTo, "Object");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("T", "T");
    this.isNotAssignableFrom(_mappedTo_1, "String");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("T", "T");
    this.isNotAssignableFrom(_mappedTo_2, "Object[]");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("T", "T");
    this.isNotAssignableFrom(_mappedTo_3, "int");
  }
  
  @Test
  public abstract void testFunctionTypes_01();
  
  @Test
  public abstract void testFunctionTypes_02();
  
  @Test
  public abstract void testFunctionTypes_03();
  
  @Test
  public void testFunctionTypes_04() {
    this.isNotAssignableFrom("(String)=>CharSequence", "()=>String");
    this.isNotAssignableFrom("()=>CharSequence", "(CharSequence)=>String");
    this.isNotAssignableFrom("(CharSequence)=>CharSequence", "(String, CharSequence)=>String");
  }
  
  @Test
  public void testFunctionTypes_05() {
    this.isAssignableFrom("(int, int)=>boolean", "(Integer, Integer)=>Boolean");
    this.isAssignableFrom("(Integer, Integer)=>Boolean", "(int, int)=>boolean");
  }
  
  @Test
  public void testFunctionTypes_06() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("(T)=>void", "T extends Integer");
    this.isAssignableFrom(_mappedTo, "(Integer)=>void");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("(T)=>int", "T extends Integer");
    this.isAssignableFrom(_mappedTo_1, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("(T)=>void", "T extends Integer");
    this.isAssignableFrom(_mappedTo_2, "(int)=>void");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("(T)=>Integer", "T extends Integer");
    this.isAssignableFrom(_mappedTo_3, "(int)=>int");
  }
  
  @Test
  public abstract void testFunctionTypes_07();
  
  @Test
  public abstract void testFunctionTypes_08();
  
  @Test
  public abstract void testFunctionTypeAsParameterized_01();
  
  @Test
  public abstract void testFunctionTypeAsParameterized_02();
  
  @Test
  public abstract void testFunctionTypeAsParameterized_03();
  
  @Test
  public void testFunctionTypeAsParameterized_04() {
    this.isNotAssignableFrom("$Function1<String, CharSequence>", "()=>String");
    this.isNotAssignableFrom("$Function1<? super String, CharSequence>", "()=>String");
    this.isNotAssignableFrom("$Function1<? super String, ? extends CharSequence>", "()=>String");
    this.isNotAssignableFrom("$Function1<String, ? extends CharSequence>", "()=>String");
    this.isNotAssignableFrom("$Function0<CharSequence>", "(CharSequence)=>String");
    this.isNotAssignableFrom("$Function0<? extends CharSequence>", "(CharSequence)=>String");
    this.isNotAssignableFrom("$Function0<? super CharSequence>", "(CharSequence)=>String");
    this.isNotAssignableFrom("$Function1<CharSequence, CharSequence>", "(String, CharSequence)=>String");
    this.isNotAssignableFrom("$Function1<CharSequence, ? extends CharSequence>", "(String, CharSequence)=>String");
    this.isNotAssignableFrom("$Function1<? super CharSequence, CharSequence>", "(String, CharSequence)=>String");
    this.isNotAssignableFrom("$Function1<? super CharSequence, ? extends CharSequence>", "(String, CharSequence)=>String");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_05() {
    this.isAssignableFrom("$Function2<Integer, Integer, Boolean>", "(Integer, Integer)=>Boolean");
    this.isAssignableFrom("$Function2<? super Integer, ? super Integer, Boolean>", "(Integer, Integer)=>Boolean");
    this.isAssignableFrom("$Function2<Integer, Integer, ? extends Boolean>", "(Integer, Integer)=>Boolean");
    this.isAssignableFrom("$Function2<? super Integer, ? super Integer, ? extends Boolean>", "(Integer, Integer)=>Boolean");
    this.isAssignableFrom("$Function2<Integer, Integer, Boolean>", "(int, int)=>boolean");
    this.isAssignableFrom("$Function2<? super Integer, ? super Integer, Boolean>", "(int, int)=>boolean");
    this.isAssignableFrom("$Function2<Integer, Integer, ? extends Boolean>", "(int, int)=>boolean");
    this.isAssignableFrom("$Function2<? super Integer, ? super Integer, ? extends Boolean>", "(int, int)=>boolean");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_06() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("$Procedure1<T>", "T extends Integer");
    this.isAssignableFrom(_mappedTo, "(Integer)=>void");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("$Procedure1<? super T>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_1, "(Integer)=>void");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("$Function1<T, Integer>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_2, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("$Function1<? super T, Integer>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_3, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_4 = Pair.<String, String>of("$Function1<T, ? extends Integer>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_4, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_5 = Pair.<String, String>of("$Function1<? super T, ? extends Integer>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_5, "(Integer)=>Integer");
    Pair<String,String> _mappedTo_6 = Pair.<String, String>of("$Procedure1<T>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_6, "(int)=>void");
    Pair<String,String> _mappedTo_7 = Pair.<String, String>of("$Procedure1<? super T>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_7, "(int)=>void");
    Pair<String,String> _mappedTo_8 = Pair.<String, String>of("$Function1<T, Integer>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_8, "(int)=>int");
    Pair<String,String> _mappedTo_9 = Pair.<String, String>of("$Function1<? super T, Integer>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_9, "(int)=>int");
    Pair<String,String> _mappedTo_10 = Pair.<String, String>of("$Function1<T, ? extends Integer>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_10, "(int)=>int");
    Pair<String,String> _mappedTo_11 = Pair.<String, String>of("$Function1<? super T, ? extends Integer>", "T extends Integer");
    this.isAssignableFrom(_mappedTo_11, "(int)=>int");
  }
  
  @Test
  public abstract void testFunctionTypeAsParameterized_07();
  
  @Test
  public abstract void testFunctionTypeAsParameterized_08();
  
  @Test
  public abstract void testFunctionTypeAsParameterized_09();
  
  @Test
  public abstract void testFunctionTypeAsParameterized_10();
  
  @Test
  public void testFunctionTypeAsParameterized_11() {
    this.isNotAssignableFrom("(String)=>CharSequence", "$Function0<String>");
    this.isNotAssignableFrom("(String)=>CharSequence", "$Function0<? extends String>");
    this.isNotAssignableFrom("(String)=>CharSequence", "$Function0<? super String>");
    this.isNotAssignableFrom("()=>CharSequence", "$Function1<CharSequence, String>");
    this.isNotAssignableFrom("()=>CharSequence", "$Function1<? super CharSequence, String>");
    this.isNotAssignableFrom("()=>CharSequence", "$Function1<CharSequence, ? extends String>");
    this.isNotAssignableFrom("()=>CharSequence", "$Function1<? super CharSequence, ? extends String>");
    this.isNotAssignableFrom("(CharSequence)=>CharSequence", "$Function2<String, CharSequence, String>");
    this.isNotAssignableFrom("(CharSequence)=>CharSequence", "$Function2<? super String, ? super CharSequence, String>");
    this.isNotAssignableFrom("(CharSequence)=>CharSequence", "$Function2<String, CharSequence, ? extends String>");
    this.isNotAssignableFrom("(CharSequence)=>CharSequence", "$Function2<? super String, ? super CharSequence, ? extends String>");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_12() {
    this.isAssignableFrom("(int, int)=>boolean", "$Function2<Integer, Integer, Boolean>");
    this.isAssignableFrom("(int, int)=>boolean", "$Function2<? super Integer, ? super Integer, ? extends Boolean>");
    this.isAssignableFrom("(int, int)=>boolean", "$Function2<Integer, Integer, Boolean>");
    this.isAssignableFrom("(int, int)=>boolean", "$Function2<? super Integer, ? super Integer, ? extends Boolean>");
    this.isAssignableFrom("(Integer, Integer)=>Boolean", "$Function2<Integer, Integer, Boolean>");
    this.isAssignableFrom("(Integer, Integer)=>Boolean", "$Function2<? super Integer, ? super Integer, Boolean>");
    this.isAssignableFrom("(Integer, Integer)=>Boolean", "$Function2<Integer, Integer, ? extends Boolean>");
    this.isAssignableFrom("(Integer, Integer)=>Boolean", "$Function2<? super Integer, ? super Integer, ? extends Boolean>");
  }
  
  @Test
  public void testFunctionTypeAsParameterized_13() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("(T)=>void", "T extends Integer");
    this.isAssignableFrom(_mappedTo, "$Procedure1<Integer>");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("(T)=>void", "T extends Integer");
    this.isAssignableFrom(_mappedTo_1, "$Procedure1<? super Integer>");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("(T)=>int", "T extends Integer");
    this.isAssignableFrom(_mappedTo_2, "$Function1<Integer, Integer>");
    Pair<String,String> _mappedTo_3 = Pair.<String, String>of("(T)=>int", "T extends Integer");
    this.isAssignableFrom(_mappedTo_3, "$Function1<? super Integer, Integer>");
    Pair<String,String> _mappedTo_4 = Pair.<String, String>of("(T)=>int", "T extends Integer");
    this.isAssignableFrom(_mappedTo_4, "$Function1<Integer, ? extends Integer>");
    Pair<String,String> _mappedTo_5 = Pair.<String, String>of("(T)=>int", "T extends Integer");
    this.isAssignableFrom(_mappedTo_5, "$Function1<? super Integer, ? extends Integer>");
    Pair<String,String> _mappedTo_6 = Pair.<String, String>of("(T)=>Integer", "T extends Integer");
    this.isAssignableFrom(_mappedTo_6, "$Function1<Integer, Integer>");
    Pair<String,String> _mappedTo_7 = Pair.<String, String>of("(T)=>Integer", "T extends Integer");
    this.isAssignableFrom(_mappedTo_7, "$Function1<? super Integer, Integer>");
    Pair<String,String> _mappedTo_8 = Pair.<String, String>of("(T)=>Integer", "T extends Integer");
    this.isAssignableFrom(_mappedTo_8, "$Function1<Integer, ? extends Integer>");
    Pair<String,String> _mappedTo_9 = Pair.<String, String>of("(T)=>Integer", "T extends Integer");
    this.isAssignableFrom(_mappedTo_9, "$Function1<? super Integer, ? extends Integer>");
  }
  
  @Test
  public abstract void testFunctionTypeAsParameterized_14();
  
  @Test
  public abstract void testDemandConvertedFunctionType_01();
  
  @Test
  public void testDemandConvertedFunctionType_02() {
    this.isAssignableFrom("Runnable", "()=>void");
    this.isNotAssignableFrom("Runnable", "()=>String");
    this.isNotAssignableFrom("Runnable", "(String)=>void");
  }
  
  @Test
  public void testDemandConvertedFunctionType_03() {
    this.isAssignableFrom("Iterable<String>", "()=>java.util.Iterator<String>");
    this.isAssignableFrom("Iterable<? extends String>", "()=>java.util.Iterator<? extends String>");
    this.isNotAssignableFrom("Iterable<String>", "()=>void");
    this.isNotAssignableFrom("Iterable<String>", "(Number)=>java.util.Iterator<String>");
  }
  
  @Test
  public void testDemandConvertedFunctionType_04() {
    this.isNotAssignableFrom("$Function<String, CharSequence>", "()=>CharSequence");
    this.isNotAssignableFrom("Iterable<CharSequence>", "(CharSequence)=>String");
    this.isNotAssignableFrom("java.util.Comparator<CharSequence>", "(String)=>String");
  }
  
  @Test
  public abstract void testDemandConvertedFunctionType_05();
  
  @Test
  public abstract void testDemandConvertedFunctionType_06();
  
  @Test
  public void testDemandConvertedFunctionType_07() {
    this.isAssignableFrom("java.util.Comparator<Integer>", "(int, int)=>int");
    this.isAssignableFrom("java.util.Comparator<? super Integer>", "(Integer, Integer)=>int");
    this.isAssignableFrom("java.util.Comparator<Integer>", "(Number, Integer)=>Integer");
    this.isAssignableFrom("java.util.Comparator<? super Integer>", "(Integer, Number)=>Integer");
    this.isAssignableFrom("java.util.Comparator<Integer>", "(Number, Object)=>int");
  }
  
  @Test
  public void testDemandConvertedFunctionType_08() {
    this.isNotAssignableFrom("Comparable<String>", "$Function<String, Integer>");
    this.isNotAssignableFrom("Comparable<String>", "$Function<? super String, Integer>");
    this.isNotAssignableFrom("Comparable<String>", "$Function<String, ? extends Integer>");
    this.isNotAssignableFrom("Comparable<String>", "$Function<? super String, ? extends Integer>");
  }
  
  @Test
  public void testDemandConvertedFunctionType_09() {
    this.isAssignableFrom("Comparable<String>", "$Function1<String, Integer>");
    this.isAssignableFrom("Comparable<String>", "$Function1<? super String, Integer>");
    this.isAssignableFrom("Comparable<String>", "$Function1<String, ? extends Integer>");
    this.isAssignableFrom("Comparable<String>", "$Function1<? super String, ? extends Integer>");
  }
  
  @Test
  public void testDemandConvertedFunctionType_10() {
    this.isAssignableFrom("()=>void", "Runnable");
    this.isNotAssignableFrom("()=>String", "Runnable");
    this.isNotAssignableFrom("(String)=>void", "Runnable");
  }
  
  @Test
  public void testDemandConvertedFunctionType_11() {
    this.isAssignableFrom("()=>java.util.Iterator<String>", "Iterable<String>");
    this.isAssignableFrom("()=>java.util.Iterator<? extends String>", "Iterable<? extends String>");
    this.isNotAssignableFrom("()=>void", "Iterable<String>");
    this.isNotAssignableFrom("(Number)=>java.util.Iterator<String>", "Iterable<String>");
  }
  
  @Test
  public void testDemandConvertedFunctionType_12() {
    this.isNotAssignableFrom("()=>CharSequence", "$Function<String, CharSequence>");
    this.isNotAssignableFrom("(CharSequence)=>String", "Iterable<CharSequence>");
    this.isNotAssignableFrom("(String)=>String", "java.util.Comparator<CharSequence>");
  }
  
  @Test
  public void testDemandConvertedFunctionType_13() {
    this.isAssignableFrom("java.util.Comparator<? super String>", "(String, String)=>int");
    this.isAssignableFrom("java.util.Comparator<String>", "(CharSequence, CharSequence)=>int");
    this.isAssignableFrom("java.util.Comparator<? super String>", "(CharSequence, CharSequence)=>int");
  }
  
  @Test
  public void testBug395002_01() {
    String _selfBound = this.selfBound("$<?, A>");
    String _selfBound_1 = this.selfBound("A extends $<?,A>");
    Pair<String,String> _mappedTo = Pair.<String, String>of(_selfBound, _selfBound_1);
    this.isAssignableFrom(_mappedTo, "A");
  }
  
  @Ignore("Substitutions are not applied recursively according to JLS - see ticket 395002")
  @Test
  public void testBug395002_02() {
    String _selfBound = this.selfBound("$<? extends $<?, A>, ?>");
    String _selfBound_1 = this.selfBound("A extends $<?,A>");
    Pair<String,String> _mappedTo = Pair.<String, String>of(_selfBound, _selfBound_1);
    this.isAssignableFrom(_mappedTo, "$<?, A>");
  }
  
  @Ignore("Substitutions are not applied recursively according to JLS - see ticket 395002")
  @Test
  public void testBug395002_03() {
    String _selfBound = this.selfBound("$<? extends $<?, A>, ?>");
    String _selfBound_1 = this.selfBound("A extends $<?,A>");
    Pair<String,String> _mappedTo = Pair.<String, String>of(_selfBound, _selfBound_1);
    this.isAssignableFrom(_mappedTo, "A");
  }
  
  private String selfBound(final String typeName) {
    String _replace = typeName.replace("$", "org.eclipse.xtend.core.tests.typesystem.ScenarioBug395002$SelfBound");
    return _replace;
  }
}
