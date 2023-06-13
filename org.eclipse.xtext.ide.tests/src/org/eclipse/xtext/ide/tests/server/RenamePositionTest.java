/**
 * Copyright (c) 2019, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.PrepareRenameDefaultBehavior;
import org.eclipse.lsp4j.PrepareRenameParams;
import org.eclipse.lsp4j.PrepareRenameResult;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.RenameCapabilities;
import org.eclipse.lsp4j.RenameParams;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.WorkspaceClientCapabilities;
import org.eclipse.lsp4j.WorkspaceEdit;
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException;
import org.eclipse.lsp4j.jsonrpc.messages.Either3;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.testing.AbstractLanguageServerTest;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Throwables;

/**
 * @author koehnlein - Initial contribution and API
 */
public class RenamePositionTest extends AbstractLanguageServerTest {
	public RenamePositionTest() {
		super("renametl");
	}

	@Test
	public void testRenameBeginningOfFile() {
		renameAndFail("type Test", new Position(0, 0), "No element found at position");
	}

	@Test
	public void testRenameNameAtEndOfFile() throws Exception {
		String model = "type Test";
		renameWithSuccess(model, new Position(0, model.length()));
	}

	@Test
	public void testBeyondBeginningOfFile() {
		renameAndFail("type Test", new Position(-1, 0), "");
	}

	@Test
	public void testRenameBeyondLine() {
		String model =
				"type Test\n" +
				"{}\n";
		renameAndFail(model, new Position(0, 11), "Invalid document position");
	}

	@Test
	public void testBeyondEndOfFile() {
		String model = "type Test";
		renameAndFail(model, new Position(0, model.length()+ 1), "Invalid document position");
	}

	@Test
	public void testRenameAtBraceAfterIdentifier() throws Exception {
		String model = "type Test{}";
		renameWithSuccess(model, new Position(0, model.indexOf("{")));
	}

	@Test
	public void testRenameAtBrace() {
		String model = "type Test{}";
		renameAndFail(model, new Position(0, model.indexOf("}")), "No element found at position");
	}

	protected void renameAndFail(String model, Position position, String messageFragment) {
		String modelFile = writeFile("MyType.testlang", model);
		initialize();
		try {
			TextDocumentIdentifier identifier = new TextDocumentIdentifier(modelFile);
			Either3<Range, PrepareRenameResult, PrepareRenameDefaultBehavior> prepareRenameResult = languageServer
					.prepareRename(new PrepareRenameParams(identifier, position)).get();
			Assert.assertNull("expected null result got " + prepareRenameResult + " instead", prepareRenameResult);
			RenameParams renameParams = new RenameParams(new TextDocumentIdentifier(modelFile), position, "Tescht");
			languageServer.rename(renameParams).get();
			Assert.fail("Rename should have failed");
		} catch (Exception exc) {
			Throwable rootCause = Throwables.getRootCause(exc);
			Assert.assertTrue(rootCause instanceof ResponseErrorException);
			ResponseError error = ((ResponseErrorException) rootCause).getResponseError();
			Assert.assertTrue(error.getData().toString().contains(messageFragment));
		}
	}

	protected void renameWithSuccess(String model, Position position) throws Exception {
		String modelFile = writeFile("MyType.testlang", model);
		initialize((InitializeParams params) -> {
			ClientCapabilities clientCapabilities = new ClientCapabilities();
			WorkspaceClientCapabilities workspaceCapabilities = new WorkspaceClientCapabilities();
			workspaceCapabilities.setWorkspaceFolders(true);
			clientCapabilities.setWorkspace(workspaceCapabilities);
			TextDocumentClientCapabilities textDocumentClientCapabilities = new TextDocumentClientCapabilities();
			textDocumentClientCapabilities.setRename(new RenameCapabilities(true, false));
			clientCapabilities.setTextDocument(textDocumentClientCapabilities);
			params.setCapabilities(clientCapabilities);
		});
		TextDocumentIdentifier identifier = new TextDocumentIdentifier(modelFile);
		Range range = languageServer.prepareRename(new PrepareRenameParams(identifier, position)).get().getLeft();
		Assert.assertNotNull(range);
		assertEquals(new Document(Integer.valueOf(0), model).getSubstring(range), "Test");
		RenameParams params = new RenameParams(identifier, position, "Tescht");
		WorkspaceEdit workspaceEdit = languageServer.rename(params).get();
		String expectation =
				"changes :\n" +
				"	MyType.testlang : Tescht [[0, 5] .. [0, 9]]\n" +
				"documentChanges : \n";
		assertEquals(expectation.toString(),
				toExpectation(workspaceEdit));
	}
}
