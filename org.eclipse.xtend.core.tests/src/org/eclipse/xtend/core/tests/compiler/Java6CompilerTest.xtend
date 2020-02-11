/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.eclipse.xtend.core.tests.Java6RuntimeInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.junit.Test

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@InjectWith(Java6RuntimeInjectorProvider)
class Java6CompilerTest extends AbstractXtendCompilerTest {
	
	@Test def void testOverrideAbstractClass() {
		'''
		class B extends A {
			override a() {
			}
		}
		abstract class A {
			abstract def void a()
		}
		'''
		.assertCompilesTo('''
		@SuppressWarnings("all")
		public class B extends A {
		  @Override
		  public void a() {
		  }
		}
		''')
	}
	
	@Test def void testOverrideClass() {
		'''
		class B extends A {
			override a() {
			}
		}
		class A {
			def void a() {
			}
		}
		'''
		.assertCompilesTo('''
		@SuppressWarnings("all")
		public class B extends A {
		  @Override
		  public void a() {
		  }
		}
		''')
	}
	
	@Test def void testOverrideInterface() {
		'''
		class B implements A {
			override a() {
			}
		}
		interface A {
			def void a()
		}
		'''
		.assertCompilesTo('''
		@SuppressWarnings("all")
		public class B implements A {
		  @Override
		  public void a() {
		  }
		}
		''')
	}
	
}