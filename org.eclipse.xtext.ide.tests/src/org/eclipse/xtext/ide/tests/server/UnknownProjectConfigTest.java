/**
 * Copyright (c) 2017, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.eclipse.lsp4j.CompletionItem;
import org.eclipse.lsp4j.CompletionList;
import org.eclipse.lsp4j.CompletionParams;
import org.eclipse.lsp4j.DidOpenTextDocumentParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.TextDocumentIdentifier;
import org.eclipse.lsp4j.TextDocumentItem;
import org.eclipse.lsp4j.jsonrpc.messages.Either;
import org.eclipse.xtext.util.Strings;
import org.junit.Test;

import com.google.common.collect.Lists;

public class UnknownProjectConfigTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void testCompletionWithInmemoryScheme_01() throws Exception {
		initialize(it -> it.setWorkspaceFolders(Lists.newArrayList()));
		String inmemoryUri = "inmemory:/mydoc.testlang";
		languageServer.didOpen(new DidOpenTextDocumentParams(newTextDocumentItem(inmemoryUri, "type Foo {}")));
		checkCompletion(inmemoryUri);
	}

	@Test
	public void testCompletionWithInmemoryScheme_02() throws Exception {
		initialize();
		String inmemoryUri = "inmemory:/mydoc.testlang";
		languageServer.didOpen(new DidOpenTextDocumentParams(newTextDocumentItem(inmemoryUri, "type Foo {}")));
		checkCompletion(inmemoryUri);
	}

	@Test
	public void testCompletionWithFileScheme_01() throws Exception {
		initialize(it -> it.setWorkspaceFolders(Lists.newArrayList()));
		String fileUri = "file:/home/test/workspace/mydoc.testlang";
		languageServer.didOpen(new DidOpenTextDocumentParams(newTextDocumentItem(fileUri, "type Foo {}")));
		checkCompletion(fileUri);
	}

	@Test
	public void testCompletionWithFileScheme_02() throws Exception {
		initialize();
		String fileUri = "file:/home/test/workspace/mydoc.testlang";
		languageServer.didOpen(new DidOpenTextDocumentParams(newTextDocumentItem(fileUri, "type Foo {}")));
		checkCompletion(fileUri);
	}

	protected TextDocumentItem newTextDocumentItem(String uri, String text) {
		TextDocumentItem result = new TextDocumentItem();
		result.setUri(uri);
		result.setText(text);
		return result;
	}

	protected void checkCompletion(String uri) throws Exception {
		CompletableFuture<Either<List<CompletionItem>, CompletionList>> completionItems = languageServer
				.completion(new CompletionParams(new TextDocumentIdentifier(uri), new Position(0, 10)));
		Either<List<CompletionItem>, CompletionList> result = completionItems.get();
		List<CompletionItem> items = null;
		if (result.isLeft()) {
			items = result.getLeft();
		} else {
			items = result.getRight().getItems();
		}
		String actualCompletionItems = Strings.toUnixLineSeparator(toExpectation(items));
		String expectedCompletionItems = 
				"Foo (TypeDeclaration) -> Foo [[0, 10] .. [0, 10]]\n" +
				"boolean -> boolean [[0, 10] .. [0, 10]]\n" +
				"int -> int [[0, 10] .. [0, 10]]\n" +
				"op -> op [[0, 10] .. [0, 10]]\n" +
				"string -> string [[0, 10] .. [0, 10]]\n" +
				"void -> void [[0, 10] .. [0, 10]]\n" +
				"} -> } [[0, 10] .. [0, 10]]\n" +
				"{ -> { [[0, 9] .. [0, 10]]\n" +
				"   + } [[0, 11] .. [0, 11]]\n";
		assertEquals(expectedCompletionItems, actualCompletionItems);
	}
}
