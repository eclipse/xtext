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
class ReferenceTest extends AbstractTestLangLanguageServerTest {

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

	@Test
	def void testReferences_03_acrossFiles() {
		testReferences[
			filesInScope = #{
				"foo.testlang" -> '''
					type Foo {}
				'''
			}
			model = '''
				type Bar {
				    Foo foo
				}
			'''
			line = 1
			column = 6
			includeDeclaration = true
			expectedReferences = '''
				foo.testlang [[0, 5] .. [0, 8]]
				MyModel.testlang [[1, 4] .. [1, 7]]
			'''
		]
	}

}
