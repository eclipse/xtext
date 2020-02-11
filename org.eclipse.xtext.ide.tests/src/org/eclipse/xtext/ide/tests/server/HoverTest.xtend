/*******************************************************************************
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
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
class HoverTest extends AbstractTestLangLanguageServerTest {

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
				kind: markdown
				value: Some documentation.
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
			expectedHover = '''
				kind: markdown
				value: 
			'''
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
				kind: markdown
				value: Some documentation.
			'''
		]
	}

	@Test
	def void testHover_04() {
		testHover[
			model = '''
				/**
				 * Some documentation.
				 */
				type Foo {
				}
				type Bar extends Foo {
				}
			'''
			line = 5
			column = 'type Bar extends F'.length
			expectedHover = '''
				[[5, 17] .. [5, 20]]
				kind: markdown
				value: Some documentation.
			'''
		]
	}

	@Test
	def void testHover_05() {
		testHover[
			filesInScope = #{
				('MyModel2.' + fileExtension) -> '''
					/**
					 * Some documentation.
					 */
					type Foo {
					}
				'''
			}
			model = '''
				type Bar extends Foo {
				}
			'''
			column = 'type Bar extends F'.length
			expectedHover = '''
				[[0, 17] .. [0, 20]]
				kind: markdown
				value: Some documentation.
			'''
		]
	}

}
