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
class Bug370955Test extends AbstractXtendContentAssistBugTest {
	
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