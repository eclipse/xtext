/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.List;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.serializer.analysis.NfaToGrammar;
import org.eclipse.xtext.serializer.analysis.NfaToGrammar.AbstractElementAlias;

import com.google.common.base.Function;
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

	private static class SFollowers implements Function<S, Iterable<S>> {
		public Iterable<S> apply(S from) {
			return from.followers;
		}
	}

	private String nfa2g(S start, S stop) {
		NfaToGrammar nfa2g = new NfaToGrammar();
		AbstractElementAlias<S> grammar = nfa2g.nfaToGtammar(start, stop, new SFollowers());
		return grammar.toString();
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
		assertEquals("start (((v | w) b) | ((x | y | z) a)) stop", nfa2g(start, stop));
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

	public void testCycle() {
		S start = new S("start");
		S stop = new S("stop");
		S x = new S("x");
		S y = new S("y");
		start.add(x);
		x.add(y, stop);
		y.add(x);
		assertEquals("start x (y x)* stop", nfa2g(start, stop));
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
}
