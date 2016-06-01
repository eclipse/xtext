/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.Hover
import io.typefox.lsapi.MarkedString
import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.Test

import static io.typefox.lsapi.util.LsapiFactories.*
import static org.junit.Assert.*

/**
 * @author kosyakov - Initial contribution and API
 */
class HoverTest extends AbstractLanguageServerTest {

	@Test
	def void testHover_01() {
		testHover[
			model = '''
				/**
				 * Some documentation.
				 */
				type Foo {
				}
			'''
			line = 3
			column = 'type F'.length
			expectedHover = '''
				[[3, 5] .. [3, 8]]
				Some documentation.
			'''
		]
	}

	@Test
	def void testHover_02() {
		testHover[
			model = '''
				/**
				 * Some documentation.
				 */
				type Foo {}
			'''
			line = 3
			column = '{'.length
		]
	}

	@Test
	def void testHover_03() {
		testHover[
			model = '''
				/**
				 * Some documentation.
				 */
				type Foo {
					Foo foo
				}
			'''
			line = 4
			column = '	F'.length
			expectedHover = '''
				[[4, 1] .. [4, 4]]
				Some documentation.
			'''
		]
	}

	protected def void testHover((HoverTestConfiguration)=>void configurator) {
		val extension configuration = new HoverTestConfiguration
		configurator.apply(configuration)

		val fileUri = filePath -> model

		initialize
		open(fileUri, model)

		val hover = languageServer.hover(newTextDocumentPositionParams(fileUri, line, column))
		val actualHover = hover.get.toExpectation
		assertEquals(expectedHover, actualHover)
	}

	@Accessors
	static class HoverTestConfiguration {
		String model = ''
		String filePath = 'MyModel.testlang'
		int line = 0
		int column = 0
		String expectedHover = ''
	}

	protected dispatch def String toExpectation(Hover it) '''
		«range.toExpectation»
		«FOR content : contents»
			«content.toExpectation»
		«ENDFOR»
	'''

	protected dispatch def String toExpectation(
		MarkedString it
	) '''«IF !language.nullOrEmpty»«language» -> «ENDIF»«value»'''

}
