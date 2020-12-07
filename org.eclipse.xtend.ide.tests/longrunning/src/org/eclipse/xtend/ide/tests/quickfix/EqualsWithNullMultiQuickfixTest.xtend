/*******************************************************************************
 * Copyright (c) 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.quickfix

import org.eclipse.xtend.ide.tests.XtendIDEInjectorProvider
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.editor.quickfix.QuickAssistCompletionProposal
import org.eclipse.xtext.ui.testing.AbstractMultiQuickfixTest
import org.junit.Test
import org.junit.runner.RunWith

import static extension org.eclipse.xtend.ide.tests.WorkbenchTestHelper.createPluginProject

/** 
 * @author Aaron R Miller - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtendIDEInjectorProvider)
class EqualsWithNullMultiQuickfixTest extends AbstractMultiQuickfixTest {

	@Test def equals_with_null_in_expression() {
		'''
			package equalsnull
			class Foo {
				def m(Object a, Object b, Object c) {
					if(a == null || b != null || c === null) 0 else 1
				}
			}
		'''.testMultiQuickfix('''
			package equalsnull
			class Foo {
				def m(Object a, Object b, Object c) {
					if(a <0<==>0> null || b <1<!=>1> null || c === null) 0 else 1
				}
			}
			-----
			0: message=The operator '==' should be replaced by '===' when null is one of the arguments.
			1: message=The operator '!=' should be replaced by '!==' when null is one of the arguments.
		''','''
			package equalsnull
			class Foo {
				def m(Object a, Object b, Object c) {
					if(a === null || b !== null || c === null) 0 else 1
				}
			}
			-----
			(no markers found)
		''')
	}

	@Test def equals_with_null_in_switch() {
		val model = '''
			package equalsnull
			class Foo {
				def m(Object a, Object b, Object c) {
					switch true {
						case a == null: 0
						case b != null: 0
						case c === null: 0
						default: 1
					}
				}
			}
		'''

		val xtextEditor = model.dslFile.openEditor

		val offset = model.indexOf("==") + 1
		val proposals = xtextEditor.computeQuickAssistProposals(offset)

		assertEquals(1, proposals.size)
		assertEquals(1, proposals.filter(QuickAssistCompletionProposal).size)
		assertEquals("Replace '==' with '===' and '!=' with '!=='", proposals.head.displayString)
	}

	override setUp() {
		super.setUp
		projectName.createPluginProject
	}

	override getFileName() {
		"Foo"
	}

	override dslFile(CharSequence content) {
		super.dslFile(projectName, "src/equalsnull/" + fileName, fileExtension, content)
	}
}