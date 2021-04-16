/**
 * Copyright (c) 2015, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.serializer;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.IGrammarPDAProvider;
import org.eclipse.xtext.serializer.analysis.ISerState;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap.Entry;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaListFormatter;
import org.eclipse.xtext.util.formallang.PdaToDot;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
public class GrammarPDAProviderTest {
	@Inject
	private IGrammarPDAProvider pdaProvider;

	@Inject
	private ParseHelper<Grammar> parser;

	@Inject
	private ValidationTestHelper validator;

	@Test
	public void testUnassignedAction() throws Exception {
		String model = "Rule: {Action};\n";
		String expected =
				"Rule:\n" +
				"	start -> {Action}\n" +
				"	{Action} -> stop\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testAssignedAction() throws Exception {
		String model = "Rule: {Foo} {Action.feat=current};\n";
		String expected =
				"Rule:\n" +
				"	start -> {Foo}\n" +
				"	{Action.feat=} -> stop\n" +
				"	{Foo} -> {Action.feat=}\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testAssignedTerminalRuleCall() throws Exception {
		String model = "Rule: name=ID;\n";
		String expected =
				"Rule:\n" +
				"	start -> name=ID\n" +
				"	name=ID -> stop\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testAssignedEObjectRuleCall() throws Exception {
		String model =
				"Rule: call=Called;\n" +
				"Called: name=ID;\n";
		String expected =
				"Rule:\n" +
				"	start -> call=Called\n" +
				"	call=Called -> stop\n" +
				"Called:\n" +
				"	start -> name=ID\n" +
				"	name=ID -> stop\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testAssignedDatatypeRuleCall() throws Exception {
		String model =
				"Rule: call=Called;\n" +
				"Called: 'foo';\n";
		String expected =
				"Rule:\n" +
				"	start -> call=Called\n" +
				"	call=Called -> stop\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testUnassignedCalledAction() throws Exception {
		String model =
				"Rule: D1 | D2;\n" +
				"D1: 'd1' A;\n" +
				"D2: 'd2' A;\n" +
				"A: f1=ID {A.l=current} f2=ID;\n";
		String expected =
				"Rule:\n" +
				"	start -> >>D1, >>D2\n" +
				"	'd1' -> >>A\n" +
				"	'd2' -> >>A\n" +
				"	<<A -> <<D1\n" +
				"	<<A -> <<D2\n" +
				"	<<D1 -> stop\n" +
				"	<<D2 -> stop\n" +
				"	>>A -> f1=ID\n" +
				"	>>A -> f1=ID\n" +
				"	>>D1 -> 'd1'\n" +
				"	>>D2 -> 'd2'\n" +
				"	f1=ID -> {A.l=}\n" +
				"	f2=ID -> <<A, <<A\n" +
				"	{A.l=} -> f2=ID\n" +
				"D1:\n" +
				"	start -> 'd1'\n" +
				"	'd1' -> >>A\n" +
				"	<<A -> stop\n" +
				"	>>A -> f1=ID\n" +
				"	f1=ID -> {A.l=}\n" +
				"	f2=ID -> <<A\n" +
				"	{A.l=} -> f2=ID\n" +
				"D2:\n" +
				"	start -> 'd2'\n" +
				"	'd2' -> >>A\n" +
				"	<<A -> stop\n" +
				"	>>A -> f1=ID\n" +
				"	f1=ID -> {A.l=}\n" +
				"	f2=ID -> <<A\n" +
				"	{A.l=} -> f2=ID\n" +
				"A:\n" +
				"	start -> f1=ID\n" +
				"	f1=ID -> {A.l=}\n" +
				"	f2=ID -> stop\n" +
				"	{A.l=} -> f2=ID\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testUnassignedFragmentRuleCall() throws Exception {
		String model =
				"Rule: Called;\n" +
				"fragment Called returns Abstract: name=ID;\n";
		String expected =
				"Rule:\n" +
				"	start -> >>Called\n" +
				"	<<Called -> stop\n" +
				"	>>Called -> name=ID\n" +
				"	name=ID -> <<Called\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testUnassignedDatatypeRule() throws Exception {
		String model =
				"Rule: val=ID Called;\n" +
				"Called: 'kw1';\n";
		String expected =
				"Rule:\n" +
				"	start -> val=ID\n" +
				"	Called -> stop\n" +
				"	val=ID -> Called\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testUnassignedTerminalRule() throws Exception {
		String model =
				"Rule: val=ID Called;\n" +
				"terminal Called: 'kw1';\n";
		String expected =
				"Rule:\n" +
				"	start -> val=ID\n" +
				"	Called -> stop\n" +
				"	val=ID -> Called\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testUnassignedParserRuleCall() throws Exception {
		String model =
				"Rule: Called;\n" +
				"Called returns Sub: name=ID;\n";
		String expected =
				"Rule:\n" +
				"	start -> >>Called\n" +
				"	<<Called -> stop\n" +
				"	>>Called -> name=ID\n" +
				"	name=ID -> <<Called\n" +
				"Called:\n" +
				"	start -> name=ID\n" +
				"	name=ID -> stop\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testUnassignedWildcardFragmentRuleCall() throws Exception {
		String model =
				"Rule: Called;\n" +
				"fragment Called*: name=ID;\n";
		String expected =
				"Rule:\n" +
				"	start -> >>Called\n" +
				"	<<Called -> stop\n" +
				"	>>Called -> name=ID\n" +
				"	name=ID -> <<Called\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testGroup() throws Exception {
		String model = "Rule: {Rule} 'a' 'b' 'c';\n";
		String expected =
				"Rule:\n" +
				"	start -> {Rule}\n" +
				"	'a' -> 'b'\n" +
				"	'b' -> 'c'\n" +
				"	'c' -> stop\n" +
				"	{Rule} -> 'a'\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testAlternative() throws Exception {
		String model = "Rule: {Rule} ('a' | 'b' | 'c');\n";
		String expected =
				"Rule:\n" +
				"	start -> {Rule}\n" +
				"	'a' -> stop\n" +
				"	'b' -> stop\n" +
				"	'c' -> stop\n" +
				"	{Rule} -> 'a', 'b', 'c'\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testUnorderedGroup() throws Exception {
		String model = "Rule: {Rule} ('a' & 'b' & 'c');\n";
		String expected =
				"Rule:\n" +
				"	start -> {Rule}\n" +
				"	'a' -> 'a', 'b', 'c', stop\n" +
				"	'b' -> 'a', 'b', 'c', stop\n" +
				"	'c' -> 'a', 'b', 'c', stop\n" +
				"	{Rule} -> 'a', 'b', 'c'\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testUnorderedGroup2() throws Exception {
		String model = "Rule: {Rule} ('a' & 'b'? & 'c'* & 'd'+);\n";
		String expected =
				"Rule:\n" +
				"	start -> {Rule}\n" +
				"	'a' -> 'a', 'b', 'c', 'd', stop\n" +
				"	'b' -> 'a', 'b', 'c', 'd', stop\n" +
				"	'c' -> 'a', 'b', 'c', 'd', stop\n" +
				"	'd' -> 'a', 'b', 'c', 'd', stop\n" +
				"	{Rule} -> 'a', 'b', 'c', 'd'\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testTwoAssignedEObjectRuleCalls() throws Exception {
		String model = "Rule: foo1=Sub foo2=Sub; Sub: id='id';\n";
		String expected =
				"Rule:\n" +
				"	start -> foo1=Sub\n" +
				"	foo1=Sub -> foo2=Sub\n" +
				"	foo2=Sub -> stop\n" +
				"Sub:\n" +
				"	start -> id='id'\n" +
				"	id='id' -> stop\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testRecursion() throws Exception {
		String model = "Recursion: val=ID | '(' Recursion ')';\n";
		String expected =
				"Recursion:\n" +
				"	start -> '(', val=ID\n" +
				"	'(' -> >>Recursion\n" +
				"	')' -> <<Recursion, stop\n" +
				"	<<Recursion -> ')'\n" +
				"	>>Recursion -> '(', val=ID\n" +
				"	val=ID -> <<Recursion, stop\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testExpression1() throws Exception {
		String model = 
				"Exp: 'kw' Addit; Addit returns Exp: Prim ({Add.left=current} '+' right=Prim)*; Prim returns Exp: {Val} val=ID;\n";
		String expected =
				"Exp:\n" +
				"	start -> 'kw'\n" +
				"	'+' -> right=Prim\n" +
				"	'kw' -> >>Addit\n" +
				"	<<Addit -> stop\n" +
				"	<<Prim -> <<Addit, {Add.left=}\n" +
				"	>>Addit -> >>Prim\n" +
				"	>>Prim -> {Val}\n" +
				"	right=Prim -> <<Addit, {Add.left=}\n" +
				"	val=ID -> <<Prim\n" +
				"	{Add.left=} -> '+'\n" +
				"	{Val} -> val=ID\n" +
				"Addit:\n" +
				"	start -> >>Prim\n" +
				"	'+' -> right=Prim\n" +
				"	<<Prim -> stop, {Add.left=}\n" +
				"	>>Prim -> {Val}\n" +
				"	right=Prim -> stop, {Add.left=}\n" +
				"	val=ID -> <<Prim\n" +
				"	{Add.left=} -> '+'\n" +
				"	{Val} -> val=ID\n" +
				"Prim:\n" +
				"	start -> {Val}\n" +
				"	val=ID -> stop\n" +
				"	{Val} -> val=ID\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testActionAlternative() throws Exception {
		String model =
				"Greeting: '(' Greeting ')' {Foo.child=current} | val=ID;\n";
		String expected =
				"Greeting:\n" +
				"	start -> '(', val=ID\n" +
				"	'(' -> >>Greeting\n" +
				"	')' -> {Foo.child=}\n" +
				"	<<Greeting -> ')'\n" +
				"	>>Greeting -> '(', val=ID\n" +
				"	val=ID -> <<Greeting, stop\n" +
				"	{Foo.child=} -> <<Greeting, stop\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	@Ignore
	public void testFragmentWithAction() throws Exception {
		String model =
				"R: f1=ID F; fragment F returns R: {A.prev=current} f2=ID;\n";
		String expected =
				"R:\n" +
				"	start -> f1=ID\n" +
				"	<<F -> stop\n" +
				"	>>F -> {A.prev=}\n" +
				"	f1=ID -> >>F\n" +
				"	f2=ID -> <<F\n" +
				"	{A.prev=} -> f2=ID\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	@Ignore
	public void testFragmentWithAction2() throws Exception {
		String model =
				"R: 'kw1a' f1=ID 'kw1b' F; fragment F returns R: 'kw2a' {A.prev=current} 'kw2b' f2=ID 'kw2c';\n";
		String expected =
				"R:\n" +
				"	start -> f1=ID\n" +
				"	<<F -> stop\n" +
				"	>>F -> {A.prev=}\n" +
				"	f1=ID -> >>F\n" +
				"	f2=ID -> <<F\n" +
				"	{A.prev=} -> f2=ID\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testParameter1() throws Exception {
		String model =
				"M: 'kw1' s=S<true> | 'kw2' s=S<false>;\n" +
				"S <P>: <P> v1=ID | <!P> v2=ID;  \n";
		String expected =
				"M:\n" +
				"	start -> 'kw1', 'kw2'\n" +
				"	'kw1' -> (s=S|)\n" +
				"	'kw2' -> (|s=S)\n" +
				"	(s=S|) -> stop\n" +
				"	(|s=S) -> stop\n" +
				"S<P>:\n" +
				"	start -> v1=ID\n" +
				"	v1=ID -> stop\n" +
				"S:\n" +
				"	start -> v2=ID\n" +
				"	v2=ID -> stop\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testDoubleFragment() throws Exception {
		String model =
				"R: F1 F2;\n" +
				"fragment F1: f1=ID;  \n" +
				"fragment F2: f2=ID;  \n";
		String expected =
				"R:\n" +
				"	start -> >>F1\n" +
				"	<<F1 -> >>F2\n" +
				"	<<F2 -> stop\n" +
				"	>>F1 -> f1=ID\n" +
				"	>>F2 -> f2=ID\n" +
				"	f1=ID -> <<F1\n" +
				"	f2=ID -> <<F2\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testFragmentLoop() throws Exception {
		String model =
				"R: F+;\n" +
				"fragment F: f+=ID;  \n";
		String expected =
				"R:\n" +
				"	start -> >>F\n" +
				"	<<F -> >>F, stop\n" +
				"	>>F -> f+=ID\n" +
				"	f+=ID -> <<F\n";
		Assert.assertEquals(expected, toPda(model));
	}

	@Test
	public void testParameterizedDoubleDelegation() throws Exception {
		String model =
				"R: F<true> | F<false>;\n" +
				"fragment F<X>: f+=ID;\n";
		String expected =
				"R:\n" +
				"	start -> >>F, >>F\n" +
				"	<<F -> stop\n" +
				"	<<F -> stop\n" +
				"	>>F -> f+=ID\n" +
				"	>>F -> f+=ID\n" +
				"	f+=ID -> <<F, <<F\n";
		Assert.assertEquals(expected, toPda(model));
	}

	private String toPda(CharSequence rulesText) throws Exception {
		String grammarText = "grammar org.eclipse.xtext.serializer.GrammarPDAProviderTestLanguage with org.eclipse.xtext.common.Terminals\n"
				+ "generate GrammarPDAProviderTest 'http://www.eclipse.org/2010/tmf/xtext/GrammarPDAProviderTestLanguage'\n"
				+ rulesText;
		Grammar grammar = parser.parse(grammarText);
		validator.assertNoErrors(grammar);
		SerializationContextMap<Pda<ISerState, RuleCall>> pdas = pdaProvider.getGrammarPDAs(grammar);
		pdas.values().forEach(it -> {
			assertNoLeakedGrammarElements(grammar, it.getValue());
		});
		Iterable<ISerializationContext> contexts = Iterables
				.concat(Lists.transform(pdas.values(), Entry<Pda<ISerState, RuleCall>>::getContexts));
		return Strings.toUnixLineSeparator(
				Joiner.on("").join(Lists.transform(IterableExtensions.sort(contexts), (ISerializationContext it) -> {
					StringConcatenation b = new StringConcatenation();
					b.append(it);
					b.append(":");
					b.newLineIfNotEmpty();
					b.append("	");
					b.append(toListString(pdas.get(it)), "	");
					b.newLineIfNotEmpty();
					return b.toString();
				})));
	}

	private void assertNoLeakedGrammarElements(Grammar grammar, Pda<ISerState, RuleCall> pda) {
		for (AbstractElement ele : Iterables.filter(
				Iterables.transform(new NfaUtil().collect(pda), ISerState::getGrammarElement), Predicates.notNull())) {
			Grammar actual = GrammarUtil.getGrammar(ele);
			if (actual != grammar) {
				Assert.fail("Element " + EmfFormatter.objPath(ele) + " leaked!");
			}
		}
	}

	protected void toDot(Pda<ISerState, RuleCall> pda, String name) throws Exception {
		String test = Thread.currentThread().getStackTrace()[6].getMethodName();
		new PdaToDot<Object, Object>().draw(pda, "dot2/" + test + "_" + name + ".pdf", "-T pdf");
	}

	private String toListString(Pda<ISerState, RuleCall> pda) {
		GrammarElementTitleSwitch ts = new GrammarElementTitleSwitch().showAssignments().hideCardinality()
				.showQualified();
		PdaListFormatter<ISerState, RuleCall> formatter = new PdaListFormatter<ISerState, RuleCall>();
		formatter.setStateFormatter((Function<ISerState, String>) (ISerState it) -> {
			if (it.getType() != null) {
				switch (it.getType()) {
				case START:
					return "start";
				case STOP:
					return "stop";
				default:
					return ts.apply(it.getGrammarElement());
				}
			} else {
				return ts.apply(it.getGrammarElement());
			}
		});
		formatter.setStackitemFormatter(new GrammarElementTitleSwitch().showAssignments().hideCardinality());
		formatter.sortFollowers();
		return formatter.format(pda) + "\n";
	}
}
