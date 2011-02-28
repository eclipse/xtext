/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.compiler;

import static java.util.Collections.*;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.junit.util.ParseHelper;
import org.eclipse.xtext.junit.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import test.ExtensionMethods;
import testdata.Properties1;

import com.google.common.base.Function;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilerTest extends AbstractXtend2TestCase {
	
	public void testStaticExtensionMethod_01() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y","package x import static extension java.util.Collections.* class Y { foo() {'foo'.singleton()}}");
		assertEquals(singleton("foo"),apply(class1,"foo"));
	}
	
//	TODO Fix me
//	public void testStaticExtensionMethod_02() throws Exception {
//		Class<?> class1 = compileJavaCode("x.Y","package x import static extension java.util.Collections.* class Y { foo() {'foo'.singleton}}");
//		assertEquals(singleton("foo"),apply(class1,"foo"));
//	}
	
//	public void testInjectedExtensionMethod_01() throws Exception {
//		Class<?> class1 = compileJavaCode("x.Y",
//				"package x " +
//				"class Y { " +
//				"  @Inject extension java.util.HashMap<String,String> as map " +
//				"  " +
//				"  foo(String arg) { " +
//				"    arg.put('bar') " +
//				"    map" +
//				"  }" +
//				"}");
//		assertEquals(singleton(singletonMap("foo", "bar")),apply(class1,"foo"));
//	}
	public void testInjectedExtensionMethod_02() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @Inject extension test.ExtensionMethods " +
				"  " +
				"  foo(String arg) { " +
				"    (arg as CharSequence).generic()" +
				"  }" +
		"}");
		assertEquals(ExtensionMethods.GENERIC_T,apply(class1,"foo","x"));
	}
	
	public void testInjectedExtensionMethod_03() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @Inject extension test.ExtensionMethods " +
				"  " +
				"  foo(String arg) { " +
				"    arg.generic()" +
				"  }" +
		"}");
		assertEquals(ExtensionMethods.GENERIC_STRING,apply(class1,"foo","x"));
	}
	
