/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Functions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NfaToProductionTest extends Assert {

	private String nfa2g(Nfa<String> nfa) {
		NfaToProduction nfa2g = new NfaToProduction();
		return nfa2g.nfaToGrammar(nfa, Functions.<String> identity(), new ProductionStringFactory<String>());
	}

	@Test public void testAlternative() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "y");
		nfa.state("x").followedBy("stop");
		nfa.state("y").followedBy("stop");
		assertEquals("start (x | y) stop", nfa2g(nfa));
	}

	@Test public void testAlternative2() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "y", "z");
		nfa.state("x").followedBy("stop");
		nfa.state("y").followedBy("stop");
		nfa.state("z").followedBy("stop");
		assertEquals("start (x | y | z) stop", nfa2g(nfa));
	}

	@Test public void testAlternative3() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "y", "z", "v", "w");
		nfa.state("x").followedBy("a");
		nfa.state("y").followedBy("a");
		nfa.state("z").followedBy("a");
		nfa.state("v").followedBy("b");
		nfa.state("w").followedBy("b");
		nfa.state("a").followedBy("stop");
		nfa.state("b").followedBy("stop");
		assertEquals("start ((v | w) b | (x | y | z) a) stop", nfa2g(nfa));
	}

	@Test public void testAlternative4() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "y", "stop");
		nfa.state("x").followedBy("stop");
		nfa.state("y").followedBy("stop");
		assertEquals("start (x | y)? stop", nfa2g(nfa));
	}

	@Test public void testAlternative5() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "y");
		nfa.state("x").followedBy("stop", "x");
		nfa.state("y").followedBy("stop");
		assertEquals("start (x+ | y) stop", nfa2g(nfa));
	}

	@Test public void testAlternative6() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "y", "stop");
		nfa.state("x").followedBy("stop", "x");
		nfa.state("y").followedBy("stop");
		assertEquals("start (x* | y?) stop", nfa2g(nfa));
	}

	@Test public void testAlternative7() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("a", "b");
		nfa.state("a").followedBy("x", "y");
		nfa.state("b").followedBy("x", "y");
		nfa.state("x").followedBy("stop");
		nfa.state("y").followedBy("stop");
		assertEquals("start (a | b) (x | y) stop", nfa2g(nfa));
	}

	@Test public void testAlternative8() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("a", "b");
		nfa.state("a").followedBy("c", "d");
		nfa.state("b").followedBy("c", "d");
		nfa.state("c").followedBy("x", "y");
		nfa.state("d").followedBy("x", "y");
		nfa.state("x").followedBy("stop");
		nfa.state("y").followedBy("stop");
		assertEquals("start (a | b) (c | d) (x | y) stop", nfa2g(nfa));
	}

	@Test public void testManyGroups1() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "y");
		nfa.state("x").followedBy("x", "y");
		nfa.state("y").followedBy("x", "y", "stop");
		assertEquals("start (x* y)+ stop", nfa2g(nfa));
	}

	@Test public void testManyAlternative1() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "y", "stop");
		nfa.state("x").followedBy("x", "y", "stop");
		nfa.state("y").followedBy("x", "y", "stop");
		assertEquals("start (x | y)* stop", nfa2g(nfa));
	}

	@Test public void testManyAlternative2() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("a", "b", "c", "stop");
		nfa.state("a").followedBy("a", "b", "c", "stop");
		nfa.state("b").followedBy("a", "b", "c", "stop");
		nfa.state("c").followedBy("a", "b", "c", "stop");
		assertEquals("start (a | b | c)* stop", nfa2g(nfa));
	}

	@Test public void testManyAlternative3() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("a1", "b1", "stop");
		nfa.state("a1").followedBy("a2");
		nfa.state("a2").followedBy("b1", "a1", "stop");
		nfa.state("b1").followedBy("b2");
		nfa.state("b2").followedBy("a1", "b1", "stop");
		assertEquals("start (a1 a2 | b1 b2)* stop", nfa2g(nfa));
	}

	@Test public void testManyAlternative4() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("a1", "b1", "c1", "stop");
		nfa.state("a1").followedBy("a2");
		nfa.state("a2").followedBy("a1", "b1", "c1", "stop");
		nfa.state("b1").followedBy("b2");
		nfa.state("b2").followedBy("a1", "b1", "c1", "stop");
		nfa.state("c1").followedBy("c2");
		nfa.state("c2").followedBy("a1", "b1", "c1", "stop");
		assertEquals("start (a1 a2 | b1 b2 | c1 c2)* stop", nfa2g(nfa));
	}

	@Test public void testOptionalChain1() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "y", "stop");
		nfa.state("x").followedBy("y", "stop");
		nfa.state("y").followedBy("stop");
		assertEquals("start x? y? stop", nfa2g(nfa));
	}

	@Test public void testOptionalChain2() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "y", "z", "stop");
		nfa.state("x").followedBy("y", "z", "stop");
		nfa.state("y").followedBy("z", "stop");
		nfa.state("z").followedBy("stop");
		assertEquals("start x? y? z? stop", nfa2g(nfa));
	}

	@Test public void testSimple() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("stop");
		assertEquals("start stop", nfa2g(nfa));
	}

	@Test public void testSimpleMany() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x");
		nfa.state("x").followedBy("x", "stop");
		assertEquals("start x+ stop", nfa2g(nfa));
	}

	@Test public void testSimpleManyOptional() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "stop");
		nfa.state("x").followedBy("x", "stop");
		assertEquals("start x* stop", nfa2g(nfa));
	}

	@Test public void testSimpleManyOptional2() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "stop");
		nfa.state("x").followedBy("y");
		nfa.state("y").followedBy("z");
		nfa.state("z").followedBy("x", "stop");
		assertEquals("start (x y z)* stop", nfa2g(nfa));
	}

	@Test public void testSimpleManyOptional3() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "stop");
		nfa.state("x").followedBy("y", "z");
		nfa.state("y").followedBy("z");
		nfa.state("z").followedBy("x", "z", "stop");
		assertEquals("start (x y? z+)* stop", nfa2g(nfa));
	}

	@Test public void testSimpleOne() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x");
		nfa.state("x").followedBy("stop");
		assertEquals("start x stop", nfa2g(nfa));
	}

	@Test public void testSimpleOptional1() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x", "stop");
		nfa.state("x").followedBy("stop");
		assertEquals("start x? stop", nfa2g(nfa));
	}

	@Test public void testSimpleStartStopIdentical() {
		StringNfa nfa = new StringNfa("foo", "foo");
		nfa.start().followedBy("x", "foo");
		nfa.state("x").followedBy("foo");
		assertEquals("foo x? foo", nfa2g(nfa));
	}

	@Test public void testSplitStateAlternatives1() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("b", "c");
		nfa.state("b").followedBy("d", "e");
		nfa.state("c").followedBy("e");
		nfa.state("d").followedBy("stop");
		nfa.state("e").followedBy("stop");
		assertEquals("start (b (d | e) | c e) stop", nfa2g(nfa));
	}

	@Test public void testSplitStateAlternatives2() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("a", "b");
		nfa.state("a").followedBy("c", "d");
		nfa.state("b").followedBy("d", "e");
		nfa.state("c").followedBy("f");
		nfa.state("d").followedBy("f", "g");
		nfa.state("e").followedBy("g");
		nfa.state("f").followedBy("stop");
		nfa.state("g").followedBy("stop");
		assertEquals("start ((a | b) d (f | g) | a c f | b e g) stop", nfa2g(nfa));
	}

	@Test public void testSplitStateCycle1() {
		StringNfa nfa = new StringNfa("start", "stop");
		nfa.start().followedBy("x");
		nfa.state("x").followedBy("stop", "y");
		nfa.state("y").followedBy("x");
		assertEquals("start x (y x)* stop", nfa2g(nfa));
	}

}
