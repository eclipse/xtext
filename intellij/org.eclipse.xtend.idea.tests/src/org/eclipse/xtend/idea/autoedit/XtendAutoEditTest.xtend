/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autoedit

import com.intellij.openapi.util.TextRange
import org.eclipse.xtend.idea.LightXtendTest
import org.eclipse.xtext.junit4.internal.LineDelimiters

class XtendAutoEditTest extends LightXtendTest {
	private static val CARET = "<caret>"
	
	def void testClassBraces() {
		configureByText('''class Foo {«CARET»''')
		newLine
		assertEditor('''
		class Foo {
			«CARET»
		}''')
	}
	
	def void testMethodParentheses() {
		configureByText('''
			class Foo {
				def bar«CARET»
			}
		''')
		myFixture.type("(")
		assertEditor('''
			class Foo {
				def bar(«CARET»)
			}
		''')
	}
	
	def void testMethodBraces() {
		configureByText('''
			class Foo {
				def bar() {«CARET»
			}
		''')
		newLine
		assertEditor('''
			class Foo {
				def bar() {
					«CARET»
				}
			}
		''')
	}
	
	def void testFeatureCallParentheses() {
		configureByText('''
			class Foo {
				def bar() {
					toString«CARET»
				}
			}
		''')
		myFixture.type("(")
		assertEditor('''
			class Foo {
				def bar() {
					toString(«CARET»)
				}
			}
		''')
	}
	
	def void testArrayBrackets() {
		configureByText('''
			class Foo {
				def bar(int«CARET»)
			}
		''')
		myFixture.type("[")
		assertEditor('''
			class Foo {
				def bar(int[«CARET»])
			}
		''')
	}
	
	def void testGuillemets() {
		//Does not work, TypedHandler:214 looks suspicious
//		configureByText("
//			class Foo {
//				def bar() {
//					'''<caret>'''
//				}
//			}
//		")
//		type("«")
//		assertEditor("
//			class Foo {
//				def bar() {
//					'''«<caret>»'''
//				}
//			}
//		")
	}
	
	private def newLine() {
		myFixture.type('\n')
	}

	private def assertEditor(String editorState) {
		val expectedState = LineDelimiters.toUnix(editorState.replace(CARET, "|"))

		val actualState = {
			val caretOffset = myFixture.editor.caretModel.primaryCaret.offset
			val document = myFixture.editor.document
			val beforeCaret = myFixture.editor.document.getText(new TextRange(0, caretOffset))
			val afterCaret = myFixture.editor.document.getText(new TextRange(caretOffset, document.textLength))
			beforeCaret + '|' + afterCaret
		}

		assertEquals(expectedState, actualState)
	}
}