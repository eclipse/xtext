/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class KeywordInspector {

	private final ValidationMessageAcceptor acceptor;

	public KeywordInspector(ValidationMessageAcceptor messageAcceptor) {
		this.acceptor = messageAcceptor;
	}
	
	public void inspectKeywordHidesTerminalRule(Keyword keyword) {
		AbstractRule container = GrammarUtil.containingRule(keyword);
		if (container instanceof TerminalRule)
			return;
		Grammar grammar = GrammarUtil.getGrammar(container);
		List<TerminalRule> rules = GrammarUtil.allTerminalRules(grammar);
		for(TerminalRule rule: rules) {
			AbstractElement element = rule.getAlternatives();
			if (element instanceof Keyword && Strings.isEmpty(element.getCardinality())) {
				String value = ((Keyword) element).getValue();
				if (value.equals(keyword.getValue()))
				acceptor.acceptError("The keyword '" + value + "' hides the terminal rule " + rule.getName()+ ".", 
						keyword, XtextPackage.KEYWORD__VALUE, null);
			}
		}
	}

}
