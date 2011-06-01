/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.util.formallang.IPdaAdapter;
import org.eclipse.xtext.util.formallang.PdaUtil;

import junit.framework.TestCase;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.internal.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class PdaUtilTest extends TestCase {

	private class PDA implements IPdaAdapter<String, String> {

		private final Set<String> starts = Sets.newHashSet();
		private final Set<String> finals = Sets.newHashSet();
		private final Multimap<String, String> followers = HashMultimap.create();
		private final Map<String, String> pushs = Maps.newHashMap();
		private final Map<String, String> pops = Maps.newHashMap();

		public class State {
			private String name;

			public State(String name) {
				super();
				this.name = name;
			}

			public State to(String... followers) {
				for (String follower : followers)
					PDA.this.followers.put(name, follower);
				return this;
			}

			public State push(String push) {
				PDA.this.pushs.put(name, push);
				return this;
			}

			public State pop(String pop) {
				PDA.this.pops.put(name, pop);
				return this;
			}

			public State start() {
				PDA.this.starts.add(name);
				return this;
			}

			public State stop() {
				PDA.this.finals.add(name);
				return this;
			}
		}

		public State state(String name) {
			return new State(name);
		}

		public Iterable<String> getStartStates() {
			return starts;
		}

		public Iterable<String> getFollowers(String node) {
			return followers.get(node);
		}

		public Iterable<String> getFinalStates() {
			return finals;
		}

		public String getPush(String state) {
			return pushs.get(state);
		}

		public String getPop(String state) {
			return pops.get(state);
		}
	}

	private PDA newPDA() {
		return new PDA();
	}

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

	public void testShortestPathSimple() {
		PDA pda = newPDA();
		pda.state("A").start().to("B");
		pda.state("B").to("C");
		pda.state("C").stop();
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack(), "C"));
	}

	//	public void testShortestPathSingleState() {
	//		PDA pda = newPDA();
	//		pda.state("A").start().stop();
	//		assertEquals("[A]", util.shortestPathTo(pda, newStack(), "A"));
	//	}

	public void testShortestPathNoStates() {
		PDA pda = newPDA();
		assertEquals("[]", util.shortestPathToFinalState(pda, newStack()));
	}

	public void testShortestPathLoop() {
		PDA pda = newPDA();
		pda.state("A").start().to("B");
		pda.state("B").to("C", "B");
		pda.state("C").stop().to("B");
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack(), "C"));
	}

	public void testShortestPathStackSimple() {
		PDA pda = newPDA();
		pda.state("A").start().to("B");
		pda.state("B").to("C").pop("X");
		pda.state("C").stop();
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack("X"), "C"));
		assertEquals("null", util.shortestPathTo(pda, newStack(), "C"));
	}

	public void testShortestPathStackSimplePop() {
		PDA pda = newPDA();
		pda.state("A").start().to("B").pop("X");
		pda.state("B").to("C").pop("Y");
		pda.state("C").stop().pop("Z");
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack("Z", "Y"), "C"));
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack("Y"), "C"));
	}

	public void testShortestPathStackSimplePopLoop() {
		PDA pda = newPDA();
		pda.state("A").start().to("B", "A").pop("X");
		pda.state("B").to("C", "B").pop("Y");
		pda.state("C").stop().pop("Z");
		assertEquals("[A, A, A, B, C]", util.shortestPathTo(pda, newStack("Y", "X", "X"), "C"));
		assertEquals("[A, B, C]", util.shortestPathTo(pda, newStack("Y"), "C"));
	}

	public void testShortestStackemptyingPathStackSimplePopLoop() {
		PDA pda = newPDA();
		pda.state("A").start().to("B");
		pda.state("B").to("C", "B").pop("Y");
		pda.state("C").stop();
		assertEquals("[A, B, B, C]", util.shortestStackpruningPathTo(pda, newStack("Y", "Y"), "C"));
	}

	public void testShortestStackemptyingPathTwoLoops() {
		PDA pda = newPDA();
		pda.state("A").start().to("B");
		pda.state("B").to("C", "B").push("Y");
		pda.state("C").to("D", "C").pop("Y");
		pda.state("D").stop();
		assertEquals("[A, B, C, D]", util.shortestStackpruningPathTo(pda, newStack(), "D"));
		assertEquals("[A, B, C, C, D]", util.shortestStackpruningPathTo(pda, newStack("Y"), "D"));
		assertEquals("[A, B, C, C, C, D]", util.shortestStackpruningPathTo(pda, newStack("Y", "Y"), "D"));
	}

	//	public void testShortestStackemptyingSingleState() {
	//		PDA pda = newPDA();
	//		pda.state("A").start().stop();
	//		assertEquals("[A]", util.shortestStackpruningPathTo(pda, newStack(), "A"));
	//	}

	//	public void testShortestStackemptyingPathLoops1() {
	//		PDA pda = newPDA();
	//		pda.state("A").start().to("B");
	//		pda.state("B").to("C").pop("X");
	//		pda.state("C").to("D", "C").pop("Y");
	//		pda.state("D").stop();
	//		assertEquals("[A, B, C, D]", util.shortestStackpruningPathTo(pda, newStack(), "D"));
	//		assertEquals("[A, B, C, C, D]", util.shortestStackpruningPathTo(pda, newStack("Y"), "D"));
	//		assertEquals("[A, B, C, C, C, D]", util.shortestStackpruningPathTo(pda, newStack("Y", "Y"), "D"));
	//	}

}
