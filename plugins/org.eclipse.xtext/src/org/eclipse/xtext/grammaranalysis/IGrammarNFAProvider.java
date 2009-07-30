package org.eclipse.xtext.grammaranalysis;

import org.eclipse.xtext.AbstractElement;

public interface IGrammarNFAProvider<S, T> {

	public interface NFABuilder<S, T> {

		public boolean filter(AbstractElement ele);

		public NFADirection getDirection();

		public S getState(AbstractElement ele);

		public T getTransition(S source, S target, boolean isRuleCall);;
	}

	public enum NFADirection {
		BACKWARD, FORWARD
	}

	public S getNFA(AbstractElement element);
}
