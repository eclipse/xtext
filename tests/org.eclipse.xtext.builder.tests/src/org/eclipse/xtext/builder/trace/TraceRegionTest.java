/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.trace;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbstractStatefulTraceRegion;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.TraceRegion;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.Iterators;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TraceRegionTest extends Assert {

	@Test
	public void testConstructor() {
		TraceRegion region = new TraceRegion(0, 1, 2, 3, null, URI.createURI("uri"), "project");
		assertEquals(0, region.getFromOffset());
		assertEquals(1, region.getFromLength());
		assertEquals(2, region.getToOffset());
		assertEquals(3, region.getToLength());
		assertEquals(URI.createURI("uri"), region.getToPath());
		assertEquals("project", region.getToProjectName());
		assertNull(region.getParent());
		assertTrue(region.getNestedRegions().isEmpty());
	}
	
	@Test
	public void testConstructorWithParent() {
		TraceRegion parent = new TraceRegion(0, 1, 2, 3, null, URI.createURI("uri"), "project");
		TraceRegion region = new TraceRegion(0, 1, 2, 3, parent, null, null);
		assertEquals(URI.createURI("uri"), region.getToPath());
		assertEquals("project", region.getToProjectName());
		assertEquals(parent, region.getParent());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArgs_01() {
		new TraceRegion(-1, 0, 0, 0, null, URI.createURI("uri"), "project");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArgs_02() {
		new TraceRegion(0, -1, 0, 0, null, URI.createURI("uri"), "project");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArgs_03() {
		new TraceRegion(0, 0, -1, 0, null, URI.createURI("uri"), "project");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArgs_04() {
		new TraceRegion(0, 0, 0, -1, null, URI.createURI("uri"), "project");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorInvalidArgs_05() {
		new TraceRegion(0, 0, 0, 0, null, null, "project");
	}
	
	public void testConstructor_NoProject() {
		TraceRegion region = new TraceRegion(0, 0, 0, 0, null, URI.createURI("uri"), null);
		assertEquals("<unknown>", region.getToProjectName());
	}
	
	@Test
	public void testLeafIterator_NoChildren() {
		TraceRegion region = new TraceRegion(0, 1, 2, 3, null, URI.createURI("uri"), "project");
		Iterator<AbstractTraceRegion> iter = region.leafIterator();
		assertTrue(Iterators.elementsEqual(Collections.singleton(region).iterator(), iter));
	}
	
	@Test
	public void testLeafIterator_OneChild() {
		TraceRegion parent = new TraceRegion(0, 1, 2, 3, null, URI.createURI("uri"), "project");
		TraceRegion region = new TraceRegion(0, 1, 2, 3, parent, null, null);
		Iterator<AbstractTraceRegion> iter = parent.leafIterator();
		assertTrue(Iterators.elementsEqual(Collections.singleton(region).iterator(), iter));
	}
	
	@Test
	public void testLeafIterator_GrandChild() {
		TraceRegion root = new TraceRegion(0, 1, 2, 3, null, URI.createURI("uri"), "project");
		TraceRegion parent = new TraceRegion(0, 1, 2, 3, root, null, null);
		TraceRegion region = new TraceRegion(0, 1, 2, 3, parent, null, null);
		Iterator<AbstractTraceRegion> iter = root.leafIterator();
		assertTrue(Iterators.elementsEqual(Collections.singleton(region).iterator(), iter));
	}
	
	@Test
	public void testLeafIterator_TwoChildren_NoGaps() {
		TraceRegion parent = new TraceRegion(0, 2, 2, 3, null, URI.createURI("uri"), "project");
		TraceRegion first = new TraceRegion(0, 1, 2, 3, parent, null, null);
		TraceRegion second = new TraceRegion(1, 1, 3, 4, parent, null, null);
		Iterator<AbstractTraceRegion> iter = parent.leafIterator();
		assertTrue(Iterators.elementsEqual(Arrays.asList(first, second).iterator(), iter));
	}
	
	@Test
	public void testLeafIterator_OneChild_LeftGap() {
		final TraceRegion parent = new TraceRegion(0, 2, 2, 3, null, URI.createURI("uri"), "project");
		AbstractTraceRegion first = new AbstractStatefulTraceRegion(0, 1, 2, 3, parent) {};
		TraceRegion second = new TraceRegion(1, 1, 3, 4, parent, null, null);
		Iterator<AbstractTraceRegion> iter = parent.leafIterator();
		assertTrue(Iterators.elementsEqual(Arrays.asList(first, second).iterator(), iter));
	}
	
	@Test
	public void testLeafIterator_OneChild_RightGap() {
		final TraceRegion parent = new TraceRegion(0, 2, 2, 3, null, URI.createURI("uri"), "project");
		AbstractTraceRegion first = new TraceRegion(0, 1, 3, 4, parent, null, null);
		AbstractTraceRegion second = new AbstractStatefulTraceRegion(1, 1, 2, 3, parent) {};
		Iterator<AbstractTraceRegion> iter = parent.leafIterator();
		assertTrue(Iterators.elementsEqual(Arrays.asList(first, second).iterator(), iter));
	}
	
	@Test
	public void testLeafIterator_OneGrandChild_LeftGap() {
		final TraceRegion root = new TraceRegion(0, 2, 2, 3, null, URI.createURI("uri"), "project");
		AbstractTraceRegion first = new AbstractStatefulTraceRegion(0, 1, 2, 3, root) {};
		TraceRegion parent = new TraceRegion(1, 1, 3, 4, root, null, null);
		TraceRegion second = new TraceRegion(1, 1, 3, 4, parent, null, null);
		Iterator<AbstractTraceRegion> iter = root.leafIterator();
		assertTrue(Iterators.elementsEqual(Arrays.asList(first, second).iterator(), iter));
	}
	
	@Test
	public void testLeafIterator_OneGrandChild_RightGap() {
		final TraceRegion root = new TraceRegion(0, 2, 2, 3, null, URI.createURI("uri"), "project");
		TraceRegion parent = new TraceRegion(0, 1, 3, 4, root, null, null);
		TraceRegion first = new TraceRegion(0, 1, 3, 4, parent, null, null);
		AbstractTraceRegion second = new AbstractStatefulTraceRegion(1, 1, 2, 3, root) {};
		Iterator<AbstractTraceRegion> iter = root.leafIterator();
		assertTrue(Iterators.elementsEqual(Arrays.asList(first, second).iterator(), iter));
	}
	
	@Test
	public void testLeafIterator_TwoGrandChildren_NoGaps_01() {
		TraceRegion root = new TraceRegion(0, 2, 2, 3, null, URI.createURI("uri"), "project");
		TraceRegion parent = new TraceRegion(0, 2, 2, 3, root, null, null);
		TraceRegion first = new TraceRegion(0, 1, 2, 3, parent, null, null);
		TraceRegion second = new TraceRegion(1, 1, 3, 4, parent, null, null);
		Iterator<AbstractTraceRegion> iter = root.leafIterator();
		assertTrue(Iterators.elementsEqual(Arrays.asList(first, second).iterator(), iter));
	}
	
	@Test
	public void testLeafIterator_TwoGrandChildren_NoGaps_02() {
		TraceRegion root = new TraceRegion(0, 2, 2, 3, null, URI.createURI("uri"), "project");
		TraceRegion firstParent = new TraceRegion(0, 1, 2, 3, root, null, null);
		TraceRegion first = new TraceRegion(0, 1, 2, 3, firstParent, null, null);
		TraceRegion secondParent = new TraceRegion(1, 1, 3, 4, root, null, null);
		TraceRegion second = new TraceRegion(1, 1, 3, 4, secondParent, null, null);
		Iterator<AbstractTraceRegion> iter = root.leafIterator();
		assertTrue(Iterators.elementsEqual(Arrays.asList(first, second).iterator(), iter));
	}
	
	@Test
	public void testLeafIterator_TwoChildren_WithGaps() {
		final TraceRegion parent = new TraceRegion(0, 3, 2, 3, null, URI.createURI("uri"), "project");
		TraceRegion first = new TraceRegion(0, 1, 2, 3, parent, null, null);
		AbstractTraceRegion second = new AbstractStatefulTraceRegion(1, 1, 2, 3, parent) {};
		AbstractTraceRegion third = new TraceRegion(2, 1, 3, 4, parent, null, null);
		Iterator<AbstractTraceRegion> iter = parent.leafIterator();
		assertTrue(Iterators.elementsEqual(Arrays.asList(first, second, third).iterator(), iter));
	}

	@Test
	public void testAnnotate_01() {
		TraceRegion region = new TraceRegion(0, 1, 2, 3, null, URI.createURI("uri"), "project");
		assertEquals("<2:3[a]", region.getAnnotatedString("a"));
	}
	
	@Test
	public void testAnnotate_02() {
		TraceRegion region = new TraceRegion(1, 1, 2, 3, null, URI.createURI("uri"), "project");
		assertEquals("a<2:3[b]c", region.getAnnotatedString("abc"));
	}
	
	@Test
	public void testAnnotate_03() {
		TraceRegion parent = new TraceRegion(0, 4, 1, 2, null, URI.createURI("uri"), "project");
		new TraceRegion(0, 1, 3, 4, parent, null, null);
		new TraceRegion(2, 1, 5, 6, parent, null, null);
		new TraceRegion(3, 1, 7, 8, parent, null, null);
		assertEquals("<1:2[<3:4[a]b<5:6[c]<7:8[d]]e", parent.getAnnotatedString("abcde"));
	}
	
	@Test
	public void testAnnotate_04() {
		TraceRegion root = new TraceRegion(0, 4, 1, 2, null, URI.createURI("uri"), "project");
		TraceRegion parent = new TraceRegion(1, 2, 3, 4, root, null, null);
		new TraceRegion(2, 1, 5, 6, parent, null, null);
		assertEquals("<1:2[a<3:4[b<5:6[c]]d]e", root.getAnnotatedString("abcde"));
	}
}
