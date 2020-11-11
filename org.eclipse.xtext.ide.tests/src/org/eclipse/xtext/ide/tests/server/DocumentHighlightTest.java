/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.server;

import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightKind;
import org.eclipse.xtext.ide.server.occurrences.IDocumentHighlightService;
import org.eclipse.xtext.testing.DocumentHighlightConfiguration;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;

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
public class DocumentHighlightTest extends AbstractTestLangLanguageServerTest {
	@Test
	public void singleLineNoOccurrences_SelectionBeforeWriteScfgeMethodName() {
		testDocumentHighlight((DocumentHighlightConfiguration cfg) -> {
			cfg.setModel("type A { op foo() { } }");
			cfg.setColumn("type A { op".length());
			cfg.setExpectedDocumentHighlight("");
		});
	}

	@Test
	public void singleLineNoOccurrences_SelectionAfterWriteSiteMethodName() {
		testDocumentHighlight((DocumentHighlightConfiguration cfg) -> {
			cfg.setModel("type A { op foo() { } }");
			cfg.setColumn("type A { op foo(".length());
			cfg.setExpectedDocumentHighlight("");
		});
	}

	@Test
	public void singleLineSingleOccurrence() {
		testDocumentHighlight((DocumentHighlightConfiguration cfg) -> {
			cfg.setModel("type A { op foo() { } }");
			cfg.setColumn("type A { op fo".length());
			cfg.setExpectedDocumentHighlight("W [[0, 12] .. [0, 15]]");
		});
	}

	@Test
	public void singleLineSingleOccurrenceWithVariable() {
		testDocumentHighlight((DocumentHighlightConfiguration cfg) -> {
			cfg.setModel("type A { int foo op foo() { } }");
			cfg.setColumn("type A { int fo".length());
			cfg.setExpectedDocumentHighlight("W [[0, 13] .. [0, 16]]");
		});
	}

	@Test
	public void singleLineSingleOccurrenceWithMultipleTypes() {
		testDocumentHighlight((DocumentHighlightConfiguration cfg) -> {
			cfg.setModel("type A { op foo() { } } type B { op foo() { } }");
			cfg.setColumn("type A { op fo".length());
			cfg.setExpectedDocumentHighlight("W [[0, 12] .. [0, 15]]");
		});
	}

	@Test
	public void singleLineMultipleOccurrences_SelectionOnReadSite() {
		testDocumentHighlight((DocumentHighlightConfiguration cfg) -> {
			cfg.setModel("type A { op foo() { } op bar() { foo(10) } }");
			cfg.setLine(0);
			cfg.setColumn("type A { op foo() { } op bar() { fo".length());
			cfg.setExpectedDocumentHighlight("W [[0, 12] .. [0, 15]] | R [[0, 33] .. [0, 36]]");
		});
	}

	@Test
	public void singleLineMultipleOccurrences_SelectionOnWriteSite() {
		testDocumentHighlight((DocumentHighlightConfiguration cfg) -> {
			cfg.setModel("type A { op foo() { } op bar() { foo(10) } }");
			cfg.setLine(0);
			cfg.setColumn("type A { op fo".length());
			cfg.setExpectedDocumentHighlight("W [[0, 12] .. [0, 15]] | R [[0, 33] .. [0, 36]]");
		});
	}

	@Test
	public void multipleLinesMultipleOccurrences_WithHorizontalTabs() {
		testDocumentHighlight((Procedure1<DocumentHighlightConfiguration>) (DocumentHighlightConfiguration cfg) -> {
			String model = 
					"type A {\n" +
					"	op foo() { }\n" +
					"	op bar() {\n" +
					"		foo(10)\n" +
					"	}\n}";
			cfg.setModel(model);
			cfg.setLine(1);
			cfg.setColumn(
				"	op fo".length()
			);
			cfg.setExpectedDocumentHighlight("W [[1, 4] .. [1, 7]] | R [[3, 2] .. [3, 5]]");
		});
	}

	@Test
	public void multipleLinesMultipleOccurrences_WithWhitespaces() {
		testDocumentHighlight((DocumentHighlightConfiguration cfg) -> {
			String model = 
					"type A {\n" +
					"    op foo() { }\n" +
					"    op bar() {\n" +
					"        foo(10)\n" +
					"    }\n" +
					"}";
			cfg.setModel(model);
			cfg.setLine(1);
			cfg.setColumn("    op fo".length());
			cfg.setExpectedDocumentHighlight("W [[1, 7] .. [1, 10]] | R [[3, 8] .. [3, 11]]");
		});
	}
}
