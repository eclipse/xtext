/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.util

import java.util.List
import javax.inject.Inject
import org.eclipse.lsp4j.Position
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider
import org.eclipse.xtext.ide.util.PositionComparator
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test for the null-safe {@link PositionComparator}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(TestLanguageIdeInjectorProvider)
class PositionComparatorTest extends Assert {

	@Inject
	PositionComparator comparator;

	@Test
	def void withoutNull() {
		val input = newArrayList(new Position(2, 2), new Position(2, 1), new Position(1, 2), new Position(1, 1)).sort;

		assertEquals(1, input.get(0).line);
		assertEquals(1, input.get(0).character);

		assertEquals(1, input.get(1).line);
		assertEquals(2, input.get(1).character);

		assertEquals(2, input.get(2).line);
		assertEquals(1, input.get(2).character);

		assertEquals(2, input.get(3).line);
		assertEquals(2, input.get(3).character);
	}

	@Test
	def void withNull() {
		val input = newArrayList(new Position(2, 2), null, new Position(1, 1)).sort;

		assertEquals(1, input.get(0).line);
		assertEquals(1, input.get(0).character);

		assertEquals(2, input.get(1).line);
		assertEquals(2, input.get(1).character);

		assertNull(input.last)
	}

	private def sort(List<? extends Position> toSort) {
		toSort.sort(comparator);
		return toSort;
	}

}
