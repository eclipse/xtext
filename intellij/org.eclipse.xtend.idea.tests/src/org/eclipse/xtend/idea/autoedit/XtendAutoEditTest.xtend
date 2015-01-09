/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.autoedit

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
		type("(")
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
		type("(")
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
		type("[")
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
		type('\n')
	}

	private def assertEditor(String editorState) {
		val normalized = LineDelimiters.toUnix(editorState)
		val caretPosition = normalized.indexOf(CARET)
		var text = normalized
		if (caretPosition != -1) {
			text = normalized.replace(CARET, "")
			assertEquals(caretPosition, editor.caretModel.primaryCaret.offset)
		}
		assertEquals(text, editor.document.text)
	}
}