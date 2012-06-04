package de.itemis.statefullexer;

import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaToDot;

@SuppressWarnings("restriction")
public class NfaToDot2<STATE, TRANSITION> extends NfaToDot<STATE> {

	@Override
	@SuppressWarnings("unchecked")
	protected Edge create(Digraph result, Nfa<STATE> nfa, STATE from, STATE to) {
		Edge edge = new Edge(from, to);
		if (nfa instanceof NfaWithTransitions<?, ?>) {
			NfaWithTransitions<STATE, TRANSITION> n = (NfaWithTransitions<STATE, TRANSITION>) nfa;
			for (TRANSITION t : n.getOutgoingTransitions(from))
				if (n.getTarget(t) == to)
					edge.setLabel(t.toString());
		}
		return edge;
	}

	protected Node create(Digraph result, Nfa<STATE> nfa, STATE state) {
		Node n = new Node(state, stateToString(nfa, state));
		if (state == nfa.getStart() || state == nfa.getStop())
			n.setShape("diamond");
		return n;
	}
}
