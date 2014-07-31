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
class CompilerBug440902Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class C implements I {
				def String m2(Object o) {
					m.toString() // unresolveable
				}
				override m() {
					throw new RuntimeException()
				}
			}
			interface I {
				def String m()
			}
		''', '''
			@SuppressWarnings("all")
			public class C implements I {
			  public String m2(final Object o) {
			    String _m = this.m();
			    return _m.toString();
			  }
			  
			  public String m() {
			    throw new RuntimeException();
			  }
			}
		''')
	}
	
	@Test
	def test_02() {
		assertCompilesTo('''
			class C implements I {
				override m() {
					throw new RuntimeException()
				}
			}
			interface I {
				def String m()
			}
		''', '''
			@SuppressWarnings("all")
			public class C implements I {
			  public String m() {
			    throw new RuntimeException();
			  }
			}
		''')
	}
}