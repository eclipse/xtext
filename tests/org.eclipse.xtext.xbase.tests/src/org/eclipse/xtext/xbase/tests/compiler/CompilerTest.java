/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.xbase.XbaseStandaloneSetup;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilerTest extends AbstractXtextTests {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(new XbaseStandaloneSetup());
	}
	
	public void testSimple() throws Exception {
		assertCompilesTo("return \"foo\".length();", "'foo'.length");
	}
	
	public void testBlock() throws Exception {
		assertCompilesTo(
				"java.lang.Integer _var;\n" +
				"{\n" +
				"final java.util.ArrayList<java.lang.String> _this = new java.util.ArrayList<java.lang.String>();\n" +
				"_var = _this.size();\n" +
				"}\n" +
				"return _var;"
				, "{ val this = new java.util.ArrayList<java.lang.String>(); size;}");
	}
	
	public void testIf() throws Exception {
		assertCompilesTo(
				"java.lang.Integer _var;\n" +
				"if (true) {\n" +
				"_var = 42L;\n" +
				"} else {\n" +
				"_var = 21L;\n}\n" +
				"return _var;"
				, "if (true) 42 else 21");
	}
//TODO	
//	public void testForEach() throws Exception {
//		assertCompilesTo(
//				"for (java.lang.String s : new java.util.ArrayList<java.lang.String>()) {\n" +
//				"s.length();\n" +
//				"}\n" +
//				"return null;"
//				, "for (java.lang.String s : new java.util.ArrayList<java.lang.String>()) " +
//						"s.length");
//	}

	protected void assertCompilesTo(final String expectedJavaCode, final String xbaseCode) throws Exception {
		EObject model = getModel(xbaseCode);
		XbaseCompiler compiler = get(XbaseCompiler.class);
		assertEquals(expectedJavaCode,compiler.compile(model).toString());
	}
}
