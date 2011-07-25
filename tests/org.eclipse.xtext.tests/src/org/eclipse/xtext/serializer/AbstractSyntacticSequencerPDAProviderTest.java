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
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarToDot;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IContextProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerNFAProvider;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerNFAState;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerNFATransition;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.internal.Join;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSyntacticSequencerPDAProviderTest extends AbstractXtextTests {
	protected class SequenceParserNDA2Dot extends GrammarToDot {
		protected SequencerNFAProvider nfaProvider = new SequencerNFAProvider();

		@Override
		protected Node drawAbstractElementTree(AbstractElement ele, Digraph d) {
			Node n = super.drawAbstractElementTree(ele, d);
			SequencerNFAState nfas = nfaProvider.getNFA(ele);

			for (SequencerNFATransition t : nfas.getOutgoing())
				d.add(drawFollowerEdge(ele, t, false));
			for (SequencerNFATransition t : nfas.getOutgoingAfterReturn())
				d.add(drawFollowerEdge(ele, t, true));

			if (nfas.getOutgoing().size() == 0 && nfas.getOutgoingAfterReturn().size() == 0 && !nfas.isEndState())
				n.setStyle("dotted");
			if (nfas.isEndState())
				n.put("peripheries", "2");
			return n;
		}

		protected Edge drawFollowerEdge(AbstractElement ele, SequencerNFATransition t, boolean isParent) {
			Edge e = new Edge(ele, t.getTarget().getGrammarElement());
			e.setLabel(String.valueOf(t.getPrecedence()));
			e.setStyle("dotted");
			if (isParent)
				e.put("arrowtail", "odot");
			if (t.isRuleCall())
				e.put("arrowhead", "onormalonormal");
			else
				e.put("arrowhead", "onormal");
			return e;
		}
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
	}

	final static String HEADER = "grammar org.eclipse.xtext.serializer.SequenceParserPDAProviderTestLanguage"
			+ " with org.eclipse.xtext.common.Terminals "
			+ "generate sequenceParserPDAProviderTest \"http://www.eclipse.org/2010/tmf/xtext/SequenceParserPDAProvider\"  ";

	protected String getParserRule(String body) throws Exception {
		Grammar grammar = (Grammar) getModel(HEADER + body);
		//		new SequenceParserNDA2Dot().draw(grammar, "pdf/" + getName() + "-NFA.pdf", "-T pdf");
		//		SyntacticSequencerPDA2SimpleDot.drawGrammar(get(IContextProvider.class), "pdf/" + getName(), grammar);
		//		SyntacticSequencerPDA2ExtendedDot.drawGrammar(get(IContextProvider.class), createSequenceParserPDAProvider(),
		//				"pdf/" + getName(), grammar);
		List<String> result = Lists.newArrayList();
		for (Triple<EClass, EObject, String> ctx : getContexts(grammar)) {
			String t = ctx.getFirst() == null ? "null" : ctx.getFirst().getName();
			result.add(t + "_" + ctx.getThird() + ":");
			result.addAll(pda2lines(createSequenceParserPDAProvider().getPDA(ctx.getSecond(), ctx.getFirst())));
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
}
