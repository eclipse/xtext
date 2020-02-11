/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @since 2.9
 */
public class CallHierarchyHelper extends XtextSwitch<Boolean> {
	private final EObject nextGrammarElement;
	private Set<AbstractRule> visiting = new HashSet<AbstractRule>();
	private Map<AbstractRule, Boolean> visited = Maps.newHashMapWithExpectedSize(4);
	private EObject grammarElement;
	private EObject queuedGrammarElement;
	private Boolean result = Boolean.FALSE;
	private String expectedText;

	public CallHierarchyHelper(EObject nextGrammarElement, String previousText, EObject previousGrammarElement) {
		this.nextGrammarElement = nextGrammarElement;
		this.expectedText = previousText;
		grammarElement = previousGrammarElement;
		queuedGrammarElement = nextGrammarElement;
	}

	@Override
	public Boolean caseAbstractRule(AbstractRule object) {
		if (!checkFurther(object))
			return result;
		if (!visiting.add(object))
			return Boolean.FALSE;
		if (visited.containsKey(object)) {
			visiting.remove(object);
			return visited.get(object);
		}
		EObject wasGrammarElement = grammarElement;
		Boolean result = doSwitch(object.getAlternatives());
		visiting.remove(object);
		if (isExpectedGrammarElement(wasGrammarElement)) // we store the result per grammarElement for performance reasons
			visited.put(object, result);
		return result;
	}

	private boolean checkFurther(EObject object) {
		if (isExpectedGrammarElement(object)) {
			if (queuedGrammarElement != null) {
				grammarElement = queuedGrammarElement;
				queuedGrammarElement = null;
				expectedText = null;
				visited.clear();
				visiting.clear();
				return true;
			}
			result = Boolean.TRUE;
			return false;
		}
		return true;
	}

	protected boolean isExpectedGrammarElement(EObject object) {
		if (object == grammarElement)
			return true;
		if (grammarElement == null && expectedText != null) {
			if (object instanceof Keyword) {
				if (expectedText.equals(((Keyword) object).getValue()))
					return true;
			}
		}
		return false;
	}

	@Override
	public Boolean caseTerminalRule(TerminalRule object) {
		checkFurther(object);
		return result;
	}

	@Override
	public Boolean caseGroup(Group object) {
		if (!checkFurther(object))
			return result;
		for (AbstractElement token : object.getElements())
			if (doSwitch(token))
				return true;
		if (GrammarUtil.isMultipleCardinality(object)) {
			if (!checkFurther(object))
				return result;
			for (AbstractElement token : object.getElements())
				if (doSwitch(token))
					return true;
		}
		return false;
	}

	@Override
	public Boolean caseUnorderedGroup(UnorderedGroup object) {
		if (!checkFurther(object))
			return result;
		// elements may occur in any order - treat them as looped alternatives
		if (caseAlternatives(object.getElements()))
			return true;
		if (!checkFurther(object))
			return result;
		return caseAlternatives(object.getElements());
	}

	@Override
	public Boolean caseAlternatives(Alternatives object) {
		if (!checkFurther(object))
			return result;
		if (caseAlternatives(object.getElements()))
			return true;
		if (GrammarUtil.isMultipleCardinality(object)) {
			if (!checkFurther(object))
				return result;
			return caseAlternatives(object.getElements());
		}
		return Boolean.FALSE;
	}

	public Boolean caseAlternatives(List<AbstractElement> elements) {
		EObject wasGrammarElement = this.grammarElement;
		Set<AbstractRule> visiting = Sets.newHashSet(this.visiting);
		boolean foundSomething = false;
		for (AbstractElement group : elements) {
			this.grammarElement = wasGrammarElement;
			this.visiting = Sets.newHashSet(visiting);
			if (doSwitch(group))
				return true;
			if (wasGrammarElement != this.grammarElement) {
				foundSomething = true;
			}
		}
		if (foundSomething) {
			this.grammarElement = nextGrammarElement;
			this.visiting.clear();
			this.visited.clear();
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseAbstractElement(AbstractElement object) {
		if (!checkFurther(object))
			return result;
		if (GrammarUtil.isMultipleCardinality(object)) {
			if (!checkFurther(object))
				return result;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseAssignment(Assignment object) {
		if (!checkFurther(object))
			return result;
		if (doSwitch(object.getTerminal()))
			return true;
		if (GrammarUtil.isMultipleCardinality(object)) {
			if (!checkFurther(object))
				return result;
			if (doSwitch(object.getTerminal()))
				return true;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseCrossReference(CrossReference object) {
		if (!checkFurther(object))
			return result;
		if (doSwitch(object.getTerminal()))
			return true;
		if (GrammarUtil.isMultipleCardinality(object)) {
			if (!checkFurther(object))
				return result;
			if (doSwitch(object.getTerminal()))
				return true;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseRuleCall(RuleCall object) {
		if (!checkFurther(object))
			return result;
		if (doSwitch(object.getRule()))
			return true;
		if (GrammarUtil.isMultipleCardinality(object)) {
			if (!checkFurther(object))
				return result;
			if (doSwitch(object.getRule()))
				return true;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseEnumLiteralDeclaration(EnumLiteralDeclaration object) {
		if (!checkFurther(object))
			return result;
		Boolean result = doSwitch(object.getLiteral());
		return result;
	}
}