package org.eclipse.xtend.core.tests.macro.declaration;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.macro.ConstantExpressionsInterpreter;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationElementValuePair;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ConstantExpressionsInterpreterTest extends AbstractXtendTestCase {
  @Inject
  private ConstantExpressionsInterpreter interpreter;
  
  @Test
  public void testBooleanLiteral() {
    try {
      final XtendFunction function = this.function("@test.Annotation(booleanValue=true) def void testFoo() {}");
      EList<XAnnotation> _annotations = function.getAnnotations();
      XAnnotation _head = IterableExtensions.<XAnnotation>head(_annotations);
      EList<XAnnotationElementValuePair> _elementValuePairs = _head.getElementValuePairs();
      XAnnotationElementValuePair _head_1 = IterableExtensions.<XAnnotationElementValuePair>head(_elementValuePairs);
      XExpression _value = _head_1.getValue();
      IEvaluationResult _evaluate = this.interpreter.evaluate(_value);
      Object _result = _evaluate.getResult();
      Assert.assertTrue((((Boolean) _result)).booleanValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStringLiteral() {
    try {
      final XtendFunction function = this.function("@Foo(\"foo\") def void testFoo() {}");
      EList<XAnnotation> _annotations = function.getAnnotations();
      XAnnotation _head = IterableExtensions.<XAnnotation>head(_annotations);
      XExpression _value = _head.getValue();
      IEvaluationResult _evaluate = this.interpreter.evaluate(_value);
      Object _result = _evaluate.getResult();
      Assert.assertEquals("foo", _result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStringAdditionLiteral() {
    try {
      final XtendFunction function = this.function("@Foo((\"foo\" + \"bar\")) def void testFoo() {}");
      EList<XAnnotation> _annotations = function.getAnnotations();
      XAnnotation _head = IterableExtensions.<XAnnotation>head(_annotations);
      XExpression _value = _head.getValue();
      IEvaluationResult _evaluate = this.interpreter.evaluate(_value);
      Object _result = _evaluate.getResult();
      Assert.assertEquals("foobar", _result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStringArrayLiteral() {
    try {
      final XtendFunction function = this.function("@test.Annotation(stringArrayValue=#[\"foo\",\"bar\"]) def void testFoo() {}");
      EList<XAnnotation> _annotations = function.getAnnotations();
      XAnnotation _head = IterableExtensions.<XAnnotation>head(_annotations);
      EList<XAnnotationElementValuePair> _elementValuePairs = _head.getElementValuePairs();
      XAnnotationElementValuePair _head_1 = IterableExtensions.<XAnnotationElementValuePair>head(_elementValuePairs);
      XExpression _value = _head_1.getValue();
      IEvaluationResult _evaluate = this.interpreter.evaluate(_value);
      Object _result = _evaluate.getResult();
      Object _get = ((String[]) _result)[1];
      Assert.assertEquals("bar", _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStringArrayLiteral_01() {
    try {
      final XtendFunction function = this.function("@test.Annotation(stringArrayValue=#[\"foo\",\"b\"+\"a\"+\"r\"]) def void testFoo() {}");
      EList<XAnnotation> _annotations = function.getAnnotations();
      XAnnotation _head = IterableExtensions.<XAnnotation>head(_annotations);
      EList<XAnnotationElementValuePair> _elementValuePairs = _head.getElementValuePairs();
      XAnnotationElementValuePair _head_1 = IterableExtensions.<XAnnotationElementValuePair>head(_elementValuePairs);
      XExpression _value = _head_1.getValue();
      IEvaluationResult _evaluate = this.interpreter.evaluate(_value);
      Object _result = _evaluate.getResult();
      Object _get = ((String[]) _result)[1];
      Assert.assertEquals("bar", _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNumberLiteral_long() {
    try {
      final XtendFunction function = this.function("def long testFoo() { 1 }");
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression numberLiteral = IterableExtensions.<XExpression>head(_expressions);
      IEvaluationResult _evaluate = this.interpreter.evaluate(numberLiteral);
      final Object value = _evaluate.getResult();
      Class<? extends Object> _class = value.getClass();
      Assert.assertEquals(Long.class, _class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNumberLiteral_double() {
    try {
      final XtendFunction function = this.function("def double testFoo() { 1 }");
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression numberLiteral = IterableExtensions.<XExpression>head(_expressions);
      IEvaluationResult _evaluate = this.interpreter.evaluate(numberLiteral);
      final Object value = _evaluate.getResult();
      Class<? extends Object> _class = value.getClass();
      Assert.assertEquals(Double.class, _class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNumberLiteral_float() {
    try {
      final XtendFunction function = this.function("def float testFoo() { 1 }");
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression numberLiteral = IterableExtensions.<XExpression>head(_expressions);
      IEvaluationResult _evaluate = this.interpreter.evaluate(numberLiteral);
      final Object value = _evaluate.getResult();
      Class<? extends Object> _class = value.getClass();
      Assert.assertEquals(Float.class, _class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
