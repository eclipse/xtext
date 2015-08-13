/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.analysis.TypeFinderNFAProvider.TypeFinderState;
import org.eclipse.xtext.serializer.analysis.TypeFinderNFAProvider.TypeFinderTransition;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class ContextProvider implements IContextProvider {

	@Inject
	protected TypeFinderNFAProvider nfaProvider2;

	protected void collectTypesForContext(TypeFinderState state, Set<EClass> types, boolean allowLocal,
			boolean hasAssignment, Set<Object> visited) {
		hasAssignment = hasAssignment || state.getGrammarElement() instanceof Assignment || GrammarUtil.isEObjectFragmentRuleCall(state.getGrammarElement());
		if (allowLocal) {
			if (state.getGrammarElement() instanceof Action) {
				types.add((EClass) ((Action) state.getGrammarElement()).getType().getClassifier());
				return;
			}
		}
		if (state.isEndState() && !GrammarUtil.isUnassignedEObjectRuleCall(state.getGrammarElement())) {
			if (hasAssignment) {
				ParserRule rule = (ParserRule) GrammarUtil.containingRule(state.getGrammarElement());
				if (!rule.isFragment()) {
					types.add((EClass) rule.getType().getClassifier());
				}
			} else {
				types.add(null);
			}
		}
		if (!visited.add(state))
			return;
		for (TypeFinderTransition t : state.getAllOutgoing())
			if (!(t.isRuleCall() && state.getGrammarElement() instanceof Assignment))
				collectTypesForContext(t.getTarget(), types, true, hasAssignment, visited);
	}

	@Override
	public List<EObject> getAllContexts(Grammar grammar) {
		List<EObject> result = Lists.newArrayList();
		for (ParserRule pr : GrammarUtil.allParserRules(grammar))
			if (GrammarUtil.isEObjectRule(pr)) {
				result.add(pr);
				for (Action action : GrammarUtil.containedActions(pr))
					if (GrammarUtil.isAssignedAction(action))
						result.add(action);
			}
		return result;
	}

	@Override
	public Set<EClass> getTypesForContext(EObject context) {
		Set<EClass> result = Sets.newHashSet();
		if (context instanceof AbstractElement) {
			AbstractElement ele = (AbstractElement) context;
			collectTypesForContext(nfaProvider2.getNFA(ele), result, false, false, Sets.newHashSet());
		} else if (context instanceof AbstractRule) {
			AbstractElement ele = ((AbstractRule) context).getAlternatives();
			collectTypesForContext(nfaProvider2.getNFA(ele), result, true, false, Sets.newHashSet());
			if (GrammarUtil.isOptionalCardinality(ele))
				result.add(null);
		} else
			throw new RuntimeException("This is not a valid context: " + EmfFormatter.objPath(context));
		return result;
	}

}
