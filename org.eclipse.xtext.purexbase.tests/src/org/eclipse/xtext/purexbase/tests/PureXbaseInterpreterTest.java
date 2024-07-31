/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.purexbase.tests;

import org.eclipse.xtext.purexbase.pureXbase.Model;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.testing.evaluation.AbstractXbaseEvaluationTestEx;
import org.junit.After;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

/**
 * @author Eva Poell - Tests for Try with Resources and ternary if
 */
@RunWith(XtextRunner.class)
@InjectWith(PureXbaseInjectorProvider.class)
public class PureXbaseInterpreterTest extends AbstractXbaseEvaluationTestEx {
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
		interpreter = null;
		parseHelper = null;
	}

	@Test
	public void testInvokeProtectedMethod() throws Exception {
		assertEvaluatesTo("", "{ val x = new testdata.VisibilitySuperType() x.protectedProperty }", false);
	}

	@Override
	public void assertEvaluatesTo(Object expectation, String model) throws Exception {
		assertEvaluatesTo(expectation, model, true);
	}

	@Override
	public void assertEvaluatesToArray(Object[] expectation, String model) throws Exception {
		assertEvaluatesTo(expectation, model, true);
	}

	public void assertEvaluatesTo(Object expectation, String model, boolean validate) throws Exception {
		XExpression expression = null;
		try {
			expression = expression(model, validate);
			IEvaluationResult result = interpreter.evaluate(expression);
			Assert.assertNull(
					"Expected no exception. Model was: " + model + ", Exception was: " + result.getException(),
					result.getException());
			if (expectation != null && expectation.getClass().isArray()) {
				Assert.assertArrayEquals("Model was: " + model, (Object[]) expectation, (Object[]) result.getResult());
			} else {
				Assert.assertEquals("Model was: " + model, expectation, result.getResult());
			}
		} finally {
			if ((expression != null)) {
				cache.clear(expression.eResource());
			}
		}
	}

	@Override
	public void assertEvaluatesWithException(Class<? extends Throwable> expectatedException, String model)
			throws Exception {
		XExpression expression = null;
		try {
			expression = expression(model, true);
			IEvaluationResult result = interpreter.evaluate(expression);
			Assert.assertTrue("Expected " + expectatedException.getSimpleName() + " but got: " + result.getException(),
					expectatedException.isInstance(result.getException()));
		} finally {
			if (expression != null) {
				cache.clear(expression.eResource());
			}
		}
	}

	public XExpression expression(String string, boolean resolve) throws Exception {
		Model model = parseHelper.parse(string);
		if (resolve) {
			validationHelper.assertNoErrors(model);
		}
		return model.getBlock();
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
