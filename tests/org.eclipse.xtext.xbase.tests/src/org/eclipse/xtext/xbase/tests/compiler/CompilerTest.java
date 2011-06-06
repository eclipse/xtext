/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.IAppendable;
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable;
import org.eclipse.xtext.xbase.compiler.XbaseCompiler;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.typing.ITypeProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilerTest extends AbstractXbaseTestCase {
	
	@Inject
	private ITypeProvider typeProvider;
	
	public void testSimple() throws Exception {
		assertCompilesTo("\nint _length = \"foo\".length();\n" + 
				"return _length;", "'foo'.length");
	}
	
	public void testFieldAccessDontGetAVariableDeclaration() throws Exception {
		assertCompilesTo(
				"\ntestdata.Properties1 _properties1 = new testdata.Properties1();" + 
				"\nreturn _properties1.prop1;", 
				"new testdata.Properties1().prop1");
	}
	
//TODO	
//	public void testNoUnneccessaryConversionStatement() throws Exception {
//		assertCompilesTo(
//				
//				No unneccessary conversion!
//				
//				"{ val x = new testdata.Properties1() x.toString()}");
//	}
	
	public void testBlock() throws Exception {
		assertCompilesTo(
				"\nint _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  java.util.ArrayList<String> _arrayList = new java.util.ArrayList<String>();\n" + 
				"  final java.util.ArrayList<String> _this = _arrayList;\n" +
				"  int _size = _this.size();\n" + 
				"  _xblockexpression = (_size);\n" +
				"}\n" +
				"return _xblockexpression;"
				, "{ val this = new java.util.ArrayList<String>(); size;}");
	}
	
	public void testIf() throws Exception {
		assertCompilesTo(
				"\nint _xifexpression = (int) 0;\n" +
				"if (true) {\n" +
				"  _xifexpression = 42;\n" +
				"} else {\n" +
				"  _xifexpression = 21;\n}\n" +
				"return _xifexpression;"
				, "if (true) 42 else 21");
	}

	public void testForEach_01() throws Exception {
		assertCompilesTo(
				"\njava.util.ArrayList<String> _arrayList = new java.util.ArrayList<String>();\n" + 
				"for (final String s : _arrayList) {\n" +
				"  s.length();\n" +
				"}"
				, "for (String s : new java.util.ArrayList<String>())" +
						"s.length");
	}
	
	public void testForEach_02() throws Exception {
		assertCompilesTo(
				"\njava.util.ArrayList<String> _arrayList = new java.util.ArrayList<String>();\n" + 
				"for (final String s : _arrayList) {\n" +
				"  s.length();\n" +
				"}"
				, "for (s : new java.util.ArrayList<String>())" +
						"s.length");
	}
	
//	public void testForEach_03() throws Exception {	
//		assertCompilesTo(
//				"\njava.util.ArrayList<String> _arrayList = new java.util.ArrayList<String>();\n" + 
//				"for (final String s : _arrayList) {\n" +
//				"  s.length();\n" +
//				"}"
//				, "for (String s : new java.util.ArrayList())" +
//						"s.length");
//	}
	
	protected void assertCompilesTo(final String expectedJavaCode, final String xbaseCode) throws Exception {
		XExpression model = expression(xbaseCode,true);
		XbaseCompiler compiler = get(XbaseCompiler.class);
		IAppendable appandable = new StringBuilderBasedAppendable();
		JvmTypeReference returnType = typeProvider.getCommonReturnType(model, true);
		compiler.compile(model,appandable, returnType);
		assertEquals(expectedJavaCode,appandable.toString());
	}
}
