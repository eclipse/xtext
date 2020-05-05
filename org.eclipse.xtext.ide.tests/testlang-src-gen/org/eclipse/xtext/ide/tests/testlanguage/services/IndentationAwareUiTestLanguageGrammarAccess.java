/*
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.tests.testlanguage.services;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.List;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.common.services.TerminalsGrammarAccess;
import org.eclipse.xtext.service.AbstractElementFinder;
import org.eclipse.xtext.service.GrammarProvider;

@Singleton
public class IndentationAwareUiTestLanguageGrammarAccess extends AbstractElementFinder.AbstractGrammarElementFinder {
	
	public class TreeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.IndentationAwareUiTestLanguage.Tree");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cTreeAction_0 = (Action)cGroup.eContents().get(0);
		private final Assignment cNodesAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNodesTreeNodeParserRuleCall_1_0 = (RuleCall)cNodesAssignment_1.eContents().get(0);
		private final Assignment cMoreNodesAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cMoreNodesOtherTreeNodeParserRuleCall_2_0 = (RuleCall)cMoreNodesAssignment_2.eContents().get(0);
		
		//Tree:
		//	{Tree} nodes+=TreeNode*
		//	moreNodes+=OtherTreeNode*;
		@Override public ParserRule getRule() { return rule; }
		
		//{Tree} nodes+=TreeNode* moreNodes+=OtherTreeNode*
		public Group getGroup() { return cGroup; }
		
		//{Tree}
		public Action getTreeAction_0() { return cTreeAction_0; }
		
		//nodes+=TreeNode*
		public Assignment getNodesAssignment_1() { return cNodesAssignment_1; }
		
		//TreeNode
		public RuleCall getNodesTreeNodeParserRuleCall_1_0() { return cNodesTreeNodeParserRuleCall_1_0; }
		
		//moreNodes+=OtherTreeNode*
		public Assignment getMoreNodesAssignment_2() { return cMoreNodesAssignment_2; }
		
		//OtherTreeNode
		public RuleCall getMoreNodesOtherTreeNodeParserRuleCall_2_0() { return cMoreNodesOtherTreeNodeParserRuleCall_2_0; }
	}
	public class TreeNodeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.IndentationAwareUiTestLanguage.TreeNode");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameIDTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Group cGroup_1 = (Group)cGroup.eContents().get(1);
		private final RuleCall cINDENTTerminalRuleCall_1_0 = (RuleCall)cGroup_1.eContents().get(0);
		private final Assignment cChildrenAssignment_1_1 = (Assignment)cGroup_1.eContents().get(1);
		private final RuleCall cChildrenTreeNodeParserRuleCall_1_1_0 = (RuleCall)cChildrenAssignment_1_1.eContents().get(0);
		private final RuleCall cDEDENTTerminalRuleCall_1_2 = (RuleCall)cGroup_1.eContents().get(2);
		
		//TreeNode:
		//	name=ID (INDENT
		//	children+=TreeNode*
		//	DEDENT)?;
		@Override public ParserRule getRule() { return rule; }
		
		//name=ID (INDENT children+=TreeNode* DEDENT)?
		public Group getGroup() { return cGroup; }
		
		//name=ID
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//ID
		public RuleCall getNameIDTerminalRuleCall_0_0() { return cNameIDTerminalRuleCall_0_0; }
		
		//(INDENT children+=TreeNode* DEDENT)?
		public Group getGroup_1() { return cGroup_1; }
		
		//INDENT
		public RuleCall getINDENTTerminalRuleCall_1_0() { return cINDENTTerminalRuleCall_1_0; }
		
		//children+=TreeNode*
		public Assignment getChildrenAssignment_1_1() { return cChildrenAssignment_1_1; }
		
		//TreeNode
		public RuleCall getChildrenTreeNodeParserRuleCall_1_1_0() { return cChildrenTreeNodeParserRuleCall_1_1_0; }
		
		//DEDENT
		public RuleCall getDEDENTTerminalRuleCall_1_2() { return cDEDENTTerminalRuleCall_1_2; }
	}
	public class OtherTreeNodeElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.IndentationAwareUiTestLanguage.OtherTreeNode");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment cNameAssignment_0 = (Assignment)cGroup.eContents().get(0);
		private final RuleCall cNameSTRINGTerminalRuleCall_0_0 = (RuleCall)cNameAssignment_0.eContents().get(0);
		private final Assignment cChildListAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cChildListChildListParserRuleCall_1_0 = (RuleCall)cChildListAssignment_1.eContents().get(0);
		
		//OtherTreeNode:
		//	name=STRING
		//	childList=ChildList?;
		@Override public ParserRule getRule() { return rule; }
		
		//name=STRING childList=ChildList?
		public Group getGroup() { return cGroup; }
		
		//name=STRING
		public Assignment getNameAssignment_0() { return cNameAssignment_0; }
		
		//STRING
		public RuleCall getNameSTRINGTerminalRuleCall_0_0() { return cNameSTRINGTerminalRuleCall_0_0; }
		
		//childList=ChildList?
		public Assignment getChildListAssignment_1() { return cChildListAssignment_1; }
		
		//ChildList
		public RuleCall getChildListChildListParserRuleCall_1_0() { return cChildListChildListParserRuleCall_1_0; }
	}
	public class ChildListElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.IndentationAwareUiTestLanguage.ChildList");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Action cChildListAction_0 = (Action)cGroup.eContents().get(0);
		private final RuleCall cINDENTTerminalRuleCall_1 = (RuleCall)cGroup.eContents().get(1);
		private final Assignment cChildrenAssignment_2 = (Assignment)cGroup.eContents().get(2);
		private final RuleCall cChildrenOtherTreeNodeParserRuleCall_2_0 = (RuleCall)cChildrenAssignment_2.eContents().get(0);
		private final RuleCall cDEDENTTerminalRuleCall_3 = (RuleCall)cGroup.eContents().get(3);
		
		//ChildList:
		//	{ChildList} INDENT
		//	children+=OtherTreeNode+
		//	DEDENT;
		@Override public ParserRule getRule() { return rule; }
		
		//{ChildList} INDENT children+=OtherTreeNode+ DEDENT
		public Group getGroup() { return cGroup; }
		
		//{ChildList}
		public Action getChildListAction_0() { return cChildListAction_0; }
		
		//INDENT
		public RuleCall getINDENTTerminalRuleCall_1() { return cINDENTTerminalRuleCall_1; }
		
		//children+=OtherTreeNode+
		public Assignment getChildrenAssignment_2() { return cChildrenAssignment_2; }
		
		//OtherTreeNode
		public RuleCall getChildrenOtherTreeNodeParserRuleCall_2_0() { return cChildrenOtherTreeNodeParserRuleCall_2_0; }
		
		//DEDENT
		public RuleCall getDEDENTTerminalRuleCall_3() { return cDEDENTTerminalRuleCall_3; }
	}
	
	
	private final TreeElements pTree;
	private final TreeNodeElements pTreeNode;
	private final OtherTreeNodeElements pOtherTreeNode;
	private final ChildListElements pChildList;
	private final TerminalRule tSL_COMMENT;
	private final TerminalRule tINDENT;
	private final TerminalRule tDEDENT;
	
	private final Grammar grammar;
	
	private final TerminalsGrammarAccess gaTerminals;

	@Inject
	public IndentationAwareUiTestLanguageGrammarAccess(GrammarProvider grammarProvider,
			TerminalsGrammarAccess gaTerminals) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.gaTerminals = gaTerminals;
		this.pTree = new TreeElements();
		this.pTreeNode = new TreeNodeElements();
		this.pOtherTreeNode = new OtherTreeNodeElements();
		this.pChildList = new ChildListElements();
		this.tSL_COMMENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.IndentationAwareUiTestLanguage.SL_COMMENT");
		this.tINDENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.IndentationAwareUiTestLanguage.INDENT");
		this.tDEDENT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "org.eclipse.xtext.ide.tests.testlanguage.IndentationAwareUiTestLanguage.DEDENT");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("org.eclipse.xtext.ide.tests.testlanguage.IndentationAwareUiTestLanguage".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	@Override
	public Grammar getGrammar() {
		return grammar;
	}
	
	
	public TerminalsGrammarAccess getTerminalsGrammarAccess() {
		return gaTerminals;
	}

	
	//Tree:
	//	{Tree} nodes+=TreeNode*
	//	moreNodes+=OtherTreeNode*;
	public TreeElements getTreeAccess() {
		return pTree;
	}
	
	public ParserRule getTreeRule() {
		return getTreeAccess().getRule();
	}
	
	//TreeNode:
	//	name=ID (INDENT
	//	children+=TreeNode*
	//	DEDENT)?;
	public TreeNodeElements getTreeNodeAccess() {
		return pTreeNode;
	}
	
	public ParserRule getTreeNodeRule() {
		return getTreeNodeAccess().getRule();
	}
	
	//OtherTreeNode:
	//	name=STRING
	//	childList=ChildList?;
	public OtherTreeNodeElements getOtherTreeNodeAccess() {
		return pOtherTreeNode;
	}
	
	public ParserRule getOtherTreeNodeRule() {
		return getOtherTreeNodeAccess().getRule();
	}
	
	//ChildList:
	//	{ChildList} INDENT
	//	children+=OtherTreeNode+
	//	DEDENT;
	public ChildListElements getChildListAccess() {
		return pChildList;
	}
	
	public ParserRule getChildListRule() {
		return getChildListAccess().getRule();
	}
	
	//@Override
	//terminal SL_COMMENT:
	//	'//' !('\n' | '\r')*;
	public TerminalRule getSL_COMMENTRule() {
		return tSL_COMMENT;
	}
	
	//terminal INDENT:
	//	'synthetic:INDENT';
	public TerminalRule getINDENTRule() {
		return tINDENT;
	}
	
	//terminal DEDENT:
	//	'synthetic:DEDENT';
	public TerminalRule getDEDENTRule() {
		return tDEDENT;
	}
	
	//terminal ID:
	//	'^'? ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;
	public TerminalRule getIDRule() {
		return gaTerminals.getIDRule();
	}
	
	//terminal INT returns ecore::EInt:
	//	'0'..'9'+;
	public TerminalRule getINTRule() {
		return gaTerminals.getINTRule();
	}
	
	//terminal STRING:
	//	'"' ('\\' . | !('\\' | '"'))* '"' |
	//	"'" ('\\' . | !('\\' | "'"))* "'";
	public TerminalRule getSTRINGRule() {
		return gaTerminals.getSTRINGRule();
	}
	
	//terminal ML_COMMENT:
	//	'/*'->'*/';
	public TerminalRule getML_COMMENTRule() {
		return gaTerminals.getML_COMMENTRule();
	}
	
	//terminal WS:
	//	' ' | '\t' | '\r' | '\n'+;
	public TerminalRule getWSRule() {
		return gaTerminals.getWSRule();
	}
	
	//terminal ANY_OTHER:
	//	.;
	public TerminalRule getANY_OTHERRule() {
		return gaTerminals.getANY_OTHERRule();
	}
}
