/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.macro.declaration;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.ConstantExpressionsInterpreter;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendTypeDeclaration;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmEnumerationLiteral;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.interpreter.ConstantExpressionEvaluationException;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import test.Constants1;

/**
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class ConstantExpressionsInterpreterTest extends AbstractXtendTestCase {
  @Inject
  private ConstantExpressionsInterpreter interpreter;
  
  @Test
  public void testAnnotationValues() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@test.Annotation(annotation2Value=@test.Annotation2(\'foo\'))");
      _builder.newLine();
      _builder.append("class C { ");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.file(_builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XAnnotation> _annotations = _head.getAnnotations();
      XAnnotation _head_1 = IterableExtensions.<XAnnotation>head(_annotations);
      EList<XAnnotationElementValuePair> _elementValuePairs = _head_1.getElementValuePairs();
      final XAnnotationElementValuePair pair = IterableExtensions.<XAnnotationElementValuePair>head(_elementValuePairs);
      XExpression _value = pair.getValue();
      JvmOperation _element = pair.getElement();
      JvmTypeReference _returnType = _element.getReturnType();
      Object _evaluate = this.interpreter.evaluate(_value, _returnType);
      final XAnnotation anno = ((XAnnotation) _evaluate);
      JvmType _annotationType = anno.getAnnotationType();
      String _identifier = _annotationType.getIdentifier();
      Assert.assertEquals("test.Annotation2", _identifier);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumLiteral_WithStaticImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static test.Enum1.* ");
      _builder.newLine();
      _builder.append("class C { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Enum1 testFoo = RED");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.file(_builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = _head.getMembers();
      Iterable<XtendField> _filter = Iterables.<XtendField>filter(_members, XtendField.class);
      final XtendField field = IterableExtensions.<XtendField>head(_filter);
      XExpression _initialValue = field.getInitialValue();
      JvmTypeReference _type = field.getType();
      Object _evaluate = this.interpreter.evaluate(_initialValue, _type);
      final JvmEnumerationLiteral blue = ((JvmEnumerationLiteral) _evaluate);
      String _simpleName = blue.getSimpleName();
      Assert.assertEquals("RED", _simpleName);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstants_WithStaticImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static test.Constants1.* ");
      _builder.newLine();
      _builder.append("class C { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val someString = STRING_CONSTANT");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val someInt = INT_CONSTANT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.file(_builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = _head.getMembers();
      Iterable<XtendField> _filter = Iterables.<XtendField>filter(_members, XtendField.class);
      final XtendField stringField = IterableExtensions.<XtendField>head(_filter);
      EList<XtendTypeDeclaration> _xtendTypes_1 = file.getXtendTypes();
      XtendTypeDeclaration _head_1 = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes_1);
      EList<XtendMember> _members_1 = _head_1.getMembers();
      Iterable<XtendField> _filter_1 = Iterables.<XtendField>filter(_members_1, XtendField.class);
      final XtendField intField = ((XtendField[])Conversions.unwrapArray(_filter_1, XtendField.class))[1];
      XExpression _initialValue = stringField.getInitialValue();
      Object _evaluate = this.interpreter.evaluate(_initialValue, null);
      Assert.assertEquals(Constants1.STRING_CONSTANT, _evaluate);
      XExpression _initialValue_1 = intField.getInitialValue();
      Object _evaluate_1 = this.interpreter.evaluate(_initialValue_1, null);
      Assert.assertEquals(Integer.valueOf(Constants1.INT_CONSTANT), _evaluate_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstants_WithStaticImport_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static test.Constants1.* ");
      _builder.newLine();
      _builder.append("import static MyConstants.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class C { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val someString = STRING_CONSTANT+\'-\'+MY_CONST");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class MyConstants {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static val MY_CONST = STRING_CONSTANT");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.file(_builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = _head.getMembers();
      Iterable<XtendField> _filter = Iterables.<XtendField>filter(_members, XtendField.class);
      final XtendField stringField = IterableExtensions.<XtendField>head(_filter);
      XExpression _initialValue = stringField.getInitialValue();
      Object _evaluate = this.interpreter.evaluate(_initialValue, null);
      Assert.assertEquals(((Constants1.STRING_CONSTANT + "-") + Constants1.STRING_CONSTANT), _evaluate);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstants_RecursionFails() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static MyConstants.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class C { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val someString = MY_CONST");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class MyConstants {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static val MY_CONST = STRING_CONSTANT");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static val STRING_CONSTANT = MY_CONST");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.file(_builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = _head.getMembers();
      Iterable<XtendField> _filter = Iterables.<XtendField>filter(_members, XtendField.class);
      final XtendField stringField = IterableExtensions.<XtendField>head(_filter);
      try {
        XExpression _initialValue = stringField.getInitialValue();
        Object _evaluate = this.interpreter.evaluate(_initialValue, null);
        InputOutput.<Object>println(_evaluate);
        Assert.fail("Exception expected");
      } catch (final Throwable _t) {
        if (_t instanceof ConstantExpressionEvaluationException) {
          final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOperators() {
    Pair<String, String> _mappedTo = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("2", "int");
    this.assertEvaluatesTo(Boolean.valueOf((1 == 2)), _mappedTo, _mappedTo_1, "===");
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("1", "byte");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_2, _mappedTo_3, "===");
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("1", "float");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_4, _mappedTo_5, "===");
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("1", "long");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_6, _mappedTo_7, "===");
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("1", "double");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_8, _mappedTo_9, "===");
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_11 = Pair.<String, String>of("1", "byte");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_10, _mappedTo_11, "<=");
    Pair<String, String> _mappedTo_12 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_13 = Pair.<String, String>of("1", "float");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_12, _mappedTo_13, "<=");
    Pair<String, String> _mappedTo_14 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_15 = Pair.<String, String>of("1", "long");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_14, _mappedTo_15, "<=");
    Pair<String, String> _mappedTo_16 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_17 = Pair.<String, String>of("1", "double");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_16, _mappedTo_17, "<=");
    Pair<String, String> _mappedTo_18 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_19 = Pair.<String, String>of("1", "byte");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_18, _mappedTo_19, ">=");
    Pair<String, String> _mappedTo_20 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_21 = Pair.<String, String>of("1", "float");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_20, _mappedTo_21, ">=");
    Pair<String, String> _mappedTo_22 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_23 = Pair.<String, String>of("1", "long");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_22, _mappedTo_23, ">=");
    Pair<String, String> _mappedTo_24 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_25 = Pair.<String, String>of("1", "double");
    this.assertEvaluatesTo(Boolean.valueOf(true), _mappedTo_24, _mappedTo_25, ">=");
    Pair<String, String> _mappedTo_26 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_27 = Pair.<String, String>of("1", "byte");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_26, _mappedTo_27, "!==");
    Pair<String, String> _mappedTo_28 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_29 = Pair.<String, String>of("1", "float");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_28, _mappedTo_29, "!==");
    Pair<String, String> _mappedTo_30 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_31 = Pair.<String, String>of("1", "long");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_30, _mappedTo_31, "!==");
    Pair<String, String> _mappedTo_32 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_33 = Pair.<String, String>of("1", "double");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_32, _mappedTo_33, "!==");
    Pair<String, String> _mappedTo_34 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_35 = Pair.<String, String>of("1", "byte");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_34, _mappedTo_35, "<");
    Pair<String, String> _mappedTo_36 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_37 = Pair.<String, String>of("1", "float");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_36, _mappedTo_37, "<");
    Pair<String, String> _mappedTo_38 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_39 = Pair.<String, String>of("1", "long");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_38, _mappedTo_39, "<");
    Pair<String, String> _mappedTo_40 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_41 = Pair.<String, String>of("1", "double");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_40, _mappedTo_41, "<");
    Pair<String, String> _mappedTo_42 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_43 = Pair.<String, String>of("1", "byte");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_42, _mappedTo_43, ">");
    Pair<String, String> _mappedTo_44 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_45 = Pair.<String, String>of("1", "float");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_44, _mappedTo_45, ">");
    Pair<String, String> _mappedTo_46 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_47 = Pair.<String, String>of("1", "long");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_46, _mappedTo_47, ">");
    Pair<String, String> _mappedTo_48 = Pair.<String, String>of("1", "int");
    Pair<String, String> _mappedTo_49 = Pair.<String, String>of("1", "double");
    this.assertEvaluatesTo(Boolean.valueOf(false), _mappedTo_48, _mappedTo_49, ">");
  }
  
  @Test
  public void testOperatorsWithExpectation() {
    Pair<String, String> _mappedTo = Pair.<String, String>of("boolean", "1 + 1");
    this.evaluatesTo(_mappedTo, Integer.valueOf(2));
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("boolean", "1 - 1");
    this.evaluatesTo(_mappedTo_1, Integer.valueOf(0));
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("boolean", "1 * 1");
    this.evaluatesTo(_mappedTo_2, Integer.valueOf(1));
    Pair<String, String> _mappedTo_3 = Pair.<String, String>of("boolean", "1 / 1");
    this.evaluatesTo(_mappedTo_3, Integer.valueOf(1));
    Pair<String, String> _mappedTo_4 = Pair.<String, String>of("boolean", "1 % 1");
    this.evaluatesTo(_mappedTo_4, Integer.valueOf(0));
    Pair<String, String> _mappedTo_5 = Pair.<String, String>of("boolean", "1 < 1");
    this.evaluatesTo(_mappedTo_5, Boolean.valueOf(false));
    Pair<String, String> _mappedTo_6 = Pair.<String, String>of("boolean", "1 <= 1");
    this.evaluatesTo(_mappedTo_6, Boolean.valueOf(true));
    Pair<String, String> _mappedTo_7 = Pair.<String, String>of("boolean", "1 > 1");
    this.evaluatesTo(_mappedTo_7, Boolean.valueOf(false));
    Pair<String, String> _mappedTo_8 = Pair.<String, String>of("boolean", "1 >= 1");
    this.evaluatesTo(_mappedTo_8, Boolean.valueOf(true));
    Pair<String, String> _mappedTo_9 = Pair.<String, String>of("boolean", "1 == 1");
    this.evaluatesTo(_mappedTo_9, Boolean.valueOf(true));
    Pair<String, String> _mappedTo_10 = Pair.<String, String>of("boolean", "1 != 1");
    this.evaluatesTo(_mappedTo_10, Boolean.valueOf(false));
    Pair<String, String> _mappedTo_11 = Pair.<String, String>of("boolean", "1 === 1");
    this.evaluatesTo(_mappedTo_11, Boolean.valueOf(true));
    Pair<String, String> _mappedTo_12 = Pair.<String, String>of("boolean", "1 !== 1");
    this.evaluatesTo(_mappedTo_12, Boolean.valueOf(false));
  }
  
  protected void assertEvaluatesTo(final Object expectation, final Pair<String, String> left, final Pair<String, String> right, final String op) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import static MyConstants.*");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class C { ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static val result = A ");
      _builder.append(op, "\t");
      _builder.append(" B");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class MyConstants {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static val ");
      String _value = left.getValue();
      _builder.append(_value, "\t");
      _builder.append(" A = ");
      String _key = left.getKey();
      _builder.append(_key, "\t");
      _builder.append(" as ");
      String _value_1 = left.getValue();
      _builder.append(_value_1, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("\t");
      _builder.append("static val ");
      String _value_2 = right.getValue();
      _builder.append(_value_2, "\t");
      _builder.append(" B = ");
      String _key_1 = right.getKey();
      _builder.append(_key_1, "\t");
      _builder.append(" as ");
      String _value_3 = right.getValue();
      _builder.append(_value_3, "\t");
      _builder.newLineIfNotEmpty();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.file(_builder.toString());
      EList<XtendTypeDeclaration> _xtendTypes = file.getXtendTypes();
      XtendTypeDeclaration _head = IterableExtensions.<XtendTypeDeclaration>head(_xtendTypes);
      EList<XtendMember> _members = _head.getMembers();
      Iterable<XtendField> _filter = Iterables.<XtendField>filter(_members, XtendField.class);
      final XtendField stringField = IterableExtensions.<XtendField>head(_filter);
      XExpression _initialValue = stringField.getInitialValue();
      Object _evaluate = this.interpreter.evaluate(_initialValue, null);
      Assert.assertEquals(expectation, _evaluate);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumLiteral() {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        String _simpleName = ((JvmEnumerationLiteral) it).getSimpleName();
        Assert.assertEquals("YELLOW", _simpleName);
      }
    };
    this.evaluatesTo("test.Enum1.YELLOW", _function);
    final Procedure1<Object> _function_1 = new Procedure1<Object>() {
      public void apply(final Object it) {
        JvmEnumerationLiteral _get = ((JvmEnumerationLiteral[]) it)[0];
        String _simpleName = _get.getSimpleName();
        Assert.assertEquals("YELLOW", _simpleName);
      }
    };
    this.evaluatesTo("#[test.Enum1.YELLOW,test.Enum1.RED]", _function_1);
  }
  
  @Test
  public void testConstantsReference() {
    this.evaluatesTo("test.Constants1.STRING_CONSTANT", Constants1.STRING_CONSTANT);
    this.evaluatesTo("test.Constants1.INT_CONSTANT", Integer.valueOf(Constants1.INT_CONSTANT));
  }
  
  @Test
  public void testBooleanLiteral() {
    this.evaluatesTo("true", Boolean.valueOf(true));
    this.evaluatesTo("false", Boolean.valueOf(false));
    this.evaluatesTo("!true", Boolean.valueOf(false));
    this.evaluatesTo("!false", Boolean.valueOf(true));
    this.evaluatesTo("42 > 5", Boolean.valueOf(true));
    this.evaluatesTo("42 >= 5", Boolean.valueOf(true));
    this.evaluatesTo("42 === 5", Boolean.valueOf(false));
    this.evaluatesTo("42 !== 5", Boolean.valueOf(true));
    this.evaluatesTo("42 < 5", Boolean.valueOf(false));
    this.evaluatesTo("42 <= 5", Boolean.valueOf(false));
  }
  
  @Test
  public void testStringLiteral() {
    this.evaluatesTo("\"foo\"", "foo");
    this.evaluatesTo("\"fo\"+\"o\"", "foo");
    this.evaluatesTo("\"fo\"+2", "fo2");
  }
  
  @Test
  public void testStringArrayLiteral() {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        Object _get = ((String[]) it)[1];
        Assert.assertEquals("bar", _get);
      }
    };
    this.evaluatesTo("#[\"foo\",\"bar\"]", _function);
    final Procedure1<Object> _function_1 = new Procedure1<Object>() {
      public void apply(final Object it) {
        Object _get = ((String[]) it)[1];
        Assert.assertEquals("bar", _get);
      }
    };
    this.evaluatesTo("#[\"foo\",\"b\"+\"a\"+\"r\"]", _function_1);
  }
  
  @Test
  public void testClassLiteral() {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        Assert.assertTrue((it instanceof JvmTypeReference));
        String _identifier = ((JvmTypeReference) it).getIdentifier();
        Assert.assertEquals("java.lang.String", _identifier);
      }
    };
    final Procedure1<Object> assertion = _function;
    this.evaluatesTo("typeof(String)", assertion);
    this.evaluatesTo("String", assertion);
    this.evaluatesTo("java.lang.String", assertion);
  }
  
  @Test
  public void testClassLiteralArray() {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        Assert.assertTrue((it instanceof JvmTypeReference[]));
        JvmTypeReference _get = ((JvmTypeReference[]) it)[0];
        String _identifier = _get.getIdentifier();
        Assert.assertEquals("java.lang.String", _identifier);
        JvmTypeReference _get_1 = ((JvmTypeReference[]) it)[1];
        String _identifier_1 = _get_1.getIdentifier();
        Assert.assertEquals("java.lang.Class", _identifier_1);
      }
    };
    final Procedure1<Object> assertion = _function;
    this.evaluatesTo("#[typeof(String), typeof(Class)]", assertion);
    this.evaluatesTo("#[String,Class]", assertion);
    this.evaluatesTo("#[java.lang.String, java.lang.Class]", assertion);
    this.evaluatesTo("#[typeof(String), Class]", assertion);
  }
  
  @Test
  public void testNumberLiteralWithExpectation() {
    Pair<String, String> _mappedTo = Pair.<String, String>of("float", "1");
    this.evaluatesTo(_mappedTo, Float.valueOf(1f));
    Pair<String, String> _mappedTo_1 = Pair.<String, String>of("double", "1");
    this.evaluatesTo(_mappedTo_1, Double.valueOf(1d));
    Pair<String, String> _mappedTo_2 = Pair.<String, String>of("long", "1");
    this.evaluatesTo(_mappedTo_2, Long.valueOf(1l));
  }
  
  @Test
  public void testError() {
    final Procedure1<ConstantExpressionEvaluationException> _function = new Procedure1<ConstantExpressionEvaluationException>() {
      public void apply(final ConstantExpressionEvaluationException it) {
      }
    };
    this.evaluatesWithException("1.intValue", _function);
    final Procedure1<ConstantExpressionEvaluationException> _function_1 = new Procedure1<ConstantExpressionEvaluationException>() {
      public void apply(final ConstantExpressionEvaluationException it) {
      }
    };
    this.evaluatesWithException("String.name", _function_1);
    final Procedure1<ConstantExpressionEvaluationException> _function_2 = new Procedure1<ConstantExpressionEvaluationException>() {
      public void apply(final ConstantExpressionEvaluationException it) {
      }
    };
    this.evaluatesWithException("if (true) 2 else 3", _function_2);
    final Procedure1<ConstantExpressionEvaluationException> _function_3 = new Procedure1<ConstantExpressionEvaluationException>() {
      public void apply(final ConstantExpressionEvaluationException it) {
      }
    };
    this.evaluatesWithException("for (x : 1..3) { println(\"foo\") }", _function_3);
  }
  
  protected void evaluatesWithException(final String expression, final Procedure1<? super ConstantExpressionEvaluationException> exceptionAssertions) {
    try {
      final XtendFunction function = this.function((("def void testFoo() { " + expression) + " }"));
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression expr = IterableExtensions.<XExpression>head(_expressions);
      try {
        this.interpreter.evaluate(expr, null);
        Assert.fail("exception expected");
      } catch (final Throwable _t) {
        if (_t instanceof ConstantExpressionEvaluationException) {
          final ConstantExpressionEvaluationException e = (ConstantExpressionEvaluationException)_t;
          exceptionAssertions.apply(e);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void evaluatesTo(final String expression, final Object expectation) {
    Pair<String, String> _mappedTo = Pair.<String, String>of(null, expression);
    this.evaluatesTo(_mappedTo, expectation);
  }
  
  protected void evaluatesTo(final String expression, final Procedure1<? super Object> assertions) {
    Pair<String, String> _mappedTo = Pair.<String, String>of(null, expression);
    this.evaluatesTo(_mappedTo, assertions);
  }
  
  protected void evaluatesTo(final Pair<String, String> typeAndExpression, final Object expectation) {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        Assert.assertEquals(expectation, it);
      }
    };
    this.evaluatesTo(typeAndExpression, _function);
  }
  
  protected void evaluatesTo(final Pair<String, String> typeAndExpression, final Procedure1<? super Object> assertions) {
    try {
      final String type = typeAndExpression.getKey();
      final String expression = typeAndExpression.getValue();
      String _elvis = null;
      if (type != null) {
        _elvis = type;
      } else {
        _elvis = "void";
      }
      String _plus = ("def " + _elvis);
      String _plus_1 = (_plus + " testFoo() { ");
      String _plus_2 = (_plus_1 + expression);
      String _plus_3 = (_plus_2 + " }");
      final XtendFunction function = this.function(_plus_3);
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression expr = IterableExtensions.<XExpression>head(_expressions);
      JvmTypeReference _xifexpression = null;
      boolean _notEquals = (!Objects.equal(type, null));
      if (_notEquals) {
        _xifexpression = function.getReturnType();
      }
      final Object value = this.interpreter.evaluate(expr, _xifexpression);
      assertions.apply(value);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
