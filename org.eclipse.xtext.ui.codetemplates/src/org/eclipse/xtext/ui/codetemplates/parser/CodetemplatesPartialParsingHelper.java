/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.parser;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.impl.PartialParsingHelper;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CodetemplatesPartialParsingHelper extends PartialParsingHelper {

	@Inject
	private IGrammarAccess grammarAccess;
	
	private AbstractRule templatesRule;
	private AbstractRule templateRule;
	
	@Override
	protected boolean isInvalidRootNode(ICompositeNode rootNode, ICompositeNode candidate) {
		if (!(candidate.getGrammarElement() instanceof RuleCall) && !(candidate.getGrammarElement() instanceof ParserRule)) {
			return true;
		}
		ParserRule parserRule = null;
		if (candidate.getGrammarElement() instanceof RuleCall) {
			RuleCall call = (RuleCall) candidate.getGrammarElement();
			if (call.getRule() instanceof ParserRule) {
				parserRule = (ParserRule) call.getRule(); 
			}
		} else if (candidate.getGrammarElement() instanceof ParserRule) {
			parserRule = (ParserRule) candidate.getGrammarElement();
		}
		if (parserRule != getTemplatesRule() && parserRule != getTemplateRule())
			return true;
		return super.isInvalidRootNode(rootNode, candidate);
	}

	private AbstractRule getTemplatesRule() {
		if (templatesRule == null)
			templatesRule = GrammarUtil.findRuleForName(grammarAccess.getGrammar(), "Codetemplates");
		return templatesRule;
	}

	private AbstractRule getTemplateRule() {
		if (templateRule == null)
			templateRule = GrammarUtil.findRuleForName(grammarAccess.getGrammar(), "Codetemplate");
		return templateRule;
	}
	
}
