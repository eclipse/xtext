/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.interpreter;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.tests.XbaseInjectorProvider;
import org.junit.After;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XbaseInjectorProvider.class)
public class XbaseInterpreterTest extends AbstractXbaseEvaluationTest {

	@Inject
	private ParseHelper<XExpression> parseHelper;
	@Inject
	private ValidationTestHelper validationHelper;
	@Inject
	private IExpressionInterpreter interpreter;
	@Inject
	private IResourceScopeCache cache;

	@After
	public void tearDown() throws Exception {
		interpreter = null;
		parseHelper = null;
	}
	
	@Test
	public void testInvokeProtectedMethod() throws Exception {
		// assuming a context where protected members are accessible, e.g. an interpreted operation
		// in the very same class
		assertEvaluatesTo("", "{ val x = new testdata.VisibilitySuperType() x.protectedProperty }", false);
	}

	@Override
	public void assertEvaluatesTo(Object expectation, String model) {
		assertEvaluatesTo(expectation, model, true);
	}
	
	@Override
	public void assertEvaluatesToArray(Object[] expectation, String model) {
		assertEvaluatesTo(expectation, model, true);
	}
	
	public void assertEvaluatesTo(Object expectation, String model, boolean validate) {
		XExpression expression = null;
		try {
			expression = expression(model, validate);
			IEvaluationResult result = interpreter.evaluate(expression);
			assertNull("Expected no exception. Model was: " + model + ", Exception was: " + result.getException(),
					result.getException());
			if(expectation != null && expectation.getClass().isArray())
				assertArrayEquals("Model was: " + model, (Object[]) expectation, (Object[]) result.getResult());
			else
				assertEquals("Model was: " + model, expectation, result.getResult());
		} catch (Exception e) {
			if (e instanceof RuntimeException)
				throw (RuntimeException) e;
			throw new RuntimeException(e);
		} finally {
			if (expression != null) {
				cache.clear(expression.eResource());
			}
		}
	}

	@Override
	public void assertEvaluatesWithException(Class<? extends Throwable> expectatedException, String model) {
		XExpression expression = null;
		try {
			expression = expression(model,true);
			IEvaluationResult result = interpreter.evaluate(expression);
			assertTrue("Expected " + expectatedException.getSimpleName() + " but got: " + result.getException(),
					expectatedException.isInstance(result.getException()));
		} catch (Exception e) {
			if (e instanceof RuntimeException)
				throw (RuntimeException) e;
			throw new RuntimeException(e);
		} finally {
			if (expression != null) {
				cache.clear(expression.eResource());
			}
		}
	}
	
	protected XExpression expression(String string, boolean resolve) throws Exception {
		XExpression result = parseHelper.parse(string);
		if (resolve) {
			validationHelper.assertNoErrors(result);
		}
		return result;
	}
	
	@Override @Ignore
	@Test public void testClosure_31() throws Exception {
		super.testClosure_31();
	}
	
	@Override @Ignore
	@Test public void testClosure_32() throws Exception {
		super.testClosure_32();
	}
	
	@Override
	@Ignore @Test public void testArrays_01() throws Exception {
		super.testArrays_01();
	}
	
	@Override
	@Ignore @Test public void testArrays_02() throws Exception {
		super.testArrays_02();
	}
	
	@Override
	@Ignore @Test public void testArrays_04() throws Exception {
		super.testArrays_01();
	}
	
}
