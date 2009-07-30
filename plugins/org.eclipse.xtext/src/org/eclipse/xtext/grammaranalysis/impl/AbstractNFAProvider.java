package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider;

public abstract class AbstractNFAProvider<S, T> implements
		IGrammarNFAProvider<S, T> {

	protected NFABuilder<S, T> builder = createBuilder();

	protected abstract NFABuilder<S, T> createBuilder();

	public S getNFA(AbstractElement element) {
		return builder.getState(element);
	}
}
