package org.eclipse.xtext.generator.serializer;

import java.util.Set;

import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynState;
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

	//	public static void drawGrammar(ISyntacticSequencerPDAProvider provider, String path, Grammar grammar) {
	//		try {
	//			for (ParserRule pr : GrammarUtil.allParserRules(grammar))
	//				new SyntacticSequencerPDA2ExtendedDot(provider).draw(pr, path + "-" + pr.getName() + "-PDA.pdf", "-T pdf");
	//			for (Action a : GrammarUtil.containedActions(grammar))
	//				if (a.getFeature() != null)
	//					new SyntacticSequencerPDA2ExtendedDot(provider)
	//							.draw(a, path + "-" + GrammarUtil.containingRule(a).getName() + "_"
	//									+ a.getType().getClassifier().getName() + "_" + a.getFeature() + "-PDA.pdf",
	//									"-T pdf");
	//		} catch (IOException e) {
	//		}
	//	}

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