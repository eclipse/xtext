/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
grammar InternalPartialSerializationTestLanguage;

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
import org.eclipse.xtext.ide.tests.testlanguage.services.PartialSerializationTestLanguageGrammarAccess;

}

@parser::members {

 	private PartialSerializationTestLanguageGrammarAccess grammarAccess;

    public InternalPartialSerializationTestLanguageParser(TokenStream input, PartialSerializationTestLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Model";
   	}

   	@Override
   	protected PartialSerializationTestLanguageGrammarAccess getGrammarAccess() {
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
			otherlv_0='#1'
			{
				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getNumberSignDigitOneKeyword_0_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getNodeParserRuleCall_0_1());
			}
			this_Node_1=ruleNode
			{
				$current = $this_Node_1.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_2='#2'
			{
				newLeafNode(otherlv_2, grammarAccess.getModelAccess().getNumberSignDigitTwoKeyword_1_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getMandatoryValueParserRuleCall_1_1());
			}
			this_MandatoryValue_3=ruleMandatoryValue
			{
				$current = $this_MandatoryValue_3.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_4='#3'
			{
				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getNumberSignDigitThreeKeyword_2_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getOptionalValueParserRuleCall_2_1());
			}
			this_OptionalValue_5=ruleOptionalValue
			{
				$current = $this_OptionalValue_5.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_6='#4'
			{
				newLeafNode(otherlv_6, grammarAccess.getModelAccess().getNumberSignDigitFourKeyword_3_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getMandatoryChildParserRuleCall_3_1());
			}
			this_MandatoryChild_7=ruleMandatoryChild
			{
				$current = $this_MandatoryChild_7.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_8='#5'
			{
				newLeafNode(otherlv_8, grammarAccess.getModelAccess().getNumberSignDigitFiveKeyword_4_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getOptionalChildParserRuleCall_4_1());
			}
			this_OptionalChild_9=ruleOptionalChild
			{
				$current = $this_OptionalChild_9.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_10='#10'
			{
				newLeafNode(otherlv_10, grammarAccess.getModelAccess().getNumberSignDigitOneDigitZeroKeyword_5_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getManyOptionalValuesParserRuleCall_5_1());
			}
			this_ManyOptionalValues_11=ruleManyOptionalValues
			{
				$current = $this_ManyOptionalValues_11.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_12='#11'
			{
				newLeafNode(otherlv_12, grammarAccess.getModelAccess().getNumberSignDigitOneDigitOneKeyword_6_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getManyMandatoryValuesParserRuleCall_6_1());
			}
			this_ManyMandatoryValues_13=ruleManyMandatoryValues
			{
				$current = $this_ManyMandatoryValues_13.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_14='#12'
			{
				newLeafNode(otherlv_14, grammarAccess.getModelAccess().getNumberSignDigitOneDigitTwoKeyword_7_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getMandatoryChildListParserRuleCall_7_1());
			}
			this_MandatoryChildList_15=ruleMandatoryChildList
			{
				$current = $this_MandatoryChildList_15.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_16='#13'
			{
				newLeafNode(otherlv_16, grammarAccess.getModelAccess().getNumberSignDigitOneDigitThreeKeyword_8_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getOptionalChildListParserRuleCall_8_1());
			}
			this_OptionalChildList_17=ruleOptionalChildList
			{
				$current = $this_OptionalChildList_17.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_18='#20'
			{
				newLeafNode(otherlv_18, grammarAccess.getModelAccess().getNumberSignDigitTwoDigitZeroKeyword_9_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getModelAccess().getClazzEClassDeclParserRuleCall_9_1_0());
					}
					lv_clazz_19_0=ruleEClassDecl
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getModelRule());
						}
						add(
							$current,
							"clazz",
							lv_clazz_19_0,
							"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.EClassDecl");
						afterParserOrEnumRuleCall();
					}
				)
			)+
		)
		    |
		(
			otherlv_20='#21'
			{
				newLeafNode(otherlv_20, grammarAccess.getModelAccess().getNumberSignDigitTwoDigitOneKeyword_10_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getEClassRefParserRuleCall_10_1());
			}
			this_EClassRef_21=ruleEClassRef
			{
				$current = $this_EClassRef_21.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_22='#22'
			{
				newLeafNode(otherlv_22, grammarAccess.getModelAccess().getNumberSignDigitTwoDigitTwoKeyword_11_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getTwoChildListsParserRuleCall_11_1());
			}
			this_TwoChildLists_23=ruleTwoChildLists
			{
				$current = $this_TwoChildLists_23.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_24='#23'
			{
				newLeafNode(otherlv_24, grammarAccess.getModelAccess().getNumberSignDigitTwoDigitThreeKeyword_12_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getChildWithSubChildsParserRuleCall_12_1());
			}
			this_ChildWithSubChilds_25=ruleChildWithSubChilds
			{
				$current = $this_ChildWithSubChilds_25.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_26='#24'
			{
				newLeafNode(otherlv_26, grammarAccess.getModelAccess().getNumberSignDigitTwoDigitFourKeyword_13_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getTwoChildsParserRuleCall_13_1());
			}
			this_TwoChilds_27=ruleTwoChilds
			{
				$current = $this_TwoChilds_27.current;
				afterParserOrEnumRuleCall();
			}
		)
		    |
		(
			otherlv_28='#30'
			{
				newLeafNode(otherlv_28, grammarAccess.getModelAccess().getNumberSignDigitThreeDigitZeroKeyword_14_0());
			}
			{
				newCompositeNode(grammarAccess.getModelAccess().getWithTransientContainerParserRuleCall_14_1());
			}
			this_WithTransientContainer_29=ruleWithTransientContainer
			{
				$current = $this_WithTransientContainer_29.current;
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleMandatoryValue
entryRuleMandatoryValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMandatoryValueRule()); }
	iv_ruleMandatoryValue=ruleMandatoryValue
	{ $current=$iv_ruleMandatoryValue.current; }
	EOF;

// Rule MandatoryValue
ruleMandatoryValue returns [EObject current=null]
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
				newLeafNode(lv_name_0_0, grammarAccess.getMandatoryValueAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getMandatoryValueRule());
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

// Entry rule entryRuleOptionalValue
entryRuleOptionalValue returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOptionalValueRule()); }
	iv_ruleOptionalValue=ruleOptionalValue
	{ $current=$iv_ruleOptionalValue.current; }
	EOF;

// Rule OptionalValue
ruleOptionalValue returns [EObject current=null]
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
					grammarAccess.getOptionalValueAccess().getOptionalValueAction_0(),
					$current);
			}
		)
		(
			otherlv_1='kw1'
			{
				newLeafNode(otherlv_1, grammarAccess.getOptionalValueAccess().getKw1Keyword_1());
			}
		)?
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getOptionalValueAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOptionalValueRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)?
		(
			otherlv_3='kw2'
			{
				newLeafNode(otherlv_3, grammarAccess.getOptionalValueAccess().getKw2Keyword_3());
			}
		)?
	)
