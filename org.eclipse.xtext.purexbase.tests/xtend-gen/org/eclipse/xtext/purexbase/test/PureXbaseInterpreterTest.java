/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.purexbase.test;

import com.google.inject.Inject;
import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.purexbase.test.RuntimeInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Eva Poell - Tests for Try with Resources and ternary if
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class PureXbaseInterpreterTest extends AbstractXbaseEvaluationTest {
  @Inject
  private ParseHelper<Model> parseHelper;
  
  @Inject
  private ValidationTestHelper validationHelper;
  
  @Inject
  private IExpressionInterpreter interpreter;
  
  @Inject
  private IResourceScopeCache cache;
  
  @After
  public void tearDown() throws Exception {
    this.interpreter = null;
    this.parseHelper = null;
  }
  
  @Test
  public void testInvokeProtectedMethod() throws Exception {
    this.assertEvaluatesTo("", "{ val x = new testdata.VisibilitySuperType() x.protectedProperty }", false);
  }
  
  @Override
  public void assertEvaluatesTo(final Object expectation, final String model) {
    this.assertEvaluatesTo(expectation, model, true);
  }
  
  @Override
  public void assertEvaluatesToArray(final Object[] expectation, final String model) {
    this.assertEvaluatesTo(expectation, model, true);
  }
  
  public void assertEvaluatesTo(final Object expectation, final String model, final boolean validate) {
    try {
      XExpression expression = null;
      try {
        expression = this.expression(model, validate);
        IEvaluationResult result = this.interpreter.evaluate(expression);
        Throwable _exception = result.getException();
        String _plus = ((("Expected no exception. Model was: " + model) + ", Exception was: ") + _exception);
        Assert.assertNull(_plus, 
          result.getException());
        if (((expectation != null) && expectation.getClass().isArray())) {
          Object _result = result.getResult();
          Assert.assertArrayEquals(("Model was: " + model), ((Object[]) expectation), ((Object[]) _result));
        } else {
          Assert.assertEquals(("Model was: " + model), expectation, result.getResult());
        }
      } finally {
        if ((expression != null)) {
          this.cache.clear(expression.eResource());
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void assertEvaluatesWithException(final Class<? extends Throwable> expectatedException, final String model) {
    try {
      XExpression expression = null;
      try {
        expression = this.expression(model, true);
        IEvaluationResult result = this.interpreter.evaluate(expression);
        String _simpleName = expectatedException.getSimpleName();
        String _plus = ("Expected " + _simpleName);
        String _plus_1 = (_plus + " but got: ");
        Throwable _exception = result.getException();
        String _plus_2 = (_plus_1 + _exception);
        Assert.assertTrue(_plus_2, 
          expectatedException.isInstance(result.getException()));
      } finally {
        if ((expression != null)) {
          this.cache.clear(expression.eResource());
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public XExpression expression(final String string, final boolean resolve) throws Exception {
    Model model = this.parseHelper.parse(string);
    if (resolve) {
      this.validationHelper.assertNoErrors(model);
    }
    return model.getBlock();
  }
  
  @Test
  @Override
  public void testTryWithoutResources() {
    try {
      super.testTryWithoutResources();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_easy() {
    try {
      super.testTryWithResources_easy();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_lambda() {
    try {
      super.testTryWithResources_lambda();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_2Resources() {
    try {
      super.testTryWithResources_2Resources();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_2NestedResources() {
    try {
      super.testTryWithResources_2NestedResources();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_2DiffResources() {
    try {
      super.testTryWithResources_2DiffResources();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_if1() {
    try {
      super.testTryWithResources_if1();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_if2() {
    try {
      super.testTryWithResources_if2();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_userClass() {
    try {
      super.testTryWithResources_userClass();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_isClosed1() {
    try {
      super.testTryWithResources_isClosed1();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_isClosed2() {
    try {
      super.testTryWithResources_isClosed2();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_userClassExceptionOnConstructor() {
    try {
      super.testTryWithResources_userClassExceptionOnConstructor();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_userClassExceptionOnClose() {
    try {
      super.testTryWithResources_userClassExceptionOnClose();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_finally() {
    try {
      super.testTryWithResources_finally();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_catch() {
    try {
      super.testTryWithResources_catch();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_catchFinally() {
    try {
      super.testTryWithResources_catchFinally();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_ExceptionInBody() {
    try {
      super.testTryWithResources_ExceptionInBody();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_2Resources_ExceptionInBody() {
    try {
      super.testTryWithResources_2Resources_ExceptionInBody();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_2Resources_ExceptionOnClose() {
    try {
      super.testTryWithResources_2Resources_ExceptionOnClose();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_2ResourcesCatch_01() {
    try {
      super.testTryWithResources_2ResourcesCatch_01();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTryWithResources_2ResourcesCatch_02() {
    try {
      super.testTryWithResources_2ResourcesCatch_02();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTernaryIf_1() {
    try {
      super.testTernaryIf_1();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTernaryIf_2() {
    try {
      super.testTernaryIf_2();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTernaryIf_3() {
    try {
      super.testTernaryIf_3();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTernaryIf_4() {
    try {
      super.testTernaryIf_4();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTernaryIf_5() {
    try {
      super.testTernaryIf_5();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTernaryIf_6() {
    try {
      super.testTernaryIf_6();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  @Override
  public void testTernaryIf_7() {
    try {
      super.testTernaryIf_7();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  @Override
  public void testClosure_31() throws Exception {
    super.testClosure_31();
  }
  
  @Ignore
  @Test
  @Override
  public void testClosure_32() throws Exception {
    super.testClosure_32();
  }
  
  @Ignore
  @Test
  @Override
  public void testArrays_01() throws Exception {
    super.testArrays_01();
  }
  
  @Ignore
  @Test
  @Override
  public void testArrays_02() throws Exception {
    super.testArrays_02();
  }
  
  @Ignore
  @Test
  @Override
  public void testArrays_04() throws Exception {
    super.testArrays_01();
  }
}
