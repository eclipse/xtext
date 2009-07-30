package org.eclipse.xtext.grammaranalysis;

public interface INFATransition<S, T> {
	public int getPrecedence();

	public S getTarget();

	public boolean isRuleCall();
}
