/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.Position
import org.junit.Assert
import org.junit.Test

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class CodeLensTest extends AbstractTestLangLanguageServerTest {
	
	@Test def void testCodeLens() {
		testCodeLens [
			model = '''
				type Foo {}
				type Bar {
					Foo foo
				}
			'''
			assertCodeLenses = [
				assertEquals("Do Awesome Stuff(RESOLVED)", head.command.title)
				Assert.assertEquals(1, (head.data as Position).line)
			]
		]
	}
}