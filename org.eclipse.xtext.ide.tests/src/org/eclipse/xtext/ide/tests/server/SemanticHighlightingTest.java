/**
 * Copyright (c) 2018, 2020 TypeFox and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.eclipse.lsp4j.ClientCapabilities;
import org.eclipse.lsp4j.DidChangeTextDocumentParams;
import org.eclipse.lsp4j.InitializeParams;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.lsp4j.SemanticHighlightingCapabilities;
import org.eclipse.lsp4j.SemanticHighlightingInformation;
import org.eclipse.lsp4j.TextDocumentClientCapabilities;
import org.eclipse.lsp4j.TextDocumentContentChangeEvent;
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier;
import org.eclipse.xtext.ide.server.UriExtensions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

@Deprecated
public class SemanticHighlightingTest extends AbstractTestLangLanguageServerTest {
	@Inject
	private UriExtensions uriExtensions;

	private List<List<String>> scopes;

	@Before
	public void before() {
		scopes = initialize((InitializeParams it) -> {
			ClientCapabilities clientCapabilities = new ClientCapabilities();
			TextDocumentClientCapabilities textDocumentClientCapabilities = new TextDocumentClientCapabilities();
			textDocumentClientCapabilities
					.setSemanticHighlightingCapabilities(new SemanticHighlightingCapabilities(true));
			clientCapabilities.setTextDocument(textDocumentClientCapabilities);
			it.setCapabilities(clientCapabilities);
		}).getCapabilities().getSemanticHighlighting().getScopes();
	}

	@Test
	public void testDidOpen() {
		File file = root.toPath().resolve("MyModel." + fileExtension).toFile();
		String uri = uriExtensions.toUriString(file.toURI());
		String model =
				"type A {\n" +
				"  int a\n" +
				"  op foo() {}\n" +
				"  op foo(a: A): string {}\n" +
				"}";
		open(uri, model);
		String expected =
				"0 : [5:1:[typeDeclaration]]\n" +
				"1 : [2:3:[primitiveType], 6:1:[identifier]]\n" +
				"2 : [5:3:[identifier]]\n" +
				"3 : [5:3:[identifier], 9:1:[parameterName], 12:1:[type], 16:6:[primitiveType]]\n" +
				"4 : []";
		assertInfos(uri, expected);
	}

	@Test
	public void testDidOpen_multiLine() {
		File file = root.toPath().resolve("MyModel." + fileExtension).toFile();
		String uri = uriExtensions.toUriString(file.toURI());
		String model =
				"type A {\n" +
				"  op foo() { \n" +
				"  \n" +
				"    \n" +
				"  }\n" +
				"}";
		open(uri, model);
		String expected =
				"0 : [5:1:[typeDeclaration]]\n" +
				"1 : [5:3:[identifier], 12:1:[opBody]]\n" +
				"2 : [0:2:[opBody]]\n" +
				"3 : [0:4:[opBody]]\n" +
				"4 : [0:2:[opBody]]\n" +
				"5 : []";
		assertInfos(uri, expected);
	}

	@Test
	public void testChange() {
		File file = root.toPath().resolve("MyModel." + fileExtension).toFile();
		String fileUri = uriExtensions.toUriString(file.toURI());
		String model =
				"type A {\n" +
				"  int a\n" +
				"  op foo() {}\n" +
				"  op foo(a: A): string {}\n" +
				"}";
		open(fileUri, model);
		notifications.clear();
		DidChangeTextDocumentParams didChangeTextDocumentParams1 = new DidChangeTextDocumentParams();
		didChangeTextDocumentParams1.setTextDocument(new VersionedTextDocumentIdentifier(fileUri, 2));
		TextDocumentContentChangeEvent textDocumentContentChangeEvent1 = new TextDocumentContentChangeEvent();
		String change1 =
				"type A {\n" +
				"  int a\n" +
				"  op foo(a: A): string {}\n" +
				"}";
		textDocumentContentChangeEvent1.setText(change1);
		textDocumentContentChangeEvent1.setRange(new Range(new Position(0, 0), new Position(4, 1)));
		didChangeTextDocumentParams1.setContentChanges(Lists.newArrayList(textDocumentContentChangeEvent1));
		languageServer.didChange(didChangeTextDocumentParams1);
		String expected1 =
				"0 : [5:1:[typeDeclaration]]\n" +
				"1 : [2:3:[primitiveType], 6:1:[identifier]]\n" +
				"2 : [5:3:[identifier], 9:1:[parameterName], 12:1:[type], 16:6:[primitiveType]]\n" +
				"3 : []";
		assertInfos(fileUri, expected1);
		notifications.clear();
		DidChangeTextDocumentParams didChangeTextDocumentParams2 = new DidChangeTextDocumentParams();
		didChangeTextDocumentParams2.setTextDocument(new VersionedTextDocumentIdentifier(fileUri, 3));
		TextDocumentContentChangeEvent textDocumentContentChangeEvent2 = new TextDocumentContentChangeEvent();
		String change2 =
				"type A {\n" +
				"  int a\n" +
				"}";
		textDocumentContentChangeEvent2.setText(change2);
		textDocumentContentChangeEvent2.setRange(new Range(new Position(0, 0), new Position(3, 1)));
		didChangeTextDocumentParams2.setContentChanges(Lists.newArrayList(textDocumentContentChangeEvent2));
		languageServer.didChange(didChangeTextDocumentParams2);
		String expected2 =
				"0 : [5:1:[typeDeclaration]]\n" +
				"1 : [2:3:[primitiveType], 6:1:[identifier]]\n" +
				"2 : []";
		assertInfos(fileUri, expected2);
		notifications.clear();
		DidChangeTextDocumentParams didChangeTextDocumentParams3 = new DidChangeTextDocumentParams();
		didChangeTextDocumentParams3.setTextDocument(new VersionedTextDocumentIdentifier(fileUri, 3));
		TextDocumentContentChangeEvent textDocumentContentChangeEvent3 = new TextDocumentContentChangeEvent();
		String change3 =
				"type A {\n" +
				"  int a\n" +
				"  op foo() {}\n" +
				"  op foo(a: A): string {}\n" +
				"}";
		textDocumentContentChangeEvent3.setText(change3);
		textDocumentContentChangeEvent3.setRange(new Range(new Position(0, 0), new Position(2, 1)));
		didChangeTextDocumentParams3.setContentChanges(Lists.newArrayList(textDocumentContentChangeEvent3));
		languageServer.didChange(didChangeTextDocumentParams3);
		String expected3 =
				"0 : [5:1:[typeDeclaration]]\n" +
				"1 : [2:3:[primitiveType], 6:1:[identifier]]\n" +
				"2 : [5:3:[identifier]]\n" +
				"3 : [5:3:[identifier], 9:1:[parameterName], 12:1:[type], 16:6:[primitiveType]]\n" +
				"4 : []";
		assertInfos(fileUri, expected3);
	}

	protected void assertInfos(String uri, String expected) {
		Map<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>> params = getSemanticHighlightingParams();
		Assert.assertEquals(1, params.size());
		Map.Entry<VersionedTextDocumentIdentifier, List<SemanticHighlightingInformation>> entry = IterableExtensions
				.findFirst(params.entrySet(), it -> Objects.equal(it.getKey().getUri(), uri));
		Assert.assertNotNull(entry);
		String actual = Joiner.on("\n")
				.join(Lists.transform(Lists.transform(
						IterableExtensions.sortWith(entry.getValue(),
								(SemanticHighlightingInformation left,
										SemanticHighlightingInformation right) -> left.getLine()- right.getLine()),
						it -> Pair.of(it, scopes)), it -> toExpectation(it)));
		assertEquals(expected, actual);
	}
}
