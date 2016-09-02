/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.junit.Test
import static io.typefox.lsapi.MarkedString.*

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
				Some documentation.
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
				Some documentation.
			'''
		]
	}

}
