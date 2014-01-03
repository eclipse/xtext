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
class CompilerBug410556Test extends AbstractXtendCompilerTest {
	
	@Test
	def testConstructorTypeParameter_01() {
		assertCompilesTo('''
			class C {
				def void m() {
					new bug413824.ConstructorTypeParameter('')
				}
			}
		''', '''
			import bug413824.ConstructorTypeParameter;
			
			@SuppressWarnings("all")
			public class C {
			  public void m() {
			    new <String>ConstructorTypeParameter("");
			  }
			}
		''')
	}
	
	@Test
	def testConstructorTypeParameter_02() {
		assertCompilesTo('''
			class C {
				def void m(Integer i, String s) {
					new bug413824.ConstructorAndClassTypeParameter(i, s)
				}
			}
		''', '''
			import bug413824.ConstructorAndClassTypeParameter;
			
			@SuppressWarnings("all")
			public class C {
			  public void m(final Integer i, final String s) {
			    new <String>ConstructorAndClassTypeParameter<Integer>(i, s);
			  }
			}
		''')
	}
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class BugTypeInference<T> {
				new(Class<T> c) {
				}
				def static void main(String[] args) {
					new BugTypeInference(Object)
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class BugTypeInference<T extends Object> {
			  public BugTypeInference(final Class<T> c) {
			  }
			  
			  public static void main(final String[] args) {
			    new BugTypeInference<Object>(Object.class);
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class BugTypeInference<T> {
				new(Class<T> c) {
				}
				def static void main(String[] args) {
					val b = new BugTypeInference(Object)
					b.toString
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class BugTypeInference<T extends Object> {
			  public BugTypeInference(final Class<T> c) {
			  }
			  
			  public static void main(final String[] args) {
			    final BugTypeInference<Object> b = new BugTypeInference<Object>(Object.class);
			    b.toString();
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class BugTypeInference<T> {
				new(Class<T> c) {
				}
				def static void main(String[] args) {
					val BugTypeInference<Iterable<String>> b = new BugTypeInference(Iterable)
					b.toString
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class BugTypeInference<T extends Object> {
			  public BugTypeInference(final Class<T> c) {
			  }
			  
			  public static void main(final String[] args) {
			    final BugTypeInference<Iterable<String>> b = new BugTypeInference(Iterable.class);
			    b.toString();
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class BugTypeInference<T> {
				new(Class<T> c) {
				}
				def static void main(String[] args) {
					val b = new BugTypeInference(typeof(Object).getClass)
					b.toString
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class BugTypeInference<T extends Object> {
			  public BugTypeInference(final Class<T> c) {
			  }
			  
			  public static void main(final String[] args) {
			    Class<? extends Class> _class = Object.class.getClass();
			    final BugTypeInference<? extends Class> b = new BugTypeInference(_class);
			    b.toString();
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			class BugTypeInference<T> {
				new(Class<T> c) {
				}
				def static void main(String[] args) {
					val b = new BugTypeInference(Iterable)
					b.toString
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class BugTypeInference<T extends Object> {
			  public BugTypeInference(final Class<T> c) {
			  }
			  
			  public static void main(final String[] args) {
			    final BugTypeInference<Iterable> b = new BugTypeInference<Iterable>(Iterable.class);
			    b.toString();
			  }
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			class BugTypeInference<T> {
				new(Class<T> c) {
				}
				def static void main(String[] args) {
					val BugTypeInference<Class> b = new BugTypeInference(typeof(Object).getClass)
					b.toString
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class BugTypeInference<T extends Object> {
			  public BugTypeInference(final Class<T> c) {
			  }
			  
			  public static void main(final String[] args) {
			    Class<? extends Class> _class = Object.class.getClass();
			    final BugTypeInference<Class> b = new BugTypeInference(_class);
			    b.toString();
			  }
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			class BugTypeInference<T> {
				new(Class<T> c) {
				}
				def static void main(String[] args) {
					val BugTypeInference b = new BugTypeInference(typeof(Object).getClass)
					b.toString
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class BugTypeInference<T extends Object> {
			  public BugTypeInference(final Class<T> c) {
			  }
			  
			  public static void main(final String[] args) {
			    Class<? extends Class> _class = Object.class.getClass();
			    final BugTypeInference b = new BugTypeInference(_class);
			    b.toString();
			  }
			}
		''')
	}
	
}