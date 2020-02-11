/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.junit.Test

/**
 * @author kosyakov - Initial contribution and API
 */
class WorkspaceSymbolTest extends AbstractTestLangLanguageServerTest {

	@Test
	def void testSymbol_01() {
		testSymbol[
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
					kind: 7
					location: MyModel.testlang [[0, 5] .. [0, 8]]
				}
				symbol "Foo.bar" {
					kind: 7
					location: MyModel.testlang [[1, 5] .. [1, 8]]
				}
				symbol "Foo.bar.int" {
					kind: 7
					location: MyModel.testlang [[1, 1] .. [1, 4]]
				}
				symbol "Bar.foo" {
					kind: 7
					location: MyModel.testlang [[4, 5] .. [4, 8]]
				}
			'''
		]
	}

	@Test
	def void testSymbol_02() {
		testSymbol[
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
					kind: 7
					location: MyModel.testlang [[0, 5] .. [0, 8]]
				}
				symbol "Foo.bar" {
					kind: 7
					location: MyModel.testlang [[1, 5] .. [1, 8]]
				}
				symbol "Foo.bar.int" {
					kind: 7
					location: MyModel.testlang [[1, 1] .. [1, 4]]
				}
				symbol "Bar.foo" {
					kind: 7
					location: MyModel.testlang [[4, 5] .. [4, 8]]
				}
			'''
		]
	}
	
}