/*******************************************************************************
 * Copyright (c) 2018 TypeFox and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import com.google.inject.Inject
import java.util.List
import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.DidChangeTextDocumentParams
import org.eclipse.lsp4j.SemanticHighlightingCapabilities
import org.eclipse.lsp4j.TextDocumentClientCapabilities
import org.eclipse.lsp4j.TextDocumentContentChangeEvent
import org.eclipse.lsp4j.VersionedTextDocumentIdentifier
import org.eclipse.xtext.ide.server.UriExtensions
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.lsp4j.Range
import org.eclipse.lsp4j.Position

class SemanticHighlightingTest extends AbstractTestLangLanguageServerTest {

	@Inject
	extension UriExtensions;

	List<List<String>> scopes;

	@Before
	def void before() {
		scopes = initialize[
			capabilities = new ClientCapabilities() => [
				textDocument = new TextDocumentClientCapabilities() => [
					semanticHighlightingCapabilities = new SemanticHighlightingCapabilities() => [
						semanticHighlighting = true;
					];
				];
			];
		].capabilities.semanticHighlighting.scopes;
	}

	@Test
	def void testDidOpen() {
		val file = root.toPath.resolve('''MyModel.«fileExtension»''').toFile;
		val uri = file.toURI.toUriString;
		uri.open('''
			type A {
			  int a
			  op foo() {}
			  op foo(a: A): string {}
			}''');
		uri.assertInfos('''0 : [5:1:[typeDeclaration]]
1 : [2:3:[primitiveType], 6:1:[identifier]]
2 : [5:3:[identifier]]
3 : [5:3:[identifier], 9:1:[parameterName], 12:1:[type], 16:6:[primitiveType]]
4 : []''');
	}
	
	@Test
	def void testDidOpen_multiLine() {
		val file = root.toPath.resolve('''MyModel.«fileExtension»''').toFile;
		val uri = file.toURI.toUriString;
		uri.open('''
			type A {
			  op foo() { 
			  
			    
			  }
			}''');
		uri.assertInfos('''0 : [5:1:[typeDeclaration]]
1 : [5:3:[identifier], 12:1:[opBody]]
2 : [0:2:[opBody]]
3 : [0:4:[opBody]]
4 : [0:2:[opBody]]
5 : []''');
	}

	@Test
	def void testChange() {
		val file = root.toPath.resolve('''MyModel.«fileExtension»''').toFile;
		val fileUri = file.toURI.toUriString;
		fileUri.open('''
			type A {
			  int a
			  op foo() {}
			  op foo(a: A): string {}
			}''');
		notifications.clear;
		// Delete line: `  op foo() { }`
		languageServer.didChange(new DidChangeTextDocumentParams => [
			textDocument = new VersionedTextDocumentIdentifier => [
				uri = fileUri;
				version = 2;
			];
			contentChanges = #[
				new TextDocumentContentChangeEvent => [
					text = '''
					type A {
					  int a
					  op foo(a: A): string {}
					}'''
					range = new Range(new Position(0, 0), new Position(4, 1))
				]
			];
		]);
		fileUri.assertInfos('''0 : [5:1:[typeDeclaration]]
1 : [2:3:[primitiveType], 6:1:[identifier]]
2 : [5:3:[identifier], 9:1:[parameterName], 12:1:[type], 16:6:[primitiveType]]
3 : []''');

		notifications.clear;
		// Delete line: `  op foo(a: A): string { }`
		languageServer.didChange(new DidChangeTextDocumentParams => [
			textDocument = new VersionedTextDocumentIdentifier => [
				uri = fileUri;
				version = 3;
			];
			contentChanges = #[
				new TextDocumentContentChangeEvent => [
					text = '''
					type A {
					  int a
					}'''
					range = new Range(new Position(0, 0), new Position(3, 1))
				]
			];
		]);
		fileUri.assertInfos('''0 : [5:1:[typeDeclaration]]
1 : [2:3:[primitiveType], 6:1:[identifier]]
2 : []''');

		notifications.clear;
		// Restore the original state.
		languageServer.didChange(new DidChangeTextDocumentParams => [
			textDocument = new VersionedTextDocumentIdentifier => [
				uri = fileUri;
				version = 3;
			];
			contentChanges = #[
				new TextDocumentContentChangeEvent => [
					text = '''
					type A {
					  int a
					  op foo() {}
					  op foo(a: A): string {}
					}'''
					range = new Range(new Position(0, 0), new Position(2, 1))
				]
			];
		]);
		fileUri.assertInfos('''0 : [5:1:[typeDeclaration]]
1 : [2:3:[primitiveType], 6:1:[identifier]]
2 : [5:3:[identifier]]
3 : [5:3:[identifier], 9:1:[parameterName], 12:1:[type], 16:6:[primitiveType]]
4 : []''');

	}

	protected def void assertInfos(String uri, String expected) {
		val params = semanticHighlightingParams;
		assertEquals(1, params.size);
		val entry = params.entrySet.findFirst[key.uri == uri];
		assertNotNull(entry);
		val actual = entry.value.sortWith[left, right|left.line - right.line].map[it -> scopes].map [
			toExpectation
		].join('\n');
		assertEquals(expected, actual);
	}

}
