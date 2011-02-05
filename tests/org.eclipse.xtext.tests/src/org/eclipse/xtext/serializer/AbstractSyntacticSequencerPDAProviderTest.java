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
import org.eclipse.xtext.grammaranalysis.IPDAState;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAEmitterState;
import org.eclipse.xtext.serializer.impl.SyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.impl.SyntacticSequencerPDAProvider.SequencerNFAProvider;
import org.eclipse.xtext.serializer.impl.SyntacticSequencerPDAProvider.SequencerNFAState;
import org.eclipse.xtext.serializer.impl.SyntacticSequencerPDAProvider.SequencerNFATransition;
import org.eclipse.xtext.serializer.impl.SyntacticSequencerPDAProvider.SequencerPDAProvider;
import org.eclipse.xtext.util.GraphvizDotBuilder;

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

	protected static class SequencePDA2Dot extends GraphvizDotBuilder {
		protected SequencerPDAProvider pdaProvider = new SequencerPDAProvider(new SequencerNFAProvider());

		public static void drawGrammar(String path, Grammar grammar) {
			try {
				for (ParserRule pr : GrammarUtil.allParserRules(grammar))
					new SequencePDA2Dot().draw(pr, path + "-" + pr.getName() + "-simple-PDA.pdf", "-T pdf");
				for (Action a : GrammarUtil.containedActions(grammar))
					if (a.getFeature() != null)
						new SequencePDA2Dot().draw(a, path + "-" + GrammarUtil.containingRule(a).getName() + "_"
								+ a.getType().getClassifier().getName() + "_" + a.getFeature() + "-PDA.pdf", "-T pdf");
			} catch (IOException e) {
			}
		}

		@Override
		protected Props drawObject(Object obj) {
			if (obj instanceof ParserRule)
				return drawGrammar(pdaProvider.getPDA((ParserRule) obj));
			if (obj instanceof Action)
				return drawGrammar(pdaProvider.getPDA((Action) obj));
			return null;
		}

		protected Digraph drawGrammar(IPDAState pr) {
			Digraph d = new Digraph();
			Set<IPDAState> visited = Sets.newHashSet();
			drawState(d, pr, visited);
			return d;
		}

		protected void drawState(Digraph d, IPDAState state, Set<IPDAState> visited) {
			if (state == null || !visited.add(state))
				return;
			Node n = new Node(state, state.toString());
			d.add(n);
			for (IPDAState follower : state.getFollowers()) {
				Edge edge = new Edge(state, follower);
				d.add(edge);
				drawState(d, follower, visited);
			}
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
			SequencePDA2Dot.drawGrammar("pdf/" + getName(), grammar);
			SequenceParserPDA2Dot.drawGrammar(createSequenceParserPDAProvider(), "pdf/" + getName(), grammar);
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
		return Join.join("\n", result);
	}

	private List<String> pda2lines(IPDAAbsorberState start) {
		Set<IPDAAbsorberState> states = Sets.newHashSet(start);
		collectAbsorberStates(start, Sets.<IPDAEmitterState> newHashSet(), states);
		List<String> pdalines = Lists.newArrayList();
		for (IPDAAbsorberState state : states)
			for (IPDAEmitterState child : state.getFollowers())
				pdalines.add("  " + state + " " + pathToStr(child));
		Collections.sort(pdalines);
		return pdalines;
	}

	protected abstract SyntacticSequencerPDAProvider createSequenceParserPDAProvider();

	private void collectAbsorberStates(IPDAEmitterState state, Set<IPDAEmitterState> visited,
			Set<IPDAAbsorberState> result) {
		if (!visited.add(state))
			return;
		if (state instanceof IPDAAbsorberState)
			result.add((IPDAAbsorberState) state);
		for (IPDAEmitterState follower : state.getFollowers())
			collectAbsorberStates(follower, visited, result);
	}

	private void pathToStr(IPDAEmitterState state, Set<IPDAEmitterState> visited, List<String> result) {
		if (!visited.add(state))
			result.add("!" + state);
		else if (state instanceof IPDAAbsorberState)
			result.add(state.toString());
		else {
			result.add(state.toString());
			List<IPDAEmitterState> follower = state.getFollowers();
			Collections.sort(follower, new Comparator<IPDAEmitterState>() {
				public int compare(IPDAEmitterState o1, IPDAEmitterState o2) {
					return o1.toString().compareTo(o2.toString());
				}
			});
			for (IPDAEmitterState child : follower)
				pathToStr(child, visited, result);
		}
	}

	private String pathToStr(IPDAEmitterState state) {
		List<String> result = Lists.newArrayList();
		pathToStr(state, Sets.<IPDAEmitterState> newHashSet(), result);
		return Join.join(" ", result);
	}
}
