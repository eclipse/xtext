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
class DefinitionTest extends AbstractTestLangLanguageServerTest {

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

}
