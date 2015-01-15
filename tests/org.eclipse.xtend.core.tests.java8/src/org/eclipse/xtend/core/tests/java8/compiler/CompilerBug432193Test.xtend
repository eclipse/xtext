/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.compiler

import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Miro Spoenemann - Copied and adapted to Java 8 output
 */
@InjectWith(Java8RuntimeInjectorProvider)
class CompilerBug432193Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_432193_01() {
		'''
			class C {
				D d = [ CharSequence o | 
					o.subSequence(1, 2)
				]
			}
			interface D {
				def void m(String o) 
			}
		'''.assertCompilesTo('''
			@SuppressWarnings("all")
			public class C {
			  private D d = ((D) (String o) -> {
			    o.subSequence(1, 2);
			  });
			}
		''')
	}
		
}