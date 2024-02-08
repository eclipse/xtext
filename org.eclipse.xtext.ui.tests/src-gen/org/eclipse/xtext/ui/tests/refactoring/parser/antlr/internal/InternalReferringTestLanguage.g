/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
grammar InternalReferringTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.ui.tests.refactoring.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.ui.tests.refactoring.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ui.tests.refactoring.services.ReferringTestLanguageGrammarAccess;

}

@parser::members {

 	private ReferringTestLanguageGrammarAccess grammarAccess;

    public InternalReferringTestLanguageParser(TokenStream input, ReferringTestLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Main";
   	}

   	@Override
   	protected ReferringTestLanguageGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleMain
entryRuleMain returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMainRule()); }
	iv_ruleMain=ruleMain
	{ $current=$iv_ruleMain.current; }
	EOF;

// Rule Main
ruleMain returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getMainAccess().getReferencedAbstractReferenceParserRuleCall_0());
			}
			lv_referenced_0_0=ruleAbstractReference
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getMainRule());
				}
				add(
					$current,
					"referenced",
					lv_referenced_0_0,
					"org.eclipse.xtext.ui.tests.refactoring.ReferringTestLanguage.AbstractReference");
				afterParserOrEnumRuleCall();
			}
		)
	)*
;

// Entry rule entryRuleAbstractReference
entryRuleAbstractReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getAbstractReferenceRule()); }
	iv_ruleAbstractReference=ruleAbstractReference
	{ $current=$iv_ruleAbstractReference.current; }
	EOF;

// Rule AbstractReference
ruleAbstractReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getAbstractReferenceAccess().getReferenceParserRuleCall_0());
		}
		this_Reference_0=ruleReference
		{
			$current = $this_Reference_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getAbstractReferenceAccess().getReference2ParserRuleCall_1());
		}
		this_Reference2_1=ruleReference2
		{
			$current = $this_Reference2_1.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleReference
entryRuleReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReferenceRule()); }
	iv_ruleReference=ruleReference
	{ $current=$iv_ruleReference.current; }
	EOF;

// Rule Reference
ruleReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='ref'
		{
			newLeafNode(otherlv_0, grammarAccess.getReferenceAccess().getRefKeyword_0());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReferenceRule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReferenceAccess().getReferencedEObjectCrossReference_1_0());
				}
				ruleFQN
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleReference2
entryRuleReference2 returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getReference2Rule()); }
	iv_ruleReference2=ruleReference2
	{ $current=$iv_ruleReference2.current; }
	EOF;

// Rule Reference2
ruleReference2 returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getReference2Access().getNamedParserRuleCall_0());
		}
		this_Named_0=ruleNamed
		{
			$current = $this_Named_0.current;
			afterParserOrEnumRuleCall();
		}
		otherlv_1='='
		{
			newLeafNode(otherlv_1, grammarAccess.getReference2Access().getEqualsSignKeyword_1());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getReference2Rule());
					}
				}
				{
					newCompositeNode(grammarAccess.getReference2Access().getReferencedEObjectCrossReference_2_0());
				}
				ruleFQN
				{
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleNamed
entryRuleNamed returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNamedRule()); }
	iv_ruleNamed=ruleNamed
	{ $current=$iv_ruleNamed.current; }
	EOF;

// Rule Named
ruleNamed returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			lv_name_0_0=RULE_ID
			{
				newLeafNode(lv_name_0_0, grammarAccess.getNamedAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getNamedRule());
				}
				setWithLastConsumed(
					$current,
					"name",
					lv_name_0_0,
					"org.eclipse.xtext.common.Terminals.ID");
			}
		)
	)
;

// Entry rule entryRuleFQN
entryRuleFQN returns [String current=null]:
	{ newCompositeNode(grammarAccess.getFQNRule()); }
	iv_ruleFQN=ruleFQN
	{ $current=$iv_ruleFQN.current.getText(); }
	EOF;

// Rule FQN
ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		this_ID_0=RULE_ID
		{
			$current.merge(this_ID_0);
		}
		{
			newLeafNode(this_ID_0, grammarAccess.getFQNAccess().getIDTerminalRuleCall_0());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getFQNAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
