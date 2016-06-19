/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.formatter;

import java.io.IOException;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.formatting.IElementMatcherProvider;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IAfterElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IBeforeElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IBetweenElements;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IElementMatcherExtension;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IElementPattern;
import org.eclipse.xtext.formatting.impl.AbstractTokenStream;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess.LoopElements;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess.OptionalCallsElements;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess.RuleCallsElements;
import org.eclipse.xtext.parsetree.formatter.services.ElementMatcherTestLanguageGrammarAccess.SimpleElements;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ElementMatcherTest extends AbstractXtextTests {
	
	private ElementMatcherTestLanguageGrammarAccess g;

	private static class Patterns {
		private List<IElementPattern> patterns = Lists.newArrayList();

		public void after(final AbstractElement ele) {
			after("!", ele);
		}

		public void after(final String name, final AbstractElement ele) {
			patterns.add(new IAfterElement() {
				@Override
				public AbstractElement matchAfter() {
					return ele;
				}

				@Override
				public String toString() {
					return name;
				}
			});
		}

		public void before(final AbstractElement ele) {
			before("!", ele);
		}

		public void before(final String name, final AbstractElement ele) {
			patterns.add(new IBeforeElement() {
				@Override
				public AbstractElement matchBefore() {
					return ele;
				}

				@Override
				public String toString() {
					return name;
				}
			});
		}

		public void between(final AbstractElement first, final AbstractElement second) {
			between("!", first, second);
		}

		public void between(final String name, final AbstractElement first, final AbstractElement second) {
			patterns.add(new IBetweenElements() {
				@Override
				public Pair<AbstractElement, AbstractElement> matchBetween() {
					return Tuples.create(first, second);
				}

				@Override
				public String toString() {
					return name;
				}
			});
		}
	}

	private String match(String model, Patterns patterns) throws Exception {
		EObject m = getModel(model);
		IElementMatcherProvider mp = get(IElementMatcherProvider.class);
		final IElementMatcherExtension<IElementPattern> matcher = (IElementMatcherExtension<IElementPattern>) mp
				.createMatcher(patterns.patterns);
		final StringBuilder result = new StringBuilder();
		getParseTreeConstructor().serializeSubtree(m, new AbstractTokenStream() {
			@Override
			public void writeSemantic(EObject grammarElement, String value) throws IOException {
				Iterable<IElementPattern> matches = matcher.matchNext((AbstractElement) grammarElement);
				for (IElementPattern m : matches) {
					result.append(" ");
					result.append(m.toString());
				}
				result.append(" ");
				result.append(value);
			}

			@Override
			public void init(ParserRule startRule) {
				matcher.init(startRule);
			}
		});
		for (IElementPattern m2 : matcher.finish()) {
			result.append(" ");
			result.append(m2.toString());
		}
		//		String file = "src/" + getClass().getName().replace('.', '/') + "-" + getName() + ".pdf";
		//		new ElementMatcherToDot().draw(matcher, file, "-T pdf");
		return result.toString().trim();
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(ElementMatcherTestLanguageStandaloneSetup.class);
		g = (ElementMatcherTestLanguageGrammarAccess) getGrammarAccess();
	}

	@Test public void testSimple1() throws Exception {
		Patterns pattern = new Patterns();
		pattern.after(g.getSimpleAccess().getNumberSignDigitOneKeyword_0());
		pattern.before(g.getSimpleAccess().getKw1Keyword_2_0());
		assertEquals("#1 ! abc ! kw1 efg long.name", match("#1 abc kw1 efg long.name", pattern));
	}

	@Test public void testSimpleAssignments() throws Exception {
		Patterns pattern = new Patterns();
		pattern.after(g.getSimpleAccess().getNameAssignment_1());
		pattern.before(g.getSimpleAccess().getOptionalAssignment_2_1());
		pattern.before(g.getSimpleAccess().getDatatypeAssignment_3());
		assertEquals("#1 abc ! kw1 ! efg ! long.name", match("#1 abc kw1 efg long.name", pattern));
	}

	@Test public void testSimpleGroup1() throws Exception {
		Patterns pattern = new Patterns();
		pattern.before(g.getSimpleAccess().getGroup_2());
		assertEquals("#1 abc ! kw1 efg long.name", match("#1 abc kw1 efg long.name", pattern));
	}

	@Test public void testSimpleGroup2() throws Exception {
		Patterns pattern = new Patterns();
		pattern.after(g.getSimpleAccess().getGroup_2());
		assertEquals("#1 abc kw1 efg ! long.name", match("#1 abc kw1 efg long.name", pattern));
	}

	@Test public void testSimpleGroup3() throws Exception {
		Patterns pattern = new Patterns();
		pattern.before(g.getSimpleAccess().getGroup());
		pattern.after(g.getSimpleAccess().getGroup());
		assertEquals("! #1 abc kw1 efg long.name !", match("#1 abc kw1 efg long.name", pattern));
	}

	@Test public void testSimpleBetween1() throws Exception {
		SimpleElements se = g.getSimpleAccess();
		Patterns pattern = new Patterns();
		pattern.between(se.getNumberSignDigitOneKeyword_0(), se.getNameIDTerminalRuleCall_1_0());
		assertEquals("#1 ! abc kw1 efg long.name", match("#1 abc kw1 efg long.name", pattern));
	}

	@Test public void testSimpleBetween2() throws Exception {
		SimpleElements se = g.getSimpleAccess();
		Patterns pattern = new Patterns();
		pattern.between(se.getNumberSignDigitOneKeyword_0(), se.getNameAssignment_1());
		assertEquals("#1 ! abc kw1 efg long.name", match("#1 abc kw1 efg long.name", pattern));
	}

	@Test public void testSimpleBetween3() throws Exception {
		SimpleElements se = g.getSimpleAccess();
		Patterns pattern = new Patterns();
		pattern.between(se.getNameIDTerminalRuleCall_1_0(), se.getDatatypeAssignment_3());
		assertEquals("#1 abc ! long.name", match("#1 abc long.name", pattern));
		assertEquals("#1 abc kw1 efg long.name", match("#1 abc kw1 efg long.name", pattern));
	}

	@Test public void testSimpleBetween4() throws Exception {
		SimpleElements se = g.getSimpleAccess();
		Patterns pattern = new Patterns();
		pattern.between(se.getGroup_2(), se.getDatatypeFQNParserRuleCall_3_0());
		assertEquals("#1 abc long.name", match("#1 abc long.name", pattern));
		assertEquals("#1 abc kw1 efg ! long.name", match("#1 abc kw1 efg long.name", pattern));
	}

	@Test public void testRuleCalls1() throws Exception {
		RuleCallsElements rce = g.getRuleCallsAccess();
		Patterns pattern = new Patterns();
		pattern.before(rce.getRuleCallsSubParserRuleCall_1());
		assertEquals("#2 ! sub foo", match("#2 sub foo", pattern));
	}

	@Test public void testRuleCalls2() throws Exception {
		RuleCallsElements rce = g.getRuleCallsAccess();
		Patterns pattern = new Patterns();
		pattern = new Patterns();
		pattern.between(rce.getRuleCallsSubParserRuleCall_1(), rce.getNameAssignment_2());
		assertEquals("#2 sub ! foo", match("#2 sub foo", pattern));
	}

	@Test public void testRuleCalls3() throws Exception {
		RuleCallsElements rce = g.getRuleCallsAccess();
		Patterns pattern = new Patterns();
		pattern.between(rce.getNameAssignment_2(), rce.getCall1Assignment_3());
		pattern.between(rce.getNameAssignment_2(), rce.getCall2Assignment_4());
		assertEquals("#2 sub foo ! ass1 bar ass2 zonk", match("#2 sub foo ass1 bar ass2 zonk", pattern));
		assertEquals("#2 sub foo ! ass2 zonk", match("#2 sub foo ass2 zonk", pattern));
	}

	@Test public void testRuleCalls4() throws Exception {
		Patterns pattern = new Patterns();
		pattern.before(g.getRuleCallsSubAccess().getSubAssignment());
		pattern.after(g.getRuleCallsSubAccess().getSubAssignment());
		assertEquals("#2 ! sub ! foo", match("#2 sub foo", pattern));
	}

	@Test public void testRuleCalls5() throws Exception {
		Patterns pattern = new Patterns();
		pattern.before(g.getRuleCallsAss1Access().getGroup());
		pattern.after(g.getRuleCallsAss1Access().getGroup());
		assertEquals("#2 sub foo ! ass1 foo !", match("#2 sub foo ass1 foo", pattern));
	}

	@Test public void testRuleCalls6() throws Exception {
		Patterns pattern = new Patterns();
		pattern.before(g.getRuleCallsAss2Access().getGroup());
		pattern.after(g.getRuleCallsAss2Access().getGroup());
		assertEquals("#2 sub foo ass1 bar ! ass2 zonk !", match("#2 sub foo ass1 bar ass2 zonk", pattern));
	}

	@Test public void testRuleCalls7() throws Exception {
		Patterns pattern = new Patterns();
		pattern.before(g.getRuleCallsAccess().getCall1Assignment_3());
		pattern.after(g.getRuleCallsAccess().getCall1Assignment_3());
		assertEquals("#2 sub foo ! ass1 bar ! ass2 zonk", match("#2 sub foo ass1 bar ass2 zonk", pattern));
	}

	@Test public void testRuleCalls8() throws Exception {
		Patterns pattern = new Patterns();
		pattern.before(g.getRuleCallsAccess().getCall2Assignment_4());
		pattern.after(g.getRuleCallsAccess().getCall2Assignment_4());
		assertEquals("#2 sub foo ass1 bar ! ass2 zonk !", match("#2 sub foo ass1 bar ass2 zonk", pattern));
	}

	@Test public void testRuleCalls9() throws Exception {
		Patterns pattern = new Patterns();
		pattern.before(g.getRuleCallsSubAccess().getSubAssignment());
		pattern.after(g.getRuleCallsSubAccess().getSubAssignment());
		assertEquals("#2 ! sub ! foo", match("#2 sub foo", pattern));
	}
	
	@Test public void testRuleCalls10() throws Exception {
		Patterns pattern = new Patterns();
		pattern.before(g.getRuleCallsAccess().getCall1Assignment_3());
		pattern.after(g.getRuleCallsAccess().getCall1Assignment_3());
		assertEquals("#2 sub foo ass2 bar", match("#2 sub foo ass2 bar", pattern));
	}

	@Test public void testOptionalCalls1() throws Exception {
		OptionalCallsElements oce = g.getOptionalCallsAccess();
		Patterns pattern = new Patterns();
		pattern.between(oce.getNumberSignDigitThreeKeyword_0(), oce.getNameAssignment_3());
		assertEquals("#3 ! foo", match("#3 foo", pattern));
	}

	@Test public void testOptionalCalls2() throws Exception {
		OptionalCallsElements oce = g.getOptionalCallsAccess();
		Patterns pattern = new Patterns();
		pattern.between(oce.getNumberSignDigitThreeKeyword_0(), g.getOptionalCallsSub1Access().getSubKeyword_2());
		pattern.between(g.getOptionalCallsSub1Access().getSubKeyword_2(), oce.getNameAssignment_3());
		assertEquals("#3 ! sub ! foo", match("#3 sub foo", pattern));
	}

	@Test public void testOptionalCalls3() throws Exception {
		OptionalCallsElements oce = g.getOptionalCallsAccess();
		Patterns pattern = new Patterns();
		pattern.between(oce.getNumberSignDigitThreeKeyword_0(), g.getOptionalCallsSub2Access().getSub2Keyword_0());
		pattern.between(g.getOptionalCallsSub3Access().getNameAssignment_1(), oce.getNameAssignment_3());
		assertEquals("#3 ! sub2 foo sub sub3 bar ! baz", match("#3 sub2 foo sub sub3 bar baz", pattern));
	}

	@Test public void testRecursion() throws Exception {
		disableSerializerTest();
		Patterns p = new Patterns();
		p.after(g.getRecursionSubAccess().getLeftCurlyBracketKeyword_1());
		p.before(g.getRecursionSubAccess().getRightCurlyBracketKeyword_3());
		assertEquals("#4 { ! bar { ! foo ! } { ! { ! zonk ! } ! } ! }", match("#4 { { foo } bar { { zonk } } }", p));
	}

	@Test public void testLoop1() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.before(le.getNamesAssignment_1());
		assertEquals("#5 ! foo ! bar ! baz", match("#5 foo bar baz", p));
	}

	@Test public void testLoop2() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.after(le.getNamesAssignment_1());
		assertEquals("#5 foo ! bar ! baz !", match("#5 foo bar baz", p));
	}

	@Test public void testLoop3() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.between(le.getNamesAssignment_1(), le.getNamesAssignment_1());
		assertEquals("#5 foo ! bar ! baz", match("#5 foo bar baz", p));
	}

	@Test public void testLoop4() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.before(le.getGroup_2());
		assertEquals("#5 foo bar ! gr grfoo ! gr grbar", match("#5 foo bar gr grfoo gr grbar", p));
	}

	@Test public void testLoop5() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.after(le.getGroup_2());
		assertEquals("#5 foo bar gr grfoo ! gr grbar !", match("#5 foo bar gr grfoo gr grbar", p));
	}

	@Test public void testLoop6() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.between(le.getGroup_2(), le.getGroup_2());
		assertEquals("#5 foo bar gr grfoo ! gr grbar", match("#5 foo bar gr grfoo gr grbar", p));
	}

	@Test public void testLoop7() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.between(le.getNamesAssignment_1(), le.getGroup_2());
		assertEquals("#5 foo bar ! gr grfoo gr grbar", match("#5 foo bar gr grfoo gr grbar", p));
	}

	@Test public void testLoop8() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.before(le.getAlternatives_3());
		assertEquals("#5 x gr gf gr gb ! '1' ! '2' ! 1 ! 2", match("#5 x gr gf gr gb '1' '2' 1 2", p));
	}

	@Test public void testLoop9() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.after(le.getAlternatives_3());
		assertEquals("#5 x gr gf gr gb '1' ! '2' ! 1 ! 2 !", match("#5 x gr gf gr gb '1' '2' 1 2", p));
	}

	@Test public void testLoop10() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.between(le.getAlternatives_3(), le.getAlternatives_3());
		assertEquals("#5 x gr gf gr gb '1' ! '2' ! 1 ! 2", match("#5 x gr gf gr gb '1' '2' 1 2", p));
	}

	@Test public void testLoop11() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.between(le.getGroup_2(), le.getAlternatives_3());
		assertEquals("#5 x gr gf gr gb ! '1' '2' 1 2", match("#5 x gr gf gr gb '1' '2' 1 2", p));
	}

	@Test public void testLoop12() throws Exception {
		LoopElements le = g.getLoopAccess();
		Patterns p = new Patterns();
		p.between(le.getNamesAssignment_1(), le.getAlternatives_3());
		assertEquals("#5 x gr gf gr gb '1' '2' 1 2", match("#5 x gr gf gr gb '1' '2' 1 2", p));
		assertEquals("#5 x ! '1' '2' 1 2", match("#5 x '1' '2' 1 2", p));
	}

	@Test public void testExpression1() throws Exception {
		Patterns p = new Patterns();
		p.before("<p", g.getAddAccess().getPlusSignKeyword_1_1());
		p.after("p>", g.getAddAccess().getPlusSignKeyword_1_1());
		p.before("<f", g.getPrimAccess().getLeftParenthesisKeyword_1_2());
		p.after("f>", g.getPrimAccess().getRightParenthesisKeyword_1_5());
		String expected1 = "#6 1 <p + p> 2 * 4 * ( 3 <p + p> 4 <p + p> foo <f ( 4 , 6 <p + p> 7 ) f> )";
		assertEquals(expected1, match("#6 1 + 2 * 4 * ((3 + 4) + foo(4, 6 +7))", p));
	}

	@Test public void testExpression2() throws Exception {
		Patterns p = new Patterns();
		p.before("<", g.getPrimAccess().getValAssignment_0_1());
		p.after(">", g.getPrimAccess().getValAssignment_0_1());
		String expected2 = "#6 < 1 > + < 2 > * < 4 > * ( < 3 > + < 4 > + foo ( < 4 > , < 6 > + < 7 > ) )";
		assertEquals(expected2, match("#6 1 + 2 * 4 * ((3 + 4) + foo(4, 6 +7))", p));
	}

	@Test public void testExpression3() throws Exception {
		Patterns p = new Patterns();
		p.before("<", g.getPrimAccess().getAddParserRuleCall_3_1());
		p.after(">", g.getPrimAccess().getAddParserRuleCall_3_1());
		String expected3 = "#6 ( < 1 + 2 > ) * 4 * ( < 3 + 4 * ( < 5 + 5 > ) + foo ( 4 , 6 * ( < 7 + 9 > ) ) > )";
		assertEquals(expected3, match("#6 (1 + 2) * 4 * ((3 + 4 * (5 + 5)) + foo(4, 6 * (7 + 9)))", p));
	}

	@Test public void testExpression4() throws Exception {
		Patterns p = new Patterns();
		p.before("(", g.getPrimAccess().getTargetAssignment_2_2());
		p.after(")", g.getPrimAccess().getTargetAssignment_2_2());
		String expected4 = "#6 => ( => ( => ( => ( 5 ) ) ) )";
		assertEquals(expected4, match("#6 => => => => 5", p));
	}

	@Test public void testExpression5() throws Exception {
		Patterns p = new Patterns();
		p.before("<", g.getAddAccess().getRightAssignment_1_2());
		p.after(">", g.getAddAccess().getRightAssignment_1_2());
		String expected5 = "#6 1 + < 2 * ( 3 + < 4 * ( 5 + < 6 * 7 > ) > ) >";
		assertEquals(expected5, match("#6 1 + 2 * (3 + 4 * (5 + 6 * 7))", p));
		String expected6 = "#6 4 * ( 3 + < 4 * 5 > + < 6 > )";
		assertEquals(expected6, match("#6 4 * ((3 + 4 * 5) + 6)", p));
		String expected = "#6 ( 1 + < 2 > ) * 4 * ( 3 + < 4 * ( 5 + < 5 > ) > + < foo ( 4 , 6 * ( 7 + < 9 > ) ) > )";
		assertEquals(expected, match("#6 (1 + 2) * 4 * ((3 + 4 * (5 + 5)) + foo(4, 6 * (7 + 9)))", p));
	}

	@Test public void testExpression6() throws Exception {
		Patterns p = new Patterns();
		p.between(g.getPrimAccess().getRightParenthesisKeyword_3_2(), g.getMultAccess().getAsteriskKeyword_1_1());
		assertEquals("#6 ( 5 + 4 ) ! * 7", match("#6 (5 + 4) * 7", p));
	}

	@Test public void testRuleCalls2a() throws Exception {
		disableSerializerTest();
		Patterns p = new Patterns();
		p.before(g.getConstructorRule().getAlternatives());
		p.after(g.getConstructorRule().getAlternatives());
		assertEquals("#7 ! kw1 ! foo kw2 kw3", match("#7 kw1 foo kw2 kw3", p));
		assertEquals("#7 ! kw1 ! foo kw3", match("#7 kw1 foo kw3", p));
		//		assertEquals("#7 ! ! foo kw2 kw3", match("#7 foo kw2 kw3", p));
		//		assertEquals("#7 ! ! foo kw3", match("#7 foo kw3", p));
	}

	@Test public void testRuleCalls2b() throws Exception {
		disableSerializerTest();
		Patterns p = new Patterns();
		p.before(g.getFieldRule().getAlternatives());
		p.after(g.getFieldRule().getAlternatives());
		assertEquals("#7 kw1 ! foo kw2 ! kw3", match("#7 kw1 foo kw2 kw3", p));
		assertEquals("#7 kw1 ! foo ! kw3", match("#7 kw1 foo kw3", p));
		assertEquals("#7 ! foo kw2 ! kw3", match("#7 foo kw2 kw3", p));
		assertEquals("#7 ! foo ! kw3", match("#7 foo kw3", p));
	}

	@Test public void testRuleCalls2c() throws Exception {
		disableSerializerTest();
		Patterns p = new Patterns();
		p.before(g.getParameterRule().getAlternatives());
		p.after(g.getParameterRule().getAlternatives());
		assertEquals("#7 kw1 foo ! kw2 ! kw3", match("#7 kw1 foo kw2 kw3", p));
		//		assertEquals("#7 kw1 foo ! ! kw3", match("#7 kw1 foo kw3", p));
		assertEquals("#7 foo ! kw2 ! kw3", match("#7 foo kw2 kw3", p));
		//		assertEquals("#7 foo ! ! kw3", match("#7 foo kw3", p));
	}

	@Test public void testNestedStart() throws Exception {
		Patterns p = new Patterns();
		p.after(g.getNestedStartSubAccess().getGroup());
		assertEquals("#8 ! foo", match("#8 foo", p));
	}

	@Test public void testNestedStart2() throws Exception {
		Patterns p = new Patterns();
		p.after(g.getNestedStartAccess().getGroup());
		p.before(g.getNestedStartAccess().getGroup());
		assertEquals("! #8 foo !", match("#8 foo", p));
	}
}
