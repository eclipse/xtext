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
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class Xtend2EvaluationTest extends AbstractXtend2TestCase {
	
	private EclipseRuntimeDependentJavaCompiler javaCompiler;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		javaCompiler = get(OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler.class);
		javaCompiler.addClassPathOfClass(getClass());
		javaCompiler.addClassPathOfClass(Functions.class);
	}
	
	protected void assertEvaluatesTo(Object object, String string) {
		final String compileToJavaCode = compileToJavaCode(string);
		try {
			assertEquals("Java code was "+compileToJavaCode, object, apply(compile(string)));
		} catch (Exception e) {
			e.printStackTrace();
			fail("Exception thrown "+e+".Java code was "+compileToJavaCode);
		}
	}

	protected void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) {
		try {
			Class<?> compile = null;
			try {
				compile = compile(string);
			} catch (Exception e) {
				throw new WrappedException(e);
			}
			apply(compile);
			fail("expected exception " + class1.getCanonicalName()+". Java code was "+compileToJavaCode(string));
		} catch (InvocationTargetException e) {
			if (!class1.isInstance(e.getTargetException()))
				e.printStackTrace();
			assertTrue("expected "+class1.getCanonicalName()+" but was "+e,class1.isInstance(e));
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
			Class<?> clazz = javaCompiler.compileToClass("foo.Test",javaCode);
			return clazz;
		} catch (Exception e) {
			throw new RuntimeException("Java compilation failed. Java code was : \n" + javaCode, e);
		}
	}

	protected String compileToJavaCode(String xtendCode) {
		XtendFile file;
		IAppendable appandable = new IAppendable.StringBuilderBasedAppendable();
		try {
			file = file("package foo class Test { Object foo() "+xtendCode+" }", true);
			Xtend2Compiler compiler = get(Xtend2Compiler.class);
			compiler.compile(file, appandable);
		} catch (Exception e) {
			throw new RuntimeException("Xtend compilation failed", e);
		}
		return appandable.toString();
	}
}
