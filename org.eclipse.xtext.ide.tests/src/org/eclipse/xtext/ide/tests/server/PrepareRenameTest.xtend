/*******************************************************************************
 * Copyright (c) 2019 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import com.google.common.base.Throwables
import com.google.inject.Inject
import java.io.File
import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.RenameCapabilities
import org.eclipse.lsp4j.RenameParams
import org.eclipse.lsp4j.TextDocumentClientCapabilities
import org.eclipse.lsp4j.TextDocumentIdentifier
import org.eclipse.lsp4j.TextDocumentPositionParams
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException
import org.eclipse.xtext.ide.server.Document
import org.eclipse.xtext.ide.server.UriExtensions
import org.junit.Test

import static org.junit.Assert.*
import java.io.FileNotFoundException

class PrepareRenameTest extends AbstractTestLangLanguageServerTest {

	@Inject
	extension UriExtensions

	@Test
	def void testRenameFqn_missing_file_null() {
		val uri = new File('''missing.«fileExtension»''').toURI.normalize.toUriString
		initializeWithPrepareSupport()

		val params = new RenameParams(new TextDocumentIdentifier(uri), new Position(2, 5), 'Does not matter')
		assertNull(languageServer.rename(params).get)
	}

	@Test
	def void testPrepareRenameFqn_missing_file_null() {
		val uri = new File('''missing.«fileExtension»''').toURI.normalize.toUriString
		initializeWithPrepareSupport()

		val params = new TextDocumentPositionParams(new TextDocumentIdentifier(uri), new Position(2, 5))
		assertNull(languageServer.prepareRename(params).get)
	}

	@Test
	def void testPrepareRenameFqn_missing_file_exception() {
		val uri = new File('''missing.«fileExtension»''').toURI.normalize.toUriString
		initialize()

		val params = new TextDocumentPositionParams(new TextDocumentIdentifier(uri), new Position(2, 5))
		try {
			assertNull(languageServer.prepareRename(params).get)
			fail('Expected an error.')
		} catch (Exception e) {
			assertTrue(Throwables.getRootCause(e) instanceof FileNotFoundException)
		}

	}

	@Test
	def void testRenameFqn_invalid_error() {
		val uri = 'my-type-invalid.testlang'.writeFile('''
			package foo.bar {
			  type A {
			    foo.bar.MyType bar
			  }
			  type MyType { }
			}
		''')
		initialize()

		val params = new RenameParams(new TextDocumentIdentifier(uri), new Position(2, 5), 'Does not matter')
		try {
			val workspaceEdit = languageServer.rename(params).get
			fail('''Expected an expcetion when trying to rename document but got a valid workspace edit instead: «workspaceEdit»''')
		} catch (Exception e) {
			val rootCause = Throwables.getRootCause(e)
			assertTrue(rootCause instanceof ResponseErrorException)
			val error = (rootCause as ResponseErrorException).responseError
			assertTrue(error.data.toString.contains('No element found at position'))
		}
	}

	@Test
	def void testRenameFqn_invalid_null() {
		val uri = 'my-type-invalid.testlang'.writeFile('''
			package foo.bar {
			  type A {
			    foo.bar.MyType bar
			  }
			  type MyType { }
			}
		''')
		initializeWithPrepareSupport()

		val params = new RenameParams(new TextDocumentIdentifier(uri), new Position(2, 5), 'Does not matter')
		assertNull(languageServer.rename(params).get)
	}

	@Test
	def void testRenameFqn_before_ok() {
		val uri = 'my-type-valid.testlang'.writeFile('''
			package foo.bar {
			  type A {
			    foo.bar.MyType bar
			  }
			  type MyType { }
			}
		''')
		initializeWithPrepareSupport()

		val params = new RenameParams(new TextDocumentIdentifier(uri), new Position(2, 13), 'YourType')
		val workspaceEdit = languageServer.rename(params).get
		assertEquals('''
			changes :
				my-type-valid.testlang : foo.bar.YourType [[2, 4] .. [2, 18]]
				YourType [[4, 7] .. [4, 13]]
			documentChanges : 
		'''.toString, toExpectation(workspaceEdit))
	}

	@Test
	def void testPrepareRenameFqn_before_nok() {
		val model = '''
			package foo.bar {
			  type A {
			    foo.bar.MyType bar
			  }
			  type MyType { }
			}
		'''
		initializeWithPrepareSupport()

		val uri = 'my-type-valid.testlang'.writeFile(model)

		val params = new TextDocumentPositionParams(new TextDocumentIdentifier(uri), new Position(2, 11))
		assertNull(languageServer.prepareRename(params).get)
	}

	@Test
	def void testPrepareRenameFqn_start_ok() {
		val model = '''
			package foo.bar {
			  type A {
			    foo.bar.MyType bar
			  }
			  type MyType { }
			}
		'''
		initializeWithPrepareSupport()

		val uri = 'my-type-valid.testlang'.writeFile(model)

		val params = new TextDocumentPositionParams(new TextDocumentIdentifier(uri), new Position(2, 12))
		val range = languageServer.prepareRename(params).get.getLeft
		assertEquals('MyType', new Document(0, model).getSubstring(range))
	}

	@Test
	def void testPrepareRenameFqn_in_ok() {
		val model = '''
			package foo.bar {
			  type A {
			    foo.bar.MyType bar
			  }
			  type MyType { }
			}
		'''
		initializeWithPrepareSupport()

		val uri = 'my-type-valid.testlang'.writeFile(model)

		val params = new TextDocumentPositionParams(new TextDocumentIdentifier(uri), new Position(2, 14))
		val range = languageServer.prepareRename(params).get.getLeft
		assertEquals('MyType', new Document(0, model).getSubstring(range))
	}

	@Test
	def void testPrepareRenameFqn_end_ok() {
		val model = '''
			package foo.bar {
			  type A {
			    foo.bar.MyType bar
			  }
			  type MyType { }
			}
		'''
		initializeWithPrepareSupport()

		val uri = 'my-type-valid.testlang'.writeFile(model)

		val params = new TextDocumentPositionParams(new TextDocumentIdentifier(uri), new Position(2, 18))
		val range = languageServer.prepareRename(params).get.getLeft
		assertEquals('MyType', new Document(0, model).getSubstring(range))
	}

	@Test
	def void testPrepareRenameFqn_end_null() {
		val model = '''
			package foo.bar {
			  type A {
			    foo.bar.MyType bar
			  }
			  type MyType { }
			}
		'''
		initialize()

		val uri = 'my-type-valid.testlang'.writeFile(model)

		val params = new TextDocumentPositionParams(new TextDocumentIdentifier(uri), new Position(2, 18))
		assertNull(languageServer.prepareRename(params).get)
	}

	private def initializeWithPrepareSupport() {
		initialize[
			capabilities = new ClientCapabilities => [
				textDocument = new TextDocumentClientCapabilities => [
					rename = new RenameCapabilities => [
						prepareSupport = true
					]
				]
			]
		]
	}

}
