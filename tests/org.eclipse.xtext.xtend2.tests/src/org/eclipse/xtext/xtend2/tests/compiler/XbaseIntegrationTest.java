/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.compiler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.parser.ParseHelper;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase.TestSetup;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseIntegrationTest extends AbstractXbaseEvaluationTest {

	//TODO reactivate temporarily disabled tests
	@Override
	public void testThrowExpression_01() {
	}

	@Override
	public void testSpreadOperator_01() {
	}

	@Override
	public void testSpreadOperator_02() {
	}

	@Override
	public void testSwitchExpression_01() {
	}

	@Override
	public void testSwitchExpression_02() {
	}

	@Override
	public void testSwitchExpression_03() {
	}

	@Override
	public void testSwitchExpression_04() {
	}

	@Override
	public void testSwitchExpression_05() {
	}

	@Override
	public void testSwitchExpression_06() {
	}

	@Override
	public void testSwitchExpression_07() {
	}

	@Override
	public void testSwitchExpression_08() {
	}

	@Override
	public void testSwitchExpression_09() {
	}

	@Override
	public void testSwitchExpression_10() {
	}

	static Injector injector = new TestSetup().createInjectorAndDoEMFRegistration();
	
	@Inject
	private EclipseRuntimeDependentJavaCompiler javaCompiler;

	@Inject
	private ParseHelper<XtendFile> parseHelper;

	@Inject
	private ValidationTestHelper validationHelper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		injector.injectMembers(this);
		javaCompiler.addClassPathOfClass(getClass());
		javaCompiler.addClassPathOfClass(AbstractXbaseEvaluationTest.class);
		javaCompiler.addClassPathOfClass(Functions.class);
	}

	@Override
	protected void assertEvaluatesTo(Object object, String string) {
		final String compileToJavaCode = compileToJavaCode(string);
		try {
			assertEquals("Java code was " + compileToJavaCode, object, apply(compile(string)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown " + e + ".Java code was " + compileToJavaCode);
		}
	}

	@Override
	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) {
		try {
			Class<?> compile = null;
			try {
				compile = compile(string);
			} catch (Exception e) {
				throw new WrappedException(e);
			}
			apply(compile);
			fail("expected exception " + class1.getCanonicalName() + ". Java code was " + compileToJavaCode(string));
		} catch (InvocationTargetException e) {
			final boolean isExpected = class1.isInstance(e.getTargetException());
			if (!isExpected)
				e.printStackTrace();
			assertTrue("expected " + class1.getCanonicalName() + " but was " + e, isExpected);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Object apply(Class<?> compile) throws Exception {
		Object instance = compile.newInstance();
		Method method = compile.getDeclaredMethod("foo");
		return method.invoke(instance);
	}

	protected Class<?> compile(String code) {
		String javaCode = compileToJavaCode(code);
		try {
			Class<?> clazz = javaCompiler.compileToClass("foo.Test", javaCode);
			return clazz;
		} catch (Exception e) {
			throw new RuntimeException("Java compilation failed. Java code was : \n" + javaCode, e);
		}
	}

	protected String compileToJavaCode(String xtendCode) {
		IAppendable appandable = new IAppendable.StringBuilderBasedAppendable();
		try {
			final XtendFile file = parseHelper.parse("package foo class Test { Object foo() " + xtendCode + " }");
			validationHelper.assertNoErrors(file);
			Xtend2Compiler compiler = injector.getInstance(Xtend2Compiler.class);
			compiler.compile(file, appandable);
		} catch (Exception e) {
			throw new RuntimeException("Xtend compilation failed", e);
		}
		return appandable.toString();
	}

}
