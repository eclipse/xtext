/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.interpreter;

import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.interpreter.IEvaluationResult;
import org.eclipse.xtext.xbase.interpreter.IExpressionInterpreter;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XbaseInterpreterTest extends AbstractXbaseEvaluationTest {

	static Injector injector = new XbaseStandaloneSetup() {
		@Override
		public Injector createInjector() {
			return Guice.createInjector(new org.eclipse.xtext.xbase.XbaseRuntimeModule() {
				@Override
				public ClassLoader bindClassLoaderToInstance() {
					return AbstractXbaseTestCase.class.getClassLoader();
				}
			});
		}
	}.createInjectorAndDoEMFRegistration();

	@Inject
	private ParseHelper<XExpression> parseHelper;
	@Inject
	private ValidationTestHelper validationHelper;
	@Inject
	private IExpressionInterpreter interpreter;
	@Inject
	private IResourceScopeCache cache;

	@Before
	public void setUp() throws Exception {
		injector.injectMembers(this);
	}

	@After
	public void tearDown() throws Exception {
		interpreter = null;
		parseHelper = null;
	}

	@Override
	public void assertEvaluatesTo(Object expectation, String model) {
		XExpression expression = null;
		try {
			expression = expression(model, true);
			IEvaluationResult result = interpreter.evaluate(expression);
			assertNull("Expected no exception. Model was: " + model + ", Exception was: " + result.getException(),
					result.getException());
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
	
}
