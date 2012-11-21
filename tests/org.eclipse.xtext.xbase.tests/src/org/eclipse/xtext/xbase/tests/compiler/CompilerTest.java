/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class CompilerTest extends AbstractOutputComparingCompilerTests {
	
	@Test public void testSimple() throws Exception {
		assertCompilesTo("\nint _length = \"foo\".length();\n" + 
				"return _length;", "'foo'.length");
	}
	
	@Test public void testFieldAccessDontGetAVariableDeclaration() throws Exception {
		assertCompilesTo(
				"\ntestdata.Properties1 _properties1 = new testdata.Properties1();" + 
				"\nreturn _properties1.prop1;", 
				"new testdata.Properties1().prop1");
	}

	@Test public void testNull() throws Exception {
		assertCompilesToStatement(
				"\n// null\n", 
				"null");
	}
	
	@Test public void testStringLiteralInComment() throws Exception {
		assertCompilesToStatement(
				"\n// \"* /\"\n", 
				"'*/'");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_01() throws Exception {
		assertCompilesToStatement(
				"\n" +
				"try {\n" +
				"  new Object();\n" +
				"  new Object();\n" +
				"} finally {\n" +
				"  new Object();\n" +
				"  new Object();\n" +
				"}", 
				"try { new Object() new Object() } finally { new Object() new Object() }");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_02() throws Exception {
		assertCompilesToStatement(
				"\n" +
				"if (true) {\n" +
				"  new Object();\n" +
				"  new Object();\n" +
				"} else {\n" +
				"  new Object();\n" +
				"  new Object();\n" +
				"}", 
				"if (true) { new Object() new Object() } else { new Object() new Object() }");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_03() throws Exception {
		assertCompilesTo(
				"\n" + 
				"final org.eclipse.xtext.xbase.lib.Procedures.Procedure1<Integer> _function = new org.eclipse.xtext.xbase.lib.Procedures.Procedure1<Integer>() {\n" + 
				"    public void apply(final Integer i) {\n" + 
				"      new Object();\n" + 
				"      new Object();\n" + 
				"    }\n" + 
				"  };\n" + 
				"org.eclipse.xtext.xbase.lib.Procedures.Procedure1<? super Integer> fun = _function;", 
				"{ var (int)=>void fun = [ int i | new Object() new Object() ] }");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_04() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object _object = new Object();\n" +
				"Object it = _object;\n" +
				"it.notify();",
				"{ var it = new Object() notify }");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_05() throws Exception {
		assertCompilesTo(
				"\n" + 
				"{\n" +
				"  Object _object = new Object();\n" +
				"  Object it = _object;\n" +
				"  it.notify();\n" +
				"}\n" +
				"{\n" +
				"  Object _object = new Object();\n" +
				"  Object it = _object;\n" +
				"  it.notify();\n" +
				"}",
				"{ { var it = new Object() notify } { var it = new Object() notify } }");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_06() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object _object = new Object();\n" + 
				"Object it = _object;\n" + 
				"{\n" + 
				"  Object _object_1 = new Object();\n" + 
				"  Object it_1 = _object_1;\n" + 
				"  it_1.notify();\n" + 
				"}\n" + 
				"it.notify();",
				"{ var it = new Object() { var it = new Object() it.notify() } notify }");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_07() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object _object = new Object();\n" + 
				"Object it = _object;\n" + 
				"Object _object_1 = new Object();\n" + 
				"_object_1.notify();\n" + 
				"it.notify();",
				"{ var it = new Object() { new Object().notify() } notify }");
	}
	
	@Test
	@Ignore("TODO")
	public void testNoUnneccessaryConversionStatement() throws Exception {
		assertCompilesTo(
				"String _xblockexpression = null;\n" + 
				"{\n" + 
				"  testdata.Properties1 _properties1 = new testdata.Properties1();\n" + 
				"  final testdata.Properties1 x = _properties1;\n" + // this one is not necessary 
				"  String _string = x.toString();\n" + 
				"  _xblockexpression = (_string);\n" + 
				"}\n" + 
				"return _xblockexpression;",
				"{ val x = new testdata.Properties1() x.toString()}");
	}
	
	@Test public void testBlock() throws Exception {
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
	
	@Test public void testIf() throws Exception {
		assertCompilesTo(
				"\nint _xifexpression = (int) 0;\n" +
				"if (true) {\n" +
				"  _xifexpression = 42;\n" +
				"} else {\n" +
				"  _xifexpression = 21;\n}\n" +
				"return _xifexpression;"
				, "if (true) 42 else 21");
	}

	@Test public void testForEach_01() throws Exception {
		assertCompilesTo(
				"\njava.util.ArrayList<String> _arrayList = new java.util.ArrayList<String>();\n" + 
				"for (final String s : _arrayList) {\n" +
				"  s.length();\n" +
				"}"
				, "for (String s : new java.util.ArrayList<String>())" +
						"s.length");
	}
	
	@Test public void testForEach_02() throws Exception {
		assertCompilesTo(
				"\njava.util.ArrayList<String> _arrayList = new java.util.ArrayList<String>();\n" + 
				"for (final String s : _arrayList) {\n" +
				"  s.length();\n" +
				"}"
				, "for (s : new java.util.ArrayList<String>())" +
						"s.length");
	}
	
	@Test
	@Ignore("TODO type inferrence in for-loops does not work properly")
	public void testForEach_03() throws Exception {	
		assertCompilesTo(
				"\njava.util.ArrayList<String> _arrayList = new java.util.ArrayList<String>();\n" + 
				"for (final String s : _arrayList) {\n" +
				"  s.length();\n" +
				"}"
				, "for (String s : new java.util.ArrayList())" +
						"s.length");
	}
	
	@Test public void testFeatureCall() throws Exception {
		assertCompilesTo(
				"\n" + 
				"java.util.ArrayList<String> _xblockexpression = null;\n" + 
				"{\n" + 
				"  final java.util.ArrayList<String> x = org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"foo\");\n" + 
				"  _xblockexpression = (x);\n" + 
				"}\n" + 
				"return _xblockexpression;",
				"{val x = newArrayList('foo')\n" +
				"x}");
	}
	
	@Test public void testNullSafeFeatureCall_01() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object _object = new Object();\n" +
				"if (_object!=null) _object.notify();",
				"new Object()?.notify");
	}
	
	@Test public void testNullSafeFeatureCall_02() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object _object = new Object();\n" +
				"String _string = _object.toString();\n" +
				"if (_string!=null) _string.notify();",
				"new Object().toString?.notify");
	}
	
	@Test public void testNullSafeFeatureCall_03() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object _object = new Object();\n" +
				"String _string = _object==null?(String)null:_object.toString();\n" +
				"if (_string!=null) _string.notify();",
				"new Object()?.toString?.notify");
	}
	
	@Test public void testInline_01() throws Exception {
		assertCompilesTo(
				"\n" + 
				"String _plus = (\"a\" + \"b\");\n" + 
				"String _string = _plus.toString();\n" + 
				"return _string;",
				"('a'+'b').toString");
	}
	
	@Test public void testInline_02() throws Exception {
		assertCompilesTo(
				"\n" + 
				"boolean _xifexpression = false;\n" + 
				"boolean _not = (!true);\n" + 
				"if (_not) {\n" + 
				"  boolean _equals = (true == false);\n" + 
				"  _xifexpression = _equals;\n" + 
				"} else {\n" + 
				"  boolean _notEquals = (true != false);\n" + 
				"  _xifexpression = _notEquals;\n" + 
				"}\n" + 
				"return _xifexpression;",
				"if(!true) true==false else true!=false");
	}
	
	@Test public void testSwitch_() throws Exception {
		assertCompilesTo("String _xblockexpression = null;\n" + 
				"{\n" + 
				"  final Object o = \"foo\";\n" + 
				"  boolean _matched = false;\n" + 
				"  if (!_matched) {\n" + 
				"    if (o instanceof String) {\n" + 
				"      final String _string = (String)o;\n" + 
				"      _matched=true;\n" + 
				"      \"\".toString();\n" + 
				"    }\n" + 
				"  }\n" + 
				"  String _switchResult_1 = null;\n" + 
				"  boolean _matched_1 = false;\n" + 
				"  if (!_matched_1) {\n" + 
				"    if (o instanceof String) {\n" + 
				"      final String _string = (String)o;\n" + 
				"      _matched_1=true;\n" + 
				"      _switchResult_1 = \"\";\n" + 
				"    }\n" + 
				"  }\n" + 
				"  _xblockexpression = (_switchResult_1);\n" + 
				"}\n" + 
				"return _xblockexpression;",
				"{" +
				"  val Object o = 'foo'" +
				"    switch(o) {\n" + 
				"        String: \"\".toString\n" + 
				"    }\n" + 
				"    switch(o) {\n" + 
				"        String: \"\"\n" + 
				"    }" +
				"}");
	}
	
	@Test public void testSwitchTypeGuards_01() throws Exception {
		assertCompilesTo(
				"String _switchResult = null;\n" + 
				"final CharSequence x = ((CharSequence) \"foo\");\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (x instanceof String) {\n" + 
				"    final String _string = (String)x;\n" + 
				"    _matched=true;\n" + 
				"    String _substring = _string.substring(3);\n" + 
				"    String _plus = (_substring + _string);\n" + 
				"    _switchResult = _plus;\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (x instanceof Comparable) {\n" + 
				"    final Comparable _comparable = (Comparable)x;\n" + 
				"    _matched=true;\n" + 
				"    int _compareTo = ((Comparable)_comparable).compareTo(\"jho\");\n" + 
				"    String _plus = (\"\" + Integer.valueOf(_compareTo));\n" + 
				"    String _string = ((Comparable)_comparable).toString();\n" + 
				"    String _plus_1 = (_plus + _string);\n" + 
				"    _switchResult = _plus_1;\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;"
				, 
				"switch x : 'foo' as CharSequence {" +
				"  String : x.substring(3) + x " +
				"  Comparable : '' + x.compareTo('jho') + x.toString" +
				"}");
	}
	
	/*
	 * TODO output should be more straight forward, e.g. the cast of _comparable to CharSequence is unnecessary
	 * it should more look like
	 * int _compareTo = ..
	 * int _plus = ..
	 * int _length = x.length();
	 * ..
	 */
	@Test public void testSwitchTypeGuards_02() throws Exception {
		assertCompilesTo(
				"String _switchResult = null;\n" + 
				"final CharSequence x = ((CharSequence) \"foo\");\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (x instanceof String) {\n" + 
				"    final String _string = (String)x;\n" + 
				"    _matched=true;\n" + 
				"    String _substring = _string.substring(3);\n" + 
				"    String _plus = (_substring + _string);\n" + 
				"    _switchResult = _plus;\n" + 
				"  }\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (x instanceof Comparable) {\n" + 
				"    final Comparable<String> _comparable = (Comparable<String>)x;\n" + 
				"    _matched=true;\n" + 
				"    int _compareTo = ((Comparable<String>)_comparable).compareTo(\"jho\");\n" + 
				"    String _plus = (\"\" + Integer.valueOf(_compareTo));\n" + 
				"    int _length = ((CharSequence)_comparable).length();\n" + 
				"    String _plus_1 = (_plus + Integer.valueOf(_length));\n" + 
				"    _switchResult = _plus_1;\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;"
				, 
				"switch x : 'foo' as CharSequence {" +
				"  String : x.substring(3) + x " +
				"  Comparable<String> : '' + x.compareTo('jho') + x.length" +
				"}");
	}
	
	@Test public void testNewLines_withinline() throws Exception {
		assertCompilesTo(
				"java.util.ArrayList<String> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"foo\");\n" + 
				"boolean _add = _newArrayList.add(\n" + 
				"  \"bar\");\n" + 
				"return _add;", 
				"newArrayList('foo') += \n'bar'");
	}
	
	@Test public void testNewLines_withinline1() throws Exception {
		assertCompilesTo(
				"String _plus = (\"foo\" + \n" + 
				"  \"bar\");\n" + 
				"java.util.ArrayList<String> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(_plus);\n" + 
				"return _newArrayList;", 
				"newArrayList(\n'foo' + \n'bar')");
	}
	
	@Test public void testNewLines_forExtensionMethod() throws Exception {
		assertCompilesTo(
				"String _firstUpper = org.eclipse.xtext.xbase.lib.StringExtensions.toFirstUpper(\"foo\");\n" + 
				"return _firstUpper;", 
				"\n'foo'.toFirstUpper");
	}
	
	
}