;

// Entry rule entryRuleManyOptionalValues
entryRuleManyOptionalValues returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getManyOptionalValuesRule()); }
	iv_ruleManyOptionalValues=ruleManyOptionalValues
	{ $current=$iv_ruleManyOptionalValues.current; }
	EOF;

// Rule ManyOptionalValues
ruleManyOptionalValues returns [EObject current=null]
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
					grammarAccess.getManyOptionalValuesAccess().getManyValuesAction_0(),
					$current);
			}
		)
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getManyOptionalValuesAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getManyOptionalValuesRule());
					}
					addWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)*
	)
;

// Entry rule entryRuleManyMandatoryValues
entryRuleManyMandatoryValues returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getManyMandatoryValuesRule()); }
	iv_ruleManyMandatoryValues=ruleManyMandatoryValues
	{ $current=$iv_ruleManyMandatoryValues.current; }
	EOF;

// Rule ManyMandatoryValues
ruleManyMandatoryValues returns [EObject current=null]
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
				newLeafNode(lv_name_0_0, grammarAccess.getManyMandatoryValuesAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getManyMandatoryValuesRule());
				}
				addWithLastConsumed(
					$current,
					"name",
					lv_name_0_0,
					"org.eclipse.xtext.common.Terminals.ID");
			}
		)
	)+
;

// Entry rule entryRuleMandatoryChild
entryRuleMandatoryChild returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMandatoryChildRule()); }
	iv_ruleMandatoryChild=ruleMandatoryChild
	{ $current=$iv_ruleMandatoryChild.current; }
	EOF;

// Rule MandatoryChild
ruleMandatoryChild returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getMandatoryChildAccess().getChildMandatoryValueParserRuleCall_0());
			}
			lv_child_0_0=ruleMandatoryValue
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getMandatoryChildRule());
				}
				set(
					$current,
					"child",
					lv_child_0_0,
					"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleOptionalChild
entryRuleOptionalChild returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOptionalChildRule()); }
	iv_ruleOptionalChild=ruleOptionalChild
	{ $current=$iv_ruleOptionalChild.current; }
	EOF;

