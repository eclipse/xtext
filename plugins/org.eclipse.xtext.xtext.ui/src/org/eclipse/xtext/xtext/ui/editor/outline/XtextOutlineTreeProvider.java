/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.ui.label.StylerFactory;
import org.eclipse.xtext.xtext.UsedRulesFinder;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XtextOutlineTreeProvider extends DefaultOutlineTreeProvider {
	@Inject
	private SemanticHighlightingConfiguration semanticHighlightingConfiguration;
	private Set<AbstractRule> calledRules = Sets.newHashSet();

	@Inject
	private StylerFactory stylerFactory;

	protected IOutlineNode createNode(IOutlineNode parentNode, AbstractRule rule) {
		EObjectNode eObjectNode = (EObjectNode) super.createNode(parentNode, rule);
		if (!calledRules.isEmpty() && !calledRules.contains(rule)) {
			Object text = eObjectNode.getText();
			Styler styler = stylerFactory.createXtextStyleAdapterStyler(semanticHighlightingConfiguration.unusedRule());
			if(text instanceof StyledString) { 
				((StyledString) text).setStyle(0, ((StyledString) text).length(), styler);
			} else {
				eObjectNode.setText(new StyledString(text.toString(), styler));
			}
		}
		return eObjectNode;
	}

	
	protected IOutlineNode createNode(IOutlineNode parentNode, Grammar grammar) {
		calledRules = Sets.newHashSet();
		if (!grammar.getRules().isEmpty()) {
			UsedRulesFinder usedRulesFinder = new UsedRulesFinder(calledRules);
			usedRulesFinder.compute(grammar);
		}
		return super.createNode(parentNode, grammar);
	}

	@Override
	protected List<IOutlineNode> createChildren(EObjectNode parentNode, Resource resource) {
		EObject eObject = resource.getEObject(parentNode.getEObjectURI().fragment());
		if (eObject instanceof Grammar) {
			Grammar grammar = (Grammar) eObject;
			for(AbstractMetamodelDeclaration metamodelDeclaration: grammar.getMetamodelDeclarations()) {
				createNode(parentNode, metamodelDeclaration);
			}
			for(AbstractRule rule: grammar.getRules()) {
				createNode(parentNode, rule);
			}
			return parentNode.getChildren();
		}
		return Collections.emptyList();
	}
}
