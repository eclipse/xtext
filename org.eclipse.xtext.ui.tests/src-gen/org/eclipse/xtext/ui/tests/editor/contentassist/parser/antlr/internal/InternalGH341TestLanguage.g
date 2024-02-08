/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalGH341TestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.ui.tests.editor.contentassist.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.editor.contentassist.services.GH341TestLanguageGrammarAccess;

}

@parser::members {

 	private GH341TestLanguageGrammarAccess grammarAccess;

    public InternalGH341TestLanguageParser(TokenStream input, GH341TestLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected GH341TestLanguageGrammarAccess getGrammarAccess() {
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
				{
					newCompositeNode(grammarAccess.getModelAccess().getElementsWorksParserRuleCall_0_0());
				}
				lv_elements_0_1=ruleWorks
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"elements",
						lv_elements_0_1,
						"org.eclipse.xtext.ui.tests.editor.contentassist.GH341TestLanguage.Works");
					afterParserOrEnumRuleCall();
				}
				    |
				{
					newCompositeNode(grammarAccess.getModelAccess().getElementsBrokenParserRuleCall_0_1());
				}
				lv_elements_0_2=ruleBroken
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"elements",
						lv_elements_0_2,
						"org.eclipse.xtext.ui.tests.editor.contentassist.GH341TestLanguage.Broken");
					afterParserOrEnumRuleCall();
				}
				    |
				{
					newCompositeNode(grammarAccess.getModelAccess().getElementsThirdParserRuleCall_0_2());
				}
				lv_elements_0_3=ruleThird
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModelRule());
					}
					add(
						$current,
						"elements",
						lv_elements_0_3,
						"org.eclipse.xtext.ui.tests.editor.contentassist.GH341TestLanguage.Third");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)*
;

// Entry rule entryRuleWorks
entryRuleWorks returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWorksRule()); }
	iv_ruleWorks=ruleWorks
	{ $current=$iv_ruleWorks.current; }
	EOF;

// Rule Works
ruleWorks returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='works'
		{
			newLeafNode(otherlv_0, grammarAccess.getWorksAccess().getWorksKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getWorksAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getWorksRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			(
				(
					lv_ids_2_0=RULE_ID
					{
						newLeafNode(lv_ids_2_0, grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getWorksRule());
						}
						addWithLastConsumed(
							$current,
							"ids",
							lv_ids_2_0,
							"org.eclipse.xtext.common.Terminals.ID");
					}
				)
			)
			(
				otherlv_3='.'
				{
					newLeafNode(otherlv_3, grammarAccess.getWorksAccess().getFullStopKeyword_2_1_0());
				}
				(
					(
						lv_ids_4_0=RULE_ID
						{
							newLeafNode(lv_ids_4_0, grammarAccess.getWorksAccess().getIdsIDTerminalRuleCall_2_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getWorksRule());
							}
							addWithLastConsumed(
								$current,
								"ids",
								lv_ids_4_0,
								"org.eclipse.xtext.common.Terminals.ID");
						}
					)
				)
			)*
			otherlv_5=';'
			{
				newLeafNode(otherlv_5, grammarAccess.getWorksAccess().getSemicolonKeyword_2_2());
			}
		)*
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getWorksRule());
						}
					}
					otherlv_6=RULE_ID
					{
						newLeafNode(otherlv_6, grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_0_0());
					}
				)
			)
			(
				otherlv_7='.'
				{
					newLeafNode(otherlv_7, grammarAccess.getWorksAccess().getFullStopKeyword_3_1_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getWorksRule());
							}
						}
						otherlv_8=RULE_ID
						{
							newLeafNode(otherlv_8, grammarAccess.getWorksAccess().getRefsWorksCrossReference_3_1_1_0());
						}
					)
				)
			)*
			otherlv_9='X'
			{
				newLeafNode(otherlv_9, grammarAccess.getWorksAccess().getXKeyword_3_2());
			}
			otherlv_10=';'
			{
				newLeafNode(otherlv_10, grammarAccess.getWorksAccess().getSemicolonKeyword_3_3());
			}
		)*
	)
