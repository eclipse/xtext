/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.junit.Test

import static org.junit.Assert.*

class UriExtensionsTest extends AbstractTestLangLanguageServerTest {
	@Test
	def void testFilesWithSpaces() {
		initialize

		val fileURI = 'Foo Bar.testlang'.virtualFile
		fileURI.open('''
			type FooBar {
			}
		''')

		diagnostics.get(fileURI).forEach [
			println("err: " + it.message)
		]

		assertTrue(diagnostics.get(fileURI).empty)
	}

	@Test
	def void testFilesWithCyrillic() {
		initialize

		val fileURI = "\u0424\u0443 \u0411\u0430\u0440.testlang".virtualFile
		fileURI.open('''
			type FooBar {
			}
		''')

		diagnostics.get(fileURI).forEach [
			println("err: " + it.message)
		]

		assertTrue(diagnostics.get(fileURI).empty)
	}
}

