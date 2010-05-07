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
import org.eclipse.xtext.IGrammarAccess;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class IDValueConverter extends AbstractIDValueConverter {
	
	@Inject
	public IDValueConverter(IGrammarAccess grammarAccess) {
		this(grammarAccess.getGrammar(), "ID");
	}
	
	protected IDValueConverter(Grammar grammar, String ruleName) {
		super(grammar, ruleName);
	}
	
	@Override
	protected Set<String> computeValuesToEscape(Grammar grammar) {
		return ImmutableSet.copyOf(GrammarUtil.getAllKeywords(grammar));
	}

	@Override
	protected boolean mustEscape(String value) {
		return getValuesToEscape().contains(value);
	}
}