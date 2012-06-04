package de.itemis.statefullexer;

import org.eclipse.xtext.util.formallang.Nfa;

@SuppressWarnings("restriction")
public interface NfaWithTransitions<STATE, TRANSITION> extends Nfa<STATE> {

	Iterable<TRANSITION> getOutgoingTransitions(STATE state);

	STATE getTarget(TRANSITION trans);
}
