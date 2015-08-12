/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import static com.google.common.collect.Lists.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DocumentRootNode;
import org.eclipse.xtext.ui.editor.outline.impl.ModeAwareOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineMode;
import org.eclipse.xtext.ui.label.StylerFactory;
import org.eclipse.xtext.xtext.UsedRulesFinder;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtextOutlineTreeProvider extends ModeAwareOutlineTreeProvider {

	private static final String ALIAS_TYPE_SEPARATOR = "::";

	public static final String NAME_TYPE_SEPARATOR = " - ";

	private static final OutlineMode SHOW_INHERITED_MODE = new OutlineMode("show", "Show inherited rules");
	private static final OutlineMode HIDE_INHERITED_MODE = new OutlineMode("hide", "Hide inherited rules");
	private static final List<OutlineMode> MODES = newArrayList(HIDE_INHERITED_MODE, SHOW_INHERITED_MODE);
	
	@Override
	public List<OutlineMode> getOutlineModes() {
		return MODES;
	}
	
	@Inject
	private SemanticHighlightingConfiguration semanticHighlightingConfiguration;

	@Inject
	private StylerFactory stylerFactory;
	
	private Set<AbstractRule> calledRules = Sets.newHashSet();
	
	protected Object _text(AbstractRule rule) {
		StyledString ruleText = null;
		if (!calledRules.isEmpty() && !calledRules.contains(rule))
			ruleText = new StyledString(safeName(rule.getName()),
					stylerFactory.createXtextStyleAdapterStyler(semanticHighlightingConfiguration.unusedRule()));
		else if (GrammarUtil.isDatatypeRule(rule))
			ruleText = new StyledString(safeName(rule.getName()),
					stylerFactory.createXtextStyleAdapterStyler(semanticHighlightingConfiguration.dataTypeRule()));
		else
			ruleText = new StyledString(safeName(rule.getName()));
		return ruleText;
	}

	protected StyledString getReturnTypeText(AbstractRule rule) {
		StringBuilder typeName = new StringBuilder(NAME_TYPE_SEPARATOR);
		if (rule.getType() != null && rule.getType().getClassifier() != null && rule.getType().getMetamodel() != null) {
			String alias = rule.getType().getMetamodel().getAlias();
			if (alias != null) {
				typeName.append(alias);
				typeName.append(ALIAS_TYPE_SEPARATOR);
			}
			typeName.append(safeName(rule.getType().getClassifier().getName()));
		} else {
			typeName.append(safeName(rule.getName()));
		}
		StyledString styledType = new StyledString(typeName.toString(),
				stylerFactory.createXtextStyleAdapterStyler(semanticHighlightingConfiguration.typeReference()));
		return styledType;
	}

	protected void _createNode(DocumentRootNode parentNode, Grammar grammar) {
		// Hack: we use this hook to calculate unused rule
		calledRules = Sets.newHashSet();
		if (!grammar.getRules().isEmpty()) {
			UsedRulesFinder usedRulesFinder = new UsedRulesFinder(calledRules);
			usedRulesFinder.compute(grammar);
		}
		super._createNode(parentNode, grammar);
	}

	protected void _createNode(IOutlineNode parentNode, AbstractRule rule) {
		createRuleNode(parentNode, rule, false, true);
	}

	protected void createRuleNode(IOutlineNode parentNode, AbstractRule rule, boolean isShowGrammar, boolean isLocalRule) {
		StyledString text = (StyledString) textDispatcher.invoke(rule);
		if (isShowGrammar) {
			EObject grammar = rule.eContainer();
			if (grammar instanceof Grammar)
				text.append(new StyledString(" (" + ((Grammar) grammar).getName() + ")", StyledString.COUNTER_STYLER));
		}
		Image image = imageDispatcher.invoke(rule);
		RuleNode ruleNode = new RuleNode(rule, parentNode, image, text, isLeafDispatcher.invoke(rule));
		if (isLocalRule) {
			ICompositeNode parserNode = NodeModelUtils.getNode(rule);
			if (parserNode != null)
				ruleNode.setTextRegion(parserNode.getTextRegion());
			ruleNode.setShortTextRegion(locationInFileProvider.getSignificantTextRegion(rule));
			ruleNode.setFullText(new StyledString().append(text).append(getReturnTypeText(rule)));
		}
	}

	protected void _createChildren(IOutlineNode parentNode, Grammar grammar) {
		for (AbstractMetamodelDeclaration metamodelDeclaration : grammar.getMetamodelDeclarations()) {
			createNode(parentNode, metamodelDeclaration);
		}
		for (AbstractRule rule : grammar.getRules()) {
			createNode(parentNode, rule);
		}
		if (getCurrentMode() == SHOW_INHERITED_MODE) {
			List<Grammar> usedGrammars = GrammarUtil.allUsedGrammars(grammar);
			for(Grammar usedGrammar: usedGrammars) {
				for (AbstractRule rule : usedGrammar.getRules()) {
					createRuleNode(parentNode, rule, true, false);
				}
			}
		}
	}
	
	protected boolean _isLeaf(AbstractRule rule) {
		return true;
	}

	protected String safeName(String s) {
		return (s == null) ? "<unnamed>" : s; 
	}
}
