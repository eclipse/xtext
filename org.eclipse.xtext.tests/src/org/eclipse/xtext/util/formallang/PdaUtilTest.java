/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PdaUtilTest extends Assert {

	private PdaUtil util = new PdaUtil();

	private Iterator<String> newStack(String... stackItem) {
		List<String> result = Lists.newArrayList(stackItem);
		Collections.reverse(result);
		return result.iterator();
	}

	private void assertEquals(String expected, Iterable<String> actual) {
		String act = actual == null ? "null" : actual.toString();
		assertEquals(expected, act);
	}

	@Test public void testShortestPathSimple() {
		StringPda pda = new StringPda("A", "C");
		pda.state("A").followedBy("B");
		pda.state("B").followedBy("C");
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack(), "C"));
	}

	@Test public void testShortestPathLoop() {
		StringPda pda = new StringPda("A", "C");
		pda.state("A").followedBy("B");
		pda.state("B").followedBy("C", "B");
		pda.state("C").followedBy("B");
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack(), "C"));
	}

	@Test public void testShortestPathStackSimple() {
		StringPda pda = new StringPda("A", "C");
		pda.state("A").followedBy("B");
		pda.state("B").followedBy("C").pop("X");
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack("X"), "C"));
		assertEquals("null", util.shortestPathTo(pda, newStack(), "C"));
	}

	@Test public void testShortestPathStackSimplePop() {
		StringPda pda = new StringPda("A", "C");
		pda.state("A").followedBy("B").pop("X");
		pda.state("B").followedBy("C").pop("Y");
		pda.state("C").pop("Z");
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack("Z", "Y"), "C"));
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack("Y"), "C"));
	}

	@Test public void testShortestPathStackSimplePopLoop() {
		StringPda pda = new StringPda("A", "C");
		pda.state("A").followedBy("B", "A").pop("X");
		pda.state("B").followedBy("C", "B").pop("Y");
		pda.state("C").pop("Z");
		assertEquals("[A, A, A, B, C]", util.shortestPathTo(pda, newStack("Y", "X", "X"), "C"));
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack("Y"), "C"));
	}

	@Test public void testShortestStackemptyingPathStackSimplePopLoop() {
		StringPda pda = new StringPda("A", "C");
		pda.state("A").followedBy("B");
		pda.state("B").followedBy("C", "B").pop("Y");
		assertEquals("[A, B, B, C]", util.shortestStackpruningPathTo(pda, newStack("Y", "Y"), "C"));
	}

	@Test public void testShortestStackemptyingPathTwoLoops() {
		StringPda pda = new StringPda("A", "D");
		pda.state("A").followedBy("B");
		pda.state("B").followedBy("C", "B").push("Y");
		pda.state("C").followedBy("D", "C").pop("Y");
		assertEquals("[A, B, C, D]", util.shortestStackpruningPathTo(pda, newStack(), "D"));
		assertEquals("[A, B, C, C, D]", util.shortestStackpruningPathTo(pda, newStack("Y"), "D"));
		assertEquals("[A, B, C, C, C, D]", util.shortestStackpruningPathTo(pda, newStack("Y", "Y"), "D"));
	}

	@Test 
	@Ignore
	public void testShortestStackemptyingSingleState() {
		StringPda pda = new StringPda("A", "A");
		pda.state("A");
		assertEquals("[A]", util.shortestStackpruningPathTo(pda, newStack(), "A"));
	}

	@Test
	@Ignore
	public void testShortestStackemptyingPathLoops1() {
		StringPda pda = new StringPda("A", "D");
		pda.state("A").followedBy("B");
		pda.state("B").followedBy("C").pop("X");
		pda.state("C").followedBy("D", "C").pop("Y");
		assertEquals("[A, B, C, D]", util.shortestStackpruningPathTo(pda, newStack(), "D"));
		assertEquals("[A, B, C, C, D]", util.shortestStackpruningPathTo(pda, newStack("Y"), "D"));
		assertEquals("[A, B, C, C, C, D]", util.shortestStackpruningPathTo(pda, newStack("Y", "Y"), "D"));
	}

}
