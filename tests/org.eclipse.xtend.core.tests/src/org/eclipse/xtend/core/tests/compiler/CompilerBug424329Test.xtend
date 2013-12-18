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
class CompilerBug424329Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_424329_01() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(String s){
				}
				def static void main(String[] args) {
					A.mainDir = "D:" 
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final String s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir("D:");
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_02() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(String s){
				}
				def static void main(String[] args) {
					mainDir = "D:" 
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final String s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir("D:");
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_03() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String s){}
				def static void main(String[] args) {
					A.mainDir = "D:" 
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir(A.class, "D:");
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_04() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String s){}
				def static void main(String[] args) {
					B.mainDir = "D:"
				}
			}
			class B extends A {}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir(B.class, "D:");
			  }
			}
		''')
	}
		
	@Test def void testBug_424329_05() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String... s){}
				def static void main(String[] args) {
					B.mainDir = #["D:"] 
				}
			}
			class B extends A {}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String... s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir(B.class, new String[] { "D:" });
			  }
			}
		''')
	}

	@Test def void testBug_424329_06() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(String s){
				}
				def static void main(String[] args) {
					A.setMainDir("D:")
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final String s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir("D:");
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_07() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(String s){
				}
				def static void main(String[] args) {
					setMainDir("D:")
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final String s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir("D:");
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_08() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String s){}
				def static void main(String[] args) {
					A.setMainDir("D:")
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir(A.class, "D:");
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_09() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String s){}
				def static void main(String[] args) {
					B.setMainDir("D:")
				}
			}
			class B extends A {}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir(B.class, "D:");
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_10() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String... s){}
				def static void main(String[] args) {
					B.setMainDir(#["D:"])
				}
			}
			class B extends A {}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String... s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir(B.class, new String[] { "D:" });
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_11() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String... s){}
				def static void main(String[] args) {
					B.setMainDir("D:")
				}
			}
			class B extends A {}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String... s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir(B.class, "D:");
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_12() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String... s){}
				def static void main(String[] args) {
					B.setMainDir("D:", "E:")
				}
			}
			class B extends A {}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String... s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir(B.class, "D:", "E:");
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_13() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String... s){}
				def static void main(String[] args) {
					B.setMainDir(null)
				}
			}
			class B extends A {}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String... s) {
			  }
			  
			  public static void main(final String[] args) {
			    B.setMainDir(null);
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_14() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String... s){}
				def static void main(String[] args) {
					B.setMainDir()
				}
			}
			class B extends A {}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String... s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir(B.class);
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_15() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String... s){}
				def static void main(String[] args) {
					B.setMainDir
				}
			}
			class B extends A {}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String... s) {
			  }
			  
			  public static void main(final String[] args) {
			    A.setMainDir(B.class);
			  }
			}
		''')
	}
	
	@Test def void testBug_424329_16() {
		assertCompilesTo('''
			class A {
				public def static void setMainDir(Class<? extends A> c, String... s){}
				def static void main(String[] args) {
					B.setMainDir(null, null)
				}
			}
			class B extends A {}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void setMainDir(final Class<? extends A> c, final String... s) {
			  }
			  
			  public static void main(final String[] args) {
			    B.setMainDir(null, null);
			  }
			}
		''')
	}
}

