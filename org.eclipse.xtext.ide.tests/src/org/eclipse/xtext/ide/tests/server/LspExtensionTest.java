/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.List;

import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.jsonrpc.services.ServiceEndpoints;
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension;
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension.TextOfLineParam;
import org.eclipse.xtext.ide.tests.testlanguage.ide.TestLangLSPExtension.TextOfLineResult;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author efftinge - Initial contribution and API
 */
public class LspExtensionTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testExtension() throws Exception {
		String fileURI = writeFile("mydoc.testlang", "");
		initialize();
		TestLangLSPExtension ext = ServiceEndpoints.toServiceObject(languageServer, TestLangLSPExtension.class);
		DidOpenTextDocumentParams didOpenTextDocumentParams = new DidOpenTextDocumentParams();
		String text = 
				"foo bar" + System.lineSeparator() +
				"baz test" + System.lineSeparator() +
				"	bla blubb";
		didOpenTextDocumentParams.setTextDocument(new TextDocumentItem(fileURI, "testlang", 0, text));
		languageServer.didOpen(didOpenTextDocumentParams);
		TextOfLineParam textOfLineParam = new TextOfLineParam();
		textOfLineParam.uri = fileURI;
		textOfLineParam.line = 1;
		TextOfLineResult result = ext.getTextOfLine(textOfLineParam).get();
		Assert.assertEquals("baz test", result.text);
		Assert.assertEquals(2,
				IterableExtensions.size(Iterables.filter(Iterables.transform(notifications, n -> n.getValue()),
						TestLangLSPExtension.BuildNotification.class)));
	}

	@Test
	public void testExtension_readIndex() throws Exception {
		writeFile("model.testlang",
				"type C {\n" +
				"	op baz() { }\n" +
				"}\n" + 
				"type A {\n" +
				"	op foo() { }\n" +
				"}\n" +
				"type B {\n" +
				"	op bar() { }\n" +
				"}\n");
		initialize();
		TestLangLSPExtension ext = ServiceEndpoints.toServiceObject(languageServer, TestLangLSPExtension.class);
		List<String> actual = IterableExtensions.sort(Lists.newArrayList(ext.getAllOpNames().get()));
		Assert.assertEquals(Lists.newArrayList("bar", "baz", "foo"), actual);
	}
}
