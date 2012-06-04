package de.itemis.statefullexer;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;

public interface ILexerStatesProvider {

	public interface ILexerState {
		Set<EObject> getElements();

		int getID();

		Iterable<ILexerStateTransition> getOutgoingTransitions();

		AbstractRule getRule();

		Set<Object /* TerminalRule | String */> getTokens();
	}

	public interface ILexerStateTransition {
		AbstractElement getElement();

		ILexerState getSource();

		ILexerState getTarget();

		Object getToken();
	}

	public interface ILexerStates extends NfaWithTransitions<ILexerState, ILexerStateTransition>, NfaWithAllStates<ILexerState> {
	}

	public ILexerStates getStates(Grammar grammar);

}
