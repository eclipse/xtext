package org.eclipse.xtend.core.tests.annotations;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.annotations.interpreter.ConstantExpressionsInterpreter;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotation;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.eclipse.xtext.xbase.typesystem.references.UnknownTypeReference;
import org.eclipse.xtext.xbase.typesystem.util.CommonTypeComputationServices;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ConstantExpressionsInterpreterTest extends AbstractXtendTestCase {
  @Inject
  private ConstantExpressionsInterpreter interpreter;
  
  @Inject
  private CommonTypeComputationServices services;
  
  @Test
  public void testBooleanLiteral() {
    try {
      final XtendFunction function = this.function("@Foo(true) def void testFoo() {}");
      EList<XAnnotation> _annotations = function.getAnnotations();
      XAnnotation _head = IterableExtensions.<XAnnotation>head(_annotations);
      XExpression _value = _head.getValue();
      Object _evaluate = this.interpreter.evaluate(_value, null);
      Assert.assertTrue((((Boolean) _evaluate)).booleanValue());
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
      Object _evaluate = this.interpreter.evaluate(_value, null);
      Assert.assertEquals("foo", _evaluate);
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
      Object _evaluate = this.interpreter.evaluate(_value, null);
      Assert.assertEquals("foobar", _evaluate);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStringArrayLiteral() {
    try {
      final XtendFunction function = this.function("@Foo(#[\"foo\",\"bar\"]) def void testFoo() {}");
      EList<XAnnotation> _annotations = function.getAnnotations();
      XAnnotation _head = IterableExtensions.<XAnnotation>head(_annotations);
      XExpression _value = _head.getValue();
      Object _evaluate = this.interpreter.evaluate(_value, null);
      Object _get = ((String[]) _evaluate)[1];
      Assert.assertEquals("bar", _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStringArrayLiteral_01() {
    try {
      final XtendFunction function = this.function("@Foo(#[\"foo\"+\"bar\",\"bar\"]) def void testFoo() {}");
      EList<XAnnotation> _annotations = function.getAnnotations();
      XAnnotation _head = IterableExtensions.<XAnnotation>head(_annotations);
      XExpression _value = _head.getValue();
      Object _evaluate = this.interpreter.evaluate(_value, null);
      Object _get = ((String[]) _evaluate)[1];
      Assert.assertEquals("bar", _get);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeLiteral() {
    try {
      final XtendFunction function = this.function("@Foo(typeof(String)) def void testFoo() {}");
      EList<XAnnotation> _annotations = function.getAnnotations();
      XAnnotation _head = IterableExtensions.<XAnnotation>head(_annotations);
      XExpression _value = _head.getValue();
      Object _evaluate = this.interpreter.evaluate(_value, null);
      String _simpleName = ((JvmType) _evaluate).getSimpleName();
      Assert.assertEquals("String", _simpleName);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNumberLiteral_long() {
    try {
      final XtendFunction function = this.function("def void testFoo() { 1 }");
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression numberLiteral = IterableExtensions.<XExpression>head(_expressions);
      StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, function);
      final StandardTypeReferenceOwner owner = _standardTypeReferenceOwner;
      UnknownTypeReference _unknownTypeReference = new UnknownTypeReference(owner, "long");
      final UnknownTypeReference pseudo = _unknownTypeReference;
      final Object value = this.interpreter.evaluate(numberLiteral, pseudo);
      Class<? extends Object> _class = value.getClass();
      Assert.assertEquals(Long.class, _class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNumberLiteral_double() {
    try {
      final XtendFunction function = this.function("def void testFoo() { 1 }");
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression numberLiteral = IterableExtensions.<XExpression>head(_expressions);
      StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, function);
      final StandardTypeReferenceOwner owner = _standardTypeReferenceOwner;
      UnknownTypeReference _unknownTypeReference = new UnknownTypeReference(owner, "double");
      final UnknownTypeReference pseudo = _unknownTypeReference;
      final Object value = this.interpreter.evaluate(numberLiteral, pseudo);
      Class<? extends Object> _class = value.getClass();
      Assert.assertEquals(Double.class, _class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNumberLiteral_float() {
    try {
      final XtendFunction function = this.function("def void testFoo() { 1 }");
      XExpression _expression = function.getExpression();
      EList<XExpression> _expressions = ((XBlockExpression) _expression).getExpressions();
      final XExpression numberLiteral = IterableExtensions.<XExpression>head(_expressions);
      StandardTypeReferenceOwner _standardTypeReferenceOwner = new StandardTypeReferenceOwner(this.services, function);
      final StandardTypeReferenceOwner owner = _standardTypeReferenceOwner;
      UnknownTypeReference _unknownTypeReference = new UnknownTypeReference(owner, "float");
      final UnknownTypeReference pseudo = _unknownTypeReference;
      final Object value = this.interpreter.evaluate(numberLiteral, pseudo);
      Class<? extends Object> _class = value.getClass();
      Assert.assertEquals(Float.class, _class);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
