/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalCrossReferenceProposalTestLanguage;

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
import org.eclipse.xtext.ui.tests.editor.contentassist.services.CrossReferenceProposalTestLanguageGrammarAccess;

}

@parser::members {

 	private CrossReferenceProposalTestLanguageGrammarAccess grammarAccess;

    public InternalCrossReferenceProposalTestLanguageParser(TokenStream input, CrossReferenceProposalTestLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected CrossReferenceProposalTestLanguageGrammarAccess getGrammarAccess() {
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
			{
				newCompositeNode(grammarAccess.getModelAccess().getElementsClassParserRuleCall_0());
			}
			lv_elements_0_0=ruleClass
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getModelRule());
				}
				add(
					$current,
					"elements",
					lv_elements_0_0,
					"org.eclipse.xtext.ui.tests.editor.contentassist.CrossReferenceProposalTestLanguage.Class");
				afterParserOrEnumRuleCall();
			}
		)
	)*
;

// Entry rule entryRuleClass
entryRuleClass returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getClassRule()); }
	iv_ruleClass=ruleClass
	{ $current=$iv_ruleClass.current; }
	EOF;

// Rule Class
ruleClass returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getClassRule());
							}
						}
						otherlv_0='Object'
						{
							newLeafNode(otherlv_0, grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_0_0());
						}
					)
				)
				    |
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getClassRule());
							}
						}
						otherlv_1=RULE_ID
						{
							newLeafNode(otherlv_1, grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_1_0());
						}
					)
				)
				    |
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getClassRule());
							}
						}
						{
							newCompositeNode(grammarAccess.getClassAccess().getSuperClassClassCrossReference_0_0_2_0());
						}
						ruleComplexName
						{
							afterParserOrEnumRuleCall();
						}
					)
				)
			)
			otherlv_3='<-'
			{
				newLeafNode(otherlv_3, grammarAccess.getClassAccess().getLessThanSignHyphenMinusKeyword_0_1());
			}
		)?
		(
			(
				(
					lv_name_4_1=RULE_ID
					{
						newLeafNode(lv_name_4_1, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getClassRule());
						}
						setWithLastConsumed(
							$current,
							"name",
							lv_name_4_1,
							"org.eclipse.xtext.common.Terminals.ID");
					}
					    |
					{
						newCompositeNode(grammarAccess.getClassAccess().getNameComplexNameParserRuleCall_1_0_1());
					}
					lv_name_4_2=ruleComplexName
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getClassRule());
						}
						set(
							$current,
							"name",
							lv_name_4_2,
							"org.eclipse.xtext.ui.tests.editor.contentassist.CrossReferenceProposalTestLanguage.ComplexName");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)
		otherlv_5='{'
		{
			newLeafNode(otherlv_5, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_2());
		}
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_3());
		}
	)
;

// Entry rule entryRuleComplexName
entryRuleComplexName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getComplexNameRule()); }
	iv_ruleComplexName=ruleComplexName
	{ $current=$iv_ruleComplexName.current.getText(); }
	EOF;

// Rule ComplexName
ruleComplexName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		kw='::'
		{
			$current.merge(kw);
			newLeafNode(kw, grammarAccess.getComplexNameAccess().getColonColonKeyword_0());
		}
		this_ID_1=RULE_ID
		{
			$current.merge(this_ID_1);
		}
		{
			newLeafNode(this_ID_1, grammarAccess.getComplexNameAccess().getIDTerminalRuleCall_1());
		}
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
