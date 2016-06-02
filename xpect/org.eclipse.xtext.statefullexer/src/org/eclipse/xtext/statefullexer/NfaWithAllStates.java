package org.eclipse.xtext.statefullexer;

import org.eclipse.xtext.util.formallang.Nfa;

@SuppressWarnings("restriction")
public interface NfaWithAllStates<STATE> extends Nfa<STATE> {
	Iterable<STATE> getAllStates();
}
