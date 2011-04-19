/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.compiler;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
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
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilerTest extends AbstractXtend2TestCase {
	
	
	public void testExtensionCallOnThisBoundMember() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y",
				"package x " +
				"import static extension java.util.Collections.* " +
				"class Y {" +
				"  foo(Object this) {\n" +
				"    singletonList" + 
				"  }\n" +
				"}");
		Object instance = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("foo", Object.class);
		try {
			assertEquals(Collections.singletonList("FOO"), method.invoke(instance, "FOO"));
		} catch (InvocationTargetException e) {
			assertTrue(e.getCause() instanceof IOException);
		}
	}
	
	public void testRethrownCheckedExceptions_00() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y",
				"package x class Y {" +
				"  foo() {\n" +
				"    throw new java.io.IOException()" + 
				"  }\n" +
				"  bar(){\n" +
				"    foo()" +
				"  }\n" + 
				"}");
		Object instance = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("bar");
		try {
			method.invoke(instance);
		} catch (InvocationTargetException e) {
			assertTrue(e.getCause() instanceof IOException);
		}
	}
	
	public void testRethrownCheckedExceptions_01() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y",
				"package x class Y {" +
				"  dispatch foo(String x) {\n" +
				"    throw new java.io.EOFException()" + 
				"  }\n" +
				"  dispatch foo(Object x) {\n" +
				"    throw new java.io.FileNotFoundException()" + 
				"  }\n" +
				"  bar(){\n" +
				"    foo('bar')" +
				"  }\n" + 
		"}");
		Object instance = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("bar");
		try {
			method.invoke(instance);
		} catch (InvocationTargetException e) {
			assertTrue(e.getCause() instanceof java.io.EOFException);
		}
	}
	
	public void testSuperCall() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y",
				"package x class Y extends Object {" +
				"  override boolean equals(Object p){\n" +
				"    if ('foo' == p) " +
				"       return true" +
				"    else " +
				"       super.equals(p)" + 
				"  }\n" + 
		"}");
		Object instance = clazz.newInstance();
		assertFalse(instance.equals(clazz.newInstance()));
		assertTrue(instance.equals(instance));
		assertTrue(instance.equals("foo"));
	}
	
	public void testSuperCall_00() throws Exception {
		String code = 
				"package x class Z {" +
				"  override boolean equals(Object p){\n" +
				"    if ('foo' == p) " +
				"       return true" +
				"    else " +
				"       return super.equals(p)" + 
				"  }\n" + 
				"}";
		String javaCode = compileToJavaCode(code);
		Class<?> clazz = javaCompiler.compileToClass("x.Z", javaCode);
		Object instance = clazz.newInstance();
		assertFalse(instance.equals(clazz.newInstance()));
		assertTrue(instance.equals(instance));
		assertTrue(instance.equals("foo"));
	}
	
	public void testThisReferenceInClosures() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y",
				"package x class Y {" +
				"  String foo(String p){\n" +
				"    [|this.bar(p+'foo')].apply" + 
				"  }\n" + 
				"  String bar(String this){\n" +
				"    [|this+'bar'].apply" + 
				"  }" +
		"}");
		Method method = clazz.getDeclaredMethod("foo", String.class);
		assertEquals("Hello foobar", method.invoke(clazz.newInstance(),"Hello "));
	}
	
	public void testDispatchWithThis() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y",
				"package x class Y {" +
				"  dispatch foo(String this){\n" +
				"    return 'String'" + 
				"  }\n" + 
				"  dispatch foo(CharSequence this){\n" +
				"    return 'CharSequence'" + 
				"  }" +
				"}");
		Method method = clazz.getDeclaredMethod("foo", CharSequence.class);
		assertEquals("String", method.invoke(clazz.newInstance(),"Foo"));
		
	}
	
	public void testCreateExtension_00() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y", 
				"package x " +
				"class Y {" +
				"  create new StringBuilder() aBuilder(String x) {" +
				"   this.append(x)" +
				"  }" +
				"}");
		Object instance = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("aBuilder", String.class);
		StringBuilder sb = (StringBuilder) method.invoke(instance, "Foo");
		assertSame(sb, method.invoke(instance, "Foo"));
		assertEquals("Foo", sb.toString());
		sb.append("Bar");
		StringBuilder sb2 = (StringBuilder) method.invoke(instance, "Bar");
		assertEquals("Bar", sb2.toString());
		sb = (StringBuilder) method.invoke(instance, "Foo");
		assertEquals("FooBar",sb.toString());
	}
	
	public void testCreateExtension_threadSafety() throws Exception {
		String xtendCode = 
			"package x " +
			"class Y {" +
			"  create result: {Thread::sleep(10) new StringBuilder()} aBuilder(String x) {" +
			"   Thread::sleep(10)" +
			"   result.append(x)" +
			"  }" +
			"}";
		Class<?> clazz = compileJavaCode("x.Y", xtendCode);
		final Object instance = clazz.newInstance();
		final Method method = clazz.getDeclaredMethod("aBuilder", String.class);
		final Set<Object> elements = Collections.synchronizedSet(Sets.newHashSet());
		Runnable runnable = new Runnable() {
			public void run() {
				try {
					for (int i = 0; i < 50; i++) {
						Object stringBuilder = method.invoke(instance, "Foo");
						elements.add(stringBuilder);
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		};
		List<Thread> threads = newArrayList(); 
		for (int i=0;i<10;i++) {
			Thread t = new Thread(runnable);
			t.start();
			threads.add(t);
		}
		for (Thread thread : threads) {
			thread.join();
		}
		assertEquals(compileToJavaCode(xtendCode) + " produced: " + elements, 1, elements.size());
		assertEquals("Foo", elements.iterator().next().toString());
	}
	
	public void testInferredReturnType() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y", 
				"package x " +
				"class Y {" +
				"  int a() {" +
				"   b()" +
				"  }" +
				"  " +
				"  b() {" +
				"    c()" +
				"  }" +
				"  " +
				"  c() {" +
				"    2" +
				"  }" +
		"}");
		assertEquals(2, apply(clazz, "a"));
	}
	
	public void testSugarForLocalExtensions_01() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				" operator_plus(int x, String s) {" +
				"   x.toString + s" +
				" }" +
				"" +
				" test() {" +
				"    return 42 + 'foo'" +
				" }" +
				"}");
		assertEquals("42foo",apply(class1,"test"));
	}
	
	public void testSugarForLocalExtensions_02() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				" getSize(String s) {" +
				"   s.length" +
				" }" +
				"" +
				" test() {" +
				"    return 'foo'.size" +
				" }" +
		"}");
		assertEquals(3,apply(class1,"test"));
	}
	
	public void testStaticExtensionMethod_01() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y","package x import static extension java.util.Collections.* class Y { foo() {'foo'.singleton()}}");
		assertEquals(singleton("foo"),apply(class1,"foo"));
	}
	
	public void testStaticExtensionMethod_02() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"import static extension java.util.Collections.* " +
				"class Y { " +
				" foo() {" +
				"   'foo'.singleton" +
				" }" +
				"}");
		assertEquals(singleton("foo"),apply(class1,"foo"));
	}
	
	public void testInjectedExtensionMethod_01() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @Inject extension test.GenericExtensionMethods<String,Integer> as x" +
				"  " +
				"  foo(String arg) { " +
				"    arg.method " +
				"    42.method" +
				"    return x.result" +
				"  }" +
				"}");
		assertEquals(newArrayList("method(A)","method(B)"), apply(class1,"foo","foo"));
	}
	
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
	
	public void testInjectedExtensionMethod_04() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @Inject extension test.ExtensionMethods " +
				"  foo(String arg) { " +
				"    return arg - 'bar' " +
				"  } " +
				"}");
		assertEquals("operator_minus(String,String)",apply(class1,"foo","foobar"));
	}
	
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
	
	public void testReturnTypeAndReturnExpression_00() throws Exception {
		String decl = 
			"String test() {" +
			"  return 'foo'" +
			"}";
		invokeAndExpect2("foo", decl, "test");
	}
	
	public void testReturnTypeAndReturnExpression_01() throws Exception {
		String decl = 
			"CharSequence test() {" +
			"  if ('foo' == 'foo') {" +
			"    return 'foo'" +
			"  }" +
			"}";
		invokeAndExpect2("foo", decl, "test");
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
		invokeAndExpect("null", definition, new Object[]{null});
	}

	public void testDispatchFunction_03() throws Exception {
		final String definition = "doIt(p1) }" +
				"   dispatch doIt(org.eclipse.emf.ecore.EStructuralFeature x) { typeof(org.eclipse.emf.ecore.EStructuralFeature) }\n" + 
				"	dispatch doIt(org.eclipse.emf.ecore.EReference x) { typeof(org.eclipse.emf.ecore.EReference) }\n" + 
				"	dispatch doIt(org.eclipse.emf.ecore.EAttribute x) { typeof(org.eclipse.emf.ecore.EAttribute) }\n" + 
				"	dispatch doIt(org.eclipse.emf.ecore.ETypedElement x) { typeof(org.eclipse.emf.ecore.ETypedElement) ";
		invokeAndExpect(EReference.class, definition,Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF);
		invokeAndExpect(EAttribute.class, definition,Xtend2Package.Literals.XTEND_FILE__PACKAGE);
		invokeAndExpect(ETypedElement.class, definition,EcoreFactory.eINSTANCE.createEOperation());
	}
	
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

	public void testDispatchFunction_06() throws Exception {
		final String definition = "foo(p1)} " +
				"dispatch foo (String string) {\n" + 
				"    string + string\n" + 
				"}\n" + 
				"dispatch foo (Object o) {\n" + 
				"    null\n";
		invokeAndExpect("zonkzonk", definition, "zonk");
		invokeAndExpect(null, definition, Integer.valueOf(1));
	}
	
	public void testDispatchFunction_07() throws Exception {
		final String definition = "foo(p1)} " +
				"dispatch foo (String string) {\n" + 
				"    string + string\n" + 
				"}\n" + 
				"dispatch foo (Void nullCase) {\n" + 
				"    'literal'\n";
		invokeAndExpect("zonkzonk", definition, "zonk");
		invokeAndExpect("literal", definition, new Object[]{ null });
		try {
			invokeAndExpect(null, definition, Integer.valueOf(1));
			fail();
		} catch (InvocationTargetException e) {
			assertTrue(e.getCause() instanceof IllegalArgumentException);
		}
	}
	
	public void testDispatchFunction_08() throws Exception {
		final String definition = "foo(p1)} " +
		"dispatch String foo(String string) {\n" + 
		"    string + string\n" + 
		"}\n" + 
		"String foo(Object x) {\n" + 
		"    'literal'\n";
		invokeAndExpect("zonkzonk", definition, "zonk");
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
	
	public void testGenericFunction_02() throws Exception {
		String def = 
			    "test(String x) {" +
			    "  x.init(e|{})" +
			    "}" +
			    "<T> T init(T obj, (T)=>Void function) {\n" + 
				"  function.apply(obj)\n" + 
				"  return obj\n" + 
				"}";
		invokeAndExpect2("foo", def, "test", "foo");
	}
	
	public void testFunctionCall_00() throws Exception {
		invokeAndExpect("foobar", "bar(p1)} bar(String x) {'foo'+x","bar");
	}
	
	public void testBug342134() throws Exception {
		List<String> list = newArrayList("a", "b", "c");
		invokeAndExpect2(
				list, 
				"bug342134(java.util.ArrayList<String> strings) {\n" + 
				"    strings.map(e| newArrayList(e)).flatten.toList\n" + 
				"}", "bug342134", list);
	}
	
	public void testTypeInferrence_00() throws Exception {
		compileJavaCode("Foo", "import org.eclipse.emf.ecore.EObject " +
				"class Foo { " +
				"	Iterable<? extends EObject> test(EObject e) {" +
				"		e.eContents().map(o|test(o)).flatten()" +
				"	}" +
				"}");
	}
	
	public void testDispatchTypes() throws Exception {
		compileJavaCode("Dispatch", "class Dispatch { " +
				 "  dispatch doSomething(int i) { i.toString() } " +
				 "  dispatch doSomething(Object o) { null } " +
				 "}");
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
			System.err.println(javaCode);
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
