/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IContextPDAProvider;
import org.eclipse.xtext.serializer.analysis.IContextProvider;
import org.eclipse.xtext.serializer.analysis.ISerState;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaListFormatter;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContextPDAProviderTest extends AbstractXtextTests {
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

	private List<Pair<EObject, String>> getContexts(Grammar grammar) {
		final Context2NameFunction ctx2name = get(Context2NameFunction.class);
		final IContextProvider contextProvider = get(IContextProvider.class);
		List<Pair<EObject, String>> result = Lists.newArrayList();
		for (EObject ctx : contextProvider.getAllContexts(grammar))
			result.add(Tuples.create(ctx, ctx2name.getContextName(grammar, ctx)));
		Collections.sort(result, new Comparator<Pair<EObject, String>>() {
			@Override
			public int compare(Pair<EObject, String> o1, Pair<EObject, String> o2) {
				return o1.getSecond().compareTo(o2.getSecond());
			}
		});
		return result;
	}

	protected String getParserRule(String body) throws Exception {
		Grammar grammar = (Grammar) getModel(HEADER + body);
		List<String> result = Lists.newArrayList();
		PdaListFormatter<ISerState, RuleCall> formatter = new PdaListFormatter<ISerState, RuleCall>();
		formatter.setStateFormatter(new ToStr());
		formatter.setStackitemFormatter(new GrammarElementTitleSwitch().showAssignments().hideCardinality());
		formatter.sortFollowers();
		IContextPDAProvider pdaProvider = get(IContextPDAProvider.class);
		for (Pair<EObject, String> ctx : getContexts(grammar)) {
			result.add(ctx.getSecond() + ":");
			Pda<ISerState, RuleCall> pda = pdaProvider.getContextPDA(ctx.getFirst());
			result.add("  " + formatter.format(pda).replace("\n", "\n  "));
			//			StackTraceElement ele = Thread.currentThread().getStackTrace()[2];
			//			String name = getClass().getSimpleName() + "_" + ele.getMethodName() + "_" + ctx.getSecond() + ".pdf";
			//			new PdaToDot<ISerState, RuleCall>().draw(pda, name, "-T pdf");
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
		expected.append("Rule:\n");
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
		expected.append("Delegate:\n");
		expected.append("  start -> val=ID\n");
		expected.append("  val=ID -> stop\n");
		expected.append("Rule:\n");
		expected.append("  start -> >>Delegate\n");
		expected.append("  <<Delegate -> stop\n");
		expected.append("  >>Delegate -> val=ID\n");
		expected.append("  val=ID -> <<Delegate");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testDelegation2() throws Exception {
		String actual = getParserRule("Rule: Foo | Delegate1; Delegate1: 'del' Delegate2 bar=ID; Delegate2: val=ID; Foo: val2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Delegate1:\n");
		expected.append("  start -> 'del'\n");
		expected.append("  'del' -> >>Delegate2\n");
		expected.append("  <<Delegate2 -> bar=ID\n");
		expected.append("  >>Delegate2 -> val=ID\n");
		expected.append("  bar=ID -> stop\n");
		expected.append("  val=ID -> <<Delegate2\n");
		expected.append("Delegate2:\n");
		expected.append("  start -> val=ID\n");
		expected.append("  val=ID -> stop\n");
		expected.append("Foo:\n");
		expected.append("  start -> val2=ID\n");
		expected.append("  val2=ID -> stop\n");
		expected.append("Rule:\n");
		expected.append("  start -> >>Delegate1, >>Foo\n");
		expected.append("  'del' -> >>Delegate2\n");
		expected.append("  <<Delegate1 -> stop\n");
		expected.append("  <<Delegate2 -> bar=ID\n");
		expected.append("  <<Foo -> stop\n");
		expected.append("  >>Delegate1 -> 'del'\n");
		expected.append("  >>Delegate2 -> val=ID\n");
		expected.append("  >>Foo -> val2=ID\n");
		expected.append("  bar=ID -> <<Delegate1\n");
		expected.append("  val2=ID -> <<Foo\n");
		expected.append("  val=ID -> <<Delegate2");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testActionMandatory() throws Exception {
		String actual = getParserRule("Rule: val1=ID {Act.val2=current} val3=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule:\n");
		expected.append("  start -> {Act.val2=}\n");
		expected.append("  val3=ID -> stop\n");
		expected.append("  {Act.val2=} -> val3=ID\n");
		expected.append("Rule_Act_1:\n");
		expected.append("  start -> val1=ID\n");
		expected.append("  val1=ID -> stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testActionOptional() throws Exception {
		String actual = getParserRule("Rule: val1=ID ({Act.val2=current} val3=ID)?;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule:\n");
		expected.append("  start -> val1=ID, {Act.val2=}\n");
		expected.append("  val1=ID -> stop\n");
		expected.append("  val3=ID -> stop\n");
		expected.append("  {Act.val2=} -> val3=ID\n");
		expected.append("Rule_Act_1_0:\n");
		expected.append("  start -> val1=ID\n");
		expected.append("  val1=ID -> stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testActionManyMandatory() throws Exception {
		String actual = getParserRule("Rule: val1=ID ({Act.val2=current} val3=ID)+;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule:\n");
		expected.append("  start -> {Act.val2=}\n");
		expected.append("  val3=ID -> stop\n");
		expected.append("  {Act.val2=} -> val3=ID\n");
		expected.append("Rule_Act_1_0:\n");
		expected.append("  start -> val1=ID, {Act.val2=}\n");
		expected.append("  val1=ID -> stop\n");
		expected.append("  val3=ID -> stop\n");
		expected.append("  {Act.val2=} -> val3=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testActionManyOptional() throws Exception {
		String actual = getParserRule("Rule: val1=ID ({Act.val2=current} val3=ID)*;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule:\n");
		expected.append("  start -> val1=ID, {Act.val2=}\n");
		expected.append("  val1=ID -> stop\n");
		expected.append("  val3=ID -> stop\n");
		expected.append("  {Act.val2=} -> val3=ID\n");
		expected.append("Rule_Act_1_0:\n");
		expected.append("  start -> val1=ID, {Act.val2=}\n");
		expected.append("  val1=ID -> stop\n");
		expected.append("  val3=ID -> stop\n");
		expected.append("  {Act.val2=} -> val3=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testOptionalEnd() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: 'model' foo=AbstractRule;\n");
		grammar.append("AbstractRule: Rule1 | Rule2;\n");
		grammar.append("Rule1: 'r1' foo1=ID ('as' alias1+=ID)?;\n");
		grammar.append("Rule2: 'r2' foo2=ID ('as' alias2+=ID)*;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("AbstractRule:\n");
		expected.append("  start -> >>Rule1, >>Rule2\n");
		expected.append("  'as' -> alias1+=ID\n");
		expected.append("  'as' -> alias2+=ID\n");
		expected.append("  'r1' -> foo1=ID\n");
		expected.append("  'r2' -> foo2=ID\n");
		expected.append("  <<Rule1 -> stop\n");
		expected.append("  <<Rule2 -> stop\n");
		expected.append("  >>Rule1 -> 'r1'\n");
		expected.append("  >>Rule2 -> 'r2'\n");
		expected.append("  alias1+=ID -> <<Rule1\n");
		expected.append("  alias2+=ID -> 'as', <<Rule2\n");
		expected.append("  foo1=ID -> 'as', <<Rule1\n");
		expected.append("  foo2=ID -> 'as', <<Rule2\n");
		expected.append("Model:\n");
		expected.append("  start -> 'model'\n");
		expected.append("  'model' -> foo=AbstractRule\n");
		expected.append("  foo=AbstractRule -> stop\n");
		expected.append("Rule1:\n");
		expected.append("  start -> 'r1'\n");
		expected.append("  'as' -> alias1+=ID\n");
		expected.append("  'r1' -> foo1=ID\n");
		expected.append("  alias1+=ID -> stop\n");
		expected.append("  foo1=ID -> 'as', stop\n");
		expected.append("Rule2:\n");
		expected.append("  start -> 'r2'\n");
		expected.append("  'as' -> alias2+=ID\n");
		expected.append("  'r2' -> foo2=ID\n");
		expected.append("  alias2+=ID -> 'as', stop\n");
		expected.append("  foo2=ID -> 'as', stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testActionTwoMandatory() throws Exception {
		String actual = getParserRule("Rule: val1=ID {Act1.val2=current} val3=ID {Act2.val2=current} val4=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule:\n");
		expected.append("  start -> {Act2.val2=}\n");
		expected.append("  val4=ID -> stop\n");
		expected.append("  {Act2.val2=} -> val4=ID\n");
		expected.append("Rule_Act1_1:\n");
		expected.append("  start -> val1=ID\n");
		expected.append("  val1=ID -> stop\n");
		expected.append("Rule_Act2_3:\n");
		expected.append("  start -> {Act1.val2=}\n");
		expected.append("  val3=ID -> stop\n");
		expected.append("  {Act1.val2=} -> val3=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testActionAlternative() throws Exception {
		String actual = getParserRule("Greeting: '(' Greeting ')' {Foo.child=current} | val=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Greeting:\n");
		expected.append("  start -> val=ID, {Foo.child=}\n");
		expected.append("  val=ID -> stop\n");
		expected.append("  {Foo.child=} -> stop\n");
		expected.append("Greeting_Foo_0_3:\n");
		expected.append("  start -> '('\n");
		expected.append("  '(' -> >>Greeting\n");
		expected.append("  ')' -> stop\n");
		expected.append("  <<Greeting -> ')'\n");
		expected.append("  >>Greeting -> val=ID, {Foo.child=}\n");
		expected.append("  val=ID -> <<Greeting\n");
		expected.append("  {Foo.child=} -> <<Greeting");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testExpression1() throws Exception {
		String actual = getParserRule("Exp: 'kw' Addit; Addit returns Exp: Prim ({Add.left=current} '+' right=Prim)*; Prim returns Exp: {Val} val=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Addit:\n");
		expected.append("  start -> >>Prim, {Add.left=}\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  <<Prim -> stop\n");
		expected.append("  >>Prim -> {Val}\n");
		expected.append("  right=Prim -> stop\n");
		expected.append("  val=ID -> <<Prim\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("  {Val} -> val=ID\n");
		expected.append("Addit_Add_1_0:\n");
		expected.append("  start -> >>Prim, {Add.left=}\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  <<Prim -> stop\n");
		expected.append("  >>Prim -> {Val}\n");
		expected.append("  right=Prim -> stop\n");
		expected.append("  val=ID -> <<Prim\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("  {Val} -> val=ID\n");
		expected.append("Exp:\n");
		expected.append("  start -> 'kw'\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  'kw' -> >>Addit\n");
		expected.append("  <<Addit -> stop\n");
		expected.append("  <<Prim -> <<Addit\n");
		expected.append("  >>Addit -> >>Prim, {Add.left=}\n");
		expected.append("  >>Prim -> {Val}\n");
		expected.append("  right=Prim -> <<Addit\n");
		expected.append("  val=ID -> <<Prim\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("  {Val} -> val=ID\n");
		expected.append("Prim:\n");
		expected.append("  start -> {Val}\n");
		expected.append("  val=ID -> stop\n");
		expected.append("  {Val} -> val=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testExpression2() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Addition returns Expr: Prim ({Add.left=current} '+' right=Prim)*;\n");
		grammar.append("Prim returns Expr: {Val} name=ID | '(' Addition ')';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Addition:\n");
		expected.append("  start -> >>Prim, {Add.left=}\n");
		expected.append("  '(' -> >>Addition\n");
		expected.append("  ')' -> <<Prim\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  <<Addition -> ')'\n");
		expected.append("  <<Prim -> <<Addition, stop\n");
		expected.append("  >>Addition -> >>Prim, {Add.left=}\n");
		expected.append("  >>Prim -> '(', {Val}\n");
		expected.append("  name=ID -> <<Prim\n");
		expected.append("  right=Prim -> <<Addition, stop\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("  {Val} -> name=ID\n");
		expected.append("Addition_Add_1_0:\n");
		expected.append("  start -> >>Prim, {Add.left=}\n");
		expected.append("  '(' -> >>Addition\n");
		expected.append("  ')' -> <<Prim\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  <<Addition -> ')'\n");
		expected.append("  <<Prim -> <<Addition, stop\n");
		expected.append("  >>Addition -> >>Prim, {Add.left=}\n");
		expected.append("  >>Prim -> '(', {Val}\n");
		expected.append("  name=ID -> <<Prim\n");
		expected.append("  right=Prim -> <<Addition, stop\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("  {Val} -> name=ID\n");
		expected.append("Prim:\n");
		expected.append("  start -> '(', {Val}\n");
		expected.append("  '(' -> >>Addition\n");
		expected.append("  ')' -> <<Prim, stop\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  <<Addition -> ')'\n");
		expected.append("  <<Prim -> <<Addition\n");
		expected.append("  >>Addition -> >>Prim, {Add.left=}\n");
		expected.append("  >>Prim -> '(', {Val}\n");
		expected.append("  name=ID -> <<Prim, stop\n");
		expected.append("  right=Prim -> <<Addition\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("  {Val} -> name=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testRecursion() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Recursion: val=ID | '(' Recursion ')';");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Recursion:\n");
		expected.append("  start -> '(', val=ID\n");
		expected.append("  '(' -> >>Recursion\n");
		expected.append("  ')' -> <<Recursion, stop\n");
		expected.append("  <<Recursion -> ')'\n");
		expected.append("  >>Recursion -> '(', val=ID\n");
		expected.append("  val=ID -> <<Recursion, stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testOptionalDelegate() throws Exception {
		String actual = getParserRule("Rule: Mand | Opt; Mand: 'm' mand=ID; Opt: 'o' opt=ID?;");
		StringBuilder expected = new StringBuilder();
		expected.append("Mand:\n");
		expected.append("  start -> 'm'\n");
		expected.append("  'm' -> mand=ID\n");
		expected.append("  mand=ID -> stop\n");
		expected.append("Opt:\n");
		expected.append("  start -> 'o'\n");
		expected.append("  'o' -> opt=ID, stop\n");
		expected.append("  opt=ID -> stop\n");
		expected.append("Rule:\n");
		expected.append("  start -> >>Mand, >>Opt\n");
		expected.append("  'm' -> mand=ID\n");
		expected.append("  'o' -> <<Opt, opt=ID\n");
		expected.append("  <<Mand -> stop\n");
		expected.append("  <<Opt -> stop\n");
		expected.append("  >>Mand -> 'm'\n");
		expected.append("  >>Opt -> 'o'\n");
		expected.append("  mand=ID -> <<Mand\n");
		expected.append("  opt=ID -> <<Opt");
		assertEquals(expected.toString(), actual);
	}
}
