/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.compiler;

import java.io.StringWriter;

import org.eclipse.xtext.xtend2.compiler.Xtend2Compiler;
import org.eclipse.xtext.xtend2.tests.AbstractXtend2TestCase;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;

public class Xtend2CompilerTest extends AbstractXtend2TestCase {

	public void testJavaLangReflectImport() throws Exception {
		final String input = "package foo\n" +
				"class Bar {\n" +
				"  def void doStuff(java.lang.reflect.Method m) {}\n" +
				"}\n";
		final String expected = "package foo;\n" + 
				"\n" +
				"import java.lang.reflect.Method;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" + 
				"public class Bar {\n" +
				"  \n" +
				"  public void doStuff(final Method m) {\n" + 
				"  }\n" + 
				"}";
		assertCompilesTo(expected, input);
	}
	
	public void testSimple() throws Exception {
		final String input = "package foo\n" +
		"class Bar {\n" +
		"  def Integer doStuff(String x) {x.length}\n" +
		"}\n";
		final String expected = "package foo;\n" + 
		"\n" +
		"\n" +
		"@SuppressWarnings(\"all\")\n" + 
		"public class Bar {\n" +
		"  \n" +
		"  public Integer doStuff(final String x) {\n" + 
		"    int _length = x.length();\n" + 
		"    return ((Integer)_length);\n" + 
		"  }\n" + 
		"}";
		assertCompilesTo(expected, input);
	}
	
	public void testConstructor() throws Exception {
		final String input = 
		"package foo\n" +
		"class Bar {\n" +
		"  def foo() {new String()}\n" +
		"}\n";
		final String expected =  
		"package foo;\n" +
		"\n" + 
		"\n" +
		"@SuppressWarnings(\"all\")\n" +
		"public class Bar {\n" +
		"  \n" + 
		"  public String foo() {\n" + 
		"    String _string = new String();\n" + 
		"    return _string;\n" + 
		"  }\n" + 
		"}";
		assertCompilesTo(expected, input);
	}

	public void testExtends() throws Exception {
		final String input = 
		"package foo\n" +
		"class Bar extends Object {\n" +
		"}\n";
		final String expected =  
		"package foo;\n" +
		"\n" + 
		"\n" +
		"@SuppressWarnings(\"all\")\n" +
		"public class Bar extends Object {\n" +
		"}";
		assertCompilesTo(expected, input);
	}
	
	public void testExtendsException() throws Exception {
		final String input = 
		"package foo\n" +
		"class NoSuchElementException extends java.util.NoSuchElementException {\n" +
		"}\n";
		final String expected =  
		"package foo;\n" +
		"\n" + 
		"\n" +
		"@SuppressWarnings(\"all\")\n" +
		"public class NoSuchElementException extends java.util.NoSuchElementException {\n" +
		"}";
		assertCompilesTo(expected, input);
	}
	
	public void testVisibilityOfDispatchMethods() throws Exception {
		final String input = 
			"package foo\n" +
			"class NoSuchElementException {\n" +
			"  def dispatch void foo(String s) {}\n" +
			"  def dispatch void foo(Object s) {}\n" +
			"}\n";
		final String expected =  
			"package foo;\n" +
			"\n" + 
			"\n" +
			"@SuppressWarnings(\"all\")\n" +
			"public class NoSuchElementException {\n" + 
			"  \n" + 
			"  protected void _foo(final String s) {\n" + 
			"  }\n" + 
			"  \n" + 
			"  protected void _foo(final Object s) {\n" + 
			"  }\n" + 
			"  \n" + 
			"  public void foo(final Object s) {\n" + 
			"    if ((s instanceof String)) {\n" + 
			"      _foo((String)s);\n" + 
			"    } else if ((s instanceof Object)) {\n" + 
			"      _foo((Object)s);\n" + 
			"    } else {\n" + 
			"      throw new IllegalArgumentException(\"Unhandled parameter types: \" +\n" +
			"        java.util.Arrays.<Object>asList(s).toString());\n" + 
			"    }\n" + 
			"  }\n" +
			"}";
		assertCompilesTo(expected, input);
	}
	
//	public void testExtendsArrayList_01() throws Exception {
//		final String input = 
//		"package foo\n" +
//		"class ArrayList<T> extends java.util.ArrayList<T> {\n" +
//		"}\n";
//		final String expected =  
//		"package foo;\n" +
//		"\n" + 
//		"\n" +
//		"@SuppressWarnings(\"all\")\n" +
//		"public class ArrayList<T> extends java.util.ArrayList<T> {\n" +
//		"}";
//		assertCompilesTo(expected, input);
//	}
//	
//	public void testExtendsArrayList_02() throws Exception {
//		final String input = 
//		"package foo\n" +
//		"class StringList extends java.util.ArrayList<String> {\n" +
//		"}\n";
//		final String expected =  
//		"package foo;\n" +
//		"\n" +
//		"import java.util.ArrayList;\n" +
//		"\n" +
//		"@SuppressWarnings(\"all\")\n" +
//		"public class StringList extends ArrayList<String> {\n" +
//		"}";
//		assertCompilesTo(expected, input);
//	}

	public void testImplements() throws Exception {
		final String input = 
		"package foo\n" +
		"class Bar implements Cloneable, java.io.Serializable {\n" +
		"}\n";
		final String expected =  
		"package foo;\n" +
		"\n" + 
		"import java.io.Serializable;\n" + 
		"\n" +
		"@SuppressWarnings(\"all\")\n" +
		"public class Bar implements Cloneable, Serializable {\n" +
		"}";
		assertCompilesTo(expected, input);
	}
	
	public void testConstructor_2() throws Exception {
		final String input = 
			"package foo\n" +
			"class Bar {\n" +
			"  def foo() {new java.util.HashMap<String,java.io.Serializable>()}" +
			"}\n";
		final String expected =  
			"package foo;\n" +
			"\n" + 
			"import java.io.Serializable;\n" + 
			"import java.util.HashMap;\n" + 
			"\n" +
			"@SuppressWarnings(\"all\")\n" +
			"public class Bar {\n" +
			"  \n" +
			"  public HashMap<String,Serializable> foo() {\n" +
			"    HashMap<String,Serializable> _hashMap = new HashMap<String,Serializable>();\n" + 
			"    return _hashMap;\n" +
			"  }\n" + 
			"}";
		assertCompilesTo(expected, input);
	}
	
	public void testAnnotation() throws Exception {
		final String input = 
			"package foo\n" +
			"class Bar {\n" +
			"  @com.google.inject.Inject String string" +
			"}\n";
		final String expected =  
			"package foo;\n" +
			"\n" + 
			"import com.google.inject.Inject;\n" + 
			"\n" +
			"@SuppressWarnings(\"all\")\n" +
			"public class Bar {\n" +
			"  \n" +
			"  @Inject\n" +
			"  private String string;\n" + 
			"}";
		XtendFile file = file(input,true);
		Xtend2Compiler compiler = get(Xtend2Compiler.class);
		StringWriter appendable = new StringWriter();
		compiler.compile(file, appendable);
		assertEquals(expected,appendable.toString());
	}

	protected void assertCompilesTo(final String expected, final String input) throws Exception {
		XtendFile file = file(input,true);
		Xtend2Compiler compiler = get(Xtend2Compiler.class);
		StringWriter appendable = new StringWriter();
		compiler.compile(file, appendable);
		assertEquals(expected,appendable.toString());
	}
	
}
