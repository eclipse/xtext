/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.xtext.ide.server.signatureHelp.SignatureHelpService
import org.junit.Test
import org.eclipse.xtext.ide.tests.testlanguage.signatureHelp.SignatureHelpServiceImpl

/**
 * Class for testing the the {@link SignatureHelpService signature help service} implementation.
 * 
 * @author akos.kitta - Initial contribution and API
 * @see SignatureHelpServiceImpl
 */
class SignatureHelpTest extends AbstractTestLangLanguageServerTest {

    static val LINE_NUMBER = 12;

    @Test
    def void noArgsExactMatch() {
        val testMe = '''foo()''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo('''.length;
            expectedSignatureHelp = 'A.foo(): void | A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | <empty>'
        ];
    }
    
    @Test
    def void firstArgExactMatch() {
        val testMe = '''foo(1)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(1'''.length;
            expectedSignatureHelp = 'A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A'
        ];
    }
    
    @Test
    def void secondArgExactMatch() {
        val testMe = '''foo(1, 2)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(1, 2'''.length;
            expectedSignatureHelp = 'B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | b: B'
        ];
    }
    
    @Test
    def void thirdArgExactMatch() {
        val testMe = '''foo(1, 2, 3)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(1, 2, 3'''.length;
            expectedSignatureHelp = 'C.foo(a: A, b: B, c: C): void | c: C'
        ];
    }
    
    @Test
    def void singleArgWithLeadingWhitespace() {
        val testMe = '''foo(     1)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(     1'''.length;
            expectedSignatureHelp = 'A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A'
        ];
    }
    
    @Test
    def void singleArgWithTrailingWhitespace() {
        val testMe = '''foo(1    )''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(1    '''.length;
            expectedSignatureHelp = 'A.foo(a: A): string | B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A'
        ];
    }
    
    @Test
    def void multipleArgsWithLeadingWhitespaceBeforeFirstArg_ExpectFirstArg() {
    val testMe = '''foo(    1, 2)'''
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(    1'''.length;
            expectedSignatureHelp = 'B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A'
        ];
    }
    
    @Test
    def void multipleArgsWithLeadingWhitespaceBeforeComma_ExpectFirstArg() {
        val testMe = '''foo(    1   , 2)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(    1   '''.length;
            expectedSignatureHelp = 'B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | a: A'
        ];
    }
    
    @Test
    def void multipleArgsWithLeadingWhitespaceAtComma_ExpectFirstArg() {
        val testMe = '''foo(    1   , 2)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(    1   ,'''.length;
            expectedSignatureHelp = 'B.foo(a: A, b: B): int | C.foo(a: A, b: B, c: C): void | b: B'
        ];
    }
    
    @Test
    def void multipleArgsAtComma() {
        val testMe = '''foo(1, 2, 3)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(1, 2,'''.length;
            expectedSignatureHelp = 'C.foo(a: A, b: B, c: C): void | c: C'
        ];
    }
    
    @Test
    def void multipleArgsAtCommaIncomplete() {
        val testMe = '''foo(1, 2,)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(1, 2,'''.length;
            expectedSignatureHelp = 'C.foo(a: A, b: B, c: C): void | c: C'
        ];
    }
    
    @Test
    def void multipleArgsWithCommentAtCommaIncomplete() {
        val testMe = '''foo(1, /*,*/ 2,)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(1, /*,*/ 2,'''.length;
            expectedSignatureHelp = 'C.foo(a: A, b: B, c: C): void | c: C'
        ];
    }
    
    @Test
    def void beforeOperationCall() {
        val testMe = '''foo(1, 2)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo'''.length;
            expectedSignatureHelp = '<empty>'
        ];
    }
    
    @Test
    def void afterOperationCall() {
        val testMe = '''foo(1, 2)''';
        testSignatureHelp[
            model = getModel(testMe)
            line = LINE_NUMBER;
            column = '''foo(1, 2)'''.length;
            expectedSignatureHelp = '<empty>'
        ];
    }
    
    private def String getModel(CharSequence method) '''
            type A { 
                op foo() { } 
                op foo(a: A): string { }
            }
            type B { 
                op foo(a: A, b: B): int { }
            }
            type C { 
                op foo(a: A, b: B, c: C): void { }
            }
            type Test { 
                op main() {
            «method»
                }
            }
    '''

   
}