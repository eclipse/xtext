/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.core.parser.ITokenTypes;

public class GrammarUtil {

	public static boolean isLexerRuleCall(EObject grammarElement) {
		return grammarElement instanceof RuleCall && !isParserRuleCall(grammarElement);
	}
	
	public static boolean isBuiltinLexerRule(LexerRule lexerRule) {
		return BuiltinRules.getBuiltinLexerRules().contains(lexerRule); 
	}

	public static boolean isWhitespaceLexerRule(EObject grammarElement) {
		return (grammarElement instanceof LexerRule)
				&& ((LexerRule) grammarElement).getTokenType().equals(
						ITokenTypes.WHITESPACE);
	}

	public static boolean isParserRuleCall(EObject grammarElement) {
		if (grammarElement instanceof RuleCall) {
			RuleCall ruleCall = (RuleCall) grammarElement;
			Grammar g = grammar(ruleCall);
			for (ParserRule p : g.getParserRules()) {
				if (ruleCall.getName().equals(p.getName())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static AbstractRule calledRule(RuleCall ruleCall) {
		Grammar g = grammar(ruleCall);
		for (LexerRule l : g.getLexerRules()) {
			if (ruleCall.getName().equals(l.getName())) {
				return l;
			}			
		}
		for (LexerRule b : BuiltinRules.getBuiltinLexerRules()) {
			if (ruleCall.getName().equals(b.getName())) {
				return b;
			}			
		}
		for (ParserRule p : g.getParserRules()) {
			if (ruleCall.getName().equals(p.getName())) {
				return p;
			}
		}
		return null;
	}
	
	public static Grammar grammar(EObject grammarElement) {
		Resource resource = grammarElement.eResource();
		if(resource != null) {
			EList<EObject> contents = resource.getContents();
			if(!contents.isEmpty()) {
				EObject rootElement = contents.get(0);
				if(rootElement instanceof Grammar) {
					return (Grammar) rootElement;
				}
			}
		}
		return null;
	}
	
	public static String getID(EObject eObject) {
		Resource resource = eObject.eResource();
		String fragment = resource.getURIFragment(eObject);
		return fragment;
	}
	
}
