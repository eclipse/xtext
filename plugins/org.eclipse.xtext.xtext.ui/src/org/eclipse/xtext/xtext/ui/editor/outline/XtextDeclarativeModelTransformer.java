/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.editor.outline;

import static org.eclipse.xtext.ui.core.DefaultLabelProvider.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.transformer.AbstractDeclarativeSemanticModelTransformer;
import org.eclipse.xtext.xtext.UsedRulesFinder;
import org.eclipse.xtext.xtext.ui.editor.syntaxcoloring.SemanticHighlightingConfiguration;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Peter Friese - Initial contribution and API
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @author Michael Clay
 */
public class XtextDeclarativeModelTransformer extends AbstractDeclarativeSemanticModelTransformer {
	@Inject
	private SemanticHighlightingConfiguration semanticHighlightingConfiguration;
	private Set<AbstractRule> calledRules = Sets.newHashSet();

	public ContentOutlineNode createNode(AbstractRule abstractRule, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode contentOutlineNode = super.createNode(abstractRule, outlineParentNode);
		if (!calledRules.isEmpty() && !calledRules.contains(abstractRule)) {
			contentOutlineNode.setStyler(createXtextStyleAdapterStyler(semanticHighlightingConfiguration.unusedRule()));
		}
		return contentOutlineNode;
	}

	public boolean consumeNode(Grammar grammar) {
		calledRules = Sets.newHashSet();
		if (!grammar.getRules().isEmpty()) {
			UsedRulesFinder usedRulesFinder = new UsedRulesFinder(calledRules);
			usedRulesFinder.compute(grammar);
		}
		return true;
	}

	public boolean consumeNode(RuleCall object) {
		return false;
	}

	public boolean consumeNode(Group object) {
		return false;
	}

	public boolean consumeNode(TypeRef object) {
		return false;
	}

	public List<EObject> getChildren(Assignment object) {
		if (object.getTerminal() instanceof Alternatives || object.getTerminal() instanceof CrossReference) {
			return getChildren(object.getTerminal());
		}
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(CrossReference object) {
		if (object.getTerminal() instanceof Alternatives) {
			return getChildren(object.getTerminal());
		}
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(EnumRule object) {
		if (object.getAlternatives() instanceof Alternatives) {
			return getChildren(object.getAlternatives());
		}
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(CharacterRange object) {
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(EnumLiteralDeclaration object) {
		return NO_CHILDREN;
	}

	public List<EObject> getChildren(RuleCall object) {
		return NO_CHILDREN;
	}

}
