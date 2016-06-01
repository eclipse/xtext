/*
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
grammar InternalTestLanguage;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.eclipse.xtext.ide.tests.testlanguage.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
package org.eclipse.xtext.ide.tests.testlanguage.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.ide.tests.testlanguage.services.TestLanguageGrammarAccess;

}

@parser::members {

 	private TestLanguageGrammarAccess grammarAccess;

    public InternalTestLanguageParser(TokenStream input, TestLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected TestLanguageGrammarAccess getGrammarAccess() {
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
				newCompositeNode(grammarAccess.getModelAccess().getTypesTypeDeclarationParserRuleCall_0());
			}
			lv_types_0_0=ruleTypeDeclaration
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getModelRule());
				}
				add(
					$current,
					"types",
					lv_types_0_0,
					"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.TypeDeclaration");
				afterParserOrEnumRuleCall();
			}
		)
	)*
;

// Entry rule entryRuleTypeDeclaration
entryRuleTypeDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeDeclarationRule()); }
	iv_ruleTypeDeclaration=ruleTypeDeclaration
	{ $current=$iv_ruleTypeDeclaration.current; }
	EOF;

// Rule TypeDeclaration
ruleTypeDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='type'
		{
			newLeafNode(otherlv_0, grammarAccess.getTypeDeclarationAccess().getTypeKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getTypeDeclarationAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTypeDeclarationRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='{'
		{
			newLeafNode(otherlv_2, grammarAccess.getTypeDeclarationAccess().getLeftCurlyBracketKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTypeDeclarationAccess().getPropertiesPropertyParserRuleCall_3_0());
				}
				lv_properties_3_0=ruleProperty
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTypeDeclarationRule());
					}
					add(
						$current,
						"properties",
						lv_properties_3_0,
						"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Property");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		otherlv_4='}'
		{
			newLeafNode(otherlv_4, grammarAccess.getTypeDeclarationAccess().getRightCurlyBracketKeyword_4());
		}
	)
;

// Entry rule entryRuleProperty
entryRuleProperty returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPropertyRule()); }
	iv_ruleProperty=ruleProperty
	{ $current=$iv_ruleProperty.current; }
	EOF;

// Rule Property
ruleProperty returns [EObject current=null]
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
					newCompositeNode(grammarAccess.getPropertyAccess().getTypeTypeParserRuleCall_0_0());
				}
				lv_type_0_0=ruleType
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getPropertyRule());
					}
					set(
						$current,
						"type",
						lv_type_0_0,
						"org.eclipse.xtext.ide.tests.testlanguage.TestLanguage.Type");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getPropertyAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPropertyRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
	)
;

// Entry rule entryRuleType
entryRuleType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeRule()); }
	iv_ruleType=ruleType
	{ $current=$iv_ruleType.current; }
	EOF;

// Rule Type
ruleType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getTypeAccess().getTypeReferenceParserRuleCall_0_0());
			}
			this_TypeReference_0=ruleTypeReference
			{
				$current = $this_TypeReference_0.current;
				afterParserOrEnumRuleCall();
			}
			    |
			{
				newCompositeNode(grammarAccess.getTypeAccess().getPrimitiveTypeParserRuleCall_0_1());
			}
			this_PrimitiveType_1=rulePrimitiveType
			{
				$current = $this_PrimitiveType_1.current;
				afterParserOrEnumRuleCall();
			}
		)
		(
			(
				(
					lv_arrayDiemensions_2_0='['
					{
						newLeafNode(lv_arrayDiemensions_2_0, grammarAccess.getTypeAccess().getArrayDiemensionsLeftSquareBracketKeyword_1_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getTypeRule());
						}
						addWithLastConsumed($current, "arrayDiemensions", lv_arrayDiemensions_2_0, "[");
					}
				)
			)
			otherlv_3=']'
			{
				newLeafNode(otherlv_3, grammarAccess.getTypeAccess().getRightSquareBracketKeyword_1_1());
			}
		)*
	)
;

// Entry rule entryRuleTypeReference
entryRuleTypeReference returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTypeReferenceRule()); }
	iv_ruleTypeReference=ruleTypeReference
	{ $current=$iv_ruleTypeReference.current; }
	EOF;

// Rule TypeReference
ruleTypeReference returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getTypeReferenceRule());
				}
			}
			otherlv_0=RULE_ID
			{
				newLeafNode(otherlv_0, grammarAccess.getTypeReferenceAccess().getTypeRefTypeDeclarationCrossReference_0());
			}
		)
	)
;

// Entry rule entryRulePrimitiveType
entryRulePrimitiveType returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getPrimitiveTypeRule()); }
	iv_rulePrimitiveType=rulePrimitiveType
	{ $current=$iv_rulePrimitiveType.current; }
	EOF;

// Rule PrimitiveType
rulePrimitiveType returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_1='string'
				{
					newLeafNode(lv_name_0_1, grammarAccess.getPrimitiveTypeAccess().getNameStringKeyword_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPrimitiveTypeRule());
					}
					setWithLastConsumed($current, "name", lv_name_0_1, null);
				}
				    |
				lv_name_0_2='int'
				{
					newLeafNode(lv_name_0_2, grammarAccess.getPrimitiveTypeAccess().getNameIntKeyword_0_1());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPrimitiveTypeRule());
					}
					setWithLastConsumed($current, "name", lv_name_0_2, null);
				}
				    |
				lv_name_0_3='boolean'
				{
					newLeafNode(lv_name_0_3, grammarAccess.getPrimitiveTypeAccess().getNameBooleanKeyword_0_2());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getPrimitiveTypeRule());
					}
					setWithLastConsumed($current, "name", lv_name_0_3, null);
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
