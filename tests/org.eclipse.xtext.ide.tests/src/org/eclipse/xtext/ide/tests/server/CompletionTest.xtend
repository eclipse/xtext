/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import io.typefox.lsapi.CompletionItem
import io.typefox.lsapi.DidOpenTextDocumentParamsImpl
import io.typefox.lsapi.PositionImpl
import io.typefox.lsapi.TextDocumentIdentifierImpl
import io.typefox.lsapi.TextDocumentItemImpl
import io.typefox.lsapi.TextDocumentPositionParamsImpl
import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.junit.Test

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
			caretColumn = 5
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
			caretLine = 1
			caretColumn = 'type Bar {'.length
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

		languageServer.didOpen(new DidOpenTextDocumentParamsImpl => [
			textDocument = new TextDocumentItemImpl => [
				uri = fileUri
				version = 1
				text = model
			]
		])

		val completionItems = languageServer.completion(new TextDocumentPositionParamsImpl => [
			textDocument = new TextDocumentIdentifierImpl => [
				uri = fileUri
			]
			position = new PositionImpl => [
				line = caretLine
				character = caretColumn
			]
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
		int caretLine = 0
		int caretColumn = 0
		String expectedCompletionItems = ''
	}

}
