/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.DocumentSymbolParamsImpl
import io.typefox.lsapi.SymbolInformation
import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author kosyakov - Initial contribution and API
 */
class DocumentSymbolTest extends AbstractLanguageServerTest {

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
			expectedSymbols = '''
				symbol "Foo" {
					kind: 0
					location: MyModel.testlang [[0, 5] .. [0, 8]]
				}
				symbol "Foo.bar" {
					kind: 0
					location: MyModel.testlang [[1, 5] .. [1, 8]]
					container: "Foo"
				}
				symbol "Foo.bar.int" {
					kind: 0
					location: MyModel.testlang [[1, 1] .. [1, 4]]
					container: "Foo.bar"
				}
				symbol "Bar" {
					kind: 0
					location: MyModel.testlang [[3, 5] .. [3, 8]]
				}
				symbol "Bar.foo" {
					kind: 0
					location: MyModel.testlang [[4, 5] .. [4, 8]]
					container: "Bar"
				}
			'''
		]
	}

	protected def void testDocumentSymbol((DocumentSymbolConfiguraiton)=>void configurator) {
		val extension configuration = new DocumentSymbolConfiguraiton
		configurator.apply(configuration)
		val fileUri = filePath -> model

		initialize
		open(fileUri, model)

		val symbols = languageServer.documentSymbol(new DocumentSymbolParamsImpl => [
			textDocument = fileUri.newIdentifier
		])
		val String actualSymbols = symbols.get.toExpectation
		assertEquals(expectedSymbols, actualSymbols)
	}

	@Accessors
	static class DocumentSymbolConfiguraiton {
		String model = ''
		String filePath = 'MyModel.testlang'
		String expectedSymbols = ''
	}

	protected def dispatch String toExpectation(SymbolInformation it) '''
		symbol "«name»" {
			kind: «kind»
			location: «location.toExpectation»
			«IF !container.nullOrEmpty»
				container: "«container»"
			«ENDIF»
		}
	'''

}
