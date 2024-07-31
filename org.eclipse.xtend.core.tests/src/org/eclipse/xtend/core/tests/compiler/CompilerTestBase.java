/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import java.lang.reflect.Method;

import org.eclipse.xtend.core.compiler.XtendCompiler;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.testing.InMemoryJavaCompiler;
import org.eclipse.xtext.xbase.testing.JavaSource;
import org.eclipse.xtext.xbase.testing.InMemoryJavaCompiler.Result;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public abstract class CompilerTestBase extends AbstractXtendTestCase {
	protected InMemoryJavaCompiler javaCompiler;

	@Inject
	protected ParseHelper<XtendFile> parseHelper;

	@Inject
	protected ValidationTestHelper validationHelper;
	
	@Inject
	protected XtendCompiler compiler;

	@Inject
	protected JvmModelGenerator generator;
	
	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	protected IGeneratorConfigProvider generatorConfigProvider;
	
	@Inject
	protected void createInMemoryJavaCompiler(ClassLoader classLoader) {
		javaCompiler = new InMemoryJavaCompiler(classLoader, generatorConfigProvider.get(null).getJavaSourceVersion());
	}
	
	protected void invokeAndExpect2(Object expectation, String xtendclassBody, String methodToInvoke, Object... args)
			throws Exception {
		Class<?> class1 = compileJavaCode("x.Y", "package x class Y {" + xtendclassBody + "}");
		assertEquals(expectation, apply(class1, methodToInvoke, args));
	}
	
	protected void invokeAndExpectStatic(Object expectation, String xtendclassBody, String methodToInvoke, Object... args) throws Exception {
		Class<?> class1 = compileJavaCode("x.Y", "package x class Y {" + xtendclassBody + "}");
		assertEquals(expectation, applyStatic(class1, methodToInvoke, argTypes(args), args));
	}

	protected void invokeAndExpect3(Object expectation, String xtendclassBody, String methodToInvoke,
			Class<?>[] parameterTypes, Object... args) throws Exception {
		Class<?> class1 = compileJavaCode("x.Y", "package x class Y {" + xtendclassBody + "}");
		assertEquals(expectation, applyImpl(class1, methodToInvoke, parameterTypes, args));
	}
	protected void invokeAndExpect(Object expectation, String functionDef, Object...args) throws Exception {
		String fullClass = "package x class Y { def Object testEntry(";
		for (int i = 0; i < args.length; i++) {
			Object object = args[i];
			if (object == null) {
				fullClass+= Object.class.getCanonicalName()+" p"+(i+1);
			} else {
				fullClass+= object.getClass().getCanonicalName()+" p"+(i+1);
			}
			if (i+1<args.length)
				fullClass+=",";
		}
		fullClass += ") {"+functionDef+"} }";
		Class<?> compiledClass = compileJavaCode("x.Y",fullClass);
		assertEquals(expectation, apply(compiledClass,"testEntry",args));
	}
	
	protected Object apply(Class<?> type, String methodName, Object... args) throws Exception {
		return applyImpl(type, methodName, argTypes(args), args);
	}
	
	protected Class<?>[] argTypes(Object...args) throws Exception {
		Class<?>[] argTypes = new Class[args.length];
		for (int i = 0; i < argTypes.length; i++) {
			if (args[i] == null) {
				argTypes[i] = Object.class;
			} else {
				argTypes[i] = args[i].getClass();
			}
		}
		return argTypes; 
	}
	
	protected Object applyImpl(Class<?> type,String methodName,Class<?>[] parameterTypes,Object...args) throws Exception {
		final Injector inj = Guice.createInjector();
		Object instance = inj.getInstance(type);
		if (args==null) {
			return type.getDeclaredMethod(methodName).invoke(instance);
		}
		Method method = type.getDeclaredMethod(methodName, parameterTypes);
		return method.invoke(instance,args);
	}
	
	protected Object applyStatic(Class<?> type,String methodName,Class<?>[] parameterTypes,Object...args) throws Exception {
		if (args==null) {
			return type.getDeclaredMethod(methodName).invoke(null);
		}
		Method method = type.getDeclaredMethod(methodName, parameterTypes);
		return method.invoke(null, args);
	}

	protected Class<?> compileJavaCode(String clazzName, String code) {
		String javaCode = compileToJavaCode(code);
		try {
			Class<?> clazz = compileToClass(clazzName, javaCode);
			return clazz;
		} catch (Exception e) {
			System.err.println(javaCode);
			throw new RuntimeException("Java compilation failed. Java code was : \n" + javaCode, e);
		}
	}
	
	Class<?> compileToClass(String className, String javaCode) {
		Result result = javaCompiler.compile(new JavaSource(className.replace(".", "/")+".java", javaCode));
		try {
			return result.getClassLoader().loadClass(className);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	protected String compileToJavaCode(String xtendCode) {
		try {
			XtendFile file = parseHelper.parse(xtendCode);
			validationHelper.assertNoErrors(file);
			JvmGenericType inferredType = associations.getInferredType((XtendClass) file.getXtendTypes().get(0));
			CharSequence javaCode = generator.generateType(inferredType, generatorConfigProvider.get(inferredType));
			return javaCode.toString();
		} catch (Exception exc) {
			throw new RuntimeException("Xtend compilation failed:\n" + xtendCode, exc);
		}
	}
}
