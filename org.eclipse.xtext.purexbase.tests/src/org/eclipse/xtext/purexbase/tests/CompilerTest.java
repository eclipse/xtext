/**
 * Copyright (c) 2012, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.purexbase.tests;

import java.io.IOException;

import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
public class CompilerTest {
	@Rule
	@Inject
	public TemporaryFolder temporaryFolder;

	@Inject
	private CompilationTestHelper compilationTestHelper;

	@Test
	public void literals() throws Exception {
		String source =
				"/*\n" +
				" * Literals are notations for representing fixed values.\n" +
				" * Xbase only has literals for the most important data types \n" +
				" * predefined.\n" +
				" */ \n" +
				" \n" +
				"// Null Literal\n" +
				"null\n" +
				"\n" +
				"// String Literal\n" +
				"'Hello World'\n" +
				"\n" +
				"// Number Literals are mostly like in Java\n" +
				"// (consult the documentation for more details)\n" +
				"42\n" +
				"0.42e2\n" +
				"\n" +
				"// Boolean Literal\n" +
				"true\n" +
				"false\n" +
				"\n" +
				"// Class Literal (in java : String.class)\n" +
				"typeof(String)\n" +
				"\n" +
				"// Collection literals are down using a library approach.\n" +
				"newArrayList(3,5,7)\n" +
				"newHashSet('foo','bar','baz')\n" +
				"newHashMap( 1->'one', 2->'two', 3->'three' )\n" +
				"\n" +
				"// Into the bargain, there are number literals for \n" +
				"// java.math.BigInteger and java.math.BigDecimal\n" +
				"0xbeef_beef_beef_beef_beef#BI\n" +
				"0.123_456_789_123_456_789_123_456_789_123_456_789e4242BD\n";
		String expectation =
				"import java.math.BigDecimal;\n" +
				"import java.math.BigInteger;\n" +
				"import org.eclipse.xtext.xbase.lib.CollectionLiterals;\n" +
				"import org.eclipse.xtext.xbase.lib.Pair;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public BigDecimal myMethod() throws Throwable {\n" +
				"    BigDecimal _xblockexpression = null;\n" +
				"    {\n" +
				"      /* null */\n" +
				"      /* \"Hello World\" */\n" +
				"      /* 42 */\n" +
				"      /* 0.42e2 */\n" +
				"      /* true */\n" +
				"      /* false */\n" +
				"      /* String.class */\n" +
				"      /* CollectionLiterals.<Integer>newArrayList(Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7)); */\n" +
				"      /* CollectionLiterals.<String>newHashSet(\"foo\", \"bar\", \"baz\"); */\n" +
				"      Pair<Integer, String> _mappedTo = Pair.<Integer, String>of(Integer.valueOf(1), \"one\");\n" +
				"      Pair<Integer, String> _mappedTo_1 = Pair.<Integer, String>of(Integer.valueOf(2), \"two\");\n" +
				"      Pair<Integer, String> _mappedTo_2 = Pair.<Integer, String>of(Integer.valueOf(3), \"three\");\n" +
				"      /* CollectionLiterals.<Integer, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2); */\n" +
				"      /* new BigInteger(\"beefbeefbeefbeefbeef\", 16) */\n" +
				"      _xblockexpression = new BigDecimal(\"0.123456789123456789123456789123456789e4242\");\n" +
				"    }\n" +
				"    return _xblockexpression;\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}

	@Test
	public void featureCalls() throws Exception {
		String source =
				"import org.eclipse.xtext.purexbase.tests.data.Person\n" +
				"/*\n" +
				" * Xbase comes with sugared accessor syntax for getter and setter \n" +
				" * methods\n" +
				" */\n" +
				" \n" +
				"val person = new Person()\n" +
				"\n" +
				"// setting\n" +
				"person.forename = 'Jimi'\n" +
				"person.name = 'Hendrix'\n" +
				"\n" +
				"// accessing\n" +
				"person.forename + ' ' + person.name\n" +
				"// Jimi Hendrix (String)\n" +
				"\n" +
				"\n" +
				"// static features can be accessed using ::\n" +
				"java::util::Collections::singleton('So lonely') \n" +
				"System::err.println()\n";
		String expectation =
				"import java.util.Collections;\n" +
				"import org.eclipse.xtext.purexbase.tests.data.Person;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public void myMethod() throws Throwable {\n" +
				"    final Person person = new Person();\n" +
				"    person.setForename(\"Jimi\");\n" +
				"    person.setName(\"Hendrix\");\n" +
				"    String _forename = person.getForename();\n" +
				"    String _plus = (_forename + \" \");\n" +
				"    String _name = person.getName();\n" +
				"    /* (_plus + _name); */\n" +
				"    Collections.<String>singleton(\"So lonely\");\n" +
				"    System.err.println();\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}

	@Test
	public void variableDeclarations() throws Exception {
		String source =
				"/*\n" +
				" * Xbase variable declarations look a bit different to those in Java.\n" +
				" * \n" +
				" */\n" +
				" \n" +
				"val x = 'A final value'\n" +
				"// A final value (void)\n" +
				"var y = 'A non-final variable'\n" +
				"// A non-final variable (void)\n" +
				"\n" +
				"//x = 'not allowed'\n" +
				"y = 'can be modified'\n" +
				"// can be modified (String)\n" +
				"\n" +
				"/*\n" +
				" * The type can be specified optionally\n" +
				" */\n" +
				" \n" +
				"val String s = 'my String'\n" +
				"// my String (void)\n" +
				"\n" +
				"/*\n" +
				" * Generally, variable Declarations are only allowed within a block. In\n" +
				" * this language (pure xbase) the whole script is one block expression, \n" +
				" * which is why variable declarations are allowed without curly braces.\n" +
				" * \n" +
				" * A block expression is just a list of expressions which are all \n" +
				" * executed. The result and the type are computed from the last \n" +
				" * expression. They can be used in a deeply nested fashion.\n" +
				" */\n" +
				"\n" +
				"{\n" +
				"	{\n" +
				"		{\n" +
				"			val s1 = 'foo'\n" +
				"			s + s1\n" +
				"		}\n" +
				"	}\n" +
				"}\n" +
				"// foo (String)\n";
		String expectation =
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public String myMethod() throws Throwable {\n" +
				"    String _xblockexpression = null;\n" +
				"    {\n" +
				"      final String x = \"A final value\";\n" +
				"      String y = \"A non-final variable\";\n" +
				"      y = \"can be modified\";\n" +
				"      final String s = \"my String\";\n" +
				"      String _xblockexpression_1 = null;\n" +
				"      {\n" +
				"        final String s1 = \"foo\";\n" +
				"        _xblockexpression_1 = (s + s1);\n" +
				"      }\n" +
				"      _xblockexpression = _xblockexpression_1;\n" +
				"    }\n" +
				"    return _xblockexpression;\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}

	@Test
	public void casts() throws Exception {
		String source =
				"/*\n" +
				" * Casts work like in Java, but have a different (more readable and \n" +
				" * more tooling friendly) syntax\n" +
				" * \n" +
				" * When in Java you write \n" +
				" *   ((String)obj) \n" +
				" * in Xbase you write \n" +
				" *   (obj as String)\n" +
				" */\n" +
				" \n" +
				"val CharSequence s = 'foo'\n" +
				"\n" +
				"(s as String).length\n" +
				"// 3 (int)\n";
		String expectation =
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public int myMethod() throws Throwable {\n" +
				"    int _xblockexpression = (int) 0;\n" +
				"    {\n" +
				"      final CharSequence s = \"foo\";\n" +
				"      _xblockexpression = ((String) s).length();\n" +
				"    }\n" +
				"    return _xblockexpression;\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}

	@Test
	public void closures() throws Exception {
		String source =
				"/*\n" +
				" * A closures is an anonymous function which can access variables from \n" +
				" * the outer lexical scope.\n" +
				" */\n" +
				"\n" +
				"val x = 'Hello '\n" +
				"val f = [ String e | x + e ]\n" +
				"\n" +
				"f.apply('World!')\n" +
				"// Hello World! (String)\n" +
				"\n" +
				"\n" +
				"/*\n" +
				" * The square brackets are optional if a closure is passed as the \n" +
				" * single parameter to a method. Also the parameter types are optional \n" +
				" * if they can be inferred from the context.\n" +
				" */\n" +
				"\n" +
				"val list = newArrayList('a', 'b', 'c')\n" +
				"\n" +
				"list.map( e | e.toUpperCase )\n" +
				"// [A, B, C] (List<String>)\n" +
				"\n" +
				"\n" +
				"/*\n" +
				" * The type signature of a closure is written like this \n" +
				" *   (ParamType) => ReturnType\n" +
				" */\n" +
				"val (String)=>String f2 = [ e | e.toUpperCase ]\n" +
				"\n" +
				"f2.apply('simsalabim')\n" +
				"// SIMSALABIM (String)\n";
		String expectation =
				"import java.util.ArrayList;\n" +
				"import org.eclipse.xtext.xbase.lib.CollectionLiterals;\n" +
				"import org.eclipse.xtext.xbase.lib.Functions.Function1;\n" +
				"import org.eclipse.xtext.xbase.lib.ListExtensions;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public String myMethod() throws Throwable {\n" +
				"    String _xblockexpression = null;\n" +
				"    {\n" +
				"      final String x = \"Hello \";\n" +
				"      final Function1<String, String> _function = new Function1<String, String>() {\n" +
				"        @Override\n" +
				"        public String apply(final String e) {\n" +
				"          return (x + e);\n" +
				"        }\n" +
				"      };\n" +
				"      final Function1<String, String> f = _function;\n" +
				"      f.apply(\"World!\");\n" +
				"      final ArrayList<String> list = CollectionLiterals.<String>newArrayList(\"a\", \"b\", \"c\");\n" +
				"      final Function1<String, String> _function_1 = new Function1<String, String>() {\n" +
				"        @Override\n" +
				"        public String apply(final String e) {\n" +
				"          return e.toUpperCase();\n" +
				"        }\n" +
				"      };\n" +
				"      /* ListExtensions.<String, String>map(list, _function_1); */\n" +
				"      final Function1<String, String> _function_2 = new Function1<String, String>() {\n" +
				"        @Override\n" +
				"        public String apply(final String e) {\n" +
				"          return e.toUpperCase();\n" +
				"        }\n" +
				"      };\n" +
				"      final Function1<? super String, ? extends String> f2 = _function_2;\n" +
				"      _xblockexpression = f2.apply(\"simsalabim\");\n" +
				"    }\n" +
				"    return _xblockexpression;\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}

	@Test
	public void ifExpression() throws Exception {
		String source =
				"/*\n" +
				" * The if expression looks exactly like in Java. \n" +
				" * As it is an expression it yields a value and is of some type.\n" +
				" */\n" +
				"if ('foo'.length>3) {\n" +
				"	'never true!'\n" +
				"} else {\n" +
				"	'always true!'\n" +
				"}\n" +
				"// always true! (String)\n" +
				"\n" +
				"/*\n" +
				" * The else branch is optional and if not specified 'else null' is \n" +
				" * inferred:\n" +
				" */\n" +
				"if ('foo'.length>3) {\n" +
				"	'never true!'\n" +
				"}\n" +
				"// null (String)\n" +
				"\n" +
				"/*\n" +
				" * This also means that control structure expressions like 'if' can \n" +
				" * occur wherever an expression is expected.\n" +
				" */\n" +
				"if (if ('foo'.length>3) \n" +
				"		false \n" +
				"	else \n" +
				"		true) {\n" +
				"	\"Xbase doesn't need the ternary operator\"\n" +
				"}\n";
		String expectation =
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public String myMethod() throws Throwable {\n" +
				"    String _xblockexpression = null;\n" +
				"    {\n" +
				"      int _length = \"foo\".length();\n" +
				"      boolean _greaterThan = (_length > 3);\n" +
				"      if (_greaterThan) {\n" +
				"        /* \"never true!\" */\n" +
				"      } else {\n" +
				"        /* \"always true!\" */\n" +
				"      }\n" +
				"      int _length_1 = \"foo\".length();\n" +
				"      boolean _greaterThan_1 = (_length_1 > 3);\n" +
				"      if (_greaterThan_1) {\n" +
				"        /* \"never true!\" */\n" +
				"      }\n" +
				"      String _xifexpression = null;\n" +
				"      boolean _xifexpression_1 = false;\n" +
				"      int _length_2 = \"foo\".length();\n" +
				"      boolean _greaterThan_2 = (_length_2 > 3);\n" +
				"      if (_greaterThan_2) {\n" +
				"        _xifexpression_1 = false;\n" +
				"      } else {\n" +
				"        _xifexpression_1 = true;\n" +
				"      }\n" +
				"      if (_xifexpression_1) {\n" +
				"        _xifexpression = \"Xbase doesn\\'t need the ternary operator\";\n" +
				"      }\n" +
				"      _xblockexpression = _xifexpression;\n" +
				"    }\n" +
				"    return _xblockexpression;\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}

	@Test
	public void operators() throws Exception {
		String source =
				"import org.eclipse.xtext.purexbase.tests.data.Amount\n" +
				"/*\n" +
				" * Although the operators in Xbase are syntactically predefined, the \n" +
				" * semantics are given by a simple operator overloading mechanism.\n" +
				" * \n" +
				" * Each operator maps to a certain method signature.\n" +
				" */\n" +
				"val a = new Amount('12.80')\n" +
				"val b = new Amount('0.20')\n" +
				"\n" +
				"a + b * 3\n" +
				"// 13.40 (Amount)\n";
		String expectation =
				"import org.eclipse.xtext.purexbase.tests.data.Amount;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public Amount myMethod() throws Throwable {\n" +
				"    Amount _xblockexpression = null;\n" +
				"    {\n" +
				"      final Amount a = new Amount(\"12.80\");\n" +
				"      final Amount b = new Amount(\"0.20\");\n" +
				"      Amount _multiply = b.operator_multiply(3);\n" +
				"      _xblockexpression = a.operator_plus(_multiply);\n" +
				"    }\n" +
				"    return _xblockexpression;\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}

	@Test
	public void loops() throws Exception {
		String source =
				"/*\n" +
				" * Xbase supports Java's while and do .. while as well as the new form \n" +
				" * of the for loop. In Xbase these constructs are expressions not \n" +
				" * statements. Anyway, they always result in 'null' and are of type \n" +
				" * 'void'. \n" +
				" */\n" +
				"val list = newArrayList('foo','bar','baz')\n" +
				"val result = new java.util.ArrayList<String>()\n" +
				"\n" +
				"for (x : list.reverse) {\n" +
				"	result += x.toUpperCase\n" +
				"}\n" +
				"result\n" +
				"// [BAZ, BAR, FOO] (ArrayList<String>)\n" +
				"\n" +
				"var i = 0\n" +
				"while(i<list.size) {\n" +
				"	result += 'whiled-'+list.get(i)\n" +
				"	i = i+1\n" +
				"}\n" +
				"result\n" +
				"// [BAZ, BAR, FOO, whiled-baz, whiled-bar, whiled-foo] (ArrayList<String>)\n";
		String expectation =
				"import java.util.ArrayList;\n" +
				"import java.util.List;\n" +
				"import org.eclipse.xtext.xbase.lib.CollectionLiterals;\n" +
				"import org.eclipse.xtext.xbase.lib.ListExtensions;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public ArrayList<String> myMethod() throws Throwable {\n" +
				"    ArrayList<String> _xblockexpression = null;\n" +
				"    {\n" +
				"      final ArrayList<String> list = CollectionLiterals.<String>newArrayList(\"foo\", \"bar\", \"baz\");\n" +
				"      final ArrayList<String> result = new ArrayList<String>();\n" +
				"      List<String> _reverse = ListExtensions.<String>reverse(list);\n" +
				"      for (final String x : _reverse) {\n" +
				"        String _upperCase = x.toUpperCase();\n" +
				"        result.add(_upperCase);\n" +
				"      }\n" +
				"      /* result; */\n" +
				"      int i = 0;\n" +
				"      while ((i < list.size())) {\n" +
				"        {\n" +
				"          String _get = list.get(i);\n" +
				"          String _plus = (\"whiled-\" + _get);\n" +
				"          result.add(_plus);\n" +
				"          i = (i + 1);\n" +
				"        }\n" +
				"      }\n" +
				"      _xblockexpression = result;\n" +
				"    }\n" +
				"    return _xblockexpression;\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}

	@Test
	public void exceptions() throws Exception {
		String source =
				"/*\n" +
				" * Xbase supports Exception handling using the same syntax as is used \n" +
				" * in Java. There are two differences:\n" +
				" * 1) Checked exceptions must not be caught in closures.\n" +
				" * 2) Try-catch is an expression and can therefore be used in a deeply \n" +
				" *    nested way \n" +
				" */\n" +
				"try {\n" +
				"	(null as Object).toString\n" +
				"} catch (NullPointerException e) {\n" +
				"	throw new RuntimeException(e)\n" +
				"} finally {\n" +
				"	// do nothing	\n" +
				"}\n" +
				"// threw RuntimeException (String)\n" +
				"\n" +
				"/*\n" +
				" * Note that within purexbase after you've thrown an exception, the \n" +
				" * interpreter will always result in the first thrown exception.\n" +
				" */\n" +
				"null\n" +
				"// threw RuntimeException (Void)\n";
		String expectation =
				"import org.eclipse.xtext.xbase.lib.Exceptions;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public Object myMethod() throws Throwable {\n" +
				"    Object _xblockexpression = null;\n" +
				"    {\n" +
				"      try {\n" +
				"        ((Object) null).toString();\n" +
				"      } catch (final Throwable _t) {\n" +
				"        if (_t instanceof NullPointerException) {\n" +
				"          final NullPointerException e = (NullPointerException)_t;\n" +
				"          throw new RuntimeException(e);\n" +
				"        } else {\n" +
				"          throw Exceptions.sneakyThrow(_t);\n" +
				"        }\n" +
				"      } finally {\n" +
				"      }\n" +
				"      _xblockexpression = null;\n" +
				"    }\n" +
				"    return _xblockexpression;\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}

	@Test
	public void switchExpression() throws Exception {
		String source =
				"import org.eclipse.xtext.purexbase.tests.data.Circle\n" +
				"import org.eclipse.xtext.purexbase.tests.data.Rectangle\n" +
				"/*\n" +
				" * The switch expression is different and much more powerful than the\n" +
				" * switch statement in Java.\n" +
				" * \n" +
				" * First it allows to switch over everything (not only primitives) and\n" +
				" * it does not have a fall through logic. Also the order of cases is \n" +
				" * important : First match wins!\n" +
				" */\n" +
				"val list = newArrayList('foo','bar','baz')\n" +
				"switch(list.head) {\n" +
				"	case 'foo' : \"it's foo\"\n" +
				"	case 'bar' : 'a bar'\n" +
				"	default : \"don't know\"\n" +
				"}\n" +
				"// it's foo (String)\n" +
				"\n" +
				"/*\n" +
				" * The type guards are a pragmatic variant of what people often do with\n" +
				" * pattern matching in functional languages.\n" +
				" */\n" +
				"val list2 = newArrayList(new Rectangle(5,5), new Circle(4), new Rectangle(6,8))\n" +
				"list2.map(shape | \n" +
				"		switch (shape) {\n" +
				"			Circle 	: \n" +
				"				'a circle : diameter='+shape.diameter\n" +
				"				\n" +
				"			Rectangle case shape.height == shape.width : \n" +
				"				'a square : size='+shape.width\n" +
				"				\n" +
				"			Rectangle : \n" +
				"				'a rectangle : width='+shape.width+', height='+shape.height\n" +
				"				\n" +
				"		})\n" +
				"// [a square : size=5, a circle : diameter=4, a rectangle : width=8 height=6] (List<String>)\n";
		String expectation =
				"import com.google.common.base.Objects;\n" +
				"import java.util.ArrayList;\n" +
				"import java.util.List;\n" +
				"import org.eclipse.xtext.purexbase.tests.data.Circle;\n" +
				"import org.eclipse.xtext.purexbase.tests.data.Rectangle;\n" +
				"import org.eclipse.xtext.purexbase.tests.data.Shape;\n" +
				"import org.eclipse.xtext.xbase.lib.CollectionLiterals;\n" +
				"import org.eclipse.xtext.xbase.lib.Functions.Function1;\n" +
				"import org.eclipse.xtext.xbase.lib.IterableExtensions;\n" +
				"import org.eclipse.xtext.xbase.lib.ListExtensions;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public List<String> myMethod() throws Throwable {\n" +
				"    List<String> _xblockexpression = null;\n" +
				"    {\n" +
				"      final ArrayList<String> list = CollectionLiterals.<String>newArrayList(\"foo\", \"bar\", \"baz\");\n" +
				"      String _head = IterableExtensions.<String>head(list);\n" +
				"      boolean _matched = false;\n" +
				"      if (Objects.equal(_head, \"foo\")) {\n" +
				"        _matched=true;\n" +
				"        /* \"it\\'s foo\" */\n" +
				"      }\n" +
				"      if (!_matched) {\n" +
				"        if (Objects.equal(_head, \"bar\")) {\n" +
				"          _matched=true;\n" +
				"          /* \"a bar\" */\n" +
				"        }\n" +
				"      }\n" +
				"      if (!_matched) {\n" +
				"        /* \"don\\'t know\" */\n" +
				"      }\n" +
				"      Rectangle _rectangle = new Rectangle(5, 5);\n" +
				"      Circle _circle = new Circle(4);\n" +
				"      Rectangle _rectangle_1 = new Rectangle(6, 8);\n" +
				"      final ArrayList<Shape> list2 = CollectionLiterals.<Shape>newArrayList(_rectangle, _circle, _rectangle_1);\n" +
				"      final Function1<Shape, String> _function = new Function1<Shape, String>() {\n" +
				"        @Override\n" +
				"        public String apply(final Shape shape) {\n" +
				"          String _switchResult = null;\n" +
				"          boolean _matched = false;\n" +
				"          if (shape instanceof Circle) {\n" +
				"            _matched=true;\n" +
				"            _switchResult = (\"a circle : diameter=\" + Integer.valueOf(((Circle)shape).diameter));\n" +
				"          }\n" +
				"          if (!_matched) {\n" +
				"            if (shape instanceof Rectangle) {\n" +
				"              if ((((Rectangle)shape).height == ((Rectangle)shape).width)) {\n" +
				"                _matched=true;\n" +
				"                _switchResult = (\"a square : size=\" + Integer.valueOf(((Rectangle)shape).width));\n" +
				"              }\n" +
				"            }\n" +
				"          }\n" +
				"          if (!_matched) {\n" +
				"            if (shape instanceof Rectangle) {\n" +
				"              _matched=true;\n" +
				"              _switchResult = (((\"a rectangle : width=\" + Integer.valueOf(((Rectangle)shape).width)) + \", height=\") + Integer.valueOf(((Rectangle)shape).height));\n" +
				"            }\n" +
				"          }\n" +
				"          return _switchResult;\n" +
				"        }\n" +
				"      };\n" +
				"      _xblockexpression = ListExtensions.<Shape, String>map(list2, _function);\n" +
				"    }\n" +
				"    return _xblockexpression;\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}

	@Test
	public void typeCoercion() throws Exception {
		String source =
				"/*\n" +
				" * AUTOBOXING\n" +
				" * Xbase supports Java's primitives and also the autoboxing introduced\n" +
				" * with Java 1.4.\n" +
				" */\n" +
				" \n" +
				"'string'.length\n" +
				"// 6 (int)\n" +
				"\n" +
				"val Integer i = 'string'.length\n" +
				"i\n" +
				"// 6 (Integer)\n" +
				"\n" +
				"/*\n" +
				" * It does autoboxing even when used in the receiver context.\n" +
				" */\n" +
				"\n" +
				"'string'.length.toString\n" +
				"// 6 (String)\n" +
				"\n" +
				"/*\n" +
				" * Arrays are automatically coerced to Lists.\n" +
				" */\n" +
				" \n" +
				"'string'.toCharArray\n" +
				"// [C@388e28 (char[])\n" +
				"\n" +
				"val java.util.List<Character> l = 'string'.toCharArray\n" +
				"// [s, t, r, i, n, g] (void)\n" +
				"\n" +
				"/*\n" +
				" * Again this works also in a receiver context.\n" +
				" */\n" +
				"\n" +
				"'string'.toCharArray.get(3)\n" +
				"// i (Character)\n" +
				"\n" +
				"/*\n" +
				" * Closure Coercion\n" +
				" * A closure can be passed whenever a type is expected which has only defined \n" +
				" * one method in addition to the ones inherited from java.lang.Object\n" +
				" */\n" +
				"val java.util.Comparator<String> comparator = [a,b| a.length.compareTo(b.length)]\n";
		String expectation =
				"import java.util.Comparator;\n" +
				"import java.util.List;\n" +
				"import org.eclipse.xtext.xbase.lib.Conversions;\n" +
				"\n" +
				"@SuppressWarnings(\"all\")\n" +
				"public class MyFile {\n" +
				"  public void myMethod() throws Throwable {\n" +
				"    \"string\".length();\n" +
				"    final Integer i = Integer.valueOf(\"string\".length());\n" +
				"    /* i; */\n" +
				"    Integer.valueOf(\"string\".length()).toString();\n" +
				"    \"string\".toCharArray();\n" +
				"    final List<Character> l = (List<Character>)Conversions.doWrapArray(\"string\".toCharArray());\n" +
				"    /* \"string\".toCharArray()[3]; */\n" +
				"    final Comparator<String> _function = new Comparator<String>() {\n" +
				"      @Override\n" +
				"      public int compare(final String a, final String b) {\n" +
				"        return Integer.valueOf(a.length()).compareTo(Integer.valueOf(b.length()));\n" +
				"      }\n" +
				"    };\n" +
				"    final Comparator<String> comparator = _function;\n" +
				"  }\n" +
				"}\n";
		assertCompilesTo(source, expectation);
	}
	
	private void assertCompilesTo(String source, String expectation) throws IOException {
		compilationTestHelper.assertCompilesTo(source, Strings.toPlatformLineSeparator(expectation));
	}
}
