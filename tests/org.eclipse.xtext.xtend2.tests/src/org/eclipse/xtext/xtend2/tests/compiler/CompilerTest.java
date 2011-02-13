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

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.lib.Strings;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilerTest extends AbstractXtend2TestCase {
	
	
	public void testNoArgFunction() throws Exception {
		invokeAndExpect("foo", "'foo'");
	}
	public void testOneArgFunction() throws Exception {
		invokeAndExpect("foobar", "'foo'+p1","bar");
	}
	public void testTwoArgFunction() throws Exception {
		invokeAndExpect("foo", "if (p2) 'foo' else p1 ","bar",true);
	}

	public void testTwoArgFunction_01() throws Exception {
		invokeAndExpect("bar", "if (p2) 'foo' else p1 ","bar",false);
	}
	
	public void testCaseFunction_00() throws Exception {
		final String definition = "x(p1) case x(String s) 'string' case x(Object o) 'object'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("object", definition,42);
	}
	
	public void testCaseFunction_01() throws Exception {
		final String definition = "x(p1) " +
				" case x(Comparable<Boolean> s) 'comparable'" +
				" case x(String s) 'string'" +
				" case x(CharSequence o) 'charSeq'" +
				" case x(Integer o) 'integer'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("integer", definition,42);
		invokeAndExpect("charSeq", definition,new StringBuilder());
		invokeAndExpect("comparable", definition, true);
		try {
			invokeAndExpect(null, definition, new Object[]{null});
			fail();
		} catch (InvocationTargetException e) {
			assertTrue(e.getCause() instanceof IllegalArgumentException);
		}
	}
	
	public void testCaseFunction_02() throws Exception {
		final String definition = "x(p1)" +
				" case x(Void s) 'null'" +
				" case x(String s) 'string'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("null", definition,new Object[]{null});
		try {
			invokeAndExpect(null, definition, 42);
			fail();
		} catch (InvocationTargetException e) {
			assertTrue(e.getCause() instanceof IllegalArgumentException);
		}
	}
//TODO test fails, when run as plug-in test. The EMF jars cannot be resolved.
//
//	public void testCaseFunction_03() throws Exception {
//		final String definition = "doIt(p1) " +
//				"   case doIt(org.eclipse.emf.ecore.EStructuralFeature x) typeof(org.eclipse.emf.ecore.EStructuralFeature)\n" + 
//				"	case doIt(org.eclipse.emf.ecore.EReference x) typeof(org.eclipse.emf.ecore.EReference)\n" + 
//				"	case doIt(org.eclipse.emf.ecore.EAttribute x) typeof(org.eclipse.emf.ecore.EAttribute)\n" + 
//				"	case doIt(org.eclipse.emf.ecore.ETypedElement x) typeof(org.eclipse.emf.ecore.ETypedElement)";
//		invokeAndExpect(EReference.class, definition,Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF);
//		invokeAndExpect(EAttribute.class, definition,Xtend2Package.Literals.XTEND_FILE__PACKAGE);
//		invokeAndExpect(ETypedElement.class, definition,EcoreFactory.eINSTANCE.createEOperation());
//	}

	public void testFunctionCall_00() throws Exception {
		invokeAndExpect("foobar", "bar(p1) bar(String x) 'foo'+x","bar");
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
		javaCompiler.addClassPathOfClass(Notifier.class);
		javaCompiler.addClassPathOfClass(EcorePackage.class);
		javaCompiler.addClassPathOfClass(XbasePackage.class);
		javaCompiler.addClassPathOfClass(Xtend2Package.class);
	}
	
	
	protected void invokeAndExpect(Object expectation, String functionDef, Object...args) throws Exception {
		String fullClass = "package x class Y { Object testEntry(";
		for (int i = 0; i < args.length; i++) {
			Object object = args[i];
			if (object == null) {
				fullClass+= Void.class.getCanonicalName()+" p"+(i+1);
			} else {
				fullClass+= object.getClass().getCanonicalName()+" p"+(i+1);
			}
			if (i+1<args.length)
				fullClass+=",";
		}
		fullClass += ")"+functionDef+" }";
		Class<?> compiledClass = compileJavaCode("x.Y",fullClass);
		assertEquals(expectation, apply(compiledClass,"testEntry",args));
	}
	
	protected Object apply(Class<?> compile,String methodName,Object...args) throws Exception {
		Object instance = compile.newInstance();
		if (args==null) {
			return compile.getDeclaredMethod(methodName).invoke(instance);
		}
		Class<?>[] argTypes = new Class[args.length];
		for (int i = 0; i < argTypes.length; i++) {
			if (args[i] == null) {
				argTypes[i] = Void.class;
			} else {
				argTypes[i] = args[i].getClass();
			}
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
