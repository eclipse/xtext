/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.util;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.util.List;
import org.eclipse.lsp4j.Position;
import org.eclipse.lsp4j.Range;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.util.RangeComparator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test for the null-safe {@link RangeComparator}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
public class RangeComparatorTest extends Assert {
	@Inject
	private RangeComparator comparator;

	@Test
	public void withoutNull() {
		List<? extends Range> input = sort(Lists.newArrayList(newRange(1, 2, 1, 2), newRange(1, 1, 2, 1),
				newRange(1, 1, 1, 2), newRange(1, 1, 1, 1), newRange(2, 2, 2, 3)));
		assertEquals(1, input.get(0).getStart().getLine());
		assertEquals(1, input.get(0).getStart().getCharacter());
		assertEquals(1, input.get(0).getEnd().getLine());
		assertEquals(1, input.get(0).getEnd().getCharacter());
		assertEquals(1, input.get(1).getStart().getLine());
		assertEquals(1, input.get(1).getStart().getCharacter());
		assertEquals(1, input.get(1).getEnd().getLine());
		assertEquals(2, input.get(1).getEnd().getCharacter());
		assertEquals(1, input.get(2).getStart().getLine());
		assertEquals(1, input.get(2).getStart().getCharacter());
		assertEquals(2, input.get(2).getEnd().getLine());
		assertEquals(1, input.get(2).getEnd().getCharacter());
		assertEquals(1, input.get(3).getStart().getLine());
		assertEquals(2, input.get(3).getStart().getCharacter());
		assertEquals(1, input.get(3).getEnd().getLine());
		assertEquals(2, input.get(3).getEnd().getCharacter());
		assertEquals(2, input.get(4).getStart().getLine());
		assertEquals(2, input.get(4).getStart().getCharacter());
		assertEquals(2, input.get(4).getEnd().getLine());
		assertEquals(3, input.get(4).getEnd().getCharacter());
	}

	@Test
	public void withNull() {
		List<? extends Range> input = sort(Lists.newArrayList(newRange(2, 2, 2, 3), null, newRange(1, 1, 1, 1)));
		assertEquals(1, input.get(0).getStart().getLine());
		assertEquals(1, input.get(0).getStart().getCharacter());
		assertEquals(1, input.get(0).getEnd().getLine());
		assertEquals(1, input.get(0).getEnd().getCharacter());
		assertEquals(2, input.get(1).getStart().getLine());
		assertEquals(2, input.get(1).getStart().getCharacter());
		assertEquals(2, input.get(1).getEnd().getLine());
		assertEquals(3, input.get(1).getEnd().getCharacter());
		assertNull(IterableExtensions.last(input));
	}

	private Range newRange(int startLine, int startChar, int endLine, int endChar) {
		return new Range(new Position(startLine, startChar), new Position(endLine, endChar));
	}

	private List<? extends Range> sort(List<? extends Range> toSort) {
		toSort.sort(comparator);
		return toSort;
	}
}
