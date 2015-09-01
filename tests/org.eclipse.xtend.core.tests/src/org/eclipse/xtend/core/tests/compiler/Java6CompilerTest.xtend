/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.eclipse.xtend.core.tests.Java6RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
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