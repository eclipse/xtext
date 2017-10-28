/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.junit.Ignore
import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
 // FIXME https://github.com/eclipse/xtext-core/issues/520
 @Ignore("https://github.com/eclipse/xtext-core/issues/520")
class RenameIssue520Test extends AbstractTestLangLanguageServerTest {
	
	@Test def void testTwoFiles() {
		val model = '''
			type Foo {
			}
        '''
        val file = 'foo/Foo.testlang'.writeFile(model)
		val model2 = '''
			type Bar {
				Foo ref
			}
        '''
        val file2 = 'foo/Bar.testlang'.writeFile(model2)
        initialize
        
        val params = new RenameParams(new TextDocumentIdentifier(file), new Position(0, 6), 'FooNeu')
        val workspaceEdit = languageServer.rename(params).get
        assertEquals('''
			changes :
			    Foo.testlang : FooNeu [[0, 5] .. [0, 8]]
			    Bar.testlang : FooNeu [[1, 1] .. [1, 4]]
			documentChanges : 

        '''.toString, toExpectation(workspaceEdit))
	}
}