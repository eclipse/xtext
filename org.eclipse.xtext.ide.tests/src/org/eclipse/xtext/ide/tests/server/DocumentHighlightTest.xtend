/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.server

import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightKind
import org.eclipse.lsp4j.Position
import org.eclipse.xtext.ide.server.occurrences.IDocumentHighlightService
import org.junit.Test

/**
 * Class for testing the {@link DocumentHighlightService document highlight
 * service} behavior through the language server.
 * 
 * <p>
 * The string representation of on single {@link DocumentHighlight highlight}
 * instance is represented with the below pattern:
 * 
 * <pre>
 * R|W|T [{d}+, {d}+] .. [{d}+, {d}+]
 * </pre>
 * 
 * where the first character describes the {@link DocumentHighlightKind kind} of
 * the document highlight. If missing, then the value is {@code NaN}. The values
 * between the first square brackets are the start {@link Position#getLine()
 * line} and the (zero-based) {@link Position#getCharacter() character offset}
 * in the line. The second square brackets contains the end position of the
 * selection and described with the same semantics as the first start range.
 * Multiple highlight instances are separated by the {@code |} ("pipe")
 * character.
 * 
 * @author akos.kitta - Initial contribution and API
 * 
 * @see DocumentHighlight
 * @see IDocumentHighlightService
 */
class DocumentHighlightTest extends AbstractTestLangLanguageServerTest {

	@Test
	def void singleLineNoOccurrences_SelectionBeforeWriteSiteMethodName() {
		testDocumentHighlight[
			model = '''type A { op foo() { } }''';
			column = '''type A { op'''.length;
			expectedDocumentHighlight = '';
		];
	}
	
	@Test
	def void singleLineNoOccurrences_SelectionAfterWriteSiteMethodName() {
		testDocumentHighlight[
			model = '''type A { op foo() { } }''';
			column = '''type A { op foo('''.length;
			expectedDocumentHighlight = '';
		];
	}

	@Test
	def void singleLineSingleOccurrence() {
		testDocumentHighlight[
			model = '''type A { op foo() { } }''';
			column = '''type A { op fo'''.length;
			expectedDocumentHighlight = 'W [[0, 12] .. [0, 15]]';
		];
	}

	@Test
	def void singleLineSingleOccurrenceWithVariable() {
		testDocumentHighlight[
			model = '''type A { int foo op foo() { } }''';
			column = '''type A { int fo'''.length;
			expectedDocumentHighlight = 'W [[0, 13] .. [0, 16]]';
		];
	}

	@Test
	def void singleLineSingleOccurrenceWithMultipleTypes() {
		testDocumentHighlight[
			model = '''type A { op foo() { } } type B { op foo() { } }''';
			column = '''type A { op fo'''.length;
			expectedDocumentHighlight = 'W [[0, 12] .. [0, 15]]';
		];
	}

	@Test
	def void singleLineMultipleOccurrences_SelectionOnReadSite() {
		testDocumentHighlight[
			model = '''type A { op foo() { } op bar() { foo(10) } }''';
			line = 0;
			column = '''type A { op foo() { } op bar() { fo'''.length;
			expectedDocumentHighlight = 'W [[0, 12] .. [0, 15]] | R [[0, 33] .. [0, 36]]';
		];
	}

	@Test
	def void singleLineMultipleOccurrences_SelectionOnWriteSite() {
		testDocumentHighlight[
			model = '''type A { op foo() { } op bar() { foo(10) } }''';
			line = 0;
			column = '''type A { op fo'''.length;
			expectedDocumentHighlight = 'W [[0, 12] .. [0, 15]] | R [[0, 33] .. [0, 36]]';
		];
	}

	@Test
	def void multipleLinesMultipleOccurrences_WithHorizontalTabs() {
		testDocumentHighlight[
//			This snippet contains horizontal tabs for code indentation
			model = '''
			type A {
				op foo() { }
				op bar() {
					foo(10)
				}
			}''';
			line = 1;
			// Same as above, horizontal tabs for code indentation
			column = '''	op fo'''.length;
			expectedDocumentHighlight = 'W [[1, 4] .. [1, 7]] | R [[3, 2] .. [3, 5]]';
		];
	}

	@Test
	def void multipleLinesMultipleOccurrences_WithWhitespaces() {
		testDocumentHighlight[
//			This snippet contains spaces for code indentation
			model = '''
			type A {
			    op foo() { }
			    op bar() {
			        foo(10)
			    }
			}''';
			line = 1;
			// Same as above, spaces for code indentation
			column = '''    op fo'''.length;
			expectedDocumentHighlight = 'W [[1, 7] .. [1, 10]] | R [[3, 8] .. [3, 11]]';
		];
	}

}