// Rule OptionalChild
ruleOptionalChild returns [EObject current=null]
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
					grammarAccess.getOptionalChildAccess().getOptionalChildAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getOptionalChildAccess().getChildMandatoryValueParserRuleCall_1_0());
				}
				lv_child_1_0=ruleMandatoryValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOptionalChildRule());
					}
					set(
						$current,
						"child",
						lv_child_1_0,
						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleTwoChildLists
entryRuleTwoChildLists returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTwoChildListsRule()); }
	iv_ruleTwoChildLists=ruleTwoChildLists
	{ $current=$iv_ruleTwoChildLists.current; }
	EOF;

// Rule TwoChildLists
ruleTwoChildLists returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='{'
		{
			newLeafNode(otherlv_0, grammarAccess.getTwoChildListsAccess().getLeftCurlyBracketKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTwoChildListsAccess().getDirectChildrenMandatoryValueParserRuleCall_1_0());
				}
				lv_directChildren_1_0=ruleMandatoryValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTwoChildListsRule());
					}
					add(
						$current,
						"directChildren",
						lv_directChildren_1_0,
						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		otherlv_2='children1'
		{
			newLeafNode(otherlv_2, grammarAccess.getTwoChildListsAccess().getChildren1Keyword_2());
		}
		otherlv_3='{'
		{
			newLeafNode(otherlv_3, grammarAccess.getTwoChildListsAccess().getLeftCurlyBracketKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTwoChildListsAccess().getChildsListMandatoryChildListParserRuleCall_4_0());
				}
				lv_childsList_4_0=ruleMandatoryChildList
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTwoChildListsRule());
					}
					set(
						$current,
						"childsList",
						lv_childsList_4_0,
						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryChildList");
					afterParserOrEnumRuleCall();
				}
			)
		)
		otherlv_5='}'
		{
			newLeafNode(otherlv_5, grammarAccess.getTwoChildListsAccess().getRightCurlyBracketKeyword_5());
		}
		otherlv_6='}'
		{
			newLeafNode(otherlv_6, grammarAccess.getTwoChildListsAccess().getRightCurlyBracketKeyword_6());
		}
	)
;

// Entry rule entryRuleTwoChilds
entryRuleTwoChilds returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTwoChildsRule()); }
	iv_ruleTwoChilds=ruleTwoChilds
	{ $current=$iv_ruleTwoChilds.current; }
	EOF;

// Rule TwoChilds
ruleTwoChilds returns [EObject current=null]
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
					grammarAccess.getTwoChildsAccess().getTwoChildsAction_0(),
					$current);
			}
		)
		otherlv_1='direct'
		{
			newLeafNode(otherlv_1, grammarAccess.getTwoChildsAccess().getDirectKeyword_1());
		}
		otherlv_2=':'
		{
			newLeafNode(otherlv_2, grammarAccess.getTwoChildsAccess().getColonKeyword_2());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTwoChildsAccess().getDirectChildMandatoryValueParserRuleCall_3_0());
				}
				lv_directChild_3_0=ruleMandatoryValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTwoChildsRule());
					}
					set(
						$current,
						"directChild",
						lv_directChild_3_0,
						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		otherlv_4='child'
		{
			newLeafNode(otherlv_4, grammarAccess.getTwoChildsAccess().getChildKeyword_4());
		}
		otherlv_5=':'
		{
			newLeafNode(otherlv_5, grammarAccess.getTwoChildsAccess().getColonKeyword_5());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getTwoChildsAccess().getOptChildOptionalChildParserRuleCall_6_0());
				}
				lv_optChild_6_0=ruleOptionalChild
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTwoChildsRule());
					}
					set(
						$current,
						"optChild",
						lv_optChild_6_0,
						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.OptionalChild");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleChildWithSubChilds
entryRuleChildWithSubChilds returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChildWithSubChildsRule()); }
	iv_ruleChildWithSubChilds=ruleChildWithSubChilds
	{ $current=$iv_ruleChildWithSubChilds.current; }
	EOF;

