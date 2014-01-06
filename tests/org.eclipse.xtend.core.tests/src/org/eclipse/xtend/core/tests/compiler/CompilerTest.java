/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler;

import static com.google.common.collect.Lists.*;
import static java.util.Collections.*;

import java.io.IOException;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtend.core.compiler.XtendCompiler;
import org.eclipse.xtend.core.jvmmodel.IXtendJvmAssociations;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend.lib.Property;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmGenericType;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.compiler.IGeneratorConfigProvider;
import org.eclipse.xtext.xbase.compiler.JvmModelGenerator;
import org.eclipse.xtext.xbase.compiler.OnTheFlyJavaCompiler.EclipseRuntimeDependentJavaCompiler;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import test.ExtensionMethods;
import test.SampleBuilder;
import test.SuperClass;
import testdata.Properties1;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class CompilerTest extends AbstractXtendTestCase {
	
	@Test public void testGenericVoidFunction() throws Exception {
		String code = 
				" def String getString(String myString) {\n" + 
				"   (test::GenericVoidFunctionAcceptor::accept(<String>newArrayList()) [it.add(myString)]).head\n" + 
				" }";
		invokeAndExpect2("foo",code,"getString", "foo");
	}
	
	@Test public void testRecursiveTypeParameter_01() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   selftypes::ConcreteBuilder::create.append(s).append(s).build\n" + 
				" }";
		invokeAndExpect2("zonkzonk",code,"produceString", "zonk");
	}
	
	@Test public void testRecursiveTypeParameter_02() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   selftypes::ConcreteSubBuilder::create.append(s).appendTwice(s).build\n" + 
				" }";
		invokeAndExpect2("zonkzonkzonk",code,"produceString", "zonk");
	}
	
	@Test public void testRecursiveTypeParameter_03() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   s.inferReturnType.build\n" + 
				" }\n" +
				" def inferReturnType(String s) {\n" +
				"   selftypes::ConcreteBuilder::create.append(s).append(s)" +
				" }";
		invokeAndExpect2("zonkzonk",code,"produceString", "zonk");
	}

	@Test public void testRecursiveTypeParameter_04() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   s.inferReturnType.appendTwice(s).build\n" + 
				" }\n" +
				" def inferReturnType(String s) {\n" +
				"   selftypes::ConcreteSubBuilder::create.append(s)" +
				" }";
		invokeAndExpect2("zonkzonkzonk",code,"produceString", "zonk");
	}
	
	@Test public void testRecursiveTypeParameter_05() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   selftypes.ConcreteBuilder::create.append(s).append(s).build\n" + 
				" }";
		invokeAndExpect2("zonkzonk",code,"produceString", "zonk");
	}
	
	@Test public void testRecursiveTypeParameter_06() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   selftypes.ConcreteSubBuilder::create.append(s).appendTwice(s).build\n" + 
				" }";
		invokeAndExpect2("zonkzonkzonk",code,"produceString", "zonk");
	}
	
	@Test public void testRecursiveTypeParameter_07() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   s.inferReturnType.build\n" + 
				" }\n" +
				" def inferReturnType(String s) {\n" +
				"   selftypes.ConcreteBuilder::create.append(s).append(s)" +
				" }";
		invokeAndExpect2("zonkzonk",code,"produceString", "zonk");
	}

	@Test public void testRecursiveTypeParameter_08() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   s.inferReturnType.appendTwice(s).build\n" + 
				" }\n" +
				" def inferReturnType(String s) {\n" +
				"   selftypes.ConcreteSubBuilder::create.append(s)" +
				" }";
		invokeAndExpect2("zonkzonkzonk",code,"produceString", "zonk");
	}
	
	@Test public void testRecursiveTypeParameter_09() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   selftypes.ConcreteBuilder.create.append(s).append(s).build\n" + 
				" }";
		invokeAndExpect2("zonkzonk",code,"produceString", "zonk");
	}
	
	@Test public void testRecursiveTypeParameter_10() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   selftypes.ConcreteSubBuilder.create.append(s).appendTwice(s).build\n" + 
				" }";
		invokeAndExpect2("zonkzonkzonk",code,"produceString", "zonk");
	}
	
	@Test public void testRecursiveTypeParameter_11() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   s.inferReturnType.build\n" + 
				" }\n" +
				" def inferReturnType(String s) {\n" +
				"   selftypes.ConcreteBuilder.create.append(s).append(s)" +
				" }";
		invokeAndExpect2("zonkzonk",code,"produceString", "zonk");
	}

	@Test public void testRecursiveTypeParameter_12() throws Exception {
		String code = 
				" def String produceString(String s) {\n" + 
				"   s.inferReturnType.appendTwice(s).build\n" + 
				" }\n" +
				" def inferReturnType(String s) {\n" +
				"   selftypes.ConcreteSubBuilder.create.append(s)" +
				" }";
		invokeAndExpect2("zonkzonkzonk",code,"produceString", "zonk");
	}
	
	@Test public void testBug372864() throws Exception {
		String code = 
				" def String testSwitch(Object e) {\n" + 
				"        switch e {\n" + 
				"           Object : return 'foo'\n" + 
				"           default: null\n" + 
				"        }\n" + 
				"    }";
		invokeAndExpect2("foo",code,"testSwitch", new Object());
	}
	
	@Test public void testBug372864_1() throws Exception {
		String code = 
				" def String testSwitch(Object e) {\n" + 
						"        switch e {\n" + 
						"           Object : null\n" + 
						"        }\n" + 
						"    }";
		invokeAndExpect2(null,code,"testSwitch", new Object());
	}
	
	@Test public void testBug372864_2() throws Exception {
		String code = 
				" def String testSwitch(Object e) {\n" + 
				"        switch e {\n" + 
				"           Object : return null\n" + 
				"        }\n" + 
				"    }";
		invokeAndExpect2(null,code,"testSwitch", new Object());
	}
	
	
	@Test public void testBug367763() throws Exception {
		String code = 
				"  def String foo(Number x) { throw new IllegalArgumentException() }\n" + 
				"\n" + 
				"  def foo(Object x) {'Object'}\n" + 
				"\n" + 
				"  def test(Object it) {\n" + 
				"    foo()\n" + 
				"  }";
		invokeAndExpect2("Object",code,"test", new Object());
	}
	
	@Test public void testClosuresAndExceptions() throws Exception {
		String code = "" +
				"def test() {\n" +
				"  newArrayList('foo').map( s | throwing(s) ).head\n" +
				"}\n" +
				"def String throwing(String s) throws java.io.IOException {\n" +
				"  s\n" +
				"}\n";
		invokeAndExpect2("foo", code, "test");
	}
	
	@Test public void testFunctionTypes() throws Exception {
		String code = "" +
				"def String test() {\n" +
				"  newArrayList('fo','bar').maxBy[length]" +
				"}\n" +
				"" +
				"def <A,B extends Comparable<? super B>> A maxBy(Iterable<A> iterable, (A)=>B maxOn) {\n" + 
				"  iterable.sortBy(maxOn).last\n" + 
				"}";
		invokeAndExpect2("bar", code, "test");
	}

	@Test public void testFieldInitialization_01() throws Exception {
		String code =
				"String field = if (true) newArrayList('a', 'b').join(',') else ''\n" +
				"def getField() {\n" + 
				"  field" + 
				"}";
		String expectation = "a,b";
		invokeAndExpect2(expectation, code, "getField");
	}
	
	@Test public void testFieldInitialization_02() throws Exception {
		String code =
				"String field = return 123.toString\n" +
				"def getField() {\n" + 
				"  field" + 
				"}";
		invokeAndExpect2("123", code, "getField");
	}
	
	@Test public void testFieldInitialization_03() throws Exception {
		String code =
				"int other = 12\n" + 
				"int field = other + 1\n" +
				"def getField() {\n" + 
				"  field" + 
				"}";
		invokeAndExpect2(Integer.valueOf(13), code, "getField");
	}
	
	@Test public void testFieldInitialization_04() throws Exception {
		String code =
				"val other = 12\n" + 
				"val field = other + 1\n" +
				"def getField() {\n" + 
				"  field" + 
				"}";
		invokeAndExpect2(Integer.valueOf(13), code, "getField");
	}
	
	@Test public void testFieldInitialization_05() throws Exception {
		String code =
				"val String other\n" + 
						"new() { other = 'foo' } \n" +
						"def getField() {\n" + 
						"  other" + 
						"}";
		invokeAndExpect2("foo", code, "getField");
	}
	
	@Test public void testFieldInitialization_06() throws Exception {
		String code =
				"extension val String\n" + 
				"new() { _string = 'foo' } \n" +
				"def getField() {\n" + 
				"  _string" + 
				"}";
		invokeAndExpect2("foo", code, "getField");
	}
	
	@Test public void testFieldInitialization_07() throws Exception {
		String code =
				"String field = 123.toString\n" +
				"def getField() {\n" + 
				"  field" + 
				"}";
		invokeAndExpect2("123", code, "getField");
	}
	
	@Test public void testDeclaredConstructor_01() throws Exception {
		String code = "class Z { new() { this(1) } new(int a) { super() } }";
		compileJavaCode("Z", code);
	}
	
	@Test public void testDeclaredConstructor_02() throws Exception {
		String code = "class Z { new() { super() } new(int a) { this() } }";
		compileJavaCode("Z", code);
	}
	
	@Test public void testDeclaredConstructor_03() throws Exception {
		String code = "class Z { new() { this(1) } new(int i) {} }";
		compileJavaCode("Z", code);
	}
	
	@Test public void testDeclaredConstructor_04() throws Exception {
		String code = 
				"  static int j " +
				"  int i " +
				"  new() { this(j) } " +
				"  new(int i) { this.i = i } " +
				"  def static invokeMe() { j = 47 new Y().i }";
		invokeAndExpectStatic(Integer.valueOf(47), code, "invokeMe");
	}
	
	@Test public void testDeclaredConstructor_05() throws Exception {
		String code = "class Z { new() { this(null as Object) } new(Object o) {} }";
		compileJavaCode("Z", code);
	}
	
	@Test public void testDeclaredConstructor_06() throws Exception {
		String code = "class Z { new(Object o) { this(o as String) } new(String o) {} }";
		compileJavaCode("Z", code);
	}
	
	@Test public void testDeclaredConstructor_07() throws Exception {
		String code = 
				"  static int j " +
				"  int i " +
				"  new() { this(1 + j * 2 - 1) } " +
				"  new(int i) { this.i = i } " +
				"  def static invokeMe() { j = 47 new Y().i }";
		invokeAndExpectStatic(Integer.valueOf(94), code, "invokeMe");
	}
	@Test public void testDeclaredConstructorWithVarArgs() throws Exception {
		String code = 
				"int a " +
				"int b " +
				"new() { this(1,2) } " +
				"new(int... i) { " +
				"  this.a = i.get(0) " +
				"  this.b = i.get(1) " +
				"}" +
				"def static invokeMe() { " +
				"  val x = new Y() " +
				"  return x.a -> x.b" +
				"}";
		invokeAndExpectStatic(Pair.of(1, 2), code, "invokeMe");
	}
	
	@Test public void testBug362236_01() throws Exception {
		String code = 
				"import java.util.List\n" +
				"class Z {\n"+
				"    def returnClosure() {  \n" + 
				"      thing(int i|i.toString)\n" + 
				"    }\n" + 
				"    def thing(Object o) {" +
				"      o\n" + 
				"    }\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("Z", javaCode);
		Object object = class1.newInstance();
		Object closure = class1.getDeclaredMethod("returnClosure").invoke(object);
		@SuppressWarnings("unchecked")
		Functions.Function1<Object, Object> castedClosure = (Function1<Object, Object>) closure;
		assertEquals("123", castedClosure.apply(123));
	}
	
	@Test public void testBug362236_02() throws Exception {
		String code = 
				"import java.util.List\n" +
				"class Z {\n"+
				"    def returnClosure() {  \n" + 
				"      thing(Integer i|i.toString)\n" + 
				"    }\n" + 
				"    def thing(Object o) {" +
				"      o\n" + 
				"    }\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("Z", javaCode);
		Object object = class1.newInstance();
		Object closure = class1.getDeclaredMethod("returnClosure").invoke(object);
		@SuppressWarnings("unchecked")
		Functions.Function1<Object, Object> castedClosure = (Function1<Object, Object>) closure;
		assertEquals("123", castedClosure.apply(123));
	}
	
	@Test public void testBug362236_03() throws Exception {
		String code = 
				"import java.util.List\n" +
				"class Z {\n"+
				"    def returnClosure() {  \n" + 
				"      thing(i|i.toString)\n" + 
				"    }\n" + 
				"    def thing((Object)=>Object o) {" +
				"      o\n" + 
				"    }\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("Z", javaCode);
		Object object = class1.newInstance();
		Object closure = class1.getDeclaredMethod("returnClosure").invoke(object);
		@SuppressWarnings("unchecked")
		Functions.Function1<Object, Object> castedClosure = (Function1<Object, Object>) closure;
		assertEquals("123", castedClosure.apply(123));
	}
	
	@Test public void testBug362236_04() throws Exception {
		String code = 
				"import java.util.List\n" +
						"class Z {\n"+
						"    def returnListOfClosures() {  \n" + 
						"      val list = <(String)=>int>newArrayList()" +
						"      list.add [ length ]" +
						"      list\n" + 
						"    }\n" + 
						"}";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("Z", javaCode);
		Object object = class1.newInstance();
		Object list = class1.getDeclaredMethod("returnListOfClosures").invoke(object);
		@SuppressWarnings("unchecked")
		Functions.Function1<String, Integer> castedClosure =  (Function1<String, Integer>)((List<?>)list).get(0);
		assertEquals(Integer.valueOf(4), castedClosure.apply("4444"));
	}
	
	@Test public void testBug363621() throws Exception {
		String code = 
				"import java.util.List\n" +
				"class Z {\n"+
				"    def methodOne() {\n" + 
				"        val strings = newHashSet\n" + 
				"        strings += \"a\"\n" + 
				"    }\n" + 
				"    def methodTwo() {\n" + 
				"        val List<String> l = null\n" + 
				"        l.getClass\n" + 
				"        l.^class\n" + 
				"    }\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("Z", javaCode);
		Object object = class1.newInstance();
		assertTrue((Boolean)class1.getDeclaredMethod("methodOne").invoke(object));
	}
	
	@Test public void testSneakyThrow() throws Exception {
		String code = 
				"class Z {\n" +
				"	def void test() {\n" +
				"       throw new java.io.IOException()" + 
				"	}\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("Z", javaCode);
		Object object = class1.newInstance();
		try {
			class1.getDeclaredMethod("test").invoke(object);
		} catch (Exception e) {
			assertTrue(((InvocationTargetException)e).getCause() instanceof IOException);
		}
	}
	
	@Test public void testBug_362651() throws Exception {
		String code = 
				"class Z {\n" +
				"	def boolean test() {\n" +
				"       val _class = 'Z'\n" +
				"		[| this.^class.name == _class.toUpperCase].apply" + 
				"	}\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("Z", javaCode);
		Object object = class1.newInstance();
		assertTrue((Boolean)class1.getDeclaredMethod("test").invoke(object));
	}
	
	@Test public void testReferenceStaticallyImportedFields() throws Exception {
		String code = 
				"import java.lang.annotation.RetentionPolicy\n" +
				"import static java.lang.annotation.RetentionPolicy.*\n" +
				"class Z {\n" +
				"	def RetentionPolicy test() {\n" +
				"       RUNTIME\n" + 
				"	}\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("Z", javaCode);
		Object object = class1.newInstance();
		assertEquals(RetentionPolicy.RUNTIME, class1.getDeclaredMethod("test").invoke(object));
	}
	
	@Test public void testReferenceStaticallyImportedFields_1() throws Exception {
		String code = 
				"import static java.util.Collections.*\n" +
				"class Z {\n" +
				"	def Object test() {\n" +
				"       EMPTY_SET\n" + 
				"	}\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("Z", javaCode);
		Object object = class1.newInstance();
		assertEquals(Collections.EMPTY_SET, class1.getDeclaredMethod("test").invoke(object));
	}
	
	@Test public void testSimpleExtensionMethodCall() throws Exception {
		String code = 
				"package x class Z {" +
				"  def create result : <String>newArrayList() copyNet(String append) {\n" +
				"    result += append\n" + 
				"  }" +
				"  def ifExpression(String param) {\n" + 
				"    if (param!=null) {\n" + 
				"      param.length\n" + 
				"    } else {\n" + 
				"      0\n" + 
				"    } \n" + 
				"  }\n" + 
				"\n" + 
				"  def ifExpression_01(String param) {\n" + 
				"    ifExpression(if (param=='foo') 'bar' else 'baz') \n" + 
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("x.Z", javaCode);
		Object object = class1.newInstance();
		assertEquals(3, class1.getDeclaredMethod("ifExpression_01", String.class).invoke(object, "foo"));
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=356073
	 */
	@Test public void testExtendsJavaLangObject() throws Exception {
		String code = 
				"package x class Z {" +
				"  def test() {\n" +
				"    this.equals(this.toString())\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("x.Z", javaCode);
		Object object = class1.newInstance();
		assertFalse((Boolean) class1.getDeclaredMethod("test").invoke(object));
	}
	
	@Test public void testFunctionNameStartingWithUnderscore() throws Exception {
		String code = 
				"package x class Z {" +
				"  def _foo(Object x, boolean b) {}\n" +
				"  def _foo(String x, boolean b) {}\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("x.Z", javaCode);
		assertEquals(2, class1.getDeclaredMethods().length);
		assertNotNull(class1.getMethod("_foo", new Class<?>[] { Object.class, Boolean.TYPE }));
		assertNotNull(class1.getMethod("_foo", new Class<?>[] { String.class, Boolean.TYPE }));
		try {
			class1.getMethod("foo", new Class<?>[]{Object.class, Boolean.TYPE});
			fail("shouldn't contain a dispatch method");
		} catch (NoSuchMethodException e) {
			// expected
		}
	}
	
	@Test public void testDispatchSignatureWithPrimitives() throws Exception {
		String code = 
				"package x class Z {" +
				"  def dispatch foo(Object x, boolean b) {}\n" +
				"  def dispatch foo(String x, boolean b) {}\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("x.Z", javaCode);
		Method method = class1.getMethod("foo", new Class<?>[]{Object.class, Boolean.TYPE});
		assertNotNull(method);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=382208
	 */
	@Test public void testDispatchedCreateMethods() throws Exception {
		String code = 
				"package x class Z {\n" +
				"  def dispatch create newArrayList foo(Object x) {}\n" +
				"  def dispatch create newArrayList foo(String x) {}\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("x.Z", javaCode);
		Method method = class1.getMethod("foo", new Class<?>[]{Object.class});
		assertNotNull(method);
		List<?> list = (List<?>) method.invoke(class1.newInstance(), "foo");
		assertEquals(0, list.size());
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=382208
	 */
	@Test public void testDispatchedCreateMethods_02() throws Exception {
		String code = 
				"package x class Z {\n" +
				"  def dispatch create new StringBuilder foo(Object x) { for (y : 1..2) append(y) }\n" +
				"  def dispatch create new StringBuilder foo(String x) { append(2) }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> class1 = javaCompiler.compileToClass("x.Z", javaCode);
		Method method = class1.getMethod("foo", new Class<?>[]{Object.class});
		assertNotNull(method);
		StringBuilder sb = (StringBuilder) method.invoke(class1.newInstance(), "foo");
		assertEquals("2", sb.toString());
		sb = (StringBuilder) method.invoke(class1.newInstance(), 23);
		assertEquals("12", sb.toString());
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345458
	 */
	@Test public void testBug_345458() throws Exception {
		String code = 
				"package x class Z {" +
				"  def create(Object x) { \n" + 
				"    if(true) {\n" + 
				"      if(true)\n" + 
				"        ('foo'+'bar').length\n" + 
				"      for(c : 'foo'.toCharArray)\n" + 
				"        ('do'+'sideeffect').length\n" + 
				"    }\n" + 
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345828
	 */
	@Test public void testBug_345828_01() throws Exception {
		String code = 
				"package x\n" +
				"class Z {" +
				"  def <T extends =>Integer> baz(T t) {\n" +
				"    val int i = t.apply\n" +
				"    if (i == 0)\n" +
				"      t.apply\n" + 
				"    t.apply\n" + 
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345828
	 */
	@Test public void testBug_345828_02() throws Exception {
		String code = 
				"package x\n" +
				"import org.eclipse.xtext.xbase.lib.Functions\n" +
				"class Z {" +
				"  def <T extends Functions$Function0<Integer>> bar(T t) {\n" +
				"    val int i = t.apply\n" +
				"    if (i == 0)\n" +
				"      t.apply\n" + 
				"    t.apply\n" + 
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345828
	 */
	@Test public void testBug_345828_03() throws Exception {
		String code = 
				"package x\n" +
				"class Z {" +
				"  def <MyParam extends =>Integer> baz(java.util.List<MyParam> t) {\n" +
				"    val int i = t.head.apply\n" +
				"    if (i == 0)\n" +
				"      t.head.apply\n" + 
				"    t.head.apply\n" + 
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345828
	 */
	@Test public void testBug_345828_04() throws Exception {
		String code = 
				"package x\n" +
				"import org.eclipse.xtext.xbase.lib.Functions\n" +
				"class Z {" +
				"  def <MyParam extends Functions$Function0<Integer>> bar(java.util.List<MyParam> t) {\n" +
				"    val int i = t.head.apply\n" +
				"    if (i == 0)\n" +
				"      t.head.apply\n" + 
				"    t.head.apply\n" + 
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}

	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345828
	 */
	@Test public void testBug_345828_05() throws Exception {
		String code = 
				"package x\n" +
				"class Z {" +
				"  def <MyParam extends =>Integer> baz(java.util.List<MyParam> t) {\n" +
				"    val int i = t.get(0).apply\n" +
				"    if (i == 0)\n" +
				"      t.iterator.next.apply\n" + 
				"    t.get(0).apply\n" + 
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}

	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345828
	 */
	@Test public void testBug_345828_06() throws Exception {
//		class Z {
//			<MyParam extends Functions.Function0<? extends Integer>> int baz(List<MyParam> t) {
//				int i = IterableExtensions.<MyParam>head(t).apply();
//				if (i == 0)
//					return IterableExtensions.<MyParam>head(t).apply() + 1;
//				return IterableExtensions.head(t).apply() + 1;
//			}
//		}
		String code = 
				"package x\n" +
				"class Z {" +
				"  def <MyParam extends =>Integer> baz(java.util.List<MyParam> t) {\n" +
				"    val int i = t.<MyParam>head.apply + 1\n" +
				"    if (i == 0)\n" +
				"      println(t.<MyParam>head.apply + 1)\n" + 
				"    t.head.apply + 1\n" + 
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=351330
	 */
	@Test public void testBug_351330_01() throws Exception {
		String code = 
			"package x class Z {" +
			"  def <T> toString(Iterable<T> i, (T)=>String toStringFunc, String separator){\n" + 
			"    i.map(T x | toStringFunc.apply(x)).join(separator)\n" + 
			"  }\n" +
			"}\n";
		String javaCode = compileToJavaCode(code);
		Class<?> compiledClazz = javaCompiler.compileToClass("x.Z", javaCode);
		Object instance = compiledClazz.newInstance();
		Method method = compiledClazz.getDeclaredMethods()[0];
		List<String> list = Lists.newArrayList("a", "b");
		Function1<String, String> function = new Functions.Function1<String, String>() {
			public String apply(String p) {
				return p.toUpperCase();
			}
		};
		String separator = ", ";
		Object result = method.invoke(instance, list, function, separator);
		assertEquals("A, B", result);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=351330
	 */
	@Test public void testBug_351330_02() throws Exception {
		String code = 
			"package x class Z <T> {" +
			"  def toSeparatedString(Iterable<T> i, (T)=>String toStringFunc, String separator){\n" + 
			"    i.map(T x | toStringFunc.apply(x)).join(separator)\n" + 
			"  }\n" +
			"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=351330
	 */
	@Test public void testBug_351330_03() throws Exception {
//		class C<T> {
//			void toSeparatedString(Iterable<T> i, Functions.Function1<? extends T, String> toStringFunc) {
//				IterableExtensions.map(i, toStringFunc); // error marker on this line
//				IterableExtensions.<T, String>map(i, toStringFunc); // error marker on this line
//				/*
//				 * The method map(Iterable<T>, Functions.Function1<? super T,? extends R>) in the 
//				 * type IterableExtensions is not applicable for the arguments 
//				 * (Iterable<T>, Functions.Function1<capture#25-of ? extends T,String>)
//				 */
//			}
//		}
		String code = 
			"package x class Z <T> {" +
			"  def toSeparatedString(Iterable<T> i, org.eclipse.xtext.xbase.lib.Functions$Function1<? extends T, String> toStringFunc, String separator){\n" + 
			"    i.map(T x | x.toString).join(separator)\n" + 
			"  }\n" +
			"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=351330
	 */
	@Test public void testBug_351330_04() throws Exception {
//		class C<T> {
//			void toSeparatedString(Iterable<T> i, Functions.Function1<? super T, String> toStringFunc) {
//				IterableExtensions.map(i, toStringFunc); // OK
//				IterableExtensions.<T, String>map(i, toStringFunc); // OK
//			}
//		}
		String code = 
			"package x class Z <T> {" +
			"  def toSeparatedString(Iterable<T> i, org.eclipse.xtext.xbase.lib.Functions$Function1<? super T, String> toStringFunc, String separator){\n" + 
			"    i.map(T x | x.toString).join(separator)\n" + 
			"  }\n" +
			"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=351330
	 */
	@Test public void testBug_351330_05() throws Exception {
//		class C {
//			<T> void toSeparatedString(Iterable<T> i, Functions.Function1<? extends T, String> toStringFunc) {
//				IterableExtensions.map(i, toStringFunc); // error marker on this line
//				IterableExtensions.<T, String>map(i, toStringFunc); // error marker on this line
//				/*
//				 * The method map(Iterable<T>, Functions.Function1<? super T,? extends R>) in the 
//				 * type IterableExtensions is not applicable for the arguments 
//				 * (Iterable<T>, Functions.Function1<capture#25-of ? extends T,String>)
//				 */
//			}
//		}
		String code = 
			"package x class Z {" +
			"  def <T> toSeparatedString(Iterable<T> i, org.eclipse.xtext.xbase.lib.Functions$Function1<? extends T, String> toStringFunc, String separator){\n" + 
			"    i.map(T x | x.toString).join(separator)\n" + 
			"  }\n" +
			"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=351330
	 */
	@Test public void testBug_351330_06() throws Exception {
//		class C {
//			<T> void toSeparatedString(Iterable<T> i, Functions.Function1<? super T, String> toStringFunc) {
//				IterableExtensions.map(i, toStringFunc); // OK
//				IterableExtensions.<T, String>map(i, toStringFunc); // OK
//			}
//		}
		String code = 
			"package x class Z {" +
			"  def <T> toSeparatedString(Iterable<T> i, org.eclipse.xtext.xbase.lib.Functions$Function1<? super T, String> toStringFunc, String separator){\n" + 
			"    i.map(T x | x.toString).join(separator)\n" + 
			"  }\n" +
			"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_01() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    if (true) return false\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_02() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    if (true) return false false\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_03() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    if (true) return false else false\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_04() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    if (true) return false return false\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_05() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    if (true) return false else return false\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_06() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    [|if (true) return false].apply\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_07() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    [|{ if (true) return false false }].apply\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_08() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    [|if (true) return false else false].apply\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_09() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    [|{ if (true) return false return false }].apply\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_10() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    [|if (true) return false else return false].apply\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_350932_11() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    if (true) return null\n" +
				"    ''\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val String s = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_12() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    if (true) return Boolean::FALSE\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_13() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    val x = if (true) return Boolean::FALSE x\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=350932
	 */
	@Test public void testBug_350932_14() throws Exception {
		String code = 
				"package x class Z {" +
				"  def bug(){\n" + 
				"    val x = if (true) return Boolean::FALSE else null x\n" + 
				"  }\n" +
				"  def invoke() {\n" +
				"    val boolean b = bug\n" +
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=351582
	 */
	@Test public void testBug_351582_01() throws Exception {
		String code = 
				"package x class Z {" +
				"  String s" +
				"  def sorted(Iterable<Z> it){\n" + 
				"    it.sortBy(z|z.s)\n" + 
				"  }\n" +
				"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352705_01() throws Exception {
		String code =
				"package x class Z {" +
				"  def void forEachError(testdata.PropertiesHolder h) {\n" + 
				"    {\n" + 
				"      h.properties.forEach(p|{\n" + 
				"        p.prop1=p.prop1.toFirstLower()\n" + 
				"      })\n" + 
				"    }\n" + 
				"  }\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352705_02() throws Exception {
		String code =
				"package x class Z {" +
				"  def void forEachError(testdata.PropertiesHolder h) {\n" + 
				"    h.properties.forEach(p|{\n" + 
				"      p.prop1=p.prop1.toFirstLower()\n" + 
				"    })\n" + 
				"  }\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352705_03() throws Exception {
		String code =
				"package x class Z {" +
				"  def void forEachError(testdata.PropertiesHolder h) {\n" + 
				"    h.properties.forEach(p|{\n" + 
				"      p.prop1=p.prop1.toFirstLower()\n" + 
				"    })\n" + 
				"  }\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352844_01() throws Exception {
		String code =
				"package x class Z {" +
				"  	def generate(java.util.List<String> d, String fsa) {\n" + 
				"		d.iter(e | e.generate(fsa))\n" + 
				"	}\n" + 
				"	\n" + 
				"	def void generate(String e, String fsa) {}\n" + 
				"	\n" + 
				"	def <T,R> iter(java.util.List<T> list, (T)=>void proc) {\n" + 
				"		for(element : list) { proc.apply(element); }\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352844_02() throws Exception {
		String code =
				"package x class Z {" +
				"  	def generate(java.util.List<String> d, String fsa) {\n" + 
				"		d.iter(e | e.generate(fsa))\n" + 
				"	}\n" + 
				"	\n" + 
				"	def generate(String e, String fsa) {}\n" + 
				"	\n" + 
				"	def <T,R> iter(java.util.List<T> list, (T)=>R predicate) {\n" + 
				"		for(element : list) { predicate.apply(element); }\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352844_03() throws Exception {
		String code =
				"package x class Z {" +
				"  	def generate(java.util.List<String> d, String fsa) {\n" + 
				"		d.iter(e | e.generate(fsa))\n" + 
				"	}\n" + 
				"	\n" + 
				"	def Void generate(String e, String fsa) {}\n" + 
				"	\n" + 
				"	def <T,R> iter(java.util.List<T> list, (T)=>Void function) {\n" + 
				"		for(element : list) { function.apply(element); }\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_350831_01() throws Exception {
		String code =
				"def callMe() {\n" + 
				"  var testdata.InterfaceA a = new testdata.ClassA()\n" + 
				"  var testdata.InterfaceB b = new testdata.ClassB()\n" + 
				"  newArrayList(a.dispatched, b.dispatched)" + 
				"}\n" + 
				"def dispatch dispatched(testdata.ClassA param) {param.className}\n" + 
				"def dispatch dispatched(testdata.ClassB param) {param.className}\n";
		List<String> expectation = Lists.newArrayList("ClassA", "ClassB");
		invokeAndExpect2(expectation, code, "callMe");
	}
	
//	static class Z {
//		void generate() {
//			List<CharSequence> seq = null;
//			List<String> strings = null;
//			Collection<String> result = addAll2(seq, strings);
//			result = addAll2(strings, seq);
//			Collection<String> result2 = addAll2(strings, seq);
//			result2 = addAll2(strings, seq);
//		}
//		public <K extends Object> Collection<K> addAll2(final List<? super K> collection,
//				final Iterable<K> elements) {
//			CollectionExtensions.addAll(collection, elements);
//			return null;
//		}
//		public <K extends Object> Collection<K> addAll2(final Iterable<K> elements, final Collection<? super K> collection) {
//			CollectionExtensions.addAll(collection, elements);
//			return null;
//		}
//	}
	@Test public void testBug_352849_01() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val result1 = seq.addAll2(strings)\n" +
				"		val Collection<String> test1 = result1\n" + 
				"		val result2 = strings.addAll3(seq)\n" + 
				"		val Collection<String> test2 = result2\n" + 
				"		val result3 = seq.addAllOverloaded(strings)\n" + 
				"		val Collection<String> test3 = result3\n" + 
				"		val result4 = strings.addAllOverloaded(seq)\n" + 
				"		val Collection<String> test4 = result4\n" + 
				"	}\n" + 
				"	def <K> Collection<K> addAll2(Collection<? super K> collection, Iterable<K> elements){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <K> Collection<K> addAll3(Iterable<K> elements, Collection<? super K> collection){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <K> Collection<K> addAllOverloaded(Collection<? super K> collection, Iterable<K> elements){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <K> Collection<K> addAllOverloaded(Iterable<K> elements, Collection<? super K> collection){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
//	static class Z {
//		void generate() {
//			List<CharSequence> seq = null;
//			List<String> strings = null;
//			Collection<String> result1 = addAll2(seq, strings);
//			Collection<String> result2 = addAll3(strings, seq);
//			Collection<String> result3 = addAllOverloaded(seq, strings);
//			Collection<String> result4 = addAllOverloaded(strings, seq);
//		}
//		public <K extends Object> Collection<K> addAll2(final Collection<? super K> collection,
//				final Iterable<K> elements) {
//			return null;
//		}
//		public <K extends Object> Collection<K> addAll3(final Iterable<K> elements, final Collection<? super K> collection) {
//			return null;
//		}
//		public <K extends Object> Collection<K> addAllOverloaded(final Collection<? super K> collection,
//				final Iterable<K> elements) {
//			return null;
//		}
//		public <K extends Object> Collection<K> addAllOverloaded(final Iterable<K> elements, final Collection<? super K> collection) {
//			return null;
//		}
//	}
	@Test public void testBug_352849_01_b() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val Collection<String> result1 = seq.addAll2(strings)\n" +
				"		val Collection<String> result2 = strings.addAll3(seq)\n" + 
				"		val Collection<String> result3 = seq.addAllOverloaded(strings)\n" + 
				"		val Collection<String> result4 = strings.addAllOverloaded(seq)\n" + 
				"	}\n" + 
				"	def <K> Collection<K> addAll2(Collection<? super K> collection, Iterable<K> elements){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <K> Collection<K> addAll3(Iterable<K> elements, Collection<? super K> collection){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <K> Collection<K> addAllOverloaded(Collection<? super K> collection, Iterable<K> elements){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <K> Collection<K> addAllOverloaded(Iterable<K> elements, Collection<? super K> collection){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
//	static class Z {
//		void generate() {
//			List<CharSequence> seq = null;
//			List<String> strings = null;
//			this.addAll2(seq, strings);
//			java.util.Collection<String> result = this.addAll2(seq, strings);
//		}
//		<T> java.util.Collection<T> addAll2(java.util.Collection<? super T> collection, Iterable<? extends T> elements) {
//			CollectionExtensions.addAll(collection, elements);
//			return null;
//		}
//	}
	@Ignore("TODO use the type expectation to bind type arguments")
	@Test public void testBug_352849_02() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val result1 = seq.addAll2(strings)\n" +
				"		val Collection<String> test1 = result1\n" + 
				"		val result2 = strings.addAll3(seq)\n" +
				"		val Collection<String> test2 = result2\n" + 
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <T> Collection<T> addAll3(Iterable<? extends T> elements, Collection<? super T> collection){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352849_02_b() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val Collection<String> result1 = seq.addAll2(strings)\n" +
				"		val Collection<String> result2 = strings.addAll3(seq)\n" +
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <T> Collection<T> addAll3(Iterable<? extends T> elements, Collection<? super T> collection){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352849_03() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val result1 = seq.addAll2(strings)\n" + 
				"		val Collection<CharSequence> test1 = result1\n" + 
				"		val result2 = strings.addAll3(seq)\n" + 
				"		val Collection<CharSequence> test2 = result2\n" + 
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<T> collection, Iterable<? extends T> elements){\n" + 
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <T> Collection<T> addAll3(Iterable<? extends T> elements, Collection<T> collection){\n" + 
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352849_04() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		seq.addAll2(seq) \n" + 
				"		strings.addAll2(strings) \n" + 
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<T> collection, Iterable<T> elements){\n" + 
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352849_05() throws Exception {
//		class Z {
//			void generate() {
//				List<CharSequence> seq = null;
//				List<String> strings = null;
//				java.util.Collection<String> result = 
//						this.addAll2(seq, strings);
//			}
//			<T> java.util.Collection<T> addAll2(java.util.Collection<? super T> collection, Iterable<? extends T> elements) {
//				CollectionExtensions.addAll(collection, elements);
//				return null;
//			}
//		}
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val Collection<String> test = seq.addAll2(strings)\n" +
				"		val Collection<String> test2 = strings.addAll3(seq)\n" +
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <T> Collection<T> addAll3(Iterable<? extends T> elements, Collection<? super T> collection){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
//	static class Z {
//		void generate() {
//			List<CharSequence> seq = null;
//			List<String> strings = null;
//			java.util.Collection<CharSequence> CharSequence = this.<CharSequence>addAll2(seq, strings);
//		}
//
//		<T> java.util.Collection<T> addAll2(java.util.Collection<? super T> collection, Iterable<? extends T> elements) {
//			CollectionExtensions.addAll(collection, elements);
//			return null;
//		}
//	}
	@Test public void testBug_352849_06() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val Collection<CharSequence> test = seq.<CharSequence>addAll2(strings)\n" +
				"		val Collection<CharSequence> test2 = strings.<CharSequence>addAll3(seq)\n" +
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n" + 
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <T> Collection<T> addAll3(Iterable<? extends T> elements, Collection<? super T> collection){\n" + 
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test
	public void testBug_352849_06_b() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val Collection<CharSequence> test = seq.addAll2(strings)\n" +
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n" + 
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test
	public void testBug_352849_06_c() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val Collection<String> test = seq.addAll2(strings)\n" +
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n" + 
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
//	static class Z {
//		void generate() {
//			List<Object> seq = null;
//			List<String> strings = null;
//			java.util.Collection<CharSequence> result = this.<CharSequence> addAll2(seq, strings);
//		}
//
//		<T> java.util.Collection<T> addAll2(java.util.Collection<? super T> collection, Iterable<? extends T> elements) {
//			CollectionExtensions.addAll(collection, elements);
//			return null;
//		}
//	}
	@Test
	public void testBug_352849_06_d() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<Object> obj = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val Collection<CharSequence> test = obj.addAll2(strings)\n" +
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n" + 
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_396879_01() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Comparator\n" +
				"class Z {\n" +
				"  	def overloaded(String s) {\n" +
				"		overloaded[ a,b | a.toUpperCase.compareTo(b.toUpperCase) ]\n" + 
				"		overloaded[ it.length ]\n" + 
				"	}\n" + 
				"	def void overloaded(Comparable<String> comparable){\n" +
				"	}\n" +
				"	def void overloaded(Comparator<String> comparator){\n" +
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_396879_02() throws Exception {
		String code =
				"package x\n" +
				"import bug396879.*\n" +
				"class Z {\n" +
				"  	def addListeners(BooleanProperty prop) {\n" +
				"		val ChangeListener<Boolean> listener = [ p, oldValue, newValue | ]" +
				"		prop.addListener(listener)\n" + 
				"	}\n" + 
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_396879_03() throws Exception {
		String code =
				"package x\n" +
				"import bug396879.*\n" +
				"class Z {\n" +
				"  	def addListeners(BooleanProperty prop) {\n" +
				"		val InvalidationListener listener = []" +
				"		prop.addListener(listener)\n" + 
				"	}\n" + 
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_396879_04() throws Exception {
		String code =
				"package x\n" +
				"import bug396879.*\n" +
				"class Z {\n" +
				"  	def addListeners(BooleanProperty prop) {\n" +
				"		prop.addListener[ p, Boolean oldValue, Boolean newValue | ]\n" + 
				"	}\n" + 
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_396879_05() throws Exception {
		String code =
				"package x\n" +
				"import bug396879.*\n" +
				"class Z {\n" +
				"  	def addListeners(BooleanProperty prop) {\n" +
				"		prop.addListener[ p, oldValue, newValue | ]\n" + 
				"		prop.addListener[]\n" + 
				"	}\n" + 
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
//	static class Z {
//		void generate() {
//			List<CharSequence> seq = null;
//			List<String> strings = null;
//			java.util.Collection<String> CharSequence = this.addAll2(seq, strings);
//		}
//	
//		<N, K extends N> Collection<K> addAll2(Collection<N> collection, Iterable<K> elements) {
//			CollectionExtensions.addAll(collection, elements);
//			return null;
//		}
//	}
	@Test public void testBug_352849_07() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val result = seq.addAll2(strings)\n" + 
				"		val Collection<String> test = result\n" + 
				"		val result2 = strings.addAll3(seq)\n" + 
				"		val Collection<String> test2 = result2\n" + 
				"	}\n" + 
				"	def <N, K extends N> Collection<K> addAll2(Collection<N> collection, Iterable<K> elements){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <N, K extends N> Collection<K> addAll3(Iterable<K> elements, Collection<N> collection){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testBug_352849_08() throws Exception {
		String code =
				"package x\n" +
				"import java.util.Collection\n" + 
				"import java.util.List\n" +
				"class Z {" +
				"  	def generate() {\n" + 
				"		val List<CharSequence> seq = null\n" + 
				"		val List<String> strings = null\n" + 
				"		val result = seq.addAll2(strings)\n" + 
				"		val Collection<CharSequence> test = result\n" + 
				"		val result2 = strings.addAll3(seq)\n" + 
				"		val Collection<CharSequence> test2 = result2\n" + 
				"	}\n" + 
				"	def <T, U extends T> Collection<T> addAll2(Collection<T> collection, Iterable<U> elements){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    collection.<T>addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"	def <T, U extends T> Collection<T> addAll3(Iterable<U> elements, Collection<T> collection){\n" +
				"	    collection.addAll(elements)\n" + 
				"	    collection.<T>addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345371
	 */
	@Test public void testVoidInTryCatchCompiles_00() throws Exception {
		String code = 
			"package x class Z {" +
			"  def create(Object x) { \n" + 
			"    try { \n" + 
			"      val fileName = 'foo' \n" + 
			"      if (fileName != null) return fileName \n" + 
			"        return 'bar' \n" + 
			"    } catch (Exception ex) { \n" + 
			"        return 'baz'; \n" + 
			"    }\n" + 
			"  }\n" +
			"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testEscapeCharacterForReservedNames() throws Exception {
		String code = 
			"package x class Z {" +
			"  def create(Object x){\n" +
			"    create(x)" + 
			"  }\n" + 
			"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}	
	
	@Test public void testSuperCall() throws Exception {
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
	
	@Test public void testSuperCall_00() throws Exception {
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
	
	@Test public void testCreateExtension_00() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y", 
				"package x " +
				"class Y {" +
				"  def create result: new StringBuilder() aBuilder(String x) {" +
				"   result.append(x)" +
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
	
	@Test public void testCreateExtension_01() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y", 
				"package x " +
				"import java.util.List " +
				"class Y {" +
				"  def Iterable<String> create result: newArrayList listWith(String s) {" +
				"   result.add(s)" +
				"  }" +
				"}");
		Object instance = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("listWith", String.class);
		@SuppressWarnings("unchecked")
		Iterable<String> iterable = (Iterable<String>) method.invoke(instance, "Foo");
		assertSame(iterable, method.invoke(instance, "Foo"));
		assertTrue(iterable instanceof ArrayList);
		assertEquals("Foo", iterable.iterator().next());
	}

	@Test public void testCreateExtension_02() throws Exception {
		Class<?> clazz = compileJavaCode("foo.Bar", 
				"package foo " +
				"class Bar { " +
				"  def create result: '' transform(String x) {} " +
				"  def create result: new Object() transform(Object x) {} " +
				"}");
		Object instance = clazz.newInstance();
		Method stringMethod = clazz.getDeclaredMethod("transform", String.class);
		Object stringResult = stringMethod.invoke(instance, "");
		assertTrue(stringResult instanceof String);
		Method objectMethod = clazz.getDeclaredMethod("transform", Object.class);
		Object objectResult = objectMethod.invoke(instance, new Object());
		assertFalse(objectResult instanceof String);
	}
	
	@Test public void testCreateExtension_03() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y", 
				"package x " +
				"import java.util.List " +
				"class Y {" +
				"  def Iterable<String> create newArrayList listWith(String s) {" +
				"   it.add(s)\n" +
				"   add(s)\n" +
				"  }" +
				"}");
		Object instance = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("listWith", String.class);
		@SuppressWarnings("unchecked")
		Iterable<String> iterable = (Iterable<String>) method.invoke(instance, "Foo");
		assertSame(iterable, method.invoke(instance, "Foo"));
		assertTrue(iterable instanceof ArrayList);
		assertEquals(newArrayList("Foo", "Foo"), newArrayList(iterable));
	}
	
	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=362868
	 */
	@Test public void testCreateExtension_Bug362868() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y", 
				"package x " +
				"import java.util.List " +
				"import java.util.ArrayList " +
				"class Y {" +
				"  def List<String> newArrayList() {\n" +
				"    return new ArrayList<String>()\n" +
				"  }\n" +
				"  def Iterable<String> create this.newArrayList listWith(String s) {" +
				"   it.add(s)\n" +
				"   add(s)\n" +
				"  }" +
				"}");
		Object instance = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("listWith", String.class);
		@SuppressWarnings("unchecked")
		Iterable<String> iterable = (Iterable<String>) method.invoke(instance, "Foo");
		assertSame(iterable, method.invoke(instance, "Foo"));
		assertTrue(iterable instanceof ArrayList);
		assertEquals(newArrayList("Foo", "Foo"), newArrayList(iterable));
	}
	
	@Test public void testCreateExtension_Bug362868_1() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y", 
				"package x " +
				"import java.util.List " +
				"class Y {" +
				"  def Iterable<String> create list listWith(List<String> list) {" +
				"  }" +
				"}");
		Object instance = clazz.newInstance();
		Method method = clazz.getDeclaredMethod("listWith", List.class);
		@SuppressWarnings("unchecked")
		Iterable<String> iterable = (Iterable<String>) method.invoke(instance, newArrayList("Foo"));
		assertSame(iterable, method.invoke(instance, newArrayList("Foo")));
		assertTrue(iterable instanceof ArrayList);
		assertEquals(newArrayList("Foo"), newArrayList(iterable));
	}

	@Test public void testCreateExtension_threadSafety() throws Exception {
		String xtendCode = 
			"package x " +
			"class Y {" +
			"  def create result: {Thread::sleep(10) new StringBuilder()} aBuilder(String x) throws InterruptedException {" +
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
	
	@Test public void testInferredReturnType() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y", 
				"package x " +
				"class Y {" +
				"  def int a() {" +
				"   b()" +
				"  }" +
				"  " +
				"  def b() {" +
				"    c()" +
				"  }" +
				"  " +
				"  def c() {" +
				"    2" +
				"  }" +
		"}");
		assertEquals(2, apply(clazz, "a"));
	}
	
	@Test public void testSugarForLocalExtensions_01() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				" def operator_plus(int x, String s) {" +
				"   x.toString + s" +
				" }" +
				"" +
				" def test() {" +
				"    return 42 + 'foo'" +
				" }" +
				"}");
		assertEquals("42foo",apply(class1,"test"));
	}
	
	@Test public void testSugarForLocalExtensions_02() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				" def getSize(String s) {" +
				"   s.length" +
				" }" +
				"" +
				" def test() {" +
				"    return 'foo'.size" +
				" }" +
				"}");
		assertEquals(3,apply(class1,"test"));
	}
	
	@Test public void testStaticExtensionMethod_01() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y","package x import static extension java.util.Collections.* class Y { def foo() {'foo'.singleton()}}");
		assertEquals(singleton("foo"),apply(class1,"foo"));
	}
	
	@Test public void testStaticExtensionMethod_02() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"import static extension java.util.Collections.* " +
				"class Y { " +
				" def foo() {" +
				"   'foo'.singleton" +
				" }" +
				"}");
		assertEquals(singleton("foo"),apply(class1,"foo"));
	}
	
	@Test public void testImportNestedTypes_01() throws Exception {
		String code = 
				"package x " +
				"import java.util.Map$Entry " +
				"import java.util.Map " +
				"class Z { " +
				" def foo(Map$Entry e1, Entry e2, Map m) {" +
				" }" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testImportNestedTypes_02() throws Exception {
		String code = 
				"package x " +
				"import java.util.Map.Entry " +
				"import java.util.Map " +
				"class Z { " +
				" def foo(Map$Entry e1, Entry e2, Map m) {" +
				" }" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	

	@Test public void testImportNestedTypes_03() throws Exception {
		String code = 
				"package x " +
				"import java.util.Map.Entry " +
				"import java.util.Map " +
				"class Z { " +
				" def foo(Map.Entry e1, Entry e2, Map m) {" +
				" }" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	

	@Test public void testImportNestedTypes_04() throws Exception {
		String code = 
				"package x " +
				"import java.util.Map$Entry " +
				"import java.util.Map " +
				"class Z { " +
				" def foo(Map.Entry e1, Entry e2, Map m) {" +
				" }" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	@Test public void testInjectedExtensionMethod_01() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @com.google.inject.Inject extension test.GenericExtensionMethods<String,Integer> x" +
				"  " +
				"  def foo(String arg) { " +
				"    arg.method " +
				"    42.method" +
				"    return x.result" +
				"  }" +
				"}");
		assertEquals(newArrayList("method(A)","method(B)"), apply(class1,"foo","foo"));
	}
	
	@Test public void testInjectedExtensionMethod_02() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @com.google.inject.Inject extension test.ExtensionMethods e" +
				"  " +
				"  def foo(String arg) { " +
				"    (arg as CharSequence).generic()" +
				"  }" +
				"}");
		assertEquals(ExtensionMethods.GENERIC_T, apply(class1,"foo","x"));
	}
	
	@Test public void testInjectedExtensionMethod_03() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @com.google.inject.Inject extension test.ExtensionMethods e" +
				"  " +
				"  def foo(String arg) { " +
				"    arg.generic()" +
				"  }" +
				"}");
		assertEquals(ExtensionMethods.GENERIC_STRING, apply(class1,"foo","x"));
	}
	
	@Test public void testInjectedExtensionMethod_04() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @com.google.inject.Inject extension test.ExtensionMethods e" +
				"  def foo(String arg) { " +
				"    return arg - 'bar' " +
				"  } " +
				"}");
		assertEquals("operator_minus(String,String)",apply(class1,"foo","foobar"));
	}
	
	@Test public void testInjectedExtensionMethod_05() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y","package x class Y { @com.google.inject.Inject extension test.ExtensionMethods e def foo(String arg) { return arg.operator_minus('bar') } }");
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_STRING,apply(class1,"foo", "foobar"));
	}
	
	@Test public void testInjectedExtensionMethod_06() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @com.google.inject.Inject extension test.ExtensionMethods e" +
				"  def a(String arg) { " +
				"    return arg.operator_minus('bar') " +
				"  } " +
				"  def b(String arg) { " +
				"    return (arg as Object).operator_minus('bar') " +
				"  } " +
				"  def c(String arg) { " +
				"    return arg.operator_minus('bar' as Object) " +
				"  } " +
				"  def d(String arg) { " +
				"    return arg.operator_minus('bar' as CharSequence) " +
				"  } " +
				"}");
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_STRING,apply(class1,"a", "foo"));
		assertEquals(ExtensionMethods.OPERATOR_MINUS_OBJECT_STRING,apply(class1,"b", "foo"));
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_OBJECT,apply(class1,"c", "foo"));
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_CHARSEQUENCE,apply(class1,"d", "foo"));
	}
	
	@Test public void testInjectedExtensionMethod_07() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @com.google.inject.Inject extension test.ExtensionMethods" +
				"  " +
				"  def foo(String arg) { " +
				"    (arg as CharSequence).generic()" +
				"  }" +
				"}");
		assertEquals(ExtensionMethods.GENERIC_T, apply(class1,"foo","x"));
	}
	
	@Test public void testInjectedExtensionMethod_08() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @com.google.inject.Inject extension test.ExtensionMethods" +
				"  " +
				"  def foo(String arg) { " +
				"    arg.generic()" +
				"  }" +
				"}");
		assertEquals(ExtensionMethods.GENERIC_STRING, apply(class1,"foo","x"));
	}
	
	@Test public void testInjectedExtensionMethod_09() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @com.google.inject.Inject extension test.ExtensionMethods" +
				"  def foo(String arg) { " +
				"    return arg - 'bar' " +
				"  } " +
				"}");
		assertEquals("operator_minus(String,String)",apply(class1,"foo","foobar"));
	}
	
	@Test public void testInjectedExtensionMethod_10() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y","package x class Y { @com.google.inject.Inject extension test.ExtensionMethods def foo(String arg) { return arg.operator_minus('bar') } }");
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_STRING,apply(class1,"foo", "foobar"));
	}
	
	@Test public void testInjectedExtensionMethod_11() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y",
				"package x " +
				"class Y { " +
				"  @com.google.inject.Inject extension test.ExtensionMethods" +
				"  def a(String arg) { " +
				"    return arg.operator_minus('bar') " +
				"  } " +
				"  def b(String arg) { " +
				"    return (arg as Object).operator_minus('bar') " +
				"  } " +
				"  def c(String arg) { " +
				"    return arg.operator_minus('bar' as Object) " +
				"  } " +
				"  def d(String arg) { " +
				"    return arg.operator_minus('bar' as CharSequence) " +
				"  } " +
				"}");
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_STRING,apply(class1,"a", "foo"));
		assertEquals(ExtensionMethods.OPERATOR_MINUS_OBJECT_STRING,apply(class1,"b", "foo"));
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_OBJECT,apply(class1,"c", "foo"));
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_CHARSEQUENCE,apply(class1,"d", "foo"));
	}
	
	@Test public void testExtensionMethodForLocalFunctions_00() throws Exception {
		invokeAndExpect2("foobar", "def with(String x, String y) { x+y} def main(String x) { x.with('bar')}", "main", "foo"); 
	}
	
	@Test public void testClosureReturnsVoid() throws Exception {
		invokeAndExpect2(null, 
				"def foo() { " +
				"  [|{}].apply" +
				"}", "foo"); 
	}
	
	@Test public void testDependencyDeclaration() throws Exception {
		invokeAndExpect2(Boolean.TRUE, "def check() {obj!=null} @com.google.inject.Inject test.ExtensionMethods obj", "check");
	}
	
	@Test public void testReturnTypeAndReturnExpression_00() throws Exception {
		String decl = 
			"def String test() {" +
			"  return 'foo'" +
			"}";
		invokeAndExpect2("foo", decl, "test");
	}
	
	@Test public void testReturnTypeAndReturnExpression_01() throws Exception {
		String decl = 
			"def CharSequence test() {" +
			"  if ('foo' == 'foo') {" +
			"    return 'foo'" +
			"  }" +
			"}";
		invokeAndExpect2("foo", decl, "test");
	}
	
	@Test public void testNoArgFunction() throws Exception {
		invokeAndExpect("foo", "'foo'");
	}
	@Test public void testOneArgFunction() throws Exception {
		invokeAndExpect("foobar", "'foo'+p1","bar");
	}
	@Test public void testTwoArgFunction() throws Exception {
		invokeAndExpect("foo", "if (p2) 'foo' else p1 ","bar",true);
	}

	@Test public void testTwoArgFunction_01() throws Exception {
		invokeAndExpect("bar", "if (p2) 'foo' else p1 ","bar",false);
	}
	
	@Test public void testDispatchFunction_00() throws Exception {
		final String definition = "x(p1)} def dispatch x(String s) {'string'} def dispatch x(Object o) {'object'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("object", definition,42);
	}
	
	@Test public void testDispatchFunction_01() throws Exception {
		final String definition = "x(p1)} " +
				"def  dispatch x(Comparable<Boolean> s) {'comparable'}" +
				"def  dispatch x(String s) {'string'}" +
				"def  dispatch x(CharSequence o) {'charSeq'}" +
				"def  dispatch x(Integer o) {'integer'";
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
	
	@Test public void testDispatchFunction_02() throws Exception {
		final String definition = "x(p1 as String)}" +
				"def  dispatch x(Void s) {'null'}" +
				"def  dispatch x(String s) {'string'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("null", definition,new Object[]{null});
	}
	
	@Test public void testImportsAndExtensions_01() throws Exception {
		final String definition = "x(p1 as String)}" +
				"def  dispatch x(Void s) {'null'}" +
				"def  dispatch x(String s) {'string'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("null", definition, new Object[]{null});
	}

	@Test public void testDispatchFunction_03() throws Exception {
		final String definition = "doIt(p1) }" +
				" def dispatch doIt(org.eclipse.emf.ecore.EStructuralFeature x) { typeof(org.eclipse.emf.ecore.EStructuralFeature) }\n" + 
				" def dispatch doIt(org.eclipse.emf.ecore.EReference x) { typeof(org.eclipse.emf.ecore.EReference) }\n" + 
				" def dispatch doIt(org.eclipse.emf.ecore.EAttribute x) { typeof(org.eclipse.emf.ecore.EAttribute) }\n" + 
				" def dispatch doIt(org.eclipse.emf.ecore.ETypedElement x) { typeof(org.eclipse.emf.ecore.ETypedElement) ";
		invokeAndExpect(EReference.class, definition,XtendPackage.Literals.RICH_STRING_ELSE_IF__IF);
		invokeAndExpect(EAttribute.class, definition,XtendPackage.Literals.XTEND_FILE__PACKAGE);
		invokeAndExpect(ETypedElement.class, definition,EcoreFactory.eINSTANCE.createEOperation());
	}
	
	@Test public void testDispatchFunction_04() throws Exception {
		final String definition = "x(p1)}" +
		" def dispatch x(int s) {'int'}" +
		" def dispatch x(boolean s) {'boolean'}" +
		" def dispatch x(double s) {'double'";
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

	@Test public void testDispatchFunction_06() throws Exception {
		final String definition = "foo(p1)} " +
				"def dispatch foo (String string) {\n" + 
				"    string + string\n" + 
				"}\n" + 
				"def dispatch foo (Object o) {\n" + 
				"    null\n";
		invokeAndExpect("zonkzonk", definition, "zonk");
		invokeAndExpect(null, definition, Integer.valueOf(1));
	}
	
	@Test public void testDispatchFunction_07() throws Exception {
		final String definition = 
				"def invokeMe(String p1) { foo(p1) }\n" +
				"def dispatch foo (String string) {\n" + 
				"    string + string\n" + 
				"}\n" + 
				"def dispatch foo (Void nullCase) {\n" + 
				"    'literal'\n" +
				"}";
		invokeAndExpect2("zonkzonk", definition, "invokeMe", "zonk");
		invokeAndExpect3("literal", definition, "invokeMe", new Class[] { String.class }, new Object[]{ null });
	}
	
	@Test public void testDispatchFunction_08() throws Exception {
		final String definition = "foo(p1)} " +
			"def dispatch String foo(String string) {\n" + 
			"    string + string\n" + 
			"}\n" + 
			"def String foo(Object x) {\n" + 
			"    'literal'\n";
		invokeAndExpect("zonkzonk", definition, "zonk");
	}
	
	@Test public void testGenericFunction_01() throws Exception {
		final String definition = 
			"def test(String arg) {\n" + 
			"  arg.doApply(e|e+arg);\n" + 
			"}\n" + 
			"\n" + 
			"def <T extends CharSequence, R> R doApply(T obj, (T)=>R fun) {\n" + 
			"  fun.apply(obj)\n" + 
			"}";
		invokeAndExpect2("foofoo", definition, "test", "foo");
	}
	
	@Test public void testGenericFunction_02() throws Exception {
		String def = 
			    "def test(String x) {" +
			    "  x.init(e|{})" +
			    "}" +
			    "def <T> T init(T obj, (T)=>Void function) {\n" + 
				"  function.apply(obj)\n" + 
				"  return obj\n" + 
				"}";
		invokeAndExpect2("foo", def, "test", "foo");
	}
	
	@Test public void testFunctionCall_00() throws Exception {
		invokeAndExpect("foobar", "bar(p1)} def bar(String x) {'foo'+x","bar");
	}
	
	@Test public void testBug342134() throws Exception {
		List<String> list = newArrayList("a", "b", "c");
		invokeAndExpect2(
				list, 
				"def bug342134(java.util.ArrayList<String> strings) {\n" + 
				"    strings.map(e| newArrayList(e)).flatten.toList\n" + 
				"}", "bug342134", list);
	}
	
	@Test public void testTypeInferrence_00() throws Exception {
		compileJavaCode("Foo", "import org.eclipse.emf.ecore.EObject " +
				"class Foo { " +
				"	def Iterable<? extends EObject> test(EObject e) {" +
				"		e.eContents().map(o|test(o)).flatten()" +
				"	}" +
				"}");
	}
	
	@Test public void testDispatchTypes() throws Exception {
		compileJavaCode("Dispatch", "class Dispatch { " +
				 "  def dispatch doSomething(int i) { i.toString() } " +
				 "  def dispatch doSomething(Object o) { null } " +
				 "}");
	}
	
	@Test public void testBug343090_1() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343090(Integer a, Integer b) {\n" + 
				"    addFunction.apply(a, b)\n" + 
				"}\n" +
				"def addFunction() {\n" + 
				"    [Integer a, Integer b|a+b] as (Integer,Integer)=>Integer\n" + 
				"}", "bug343090", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	@Test public void testBug343090_2() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343090(Integer a, Integer b) {\n" + 
				"    <Integer>addFunction.apply(a, b)\n" + 
				"}\n" +
				"def <T extends Integer> addFunction() {\n" + 
				"    [T a,T b|a+b] as (T,T)=>T\n" + 
				"}", "bug343090", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	@Test public void testBug343090_3() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343090(Integer a, Integer b) {\n" + 
				"    addFunction.apply(a, b)\n" + 
				"}\n" +
				"def <T extends Integer> addFunction() {\n" + 
				"    [T a,T b|a+b] as (T,T)=>T\n" + 
				"}", "bug343090", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	@Test public void testBug343090_4() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343090(Integer a, Integer b) {\n" + 
				"    <Integer>addFunction.apply(a, b)\n" + 
				"}\n" +
				"def <T extends Integer> addFunction() {\n" + 
				"    [T a,T b|(a+b) as Integer] as (T,T)=>T\n" + 
				"}", "bug343090", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	@Test public void testBug343090_5() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343090(Integer a, Integer b) {\n" + 
				"    <Integer>addFunction.apply(a, b)\n" + 
				"}\n" +
				"def <T extends Integer> addFunction() {\n" + 
				"    [T a,T b|(a+b) as T] as (T,T)=>T\n" + 
				"}", "bug343090", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	@Test public void testBug343088_1() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343088(Integer a, Integer b) {\n" + 
				"    addFunction.apply(a, b)\n" + 
				"}\n" +
				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
				"    [T a,T b|(a+(b as Integer)) as T]\n" + 
				"}", "bug343088", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	@Test public void testBug343088_2() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343088(Integer a, Integer b) {\n" + 
				"    addFunction.apply(a, b)\n" + 
				"}\n" +
				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
				"    [T a,T b|(a+b) as T]\n" + 
				"}", "bug343088", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	@Test public void testNullSafeOperatorWithExtension() throws Exception {
		invokeAndExpect2(
				newArrayList(null,null,"foo"), 
				"def myExtension(String s) { 'foo' } " +
				"def nullSafeTest() {\n" + 
				"    newArrayList((null as String)?.myExtension, (null as String)?.myExtension(), 'test'?.myExtension)\n" + 
				"}\n", "nullSafeTest");
	}
	
	@Test public void testBug358418_01() throws Exception {
		invokeAndExpect3(
				Lists.<Object>newArrayList(), 
				"def <T> Iterable<T> nullSafe(Iterable<T> elements) {\n" + 
				"  if (elements == null)\n" + 
				"    newArrayList\n" + 
				"  else\n" + 
				"    elements\n" + 
				"}","nullSafe", new Class[] { Iterable.class },  new Object[] { null });
	}
	
	@Test public void testBug358418_02() throws Exception {
		invokeAndExpect3(
				Lists.newArrayList("a", "b"), 
				"def <T> Iterable<T> nullSafe(Iterable<T> elements) {\n" + 
				"  if (elements == null)\n" + 
				"    newArrayList\n" + 
				"  else\n" + 
				"    elements\n" + 
				"}", "nullSafe", new Class[] { Iterable.class }, Lists.newArrayList("a", "b"));
	}
	
	@Test public void testBug342274() throws Exception {
		invokeAndExpect2(
				null, 
				"def void castNull() {\n" + 
				"  var raw = null as Iterable\n" + 
				"  var strings = null as Iterable<String>\n" +
				"  var Iterable assignStringsToRaw = null as Iterable<String>\n" +
				"  var Iterable<String> assignRawToStrings = null as Iterable\n" +
				"  var Iterable assignRawToRaw = null as Iterable\n" +
				"  var Iterable<String> assignStringsToStrings = null as Iterable<String>\n" +
				"  if (raw != strings)\n" +
				"    throw new IllegalStateException()\n" + 
				"}", "castNull");
	}
	
	@Test
	public void testBug343096_01() throws Exception {
		compileJavaCode("x.Y",
				"package x class Y {" +
				"def <T> bug343096() {\n" + 
				"  [T t|switch t {\n" + 
				"    case t : bug343096\n" + 
				"  }]" + 
				"}}");
	}
	
	@Test
	public void testBug343096_02() throws Exception {
		invokeAndExpect2(
				Functions.Function1.class.getCanonicalName(),
				"def <T> bug343096() {\n" + 
				"  [T t|switch t {\n" + 
				"    case t : bug343096\n" + 
				"  }].getClass.interfaces.head.canonicalName" + 
				"}", "bug343096");
	}
	
	@Test
	public void testBug343096_03() throws Exception {
		invokeAndExpect2(
				Object.class.getCanonicalName(),
				"def <T> bug343096() {\n" + 
				"  [T t|switch t {\n" + 
				"    case t : bug343096\n" + 
				"  }].getClass.superclass.canonicalName" + 
				"}", "bug343096");
	}
	
	@Test public void testBug345373_01() throws Exception {
		invokeAndExpect3(
				"string", 
				"def String rawListGet(java.util.List elements) {\n" + 
				"  if (elements.get(0) instanceof String) {\n" + 
				"    'string'\n" + 
				"  } else {" +
				"    'no string'" +
				"  }" +
				"}", "rawListGet", new Class[] { List.class }, Collections.singletonList("String"));
	}
	
	@Test public void testBug345373_02() throws Exception {
		invokeAndExpect3(
				"no string", 
				"def String rawListGet(java.util.List elements) {\n" + 
				"  if (elements.get(0) instanceof String) {\n" + 
				"    'string'\n" + 
				"  } else {" +
				"    'no string'" +
				"  }" +
				"}", "rawListGet", new Class[] { List.class }, Collections.singletonList(Integer.valueOf(1)));
	}
	
	@Test public void testBug346763_01() throws Exception {
//		List<? extends String> strings = null;
//		IterableExtensions.forEach(strings, (Functions.Function1<String, Void>) null);
		invokeAndExpect2(
				null, 
				"def void wildcardExtends() {\n" + 
				"  var java.util.List<? extends String> v = null\n" + 
				"  v = newArrayList('')\n" + 
				"  if (v != null) v.forEach(e|e.toUpperCase)\n" +
				"}", "wildcardExtends");
	}
	
	@Test public void testBug346763_02() throws Exception {
		invokeAndExpect2(
				null, 
				"def void inferStringParam() {\n" + 
				"  var java.util.List<? extends String> v = null\n" + 
				"  v = newArrayList\n" + 
				"  v = new java.util.ArrayList()\n" + 
				"}", "inferStringParam");
	}
	
	@Test public void testBug346763_03() throws Exception {
//		class X {
//			java.util.List<String> wildcardExtends() {
//				java.util.List<String> v = new java.util.ArrayList<String>();
//				v.add("a");
//				java.util.List<? extends String> v2 = v;
//				return ListExtensions.map(v2, null);
//			}
//		}
		invokeAndExpect2(
				Collections.singletonList("A"), 
				"def java.util.List<String> wildcardExtends() {\n" + 
				"  var java.util.List<String> v = new java.util.ArrayList<String>();\n" + 
				"  v.add('a');\n" + 
				"  var java.util.List<? extends String> v2 = v;\n" + 
				"  v2.map(e|e.toUpperCase)\n" +
				"}", "wildcardExtends");
	}
	
	@Test public void testBug346763_04() throws Exception {
//		List<? extends String> strings = null;
//		IterableExtensions.forEach(strings, (Functions.Function1<CharSequence, Void>) null);
		invokeAndExpect2(
				null, 
				"def void wildcardExtends() {\n" + 
				"  var java.util.List<? extends String> v = null\n" + 
				"  if (v != null) v.forEach(CharSequence e|e.length)\n" +
				"}", "wildcardExtends");
	}
	
	@Test public void testBug346763_05() throws Exception {
//		List<? extends String> strings = null;
//		IterableExtensions.forEach(strings, (Functions.Function1<CharSequence, Void>) null);
		invokeAndExpect2(
				null, 
				"def void forEachString() {\n" + 
				"  var java.util.List<String> v = null\n" + 
				"  if (v != null) v.forEach(CharSequence e|e.length)\n" +
				"}", "forEachString");
	}
	
	@Test public void testBug346763_06() throws Exception {
//		List<? extends String> strings = null;
//		IterableExtensions.forEach(strings, (Functions.Function1<CharSequence, Void>) null);
		invokeAndExpect2(
				null, 
				"def void forEachString() {\n" + 
				"  var java.util.List<String> v = null\n" + 
				"  if (v != null) v.forEach(e|e.toUpperCase)\n" +
				"}", "forEachString");
	}
	
	@Test
	public void testBug346763_07() throws Exception {
//		class X {
//			java.util.List<String> wildcardSuper() {
//				java.util.List<String> v = new java.util.ArrayList<String>();
//				v.add("a");
//				java.util.List<? super String> v2 = v;
//				Function1<Object,String> fun = null;
//				return ListExtensions.map(v2, fun);
//			}
//		}
		invokeAndExpect2(
				Collections.singletonList("A"), 
				"def java.util.List<String> wildcardSuper() {\n" + 
				"  var java.util.List<String> v = new java.util.ArrayList();\n" + 
				"  v.add('a');\n" + 
				"  var java.util.List<? super String> v2 = v;\n" + 
				"  v2.map(e|e.toString.toUpperCase)\n" +
				"}", "wildcardSuper");
	}
	
	@Test public void testBug358118_NoNPE() throws Exception {
		invokeAndExpect2(
				null, 
				"def dispatch void recursiveMethod(CharSequence r, java.util.Set<Object> shapes) {}\n" + 
				"def dispatch void recursiveMethod(Appendable c, java.util.Set<Object> shapes) {\n" + 
				"	// If method2 is called directly, no NPE is thrown\n" + 
				"	val Object o = method1()\n" + 
				"}\n" + 
				"def Object method1() {\n" + 
				"	return method2()\n" + 
				"}\n" + 
				"// Inferred return type that causes the NPE\n" + 
				"def method2() {\n" + 
				"	val java.util.Set<Object> objects = newHashSet()\n" + 
				"	// If the recursive method is not called, no NPE is thrown\n" + 
				"	recursiveMethod(new String(), objects)\n" + 
				"	return objects.findFirst([ Object o | o instanceof CharSequence])\n" + 
				"}", "method1");
	}
	
	@Test public void testBug355848() throws Exception {
		invokeAndExpect2(
				Integer.valueOf(1), 
				"def closureWithPrimitives() {\n" + 
				"    val (int)=>int sum = [a|a]\n" +
				"    sum.apply(1)" + 
				"}", "closureWithPrimitives");
	}
	
	@Test public void testBug356742_01() throws Exception {
		invokeAndExpect2(
				"logInfo(a)", 
				"@com.google.inject.Inject extension testdata.ClassWithVarArgs classWithVarArgs\n" + 
				"\n" +
				"def doLog() {" + 
				"    classWithVarArgs.logInfo('a')\n" +
				"}", "doLog");
	}
	
	@Test public void testBug356742_02() throws Exception {
		invokeAndExpect2(
				"logInfo(a, args...)", 
				"@com.google.inject.Inject extension testdata.ClassWithVarArgs classWithVarArgs\n" + 
				"\n" +
				"def doLog() {" + 
				"    classWithVarArgs.logInfo('a', 'b')\n" +
				"}", "doLog");
	}
	
	@Test public void testBug356742_03() throws Exception {
		invokeAndExpect2(
				"logInfo(a, args...)", 
				"@com.google.inject.Inject extension testdata.ClassWithVarArgs\n" + 
				"\n" +
				"def doLog() {" + 
				"    'a'.logInfo('b')\n" +
				"}", "doLog");
	}
	
	@Test public void testBug356742_04() throws Exception {
		invokeAndExpect2(
				"logInfo(a)", 
				"@com.google.inject.Inject extension testdata.ClassWithVarArgs\n" + 
				"\n" +
				"def doLog() {" + 
				"    'a'.logInfo()\n" +
				"}", "doLog");
	}
	
	@Test public void testOperationParameterOnScope() throws Exception {
		String code =
				"package foo " + 
				"class Bar {" +
				"  def foo(int bar) {" +
				"    switch(bar) {" +
				"      case 1: 'bar'" + 
				"    }"+
				"  }"+
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("foo.Bar", javaCode);
	}
	
	@Test public void testArrayConversion_01() throws Exception {
		int[] expected = new int[] { 1, 2, 3 };
		Object wrappedArray = Conversions.doWrapArray(expected);
		invokeAndExpect3(
				expected, 
				"def int[] unpackArray(Iterable<Integer> iterable) {" + 
				"    return iterable\n" +
				"}", "unpackArray", new Class[] { Iterable.class }, wrappedArray);
	}
	
	@Test public void testArrayConversion_02() throws Exception {
		int[] expected = new int[] { 1, 2, 3 };
		String classBody = 
				"def int[] unpackArray(Iterable<Integer> iterable) {" + 
				"    return iterable\n" +
				"}";
		
		Class<?> class1 = compileJavaCode("x.Y", "package x class Y {" + classBody + "}");
		Object result = applyImpl(class1, "unpackArray", new Class[] { Iterable.class }, Lists.newArrayList(1, 2, 3));
		assertTrue(result instanceof int[]);
		assertTrue(Arrays.toString((int[]) result) + "!=" + Arrays.toString(expected), Arrays.equals(expected, (int[]) result));
	}
	
	@Test public void testArrayConversion_03() throws Exception {
		String code =
				"package foo " + 
				"class Bar extends testdata.ArrayClient {" +
				"  override toStringArray(String s1, String s2) {" +
				"    newArrayList(s1, s2)"+
				"  }"+
				"}";
		Class<?> class1 = compileJavaCode("foo.Bar", code);
		Object result = applyImpl(class1, "toStringArray", new Class[] { String.class, String.class }, "a", "b");
		assertTrue(result instanceof String[]);
		assertEquals(Lists.newArrayList("a", "b"), Arrays.asList((String[])result));
	}
	
	@Test public void testImplictFirstArgument_01() throws Exception {
		invokeAndExpect2(
				"Hello World", 
				"def prependHello(String myString) {\n" + 
				"  'Hello '+myString\n" + 
				"}\n" + 
				"def testExtensionMethods(String it) {\n" + 
				"  prependHello\n" + 
				"}", 
				"testExtensionMethods", 
				"World");
	}
	
	@Test public void testImplictFirstArgument_02() throws Exception {
		String code =
				"package foo " + 
				"class Bar {\n" +
				"  @com.google.inject.Inject\n" +
				"  extension test.SampleBuilder" +
				"  def createRoot(String first, String second, String third) {" +
				"    root [" +
				"      name = first" +
				"      parent [" +
				"        name = second" +
				"        child [" +
				"          name = third" +
				"        ]" +
				"      ]\n" +
				"    ]"+
				"  }"+
				"}";
		Class<?> class1 = compileJavaCode("foo.Bar", code);
		Object result = applyImpl(class1, "createRoot", new Class[] { String.class, String.class, String.class }, "a", "b", "c");
		assertTrue(result instanceof SampleBuilder.Root);
		SampleBuilder.Root root = (SampleBuilder.Root) result;
		assertEquals("a", root.name);
		assertEquals("b", root.parent.name);
		assertEquals("c", root.parent.child.name);
	}
	
	@Test public void testImplictFirstArgument_03() throws Exception {
		String code =
				"package foo " +
				"import static extension test.SampleBuilder.*" + 
				"class Bar {\n" +
				"  def createRoot(String first, String second, String third) {" +
				"    staticRoot [" +
				"      name = first" +
				"      staticParent [" +
				"        name = second" +
				"        staticChild [" +
				"          name = third" +
				"        ]" +
				"      ]\n" +
				"    ]"+
				"  }"+
				"}";
		Class<?> class1 = compileJavaCode("foo.Bar", code);
		Object result = applyImpl(class1, "createRoot", new Class[] { String.class, String.class, String.class }, "a", "b", "c");
		assertTrue(result instanceof SampleBuilder.Root);
		SampleBuilder.Root root = (SampleBuilder.Root) result;
		assertEquals("a", root.name);
		assertEquals("b", root.parent.name);
		assertEquals("c", root.parent.child.name);
	}
	
	@Test public void testBug361539_01() throws Exception {
		invokeAndExpect2(
				Boolean.TRUE, 
				"def addHelloWorld(String myString) {\n" + 
				"  myString.foos += 'Hello World'\n" + 
				"}\n" + 
				"def getFoos(String key) {\n" + 
				"  if (key == 'zonk') newArrayList(key) \n" + 
				"}", 
				"addHelloWorld", 
				"zonk");
	}
	
	@Test public void testBug361539_02() throws Exception {
		invokeAndExpect2(
				Boolean.TRUE, 
				"def addHelloWorld(String it) {\n" + 
				"  foos += 'Hello World'\n" + 
				"}\n" + 
				"def getFoos(String key) {\n" + 
				"  if (key == 'zonk') newArrayList(key) \n" + 
				"}", 
				"addHelloWorld", 
				"zonk");
	}
	
	@Test public void testAssignmentWithExtension_01() throws Exception {
		invokeAndExpect2(
				"Hello World", 
				"def doStuff(String it, String addMe) {\n" + 
				"  things=addMe\n" + 
				"}\n" + 
				"def setThings(String left, String right) {\n" + 
				"  left + ' ' + right\n" + 
				"}", 
				"doStuff", 
				"Hello", "World");
	}
	
	@Test public void testThrowsDeclaration() throws Exception {
		try {
			invokeAndExpect2(null, "def foo() throws NoSuchFieldException { throw new NoSuchFieldException(\"foo\") }", "foo");
		} catch(InvocationTargetException e) {
			assertTrue(e.getCause() instanceof NoSuchFieldException);
			assertEquals("foo", e.getCause().getMessage());
			return;
		}
		fail("Expected NoSuchFieldException not thrown");
	}
	
	@Test public void testRichStringAndSwitch() throws Exception {
		invokeAndExpect2(
				"foo", 
				"def x() { " +
				"	runTest().toString() " +
				"} " +
				"def runTest() '''«switch x : '''test''' { CharSequence : '''foo''' }»'''", 
				"x");
	}
	
	@Test public void testBug366293() throws Exception {
		invokeAndExpect2("success", 
				"def String whileLoopTest () {\n" + 
				"        while (true)\n" + 
				"            try {\n" + 
				"                return 'success'\n" + 
				"            }\n" + 
				"            catch (Exception ex)\n" + 
				"            {\n" + 
				"                throw ex\n" + 
				"            }    \n" +
				"		 return 'failure'" + 
				"    }", "whileLoopTest");
	}
	
	@Test public void testBug366293_related() throws Exception {
		invokeAndExpect2("success", 
				"def String whileLoopTest () {\n" + 
				"  do {\n" + 
				"    try {\n" + 
				"      toString()\n" +
				"      return 'success'\n" + 
				"    }\n" + 
				"    catch (Exception ex)\n" + 
				"    {\n" + 
				"      throw ex\n" + 
				"    }\n" +
				"  } while (true)" + 
				"}", "whileLoopTest");
	}
	
	@Test public void testBug366525_0() throws Exception {
		try {
			invokeAndExpect2(null, 
				"  def foo() {\n" +
				"    return { if(true) throw new Exception(\"Bug366525\") else null }\n" +
				"  }\n",
				"foo");
			fail("Expected Exception(\"Bug366525\")");
		} catch(InvocationTargetException e) {
			assertNotNull(e.getCause());
			assertEquals("Bug366525", e.getCause().getMessage());
		}
	}

	@Test public void testBug366525_1() throws Exception {
		try {
			String javaCode = compileToJavaCode("class Foo {\n" +
					"  def foo() {\n" +
					"    return { if(true) throw new Exception(\"Bug366525\") else null }\n" +
					"  }\n" +
					"}");
			assertTrue(javaCode.contains("Exceptions.sneakyThrow"));
			javaCompiler.compileToClass("Foo", javaCode);
		} catch(Exception e) {
			assertEquals("Bug366525", e.getMessage());
		}
	}

	@Test public void testBug366525_2() throws Exception {
		try {
			String javaCode = compileToJavaCode("class Foo {\n" +
					"  def foo() throws Exception {\n" +
					"    return { if(true) throw new Exception(\"Bug366525\") else null }\n" +
					"  }\n" +
					"}");
			assertFalse(javaCode.contains("Exceptions.sneakyThrow"));
			javaCompiler.compileToClass("Foo", javaCode);
		} catch(Exception e) {
			assertEquals("Bug366525", e.getMessage());
		}
	}

	@Test public void testRemoveDuplicateExceptions() throws Exception {
		Class<?> clazz = compileJavaCode("Foo", "class Foo {\n" +
				"  def dispatch foo(Object o) throws Exception {}\n" +
				"  def dispatch foo(Number m) throws Exception {}\n" +
				"}");
		Method fooMethod = clazz.getMethod("foo", Object.class);
		assertEquals(1, fooMethod.getExceptionTypes().length);
		assertEquals(Exception.class, fooMethod.getExceptionTypes()[0]);
	}
	
	@Test public void testParameterAnnotation() throws Exception {
		Class<?> clazz = compileJavaCode("Foo", "class Foo {\n" +
				"  def foo(@Deprecated Object o) {}\n" +
				"}");
		Method fooMethod = clazz.getMethod("foo", Object.class);
		assertEquals(1, fooMethod.getParameterAnnotations()[0].length);
		assertEquals(Deprecated.class, fooMethod.getParameterAnnotations()[0][0].annotationType());
	}
	
	@Inject
	protected EclipseRuntimeDependentJavaCompiler javaCompiler;

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

	@Before
	public void setUp() throws Exception {
		javaCompiler.clearClassPath();
		javaCompiler.addClassPathOfClass(getClass());
		javaCompiler.addClassPathOfClass(StringExtensions.class);
		javaCompiler.addClassPathOfClass(Notifier.class);
		javaCompiler.addClassPathOfClass(EcorePackage.class);
		javaCompiler.addClassPathOfClass(XbasePackage.class);
		javaCompiler.addClassPathOfClass(XtendPackage.class);
		javaCompiler.addClassPathOfClass(Inject.class);
		javaCompiler.addClassPathOfClass(Properties1.class);
		javaCompiler.addClassPathOfClass(Function.class);
		javaCompiler.addClassPathOfClass(StringConcatenation.class);
		javaCompiler.addClassPathOfClass(Property.class);
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
			Class<?> clazz = javaCompiler.compileToClass(clazzName, javaCode);
			return clazz;
		} catch (Exception e) {
			System.err.println(javaCode);
			throw new RuntimeException("Java compilation failed. Java code was : \n" + javaCode, e);
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
	
	@Test public void testStaticMethod() throws Exception {
		invokeAndExpectStatic(42, "def static foo() { 42 }", "foo");
	}
	
	@Test public void testStaticMethodStaticCall() throws Exception {
		invokeAndExpectStatic(43, "def static foo() { bar() + 1 } def static bar() { 42 }", "foo");
	}
	
	@Test public void testStaticMethodDynamicCall() throws Exception {
		invokeAndExpect2(43, "def foo() { bar + 1 } def static bar() { 42 }", "foo");
	}
	
	@Test public void testStaticFieldStaticCall() throws Exception {
		invokeAndExpectStatic(42, "static int bar def static foo() { bar = 42; bar }", "foo");
	}
	
	@Test public void testStaticFieldDynamicCall() throws Exception {
		invokeAndExpect2(42, "static int bar def foo() { bar = 42; bar }", "foo");
	}
	
	@Test public void testVarArgs() throws Exception {
		invokeAndExpect2("[FOO, BAR, BAZ]", 
				"def String foo() {" +
				"  foo('foo','bar','baz')" +
				"}" +
				"def String foo(String ... s) { " +
				"  s.map[toUpperCase].toString" +
				"}", "foo");
	}
	
	@Test public void testSpaceShipOperator() throws Exception {
		invokeAndExpect2("FOOBARBAZ", 
				"def String foo() {" +
				"  'foo' <=> 'bar' <=> 'baz'" +
				"}" +
				"def String operator_spaceship(String a, String b) { " +
				"  a.toUpperCase + b.toUpperCase" +
				"}", "foo");
	}
	@Test public void testDiamondOperator() throws Exception {
		invokeAndExpect2("FOOBARBAZ", 
				"def String foo() {" +
				"  'foo' <> 'bar' <> 'baz'" +
				"}" +
				"def String operator_diamond(String a, String b) { " +
				"  a.toUpperCase + b.toUpperCase" +
				"}", "foo");
	}
	
	@Test public void testTripleLessThanOperator() throws Exception {
		invokeAndExpect2("FOOBARBAZ", 
				"def String foo() {" +
				"  'foo' <<< 'bar' <<< 'baz'" +
				"}" +
				"def String operator_tripleLessThan(String a, String b) { " +
				"  a.toUpperCase + b.toUpperCase" +
				"}", "foo");
	}
	
	@Test public void testAbstractClasses_01() throws Exception {
		Class<?> code = compileJavaCode("foo.Bar", "package foo abstract class Bar {}");
		assertTrue(Modifier.isAbstract(code.getModifiers()));
	}
	
	@Test public void testAbstractClasses_02() throws Exception {
		Class<?> code = compileJavaCode("foo.Bar", "package foo abstract class Bar { def String foo() }");
		assertTrue(Modifier.isAbstract(code.getModifiers()));
		Method method = code.getDeclaredMethod("foo");
		assertTrue(Modifier.isAbstract(method.getModifiers()));
	}
	
	@Test public void testProperty() throws Exception {
		Class<?> code = compileJavaCode("foo.Bar", "package foo class Bar { @Property val String myField = 'hello'}");
		final Method declaredMethod = code.getDeclaredMethod("getMyField");
		assertNotNull(declaredMethod);
		assertEquals("hello", declaredMethod.invoke(code.newInstance()));
		try {
			code.getDeclaredMethod("setMyField", new Class<?>[]{ String.class});
		} catch (NoSuchMethodException e ) {
			// expected
		}
	}
	
	@Test public void testProperty_01() throws Exception {
		Class<?> code = compileJavaCode("foo.Bar", "package foo class Bar { @Property var String myField = 'hello' def String getMyField() { _myField.toUpperCase } }");
		Method getter = code.getDeclaredMethod("getMyField");
		Object newInstance = code.newInstance();
		assertEquals("HELLO", getter.invoke(newInstance));
		Method setter = code.getDeclaredMethod("setMyField", new Class<?>[]{ String.class});
		setter.invoke(newInstance, "setterCalled");
		assertEquals("SETTERCALLED", getter.invoke(newInstance));
	}
	
	@Test public void testData_01() throws Exception {
		Class<?> code = compileJavaCode("foo.Bar", "package foo @Data class Bar { val myField = 'hello' boolean myFlag }");
		Method getter = code.getDeclaredMethod("getMyField");
		Method isMyFlag = code.getDeclaredMethod("isMyFlag");
		Constructor<?> constructor = code.getDeclaredConstructor(new Class[]{Boolean.TYPE});
		Object newInstance = constructor.newInstance(true);
		assertEquals("hello", getter.invoke(newInstance));
		assertTrue( (Boolean) isMyFlag.invoke(newInstance));
		
		Object anotherInstance = constructor.newInstance(true);
		Object thirdInstance = constructor.newInstance(false);
		
		assertEquals(newInstance, anotherInstance);
		assertFalse(newInstance.equals(thirdInstance));
		
		assertTrue(newInstance.hashCode() == anotherInstance.hashCode());
		assertFalse(newInstance.hashCode() == thirdInstance.hashCode());
	}
	
	@Test public void testData_02() throws Exception {
		Class<?> code = compileJavaCode("foo.Bar", "package foo @Data class Bar extends test.BasicDataClass { val myField = 'hello' boolean myFlag }");
		Method getter = code.getDeclaredMethod("getMyField");
		Method isMyFlag = code.getDeclaredMethod("isMyFlag");
		Constructor<?> constructor = code.getDeclaredConstructor(new Class[]{String.class, Boolean.TYPE});
		Object newInstance = constructor.newInstance("MOIN", true);
		assertEquals("hello", getter.invoke(newInstance));
		assertTrue( (Boolean) isMyFlag.invoke(newInstance));
		
		Object anotherInstance = constructor.newInstance("MOIN", true);
		Object thirdInstance = constructor.newInstance("MOIN", false);
		Object fourthInstance = constructor.newInstance("moin", true);
		
		assertEquals(newInstance, anotherInstance);
		assertFalse(newInstance.equals(thirdInstance));
		assertFalse(newInstance.equals(fourthInstance));
		
		assertTrue(newInstance.hashCode() == anotherInstance.hashCode());
		assertFalse(newInstance.hashCode() == thirdInstance.hashCode());
		assertFalse(newInstance.hashCode() == fourthInstance.hashCode());
	}
	
	@Ignore("TODO Currently there is no way to refer to computed types in the jvm model inferer")
	@Test public void testData_03() throws Exception {
		Class<?> code = compileJavaCode("foo.Bar", "package foo @Data class Bar { val myFlag = true }");
		Method isMyFlag = code.getDeclaredMethod("isMyFlag");
		Constructor<?> constructor = code.getDeclaredConstructor();
		Object newInstance = constructor.newInstance();
		assertTrue( (Boolean) isMyFlag.invoke(newInstance));
	}
	
	@Test public void testPackageScope() throws Exception {
		Class<?> code = compileJavaCode("test.Bar", "package test class Bar extends SuperClass {}");
		SuperClass sc = (SuperClass) code.newInstance();
		assertNotNull(sc);
	}

	/**
	 * StackOveflowError see https://bugs.eclipse.org/bugs/show_bug.cgi?id=362240
	 */
	@Test
	public void testGenericsBug362240_01() throws Exception {
		String code = 
				"package generics" + 
				" class Bar {" + 
				"	def <T extends (Object)=>T> T bar(T t) {" +
				" 		bar(t).apply(bar(t))" + 
				"	}" +
				"}";
		Class<?> javaCode = compileJavaCode("generics.Bar", code);
		assertNotNull("Example code does not compile to java", javaCode);
	}
	
	/**
	 * StackOveflowError see https://bugs.eclipse.org/bugs/show_bug.cgi?id=362240
	 */
	@Test
	public void testGenericsBug362240_02() throws Exception {
		String code = "package generics class Bar<T extends (Object)=>T> {" +
				"def T bar(T t) { bar(t).apply(bar(t)) } }";
		Class<?> javaCode = compileJavaCode("generics.Bar", code);
		assertNotNull("Example code does not compile to java", javaCode);
	}

	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=411973
	 */
	@Test
	public void testBug411973() throws Exception {
		String code = "package bug411973 class Bug {val ()=>String init new() { this([|\"Hello World!\"]) }"
				+ "new(()=>String init) { this.init = init } @Override override toString() { init.apply } }";
		Class<?> javaCode = compileJavaCode("bug411973.Bug", code);
		assertNotNull("Example code does not compile to java", javaCode);

		Constructor<?> constructor = javaCode.getDeclaredConstructor();
		Object newInstance = constructor.newInstance();
		Method toString = javaCode.getDeclaredMethod("toString");
		assertEquals("Hello World!", toString.invoke(newInstance));
	}

}
