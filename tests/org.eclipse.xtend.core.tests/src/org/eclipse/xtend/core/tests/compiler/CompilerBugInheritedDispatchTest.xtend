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
class CompilerBugInheritedDispatchTest extends AbstractXtendCompilerTest {
	
	@Test def void test_01() {
		assertCompilesTo('''
			class D extends C {
				def dispatch void m(Integer o) {}
				def dispatch void m(CharSequence o) {}
			}
			class C extends B {
				def dispatch void m(Number o) {}
			}
			class B extends A {
				def dispatch void m(String o) {}
			}
			class A {
				def dispatch void m(Object o) {}
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class D extends C {
			  protected void _m(final Integer o) {
			  }
			  
			  protected void _m(final CharSequence o) {
			  }
			  
			  public void m(final Object o) {
			    if (o instanceof Integer) {
			      _m((Integer)o);
			      return;
			    } else if (o instanceof Number) {
			      _m((Number)o);
			      return;
			    } else if (o instanceof String) {
			      _m((String)o);
			      return;
			    } else if (o instanceof CharSequence) {
			      _m((CharSequence)o);
			      return;
			    } else if (o != null) {
			      _m(o);
			      return;
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(o).toString());
			    }
			  }
			}
		''')
	}
		
}