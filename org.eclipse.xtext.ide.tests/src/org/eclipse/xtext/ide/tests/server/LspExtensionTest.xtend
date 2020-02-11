/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.DidOpenTextDocumentParams
import org.eclipse.lsp4j.TextDocumentItem
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension.TextOfLineParam
import org.junit.Assert
import org.junit.Test
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension.BuildNotification

/**
 * @author efftinge - Initial contribution and API
 */
class LspExtensionTest extends AbstractTestLangLanguageServerTest {
	
	@Test def void testExtension() {
		val fileURI = "mydoc.testlang".writeFile("")
		initialize
		val ext = ServiceEndpoints.toServiceObject(languageServer, TestLangLSPExtension)
		languageServer.didOpen(new DidOpenTextDocumentParams => [
			it.textDocument = new TextDocumentItem => [
				uri = fileURI
				text = '''
					foo bar
					baz test
						bla blubb
				'''
			]
		])
		val result = ext.getTextOfLine(new TextOfLineParam => [
			uri = fileURI
			line = 1
		]).get
		Assert.assertEquals("baz test", result.text)
		Assert.assertEquals(2, notifications.map[value].filter(BuildNotification).size)
	}

	@Test def void testExtension_readIndex() {
		'model.testlang'.writeFile('''
			type C {
			  op baz() { }
			}
			type A {
			  op foo() { }
			}
			type B {
			  op bar() { }
			}
		''')
		initialize
		val ext = ServiceEndpoints.toServiceObject(languageServer, TestLangLSPExtension)
		val actual = ext.allOpNames.get.toList.sort
		Assert.assertEquals(#['bar', 'baz', 'foo'], actual)
	}

}