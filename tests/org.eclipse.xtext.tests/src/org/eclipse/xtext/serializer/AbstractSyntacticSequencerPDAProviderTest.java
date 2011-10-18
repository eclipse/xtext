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
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.generator.serializer.SyntacticSequencerPDA2ExtendedDot;
import org.eclipse.xtext.grammaranalysis.IPDAState.PDAStateType;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IContextProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.GetGrammarElement;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.NfaToProduction;
import org.eclipse.xtext.util.formallang.ProductionStringFactory;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.internal.Join;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSyntacticSequencerPDAProviderTest extends AbstractXtextTests {
	//	protected class SequenceParserNDA2Dot extends GrammarToDot {
	//		protected SequencerNFAProvider nfaProvider = new SequencerNFAProvider();
	//
	//		@Override
	//		protected Node drawAbstractElementTree(AbstractElement ele, Digraph d) {
	//			Node n = super.drawAbstractElementTree(ele, d);
	//			SequencerNFAState nfas = nfaProvider.getNFA(ele);
	//
	//			for (SequencerNFATransition t : nfas.getOutgoing())
	//				d.add(drawFollowerEdge(ele, t, false));
	//			for (SequencerNFATransition t : nfas.getOutgoingAfterReturn())
	//				d.add(drawFollowerEdge(ele, t, true));
	//
	//			if (nfas.getOutgoing().size() == 0 && nfas.getOutgoingAfterReturn().size() == 0 && !nfas.isEndState())
	//				n.setStyle("dotted");
	//			if (nfas.isEndState())
	//				n.put("peripheries", "2");
	//			return n;
	//		}
	//
	//		protected Edge drawFollowerEdge(AbstractElement ele, SequencerNFATransition t, boolean isParent) {
	//			Edge e = new Edge(ele, t.getTarget().getGrammarElement());
	//			e.setLabel(String.valueOf(t.getPrecedence()));
	//			e.setStyle("dotted");
	//			if (isParent)
	//				e.put("arrowtail", "odot");
	//			if (t.isRuleCall())
	//				e.put("arrowhead", "onormalonormal");
	//			else
	//				e.put("arrowhead", "onormal");
	//			return e;
	//		}
	//	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	final static String HEADER = "grammar org.eclipse.xtext.serializer.SequenceParserPDAProviderTestLanguage"
			+ " with org.eclipse.xtext.common.Terminals "
			+ "generate sequenceParserPDAProviderTest \"http://www.eclipse.org/2010/tmf/xtext/SequenceParserPDAProvider\"  ";

	public void drawGrammar(String path, Grammar grammar) {
		try {
			IContextProvider contexts = get(IContextProvider.class);
			SyntacticSequencerPDA2ExtendedDot seq2dot = get(SyntacticSequencerPDA2ExtendedDot.class);
			for (EObject ctx : contexts.getAllContexts(grammar))
				for (EClass type : contexts.getTypesForContext(ctx))
					seq2dot.draw(
							new Pair<EObject, EClass>(ctx, type),
							path + "-" + new Context2NameFunction().apply(ctx) + "_"
									+ (type == null ? "null" : type.getName()) + "-PDA.pdf", "-T pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected String getParserRule(String body) throws Exception {
		return getParserRule2(body);
		//		Grammar grammar = (Grammar) getModel(HEADER + body);
		//		drawGrammar("pdf/" + getName(), grammar);
		//		List<String> result = Lists.newArrayList();
		//		for (Triple<EClass, EObject, String> ctx : getContexts(grammar)) {
		//			String t = ctx.getFirst() == null ? "null" : ctx.getFirst().getName();
		//			result.add(t + "_" + ctx.getThird() + ":");
		//			result.addAll(pda2lines(createSequenceParserPDAProvider().getPDA(ctx.getSecond(), ctx.getFirst())));
		//		}
		//		return Join.join("\n", result);
	}

	protected String getParserRule2(String body) throws Exception {
		Grammar grammar = (Grammar) getModel(HEADER + body);
		drawGrammar("pdf/" + getName(), grammar);
		List<String> result = Lists.newArrayList();
		for (Triple<EClass, EObject, String> ctx : getContexts(grammar)) {
			String t = ctx.getFirst() == null ? "null" : ctx.getFirst().getName();
			result.add(t + "_" + ctx.getThird() + ":");
			result.addAll(pda2lines2(createSequenceParserPDAProvider().getPDA(ctx.getSecond(), ctx.getFirst())));
		}
		return Join.join("\n", result);
	}

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

	private List<String> pda2lines(ISynAbsorberState start) {
		Set<ISynAbsorberState> states = Sets.newHashSet(start);
		collectAbsorberStates(start, Sets.<ISynState> newHashSet(), states);
		List<String> pdalines = Lists.newArrayList();
		for (ISynAbsorberState state : states)
			for (ISynState child : state.getFollowers())
				pdalines.add("  " + state + " " + pathToStr(child));
		Collections.sort(pdalines);
		return pdalines;
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

	protected abstract SyntacticSequencerPDAProvider createSequenceParserPDAProvider();

	private void collectAbsorberStates(ISynState state, Set<ISynState> visited, Set<ISynAbsorberState> result) {
		if (!visited.add(state))
			return;
		if (state instanceof ISynAbsorberState)
			result.add((ISynAbsorberState) state);
		for (ISynState follower : state.getFollowers())
			collectAbsorberStates(follower, visited, result);
	}

	private void pathToStr(ISynState state, Set<ISynState> visited, List<String> result) {
		if (!visited.add(state))
			result.add("!" + state);
		else if (state instanceof ISynAbsorberState)
			result.add(state.toString());
		else {
			result.add(state.toString());
			List<ISynState> follower = state.getFollowers();
			Collections.sort(follower, new Comparator<ISynState>() {
				public int compare(ISynState o1, ISynState o2) {
					return o1.toString().compareTo(o2.toString());
				}
			});
			for (ISynState child : follower)
				pathToStr(child, visited, result);
		}
	}

	private String pathToStr(ISynState state) {
		List<String> result = Lists.newArrayList();
		pathToStr(state, Sets.<ISynState> newHashSet(), result);
		return Joiner.on(" ").join(result);
	}

	private static class ToStr implements Function<ISynState, String> {
		private Function<AbstractElement, String> ts = new GrammarElementTitleSwitch().showAssignments()
				.hideCardinality().showQualified();

		public String apply(ISynState from) {
			return from.getType().getSimpleType() == PDAStateType.ELEMENT ? ts.apply(from.getGrammarElement()) : from
					.toString();
		}

	}

	private String pathToStr2(ISynTransition state) {
		ProductionStringFactory<String> factory = new ProductionStringFactory<String>();
		return new NfaToProduction().nfaToGrammar(state.getPathToTarget(), new ToStr(), factory);
	}
}
