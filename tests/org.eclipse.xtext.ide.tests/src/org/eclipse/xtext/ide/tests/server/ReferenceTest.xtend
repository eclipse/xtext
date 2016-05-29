/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.ReferenceContextImpl
import io.typefox.lsapi.ReferenceParamsImpl
import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.Test

import static io.typefox.lsapi.util.LsapiFactories.*
import static org.junit.Assert.*

/**
 * @author kosyakov - Initial contribution and API
 */
class ReferenceTest extends AbstractLanguageServerTest {

	@Test
	def void testReferences_01() {
		testReferences[
			model = '''
				type Foo {}
				type Bar {
					Foo foo
				}
			'''
			column = 'type F'.length
			expectedReferences = '''
				MyModel.testlang [[2, 1] .. [2, 4]]
			'''
		]
	}

	@Test
	def void testReferences_02() {
		testReferences[
			model = '''
				type Foo {}
				type Bar {
					Foo foo
				}
			'''
			column = 'type F'.length
			includeDeclaration = true
			expectedReferences = '''
				MyModel.testlang [[0, 5] .. [0, 8]]
				MyModel.testlang [[2, 1] .. [2, 4]]
			'''
		]
	}
	

	protected def void testReferences((ReferenceTestConfiguration)=>void configurator) {
		val extension configuration = new ReferenceTestConfiguration
		configurator.apply(configuration)

		val fileUri = filePath -> model

		initialize
		open(fileUri, model)

		val referenceContext = new ReferenceContextImpl
		referenceContext.includeDeclaration = includeDeclaration
		val definitions = languageServer.references(new ReferenceParamsImpl => [
			textDocument = fileUri.newIdentifier
			position = newPosition(line, column)
			context = referenceContext
		])
		val actualDefinitions = definitions.get.toExpectation
		assertEquals(expectedReferences, actualDefinitions)
	}

	@Accessors
	static class ReferenceTestConfiguration {
		String model = ''
		String filePath = 'MyModel.testlang'
		int line = 0
		int column = 0
		boolean includeDeclaration = false
		String expectedReferences = ''
	}

}
