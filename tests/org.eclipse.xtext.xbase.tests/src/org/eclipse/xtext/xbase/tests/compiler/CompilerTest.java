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
				"  final java.util.ArrayList<String> it = _arrayList;\n" +
				"  int _size = it.size();\n" + 
				"  _xblockexpression = (_size);\n" +
				"}\n" +
				"return _xblockexpression;"
				, "{ val it = new java.util.ArrayList<String>(); size;}");
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
	
	public void testFeatureCall() throws Exception {
		assertCompilesTo(
				"\n" + 
				"java.util.ArrayList<String> _xblockexpression = null;\n" + 
				"{\n" + 
				"  java.util.ArrayList<String> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"foo\");\n" + 
				"  final java.util.ArrayList<String> x = _newArrayList;\n" + 
				"  _xblockexpression = (x);\n" + 
				"}\n" + 
				"return _xblockexpression;",
				"{val x = newArrayList('foo')\n" +
				"x}");
	}
	
	public void testSwitchTypeGuards() throws Exception {
		assertCompilesTo(
				"\n" +
				"String _switchResult = null;\n" + 
				"final CharSequence x = ((CharSequence) \"foo\");\n" + 
				"boolean matched = false;\n" + 
				"if (!matched) {\n" + 
				"  if (x instanceof String) {\n" + 
				"    final String _string = (String)x;\n" + 
				"    matched=true;\n" + 
				"    String _substring = _string.substring(3);\n" + 
				"    String _operator_plus = org.eclipse.xtext.xbase.lib.StringExtensions.operator_plus(_substring, _string);\n" + 
				"    _switchResult = _operator_plus;\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!matched) {\n" + 
				"  if (x instanceof Comparable) {\n" + 
				"    final Comparable _comparable = (Comparable)x;\n" + 
				"    matched=true;\n" + 
				"    int _compareTo = ((Comparable)_comparable).compareTo(\"jho\");\n" + 
				"    String _operator_plus = org.eclipse.xtext.xbase.lib.StringExtensions.operator_plus(\"\", ((Integer)_compareTo));\n" + 
				"    String _string = ((Comparable)_comparable).toString();\n" + 
				"    String _operator_plus_1 = org.eclipse.xtext.xbase.lib.StringExtensions.operator_plus(_operator_plus, _string);\n" + 
				"    _switchResult = _operator_plus_1;\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;"
				, 
				"switch x : 'foo' as CharSequence {" +
				"  String : x.substring(3) + x " +
				"  Comparable : '' + x.compareTo('jho') + x.toString" +
				"}");
	}
	
	protected void assertCompilesTo(final String expectedJavaCode, final String xbaseCode) throws Exception {
		XExpression model = expression(xbaseCode,true);
		XbaseCompiler compiler = get(XbaseCompiler.class);
		IAppendable appandable = new StringBuilderBasedAppendable();
		JvmTypeReference returnType = typeProvider.getCommonReturnType(model, true);
		compiler.compile(model,appandable, returnType);
		assertEquals(expectedJavaCode,appandable.toString());
	}
}
