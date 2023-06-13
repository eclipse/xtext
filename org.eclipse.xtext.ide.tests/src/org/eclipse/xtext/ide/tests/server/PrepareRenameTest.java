/**
 * Copyright (c) 2019, 2020 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.io.File;
import java.io.FileNotFoundException;

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
import org.eclipse.lsp4j.jsonrpc.ResponseErrorException;
import org.eclipse.lsp4j.jsonrpc.messages.ResponseError;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Throwables;
import com.google.inject.Inject;

public class PrepareRenameTest extends AbstractTestLangLanguageServerTest {
	@Inject
	private UriExtensions uriExtensions;

	@Test
	public void testRenameFqn_missing_file_null() throws Exception {
		String uri = uriExtensions.toUriString(new File("missing." + fileExtension).toURI().normalize());
		initializeWithPrepareSupport();
		RenameParams params = new RenameParams(new TextDocumentIdentifier(uri), new Position(2, 5), "Does not matter");
		Assert.assertNull(languageServer.rename(params).get());
	}

	@Test
	public void testPrepareRenameFqn_missing_file_null() throws Exception {
		String uri = uriExtensions.toUriString(new File("missing." + fileExtension).toURI().normalize());
		initializeWithPrepareSupport();
		PrepareRenameParams params = new PrepareRenameParams(new TextDocumentIdentifier(uri), new Position(2, 5));
		Assert.assertNull(languageServer.prepareRename(params).get());
	}

	@Test
	public void testPrepareRenameFqn_missing_file_exception() throws Exception {
		String uri = uriExtensions.toUriString(new File("missing." + fileExtension).toURI().normalize());
		initialize();
		PrepareRenameParams params = new PrepareRenameParams(new TextDocumentIdentifier(uri), new Position(2, 5));
		try {
			Assert.assertNull(languageServer.prepareRename(params).get());
			Assert.fail("Expected an error.");
		} catch (Exception e) {
			Assert.assertTrue(Throwables.getRootCause(e) instanceof FileNotFoundException);
		}
	}

	@Test
	public void testRenameFqn_invalid_error() throws Exception {
		String model =
				"package foo.bar {\n" +
				"  type A {\n" +
				"    foo.bar.MyType bar\n" +
				"  }\n" +
				"  type MyType { }\n" +
				"}\n";
		String uri = writeFile("my-type-invalid.testlang", model);
		initialize();
		RenameParams params = new RenameParams(new TextDocumentIdentifier(uri), new Position(2, 5), "Does not matter");
		try {
			languageServer.rename(params).get();
			Assert.fail(
					"Expected an expcetion when trying to rename document but got a valid workspace edit instead: «workspaceEdit»");
		} catch (Exception e) {
			Throwable rootCause = Throwables.getRootCause(e);
			Assert.assertTrue(rootCause instanceof ResponseErrorException);
			ResponseError error = ((ResponseErrorException) rootCause).getResponseError();
			Assert.assertTrue(error.getData().toString().contains("No element found at position"));
		}
	}

	@Test
	public void testRenameFqn_invalid_null() throws Exception {
		String model =
				"package foo.bar {\n" +
				"  type A {\n" +
				"    foo.bar.MyType bar\n" +
				"  }\n" +
				"  type MyType { }\n" +
				"}\n";
		String uri = writeFile("my-type-invalid.testlang", model);
		initializeWithPrepareSupport();
		RenameParams params = new RenameParams(new TextDocumentIdentifier(uri), new Position(2, 5), "Does not matter");
		Assert.assertNull(languageServer.rename(params).get());
	}

	@Test
	public void testRenameFqn_before_ok() throws Exception {
		String model =
				"package foo.bar {\n" +
				"  type A {\n" +
				"    foo.bar.MyType bar\n" +
				"  }\n" +
				"  type MyType { }\n" +
				"}\n";
		String uri = writeFile(
				"my-type-valid.testlang",
				model);
		initializeWithPrepareSupport();
		RenameParams params = new RenameParams(new TextDocumentIdentifier(uri), new Position(2, 13), "YourType");
		WorkspaceEdit workspaceEdit = languageServer.rename(params).get();
		String expectation =
				"changes :\n" +
				"	my-type-valid.testlang : foo.bar.YourType [[2, 4] .. [2, 18]]\n" +
				"	YourType [[4, 7] .. [4, 13]]\n" +
				"documentChanges : \n";
		assertEquals(expectation.toString(), toExpectation(workspaceEdit));
	}

	@Test
	public void testPrepareRenameFqn_before_nok() throws Exception {
		String model =
				"package foo.bar {\n" +
				"  type A {\n" +
				"    foo.bar.MyType bar\n" +
				"  }\n" +
				"  type MyType { }\n" +
				"}\n";
		initializeWithPrepareSupport();
		String uri = writeFile("my-type-valid.testlang", model);
		PrepareRenameParams params = new PrepareRenameParams(new TextDocumentIdentifier(uri), new Position(2, 11));
		Assert.assertNull(languageServer.prepareRename(params).get());
	}

	@Test
	public void testPrepareRenameFqn_start_ok() throws Exception {
		String model =
				"package foo.bar {\n" +
				"  type A {\n" +
				"    foo.bar.MyType bar\n" +
				"  }\n" +
				"  type MyType { }\n" +
				"}\n";
		initializeWithPrepareSupport();
		String uri = writeFile("my-type-valid.testlang", model);
		PrepareRenameParams params = new PrepareRenameParams(new TextDocumentIdentifier(uri), new Position(2, 12));
		Range range = languageServer.prepareRename(params).get().getLeft();
		assertEquals("MyType", new Document(0, model).getSubstring(range));
	}

	@Test
	public void testPrepareRenameFqn_in_ok() throws Exception {
		String model =
				"package foo.bar {\n" +
				"  type A {\n" +
				"    foo.bar.MyType bar\n" +
				"  }\n" +
				"  type MyType { }\n" +
				"}\n";
		initializeWithPrepareSupport();
		String uri = writeFile("my-type-valid.testlang", model);
		PrepareRenameParams params = new PrepareRenameParams(new TextDocumentIdentifier(uri), new Position(2, 14));
		Range range = languageServer.prepareRename(params).get().getLeft();
		assertEquals("MyType", new Document(0, model).getSubstring(range));
	}

	@Test
	public void testPrepareRenameFqn_end_ok() throws Exception {
		String model =
				"package foo.bar {\n" +
				"  type A {\n" +
				"    foo.bar.MyType bar\n" +
				"  }\n" +
				"  type MyType { }\n" +
				"}\n";
		initializeWithPrepareSupport();
		String uri = writeFile("my-type-valid.testlang", model);
		PrepareRenameParams params = new PrepareRenameParams(new TextDocumentIdentifier(uri), new Position(2, 18));
		Range range = languageServer.prepareRename(params).get().getLeft();
		assertEquals("MyType", new Document(0, model).getSubstring(range));
	}

	@Test
	public void testPrepareRenameFqn_end_null() throws Exception {
		String model =
				"package foo.bar {\n" +
				"  type A {\n" +
				"    foo.bar.MyType bar\n" +
				"  }\n" +
				"  type MyType { }\n" +
				"}\n";
		initialize();
		String uri = writeFile("my-type-valid.testlang", model);
		PrepareRenameParams params = new PrepareRenameParams(new TextDocumentIdentifier(uri), new Position(2, 18));
		Assert.assertNull(languageServer.prepareRename(params).get());
	}

	private InitializeResult initializeWithPrepareSupport() {
		return super.initialize((InitializeParams params) -> {
			ClientCapabilities clientCapabilities = new ClientCapabilities();
			WorkspaceClientCapabilities workspaceClientCapabilities = new WorkspaceClientCapabilities();
			workspaceClientCapabilities.setWorkspaceFolders(true);
			clientCapabilities.setWorkspace(workspaceClientCapabilities);
			TextDocumentClientCapabilities textDocumentClientCapabilities = new TextDocumentClientCapabilities();
			textDocumentClientCapabilities.setRename(new RenameCapabilities(true, false));
			clientCapabilities.setTextDocument(textDocumentClientCapabilities);
			params.setCapabilities(clientCapabilities);
		});
	}
}
