/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.serializer;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.GraphvizDotBuilder;

public class SyntacticSequencerPDA2ExtendedDot extends GraphvizDotBuilder {
	@Override
	protected GraphvizDotBuilder.Props drawObject(Object obj) {
		if (obj instanceof ISyntacticSequencerPDAProvider.ISynState) {
			return drawGrammar((ISyntacticSequencerPDAProvider.ISynState) obj);
		}
		return null;
	}

	protected GraphvizDotBuilder.Digraph drawGrammar(ISyntacticSequencerPDAProvider.ISynState pr) {
		GraphvizDotBuilder.Digraph d = new GraphvizDotBuilder.Digraph();
		Set<ISyntacticSequencerPDAProvider.ISynState> visited = new HashSet<>();
		drawState(d, pr, visited);
		return d;
	}

	protected void drawState(GraphvizDotBuilder.Digraph d, ISyntacticSequencerPDAProvider.ISynState state,
			Set<ISyntacticSequencerPDAProvider.ISynState> visited) {
		if (!visited.add(state)) {
			return;
		}
		GraphvizDotBuilder.Node n = new GraphvizDotBuilder.Node(state, state.toString());
		if (!(state instanceof ISyntacticSequencerPDAProvider.ISynAbsorberState)) {
			n.setStyle("dotted");
		}
		d.add(n);
		for (ISyntacticSequencerPDAProvider.ISynState trans : state.getFollowers()) {
			GraphvizDotBuilder.Edge edge = new GraphvizDotBuilder.Edge(state, trans);
			d.add(edge);
			drawState(d, trans, visited);
		}
	}
}
