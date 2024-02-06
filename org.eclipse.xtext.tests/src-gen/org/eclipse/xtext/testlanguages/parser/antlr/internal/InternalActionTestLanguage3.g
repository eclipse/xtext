/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalActionTestLanguage3;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.testlanguages.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.testlanguages.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguage3GrammarAccess;

}

@parser::members {

 	private ActionTestLanguage3GrammarAccess grammarAccess;

    public InternalActionTestLanguage3Parser(TokenStream input, ActionTestLanguage3GrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "ProductionRules";
   	}

   	@Override
   	protected ActionTestLanguage3GrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleProductionRules
entryRuleProductionRules returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getProductionRulesRule()); }
	iv_ruleProductionRules=ruleProductionRules
	{ $current=$iv_ruleProductionRules.current; }
	EOF;

// Rule ProductionRules
ruleProductionRules returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getProductionRulesAccess().getProductionRule1ParserRuleCall_0());
		}
		this_ProductionRule1_0=ruleProductionRule1
		{
			$current = $this_ProductionRule1_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getProductionRulesAccess().getProductionRule2ParserRuleCall_1());
		}
		this_ProductionRule2_1=ruleProductionRule2
		{
			$current = $this_ProductionRule2_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleProductionRule1
entryRuleProductionRule1 returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getProductionRule1Rule()); }
	iv_ruleProductionRule1=ruleProductionRule1
	{ $current=$iv_ruleProductionRule1.current; }
	EOF;

// Rule ProductionRule1
ruleProductionRule1 returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getProductionRule1Access().getP1Action_0(),
					$current);
			}
		)
		(
			(
				lv_id_1_0=RULE_ID
				{
					newLeafNode(lv_id_1_0, grammarAccess.getProductionRule1Access().getIdIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getProductionRule1Rule());
					}
					setWithLastConsumed(
						$current,
						"id",
						lv_id_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)?
		(
			{
				$current = forceCreateModelElementAndSet(
					grammarAccess.getProductionRule1Access().getP2PAction_2(),
					$current);
			}
		)
		(
			(
				lv_string_3_0=RULE_STRING
				{
					newLeafNode(lv_string_3_0, grammarAccess.getProductionRule1Access().getStringSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getProductionRule1Rule());
					}
					setWithLastConsumed(
						$current,
						"string",
						lv_string_3_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)?
		(
			{
				$current = forceCreateModelElementAndSet(
					grammarAccess.getProductionRule1Access().getP3PAction_4(),
					$current);
			}
		)
		(
			(
				lv_i_5_0=RULE_INT
				{
					newLeafNode(lv_i_5_0, grammarAccess.getProductionRule1Access().getIINTTerminalRuleCall_5_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getProductionRule1Rule());
					}
					setWithLastConsumed(
						$current,
						"i",
						lv_i_5_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
	)
;

// Entry rule entryRuleProductionRule2
entryRuleProductionRule2 returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getProductionRule2Rule()); }
	iv_ruleProductionRule2=ruleProductionRule2
	{ $current=$iv_ruleProductionRule2.current; }
	EOF;

// Rule ProductionRule2
ruleProductionRule2 returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_STRING_0=RULE_STRING
		{
			newLeafNode(this_STRING_0, grammarAccess.getProductionRule2Access().getSTRINGTerminalRuleCall_0());
		}
		(
			{
				$current = forceCreateModelElement(
					grammarAccess.getProductionRule2Access().getEntryAction_1(),
					$current);
			}
		)
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getProductionRule2Access().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getProductionRule2Rule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
