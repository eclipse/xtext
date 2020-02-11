/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.util

import com.google.inject.Inject
import java.util.List
import org.eclipse.lsp4j.DocumentHighlight
import org.eclipse.lsp4j.DocumentHighlightKind
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider
import org.eclipse.xtext.ide.util.DocumentHighlightComparator
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.lsp4j.DocumentHighlightKind.*

/**
 * Test for the null-safe {@link DocumentHighlightComparator}.
 * 
 * <p>
 * This test focuses on the {@link DocumentHighlightKind} and the null-safety
 * other orderings are checked via the {@link RangeComparatorTest}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(TestLanguageIdeInjectorProvider)
class DocumentHighlightComparatorTest extends Assert {

	@Inject
	DocumentHighlightComparator comparator;

	@Test
	def void withoutNull() {
		val input = newArrayList(Text.newHighlight(newRange(2, 2, 2, 2)), Text.newHighlight(newRange(1, 1, 1, 1)),
			Write.newHighlight(newRange(2, 2, 2, 2)), Write.newHighlight(newRange(1, 1, 1, 1)),
			Read.newHighlight(newRange(2, 2, 2, 2)), Read.newHighlight(newRange(1, 1, 1, 1))).sort;

		assertEquals(1, input.get(0).range.start.line);
		assertEquals(1, input.get(0).range.start.character);
		assertEquals(1, input.get(0).range.end.line);
		assertEquals(1, input.get(0).range.end.character);
		assertEquals(Text, input.get(0).kind);

		assertEquals(1, input.get(1).range.start.line);
		assertEquals(1, input.get(1).range.start.character);
		assertEquals(1, input.get(1).range.end.line);
		assertEquals(1, input.get(1).range.end.character);
		assertEquals(Read, input.get(1).kind);

		assertEquals(1, input.get(2).range.start.line);
		assertEquals(1, input.get(2).range.start.character);
		assertEquals(1, input.get(2).range.end.line);
		assertEquals(1, input.get(2).range.end.character);
		assertEquals(Write, input.get(2).kind);

		assertEquals(2, input.get(3).range.start.line);
		assertEquals(2, input.get(3).range.start.character);
		assertEquals(2, input.get(3).range.end.line);
		assertEquals(2, input.get(3).range.end.character);
		assertEquals(Text, input.get(3).kind);

		assertEquals(2, input.get(4).range.start.line);
		assertEquals(2, input.get(4).range.start.character);
		assertEquals(2, input.get(4).range.end.line);
		assertEquals(2, input.get(4).range.end.character);
		assertEquals(Read, input.get(4).kind);

		assertEquals(2, input.get(5).range.start.line);
		assertEquals(2, input.get(5).range.start.character);
		assertEquals(2, input.get(5).range.end.line);
		assertEquals(2, input.get(5).range.end.character);
		assertEquals(Write, input.get(5).kind);
	}

	@Test
	def void withNull() {
		val input = newArrayList(null, Text.newHighlight(newRange(1, 1, 1, 1)),
			Write.newHighlight(newRange(1, 1, 1, 1)), Read.newHighlight(newRange(1, 1, 1, 1))).sort;

		assertEquals(1, input.get(0).range.start.line);
		assertEquals(1, input.get(0).range.start.character);
		assertEquals(1, input.get(0).range.end.line);
		assertEquals(1, input.get(0).range.end.character);
		assertEquals(Text, input.get(0).kind);

		assertEquals(1, input.get(1).range.start.line);
		assertEquals(1, input.get(1).range.start.character);
		assertEquals(1, input.get(1).range.end.line);
		assertEquals(1, input.get(1).range.end.character);
		assertEquals(Read, input.get(1).kind);

		assertEquals(1, input.get(2).range.start.line);
		assertEquals(1, input.get(2).range.start.character);
		assertEquals(1, input.get(2).range.end.line);
		assertEquals(1, input.get(2).range.end.character);
		assertEquals(Write, input.get(2).kind);

		assertNull(input.last);
	}

	private def newHighlight(DocumentHighlightKind kind, Range range) {
		new DocumentHighlight(range, kind);
	}

	private def newRange(int startLine, int startChar, int endLine, int endChar) {
		return new Range(new Position(startLine, startChar), new Position(endLine, endChar));
	}

	private def sort(List<? extends DocumentHighlight> toSort) {
		toSort.sort(comparator);
		return toSort;
	}

}
