/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import java.util.Set;

import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.AbstractMetamodelDeclaration;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ui.editor.outline.IOutlineNode;
import org.eclipse.xtext.ui.editor.outline.impl.DefaultOutlineTreeProvider;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.label.StylerFactory;
import org.eclipse.xtext.xtext.UsedRulesFinder;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author koehnlein - Initial contribution and API
 */
public class XtextOutlineTreeProvider extends DefaultOutlineTreeProvider {

	private static final String ALIAS_TYPE_SEPARATOR = "::";

	public static final String NAME_TYPE_SEPARATOR = " - ";

	@Inject
	private SemanticHighlightingConfiguration semanticHighlightingConfiguration;

	@Inject
	private StylerFactory stylerFactory;

	@Inject
	private IPreferenceStoreAccess preferenceStoreAccess;

	private Set<AbstractRule> calledRules = Sets.newHashSet();

	protected Object text(AbstractRule rule) {
		StyledString ruleText = null;
		if (!calledRules.isEmpty() && !calledRules.contains(rule))
			ruleText = new StyledString(rule.getName(),
					stylerFactory.createXtextStyleAdapterStyler(semanticHighlightingConfiguration.unusedRule()));
		else if (GrammarUtil.isDatatypeRule(rule))
			ruleText = new StyledString(rule.getName(),
					stylerFactory.createXtextStyleAdapterStyler(semanticHighlightingConfiguration.dataTypeRule()));
		else
			ruleText = new StyledString(rule.getName());
		if (isShowReturnTypes()) {
			StringBuilder typeName = new StringBuilder(NAME_TYPE_SEPARATOR);
			if (rule.getType() != null) {
				String alias = rule.getType().getMetamodel().getAlias();
				if (alias != null) {
					typeName.append(alias);
					typeName.append(ALIAS_TYPE_SEPARATOR);
				}
				typeName.append(rule.getType().getClassifier().getName());
			} else {
				typeName.append(rule.getName());
			}
			StyledString styledType = new StyledString(typeName.toString(),
					stylerFactory.createXtextStyleAdapterStyler(semanticHighlightingConfiguration.typeReference()));
			return ruleText.append(styledType);
		} else
			return ruleText;
	}

	protected boolean isShowReturnTypes() {
		return preferenceStoreAccess.getPreferenceStore().getBoolean(FilterReturnTypesAction.PREFERENCE_KEY);
	}

	protected void doCreateNode(IOutlineNode parentNode, Grammar grammar) {
		// Hack: we use this hook to calculate unused rule
		calledRules = Sets.newHashSet();
		if (!grammar.getRules().isEmpty()) {
			UsedRulesFinder usedRulesFinder = new UsedRulesFinder(calledRules);
			usedRulesFinder.compute(grammar);
		}
		super.doCreateNode(parentNode, grammar);
	}

	protected void doCreateChildren(IOutlineNode parentNode, Grammar grammar) {
		for (AbstractMetamodelDeclaration metamodelDeclaration : grammar.getMetamodelDeclarations()) {
			createNode(parentNode, metamodelDeclaration);
		}
		for (AbstractRule rule : grammar.getRules()) {
			createNode(parentNode, rule);
		}
	}
	
	protected boolean isLeaf(AbstractRule rule) {
		return true;
	}

}
