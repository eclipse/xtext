package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.xtext.AbstractElement;

public class DefaultForwardNFAProvider extends
		AbstractNFAProvider<DefaultNFAState, DefaultNFATransition> {

	public static class DefaultBackwardsNFABuilder extends
			AbstractCachingNFABuilder<DefaultNFAState, DefaultNFATransition> {

		public DefaultNFAState createState(AbstractElement ele) {
			return new DefaultNFAState(ele, this);
		}

		protected DefaultNFATransition createTransition(DefaultNFAState source,
				DefaultNFAState target, boolean isRuleCall) {
			return new DefaultNFATransition(source, target, isRuleCall);
		}

		@Override
		public boolean filter(AbstractElement ele) {
			return false;
		}

		public NFADirection getDirection() {
			return NFADirection.FORWARD;
		}
	}

	@Override
	protected NFABuilder<DefaultNFAState, DefaultNFATransition> createBuilder() {
		return new DefaultBackwardsNFABuilder();
	}
}
