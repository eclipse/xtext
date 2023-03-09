/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.IContextTypePDAProvider;
import org.eclipse.xtext.serializer.analysis.ISerState;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap.Entry;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaListFormatter;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContextTypePDAProviderTest extends AbstractXtextTests {
	private static class ToStr implements Function<ISerState, String> {
		private Function<AbstractElement, String> ts = new GrammarElementTitleSwitch().showAssignments()
				.hideCardinality().showQualified();

		@Override
		public String apply(ISerState from) {
			switch (from.getType()) {
				case START:
					return "start";
				case STOP:
					return "stop";
				default:
					return ts.apply(from.getGrammarElement());
			}
		}
	}

	final static String HEADER = "grammar org.eclipse.xtext.serializer.SequenceParserPDAProviderTestLanguage"
			+ " with org.eclipse.xtext.common.Terminals "
			+ "generate sequenceParserPDAProviderTest \"http://www.eclipse.org/2010/tmf/xtext/SequenceParserPDAProvider\"  ";

	protected String getParserRule(String body) throws Exception {
		Grammar grammar = (Grammar) getModel(HEADER + body);
		// drawGrammar("pdf/" + getName(), grammar);
		List<String> result = Lists.newArrayList();
		PdaListFormatter<ISerState, RuleCall> formatter = new PdaListFormatter<ISerState, RuleCall>();
		formatter.setStateFormatter(new ToStr());
		formatter.setStackitemFormatter(new GrammarElementTitleSwitch().showAssignments().hideCardinality());
		formatter.sortFollowers();
		IContextTypePDAProvider typePDAProvider = get(IContextTypePDAProvider.class);
		SerializationContextMap<Pda<ISerState, RuleCall>> pdas = typePDAProvider.getContextTypePDAs(grammar);
		for (Entry<Pda<ISerState, RuleCall>> ctx : pdas.sortedCopy().values()) {
			result.add(Joiner.on(", ").join(ctx.getContexts()) + ":");
			result.add("  " + formatter.format(ctx.getValue()).replace("\n", "\n  "));
		}
		return Joiner.on("\n").join(result);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test
	public void testKeywordAlternative() throws Exception {
		String actual = getParserRule("Rule: a1=ID ('kw1' | 'kw2') a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  start -> a1=ID\n");
		expected.append("  'kw1' -> a2=ID\n");
		expected.append("  'kw2' -> a2=ID\n");
		expected.append("  a1=ID -> 'kw1', 'kw2'\n");
		expected.append("  a2=ID -> stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testDelegation1() throws Exception {
		String actual = getParserRule("Rule: Delegate; Delegate: val=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Delegate, Delegate returns Delegate:\n");
		expected.append("  start -> val=ID\n");
		expected.append("  val=ID -> stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testLoop1() throws Exception {
		String actual = getParserRule("Rule: ('x' x=ID*)*;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  start -> 'x'\n");
		expected.append("  'x' -> 'x', stop, x=ID\n");
		expected.append("  x=ID -> 'x', stop, x=ID\n");
		expected.append("Rule returns null:\n");
		expected.append("  start -> 'x', stop\n");
		expected.append("  'x' -> 'x', stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testLoop2() throws Exception {
		String actual = getParserRule("Model: (('x' x+=ID*) | ('y' y+=ID*))*;");
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Model:\n");
		expected.append("  start -> 'x', 'y'\n");
		expected.append("  'x' -> 'x', 'y', stop, x+=ID\n");
		expected.append("  'y' -> 'x', 'y', stop, y+=ID\n");
		expected.append("  x+=ID -> 'x', 'y', stop, x+=ID\n");
		expected.append("  y+=ID -> 'x', 'y', stop, y+=ID\n");
		expected.append("Model returns null:\n");
		expected.append("  start -> 'x', 'y', stop\n");
		expected.append("  'x' -> 'x', 'y', stop\n");
		expected.append("  'y' -> 'x', 'y', stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testDelegation2() throws Exception {
		String actual = getParserRule(
				"Rule: Foo | Delegate1; Delegate1: 'del' Delegate2 bar=ID; Delegate2: val=ID; Foo: val2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Delegate2, Delegate1 returns Delegate2:\n");
		expected.append("  start -> 'del'\n");
		expected.append("  'del' -> val=ID\n");
		expected.append("  bar=ID -> stop\n");
		expected.append("  val=ID -> bar=ID\n");
		expected.append("Rule returns Foo, Foo returns Foo:\n");
		expected.append("  start -> val2=ID\n");
		expected.append("  val2=ID -> stop\n");
		expected.append("Delegate2 returns Delegate2:\n");
		expected.append("  start -> val=ID\n");
		expected.append("  val=ID -> stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testExpression1() throws Exception {
		String actual = getParserRule(
				"Exp: 'kw' Addit; Addit returns Exp: Prim ({Add.left=current} '+' right=Prim)*; Prim returns Exp: {Val} val=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Exp returns Add:\n");
		expected.append("  start -> 'kw'\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  'kw' -> {Add.left=}\n");
		expected.append("  right=Prim -> stop\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("Exp returns Val:\n");
		expected.append("  start -> 'kw'\n");
		expected.append("  'kw' -> {Val}\n");
		expected.append("  val=ID -> stop\n");
		expected.append("  {Val} -> val=ID\n");
		expected.append("Addit returns Add, Addit.Add_1_0 returns Add:\n");
		expected.append("  start -> {Add.left=}\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  right=Prim -> stop\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("Addit returns Val, Addit.Add_1_0 returns Val, Prim returns Val:\n");
		expected.append("  start -> {Val}\n");
		expected.append("  val=ID -> stop\n");
		expected.append("  {Val} -> val=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testExpression2() throws Exception {
		String actual = getParserRule(
				"Addition returns Expr: Prim ({Add.left=current} '+' right=Prim)*; Prim returns Expr: {Val} name=ID | '(' Addition ')';");
		StringBuilder expected = new StringBuilder();
		expected.append("Addition returns Add, Addition.Add_1_0 returns Add:\n");
		expected.append("  start -> '(', {Add.left=}\n");
		expected.append("  '(' -> >>Addition\n");
		expected.append("  ')' -> <<Addition, stop\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  <<Addition -> ')'\n");
		expected.append("  >>Addition -> '(', {Add.left=}\n");
		expected.append("  right=Prim -> <<Addition, stop\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("Addition returns Val, Addition.Add_1_0 returns Val, Prim returns Val:\n");
		expected.append("  start -> '(', {Val}\n");
		expected.append("  '(' -> >>Addition\n");
		expected.append("  ')' -> <<Addition, stop\n");
		expected.append("  <<Addition -> ')'\n");
		expected.append("  >>Addition -> '(', {Val}\n");
		expected.append("  name=ID -> <<Addition, stop\n");
		expected.append("  {Val} -> name=ID\n");
		expected.append("Prim returns Add:\n");
		expected.append("  start -> '('\n");
		expected.append("  '(' -> >>Addition\n");
		expected.append("  ')' -> <<Addition, stop\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  <<Addition -> ')'\n");
		expected.append("  >>Addition -> '(', {Add.left=}\n");
		expected.append("  right=Prim -> <<Addition\n");
		expected.append("  {Add.left=} -> '+'");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testOptionalDelegate() throws Exception {
		String actual = getParserRule("Rule: Mand | Opt; Mand: 'm' mand=ID; Opt: 'o' opt=ID?;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Mand, Mand returns Mand:\n");
		expected.append("  start -> 'm'\n");
		expected.append("  'm' -> mand=ID\n");
		expected.append("  mand=ID -> stop\n");
		expected.append("Rule returns Opt, Opt returns Opt:\n");
		expected.append("  start -> 'o'\n");
		expected.append("  'o' -> opt=ID\n");
		expected.append("  opt=ID -> stop\n");
		expected.append("Rule returns null, Opt returns null:\n");
		expected.append("  start -> 'o'\n");
		expected.append("  'o' -> stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testUnassignedDatatypeRuleCall() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: {Model} 'kw1' ({Foo.child=current} Sub)*;\n");
		grammar.append("Sub: 'kw2' 'kw3';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Foo, Model.Foo_2_0 returns Foo:\n");
		expected.append("  start -> {Foo.child=}\n");
		expected.append("  Sub -> stop\n");
		expected.append("  {Foo.child=} -> Sub\n");
		expected.append("Model returns Model, Model.Foo_2_0 returns Model:\n");
		expected.append("  start -> {Model}\n");
		expected.append("  'kw1' -> stop\n");
		expected.append("  {Model} -> 'kw1'");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testUnorderedGroup() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: 'model' '{' (greetings1+=ID+ & greetings2+=ID*) '}';");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Model:\n");
		expected.append("  start -> 'model'\n");
		expected.append("  'model' -> '{'\n");
		expected.append("  '{' -> greetings1+=ID, greetings2+=ID\n");
		expected.append("  '}' -> stop\n");
		expected.append("  greetings1+=ID -> '}', greetings1+=ID, greetings2+=ID\n");
		expected.append("  greetings2+=ID -> '}', greetings1+=ID, greetings2+=ID\n");
		expected.append("Model returns null:\n");
		expected.append("  start -> 'model'\n");
		expected.append("  'model' -> '{'\n");
		expected.append("  '{' -> '}'\n");
		expected.append("  '}' -> stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testWildcardFragment() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Rule: F; fragment F*:name=ID;");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  start -> >>F\n");
		expected.append("  <<F -> stop\n");
		expected.append("  >>F -> name=ID\n");
		expected.append("  name=ID -> <<F");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testActionFragment() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Rule: val1=ID ('kw1' {A.c=current})? F; fragment F:val2=ID;");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns A:\n");
		expected.append("  start -> {A.c=}\n");
		expected.append("  <<F -> stop\n");
		expected.append("  >>F -> val2=ID\n");
		expected.append("  val2=ID -> <<F\n");
		expected.append("  {A.c=} -> >>F\n");
		expected.append("Rule returns Rule:\n");
		expected.append("  start -> val1=ID\n");
		expected.append("  <<F -> stop\n");
		expected.append("  >>F -> val2=ID\n");
		expected.append("  val1=ID -> >>F\n");
		expected.append("  val2=ID -> <<F\n");
		expected.append("Rule.A_1_1 returns Rule:\n");
		expected.append("  start -> val1=ID\n");
		expected.append("  'kw1' -> stop\n");
		expected.append("  val1=ID -> 'kw1'");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testParameters() throws Exception {
		String actual = getParserRule("M: 'kw1' s=S<true> | 'kw2' s=S<false>; S <P>: <P> v1=ID | <!P> v2=ID;  ");
		StringBuilder expected = new StringBuilder();
		expected.append("M returns M:\n");
		expected.append("  start -> 'kw1', 'kw2'\n");
		expected.append("  'kw1' -> (s=S|)\n");
		expected.append("  'kw2' -> (|s=S)\n");
		expected.append("  (s=S|) -> stop\n");
		expected.append("  (|s=S) -> stop\n");
		expected.append("S<P> returns S:\n");
		expected.append("  start -> v1=ID\n");
		expected.append("  v1=ID -> stop\n");
		expected.append("S returns S:\n");
		expected.append("  start -> v2=ID\n");
		expected.append("  v2=ID -> stop");
		assertEquals(expected.toString(), actual);
	}
}
