/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class LinkedHashSetQueueTest {
	
	@Test
	public void testLinkedHashSetQueue() {
		LinkedHashSetQueue<String> queue = new LinkedHashSetQueue<>();
		queue.add("a");
		assertEquals(1, queue.size());
		queue.add("b");
		assertEquals(2, queue.size());
		queue.add("b");
		assertEquals(2, queue.size());
		assertTrue(queue.contains("a"));
		assertTrue(queue.contains("b"));
		assertEquals("a", queue.peek());
		assertEquals(2, queue.size());
		assertEquals("a", queue.peek());
		assertEquals(2, queue.size());
		assertEquals("a", queue.poll());
		assertEquals(1, queue.size());
		assertFalse(queue.contains("a"));
		assertTrue(queue.contains("b"));
		assertEquals("b", queue.peek());
		assertEquals(1, queue.size());
		assertEquals("b", queue.poll());
		assertEquals(0, queue.size());
		assertNull(queue.poll());
		assertNull(queue.peek());
		queue.add("a");
		assertEquals(1, queue.size());
		queue.clear();
		assertEquals(0, queue.size());
	}

}
