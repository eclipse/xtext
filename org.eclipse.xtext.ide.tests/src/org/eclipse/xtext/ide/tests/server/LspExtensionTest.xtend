/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension.TextOfLineParam
import org.junit.Assert
import org.junit.Test

/**
 * @author efftinge - Initial contribution and API
 */
class LspExtensionTest extends AbstractTestLangLanguageServerTest {
	
	@Test def void testExtension() {
		initialize
		val ext = ServiceEndpoints.toServiceObject(languageServer, TestLangLSPExtension)
		val fileURI = "mydoc.testlang".writeFile('''
			foo bar
			baz test
				bla blubb
		''')
		val result = ext.getTextOfLine(new TextOfLineParam => [
			uri = fileURI
			line = 1
		]).get
		Assert.assertEquals("baz test", result.text)
	}
}