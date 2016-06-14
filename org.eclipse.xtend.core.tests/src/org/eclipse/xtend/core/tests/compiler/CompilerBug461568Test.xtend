/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug461568Test extends AbstractXtendCompilerTest {
	
	@Test def test_01() {
		'''
			class C {
			    def m((String)=>void foo) {}
				def m(Object foo) {}
				def m2() {
				  m[s|s.bytes]
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public Object m(final Procedure1<? super String> foo) {
			    return null;
			  }
			  
			  public Object m(final Object foo) {
			    return null;
			  }
			  
			  public Object m2() {
			    final Procedure1<String> _function = new Procedure1<String>() {
			      public void apply(final String s) {
			        s.getBytes();
			      }
			    };
			    return this.m(_function);
			  }
			}
		''')
	}
	
	@Test def test_02() {
		'''
			class C {
			    def m((String)=>Object foo) {}
				def m(Object foo) {}
				def m2() {
				  m[s|s.bytes]
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Functions.Function1;
			
			@SuppressWarnings("all")
			public class C {
			  public Object m(final Function1<? super String, ?> foo) {
			    return null;
			  }
			  
			  public Object m(final Object foo) {
			    return null;
			  }
			  
			  public Object m2() {
			    final Function1<String, Object> _function = new Function1<String, Object>() {
			      public Object apply(final String s) {
			        return s.getBytes();
			      }
			    };
			    return this.m(_function);
			  }
			}
		''')
	}
	
	@Test def test_03() {
		'''
			class C {
			    def m((String)=>void foo) {}
				def m(Object foo) {}
				def m2() {
				  m[ bytes ]
				}
			}
		'''.assertCompilesTo('''
			import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
			
			@SuppressWarnings("all")
			public class C {
			  public Object m(final Procedure1<? super String> foo) {
			    return null;
			  }
			  
			  public Object m(final Object foo) {
			    return null;
			  }
			  
			  public Object m2() {
			    final Procedure1<String> _function = new Procedure1<String>() {
			      public void apply(final String it) {
			        it.getBytes();
			      }
			    };
			    return this.m(_function);
			  }
			}
		''')
	}
	
}