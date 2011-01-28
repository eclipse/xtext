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

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarToDot;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAEmitterState;
import org.eclipse.xtext.serializer.impl.SequenceParserPDAProvider;
import org.eclipse.xtext.serializer.impl.SequenceParserPDAProvider.SequenceParserNFAProvider;
import org.eclipse.xtext.serializer.impl.SequenceParserPDAProvider.SequenceParserState;
import org.eclipse.xtext.serializer.impl.SequenceParserPDAProvider.SequenceParserTransition;
import org.eclipse.xtext.util.GraphvizDotBuilder;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.internal.Join;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSyntacticSequencerPDAProviderTest extends AbstractXtextTests {
	protected class SequenceParserNDA2Dot extends GrammarToDot {
		protected SequenceParserNFAProvider nfaProvider = createSequenceParserPDAProvider().new SequenceParserNFAProvider();

		@Override
		protected Node drawAbstractElementTree(AbstractElement ele, Digraph d) {
			Node n = super.drawAbstractElementTree(ele, d);
			SequenceParserState nfas = nfaProvider.getNFA(ele);

			for (SequenceParserTransition t : nfas.getOutgoing())
				d.add(drawFollowerEdge(ele, t, false));
			for (SequenceParserTransition t : nfas.getOutgoingAfterReturn())
				d.add(drawFollowerEdge(ele, t, true));

			if (nfas.getOutgoing().size() == 0 && nfas.getOutgoingAfterReturn().size() == 0 && !nfas.isEndState())
				n.setStyle("dotted");
			if (nfas.isEndState())
				n.put("peripheries", "2");
			return n;
		}

		protected Edge drawFollowerEdge(AbstractElement ele, SequenceParserTransition t, boolean isParent) {
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

	protected class SequenceParserPDA2Dot extends GraphvizDotBuilder {
		protected SequenceParserPDAProvider pdaProvider = createSequenceParserPDAProvider();

		@Override
		protected Props drawObject(Object obj) {
			if (obj instanceof Grammar)
				return drawGrammar((Grammar) obj);
			return null;
		}

		protected Digraph drawGrammar(Grammar grammar) {
			Digraph d = new Digraph();
			Set<IPDAEmitterState> visited = Sets.newHashSet();
			drawState(d, pdaProvider.getPDA(grammar), visited);
			return d;
		}

		protected void drawState(Digraph d, IPDAEmitterState state, Set<IPDAEmitterState> visited) {
			if (!visited.add(state))
				return;
			Node n = new Node(state, state.toString());
			if (!(state instanceof IPDAAbsorberState))
				n.setStyle("dotted");
			d.add(n);
			for (IPDAEmitterState trans : state.getFollowers()) {
				Edge edge = new Edge(state, trans);
				d.add(edge);
				drawState(d, trans, visited);
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
			new SequenceParserPDA2Dot().draw(grammar, "pdf/" + getName() + "-PDA.pdf", "-T pdf");
			//			System.out.println(new SequenceParserPDA2Dot().draw(grammar));
		} catch (IOException e) {
			e.printStackTrace();
		}

		IPDAAbsorberState start = createSequenceParserPDAProvider().getPDA(grammar);
		Set<IPDAAbsorberState> states = Sets.newHashSet(start);
		collectAbsorberStates(start, Sets.<IPDAEmitterState> newHashSet(), states);
		List<String> result = Lists.newArrayList();
		for (IPDAAbsorberState state : states)
			for (IPDAEmitterState child : state.getFollowers())
				result.add(state + " " + pathToStr(child));
		Collections.sort(result);
		return Join.join("\n", result);
	}

	protected abstract SequenceParserPDAProvider createSequenceParserPDAProvider();

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
