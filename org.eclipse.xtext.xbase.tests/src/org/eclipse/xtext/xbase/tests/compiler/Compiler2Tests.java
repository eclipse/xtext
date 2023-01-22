/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.compiler;

import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.compiler.output.FakeTreeAppendable;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

public class Compiler2Tests extends AbstractOutputComparingCompilerTests {

	@Override
	protected FakeTreeAppendable createAppendable() {
		return new FakeTreeAppendable();
	}

	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=424279
	 */
	@Test
	public void testBug_424279() throws Exception {
		compilesTo(
				"{\n" +
				"	val treeIt = <CharSequence>newArrayList.iterator;\n" +
				"	while (treeIt.hasNext) {\n" +
				"		val o = treeIt.next;\n" +
				"		if (o instanceof java.util.List<?>) {\n" +
				"			return o;\n" +
				"		} else {\n" +
				"			return o;\n" +
				"		}\n" +
				"	}\n" +
				"	return null;\n" +
				"}\n",
				"\n" +
				"final java.util.Iterator<CharSequence> treeIt = org.eclipse.xtext.xbase.lib.CollectionLiterals.<CharSequence>newArrayList().iterator();\n" +
				"while (treeIt.hasNext()) {\n" +
				"  {\n" +
				"    final CharSequence o = treeIt.next();\n" +
				"    if ((o instanceof java.util.List<?>)) {\n" +
				"      return o;\n" +
				"    } else {\n" +
				"      return o;\n" +
				"    }\n" +
				"  }\n" +
				"}\n" +
				"return null;\n");
	}

	@Test
	public void testAbstractIterator() throws Exception {
		compilesTo(
				"{\n" +
				"	var com.google.common.collect.AbstractIterator<String> iter = [| return self.endOfData ]\n" +
				"	return iter\n" +
				"}\n",
				"\n" +
				"final com.google.common.collect.AbstractIterator<String> _function = new com.google.common.collect.AbstractIterator<String>() {\n" +
				"  @Override\n" +
				"  protected String computeNext() {\n" +
				"    return this.endOfData();\n" +
				"  }\n" +
				"};\n" +
				"com.google.common.collect.AbstractIterator<String> iter = _function;\n" +
				"return iter;\n");
	}

	@Test
	public void testVariableDeclaration() throws Exception {
		compilesTo(
				"{\n" +
				"	val x = 42\n" +
				"}\n", "\n" +
				"final int x = 42;\n");
	}

	@Test
	public void testVariableDeclaration1() throws Exception {
		compilesTo(
				"{\n" +
				"	val a = 'foo'\n" +
				"	val x = a\n" +
				"}\n", "\n" +
				"final String a = \"foo\";\n" +
				"final String x = a;\n");
	}

	@Test
	public void testVariableDeclaration2() throws Exception {
		compilesTo(
				"{\n" +
				"	val x = 'foo'.toUpperCase\n" +
				"}\n", "\n" +
				"final String x = \"foo\".toUpperCase();\n");
	}

	@Test
	public void testBug367144() throws Exception {
		compilesTo(
				"foo::bar::SubOfClassWithStatics::MY_STATIC_FIELD\n", "\n" +
				"return foo.bar.SubOfClassWithStatics.MY_STATIC_FIELD;\n");
	}

	@Test
	public void testBug367144_1() throws Exception {
		compilesTo(
				"foo::bar::SubOfClassWithStatics::MY_STATIC_METHOD\n",
				"\n" +
				"String _MY_STATIC_METHOD = foo.bar.SubOfClassWithStatics.MY_STATIC_METHOD();\n" +
				"return _MY_STATIC_METHOD;\n");
	}

	@Test
	public void testBug371321_1() throws Exception {
		compilesTo(
				"try {\n" +
				"	'foo'.length\n" +
				"} catch (RuntimeException assert) {\n" +
				"	assert.printStackTrace\n" +
				"}\n",
				"\n" +
				"int _xtrycatchfinallyexpression = (int) 0;\n" +
				"try {\n" +
				"  _xtrycatchfinallyexpression = \"foo\".length();\n" +
				"} catch (final Throwable _t) {\n" +
				"  if (_t instanceof RuntimeException) {\n" +
				"    final RuntimeException assert_ = (RuntimeException)_t;\n" +
				"    assert_.printStackTrace();\n" +
				"  } else {\n" +
				"    throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_t);\n" +
				"  }\n" +
				"}\n" +
				"return Integer.valueOf(_xtrycatchfinallyexpression);\n");
	}

	@Test
	public void testBug420984_EmptyCatch() throws Exception {
		compilesTo(
				"try {\n" +
				"	println(\"\")\n" +
				"} catch (RuntimeException e) {\n" +
				"}\n",
				"\n" +
				"String _xtrycatchfinallyexpression = null;\n" +
				"try {\n" +
				"  _xtrycatchfinallyexpression = org.eclipse.xtext.xbase.lib.InputOutput.<String>println(\"\");\n" +
				"} catch (final Throwable _t) {\n" +
				"  if (_t instanceof RuntimeException) {\n" +
				"    _xtrycatchfinallyexpression = null;\n" +
				"  } else {\n" +
				"    throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_t);\n" +
				"  }\n" +
				"}\n" +
				"return _xtrycatchfinallyexpression;\n");
	}

	@Test
	public void testBug420984_EmptyCatchWithoutReturnType() throws Exception {
		compilesToStatement(
				"try {\n" +
				"  println(\"\")\n" +
				"} catch (RuntimeException e) {\n" +
				"}\n",
				"try {\n" +
				"  org.eclipse.xtext.xbase.lib.InputOutput.<String>println(\"\");\n" +
				"} catch (final Throwable _t) {\n" +
				"  if (_t instanceof RuntimeException) {\n" +
				"  } else {\n" +
				"    throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_t);\n" +
				"  }\n" +
				"}");
	}

	@Test
	public void testBug420984_CatchWithoutReference() throws Exception {
		compilesTo(
				"try {\n" +
				"	println(\"\")\n" +
				"} catch (RuntimeException e) {\n" +
				"	println(\"\")\n" +
				"}\n",
				"\n" +
				"String _xtrycatchfinallyexpression = null;\n" +
				"try {\n" +
				"  _xtrycatchfinallyexpression = org.eclipse.xtext.xbase.lib.InputOutput.<String>println(\"\");\n" +
				"} catch (final Throwable _t) {\n" +
				"  if (_t instanceof RuntimeException) {\n" +
				"    _xtrycatchfinallyexpression = org.eclipse.xtext.xbase.lib.InputOutput.<String>println(\"\");\n" +
				"  } else {\n" +
				"    throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_t);\n" +
				"  }\n" +
				"}\n" +
				"return _xtrycatchfinallyexpression;\n");
	}

	@Test
	public void testBug420984_CatchWithReference() throws Exception {
		compilesTo(
				"try {\n" +
				"	println(\"\")\n" +
				"} catch (RuntimeException e) {\n" +
				"	println(e)\n" +
				"}\n",
				"\n" +
				"java.io.Serializable _xtrycatchfinallyexpression = null;\n" +
				"try {\n" +
				"  _xtrycatchfinallyexpression = org.eclipse.xtext.xbase.lib.InputOutput.<String>println(\"\");\n" +
				"} catch (final Throwable _t) {\n" +
				"  if (_t instanceof RuntimeException) {\n" +
				"    final RuntimeException e = (RuntimeException)_t;\n" +
				"    _xtrycatchfinallyexpression = org.eclipse.xtext.xbase.lib.InputOutput.<RuntimeException>println(e);\n" +
				"  } else {\n" +
				"    throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_t);\n" +
				"  }\n" +
				"}\n" +
				"return _xtrycatchfinallyexpression;\n");
	}

