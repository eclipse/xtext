/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.highlighting

import org.eclipse.xtend.idea.LightXtendTest

import static org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles.*

class XtendHighlightingTest extends LightXtendTest {
	
	static val Q3 = "'''"
	static val GL = '«'
	static val GR = '»'
	
	def testKeyWord() {
		configureByText('public')
		assertHighlights(
			'''
				0-6:«KEYWORD_ID»
			'''
		)
	}
	
	def testStringLiteral() {
		configureByText('"Foo"')
		assertHighlights('''
			0-5:«STRING_ID»
		''')
	}
	
	def testNumberLiteral() {
		configureByText('5')
		assertHighlights('''
			0-1:«NUMBER_ID»
		''')
		
	}
	
	def testSlComment() {
		configureByText("//comment")
		assertHighlights('''
			0-9:«COMMENT_ID»
		''')
	}
	
	def testMlComment() {
		configureByText('''
			/* 
			 * comment
			 */''')
		assertHighlights('''
			0-18:«COMMENT_ID»
		''')
	}

	def testRichString_0() {
		configureByText('''
			class Foo {
				def foo() «Q3»
					this is a template
				«Q3»
			}
		''')
		assertHighlights('''
			0-5:keyword
			10-11:punctuation
			13-16:keyword
			20-21:punctuation
			21-22:punctuation
			23-52:xtend.richText
			53-54:punctuation
		''')
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichString_1() {
		configureByText('''
			class Foo {
				def foo() «Q3»
					this is a «GL»'foo'«GR» template
				«Q3»
			}
		''')
		assertHighlights('''
			0-5:keyword
			10-11:punctuation
			13-16:keyword
			20-21:punctuation
			21-22:punctuation
			23-39:xtend.richText
			39-40:xtend.richText.delimiter
			40-45:string
			45-46:xtend.richText.delimiter
			46-60:xtend.richText
			61-62:punctuation
		''')
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichString_2() {
		configureByText('''
			class Foo {
				def foo() «Q3»
					this is a «GL»'foo'«GR» template
					this is a «GL»'bar'«GR» template
				«Q3»
			}
		''')
		assertHighlights('''
			0-5:keyword
			10-11:punctuation
			13-16:keyword
			20-21:punctuation
			21-22:punctuation
			23-39:xtend.richText
			39-40:xtend.richText.delimiter
			40-45:string
			45-46:xtend.richText.delimiter
			46-68:xtend.richText
			68-69:xtend.richText.delimiter
			69-74:string
			74-75:xtend.richText.delimiter
			75-89:xtend.richText
			90-91:punctuation
		''')
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichString_3() {
		configureByText('''
			class Foo {
				def foo() «Q3»
					this is a template«GL»«GL»«GL» comment
				«Q3»
			}
		''')
		assertHighlights('''
			0-5:keyword
			10-11:punctuation
			13-16:keyword
			20-21:punctuation
			21-22:punctuation
			23-47:xtend.richText
			47-50:xtend.richText.delimiter
			64-65:punctuation
		''')
	}
}