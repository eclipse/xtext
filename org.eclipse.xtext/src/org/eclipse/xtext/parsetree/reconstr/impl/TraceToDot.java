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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.impl.AbstractParseTreeConstructor.AbstractToken;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TraceToDot extends TreeConstNFAToDot {

	@Override
	protected Props drawObject(Object obj) {
		if (obj instanceof TreeConstructionReportImpl)
			return drawPTC((TreeConstructionReportImpl) obj);
		return super.drawObject(obj);
	}

	protected Digraph drawPTC(TreeConstructionReportImpl report) {
		Digraph digraph = new Digraph();
		Set<AbstractToken> drawnTokens = new HashSet<AbstractToken>();
		Set<ParserRule> drawnRules = new HashSet<ParserRule>();
		List<AbstractToken> traces = new ArrayList<AbstractToken>();
		traces.add(report.getSuccess());
		traces.addAll(report.getDeadends());
		boolean solid = true;
		for (AbstractToken token : traces) {
			while (token != null && !drawnTokens.contains(token)) {
				// String ser = ((AbstractToken) t).serialize().replaceAll(
				// "\\\\", "\\\\");
				String tokenDescription = token.getClass().getSimpleName() + "\\n"
						+ token.getEObjectConsumer() + "\\n'" /* + ser */+ "'";
				digraph.add(new Node(token, tokenDescription));
				if (token.getGrammarElement() != null) {
					ParserRule parserRule = GrammarUtil.containingParserRule(token
							.getGrammarElement());
					if (parserRule != null && !drawnRules.contains(parserRule)) {
						drawnRules.add(parserRule);
						drawRule(parserRule, digraph);
					}
				}
				if (token.getNext() != null) {
					Edge edge = new Edge(token.getNext(), token);
					edge.setLabel(String.valueOf((token).getTransitionIndex()));
					if (!solid)
						edge.setStyle("dashed");
					digraph.add(edge);
				}
				drawnTokens.add(token);
				token = token.getNext();
			}
			solid = false;
		}
		return digraph;
	}
}
