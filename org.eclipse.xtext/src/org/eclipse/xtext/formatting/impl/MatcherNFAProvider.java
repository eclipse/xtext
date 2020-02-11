/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.impl.AbstractCachingNFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAProvider;

import com.google.inject.Singleton;

@Singleton
public class MatcherNFAProvider extends AbstractNFAProvider<MatcherState, MatcherTransition> {

	protected static class MatcherNFABuilder extends AbstractCachingNFABuilder<MatcherState, MatcherTransition> {

		@Override
		protected MatcherState createState(AbstractElement grammarElement) {
			return new MatcherState(grammarElement, this);
		}

		@Override
		protected MatcherTransition createTransition(MatcherState source, MatcherState target, boolean isRuleCall,
				AbstractElement loopCenter) {
			return new MatcherTransition(source, target, isRuleCall, loopCenter);
		}

		@Override
		public boolean filter(AbstractElement grammarElement) {
			if (grammarElement instanceof CrossReference)
				return false;
			if (isContainedInCrossReference(grammarElement))
				return true;
			if (grammarElement instanceof Keyword)
				return false;
			if (grammarElement instanceof RuleCall)
				return false;
			return true;
		}

		@Override
		public NFADirection getDirection() {
			return NFADirection.FORWARD;
		}

		protected boolean isContainedInCrossReference(EObject obj) {
			EObject cnt = obj.eContainer();
			if (cnt == null)
				return false;
			if (cnt instanceof CrossReference)
				return true;
			if (cnt instanceof Group)
				return false;
			return isContainedInCrossReference(cnt);
		}
	}

	@Override
	protected NFABuilder<MatcherState, MatcherTransition> createBuilder() {
		return new MatcherNFABuilder();
	}

}
