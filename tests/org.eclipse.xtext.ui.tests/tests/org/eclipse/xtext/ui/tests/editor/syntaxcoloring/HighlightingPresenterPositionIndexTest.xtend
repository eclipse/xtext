/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.editor.syntaxcoloring

import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingPresenter
import org.junit.Test
import org.junit.Before
import org.eclipse.xtext.ui.editor.syntaxcoloring.AttributedPosition
import java.util.List
import static org.junit.Assert.*

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
class HighlightingPresenterPositionIndexTest extends HighlightingPresenter {
	
	List<AttributedPosition> positions
	
	@Before
	def void setUp() {
		positions = #[
			new AttributedPosition(0, 2, null, null), 
			new AttributedPosition(2, 2, null, null) 
		] 
	} 
	
	@Test
	def testIndexAtOffset() {
		assertEquals(0, positions.computeIndexAtOffset(-1))
		assertEquals(0, positions.computeIndexAtOffset(0))
		assertEquals(1, positions.computeIndexAtOffset(1))
		assertEquals(1, positions.computeIndexAtOffset(2))
		assertEquals(2, positions.computeIndexAtOffset(3))
		assertEquals(2, positions.computeIndexAtOffset(4))
	}

	@Test
	def testIndexAfterOffset() {
		assertEquals(0, positions.computeIndexAfterOffset(-1))
		assertEquals(1, positions.computeIndexAfterOffset(0))
		assertEquals(1, positions.computeIndexAfterOffset(1))
		assertEquals(2, positions.computeIndexAfterOffset(2))
		assertEquals(2, positions.computeIndexAfterOffset(3))
		assertEquals(2, positions.computeIndexAfterOffset(4))
	}

	@Test
	def testIndexEndingAtOrEnclosingOffset() {
		assertEquals(0, positions.computeIndexEndingAtOrEnclosingOffset(-1))
		assertEquals(0, positions.computeIndexEndingAtOrEnclosingOffset(0))
		assertEquals(0, positions.computeIndexEndingAtOrEnclosingOffset(1))
		assertEquals(1, positions.computeIndexEndingAtOrEnclosingOffset(2))
		assertEquals(1, positions.computeIndexEndingAtOrEnclosingOffset(3))
		assertEquals(2, positions.computeIndexEndingAtOrEnclosingOffset(4))
	}
}