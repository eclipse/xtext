/*******************************************************************************
 * Copyright (c) 2011, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.collect.Sets;

/**
 * Checks whether a {@link AbstractElement#isPredicated() predicate} uses an 
 * {@link UnorderedGroup unordered group}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PredicateUsesUnorderedGroupInspector extends XtextSwitch<Boolean> implements ValidationMessageAcceptor {
	
	private final ValidationMessageAcceptor validationMessageAcceptor;
	private Set<AbstractRule> validatedRules;
	private final Set<RuleCall> callHierarchy;
	private Grammar inspectedGrammar;
	private final Set<EObject> erroneousElements;
	private Set<AbstractElement> alreadyChecked;
	private Stack<AbstractElement> elementStack;

	public PredicateUsesUnorderedGroupInspector(ValidationMessageAcceptor validationMessageAcceptor) {
		this.validationMessageAcceptor = validationMessageAcceptor;
		this.validatedRules = Sets.newHashSet();
		this.callHierarchy = Sets.newHashSet();
		this.erroneousElements = Sets.newHashSet();
		this.alreadyChecked = Sets.newHashSet();
		this.elementStack = new Stack<AbstractElement>();
	}

	public void inspect(Grammar grammar) {
		this.inspectedGrammar = grammar;
		for(AbstractRule rule: grammar.getRules()) {
			if (!validatedRules.contains(rule)) {
				// different entry points yield different error messages
				Set<AbstractRule> storedRules = validatedRules;
				validatedRules = Sets.newHashSet();
				doSwitch(rule);
				storedRules.addAll(validatedRules);
				validatedRules = storedRules;
			}
		}
	}

	@Override
	public Boolean caseAbstractElement(AbstractElement object) {
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseAssignment(Assignment object) {
		// Do not create duplicate errors
		if (shouldTraverse(object)) {
			pushChecked(object);
			if (object.getTerminal() != null)
				doSwitch(object.getTerminal());
			popChecked(object);
		}
		return Boolean.FALSE;
	}

	protected boolean shouldTraverse(AbstractElement object) {
		return !object.isPredicated() || alreadyChecked.add(object);
	}
	
	private void pushChecked(AbstractElement element) {
		if (element.isPredicated()) {
			elementStack.push(element);
		}
	}
	
	private void popChecked(AbstractElement element) {
		if (element.isPredicated()) {
			elementStack.pop();
		}
	}
	
	@Override
	public Boolean caseCrossReference(CrossReference object) {
		// Do not create duplicate errors
		if (shouldTraverse(object)) {
			pushChecked(object);
			if (object.getTerminal() != null)
				doSwitch(object.getTerminal());
			popChecked(object);
		}
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseCompoundElement(CompoundElement object) {
		// Do not create duplicate errors
		if (shouldTraverse(object)) {
			pushChecked(object);
			for(AbstractElement child: object.getElements())
				doSwitch(child);
			popChecked(object);
		}
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseUnorderedGroup(UnorderedGroup object) {
		if (!elementStack.isEmpty()) {
			createErrorMessages(object);
		}
		return super.caseUnorderedGroup(object);
	}
	
	@Override
	public Boolean caseRuleCall(RuleCall object) {
		if (shouldTraverse(object)) {
			pushChecked(object);
			callHierarchy.add(object);
			if (object.getRule() != null)
				doSwitch(object.getRule());
			callHierarchy.remove(object);
			popChecked(object);
		}
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseParserRule(ParserRule object) {
		if (!validatedRules.add(object))
			return Boolean.FALSE;
		AbstractElement alternatives = object.getAlternatives();
		if (alternatives == null)
			return Boolean.FALSE;
		return doSwitch(alternatives);
	}

	public void createErrorMessages(UnorderedGroup object) {
		acceptError(
				"Cannot use unordered groups in syntactic predicates.", 
				object, 
				null,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
				null);
		for(AbstractElement element: elementStack) {
			acceptError(
					"A predicate may not use an unordered group.", 
					element, 
					XtextPackage.Literals.ABSTRACT_ELEMENT__PREDICATED,
					ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
					null);
		}
		for(RuleCall ruleCall: callHierarchy) {
			if (!ruleCall.isPredicated())
				acceptError(
						"The rule call is part of a call hierarchy that leads to a predicated unordered group.", 
						ruleCall, 
						XtextPackage.Literals.RULE_CALL__RULE,
						ValidationMessageAcceptor.INSIGNIFICANT_INDEX,
						null);
		}
	}

	@Override
	public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		if (erroneousElements.add(object) && EcoreUtil.isAncestor(inspectedGrammar, object))
			validationMessageAcceptor.acceptError(message, object, feature, index, code, issueData);			
	}

	@Override
	public void acceptWarning(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptError(String message, EObject object, int offset, int length, String code, String... issueData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptWarning(String message, EObject object, int offset, int length, String code, String... issueData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptInfo(String message, EObject object, EStructuralFeature feature, int index, String code,
			String... issueData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptInfo(String message, EObject object, int offset, int length, String code, String... issueData) {
		throw new UnsupportedOperationException();
	}

}