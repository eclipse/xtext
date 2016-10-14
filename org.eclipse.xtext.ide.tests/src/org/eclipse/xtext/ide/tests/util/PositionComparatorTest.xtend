/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.util

import io.typefox.lsapi.impl.PositionImpl
import javax.inject.Inject
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider
import org.eclipse.xtext.ide.util.PositionComparator
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import java.util.List
import io.typefox.lsapi.Position

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
		val input = newArrayList(newPosition(2, 2), newPosition(2, 1), newPosition(1, 2), newPosition(1, 1)).sort;

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
		val input = newArrayList(newPosition(2, 2), null, newPosition(1, 1)).sort;

		assertEquals(1, input.get(0).line);
		assertEquals(1, input.get(0).character);

		assertEquals(2, input.get(1).line);
		assertEquals(2, input.get(1).character);

		assertNull(input.last)
	}

	private def newPosition(int line, int character) {
		return new PositionImpl(line, character);
	}

	private def sort(List<? extends Position> toSort) {
		toSort.sort(comparator);
		return toSort;
	}

}
