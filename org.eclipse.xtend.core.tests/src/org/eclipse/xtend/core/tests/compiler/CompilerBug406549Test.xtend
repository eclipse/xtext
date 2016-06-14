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
class CompilerBug406549Test extends AbstractXtendCompilerTest {
	
	@Test
	def testBug406549_01() {
		assertCompilesTo('''
			class Test<T> {
			    def m(T t){}
			    def void n() {
			        new Test<Object>().m(1L)
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class Test<T extends Object> {
			  public Object m(final T t) {
			    return null;
			  }
			  
			  public void n() {
			    Test<Object> _test = new Test<Object>();
			    _test.m(Long.valueOf(1L));
			  }
			}
		''')
	}
	
	@Test
	def testBug406549_02() {
		assertCompilesTo('''
			class Test<T> {
			    def m(){}
			    def void m(T a, T b) {
			        this => [
			            new Test<T>().m(a, b)
			        ]
			    }
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test<T extends Object> {
			  public Object m() {
			    return null;
			  }
			  
			  public void m(final T a, final T b) {
			    final Procedure1<Test<T>> _function = new Procedure1<Test<T>>() {
			      public void apply(final Test<T> it) {
			        Test<T> _test = new Test<T>();
			        _test.m(a, b);
			      }
			    };
			    ObjectExtensions.<Test<T>>operator_doubleArrow(this, _function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406549_03() {
		assertCompilesTo('''
			class Test<T> {
			    def m(T a, T b){}
			    def m() {
			        new StringBuilder => [
			            new Test<Object>().m(it, new Long(0))
			        ]
			    }
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.ObjectExtensions;
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class Test<T extends Object> {
			  public Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public StringBuilder m() {
			    StringBuilder _stringBuilder = new StringBuilder();
			    final Procedure1<StringBuilder> _function = new Procedure1<StringBuilder>() {
			      public void apply(final StringBuilder it) {
			        Test<Object> _test = new Test<Object>();
			        Long _long = new Long(0);
			        _test.m(it, _long);
			      }
			    };
			    return ObjectExtensions.<StringBuilder>operator_doubleArrow(_stringBuilder, _function);
			  }
			}
		''')
	}
	
	@Test
	def testBug406549_04() {
		assertCompilesTo('''
			class Test<T> {
			    def m(T a, T b){}
			    def m() {
			        new Test<Object>().m(null, new Long(0))
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class Test<T extends Object> {
			  public Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public Object m() {
			    Test<Object> _test = new Test<Object>();
			    Long _long = new Long(0);
			    return _test.m(null, _long);
			  }
			}
		''')
	}
	
	@Test
	def testBug406549_05() {
		assertCompilesTo('''
			class Test<T> {
			    def m(T a, T b){}
			    def m() {
			        new Test().m('', new Long(0))
			    }
			}
		''', '''
			@SuppressWarnings("all")
			public class Test<T extends Object> {
			  public Object m(final T a, final T b) {
			    return null;
			  }
			  
			  public Object m() {
			    Test<Object> _test = new Test<Object>();
			    Long _long = new Long(0);
			    return _test.m("", _long);
			  }
			}
		''')
	}
}