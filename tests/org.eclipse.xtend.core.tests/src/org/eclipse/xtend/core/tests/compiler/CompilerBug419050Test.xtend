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
class CompilerBug419050Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C {
				def boolean m(boolean b) { 
				   if (b) { 
				     return true 
				   }
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final boolean b) {
			    if (b) {
			      return true;
			    }
			    return false;
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C {
				def boolean m1(boolean x) {
				  while(x) {
				    return true
				  }
				}
				def m2(boolean x) {
				  while(x) {
				    return true
				  }
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean m1(final boolean x) {
			    boolean _while = x;
			    while (_while) {
			      return true;
			      
			    }
			    return false;
			  }
			  
			  public Boolean m2(final boolean x) {
			    boolean _while = x;
			    while (_while) {
			      return true;
			      
			    }
			    return null;
			  }
			}
		''')
	}
	
	@Test
	def test_03() {
		assertCompilesTo('''
			class C {
				def boolean m(Object o) { 
					switch o { 
				   		String: return true 
					}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final Object o) {
			    boolean _matched = false;
			    if (!_matched) {
			      if (o instanceof String) {
			        _matched=true;
			        return true;
			      }
			    }
			    return false;
			  }
			}
		''')
	}
	
	@Test
	def test_04() {
		assertCompilesTo('''
			class C {
				def boolean m(Object o) { 
					try {
						return true;
					} finally {
					}
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public boolean m(final Object o) {
			    try {
			      return true;
			    } finally {
			    }
			  }
			}
		''')
	}
	
	@Test
	def test_05() {
		assertCompilesTo('''
			class C {
				def m(boolean b) { 
				   if (b) { 
				     while(false) {}
				   }
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  public void m(final boolean b) {
			    if (b) {
			      boolean _while = false;
			      while (_while) {
			        _while = false;
			      }
			    }
			  }
			}
		''')
	}
	
}