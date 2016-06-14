/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug416305Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class A<T> {
				def <E extends T> void f(Iterable<E> iterable) {
				}
				def <E extends T> void f(java.util.Iterator<E> iterable) {
				}
				def static void main(String[] args) {
					val list = #["abc", "def"]
					val a = new A<String>
					a.f(list)
				}
			}
		''', '''
			import java.util.Collections;
			import java.util.Iterator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class A<T extends Object> {
			  public <E extends T> void f(final Iterable<E> iterable) {
			  }
			  
			  public <E extends T> void f(final Iterator<E> iterable) {
			  }
			  
			  public static void main(final String[] args) {
			    final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("abc", "def"));
			    final A<String> a = new A<String>();
			    a.<String>f(list);
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class A<T> {
				def <E extends T> void f(Iterable<E> iterable) {
				}
				def <E extends T> void f(java.util.Iterator<E> iterable) {
				}
				def static void main(String[] args) {
					val list = #["abc", "def"]
					val a = new A<CharSequence>
					a.f(list)
				}
			}
		''', '''
			import java.util.Collections;
			import java.util.Iterator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class A<T extends Object> {
			  public <E extends T> void f(final Iterable<E> iterable) {
			  }
			  
			  public <E extends T> void f(final Iterator<E> iterable) {
			  }
			  
			  public static void main(final String[] args) {
			    final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("abc", "def"));
			    final A<CharSequence> a = new A<CharSequence>();
			    a.<String>f(list);
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class A<T> {
				def <E extends T> void f(Iterable<E> iterable) {
				}
				def <E extends T> void f(java.util.Iterator<E> iterable) {
				}
				def static void main(String[] args) {
					val list = #[]
					val a = new A<String>
					a.f(list)
				}
			}
		''', '''
			import java.util.Collections;
			import java.util.Iterator;
			import java.util.List;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class A<T extends Object> {
			  public <E extends T> void f(final Iterable<E> iterable) {
			  }
			  
			  public <E extends T> void f(final Iterator<E> iterable) {
			  }
			  
			  public static void main(final String[] args) {
			    final List<String> list = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList());
			    final A<String> a = new A<String>();
			    a.<String>f(list);
			  }
			}
		''')
	}
	
	
}