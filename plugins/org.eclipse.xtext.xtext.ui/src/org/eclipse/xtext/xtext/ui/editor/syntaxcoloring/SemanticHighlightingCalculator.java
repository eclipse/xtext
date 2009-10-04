/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.syntaxcoloring;

import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.xtext.UsedRulesFinder;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SemanticHighlightingCalculator implements ISemanticHighlightingCalculator {

	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		if (resource == null)
			return;
		
		Iterator<EObject> iter = EcoreUtil.getAllContents(resource, true);
		Set<AbstractRule> calledRules = Sets.newHashSet();
		while(iter.hasNext()) {
			EObject current = iter.next();
			if (current instanceof Grammar) {
				Grammar grammar = (Grammar) current;
				if (!grammar.getRules().isEmpty()) {
					UsedRulesFinder usedRulesFinder = new UsedRulesFinder(calledRules);
					usedRulesFinder.compute(grammar);
				}
			} else if (current instanceof AbstractRule) {
				AbstractNode node = getFirstFeatureNode(current, XtextPackage.Literals.ABSTRACT_RULE__NAME.getName());
				highlightNode(node, SemanticHighlightingConfiguration.RULE_DECLARATION_ID, acceptor);
				if (current instanceof ParserRule && GrammarUtil.isDatatypeRule((ParserRule) current)) {
					highlightNode(node, SemanticHighlightingConfiguration.DATA_TYPE_RULE_ID, acceptor);	
				}
				if (!calledRules.isEmpty() && !calledRules.contains(current)) {
					highlightNode(node, SemanticHighlightingConfiguration.NEVER_CALLED_RULE_ID, acceptor);
				}
			} else if (current instanceof TypeRef) {
				AbstractNode node = getFirstFeatureNode(current, null);
				highlightNode(node, SemanticHighlightingConfiguration.TYPE_REFERENCE_ID, acceptor);
			} else if (current instanceof RuleCall) {
				RuleCall call = (RuleCall) current;
				if ((call.getRule() instanceof TerminalRule ||
					call.getRule() instanceof ParserRule && GrammarUtil.isDatatypeRule((ParserRule) call.getRule())) &&
					EcoreUtil2.getContainerOfType(call, Assignment.class) == null) {
					ParserRule container = GrammarUtil.containingParserRule(call);
					if (container != null && !GrammarUtil.isDatatypeRule(container)) {
						AbstractNode node = getFirstFeatureNode(call, null);
						highlightNode(node, SemanticHighlightingConfiguration.UNUSED_VALUE_ID, acceptor);
					}
				}
			}
		}
	}
	
	private void highlightNode(AbstractNode node, String id, IHighlightedPositionAcceptor acceptor) {
		if (node == null)
			return;
		if (node instanceof LeafNode) {
			acceptor.addPosition(node.getOffset(), node.getLength(), id);
		} else {
			for (LeafNode leaf: node.getLeafNodes()) {
				if (!leaf.isHidden()) {
					acceptor.addPosition(leaf.getOffset(), leaf.getLength(), id);
				}
			}
		}
	}

	public AbstractNode getFirstFeatureNode(EObject semantic, String feature) {
		NodeAdapter adapter = NodeUtil.getNodeAdapter(semantic);
		if (adapter != null) {
			CompositeNode node = adapter.getParserNode();
			if (node != null) {
				if (feature == null)
					return node;
				for (AbstractNode child: node.getChildren()) {
					if (child instanceof LeafNode) {
						if (feature.equals(((LeafNode) child).getFeature())) {
							return child;
						}
					}
				}
			}
		}
		return null;
	}

}
