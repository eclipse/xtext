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
	
	@Test public void testExtensionOnTypeLiteral() throws Exception {
		assertCompilesTo("\nboolean _identityEquals = (org.eclipse.xtext.xbase.lib.StringExtensions.class == null);\n" + 
				"return _identityEquals;", "org.eclipse.xtext.xbase.lib.StringExtensions.identityEquals(null)");
	}
	
	@Test public void testBug377855() throws Exception {
		assertCompilesToStatement(
				"\n" + 
				"try {\n" + 
				"  Class<?> clazz = Class.forName(\"java.lang.String\");\n" + 
				"  Class<?> _superclass = clazz.getSuperclass();\n" + 
				"  org.eclipse.xtext.xbase.lib.InputOutput.<Class<?>>println(_superclass);\n" + 
				"} catch (Throwable _e) {\n" + 
				"  throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_e);\n" + 
				"}", 
				"{" +
				"  var clazz = Class::forName('java.lang.String')\n" + 
				"  println(clazz.superclass)\n" +
				"}");
	}
	
	@Test public void testBug383551_01() throws Exception {
		assertCompilesToStatement(
				"\n" + 
				"final java.util.List<String> list = null;\n" + 
				"Object _switchResult = null;\n" + 
				"boolean _matched = false;\n" + 
				"if (list instanceof java.util.ArrayList) {\n" + 
				"  _matched=true;\n" + 
				"  _switchResult = ((java.util.ArrayList)list).get(1);\n" + 
				"}\n" + 
				"final Object it = _switchResult;\n" + 
				"it.toString();", 
				"{" +
				"  val java.util.List<String> list = null\n" +
				"  val Object it = switch list {\n" +
				"    java.util.ArrayList: list.get(1)\n" +
				"  }\n" +
				"  toString" + 
				"}");
	}

	@Ignore("TODO automatically insert type arguments after instanceof expressions")
	@Test public void testBug383551_02() throws Exception {
		assertCompilesToStatement(
				"\n" + 
				"final java.util.List<String> list = null;\n" + 
				"Object _switchResult = null;\n" + 
				"boolean _matched = false;\n" + 
				"if (!_matched) {\n" + 
				"  if (list instanceof java.util.ArrayList) {\n" + 
				"    _matched=true;\n" + 
				"    Object _get = ((java.util.ArrayList)list).get(1);\n" + 
				"    _switchResult = _get;\n" + 
				"  }\n" + 
				"}\n" + 
				"final String it = _switchResult;\n" + 
				"it.substring(1);", 
				"{" +
				"  val java.util.List<String> list = null\n" +
				"  val it = switch list {\n" +
				"    java.util.ArrayList: list.get(1)\n" +
				"  }\n" +
				"  substring(1)" + 
				"}");
	}
	
	@Test public void testBug383551_03() throws Exception {
		assertCompilesToStatement(
				"\n" + 
				"final java.util.List<String> list = null;\n" + 
				"String _switchResult = null;\n" + 
				"boolean _matched = false;\n" + 
				"if (list instanceof java.util.ArrayList) {\n" + 
				"  _matched=true;\n" + 
				"  _switchResult = ((java.util.ArrayList<String>)list).get(1);\n" + 
				"}\n" + 
				"final String it = _switchResult;\n" + 
				"it.substring(1);", 
				"{" +
				"  val java.util.List<String> list = null\n" +
				"  val it = switch list {\n" +
				"    java.util.ArrayList<String>: list.get(1)\n" +
				"  }\n" +
				"  substring(1)" + 
				"}");
	}
	
	@Test public void testBug383551_04() throws Exception {
		assertCompilesToStatement(
				"\n" + 
				"final Object o = null;\n" + 
				"if ((o instanceof String)) {\n" + 
				"  ((String) o).length();\n" + 
				"}", 
				"{" +
				"  val Object o = null\n" +
				"  if (o instanceof String) (o as String).length()" + 
				"}");
	}
	
	@Test public void testImplicitReferenceToMultitype() throws Exception {
		assertCompilesTo(
				// TODO AbstractStringBuilder is package private and should not be part of the resolved type
				"Iterable<AbstractStringBuilder> _plus = com.google.common.collect.Iterables.<AbstractStringBuilder>concat(((Iterable<StringBuilder>) null), ((Iterable<StringBuffer>) null));\n" + 
				"Iterable<Object> _plus_1 = com.google.common.collect.Iterables.<Object>concat(_plus, ((Iterable<String>) null));\n" + 
				"final java.util.function.Consumer<Object> _function = new java.util.function.Consumer<Object>() {\n" + 
				"  public void accept(final Object it) {\n" + 
				"    ((CharSequence)it).length();\n" + 
				"  }\n" + 
				"};\n" + 
				"_plus_1.forEach(_function);", 
				"((null as Iterable<StringBuilder>) + (null as Iterable<StringBuffer>) + (null as Iterable<String>)).forEach[ length ]");
	}
	
	@Test public void testReferenceToSynonym_01() throws Exception {
		assertCompilesTo(
				"int _size = ((java.util.List<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(((String[]) null))).size();\n" + 
				"return _size;", 
				"(null as String[]).size");
	}
	
	@Test public void testImplicitReferenceToSynonym_01() throws Exception {
		assertCompilesTo(
				"final java.util.function.Consumer<String[]> _function = new java.util.function.Consumer<String[]>() {\n" + 
				"  public void accept(final String[] it) {\n" + 
				"    ((java.util.List<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(it)).subList(1, 1);\n" +
				"  }\n" + 
				"};\n" + 
				"((Iterable<String[]>) null).forEach(_function);", 
				"(null as Iterable<String[]>).forEach[ subList(1,1) ]");
	}
	
	@Test public void testImplicitReferenceToSynonym_02() throws Exception {
		assertCompilesTo(
				"final java.util.function.Consumer<String[]> _function = new java.util.function.Consumer<String[]>() {\n" + 
				"  public void accept(final String[] it) {\n" + 
				"    ((java.util.List<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(it)).size();\n" +
				"  }\n" + 
				"};\n" + 
				"((Iterable<String[]>) null).forEach(_function);", 
				"(null as Iterable<String[]>).forEach[ size() ]");
	}
	
	@Test public void testImplicitReferenceToSynonymWithPrimitives() throws Exception {
		assertCompilesTo(
				"final java.util.function.Consumer<int[]> _function = new java.util.function.Consumer<int[]>() {\n" + 
				"  public void accept(final int[] it) {\n" + 
				"    ((java.util.List<Integer>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(it)).subList(1, 1);\n" +
				"  }\n" + 
				"};\n" + 
				"((Iterable<int[]>) null).forEach(_function);", 
				"(null as Iterable<int[]>).forEach[ subList(1,1) ]");
	}
	
	@Test public void testImplicitReferenceToArray() throws Exception {
		assertCompilesTo(
				"final java.util.function.Consumer<String[]> _function = new java.util.function.Consumer<String[]>() {\n" + 
				"  public void accept(final String[] it) {\n" + 
				"    int _length = it.length;\n" +
				"    org.eclipse.xtext.xbase.lib.InputOutput.<Integer>println(Integer.valueOf(_length));\n" + 
				"  }\n" + 
				"};\n" + 
				"((Iterable<String[]>) null).forEach(_function);", 
				"(null as Iterable<String[]>).forEach[ println(length) ]");
	}
	
	@Test public void testExplicitReferenceToSynonym_01() throws Exception {
		assertCompilesTo(
				"final java.util.function.Consumer<String[]> _function = new java.util.function.Consumer<String[]>() {\n" + 
				"  public void accept(final String[] it) {\n" + 
				"    ((java.util.List<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(it)).subList(1, 1);\n" +
				"  }\n" + 
				"};\n" + 
				"((Iterable<String[]>) null).forEach(_function);", 
				"(null as Iterable<String[]>).forEach[ it.subList(1,1) ]");
	}
	
	@Test public void testExplicitReferenceToSynonym_02() throws Exception {
		assertCompilesTo(
				"final java.util.function.Consumer<String[]> _function = new java.util.function.Consumer<String[]>() {\n" + 
				"  public void accept(final String[] it) {\n" + 
				"    ((java.util.List<String>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(it)).size();\n" +
				"  }\n" + 
				"};\n" + 
				"((Iterable<String[]>) null).forEach(_function);", 
				"(null as Iterable<String[]>).forEach[ it.size ]");
	}
	
	@Test public void testExplicitReferenceToSynonymWithPrimitives() throws Exception {
		assertCompilesTo(
				"final java.util.function.Consumer<int[]> _function = new java.util.function.Consumer<int[]>() {\n" + 
				"  public void accept(final int[] it) {\n" + 
				"    ((java.util.List<Integer>)org.eclipse.xtext.xbase.lib.Conversions.doWrapArray(it)).subList(1, 1);\n" +
				"  }\n" + 
				"};\n" + 
				"((Iterable<int[]>) null).forEach(_function);", 
				"(null as Iterable<int[]>).forEach[ it.subList(1,1) ]");
	}
	
	@Test public void testExplicitReferenceToArray() throws Exception {
		assertCompilesTo(
				"final java.util.function.Consumer<String[]> _function = new java.util.function.Consumer<String[]>() {\n" + 
				"  public void accept(final String[] it) {\n" + 
				"    int _length = it.length;\n" +
				"    org.eclipse.xtext.xbase.lib.InputOutput.<Integer>println(Integer.valueOf(_length));\n" + 
				"  }\n" + 
				"};\n" + 
				"((Iterable<String[]>) null).forEach(_function);", 
				"(null as Iterable<String[]>).forEach[ println(it.length) ]");
	}
	
	@Test public void testFieldAccessDontGetAVariableDeclaration() throws Exception {
		assertCompilesTo(
				"\ntestdata.Properties1 _properties1 = new testdata.Properties1();" + 
				"\nreturn _properties1.prop1;", 
				"new testdata.Properties1().prop1");
	}

	@Test public void testNull() throws Exception {
		assertCompilesToStatement(
				"\n/* null */", 
				"null");
	}
	
	@Test public void testStringLiteralInComment() throws Exception {
		assertCompilesToStatement(
				"\n/* \"* /\" */", 
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
				"  public void apply(final Integer i) {\n" + 
				"    new Object();\n" + 
				"    new Object();\n" + 
				"  }\n" + 
				"};\n" + 
				"org.eclipse.xtext.xbase.lib.Procedures.Procedure1<? super Integer> fun = _function;", 
				"{ var (int)=>void fun = [ int i | new Object() new Object() ] }");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_04() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object it = new Object();\n" +
				"it.notify();",
				"{ var it = new Object() notify }");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_05() throws Exception {
		assertCompilesTo(
				"\n" + 
				"{\n" +
				"  Object it = new Object();\n" +
				"  it.notify();\n" +
				"}\n" +
				"{\n" +
				"  Object it = new Object();\n" +
				"  it.notify();\n" +
				"}",
				"{ { var it = new Object() notify } { var it = new Object() notify } }");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_06() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object it = new Object();\n" + 
				"{\n" + 
				"  Object it_1 = new Object();\n" + 
				"  it_1.notify();\n" + 
				"}\n" + 
				"it.notify();",
				"{ var it = new Object() { var it = new Object() it.notify() } notify }");
	}
	
	@Test public void testBlockHasNoSuperfluousBraces_07() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object it = new Object();\n" + 
				"Object _object = new Object();\n" + 
				"_object.notify();\n" + 
				"it.notify();",
				"{ var it = new Object() { new Object().notify() } notify }");
	}
	
	@Test
	public void testNoUnneccessaryConversionStatement() throws Exception {
		assertCompilesTo(
				"String _xblockexpression = null;\n" + 
				"{\n" + 
				"  final testdata.Properties1 x = new testdata.Properties1();\n" +  
				"  _xblockexpression = x.toString();\n" + 
				"}\n" + 
				"return _xblockexpression;",
				"{ val x = new testdata.Properties1() x.toString()}");
	}
	
	@Test public void testBlock() throws Exception {
		assertCompilesTo(
				"\nint _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  final java.util.ArrayList<String> it = new java.util.ArrayList<String>();\n" +
				"  _xblockexpression = it.size();\n" +
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
				"  _xblockexpression = x;\n" + 
				"}\n" + 
				"return _xblockexpression;",
				"{val x = newArrayList('foo')\n" +
				"x}");
	}
	
	@Test public void testNullSafeFeatureCall_01() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object _object = new Object();\n" +
				"if (_object!=null) {\n" +
				"  _object.notify();\n" +
				"}",
				"new Object()?.notify");
	}
	
	@Test public void testNullSafeFeatureCall_02() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object _object = new Object();\n" +
				"String _string = _object.toString();\n" +
				"if (_string!=null) {\n" +
				"  _string.notify();\n" +
				"}",
				"new Object().toString?.notify");
	}
	
	@Test public void testNullSafeFeatureCall_03() throws Exception {
		assertCompilesTo(
				"\n" + 
				"Object _object = new Object();\n" +
				"String _string = null;\n" +
				"if (_object!=null) {\n" +
				"  _string=_object.toString();\n" +
				"}\n" +
				"if (_string!=null) {\n" +
				"  _string.notify();\n" +
				"}",
				"new Object()?.toString?.notify");
	}
	
	@Test public void testNullSafeFeatureCall_04() throws Exception {
		assertCompilesTo(
				"\n" + 
				"String _string = new String();\n" +
				"String _substring = null;\n" +
				"if (_string!=null) {\n" +
				"  _substring=_string.substring(1);\n" +
				"}\n" +
				"int _length = 0;\n" +
				"if (_substring!=null) {\n" +
				"  _length=_substring.length();\n" +
				"}\n" +
				"return _length;",
				"new String()?.substring(1)?.length");
	}
	
	@Test public void testNullSafeFeatureCall_05() throws Exception {
		assertCompilesTo(
				"\n" + 
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int x = 0;\n" +
				"  String _string = new String();\n" +
				"  if (_string!=null) {\n" +
				"    _string.substring(x = 2);\n" +
				"  }\n" +
				"  _xblockexpression = x;\n" +
				"}\n" +
				"return _xblockexpression;",
				"{var x = 0; new String()?.substring(x=2); x}");
	}
	
	@Test public void testNullSafeFeatureCall_06() throws Exception {
		assertCompilesTo(
				"\n" + 
				"String s = new String();\n" + 
				"String _string = null;\n" + 
				"if (s!=null) {\n" + 
				"  _string=s.toString();\n" + 
				"}\n" + 
				"return _string;", 
				"{ var s = new String; return s?.toString() }");
	}
	
	@Test public void testInline_01() throws Exception {
		assertCompilesTo(
				"\n" + 
				"String _string = (\"a\" + \"b\").toString();\n" + 
				"return _string;",
				"('a'+'b').toString");
	}
	
	@Test public void testInline_02() throws Exception {
		assertCompilesTo(
				"\n" + 
				"boolean _xifexpression = false;\n" + 
				"if ((!true)) {\n" +
				"  _xifexpression = (true == false);\n" +
				"} else {\n" +
				"  _xifexpression = (true != false);\n" +
				"}\n" + 
				"return _xifexpression;",
				"if(!true) true==false else true!=false");
	}
	
	@Test public void testSwitch_01() throws Exception {
		assertCompilesTo("String _xblockexpression = null;\n" + 
				"{\n" + 
				"  final Object o = \"foo\";\n" + 
				"  boolean _matched = false;\n" + 
				"  if (o instanceof String) {\n" + 
				"    _matched=true;\n" + 
				"    \"\".toString();\n" + 
				"  }\n" + 
				"  String _switchResult_1 = null;\n" + 
				"  boolean _matched_1 = false;\n" + 
				"  if (o instanceof String) {\n" + 
				"    _matched_1=true;\n" + 
				"    _switchResult_1 = \"\";\n" + 
				"  }\n" + 
				"  _xblockexpression = _switchResult_1;\n" + 
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
	
	@Test
	public void testSwitchTypeGuards_01() throws Exception {
		assertCompilesTo(
				"String _switchResult = null;\n" + 
				"final CharSequence x = ((CharSequence) \"foo\");\n" + 
				"boolean _matched = false;\n" + 
				"if (x instanceof String) {\n" + 
				"  _matched=true;\n" + 
				"  String _substring = ((String)x).substring(3);\n" + 
				"  _switchResult = (_substring + ((String)x));\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (x instanceof Comparable) {\n" + 
				"    _matched=true;\n" + 
				"    int _compareTo = ((Comparable)x).compareTo(\"jho\");\n" + 
				"    String _plus = (\"\" + Integer.valueOf(_compareTo));\n" + 
				"    String _string = x.toString();\n" + 
				"    _switchResult = (_plus + _string);\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;"
				, 
				"switch x : 'foo' as CharSequence {" +
				"  String : x.substring(3) + x " +
				"  Comparable : '' + x.compareTo('jho') + x.toString" +
				"}");
	}
	
	@Test public void testSwitchTypeGuards_02() throws Exception {
		assertCompilesTo(
				"String _switchResult = null;\n" + 
				"final CharSequence x = ((CharSequence) \"foo\");\n" + 
				"boolean _matched = false;\n" + 
				"if (x instanceof String) {\n" + 
				"  _matched=true;\n" + 
				"  String _substring = ((String)x).substring(3);\n" + 
				"  _switchResult = (_substring + ((String)x));\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (x instanceof Comparable) {\n" + 
				"    _matched=true;\n" + 
				"    int _compareTo = ((Comparable<String>)x).compareTo(\"jho\");\n" + 
				"    String _plus = (\"\" + Integer.valueOf(_compareTo));\n" + 
				"    int _length = x.length();\n" + 
				"    _switchResult = (_plus + Integer.valueOf(_length));\n" + 
				"  }\n" + 
				"}\n" + 
				"return _switchResult;"
				, 
				"switch x : 'foo' as CharSequence {" +
				"  String : x.substring(3) + x " +
				"  Comparable<String> : '' + x.compareTo('jho') + x.length" +
				"}");
	}
	
	/*
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=371306
	 */
	@Test public void testSwitchEarlyExits() throws Exception {
		assertCompilesTo(
				"final boolean _switchValue = true;\n" + 
				"boolean _matched = false;\n" + 
				"if (true) {\n" + 
				"  _matched=true;\n" + 
				"  return 1;\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (false) {\n" + 
				"    _matched=true;\n" + 
				"    return (-1);\n" + 
				"  }\n" + 
				"}\n" +
				"return 0;" 
				, 
				"switch true {" +
				"  case true: return 1" +
				"  case false: return -1" +
				"  default: return 0" +
				"}");
	}
	
	/*
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=371306
	 */
	@Test public void testSwitchEarlyExits_1() throws Exception {
		assertCompilesTo(
				"int _switchResult = (int) 0;\n" + 
				"final boolean _switchValue = true;\n" + 
				"boolean _matched = false;\n" + 
				"if (true) {\n" + 
				"  _matched=true;\n" + 
				"  _switchResult = 1;\n" + 
				"}\n" + 
				"if (!_matched) {\n" + 
				"  if (false) {\n" + 
				"    _matched=true;\n" + 
				"    return (-1);\n" + 
				"  }\n" + 
				"}\n" +
				"if (!_matched) {\n" + 
				"  return 0;\n" + 
				"}\n" + 
				"return _switchResult;" 
				, 
				"switch true {" +
				"  case true: 1" +
				"  case false: return -1" +
				"  default: return 0" +
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
				"java.util.ArrayList<String> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\n" + 
				"  (\"foo\" + \n" + 
				"    \"bar\"));\n" + 
				"return _newArrayList;",
				"newArrayList(\n'foo' + \n'bar')");
	}
	
	@Test public void testNewLines_forExtensionMethod() throws Exception {
		assertCompilesTo(
				"String _firstUpper = org.eclipse.xtext.xbase.lib.StringExtensions.toFirstUpper(\"foo\");\n" + 
				"return _firstUpper;", 
				"\n'foo'.toFirstUpper");
	}
	
	@Test public void testSetLiteral() throws Exception {
		assertCompilesTo(
				"return java.util.Collections.<String>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newHashSet(\"foo\"));\n",
				"#{'foo'}");
	}
	
	@Test public void testMapLiteral() throws Exception {
		assertCompilesTo(
				"org.eclipse.xtext.xbase.lib.Pair<String, Integer> _mappedTo = org.eclipse.xtext.xbase.lib.Pair.<String, Integer>of(\"foo\", Integer.valueOf(42));\n"+
				"return java.util.Collections.<String, Integer>unmodifiableMap(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String, Integer>newHashMap(_mappedTo));\n",
				"#{'foo'->42}");
	}
	
	@Test public void testListLiteralAsList() throws Exception {
		assertCompilesTo(
				"return java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"foo\"));\n",
				"#['foo']");
	}

	@Test public void testListLiteralAsArray() throws Exception {
		assertCompilesTo(
				"final String[] x = { \"foo\" };",
				"{val String[] x = #['foo']}");
	}

	@Test public void testExceptionOnClosure() throws Exception {
		assertCompilesTo(
				"final java.beans.VetoableChangeListener _function = new java.beans.VetoableChangeListener() {\n" + 
				"  public void vetoableChange(final java.beans.PropertyChangeEvent it) throws java.beans.PropertyVetoException {\n" + 
				"  }\n" + 
				"};\n" + 
				"final java.beans.VetoableChangeListener x = _function;",
				"{val java.beans.VetoableChangeListener x = []}");
	}
}
