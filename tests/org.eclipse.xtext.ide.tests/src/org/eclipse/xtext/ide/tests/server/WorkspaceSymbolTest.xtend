/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.Test

import static org.junit.Assert.*

import static extension io.typefox.lsapi.util.LsapiFactories.*

/**
 * @author kosyakov - Initial contribution and API
 */
class WorkspaceSymbolTest extends AbstractLanguageServerTest {

	@Test
	def void testDocumentSymbol_01() {
		testDocumentSymbol[
			model = '''
				type Foo {
					int bar
				}
				type Bar {
					Foo foo
				}
			'''
			query = 'F'
			expectedSymbols = '''
				symbol "Foo" {
					kind: 0
					location: MyModel.testlang [[0, 5] .. [0, 8]]
				}
				symbol "Foo.bar" {
					kind: 0
					location: MyModel.testlang [[1, 5] .. [1, 8]]
				}
				symbol "Foo.bar.int" {
					kind: 0
					location: MyModel.testlang [[1, 1] .. [1, 4]]
				}
				symbol "Bar.foo" {
					kind: 0
					location: MyModel.testlang [[4, 5] .. [4, 8]]
				}
			'''
		]
	}

	@Test
	def void testDocumentSymbol_02() {
		testDocumentSymbol[
			model = '''
				type Foo {
					int bar
				}
				type Bar {
					Foo foo
				}
			'''
			query = 'oO'
			expectedSymbols = '''
				symbol "Foo" {
					kind: 0
					location: MyModel.testlang [[0, 5] .. [0, 8]]
				}
				symbol "Foo.bar" {
					kind: 0
					location: MyModel.testlang [[1, 5] .. [1, 8]]
				}
				symbol "Foo.bar.int" {
					kind: 0
					location: MyModel.testlang [[1, 1] .. [1, 4]]
				}
				symbol "Bar.foo" {
					kind: 0
					location: MyModel.testlang [[4, 5] .. [4, 8]]
				}
			'''
		]
	}

	protected def void testDocumentSymbol((WorkspaceSymbolConfiguraiton)=>void configurator) {
		val extension configuration = new WorkspaceSymbolConfiguraiton
		configurator.apply(configuration)
		val fileUri = filePath -> model

		initialize
		open(fileUri, model)

		val symbols = languageServer.symbol(query.newWorkspaceSymbolParams).get
		
		val String actualSymbols = symbols.toExpectation
		assertEquals(expectedSymbols, actualSymbols)
	}

	@Accessors
	static class WorkspaceSymbolConfiguraiton {
		String model = ''
		String filePath = 'MyModel.testlang'
		String query = ''
		String expectedSymbols = ''
	}
	
}