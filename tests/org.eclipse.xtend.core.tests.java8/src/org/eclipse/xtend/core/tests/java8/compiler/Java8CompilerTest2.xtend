/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.XtendCompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider)
class Java8CompilerTest2 extends XtendCompilerTest {
	
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
			    final Function<String, Integer> _function_1 = (String s) -> {
			      return Integer.valueOf(s.length());
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
	
	@Test def void testDefaultMethodSuperCall01() throws Exception {
		'''
			class Test implements A {
				override void foo() {
					A.super.foo
				}
			}
			interface A {
				def void foo() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test implements A {
			  @Override
			  public void foo() {
			    A.super.foo();
			  }
			}
		''')
	}
	
	@Test def void testDefaultMethodSuperCall02() throws Exception {
		'''
			class Test implements A, B {
				override void foo() {
					B.super.foo
				}
			}
			interface A {
				def void foo() {}
			}
			interface B {
				def void foo() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Test implements A, B {
			  @Override
			  public void foo() {
			    B.super.foo();
			  }
			}
		''')
	}
	
	@Test def void testDefaultMethodSuperCall03() throws Exception {
		'''
			import test.Consumer
			class Test implements Consumer, java.util.function.Consumer<String> {
				override void accept(String element) {
					java.util.function.Consumer.super.andThen(this).accept('foo')
				}
			}
		'''.assertCompilesTo('''
			import test.Consumer;
			
			@SuppressWarnings("all")
			public class Test implements Consumer, java.util.function.Consumer<String> {
			  @Override
			  public void accept(final String element) {
			    java.util.function.Consumer<String> _andThen = java.util.function.Consumer.super.andThen(this);
			    _andThen.accept("foo");
			  }
			}
		''')
	}
	
	@Test def void testDefaultMethodSuperCall04() throws Exception {
		'''
			interface Test extends A {
				override void foo() {
					A.super.foo
				}
			}
			interface A {
				def void foo() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public interface Test extends A {
			  @Override
			  public default void foo() {
			    A.super.foo();
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
			      String _b = this.b(_function_1);
			      return ("hello" + _b);
			    };
			    return this.b(_function);
			  }
			}
		''')
	}

	@Test override testClosureNoArgs() {
		'''
			class Foo {
			   val thread = new Thread []
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class Foo {
			  private final Thread thread = new Thread(((Runnable) () -> {
			  }));
			}
		''')
	}
	
	@Test override testClosureTwoArgs() {
		'''
			class Foo {
				def void m(java.util.List<String> list) {
					java.util.Collections.sort(list) [ return 0 ]
				}
			}
		'''.assertCompilesTo('''
			import java.util.Collections;
			import java.util.Comparator;
			import java.util.List;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void m(final List<String> list) {
			    final Comparator<String> _function = (String $0, String $1) -> {
			      return 0;
			    };
			    Collections.<String>sort(list, _function);
			  }
			}
		''')
	}
	
	@Test override testVoidMethod_02() throws Exception {
		'''
			class A {
				def m() {
					[ | System::out.println('') ]
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
			
			@SuppressWarnings("all")
			public class A {
			  public Procedure0 m() {
			    final Procedure0 _function = () -> {
			      System.out.println("");
			    };
			    return _function;
			  }
			}
		''')
	}
	
	@Test override testVoidMethod_03() throws Exception {
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
	
	@Test override testThrowablesPropagate_01() throws Exception {
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
	
	@Test override testThrowablesPropagate_02() throws Exception {
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
	
	@Test override testSwitchWithBooleanExpression_3() {
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
			    if (!_matched) {
			      _switchResult = false;
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test override testSwitchOverNull() {
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
			    if (Objects.equal(_switchValue, null)) {
			      _matched=true;
			      final Function1<Object, Object> _function = (Object it) -> {
			        return it;
			      };
			      _switchResult = _function;
			    }
			    if (!_matched) {
			      if (Objects.equal(_switchValue, null)) {
			        _matched=true;
			        final Function1<Integer, Integer> _function_1 = (Integer it) -> {
			          return it;
			        };
			        _switchResult = _function_1;
			      }
			    }
			    return _switchResult;
			  }
			}
		''')
	}
	
	@Test override testSwitchWithConstantExpressions_6() {
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
	
	@Test override testSwitchWithConstantExpressions_7() {
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
			    final Function0<Integer> _function = () -> {
			      return Integer.valueOf(1);
			    };
			    Integer _apply = _function.apply();
			    if (Objects.equal(x, _apply)) {
			      _matched=true;
			      _switchResult = true;
			    }
			    return _switchResult;
			  }
			}
		''')
	}

	@Test override testClosureSneakyThrow() {
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
	
	@Test override testClosureSneakyThrow_02() throws Exception {
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
			        return this.getFoo(it);
			      } catch (Throwable _e) {
			        throw Exceptions.sneakyThrow(_e);
			      }
			    };
			    return IterableExtensions.<Object, String>toMap(_newArrayList, _function);
			  }
			}
		''')
	}
	
	@Test override testNestedClosureWithIt() {
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
	
	@Test override testNestedClosureSuperCall() {
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
			        return super.toString();
			      };
			      return _function_1.apply();
			    };
			    return _function.apply();
			  }
			}
		''')
	}
	
	@Test override testFindFirstOnIt_01() { 
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
	
	@Test override testAbstractIterator_03() {
		'''
			import java.util.Iterator
			import com.google.common.collect.AbstractIterator
			public class Foo  {
				def <T> Iterator<T> skipNulls(Iterator<T> iter) {
					val AbstractIterator<T> result = [|
						iter.findFirst [ it !== null ] ?: self.endOfData
					]
					return result
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.AbstractIterator;
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IteratorExtensions;
			
			@SuppressWarnings("all")
			public class Foo {
			  public <T extends Object> Iterator<T> skipNulls(final Iterator<T> iter) {
			    final AbstractIterator<T> _function = new AbstractIterator<T>() {
			      @Override
			      protected T computeNext() {
			        T _elvis = null;
			        final Function1<T, Boolean> _function = (T it) -> {
			          return Boolean.valueOf((it != null));
			        };
			        T _findFirst = IteratorExtensions.<T>findFirst(iter, _function);
			        if (_findFirst != null) {
			          _elvis = _findFirst;
			        } else {
			          T _endOfData = this.endOfData();
			          _elvis = _endOfData;
			        }
			        return _elvis;
			      }
			    };
			    final AbstractIterator<T> result = _function;
			    return result;
			  }
			}
		''')
	}
	
	@Test override testAbstractIterator_04() { 
		'''
			import java.util.Iterator
			import com.google.common.collect.AbstractIterator
			class FindFirstOnIt {

				def <T> Iterator<T> skipNulls(Iterator<T> it) {
					val AbstractIterator<T> result = [|
						findFirst [ it != null ] ?: self.endOfData
					]
					return result
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.base.Objects;
			import com.google.common.collect.AbstractIterator;
			import java.util.Iterator;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IteratorExtensions;
			
			@SuppressWarnings("all")
			public class FindFirstOnIt {
			  public <T extends Object> Iterator<T> skipNulls(final Iterator<T> it) {
			    final AbstractIterator<T> _function = new AbstractIterator<T>() {
			      @Override
			      protected T computeNext() {
			        T _elvis = null;
			        final Function1<T, Boolean> _function = (T it_1) -> {
			          return Boolean.valueOf((!Objects.equal(it_1, null)));
			        };
			        T _findFirst = IteratorExtensions.<T>findFirst(it, _function);
			        if (_findFirst != null) {
			          _elvis = _findFirst;
			        } else {
			          T _endOfData = this.endOfData();
			          _elvis = _endOfData;
			        }
			        return _elvis;
			      }
			    };
			    final AbstractIterator<T> result = _function;
			    return result;
			  }
			}
		''')
	}
	
	@Test override testReturnType() {
		'''
			import test.ReturnTypeUsesTypeParameter
			class MyClass implements ReturnTypeUsesTypeParameter {
			
				override <LocalName extends CharSequence> accept(LocalName param) {
					null
				}
			}
		'''.assertCompilesTo('''
			import test.ReturnTypeUsesTypeParameter;
			
			@SuppressWarnings("all")
			public class MyClass implements ReturnTypeUsesTypeParameter {
			  @Override
			  public <LocalName extends CharSequence> ReturnTypeUsesTypeParameter.Inner<LocalName> accept(final LocalName param) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override testReturnType_02() {
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
	
	@Test override testReturnType_03() {
		'''
			import java.util.LinkedList
			
			class B extends A {
				def String client(CharSequence c) {
					client(m)
				}
				override m() {
					''
				}
			}
			
			abstract class A {
				def CharSequence m() 
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class B extends A {
			  public String client(final CharSequence c) {
			    CharSequence _m = this.m();
			    return this.client(_m);
			  }
			  
			  @Override
			  public CharSequence m() {
			    return "";
			  }
			}
		''')
	}
	
	@Test override testInnerTypeImports_1() {
		'''
			class Foo extends types.SomeClassWithNestedInterface {
				override types.SomeClassWithNestedInterface.String convert(java.lang.String s) {
					return null;
				}
			}
		'''.assertCompilesTo('''
			import types.SomeClassWithNestedInterface;
			
			@SuppressWarnings("all")
			public class Foo extends SomeClassWithNestedInterface {
			  @Override
			  public SomeClassWithNestedInterface.String convert(final java.lang.String s) {
			    return null;
			  }
			}
		''')
	}
	
	@Test override testRecursiveLambda_01() {
		'''
			public class Foo  {
			    def void foo((String)=>String func) {
			    	foo[self.apply(it)]
			    }
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void foo(final Function1<? super String, ? extends String> func) {
			    final Function1<String, String> _function = new Function1<String, String>() {
			      @Override
			      public String apply(final String it) {
			        return this.apply(it);
			      }
			    };
			    this.foo(_function);
			  }
			}
		''')
	}
	
	@Test override testRecursiveLambda_02() {
		'''
			public class Foo  {
			    def void foo(()=>void func) {
			    	foo[|self.apply()]
			    }
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

			@SuppressWarnings("all")
			public class Foo {
			  public void foo(final Procedure0 func) {
			    final Procedure0 _function = new Procedure0() {
			      @Override
			      public void apply() {
			        this.apply();
			      }
			    };
			    this.foo(_function);
			  }
			}
		''')
	}
	
	@Test override testXFunctionTypeRefAsSuperType_01() {
		'''
			class Foo implements ()=>void {
				override apply() {
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
			
			@SuppressWarnings("all")
			public class Foo implements Procedure0 {
			  @Override
			  public void apply() {
			  }
			}
		''')
	}
	
	@Test override testXFunctionTypeRefAsSuperType_02() {
		'''
			interface Foo extends ()=>void {
				override void apply()
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;
			
			@SuppressWarnings("all")
			public interface Foo extends Procedure0 {
			  @Override
			  public abstract void apply();
			}
		''')
	} 
	
	@Test override testXFunctionTypeRefAsSuperType_03() {
		'''
			class Foo implements (String)=>void {
				override apply(String value) {
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

			@SuppressWarnings("all")
			public class Foo implements Procedure1<String> {
			  @Override
			  public void apply(final String value) {
			  }
			}
		''')
	}
	
	@Test override testXFunctionTypeRefAsSuperType_04() {
		'''
			interface Foo extends (String)=>void {
				override void apply(String value)
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

			@SuppressWarnings("all")
			public interface Foo extends Procedure1<String> {
			  @Override
			  public abstract void apply(final String value);
			}
		''')
	} 
	
	@Test override testXFunctionTypeRefAsSuperType_05() {
		'''
			class Foo implements ((String)=>void)=>void {
				override apply((String)=>void procedure) {
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

			@SuppressWarnings("all")
			public class Foo implements Procedure1<Procedure1<? super String>> {
			  @Override
			  public void apply(final Procedure1<? super String> procedure) {
			  }
			}
		''')
	}
	
	@Test override testXFunctionTypeRefAsSuperType_06() {
		'''
			interface Foo extends ((String)=>void)=>void {
				override void apply((String)=>void procedure)
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public interface Foo extends Procedure1<Procedure1<? super String>> {
			  @Override
			  public abstract void apply(final Procedure1<? super String> procedure);
			}
		''')
	} 
	
	@Test override testXFunctionTypeRefAsSuperType_07() {
		'''
			class Foo implements ()=>String {
				override apply() {
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class Foo implements Function0<String> {
			  @Override
			  public String apply() {
			    return null;
			  }
			}
		''')
	}
	
	@Test override testXFunctionTypeRefAsSuperType_08() {
		'''
			interface Foo extends ()=>String {
				override String apply()
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;

			@SuppressWarnings("all")
			public interface Foo extends Function0<String> {
			  @Override
			  public abstract String apply();
			}
		''')
	} 
	
	@Test override testXFunctionTypeRefAsSuperType_09() {
		'''
			class Foo implements ()=>(String)=>void {
				override apply() {
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Foo implements Function0<Procedure1<? super String>> {
			  @Override
			  public Procedure1<? super String> apply() {
			    return null;
			  }
			}
		''')
	}
	
	@Test override testXFunctionTypeRefAsSuperType_10() {
		'''
			interface Foo extends ()=>(String)=>void {
				override (String)=>void apply();
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

			@SuppressWarnings("all")
			public interface Foo extends Function0<Procedure1<? super String>> {
			  @Override
			  public abstract Procedure1<? super String> apply();
			}
		''')
	}

	@Test override testSuperCall_01() {
		'''
			package x class Y extends Object {
				override boolean equals(Object p){
					if ('foo' == p)
						return true
					else
						super.equals(p) 
				} 
			}
		'''.assertCompilesTo('''
			package x;

			import com.google.common.base.Objects;

			@SuppressWarnings("all")
			public class Y {
			  @Override
			  public boolean equals(final Object p) {
			    boolean _xifexpression = false;
			    boolean _equals = Objects.equal("foo", p);
			    if (_equals) {
			      return true;
			    } else {
			      _xifexpression = super.equals(p);
			    }
			    return _xifexpression;
			  }
			}
		''')
	}
	
	@Test override testSuperCall_03() {
		'''
			package x
			class B extends A {
				override getThing() {
					this.getThing('')
					''.getThing
					this.thing
					''.thing
					thing
					getThing('')
					super.getThing('')
					super.thing
					super.getThing
					super.getThing()
				}
			}
			class A {
				def String getThing() {
					getThing('')
				}
				def protected String getThing(String s) {
					return s
				}
			}
		'''.assertCompilesTo('''
			package x;
			
			import x.A;
			
			@SuppressWarnings("all")
			public class B extends A {
			  @Override
			  public String getThing() {
			    String _xblockexpression = null;
			    {
			      this.getThing("");
			      this.getThing("");
			      this.getThing();
			      this.getThing("");
			      this.getThing();
			      this.getThing("");
			      super.getThing("");
			      super.getThing();
			      super.getThing();
			      _xblockexpression = super.getThing();
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	/**
	 * see https://bugs.eclipse.org/bugs/show_bug.cgi?id=395043
	 */
	@Test override testOverriddenVarArgs() {
		'''
			class B extends A {
				override foo(String x, String...args) {
					return x
				}
			}
			abstract class A {
				def String foo(String x, String...args)
			}
			
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class B extends A {
			  @Override
			  public String foo(final String x, final String... args) {
			    return x;
			  }
			}
		''')
	}
	
	@Test override testExpectationFromTypeParameter() {
		'''
			import java.util.Set
			import org.eclipse.xtext.common.types.JvmTypeParameter
			import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference
			import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor
			import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner
			
			class C extends TypeParameterSubstitutor<Set<JvmTypeParameter>> {
				
				new(ITypeReferenceOwner owner) {
					super(null, owner)
				}
				
				override substitute(LightweightTypeReference original) {
					original.accept(this, newHashSet)
				}
			
				override protected createVisiting() {
					return newHashSet
				}
			}
		'''.assertCompilesTo('''
			import java.util.HashSet;
			import java.util.Set;
			import org.eclipse.xtext.common.types.JvmTypeParameter;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.typesystem.references.ITypeReferenceOwner;
			import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
			import org.eclipse.xtext.xbase.typesystem.util.TypeParameterSubstitutor;
			
			@SuppressWarnings("all")
			public class C extends TypeParameterSubstitutor<Set<JvmTypeParameter>> {
			  public C(final ITypeReferenceOwner owner) {
			    super(null, owner);
			  }
			  
			  @Override
			  public LightweightTypeReference substitute(final LightweightTypeReference original) {
			    HashSet<JvmTypeParameter> _newHashSet = CollectionLiterals.<JvmTypeParameter>newHashSet();
			    return original.<Set<JvmTypeParameter>, LightweightTypeReference>accept(this, _newHashSet);
			  }
			  
			  @Override
			  protected Set<JvmTypeParameter> createVisiting() {
			    return CollectionLiterals.<JvmTypeParameter>newHashSet();
			  }
			}
		''')
	}
	
	@Test override testJavaKeywordsUsed() {
		'''
			package foo;
			
			public class Foo {
				def void someMethod(String assert) {
					val synchronized = newArrayList('foo')
					for (volatile : synchronized) {
						switch continue : volatile {
							case continue.length > 2 : synchronized.forEach(break | (break + continue).toString)
						}
					}
				}
			}
		'''.assertCompilesTo('''
			package foo;
			
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class Foo {
			  public void someMethod(final String assert_) {
			    final ArrayList<String> synchronized_ = CollectionLiterals.<String>newArrayList("foo");
			    for (final String volatile_ : synchronized_) {
			      final String continue_ = volatile_;
			      boolean _matched = false;
			      int _length = continue_.length();
			      boolean _greaterThan = (_length > 2);
			      if (_greaterThan) {
			        _matched=true;
			        final Consumer<String> _function = (String break_) -> {
			          (break_ + continue_).toString();
			        };
			        synchronized_.forEach(_function);
			      }
			    }
			  }
			}
		''')
	}
	
}