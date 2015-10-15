/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.serializer

import java.util.Set
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState
import org.eclipse.xtext.util.GraphvizDotBuilder

class SyntacticSequencerPDA2ExtendedDot extends GraphvizDotBuilder {

	override protected Props drawObject(Object obj) {
		if (obj instanceof ISynState)
			drawGrammar(obj)
	}

	def protected Digraph drawGrammar(ISynState pr) {
		val d = new Digraph
		val Set<ISynState> visited = newHashSet
		drawState(d, pr, visited)
		return d
	}

	def protected void drawState(Digraph d, ISynState state, Set<ISynState> visited) {
		if (!visited.add(state))
			return;
		val n = new Node(state, state.toString)
		if (!(state instanceof ISynAbsorberState))
			n.style = 'dotted'
		d.add(n)
		for (trans : state.followers) {
			val edge = new Edge(state, trans)
			d.add(edge)
			drawState(d, trans, visited)
		}
	}
}
