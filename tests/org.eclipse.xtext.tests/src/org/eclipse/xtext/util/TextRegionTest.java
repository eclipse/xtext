/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TextRegionTest extends Assert {

	@Test public void testContainsByOffset() {
		ITextRegion location = new TextRegion(3, 4);
		assertTrue(location.contains(3));
		assertTrue(location.contains(6));
		assertFalse(location.contains(2));
		assertFalse(location.contains(7));
	}
	
	@Test public void testContainsByLocation() {
		ITextRegion location = new TextRegion(3, 4);
		assertTrue(location.contains(new TextRegion(4,2)));
		assertTrue(location.contains(new TextRegion(4,3)));
		assertTrue(location.contains(new TextRegion(3,2)));
		assertTrue(location.contains(new TextRegion(3,0)));
		assertFalse(location.contains(new TextRegion(2,4)));
		assertFalse(location.contains(new TextRegion(1,1)));
		assertFalse(location.contains(new TextRegion(8,1)));
	}
	
	@Test public void testMerge() {
		ITextRegion location = new TextRegion(2, 4);
		ITextRegion merge = location.merge(ITextRegion.EMPTY_REGION);
		assertEquals(2, merge.getOffset());
		assertEquals(4, merge.getLength());
		merge = ITextRegion.EMPTY_REGION.merge(location);
		assertEquals(2, merge.getOffset());
		assertEquals(4, merge.getLength());
		merge = location.merge(new TextRegion(2, 4));
		assertEquals(2, merge.getOffset());
		assertEquals(4, merge.getLength());
		merge = location.merge(new TextRegion(1, 2));
		assertEquals(1, merge.getOffset());
		assertEquals(5, merge.getLength());
		merge = location.merge(new TextRegion(5, 2));
		assertEquals(2, merge.getOffset());
		assertEquals(5, merge.getLength());
	}
}
