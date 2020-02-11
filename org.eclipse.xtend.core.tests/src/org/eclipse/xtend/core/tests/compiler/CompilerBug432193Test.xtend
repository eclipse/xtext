/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug432193Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_432193_01() {
		assertCompilesTo('''
			class C {
				D d = [ CharSequence o | 
					o.subSequence(1, 2)
				]
			}
			interface D {
				def void m(String o) 
			}
		''', '''
			@SuppressWarnings("all")
			public class C {
			  private D d = new D() {
			    public void m(final String o) {
			      o.subSequence(1, 2);
			    }
			  };
			}
		''')
	}
		
}