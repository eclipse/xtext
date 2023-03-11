/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test
import org.eclipse.xtext.testing.Flaky

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug437678Test extends AbstractXtendContentAssistBugTest {
	
	@Flaky
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			class A {
				def methodA() {}
			}
			class B {
				def methodB() {}
				def void myInstance(Object o) {}
			}
			class C {
				static extension B b
				static String string
				def static void main(A it) {
					method|
				}
			}
		''')
			.assertTextAtCursorPosition('ethod|', 'methodA', 'methodB', 'main', 'myInstance')
	}
	
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			class A {
				def methodA() {}
			}
			class B {
				def methodB() {}
				def void myInstance(Object o) {}
			}
			class C {
				extension B b
				static String string
				def static void main(A it) {
					method|
				}
			}
		''')
			.assertTextAtCursorPosition('ethod|', 'methodA', 'main')
	}
	
	@Flaky
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			class A {
				def methodA() {}
			}
			class B {
				def methodB() {}
				def void myInstance(Object o) {}
			}
			class C {
				static extension B b
				static String string
				def static void main(A a) {
					method|
				}
			}
		''')
			.assertTextAtCursorPosition('ethod|', 'methodB', 'main()', 'myInstance()')
	}
	
	@Test def void test_04() throws Exception {
		newBuilder.append('''
			class A {
				def methodA() {}
			}
			class B {
				def methodB() {}
				def void myInstance(Object o) {}
			}
			class C {
				extension B b
				static String string
				def static void main(A a) {
					method|
				}
			}
		''')
			.assertTextAtCursorPosition('ethod|', 'main()')
	}
	
	@Flaky
	@Test def void test_05() throws Exception {
		newBuilder.append('''
			class A {
				def methodA() {}
			}
			class B {
				def methodB() {}
				def void myInstance(Object o) {}
			}
			class C {
				static extension B b
				static String string
				def static void main(A a) {
					a.method|
				}
			}
		''')
			.assertTextAtCursorPosition('ethod|', 'methodA', 'main', 'myInstance')
	}
	
	@Test def void test_06() throws Exception {
		newBuilder.append('''
			class A {
				def methodA() {}
			}
			class B {
				def methodB() {}
				def void myInstance(Object o) {}
			}
			class C {
				extension B b
				static String string
				def static void main(A a) {
					a.method|
				}
			}
		''')
			.assertTextAtCursorPosition('ethod|', 'main', 'methodA')
	}
}