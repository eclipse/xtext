/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.editor

import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractEditorDoubleClickTextSelectionTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class XtendEditorDoubleClickTextSelectionTest extends AbstractEditorDoubleClickTextSelectionTest {

	@Test def selection_in_javadoc_001() {
		'''
			class Foo {
				
				/**
				 * @par|am s
				 * @return
				 */
				def m(String s) {}
			}
		'''.assertSelectedTextAfterDoubleClicking('''@param''')
	}

	@Test def selection_in_javadoc_002() {
		'''
			class Foo {
				
				/**
				 * @param s
				 * @ret|urn
				 */
				def m(String s) {}
			}
		'''.assertSelectedTextAfterDoubleClicking('''@return''')
	}

	@Test def selection_in_rich_string_001() {
		val tripleQuotes = "'''"
		
		'''
			class Foo {
				
				val a = «tripleQuotes»te|xt«tripleQuotes»
				
			}
		'''.assertSelectedTextAfterDoubleClicking('''text''')
	}
}