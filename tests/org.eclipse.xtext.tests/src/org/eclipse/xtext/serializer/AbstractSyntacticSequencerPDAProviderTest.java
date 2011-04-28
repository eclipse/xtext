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
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarToDot;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerNFAProvider;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerNFAState;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerNFATransition;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

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
		try {
			new SequenceParserNDA2Dot().draw(grammar, "pdf/" + getName() + "-NFA.pdf", "-T pdf");
			//			SyntacticSequencerPDA2SimpleDot.drawGrammar("pdf/" + getName(), grammar);
			//			SyntacticSequencerPDA2ExtendedDot.drawGrammar(createSequenceParserPDAProvider(), "pdf/" + getName(), grammar);
			//			System.out.println(new SequenceParserPDA2Dot().draw(grammar));
		} catch (IOException e) {
		}

		List<String> result = Lists.newArrayList();
		for (ParserRule pr : GrammarUtil.allParserRules(grammar))
			if (pr.getType().getClassifier() instanceof EClass) {
				result.add(pr.getName() + ":");
				result.addAll(pda2lines(createSequenceParserPDAProvider().getPDA(pr)));
			}
		for (Action act : GrammarUtil.containedActions(grammar))
			if (act.getFeature() != null) {
				result.add("{" + act.getType().getClassifier().getName() + "." + act.getFeature() + "}" + ":");
				result.addAll(pda2lines(createSequenceParserPDAProvider().getPDA(act)));
			}
		return Joiner.on("\n").join(result);
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
