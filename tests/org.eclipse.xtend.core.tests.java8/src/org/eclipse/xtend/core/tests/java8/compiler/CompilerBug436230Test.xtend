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
class CompilerBug436230Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			import java.util.List
			class Foo {
				val List<CharSequence> list = newArrayList
				def foo(List<? extends Object> source) {
					list += source.map['']
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.Iterables;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.ListExtensions;
			
			@SuppressWarnings("all")
			public class Foo {
			  private final List<CharSequence> list = CollectionLiterals.<CharSequence>newArrayList();
			  
			  public boolean foo(final List<?> source) {
			    final Function1<Object, String> _function = (Object it) -> {
			      return "";
			    };
			    List<String> _map = ListExtensions.map(source, _function);
			    return Iterables.<CharSequence>addAll(this.list, _map);
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			import java.util.List
			class C {
				def m() { 
					val List<CharSequence> res = null
					val Iterable<? extends Object> obj = null
					res += obj.map[""]
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.Iterables;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public boolean m() {
			    boolean _xblockexpression = false;
			    {
			      final List<CharSequence> res = null;
			      final Iterable<?> obj = null;
			      final Function1<Object, String> _function = (Object it) -> {
			        return "";
			      };
			      Iterable<String> _map = IterableExtensions.map(obj, _function);
			      _xblockexpression = Iterables.<CharSequence>addAll(res, _map);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			import java.util.List
			class C {
				def m() { 
					val List<? super CharSequence> res = null
					val Iterable<? extends Object> obj = null
					res += obj.map[""]
				}
			}
		'''.assertCompilesTo('''
			import com.google.common.collect.Iterables;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public boolean m() {
			    boolean _xblockexpression = false;
			    {
			      final List<? super CharSequence> res = null;
			      final Iterable<?> obj = null;
			      final Function1<Object, String> _function = (Object it) -> {
			        return "";
			      };
			      Iterable<? extends CharSequence> _map = IterableExtensions.map(obj, _function);
			      _xblockexpression = Iterables.addAll(res, _map);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
	@Test def test_04() {
		'''
			import java.util.List
			class C {
				def Iterable<? extends CharSequence> m() { 
					val Iterable<? extends Object> obj = null
					obj.map[""]
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			import org.eclipse.xtext.xbase.lib.IterableExtensions;
			
			@SuppressWarnings("all")
			public class C {
			  public Iterable<? extends CharSequence> m() {
			    Iterable<String> _xblockexpression = null;
			    {
			      final Iterable<?> obj = null;
			      final Function1<Object, String> _function = (Object it) -> {
			        return "";
			      };
			      _xblockexpression = IterableExtensions.map(obj, _function);
			    }
			    return _xblockexpression;
			  }
			}
		''')
	}
	
}