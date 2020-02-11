/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.util.Collections;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.0
 */
public class KeywordAlternativeConverter extends AbstractValueConverter<String> implements IValueConverter.RuleSpecific {

	private Set<String> keywords;
	private AbstractRule delegateRule;
	@Inject
	private IValueConverterService delegateService;
	private IValueConverter<Object> delegateConverter;

	@Override
	public String toValue(String string, INode node) throws ValueConverterException {
		if (keywords.contains(string))
			return string;
		String result = (String) getDelegateConverter().toValue(string, node);
		return result;
	}

	@Override
	public String toString(String value) throws ValueConverterException {
		if (keywords.contains(value))
			return value;
		String result = getDelegateConverter().toString(value);
		return result;
	}
	
	private IValueConverter<Object> getDelegateConverter() {
		if (delegateConverter != null) {
			return delegateConverter;
		}
		if (delegateService instanceof IValueConverterService.Introspectable) {
			return delegateConverter = ((IValueConverterService.Introspectable) delegateService).getConverter(delegateRule.getName());
		} else {
			final String ruleName = delegateRule.getName();
			return delegateConverter = new IValueConverter<Object>() {

				@Override
				public Object toValue(String string, INode node) throws ValueConverterException {
					return delegateService.toValue(string, ruleName, node);
				}

				@Override
				public String toString(Object value) throws ValueConverterException {
					return delegateService.toString(value, ruleName);
				}
				
			};
		}
	}

	protected String keywordToString(Keyword keyword) {
		return keyword.getValue();
	}
	
	/**
	 * @throws IllegalArgumentException if the rule is not a datatype rule or does not match
	 *   the pattern <pre>RuleName: 'keyword' | 'other';</pre>
	 */
	@Override
	public void setRule(AbstractRule rule) {
		if (!GrammarUtil.isDatatypeRule(rule))
			throw new IllegalArgumentException(rule.getName() + " is not a data type rule");
		if (!(rule.getAlternatives() instanceof Alternatives)) {
			if (rule.getAlternatives() instanceof RuleCall) {
				delegateRule = ((RuleCall) rule.getAlternatives()).getRule();
				keywords = Collections.emptySet();
				return;
			}
			throw mismatchedRuleBody(rule);
		}
		Alternatives alternatives = (Alternatives) rule.getAlternatives();
		ImmutableSet.Builder<String> builder = ImmutableSet.builder();
		for (AbstractElement element : alternatives.getElements()) {
			processElement(element, rule, builder);
		}
		keywords = builder.build();
	}

	/**
	 * @since 2.9
	 */
	protected void processElement(AbstractElement element, AbstractRule rule, ImmutableSet.Builder<String> result) {
		if (element.getCardinality() != null) {
			throw mismatchedRuleBody(rule);
		}
		if (element instanceof Keyword) {
			result.add(keywordToString((Keyword) element));
		} else if (element instanceof Group) {
			Group group = (Group) element;
			if (group.getGuardCondition() != null && group.getElements().size() == 1) {
				for (AbstractElement child : group.getElements()) {
					processElement(child, rule, result);
				}
			} else {
				throw mismatchedRuleBody(rule);
			}
		} else if (element instanceof Alternatives) {
			for (AbstractElement child : ((Alternatives) element).getElements()) {
				processElement(child, rule, result);
			}
		} else if (element instanceof RuleCall) {
			if (delegateRule != null)
				throw mismatchedRuleBody(rule);
			delegateRule = ((RuleCall) element).getRule();
		} else {
			throw mismatchedRuleBody(rule);
		}
	}

	/**
	 * @since 2.9
	 */
	protected IllegalArgumentException mismatchedRuleBody(AbstractRule rule) {
		return new IllegalArgumentException(
				rule.getName() + "'s body does not contain an alternative of keywords and a single rule call");
	} 
	
}
