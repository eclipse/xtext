/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.grammaranalysis.impl.AbstractCachingNFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAProvider;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFATransition;
import org.eclipse.xtext.serializer.analysis.ActionFilterNFAProvider.ActionFilterState;
import org.eclipse.xtext.serializer.analysis.ActionFilterNFAProvider.ActionFilterTransition;

import com.google.inject.Singleton;

@Singleton
public class ActionFilterNFAProvider extends AbstractNFAProvider<ActionFilterState, ActionFilterTransition> {
	public static class ActionFilterState extends AbstractNFAState<ActionFilterState, ActionFilterTransition> {

		public ActionFilterState(AbstractElement element, NFABuilder<ActionFilterState, ActionFilterTransition> builder) {
			super(element, builder);
		}

	}

	public static class ActionFilterTransition extends AbstractNFATransition<ActionFilterState, ActionFilterTransition> {

		public ActionFilterTransition(ActionFilterState source, ActionFilterState target, boolean ruleCall,
				AbstractElement loopCenter) {
			super(source, target, ruleCall, loopCenter);
		}
	}

	public static class ActionFilterNFABuilder extends
			AbstractCachingNFABuilder<ActionFilterState, ActionFilterTransition> {

		@Override
		public ActionFilterState createState(AbstractElement ele) {
			return new ActionFilterState(ele, this);
		}

		@Override
		protected ActionFilterTransition createTransition(ActionFilterState source, ActionFilterState target,
				boolean isRuleCall, AbstractElement loopCenter) {
			return new ActionFilterTransition(source, target, isRuleCall, loopCenter);
		}

		@Override
		public boolean filter(AbstractElement ele) {

			// never filter root elements
			if (!(ele.eContainer() instanceof AbstractElement))
				return false;

			// filter unassigned keywords and token rule calls
			if (!GrammarUtil.isAssigned(ele)) {
				if (ele instanceof Keyword)
					return true;
				if (ele instanceof RuleCall) {
					AbstractRule rule = ((RuleCall) ele).getRule();
					TypeRef ruleType = rule.getType();
					if (!(ruleType == null || ruleType.getClassifier() instanceof EClass))
						return true;
				}
			}

			// filter groups and alternatives, if they contain assigned actions
			if (ele instanceof CompoundElement) {
				TreeIterator<EObject> ti = ele.eAllContents();
				while (ti.hasNext()) {
					EObject obj = ti.next();
					if (obj instanceof Action && ((Action) obj).getFeature() != null)
						return true;
				}
			}

			// don't filter, if there is a child or a sibling that is or contains an assigned action.
			TreeIterator<EObject> ti = ele.eContainer().eAllContents();
			while (ti.hasNext()) {
				EObject obj = ti.next();
				if (obj instanceof Action && ((Action) obj).getFeature() != null)
					return false;
			}
			return true;
		}

		@Override
		public NFADirection getDirection() {
			return NFADirection.BACKWARD;
		}
	}

	@Override
	protected NFABuilder<ActionFilterState, ActionFilterTransition> createBuilder() {
		return new ActionFilterNFABuilder();
	}

}