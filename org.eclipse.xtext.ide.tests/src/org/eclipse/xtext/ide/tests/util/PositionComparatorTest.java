/*******************************************************************************
 * Copyright (c) 2016, 2023 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.util;

import java.util.List;
import org.eclipse.lsp4j.Position;
import org.eclipse.xtext.ide.tests.testlanguage.TestLanguageIdeInjectorProvider;
import org.eclipse.xtext.ide.util.PositionComparator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Test for the null-safe {@link PositionComparator}.
 * 
 * @author akos.kitta - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(TestLanguageIdeInjectorProvider.class)
public class PositionComparatorTest extends Assert {

	@Inject
	private PositionComparator comparator;

	@Test
	public void withoutNull() {
		List<? extends Position> input = sort(Lists.newArrayList(new Position(2, 2), new Position(2, 1), new Position(1, 2), new Position(1, 1)));

		assertEquals(1, input.get(0).getLine());
		assertEquals(1, input.get(0).getCharacter());

		assertEquals(1, input.get(1).getLine());
		assertEquals(2, input.get(1).getCharacter());

		assertEquals(2, input.get(2).getLine());
		assertEquals(1, input.get(2).getCharacter());

		assertEquals(2, input.get(3).getLine());
		assertEquals(2, input.get(3).getCharacter());
	}

	@Test
	public void withNull() {
		List<? extends Position> input = sort(Lists.newArrayList(new Position(2, 2), null, new Position(1, 1)));

		assertEquals(1, input.get(0).getLine());
		assertEquals(1, input.get(0).getCharacter());

		assertEquals(2, input.get(1).getLine());
		assertEquals(2, input.get(1).getCharacter());

		assertNull(IterableExtensions.lastOrNull(input));
	}

	private List<? extends Position> sort(List<? extends Position> toSort) {
		toSort.sort(comparator);
		return toSort;
	}

}
