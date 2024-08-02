/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper.Result;
import org.eclipse.xtext.xbase.testing.evaluation.AbstractXbaseEvaluationTestEx;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;


@RunWith(XtextRunner.class)
@InjectWith(PureXbaseInjectorProvider.class)
public class XbaseIntegrationTest extends AbstractXbaseEvaluationTestEx {
	
	@Inject private CompilationTestHelper helper;

	@Override
	protected Object invokeXbaseExpression(String expression) throws Exception {
		final Object[] result = new Object[1];
		final InvocationTargetException[] exception = new InvocationTargetException[1];
		helper.compile(expression, new IAcceptor<CompilationTestHelper.Result>() {
			@Override
			public void accept(Result t) {
				try {
					final Class<?> compiledClass = t.getCompiledClass();
					Object instance = compiledClass.getDeclaredConstructor().newInstance();
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
	
	/**
	 * @since 2.5
	 */
	@Override
	@Test public void testIfExpression_06() throws Exception {
		assertEvaluatesTo(0, 
				"if (Boolean.FALSE) return 1");
	}
	
	/**
	 * @since 2.5
	 */
	@Override
	@Test public void testIfExpression_07() throws Exception {
		assertEvaluatesTo(0l, 
				"if (Boolean.FALSE) return 1L");
	}

}
