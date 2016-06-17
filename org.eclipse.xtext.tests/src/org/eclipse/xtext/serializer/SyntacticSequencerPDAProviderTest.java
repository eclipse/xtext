/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.grammaranalysis.IPDAState.PDAStateType;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.formallang.NfaToProduction;
import org.eclipse.xtext.util.formallang.ProductionStringFactory;
import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerPDAProviderTest extends AbstractXtextTests {

	private static class ToStr implements Function<ISynState, String> {
		private Function<AbstractElement, String> ts = new GrammarElementTitleSwitch().showAssignments().hideCardinality().showQualified();

		@Override
		public String apply(ISynState from) {
			return from.getType().getSimpleType() == PDAStateType.ELEMENT ? ts.apply(from.getGrammarElement()) : from.toString();
		}
	}

	final static String HEADER = "grammar org.eclipse.xtext.serializer.SequenceParserPDAProviderTestLanguage"
			+ " with org.eclipse.xtext.common.Terminals "
			+ "generate sequenceParserPDAProviderTest \"http://www.eclipse.org/2010/tmf/xtext/SequenceParserPDAProvider\"  ";

	private void collectAbsorberStates(ISynState state, Set<ISynState> visited, Set<ISynAbsorberState> result) {
		if (!visited.add(state))
			return;
		if (state instanceof ISynAbsorberState)
			result.add((ISynAbsorberState) state);
		for (ISynState follower : state.getFollowers())
			collectAbsorberStates(follower, visited, result);
	}

	//	public void drawGrammar(String path, Grammar grammar) {
	//		try {
	//			IContextPDAProvider contexts = get(IContextPDAProvider.class);
	//			IContextTypePDAProvider types = get(IContextTypePDAProvider.class);
	//			SyntacticSequencerPDA2ExtendedDot seq2dot = get(SyntacticSequencerPDA2ExtendedDot.class);
	//			for (EObject ctx : contexts.getAllContexts(grammar))
	//				for (EClass type : types.getTypesForContext(grammar, ctx))
	//					seq2dot.draw(new Pair<EObject, EClass>(ctx, type),
	//							path + "-" + new Context2NameFunction().toFunction(grammar).apply(ctx) + "_"
	//									+ (type == null ? "null" : type.getName()) + "-PDA.pdf",
	//							"-T pdf");
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//	}

	protected String getParserRule(String body) throws Exception {
		Grammar grammar = (Grammar) getModel(HEADER + body);
		//		StackTraceElement ele = Thread.currentThread().getStackTrace()[2];
		//		drawGrammar("pdf/" + ele.getMethodName(), grammar);
		ISyntacticSequencerPDAProvider pdaProvider = get(ISyntacticSequencerPDAProvider.class);
		Map<ISerializationContext, ISynAbsorberState> pdas = pdaProvider.getSyntacticSequencerPDAs(grammar);
		List<Pair<List<ISerializationContext>, ISynAbsorberState>> grouped = SerializationContext.groupByEqualityAndSort(pdas);
		List<String> result = Lists.newArrayList();
		for (Pair<List<ISerializationContext>, ISynAbsorberState> e : grouped) {
			result.add(e.getFirst() + ":");
			result.addAll(pda2lines2(e.getSecond()));
		}
		return Joiner.on("\n").join(result);
	}

	private String pathToStr2(ISynTransition state) {
		ProductionStringFactory<String> factory = new ProductionStringFactory<String>();
		return new NfaToProduction().nfaToGrammar(state.getPathToTarget(), new ToStr(), factory);
	}

	private List<String> pda2lines2(ISynAbsorberState start) {
		Set<ISynAbsorberState> states = Sets.newHashSet(start);
		collectAbsorberStates(start, Sets.<ISynState> newHashSet(), states);
		List<String> pdalines = Lists.newArrayList();
		for (ISynAbsorberState state : states)
			for (ISynTransition child : state.getOutTransitions())
				pdalines.add("  " + pathToStr2(child));
		Collections.sort(pdalines);
		return pdalines;
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	@Test
	public void testKeyword() throws Exception {
		String actual = getParserRule("Rule: a1=ID 'kw1' a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  a1=ID 'kw1' a2=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testKeywordOptional() throws Exception {
		String actual = getParserRule("Rule: a1=ID 'kw1' 'kw2'? a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  a1=ID 'kw1' 'kw2'? a2=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testKeywordMany() throws Exception {
		String actual = getParserRule("Rule: a1=ID 'kw1' 'kw2'+ a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  a1=ID 'kw1' 'kw2'+ a2=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testKeywordOptionalMany() throws Exception {
		String actual = getParserRule("Rule: a1=ID 'kw1' 'kw2'* a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  a1=ID 'kw1' 'kw2'* a2=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testKeywordAlternative() throws Exception {
		String actual = getParserRule("Rule: a1=ID ('kw1' | 'kw2') a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  a1=ID ('kw1' | 'kw2') a2=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testKeywordAllMandatory() throws Exception {
		String actual = getParserRule("Rule: a1=ID ('kw1' a2=ID | 'kw2' a3=ID 'kw3');");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule returns Rule:\n");
		expected.append("  a1=ID 'kw1' a2=ID\n");
		expected.append("  a1=ID 'kw2' a3=ID\n");
		expected.append("  a2=ID stop\n");
		expected.append("  a3=ID 'kw3' stop\n");
		expected.append("  start a1=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testUnassignedRuleCall1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: Sub;\n");
		grammar.append("Sub: val=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Sub:\n");
		expected.append("  start >>Sub val=ID\n");
		expected.append("  val=ID <<Sub stop\n");
		expected.append("Sub returns Sub:\n");
		expected.append("  start val=ID\n");
		expected.append("  val=ID stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testUnassignedRuleCall2() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: 'kw1' Sub 'kw4';\n");
		grammar.append("Sub: 'kw2' val=ID 'kw3';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Sub:\n");
		expected.append("  start 'kw1' >>Sub 'kw2' val=ID\n");
		expected.append("  val=ID 'kw3' <<Sub 'kw4' stop\n");
		expected.append("Sub returns Sub:\n");
		expected.append("  start 'kw2' val=ID\n");
		expected.append("  val=ID 'kw3' stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAssignedRuleCall2() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: 'kw1' sub=Sub 'kw4';\n");
		grammar.append("Sub: 'kw2' val=ID 'kw3';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Model:\n");
		expected.append("  start 'kw1' sub=Sub\n");
		expected.append("  sub=Sub 'kw4' stop\n");
		expected.append("Sub returns Sub:\n");
		expected.append("  start 'kw2' val=ID\n");
		expected.append("  val=ID 'kw3' stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAssignedRuleCallNested1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: start=ID sub1=Sub1 val1=ID;\n");
		grammar.append("Sub1: 'sub1' sub2=Sub2 val2=ID;\n");
		grammar.append("Sub2: 'sub2' sub3=Sub3 val3=ID;\n");
		grammar.append("Sub3: 'sub3' val4=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Model:\n");
		expected.append("  start start=ID\n");
		expected.append("  start=ID sub1=Sub1\n");
		expected.append("  sub1=Sub1 val1=ID\n");
		expected.append("  val1=ID stop\n");
		expected.append("Sub1 returns Sub1:\n");
		expected.append("  start 'sub1' sub2=Sub2\n");
		expected.append("  sub2=Sub2 val2=ID\n");
		expected.append("  val2=ID stop\n");
		expected.append("Sub2 returns Sub2:\n");
		expected.append("  start 'sub2' sub3=Sub3\n");
		expected.append("  sub3=Sub3 val3=ID\n");
		expected.append("  val3=ID stop\n");
		expected.append("Sub3 returns Sub3:\n");
		expected.append("  start 'sub3' val4=ID\n");
		expected.append("  val4=ID stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAssignedElements() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: t=MyTerminal 'kw1' d=MyDatatype 'kw2' e=MyEnum 'kw3' k='kw4' 'kw5' b='kw6'? \n");
		grammar.append("       c1=[Model|MyTerminal] 'kw7' c2=[Model|MyDatatype] 'kw8' c3=[Model|'kw9'];\n");
		grammar.append("terminal MyTerminal: '$' ('a'..'z')+;\n");
		grammar.append("MyDatatype: 'kw1' | 'kw2';\n");
		grammar.append("enum MyEnum: kw1 | kw2;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Model:\n");
		expected.append("  b='kw6' c1=[Model|MyTerminal]\n");
		expected.append("  c1=[Model|MyTerminal] 'kw7' c2=[Model|MyDatatype]\n");
		expected.append("  c2=[Model|MyDatatype] 'kw8' c3=[Model|'kw9']\n");
		expected.append("  c3=[Model|'kw9'] stop\n");
		expected.append("  d=MyDatatype 'kw2' e=MyEnum\n");
		expected.append("  e=MyEnum 'kw3' k='kw4'\n");
		expected.append("  k='kw4' 'kw5' b='kw6'\n");
		expected.append("  k='kw4' 'kw5' c1=[Model|MyTerminal]\n");
		expected.append("  start t=MyTerminal\n");
		expected.append("  t=MyTerminal 'kw1' d=MyDatatype");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testRecursion() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Recursion: val=ID | '(' Recursion ')';");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Recursion returns Recursion:\n");
		expected.append("  start ('(' >>Recursion)* val=ID\n");
		expected.append("  val=ID (<<Recursion ')')* stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testReturnChoices() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: Sub1 | Sub2;\n");
		grammar.append("Sub1: 'in1' Infix 'out1';\n");
		grammar.append("Sub2: 'in2' Infix 'out2';\n");
		grammar.append("Sub3: 'in3' Infix 'out3';\n");
		grammar.append("Infix: val=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Infix:\n");
		expected.append("  start (>>Sub1 'in1' >>Infix | >>Sub2 'in2' >>Infix) val=ID\n");
		expected.append("  val=ID (<<Infix 'out1' <<Sub1 | <<Infix 'out2' <<Sub2) stop\n");
		expected.append("Sub1 returns Infix:\n");
		expected.append("  start 'in1' >>Infix val=ID\n");
		expected.append("  val=ID <<Infix 'out1' stop\n");
		expected.append("Sub2 returns Infix:\n");
		expected.append("  start 'in2' >>Infix val=ID\n");
		expected.append("  val=ID <<Infix 'out2' stop\n");
		expected.append("Sub3 returns Infix:\n");
		expected.append("  start 'in3' >>Infix val=ID\n");
		expected.append("  val=ID <<Infix 'out3' stop\n");
		expected.append("Infix returns Infix:\n");
		expected.append("  start val=ID\n");
		expected.append("  val=ID stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testExpression0() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Addition returns Expr: Prim ({Add.left=current} '+' right=Prim)*;\n");
		grammar.append("Prim returns Expr: {Val} name=ID;\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Addition returns Add, Addition.Add_1_0 returns Add:\n");
		expected.append("  right=Prim stop\n");
		expected.append("  start {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Prim\n");
		expected.append("Addition returns Val, Addition.Add_1_0 returns Val:\n");
		expected.append("  name=ID <<Prim stop\n");
		expected.append("  start >>Prim {Val} name=ID\n");
		expected.append("Prim returns Val:\n");
		expected.append("  name=ID stop\n");
		expected.append("  start {Val} name=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testExpression1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Addition returns Expr: Prim ({Add.left=current} '+' right=Prim)*;\n");
		grammar.append("Prim returns Expr: {Val} name=ID | '(' Addition ')';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Addition returns Add, Addition.Add_1_0 returns Add:\n");
		expected.append("  right=Prim (<<Addition ')' <<Prim)* stop\n");
		expected.append("  start (>>Prim '(' >>Addition)* {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Prim\n");
		expected.append("Addition returns Val, Addition.Add_1_0 returns Val:\n");
		expected.append("  name=ID <<Prim (<<Addition ')' <<Prim)* stop\n");
		expected.append("  start >>Prim ('(' >>Addition >>Prim)* {Val} name=ID\n");
		expected.append("Prim returns Add:\n");
		expected.append("  right=Prim <<Addition ')' (<<Prim <<Addition ')')* stop\n");
		expected.append("  start '(' >>Addition (>>Prim '(' >>Addition)* {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Prim\n");
		expected.append("Prim returns Val:\n");
		expected.append("  name=ID (<<Prim <<Addition ')')* stop\n");
		expected.append("  start ('(' >>Addition >>Prim)* {Val} name=ID");
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
		expected.append("Model returns Model:\n");
		expected.append("  foo=AbstractRule stop\n");
		expected.append("  start 'model' foo=AbstractRule\n");
		expected.append("AbstractRule returns Rule1:\n");
		expected.append("  alias1+=ID <<Rule1 stop\n");
		expected.append("  foo1=ID 'as' alias1+=ID\n");
		expected.append("  foo1=ID <<Rule1 stop\n");
		expected.append("  start >>Rule1 'r1' foo1=ID\n");
		expected.append("AbstractRule returns Rule2:\n");
		expected.append("  alias2+=ID 'as' alias2+=ID\n");
		expected.append("  alias2+=ID <<Rule2 stop\n");
		expected.append("  foo2=ID 'as' alias2+=ID\n");
		expected.append("  foo2=ID <<Rule2 stop\n");
		expected.append("  start >>Rule2 'r2' foo2=ID\n");
		expected.append("Rule1 returns Rule1:\n");
		expected.append("  alias1+=ID stop\n");
		expected.append("  foo1=ID 'as' alias1+=ID\n");
		expected.append("  foo1=ID stop\n");
		expected.append("  start 'r1' foo1=ID\n");
		expected.append("Rule2 returns Rule2:\n");
		expected.append("  alias2+=ID 'as' alias2+=ID\n");
		expected.append("  alias2+=ID stop\n");
		expected.append("  foo2=ID 'as' alias2+=ID\n");
		expected.append("  foo2=ID stop\n");
		expected.append("  start 'r2' foo2=ID");
		assertEquals(expected.toString(), actual);
	}

	// TODO: fixme: this fails randomly
	public void disabled_testExpression4() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: x1=Exp1;\n");
		grammar.append("Exp1: '#3' Addition1;\n");
		grammar.append("Addition1 returns Exp1: Prim1 ({Add1.left=current} '+' right=Prim1)*;\n");
		grammar.append("Prim1 returns Exp1: {Val1} name=ID | '(' Addition1 ')';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model:\n");
		expected.append("  start x1=Exp1\n");
		expected.append("  x1=Exp1 stop\n");
		expected.append("Exp1:\n");
		expected.append("  name=ID <<Prim1 <<Addition1 stop <<Addition1 ')' !<<Prim1\n");
		expected.append("  right=Prim1 <<Addition1 ')' <<Prim1 <<Addition1 stop !<<Addition1\n");
		expected.append("  right=Prim1 <<Addition1 stop\n");
		expected.append("  start '#3' >>Addition1 >>Prim1 '(' >>Addition1 !>>Prim1 {Add1.left=} !{Add1.left=}\n");
		expected.append("  start '#3' >>Addition1 >>Prim1 '(' >>Addition1 !>>Prim1 {Val1} name=ID\n");
		expected.append("  {Add1.left=} '+' right=Prim1\n");
		expected.append("Addition1:\n");
		expected.append("  name=ID <<Prim1 <<Addition1 ')' !<<Prim1 stop\n");
		expected.append("  right=Prim1 <<Addition1 ')' <<Prim1 !<<Addition1 stop\n");
		expected.append("  right=Prim1 stop\n");
		expected.append("  start >>Prim1 '(' >>Addition1 !>>Prim1 {Add1.left=}\n");
		expected.append("  start >>Prim1 '(' >>Addition1 !>>Prim1 {Val1} name=ID\n");
		expected.append("  start {Add1.left=}\n");
		expected.append("  {Add1.left=} '+' right=Prim1\n");
		expected.append("Prim1:\n");
		expected.append("  name=ID <<Prim1 <<Addition1 ')' !<<Prim1 stop\n");
		expected.append("  name=ID stop\n");
		expected.append("  right=Prim1 <<Addition1 ')' <<Prim1 !<<Addition1 stop\n");
		expected.append("  start '(' >>Addition1 >>Prim1 !'(' {Add1.left=}\n");
		expected.append("  start '(' >>Addition1 >>Prim1 !'(' {Val1} name=ID\n");
		expected.append("  start {Val1} name=ID\n");
		expected.append("  {Add1.left=} '+' right=Prim1\n");
		expected.append("{Add1.left}:\n");
		expected.append("  name=ID <<Prim1 <<Addition1 ')' !<<Prim1 stop\n");
		expected.append("  right=Prim1 <<Addition1 ')' <<Prim1 !<<Addition1 stop\n");
		expected.append("  right=Prim1 stop\n");
		expected.append("  start >>Prim1 '(' >>Addition1 !>>Prim1 {Add1.left=}\n");
		expected.append("  start >>Prim1 '(' >>Addition1 !>>Prim1 {Val1} name=ID\n");
		expected.append("  start {Add1.left=}\n");
		expected.append("  {Add1.left=} '+' right=Prim1");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testExpression5() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Addition returns Expr: Multiplication ({Add.left=current} '+' right=Multiplication)*;\n");
		grammar.append("Multiplication returns Expr: Prim ({Mult.left=current} '*' right=Prim)*;\n");
		grammar.append("Prim returns Expr: {Val} name=ID | '(' Addition ')';\n");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Addition returns Add, Addition.Add_1_0 returns Add:\n");
		expected.append("  right=Multiplication (<<Addition ')' <<Prim <<Multiplication)* stop\n");
		expected.append("  start (>>Multiplication >>Prim '(' >>Addition)* {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Multiplication\n");
		expected.append("Addition returns Mult, Addition.Add_1_0 returns Mult:\n");
		expected.append("  right=Prim <<Multiplication (<<Addition ')' <<Prim <<Multiplication)* stop\n");
		expected.append("  start >>Multiplication (>>Prim '(' >>Addition >>Multiplication)* {Mult.left=}\n");
		expected.append("  {Mult.left=} '*' right=Prim\n");
		expected.append("Addition returns Val, Addition.Add_1_0 returns Val:\n");
		expected.append("  name=ID <<Prim <<Multiplication (<<Addition ')' <<Prim <<Multiplication)* stop\n");
		expected.append("  start >>Multiplication >>Prim ('(' >>Addition >>Multiplication >>Prim)* {Val} name=ID\n");
		expected.append("Multiplication returns Add, Multiplication.Mult_1_0 returns Add:\n");
		expected.append("  right=Multiplication <<Addition ')' <<Prim (<<Multiplication <<Addition ')' <<Prim)* stop\n");
		expected.append("  start >>Prim '(' >>Addition (>>Multiplication >>Prim '(' >>Addition)* {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Multiplication\n");
		expected.append("Multiplication returns Mult, Multiplication.Mult_1_0 returns Mult:\n");
		expected.append("  right=Prim (<<Multiplication <<Addition ')' <<Prim)* stop\n");
		expected.append("  start (>>Prim '(' >>Addition >>Multiplication)* {Mult.left=}\n");
		expected.append("  {Mult.left=} '*' right=Prim\n");
		expected.append("Multiplication returns Val, Multiplication.Mult_1_0 returns Val:\n");
		expected.append("  name=ID <<Prim (<<Multiplication <<Addition ')' <<Prim)* stop\n");
		expected.append("  start >>Prim ('(' >>Addition >>Multiplication >>Prim)* {Val} name=ID\n");
		expected.append("Prim returns Add:\n");
		expected.append("  right=Multiplication <<Addition ')' (<<Prim <<Multiplication <<Addition ')')* stop\n");
		expected.append("  start '(' >>Addition (>>Multiplication >>Prim '(' >>Addition)* {Add.left=}\n");
		expected.append("  {Add.left=} '+' right=Multiplication\n");
		expected.append("Prim returns Mult:\n");
		expected.append("  right=Prim <<Multiplication <<Addition ')' (<<Prim <<Multiplication <<Addition ')')* stop\n");
		expected.append("  start '(' >>Addition >>Multiplication (>>Prim '(' >>Addition >>Multiplication)* {Mult.left=}\n");
		expected.append("  {Mult.left=} '*' right=Prim\n");
		expected.append("Prim returns Val:\n");
		expected.append("  name=ID (<<Prim <<Multiplication <<Addition ')')* stop\n");
		expected.append("  start ('(' >>Addition >>Multiplication >>Prim)* {Val} name=ID");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testMultiOptional() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Optional: val1=ID? val2=ID? val3=ID?;");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Optional returns Optional:\n");
		expected.append("  start val1=ID\n");
		expected.append("  start val2=ID\n");
		expected.append("  start val3=ID\n");
		expected.append("  val1=ID stop\n");
		expected.append("  val1=ID val2=ID\n");
		expected.append("  val1=ID val3=ID\n");
		expected.append("  val2=ID stop\n");
		expected.append("  val2=ID val3=ID\n");
		expected.append("  val3=ID stop\n");
		expected.append("Optional returns null:\n");
		expected.append("  start stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testActions1() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: {Foo.left=current} (val=ID? | {Foo.left=current});");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Foo:\n");
		expected.append("  ( {Foo.left=}) stop\n");
		expected.append("  ({Foo.left=} ) stop\n");
		expected.append("  ({Foo.left=} ) val=ID\n");
		expected.append("  start ( {Foo.left=})\n");
		expected.append("  start ({Foo.left=} )\n");
		expected.append("  val=ID stop\n");
		expected.append("Model.Foo_0 returns null:\n");
		expected.append("  start stop\n");
		expected.append("Model.Foo_1_1 returns Foo:\n");
		expected.append("  ({Foo.left=} ) stop\n");
		expected.append("  start ({Foo.left=} )");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testActions2() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: 'x' ('kw1' {Foo} | 'kw2' {Bar}) val1=ID;");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Bar:\n");
		expected.append("  start 'x' 'kw2' {Bar} val1=ID\n");
		expected.append("  val1=ID stop\n");
		expected.append("Model returns Foo:\n");
		expected.append("  start 'x' 'kw1' {Foo} val1=ID\n");
		expected.append("  val1=ID stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testActions3() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: 'x' ('kw1' {Foo} | 'kw2' {Bar}) val1=ID;");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Bar:\n");
		expected.append("  start 'x' 'kw2' {Bar} val1=ID\n");
		expected.append("  val1=ID stop\n");
		expected.append("Model returns Foo:\n");
		expected.append("  start 'x' 'kw1' {Foo} val1=ID\n");
		expected.append("  val1=ID stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	public void testAlternativeManyNested() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("Model: (('x' x+=ID*) | ('y' y+=ID*))*;");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("Model returns Model:\n");
		expected.append("  start ('x' | 'y')+ stop\n");
		expected.append("  start ('x'* 'y')+ y+=ID\n");
		expected.append("  start ('y'* 'x')+ x+=ID\n");
		expected.append("  x+=ID ('x' | 'y')* stop\n");
		expected.append("  x+=ID ('x'* 'y')+ y+=ID\n");
		expected.append("  x+=ID ('y'* 'x')* x+=ID\n");
		expected.append("  y+=ID ('x' | 'y')* stop\n");
		expected.append("  y+=ID ('x'* 'y')* y+=ID\n");
		expected.append("  y+=ID ('y'* 'x')+ x+=ID\n");
		expected.append("Model returns null:\n");
		expected.append("  start ('x' | 'y')* stop");
		assertEquals(expected.toString(), actual);
	}

	@Test
	// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=387731
	public void testPotentialOOME() throws Exception {
		StringBuilder grammar = new StringBuilder();
		grammar.append("AllElements: elements+=Elements*; \n");
		grammar.append("Elements: Dummy | Model;\n");
		grammar.append("Dummy: 'Dummy' name=ID; \n");
		grammar.append("Model: 'model' '{' greetings1+=Greeting1+ & greetings2+=Greeting2* '}';\n");
		grammar.append("Greeting1: 'Hello' name=ID '!';\n");
		grammar.append("Greeting2: 'Hi' name=ID '!';");
		String actual = getParserRule(grammar.toString());
		StringBuilder expected = new StringBuilder();
		expected.append("AllElements returns AllElements:\n");
		expected.append("  elements+=Elements elements+=Elements\n");
		expected.append("  elements+=Elements stop\n");
		expected.append("  start elements+=Elements\n");
		expected.append("AllElements returns null:\n");
		expected.append("  start stop\n");
		expected.append("Elements returns Dummy:\n");
		expected.append("  name=ID <<Dummy stop\n");
		expected.append("  start >>Dummy 'Dummy' name=ID\n");
		expected.append("Elements returns Model:\n");
		expected.append("  greetings1+=Greeting1 '}'* <<Model stop\n");
		expected.append("  greetings1+=Greeting1 '}'* greetings2+=Greeting2\n");
		expected.append("  greetings1+=Greeting1 ('}'* 'model' '{')? greetings1+=Greeting1\n");
		expected.append("  greetings2+=Greeting2 '}'* greetings2+=Greeting2\n");
		expected.append("  greetings2+=Greeting2 '}'+ 'model' '{' greetings1+=Greeting1\n");
		expected.append("  greetings2+=Greeting2 '}'+ <<Model stop\n");
		expected.append("  start >>Model '}'* 'model' '{' greetings1+=Greeting1\n");
		expected.append("  start >>Model '}'* greetings2+=Greeting2\n");
		expected.append("  start >>Model '}'+ <<Model stop\n");
		expected.append("Elements returns null:\n");
		expected.append("  start >>Model '}'+ <<Model stop\n");
		expected.append("Dummy returns Dummy:\n");
		expected.append("  name=ID stop\n");
		expected.append("  start 'Dummy' name=ID\n");
		expected.append("Model returns Model:\n");
		expected.append("  greetings1+=Greeting1 '}'* greetings2+=Greeting2\n");
		expected.append("  greetings1+=Greeting1 '}'* stop\n");
		expected.append("  greetings1+=Greeting1 ('}'* 'model' '{')? greetings1+=Greeting1\n");
		expected.append("  greetings2+=Greeting2 '}'* greetings2+=Greeting2\n");
		expected.append("  greetings2+=Greeting2 '}'+ 'model' '{' greetings1+=Greeting1\n");
		expected.append("  greetings2+=Greeting2 '}'+ stop\n");
		expected.append("  start '}'* 'model' '{' greetings1+=Greeting1\n");
		expected.append("  start '}'* greetings2+=Greeting2\n");
		expected.append("  start '}'+ stop\n");
		expected.append("Model returns null:\n");
		expected.append("  start '}'+ stop\n");
		expected.append("Greeting1 returns Greeting1:\n");
		expected.append("  name=ID '!' stop\n");
		expected.append("  start 'Hello' name=ID\n");
		expected.append("Greeting2 returns Greeting2:\n");
		expected.append("  name=ID '!' stop\n");
		expected.append("  start 'Hi' name=ID");
		assertEquals(expected.toString(), actual);
	}

}
