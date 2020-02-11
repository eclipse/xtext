/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarToDot;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NFAToDot extends GrammarToDot {

	protected IGrammarNFAProvider<DefaultNFAState, DefaultNFATransition> nfaProvider = new DefaultForwardNFAProvider();

	@Override
	protected Node drawAbstractElementTree(AbstractElement ele, Digraph d) {
		Node n = super.drawAbstractElementTree(ele, d);
		DefaultNFAState nfas = nfaProvider.getNFA(ele);

		for (DefaultNFATransition t : nfas.getOutgoing())
			d.add(drawFollowerEdge(ele, t, false));
		for (DefaultNFATransition t : nfas.getOutgoingAfterReturn())
			d.add(drawFollowerEdge(ele, t, true));

		if (nfas.getOutgoing().size() == 0
				&& nfas.getOutgoingAfterReturn().size() == 0 && !nfas.isEndState())
			n.setStyle("dotted");
		if (nfas.isEndState())
			n.put("peripheries", "2");
		return n;
	}

	protected Edge drawFollowerEdge(AbstractElement ele,
			DefaultNFATransition t, boolean isParent) {
		Edge e = new Edge(ele, t.getTarget().getGrammarElement());
		e.setLabel(String.valueOf(t.getPrecedence()));
		e.setStyle("dotted");
		if (isParent)
			e.put("arrowtail", "odot");
		if (t.isRuleCall())
			e.put("arrowhead", "onormalonormal");
		else
			e.put("arrowhead", "onormal");
		return e;
	}
}
