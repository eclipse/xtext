package org.eclipse.xtext.generator.serializer;

import java.io.IOException;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.serializer.analysis.IContextProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.SyntacticSequencerPDAProvider.SequencerPDAContext;
import org.eclipse.xtext.util.GraphvizDotBuilder;

import com.google.common.collect.Sets;

public class SyntacticSequencerPDA2ExtendedDot extends GraphvizDotBuilder {
	protected ISyntacticSequencerPDAProvider pdaProvider;

	public SyntacticSequencerPDA2ExtendedDot(ISyntacticSequencerPDAProvider pdaProvider) {
		super();
		this.pdaProvider = pdaProvider;
	}

	public SyntacticSequencerPDA2ExtendedDot() {
		super();
		this.pdaProvider = new SyntacticSequencerPDAProvider();
	}

	public static void drawGrammar(IContextProvider contexts, ISyntacticSequencerPDAProvider provider, String path,
			Grammar grammar) {
		try {
			for (EObject ctx : contexts.getAllContexts(grammar))
				for (EClass type : contexts.getTypesForContext(ctx))
					new SyntacticSequencerPDA2ExtendedDot(provider).draw(new SequencerPDAContext(ctx, type), path + "-"
							+ new Context2NameFunction().apply(ctx) + "_" + type.getName() + "-PDA.pdf", "-T pdf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Props drawObject(Object obj) {
		if (obj instanceof SequencerPDAContext) {
			SequencerPDAContext ctx = (SequencerPDAContext) obj;
			return drawGrammar(pdaProvider.getPDA(ctx.getContext(), ctx.getType()));
		}
		return null;
	}

	protected Digraph drawGrammar(ISynState pr) {
		Digraph d = new Digraph();
		Set<ISynState> visited = Sets.newHashSet();
		drawState(d, pr, visited);
		return d;
	}

	protected void drawState(Digraph d, ISynState state, Set<ISynState> visited) {
		if (!visited.add(state))
			return;
		Node n = new Node(state, state.toString());
		if (!(state instanceof ISynAbsorberState))
			n.setStyle("dotted");
		d.add(n);
		for (ISynState trans : state.getFollowers()) {
			Edge edge = new Edge(state, trans);
			d.add(edge);
			drawState(d, trans, visited);
		}
	}
}