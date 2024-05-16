/**
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.util.Strings;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarFlatteningTest extends AbstractXtextTests {
	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Override
	public Grammar getModel(String model) throws Exception {
		return getModel(model, false);
	}

	public Grammar getModel(String model, boolean dropUnreachable) throws Exception {
		Grammar grammar = ((Grammar) super.getModel(model));
		RuleNames ruleNames = RuleNames.getRuleNames(grammar, false);
		RuleFilter filter = new RuleFilter();
		filter.setDiscardUnreachableRules(dropUnreachable);
		Grammar result = new FlattenedGrammarAccess(ruleNames, filter).getFlattenedGrammar();
		XtextResource resource = get(XtextResource.class);
		resource.getContents().add(result);
		resource.setURI(URI.createURI("synthetic://flattened.xtext"));
		return result;
	}

	@Test
	public void test_01() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule: name=ID;";
		Grammar flattened = getModel(grammar);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	name=RULE_ID;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Test
	public void test_02() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule: name=ID;\n" +
				"terminal ID: super;";
		Grammar flattened = getModel(grammar);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	name=RULE_ID;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	SUPER_ID;\n" +
				"\n" +
				"terminal fragment SUPER_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Test
	public void test_03() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule<A, B>: <A> name=ID | <!B> name=ID | name=STRING;";
		Grammar flattened = getModel(grammar);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	name=RULE_ID | name=RULE_STRING;\n" +
				"\n" +
				"norm1_Rule:\n" +
				"	name=RULE_ID | name=RULE_ID | name=RULE_STRING;\n" +
				"\n" +
				"norm2_Rule:\n" +
				"	name=RULE_STRING;\n" +
				"\n" +
				"norm3_Rule:\n" +
				"	name=RULE_ID | name=RULE_STRING;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Test
	public void test_04() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule<A>: name=ID child=Rule<A>?;";
		Grammar flattened = getModel(grammar);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	name=RULE_ID child=ruleRule?;\n" +
				"\n" +
				"norm1_Rule:\n" +
				"	name=RULE_ID child=norm1_Rule?;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Test
	public void test_05() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule<A>: name=ID (<A>child=Rule<A>|<!A>child=Rule<true>+)?;";
		Grammar flattened = getModel(grammar);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	name=RULE_ID child=norm1_Rule*;\n" +
				"\n" +
				"norm1_Rule:\n" +
				"	name=RULE_ID child=norm1_Rule?;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Test
	public void test_06() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule<A>: name=ID (<A>child=Rule<!A>)?;";
		Grammar flattened = getModel(grammar);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	name=RULE_ID;\n" +
				"\n" +
				"norm1_Rule:\n" +
				"	name=RULE_ID child=ruleRule?;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Test
	public void test_07() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule<A>: name=ID (<A>child=Rule<!A>)?;";
		Grammar flattened = getModel(grammar, true);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	name=RULE_ID;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Test
	public void test_08() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule<A>: name=ID =>(<A> ->child=Rule<!A> | <!A> ->'keyword')?;";
		Grammar flattened = getModel(grammar, true);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	name=RULE_ID => (\"keyword\")?;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Test
	public void test_09() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule<A>: name=ID ->(<A> =>child=Rule<!A> | <!A> =>'keyword')?;";
		Grammar flattened = getModel(grammar, true);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	name=RULE_ID => (\"keyword\")?;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Test
	public void test_10() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"ParserRuleParameters: {ParserRuleParameters} \n" +
				"  ( '#1' scenario=Scenario1<true>\n" +
				"  |\t'#2' scenario=Scenario1<Param=false>\n" +
				"  | '#3' scenario=Scenario2<true>\n" +
				"  | '#4' scenario=Scenario2<false>\n" +
				"  | =>('#5' scenario=Scenario2<true>)\n" +
				"  | =>('#6' scenario=Scenario2<false>)\n" +
				"  | '#7' scenario=Scenario3<true>\n" +
				"  | '#8' scenario=Scenario3<false>\n" +
				"  | '#9' (scenario=Scenario4<true> | scenario=Scenario2<true> 'keyword'?)\n" +
				"  | '#10' (scenario=Scenario4<true> | scenario=Scenario2<false> 'keyword'?)\n" +
				"  | '#11' (scenario=Scenario4<false> | scenario=Scenario2<true> 'keyword'?)\n" +
				"  | '#12' (scenario=Scenario4<false> | scenario=Scenario2<false> 'keyword'?)\n" +
				"  )\n" +
				";\n" +
				"\n" +
				"" +
				"Scenario1<Param> returns Scenario:\n" +
				"	<Param> first=ID\n" +
				"	 | <!Param> second=ID\n" +
				";\n" +
				"\n" +
				"" +
				"Scenario2<AllowKeyword> returns Scenario:\n" +
				"	first=IdOrKeyword<AllowKeyword>\n" +
				";\n" +
				"\n" +
				"" +
				"Scenario3<AllowKeyword> returns Scenario:\n" +
				"	=>first=IdOrKeyword<AllowKeyword>\n" +
				"	| second='keyword'\n" +
				";\n" +
				"\n" +
				"" +
				"Scenario4<AllowKeyword> returns Scenario:\n" +
				"	=>second=IdOrKeyword<AllowKeyword> 'keyword'\n" +
				";\n" +
				"\n" +
				"" +
				"IdOrKeyword<Keyword>:\n" +
				"	<Keyword> 'keyword'\n" +
				"	| ID\n" +
				";";
		Grammar flattened = getModel(grammar, true);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleParserRuleParameters:\n" +
				"	{ParserRuleParameters} (\"#1\" scenario=norm1_Scenario1 | \"#2\" scenario=ruleScenario1 | \"#3\" scenario=norm1_Scenario2\n" +
				"	| \"#4\" scenario=ruleScenario2 | => (\"#5\" scenario=norm1_Scenario2) | => (\"#6\" scenario=ruleScenario2) | \"#7\"\n" +
				"	scenario=norm1_Scenario3 | \"#8\" scenario=ruleScenario3 | \"#9\" (scenario=norm1_Scenario4 | scenario=norm1_Scenario2\n" +
				"	\"keyword\"?) | \"#10\" (scenario=norm1_Scenario4 | scenario=ruleScenario2 \"keyword\"?) | \"#11\" (scenario=ruleScenario4 |\n" +
				"	scenario=norm1_Scenario2 \"keyword\"?) | \"#12\" (scenario=ruleScenario4 | scenario=ruleScenario2 \"keyword\"?));\n" +
				"\n" +
				"ruleScenario1:\n" +
				"	second=RULE_ID;\n" +
				"\n" +
				"norm1_Scenario1:\n" +
				"	first=RULE_ID;\n" +
				"\n" +
				"ruleScenario2:\n" +
				"	first=ruleIdOrKeyword;\n" +
				"\n" +
				"norm1_Scenario2:\n" +
				"	first=norm1_IdOrKeyword;\n" +
				"\n" +
				"ruleScenario3:\n" +
				"	=>first=ruleIdOrKeyword | second=\"keyword\";\n" +
				"\n" +
				"norm1_Scenario3:\n" +
				"	=>first=norm1_IdOrKeyword | second=\"keyword\";\n" +
				"\n" +
				"ruleScenario4:\n" +
				"	=>second=ruleIdOrKeyword \"keyword\";\n" +
				"\n" +
				"norm1_Scenario4:\n" +
				"	=>second=norm1_IdOrKeyword \"keyword\";\n" +
				"\n" +
				"ruleIdOrKeyword:\n" +
				"	RULE_ID;\n" +
				"\n" +
				"norm1_IdOrKeyword:\n" +
				"	\"keyword\" | RULE_ID;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Ignore("Flattened grammar access produces bad grammar?")
	@Test
	public void test_11() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule<A>: name=ID =>(<A> ->child=Rule<!A> | <!A> ->('a' 'b'))?;";
		Grammar flattened = getModel(grammar, true);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	name=RULE_ID => (\"keyword\")?;\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}

	@Test
	public void test_12() throws Exception {
		String grammar =
				"grammar com.foo.bar with org.eclipse.xtext.common.Terminals\n" +
				"generate myPack 'http://myURI'\n" +
				"Rule: =>(name+=ID*);";
		Grammar flattened = getModel(grammar, true);
		String serialized = getSerializer().serialize(flattened);
		String expectation =
				"grammar com.foo.bar hidden(RULE_WS, RULE_ML_COMMENT, RULE_SL_COMMENT)\n" +
				"\n" +
				"ruleRule:\n" +
				"	=> (name+=RULE_ID*);\n" +
				"\n" +
				"terminal RULE_ID:\n" +
				"	\"^\"? (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\") (\"a\"..\"z\" | \"A\"..\"Z\" | \"_\" | \"0\"..\"9\")*;\n" +
				"\n" +
				"terminal RULE_INT:\n" +
				"	\"0\"..\"9\"+;\n" +
				"\n" +
				"terminal RULE_STRING:\n" +
				"	\"\\\"\" (\"\\\\\" . | !(\"\\\\\" | \"\\\"\"))* \"\\\"\" | \"\\'\" (\"\\\\\" . | !(\"\\\\\" | \"\\'\"))* \"\\'\";\n" +
				"\n" +
				"terminal RULE_ML_COMMENT:\n" +
				"	\"/*\"->\"*/\";\n" +
				"\n" +
				"terminal RULE_SL_COMMENT:\n" +
				"	\"//\" !(\"\\n\" | \"\\r\")* (\"\\r\"? \"\\n\")?;\n" +
				"\n" +
				"terminal RULE_WS:\n" +
				"	\" \" | \"\\t\" | \"\\r\" | \"\\n\"+;\n" +
				"\n" +
				"terminal RULE_ANY_OTHER:\n" +
				"	.;";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation), serialized);
	}
}
