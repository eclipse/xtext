/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.tests.compiler.XtendCompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * Tests for the Xtend compiler configured for Java 8. Several test cases have been copied from
 * {@link XtendCompilerTest}.
 * 
 * @author Miro Spoenemann - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider)
class Java8CompilerTest extends AbstractXtendCompilerTest {
	
	@Test def void testStaticMethodInInterface() {
		'''
			interface Foo {
				static def bar() {
					"bar!"
				}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public interface Foo {
			  public static String bar() {
			    return "bar!";
			  }
			}
		''')
	}
	
	@Test def void testJava8UnaryOperator() throws Exception {
		'''
			import java.util.List
			class Test {
				def test(List<Integer> list) {
					list.replaceAll[it + 1]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.UnaryOperator;
			
			@SuppressWarnings("all")
			public class Test {
			  public void test(final List<Integer> list) {
			    final UnaryOperator<Integer> _function = (Integer it) -> {
			      return Integer.valueOf(((it).intValue() + 1));
			    };
			    list.replaceAll(_function);
			  }
			}
		''')
	}
	
	@Test def void testJava8Comparator() throws Exception {
		'''
			import java.util.List
			class Test {
				def test(List<String> list) {
					list.sort(java.util.Comparator.comparingInt[String s | s.length]
						.thenComparing[String s | s.length])
				}
			}
		'''.assertCompilesTo('''
			import java.util.Comparator;
			import java.util.List;
			import java.util.function.Function;
			import java.util.function.ToIntFunction;
			
			@SuppressWarnings("all")
			public class Test {
			  public void test(final List<String> list) {
			    final ToIntFunction<String> _function = (String s) -> {
			      return s.length();
			    };
			    Comparator<String> _comparingInt = Comparator.<String>comparingInt(_function);
			    final Function<String, Integer> _function_1 = (String s_1) -> {
			      return Integer.valueOf(s_1.length());
			    };
			    Comparator<String> _thenComparing = _comparingInt.<Integer>thenComparing(_function_1);
			    list.sort(_thenComparing);
			  }
			}
		''')
	}
	
	@Test def void testJava8Predicate() throws Exception {
		'''
			import java.util.List
			class Test {
				def test(List<Integer> list) {
					list.removeIf[it < 2]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Predicate;
			
			@SuppressWarnings("all")
			public class Test {
			  public boolean test(final List<Integer> list) {
			    final Predicate<Integer> _function = (Integer it) -> {
			      return ((it).intValue() < 2);
			    };
			    return list.removeIf(_function);
			  }
			}
		''')
	}

	@Test def void testJava8BinaryOperation() throws Exception {
		'''
			import java.util.List
			class Test {
				def test(List<Boolean> list) {
					list.stream.reduce[a, b | a && b]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.Optional;
			import java.util.function.BinaryOperator;
			import java.util.stream.Stream;
			
			@SuppressWarnings("all")
			public class Test {
			  public Optional<Boolean> test(final List<Boolean> list) {
			    Stream<Boolean> _stream = list.stream();
			    final BinaryOperator<Boolean> _function = (Boolean a, Boolean b) -> {
			      boolean _and = false;
			      if (!(a).booleanValue()) {
			        _and = false;
			      } else {
			        _and = (b).booleanValue();
			      }
			      return Boolean.valueOf(_and);
			    };
			    return _stream.reduce(_function);
			  }
			}
		''')
	}

	@Test def void testJava8Consumer() throws Exception {
		'''
			import java.util.List
			class Test {
				def test(List<String> list) {
					list.stream.forEach[println(it)]
				}
			}
		'''.assertCompilesTo('''
			import java.util.List;
			import java.util.function.Consumer;
			import java.util.stream.Stream;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class Test {
			  public void test(final List<String> list) {
			    Stream<String> _stream = list.stream();
			    final Consumer<String> _function = (String it) -> {
			      InputOutput.<String>println(it);
			    };
			    _stream.forEach(_function);
			  }
			}
		''')
	}

	@Test def void testJava8BiFunction() throws Exception {
		'''
			import java.util.Map
			class Test {
				def test(Map<String, Integer> map) {
					map.replaceAll[k, v | v + k.length]
				}
			}
		'''.assertCompilesTo('''
			import java.util.Map;
			import java.util.function.BiFunction;
			
			@SuppressWarnings("all")
			public class Test {
			  public void test(final Map<String, Integer> map) {
			    final BiFunction<String, Integer, Integer> _function = (String k, Integer v) -> {
			      int _length = k.length();
			      return Integer.valueOf(((v).intValue() + _length));
			    };
			    map.replaceAll(_function);
			  }
			}
		''')
	}

	@Test def void testSelfReference() throws Exception {
		'''
			class LambdaTest {
				def b(A a) {
					a.a
				}
				def test() {
					b['hello' + b['world' + self.a]]
				}
			}
			interface A {
				def String a()
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class LambdaTest {
			  public String b(final A a) {
			    return a.a();
			  }
			  
			  public String test() {
			    final A _function = () -> {
			      final A _function_1 = new A() {
			        @Override
			        public String a() {
			          String _a = this.a();
			          return ("world" + _a);
			        }
			      };
			      String _b = LambdaTest.this.b(_function_1);
			      return ("hello" + _b);
			    };
			    return LambdaTest.this.b(_function);
			  }
			}
		''')
	}
	
	@Test def testVoidMethod_03() throws Exception {
		'''
			class A {
				def m() {
					[ | println('') ]
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class A {
			  public Function0<String> m() {
			    final Function0<String> _function = () -> {
			      return InputOutput.<String>println("");
			    };
			    return _function;
			  }
			}
		''')
	}
	
	@Test def testThrowablesPropagate_01() throws Exception {
		'''
			import static extension Throwables.*
			import java.net.URI
			
			class Client {
				val uri = [| new URI('')].propagate [ new IllegalArgumentException(it) ]
				
				def foo (){
					uri.toString
				}
			}
			class Throwables {
				def static <T> T propagate(()=>T proc, (Exception)=>Exception handler) {
					try {
						proc.apply
					} catch(Exception e) {
						throw handler.apply(e)
					}
				}
			}
		'''.assertCompilesTo('''
			import java.net.URI;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Client {
			  private final URI uri = Throwables.<URI>propagate(((Function0<URI>) () -> {
			    try {
			      return new URI("");
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }), ((Function1<Exception, Exception>) (Exception it) -> {
			    return new IllegalArgumentException(it);
			  }));
			  
			  public String foo() {
			    return this.uri.toString();
			  }
			}
		''')
	}
	
	@Test def testThrowablesPropagate_02() throws Exception {
		'''
			import static extension Throwables.*
			import java.net.URI
			
			class Client {
				val uri = [| new URI('')].propagate [ new IllegalArgumentException(it) ]
			}
			class Throwables {
				def static <T> T propagate(()=>T proc, (Exception)=>Exception handler) {
					try {
						proc.apply
					} catch(Exception e) {
						throw handler.apply(e)
					}
				}
			}
		'''.assertCompilesTo('''
			import java.net.URI;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Client {
			  private final URI uri = Throwables.<URI>propagate(((Function0<URI>) () -> {
			    try {
			      return new URI("");
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }), ((Function1<Exception, Exception>) (Exception it) -> {
			    return new IllegalArgumentException(it);
			  }));
			}
		''')
	}
	
	@Test
	def testSwitchWithBooleanExpression_3() {
		'''
			class Foo {
				def foo(int x) { 
					switch x {
						case [|1 == x].apply || x == 2: true
						default: false
					}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Foo {
			  public boolean foo(final int x) {
			    boolean _switchResult = false;
			    boolean _matched = false;
			    if (!_matched) {
			      boolean _or = false;
			      final Function0<Boolean> _function = () -> {
			        return Boolean.valueOf((1 == x));
			      };
			      Boolean _apply = _function.apply();
			      if ((_apply).booleanValue()) {
			        _or = true;
			      } else {
			        _or = (x == 2);
			      }
			      if (_or) {
			        _matched=true;
			        _switchResult = true;
			      }
			    }
			    if (!_matched) {
			      _switchResult = false;
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testSwitchOverNull() {
		'''
			public class Foo  {
			    def foo() {
			        switch null {
			            case null : [Object it|it]
			            case null : [Integer it|it]
			        }
			    }    
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Foo {
			  public Function1<? super Integer, ?> foo() {
			    Function1<? super Integer, ?> _switchResult = null;
			    final Object _switchValue = null;
			    boolean _matched = false;
			    if (!_matched) {
			      if (Objects.equal(_switchValue, null)) {
			        _matched=true;
			        final Function1<Object, Object> _function = (Object it) -> {
			          return it;
			        };
			        _switchResult = _function;
			      }
			    }
			    if (!_matched) {
			      if (Objects.equal(_switchValue, null)) {
			        _matched=true;
			        final Function1<Integer, Integer> _function_1 = (Integer it_1) -> {
			          return it_1;
			        };
			        _switchResult = _function_1;
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_6() {
		'''
			class Foo {
				def foo() {
					switch x : [|1].apply {
						case 1: true
					}
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Foo {
			  public boolean foo() {
			    boolean _switchResult = false;
			    final Function0<Integer> _function = () -> {
			      return Integer.valueOf(1);
			    };
			    Integer _apply = _function.apply();
			    final Integer x = _apply;
			    if (x != null) {
			      switch (x) {
			        case 1:
			          _switchResult = true;
			          break;
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test
	def testSwitchWithConstantExpressions_7() {
		'''
			class Foo {
				def foo() {
					switch x : 1 {
						case [|1].apply: true
					}
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Foo {
			  public boolean foo() {
			    boolean _switchResult = false;
			    final int x = 1;
			    boolean _matched = false;
			    if (!_matched) {
			      final Function0<Integer> _function = () -> {
			        return Integer.valueOf(1);
			      };
			      Integer _apply = _function.apply();
			      if (Objects.equal(x, _apply)) {
			        _matched=true;
			        _switchResult = true;
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}

	@Test	
	def testClosureSneakyThrow() {
		'''
			import java.io.File
			import java.io.IOException
			import java.util.Collections
			
			class Foo {
			   def bar() {
			       try {
			           newArrayList("file1.ext").map(f| new File(f).canonicalFile)
			       } catch(IOException o) {
			           Collections::<File>emptyList
			       }
			   }
			}
		'''.assertCompilesTo('''
			import java.io.File;
			import java.io.IOException;
			import java.util.ArrayList;
			import java.util.Collections;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class Foo {
			  public List<File> bar() {
			    List<File> _xtrycatchfinallyexpression = null;
			    try {
			      ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("file1.ext");
			      final Function1<String, File> _function = (String f) -> {
			        try {
			          File _file = new File(f);
			          return _file.getCanonicalFile();
			        } catch (Throwable _e) {
			          throw Exceptions.sneakyThrow(_e);
			        }
			      };
			      _xtrycatchfinallyexpression = ListExtensions.<String, File>map(_newArrayList, _function);
			    } catch (final Throwable _t) {
			      if (_t instanceof IOException) {
			        final IOException o = (IOException)_t;
			        _xtrycatchfinallyexpression = Collections.<File>emptyList();
			      } else {
			        throw Exceptions.sneakyThrow(_t);
			      }
			    }
			    return _xtrycatchfinallyexpression;
			  }
			}
		''')
	}
	
	@Test
	def testClosureSneakyThrow_02() throws Exception {
		'''
			abstract class Foo {
			 def Object getFoo(String x) throws Exception
			 def bar() {
			   <String>newArrayList.toMap[foo]
			 }
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.Map;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public abstract class Foo {
			  public abstract Object getFoo(final String x) throws Exception;
			  
			  public Map<Object, String> bar() {
			    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList();
			    final Function1<String, Object> _function = (String it) -> {
			      try {
			        return Foo.this.getFoo(it);
			      } catch (Throwable _e) {
			        throw Exceptions.sneakyThrow(_e);
			      }
			    };
			    return IterableExtensions.<Object, String>toMap(_newArrayList, _function);
			  }
			}
		''')
	}
	
	@Test
	def testNestedClosureWithIt() {
		'''
			class X {
				def foo() {
					val (String)=>String function = [ [String it | it].apply(it) ]
					function.apply('foo')
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class X {
			  public String foo() {
			    String _xblockexpression = null;
			    {
			      final Function1<String, String> _function = (String it) -> {
			        final Function1<String, String> _function_1 = (String it_1) -> {
			          return it_1;
			        };
			        return _function_1.apply(it);
			      };
			      final Function1<? super String, ? extends String> function = _function;
			      _xblockexpression = function.apply("foo");
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test
	def testNestedClosureSuperCall() {
		'''
			class X {
				def foo() {
					[| [| super.toString ].apply ].apply
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class X {
			  public String foo() {
			    final Function0<String> _function = () -> {
			      final Function0<String> _function_1 = () -> {
			        return X.super.toString();
			      };
			      return _function_1.apply();
			    };
			    return _function.apply();
			  }
			}
		''')
	}
	
	@Test
	def testFindFirstOnIt_01() { 
		'''
			class FindFirstOnIt {
				def <T> useExtension(Iterable<T> it) {
					findFirst [ it !== null ]
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class FindFirstOnIt {
			  public <T extends Object> T useExtension(final Iterable<T> it) {
			    final Function1<T, Boolean> _function = (T it_1) -> {
			      return Boolean.valueOf((it_1 != null));
			    };
			    return IterableExtensions.<T>findFirst(it, _function);
			  }
			}
		''')
	}
	
	@Test
	def testReturnType_02() {
		'''
			import test.ReturnTypeUsesTypeParameter
			class MyClass implements ReturnTypeUsesTypeParameter {
			
				override <LocalName extends CharSequence> accept(LocalName param) {
					[ if (true) it?.apply(param) ] 
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			import test.ReturnTypeUsesTypeParameter;
			
			@SuppressWarnings("all")
			public class MyClass implements ReturnTypeUsesTypeParameter {
			  @Override
			  public <LocalName extends CharSequence> ReturnTypeUsesTypeParameter.Inner<LocalName> accept(final LocalName param) {
			    final ReturnTypeUsesTypeParameter.Inner<LocalName> _function = (Procedure1<? super LocalName> it) -> {
			      if (true) {
			        if (it!=null) {
			          it.apply(param);
			        }
			      }
			    };
			    return _function;
			  }
			}
		''')
	}
	
}