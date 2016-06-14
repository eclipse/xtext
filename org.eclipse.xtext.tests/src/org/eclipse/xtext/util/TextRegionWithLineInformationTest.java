/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util;

import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TextRegionWithLineInformationTest extends TextRegionTest {

	@Override
	/* @NonNull */
	protected ITextRegionWithLineInformation newTextRegion(int offset, int length) {
		return newTextRegion(offset, length, 0, 0);
	}
	
	/* @NonNull */
	protected ITextRegionWithLineInformation newTextRegion(int offset, int length, int startLine, int endLine) {
		return new TextRegionWithLineInformation(offset, length, startLine, endLine);
	}
	
	@Test
	public void testMergeLines_01() {
		ITextRegionWithLineInformation location = newTextRegion(2, 4, 2, 4);
		ITextRegionWithLineInformation other = newTextRegion(3, 4, 3, 4);
		assertLines(location, other, 2, 4);
	}
	
	@Test
	public void testMergeLines_02() {
		ITextRegionWithLineInformation location = newTextRegion(2, 4, 2, 4);
		ITextRegionWithLineInformation other = newTextRegion(3, 4, 2, 5);
		assertLines(location, other, 2, 5);
	}
	
	@Test
	public void testMergeLines_03() {
		ITextRegionWithLineInformation location = newTextRegion(2, 4, 2, 4);
		ITextRegionWithLineInformation other = newTextRegion(3, 4, 1, 3);
		assertLines(location, other, 1, 4);
	}
	
	@Test
	public void testMergeLines_04() {
		ITextRegionWithLineInformation location = newTextRegion(2, 4, 2, 4);
		ITextRegionWithLineInformation other = newTextRegion(3, 4, 1, 5);
		assertLines(location, other, 1, 5);
	}

	protected void assertLines(ITextRegionWithLineInformation first, ITextRegionWithLineInformation second, int expectedLine, int expectedEndLine) {
		assertLines(first.merge(second), expectedLine, expectedEndLine);
		assertLines(second.merge(first), expectedLine, expectedEndLine);
	}

	protected void assertLines(ITextRegionWithLineInformation result, int expectedLine, int expectedEndLine) {
		assertEquals(expectedLine, result.getLineNumber());
		assertEquals(expectedEndLine, result.getEndLineNumber());
	}

}
