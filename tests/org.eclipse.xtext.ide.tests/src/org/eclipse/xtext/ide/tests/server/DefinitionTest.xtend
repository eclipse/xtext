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
import static io.typefox.lsapi.util.LsapiFactories.*

/**
 * @author kosyakov - Initial contribution and API
 */
class DefinitionTest extends AbstractLanguageServerTest {

	@Test
	def void testDefinition_01() {
		testDefinition[
			model = '''
				type Foo {}
				type Bar {
					Foo foo
				}
			'''
			line = 2
			column = 3
			expectedDefinitions = '''
				MyModel.testlang [[0, 5] .. [0, 8]]
			'''
		]
	}

	protected def void testDefinition((DefinitionTestConfiguration)=>void configurator) {
		val extension configuration = new DefinitionTestConfiguration
		configurator.apply(configuration)

		val fileUri = filePath -> model

		initialize
		open(fileUri, model)

		val definitions = languageServer.definition(newTextDocumentPositionParams(fileUri, line, column))
		val actualDefinitions = definitions.get.toExpectation
		assertEquals(expectedDefinitions, actualDefinitions)
	}

	@Accessors
	static class DefinitionTestConfiguration {
		String model = ''
		String filePath = 'MyModel.testlang'
		int line = 0
		int column = 0
		String expectedDefinitions = ''
	}

}
