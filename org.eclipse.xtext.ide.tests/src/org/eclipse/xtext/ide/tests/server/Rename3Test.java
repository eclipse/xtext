/**
 * Copyright (c) 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.InitializeResult;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.PrepareRenameParams;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.RenameCapabilities;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.WorkspaceEditCapabilities;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.junit.Test;

/**
 * @author koehnlein - Initial contribution and API
 */
public class Rename3Test extends AbstractLanguageServerTest {
	public Rename3Test() {
		super("renametl");
	}

	@Test
	public void testRenameAutoQuote() throws Exception {
		String model =
				"type Foo {\n" +
				"}\n" +
				"";
		String file = writeFile("foo/Foo.renametl", model);
		initialize();
		TextDocumentIdentifier identifier = new TextDocumentIdentifier(file);
		Position position = new Position(0, 6);
		Range range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get().getLeft();
		assertEquals("Foo", new Document(0, model).getSubstring(range));
		RenameParams params = new RenameParams(identifier, position, "type");
		WorkspaceEdit workspaceEdit = languageServer.rename(params).get();
		String expectation =
				"changes :\n" +
				"documentChanges : \n" +
				"    Foo.renametl <1> : ^type [[0, 5] .. [0, 8]]\n" +
				"";
		assertEquals(expectation.toString(), toExpectation(workspaceEdit));
	}

	@Test
	public void testRenameQuoted() throws Exception {
		String model =
				"type ^type {\n" +
				"}\n" +
				"";
		String file = writeFile("foo/Foo.renametl", model);
		initialize();
		TextDocumentIdentifier identifier = new TextDocumentIdentifier(file);
		Position position = new Position(0, 6);
		Range range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get().getLeft();
		assertEquals("^type", new Document(0, model).getSubstring(range));
		RenameParams params = new RenameParams(identifier, position, "Foo");
		WorkspaceEdit workspaceEdit = languageServer.rename(params).get();
		String expectation =
				"changes :\n" +
				"documentChanges : \n" +
				"    Foo.renametl <1> : Foo [[0, 5] .. [0, 10]]\n" +
				"";
		assertEquals(expectation.toString(), toExpectation(workspaceEdit));
	}

	@Test
	public void testRenameAutoQuoteRef() throws Exception {
		String model =
				"type Foo {\n" +
				"}\n" +
				"\n" +
				"type Bar extends Foo {\n" +
				"}\n" +
				"";
		String file = writeFile("foo/Foo.renametl", model);
		initialize();
		TextDocumentIdentifier identifier = new TextDocumentIdentifier(file);
		Position position = new Position(3, 18);
		Range range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get().getLeft();
		assertEquals("Foo", new Document(0, model).getSubstring(range));
		RenameParams params = new RenameParams(identifier, position, "type");
		WorkspaceEdit workspaceEdit = languageServer.rename(params).get();
		String expectation =
				"changes :\n" +
				"documentChanges : \n" +
				"    Foo.renametl <1> : ^type [[0, 5] .. [0, 8]]\n" +
				"    ^type [[3, 17] .. [3, 20]]\n" +
				"";
		assertEquals(expectation.toString(), toExpectation(workspaceEdit));
	}

	@Test
	public void testRenameQuotedRef() throws Exception {
		String model =
				"type ^type {\n" +
				"}\n" +
				"\n" +
				"type Bar extends ^type {\n" +
				"}\n" +
				"";
		String file = writeFile("foo/Foo.renametl", model);
		initialize();
		TextDocumentIdentifier identifier = new TextDocumentIdentifier(file);
		Position position = new Position(3, 19);
		Range range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get().getLeft();
		assertEquals("^type", new Document(0, model).getSubstring(range));
		RenameParams params = new RenameParams(identifier, position, "Foo");
		WorkspaceEdit workspaceEdit = languageServer.rename(params).get();
		String expectation =
				"changes :\n" +
				"documentChanges : \n" +
				"    Foo.renametl <1> : Foo [[0, 5] .. [0, 10]]\n" +
				"    Foo [[3, 17] .. [3, 22]]\n" +
				"";
		assertEquals(expectation.toString(), toExpectation(workspaceEdit));
	}

	@Override
	protected InitializeResult initialize() {
		return super.initialize((InitializeParams params) -> {
			ClientCapabilities clientCapabilities = new ClientCapabilities();
			WorkspaceClientCapabilities workspaceClientCapabilities = new WorkspaceClientCapabilities();
			WorkspaceEditCapabilities workspaceEditCapabilities = new WorkspaceEditCapabilities();
			workspaceEditCapabilities.setDocumentChanges(true);
			workspaceClientCapabilities.setWorkspaceEdit(workspaceEditCapabilities);
			clientCapabilities.setWorkspace(workspaceClientCapabilities);
			TextDocumentClientCapabilities textDocumentClientCapabilities = new TextDocumentClientCapabilities();
			textDocumentClientCapabilities.setRename(new RenameCapabilities(true, false));
			clientCapabilities.setTextDocument(textDocumentClientCapabilities);
			params.setCapabilities(clientCapabilities);
		});
	}
}
