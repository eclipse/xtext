/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.serializer;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.junit.Test;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractXtendTestData extends AbstractXtendTestCase {

	protected abstract void doTest(String fileContents) throws Exception;

	@Test public void testHelloWorld() throws Exception {
		StringBuilder str = new StringBuilder();
		str.append("package xtend.tutorial.basics\n\n");
		str.append("\n\n");
		str.append("/*\n\n");
		str.append(" * The classical hello world example\n\n");
		str.append(" */\n\n");
		str.append("import org.junit.Assert\n");
		str.append("\n\n");
		str.append("class Xtend01_HelloWorld extends Assert {\n");
		str.append("	\n");
		str.append("	def void testHelloWorld() {\n");
		str.append("		Assert::assertEquals('Hello Joe!', sayHelloTo('Joe'))\n");
		str.append("	}\n");
		str.append("	/**\n");
		str.append("	 * Hello World with explicit return type and explicit return expression 1.\n");
		str.append("	 */\n");
		str.append("	def String sayHelloTo(String to) {\n");
		str.append("		return 'Hello '+to+'!'\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("	/**\n");
		str.append("	 * Hello World with explicit return type and explicit return expression 2.\n");
		str.append("	 */\n");
		str.append("	def sayHelloTo2(String to) {\n");
		str.append("		'Hello '+to+'!'\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("	/**\n");
		str.append("	 * prints hello world to System.out\n");
		str.append("	 */\n");
		str.append("	def void sayHelloToSystemOut(String to) {\n");
		str.append("		System::out.println(sayHelloTo(to))\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("	/**\n");
		str.append("	 * using the shorter extension method.\n");
		str.append("	 */\n");
		str.append("	def void sayHelloToSystemOut2(String to) {\n");
		str.append("		println(sayHelloTo(to))\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("}");
		doTest(str.toString());
	}

	@Test public void testSimpleExpressions() throws Exception {
		StringBuilder str = new StringBuilder();
		str.append("package xtend.tutorial.basics\n");
		str.append("\n");
		str.append("import java.util.ArrayList\n");
		str.append("\n");
		str.append("class Xtend02_SimpleExpressions {\n");
		str.append("	\n");
		str.append("	new() {\n");
		str.append("		super()");
		str.append("	}\n");
		str.append("	new(int i) {\n");
		str.append("		this()");
		str.append("	}\n");
		str.append("	/**\n");
		str.append("	 * string literals can be multi line and \n");
		str.append("	 * can be terminated by either single quotes or double quotes\n");
		str.append("	 */\n");
		str.append("	def stringLiteral() {\n");
		str.append("		'Hello World'\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("	def booleanLiteral() {\n");
		str.append("		true || false\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("	def intLiteral() {\n");
		str.append("		42 + 21 + super.hashCode\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("	def nullLiteral() {\n");
		str.append("		null\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("	def objectConstruction() {\n");
		str.append("		new ArrayList<String>()\n");
		str.append("		new ArrayList<String>(1)\n");
		str.append("		new ArrayList<String>(newArrayList)\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("	/**\n");
		str.append("	 * The equivalent to Java's String.class is typeof(String)\n");
		str.append("	 */\n");
		str.append("	def clazzLiteral() {\n");
		str.append("		typeof(String)\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("	/**\n");
		str.append("	 * the equivalent to Java's ((String)null) is (null as String)\n");
		str.append("	 */\n");
		str.append("	def casts() {\n");
		str.append("		(null as String).toString() // results in a NullPointerException\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("	/**\n");
		str.append("	 * variable declaration can occure within a block expression.\n");
		str.append("	 * Which in turn can occure everywhere an expression can occure.\n");
		str.append("	 */\n");
		str.append("	def variableDeclaration() {\n");
		str.append("		val myString = 'Hello World'\n");
		str.append("		var modifiable = {\n");
		str.append("			val myOther = myString.toLowerCase\n");
		str.append("			myOther\n");
		str.append("		}\n");
		str.append("		// myOther is not visible anymore\n");
		str.append("		// modifiable is 'hello world'\n");
		str.append("		modifiable = myString.toUpperCase\n");
		str.append("		// modifiable is 'HELLO WORLD'\n");
		str.append("	}\n");
		str.append("	\n");
		str.append("}");
		doTest(str.toString());
	}
	
	@Test public void testTypeLiteralsNoImports() throws Exception {
		StringBuilder str = new StringBuilder();
		str.append("class TypeLiterals {\n");
		str.append("	def m() {\n");
		str.append("		java.lang.String.getName\n");
		str.append("		String.getName\n");
		str.append("		java.util.Map.Entry.getName\n");
		str.append("		java.util.Map$Entry.getName\n");
		str.append("	}\n");
		str.append("}");
		doTest(str.toString());
	}
	
	@Test public void testTypeLiteralsImports() throws Exception {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Map\n");
		str.append("class TypeLiterals {\n");
		str.append("	def m() {\n");
		str.append("		Map$Entry.getName\n");
		str.append("		Map.Entry.getName\n");
		str.append("	}\n");
		str.append("}");
		doTest(str.toString());
	}
	
	@Test public void testTypeLiteralsNestedImportsWithDollar() throws Exception {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Map$Entry\n");
		str.append("class TypeLiterals {\n");
		str.append("	def m() {\n");
		str.append("		Map$Entry.getName\n");
		str.append("		Entry.getName\n");
		str.append("	}\n");
		str.append("}");
		doTest(str.toString());
	}
	
	@Test public void testTypeLiteralsNestedImportsWithDot() throws Exception {
		StringBuilder str = new StringBuilder();
		str.append("package myPackage\n");
		str.append("import java.util.Map.Entry\n");
		str.append("class TypeLiterals {\n");
		str.append("	def m() {\n");
		str.append("		Entry.getName\n");
		str.append("		TypeLiterals.getName\n");
		str.append("		myPackage.TypeLiterals.getName\n");
		str.append("	}\n");
		str.append("}");
		doTest(str.toString());
	}
	
	@Test public void testAnonymousClass() throws Exception {
		StringBuilder str = new StringBuilder();
		str.append("package myPackage\n");
		str.append("class Foo {\n");
		str.append("	val bar = new Runnable() {\n");
		str.append("		override run() {\n");
		str.append("		}\n");
		str.append("	}\n");
		str.append("}");
		doTest(str.toString());
	}

}
