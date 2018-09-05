/*******************************************************************************
 * Copyright (c) 2018 TypeFox and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.ClientCapabilities
import org.eclipse.lsp4j.DocumentSymbolCapabilities
import org.eclipse.lsp4j.InitializeParams
import org.eclipse.lsp4j.TextDocumentClientCapabilities
import org.junit.Test

class HierarchicalDocumentSymbolTest extends AbstractTestLangLanguageServerTest {

	static val (InitializeParams)=>void INITIALIZER = [
		capabilities = new ClientCapabilities() => [
			textDocument = new TextDocumentClientCapabilities() => [
				documentSymbol = new DocumentSymbolCapabilities() => [
					it.hierarchicalDocumentSymbolSupport = true;
				];
			];
		];
	];

	@Test
	def void testDocumentSymbol_01() {
		testDocumentSymbol[
			initializer = INITIALIZER
			model = '''
				type Foo {
					int bar
				}
				type Bar {
					Foo foo
				}
			'''
			expectedSymbols = '''
				symbol "Foo" {
				    kind: 7
				    range: [[0, 5] .. [0, 8]]
				    selectionRange: [[0, 0] .. [2, 1]]
				    details: 
				    deprecated: false
				    children: [
				        symbol "Foo.bar" {
				            kind: 7
				            range: [[1, 5] .. [1, 8]]
				            selectionRange: [[1, 1] .. [1, 8]]
				            details: 
				            deprecated: false
				            children: [
				                symbol "Foo.bar.int" {
				                    kind: 7
				                    range: [[1, 1] .. [1, 4]]
				                    selectionRange: [[1, 1] .. [1, 4]]
				                    details: 
				                    deprecated: false
				                }
				            ]
				        }
				    ]
				}
				symbol "Bar" {
				    kind: 7
				    range: [[3, 5] .. [3, 8]]
				    selectionRange: [[3, 0] .. [5, 1]]
				    details: 
				    deprecated: false
				    children: [
				        symbol "Bar.foo" {
				            kind: 7
				            range: [[4, 5] .. [4, 8]]
				            selectionRange: [[4, 1] .. [4, 8]]
				            details: 
				            deprecated: false
				        }
				    ]
				}
				'''
		]
	}
}
