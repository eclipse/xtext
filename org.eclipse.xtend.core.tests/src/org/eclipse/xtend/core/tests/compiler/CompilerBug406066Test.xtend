/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import org.junit.Test

/**
 * @author Karsten Thoms - Initial contribution and API
 */
class CompilerBug406066Test extends AbstractXtendCompilerTest {
	
	@Test
	def testBug406066_01() {
		assertCompilesTo('''
			class Error {
				def static err(Integer i) {
					i.toString
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Error {
			  public static String err(final Integer i) {
			    return i.toString();
			  }
			}
		''')
	}

	@Test
	def testBug406066_02() {
		assertCompilesTo('''
			class Error {
				def static err(Integer i) {
					i.toString
					val java.lang.Error e = new AssertionError()
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Error {
			  public static void err(final Integer i) {
			    i.toString();
			    final java.lang.Error e = new AssertionError();
			  }
			}
		''')
	}

	@Test
	def testBug406066_03() {
		assertCompilesTo('''
			class Error2 {
				def static err(Integer i) {
					i.toString
					val Error e = new AssertionError()
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class Error2 {
			  public static void err(final Integer i) {
			    i.toString();
			    final Error e = new AssertionError();
			  }
			}
		''')
	}
}