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
class CompilerBug419688Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class D extends C<D> {
				new() { super() }
				override m() {
					super.m()
				}
			}
			class C<T extends C<T>>{
				def T m() {}
			}
		''', '''
			@SuppressWarnings("all")
			public class D extends C<D> {
			  public D() {
			    super();
			  }
			  
			  public D m() {
			    D _m = super.m();
			    return _m;
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class D extends C<D> {
				new() { super() }
				override m() {
					super.m()
				}
			}
			class C<T extends C<T>>{
				def Iterable<T> m() {}
			}
		''', '''
			@SuppressWarnings("all")
			public class D extends C<D> {
			  public D() {
			    super();
			  }
			  
			  public Iterable<D> m() {
			    Iterable<D> _m = super.m();
			    return _m;
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class D extends C<D> {
				new() { super() }
				def m() {
					super.m2()
				}
			}
			class C<T extends C<T>>{
				def T m2() {}
			}
		''', '''
			@SuppressWarnings("all")
			public class D extends C<D> {
			  public D() {
			    super();
			  }
			  
			  public D m() {
			    D _m2 = super.m2();
			    return _m2;
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class D extends C<D> {
				new() { super() }
				def m() {
					super.m2() + m2
				}
			}
			class C<T extends C<T>>{
				def Iterable<T> m2() {}
			}
		''', '''
			import com.google.common.collect.Iterables;
			
			@SuppressWarnings("all")
			public class D extends C<D> {
			  public D() {
			    super();
			  }
			  
			  public Iterable<D> m() {
			    Iterable<D> _m2 = super.m2();
			    Iterable<D> _m2_1 = this.m2();
			    Iterable<D> _plus = Iterables.<D>concat(_m2, _m2_1);
			    return _plus;
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			class D extends C<D> {
				new() { super() }
				def m() {
					super.m2()
				}
			}
			class C<T extends C<T>>{
				def <V extends T> V m2() {}
			}
		''', '''
			@SuppressWarnings("all")
			public class D extends C<D> {
			  public D() {
			    super();
			  }
			  
			  public D m() {
			    D _m2 = super.<D>m2();
			    return _m2;
			  }
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			class D extends C<D> {
				new() { super() }
				def m() {
					super.<E>m2()
				}
			}
			class E extends D {}
			class C<T extends C<T>>{
				def <V extends T> V m2() {}
			}
		''', '''
			@SuppressWarnings("all")
			public class D extends C<D> {
			  public D() {
			    super();
			  }
			  
			  public E m() {
			    E _m2 = super.<E>m2();
			    return _m2;
			  }
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			class D extends C<D> {
				new() { super() }
				def m() {
					super.m2()
				}
			}
			class C<T extends C<T>>{
				def <V extends Iterable<T>> V m2() {}
			}
		''', '''
			@SuppressWarnings("all")
			public class D extends C<D> {
			  public D() {
			    super();
			  }
			  
			  public Iterable<D> m() {
			    Iterable<D> _m2 = super.<Iterable<D>>m2();
			    return _m2;
			  }
			}
		''')
	}
	
	@Test
	def test_08() {
		assertCompilesTo('''
			class D extends C<D> {
				new() { super() }
				def DIter m() {
					super.m2()
				}
			}
			abstract class DIter implements Iterable<D> {}
			class C<T extends C<T>>{
				def <V extends Iterable<T>> V m2() {}
			}
		''', '''
			@SuppressWarnings("all")
			public class D extends C<D> {
			  public D() {
			    super();
			  }
			  
			  public DIter m() {
			    DIter _m2 = super.<DIter>m2();
			    return _m2;
			  }
			}
		''')
	}
		
}
