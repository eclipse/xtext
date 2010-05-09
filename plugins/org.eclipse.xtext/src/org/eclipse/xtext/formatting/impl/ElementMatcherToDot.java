/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarToDot;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.formatting.IElementMatcherProvider;
import org.eclipse.xtext.formatting.impl.ElementMatcherProvider.TransitionMatcher;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider;

import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ElementMatcherToDot extends GrammarToDot {

	protected IGrammarNFAProvider<MatcherState, MatcherTransition> nfaProvider = new MatcherNFAProvider();

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
		//		node.setLabel(nfas + node.get("label"));
		return node;
	}

	protected Edge drawFollowerEdge(AbstractElement grammarElement, MatcherTransition transition, boolean isParent) {
		Edge edge = new Edge(grammarElement, transition.getTarget().getGrammarElement());
		if (transition.getPrecedence() > -1)
			edge.setLabel(String.valueOf(transition.getPrecedence()));
		edge.setStyle("dotted");
		if (isParent)
			edge.put("arrowtail", "odot");
		if (transition.isRuleCall())
			edge.put("arrowhead", "onormalonormal");
		else
			edge.put("arrowhead", "onormal");
		return edge;
	}

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected Props drawObject(Object obj) {
		if (obj == null)
			throw new NullPointerException("Obj null");
		if (obj instanceof TransitionMatcher)
			return drawTransitionMatcher((TransitionMatcher<IElementMatcherProvider.IElementPattern>) obj,
					new Digraph());
		throw new RuntimeException("Unknown type: " + obj.getClass().getName());
	}

	protected Edge drawOutgoingToNextRuel(MatcherTransition transition) {
		Edge edge = new Edge(transition.getSource().getGrammarElement(), transition.getTarget().getGrammarElement());
		edge.setStyle("dotted");
		edge.put("color", "red");
		edge.put("arrowhead", "onormal");
		return edge;
	}

	protected Props drawTransitionMatcher(TransitionMatcher<IElementMatcherProvider.IElementPattern> matcher,
			Digraph graph) {
		Set<AbstractRule> seenRules = Sets.newHashSet();
		for (AbstractElement e : matcher.getSeenTokens())
			seenRules.add(GrammarUtil.containingRule(e));
		for (AbstractRule r : seenRules)
			drawRule(r, graph);
		return graph;
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
