package org.eclipse.xtext.serializer;

import java.io.IOException;
import java.util.Set;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAEmitterState;
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

	protected Digraph drawGrammar(IPDAEmitterState pr) {
		Digraph d = new Digraph();
		Set<IPDAEmitterState> visited = Sets.newHashSet();
		drawState(d, pr, visited);
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