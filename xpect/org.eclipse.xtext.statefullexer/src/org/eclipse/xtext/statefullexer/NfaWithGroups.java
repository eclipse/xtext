package org.eclipse.xtext.statefullexer;

import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaFactory;

@SuppressWarnings("restriction")
public interface NfaWithGroups<GROUP, STATE> extends Nfa<STATE> {
	public interface NfaWithGroupsFactory<NFA extends Nfa<STATE>, GROUP, STATE, TOKEN> extends NfaFactory<NFA, STATE, TOKEN> {
		void setGroup(NFA nfa, GROUP group, STATE state);
	}

	Iterable<GROUP> getAllGroups();

	GROUP getGroupFromState(STATE state);

	Iterable<STATE> getStatesInGroup(GROUP group);
}
