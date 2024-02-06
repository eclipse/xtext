/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
parser grammar InternalIndentationAwareTestLanguageParser;

options {
	tokenVocab=InternalIndentationAwareTestLanguageLexer;
	superClass=AbstractInternalAntlrParser;
}

@header {
package org.eclipse.xtext.parser.indentation.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.parser.indentation.services.IndentationAwareTestLanguageGrammarAccess;

}

@members {

 	private IndentationAwareTestLanguageGrammarAccess grammarAccess;

    public InternalIndentationAwareTestLanguageParser(TokenStream input, IndentationAwareTestLanguageGrammarAccess grammarAccess) {
        this(input);
        this.grammarAccess = grammarAccess;
        registerRules(grammarAccess.getGrammar());
    }

    @Override
    protected String getFirstRuleName() {
    	return "Tree";
   	}

   	@Override
   	protected IndentationAwareTestLanguageGrammarAccess getGrammarAccess() {
   		return grammarAccess;
   	}

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleTree
entryRuleTree returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTreeRule()); }
	iv_ruleTree=ruleTree
	{ $current=$iv_ruleTree.current; }
	EOF;

// Rule Tree
ruleTree returns [EObject current=null]
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
					grammarAccess.getTreeAccess().getTreeAction_0(),
					$current);
			}
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getTreeAccess().getNodesTreeNodeParserRuleCall_1_0());
				}
				lv_nodes_1_0=ruleTreeNode
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTreeRule());
					}
					add(
						$current,
						"nodes",
						lv_nodes_1_0,
						"org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage.TreeNode");
					afterParserOrEnumRuleCall();
				}
			)
		)*
		(
			(
				{
					newCompositeNode(grammarAccess.getTreeAccess().getMoreNodesOtherTreeNodeParserRuleCall_2_0());
				}
				lv_moreNodes_2_0=ruleOtherTreeNode
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getTreeRule());
					}
					add(
						$current,
						"moreNodes",
						lv_moreNodes_2_0,
						"org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage.OtherTreeNode");
					afterParserOrEnumRuleCall();
				}
			)
		)*
	)
;

// Entry rule entryRuleTreeNode
entryRuleTreeNode returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getTreeNodeRule()); }
	iv_ruleTreeNode=ruleTreeNode
	{ $current=$iv_ruleTreeNode.current; }
	EOF;

// Rule TreeNode
ruleTreeNode returns [EObject current=null]
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
					newLeafNode(lv_name_0_0, grammarAccess.getTreeNodeAccess().getNameIDTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getTreeNodeRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			this_INDENT_1=RULE_INDENT
			{
				newLeafNode(this_INDENT_1, grammarAccess.getTreeNodeAccess().getINDENTTerminalRuleCall_1_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0());
					}
					lv_children_2_0=ruleTreeNode
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getTreeNodeRule());
						}
						add(
							$current,
							"children",
							lv_children_2_0,
							"org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage.TreeNode");
						afterParserOrEnumRuleCall();
					}
				)
			)*
			this_DEDENT_3=RULE_DEDENT
			{
				newLeafNode(this_DEDENT_3, grammarAccess.getTreeNodeAccess().getDEDENTTerminalRuleCall_1_2());
			}
		)?
	)
;

// Entry rule entryRuleOtherTreeNode
entryRuleOtherTreeNode returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getOtherTreeNodeRule()); }
	iv_ruleOtherTreeNode=ruleOtherTreeNode
	{ $current=$iv_ruleOtherTreeNode.current; }
	EOF;

// Rule OtherTreeNode
ruleOtherTreeNode returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				lv_name_0_0=RULE_STRING
				{
					newLeafNode(lv_name_0_0, grammarAccess.getOtherTreeNodeAccess().getNameSTRINGTerminalRuleCall_0_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getOtherTreeNodeRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_0_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		(
			(
				{
					newCompositeNode(grammarAccess.getOtherTreeNodeAccess().getChildListChildListParserRuleCall_1_0());
				}
				lv_childList_1_0=ruleChildList
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getOtherTreeNodeRule());
					}
					set(
						$current,
						"childList",
						lv_childList_1_0,
						"org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage.ChildList");
					afterParserOrEnumRuleCall();
				}
			)
		)?
	)
;

// Entry rule entryRuleChildList
entryRuleChildList returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getChildListRule()); }
	iv_ruleChildList=ruleChildList
	{ $current=$iv_ruleChildList.current; }
	EOF;

// Rule ChildList
ruleChildList returns [EObject current=null]
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
					grammarAccess.getChildListAccess().getChildListAction_0(),
					$current);
			}
		)
		this_INDENT_1=RULE_INDENT
		{
			newLeafNode(this_INDENT_1, grammarAccess.getChildListAccess().getINDENTTerminalRuleCall_1());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getChildListAccess().getChildrenOtherTreeNodeParserRuleCall_2_0());
				}
				lv_children_2_0=ruleOtherTreeNode
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getChildListRule());
					}
					add(
						$current,
						"children",
						lv_children_2_0,
						"org.eclipse.xtext.parser.indentation.IndentationAwareTestLanguage.OtherTreeNode");
					afterParserOrEnumRuleCall();
				}
			)
		)+
		this_DEDENT_3=RULE_DEDENT
		{
			newLeafNode(this_DEDENT_3, grammarAccess.getChildListAccess().getDEDENTTerminalRuleCall_3());
		}
	)
;
