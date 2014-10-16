/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug447551Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				public val E e = E.copy
			}
			class D {
				static def D copy() { null }
			}
			class E extends D {
				static def E copy() { null }
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public final E e = E.copy();
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				public val E e = E.copy
			}
			class D<T> {
				static def <T> D<T> copy() { null }
			}
			class E<T> extends D<T> {
				static def <T> E<T> copy() { null }
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public final E e = E.<Object>copy();
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				public val E<String> e = E.copy(newArrayList)
			}
			class D<T> {
				static def <T> D<T> copy(Iterable<T> it) { null }
			}
			class E<T> extends D<T> {
				static def <T> E<T> copy(Iterable<T> it) { null }
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public final E<String> e = E.<String>copy(CollectionLiterals.<String>newArrayList());
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				public val e = E.copy(newArrayList)
			}
			class D<T> {
				static def <T> D<T> copy(Iterable<T> it) { null }
			}
			class E<T> extends D<T> {
				static def <T> E<T> copy(Iterable<T> it) { null }
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			
			@SuppressWarnings("all")
			public class C {
			  public final E<Object> e = E.<Object>copy(CollectionLiterals.<Object>newArrayList());
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			class C {
				public val e = E.copy(newArrayList)
				static class D<T> {
					static def <T> D<T> copy(Iterable<T> it) throws java.io.IOException { null }
				}
				static class E<T> extends D<T> {
					static def <T> E<T> copy(Iterable<T> it) throws java.io.IOException { null }
				}
			}
		''', '''
			import java.io.IOException;
			import java.util.ArrayList;
			import org.eclipse.xtext.xbase.lib.CollectionLiterals;
			import org.eclipse.xtext.xbase.lib.Exceptions;
			import org.eclipse.xtext.xbase.lib.Functions.Function0;
			
			@SuppressWarnings("all")
			public class C {
			  public static class D<T extends Object> {
			    public static <T extends Object> C.D<T> copy(final Iterable<T> it) throws IOException {
			      return null;
			    }
			  }
			  
			  public static class E<T extends Object> extends C.D<T> {
			    public static <T extends Object> C.E<T> copy(final Iterable<T> it) throws IOException {
			      return null;
			    }
			  }
			  
			  public final C.E<Object> e = new Function0<C.E<Object>>() {
			    public C.E<Object> apply() {
			      try {
			        ArrayList<Object> _newArrayList = CollectionLiterals.<Object>newArrayList();
			        C.E<Object> _copy = C.E.<Object>copy(_newArrayList);
			        return _copy;
			      } catch (Throwable _e) {
			        throw Exceptions.sneakyThrow(_e);
			      }
			    }
			  }.apply();
			}
		''')
	}
	
}
