/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
public class NonRecursiveKeywordAlternativeConverter extends AbstractValueConverter<String> implements IValueConverter.RuleSpecific {

	private Set<String> keywords;
	
	private AbstractRule terminalRule;
	
	@Inject
	private IValueConverterService delegateService;

	private AbstractRule rule;

	public String toValue(String string, INode node) throws ValueConverterException {
		if (keywords.contains(string))
			return string;
		String result = (String) delegateService.toValue(string, terminalRule.getName(), node);
		return result;
	}

	public String toString(String value) throws ValueConverterException {
		if (keywords.contains(value))
			return value;
		String result = delegateService.toString(value, terminalRule.getName());
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
		this.rule = rule;
		ImmutableSet.Builder<String> builder = ImmutableSet.builder();
		handleRule(rule, builder);
		keywords = builder.build();
		if(terminalRule == null)
			throw new IllegalArgumentException("Could not find terminal rule in call graph of " + rule.getName());
	}

	protected void handleRule(AbstractRule rule, ImmutableSet.Builder<String> builder) {
		if(rule instanceof TerminalRule) {
			if(terminalRule != null) 
				throw new IllegalArgumentException("Terminal rule is already set in " + this.rule.getName());
			terminalRule = rule;
			return;			
		}
		if (!GrammarUtil.isDatatypeRule(rule))
			throw new IllegalArgumentException(rule.getName() + " is not a data type rule");
		if (!(rule.getAlternatives() instanceof Alternatives)) {
			if (rule.getAlternatives() instanceof RuleCall) {
				handleRule(((RuleCall) rule.getAlternatives()).getRule(), builder);
			}
			throw new IllegalArgumentException(rule.getName() + " is not an alternative and not a rule call");
		}
		Alternatives alternatives = (Alternatives) rule.getAlternatives();
		for(AbstractElement element: alternatives.getElements()) {
			if (element instanceof Keyword) {
				builder.add(keywordToString((Keyword) element));
			} else if (element instanceof RuleCall) {
				AbstractRule calledRule = ((RuleCall) element).getRule();
				handleRule(calledRule, builder);
			} else {
				throw new IllegalArgumentException(rule.getName() + "'s body does not contain an alternative of keywords and a single rule");
			}
		}
	} 
	
}
