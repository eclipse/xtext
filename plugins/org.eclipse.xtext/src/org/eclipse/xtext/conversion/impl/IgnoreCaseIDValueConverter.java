/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.util.Set;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IgnoreCaseIDValueConverter extends AbstractIDValueConverter {
	
	public IgnoreCaseIDValueConverter() {
		super();
	}
	
	/**
	 * @deprecated this implementation is {@link IValueConverter.RuleSpecific} thus {@link #setRule(AbstractRule)}
	 * will be used to initialize this converter.
	 */
	@Deprecated
	public IgnoreCaseIDValueConverter(Grammar grammar, String ruleName) {
		super(grammar, ruleName);
	}
	
	@Override
	protected Set<String> computeValuesToEscape(Grammar grammar) {
		Set<String> result = Sets.newHashSet();
		for(String keyword: GrammarUtil.getAllKeywords(grammar))
			result.add(keyword.toLowerCase());
		return ImmutableSet.copyOf(result);
	}

	@Override
	protected boolean mustEscape(String value) {
		return getValuesToEscape().contains(value.toLowerCase());
	}
}