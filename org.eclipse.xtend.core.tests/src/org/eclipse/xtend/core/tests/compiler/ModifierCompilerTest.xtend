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
 * @author Sven Efftinge - Initial contribution and API
 */
class ModifierCompilerTest extends AbstractXtendCompilerTest {
	
	@Test def void testStrictfp_onClass() {
		'''
		strictfp class X {
		}
		'''
		.assertCompilesTo('''
		@SuppressWarnings("all")
		public strictfp class X {
		}
		''')
	}
	
	@Test def void testStrictfp_onInterface() {
		'''
		strictfp interface X {
		}
		'''
		.assertCompilesTo('''
		@SuppressWarnings("all")
		public strictfp interface X {
		}
		''')
	}
	
	@Test def void testStrictfp_onMethod() {
		'''
		class X {
			strictfp def void foo() {}
		}
		'''
		.assertCompilesTo('''
		@SuppressWarnings("all")
		public class X {
		  public strictfp void foo() {
		  }
		}
		''')
	}
	
	@Test def void testSynchronizedStrictfp_onMethod() {
		'''
		class X {
			synchronized strictfp def void foo() {}
		}
		'''
		.assertCompilesTo('''
		@SuppressWarnings("all")
		public class X {
		  public synchronized strictfp void foo() {
		  }
		}
		''')
	}
	
	@Test def void testNativeMethod() {
		'''
		class X {
			native def void foo()
		}
		'''
		.assertCompilesTo('''
		@SuppressWarnings("all")
		public class X {
		  public native void foo();
		}
		''')
	}
	
	@Test def void testTransientVolatileField() {
		'''
		class X {
			transient volatile String foo
		}
		'''
		.assertCompilesTo('''
		@SuppressWarnings("all")
		public class X {
		  private transient volatile String foo;
		}
		''')
	}
}