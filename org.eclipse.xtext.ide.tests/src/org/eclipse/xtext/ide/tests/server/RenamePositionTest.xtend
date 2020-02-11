/*******************************************************************************
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import com.google.common.base.Throwables
import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.RenameCapabilities
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.TextDocumentClientCapabilities
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.testing.AbstractLanguageServerTest
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author koehnlein - Initial contribution and API
 */
class RenamePositionTest extends AbstractLanguageServerTest {

	new() {
		super('renametl')
	}

	@Test
	def void testRenameBeginningOfFile() {
		renameAndFail('type Test', new Position(0, 0), 'No element found at position')
	}

	@Test
	def void testRenameNameAtEndOfFile() {
		val model = 'type Test'
		renameWithSuccess(model, new Position(0, model.length))
	}

	@Test
	def void testBeyondBeginningOfFile() {
		renameAndFail('type Test', new Position(-1, 0), '')
	}

	@Test
	def void testRenameBeyondLine() {
		renameAndFail('''
			type Test
			{}
		''', new Position(0, 11), 'Invalid document position')
	}

	@Test
	def void testBeyondEndOfFile() {
		val model = 'type Test'
		renameAndFail(model, new Position(0, model.length + 1), 'Invalid document position')
	}

	@Test
	def void testRenameAtBraceAfterIdentifier() {
		val model = 'type Test{}'
		renameWithSuccess(model, new Position(0, model.indexOf('{')))
	}

	@Test
	def void testRenameAtBrace() {
		val model = 'type Test{}'
		renameAndFail(model, new Position(0, model.indexOf('}')), 'No element found at position')
	}

	protected def void renameAndFail(String model, Position position, String messageFragment) {
		val modelFile = 'MyType.testlang'.writeFile(model)
		initialize
		try {
			val identifier = new TextDocumentIdentifier(modelFile)
			val prepareRenameResult = languageServer.prepareRename(new TextDocumentPositionParams(identifier, position)).get
			assertNull('''expected null result got «prepareRenameResult» instead''', prepareRenameResult)
			val renameParams = new RenameParams(new TextDocumentIdentifier(modelFile), position, 'Tescht')
			languageServer.rename(renameParams).get
			fail('Rename should have failed')
		} catch (Exception exc) {
			val rootCause = Throwables.getRootCause(exc)
			assertTrue(rootCause instanceof ResponseErrorException)
			val error = (rootCause as ResponseErrorException).responseError
			assertTrue(error.data.toString.contains(messageFragment))
		}
	}

	protected def renameWithSuccess(String model, Position position) {
		val modelFile = 'MyType.testlang'.writeFile(model)
		initialize [
			capabilities = new ClientCapabilities => [
				textDocument = new TextDocumentClientCapabilities => [
					rename = new RenameCapabilities => [
						prepareSupport = true
					]
				]
			]
		]
		val identifier = new TextDocumentIdentifier(modelFile)
		val range = languageServer.prepareRename(new TextDocumentPositionParams(identifier, position)).get.getLeft
		assertNotNull(range)
		assertEquals(new Document(0, model).getSubstring(range), 'Test')
		val params = new RenameParams(identifier, position, 'Tescht')
		val workspaceEdit = languageServer.rename(params).get
		assertEquals('''
			changes :
				MyType.testlang : Tescht [[0, 5] .. [0, 9]]
			documentChanges : 
		     '''.toString, toExpectation(workspaceEdit))
	}
}
