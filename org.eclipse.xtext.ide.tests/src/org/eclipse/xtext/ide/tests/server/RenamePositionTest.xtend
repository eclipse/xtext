/*******************************************************************************
 * Copyright (c) 2019 TypeFox GmbH (http://www.typefox.io) and others.
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
import static org.junit.Assert.*
import org.junit.Test
import java.util.concurrent.ExecutionException
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException

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
		val params = new RenameParams(new TextDocumentIdentifier(modelFile), position, 'Tescht')
		try {
			languageServer.rename(params).get
			fail('Rename should have failed')
		} catch (Exception exc) {
			assertTrue(exc instanceof ExecutionException)
			assertTrue(exc.cause instanceof ExecutionException)
			assertTrue(exc.cause.cause instanceof ResponseErrorException)
			val error = (exc.cause.cause as ResponseErrorException).responseError
			assertTrue(error.data.toString.contains(messageFragment))
		}
	}

	protected def renameWithSuccess(String model, Position position) {
		val modelFile = 'MyType.testlang'.writeFile(model)
		initialize
		val params = new RenameParams(new TextDocumentIdentifier(modelFile), position, 'Tescht')
		val workspaceEdit = languageServer.rename(params).get
		assertEquals('''
			changes :
				MyType.testlang : Tescht [[0, 5] .. [0, 9]]
			documentChanges : 
		     '''.toString, toExpectation(workspaceEdit))
	}
}
