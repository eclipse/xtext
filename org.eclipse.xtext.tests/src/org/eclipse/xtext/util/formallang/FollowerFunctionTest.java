/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import static org.eclipse.xtext.util.formallang.FollowerFunctionImpl.UnorderedStrategy.*;

import org.eclipse.xtext.util.formallang.FollowerFunctionImpl.Direction;
import org.eclipse.xtext.util.formallang.StringProduction.ProdElement;
import org.junit.Assert;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class FollowerFunctionTest extends Assert {

	private class ElementFormatter implements Function<ProdElement, String> {
		@Override
		public String apply(ProdElement from) {
			if (from == null)
				return "null";
			if (from.getValue() != null)
				return "'" + from.getValue() + "'";
			return from.toString();
		}
	}

	private class FF extends FollowerFunctionImpl<ProdElement, String> {

		public FF(Production<ProdElement, String> production) {
			super(production);
		}

		public String starts() {
			Iterable<ProdElement> followers = getStarts(production.getRoot());
			return Joiner.on(", ").join(Iterables.transform(followers, new ElementFormatter()));
		}

		public String followers(String token) {
			ProdElement ele = new ProductionUtil().findByToken(production, token);
			Iterable<ProdElement> followers = getFollowers(ele);
			return Joiner.on(", ").join(Iterables.transform(followers, new ElementFormatter()));
		}

		@Override
		public FF setUnorderedStrategy(UnorderedStrategy unorderedStrategy) {
			return (FF) super.setUnorderedStrategy(unorderedStrategy);
		}
	}

	private StringProduction sp(String value) {
		NfaUtil util = new NfaUtil();
		StringProduction result = new StringProduction(value);
		FollowerFunction<ProdElement> l2r = new FollowerFunctionImpl<ProdElement, String>(result)
				.setDirection(Direction.L2R);
		FollowerFunction<ProdElement> r2l = new FollowerFunctionImpl<ProdElement, String>(result)
				.setDirection(Direction.R2L);
		Nfa<String> nfa1 = util.create(result, l2r, new StringNfa.StringNfaFactory("(begin)", "(end)"));
		Nfa<String> nfa2 = util.inverse(util.create(result, r2l, new StringNfa.StringNfaFactory("(end)", "(begin)")));
		if (!util.equalsIgnoreOrder(nfa1, nfa2)) {
			NfaGraphFormatter fmt = new NfaGraphFormatter();
			assertEquals(fmt.format(nfa1), fmt.format(nfa2));
		}
		return result;
	}

	@Test public void testSimple() {
		StringProduction p = sp("'a'");
		assertEquals("null", new FF(p).followers("a"));
	}

	@Test public void testSequence1() {
		StringProduction p = sp("'a' 'b'");
		assertEquals("'b'", new FF(p).followers("a"));
	}

	@Test public void testSequence2() {
		StringProduction p = sp("'a' 'b'?");
		assertEquals("'b', null", new FF(p).followers("a"));
	}

	@Test public void testSequence3() {
		StringProduction p = sp("'a' 'b'? 'c'");
		assertEquals("'b', 'c'", new FF(p).followers("a"));
	}

	@Test public void testSequence4() {
		StringProduction p = sp("'a' 'b'? 'c'?");
		assertEquals("'b', 'c', null", new FF(p).followers("a"));
	}

	@Test public void testSequence5() {
		StringProduction p = sp("'a'+ 'b'");
		assertEquals("'a', 'b'", new FF(p).followers("a"));
	}

	@Test public void testSequence6() {
		StringProduction p = sp("'a'* 'b'");
		assertEquals("'a', 'b'", new FF(p).followers("a"));
	}

	@Test public void testSequence7() {
		StringProduction p = sp("'a' 'b'*");
		assertEquals("'b', null", new FF(p).followers("a"));
	}

	@Test public void testSequence8() {
		StringProduction p = sp("'a' 'b'* 'c'?");
		assertEquals("'b', 'c', null", new FF(p).followers("a"));
	}

	@Test public void testSequence9() {
		StringProduction p = sp("'a' ('b' 'c')");
		assertEquals("'b'", new FF(p).followers("a"));
	}

	@Test public void testSequence10() {
		StringProduction p = sp("'a' ('b'? 'c')");
		assertEquals("'b', 'c'", new FF(p).followers("a"));
	}

	@Test public void testSequence11() {
		StringProduction p = sp("'a' ('b'? 'c'?)");
		assertEquals("'b', 'c', null", new FF(p).followers("a"));
	}

	@Test public void testSequence12() {
		StringProduction p = sp("'a' ('b' 'c')*");
		assertEquals("'b', null", new FF(p).followers("c"));
	}

	@Test public void testAlternative1() {
		StringProduction p = sp("'a' ('b' | 'c')");
		assertEquals("'b', 'c'", new FF(p).followers("a"));
	}

	@Test public void testAlternative2() {
		StringProduction p = sp("'a' ('b'? | 'c')");
		assertEquals("'b', 'c', null", new FF(p).followers("a"));
	}

	@Test public void testAlternative3() {
		StringProduction p = sp("'a' ('b' | 'c')?");
		assertEquals("'b', 'c', null", new FF(p).followers("a"));
	}

	@Test public void testAlternative4() {
		StringProduction p = sp("'a' 'b'? ('c' | 'd')?");
		assertEquals("'b', 'c', 'd', null", new FF(p).followers("a"));
	}

	@Test public void testAlternative5() {
		StringProduction p = sp("'a' ('b' | 'c')+");
		assertEquals("'b', 'c'", new FF(p).followers("a"));
	}

	@Test public void testAlternative6() {
		StringProduction p = sp("'a' ('b' | 'c')+");
		assertEquals("'b', 'c', null", new FF(p).followers("b"));
	}

	@Test public void testAlternative7() {
		StringProduction p = sp("'a' ('b' | 'c')+");
		assertEquals("'b', 'c', null", new FF(p).followers("c"));
	}

	@Test public void testUnordered1() {
		StringProduction p = sp("'a' ('b' & 'c')");
		FF mult = new FF(p).setUnorderedStrategy(MULIT_ALTERNATIVE);
		FF seq = new FF(p).setUnorderedStrategy(SEQUENCE);
		assertEquals("'b', 'c'", mult.followers("a"));
		assertEquals("'b'", seq.followers("a"));
		assertEquals("'b', 'c', null", mult.followers("b"));
		assertEquals("'c'", seq.followers("b"));
		assertEquals("'b', 'c', null", mult.followers("c"));
		assertEquals("null", seq.followers("c"));
	}

	@Test public void testUnordered2() {
		StringProduction p = sp("'a' ('b' & 'c' & 'd')");
		FF mult = new FF(p).setUnorderedStrategy(MULIT_ALTERNATIVE);
		FF seq = new FF(p).setUnorderedStrategy(SEQUENCE);
		assertEquals("'b', 'c', 'd'", mult.followers("a"));
		assertEquals("'b'", seq.followers("a"));
		assertEquals("'b', 'c', 'd', null", mult.followers("b"));
		assertEquals("'c'", seq.followers("b"));
		assertEquals("'b', 'c', 'd', null", mult.followers("c"));
		assertEquals("'d'", seq.followers("c"));
		assertEquals("'b', 'c', 'd', null", mult.followers("d"));
		assertEquals("null", seq.followers("d"));
	}

	@Test public void testUnordered3() {
		StringProduction p = sp("'a' ('b'? & 'c')");
		FF mult = new FF(p).setUnorderedStrategy(MULIT_ALTERNATIVE);
		FF seq = new FF(p).setUnorderedStrategy(SEQUENCE);
		assertEquals("'b', 'c'", mult.followers("a"));
		assertEquals("'b', 'c'", seq.followers("a"));
		assertEquals("'b', 'c', null", mult.followers("b"));
		assertEquals("'c'", seq.followers("b"));
		assertEquals("'b', 'c', null", mult.followers("c"));
		assertEquals("null", seq.followers("c"));
	}

	@Test public void testUnordered4() {
		StringProduction p = sp("'a' ('b'? & 'c'?)");
		FF mult = new FF(p).setUnorderedStrategy(MULIT_ALTERNATIVE);
		FF seq = new FF(p).setUnorderedStrategy(SEQUENCE);
		assertEquals("'b', 'c', null", mult.followers("a"));
		assertEquals("'b', 'c', null", seq.followers("a"));
		assertEquals("'b', 'c', null", mult.followers("b"));
		assertEquals("'c', null", seq.followers("b"));
		assertEquals("'b', 'c', null", mult.followers("c"));
		assertEquals("null", seq.followers("c"));
	}

	@Test public void testStarts1() {
		StringProduction p = sp("'a'");
		assertEquals("'a'", new FF(p).starts());
	}

	@Test public void testStarts2() {
		StringProduction p = sp("'a'?");
		assertEquals("'a', null", new FF(p).starts());
	}

	@Test public void testStarts3() {
		StringProduction p = sp("'a'*");
		assertEquals("'a', null", new FF(p).starts());
	}

	@Test public void testStarts4() {
		StringProduction p = sp("'a' 'b'");
		assertEquals("'a'", new FF(p).starts());
	}

	@Test public void testStarts5() {
		StringProduction p = sp("'a'? 'b'");
		assertEquals("'a', 'b'", new FF(p).starts());
	}

	@Test public void testStarts6() {
		StringProduction p = sp("('a' | 'b') 'c'");
		assertEquals("'a', 'b'", new FF(p).starts());
	}

	@Test public void testStarts7() {
		StringProduction p = sp("('a' | 'b')*");
		assertEquals("'a', 'b', null", new FF(p).starts());
	}

	@Test public void testStarts8() {
		StringProduction p = sp("('a' 'b')*");
		assertEquals("'a', null", new FF(p).starts());
	}

	@Test public void testStarts9() {
		StringProduction p = sp("('a' & 'b')*");
		assertEquals("'a', 'b', null", new FF(p).starts());
	}

}
