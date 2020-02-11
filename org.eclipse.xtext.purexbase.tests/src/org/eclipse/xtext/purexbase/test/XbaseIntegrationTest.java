/*******************************************************************************
 * Copyright (c) 2012, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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

	@Override
	protected Object invokeXbaseExpression(String expression) throws Exception {
		final Object[] result = new Object[1];
		final InvocationTargetException[] exception = new InvocationTargetException[1];
		helper.compile(expression, new IAcceptor<CompilationTestHelper.Result>() {
			@Override
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

	@Test
	@Override
	public void testTryWithoutResources() throws Exception {
		super.testTryWithoutResources();
	}

	@Test
	@Override
	public void testTryWithResources_easy() throws Exception {
		super.testTryWithResources_easy();
	}

	@Test
	@Override
	public void testTryWithResources_lambda() throws Exception {
		super.testTryWithResources_lambda();
	}

	@Test
	@Override
	public void testTryWithResources_2Resources() throws Exception {
		super.testTryWithResources_2Resources();
	}

	@Test
	@Override
	public void testTryWithResources_2NestedResources() throws Exception {
		super.testTryWithResources_2NestedResources();
	}

	@Test
	@Override
	public void testTryWithResources_2DiffResources() throws Exception {
		super.testTryWithResources_2DiffResources();
	}

	@Test
	@Override
	public void testTryWithResources_if1() throws Exception {
		super.testTryWithResources_if1();
	}

	@Test
	@Override
	public void testTryWithResources_if2() throws Exception {
		super.testTryWithResources_if2();
	}

	@Test
	@Override
	public void testTryWithResources_userClass() throws Exception {
		super.testTryWithResources_userClass();
	}

	@Test
	@Override
	public void testTryWithResources_isClosed1() throws Exception {
		super.testTryWithResources_isClosed1();
	}

	@Test
	@Override
	public void testTryWithResources_isClosed2() throws Exception {
		super.testTryWithResources_isClosed2();
	}

	@Test
	@Override
	public void testTryWithResources_userClassExceptionOnConstructor() throws Exception {
		super.testTryWithResources_userClassExceptionOnConstructor();
	}

	@Test
	@Override
	public void testTryWithResources_userClassExceptionOnClose() throws Exception {
		super.testTryWithResources_userClassExceptionOnClose();
	}
	
	@Test
	@Override
	public void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose1() throws Exception {
		super.testTryWithResources_userClassExceptionOnCloseStillCallEveryClose1();	
	}
	
	@Test
	@Override
	public void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose2() throws Exception {
		super.testTryWithResources_userClassExceptionOnCloseStillCallEveryClose2();	
	}
	
	@Test
	@Override
	public void testTryWithResources_userClassExceptionOnCloseStillCallEveryClose3() throws Exception {
		super.testTryWithResources_userClassExceptionOnCloseStillCallEveryClose3();
	}

	@Test
	@Override
	public void testTryWithResources_finally() throws Exception {
		super.testTryWithResources_finally();
	}

	@Test
	@Override
	public void testTryWithResources_catch() throws Exception {
		super.testTryWithResources_catch();
	}

	@Test
	@Override
	public void testTryWithResources_catchFinally() throws Exception {
		super.testTryWithResources_catchFinally();
	}

	@Test
	@Override
	public void testTryWithResources_ExceptionInBody() throws Exception {
		super.testTryWithResources_ExceptionInBody();
	}

	@Test
	@Override
	public void testTryWithResources_2Resources_ExceptionInBody() throws Exception {
		super.testTryWithResources_2Resources_ExceptionInBody();
	}

	@Test
	@Override
	public void testTryWithResources_2Resources_ExceptionOnClose() throws Exception {
		super.testTryWithResources_2Resources_ExceptionOnClose();
	}

	@Test
	@Override
	public void testTryWithResources_2ResourcesCatch_01() throws Exception {
		super.testTryWithResources_2ResourcesCatch_01();
	}

	@Test
	@Override
	public void testTryWithResources_2ResourcesCatch_02() throws Exception {
		super.testTryWithResources_2ResourcesCatch_02();
	}
}
