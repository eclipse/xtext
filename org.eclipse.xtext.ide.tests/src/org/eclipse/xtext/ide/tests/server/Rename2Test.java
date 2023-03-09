/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
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
public class Rename2Test extends AbstractLanguageServerTest {
	public Rename2Test() {
		super("fileawaretestlanguage");
	}

	@Test
	public void testRenameSelfRef() throws Exception {
		String model =
				"package foo\n" +
				"\n" +
				"element Foo {\n" +
				" ref Foo\n" +
				"}\n";
		String file = writeFile("foo/Foo.fileawaretestlanguage", model);
		initialize();
		TextDocumentIdentifier identifier = new TextDocumentIdentifier(file);
		Position position = new Position(2, 9);
		Range range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get().getLeft();
		assertEquals("Foo", new Document(0, model).getSubstring(range));
		RenameParams params = new RenameParams(identifier, position, "Bar");
		WorkspaceEdit workspaceEdit = languageServer.rename(params).get();
		String expectation =
				"changes :\n" +
				"documentChanges : \n" +
				"    Foo.fileawaretestlanguage <1> : Bar [[2, 8] .. [2, 11]]\n" +
				"    Bar [[3, 5] .. [3, 8]]\n";
		assertEquals(
				expectation
						.toString(),
				toExpectation(workspaceEdit));
	}

	@Test
	public void testRenameContainer() throws Exception {
		String model =
				"package foo\n" +
				"\n" +
				"element Foo {\n" +
				" element Bar {\n" +
				" }\n" +
				" ref foo.Foo.Bar\n" +
				" ref Foo.Bar\n" +
				" ref Bar\n" +
				"}\n";
		String file = writeFile("foo/Foo.fileawaretestlanguage", model);
		initialize();
		TextDocumentIdentifier identifier = new TextDocumentIdentifier(file);
		Position position = new Position(2, 9);
		Range range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get().getLeft();
		assertEquals("Foo", new Document(0, model).getSubstring(range));
		RenameParams params = new RenameParams(identifier, position, "Baz");
		WorkspaceEdit workspaceEdit = languageServer.rename(params).get();
		String expectation =
				"changes :\n" +
				"documentChanges : \n" +
				"    Foo.fileawaretestlanguage <1> : Baz [[2, 8] .. [2, 11]]\n" +
				"    Bar [[5, 5] .. [5, 16]]\n" +
				"    Bar [[6, 5] .. [6, 12]]\n";
		assertEquals(
				expectation
						.toString(),
				toExpectation(workspaceEdit));
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
