/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package lazy

import org.eclipse.xtend.core.compiler.batch.XtendCompilerTester
import org.junit.Test

class LazyTest {
	extension XtendCompilerTester compilerTester = XtendCompilerTester.newXtendCompilerTester(class.classLoader)

	@Test def void testLazy() {
		'''
			import lazy.Lazy
			
			class Person {
			  @Lazy String name = 'foo'
			}
		'''.assertCompilesTo(
		'''
			import lazy.Lazy;

			@SuppressWarnings("all")
			public class Person {
			  @Lazy
			  private String name;
			
			  private String _initname() {
			    return "foo";
			  }
			
			  public String getName() {
			    if (name==null)
			      name = _initname();
			    return name;
			  }
			}
		''')
	}
}