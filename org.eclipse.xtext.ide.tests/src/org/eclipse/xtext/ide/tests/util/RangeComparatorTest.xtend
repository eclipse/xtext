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
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider
import org.eclipse.xtext.ide.util.RangeComparator
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test for the null-safe {@link RangeComparator}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(TestLanguageIdeInjectorProvider)
class RangeComparatorTest extends Assert {

	@Inject
	RangeComparator comparator;

	@Test
	def void withoutNull() {
		val input = newArrayList(newRange(1, 2, 1, 2), newRange(1, 1, 2, 1), newRange(1, 1, 1, 2), newRange(1, 1, 1, 1),
			newRange(2, 2, 2, 3)).sort;

		assertEquals(1, input.get(0).start.line);
		assertEquals(1, input.get(0).start.character);
		assertEquals(1, input.get(0).end.line);
		assertEquals(1, input.get(0).end.character);

		assertEquals(1, input.get(1).start.line);
		assertEquals(1, input.get(1).start.character);
		assertEquals(1, input.get(1).end.line);
		assertEquals(2, input.get(1).end.character);

		assertEquals(1, input.get(2).start.line);
		assertEquals(1, input.get(2).start.character);
		assertEquals(2, input.get(2).end.line);
		assertEquals(1, input.get(2).end.character);

		assertEquals(1, input.get(3).start.line);
		assertEquals(2, input.get(3).start.character);
		assertEquals(1, input.get(3).end.line);
		assertEquals(2, input.get(3).end.character);

		assertEquals(2, input.get(4).start.line);
		assertEquals(2, input.get(4).start.character);
		assertEquals(2, input.get(4).end.line);
		assertEquals(3, input.get(4).end.character);
	}

	@Test
	def void withNull() {
		val input = newArrayList(newRange(2, 2, 2, 3), null, newRange(1, 1, 1, 1)).sort;

		assertEquals(1, input.get(0).start.line);
		assertEquals(1, input.get(0).start.character);
		assertEquals(1, input.get(0).end.line);
		assertEquals(1, input.get(0).end.character);

		assertEquals(2, input.get(1).start.line);
		assertEquals(2, input.get(1).start.character);
		assertEquals(2, input.get(1).end.line);
		assertEquals(3, input.get(1).end.character);

		assertNull(input.last);
	}

	private def newRange(int startLine, int startChar, int endLine, int endChar) {
		return new Range(new Position(startLine, startChar), new Position(endLine, endChar));
	}

	private def sort(List<? extends Range> toSort) {
		toSort.sort(comparator);
		return toSort;
	}

}