// Rule ChildWithSubChilds
ruleChildWithSubChilds returns [EObject current=null]
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
					grammarAccess.getChildWithSubChildsAccess().getChildWithSubChildsAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getChildWithSubChildsAccess().getChildrenChildWithSubChildParserRuleCall_1_0());
				}
				lv_children_1_0=ruleChildWithSubChild
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChildWithSubChildsRule());
					}
					add(
						$current,
						"children",
						lv_children_1_0,
						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.ChildWithSubChild");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleChildWithSubChild
entryRuleChildWithSubChild returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChildWithSubChildRule()); }
	iv_ruleChildWithSubChild=ruleChildWithSubChild
	{ $current=$iv_ruleChildWithSubChild.current; }
	EOF;

// Rule ChildWithSubChild
ruleChildWithSubChild returns [EObject current=null]
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
					grammarAccess.getChildWithSubChildAccess().getChildWithSubChildAction_0(),
					$current);
			}
		)
		otherlv_1='subs'
		{
			newLeafNode(otherlv_1, grammarAccess.getChildWithSubChildAccess().getSubsKeyword_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getChildWithSubChildAccess().getSubChildsSubChildParserRuleCall_2_0());
				}
				lv_subChilds_2_0=ruleSubChild
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChildWithSubChildRule());
					}
					add(
						$current,
						"subChilds",
						lv_subChilds_2_0,
						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.SubChild");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleSubChild
entryRuleSubChild returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSubChildRule()); }
	iv_ruleSubChild=ruleSubChild
	{ $current=$iv_ruleSubChild.current; }
	EOF;

// Rule SubChild
ruleSubChild returns [EObject current=null]
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
				newLeafNode(lv_name_0_0, grammarAccess.getSubChildAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getSubChildRule());
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

// Entry rule entryRuleMandatoryChildList
entryRuleMandatoryChildList returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getMandatoryChildListRule()); }
	iv_ruleMandatoryChildList=ruleMandatoryChildList
	{ $current=$iv_ruleMandatoryChildList.current; }
	EOF;

// Rule MandatoryChildList
ruleMandatoryChildList returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getMandatoryChildListAccess().getChildrenMandatoryValueParserRuleCall_0());
			}
			lv_children_0_0=ruleMandatoryValue
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getMandatoryChildListRule());
				}
				add(
					$current,
					"children",
					lv_children_0_0,
					"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
				afterParserOrEnumRuleCall();
			}
		)
	)+
;

// Entry rule entryRuleOptionalChildList
entryRuleOptionalChildList returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOptionalChildListRule()); }
	iv_ruleOptionalChildList=ruleOptionalChildList
	{ $current=$iv_ruleOptionalChildList.current; }
	EOF;

// Rule OptionalChildList
ruleOptionalChildList returns [EObject current=null]
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
					grammarAccess.getOptionalChildListAccess().getOptionalChildListAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getOptionalChildListAccess().getChildrenMandatoryValueParserRuleCall_1_0());
				}
				lv_children_1_0=ruleMandatoryValue
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOptionalChildListRule());
					}
					add(
						$current,
						"children",
						lv_children_1_0,
						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.MandatoryValue");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleImport
entryRuleImport returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getImportRule()); }
	iv_ruleImport=ruleImport
	{ $current=$iv_ruleImport.current; }
	EOF;

// Rule Import
ruleImport returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='import'
		{
			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameParserRuleCall_1_0());
				}
				lv_importedNamespace_1_0=ruleQualifiedName
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getImportRule());
					}
					set(
						$current,
						"importedNamespace",
						lv_importedNamespace_1_0,
						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.QualifiedName");
					afterParserOrEnumRuleCall();
				}
			)
		)
	)
;

// Entry rule entryRuleNode
entryRuleNode returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getNodeRule()); }
	iv_ruleNode=ruleNode
	{ $current=$iv_ruleNode.current; }
	EOF;

