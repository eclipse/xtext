/**
 * Copyright (c) 2018, 2020 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.DocumentSymbolCapabilities;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.xtext.testing.DocumentSymbolConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

public class HierarchicalDocumentSymbolTest extends AbstractTestLangLanguageServerTest {
	private static final Procedure1<? super InitializeParams> INITIALIZER = (InitializeParams it) -> {
		ClientCapabilities clientCapabilities = new ClientCapabilities();
		WorkspaceClientCapabilities workspaceClientCapabilities = new WorkspaceClientCapabilities();
		workspaceClientCapabilities.setWorkspaceFolders(true);
		clientCapabilities.setWorkspace(workspaceClientCapabilities);
		DocumentSymbolCapabilities documentSymbolCapabilities = new DocumentSymbolCapabilities();
		documentSymbolCapabilities.setHierarchicalDocumentSymbolSupport(true);
		TextDocumentClientCapabilities textDocumentClientCapabilities = new TextDocumentClientCapabilities();
		textDocumentClientCapabilities.setDocumentSymbol(documentSymbolCapabilities);
		clientCapabilities.setTextDocument(textDocumentClientCapabilities);
		it.setCapabilities(clientCapabilities);
	};

	@Test
	public void testDocumentSymbol_01() {
		testDocumentSymbol((DocumentSymbolConfiguration it) -> {
			it.setInitializer(HierarchicalDocumentSymbolTest.INITIALIZER);
			String model =
					"type Foo {\n" +
					"	int bar\n" +
					"}\n" +
					"type Bar {\n" +
					"	Foo foo\n" +
					"}\n";
			it.setModel(model);
			String expectedSymbols =
					"symbol \"Foo\" {\n" +
					"    kind: 7\n" +
					"    range: [[0, 0] .. [2, 1]]\n" +
					"    selectionRange: [[0, 5] .. [0, 8]]\n" +
					"    details: \n" +
					"    deprecated: false\n" +
					"    children: [\n" +
					"        symbol \"Foo.bar\" {\n" +
					"            kind: 7\n" +
					"            range: [[1, 1] .. [1, 8]]\n" +
					"            selectionRange: [[1, 5] .. [1, 8]]\n" +
					"            details: \n" +
					"            deprecated: false\n" +
					"            children: [\n" +
					"                symbol \"Foo.bar.int\" {\n" +
					"                    kind: 7\n" +
					"                    range: [[1, 1] .. [1, 4]]\n" +
					"                    selectionRange: [[1, 1] .. [1, 4]]\n" +
					"                    details: \n" +
					"                    deprecated: false\n" +
					"                }\n" +
					"            ]\n" +
					"        }\n" +
					"    ]\n" +
					"}\n" +
					"symbol \"Bar\" {\n" +
					"    kind: 7\n" +
					"    range: [[3, 0] .. [5, 1]]\n" +
					"    selectionRange: [[3, 5] .. [3, 8]]\n" +
					"    details: \n" +
					"    deprecated: false\n" +
					"    children: [\n" +
					"        symbol \"Bar.foo\" {\n" +
					"            kind: 7\n" +
					"            range: [[4, 1] .. [4, 8]]\n" +
					"            selectionRange: [[4, 5] .. [4, 8]]\n" +
					"            details: \n" +
					"            deprecated: false\n" +
					"        }\n" +
					"    ]\n" +
					"}\n";
			it.setExpectedSymbols(expectedSymbols);
		});
	}
}
