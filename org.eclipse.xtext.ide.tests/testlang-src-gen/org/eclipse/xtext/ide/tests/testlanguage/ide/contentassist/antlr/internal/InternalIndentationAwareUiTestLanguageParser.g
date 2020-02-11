/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
parser grammar InternalIndentationAwareUiTestLanguageParser;

options {
	tokenVocab=InternalIndentationAwareUiTestLanguageLexer;
	superClass=AbstractInternalContentAssistParser;
}

@header {
package org.eclipse.xtext.ide.tests.testlanguage.ide.contentassist.antlr.internal;
import java.util.Map;
import java.util.HashMap;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import org.eclipse.xtext.ide.tests.testlanguage.services.IndentationAwareUiTestLanguageGrammarAccess;

}
@members {
	private IndentationAwareUiTestLanguageGrammarAccess grammarAccess;
	private final Map<String, String> tokenNameToValue = new HashMap<String, String>();
	
	{
	}

	public void setGrammarAccess(IndentationAwareUiTestLanguageGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}

	@Override
	protected Grammar getGrammar() {
		return grammarAccess.getGrammar();
	}

	@Override
	protected String getValueForTokenName(String tokenName) {
		String result = tokenNameToValue.get(tokenName);
		if (result == null)
			result = tokenName;
		return result;
	}
}

// Entry rule entryRuleTree
entryRuleTree
:
{ before(grammarAccess.getTreeRule()); }
	 ruleTree
{ after(grammarAccess.getTreeRule()); } 
	 EOF 
;

