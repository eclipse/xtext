/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class CompilerBug423631Test extends AbstractXtendCompilerTest {
	
	@Test
	def testBug423631_01() {
		assertCompilesTo('''
			class C {
				def dispatch m(A a) {
				}
				def dispatch m(B b) {
				}
			}
			class A {
			}
			class B extends A {
			}
		''', '''
			import java.util.Arrays;
			
			@SuppressWarnings("all")
			public class C {
			  protected Object _m(final A a) {
			    return null;
			  }
			
			  protected Object _m(final B b) {
			    return null;
			  }
			
			  public Object m(final A a) {
			    if (a instanceof B) {
			      return _m((B)a);
			    } else if (a != null) {
			      return _m(a);
			    } else {
			      throw new IllegalArgumentException("Unhandled parameter types: " +
			        Arrays.<Object>asList(a).toString());
			    }
			  }
			}
		''')
	}
	
}

