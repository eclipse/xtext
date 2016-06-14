/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug383534Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			class C {
				def void m() {
					val (String,String)=>String strAdd = [s1,s2 | s1+s2]
					val /*(String)=>String*/ curriedStrAdd = strAdd.curry('x') // ok
					
					println(strAdd.apply('x', 'y')) // result: 'xy'
					println(curriedStrAdd.apply('y')) // result: 'xy'
					
					val (String,String[])=>String strAdd2 = [s1,s2 | s1 + s2.reduce[x1,x2 | x1+x2]]
					val /*(String)=>String*/ curriedStrAdd2 = strAdd2.curry('x') // fail
					
					println(strAdd2.apply('x', newArrayList('y', 'z'))) // result: 'xyz'
					println(curriedStrAdd2.apply(newArrayList('y', 'z'))) // should result in 'xyz'
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.FunctionExtensions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final Function2<String, String, String> _function = (String s1, String s2) -> {
			      return (s1 + s2);
			    };
			    final Function2<? super String, ? super String, ? extends String> strAdd = _function;
			    final Function1<String, String> curriedStrAdd = FunctionExtensions.<String, String, String>curry(strAdd, "x");
			    String _apply = strAdd.apply("x", "y");
			    InputOutput.<String>println(_apply);
			    String _apply_1 = curriedStrAdd.apply("y");
			    InputOutput.<String>println(_apply_1);
			    final Function2<String, String[], String> _function_1 = (String s1, String[] s2) -> {
			      final Function2<String, String, String> _function_2 = (String x1, String x2) -> {
			        return (x1 + x2);
			      };
			      String _reduce = IterableExtensions.<String>reduce(((Iterable<? extends String>)Conversions.doWrapArray(s2)), _function_2);
			      return (s1 + _reduce);
			    };
			    final Function2<? super String, ? super String[], ? extends String> strAdd2 = _function_1;
			    final Function1<String[], String> curriedStrAdd2 = FunctionExtensions.<String, String[], String>curry(strAdd2, "x");
			    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("y", "z");
			    String _apply_2 = strAdd2.apply("x", ((String[])Conversions.unwrapArray(_newArrayList, String.class)));
			    InputOutput.<String>println(_apply_2);
			    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("y", "z");
			    String _apply_3 = curriedStrAdd2.apply(((String[])Conversions.unwrapArray(_newArrayList_1, String.class)));
			    InputOutput.<String>println(_apply_3);
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			class C {
				def void m() {
					val (String,String)=>String strAdd = [s1,s2 | s1+s2]
					val curriedStrAdd = strAdd.curry('x')
					println(strAdd.apply('x', 'y')) // result: 'xy'
					println(curriedStrAdd.apply('y')) // result: 'xy'
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.FunctionExtensions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final Function2<String, String, String> _function = (String s1, String s2) -> {
			      return (s1 + s2);
			    };
			    final Function2<? super String, ? super String, ? extends String> strAdd = _function;
			    final Function1<String, String> curriedStrAdd = FunctionExtensions.<String, String, String>curry(strAdd, "x");
			    String _apply = strAdd.apply("x", "y");
			    InputOutput.<String>println(_apply);
			    String _apply_1 = curriedStrAdd.apply("y");
			    InputOutput.<String>println(_apply_1);
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			class C {
				def void m() {
					val (String,String[])=>String strAdd = [s1,s2 | s1+s2.head]
					val curriedStrAdd = strAdd.curry('x')
					println(strAdd.apply('x', newArrayList('y', 'z')))
					println(curriedStrAdd.apply(newArrayList('y', 'z')))
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.FunctionExtensions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final Function2<String, String[], String> _function = (String s1, String[] s2) -> {
			      String _head = IterableExtensions.<String>head(((Iterable<String>)Conversions.doWrapArray(s2)));
			      return (s1 + _head);
			    };
			    final Function2<? super String, ? super String[], ? extends String> strAdd = _function;
			    final Function1<String[], String> curriedStrAdd = FunctionExtensions.<String, String[], String>curry(strAdd, "x");
			    ArrayList<String> _newArrayList = CollectionLiterals.<String>newArrayList("y", "z");
			    String _apply = strAdd.apply("x", ((String[])Conversions.unwrapArray(_newArrayList, String.class)));
			    InputOutput.<String>println(_apply);
			    ArrayList<String> _newArrayList_1 = CollectionLiterals.<String>newArrayList("y", "z");
			    String _apply_1 = curriedStrAdd.apply(((String[])Conversions.unwrapArray(_newArrayList_1, String.class)));
			    InputOutput.<String>println(_apply_1);
			  }
			}
		''')
	}
	
	@Test def test_04() {
		'''
			class C {
				def void m() {
					val (String,String[])=>String strAdd = [s1,s2 | s1+s2.reduce[x1,x2 | x1+x2]]
					val curriedStrAdd = strAdd.curry('x')
					println(strAdd.apply('x', #['y'])) // result: 'xy'
					println(curriedStrAdd.apply(#['y'])) // result: 'xy'
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Conversions;
			import org.eclipse.xtext.xbase.lib.FunctionExtensions;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.Functions.Function2;
			import org.eclipse.xtext.xbase.lib.InputOutput;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final Function2<String, String[], String> _function = (String s1, String[] s2) -> {
			      final Function2<String, String, String> _function_1 = (String x1, String x2) -> {
			        return (x1 + x2);
			      };
			      String _reduce = IterableExtensions.<String>reduce(((Iterable<? extends String>)Conversions.doWrapArray(s2)), _function_1);
			      return (s1 + _reduce);
			    };
			    final Function2<? super String, ? super String[], ? extends String> strAdd = _function;
			    final Function1<String[], String> curriedStrAdd = FunctionExtensions.<String, String[], String>curry(strAdd, "x");
			    String _apply = strAdd.apply("x", new String[] { "y" });
			    InputOutput.<String>println(_apply);
			    String _apply_1 = curriedStrAdd.apply(new String[] { "y" });
			    InputOutput.<String>println(_apply_1);
			  }
			}
		''')
	}
	
}