/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import java.util.Set;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.grammaranalysis.IPDAState;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerNFAProvider;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerPDAProvider;
import org.eclipse.xtext.util.GraphvizDotBuilder;

import com.google.common.collect.Sets;

public class SyntacticSequencerPDA2SimpleDot extends GraphvizDotBuilder {
	protected SequencerPDAProvider pdaProvider = new SequencerPDAProvider(new SequencerNFAProvider());

	//	public static void drawGrammar(String path, Grammar grammar) {
	//		try {
	//			for (ParserRule pr : GrammarUtil.allParserRules(grammar))
	//				new SyntacticSequencerPDA2SimpleDot().draw(pr, path + "-" + pr.getName() + "-simple-PDA.pdf", "-T pdf");
	//			for (Action a : GrammarUtil.containedActions(grammar))
	//				if (a.getFeature() != null)
	//					new SyntacticSequencerPDA2SimpleDot().draw(a, path + "-" + GrammarUtil.containingRule(a).getName() + "_"
	//							+ a.getType().getClassifier().getName() + "_" + a.getFeature() + "-PDA.pdf", "-T pdf");
	//		} catch (IOException e) {
	//		}
	//	}

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
