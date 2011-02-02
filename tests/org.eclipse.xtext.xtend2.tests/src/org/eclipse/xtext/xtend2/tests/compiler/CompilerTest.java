/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.compiler;

import java.lang.reflect.Method;

import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.lib.Strings;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilerTest extends AbstractXtend2TestCase {
	
	
	public void testNoArgFunction() throws Exception {
		invokeAndExpect("foo", "() 'foo'");
	}
	public void testOneArgFunction() throws Exception {
		invokeAndExpect("foobar", "(String x) 'foo'+x","bar");
	}
	public void testTwoArgFunction() throws Exception {
		invokeAndExpect("foo", "(String x,Boolean foo) if (foo) 'foo' else x ","bar",true);
	}

	public void testTwoArgFunction_01() throws Exception {
		invokeAndExpect("bar", "(String x,Boolean foo) if (foo) 'foo' else x ","bar",false);
	}
	
	public void testFunctionCall_00() throws Exception {
		invokeAndExpect("foobar", "(String x) bar(x) bar(String x) 'foo'+x","bar");
	}
	
	@Inject
	private EclipseRuntimeDependentJavaCompiler javaCompiler;

	@Inject
	private ParseHelper<XtendFile> parseHelper;

	@Inject
	private ValidationTestHelper validationHelper;
	
	@Inject
	private Xtend2Compiler compiler;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		javaCompiler.addClassPathOfClass(getClass());
		javaCompiler.addClassPathOfClass(Strings.class);
	}
	
	
	protected void invokeAndExpect(Object expectation, String functionDef, Object...args) throws Exception {
		if (!functionDef.trim().startsWith("(")) {
			throw new IllegalArgumentException("the functiondef should start with parameter delcarations");
		}
		String fullClass = "package x class Y { Object foo"+functionDef+" }";
		Class<?> compiledClass = compileJavaCode("x.Y",fullClass);
		assertEquals(expectation, apply(compiledClass,"foo",args));
	}
	
	protected Object apply(Class<?> compile,String methodName,Object...args) throws Exception {
		Object instance = compile.newInstance();
		if (args==null) {
			return compile.getDeclaredMethod(methodName).invoke(instance);
		}
		Class<?>[] argTypes = new Class[args.length];
		for (int i = 0; i < argTypes.length; i++) {
			argTypes[i] = args[i].getClass();
		}
		Method method = compile.getDeclaredMethod(methodName, argTypes);
		return method.invoke(instance,args);
	}

	protected Class<?> compileJavaCode(String clazzName, String code) {
		String javaCode = compileToJavaCode(code);
		try {
			Class<?> clazz = javaCompiler.compileToClass(clazzName, javaCode);
			return clazz;
		} catch (Exception e) {
			throw new RuntimeException("Java compilation failed. Java code was : \n" + javaCode, e);
		}
	}

	protected String compileToJavaCode(String xtendCode) {
		IAppendable appandable = new IAppendable.StringBuilderBasedAppendable();
		try {
			final XtendFile file = parseHelper.parse(xtendCode);
			assertNotNull(file);
			validationHelper.assertNoErrors(file);
			compiler.compile(file, appandable);
		} catch (Exception e) {
			throw new RuntimeException("Xtend compilation failed", e);
		}
		return appandable.toString();
	}

}
