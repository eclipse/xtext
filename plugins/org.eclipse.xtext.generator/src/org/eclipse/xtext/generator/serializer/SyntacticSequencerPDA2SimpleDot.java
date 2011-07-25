/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.serializer;

import java.io.IOException;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.grammaranalysis.IPDAState;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IContextProvider;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerNFAProvider;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerPDAContext;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerPDAProvider;
import org.eclipse.xtext.util.GraphvizDotBuilder;

import com.google.common.collect.Sets;

public class SyntacticSequencerPDA2SimpleDot extends GraphvizDotBuilder {
	protected SequencerPDAProvider pdaProvider = new SequencerPDAProvider(new SequencerNFAProvider());

	public static void drawGrammar(IContextProvider contexts, String path, Grammar grammar) {
		try {
			for (EObject ctx : contexts.getAllContexts(grammar))
				for (EClass type : contexts.getTypesForContext(ctx))
					new SyntacticSequencerPDA2SimpleDot()
							.draw(new SequencerPDAContext(ctx, type),
									path + "-" + new Context2NameFunction().apply(ctx) + "_" + type.getName()
											+ "-simplePDA.pdf", "-T pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Props drawObject(Object obj) {
		if (obj instanceof SequencerPDAContext)
			return drawGrammar(pdaProvider.getPDA((SequencerPDAContext) obj));
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
