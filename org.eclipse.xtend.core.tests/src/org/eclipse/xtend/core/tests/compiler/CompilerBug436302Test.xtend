/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
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
class CompilerBug436302Test extends AbstractXtendCompilerTest {
	
	@Test
	def test_01() {
		assertCompilesTo('''
			class A {
				def static void main(String[] args) {
					val a = new A()
					a.methodA()
				}
				def methodA() {
					new B().methodB(this)
				}
			}
			class B {
				def methodB(A a) {
					return a;
				}
			}
		''', '''
			@SuppressWarnings("all")
			public class A {
			  public static void main(final String[] args) {
			    final A a = new A();
			    a.methodA();
			  }
			
			  public A methodA() {
			    return new B().methodB(this);
			  }
			}
		''')
	}
	
}