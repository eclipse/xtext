/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.util;

import java.util.List;

import org.eclipse.lsp4j.DocumentHighlight;
import org.eclipse.lsp4j.DocumentHighlightKind;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.util.DocumentHighlightComparator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Test for the null-safe {@link DocumentHighlightComparator}.
 * 
 * <p>
 * This test focuses on the {@link DocumentHighlightKind} and the null-safety.
 * Other orderings are checked via the {@link RangeComparatorTest}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
public class DocumentHighlightComparatorTest extends Assert {
	@Inject
	private DocumentHighlightComparator comparator;

	@Test
	public void withoutNull() {
		List<? extends DocumentHighlight> input = sort(
				Lists.newArrayList(newHighlight(DocumentHighlightKind.Text, newRange(2, 2, 2, 2)),
						newHighlight(DocumentHighlightKind.Text, newRange(1, 1, 1, 1)),
						newHighlight(DocumentHighlightKind.Write, newRange(2, 2, 2, 2)),
						newHighlight(DocumentHighlightKind.Write, newRange(1, 1, 1, 1)),
						newHighlight(DocumentHighlightKind.Read, newRange(2, 2, 2, 2)),
						newHighlight(DocumentHighlightKind.Read, newRange(1, 1, 1, 1))));
		assertEquals(1, input.get(0).getRange().getStart().getLine());
		assertEquals(1, input.get(0).getRange().getStart().getCharacter());
		assertEquals(1, input.get(0).getRange().getEnd().getLine());
		assertEquals(1, input.get(0).getRange().getEnd().getCharacter());
		assertEquals(DocumentHighlightKind.Text, input.get(0).getKind());
		assertEquals(1, input.get(1).getRange().getStart().getLine());
		assertEquals(1, input.get(1).getRange().getStart().getCharacter());
		assertEquals(1, input.get(1).getRange().getEnd().getLine());
		assertEquals(1, input.get(1).getRange().getEnd().getCharacter());
		assertEquals(DocumentHighlightKind.Read, input.get(1).getKind());
		assertEquals(1, input.get(2).getRange().getStart().getLine());
		assertEquals(1, input.get(2).getRange().getStart().getCharacter());
		assertEquals(1, input.get(2).getRange().getEnd().getLine());
		assertEquals(1, input.get(2).getRange().getEnd().getCharacter());
		assertEquals(DocumentHighlightKind.Write, input.get(2).getKind());
		assertEquals(2, input.get(3).getRange().getStart().getLine());
		assertEquals(2, input.get(3).getRange().getStart().getCharacter());
		assertEquals(2, input.get(3).getRange().getEnd().getLine());
		assertEquals(2, input.get(3).getRange().getEnd().getCharacter());
		assertEquals(DocumentHighlightKind.Text, input.get(3).getKind());
		assertEquals(2, input.get(4).getRange().getStart().getLine());
		assertEquals(2, input.get(4).getRange().getStart().getCharacter());
		assertEquals(2, input.get(4).getRange().getEnd().getLine());
		assertEquals(2, input.get(4).getRange().getEnd().getCharacter());
		assertEquals(DocumentHighlightKind.Read, input.get(4).getKind());
		assertEquals(2, input.get(5).getRange().getStart().getLine());
		assertEquals(2, input.get(5).getRange().getStart().getCharacter());
		assertEquals(2, input.get(5).getRange().getEnd().getLine());
		assertEquals(2, input.get(5).getRange().getEnd().getCharacter());
		assertEquals(DocumentHighlightKind.Write, input.get(5).getKind());
	}

	@Test
	public void withNull() {
		List<? extends DocumentHighlight> input = sort(
				Lists.newArrayList(null, newHighlight(DocumentHighlightKind.Text, newRange(1, 1, 1, 1)),
						newHighlight(DocumentHighlightKind.Write, newRange(1, 1, 1, 1)),
						newHighlight(DocumentHighlightKind.Read, newRange(1, 1, 1, 1))));
		assertEquals(1, input.get(0).getRange().getStart().getLine());
		assertEquals(1, input.get(0).getRange().getStart().getCharacter());
		assertEquals(1, input.get(0).getRange().getEnd().getLine());
		assertEquals(1, input.get(0).getRange().getEnd().getCharacter());
		assertEquals(DocumentHighlightKind.Text, input.get(0).getKind());
		assertEquals(1, input.get(1).getRange().getStart().getLine());
		assertEquals(1, input.get(1).getRange().getStart().getCharacter());
		assertEquals(1, input.get(1).getRange().getEnd().getLine());
		assertEquals(1, input.get(1).getRange().getEnd().getCharacter());
		assertEquals(DocumentHighlightKind.Read, input.get(1).getKind());
		assertEquals(1, input.get(2).getRange().getStart().getLine());
		assertEquals(1, input.get(2).getRange().getStart().getCharacter());
		assertEquals(1, input.get(2).getRange().getEnd().getLine());
		assertEquals(1, input.get(2).getRange().getEnd().getCharacter());
		assertEquals(DocumentHighlightKind.Write, input.get(2).getKind());
		assertNull(IterableExtensions.lastOrNull(input));
	}

	private DocumentHighlight newHighlight(DocumentHighlightKind kind, Range range) {
		return new DocumentHighlight(range, kind);
	}

	private Range newRange(int startLine, int startChar, int endLine, int endChar) {
		return new Range(new Position(startLine, startChar), new Position(endLine, endChar));
	}

	private List<? extends DocumentHighlight> sort(List<? extends DocumentHighlight> toSort) {
		toSort.sort(comparator);
		return toSort;
	}
}
