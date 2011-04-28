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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.IContextProvider;
import org.eclipse.xtext.serializer.analysis.ActionFilterNFAProvider.ActionFilterState;
import org.eclipse.xtext.serializer.analysis.ActionFilterNFAProvider.ActionFilterTransition;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContextProvider implements IContextProvider {
	@Inject
	protected ActionFilterNFAProvider nfaProvider;

	protected void collectTypesForContext(AbstractElement context, Set<EClass> types, Set<Object> visited) {
		if (!visited.add(context))
			return;
		TreeIterator<EObject> ti = EcoreUtil2.eAll(context);
		while (ti.hasNext()) {
			EObject obj = ti.next();
			if (GrammarUtil.isUnassignedParserRuleCall(obj))
				collectTypesForContext((ParserRule) ((RuleCall) obj).getRule(), types, visited);
			else if (obj instanceof Action)
				types.add((EClass) ((Action) obj).getType().getClassifier());
		}
	}

	protected void collectTypesForContext(ActionFilterState state, Set<EClass> types, boolean allowLocal,
			Set<Object> visited) {
		if (allowLocal) {
			if (state.isEndState())
				types.add((EClass) GrammarUtil.containingRule(state.getGrammarElement()).getType().getClassifier());
			collectTypesForContext(state.getGrammarElement(), types, visited);
			if (GrammarUtil.isAssignedAction(state.getGrammarElement()))
				return;
		}
		if (!visited.add(state))
			return;
		for (ActionFilterTransition t : state.getAllOutgoing())
			if (!t.isRuleCall())
				collectTypesForContext(t.getTarget(), types, true, visited);
	}

	protected void collectTypesForContext(ParserRule context, Set<EClass> types, Set<Object> visited) {
		if (!visited.add(context))
			return;
		if (GrammarUtil.containsAssignedAction(context)) {
			ActionFilterState start = nfaProvider.getNFA(context.getAlternatives());
			collectTypesForContext(start, types, false, visited);
		} else {
			types.add((EClass) context.getType().getClassifier());
			collectTypesForContext(context.getAlternatives(), types, visited);
		}
	}

	protected ActionFilterNFAProvider createNfaProvider() {
		return new ActionFilterNFAProvider();
	}

	public List<EObject> getAllContexts(Grammar grammar) {
		List<EObject> result = Lists.newArrayList();
		for (ParserRule pr : GrammarUtil.allParserRules(grammar))
			if (GrammarUtil.isParserParserRule(pr)) {
				result.add(pr);
				for (Action action : GrammarUtil.containedActions(pr))
					if (GrammarUtil.isAssignedAction(action))
						result.add(action);
			}
		return result;
	}

	public Set<EClass> getTypesForContext(EObject context) {
		Set<EClass> result = Sets.newHashSet();
		if (GrammarUtil.isParserParserRule(context))
			collectTypesForContext((ParserRule) context, result, Sets.newHashSet());
		else if (GrammarUtil.isAssignedAction(context))
			collectTypesForContext((Action) context, result, Sets.newHashSet());
		else
			throw new RuntimeException("This is not a valid context: " + EmfFormatter.objPath(context));
		return result;
	}

}
