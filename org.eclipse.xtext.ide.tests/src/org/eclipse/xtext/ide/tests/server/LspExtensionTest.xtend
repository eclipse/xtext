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
import org.junit.Assert
import org.junit.Test

/**
 * @author efftinge - Initial contribution and API
 */
class LspExtensionTest extends AbstractTestLangLanguageServerTest {
	
	@Test def void testExtension() {
		val ext = ServiceEndpoints.toServiceObject(languageServer, TestLangLSPExtension)
		ext.sayHello
		try {
			ext.sayHello
			Assert.fail("Expected exception on second call.")
		} catch (RuntimeException e) {
			// expected
		}
		val result = ext.getFullText(new TestLangLSPExtension.Text => [ text = "World!"])
		Assert.assertEquals("Hello World!", result.get.text)
	}
}