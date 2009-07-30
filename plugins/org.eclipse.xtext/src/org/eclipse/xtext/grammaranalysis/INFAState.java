package org.eclipse.xtext.grammaranalysis;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;

public interface INFAState<S, T> {
	public NFABuilder<S, T> getBuilder();

	public AbstractElement getElement();

	public List<T> getFollowers();

	public List<T> getParentFollowers();

	public boolean isEndState();

	public boolean isStartState();
}
