/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.CompletionItem
import io.typefox.lsapi.TextDocumentPositionParamsImpl
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.Test

import static io.typefox.lsapi.util.LsapiFactories.*
import static org.junit.Assert.*

/**
 * @author kosyakov - Initial contribution and API
 */
class CompletionTest extends AbstractLanguageServerTest {

	@Test
	def void testCompletion_01() {
		testCompletion [
			expectedCompletionItems = '''
				type
			'''
		]
	}

	@Test
	def void testCompletion_02() {
		testCompletion [
			model = 'type '
			column = 5
			expectedCompletionItems = '''
				name (ID)
			'''
		]
	}

	@Test
	def void testCompletion_03() {
		testCompletion [
			model = '''
				type Foo {}
				type Bar {}
			'''
			line = 1
			column = 'type Bar {'.length
			expectedCompletionItems = '''
				Bar (TypeDeclaration)
				Foo (TypeDeclaration)
				boolean
				int
				string
				}
				{
			'''
		]
	}

	protected def testCompletion((TestCompletionConfiguration)=>void configurator) {
		val extension configuration = new TestCompletionConfiguration
		configurator.apply(configuration)
		val fileUri = filePath -> model

		initialize
		open(fileUri, model)

		val completionItems = languageServer.completion(new TextDocumentPositionParamsImpl => [
			textDocument = fileUri.createIdentifier
			position = newPosition(line, column)
		])

		val actualCompletionItems = toExpectation(completionItems)
		assertEquals(expectedCompletionItems, actualCompletionItems)
	}

	protected def String toExpectation(List<? extends CompletionItem> completionItems) '''
		«FOR completionItem : completionItems»
			«completionItem.toExpectation»
		«ENDFOR»
	'''

	protected def <T extends CompletionItem> String toExpectation(T it) '''
		«label»«IF !detail.nullOrEmpty» («detail»)«ENDIF»«IF insertText != label» -> «insertText»«ENDIF»
	'''

	@Accessors
	static class TestCompletionConfiguration {
		String model = ''
		String filePath = 'MyModel.testlang'
		int line = 0
		int column = 0
		String expectedCompletionItems = ''
	}

}
