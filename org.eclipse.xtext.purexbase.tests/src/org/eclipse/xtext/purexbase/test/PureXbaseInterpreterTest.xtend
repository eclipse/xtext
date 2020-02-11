/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.test;

import com.google.inject.Inject
import org.eclipse.xtext.purexbase.pureXbase.Model
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.util.IResourceScopeCache
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest
import org.junit.After
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Eva Poell - Tests for Try with Resources and ternary if
 */
@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class PureXbaseInterpreterTest extends AbstractXbaseEvaluationTest {

	@Inject
	ParseHelper<Model> parseHelper
	@Inject
	ValidationTestHelper validationHelper
	@Inject
	IExpressionInterpreter interpreter
	@Inject
	IResourceScopeCache cache

	@After
	def void tearDown() throws Exception {
		interpreter = null;
		parseHelper = null;
	}

	@Test
	def void testInvokeProtectedMethod() throws Exception {
		// assuming a context where protected members are accessible, e.g. an
		// interpreted operation
		// in the very same class
		assertEvaluatesTo("", "{ val x = new testdata.VisibilitySuperType() x.protectedProperty }", false);
	}

	override void assertEvaluatesTo(Object expectation, String model) {
		assertEvaluatesTo(expectation, model, true);
	}

	override void assertEvaluatesToArray(Object[] expectation, String model) {
		assertEvaluatesTo(expectation, model, true);
	}

	def void assertEvaluatesTo(Object expectation, String model, boolean validate) {
		var XExpression expression = null;
		try {
			expression = expression(model, validate)
			var result = interpreter.evaluate(expression)
			assertNull("Expected no exception. Model was: " + model + ", Exception was: " + result.getException(),
				result.getException())
			if (expectation !== null && expectation.getClass().isArray())
				assertArrayEquals("Model was: " + model, (expectation as Object[]), (result.getResult() as Object[]))
			else
				assertEquals("Model was: " + model, expectation, result.getResult())
		} finally {
			if (expression !== null) {
				cache.clear(expression.eResource());
			}
		}
	}

	override void assertEvaluatesWithException(Class<? extends Throwable> expectatedException, String model) {
		var XExpression expression = null;
		try {
			expression = expression(model, true);
			var IEvaluationResult result = interpreter.evaluate(expression);
			assertTrue("Expected " + expectatedException.getSimpleName() + " but got: " + result.getException(),
				expectatedException.isInstance(result.getException()));
		} finally {
			if (expression !== null) {
				cache.clear(expression.eResource());
			}
		}
	}

	def XExpression expression(String string, boolean resolve) throws Exception {
		var model = parseHelper.parse(string);
		if (resolve) {
			validationHelper.assertNoErrors(model);
		}
		return model.getBlock();
	}

	@Test
	override void testTryWithoutResources() {
		super.testTryWithoutResources
	}

	@Test
	override void testTryWithResources_easy() {
		super.testTryWithResources_easy
	}

	@Test
	override void testTryWithResources_lambda() {
		super.testTryWithResources_lambda
	}

	@Test
	override void testTryWithResources_2Resources() {
		super.testTryWithResources_2Resources
	}

	@Test
	override void testTryWithResources_2NestedResources() {
		super.testTryWithResources_2NestedResources
	}

	@Test
	override void testTryWithResources_2DiffResources() {
		super.testTryWithResources_2DiffResources
	}

	@Test
	override void testTryWithResources_if1() {
		super.testTryWithResources_if1
	}

	@Test
	override void testTryWithResources_if2() {
		super.testTryWithResources_if2
	}

	@Test
	override void testTryWithResources_userClass() {
		super.testTryWithResources_userClass
	}

	@Test
	override void testTryWithResources_isClosed1() {
		super.testTryWithResources_isClosed1
	}

	@Test
	override void testTryWithResources_isClosed2() {
		super.testTryWithResources_isClosed2
	}

	@Test
	override void testTryWithResources_userClassExceptionOnConstructor() {
		super.testTryWithResources_userClassExceptionOnConstructor
	}

	@Test
	override void testTryWithResources_userClassExceptionOnClose() {
		super.testTryWithResources_userClassExceptionOnClose
	}
	
	@Test
	override void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose1() {
		super.testTryWithResources_userClassExceptionOnCloseStillCallEveryClose1
	}
	
	@Test
	override void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose2() {
		super.testTryWithResources_userClassExceptionOnCloseStillCallEveryClose2
	}
	
	@Test
	override void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose3() {
		super.testTryWithResources_userClassExceptionOnCloseStillCallEveryClose3
	}

	@Test
	override void testTryWithResources_finally() {
		super.testTryWithResources_finally
	}

	@Test
	override void testTryWithResources_catch() {
		super.testTryWithResources_catch
	}

	@Test
	override void testTryWithResources_catchFinally() {
		super.testTryWithResources_catchFinally
	}

	@Test
	override void testTryWithResources_ExceptionInBody() {
		super.testTryWithResources_ExceptionInBody
	}

	@Test
	override void testTryWithResources_2Resources_ExceptionInBody() {
		super.testTryWithResources_2Resources_ExceptionInBody
	}

	@Test
	override void testTryWithResources_2Resources_ExceptionOnClose() {
		super.testTryWithResources_2Resources_ExceptionOnClose
	}

	@Test
	override void testTryWithResources_2ResourcesCatch_01() {
		super.testTryWithResources_2ResourcesCatch_01
	}

	@Test
	override void testTryWithResources_2ResourcesCatch_02() {
		super.testTryWithResources_2ResourcesCatch_02
	}

	@Test
	override void testTernaryIf_1() {
		super.testTernaryIf_1
	}

	@Test
	override void testTernaryIf_2() {
		super.testTernaryIf_2
	}

	@Test
	override void testTernaryIf_3() {
		super.testTernaryIf_3
	}

	@Test
	override void testTernaryIf_4() {
		super.testTernaryIf_4
	}

	@Test
	override void testTernaryIf_5() {
		super.testTernaryIf_5
	}

	@Test
	override void testTernaryIf_6() {
		super.testTernaryIf_6
	}

	@Test
	override void testTernaryIf_7() {
		super.testTernaryIf_7
	}

	@Ignore
	@Test
	override void testClosure_31() throws Exception {
		super.testClosure_31();
	}

	@Ignore
	@Test
	override void testClosure_32() throws Exception {
		super.testClosure_32();
	}

	@Ignore
	@Test
	override void testArrays_01() throws Exception {
		super.testArrays_01();
	}

	@Ignore
	@Test
	override void testArrays_02() throws Exception {
		super.testArrays_02();
	}

	@Ignore
	@Test
	override void testArrays_04() throws Exception {
		super.testArrays_01();
	}
}