	@Test
	public void testBug371321_2() throws Exception {
		compilesTo(
				"for (assert : 'foo'.toCharArray) {\n" +
				"	println(assert)\n" +
				"}\n",
				"\n" +
				"char[] _charArray = \"foo\".toCharArray();\n" +
				"for (final char assert_ : _charArray) {\n" +
				"  org.eclipse.xtext.xbase.lib.InputOutput.<Character>println(Character.valueOf(assert_));\n" +
				"}\n");
	}

	@Test
	public void testNewThread() throws Exception {
		compilesTo(
				"new Thread [| ]\n",
				"\n" +
				"final Runnable _function = new Runnable() {\n" +
				"  public void run() {\n" +
				"  }\n" +
				"};\n" +
				"Thread _thread = new Thread(_function);\n" +
				"return _thread;\n");
	}

	@Test
	public void testForLoop_01() throws Exception {
		compilesTo(
				"for(int i: 1..2) { i.toString }\n",
				"\n" +
				"org.eclipse.xtext.xbase.lib.IntegerRange _upTo = new org.eclipse.xtext.xbase.lib.IntegerRange(1, 2);\n" +
				"for (final int i : _upTo) {\n" +
				"  Integer.valueOf(i).toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_02() throws Exception {
		compilesTo(
				"for(Integer i: 1..2) { i.toString }\n",
				"\n" +
				"org.eclipse.xtext.xbase.lib.IntegerRange _upTo = new org.eclipse.xtext.xbase.lib.IntegerRange(1, 2);\n" +
				"for (final Integer i : _upTo) {\n" +
				"  i.toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_03() throws Exception {
		compilesTo(
				"for(i: 1..2) { i.toString }\n",
				"\n" +
				"org.eclipse.xtext.xbase.lib.IntegerRange _upTo = new org.eclipse.xtext.xbase.lib.IntegerRange(1, 2);\n" +
				"for (final Integer i : _upTo) {\n" +
				"  i.toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_04() throws Exception {
		compilesTo(
				"for(i: null as int[]) { i.toString }\n",
				"\n" +
				"for (final int i : ((int[]) null)) {\n" +
				"  Integer.valueOf(i).toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_05() throws Exception {
		compilesTo(
				"for(i: null as Integer[]) { i.toString }\n", "\n" +
				"for (final Integer i : ((Integer[]) null)) {\n" +
				"  i.toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_06() throws Exception {
		compilesTo(
				"for(Integer i: null as int[]) { i.toString }\n", "\n" +
				"for (final Integer i : ((int[]) null)) {\n" +
				"  i.toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_07() throws Exception {
		compilesTo(
				"for(int i: null as Integer[]) { i.toString }\n",
				"\n" +
				"for (final int i : ((Integer[]) null)) {\n" +
				"  Integer.valueOf(i).toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_08() throws Exception {
		compilesTo(
				"for(Integer i: null as int[]) { i.toString }\n", "\n" +
				"for (final Integer i : ((int[]) null)) {\n" +
				"  i.toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_09() throws Exception {
		compilesTo(
				"for(int i: null as Integer[]) { i.toString }\n",
				"\n" +
				"for (final int i : ((Integer[]) null)) {\n" +
				"  Integer.valueOf(i).toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_10() throws Exception {
		compilesTo(
				"for(int i: newArrayList) { i.toString }\n",
				"\n" +
				"java.util.ArrayList<Integer> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList();\n" +
				"for (final int i : _newArrayList) {\n" +
				"  Integer.valueOf(i).toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_11() throws Exception {
		compilesTo(
				"for(Integer i: newArrayList) { i.toString }\n",
				"\n" +
				"java.util.ArrayList<Integer> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList();\n" +
				"for (final Integer i : _newArrayList) {\n" +
				"  i.toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_12() throws Exception {
		compilesTo(
				"for(double d: <Integer>newArrayList) { d.toString }\n",
				"\n" +
				"java.util.ArrayList<Integer> _newArrayList = org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList();\n" +
				"for (final double d : _newArrayList) {\n" +
				"  Double.valueOf(d).toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_13() throws Exception {
		compilesTo(
				"for(double d: null as int[]) { d.toString }\n",
				"\n" +
				"for (final double d : ((int[]) null)) {\n" +
				"  Double.valueOf(d).toString();\n" +
				"}\n");
	}

	@Test
	public void testForLoop_14() throws Exception {
		compilesTo(
				"for(double d: null as Integer[]) { d.toString }\n",
				"\n" +
				"for (final double d : ((Integer[]) null)) {\n" +
				"  Double.valueOf(d).toString();\n" +
				"}\n");
	}

	@Test
	public void testNullSafe_01() throws Exception {
		compilesTo(
				"('foo'.toUpperCase as CharSequence)?.subSequence(0,2)\n",
				"\n" +
				"String _upperCase = \"foo\".toUpperCase();\n" +
				"CharSequence _subSequence = null;\n" +
				"if (((CharSequence) _upperCase)!=null) {\n" +
				"  _subSequence=((CharSequence) _upperCase).subSequence(0, 2);\n" +
				"}\n" +
				"return _subSequence;\n");
	}

	@Test
	public void testSwitch() throws Exception {
		compilesTo(
				"{\n" +
				"	val it = String\n" +
				"	switch name {\n" +
				"		CharSequence : name\n" +
				"		default : 'noname'\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"String _xblockexpression = null;\n" +
				"{\n" +
				"  final Class<String> it = String.class;\n" +
				"  String _switchResult = null;\n" +
				"  String _name = it.getName();\n" +
				"  boolean _matched = false;\n" +
				"  if (_name instanceof CharSequence) {\n" +
				"    _matched=true;\n" +
				"    _switchResult = it.getName();\n" +
				"  }\n" +
				"  if (!_matched) {\n" +
				"    _switchResult = \"noname\";\n" +
				"  }\n" +
				"  _xblockexpression = _switchResult;\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testSwitchScopes_Bug470586_01() throws Exception {
		compilesTo(
				"\n" +
				"{\n" +
				"	val list = #[\"1\", \"2\"]\n" +
				"	list.forEach[\n" +
				"		val res = switch it {\n" +
				"			CharSequence : it\n" +
				"		}\n" +
				"	]\n" +
				"	list.forEach[\n" +
				"		println(it)\n" +
				"	]\n" +
				"}\n",
				"\n" +
				"final java.util.List<String> list = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"1\", \"2\"));\n" +
				"final java.util.function.Consumer<String> _function = new java.util.function.Consumer<String>() {\n" +
				"  public void accept(final String it) {\n" +
				"    String _switchResult = null;\n" +
				"    boolean _matched = false;\n" +
				"    if (it instanceof CharSequence) {\n" +
				"      _matched=true;\n" +
				"      _switchResult = it;\n" +
				"    }\n" +
				"    final String res = _switchResult;\n" +
				"  }\n" +
				"};\n" +
				"list.forEach(_function);\n" +
				"final java.util.function.Consumer<String> _function_1 = new java.util.function.Consumer<String>() {\n" +
				"  public void accept(final String it) {\n" +
				"    org.eclipse.xtext.xbase.lib.InputOutput.<String>println(it);\n" +
				"  }\n" +
				"};\n" +
				"list.forEach(_function_1);\n");
	}

	@Test
	public void testSwitchScopes_Bug470586_02() throws Exception {
		compilesTo(
				"{\n" +
				"	val list = #[\"1\", \"2\"]\n" +
				"	list.forEach[\n" +
				"		val res = switch it {\n" +
				"			CharSequence : it\n" +
				"			default : ''\n" +
				"		}\n" +
				"	]\n" +
				"	list.forEach[\n" +
				"		println(it)\n" +
				"	]\n" +
				"}\n",
				"\n" +
				"final java.util.List<String> list = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"1\", \"2\"));\n" +
				"final java.util.function.Consumer<String> _function = new java.util.function.Consumer<String>() {\n" +
				"  public void accept(final String it) {\n" +
				"    String _switchResult = null;\n" +
				"    boolean _matched = false;\n" +
				"    if (it instanceof CharSequence) {\n" +
				"      _matched=true;\n" +
				"      _switchResult = it;\n" +
				"    }\n" +
				"    if (!_matched) {\n" +
				"      _switchResult = \"\";\n" +
				"    }\n" +
				"    final String res = _switchResult;\n" +
				"  }\n" +
				"};\n" +
				"list.forEach(_function);\n" +
				"final java.util.function.Consumer<String> _function_1 = new java.util.function.Consumer<String>() {\n" +
				"  public void accept(final String it) {\n" +
				"    org.eclipse.xtext.xbase.lib.InputOutput.<String>println(it);\n" +
				"  }\n" +
				"};\n" +
				"list.forEach(_function_1);\n");
	}

	@Test
	public void testSwitchScopes_Bug470586_03() throws Exception {
		compilesTo(
				"{\n" +
				"	val list = #[\"1\", \"2\"]\n" +
				"	list.forEach[\n" +
				"		val res = switch it {\n" +
				"			String, CharSequence : it\n" +
				"			default : ''\n" +
				"		}\n" +
				"	]\n" +
				"	list.forEach[\n" +
				"		println(it)\n" +
				"	]\n" +
				"}\n",
				"\n" +
				"final java.util.List<String> list = java.util.Collections.<String>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"1\", \"2\"));\n" +
				"final java.util.function.Consumer<String> _function = new java.util.function.Consumer<String>() {\n" +
				"  public void accept(final String it) {\n" +
				"    String _switchResult = null;\n" +
				"    boolean _matched = false;\n" +
				"    if (it instanceof String) {\n" +
				"      _matched=true;\n" +
				"    }\n" +
				"    if (!_matched) {\n" +
				"      if (it instanceof CharSequence) {\n" +
				"        _matched=true;\n" +
				"      }\n" +
				"    }\n" +
				"    if (_matched) {\n" +
				"      _switchResult = it;\n" +
				"    }\n" +
				"    if (!_matched) {\n" +
				"      _switchResult = \"\";\n" +
				"    }\n" +
				"    final String res = _switchResult;\n" +
				"  }\n" +
				"};\n" +
				"list.forEach(_function);\n" +
				"final java.util.function.Consumer<String> _function_1 = new java.util.function.Consumer<String>() {\n" +
				"  public void accept(final String it) {\n" +
				"    org.eclipse.xtext.xbase.lib.InputOutput.<String>println(it);\n" +
				"  }\n" +
				"};\n" +
				"list.forEach(_function_1);\n");
	}

	@Test
	public void testFallThroughSwitch() throws Exception {
		compilesTo(
				"{\n" +
				"	switch x : 1 {\n" +
				"		case 1,\n" +
				"		case 2:\n" +
				"			'lalala'\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"String _switchResult = null;\n" +
				"final int x = 1;\n" +
				"switch (x) {\n" +
				"  case 1:\n" +
				"  case 2:\n" +
				"    _switchResult = \"lalala\";\n" +
				"    break;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testFallThroughSwitch_2() throws Exception {
		compilesTo(
				"{\n" +
				"	switch x : 'lalala' {\n" +
				"		case 'a',\n" +
				"		case 'b',\n" +
				"		case 'c':\n" +
				"			'lalala'\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"String _switchResult = null;\n" +
				"final String x = \"lalala\";\n" +
				"boolean _matched = false;\n" +
				"if (com.google.common.base.Objects.equal(x, \"a\")) {\n" +
				"  _matched=true;\n" +
				"}\n" +
				"if (!_matched) {\n" +
				"  if (com.google.common.base.Objects.equal(x, \"b\")) {\n" +
				"    _matched=true;\n" +
				"  }\n" +
				"}\n" +
				"if (!_matched) {\n" +
				"  if (com.google.common.base.Objects.equal(x, \"c\")) {\n" +
				"    _matched=true;\n" +
				"  }\n" +
				"}\n" +
				"if (_matched) {\n" +
				"  _switchResult = \"lalala\";\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testFallThroughSwitch_3() throws Exception {
		compilesTo(
				"{\n" +
				"	switch x : 1 {\n" +
				"		case 1,\n" +
				"		case 2,\n" +
				"		default:\n" +
				"			'lalala'\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"String _switchResult = null;\n" +
				"final int x = 1;\n" +
				"switch (x) {\n" +
				"  case 1:\n" +
				"  case 2:\n" +
				"  default:\n" +
				"    _switchResult = \"lalala\";\n" +
				"    break;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testFallThroughSwitch_4() throws Exception {
		compilesTo(
				"{\n" +
				"	switch x : 'lalala' {\n" +
				"		case 'a',\n" +
				"		case 'b',\n" +
				"		default:\n" +
				"			'lalala'\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"String _switchResult = null;\n" +
				"final String x = \"lalala\";\n" +
				"boolean _matched = false;\n" +
				"if (com.google.common.base.Objects.equal(x, \"a\")) {\n" +
				"  _matched=true;\n" +
				"}\n" +
				"if (!_matched) {\n" +
				"  if (com.google.common.base.Objects.equal(x, \"b\")) {\n" +
				"    _matched=true;\n" +
				"  }\n" +
				"}\n" +
				"if (_matched) {\n" +
				"  _switchResult = \"lalala\";\n" +
				"}\n" +
				"if (!_matched) {\n" +
				"  _switchResult = \"lalala\";\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testFallThroughSwitch_5() throws Exception {
		compilesTo(
				"{\n" +
				"	switch x : 1 {\n" +
				"		case 1:\n" +
				"			'blabla'\n" +
				"		case 2,\n" +
				"		default:\n" +
				"			'lalala'\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"String _switchResult = null;\n" +
				"final int x = 1;\n" +
				"switch (x) {\n" +
				"  case 1:\n" +
				"    _switchResult = \"blabla\";\n" +
				"    break;\n" +
				"  case 2:\n" +
				"  default:\n" +
				"    _switchResult = \"lalala\";\n" +
				"    break;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testFallThroughSwitch_6() throws Exception {
		compilesTo(
				"{\n" +
				"	switch x : new Object {\n" +
				"		String case 'a':\n" +
				"			'blabla'\n" +
				"		Integer case 1,\n" +
				"		case 2,\n" +
				"		default:\n" +
				"			'lalala'\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"String _switchResult = null;\n" +
				"Object _object = new Object();\n" +
				"final Object x = _object;\n" +
				"boolean _matched = false;\n" +
				"if (x instanceof String) {\n" +
				"  if (com.google.common.base.Objects.equal(x, \"a\")) {\n" +
				"    _matched=true;\n" +
				"    _switchResult = \"blabla\";\n" +
				"  }\n" +
				"}\n" +
				"if (!_matched) {\n" +
				"  if (x instanceof Integer) {\n" +
				"    if (com.google.common.base.Objects.equal(x, 1)) {\n" +
				"      _matched=true;\n" +
				"    }\n" +
				"  }\n" +
				"  if (!_matched) {\n" +
				"    if (com.google.common.base.Objects.equal(x, 2)) {\n" +
				"      _matched=true;\n" +
				"    }\n" +
				"  }\n" +
				"  if (_matched) {\n" +
				"    _switchResult = \"lalala\";\n" +
				"  }\n" +
				"}\n" +
				"if (!_matched) {\n" +
				"  _switchResult = \"lalala\";\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testFallThroughSwitch_7() throws Exception {
		compilesTo(
				"{\n" +
				"	switch x : 'lalala' as Object { \n" +
				"		String, Integer case 1: 0\n" +
				"		Integer, default: 1\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"int _switchResult = (int) 0;\n" +
				"final Object x = ((Object) \"lalala\");\n" +
				"boolean _matched = false;\n" +
				"if (x instanceof String) {\n" +
				"  _matched=true;\n" +
				"}\n" +
				"if (!_matched) {\n" +
				"  if (x instanceof Integer) {\n" +
				"    if (com.google.common.base.Objects.equal(x, 1)) {\n" +
				"      _matched=true;\n" +
				"    }\n" +
				"  }\n" +
				"}\n" +
				"if (_matched) {\n" +
				"  _switchResult = 0;\n" +
				"}\n" +
				"if (!_matched) {\n" +
				"  if (x instanceof Integer) {\n" +
				"    _matched=true;\n" +
				"    _switchResult = 1;\n" +
				"  }\n" +
				"}\n" +
				"if (!_matched) {\n" +
				"  _switchResult = 1;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testFallThroughSwitch_8() throws Exception {
		compilesTo(
				"{\n" +
				"	switch x : 1 as Object {\n" +
				"		Integer,\n" +
				"		Double: x\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Number _switchResult = null;\n" +
				"final Object x = ((Object) Integer.valueOf(1));\n" +
				"boolean _matched = false;\n" +
				"if (x instanceof Integer) {\n" +
				"  _matched=true;\n" +
				"}\n" +
				"if (!_matched) {\n" +
				"  if (x instanceof Double) {\n" +
				"    _matched=true;\n" +
				"  }\n" +
				"}\n" +
				"if (_matched) {\n" +
				"  _switchResult = ((Number)x);\n" +
				"}\n" +
				"return ((Number)_switchResult);\n");
	}

	@Test
	public void testEmptySwitch() throws Exception {
		compilesTo(
				"{\n" +
				"	switch 1 {\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _switchResult = null;\n" +
				"final int _switchValue = 1;\n" +
				"switch (_switchValue) {\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testEmptySwitch_2() throws Exception {
		compilesTo(
				"{\n" +
				"	switch 1 {\n" +
				"		default: {\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _switchResult = null;\n" +
				"final int _switchValue = 1;\n" +
				"switch (_switchValue) {\n" +
				"  default:\n" +
				"    _switchResult = null;\n" +
				"    break;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testEmptySwitch_3() throws Exception {
		compilesTo(
				"{\n" +
				"	switch Object {\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _switchResult = null;\n" +
				"final Class<Object> Object = Object.class;\n" +
				"boolean _matched = false;\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testEmptySwitch_4() throws Exception {
		compilesTo(
				"{\n" +
				"	switch Object {\n" +
				"		default: {\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _switchResult = null;\n" +
				"final Class<Object> Object = Object.class;\n" +
				"boolean _matched = false;\n" +
				"if (!_matched) {\n" +
				"  _switchResult = null;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testEmptySwitch_5() throws Exception {
		compilesTo(
				"{\n" +
				"	switch Thread.State.NEW {\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _switchResult = null;\n" +
				"final Thread.State _switchValue = Thread.State.NEW;\n" +
				"if (_switchValue != null) {\n" +
				"  switch (_switchValue) {\n" +
				"    default:\n" +
				"      break;\n" +
				"  }\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testEmptySwitch_6() throws Exception {
		compilesTo(
				"{\n" +
				"	switch Thread.State.NEW {\n" +
				"		default: {\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _switchResult = null;\n" +
				"final Thread.State _switchValue = Thread.State.NEW;\n" +
				"if (_switchValue != null) {\n" +
				"  switch (_switchValue) {\n" +
				"    default:\n" +
				"      _switchResult = null;\n" +
				"      break;\n" +
				"  }\n" +
				"} else {\n" +
				"  _switchResult = null;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testEmptySwitch_7() throws Exception {
		compilesTo(
				"{\n" +
				"	switch Thread.State x : Thread.State.NEW {\n" +
				"		default: {\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _switchResult = null;\n" +
				"final Thread.State x = Thread.State.NEW;\n" +
				"if (x != null) {\n" +
				"  switch (x) {\n" +
				"    default:\n" +
				"      _switchResult = null;\n" +
				"      break;\n" +
				"  }\n" +
				"} else {\n" +
				"  _switchResult = null;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testEmptySwitch_8() throws Exception {
		compilesTo(
				"{\n" +
				"	switch (Thread.State x : Thread.State.NEW) {\n" +
				"		default: {\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _switchResult = null;\n" +
				"final Thread.State x = Thread.State.NEW;\n" +
				"if (x != null) {\n" +
				"  switch (x) {\n" +
				"    default:\n" +
				"      _switchResult = null;\n" +
				"      break;\n" +
				"  }\n" +
				"} else {\n" +
				"  _switchResult = null;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testEmptySwitch_9() throws Exception {
		compilesTo(
				"{\n" +
				"	switch Object x : Thread.State.NEW {\n" +
				"		default: {\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _switchResult = null;\n" +
				"final Object x = Thread.State.NEW;\n" +
				"boolean _matched = false;\n" +
				"if (!_matched) {\n" +
				"  _switchResult = null;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testEmptySwitch_10() throws Exception {
		compilesTo(
				"{\n" +
				"	switch (Object x : Thread.State.NEW) {\n" +
				"		default: {\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _switchResult = null;\n" +
				"final Object x = Thread.State.NEW;\n" +
				"boolean _matched = false;\n" +
				"if (!_matched) {\n" +
				"  _switchResult = null;\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testEmptySwitch_11() throws Exception {
		GeneratorConfig _generatorConfig = new GeneratorConfig();
		final Procedure1<GeneratorConfig> _function = (GeneratorConfig it) -> {
			it.setJavaSourceVersion(JavaVersion.JAVA8);
		};
		GeneratorConfig _doubleArrow = ObjectExtensions.<GeneratorConfig> operator_doubleArrow(_generatorConfig, _function);
		compilesTo(
				"{\n" +
				"	val String x = null\n" +
				"	switch (x) {\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"Object _xblockexpression = null;\n" +
				"{\n" +
				"  final String x = null;\n" +
				"  Object _switchResult = null;\n" +
				"  if (x != null) {\n" +
				"    switch (x) {\n" +
				"    }\n" +
				"  }\n" +
				"  _xblockexpression = _switchResult;\n" +
				"}\n" +
				"return _xblockexpression;\n",
				_doubleArrow);
	}

	@Test
	public void testBasicForLoop_0() throws Exception {
		compilesTo(
				"{\n" +
				"	for (var i = 0; i < 10; i = i + 1) {\n" +
				"	}\n" +
				"}\n", "\n" +
				"for (int i = 0; (i < 10); i = (i + 1)) {\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_toJavaWhile_0() throws Exception {
		compilesTo(
				"{\n" +
				"	for (var i = if (true) { 1 }; i < 10; i = i + 1) {\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"int _xifexpression = (int) 0;\n" +
				"if (true) {\n" +
				"  _xifexpression = 1;\n" +
				"}\n" +
				"int i = _xifexpression;\n" +
				"boolean _while = (i < 10);\n" +
				"while (_while) {\n" +
				"  i = (i + 1);\n" +
				"  _while = (i < 10);\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_1() throws Exception {
		compilesTo(
				"{\n" +
				"	for (;;) {\n" +
				"	}\n" +
				"}\n", "\n" +
				"for (;;) {\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_toJavaWhile_1() throws Exception {
		compilesTo(
				"{\n" +
				"	for (for (;;) {};;) {\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"for (;;) {\n" +
				"}\n" +
				"boolean _while = true;\n" +
				"while (_while) {\n" +
				"  _while = true;\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_2() throws Exception {
		compilesTo(
				"{\n" +
				"	for (val i = 0; i < 10;) {\n" +
				"		if (i == 2) {\n" +
				"			return true;\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"for (final int i = 0; (i < 10);) {\n" +
				"  if ((i == 2)) {\n" +
				"    return Boolean.valueOf(true);\n" +
				"  }\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_toJavaWhile_2() throws Exception {
		compilesTo(
				"{\n" +
				"	for (val i = #[if(true) {1} else {2}]; i.head < 10;) {\n" +
				"		if (i.head == 2) {\n" +
				"			return true;\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"int _xifexpression = (int) 0;\n" +
				"if (true) {\n" +
				"  _xifexpression = 1;\n" +
				"} else {\n" +
				"  _xifexpression = 2;\n" +
				"}\n" +
				"final java.util.List<Integer> i = java.util.Collections.<Integer>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Integer>newArrayList(Integer.valueOf(_xifexpression)));\n" +
				"Integer _head = org.eclipse.xtext.xbase.lib.IterableExtensions.<Integer>head(i);\n" +
				"boolean _lessThan = ((_head).intValue() < 10);\n" +
				"boolean _while = _lessThan;\n" +
				"while (_while) {\n" +
				"  Integer _head_1 = org.eclipse.xtext.xbase.lib.IterableExtensions.<Integer>head(i);\n" +
				"  boolean _equals = ((_head_1).intValue() == 2);\n" +
				"  if (_equals) {\n" +
				"    return Boolean.valueOf(true);\n" +
				"  }\n" +
				"  Integer _head_2 = org.eclipse.xtext.xbase.lib.IterableExtensions.<Integer>head(i);\n" +
				"  boolean _lessThan_1 = ((_head_2).intValue() < 10);\n" +
				"  _while = _lessThan_1;\n" +
				"}\n" +
				"return null;\n");
	}

	@Test
	public void testBasicForLoop_3() throws Exception {
		compilesTo(
				"{\n" +
				"	for (val i = 0; i < 10;) {\n" +
				"		return true\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"for (final int i = 0; (i < 10);) {\n" +
				"  return Boolean.valueOf(true);\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_4() throws Exception {
		compilesTo(
				"{\n" +
				"	for (var i = 1; i < 10;) {}\n" +
				"	for (val i = 1;;) {}\n" +
				"}\n",
				"\n" +
				"for (int i = 1; (i < 10);) {\n" +
				"}\n" +
				"for (final int i = 1;;) {\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_5() throws Exception {
		compilesTo(
				"{\n" +
				"	{\n" +
				"		for (var i = 1;i < 10;) {}\n" +
				"	}\n" +
				"	{\n" +
				"		for (val i = 1;;) {}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"for (int i = 1; (i < 10);) {\n" +
				"}\n" +
				"for (final int i = 1;;) {\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_6() throws Exception {
		compilesTo(
				"{\n" +
				"	if (true) {\n" +
				"		for (;;) {}\n" +
				"	}\n" +
				"}\n", "\n" +
				"if (true) {\n" +
				"  for (;;) {\n" +
				"  }\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_7() throws Exception {
		compilesTo(
				"{\n" +
				"	try {\n" +
				"		for (;;) {}\n" +
				"	} finally {\n" +
				"	}\n" +
				"}\n", "\n" +
				"try {\n" +
				"  for (;;) {\n" +
				"  }\n" +
				"} finally {\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_8() throws Exception {
		compilesTo(
				"{\n" +
				"	[| for (;;) {} ]\n" +
				"}\n",
				"\n" +
				"final org.eclipse.xtext.xbase.lib.Procedures.Procedure0 _function = new org.eclipse.xtext.xbase.lib.Procedures.Procedure0() {\n" +
				"  public void apply() {\n" +
				"    for (;;) {\n" +
				"    }\n" +
				"  }\n" +
				"};\n" +
				"return _function;\n");
	}

	@Test
	public void testBasicForLoop_9() throws Exception {
		compilesTo(
				"{\n" +
				"	{\n" +
				"		{\n" +
				"			{\n" +
				"				for (;;) {}\n" +
				"			}\n" +
				"		}\n" +
				"	}\n" +
				"}\n", "\n" +
				"for (;;) {\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_10() throws Exception {
		compilesTo(
				"{\n" +
				"	val i = 0\n" +
				"	for ([| i ].apply, [| i ].apply; i < 10;) {\n" +
				"		\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final int i = 0;\n" +
				"for (new org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>() {\n" +
				"  public Integer apply() {\n" +
				"    return Integer.valueOf(i);\n" +
				"  }\n" +
				"}.apply(), new org.eclipse.xtext.xbase.lib.Functions.Function0<Integer>() {\n" +
				"  public Integer apply() {\n" +
				"    return Integer.valueOf(i);\n" +
				"  }\n" +
				"}.apply(); (i < 10);) {\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_11() throws Exception {
		compilesTo(
				"{\n" +
				"	for (val i = 0, val j = 0; i < 10;) {\n" +
				"		\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final int i = 0;\n" +
				"final int j = 0;\n" +
				"boolean _while = (i < 10);\n" +
				"while (_while) {\n" +
				"  _while = (i < 10);\n" +
				"}\n");
	}

	@Test
	public void testBasicForLoop_12() throws Exception {
		compilesTo(
				"{\n" +
				"	for (var i = 0; i != 10; i += 1) {\n" +
				"		\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"int i = 0;\n" +
				"boolean _while = (i != 10);\n" +
				"while (_while) {\n" +
				"  int _i = i;\n" +
				"  i = (_i + 1);\n" +
				"  _while = (i != 10);\n" +
				"}\n");
	}

	@Test
	public void testWhileLoopWithConstantCondition_01() throws Exception {
		compilesTo(
				"while (newArrayList('').empty || 2 == (1 << 1)) {\n" +
				"	return ''\n" +
				"}\n",
				"\n" +
				"while ((org.eclipse.xtext.xbase.lib.CollectionLiterals.<String>newArrayList(\"\").isEmpty() || (2 == (1 << 1)))) {\n" +
				"  return \"\";\n" +
				"}\n" +
				"return null;\n");
	}

	@Test
	public void testWhileLoopWithConstantCondition_02() throws Exception {
		compilesTo(
				"while (2 == (1 << 1)) {\n" +
				"	return ''\n" +
				"}\n", "\n" +
				"while ((2 == (1 << 1))) {\n" +
				"  return \"\";\n" +
				"}\n");
	}

	@Test
	public void testSynchronizedBlock_1() throws Exception {
		compilesTo(
				"{\n" +
				"	val x = new Integer(1)\n" +
				"	synchronized(x) {}\n" +
				"}\n",
				"\n" +
				"Object _xblockexpression = null;\n" +
				"{\n" +
				"  final Integer x = new Integer(1);\n" +
				"  Object _xsynchronizedexpression = null;\n" +
				"  synchronized (x) {\n" +
				"    _xsynchronizedexpression = null;\n" +
				"  }\n" +
				"  _xblockexpression = _xsynchronizedexpression;\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testSynchronizedBlock_2() throws Exception {
		compilesTo(
				"{\n" +
				"	val x = new Integer(1)\n" +
				"	val y = synchronized(x) 1\n" +
				"}\n",
				"\n" +
				"final Integer x = new Integer(1);\n" +
				"int _xsynchronizedexpression = (int) 0;\n" +
				"synchronized (x) {\n" +
				"  _xsynchronizedexpression = 1;\n" +
				"}\n" +
				"final int y = _xsynchronizedexpression;\n");
	}

	@Test
	public void testSynchronizedBlock_3() throws Exception {
		compilesTo(
				"{\n" +
				"	val x = new Integer(1)\n" +
				"	val y = synchronized(x) {\n" +
				"		{\n" +
				"			{\n" +
				"				val i = 1\n" +
				"				val j = 2\n" +
				"				i + j\n" +
				"			}\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final Integer x = new Integer(1);\n" +
				"int _xsynchronizedexpression = (int) 0;\n" +
				"synchronized (x) {\n" +
				"  int _xblockexpression = (int) 0;\n" +
				"  {\n" +
				"    final int i = 1;\n" +
				"    final int j = 2;\n" +
				"    _xblockexpression = (i + j);\n" +
				"  }\n" +
				"  _xsynchronizedexpression = _xblockexpression;\n" +
				"}\n" +
				"final int y = _xsynchronizedexpression;\n");
	}

	@Test
	public void testBug410797_01() throws Exception {
		compilesTo(
				"{ val boolean bug = #[true, false, true].reduce[a,b|a && b] }\n",
				"\n" +
				"final org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean, Boolean, Boolean> _function = new org.eclipse.xtext.xbase.lib.Functions.Function2<Boolean, Boolean, Boolean>() {\n" +
				"  public Boolean apply(final Boolean a, final Boolean b) {\n" +
				"    return Boolean.valueOf(((a).booleanValue() && (b).booleanValue()));\n" +
				"  }\n" +
				"};\n" +
				"final boolean bug = (boolean) org.eclipse.xtext.xbase.lib.IterableExtensions.<Boolean>reduce(java.util.Collections.<Boolean>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Boolean>newArrayList(Boolean.valueOf(true), Boolean.valueOf(false), Boolean.valueOf(true))), _function);\n");
	}

	@Test
	public void testBug434224_01() throws Exception {
		compilesTo(
				"{\n" +
				"	val bar = new Object\n" +
				"	if (bar instanceof Byte) {\n" +
				"		bar as char\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"char _xblockexpression = (char) 0;\n" +
				"{\n" +
				"  final Object bar = new Object();\n" +
				"  char _xifexpression = (char) 0;\n" +
				"  if ((bar instanceof Byte)) {\n" +
				"    _xifexpression = ((char) ((Byte) bar).byteValue());\n" +
				"  }\n" +
				"  _xblockexpression = _xifexpression;\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug434224_02() throws Exception {
		compilesTo(
				"{\n" +
				"	switch bar : new Object {\n" +
				"		Byte: bar as char\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"char _switchResult = (char) 0;\n" +
				"Object _object = new Object();\n" +
				"final Object bar = _object;\n" +
				"boolean _matched = false;\n" +
				"if (bar instanceof Byte) {\n" +
				"  _matched=true;\n" +
				"  _switchResult = ((char) ((Byte) bar).byteValue());\n" +
				"}\n" +
				"return _switchResult;\n");
	}

	@Test
	public void testBug433573_01() throws Exception {
		compilesTo(
				"{\n" +
				"	val Number element = null\n" +
				"	if(element instanceof Double) {\n" +
				"		val Iterable<? extends Number> i = #[element]\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final Number element = null;\n" +
				"if ((element instanceof Double)) {\n" +
				"  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(element));\n" +
				"}\n");
	}

	@Test
	public void testBug433573_02() throws Exception {
		compilesTo(
				"{\n" +
				"	val Number element = null\n" +
				"	switch element {\n" +
				"		Double: {\n" +
				"			val Iterable<? extends Number> i = #[element]\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final Number element = null;\n" +
				"boolean _matched = false;\n" +
				"if (element instanceof Double) {\n" +
				"  _matched=true;\n" +
				"  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(element));\n" +
				"}\n");
	}

	@Test
	public void testBug433573_03() throws Exception {
		compilesTo(
				"{\n" +
				"	val Number element = null\n" +
				"	if(element instanceof Double) {\n" +
				"		val Iterable<? extends Number> i = #{element}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final Number element = null;\n" +
				"if ((element instanceof Double)) {\n" +
				"  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(element));\n" +
				"}\n");
	}

	@Test
	public void testBug433573_04() throws Exception {
		compilesTo(
				"{\n" +
				"	val Number element = null\n" +
				"	switch element {\n" +
				"		Double: {\n" +
				"			val Iterable<? extends Number> i = #{element}\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final Number element = null;\n" +
				"boolean _matched = false;\n" +
				"if (element instanceof Double) {\n" +
				"  _matched=true;\n" +
				"  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(element));\n" +
				"}\n");
	}

	@Test
	public void testBug433573_05() throws Exception {
		compilesTo(
				"{\n" +
				"	val Object element = null\n" +
				"	if(element instanceof Double) {\n" +
				"		val Iterable<? extends Number> i = #[element]\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final Object element = null;\n" +
				"if ((element instanceof Double)) {\n" +
				"  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(((Number)element)));\n" +
				"}\n");
	}

	@Test
	public void testBug433573_06() throws Exception {
		compilesTo(
				"{\n" +
				"	val Object element = null\n" +
				"	switch element {\n" +
				"		Double: {\n" +
				"			val Iterable<? extends Number> i = #[element]\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final Object element = null;\n" +
				"boolean _matched = false;\n" +
				"if (element instanceof Double) {\n" +
				"  _matched=true;\n" +
				"  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableList(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newArrayList(((Number)element)));\n" +
				"}\n");
	}

	@Test
	public void testBug433573_07() throws Exception {
		compilesTo(
				"{\n" +
				"	val Object element = null\n" +
				"	if(element instanceof Double) {\n" +
				"		val Iterable<? extends Number> i = #{element}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final Object element = null;\n" +
				"if ((element instanceof Double)) {\n" +
				"  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(((Number)element)));\n" +
				"}\n");
	}

	@Test
	public void testBug433573_08() throws Exception {
		compilesTo(
				"{\n" +
				"	val Object element = null\n" +
				"	switch element {\n" +
				"		Double: {\n" +
				"			val Iterable<? extends Number> i = #{element}\n" +
				"		}\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"final Object element = null;\n" +
				"boolean _matched = false;\n" +
				"if (element instanceof Double) {\n" +
				"  _matched=true;\n" +
				"  final Iterable<? extends Number> i = java.util.Collections.<Number>unmodifiableSet(org.eclipse.xtext.xbase.lib.CollectionLiterals.<Number>newHashSet(((Number)element)));\n" +
				"}\n");
	}

	@Test
	public void testBug466974_01() throws Exception {
		compilesTo(
				"{\n" +
				"	var i = 0\n" +
				"	Math.max( i = i + 1, if (i == 1) { 1 } else { 2 })\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int _i = i = (i + 1);\n" +
				"  int _xifexpression = (int) 0;\n" +
				"  if ((i == 1)) {\n" +
				"    _xifexpression = 1;\n" +
				"  } else {\n" +
				"    _xifexpression = 2;\n" +
				"  }\n" +
				"  _xblockexpression = Math.max(_i, _xifexpression);\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug466974_02() throws Exception {
		compilesTo(
				"{\n" +
				"	var i = 0\n" +
				"	Math.max(if (i == 1) { 1 } else { 2 }, i = i + 1)\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int _xifexpression = (int) 0;\n" +
				"  if ((i == 1)) {\n" +
				"    _xifexpression = 1;\n" +
				"  } else {\n" +
				"    _xifexpression = 2;\n" +
				"  }\n" +
				"  _xblockexpression = Math.max(_xifexpression, i = (i + 1));\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug466974_03() throws Exception {
		compilesTo(
				"{\n" +
				"	var i = 0\n" +
				"	Math.max({ i = i + 1 }, if (i == 1) { 1 } else { 2 })\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int _i = i = (i + 1);\n" +
				"  int _xifexpression = (int) 0;\n" +
				"  if ((i == 1)) {\n" +
				"    _xifexpression = 1;\n" +
				"  } else {\n" +
				"    _xifexpression = 2;\n" +
				"  }\n" +
				"  _xblockexpression = Math.max(_i, _xifexpression);\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug466974_04() throws Exception {
		compilesTo(
				"{\n" +
				"	var i = 0\n" +
				"	Math.max(if (i == 1) { 1 } else { 2 }, { i = i + 1 })\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int _xifexpression = (int) 0;\n" +
				"  if ((i == 1)) {\n" +
				"    _xifexpression = 1;\n" +
				"  } else {\n" +
				"    _xifexpression = 2;\n" +
				"  }\n" +
				"  _xblockexpression = Math.max(_xifexpression, i = (i + 1));\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug466974_05() throws Exception {
		compilesTo(
				"{\n" +
				"	var i = 0\n" +
				"	{i = i + 1}.compareTo(if (i == 1) { 1 } else { 2 })\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int _i = i = (i + 1);\n" +
				"  int _xifexpression = (int) 0;\n" +
				"  if ((i == 1)) {\n" +
				"    _xifexpression = 1;\n" +
				"  } else {\n" +
				"    _xifexpression = 2;\n" +
				"  }\n" +
				"  _xblockexpression = Integer.valueOf(_i).compareTo(Integer.valueOf(_xifexpression));\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug466974_06() throws Exception {
		compilesTo(
				"{\n" +
				"	var i = 0\n" +
				"	{if (i == 1) { 1 } else { 2 }}.compareTo(i = i + 1)\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int _xifexpression = (int) 0;\n" +
				"  if ((i == 1)) {\n" +
				"    _xifexpression = 1;\n" +
				"  } else {\n" +
				"    _xifexpression = 2;\n" +
				"  }\n" +
				"  _xblockexpression = Integer.valueOf(_xifexpression).compareTo(Integer.valueOf(i = (i + 1)));\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug466974_07() throws Exception {
		compilesTo(
				"{\n" +
				"	var i = 0\n" +
				"	{{i = i + 1}}.compareTo(if (i == 1) { 1 } else { 2 })\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int _i = i = (i + 1);\n" +
				"  int _xifexpression = (int) 0;\n" +
				"  if ((i == 1)) {\n" +
				"    _xifexpression = 1;\n" +
				"  } else {\n" +
				"    _xifexpression = 2;\n" +
				"  }\n" +
				"  _xblockexpression = Integer.valueOf(_i).compareTo(Integer.valueOf(_xifexpression));\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug466974_08() throws Exception {
		compilesTo(
				"{\n" +
				"	var i = 0\n" +
				"	{if (i == 1) { 1 } else { 2 }}.compareTo({i = i + 1})\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int _xifexpression = (int) 0;\n" +
				"  if ((i == 1)) {\n" +
				"    _xifexpression = 1;\n" +
				"  } else {\n" +
				"    _xifexpression = 2;\n" +
				"  }\n" +
				"  _xblockexpression = Integer.valueOf(_xifexpression).compareTo(Integer.valueOf(i = (i + 1)));\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug466974_09() throws Exception {
		compilesTo(
				"{\n" +
				"	var i = 0\n" +
				"	Math.max(i = i + 1, 2)\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  _xblockexpression = Math.max(i = (i + 1), 2);\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug466974_10() throws Exception {
		compilesTo(
				"{\n" +
				"	var i = 0\n" +
				"	{i = i + 1}.compareTo(2)\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  _xblockexpression = Integer.valueOf(i = (i + 1)).compareTo(Integer.valueOf(2));\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug489037_NestedAssignment_1() throws Exception {
		compilesTo(
				"\n" +
				"{\n" +
				"	var i = 0\n" +
				"	var j = 0\n" +
				"	j=i=0;\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int j = 0;\n" +
				"  _xblockexpression = j = (i = 0);\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug489037_NestedAssignment_2() throws Exception {
		compilesTo(
				"\n" +
				"{\n" +
				"	var i = 0\n" +
				"	var n = 1\n" +
				"	n=i=(if (i==0) 1 else 2)\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int n = 1;\n" +
				"  int _xifexpression = (int) 0;\n" +
				"  if ((i == 0)) {\n" +
				"    _xifexpression = 1;\n" +
				"  } else {\n" +
				"    _xifexpression = 2;\n" +
				"  }\n" +
				"  int _i = (i = _xifexpression);\n" +
				"  _xblockexpression = n = _i;\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void testBug489037_NestedAssignment_3() throws Exception {
		compilesTo(
				"\n" +
				"{\n" +
				"	var i = 0\n" +
				"	var n = 1\n" +
				"	n=i=switch(i) {\n" +
				"		default: 2\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  int i = 0;\n" +
				"  int n = 1;\n" +
				"  int _switchResult = (int) 0;\n" +
				"  switch (i) {\n" +
				"    default:\n" +
				"      _switchResult = 2;\n" +
				"      break;\n" +
				"  }\n" +
				"  int _i = (i = _switchResult);\n" +
				"  _xblockexpression = n = _i;\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}

	@Test
	public void test406762_NestedReturn() throws Exception {
		compilesTo(
				"{\n" +
				"	return return 0\n" +
				"}\n", "\n" +
				"return 0;\n" +
				"return /* error - couldn't compile nested return */;\n", false);
	}

	@Test
	public void test406762_NestedReturn2() throws Exception {
		compilesTo(
				"{\n" +
				"	return { \n" +
				"		return 0\n" +
				"	}\n" +
				"}\n", "\n" +
				"return 0;\n" +
				"return /* error - couldn't compile nested return */;\n", false);
	}

	@Test
	public void test406762_NestedReturn3() throws Exception {
		compilesTo(
				"{\n" +
				"	return { \n" +
				"		if (true) return 0 else return 1\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"int _xifexpression = (int) 0;\n" +
				"if (true) {\n" +
				"  return 0;\n" +
				"} else {\n" +
				"  return 1;\n" +
				"}\n" +
				"return _xifexpression;\n", false);
	}

	@Test
	public void test406762_NestedReturn4() throws Exception {
		compilesTo(
				"{\n" +
				"	return \n" +
				"		if (true) return 0 else return 1\n" +
				"}\n",
				"\n" +
				"int _xifexpression = (int) 0;\n" +
				"if (true) {\n" +
				"  return 0;\n" +
				"} else {\n" +
				"  return 1;\n" +
				"}\n" +
				"return _xifexpression;\n", false);
	}

	@Test
	public void test406762_ReturnInThrow() throws Exception {
		compilesTo(
				"{\n" +
				"	throw return\n" +
				"}\n",
				"\n" +
				"try {\n" +
				"  return;\n" +
				"  throw /* error - couldn't compile nested return */;\n" +
				"} catch (Throwable _e) {\n" +
				"  throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_e);\n" +
				"}\n",
				false);
	}

	@Test
	public void test406762_ReturnInThrow2() throws Exception {
		compilesTo(
				"{\n" +
				"	throw {\n" +
				"		return\n" +
				"	}\n" +
				"}\n",
				"\n" +
				"try {\n" +
				"  return;\n" +
				"  throw /* error - couldn't compile nested return */;\n" +
				"} catch (Throwable _e) {\n" +
				"  throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_e);\n" +
				"}\n",
				false);
	}

	@Test
	public void test406762_ReturnThrow() throws Exception {
		compilesTo(
				"{\n" +
				"	return throw new Exception()\n" +
				"}\n",
				"\n" +
				"try {\n" +
				"  throw new Exception();\n" +
				"  return /* error - couldn't compile invalid throw */;\n" +
				"} catch (Throwable _e) {\n" +
				"  throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_e);\n" +
				"}\n",
				false);
	}

	@Test
	public void test406762_ValidThrowInSingleIfBranch() throws Exception {
		compilesTo(
				"{\n" +
				"	val b = true\n" +
				"	return if (b) throw new RuntimeException() else 42\n" +
				"}\n",
				"\n" +
				"final boolean b = true;\n" +
				"int _xifexpression = (int) 0;\n" +
				"if (b) {\n" +
				"  throw new RuntimeException();\n" +
				"} else {\n" +
				"  _xifexpression = 42;\n" +
				"}\n" +
				"return _xifexpression;\n");
	}

	@Test
	public void test406762_ValidThrowInSingleIfBranch_1() throws Exception {
		compilesTo(
				"{\n" +
				"	val b = true\n" +
				"	return if (b) 42 else throw new RuntimeException()\n" +
				"}\n",
				"\n" +
				"final boolean b = true;\n" +
				"int _xifexpression = (int) 0;\n" +
				"if (b) {\n" +
				"  _xifexpression = 42;\n" +
				"} else {\n" +
				"  throw new RuntimeException();\n" +
				"}\n" +
				"return _xifexpression;\n");
	}

	@Test
	public void test406762_InvalidThrowInBothIfBranches() throws Exception {
		compilesTo(
				"{\n" +
				"	val b = true\n" +
				"	return if (b) throw new RuntimeException() else throw new RuntimeException()\n" +
				"}\n",
				"\n" +
				"final boolean b = true;\n" +
				"void _xifexpression = null;\n" +
				"if (b) {\n" +
				"  throw new RuntimeException();\n" +
				"} else {\n" +
				"  throw new RuntimeException();\n" +
				"}\n" +
				"return _xifexpression;\n",
				false);
	}

	@Test
	public void test406762_ValidReturnInLambdaContainedInThrow() throws Exception {
		compilesTo(
				"throw {\n" +
				"	val foo = [|return \"foo\"]\n" +
				"	new Exception(foo.apply)\n" +
				"}\n",
				"\n" +
				"try {\n" +
				"  Exception _xblockexpression = null;\n" +
				"  {\n" +
				"    final org.eclipse.xtext.xbase.lib.Functions.Function0<String> _function = new org.eclipse.xtext.xbase.lib.Functions.Function0<String>() {\n" +
				"      public String apply() {\n" +
				"        return \"foo\";\n" +
				"      }\n" +
				"    };\n" +
				"    final org.eclipse.xtext.xbase.lib.Functions.Function0<String> foo = _function;\n" +
				"    String _apply = foo.apply();\n" +
				"    _xblockexpression = new Exception(_apply);\n" +
				"  }\n" +
				"  throw _xblockexpression;\n" +
				"} catch (Throwable _e) {\n" +
				"  throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_e);\n" +
				"}\n");
	}

	@Test
	public void test406762_ValidReturnInLambdaContainedInThrow_1() throws Exception {
		compilesTo(
				"throw {\n" +
				"	val ()=>Exception foo = [|return new Exception]\n" +
				"	foo.apply\n" +
				"}\n",
				"\n" +
				"try {\n" +
				"  Exception _xblockexpression = null;\n" +
				"  {\n" +
				"    final org.eclipse.xtext.xbase.lib.Functions.Function0<Exception> _function = new org.eclipse.xtext.xbase.lib.Functions.Function0<Exception>() {\n" +
				"      public Exception apply() {\n" +
				"        return new Exception();\n" +
				"      }\n" +
				"    };\n" +
				"    final org.eclipse.xtext.xbase.lib.Functions.Function0<? extends Exception> foo = _function;\n" +
				"    _xblockexpression = foo.apply();\n" +
				"  }\n" +
				"  throw _xblockexpression;\n" +
				"} catch (Throwable _e) {\n" +
				"  throw org.eclipse.xtext.xbase.lib.Exceptions.sneakyThrow(_e);\n" +
				"}\n");
	}

	@Test
	public void testObjectEqualNull() throws Exception {
		compilesTo(
				"\"Foo\" == null\n", "\n" +
				"boolean _equals = com.google.common.base.Objects.equal(\"Foo\", null);\n" +
				"return _equals;\n");
	}

	@Test
	public void testObjectNotEqualNull() throws Exception {
		compilesTo(
				"\"Foo\" != null\n",
				"\n" +
				"boolean _notEquals = (!com.google.common.base.Objects.equal(\"Foo\", null));\n" +
				"return _notEquals;\n");
	}

	@Test
	public void testObjectIdenticalNull() throws Exception {
		compilesTo(
				"\"Foo\" === null\n", "\n" +
				"return (\"Foo\" == null);\n");
	}

	@Test
	public void testObjectNotIdenticalNull() throws Exception {
		compilesTo(
				"\"Foo\" !== null\n", "\n" +
				"return (\"Foo\" != null);\n");
	}

	@Test
	public void testBigIntegerLiteral01() throws Exception {
		compilesTo(
				"1bi\n", "\n" +
				"return java.math.BigInteger.ONE;\n");
	}

	@Test
	public void testBigIntegerLiteral02() throws Exception {
		compilesTo(
				"1.0bi\n", "\n" +
				"return java.math.BigInteger.ONE;\n");
	}

	@Test
	public void testBigIntegerLiteral03() throws Exception {
		compilesTo(
				"1e23bi\n", "\n" +
				"return new java.math.BigInteger(\"1\").multiply(java.math.BigInteger.TEN.pow(23));\n");
	}

	@Test
	public void testBigIntegerLiteral04() throws Exception {
		compilesTo(
				"1.23e45bi\n",
				"\n" +
				"return new java.math.BigDecimal(\"1.23\").multiply(java.math.BigDecimal.TEN.pow(45)).toBigInteger();\n");
	}

	@Test
	public void testExtrasIssue394() throws Exception {
		compilesTo(
				"newArrayOfSize(1).get(0)\n", "\n" +
				"Object _get = (new Object[1])[0];\n" +
				"return _get;\n");
	}

	@Test
	public void testExtrasIssue394_2() throws Exception {
		compilesTo(
				"newArrayOfSize(1)\n", "\n" +
				"Object[] _newArrayOfSize = new Object[1];\n" +
				"return _newArrayOfSize;\n");
	}

	@Test
	public void testLibIssue60() throws Exception {
		compilesTo(
				"{\n" +
				"	val a = <String>newArrayOfSize(1)\n" +
				"	a.set(0, \"\").length\n" +
				"	a.set(0,\"hello\")\n" +
				"	1\n" +
				"}\n",
				"int _xblockexpression = (int) 0;\n" +
				"{\n" +
				"  final String[] a = new String[1];\n" +
				"  (a[0] = \"\").length();\n" +
				"  a[0] = \"hello\";\n" +
				"  _xblockexpression = 1;\n" +
				"}\n" +
				"return _xblockexpression;\n");
	}
}
