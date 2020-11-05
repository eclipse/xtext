/*******************************************************************************
 * Copyright (c) 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.junit.Test
import org.eclipse.lsp4j.PrepareRenameParams
import org.eclipse.xtext.ide.server.Document
import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.WorkspaceClientCapabilities
import org.eclipse.lsp4j.WorkspaceEditCapabilities
import org.eclipse.lsp4j.TextDocumentClientCapabilities
import org.eclipse.lsp4j.RenameCapabilities
import org.eclipse.xtext.testing.AbstractLanguageServerTest

/**
 * @author koehnlein - Initial contribution and API
 */
class RenameTest3 extends AbstractLanguageServerTest {

	new() {
		super("renametl")
	}

	@Test
	def void testRenameAutoQuote() throws Exception {
		val model = '''
			type Foo {
			}
		    '''
		val file = 'foo/Foo.renametl'.writeFile(model)
		initialize

		val identifier = new TextDocumentIdentifier(file)
		val position = new Position(0, 6)
		val range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get.getLeft
		assertEquals('Foo', new Document(0, model).getSubstring(range))
		val params = new RenameParams(identifier, position, 'type')
		val workspaceEdit = languageServer.rename(params).get
		assertEquals('''
			changes :
			documentChanges : 
			    Foo.renametl <1> : ^type [[0, 5] .. [0, 8]]
		'''.toString, toExpectation(workspaceEdit))
	}

	@Test
	def void testRenameQuoted() throws Exception {
		val model = '''
			type ^type {
			}
		    '''
		val file = 'foo/Foo.renametl'.writeFile(model)
		initialize

		val identifier = new TextDocumentIdentifier(file)
		val position = new Position(0, 6)
		val range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get.getLeft
		assertEquals('^type', new Document(0, model).getSubstring(range))
		val params = new RenameParams(identifier, position, 'Foo')
		val workspaceEdit = languageServer.rename(params).get
		assertEquals('''
			changes :
			documentChanges : 
			    Foo.renametl <1> : Foo [[0, 5] .. [0, 10]]
		'''.toString, toExpectation(workspaceEdit))
	}

	@Test
	def void testRenameAutoQuoteRef() throws Exception {
		val model = '''
			type Foo {
			}
			
			type Bar extends Foo {
			}
		    '''
		val file = 'foo/Foo.renametl'.writeFile(model)
		initialize

		val identifier = new TextDocumentIdentifier(file)
		val position = new Position(3, 18)
		val range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get.getLeft
		assertEquals('Foo', new Document(0, model).getSubstring(range))
		val params = new RenameParams(identifier, position, 'type')
		val workspaceEdit = languageServer.rename(params).get
		assertEquals('''
			changes :
			documentChanges : 
			    Foo.renametl <1> : ^type [[0, 5] .. [0, 8]]
			    ^type [[3, 17] .. [3, 20]]
		'''.toString, toExpectation(workspaceEdit))
	}

	@Test
	def void testRenameQuotedRef() throws Exception {
		val model = '''
			type ^type {
			}
			
			type Bar extends ^type {
			}
		    '''
		val file = 'foo/Foo.renametl'.writeFile(model)
		initialize

		val identifier = new TextDocumentIdentifier(file)
		val position = new Position(3, 19)
		val range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get.getLeft
		assertEquals('^type', new Document(0, model).getSubstring(range))
		val params = new RenameParams(identifier, position, 'Foo')
		val workspaceEdit = languageServer.rename(params).get
		assertEquals('''
			changes :
			documentChanges : 
			    Foo.renametl <1> : Foo [[0, 5] .. [0, 10]]
			    Foo [[3, 17] .. [3, 22]]
		'''.toString, toExpectation(workspaceEdit))
	}

	override protected initialize() {
		super.initialize([ params |
			params.capabilities = new ClientCapabilities => [
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
