/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug437678Test extends AbstractXtendContentAssistBugTest {
	
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