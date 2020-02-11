/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.RenameCapabilities
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.TextDocumentClientCapabilities
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.lsp4j.WorkspaceClientCapabilities
import org.eclipse.lsp4j.WorkspaceEditCapabilities
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.testing.AbstractLanguageServerTest
import org.junit.Test

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
        val identifier = new TextDocumentIdentifier(file)
        val position = new Position(2, 9)
        val range = languageServer.prepareRename(new TextDocumentPositionParams(identifier, position)).get.getLeft
        assertEquals('Foo', new Document(0, model).getSubstring(range))
        val params = new RenameParams(identifier, position, 'Bar')
        val workspaceEdit = languageServer.rename(params).get
        assertEquals('''
			changes :
			documentChanges : 
			    Foo.fileawaretestlanguage <1> : Bar [[2, 8] .. [2, 11]]
			    Bar [[3, 5] .. [3, 8]]
        '''.toString, toExpectation(workspaceEdit))
	}
	
	@Test
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

        val identifier = new TextDocumentIdentifier(file)
        val position = new Position(2, 9)
        val range = languageServer.prepareRename(new TextDocumentPositionParams(identifier, position)).get.getLeft
        assertEquals('Foo', new Document(0, model).getSubstring(range))
        val params = new RenameParams(identifier, position, 'Baz')
        val workspaceEdit = languageServer.rename(params).get
        assertEquals('''
			changes :
			documentChanges : 
			    Foo.fileawaretestlanguage <1> : Baz [[2, 8] .. [2, 11]]
			    Bar [[5, 5] .. [5, 16]]
			    Bar [[6, 5] .. [6, 12]]
        '''.toString, toExpectation(workspaceEdit))
	}

	override protected initialize() {
		super.initialize([params | params.capabilities = new ClientCapabilities => [
			workspace = new WorkspaceClientCapabilities => [
				workspaceEdit = new WorkspaceEditCapabilities => [
					documentChanges = true
				]
			]
			textDocument = new TextDocumentClientCapabilities => [
					rename = new RenameCapabilities => [
						prepareSupport = true
					]
				]
			]
		])
 	}
}