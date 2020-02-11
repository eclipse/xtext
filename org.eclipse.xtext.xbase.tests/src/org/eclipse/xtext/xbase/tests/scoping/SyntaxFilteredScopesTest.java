/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.scoping;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.CfgAdapter;
import org.eclipse.xtext.util.formallang.FollowerFunction;
import org.eclipse.xtext.util.formallang.FollowerFunctionImpl;
import org.eclipse.xtext.xbase.scoping.SyntaxFilteredScopes;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SyntaxFilteredScopesTest extends AbstractXbaseTestCase {

	@Inject
	private XbaseGrammarAccess grammarAccess;
	
	@Inject
	private SyntaxFilteredScopes syntaxFilteredScopes;
	
	@Test
	public void test_01() {
		List<String> values = syntaxFilteredScopes.getEnumeratedValues(grammarAccess.getOpPostfixRule());
		assertEquals(Lists.newArrayList("++", "--"), values);
	}
	
	@Test
	public void test_02() {
		List<String> values = syntaxFilteredScopes.getEnumeratedValues(grammarAccess.getOpOtherRule());
		List<String> expectation = Lists.newArrayList(
				"->", 
				"..<",
				">..",
				"..",
				"=>",
				">>", ">>>",
				"<<", "<<<",
				"<>",
				"?:",
				"<=>"
		);
		Collections.sort(expectation);
		Collections.sort(values);
		assertEquals(expectation, values);
	}
	
	@Test
	public void test_03() {
		List<String> values = getEnumeratedValues(grammarAccess.getOpPostfixRule());
		List<String> expectation = Lists.newArrayList(
				"++", "--"
		);
		Collections.sort(expectation);
		Collections.sort(values);
		assertEquals(expectation, values);
	}
	
	@Test
	public void test_04() {
		List<String> values = getEnumeratedValues(grammarAccess.getOpOtherRule());
		List<String> expectation = Lists.newArrayList(
				"->", 
				"..<",
				">..",
				"..",
				"=>",
				">>", ">>>",
				"<<", "<<<",
				"<>",
				"?:",
				"<=>"
		);
		Collections.sort(expectation);
		Collections.sort(values);
		assertEquals(expectation, values);
	}
	
	@Test
	public void test_05() {
		List<AbstractRule> rules = grammarAccess.getGrammar().getRules();
		for(AbstractRule rule: rules) {
			if (GrammarUtil.isDatatypeRule(rule)) {
				List<String> values1 = syntaxFilteredScopes.getEnumeratedValues((ParserRule) rule);
				List<String> values2 = getEnumeratedValues((ParserRule) rule);
				Collections.sort(values1);
				Collections.sort(values2);
				assertEquals(values1, values2);
			}
		}
	}
	
	@Test
	public void test_06() {
		List<AbstractRule> rules = grammarAccess.getGrammar().getRules();
		for(AbstractRule rule: rules) {
			if (GrammarUtil.isDatatypeRule(rule)) {
				List<String> values = getEnumeratedValues((ParserRule) rule);
				assertNotNull(values);
			}
		}
	}
	
	@Test
	public void test_07() {
		List<AbstractRule> rules = grammarAccess.getGrammar().getRules();
		for(AbstractRule rule: rules) {
			if (GrammarUtil.isDatatypeRule(rule)) {
				List<String> values = syntaxFilteredScopes.getEnumeratedValues((ParserRule) rule);
				assertNotNull(values);
			}
		}
	}
	
	@Ignore
	@Test
	public void test_Performance_01() {
		for(int i = 0; i < 2000000; i++) {
			test_01();
		}
	}
	
	@Ignore
	@Test
	public void test_Performance_02() {
		for(int i = 0; i < 2000000; i++) {
			test_02();
		}
	}
	
	@Ignore
	@Test
	public void test_Performance_03() {
		for(int i = 0; i < 2000000; i++) {
			test_03();
		}
	}
	
	@Ignore
	@Test
	public void test_Performance_04() {
		for(int i = 0; i < 2000000; i++) {
			test_04();
		}
	}
	
	@Ignore
	@Test
	public void test_Performance_06() {
		for(int i = 0; i < 2000000; i++) {
			test_06();
		}
	}
	
	@Ignore
	@Test
	public void test_Performance_07() {
		for(int i = 0; i < 2000000; i++) {
			test_07();
		}
	}
	
	// This is an alternative implementation to SyntaxFilteredScopes, but it turns out that it's quite
	// slow compared to the other one based in XtextSwitch
	// However it's kept here to make sure both impl. are working equally well.
	public List<String> getEnumeratedValues(ParserRule rule) {
		CfgAdapter adapter = new CfgAdapter(GrammarUtil.getGrammar(rule));
		FollowerFunction<AbstractElement> followers = new FollowerFunctionImpl<AbstractElement, AbstractElement>(adapter);
		List<String> result = Lists.newArrayList();
		Iterable<AbstractElement> starts = followers.getStarts(rule.getAlternatives());
		collect(starts, null, "", result, followers);
		return result;
	}

	private final AbstractElement DONE = null;
	private boolean collect(Iterable<AbstractElement> followers, AbstractElement currentElement, String currentValue, List<String> result, FollowerFunction<AbstractElement> next) {
		for(AbstractElement follower: followers) {
			if (follower == currentElement || follower instanceof RuleCall || follower != null && GrammarUtil.isMultipleCardinality(follower)) {
				result.clear();
				return false;
			} else if (follower == DONE) {
				result.add(currentValue);
			} else if (follower instanceof Keyword) {
				Iterable<AbstractElement> nextFollowers = next.getFollowers(follower);
				if (!collect(nextFollowers, follower, currentValue + ((Keyword) follower).getValue(), result, next)) {
					return false;
				}
			} else {
				Iterable<AbstractElement> nextFollowers = next.getFollowers(follower);
				if (!collect(nextFollowers, follower, currentValue, result, next)) {
					return false;
				}
			}
		}
		return true;
	}
}
