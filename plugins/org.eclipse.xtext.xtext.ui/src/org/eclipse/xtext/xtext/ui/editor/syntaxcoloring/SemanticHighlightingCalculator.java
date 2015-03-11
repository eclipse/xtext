/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.syntaxcoloring;

import static com.google.common.collect.Sets.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultSemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.xtext.UsedRulesFinder;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SemanticHighlightingCalculator extends  DefaultSemanticHighlightingCalculator {

	public static final Set<String> SPECIAL_ATTRIBUTES = newHashSet("name", "importedNamespace", "importURI");
	
	@Override
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		super.doProvideHighlightingFor(resource, acceptor);
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
				INode node = getFirstFeatureNode(current, XtextPackage.Literals.ABSTRACT_RULE__NAME);
				highlightNode(acceptor, node, SemanticHighlightingConfiguration.RULE_DECLARATION_ID);
				if (current instanceof ParserRule && GrammarUtil.isDatatypeRule((ParserRule) current)) {
					highlightNode(acceptor, node, SemanticHighlightingConfiguration.DATA_TYPE_RULE_ID);	
				}
				if (!calledRules.isEmpty() && !calledRules.contains(current)) {
					highlightNode(acceptor, node, SemanticHighlightingConfiguration.NEVER_CALLED_RULE_ID);
				}
			} else if (current instanceof TypeRef) {
				INode node = getFirstFeatureNode(current, null);
				highlightNode(acceptor, node, SemanticHighlightingConfiguration.TYPE_REFERENCE_ID);
			} else if (current instanceof RuleCall) {
				RuleCall call = (RuleCall) current;
				if ((call.getRule() instanceof TerminalRule ||
					call.getRule() instanceof ParserRule && GrammarUtil.isDatatypeRule((ParserRule) call.getRule())) &&
					EcoreUtil2.getContainerOfType(call, Assignment.class) == null) {
					ParserRule container = GrammarUtil.containingParserRule(call);
					if (container != null && !GrammarUtil.isDatatypeRule(container)) {
						INode node = getFirstFeatureNode(call, XtextPackage.Literals.RULE_CALL__RULE);
						highlightNode(acceptor, node, SemanticHighlightingConfiguration.UNUSED_VALUE_ID);
					}
				}
			} else if(current instanceof Assignment) {
				if(SPECIAL_ATTRIBUTES.contains(((Assignment) current).getFeature())) {
					INode featureNode = getFirstFeatureNode(current, XtextPackage.Literals.ASSIGNMENT__FEATURE);
					highlightNode(acceptor, featureNode, SemanticHighlightingConfiguration.SPECIAL_ATTRIBUTE_ID);
				}
			}
		}
	}
	
	public INode getFirstFeatureNode(EObject semantic, EStructuralFeature feature) {
		if (feature == null)
			return NodeModelUtils.findActualNodeFor(semantic);
		List<INode> nodes = NodeModelUtils.findNodesForFeature(semantic, feature);
		if (!nodes.isEmpty())
			return nodes.get(0);
		return null;
	}
}
