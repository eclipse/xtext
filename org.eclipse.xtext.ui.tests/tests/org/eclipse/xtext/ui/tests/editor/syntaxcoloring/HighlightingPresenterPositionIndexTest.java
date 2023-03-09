/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring;

import java.util.Arrays;
import java.util.List;

import org.eclipse.xtext.ui.editor.syntaxcoloring.AttributedPosition;
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingPresenter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class HighlightingPresenterPositionIndexTest extends HighlightingPresenter {
	private List<AttributedPosition> positions;

	@Before
	public void setUp() {
		positions = Arrays.asList(new AttributedPosition(0, 2, null, null), new AttributedPosition(2, 2, null, null));
	}

	@Test
	public void testIndexAtOffset() {
		Assert.assertEquals(0, computeIndexAtOffset(positions, -1));
		Assert.assertEquals(0, computeIndexAtOffset(positions, 0));
		Assert.assertEquals(1, computeIndexAtOffset(positions, 1));
		Assert.assertEquals(1, computeIndexAtOffset(positions, 2));
		Assert.assertEquals(2, computeIndexAtOffset(positions, 3));
		Assert.assertEquals(2, computeIndexAtOffset(positions, 4));
	}

	@Test
	public void testIndexAfterOffset() {
		Assert.assertEquals(0, computeIndexAfterOffset(positions, -1));
		Assert.assertEquals(1, computeIndexAfterOffset(positions, 0));
		Assert.assertEquals(1, computeIndexAfterOffset(positions, 1));
		Assert.assertEquals(2, computeIndexAfterOffset(positions, 2));
		Assert.assertEquals(2, computeIndexAfterOffset(positions, 3));
		Assert.assertEquals(2, computeIndexAfterOffset(positions, 4));
	}

	@Test
	public void testIndexEndingAtOrEnclosingOffset() {
		Assert.assertEquals(0, computeIndexEndingAtOrEnclosingOffset(positions, -1));
		Assert.assertEquals(0, computeIndexEndingAtOrEnclosingOffset(positions, 0));
		Assert.assertEquals(0, computeIndexEndingAtOrEnclosingOffset(positions, 1));
		Assert.assertEquals(1, computeIndexEndingAtOrEnclosingOffset(positions, 2));
		Assert.assertEquals(1, computeIndexEndingAtOrEnclosingOffset(positions, 3));
		Assert.assertEquals(2, computeIndexEndingAtOrEnclosingOffset(positions, 4));
	}
}
