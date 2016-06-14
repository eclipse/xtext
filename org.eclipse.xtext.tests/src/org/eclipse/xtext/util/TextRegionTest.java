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
		ITextRegion location = newTextRegion(3, 4);
		assertTrue(location.contains(3));
		assertTrue(location.contains(6));
		assertFalse(location.contains(2));
		assertFalse(location.contains(7));
	}
	
	/* @NonNull */
	protected ITextRegion newTextRegion(int offset, int length) {
		return new TextRegion(offset, length);
	}
	
	@Test public void testContainsByLocation() {
		ITextRegion location = newTextRegion(3, 4);
		assertTrue(location.contains(newTextRegion(4,2)));
		assertTrue(location.contains(newTextRegion(4,3)));
		assertTrue(location.contains(newTextRegion(3,2)));
		assertTrue(location.contains(newTextRegion(3,0)));
		assertFalse(location.contains(newTextRegion(2,4)));
		assertFalse(location.contains(newTextRegion(1,1)));
		assertFalse(location.contains(newTextRegion(8,1)));
	}
	
	@Test public void testMergeNecessary() {
		ITextRegion location = newTextRegion(2, 4);
		ITextRegion merge = location.merge(newTextRegion(1, 2));
		assertEquals(1, merge.getOffset());
		assertEquals(5, merge.getLength());
		merge = location.merge(newTextRegion(5, 2));
		assertEquals(2, merge.getOffset());
		assertEquals(5, merge.getLength());
		merge = location.merge(newTextRegion(7, 2));
		assertEquals(2, merge.getOffset());
		assertEquals(7, merge.getLength());
	}
	
	@Test public void testMergNoMergeNecessary() {
		ITextRegion location = newTextRegion(2, 4);
		ITextRegion merge = location.merge(ITextRegion.EMPTY_REGION);
		assertSame(location, merge);
		
		merge = ITextRegion.EMPTY_REGION.merge(location);
		assertSame(location, merge);
		
		ITextRegion otherSame = newTextRegion(2, 4);
		merge = location.merge(otherSame);
		assertSame(location, merge);
		
		ITextRegion otherSmaller = newTextRegion(3, 3);
		merge = location.merge(otherSmaller);
		assertSame(location, merge);
		
		ITextRegion otherLarger = newTextRegion(1, 5);
		merge = location.merge(otherLarger);
		assertSame(otherLarger, merge);
	}
}
