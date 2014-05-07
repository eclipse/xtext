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
class NestedClassCompilerTest extends AbstractXtendCompilerTest {
	
	@Test
	def void testPlain() {'''
			class C {
				static class X {}
				X x
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  @SuppressWarnings("all")
			  public static class X {
			  }
			  
			  private C.X x;
			}
		''')
	}
	
	@Test
	def void testOuterMemberAccess() {'''
			class C {
				static class X {
					new(C c) {
						c.m
					}
				}
				private def void m() {}
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  @SuppressWarnings("all")
			  public static class X {
			    public X(final C c) {
			      c.m();
			    }
			  }
			  
			  private void m() {
			  }
			}
		''')
	}
}
