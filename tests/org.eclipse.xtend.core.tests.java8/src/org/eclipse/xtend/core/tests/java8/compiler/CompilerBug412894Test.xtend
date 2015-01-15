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
import org.junit.Ignore
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug412894Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			class C {
				def m()	{
					val list = newArrayList
					list.forEach [
						switch it {
							String: list.add(it)
						}
					]
				}
			}
		'''.assertCompilesTo('''
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final ArrayList<String> list = CollectionLiterals.<String>newArrayList();
			    final Consumer<String> _function = (String it) -> {
			      boolean _matched = false;
			      if (!_matched) {
			        if (it instanceof String) {
			          _matched=true;
			          list.add(it);
			        }
			      }
			    };
			    list.forEach(_function);
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			class C {
				def m()	{
					val list = newArrayList
					list.forEach [
						switch it {
							String: list.add(it)
							Number: list.add(it)
						}
					]
				}
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final ArrayList<Serializable> list = CollectionLiterals.<Serializable>newArrayList();
			    final Consumer<Serializable> _function = (Serializable it) -> {
			      boolean _matched = false;
			      if (!_matched) {
			        if (it instanceof String) {
			          _matched=true;
			          list.add(it);
			        }
			      }
			      if (!_matched) {
			        if (it instanceof Number) {
			          _matched=true;
			          list.add(it);
			        }
			      }
			    };
			    list.forEach(_function);
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			class C {
				def m()	{
					val list = newArrayList
					list.forEach [
						switch it {
							Number: list.add(it.toString)
						}
					]
				}
			}
		'''.assertCompilesTo('''
			import java.io.Serializable;
			import java.util.ArrayList;
			import java.util.function.Consumer;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    final ArrayList<String> list = CollectionLiterals.<String>newArrayList();
			    final Consumer<Serializable> _function = (Serializable it) -> {
			      boolean _matched = false;
			      if (!_matched) {
			        if (it instanceof Number) {
			          _matched=true;
			          String _string = ((Number)it).toString();
			          list.add(_string);
			        }
			      }
			    };
			    list.forEach(_function);
			  }
			}
		''')
	}
	
	@Ignore /* TODO see https://bugs.eclipse.org/bugs/show_bug.cgi?id=457539 */
	@Test def test_04() {
		'''
			class C {
				def m()	{
					val list = newArrayList
					list.forEach [
						if (it instanceof String) list.add(it)
					]
				}
			}
		'''.assertCompilesTo('''

		''')
	}
	
}