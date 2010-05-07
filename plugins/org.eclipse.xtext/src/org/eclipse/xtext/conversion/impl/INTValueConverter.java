/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;

public class INTValueConverter extends AbstractLexerBasedConverter<Integer> {

	@Inject
	public INTValueConverter(IGrammarAccess grammarAccess) {
		this(grammarAccess.getGrammar(), "INT");
	}
	
	protected INTValueConverter(Grammar grammar, String ruleName) {
		super(GrammarUtil.findRuleForName(grammar, ruleName));
	}
	
	@Override
	protected String toEscapedString(Integer value) {
		return value.toString();
	}
	
	@Override
	protected void assertValidValue(Integer value) {
		super.assertValidValue(value);
		if (value < 0)
			throw new ValueConverterException(getRuleName() + "-value may not be negative (value:" + value + ").", null, null);
	}
	
	public Integer toValue(String string, AbstractNode node) {
		if (Strings.isEmpty(string))
			throw new ValueConverterException("Couldn't convert empty string to int.", node, null);
		try {
			return Integer.valueOf(string);
		} catch (NumberFormatException e) {
			throw new ValueConverterException("Couldn't convert '" + string + "' to int.", node, e);
		}
	}

}