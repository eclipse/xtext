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
class CompilerBug423907Test extends AbstractXtendCompilerTest {
	
	@Test def void testBug_423907_01() {
		assertCompilesTo('''
			class Foo extends Base {
				def static void main(String[] args) {
					launch(Foo, args)
				}
			}
			class Base {
				def static void launch(Class<? extends Base> c, String... args) {}
				def static void launch(String... args) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class Foo extends Base {
			  public static void main(final String[] args) {
			    Base.launch(Foo.class, args);
			  }
			}
		''')
	}
	
	@Test def void testBug_423907_02() {
		assertCompilesTo('''
			class Foo extends Base {
				def static void main(String[] args) {
					Base.launch(Foo, args)
				}
			}
			class Base {
				def static void launch(Class<? extends Base> c, String... args) {}
				def static void launch(String... args) {}
			}
		''', '''
			@SuppressWarnings("all")
			public class Foo extends Base {
			  public static void main(final String[] args) {
			    Base.launch(Foo.class, args);
			  }
			}
		''')
	}
}

