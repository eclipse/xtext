/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.contentassist

import org.eclipse.xtext.testing.Flaky
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class Bug370955Test extends AbstractXtendContentAssistBugTest {
	
	@Flaky
	@Test def void test_01() throws Exception {
		newBuilder.append('''
			class C {
				def void method(CharSequence c) {
					c.toString
				}	
			}
		''').assertTextAtCursorPosition("toString", "toString".length,
			'!=', '!==', '+', '->', '<', '<=', '<=>', '==', '===', '=>', '>', '>=', '?:',
			'toString'
		)
	}
	
	@Flaky
	@Test def void test_02() throws Exception {
		newBuilder.append('''
			class C {
				def void method(CharSequence c) {
					method(c.toString)
				}	
			}
		''').assertTextAtCursorPosition("toString", "toString".length,
			'!=', '!==', '+', '->', '<', '<=', '<=>', '==', '===', '=>', '>', '>=', '?:',
			'toString'
		)
	}
	
	@Flaky
	@Test def void test_03() throws Exception {
		newBuilder.append('''
			class C {
				def void method(CharSequence c) {
					if (true)
						method(c.toString)
				}	
			}
		''').assertTextAtCursorPosition("toString", "toString".length,
			'!=', '!==', '+', '->', '<', '<=', '<=>', '==', '===', '=>', '>', '>=', '?:',
			'toString'
		)
	}

	@Flaky
	@Test def void test_04() throws Exception {
		newBuilder.append('''
			class C {
				def void method(CharSequence c) {
					if (true) {
						method(c.toString)
					}
				}	
			}
		''').assertTextAtCursorPosition("toString", "toString".length,
			'!=', '!==', '+', '->', '<', '<=', '<=>', '==', '===', '=>', '>', '>=', '?:',
			'toString'
		)
	}	
}