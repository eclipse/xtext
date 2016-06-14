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
	
	@Test
	def test_05() {
		assertCompilesTo('''
			class C {
				static String string
				def String getString() {
					string
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  private static String string;
			  
			  public String getString() {
			    return C.string;
			  }
			}
		''')
	}
	
	@Test
	def test_06() {
		assertCompilesTo('''
			class C {
				def static m(String s) {
					Class.forName(s)
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Exceptions;
			
			@SuppressWarnings("all")
			public class C {
			  public static Class<?> m(final String s) {
			    try {
			      return Class.forName(s);
			    } catch (Throwable _e) {
			      throw Exceptions.sneakyThrow(_e);
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_07() {
		assertCompilesTo('''
			import static extension Ext.*
			class Client {
			  def m(C c) {
			    c.m('')
			  }
			}
			class C {
			  static def m(String s) {}
			}
			class Ext {
			  static def m(C c, String s) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class Client {
			  public Object m(final C c) {
			    return Ext.m(c, "");
			  }
			}
		''')
	}
	
	@Test
	def test_08() {
		assertCompilesTo('''
			import static extension Ext.*
			class Client {
			  def static m(C c) {
			    c.m('')
			  }
			}
			class C {
			  static def m(String s) {}
			}
			class Ext {
			  static def m(C c, String s) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class Client {
			  public static Object m(final C c) {
			    return Ext.m(c, "");
			  }
			}
		''')
	}
	
	@Test
	def test_09() {
		assertCompilesTo('''
			class Client {
			  extension Ext
			  def m(C c) {
			    c.m('')
			  }
			}
			class C {
			  static def m(String s) {}
			}
			class Ext {
			  def m(C c, String s) {}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Extension;
			
			@SuppressWarnings("all")
			public class Client {
			  @Extension
			  private Ext _ext;
			  
			  public Object m(final C c) {
			    return this._ext.m(c, "");
			  }
			}
		''')
	}
	
	@Test
	def test_10() {
		assertCompilesTo('''
			class C {
				(Number)=>Number field
				def void setField((Number)=>Number field) {
					this.field = field
				}
				def void setField(String field) {
					this.field = [ it ]
				}
			}
		''', '''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  private Function1<? super Number, ? extends Number> field;
			  
			  public void setField(final Function1<? super Number, ? extends Number> field) {
			    this.field = field;
			  }
			  
			  public void setField(final String field) {
			    final Function1<Number, Number> _function = new Function1<Number, Number>() {
			      public Number apply(final Number it) {
			        return it;
			      }
			    };
			    this.field = _function;
			  }
			}
		''')
	}
	
	@Test
	def test_11() {
		assertCompilesTo('''
			class C {
				CharSequence field
				def void setField(String field) {
					this.field = field
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  private CharSequence field;
			  
			  public void setField(final String field) {
			    this.field = field;
			  }
			}
		''')
	}
	
	@Test
	def test_12() {
		assertCompilesTo('''
			class C {
				def void setField(String f) {
					var CharSequence field
					field = f
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void setField(final String f) {
			    CharSequence field = null;
			    field = f;
			  }
			}
		''')
	}
	
}