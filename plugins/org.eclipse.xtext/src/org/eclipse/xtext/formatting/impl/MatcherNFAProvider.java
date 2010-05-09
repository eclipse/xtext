/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.AbstractCachingNFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAProvider;

public class MatcherNFAProvider extends AbstractNFAProvider<MatcherState, MatcherTransition> {

	protected static class MatcherNFABuilder extends AbstractCachingNFABuilder<MatcherState, MatcherTransition> {

		@Override
		protected MatcherState createState(AbstractElement grammarElement) {
			return new MatcherState(grammarElement, this);
		}

		@Override
		protected MatcherTransition createTransition(MatcherState source, MatcherState target, boolean isRuleCall) {
			return new MatcherTransition(source, target, isRuleCall);
		}

		@Override
		public boolean filter(AbstractElement grammarElement) {
			if (grammarElement instanceof Keyword)
				return false;
			if (grammarElement instanceof RuleCall)
				return false;
			if (grammarElement instanceof RuleCall) {
				AbstractRule rule = ((RuleCall) grammarElement).getRule();
				if (rule instanceof ParserRule)
					return !GrammarUtil.isDatatypeRule((ParserRule) rule);
				return false;
			}
			return true;
		}

		public NFADirection getDirection() {
			return NFADirection.FORWARD;
		}
	}

	@Override
	protected NFABuilder<MatcherState, MatcherTransition> createBuilder() {
		return new MatcherNFABuilder();
	}

}
