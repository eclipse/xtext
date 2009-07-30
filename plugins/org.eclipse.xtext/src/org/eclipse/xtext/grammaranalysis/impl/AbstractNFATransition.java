/**
 * 
 */
package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.xtext.grammaranalysis.INFAState;
import org.eclipse.xtext.grammaranalysis.INFATransition;

public class AbstractNFATransition<S,T> implements INFATransition<S,T> {

	protected boolean ruleCall;

	protected S source;

	protected S target;

	public AbstractNFATransition(S source, S target,
			boolean ruleCall) {
		super();
		this.source = source;
		this.target = target;
		this.ruleCall = ruleCall;
	}

	@Override
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {
		if(obj instanceof AbstractNFATransition) {
			AbstractNFATransition a = (AbstractNFATransition)obj;
			return a.source == source && a.target == target;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public int getPrecedence() {
		INFAState<S, T> s = (INFAState<S, T>) source;
		int i = s.getFollowers().indexOf(this);
		return i > -1 ? i : s.getParentFollowers().indexOf(this);
	}

	public S getTarget() {
		return target;
	}

	@Override
	public int hashCode() {
		return source.hashCode() + target.hashCode();
	}

	public boolean isRuleCall() {
		return ruleCall;
	}

}