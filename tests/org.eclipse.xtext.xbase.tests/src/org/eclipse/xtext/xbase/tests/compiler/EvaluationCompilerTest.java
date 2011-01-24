/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.parser.ParseHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EvaluationCompilerTest extends AbstractXbaseEvaluationTest {

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
	private EclipseRuntimeDependentJavaCompiler javaCompiler;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		injector.injectMembers(this);
		javaCompiler.clearClassPath();
		javaCompiler.addClassPathOfClass(getClass());
		javaCompiler.addClassPathOfClass(AbstractXbaseEvaluationTest.class);
		javaCompiler.addClassPathOfClass(Functions.class);
	}

	//TODO the on-the-fly compiler cannot declare checked exceptions.
	@Override
	public void testThrowExpression_01() {
	}

	//TODO implement spread operator (needs scoping)
	@Override
	public void testSpreadOperator_01() {
	}

	@Override
	public void testSpreadOperator_02() {
	}

	//TODO implement switch expression
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

	@Override
	protected void assertEvaluatesTo(Object object, String string) {
		final String compileToJavaCode = compileToJavaCode(string);
		try {
			assertEquals("Java code was " + compileToJavaCode, object, compile(string).apply());
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown " + e + ".Java code was " + compileToJavaCode);
		}
	}

	@Override
	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) {
		try {
			Function0<Object> compile = null;
			try {
				compile = compile(string);
			} catch (Exception e) {
				throw new WrappedException(e);
			}
			compile.apply();
			fail("expected exception " + class1.getCanonicalName() + ". Java code was " + compileToJavaCode(string));
		} catch (Throwable e) {
			if (!class1.isInstance(e))
				e.printStackTrace();
			assertTrue("expected " + class1.getCanonicalName() + " but was " + e, class1.isInstance(e));
		}
	}

	protected Functions.Function0<Object> compile(String code) {
		String javaCode = compileToJavaCode(code);
		try {
			Function0<Object> function = javaCompiler.createFunction(javaCode, Object.class);
			return function;
		} catch (Exception e) {
			throw new RuntimeException("Java compilation failed. Java code was : \n" + javaCode, e);
		}
	}

	protected String compileToJavaCode(String xtendCode) {
		XExpression model;
		IAppendable appandable = new IAppendable.StringBuilderBasedAppendable();
		try {
			model = expression(xtendCode, true);
			XbaseCompiler compiler = injector.getInstance(XbaseCompiler.class);
			compiler.compile(model, appandable);
		} catch (Exception e) {
			throw new RuntimeException("Xtend compilation failed", e);
		}
		return appandable.toString();
	}

	protected XExpression expression(String string, boolean resolve) throws Exception {
		XExpression result = parseHelper.parse(string);
		if (resolve) {
			validationHelper.assertNoErrors(result);
		}
		return result;
	}

}
