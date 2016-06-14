/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.trace;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.TextRegionWithLineInformation;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class TraceRegionTest extends Assert {

	private SourceRelativeURI newURI() {
		return newURI("uri");
	}
	
	private SourceRelativeURI newURI(String path) {
		return new SourceRelativeURI(URI.createURI(path));
	}
	
	@Test
	public void testConstructor() {
		TraceRegion region = new TraceRegion(0, 1, 0, 0, true, 2, 3, 0, 0, null, newURI());
		assertEquals(0, region.getMyOffset());
		assertEquals(1, region.getMyLength());
		assertEquals(2, region.getMergedAssociatedLocation().getOffset());
		assertEquals(3, region.getMergedAssociatedLocation().getLength());
		assertEquals(newURI(), region.getAssociatedSrcRelativePath());
		assertNull(region.getParent());
		assertTrue(region.getNestedRegions().isEmpty());
	}

	@Test
	public void testConstructorWithParent() {
		TraceRegion parent = new TraceRegion(0, 1, 0, 0, true, 2, 3, 0, 0, null, newURI());
		TraceRegion region = new TraceRegion(0, 1, 0, 0, true, 2, 3, 0, 0, parent, null);
		assertEquals(newURI(), region.getAssociatedSrcRelativePath());
		assertEquals(parent, region.getParent());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArgs_01() {
		new TraceRegion(-1, 0, 0, 0, true, 0, 0, 0, 0, null, newURI());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArgs_02() {
		new TraceRegion(0, -1, 0, 0, true, 0, 0, 0, 0, null, newURI());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArgs_03() {
		new TraceRegion(0, 0, -1, 0, true, 0, 0, 0, 0, null, newURI());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArgs_04() {
		new TraceRegion(0, 0, 0, -1, true, 0, 0, 0, 0, null, newURI());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArgs_05() {
		new TraceRegion(0, 0, 0, 0, true, 0, 0, 0, 0, null, null);
	}
	
	public void assertEquals(Iterator<? extends AbstractTraceRegion> iterator1, Iterator<? extends AbstractTraceRegion> iterator2) {
		while (iterator1.hasNext()) {
			assertTrue("iterator2.hasNext", iterator2.hasNext());
			AbstractTraceRegion o1 = iterator1.next();
			AbstractTraceRegion o2 = iterator2.next();
			assertEquals(o1, o2);
			assertEquals(o1.getMyLineNumber(), o2.getMyLineNumber());
			assertEquals(o1.getMyEndLineNumber(), o2.getMyEndLineNumber());
		}
		assertFalse("iterator2.hasNext", iterator2.hasNext());
	}
	
	@Test
	public void testLeafIterator_NoChildren() {
		TraceRegion region = new TraceRegion(0, 1, 1, 2, true, 2, 3, 0, 0, null, newURI());
		Iterator<AbstractTraceRegion> iter = region.leafIterator();
		assertEquals(Collections.singleton(region).iterator(), iter);
	}
	
	@Test
	public void testLeafIterator_OneChild() {
		TraceRegion parent = new TraceRegion(0, 1, 1, 2, true, 2, 3, 0, 0, null, newURI());
		TraceRegion region = new TraceRegion(0, 1, 1, 2, true, 2, 3, 0, 0, parent, null);
		Iterator<AbstractTraceRegion> iter = parent.leafIterator();
		assertEquals(Collections.singleton(region).iterator(), iter);
	}
	
	@Test
	public void testLeafIterator_GrandChild() {
		TraceRegion root = new TraceRegion(0, 1, 1, 2, true, 2, 3, 0, 0, null, newURI());
		TraceRegion parent = new TraceRegion(0, 1, 1, 2, true, 2, 3, 0, 0, root, null);
		TraceRegion region = new TraceRegion(0, 1, 1, 2, true, 2, 3, 0, 0, parent, null);
		Iterator<AbstractTraceRegion> iter = root.leafIterator();
		assertEquals(Collections.singleton(region).iterator(), iter);
	}
	
	@Test
	public void testLeafIterator_TwoChildren_NoGaps() {
		TraceRegion parent = new TraceRegion(0, 2, 0, 2, true, 2, 3, 0, 0, null, newURI());
		TraceRegion first = new TraceRegion(0, 1, 0, 1, true, 2, 3, 0, 0, parent, null);
		TraceRegion second = new TraceRegion(1, 1, 1, 2, true, 3, 4, 0, 0, parent, null);
		Iterator<AbstractTraceRegion> iter = parent.leafIterator();
		assertEquals(Arrays.asList(first, second).iterator(), iter);
	}
	
	@Test
	public void testLeafIterator_OneChild_LeftGap() {
		final TraceRegion parent = new TraceRegion(0, 2, 0, 2, true, 2, 3, 0, 0, null, newURI());
		AbstractTraceRegion first = new AbstractStatefulTraceRegion(new TextRegionWithLineInformation(0, 1, 0, 1), true, new LocationData(2, 3, 0, 0, null), parent) {};
		TraceRegion second = new TraceRegion(1, 1, 1, 2, true, 3, 4, 0, 0, parent, null);
		Iterator<AbstractTraceRegion> iter = parent.leafIterator();
		assertEquals(Arrays.asList(first, second).iterator(), iter);
	}
	
	@Test
	public void testLeafIterator_OneChild_RightGap() {
		final TraceRegion parent = new TraceRegion(0, 2, 0, 2, true, 2, 3, 0, 0, null, newURI());
		AbstractTraceRegion first = new TraceRegion(0, 1, 0, 1, true, 3, 4, 0, 0, parent, null);
		AbstractTraceRegion second = new AbstractStatefulTraceRegion(new TextRegionWithLineInformation(1, 1, 1, 2), true, new LocationData(2, 3, 0, 0, null), parent) {};
		Iterator<AbstractTraceRegion> iter = parent.leafIterator();
		assertEquals(Arrays.asList(first, second).iterator(), iter);
	}
	
	@Test
	public void testLeafIterator_OneGrandChild_LeftGap() {
		final TraceRegion root = new TraceRegion(0, 2, 0, 2, true, 2, 3, 0, 0, null, newURI());
		AbstractTraceRegion first = new AbstractStatefulTraceRegion(new TextRegionWithLineInformation(0, 1, 0, 1), true, new LocationData(2, 3, 0, 0, null), root) {};
		TraceRegion parent = new TraceRegion(1, 1, 1, 2, true, 3, 4, 0, 0, root, null);
		TraceRegion second = new TraceRegion(1, 1, 1, 2, true, 3, 4, 0, 0, parent, null);
		Iterator<AbstractTraceRegion> iter = root.leafIterator();
		assertEquals(Arrays.asList(first, second).iterator(), iter);
	}
	
	@Test
	public void testLeafIterator_OneGrandChild_RightGap() {
		final TraceRegion root = new TraceRegion(0, 2, 0, 2, true, 2, 3, 0, 0, null, newURI());
		TraceRegion parent = new TraceRegion(0, 1, 0, 1, true, 3, 4, 0, 0, root, null);
		TraceRegion first = new TraceRegion(0, 1, 0, 1, true, 3, 4, 0, 0, parent, null);
		AbstractTraceRegion second = new AbstractStatefulTraceRegion(new TextRegionWithLineInformation(1, 1, 1, 2), true, new LocationData(2, 3, 0, 0, null), root) {};
		Iterator<AbstractTraceRegion> iter = root.leafIterator();
		assertEquals(Arrays.asList(first, second).iterator(), iter);
	}
	
	@Test
	public void testLeafIterator_TwoGrandChildren_NoGaps_01() {
		TraceRegion root = new TraceRegion(0, 2, 0, 2, true, 2, 3, 0, 0, null, newURI());
		TraceRegion parent = new TraceRegion(0, 2, 0, 2, true, 2, 3, 0, 0, root, null);
		TraceRegion first = new TraceRegion(0, 1, 0, 1, true, 2, 3, 0, 0, parent, null);
		TraceRegion second = new TraceRegion(1, 1, 1, 2, true, 3, 4, 0, 0, parent, null);
		Iterator<AbstractTraceRegion> iter = root.leafIterator();
		assertEquals(Arrays.asList(first, second).iterator(), iter);
	}
	
	@Test
	public void testLeafIterator_TwoGrandChildren_NoGaps_02() {
		TraceRegion root = new TraceRegion(0, 2, 0, 2, true, 2, 3, 0, 0, null, newURI());
		TraceRegion firstParent = new TraceRegion(0, 1, 0, 1, true, 2, 3, 0, 0, root, null);
		TraceRegion first = new TraceRegion(0, 1, 0, 1, true, 2, 3, 0, 0, firstParent, null);
		TraceRegion secondParent = new TraceRegion(1, 1, 1, 2, true, 3, 4, 0, 0, root, null);
		TraceRegion second = new TraceRegion(1, 1, 1, 2, true, 3, 4, 0, 0, secondParent, null);
		Iterator<AbstractTraceRegion> iter = root.leafIterator();
		assertEquals(Arrays.asList(first, second).iterator(), iter);
	}
	
	@Test
	public void testLeafIterator_TwoChildren_WithGaps() {
		final TraceRegion parent = new TraceRegion(0, 3, 0, 3, true, 2, 3, 0, 0, null, newURI());
		TraceRegion first = new TraceRegion(0, 1, 0, 1, true, 2, 3, 0, 0, parent, null);
		AbstractTraceRegion second = new AbstractStatefulTraceRegion(new TextRegionWithLineInformation(1, 1, 1, 2), true, new LocationData(2, 3, 0, 0, null), parent) {};
		AbstractTraceRegion third = new TraceRegion(2, 1, 2, 3, true, 3, 4, 0, 0, parent, null);
		Iterator<AbstractTraceRegion> iter = parent.leafIterator();
		assertEquals(Arrays.asList(first, second, third).iterator(), iter);
	}

	@Test
	public void testAnnotate_01() {
		TraceRegion region = new TraceRegion(0, 1, 0, 0, true, 2, 3, 0, 0, null, newURI());
		assertEquals("<2:3[a]", region.getAnnotatedString("a"));
	}
	
	@Test
	public void testAnnotate_02() {
		TraceRegion region = new TraceRegion(1, 1, 0, 0, true, 2, 3, 0, 0, null, newURI());
		assertEquals("a<2:3[b]c", region.getAnnotatedString("abc"));
	}
	
	@Test
	public void testAnnotate_03() {
		TraceRegion parent = new TraceRegion(0, 4, 0, 0, true, 1, 2, 0, 0, null, newURI());
		new TraceRegion(0, 1, 0, 0, true, 3, 4, 0, 0, parent, null);
		new TraceRegion(2, 1, 0, 0, true, 5, 6, 0, 0, parent, null);
		new TraceRegion(3, 1, 0, 0, true, 7, 8, 0, 0, parent, null);
		assertEquals("<1:2[<3:4[a]b<5:6[c]<7:8[d]]e", parent.getAnnotatedString("abcde"));
	}
	
	@Test
	public void testAnnotate_04() {
		TraceRegion root = new TraceRegion(0, 4, 0, 0, true, 1, 2, 0, 0, null, newURI());
		TraceRegion parent = new TraceRegion(1, 2, 0, 0, true, 3, 4, 0, 0, root, null);
		new TraceRegion(2, 1, 0, 0, true, 5, 6, 0, 0, parent, null);
		assertEquals("<1:2[a<3:4[b<5:6[c]]d]e", root.getAnnotatedString("abcde"));
	}
	
	@Test
	public void testInvertFor_01() {
		SourceRelativeURI path = newURI("a");
		TraceRegion root = new TraceRegion(1, 2, 3, 4, true, 5, 6, 7, 8, null, path);
		List<AbstractTraceRegion> invertedList = root.invertFor(path, newURI("b"));
		assertEquals(1, invertedList.size());
		AbstractTraceRegion inverted = invertedList.get(0);
		assertEquals(5, inverted.getMyOffset());
		assertEquals(6, inverted.getMyLength());
		assertEquals(7, inverted.getMyLineNumber());
		assertEquals(8, inverted.getMyEndLineNumber());
		ILocationData associatedLocation = inverted.getMergedAssociatedLocation();
		assertEquals(1, associatedLocation.getOffset());
		assertEquals(2, associatedLocation.getLength());
		assertEquals(3, associatedLocation.getLineNumber());
		assertEquals(4, associatedLocation.getEndLineNumber());
	}
	
	@Test
	public void testInvertFor_02() {
		SourceRelativeURI path = newURI("a");
		TraceRegion root = new TraceRegion(0, 2, 0, 2, true, 4, 2, 4, 6, null, path);
		TraceRegion first = new TraceRegion(0, 1, 0, 1, true, 4, 1, 4, 5, root, null);
		TraceRegion second = new TraceRegion(1, 1, 1, 2, true, 5, 1, 5, 6, root, null);
		List<AbstractTraceRegion> invertedList = root.invertFor(path, newURI("b"));
		assertEquals(1, invertedList.size());
		AbstractTraceRegion inverted = invertedList.get(0);
		assertEquals(2, inverted.getNestedRegions().size());
		assertEquals(4, inverted.getMyOffset());
		assertEquals(2, inverted.getMyLength());
		assertEquals(4, inverted.getMyLineNumber());
		assertEquals(6, inverted.getMyEndLineNumber());
		ILocationData associatedLocation = inverted.getMergedAssociatedLocation();
		assertEquals(0, associatedLocation.getOffset());
		assertEquals(2, associatedLocation.getLength());
		assertEquals(0, associatedLocation.getLineNumber());
		assertEquals(2, associatedLocation.getEndLineNumber());
		
		AbstractTraceRegion firstChild = inverted.getNestedRegions().get(0);
		assertEquals(0, firstChild.getNestedRegions().size());
		assertEquals(4, firstChild.getMyOffset());
		assertEquals(1, firstChild.getMyLength());
		assertEquals(4, firstChild.getMyLineNumber());
		assertEquals(5, firstChild.getMyEndLineNumber());
		associatedLocation = firstChild.getMergedAssociatedLocation();
		assertEquals(0, associatedLocation.getOffset());
		assertEquals(1, associatedLocation.getLength());
		assertEquals(0, associatedLocation.getLineNumber());
		assertEquals(1, associatedLocation.getEndLineNumber());
		
		AbstractTraceRegion secondChild = inverted.getNestedRegions().get(1);
		assertEquals(0, secondChild.getNestedRegions().size());
		assertEquals(5, secondChild.getMyOffset());
		assertEquals(1, secondChild.getMyLength());
		assertEquals(5, secondChild.getMyLineNumber());
		assertEquals(6, secondChild.getMyEndLineNumber());
		associatedLocation = secondChild.getMergedAssociatedLocation();
		assertEquals(1, associatedLocation.getOffset());
		assertEquals(1, associatedLocation.getLength());
		assertEquals(1, associatedLocation.getLineNumber());
		assertEquals(2, associatedLocation.getEndLineNumber());
	}
	
	@Test
	public void testInvertFor_03() {
		SourceRelativeURI path = newURI("a");
		TraceRegion root = new TraceRegion(0, 2, 0, 2, true, 4, 3, 4, 6, null, path);
		TraceRegion first = new TraceRegion(0, 1, 0, 1, true, 4, 1, 4, 5, root, null);
		TraceRegion second = new TraceRegion(1, 1, 1, 2, true, 6, 1, 5, 6, root, null);
		List<AbstractTraceRegion> invertedList = root.invertFor(path, newURI("b"));
		assertEquals(1, invertedList.size());
		AbstractTraceRegion inverted = invertedList.get(0);
		assertEquals(2, inverted.getNestedRegions().size());
		assertEquals(4, inverted.getMyOffset());
		assertEquals(3, inverted.getMyLength());
		assertEquals(4, inverted.getMyLineNumber());
		assertEquals(6, inverted.getMyEndLineNumber());
		ILocationData associatedLocation = inverted.getMergedAssociatedLocation();
		assertEquals(0, associatedLocation.getOffset());
		assertEquals(2, associatedLocation.getLength());
		assertEquals(0, associatedLocation.getLineNumber());
		assertEquals(2, associatedLocation.getEndLineNumber());
		
		AbstractTraceRegion firstChild = inverted.getNestedRegions().get(0);
		assertEquals(0, firstChild.getNestedRegions().size());
		assertEquals(4, firstChild.getMyOffset());
		assertEquals(1, firstChild.getMyLength());
		assertEquals(4, firstChild.getMyLineNumber());
		assertEquals(5, firstChild.getMyEndLineNumber());
		associatedLocation = firstChild.getMergedAssociatedLocation();
		assertEquals(0, associatedLocation.getOffset());
		assertEquals(1, associatedLocation.getLength());
		assertEquals(0, associatedLocation.getLineNumber());
		assertEquals(1, associatedLocation.getEndLineNumber());
		
		AbstractTraceRegion secondChild = inverted.getNestedRegions().get(1);
		assertEquals(0, secondChild.getNestedRegions().size());
		assertEquals(6, secondChild.getMyOffset());
		assertEquals(1, secondChild.getMyLength());
		assertEquals(5, secondChild.getMyLineNumber());
		assertEquals(6, secondChild.getMyEndLineNumber());
		associatedLocation = secondChild.getMergedAssociatedLocation();
		assertEquals(1, associatedLocation.getOffset());
		assertEquals(1, associatedLocation.getLength());
		assertEquals(1, associatedLocation.getLineNumber());
		assertEquals(2, associatedLocation.getEndLineNumber());
	}
	
	@Test
	public void testInvertFor_04() {
		SourceRelativeURI path = newURI("a");
		TraceRegion root = new TraceRegion(0, 2, 0, 2, true, 4, 3, 4, 6, null, path);
		TraceRegion first = new TraceRegion(0, 1, 0, 1, true, 4, 2, 4, 5, root, null);
		TraceRegion second = new TraceRegion(1, 1, 1, 2, true, 5, 2, 5, 6, root, null);
		List<AbstractTraceRegion> invertedList = root.invertFor(path, newURI("b"));
		assertEquals(1, invertedList.size());
		AbstractTraceRegion inverted = invertedList.get(0);
		assertEquals(2, inverted.getNestedRegions().size());
		assertEquals(4, inverted.getMyOffset());
		assertEquals(3, inverted.getMyLength());
		assertEquals(4, inverted.getMyLineNumber());
		assertEquals(6, inverted.getMyEndLineNumber());
		ILocationData associatedLocation = inverted.getMergedAssociatedLocation();
		assertEquals(0, associatedLocation.getOffset());
		assertEquals(2, associatedLocation.getLength());
		assertEquals(0, associatedLocation.getLineNumber());
		assertEquals(2, associatedLocation.getEndLineNumber());
		
		AbstractTraceRegion firstChild = inverted.getNestedRegions().get(0);
		assertEquals(1, firstChild.getNestedRegions().size());
		assertEquals(4, firstChild.getMyOffset());
		assertEquals(2, firstChild.getMyLength());
		assertEquals(4, firstChild.getMyLineNumber());
		assertEquals(5, firstChild.getMyEndLineNumber());
		associatedLocation = firstChild.getMergedAssociatedLocation();
		assertEquals(0, associatedLocation.getOffset());
		assertEquals(1, associatedLocation.getLength());
		assertEquals(0, associatedLocation.getLineNumber());
		assertEquals(1, associatedLocation.getEndLineNumber());
		
		AbstractTraceRegion grandChild = firstChild.getNestedRegions().get(0);
		assertEquals(0, grandChild.getNestedRegions().size());
		assertEquals(5, grandChild.getMyOffset());
		assertEquals(1, grandChild.getMyLength());
		assertEquals(5, grandChild.getMyLineNumber());
		assertEquals(5, grandChild.getMyEndLineNumber());
		associatedLocation = grandChild.getMergedAssociatedLocation();
		assertEquals(1, associatedLocation.getOffset());
		assertEquals(1, associatedLocation.getLength());
		assertEquals(1, associatedLocation.getLineNumber());
		assertEquals(2, associatedLocation.getEndLineNumber());
		
		AbstractTraceRegion secondChild = inverted.getNestedRegions().get(1);
		assertEquals(0, secondChild.getNestedRegions().size());
		assertEquals(6, secondChild.getMyOffset());
		assertEquals(1, secondChild.getMyLength());
		assertEquals(5, secondChild.getMyLineNumber());
		assertEquals(6, secondChild.getMyEndLineNumber());
		associatedLocation = secondChild.getMergedAssociatedLocation();
		assertEquals(1, associatedLocation.getOffset());
		assertEquals(1, associatedLocation.getLength());
		assertEquals(1, associatedLocation.getLineNumber());
		assertEquals(2, associatedLocation.getEndLineNumber());
	}
	
	@Test
	public void testInvertFor_05() {
		SourceRelativeURI path = newURI("a");
		TraceRegion parent = new TraceRegion(0, 3, 0, 3, true, 4, 3, 4, 6, null, path);
		TraceRegion first = new TraceRegion(0, 1, 0, 1, true, 4, 2, 4, 5, parent, null);
		TraceRegion second = new TraceRegion(2, 1, 2, 3, true, 4, 2, 4, 5, parent, null);
		List<AbstractTraceRegion> invertedList = parent.invertFor(path, newURI("b"));
		assertEquals(1, invertedList.size());
		AbstractTraceRegion inverted = invertedList.get(0);
		assertEquals(1, inverted.getNestedRegions().size());
		assertEquals(4, inverted.getMyOffset());
		assertEquals(3, inverted.getMyLength());
		assertEquals(4, inverted.getMyLineNumber());
		assertEquals(6, inverted.getMyEndLineNumber());
		ILocationData associatedLocation = inverted.getMergedAssociatedLocation();
		assertEquals(0, associatedLocation.getOffset());
		assertEquals(3, associatedLocation.getLength());
		assertEquals(0, associatedLocation.getLineNumber());
		assertEquals(3, associatedLocation.getEndLineNumber());
		
		AbstractTraceRegion invertedChild = inverted.getNestedRegions().get(0);
		assertEquals(0, invertedChild.getNestedRegions().size());
		assertEquals(4, invertedChild.getMyOffset());
		assertEquals(2, invertedChild.getMyLength());
		assertEquals(4, invertedChild.getMyLineNumber());
		assertEquals(5, invertedChild.getMyEndLineNumber());
		List<ILocationData> associatedLocations = invertedChild.getAssociatedLocations();
		assertEquals(2, associatedLocations.size());
		associatedLocation = associatedLocations.get(0);
		assertEquals(0, associatedLocation.getOffset());
		assertEquals(1, associatedLocation.getLength());
		assertEquals(0, associatedLocation.getLineNumber());
		assertEquals(1, associatedLocation.getEndLineNumber());
		
		associatedLocation = associatedLocations.get(1);
		assertEquals(2, associatedLocation.getOffset());
		assertEquals(1, associatedLocation.getLength());
		assertEquals(2, associatedLocation.getLineNumber());
		assertEquals(3, associatedLocation.getEndLineNumber());
	}
	
	@Test
	public void testInvertFor_06() {
		SourceRelativeURI path = newURI("a");
		TraceRegion root = new TraceRegion(1, 2, 3, 4, true, 0, 0, 0, 0, null, path);
		List<AbstractTraceRegion> invertedList = root.invertFor(path, newURI("b"));
		assertTrue(invertedList.isEmpty());
	}
}
