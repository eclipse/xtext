/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarToDot;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting.IElementMatcherProvider;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IElementPattern;
import org.eclipse.xtext.formatting.impl.ElementMatcherProvider.TransitionMatcher;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ElementMatcherToDot extends GrammarToDot {

	protected IGrammarNFAProvider<MatcherState, MatcherTransition> nfaProvider;

	@Override
	protected Node drawAbstractElementTree(AbstractElement grammarElement, Digraph digraph) {
		Node node = super.drawAbstractElementTree(grammarElement, digraph);
		MatcherState nfas = nfaProvider.getNFA(grammarElement);

		for (MatcherTransition outgoing : nfas.getOutgoing())
			digraph.add(drawFollowerEdge(grammarElement, outgoing, false));
		for (MatcherTransition outgoingAfterReturn : nfas.getOutgoingAfterReturn())
			digraph.add(drawFollowerEdge(grammarElement, outgoingAfterReturn, true));
		//		for (MatcherTransition outgoingToNextRule : nfas.getOutgoingToNextRule())
		//			digraph.add(drawOutgoingToNextRuel(outgoingToNextRule));

		if (nfas.isEndState())
			node.put("peripheries", "2");

		if (!nfas.hasTransitions())
			node.setStyle("dotted");
		return node;
	}

	protected String toStr(Iterable<IElementPattern> list) {
		String s1 = Joiner.on(", ").join(list);
		String s2 = s1.replaceAll("\\\\n|\\n", "\\\\\\\\n");
		return s2;
	}

	protected Edge drawFollowerEdge(AbstractElement grammarElement, MatcherTransition transition, boolean isParent) {
		Edge edge = new Edge(grammarElement, transition.getTarget().getGrammarElement());
		//		if (transition.getPrecedence() > -1)
		//			edge.setLabel(String.valueOf(transition.getPrecedence()));
		List<String> label = Lists.newArrayList();
		if (!transition.getCommonPatterns().isEmpty())
			label.add("{" + toStr(transition.getCommonPatterns()) + "}");
		//		for (Map.Entry<AbstractRule, Set<IElementPattern>> e : transition.getExitPatterns().entrySet())
		//			label.add(e.getKey().getName() + ":{" + Joiner.on(", ").join(e.getValue()).replace("\\n", "\\\\n") + "}");
		for (Map.Entry<MatcherState, Set<IElementPattern>> e : transition.getGuardPatterns().entrySet())
			label.add(GrammarUtil.containingRule(e.getKey().getGrammarElement()).getName() + "-" + e.getKey() + ":{"
					+ toStr(e.getValue()) + "}");
		if (label.size() > 0)
			edge.setLabel(Joiner.on("\\n").join(label));
		if (isParent)
			edge.put("arrowtail", "odot");
		if (transition.isRuleCall())
			edge.put("arrowhead", "onormalonormal");
		else
			edge.put("arrowhead", "onormal");
		return edge;
	}

	@Override
	protected Props drawGrammarContainementEdge(AbstractElement container, AbstractElement child) {
		Edge edge = new Edge(container, child);
		edge.setStyle("dotted");
		//		edge.put("color", "darkgray");
		return edge;
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	protected Props drawObject(Object obj) {
		if (obj == null)
			throw new NullPointerException("Obj null");
		if (obj instanceof TransitionMatcher) {
			TransitionMatcher<IElementMatcherProvider.IElementPattern> m = (TransitionMatcher<IElementMatcherProvider.IElementPattern>) obj;
			nfaProvider = m.nfaProvider;
			return super.drawObject(m.getGrammar().getGrammar());
		}
		return super.drawObject(obj);
	}

	@Override
	protected Node newNode(EObject semanticObject, String label) {
		if (semanticObject.eContainer() instanceof AbstractRule) {
			AbstractRule rule = (AbstractRule) semanticObject.eContainer();
			return new Node(semanticObject, rule.getName() + ":\\n" + label, "record");
		} else {
			return new Node(semanticObject, label);
		}
	}
}
