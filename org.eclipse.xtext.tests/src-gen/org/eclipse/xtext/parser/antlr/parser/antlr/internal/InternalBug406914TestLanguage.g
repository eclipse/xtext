/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalBug406914TestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.parser.antlr.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.parser.antlr.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.antlr.services.Bug406914TestLanguageGrammarAccess;

}

@parser::members {

 	private Bug406914TestLanguageGrammarAccess grammarAccess;

    public InternalBug406914TestLanguageParser(TokenStream input, Bug406914TestLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected Bug406914TestLanguageGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_ID
				{
					newLeafNode(lv_name_0_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModelRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.parser.antlr.Bug406914TestLanguage.ID");
				}
			)
		)
		{
			newCompositeNode(grammarAccess.getModelAccess().getBS_ESCAPEParserRuleCall_1());
		}
		ruleBS_ESCAPE
		{
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleBS_ESCAPE
entryRuleBS_ESCAPE returns [String current=null]:
	{ newCompositeNode(grammarAccess.getBS_ESCAPERule()); }
	iv_ruleBS_ESCAPE=ruleBS_ESCAPE
	{ $current=$iv_ruleBS_ESCAPE.current.getText(); }
	EOF;

// Rule BS_ESCAPE
ruleBS_ESCAPE returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='\b'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getBackspaceKeyword_0());
		}
		    |
		kw='\f'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getFormFeedKeyword_1());
		}
		    |
		kw='\n'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getLineFeedKeyword_2());
		}
		    |
		kw='lineFeed'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getLineFeedKeyword_3());
		}
		    |
		kw='\r'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getCarriageReturnKeyword_4());
		}
		    |
		kw='\t'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getTabKeyword_5());
		}
		    |
		kw='\\'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getBS_ESCAPEAccess().getBackslashKeyword_6());
		}
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_WS : (' '|'\t')+;

RULE_ANY_OTHER : .;
