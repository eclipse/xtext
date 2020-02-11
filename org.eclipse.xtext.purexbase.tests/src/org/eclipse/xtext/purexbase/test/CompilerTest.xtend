/*******************************************************************************
 * Copyright (c) 2012, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.test

import com.google.inject.Inject
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.xbase.testing.CompilationTestHelper
import org.eclipse.xtext.xbase.testing.TemporaryFolder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(RuntimeInjectorProvider)
class CompilerTest {
	
	@Rule @Inject public TemporaryFolder temporaryFolder
	
	@Inject extension CompilationTestHelper
	
	@Test
	def void literals() {
		'''
			/*
			 * Literals are notations for representing fixed values.
			 * Xbase only has literals for the most important data types 
			 * predefined.
			 */ 
			 
			// Null Literal
			null
			
			// String Literal
			'Hello World'
			
			// Number Literals are mostly like in Java
			// (consult the documentation for more details)
			42
			0.42e2
			
			// Boolean Literal
			true
			false
			
			// Class Literal (in java : String.class)
			typeof(String)
			
			// Collection literals are down using a library approach.
			newArrayList(3,5,7)
			newHashSet('foo','bar','baz')
			newHashMap( 1->'one', 2->'two', 3->'three' )
			
			// Into the bargain, there are number literals for 
			// java.math.BigInteger and java.math.BigDecimal
			0xbeef_beef_beef_beef_beef#BI
			0.123_456_789_123_456_789_123_456_789_123_456_789e4242BD
		'''.assertCompilesTo('''
			import java.math.BigDecimal;
			import java.math.BigInteger;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Pair;
			
			@SuppressWarnings("all")
			public class MyFile {
			  public BigDecimal myMethod() throws Throwable {
			    BigDecimal _xblockexpression = null;
			    {
			      /* null */
			      /* "Hello World" */
			      /* 42 */
			      /* 0.42e2 */
			      /* true */
			      /* false */
			      /* String.class */
			      /* CollectionLiterals.<Integer>newArrayList(Integer.valueOf(3), Integer.valueOf(5), Integer.valueOf(7)); */
			      /* CollectionLiterals.<String>newHashSet("foo", "bar", "baz"); */
			      Pair<Integer, String> _mappedTo = Pair.<Integer, String>of(Integer.valueOf(1), "one");
			      Pair<Integer, String> _mappedTo_1 = Pair.<Integer, String>of(Integer.valueOf(2), "two");
			      Pair<Integer, String> _mappedTo_2 = Pair.<Integer, String>of(Integer.valueOf(3), "three");
			      /* CollectionLiterals.<Integer, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2); */
			      /* new BigInteger("beefbeefbeefbeefbeef", 16) */
			      _xblockexpression = new BigDecimal("0.123456789123456789123456789123456789e4242");
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void featureCalls() {
		'''
			import org.eclipse.xtext.purexbase.test.data.Person
			/*
			 * Xbase comes with sugared accessor syntax for getter and setter 
			 * methods
			 */
			 
			val person = new Person()
			
			// setting
			person.forename = 'Jimi'
			person.name = 'Hendrix'
			
			// accessing
			person.forename +' '+ person.name
			// Jimi Hendrix (String)
			
			
			// static features can be accessed using ::
			java::util::Collections::singleton("So lonely") 
			System::err.println()
		'''.assertCompilesTo('''
			import java.util.Collections;
			import org.eclipse.xtext.purexbase.test.data.Person;
			
			@SuppressWarnings("all")
			public class MyFile {
			  public void myMethod() throws Throwable {
			    final Person person = new Person();
			    person.setForename("Jimi");
			    person.setName("Hendrix");
			    String _forename = person.getForename();
			    String _plus = (_forename + " ");
			    String _name = person.getName();
			    /* (_plus + _name); */
			    Collections.<String>singleton("So lonely");
			    System.err.println();
			  }
			}
		''')
	}
	
	@Test
	def void variableDeclarations() {
		'''
			/*
			 * Xbase variable declarations look a bit different to those in Java.
			 * 
			 */
			 
			val x = 'A final value'
			// A final value (void)
			var y = 'A non-final variable'
			// A non-final variable (void)
			
			//x = 'not allowed'
			y = 'can be modified'
			// can be modified (String)
			
			/*
			 * The type can be specified optionally
			 */
			 
			val String s = "my String"
			// my String (void)
			
			/*
			 * Generally, variable Declarations are only allowed within a block. In
			 * this language (pure xbase) the whole script is one block expression, 
			 * which is why variable declarations are allowed without curly braces.
			 * 
			 * A block expression is just a list of expressions which are all 
			 * executed. The result and the type are computed from the last 
			 * expression. They can be used in a deeply nested fashion.
			 */
			
			{
				{
					{
						val s1 = 'foo'
						s + s1
					}
				}
			}
			// foo (String)
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class MyFile {
			  public String myMethod() throws Throwable {
			    String _xblockexpression = null;
			    {
			      final String x = "A final value";
			      String y = "A non-final variable";
			      y = "can be modified";
			      final String s = "my String";
			      String _xblockexpression_1 = null;
			      {
			        final String s1 = "foo";
			        _xblockexpression_1 = (s + s1);
			      }
			      _xblockexpression = _xblockexpression_1;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void casts() {
		'''
			/*
			 * Casts work like in Java, but have a different (more readable and 
			 * more tooling friendly) syntax
			 * 
			 * When in Java you write 
			 *   ((String)obj) 
			 * in Xbase you write 
			 *   (obj as String)
			 */
			 
			val CharSequence s = 'foo'
			
			(s as String).length
			// 3 (int)
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class MyFile {
			  public int myMethod() throws Throwable {
			    int _xblockexpression = (int) 0;
			    {
			      final CharSequence s = "foo";
			      _xblockexpression = ((String) s).length();
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void closures() {
		'''
			/*
			 * A closures is an anonymous function which can access variables from 
			 * the outer lexical scope.
			 */
			
			val x = 'Hello '
			val f = [ String e | x + e ]
			
			f.apply('World!')
			// Hello World! (String)
			
			
			/*
			 * The square brackets are optional if a closure is passed as the 
			 * single parameter to a method. Also the parameter types are optional 
			 * if they can be inferred from the context.
			 */
			
			val list = newArrayList('a', 'b', 'c')
			
			list.map( e | e.toUpperCase )
			// [A, B, C] (List<String>)
			
			
			/*
			 * The type signature of a closure is written like this 
			 *   (ParamType) => ReturnType
			 */
			val (String)=>String f2 = [ e | e.toUpperCase ]
			
			f2.apply('simsalabim')
			// SIMSALABIM (String)
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class MyFile {
			  public String myMethod() throws Throwable {
			    String _xblockexpression = null;
			    {
			      final String x = "Hello ";
			      final Function1<String, String> _function = new Function1<String, String>() {
			        @Override
			        public String apply(final String e) {
			          return (x + e);
			        }
			      };
			      final Function1<String, String> f = _function;
			      f.apply("World!");
			      final ArrayList<String> list = CollectionLiterals.<String>newArrayList("a", "b", "c");
			      final Function1<String, String> _function_1 = new Function1<String, String>() {
			        @Override
			        public String apply(final String e) {
			          return e.toUpperCase();
			        }
			      };
			      /* ListExtensions.<String, String>map(list, _function_1); */
			      final Function1<String, String> _function_2 = new Function1<String, String>() {
			        @Override
			        public String apply(final String e) {
			          return e.toUpperCase();
			        }
			      };
			      final Function1<? super String, ? extends String> f2 = _function_2;
			      _xblockexpression = f2.apply("simsalabim");
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void ifExpression() {
		'''
			/*
			 * The if expression looks exactly like in Java. 
			 * As it is an expression it yields a value and is of some type.
			 */
			if ('foo'.length>3) {
				'never true!'
			} else {
				'always true!'
			}
			// always true! (String)
			
			/*
			 * The else branch is optional and if not specified 'else null' is 
			 * inferred:
			 */
			if ('foo'.length>3) {
				'never true!'
			}
			// null (String)
			
			/*
			 * This also means that control structure expressions like 'if' can 
			 * occur wherever an expression is expected.
			 */
			if (if ('foo'.length>3) 
					false 
				else 
					true) {
				"Xbase doesn't need the ternary operator"
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class MyFile {
			  public String myMethod() throws Throwable {
			    String _xblockexpression = null;
			    {
			      int _length = "foo".length();
			      boolean _greaterThan = (_length > 3);
			      if (_greaterThan) {
			        /* "never true!" */
			      } else {
			        /* "always true!" */
			      }
			      int _length_1 = "foo".length();
			      boolean _greaterThan_1 = (_length_1 > 3);
			      if (_greaterThan_1) {
			        /* "never true!" */
			      }
			      String _xifexpression = null;
			      boolean _xifexpression_1 = false;
			      int _length_2 = "foo".length();
			      boolean _greaterThan_2 = (_length_2 > 3);
			      if (_greaterThan_2) {
			        _xifexpression_1 = false;
			      } else {
			        _xifexpression_1 = true;
			      }
			      if (_xifexpression_1) {
			        _xifexpression = "Xbase doesn\'t need the ternary operator";
			      }
			      _xblockexpression = _xifexpression;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void operators() {
		'''
			import org.eclipse.xtext.purexbase.test.data.Amount
			/*
			 * Although the operators in Xbase are syntactically predefined, the 
			 * semantics are given by a simple operator overloading mechanism.
			 * 
			 * Each operator maps to a certain method signature.
			 */
			val a = new Amount('12.80')
			val b = new Amount('0.20')
			
			a + b * 3
			// 13.40 (Amount)
		'''.assertCompilesTo('''
			import org.eclipse.xtext.purexbase.test.data.Amount;
			
			@SuppressWarnings("all")
			public class MyFile {
			  public Amount myMethod() throws Throwable {
			    Amount _xblockexpression = null;
			    {
			      final Amount a = new Amount("12.80");
			      final Amount b = new Amount("0.20");
			      Amount _multiply = b.operator_multiply(3);
			      _xblockexpression = a.operator_plus(_multiply);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void loops() {
		'''
			/*
			 * Xbase supports Java's while and do .. while as well as the new form 
			 * of the for loop. In Xbase these constructs are expressions not 
			 * statements. Anyway, they always result in 'null' and are of type 
			 * 'void'. 
			 */
			val list = newArrayList('foo','bar','baz')
			val result = new java.util.ArrayList<String>()
			
			for (x : list.reverse) {
				result += x.toUpperCase
			}
			result
			// [BAZ, BAR, FOO] (ArrayList<String>)
			
			var i = 0
			while(i<list.size) {
				result += 'whiled-'+list.get(i)
				i = i+1
			}
			result
			// [BAZ, BAR, FOO, whiled-baz, whiled-bar, whiled-foo] (ArrayList<String>)
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class MyFile {
			  public ArrayList<String> myMethod() throws Throwable {
			    ArrayList<String> _xblockexpression = null;
			    {
			      final ArrayList<String> list = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
			      final ArrayList<String> result = new ArrayList<String>();
			      List<String> _reverse = ListExtensions.<String>reverse(list);
			      for (final String x : _reverse) {
			        String _upperCase = x.toUpperCase();
			        result.add(_upperCase);
			      }
			      /* result; */
			      int i = 0;
			      while ((i < list.size())) {
			        {
			          String _get = list.get(i);
			          String _plus = ("whiled-" + _get);
			          result.add(_plus);
			          i = (i + 1);
			        }
			      }
			      _xblockexpression = result;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void exceptions() {
		'''
			/*
			 * Xbase supports Exception handling using the same syntax as is used 
			 * in Java. There are two differences:
			 * 1) Checked exceptions must not be caught in closures.
			 * 2) Try-catch is an expression and can therefore be used in a deeply 
			 *    nested way 
			 */
			try {
				(null as Object).toString
			} catch (NullPointerException e) {
				throw new RuntimeException(e)
			} finally {
				// do nothing	
			}
			// threw RuntimeException (String)
			
			/*
			 * Note that within purexbase after you've thrown an exception, the 
			 * interpreter will always result in the first thrown exception.
			 */
			null
			// threw RuntimeException (Void)
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class MyFile {
			  public Object myMethod() throws Throwable {
			    Object _xblockexpression = null;
			    {
			      try {
			        ((Object) null).toString();
			      } catch (final Throwable _t) {
			        if (_t instanceof NullPointerException) {
			          final NullPointerException e = (NullPointerException)_t;
			          throw new RuntimeException(e);
			        } else {
			          throw Exceptions.sneakyThrow(_t);
			        }
			      } finally {
			      }
			      _xblockexpression = null;
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void switchExpression() {
		'''
			import org.eclipse.xtext.purexbase.test.data.Circle
			import org.eclipse.xtext.purexbase.test.data.Rectangle
			/*
			 * The switch expression is different and much more powerful than the
			 * switch statement in Java.
			 * 
			 * First it allows to switch over everything (not only primitives) and
			 * it does not have a fall through logic. Also the order of cases is 
			 * important : First match wins!
			 */
			val list = newArrayList('foo','bar','baz')
			switch(list.head) {
				case 'foo' : "it's foo"
				case 'bar' : 'a bar'
				default : "don't know"
			}
			// it's foo (String)
			
			/*
			 * The type guards are a pragmatic variant of what people often do with
			 * pattern matching in functional languages.
			 */
			val list2 = newArrayList(new Rectangle(5,5), new Circle(4), new Rectangle(6,8))
			list2.map(shape | 
					switch (shape) {
						Circle 	: 
							'a circle : diameter='+shape.diameter
							
						Rectangle case shape.height == shape.width : 
							'a square : size='+shape.width
							
						Rectangle : 
							'a rectangle : width='+shape.width+', height='+shape.height
							
					})
			// [a square : size=5, a circle : diameter=4, a rectangle : width=8 height=6] (List<String>)
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.xtext.purexbase.test.data.Circle;
			import org.eclipse.xtext.purexbase.test.data.Rectangle;
			import org.eclipse.xtext.purexbase.test.data.Shape;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class MyFile {
			  public List<String> myMethod() throws Throwable {
			    List<String> _xblockexpression = null;
			    {
			      final ArrayList<String> list = CollectionLiterals.<String>newArrayList("foo", "bar", "baz");
			      String _head = IterableExtensions.<String>head(list);
			      boolean _matched = false;
			      if (Objects.equal(_head, "foo")) {
			        _matched=true;
			        /* "it\'s foo" */
			      }
			      if (!_matched) {
			        if (Objects.equal(_head, "bar")) {
			          _matched=true;
			          /* "a bar" */
			        }
			      }
			      if (!_matched) {
			        /* "don\'t know" */
			      }
			      Rectangle _rectangle = new Rectangle(5, 5);
			      Circle _circle = new Circle(4);
			      Rectangle _rectangle_1 = new Rectangle(6, 8);
			      final ArrayList<Shape> list2 = CollectionLiterals.<Shape>newArrayList(_rectangle, _circle, _rectangle_1);
			      final Function1<Shape, String> _function = new Function1<Shape, String>() {
			        @Override
			        public String apply(final Shape shape) {
			          String _switchResult = null;
			          boolean _matched = false;
			          if (shape instanceof Circle) {
			            _matched=true;
			            _switchResult = ("a circle : diameter=" + Integer.valueOf(((Circle)shape).diameter));
			          }
			          if (!_matched) {
			            if (shape instanceof Rectangle) {
			              if ((((Rectangle)shape).height == ((Rectangle)shape).width)) {
			                _matched=true;
			                _switchResult = ("a square : size=" + Integer.valueOf(((Rectangle)shape).width));
			              }
			            }
			          }
			          if (!_matched) {
			            if (shape instanceof Rectangle) {
			              _matched=true;
			              _switchResult = ((("a rectangle : width=" + Integer.valueOf(((Rectangle)shape).width)) + ", height=") + Integer.valueOf(((Rectangle)shape).height));
			            }
			          }
			          return _switchResult;
			        }
			      };
			      _xblockexpression = ListExtensions.<Shape, String>map(list2, _function);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def void typeCoercion() {
		'''
			/*
			 * AUTOBOXING
			 * Xbase supports Java's primitives and also the autoboxing introduced
			 * with Java 1.4.
			 */
			 
			'string'.length
			// 6 (int)
			
			val Integer i = 'string'.length
			i
			// 6 (Integer)
			
			/*
			 * It does autoboxing even when used in the receiver context.
			 */
			
			'string'.length.toString
			// 6 (String)
			
			/*
			 * Arrays are automatically coerced to Lists.
			 */
			 
			'string'.toCharArray
			// [C@388e28 (char[])
			
			val java.util.List<Character> l = 'string'.toCharArray
			// [s, t, r, i, n, g] (void)
			
			/*
			 * Again this works also in a receiver context.
			 */
			
			'string'.toCharArray.get(3)
			// i (Character)
			
			/*
			 * Closure Coercion
			 * A closure can be passed whenever a type is expected which has only defined 
			 * one method in addition to the ones inherited from java.lang.Object
			 */
			val java.util.Comparator<String> comparator = [a,b| a.length.compareTo(b.length)]
		'''.assertCompilesTo('''
			import java.util.Comparator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Conversions;
			
			@SuppressWarnings("all")
			public class MyFile {
			  public void myMethod() throws Throwable {
			    "string".length();
			    final Integer i = Integer.valueOf("string".length());
			    /* i; */
			    Integer.valueOf("string".length()).toString();
			    "string".toCharArray();
			    final List<Character> l = (List<Character>)Conversions.doWrapArray("string".toCharArray());
			    /* "string".toCharArray()[3]; */
			    final Comparator<String> _function = new Comparator<String>() {
			      @Override
			      public int compare(final String a, final String b) {
			        return Integer.valueOf(a.length()).compareTo(Integer.valueOf(b.length()));
			      }
			    };
			    final Comparator<String> comparator = _function;
			  }
			}
		''')
	}
	
}