// Rule Node
ruleNode returns [EObject current=null]
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
					grammarAccess.getNodeAccess().getNodeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getNodeAccess().getImportsImportParserRuleCall_1_0());
				}
				lv_imports_1_0=ruleImport
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getNodeRule());
					}
					add(
						$current,
						"imports",
						lv_imports_1_0,
						"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.Import");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				lv_name_2_0=RULE_ID
				{
					newLeafNode(lv_name_2_0, grammarAccess.getNodeAccess().getNameIDTerminalRuleCall_2_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getNodeRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_2_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)?
		(
			otherlv_3='refs'
			{
				newLeafNode(otherlv_3, grammarAccess.getNodeAccess().getRefsKeyword_3_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getNodeRule());
						}
					}
					{
						newCompositeNode(grammarAccess.getNodeAccess().getRefsNodeCrossReference_3_1_0());
					}
					ruleQualifiedName
					{
						afterParserOrEnumRuleCall();
					}
				)
			)*
		)?
		(
			(
				otherlv_5='{'
				{
					newLeafNode(otherlv_5, grammarAccess.getNodeAccess().getLeftCurlyBracketKeyword_4_0_0());
				}
				(
					(
						{
							newCompositeNode(grammarAccess.getNodeAccess().getChildrenNodeParserRuleCall_4_0_1_0());
						}
						lv_children_6_0=ruleNode
						{
							if ($current==null) {
								$current = createModelElementForParent(grammarAccess.getNodeRule());
							}
							add(
								$current,
								"children",
								lv_children_6_0,
								"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.Node");
							afterParserOrEnumRuleCall();
						}
					)
				)*
				(
					otherlv_7='ref'
					{
						newLeafNode(otherlv_7, grammarAccess.getNodeAccess().getRefKeyword_4_0_2_0());
					}
					(
						(
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getNodeRule());
								}
							}
							{
								newCompositeNode(grammarAccess.getNodeAccess().getRefNodeCrossReference_4_0_2_1_0());
							}
							ruleQualifiedName
							{
								afterParserOrEnumRuleCall();
							}
						)
					)
				)?
				otherlv_9='}'
				{
					newLeafNode(otherlv_9, grammarAccess.getNodeAccess().getRightCurlyBracketKeyword_4_0_3());
				}
			)
			    |
			otherlv_10=';'
			{
				newLeafNode(otherlv_10, grammarAccess.getNodeAccess().getSemicolonKeyword_4_1());
			}
		)
	)
;

// Entry rule entryRuleQualifiedName
entryRuleQualifiedName returns [String current=null]:
	{ newCompositeNode(grammarAccess.getQualifiedNameRule()); }
	iv_ruleQualifiedName=ruleQualifiedName
	{ $current=$iv_ruleQualifiedName.current.getText(); }
	EOF;

// Rule QualifiedName
ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()]
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
			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
		}
		(
			kw='.'
			{
				$current.merge(kw);
				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
			}
			this_ID_2=RULE_ID
			{
				$current.merge(this_ID_2);
			}
			{
				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
			}
		)*
	)
;

// Entry rule entryRuleEClassDecl
entryRuleEClassDecl returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEClassDeclRule()); }
	iv_ruleEClassDecl=ruleEClassDecl
	{ $current=$iv_ruleEClassDecl.current; }
	EOF;

// Rule EClassDecl
ruleEClassDecl returns [EObject current=null]
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
				newLeafNode(lv_name_0_0, grammarAccess.getEClassDeclAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getEClassDeclRule());
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

// Entry rule entryRuleEClassRef
entryRuleEClassRef returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEClassRefRule()); }
	iv_ruleEClassRef=ruleEClassRef
	{ $current=$iv_ruleEClassRef.current; }
	EOF;

// Rule EClassRef
ruleEClassRef returns [EObject current=null]
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
					$current = createModelElement(grammarAccess.getEClassRefRule());
				}
			}
			{
				newCompositeNode(grammarAccess.getEClassRefAccess().getRefEClassCrossReference_0());
			}
			ruleQualifiedName
			{
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleWithTransientContainer
entryRuleWithTransientContainer returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWithTransientContainerRule()); }
	iv_ruleWithTransientContainer=ruleWithTransientContainer
	{ $current=$iv_ruleWithTransientContainer.current; }
	EOF;

// Rule WithTransientContainer
ruleWithTransientContainer returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getWithTransientContainerAccess().getChildWithTransientParserRuleCall_0());
			}
			lv_child_0_0=ruleWithTransient
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getWithTransientContainerRule());
				}
				set(
					$current,
					"child",
					lv_child_0_0,
					"org.eclipse.xtext.ide.tests.testlanguage.PartialSerializationTestLanguage.WithTransient");
				afterParserOrEnumRuleCall();
			}
		)
	)
;

// Entry rule entryRuleWithTransient
entryRuleWithTransient returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getWithTransientRule()); }
	iv_ruleWithTransient=ruleWithTransient
	{ $current=$iv_ruleWithTransient.current; }
	EOF;

// Rule WithTransient
ruleWithTransient returns [EObject current=null]
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
				newLeafNode(lv_name_0_0, grammarAccess.getWithTransientAccess().getNameIDTerminalRuleCall_0());
			}
			{
				if ($current==null) {
					$current = createModelElement(grammarAccess.getWithTransientRule());
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

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
