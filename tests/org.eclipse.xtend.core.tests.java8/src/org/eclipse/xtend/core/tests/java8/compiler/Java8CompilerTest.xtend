/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
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
	
}