/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.xtext.testing.AbstractLanguageServerTest
import org.junit.Test
import org.junit.Ignore

/**
 * @author koehnlein - Initial contribution and API
 */
class RenameTest2 extends AbstractLanguageServerTest {
	
	new() {
		super('fileawaretestlanguage')
	}
		
	@Test
	def void testRenameSelfRef() {
		val model = '''
			package foo
			
			element Foo {
			 ref Foo
			}
        '''
        val file = 'foo/Foo.fileawaretestlanguage'.writeFile(model)
        initialize
        
        val params = new RenameParams(new TextDocumentIdentifier(file), new Position(2, 9), 'Bar')
        val workspaceEdit = languageServer.rename(params).get
        assertEquals('''
			changes :
			    Foo.fileawaretestlanguage : Bar [[2, 8] .. [2, 11]]
			    Bar [[3, 5] .. [3, 8]]
			documentChanges : 
        '''.toString, toExpectation(workspaceEdit))
	}
	
	@Test@Ignore
	def void testRenameContainer() {
		val model = '''
			package foo
			
			element Foo {
			 element Bar {
			 }
			 ref foo.Foo.Bar
			 ref Foo.Bar
			 ref Bar
			}
        '''
        val file = 'foo/Foo.fileawaretestlanguage'.writeFile(model)
        initialize
    
        val params = new RenameParams(new TextDocumentIdentifier(file), new Position(2, 9), 'Baz')
        val workspaceEdit = languageServer.rename(params).get
        assertEquals('''
			changes :
			    Foo.fileawaretestlanguage : Baz [[2, 8] .. [2, 11]]
			    Baz [[3, 9] .. [3, 12]]
			    Baz [[3, 6] .. [3, 9]]
			documentChanges : 
        '''.toString, toExpectation(workspaceEdit))
	}
	
}