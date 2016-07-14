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
	
	protected def CharSequence $(String xtextStyle, CharSequence text) {
		'''<symbolName descr="«xtextStyle»">«text»</symbolName>'''
	}

 	protected def white(String whitespace) {
		INSIGNIFICANT_TEMPLATE_TEXT.$(whitespace)
	}
 
	def testPrimitiveTypeIsKeyword() {
		'''
			class «CLASS.$('Foo')» {
				def «KEYWORD_ID.$('void')» «METHOD.$('foo')»() {}
			}
		'''.checkHighlight
	}

	def testThisIsKeyword() {
		'''
			class «CLASS.$('Foo')» {
				def «METHOD.$('foo')»() {
					«KEYWORD_ID.$('this')»
				}
			}
		'''.checkHighlight
	}
	
	def testItIsKeyword() {
		'''
			class «CLASS.$('Foo')» {
				def «METHOD.$('foo')»(«CLASS.$('String')» «KEYWORD_ID.$('it')») {
				}
			}
		'''.checkHighlight
	}
	
	def void testStaticField() {
		'''
			class «CLASS.$('Foo')» {
				static val «FIELD.$(STATIC_FIELD.$(STATIC_FINAL_FIELD.$('foo')))» = true
				def «METHOD.$('bar')»() { «FIELD.$(STATIC_FIELD.$(STATIC_FINAL_FIELD.$('foo')))» }
			}
		'''.checkHighlight
	}
	
	def void testStaticMethod() {
		'''
			class «CLASS.$('Foo')» {
				static def «METHOD.$('foo')»() {}
				def «METHOD.$('bar')»() { «METHOD.$(STATIC_METHOD_INVOCATION.$('foo'))» }
			}
		'''.checkHighlight
	}

	def void testField() {
		'''
			class «CLASS.$('Foo')» {
				val «FIELD.$('foo')» = null
			}
		'''.checkHighlight
	}
	
	def void testAnnotation() {
		'''
			«ANNOTATION.$('@')»«ANNOTATION.$('SuppressWarnings')»("all")
			class «CLASS.$('Foo')» {
			}
		'''.checkHighlight
	}
	
	def void testExtensionMethod() {
		'''
			class «CLASS.$('Foo')» {
				def «METHOD.$('foo')»(«CLASS.$('String')» «PARAMETER_VARIABLE.$('x')») {
				}
				
				def «METHOD.$('bar')»() {
					''.«EXTENSION_METHOD_INVOCATION.$(METHOD.$('foo'))»
				}
			}
		'''.checkHighlight
	}
	
	def void testRichText_0() {
		'''
			class «CLASS.$('Foo')» {
				def «METHOD.$('foo')»() «white(Q3)»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is a template«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t')»«white(Q3)»
			}
		'''.checkHighlight
	}
	
	def void testRichText_1() {
		'''
			class «CLASS.$('Foo')» {
				def «METHOD.$('foo')»() «white(Q3)»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t')»	this is indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t')»«white(Q3)»
			}
		'''.checkHighlight
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichText_2() {
		'''
			class «CLASS.$('Foo')» {
				def «METHOD.$('foo')»(«CLASS.$('String')»[] «PARAMETER_VARIABLE.$('nums')») «white(Q3)»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t')»«GL»FOR «LOCAL_FINAL_VARIABLE_DECLARATION.$(LOCAL_VARIABLE_DECLARATION.$('i'))»:«PARAMETER_VARIABLE.$('nums')»«GR»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»«white('\t')»loop body«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t')»«GL»ENDFOR«GR»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t')»«white(Q3)»
			}
		'''.checkHighlight
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichText_3() {
		'''
			class «CLASS.$('Foo')» {
				def «METHOD.$('foo')»(«CLASS.$('String')»[] «PARAMETER_VARIABLE.$('nums')») «white(Q3)»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t\t')»«GL»FOR «LOCAL_FINAL_VARIABLE_DECLARATION.$(LOCAL_VARIABLE_DECLARATION.$('i'))»:«PARAMETER_VARIABLE.$('nums')»«GR»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»	«white('\t')»loop body«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t\t\t')»«GL»ENDFOR«GR»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t')»«white(Q3)»
			}
		'''.checkHighlight
	}
	
	// TODO https://github.com/eclipse/xtext-xtend/issues/11
	def void ignoreRichText_4() {
		'''
			class «CLASS.$('Foo')» {
				def «METHOD.$('foo')»() «white(Q3)»«INSIGNIFICANT_TEMPLATE_TEXT.$(NL)
			»«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«COMMENT_ID.$(GL+GL+GL+' a comment')»
			«white('\t\t')»this is not indented«SEMANTIC_LINE_BREAK.$(NL)
			»«white('\t')»«white(Q3)»
			}
			
		'''.checkHighlight
	}
}

