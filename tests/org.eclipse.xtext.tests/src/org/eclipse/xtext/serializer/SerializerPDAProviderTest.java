/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.generator.serializer.SyntacticSequencerPDA2ExtendedDot;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IContextProvider;
import org.eclipse.xtext.serializer.analysis.ISerializerPDAProvider;
import org.eclipse.xtext.serializer.analysis.ISerializerPDAProvider.ISerState;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaListFormatter;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.inject.internal.Join;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SerializerPDAProviderTest extends AbstractXtextTests {
	private static class ToStr implements Function<ISerState, String> {
		private Function<AbstractElement, String> ts = new GrammarElementTitleSwitch().showAssignments()
				.hideCardinality().showQualified();

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

	//	public void drawGrammar(String path, Grammar grammar) {
	//		try {
	//			IContextProvider contexts = get(IContextProvider.class);
	//			SyntacticSequencerPDA2ExtendedDot seq2dot = get(SyntacticSequencerPDA2ExtendedDot.class);
	//			for (EObject ctx : contexts.getAllContexts(grammar))
	//				for (EClass type : contexts.getTypesForContext(ctx))
	//					seq2dot.draw(
	//							new Pair<EObject, EClass>(ctx, type),
	//							path + "-" + new Context2NameFunction().apply(ctx) + "_"
	//									+ (type == null ? "null" : type.getName()) + "-PDA.pdf", "-T pdf");
	//		} catch (IOException e) {
	//			e.printStackTrace();
	//		}
	//	}

	private List<Triple<EClass, EObject, String>> getContexts(Grammar grammar) {
		final Context2NameFunction ctx2name = get(Context2NameFunction.class);
		final IContextProvider contextProvider = get(IContextProvider.class);
		List<Triple<EClass, EObject, String>> result = Lists.newArrayList();
		for (EObject ctx : contextProvider.getAllContexts(grammar))
			for (EClass type : contextProvider.getTypesForContext(ctx))
				result.add(Tuples.create(type, ctx, ctx2name.getContextName(ctx)));
		Collections.sort(result, new Comparator<Triple<EClass, EObject, String>>() {
			public int compare(Triple<EClass, EObject, String> o1, Triple<EClass, EObject, String> o2) {
				String n1 = o1.getFirst() == null ? "null" : o1.getFirst().getName();
				String n2 = o2.getFirst() == null ? "null" : o2.getFirst().getName();
				int c = n1.compareTo(n2);
				if (c != 0)
					return c;
				return o1.getThird().compareTo(o2.getThird());
			}
		});
		return result;
	}

	protected String getParserRule(String body) throws Exception {
		Grammar grammar = (Grammar) getModel(HEADER + body);
		//		drawGrammar("pdf/" + getName(), grammar);
		List<String> result = Lists.newArrayList();
		PdaListFormatter<ISerState, RuleCall> formatter = new PdaListFormatter<ISerState, RuleCall>();
		formatter.setStateFormatter(new ToStr());
		formatter.setStackitemFormatter(new GrammarElementTitleSwitch().showAssignments().hideCardinality());
		for (Triple<EClass, EObject, String> ctx : getContexts(grammar)) {
			String t = ctx.getFirst() == null ? "null" : ctx.getFirst().getName();
			result.add(t + "_" + ctx.getThird() + ":");
			Pda<? extends ISerState, RuleCall> pda = get(ISerializerPDAProvider.class).getPDA(ctx.getSecond(),
					ctx.getFirst());
			result.add("  " + formatter.format((Pda<ISerState, RuleCall>) pda).replace("\n", "\n  "));
		}
		return Join.join("\n", result);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	public void testKeywordAlternative() throws Exception {
		String actual = getParserRule("Rule: a1=ID ('kw1' | 'kw2') a2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Rule_Rule:\n");
		expected.append("  start -> a1=ID\n");
		expected.append("  'kw1' -> a2=ID\n");
		expected.append("  'kw2' -> a2=ID\n");
		expected.append("  a1=ID -> 'kw1', 'kw2'\n");
		expected.append("  a2=ID -> stop");
		assertEquals(expected.toString(), actual);
	}

	public void testDelegation1() throws Exception {
		String actual = getParserRule("Rule: Delegate; Delegate: val=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Delegate_Delegate:\n");
		expected.append("  start -> val=ID\n");
		expected.append("  val=ID -> stop\n");
		expected.append("Delegate_Rule:\n");
		expected.append("  start -> >>Delegate\n");
		expected.append("  <<Delegate -> stop\n");
		expected.append("  >>Delegate -> val=ID\n");
		expected.append("  val=ID -> <<Delegate");
		assertEquals(expected.toString(), actual);
	}

	public void testDelegation2() throws Exception {
		String actual = getParserRule("Rule: Foo | Delegate1; Delegate1: 'del' Delegate2 bar=ID; Delegate2: val=ID; Foo: val2=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Delegate2_Delegate1:\n");
		expected.append("  start -> 'del'\n");
		expected.append("  'del' -> >>Delegate2\n");
		expected.append("  <<Delegate2 -> bar=ID\n");
		expected.append("  >>Delegate2 -> val=ID\n");
		expected.append("  bar=ID -> stop\n");
		expected.append("  val=ID -> <<Delegate2\n");
		expected.append("Delegate2_Delegate2:\n");
		expected.append("  start -> val=ID\n");
		expected.append("  val=ID -> stop\n");
		expected.append("Delegate2_Rule:\n");
		expected.append("  start -> >>Delegate1\n");
		expected.append("  'del' -> >>Delegate2\n");
		expected.append("  <<Delegate1 -> stop\n");
		expected.append("  <<Delegate2 -> bar=ID\n");
		expected.append("  >>Delegate1 -> 'del'\n");
		expected.append("  >>Delegate2 -> val=ID\n");
		expected.append("  bar=ID -> <<Delegate1\n");
		expected.append("  val=ID -> <<Delegate2\n");
		expected.append("Foo_Foo:\n");
		expected.append("  start -> val2=ID\n");
		expected.append("  val2=ID -> stop\n");
		expected.append("Foo_Rule:\n");
		expected.append("  start -> >>Foo\n");
		expected.append("  <<Foo -> stop\n");
		expected.append("  >>Foo -> val2=ID\n");
		expected.append("  val2=ID -> <<Foo");
		assertEquals(expected.toString(), actual);
	}

	public void testExpression1() throws Exception {
		String actual = getParserRule("Exp: 'kw' Addit; Addit returns Exp: Prim ({Add.left=current} '+' right=Prim)*; Prim returns Exp: {Val} val=ID;");
		StringBuilder expected = new StringBuilder();
		expected.append("Add_Addit:\n");
		expected.append("  start -> {Add.left=}\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  right=Prim -> stop\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("Add_Addit_Add_1_0:\n");
		expected.append("  start -> {Add.left=}\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  right=Prim -> stop\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("Add_Exp:\n");
		expected.append("  start -> 'kw'\n");
		expected.append("  '+' -> right=Prim\n");
		expected.append("  'kw' -> >>Addit\n");
		expected.append("  <<Addit -> stop\n");
		expected.append("  >>Addit -> {Add.left=}\n");
		expected.append("  right=Prim -> <<Addit\n");
		expected.append("  {Add.left=} -> '+'\n");
		expected.append("Val_Addit:\n");
		expected.append("  start -> >>Prim\n");
		expected.append("  <<Prim -> stop\n");
		expected.append("  >>Prim -> {Val}\n");
		expected.append("  val=ID -> <<Prim\n");
		expected.append("  {Val} -> val=ID\n");
		expected.append("Val_Addit_Add_1_0:\n");
		expected.append("  start -> >>Prim\n");
		expected.append("  <<Prim -> stop\n");
		expected.append("  >>Prim -> {Val}\n");
		expected.append("  val=ID -> <<Prim\n");
		expected.append("  {Val} -> val=ID\n");
		expected.append("Val_Exp:\n");
		expected.append("  start -> 'kw'\n");
		expected.append("  'kw' -> >>Addit\n");
		expected.append("  <<Addit -> stop\n");
		expected.append("  <<Prim -> <<Addit\n");
		expected.append("  >>Addit -> >>Prim\n");
		expected.append("  >>Prim -> {Val}\n");
		expected.append("  val=ID -> <<Prim\n");
		expected.append("  {Val} -> val=ID\n");
		expected.append("Val_Prim:\n");
		expected.append("  start -> {Val}\n");
		expected.append("  val=ID -> stop\n");
		expected.append("  {Val} -> val=ID");
		assertEquals(expected.toString(), actual);
	}
	
	public void testOptionalDelegate() throws Exception {
		String actual = getParserRule("Rule: Mand | Opt; Mand: 'm' mand=ID; Opt: 'o' opt=ID?;");
		StringBuilder expected = new StringBuilder();
		expected.append("Mand_Mand:\n");
		expected.append("  start -> 'm'\n");
		expected.append("  'm' -> mand=ID\n");
		expected.append("  mand=ID -> stop\n");
		expected.append("Mand_Rule:\n");
		expected.append("  start -> >>Mand\n");
		expected.append("  'm' -> mand=ID\n");
		expected.append("  <<Mand -> stop\n");
		expected.append("  >>Mand -> 'm'\n");
		expected.append("  mand=ID -> <<Mand\n");
		expected.append("Opt_Opt:\n");
		expected.append("  start -> 'o'\n");
		expected.append("  'o' -> opt=ID, stop\n");
		expected.append("  opt=ID -> stop\n");
		expected.append("Opt_Rule:\n");
		expected.append("  start -> >>Opt\n");
		expected.append("  'o' -> opt=ID, <<Opt\n");
		expected.append("  <<Opt -> stop\n");
		expected.append("  >>Opt -> 'o'\n");
		expected.append("  opt=ID -> <<Opt\n");
		expected.append("null_Opt:\n");
		expected.append("  start -> 'o'\n");
		expected.append("  'o' -> stop\n");
		expected.append("null_Rule:\n");
		expected.append("  start -> >>Opt\n");
		expected.append("  'o' -> <<Opt\n");
		expected.append("  <<Opt -> stop\n");
		expected.append("  >>Opt -> 'o'");
		assertEquals(expected.toString(), actual);
	}
}
