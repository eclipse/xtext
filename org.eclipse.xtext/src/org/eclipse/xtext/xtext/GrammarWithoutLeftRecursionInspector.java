/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class GrammarWithoutLeftRecursionInspector extends XtextSwitch<Boolean> implements ValidationMessageAcceptor {
	
	private final ValidationMessageAcceptor validationMessageAcceptor;
	private final Set<AbstractRule> validatedRules;
	private final Set<AbstractRule> usedRules;
	private final List<RuleCall> callStack;
	private final Set<AbstractRule> ruleStack;
	private Grammar inspectedGrammar;
	private final Set<EObject> erroneousElements;

	public GrammarWithoutLeftRecursionInspector(ValidationMessageAcceptor validationMessageAcceptor) {
		this.validationMessageAcceptor = validationMessageAcceptor;
		this.validatedRules = Sets.newHashSet();
		this.callStack = Lists.newArrayList();
		this.ruleStack = Sets.newHashSet();
		this.usedRules = Sets.newHashSet();
		this.erroneousElements = Sets.newHashSet();
	}

	public void inspect(Grammar grammar) {
		doSwitch(grammar);
	}

	@Override
	public Boolean caseGrammar(Grammar grammar) {
		UsedRulesFinder usedRulesFinder = new UsedRulesFinder(usedRules);
		usedRulesFinder.compute(grammar);
		this.inspectedGrammar = grammar;
		for(AbstractRule rule: grammar.getRules()) {
			if (!validatedRules.contains(rule) && usedRules.contains(rule)) {
				doSwitch(rule);
			}
		}
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseAbstractRule(AbstractRule object) {
		if (!validatedRules.add(object))
			return Boolean.FALSE;
		ruleStack.add(object);
		Boolean result = object.getAlternatives() == null ? Boolean.FALSE : doSwitch(object.getAlternatives());
		ruleStack.remove(object);
		return result;
	}
	
	@Override
	public Boolean caseEnumLiteralDeclaration(EnumLiteralDeclaration object) {
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseRuleCall(RuleCall object) {
		if (object.getRule() == null)
			return Boolean.FALSE;
		if (ruleStack.contains(object.getRule())) {
			createErrorMessages(object);
			return GrammarUtil.isOptionalCardinality(object);
		}
		callStack.add(object);
		Boolean result = doSwitch(object.getRule());
		callStack.remove(callStack.size() - 1);
		if (!result.booleanValue())
			return GrammarUtil.isOptionalCardinality(object);
		return result;
	}
	
	@Override
	public Boolean caseAbstractElement(AbstractElement object) {
		return GrammarUtil.isOptionalCardinality(object);
	}
	
	@Override
	public Boolean caseAction(Action object) {
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseGroup(Group object) {
		for(AbstractElement element: object.getElements()) {
			if (!doSwitch(element)) {
				return GrammarUtil.isOptionalCardinality(object);
			}
		}
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseAlternatives(Alternatives object) {
		Boolean result = Boolean.FALSE;
		for(AbstractElement element: object.getElements()) {
			if (doSwitch(element))
				result = Boolean.TRUE;
		}
		return result || GrammarUtil.isOptionalCardinality(object);
	}
	
	@Override
	public Boolean caseUnorderedGroup(UnorderedGroup object) {
		Boolean result = Boolean.TRUE;
		for(AbstractElement element: object.getElements()) {
			if (!doSwitch(element))
				result = Boolean.FALSE;
		}
		return result || GrammarUtil.isOptionalCardinality(object);
	}
	
	@Override
	public Boolean caseAssignment(Assignment object) {
		Boolean result = doSwitch(object.getTerminal());
		return result || GrammarUtil.isOptionalCardinality(object);
	}
	
	@Override
	public Boolean caseCrossReference(CrossReference object) {
		Boolean result = doSwitch(object.getTerminal());
		return result || GrammarUtil.isOptionalCardinality(object);
	}

	public void createErrorMessages(RuleCall object) {
		acceptError(
				"The rule '" + object.getRule().getName() + "' is left recursive.", 
				object.getRule(), 
				XtextPackage.Literals.ABSTRACT_RULE__NAME, 
				null);
		acceptError(
				"This rule call is part of a left recursive call graph.", 
				object, 
				XtextPackage.Literals.RULE_CALL__RULE, 
				null);
		for(int i = callStack.size() - 1; i >= 0; i--) {
			RuleCall call = callStack.get(i);
			if (call.getRule() == object.getRule()) {
				return;
			}
			acceptError(
					"This rule call is part of a left recursive call graph.", 
					call, 
					XtextPackage.Literals.RULE_CALL__RULE, 
					null);
		}
	}

	public void acceptError(String message, EObject object, EStructuralFeature feature, String code, String... issueData) {
		if (erroneousElements.add(object) && EcoreUtil.isAncestor(inspectedGrammar, object))
			validationMessageAcceptor.acceptError(message, object, feature, ValidationMessageAcceptor.INSIGNIFICANT_INDEX, code, issueData);			
	}

	public void acceptWarning(String message, EObject object, EStructuralFeature feature, String code, String... issueData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code,
			String... issueData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptError(String message, EObject object, int offset, int length, String code, String... issueData) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void acceptWarning(String message, EObject object, EStructuralFeature feature, int index, String code,
			String... issueData) {
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