;

// Entry rule entryRuleBroken
entryRuleBroken returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getBrokenRule()); }
	iv_ruleBroken=ruleBroken
	{ $current=$iv_ruleBroken.current; }
	EOF;

// Rule Broken
ruleBroken returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='broken'
		{
			newLeafNode(otherlv_0, grammarAccess.getBrokenAccess().getBrokenKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getBrokenAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getBrokenRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		{
			if ($current==null) {
				$current = createModelElement(grammarAccess.getBrokenRule());
			}
			newCompositeNode(grammarAccess.getBrokenAccess().getFragmentParserRuleCall_2());
		}
		this_Fragment_2=ruleFragment[$current]
		{
			$current = $this_Fragment_2.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getBrokenRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_0_0());
					}
				)
			)
			(
				otherlv_4='.'
				{
					newLeafNode(otherlv_4, grammarAccess.getBrokenAccess().getFullStopKeyword_3_1_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getBrokenRule());
							}
						}
						otherlv_5=RULE_ID
						{
							newLeafNode(otherlv_5, grammarAccess.getBrokenAccess().getRefsBrokenCrossReference_3_1_1_0());
						}
					)
				)
			)*
			otherlv_6='X'
			{
				newLeafNode(otherlv_6, grammarAccess.getBrokenAccess().getXKeyword_3_2());
			}
			otherlv_7=';'
			{
				newLeafNode(otherlv_7, grammarAccess.getBrokenAccess().getSemicolonKeyword_3_3());
			}
		)*
	)
;

// Entry rule entryRuleThird
entryRuleThird returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getThirdRule()); }
	iv_ruleThird=ruleThird
	{ $current=$iv_ruleThird.current; }
	EOF;

// Rule Third
ruleThird returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			if ($current==null) {
				$current = createModelElement(grammarAccess.getThirdRule());
			}
			newCompositeNode(grammarAccess.getThirdAccess().getDEFINEParserRuleCall_0());
		}
		this_DEFINE_0=ruleDEFINE[$current]
		{
			$current = $this_DEFINE_0.current;
			afterParserOrEnumRuleCall();
		}
		{
			if ($current==null) {
				$current = createModelElement(grammarAccess.getThirdRule());
			}
			newCompositeNode(grammarAccess.getThirdAccess().getSTREAMParserRuleCall_1());
		}
		this_STREAM_1=ruleSTREAM[$current]
		{
			$current = $this_STREAM_1.current;
			afterParserOrEnumRuleCall();
		}
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getThirdAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getThirdRule());
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


// Rule STREAM
ruleSTREAM[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	otherlv_0='stream'
	{
		newLeafNode(otherlv_0, grammarAccess.getSTREAMAccess().getStreamKeyword());
	}
;


// Rule DEFINE
ruleDEFINE[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	otherlv_0='define'
	{
		newLeafNode(otherlv_0, grammarAccess.getDEFINEAccess().getDefineKeyword());
	}
;


// Rule Fragment
ruleFragment[EObject in_current]  returns [EObject current=in_current]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_ids_0_0=RULE_ID
				{
					newLeafNode(lv_ids_0_0, grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getFragmentRule());
					}
					addWithLastConsumed(
						$current,
						"ids",
						lv_ids_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_1='.'
			{
				newLeafNode(otherlv_1, grammarAccess.getFragmentAccess().getFullStopKeyword_1_0());
			}
			(
				(
					lv_ids_2_0=RULE_ID
					{
						newLeafNode(lv_ids_2_0, grammarAccess.getFragmentAccess().getIdsIDTerminalRuleCall_1_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getFragmentRule());
						}
						addWithLastConsumed(
							$current,
							"ids",
							lv_ids_2_0,
							"org.eclipse.xtext.common.Terminals.ID");
					}
				)
			)
		)*
		otherlv_3=';'
		{
			newLeafNode(otherlv_3, grammarAccess.getFragmentAccess().getSemicolonKeyword_2());
		}
	)*
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
