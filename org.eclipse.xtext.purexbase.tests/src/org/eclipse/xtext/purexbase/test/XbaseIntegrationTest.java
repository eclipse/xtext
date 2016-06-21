/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.purexbase.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper.Result;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;


@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
public class XbaseIntegrationTest extends AbstractXbaseEvaluationTest {
	
	@Inject private CompilationTestHelper helper;

	protected Object invokeXbaseExpression(String expression) throws Exception {
		final Object[] result = new Object[1];
		final InvocationTargetException[] exception = new InvocationTargetException[1];
		helper.compile(expression, new IAcceptor<CompilationTestHelper.Result>() {
			public void accept(Result t) {
				try {
					final Class<?> compiledClass = t.getCompiledClass();
					Object instance = compiledClass.newInstance();
					final Method method = compiledClass.getDeclaredMethod("myMethod");
					result[0] = method.invoke(instance);
				} catch (InvocationTargetException e) {
					exception[0] = e;
				} catch (Exception e) {
					e.printStackTrace();
					fail(e.toString());
				}
			}
		});
		if (exception[0] != null)
			throw exception[0];
		return result[0];
	}
	
	@Override
	@Test
	@Ignore
	public void testImplicitOneArgClosure_01() throws Exception {
		super.testImplicitOneArgClosure_01();
	}
	
	@Override
	@Test 
	@Ignore("Wrong type")
	public void testReturnExpression_07() throws Exception {
		assertEvaluatesTo(null, "return if (true) while(false) ('foo'+'bar').length else null");
		assertEvaluatesTo(null, "return if (false) while(false) ('foo'+'bar').length else null");
	}
	
	@Override
	@Test 
	@Ignore("Wrong type")
	public void testReturnExpression_08() throws Exception {
		assertEvaluatesTo(null, "return if (true) while(false) ('foo'+'bar').length else 'zonk'");
		assertEvaluatesTo("zonk", "return if (false) while(false) ('foo'+'bar').length else 'zonk'");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testIfExpression_06() throws Exception {
		assertEvaluatesTo(0, 
				"if (Boolean.FALSE) return 1");
	}
	
	/**
	 * @since 2.5
	 */
	@Test public void testIfExpression_07() throws Exception {
		assertEvaluatesTo(0l, 
				"if (Boolean.FALSE) return 1L");
	}
}