//	TODO Fix me (operator overloading in extensions) 
//	public void testInjectedExtensionMethod_02() throws Exception {
//		Class<?> class1 = compileJavaCode("x.Y","package x class Y { @Inject extension test.ExtensionMethods foo(String arg) { return arg - 'bar' } }");
//		assertEquals("foo",apply(class1,"foobar"));
//	}
	
	public void testInjectedExtensionMethod_05() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y","package x class Y { @Inject extension test.ExtensionMethods foo(String arg) { return arg.operator_minus('bar') } }");
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_STRING,apply(class1,"foo", "foobar"));
	}
	
	public void testInjectedExtensionMethod_06() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @Inject extension test.ExtensionMethods " +
				"  a(String arg) { " +
				"    return arg.operator_minus('bar') " +
				"  } " +
				"  b(String arg) { " +
				"    return (arg as Object).operator_minus('bar') " +
				"  } " +
				"  c(String arg) { " +
				"    return arg.operator_minus('bar' as Object) " +
				"  } " +
				"  d(String arg) { " +
				"    return arg.operator_minus('bar' as CharSequence) " +
				"  } " +
				"}");
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_STRING,apply(class1,"a", "foo"));
		assertEquals(ExtensionMethods.OPERATOR_MINUS_OBJECT_STRING,apply(class1,"b", "foo"));
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_OBJECT,apply(class1,"c", "foo"));
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_CHARSEQUENCE,apply(class1,"d", "foo"));
	}
	
	public void testExtensionMethodForLocalFunctions_00() throws Exception {
		invokeAndExpect2("foobar", " with(String x, String y) { x+y} main(String x) { x.with('bar')}", "main", "foo"); 
	}
	
	public void testClosureReturnsVoid() throws Exception {
		invokeAndExpect2(null, 
				"foo() { " +
				"  [|{}].apply" +
				"}", "foo"); 
	}
	
	public void testDependencyDeclaration() throws Exception {
		invokeAndExpect2(Boolean.TRUE, "check() {obj!=null} @Inject test.ExtensionMethods as obj", "check");
	}
	
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
	
	public void testDispatchFunction_00() throws Exception {
		final String definition = "x(p1)} dispatch x(String s) {'string'} dispatch x(Object o) {'object'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("object", definition,42);
	}
	
	public void testDispatchFunction_01() throws Exception {
		final String definition = "x(p1)} " +
				" dispatch x(Comparable<Boolean> s) {'comparable'}" +
				" dispatch x(String s) {'string'}" +
				" dispatch x(CharSequence o) {'charSeq'}" +
				" dispatch x(Integer o) {'integer'";
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
	
	public void testDispatchFunction_02() throws Exception {
		final String definition = "x(p1 as String)}" +
				" dispatch x(Void s) {'null'}" +
				" dispatch x(String s) {'string'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("null", definition,new Object[]{null});
	}
	
	public void testImportsAndExtensions_01() throws Exception {
		final String definition = "x(p1 as String)}" +
				" dispatch x(Void s) {'null'}" +
				" dispatch x(String s) {'string'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("null", definition,new Object[]{null});
	}
	
	
//TODO test fails, when run as plug-in test. The EMF jars cannot be resolved.
//
//	public void testDispatchFunction_03() throws Exception {
//		final String definition = "doIt(p1) " +
//				"   case doIt(org.eclipse.emf.ecore.EStructuralFeature x) typeof(org.eclipse.emf.ecore.EStructuralFeature)\n" + 
//				"	case doIt(org.eclipse.emf.ecore.EReference x) typeof(org.eclipse.emf.ecore.EReference)\n" + 
//				"	case doIt(org.eclipse.emf.ecore.EAttribute x) typeof(org.eclipse.emf.ecore.EAttribute)\n" + 
//				"	case doIt(org.eclipse.emf.ecore.ETypedElement x) typeof(org.eclipse.emf.ecore.ETypedElement)";
//		invokeAndExpect(EReference.class, definition,Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF);
//		invokeAndExpect(EAttribute.class, definition,Xtend2Package.Literals.XTEND_FILE__PACKAGE);
//		invokeAndExpect(ETypedElement.class, definition,EcoreFactory.eINSTANCE.createEOperation());
//	}
	
	public void testDispatchFunction_04() throws Exception {
		final String definition = "x(p1)}" +
		" dispatch x(int s) {'int'}" +
		" dispatch x(boolean s) {'boolean'}" +
		" dispatch x(double s) {'double'";
		invokeAndExpect("int", definition,42);
		invokeAndExpect("double", definition,42d);
		invokeAndExpect("boolean", definition,true);
		invokeAndExpect("boolean", definition,Boolean.TRUE);
		try {
			invokeAndExpect(null, definition, "String");
			fail();
		} catch (InvocationTargetException e) {
			assertTrue(e.getCause() instanceof IllegalArgumentException);
		}
	}
	
	public void testDispatchFunction_05() throws Exception {
		final String definition = 
			"dispatch void a(String x) {}" +
			"dispatch a(Object x) {return null}";
		invokeAndExpect2(null, definition, "a", new Object());
	}
	
	public void testGenericFunction_01() throws Exception {
		final String definition = 
			"test(String arg) {\n" + 
			"  arg.doApply(e|e+arg);\n" + 
			"}\n" + 
			"\n" + 
			"<T extends CharSequence, R> R doApply(T obj, (T)=>R fun) {\n" + 
			"  fun.apply(obj)\n" + 
			"}";
		invokeAndExpect2("foofoo", definition, "test", "foo");
	}
	
	public void testFunctionCall_00() throws Exception {
		invokeAndExpect("foobar", "bar(p1)} bar(String x) {'foo'+x","bar");
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
		javaCompiler.addClassPathOfClass(StringExtensions.class);
		javaCompiler.addClassPathOfClass(Notifier.class);
		javaCompiler.addClassPathOfClass(EcorePackage.class);
		javaCompiler.addClassPathOfClass(XbasePackage.class);
		javaCompiler.addClassPathOfClass(Xtend2Package.class);
		javaCompiler.addClassPathOfClass(Inject.class);
		javaCompiler.addClassPathOfClass(Properties1.class);
		javaCompiler.addClassPathOfClass(Function.class);
		javaCompiler.addClassPathOfClass(StringConcatenation.class);
	}
	
	protected void invokeAndExpect2(Object expectation, String xtendclassBody, String methodToInvoke, Object...args) throws Exception {
		Class<?> class1 = compileJavaCode( "x.Y", "package x class Y {"+xtendclassBody+"}");
		assertEquals(expectation,apply(class1,methodToInvoke,args));
	}
	protected void invokeAndExpect(Object expectation, String functionDef, Object...args) throws Exception {
		String fullClass = "package x class Y { Object testEntry(";
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
	
	protected Object apply(Class<?> type,String methodName,Object...args) throws Exception {
		final Injector inj = Guice.createInjector();
		Object instance = inj.getInstance(type);
		if (args==null) {
			return type.getDeclaredMethod(methodName).invoke(instance);
		}
		Class<?>[] argTypes = new Class[args.length];
		for (int i = 0; i < argTypes.length; i++) {
			if (args[i] == null) {
				argTypes[i] = Object.class;
			} else {
				argTypes[i] = args[i].getClass();
			}
		}
		Method method = type.getDeclaredMethod(methodName, argTypes);
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
		StringWriter appandable = new StringWriter();
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
