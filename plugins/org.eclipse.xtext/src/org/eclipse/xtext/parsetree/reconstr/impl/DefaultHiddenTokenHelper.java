/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultHiddenTokenHelper extends AbstractHiddenTokenHelper {

	private AbstractRule wsRule;

	public boolean isWhitespace(AbstractRule rule) {
		return rule != null && "WS".equals(rule.getName());
	}

	public boolean isComment(AbstractRule rule) {
		return rule != null && ("ML_COMMENT".equals(rule.getName()) || "SL_COMMENT".equals(rule.getName()));
	}

	@SuppressWarnings("deprecation")
	public AbstractRule getWhitespaceRuleFor(String whitespace) {
		return wsRule;
	}

	@Override
	public AbstractRule getWhitespaceRuleFor(ParserRule context, String whitespace) {
		if (context == null || !context.isDefinesHiddenTokens())
			return wsRule;
		if (context.getHiddenTokens().contains(wsRule))
			return wsRule;
		return null;
	}

	@Inject
	@SuppressWarnings("unused")
	private void setGrammar(IGrammarAccess grammar) {
		wsRule = GrammarUtil.findRuleForName(grammar.getGrammar(), "WS");
	}

}
