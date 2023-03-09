/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarToDot;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider;
import org.eclipse.xtext.parsetree.reconstr.impl.TreeConstState.Status;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TreeConstNFAToDot extends GrammarToDot {

	protected IGrammarNFAProvider<TreeConstState, TreeConstTransition> nfaProvider = new TreeConstructionNFAProvider();

	@Override
	protected Node drawAbstractElementTree(AbstractElement grammarElement, Digraph digraph) {
		Node node = super.drawAbstractElementTree(grammarElement, digraph);
		TreeConstState nfas = nfaProvider.getNFA(grammarElement);

		for (TreeConstTransition outgoing : nfas.getOutgoing())
			digraph.add(drawFollowerEdge(grammarElement, outgoing, false));
		for (TreeConstTransition outgoingAfterReturn : nfas.getOutgoingAfterReturn())
			digraph.add(drawFollowerEdge(grammarElement, outgoingAfterReturn, true));

		if (nfas.getStatusInternal() != Status.ENABLED)
			node.setStyle("dashed");
		if (nfas.isEndState())
			node.put("peripheries", "2");
		setStatusStyle(node, nfas.getStatus());
		node.setLabel(nfas + node.get("label"));
		return node;
	}

	protected Edge drawFollowerEdge(AbstractElement grammarElement, TreeConstTransition transition, boolean isParent) {
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
		setStatusStyle(edge, transition.getStatus());
		return edge;
	}

	protected void setStatusStyle(Props properties, Status status) {
		switch (status) {
			case AMBIGIOUS:
				properties.put("color", "green");
				break;
			case DETOUR_OR_LOOP:
				properties.put("color", "blue");
				break;
			case ORPHAN:
				properties.put("color", "grey");
				break;
			case UNKNOWN:
				properties.put("color", "red");
				break;
			case ENABLED:
				break;
		}
	}

	@Override
	protected Node newNode(EObject semanticObject, String label) {
		TreeConstState nfas = nfaProvider.getNFA((AbstractElement) semanticObject);
		List<String> types = Lists.newArrayList();
		for (TypeRef typeRef : nfas.getTypesToCheck())
			types.add(typeRef == null ? "null" : typeRef.getClassifier().getName());
		if (semanticObject.eContainer() instanceof AbstractRule) {
			AbstractRule rule = (AbstractRule) semanticObject.eContainer();
			String typesAsString = types.isEmpty() ? "" : " [" + Joiner.on(",").join(types) + "]";
			return new Node(semanticObject, rule.getName() + typesAsString + ":\\n" + label, "record");
		} else {
			String typesAsString = types.isEmpty() ? "" : "[" + Joiner.on(",").join(types) + "]\\n";
			return new Node(semanticObject, typesAsString + label);
		}
	}
}
