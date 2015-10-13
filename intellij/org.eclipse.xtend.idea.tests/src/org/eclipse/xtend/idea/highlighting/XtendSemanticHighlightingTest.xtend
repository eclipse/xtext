/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.idea.highlighting

import org.eclipse.xtend.idea.LightXtendTest

import static org.eclipse.xtend.ide.common.highlighting.XtendHighlightingStyles.*
import static org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles.*
import static org.eclipse.xtext.xbase.ide.highlighting.XbaseHighlightingStyles.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class XtendSemanticHighlightingTest extends LightXtendTest {
 
 	static val Q3 = "'''"
	static val GL = '«'
	static val GR = '»'
	static val NL = '§' // yes, I know, it doesn't look like a 'new line', but it will become one when once it's grown up ;-)
 
	protected def void checkHighlight(CharSequence text) {
		myFixture.addFileToProject('Foo.xtend', text.toString.replace(NL, '\n'))
		myFixture.testFile('Foo.xtend') => [
			checkSymbolNames	
			test
		]
	}
	
	protected def $(String xtextStyle, String text) {
		'<symbolName descr="'+xtextStyle+'">'+text+'</symbolName>'
	}

 	protected def white(String whitespace) {
		INSIGNIFICANT_TEMPLATE_TEXT.$(whitespace)
	}
 
	def testPrimitiveTypeIsKeyword() {
		'''
			class Foo {
				def «KEYWORD_ID.$('void')» foo() {}
			}
		'''.checkHighlight
	}

	def testThisIsKeyword() {
		'''
			class Foo {
				def foo() {
					«KEYWORD_ID.$('this')»
				}
			}
		'''.checkHighlight
	}
	
	def testItIsKeyword() {
		'''
			class Foo {
				def foo(String «KEYWORD_ID.$('it')») {
				}
			}
		'''.checkHighlight
	}
	
	def void testStaticField() {
		'''
			class Foo {
				static val «STATIC_FIELD.$('foo')» = true
				def bar() { «STATIC_FIELD.$('foo')» }
			}
		'''.checkHighlight
	}
	
	def void testStaticMethod() {
		'''
			class Foo {
				static def foo() {}
				def bar() { «STATIC_METHOD_INVOCATION.$('foo')» }
			}
		'''.checkHighlight
	}

	def void testField() {
		'''
			class Foo {
				val «FIELD.$('foo')» = null
			}
		'''.checkHighlight
	}
	
	def void testAnnotation() {
		'''
			«ANNOTATION.$('@')»«ANNOTATION.$('SuppressWarnings')»("all")
			class Foo {
			}
		'''.checkHighlight
	}
	
	def void testExtensionMethod() {
		'''
			class Foo {
				def foo(String x) {
				}
				
				def bar() {
					''.«EXTENSION_METHOD_INVOCATION.$('foo')»
				}
			}
		'''.checkHighlight
	}
	
	def void testRichText_0() {
		'''
			class Foo {
				def foo() «white(Q3)»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is a template«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t')»«white(Q3)»
			}
		'''.checkHighlight
	}
	
	def void testRichText_1() {
		'''
			class Foo {
				def foo() «white(Q3)»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t')»	this is indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t')»«white(Q3)»
			}
		'''.checkHighlight
	}
	
	def void testRichText_2() {
		'''
			class Foo {
				def foo(String[] nums) «white(Q3)»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t')»«GL»FOR i:nums«GR»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»«white('\t')»loop body«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t')»«GL»ENDFOR«GR»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t')»«white(Q3)»
			}
		'''.checkHighlight
	}
	
	def void testRichText_3() {
		'''
			class Foo {
				def foo(String[] nums) «white(Q3)»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t\t')»«GL»FOR i:nums«GR»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»	«white('\t')»loop body«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t\t')»«GL»ENDFOR«GR»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t')»«white(Q3)»
			}
		'''.checkHighlight
	}
	
	def void testRichText_4() {
		'''
			class Foo {
				def foo() «white(Q3)»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«COMMENT_ID.$(GL+GL+GL+' a comment')»
			«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t')»«white(Q3)»
			}
			
		'''.checkHighlight
	}
}

