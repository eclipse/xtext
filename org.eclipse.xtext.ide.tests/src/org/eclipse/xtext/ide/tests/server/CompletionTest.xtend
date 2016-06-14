/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.junit.Test

/**
 * @author kosyakov - Initial contribution and API
 */
class CompletionTest extends AbstractTestLangLanguageServerTest {

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

}
