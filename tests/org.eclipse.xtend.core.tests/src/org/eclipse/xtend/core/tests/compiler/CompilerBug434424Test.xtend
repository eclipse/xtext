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
class CompilerBug434424Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				def String m(CharSequence c) {
					val int i = m('')
					return String.valueOf(i)
				}
				def static int m(String s) { return 1 }
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public String m(final CharSequence c) {
			    final int i = C.m("");
			    return String.valueOf(i);
			  }
			  
			  public static int m(final String s) {
			    return 1;
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def String m(String c) {
					return m('')
				}
				def static void m(CharSequence s) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public String m(final String c) {
			    return this.m("");
			  }
			  
			  public static void m(final CharSequence s) {
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			import static C.D.d
			class C {
				def int m(D it) {
					d('')
				}
				static class D {
					def String d(CharSequence c) {}
					def static int d(String s) { 0 }
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public static class D {
			    public String d(final CharSequence c) {
			      return null;
			    }
			    
			    public static int d(final String s) {
			      return 0;
			    }
			  }
			  
			  public int m(final C.D it) {
			    return C.D.d("");
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				def void n(String s) {
					s+s
				}
				def static void +(String s1, String s2) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void n(final String s) {
			    C.operator_plus(s, s);
			  }
			  
			  public static void operator_plus(final String s1, final String s2) {
			  }
			}
		''')
	}
	
}