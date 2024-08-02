/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.testing.evaluation.AbstractXbaseEvaluationTestEx;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import testdata.TryBodyException;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
public class XbaseIntegrationTest extends AbstractXbaseEvaluationTestEx {

	@Inject
	private CompilerTestHelper testHelper;
	
	@Before
	public void setUp() throws Exception {
		testHelper.setUp();
	}
	
	@Override
	protected void assertEvaluatesTo(Object object, String string) {
		testHelper.assertEvaluatesTo(object, string);
	}
	
	@Override
	protected void assertEvaluatesToArray(Object[] object, String string) {
		testHelper.assertEvaluatesToArray(object, string);
	}
	
	@Override
	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) {
		testHelper.assertEvaluatesWithException(class1, string);
	}
	
	@Override
	protected void assertIntegerAssignOperations(Integer expectedResult, String xbaseCode) throws Exception {
		// without explicit compound assignments
		testHelper.assertEvaluatesTo(expectedResult, xbaseCode);
		
		// with explicit compound assignments
		String xtendCode =  "package foo\n" +
				"import compound.IntCompoundExtensions\n" +
				"class Test { def Object foo() throws Exception {" + xbaseCode + "} }";
		String javaCode = testHelper.toJavaCode(xtendCode);
		testHelper.assertEvaluatesTo(expectedResult, xtendCode, javaCode);
	}
	
	@Test public void testAnonymousConstructorVarArgs_01() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "(new testdata.ClassWithVarArgs() {}).defaultConstructor");
	}
	
	@Test public void testAnonymousConstructorVarArgs_02() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "(new testdata.ClassWithVarArgs(1) {}).varArgConstructor");
	}
	
	@Test public void testAnonymousConstructorVarArgs_03() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "(new testdata.ClassWithVarArgs(1, '') {}).varArgConstructor");
	}
	
	@Test public void testAnonymousConstructorVarArgs_04() throws Exception {
		assertEvaluatesTo(Boolean.FALSE, "(new testdata.ClassWithVarArgs(1, '', '') {}).varArgConstructor");
	}
	
	@Test public void testAnonymousConstructorVarArgs_05() throws Exception {
		assertEvaluatesTo(Boolean.TRUE, "(new testdata.ClassWithVarArgs(1, '', '', '') {}).varArgConstructor");
	}

	@Test @Override
	public void testTryWithResources_ExceptionInBody() throws Exception {
		assertEvaluatesWithException(TryBodyException.class,
				"try (var a = new testdata.ClosableWithListExceptionOnAdd()) {\n" + 
				"	a.add(\"body\")\n" + 
				"	a.addExc\n" + 
				"}\n" +
				"null");
	}
	
	@Test @Override
	public void testTryWithResources_2ResourcesCatch_02() throws Exception {
		assertEvaluatesWithException(InstantiationException.class, //b.add would invoke NullPointerExcpt, but InstExc came first and is caught
				"var java.util.List<String> result\n" + 
				"try (var a = new testdata.ClosableWithList;\n" + 
				"		var b = new testdata.ClosableWithListExceptionOnConstr) {\n" + 
				"	a.add(\"body\")\n" + 
				"	b.add(\"body\")\n" + 
				"}\n" +
				"null");
	}
}
