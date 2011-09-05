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
import java.util.ArrayList;
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
import org.eclipse.xtext.xbase.lib.Functions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Package;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

import test.ExtensionMethods;
import testdata.Properties1;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilerTest extends AbstractXtend2TestCase {
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345458
	 */
	public void testBug_345458() throws Exception {
		String code = 
			"package x class Z {" +
			"  def create(Object x) { \n" + 
			"    if(true) {\n" + 
			"      if(true)\n" + 
			"        'foo'+'bar'\n" + 
			"      for(c : 'foo'.toCharArray)\n" + 
			"        'do'+'sideeffect'\n" + 
			"    }\n" + 
			"  }\n" +
			"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345828
	 */
	public void testBug_345828_01() throws Exception {
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
	public void testBug_345828_02() throws Exception {
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
	public void testBug_345828_03() throws Exception {
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
	public void testBug_345828_04() throws Exception {
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
	public void testBug_345828_05() throws Exception {
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
	public void testBug_345828_06() throws Exception {
		String code = 
				"package x\n" +
						"class Z {" +
						"  def <MyParam extends =>Integer> baz(java.util.List<MyParam> t) {\n" +
						"    val int i = t.<MyParam>head.apply + 1\n" +
						"    if (i == 0)\n" +
						"      t.<MyParam>head.apply + 1\n" + 
						"    t.<MyParam>head.apply + 1\n" + 
						"  }\n" +
						"}\n";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=351330
	 */
	public void testBug_351330_01() throws Exception {
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
	public void testBug_351330_02() throws Exception {
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
	public void testBug_351330_03() throws Exception {
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
	public void testBug_351330_04() throws Exception {
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
	public void testBug_351330_05() throws Exception {
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
	public void testBug_351330_06() throws Exception {
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
	public void testBug_350932_01() throws Exception {
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
	public void testBug_350932_02() throws Exception {
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
	public void testBug_350932_03() throws Exception {
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
	public void testBug_350932_04() throws Exception {
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
	public void testBug_350932_05() throws Exception {
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
	public void testBug_350932_06() throws Exception {
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
	public void testBug_350932_07() throws Exception {
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
	public void testBug_350932_08() throws Exception {
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
	public void testBug_350932_09() throws Exception {
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
	public void testBug_350932_10() throws Exception {
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
	
	public void testBug_350932_11() throws Exception {
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
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=351582
	 */
	public void testBug_351582_01() throws Exception {
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
	
	public void testBug_352705_01() throws Exception {
		String code =
				"package x class Z {" +
				"  def void forEachError(testdata.PropertiesHolder h) {\n" + 
				"    {\n" + 
				"      h.properties.forEach(p|{\n" + 
				"        p.prop1=p.prop1.toFirstLower()\n" + 
				"        true\n" + 
				"      })\n" + 
				"      h\n" + 
				"    }\n" + 
				"  }\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	public void testBug_352705_02() throws Exception {
		String code =
				"package x class Z {" +
				"  def void forEachError(testdata.PropertiesHolder h) {\n" + 
				"    h.properties.forEach(p|{\n" + 
				"      p.prop1=p.prop1.toFirstLower()\n" + 
				"      true\n" + 
				"    })\n" + 
				"    h\n" + 
				"  }\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	public void testBug_352705_03() throws Exception {
		String code =
				"package x class Z {" +
				"  def void forEachError(testdata.PropertiesHolder h) {\n" + 
				"    h.properties.map(p|{\n" + 
				"      p.prop1=p.prop1.toFirstLower()\n" + 
				"      true\n" + 
				"    })\n" + 
				"  }\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	public void testBug_352844_01() throws Exception {
		String code =
				"package x class Z {" +
				"  	def generate(java.util.List<String> d, String fsa) {\n" + 
				"		d.iter(e | e.generate(fsa))\n" + 
				"	}\n" + 
				"	\n" + 
				"	def void generate(String e, String fsa) {}\n" + 
				"	\n" + 
				"	def <T,R> iter(java.util.List<T> list, (T)=>R predicate) {\n" + 
				"		for(element : list) { predicate.apply(element); }\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	public void testBug_352844_02() throws Exception {
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
	
	public void testBug_350831_01() throws Exception {
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
	
	public void testBug_352849_01() throws Exception {
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
				"	}\n" + 
				"	def <K> Collection<K> addAll2(Collection<? super K> collection, Iterable<K> elements){\n" +
				// TODO this invocation is valid
//				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	public void testBug_352849_02() throws Exception {
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
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n" +
				// TODO this invocation is valid
//				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	public void testBug_352849_03() throws Exception {
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
				"	}\n" + 
				"	def <T> Collection<T> addAll2(Collection<T> collection, Iterable<? extends T> elements){\n" + 
				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	public void testBug_352849_04() throws Exception {
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
	
	public void testBug_352849_05() throws Exception {
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
				// TODO this invocation is valid
//				"	    collection.addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	// TODO: This one should be valid, too
	// however, the current implementation does not provide enough information
	// to compute whether a type reference is resolved or whether the expected
	// type would yield something better
	// Note: there are other todos in this file that are related to the use case
//	public void testBug_352849_06() throws Exception {
//		String code =
//				"package x\n" +
//				"import java.util.Collection\n" + 
//				"import java.util.List\n" +
//				"class Z {" +
//				"  	def generate() {\n" + 
//				"		val List<CharSequence> seq = null\n" + 
//				"		val List<String> strings = null\n" + 
//				"		val Collection<CharSequence> test = seq.addAll2(strings)\n" +
//				"	}\n" + 
//				"	def <T> Collection<T> addAll2(Collection<? super T> collection, Iterable<? extends T> elements){\n" + 
////				"	    collection.addAll(elements)\n" + 
//				"	    null\n" + 
//				"	}\n" +
//				"}";
//		String javaCode = compileToJavaCode(code);
//		System.out.println(javaCode);
//		javaCompiler.compileToClass("x.Z", javaCode);
//	}
	
//	public void testBug_352849_07() throws Exception {
//		String code =
//				"package x\n" +
//				"import java.util.Collection\n" + 
//				"import java.util.List\n" +
//				"class Z {" +
//				"  	def generate() {\n" + 
//				"		val List<CharSequence> seq = null\n" + 
//				"		val List<String> strings = null\n" + 
//				"		val result = seq.addAll2(strings)\n" + 
//				"		val Collection<String> test = result\n" + 
//				"	}\n" + 
//				"	def <K, N super K> Collection<K> addAll2(Collection<N> collection, Iterable<K> elements){\n" +
//				"	    collection.addAll(elements)\n" + 
//				"	    null\n" + 
//				"	}\n" +
//				"}";
//		String javaCode = compileToJavaCode(code);
//		javaCompiler.compileToClass("x.Z", javaCode);
//	}
	
//	public void testBug_352849_08() throws Exception {
//		String code =
//				"package x\n" +
//				"import java.util.Collection\n" + 
//				"import java.util.List\n" +
//				"class Z {" +
//				"  	def generate() {\n" + 
//				"		val List<CharSequence> seq = null\n" + 
//				"		val List<String> strings = null\n" + 
//				"		val result = seq.addAll2(strings)\n" +
//				"		val Collection<String> test = result\n" + 
//				"	}\n" + 
//				"	def <T, C super T, I extends T> Collection<T> addAll2(Collection<C> collection, Iterable<I> elements){\n" +
//				"	    collection.addAll(elements)\n" + 
//				"	    null\n" + 
//				"	}\n" +
//				"}";
//		String javaCode = compileToJavaCode(code);
//		javaCompiler.compileToClass("x.Z", javaCode);
//	}
	
	public void testBug_352849_09() throws Exception {
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
				"	}\n" + 
				"	def <T, U extends T> Collection<T> addAll2(Collection<T> collection, Iterable<U> elements){\n" +
				// TODO this invocation is valid
//				"	    collection.addAll(elements)\n" + 
				"	    collection.<T>addAll(elements)\n" + 
				"	    null\n" + 
				"	}\n" +
				"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
//	public void testBug_352849_10() throws Exception {
//		String code =
//				"package x\n" +
//				"import java.util.Collection\n" + 
//				"import java.util.List\n" +
//				"class Z {" +
//				"  	def generate() {\n" + 
//				"		val List<CharSequence> seq = null\n" + 
//				"		val List<String> strings = null\n" + 
//				"		val Collection<String> test = seq.addAll2(strings)\n" +
//				"	}\n" + 
//				"	def <T, C super T, I extends T> Collection<T> addAll2(Collection<C> collection, Iterable<I> elements){\n" +
//				"	    collection.addAll(elements)\n" + 
//				"	    null\n" + 
//				"	}\n" +
//				"}";
//		String javaCode = compileToJavaCode(code);
//		javaCompiler.compileToClass("x.Z", javaCode);
//	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=345371
	 */
	public void testVoidInTryCatchCompiles_00() throws Exception {
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
	
	public void testEscapeCharacterForReservedNames() throws Exception {
		String code = 
			"package x class Z {" +
			"  def create(Object x){\n" +
			"    create(x)" + 
			"  }\n" + 
			"}";
		String javaCode = compileToJavaCode(code);
		javaCompiler.compileToClass("x.Z", javaCode);
	}
	
	public void testRethrownCheckedExceptions_00() throws Exception {
		Class<?> clazz = compileJavaCode("x.Y",
				"package x class Y {" +
				"  def foo() {\n" +
				"    throw new java.io.IOException()" + 
				"  }\n" +
				"  def bar(){\n" +
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
				"  def dispatch foo(String x) {\n" +
				"    throw new java.io.EOFException()" + 
				"  }\n" +
				"  def dispatch foo(Object x) {\n" +
				"    throw new java.io.FileNotFoundException()" + 
				"  }\n" +
				"  def bar(){\n" +
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
	
	public void testCreateExtension_00() throws Exception {
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
	
	public void testCreateExtension_01() throws Exception {
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
	
	public void testCreateExtension_threadSafety() throws Exception {
		String xtendCode = 
			"package x " +
			"class Y {" +
			"  def create result: {Thread::sleep(10) new StringBuilder()} aBuilder(String x) {" +
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
	
	public void testSugarForLocalExtensions_01() throws Exception {
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
	
	public void testSugarForLocalExtensions_02() throws Exception {
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
	
	public void testStaticExtensionMethod_01() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y","package x import static extension java.util.Collections.* class Y { def foo() {'foo'.singleton()}}");
		assertEquals(singleton("foo"),apply(class1,"foo"));
	}
	
	public void testStaticExtensionMethod_02() throws Exception {
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
	
	public void testImportNestedTypes() throws Exception {
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
	
	public void testInjectedExtensionMethod_01() throws Exception {
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
	
	public void testInjectedExtensionMethod_02() throws Exception {
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
	
	public void testInjectedExtensionMethod_03() throws Exception {
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
	
	public void testInjectedExtensionMethod_04() throws Exception {
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
	
	public void testInjectedExtensionMethod_05() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y","package x class Y { @com.google.inject.Inject extension test.ExtensionMethods e def foo(String arg) { return arg.operator_minus('bar') } }");
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_STRING,apply(class1,"foo", "foobar"));
	}
	
	public void testInjectedExtensionMethod_06() throws Exception {
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
	
	public void testInjectedExtensionMethod_07() throws Exception {
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
	
	public void testInjectedExtensionMethod_08() throws Exception {
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
	
	public void testInjectedExtensionMethod_09() throws Exception {
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
	
	public void testInjectedExtensionMethod_10() throws Exception {
		Class<?> class1 = compileJavaCode("x.Y","package x class Y { @com.google.inject.Inject extension test.ExtensionMethods def foo(String arg) { return arg.operator_minus('bar') } }");
		assertEquals(ExtensionMethods.OPERATOR_MINUS_STRING_STRING,apply(class1,"foo", "foobar"));
	}
	
	public void testInjectedExtensionMethod_11() throws Exception {
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
	
	public void testExtensionMethodForLocalFunctions_00() throws Exception {
		invokeAndExpect2("foobar", "def with(String x, String y) { x+y} def main(String x) { x.with('bar')}", "main", "foo"); 
	}
	
	public void testClosureReturnsVoid() throws Exception {
		invokeAndExpect2(null, 
				"def foo() { " +
				"  [|{}].apply" +
				"}", "foo"); 
	}
	
	public void testDependencyDeclaration() throws Exception {
		invokeAndExpect2(Boolean.TRUE, "def check() {obj!=null} @com.google.inject.Inject test.ExtensionMethods obj", "check");
	}
	
	public void testReturnTypeAndReturnExpression_00() throws Exception {
		String decl = 
			"def String test() {" +
			"  return 'foo'" +
			"}";
		invokeAndExpect2("foo", decl, "test");
	}
	
	public void testReturnTypeAndReturnExpression_01() throws Exception {
		String decl = 
			"def CharSequence test() {" +
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
		final String definition = "x(p1)} def dispatch x(String s) {'string'} def dispatch x(Object o) {'object'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("object", definition,42);
	}
	
	public void testDispatchFunction_01() throws Exception {
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
	
	public void testDispatchFunction_02() throws Exception {
		final String definition = "x(p1 as String)}" +
				"def  dispatch x(Void s) {'null'}" +
				"def  dispatch x(String s) {'string'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("null", definition,new Object[]{null});
	}
	
	public void testImportsAndExtensions_01() throws Exception {
		final String definition = "x(p1 as String)}" +
				"def  dispatch x(Void s) {'null'}" +
				"def  dispatch x(String s) {'string'";
		invokeAndExpect("string", definition,"bar");
		invokeAndExpect("null", definition, new Object[]{null});
	}

	public void testDispatchFunction_03() throws Exception {
		final String definition = "doIt(p1) }" +
				" def dispatch doIt(org.eclipse.emf.ecore.EStructuralFeature x) { typeof(org.eclipse.emf.ecore.EStructuralFeature) }\n" + 
				" def dispatch doIt(org.eclipse.emf.ecore.EReference x) { typeof(org.eclipse.emf.ecore.EReference) }\n" + 
				" def dispatch doIt(org.eclipse.emf.ecore.EAttribute x) { typeof(org.eclipse.emf.ecore.EAttribute) }\n" + 
				" def dispatch doIt(org.eclipse.emf.ecore.ETypedElement x) { typeof(org.eclipse.emf.ecore.ETypedElement) ";
		invokeAndExpect(EReference.class, definition,Xtend2Package.Literals.RICH_STRING_ELSE_IF__IF);
		invokeAndExpect(EAttribute.class, definition,Xtend2Package.Literals.XTEND_FILE__PACKAGE);
		invokeAndExpect(ETypedElement.class, definition,EcoreFactory.eINSTANCE.createEOperation());
	}
	
	public void testDispatchFunction_04() throws Exception {
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

	public void testDispatchFunction_06() throws Exception {
		final String definition = "foo(p1)} " +
				"def dispatch foo (String string) {\n" + 
				"    string + string\n" + 
				"}\n" + 
				"def dispatch foo (Object o) {\n" + 
				"    null\n";
		invokeAndExpect("zonkzonk", definition, "zonk");
		invokeAndExpect(null, definition, Integer.valueOf(1));
	}
	
	public void testDispatchFunction_07() throws Exception {
		final String definition = "foo(p1)} " +
				"def dispatch foo (String string) {\n" + 
				"    string + string\n" + 
				"}\n" + 
				"def dispatch foo (Void nullCase) {\n" + 
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
		"def dispatch String foo(String string) {\n" + 
		"    string + string\n" + 
		"}\n" + 
		"def String foo(Object x) {\n" + 
		"    'literal'\n";
		invokeAndExpect("zonkzonk", definition, "zonk");
	}
	
	public void testGenericFunction_01() throws Exception {
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
	
	public void testGenericFunction_02() throws Exception {
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
	
	public void testFunctionCall_00() throws Exception {
		invokeAndExpect("foobar", "bar(p1)} def bar(String x) {'foo'+x","bar");
	}
	
	public void testBug342134() throws Exception {
		List<String> list = newArrayList("a", "b", "c");
		invokeAndExpect2(
				list, 
				"def bug342134(java.util.ArrayList<String> strings) {\n" + 
				"    strings.map(e| newArrayList(e)).flatten.toList\n" + 
				"}", "bug342134", list);
	}
	
	public void testTypeInferrence_00() throws Exception {
		compileJavaCode("Foo", "import org.eclipse.emf.ecore.EObject " +
				"class Foo { " +
				"	def Iterable<? extends EObject> test(EObject e) {" +
				"		e.eContents().map(o|test(o)).flatten()" +
				"	}" +
				"}");
	}
	
	public void testDispatchTypes() throws Exception {
		compileJavaCode("Dispatch", "class Dispatch { " +
				 "  def dispatch doSomething(int i) { i.toString() } " +
				 "  def dispatch doSomething(Object o) { null } " +
				 "}");
	}
	
	public void testBug343090_1() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343090(Integer a, Integer b) {\n" + 
				"    addFunction.apply(a, b)\n" + 
				"}\n" +
				"def addFunction() {\n" + 
				"    [Integer a, Integer b|a+b] as (Integer,Integer)=>Integer\n" + 
				"}", "bug343090", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	public void testBug343090_2() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343090(Integer a, Integer b) {\n" + 
				"    <Integer>addFunction.apply(a, b)\n" + 
				"}\n" +
				"def <T extends Integer> addFunction() {\n" + 
				"    [T a,T b|a+b] as (T,T)=>T\n" + 
				"}", "bug343090", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	public void testBug343090_3() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343090(Integer a, Integer b) {\n" + 
				"    addFunction.apply(a, b)\n" + 
				"}\n" +
				"def <T extends Integer> addFunction() {\n" + 
				"    [T a,T b|a+b] as (T,T)=>T\n" + 
				"}", "bug343090", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	public void testBug343088_1() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343088(Integer a, Integer b) {\n" + 
				"    addFunction.apply(a, b)\n" + 
				"}\n" +
				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
				"    [T a,T b|(a+(b as Integer)) as T]\n" + 
				"}", "bug343088", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	public void testBug343088_2() throws Exception {
		invokeAndExpect2(
				23, 
				"def bug343088(Integer a, Integer b) {\n" + 
				"    addFunction.apply(a, b)\n" + 
				"}\n" +
				"def <T extends Integer> (T,T)=>T addFunction() {\n" + 
				"    [T a,T b|(a+b) as T]\n" + 
				"}", "bug343088", Integer.valueOf(18), Integer.valueOf(5));
	}
	
	public void testNullSafeOperatorWithExtension() throws Exception {
		invokeAndExpect2(
				newArrayList(null,null,"foo"), 
				"def myExtension(String s) { 'foo' } " +
				"def nullSafeTest() {\n" + 
				"    newArrayList((null as String)?.myExtension, (null as String)?.myExtension(), 'test'?.myExtension)\n" + 
				"}\n","nullSafeTest");
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
