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
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xbase.typesystem.references.AnyTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xbase.typesystem.references.WildcardTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow
 */
@SuppressWarnings("all")
public abstract class AbstractAssignabilityTest extends AbstractTestingTypeReferenceOwner {
  @Inject
  private IXtendJvmAssociations _iXtendJvmAssociations;
  
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
      String _elvis = ObjectExtensions.<String>operator_elvis(_key, "Object");
      _builder.append(_elvis, "");
      _builder.append(" lhs, ");
      String _elvis_1 = ObjectExtensions.<String>operator_elvis(rhs, "Object");
      _builder.append(_elvis_1, "");
      _builder.append(" rhs) {}");
      final CharSequence signature = _builder;
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
          boolean _testIsAssignable_1 = this.testIsAssignable(superType, rhsType);
          Assert.assertEquals(Boolean.valueOf(expectation), Boolean.valueOf(_testIsAssignable_1));
        }
      }
    } catch (Exception _e) {
      throw Exceptions.sneakyThrow(_e);
    }
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
    WildcardTypeReference _wildcardTypeReference = new WildcardTypeReference(this);
    final WildcardTypeReference wcRhs = _wildcardTypeReference;
    wcRhs.addUpperBound(rhs);
    boolean _doIsAssignable_3 = this.doIsAssignable(lhs, wcRhs);
    Assert.assertEquals(Boolean.valueOf(result), Boolean.valueOf(_doIsAssignable_3));
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
}
