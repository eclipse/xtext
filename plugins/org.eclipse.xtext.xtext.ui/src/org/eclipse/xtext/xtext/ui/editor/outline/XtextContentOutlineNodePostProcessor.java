/*******************************************************************************
 * Copyright (c) 2009 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import static org.eclipse.xtext.ui.core.DefaultStyledLabelProvider.*;

import java.util.Set;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.DefaultContentOutlineNodePostProcessor;
import org.eclipse.xtext.xtext.UsedRulesFinder;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;

import com.google.common.collect.Sets;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtextContentOutlineNodePostProcessor extends DefaultContentOutlineNodePostProcessor {
	private Set<AbstractRule> calledRules = Sets.newHashSet();
	private SemanticHighlightingConfiguration semanticHighlightingConfiguration = new SemanticHighlightingConfiguration();

	public void postProcessNode(Grammar grammar, ContentOutlineNode contentOutlineNode) {
		calledRules = Sets.newHashSet();
		if (!grammar.getRules().isEmpty()) {
			UsedRulesFinder usedRulesFinder = new UsedRulesFinder(calledRules);
			usedRulesFinder.compute(grammar);
		}

	}

	public void postProcessNode(AbstractRule abstractRule, ContentOutlineNode contentOutlineNode) {
		if (!calledRules.isEmpty() && !calledRules.contains(abstractRule)) {
			contentOutlineNode.setStyler(createXtextStyleAdapterStyler(semanticHighlightingConfiguration.unusedRule()));
		}
	}

}
