/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.util.Collections;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.GrammarUtil;
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

	public String toValue(String string, INode node) throws ValueConverterException {
		if (keywords.contains(string))
			return string;
		String result = (String) delegateService.toValue(string, delegateRule.getName(), node);
		return result;
	}

	public String toString(String value) throws ValueConverterException {
		if (keywords.contains(value))
			return value;
		String result = delegateService.toString(value, delegateRule.getName());
		return result;
	}

	protected String keywordToString(Keyword keyword) {
		return keyword.getValue();
	}

	/**
	 * @throws IllegalArgumentException if the rule is not a datatype rule or does not fulfill
	 *   the pattern <pre>RuleName: 'keyword' | 'other';</pre>
	 */
	public void setRule(AbstractRule rule) {
		if (!GrammarUtil.isDatatypeRule(rule))
			throw new IllegalArgumentException(rule.getName() + " is not a data type rule");
		if (!(rule.getAlternatives() instanceof Alternatives)) {
			if (rule.getAlternatives() instanceof RuleCall) {
				delegateRule = ((RuleCall) rule.getAlternatives()).getRule();
				keywords = Collections.emptySet();
				return;
			}
			throw new IllegalArgumentException(rule.getName() + " is not an alternative and not a rule call");
		}
		Alternatives alternatives = (Alternatives) rule.getAlternatives();
		ImmutableSet.Builder<String> builder = ImmutableSet.builder();
		for(AbstractElement element: alternatives.getElements()) {
			if (element instanceof Keyword) {
				builder.add(keywordToString((Keyword) element));
			} else if (element instanceof RuleCall) {
				if (delegateRule != null)
					throw new IllegalArgumentException(rule.getName() + "'s body does not contain an alternative of keywords and a single rule");
				delegateRule = ((RuleCall) element).getRule();
			} else {
				throw new IllegalArgumentException(rule.getName() + "'s body does not contain an alternative of keywords and a single rule");
			}
		}
		keywords = builder.build();
	} 
	
}
