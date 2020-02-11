/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.junit.Test
import org.eclipse.lsp4j.CompletionItem

/**
 * @author kosyakov - Initial contribution and API
 */
class CompletionTest extends AbstractTestLangLanguageServerTest {

	@Test
	def void testCompletion_01() {
		testCompletion [
			model = ''
			expectedCompletionItems = '''
				package -> package [[0, 0] .. [0, 0]]
				type -> type [[0, 0] .. [0, 0]]
				Sample Snippet -> type ${1|A,B,C|} {
				                
				            } [[0, 0] .. [0, 0]]
			'''
		]
	}

	@Test
	def void testCompletion_02() {
		testCompletion [
			model = 'type '
			column = 5
			expectedCompletionItems = '''
				name (ID) -> name [[0, 5] .. [0, 5]]
			'''
		]
	}

	@Test
	def void testCompletion_03() {
		testCompletion [
			model = '''
				type Foo {}
				type Bar {}
			'''
			line = 1
			column = 'type Bar {'.length
			expectedCompletionItems = '''
				Bar (TypeDeclaration) -> Bar [[1, 10] .. [1, 10]]
				Foo (TypeDeclaration) -> Foo [[1, 10] .. [1, 10]]
				boolean -> boolean [[1, 10] .. [1, 10]]
				int -> int [[1, 10] .. [1, 10]]
				op -> op [[1, 10] .. [1, 10]]
				string -> string [[1, 10] .. [1, 10]]
				void -> void [[1, 10] .. [1, 10]]
				} -> } [[1, 10] .. [1, 10]]
				{ -> { [[1, 9] .. [1, 10]]
				   + } [[1, 11] .. [1, 11]]
			'''
		]
	}
	
    @Test
    def void testCompletion_04() {
        testCompletion [
            model = '''
                type Foo {
                    Foo foo
                }
            '''
            line = 1
            column = '    Fo'.length
            expectedCompletionItems = '''
                Foo (TypeDeclaration) -> Foo [[1, 4] .. [1, 6]]
                [ -> [ [[1, 6] .. [1, 6]]
            '''
        ]
    }

    @Test
    def void testCompletion_05() {
        testCompletion [
            model = '''
                type Foo {}
                type foo {}
                type Boo {}
                type boo {}
            '''
            line = 1
            column = 'type Bar {'.length
            expectedCompletionItems = '''
                Boo (TypeDeclaration) -> Boo [[1, 10] .. [1, 10]]
                boo (TypeDeclaration) -> boo [[1, 10] .. [1, 10]]
                Foo (TypeDeclaration) -> Foo [[1, 10] .. [1, 10]]
                foo (TypeDeclaration) -> foo [[1, 10] .. [1, 10]]
                boolean -> boolean [[1, 10] .. [1, 10]]
                int -> int [[1, 10] .. [1, 10]]
                op -> op [[1, 10] .. [1, 10]]
                string -> string [[1, 10] .. [1, 10]]
                void -> void [[1, 10] .. [1, 10]]
                } -> } [[1, 10] .. [1, 10]]
                { -> { [[1, 9] .. [1, 10]]
                   + } [[1, 11] .. [1, 11]]
            '''
        ]
    }
    
    @Test
    def void testSnippet() {
        withKind = true
        testCompletion [
            model = '''
                type Foo {}
                 
            '''
            line = 1
            column = 0
            expectedCompletionItems = '''
               (Keyword) package -> package [[1, 0] .. [1, 0]]
               (Keyword) type -> type [[1, 0] .. [1, 0]]
               (Snippet|Snippet) Sample Snippet -> type ${1|A,B,C|} {
                               
                           } [[1, 0] .. [1, 0]]
            '''
        ]
        withKind = false
    }
    
    @Test
    def void testCompletion_AdditionalEdits_01() {
        testCompletion [
            model = '''
                type Foo 
            '''
            line = 0
            column = 'type Foo '.length
            expectedCompletionItems = '''
                extends -> extends [[0, 9] .. [0, 9]]
                { -> { [[0, 9] .. [0, 9]]
                   + } [[1, 0] .. [1, 0]]
            '''
        ]
    }
    
    @Test
    def void testCompletion_AdditionalEdits_02() {
        testCompletion [
            model = '''
                type Foo  
            '''
            line = 0
            column = 'type Foo '.length
            expectedCompletionItems = '''
            extends -> extends [[0, 9] .. [0, 9]]
            { -> { [[0, 9] .. [0, 9]]
               + } [[0, 10] .. [0, 10]]
            '''
        ]
    }
    
    var withKind = false;
    
    protected override dispatch String toExpectation(CompletionItem it) '''
		«IF withKind»(«kind»«IF insertTextFormat !== null»|«insertTextFormat»«ENDIF») «ENDIF»«label»«IF !detail.nullOrEmpty» («detail»)«ENDIF»«IF textEdit !== null» -> «textEdit.toExpectation»«IF !additionalTextEdits.nullOrEmpty»   + «additionalTextEdits.map[toExpectation].join('   + ')»«ENDIF»«ELSEIF insertText !== null && insertText != label» -> «insertText»«ENDIF»
	'''
}
