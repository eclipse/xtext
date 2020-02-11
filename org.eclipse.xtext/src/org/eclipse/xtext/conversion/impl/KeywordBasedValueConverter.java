/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.nodemodel.INode;

import com.google.common.collect.ImmutableSet;

/**
 * <p>This {@link IValueConverter} ensures that the given string value fulfills a 
 * data type rule that consists only of an alternative of keywords.</p>
 * <p>It converts the value to a string. The implementation supports the following patterns:
 * <pre>
 * RuleName: 'keyword';
 * RuleName: 'keyword' | 'other' | 'more';
 * </pre>
 * Clients who want to implement case insensitive languages have to override
 * {@link #toEscapedString(String)} and {@link #keywordToString(Keyword)}. Clients
 * who want to convert the value to another data type may use this implementation 
 * as a delegate.</p>
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class KeywordBasedValueConverter extends AbstractValueConverter<String> implements IValueConverter.RuleSpecific {

	private Set<String> keywords;
	private AbstractRule rule;

	@Override
	public String toValue(String string, INode node) throws ValueConverterException {
		return string;
	}

	@Override
	public String toString(String value) throws ValueConverterException {
		assertValidValue(value);
		String result = toEscapedString(value);
		return result;
	}

	protected void assertValidValue(String value) {
		if (!keywords.contains(value))
			throw new ValueConverterException("The value '" + value + "' is an invalid " + rule.getName(), null, null);
	}

	protected String toEscapedString(String value) {
		return value;
	}
	
	protected String keywordToString(Keyword keyword) {
		return keyword.getValue();
	}

	/**
	 * @throws IllegalArgumentException if the rule is not a datatype rule or does not fulfill
	 *   the pattern <pre>RuleName: 'keyword' | 'other';</pre>
	 */
	@Override
	public void setRule(AbstractRule rule) {
		this.rule = rule;
		if (!GrammarUtil.isDatatypeRule(rule))
			throw new IllegalArgumentException(rule.getName() + " is not a data type rule");
		if (!(rule.getAlternatives() instanceof Alternatives) && !(rule.getAlternatives() instanceof Keyword)) {
			throw new IllegalArgumentException(rule.getName() + " is not a simple keyword nor an alternative");
		}
		if (rule.getAlternatives() instanceof Keyword) {
			keywords = ImmutableSet.of(keywordToString((Keyword) rule.getAlternatives()));
		} else {
			Alternatives alternatives = (Alternatives) rule.getAlternatives();
			ImmutableSet.Builder<String> builder = ImmutableSet.builder();
			for(AbstractElement element: alternatives.getElements()) {
				if (!(element instanceof Keyword)) {
					throw new IllegalArgumentException(rule.getName() + "'s body does not contain an alternative of keywords");
				}
				builder.add(keywordToString((Keyword) element));
			}
			keywords = builder.build();
		}
	} 
	
}
