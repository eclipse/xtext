/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.junit.evaluation.AbstractXbaseEvaluationTest;
import org.eclipse.xtext.xbase.lib.Functions;
import org.junit.Assert;

import com.google.common.base.Supplier;
import com.google.inject.Inject;
import com.google.inject.Provider;
import compound.IntCompoundExtensions;

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
	private JvmModelGenerator generator;

	@Inject
	private IGeneratorConfigProvider configprovider;

	@Inject
	private IXtendJvmAssociations associations;
	
	public void setUp() {
		javaCompiler.clearClassPath();
		javaCompiler.addClassPathOfClass(getClass());
		javaCompiler.addClassPathOfClass(IntCompoundExtensions.class);
		javaCompiler.addClassPathOfClass(AbstractXbaseEvaluationTest.class);
		javaCompiler.addClassPathOfClass(Functions.class);
		javaCompiler.addClassPathOfClass(StringConcatenation.class);
		javaCompiler.addClassPathOfClass(Property.class);
		javaCompiler.addClassPathOfClass(javax.inject.Provider.class);
		javaCompiler.addClassPathOfClass(Provider.class);
		javaCompiler.addClassPathOfClass(Supplier.class);
		javaCompiler.addClassPathOfClass(Notifier.class);
		javaCompiler.addClassPathOfClass(EcorePackage.class);
		javaCompiler.addClassPathOfClass(XbasePackage.class);
		javaCompiler.addClassPathOfClass(XtendPackage.class);
		javaCompiler.addClassPathOfClass(Check.class);
		javaCompiler.addClassPathOfClass(Assert.class);
	}
	
	public void assertEvaluatesTo(Object object, String string) {
		final String compileToJavaCode = compileToJavaCode(string);
		try {
			Object actual = apply(compile(string));
			Assert.assertEquals("String was:\n" + string + "\nJava code was " + compileToJavaCode, object, actual);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown " + e + ".Java code was " + compileToJavaCode);
		}
	}
	
	public void assertEvaluatesTo(Object object, String xtendCode, String javaCode) {
		try {
			Object actual = apply(compileToClass(javaCode));
			Assert.assertEquals("String was:\n" + xtendCode + "\nJava code was " + javaCode, object, actual);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception thrown " + e + ".Java code was " + javaCode);
		}
	}

	public void assertEvaluatesToArray(Object[] object, String string) {
		final String compileToJavaCode = compileToJavaCode(string);
		try {
			Object actual = apply(compile(string));
			Assert.assertTrue(actual.getClass().isArray());
			Assert.assertArrayEquals("String was:\n" + string + "\nJava code was " + compileToJavaCode, object, (Object[]) actual); 
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
			Object result = apply(compile);
			Assert.fail("expected exception " + class1.getCanonicalName() + " but was "+result+". Java code was " + compileToJavaCode(string));
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
		return compileToClass(javaCode);
	}

	protected Class<?> compileToClass(String javaCode) {
		try {
			Class<?> clazz = javaCompiler.compileToClass("foo.Test", javaCode);
			return clazz;
		} catch (Exception e) {
			throw new RuntimeException("Java compilation failed. Java code was : \n" + javaCode, e);
		}
	}

	protected String compileToJavaCode(String xtendCode) {
		final String text = "package foo class Test { def Object foo() throws Exception {" + xtendCode + "} }";
		return toJavaCode(text);
	}
	protected String toJavaCode(String xtendCode) {
		try {
			final XtendFile file = parseHelper.parse(xtendCode);
			validationHelper.assertNoErrors(file);
			JvmGenericType inferredType = associations.getInferredType((XtendClass) file.getXtendTypes().get(0));
			CharSequence javaCode = generator.generateType(inferredType, configprovider.get(inferredType));
			return javaCode.toString();
		} catch (Exception e) {
			throw new RuntimeException("Xtend compilation failed for: " + xtendCode, e);
		}
	}
}
