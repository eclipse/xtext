/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.compiler;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import junit.framework.Assert;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.common.base.Supplier;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CompilerTestHelper {

	@Inject
	private EclipseRuntimeDependentJavaCompiler javaCompiler;

	@Inject
	private ParseHelper<XtendFile> parseHelper;

	@Inject
	private ValidationTestHelper validationHelper;
	
	@Inject
	private Xtend2Compiler xtend2Compiler;
	
	public void setUp() {
		javaCompiler.addClassPathOfClass(getClass());
		javaCompiler.addClassPathOfClass(AbstractXbaseEvaluationTest.class);
		javaCompiler.addClassPathOfClass(Functions.class);
		javaCompiler.addClassPathOfClass(StringConcatenation.class);
		javaCompiler.addClassPathOfClass(Provider.class);
		javaCompiler.addClassPathOfClass(Supplier.class);
		javaCompiler.addClassPathOfClass(Notifier.class);
		javaCompiler.addClassPathOfClass(EcorePackage.class);
		javaCompiler.addClassPathOfClass(XbasePackage.class);
		javaCompiler.addClassPathOfClass(Xtend2Package.class);
		javaCompiler.addClassPathOfClass(Check.class);
	}
	
	public void assertEvaluatesTo(Object object, String string) {
		final String compileToJavaCode = compileToJavaCode(string);
		try {
			Object actual = apply(compile(string));
			if (object instanceof String && actual instanceof String) {
				Assert.assertEquals("String was:\n" + string + "\nJava code was " + compileToJavaCode, (String)object, (String)actual);	
			} else {
				Assert.assertEquals("String was:\n" + string + "\nJava code was " + compileToJavaCode, object, actual);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown " + e + ".Java code was " + compileToJavaCode);
		}
	}

	public void assertEvaluatesWithException(Class<? extends Throwable> class1, String string) {
		try {
			Class<?> compile = null;
			try {
				compile = compile(string);
			} catch (Exception e) {
				throw new WrappedException(e);
			}
			apply(compile);
			Assert.fail("expected exception " + class1.getCanonicalName() + ". Java code was " + compileToJavaCode(string));
		} catch (InvocationTargetException e) {
			final boolean isExpected = class1.isInstance(e.getTargetException());
			if (!isExpected)
				e.printStackTrace();
			Assert.assertTrue("expected " + class1.getCanonicalName() + " but was " + e, isExpected);
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
		StringWriter appandable = new StringWriter();
		try {
			final String text = "package foo class Test { def Object foo() {" + xtendCode + "} }";
			final XtendFile file = parseHelper.parse(text);
			validationHelper.assertNoErrors(file);
			xtend2Compiler.compile(file, appandable);
		} catch (Exception e) {
			throw new RuntimeException("Xtend compilation failed for: " + xtendCode, e);
		}
		return appandable.toString();
	}
}
