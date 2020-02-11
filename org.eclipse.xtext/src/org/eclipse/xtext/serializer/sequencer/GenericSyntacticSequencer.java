/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GenericSyntacticSequencer extends AbstractSyntacticSequencer {

	@Override
	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		if (node != null)
			return node.getText().trim();
		AbstractRule rule = ruleCall.getRule();
		if (GrammarUtil.isDatatypeRule(rule)) {
			if (rule.getAlternatives() instanceof Keyword)
				return ((Keyword) rule.getAlternatives()).getValue();
			if (rule.getAlternatives() instanceof Alternatives)
				for (AbstractElement ele : ((Alternatives) rule.getAlternatives()).getElements())
					if (ele instanceof Keyword)
						return ((Keyword) ele).getValue();
		}
		return "";
	}

	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (!transition.hasEmitters())
			return;
		if (transition.isSyntacticallyAmbiguous())
			acceptNodes(transition, fromNode, toNode);
	}

}