// Rule Tree
ruleTree 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTreeAccess().getGroup()); }
		(rule__Tree__Group__0)
		{ after(grammarAccess.getTreeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleTreeNode
entryRuleTreeNode
:
{ before(grammarAccess.getTreeNodeRule()); }
	 ruleTreeNode
{ after(grammarAccess.getTreeNodeRule()); } 
	 EOF 
;

// Rule TreeNode
ruleTreeNode 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getTreeNodeAccess().getGroup()); }
		(rule__TreeNode__Group__0)
		{ after(grammarAccess.getTreeNodeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleOtherTreeNode
entryRuleOtherTreeNode
:
{ before(grammarAccess.getOtherTreeNodeRule()); }
	 ruleOtherTreeNode
{ after(grammarAccess.getOtherTreeNodeRule()); } 
	 EOF 
;

// Rule OtherTreeNode
ruleOtherTreeNode 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getOtherTreeNodeAccess().getGroup()); }
		(rule__OtherTreeNode__Group__0)
		{ after(grammarAccess.getOtherTreeNodeAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

// Entry rule entryRuleChildList
entryRuleChildList
:
{ before(grammarAccess.getChildListRule()); }
	 ruleChildList
{ after(grammarAccess.getChildListRule()); } 
	 EOF 
;

// Rule ChildList
ruleChildList 
	@init {
		int stackSize = keepStackSize();
	}
	:
	(
		{ before(grammarAccess.getChildListAccess().getGroup()); }
		(rule__ChildList__Group__0)
		{ after(grammarAccess.getChildListAccess().getGroup()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Tree__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Tree__Group__0__Impl
	rule__Tree__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__Tree__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTreeAccess().getTreeAction_0()); }
	()
	{ after(grammarAccess.getTreeAccess().getTreeAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Tree__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Tree__Group__1__Impl
	rule__Tree__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__Tree__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTreeAccess().getNodesAssignment_1()); }
	(rule__Tree__NodesAssignment_1)*
	{ after(grammarAccess.getTreeAccess().getNodesAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__Tree__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__Tree__Group__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__Tree__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTreeAccess().getMoreNodesAssignment_2()); }
	(rule__Tree__MoreNodesAssignment_2)*
	{ after(grammarAccess.getTreeAccess().getMoreNodesAssignment_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TreeNode__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TreeNode__Group__0__Impl
	rule__TreeNode__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TreeNode__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTreeNodeAccess().getNameAssignment_0()); }
	(rule__TreeNode__NameAssignment_0)
	{ after(grammarAccess.getTreeNodeAccess().getNameAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TreeNode__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TreeNode__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TreeNode__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTreeNodeAccess().getGroup_1()); }
	(rule__TreeNode__Group_1__0)?
	{ after(grammarAccess.getTreeNodeAccess().getGroup_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__TreeNode__Group_1__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TreeNode__Group_1__0__Impl
	rule__TreeNode__Group_1__1
;
finally {
	restoreStackSize(stackSize);
}

rule__TreeNode__Group_1__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTreeNodeAccess().getINDENTTerminalRuleCall_1_0()); }
	RULE_INDENT
	{ after(grammarAccess.getTreeNodeAccess().getINDENTTerminalRuleCall_1_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TreeNode__Group_1__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TreeNode__Group_1__1__Impl
	rule__TreeNode__Group_1__2
;
finally {
	restoreStackSize(stackSize);
}

rule__TreeNode__Group_1__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_1()); }
	(rule__TreeNode__ChildrenAssignment_1_1)*
	{ after(grammarAccess.getTreeNodeAccess().getChildrenAssignment_1_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__TreeNode__Group_1__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__TreeNode__Group_1__2__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__TreeNode__Group_1__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getTreeNodeAccess().getDEDENTTerminalRuleCall_1_2()); }
	RULE_DEDENT
	{ after(grammarAccess.getTreeNodeAccess().getDEDENTTerminalRuleCall_1_2()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__OtherTreeNode__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OtherTreeNode__Group__0__Impl
	rule__OtherTreeNode__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__OtherTreeNode__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOtherTreeNodeAccess().getNameAssignment_0()); }
	(rule__OtherTreeNode__NameAssignment_0)
	{ after(grammarAccess.getOtherTreeNodeAccess().getNameAssignment_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__OtherTreeNode__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__OtherTreeNode__Group__1__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__OtherTreeNode__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getOtherTreeNodeAccess().getChildListAssignment_1()); }
	(rule__OtherTreeNode__ChildListAssignment_1)?
	{ after(grammarAccess.getOtherTreeNodeAccess().getChildListAssignment_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__ChildList__Group__0
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ChildList__Group__0__Impl
	rule__ChildList__Group__1
;
finally {
	restoreStackSize(stackSize);
}

rule__ChildList__Group__0__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getChildListAccess().getChildListAction_0()); }
	()
	{ after(grammarAccess.getChildListAccess().getChildListAction_0()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChildList__Group__1
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ChildList__Group__1__Impl
	rule__ChildList__Group__2
;
finally {
	restoreStackSize(stackSize);
}

rule__ChildList__Group__1__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getChildListAccess().getINDENTTerminalRuleCall_1()); }
	RULE_INDENT
	{ after(grammarAccess.getChildListAccess().getINDENTTerminalRuleCall_1()); }
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChildList__Group__2
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ChildList__Group__2__Impl
	rule__ChildList__Group__3
;
finally {
	restoreStackSize(stackSize);
}

rule__ChildList__Group__2__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	(
		{ before(grammarAccess.getChildListAccess().getChildrenAssignment_2()); }
		(rule__ChildList__ChildrenAssignment_2)
		{ after(grammarAccess.getChildListAccess().getChildrenAssignment_2()); }
	)
	(
		{ before(grammarAccess.getChildListAccess().getChildrenAssignment_2()); }
		(rule__ChildList__ChildrenAssignment_2)*
		{ after(grammarAccess.getChildListAccess().getChildrenAssignment_2()); }
	)
)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChildList__Group__3
	@init {
		int stackSize = keepStackSize();
	}
:
	rule__ChildList__Group__3__Impl
;
finally {
	restoreStackSize(stackSize);
}

rule__ChildList__Group__3__Impl
	@init {
		int stackSize = keepStackSize();
	}
:
(
	{ before(grammarAccess.getChildListAccess().getDEDENTTerminalRuleCall_3()); }
	RULE_DEDENT
	{ after(grammarAccess.getChildListAccess().getDEDENTTerminalRuleCall_3()); }
)
;
finally {
	restoreStackSize(stackSize);
}


rule__Tree__NodesAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTreeAccess().getNodesTreeNodeParserRuleCall_1_0()); }
		ruleTreeNode
		{ after(grammarAccess.getTreeAccess().getNodesTreeNodeParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__Tree__MoreNodesAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTreeAccess().getMoreNodesOtherTreeNodeParserRuleCall_2_0()); }
		ruleOtherTreeNode
		{ after(grammarAccess.getTreeAccess().getMoreNodesOtherTreeNodeParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TreeNode__NameAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTreeNodeAccess().getNameIDTerminalRuleCall_0_0()); }
		RULE_ID
		{ after(grammarAccess.getTreeNodeAccess().getNameIDTerminalRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__TreeNode__ChildrenAssignment_1_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0()); }
		ruleTreeNode
		{ after(grammarAccess.getTreeNodeAccess().getChildrenTreeNodeParserRuleCall_1_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OtherTreeNode__NameAssignment_0
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOtherTreeNodeAccess().getNameSTRINGTerminalRuleCall_0_0()); }
		RULE_STRING
		{ after(grammarAccess.getOtherTreeNodeAccess().getNameSTRINGTerminalRuleCall_0_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__OtherTreeNode__ChildListAssignment_1
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getOtherTreeNodeAccess().getChildListChildListParserRuleCall_1_0()); }
		ruleChildList
		{ after(grammarAccess.getOtherTreeNodeAccess().getChildListChildListParserRuleCall_1_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}

rule__ChildList__ChildrenAssignment_2
	@init {
		int stackSize = keepStackSize();
	}
:
	(
		{ before(grammarAccess.getChildListAccess().getChildrenOtherTreeNodeParserRuleCall_2_0()); }
		ruleOtherTreeNode
		{ after(grammarAccess.getChildListAccess().getChildrenOtherTreeNodeParserRuleCall_2_0()); }
	)
;
finally {
	restoreStackSize(stackSize);
}
