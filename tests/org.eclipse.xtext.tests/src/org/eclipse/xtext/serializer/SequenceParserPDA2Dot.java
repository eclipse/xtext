package org.eclipse.xtext.serializer;

import java.io.IOException;
import java.util.Set;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.util.GraphvizDotBuilder;

import com.google.common.collect.Sets;

public class SequenceParserPDA2Dot extends GraphvizDotBuilder {
	protected ISyntacticSequencerPDAProvider pdaProvider;

	public SequenceParserPDA2Dot(ISyntacticSequencerPDAProvider pdaProvider) {
		super();
		this.pdaProvider = pdaProvider;
	}

	public static void drawGrammar(ISyntacticSequencerPDAProvider provider, String path, Grammar grammar) {
		try {
			for (ParserRule pr : GrammarUtil.allParserRules(grammar))
				new SequenceParserPDA2Dot(provider).draw(pr, path + "-" + pr.getName() + "-PDA.pdf", "-T pdf");
			for (Action a : GrammarUtil.containedActions(grammar))
				if (a.getFeature() != null)
					new SequenceParserPDA2Dot(provider)
							.draw(a, path + "-" + GrammarUtil.containingRule(a).getName() + "_"
									+ a.getType().getClassifier().getName() + "_" + a.getFeature() + "-PDA.pdf",
									"-T pdf");
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