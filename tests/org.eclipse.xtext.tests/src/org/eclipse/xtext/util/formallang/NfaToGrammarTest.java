/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.util.formallang.GrammarStringFactory;
import org.eclipse.xtext.util.formallang.INfaAdapter;
import org.eclipse.xtext.util.formallang.ITokenAdapter;
import org.eclipse.xtext.util.formallang.NfaToGrammar;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NfaToGrammarTest extends AbstractXtextTests {

	private static class S {
		private String name;
		private List<S> followers = Lists.newArrayList();

		protected S(String name, S... s) {
			super();
			this.name = name;
			add(s);
		}

		@Override
		public String toString() {
			return name;
		}

		public void add(S... s) {
			for (S x : s)
				followers.add(x);
		}
	}

	private static class NFA implements INfaAdapter<S, Iterable<S>>, ITokenAdapter<S, String> {
		private Iterable<S> starts;
		private Iterable<S> stops;

		public NFA(Iterable<S> starts, Iterable<S> stops) {
			super();
			this.starts = starts;
			this.stops = stops;
		}

		public String getToken(S owner) {
			return owner.name;
		}

		public Iterable<S> getStartStates() {
			return starts;
		}

		public Iterable<S> getFollowers(S node) {
			return node.followers;
		}

		public Iterable<S> getFinalStates() {
			return stops;
		}

	}

	private String nfa2g(S starts, S stops) {
		return nfa2g(Collections.singleton(starts), Collections.singleton(stops));
	}

	private String nfa2g(Iterable<S> starts, S stops) {
		return nfa2g(starts, Collections.singleton(stops));
	}

	private String nfa2g(S starts, Iterable<S> stops) {
		return nfa2g(Collections.singleton(starts), stops);
	}

	private String nfa2g(Iterable<S> starts, Iterable<S> stops) {
		NfaToGrammar nfa2g = new NfaToGrammar();
		return nfa2g.nfaToGrammar(new NFA(starts, stops), new GrammarStringFactory<String>());
	}

	public void testSimple() {
		S start = new S("start");
		S stop = new S("stop");
		start.add(stop);
		assertEquals("start stop", nfa2g(start, stop));
	}

	public void testSimpleOne() {
		S start = new S("start");
		S stop = new S("stop");
		start.add(new S("x", stop));
		assertEquals("start x stop", nfa2g(start, stop));
	}

	public void testSimpleOptional() {
		S start = new S("start");
		S stop = new S("stop");
		start.add(new S("x", stop));
		start.add(stop);
		assertEquals("start x? stop", nfa2g(start, stop));
	}

	public void testSimpleMany() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x", stop);
		start.add(x);
		x.add(x);
		assertEquals("start x+ stop", nfa2g(start, stop));
	}

	public void testSimpleManyOptional() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x", stop);
		start.add(x);
		x.add(x);
		start.add(stop);
		assertEquals("start x* stop", nfa2g(start, stop));
	}

	public void testSimpleManyOptional2() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		S z = new S("z");
		start.add(x, stop);
		x.add(y);
		y.add(z);
		z.add(x, stop);
		assertEquals("start (x y z)* stop", nfa2g(start, stop));
	}

	public void testSimpleManyOptional3() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		S z = new S("z");
		start.add(x, stop);
		x.add(y, z);
		y.add(z);
		z.add(x, z, stop);
		assertEquals("start (x y? z+)* stop", nfa2g(start, stop));
	}

	public void testAlternative() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		start.add(x, y);
		x.add(stop);
		y.add(stop);
		assertEquals("start (x | y) stop", nfa2g(start, stop));
	}

	public void testAlternative2() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		S z = new S("z");
		start.add(x, y, z);
		x.add(stop);
		y.add(stop);
		z.add(stop);
		assertEquals("start (x | y | z) stop", nfa2g(start, stop));
	}

	public void testAlternative3() {
		S start = new S("start");
		S stop = new S("stop");
		S a = new S("a");
		S b = new S("b");
		S x = new S("x");
		S y = new S("y");
		S z = new S("z");
		S v = new S("v");
		S w = new S("w");
		start.add(x, y, z, v, w);
		x.add(a);
		y.add(a);
		z.add(a);
		v.add(b);
		w.add(b);
		a.add(stop);
		b.add(stop);
		assertEquals("start ((v | w) b | (x | y | z) a) stop", nfa2g(start, stop));
	}

	public void testAlternative4() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		start.add(x, y, stop);
		x.add(stop);
		y.add(stop);
		assertEquals("start (x | y)? stop", nfa2g(start, stop));
	}

	public void testAlternative5() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		start.add(x, y);
		x.add(stop, x);
		y.add(stop);
		assertEquals("start (x+ | y) stop", nfa2g(start, stop));
	}

	public void testAlternative6() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		start.add(x, y, stop);
		x.add(stop, x);
		y.add(stop);
		assertEquals("start (x+ | y)? stop", nfa2g(start, stop));
	}

	public void testAlternative7() {
		S start = new S("start");
		S stop = new S("stop");
		S a = new S("a");
		S b = new S("b");
		S x = new S("x");
		S y = new S("y");
		start.add(a, b);
		a.add(x, y);
		b.add(x, y);
		x.add(stop);
		y.add(stop);
		assertEquals("start (a | b) (x | y) stop", nfa2g(start, stop));
	}

	public void testAlternative8() {
		S start = new S("start");
		S stop = new S("stop");
		S a = new S("a");
		S b = new S("b");
		S c = new S("c");
		S d = new S("d");
		S x = new S("x");
		S y = new S("y");
		start.add(a, b);
		a.add(c, d);
		b.add(c, d);
		c.add(x, y);
		d.add(x, y);
		x.add(stop);
		y.add(stop);
		assertEquals("start (a | b) (c | d) (x | y) stop", nfa2g(start, stop));
	}

	public void testSplitStateCycle1() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		start.add(x);
		x.add(y, stop);
		y.add(x);
		assertEquals("start x (y x)* stop", nfa2g(start, stop));
	}

	public void testSplitStateAlternatives1() {
		S start = new S("start");
		S stop = new S("stop");
		S b = new S("b");
		S c = new S("c");
		S d = new S("d");
		S e = new S("e");
		start.add(b, c);
		b.add(d, e);
		c.add(e);
		d.add(stop);
		e.add(stop);
		assertEquals("start (b (d | e) | c e) stop", nfa2g(start, stop));
	}

	public void testSplitStateAlternatives2() {
		S start = new S("start");
		S stop = new S("stop");
		S a = new S("a");
		S b = new S("b");
		S c = new S("c");
		S d = new S("d");
		S e = new S("e");
		S f = new S("f");
		S g = new S("g");
		start.add(a, b);
		a.add(c, d);
		b.add(d, e);
		c.add(f);
		d.add(f, g);
		e.add(g);
		f.add(stop);
		g.add(stop);
		assertEquals("start ((a c f | b e g) | (a | b) d (f | g)) stop", nfa2g(start, stop));
	}

	public void testOptionalChain1() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		start.add(x, y, stop);
		x.add(y, stop);
		y.add(stop);
		assertEquals("start x? y? stop", nfa2g(start, stop));
	}

	public void testOptionalChain2() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		S z = new S("z");
		start.add(x, y, z, stop);
		x.add(y, z, stop);
		y.add(z, stop);
		z.add(stop);
		assertEquals("start x? y? z? stop", nfa2g(start, stop));
	}

	public void testAmbiguousStart() {
		S start1 = new S("start1");
		S start2 = new S("start2");
		S stop = new S("stop");
		start1.add(stop);
		start2.add(stop);
		assertEquals("(start1 | start2) stop", nfa2g(Lists.newArrayList(start1, start2), stop));
	}

	public void testAmbiguousStop() {
		S start = new S("start");
		S stop1 = new S("stop");
		S stop2 = new S("stop");
		start.add(stop1);
		start.add(stop2);
		assertEquals("start (stop | stop)", nfa2g(start, Lists.newArrayList(stop1, stop2)));
	}
}
