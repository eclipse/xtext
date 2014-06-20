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
class CompilerBug437678Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				static String s
				def static String m() {
					s + m
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  private static String s;
			  
			  public static String m() {
			    String _m = C.m();
			    return (C.s + _m);
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				static extension A
				def static void m() {
					methodA
				}
				static class A {
					def methodA() {
					}
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class C {
			  public static class A {
			    public Object methodA() {
			      return null;
			    }
			  }
			  
			  @Extension
			  private static C.A _a;
			  
			  public static void m() {
			    C._a.methodA();
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				static extension A
				def void m() {
					methodA
				}
				static class A {
					def methodA() {
					}
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class C {
			  public static class A {
			    public Object methodA() {
			      return null;
			    }
			  }
			  
			  @Extension
			  private static C.A _a;
			  
			  public void m() {
			    C._a.methodA();
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				static extension A
				def static void m(B b) {
					b.methodA
				}
				static class A {
					def methodA(B b) {
					}
				}
				static class B {}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class C {
			  public static class A {
			    public Object methodA(final C.B b) {
			      return null;
			    }
			  }
			  
			  public static class B {
			  }
			  
			  @Extension
			  private static C.A _a;
			  
			  public static void m(final C.B b) {
			    C._a.methodA(b);
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			class C {
				static extension A
				def static void m(B it) {
					methodA
				}
				static class A {
					def methodA(B b) {
					}
				}
				static class B {}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class C {
			  public static class A {
			    public Object methodA(final C.B b) {
			      return null;
			    }
			  }
			  
			  public static class B {
			  }
			  
			  @Extension
			  private static C.A _a;
			  
			  public static void m(final C.B it) {
			    C._a.methodA(it);
			  }
			}
		''')
	}
	
}