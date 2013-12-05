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
import org.eclipse.xtend.core.macro.ConstantExpressionEvaluationException;
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
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
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
    Pair<String,String> _mappedTo = Pair.<String, String>of("float", "1");
    this.evaluatesTo(_mappedTo, Float.valueOf(1f));
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("double", "1");
    this.evaluatesTo(_mappedTo_1, Double.valueOf(1d));
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("long", "1");
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
    Pair<String,String> _mappedTo = Pair.<String, String>of(null, expression);
    this.evaluatesTo(_mappedTo, expectation);
  }
  
  protected void evaluatesTo(final String expression, final Procedure1<? super Object> assertions) {
    Pair<String,String> _mappedTo = Pair.<String, String>of(null, expression);
    this.evaluatesTo(_mappedTo, assertions);
  }
  
  protected void evaluatesTo(final Pair<String,String> typeAndExpression, final Object expectation) {
    final Procedure1<Object> _function = new Procedure1<Object>() {
      public void apply(final Object it) {
        Assert.assertEquals(expectation, it);
      }
    };
    this.evaluatesTo(typeAndExpression, _function);
  }
  
  protected void evaluatesTo(final Pair<String,String> typeAndExpression, final Procedure1<? super Object> assertions) {
    try {
      final String type = typeAndExpression.getKey();
      final String expression = typeAndExpression.getValue();
      String _elvis = null;
      if (type != null) {
        _elvis = type;
      } else {
        _elvis = ObjectExtensions.<String>operator_elvis(type, "void");
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
        JvmTypeReference _returnType = function.getReturnType();
        _xifexpression = _returnType;
      }
      final Object value = this.interpreter.evaluate(expr, _xifexpression);
      assertions.apply(value);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
