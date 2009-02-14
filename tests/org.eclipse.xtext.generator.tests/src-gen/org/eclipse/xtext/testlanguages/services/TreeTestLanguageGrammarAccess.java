/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class TreeTestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Assignment cAssignmentChildren = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallNode = (RuleCall)cAssignmentChildren.eContents().get(0);
		
		// Model:   (children+=Node)*;
		public ParserRule getRule() { return rule; }

		// (children+=Node)*
		public Assignment eleAssignmentChildren() { return cAssignmentChildren; }

		// Node
		public RuleCall ele0ParserRuleCallNode() { return c0ParserRuleCallNode; }
	}

	public class NodeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Node");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Group c0000Group = (Group)c000Group.eContents().get(0);
		private final Group c00000Group = (Group)c0000Group.eContents().get(0);
		private final Assignment c000000AssignmentName = (Assignment)c00000Group.eContents().get(0);
		private final RuleCall c0000000LexerRuleCallID = (RuleCall)c000000AssignmentName.eContents().get(0);
		private final Keyword c000001KeywordLeftParenthesis = (Keyword)c00000Group.eContents().get(1);
		private final Assignment c00001AssignmentAttrib = (Assignment)c0000Group.eContents().get(1);
		private final RuleCall c000010LexerRuleCallSTRING = (RuleCall)c00001AssignmentAttrib.eContents().get(0);
		private final Keyword c0001KeywordRightParenthesis = (Keyword)c000Group.eContents().get(1);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentChildren = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallNode = (RuleCall)c01AssignmentChildren.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracketSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// Node:   name=ID "(" attrib=STRING ")" "{" (children+=Node)* "};";
		public ParserRule getRule() { return rule; }

		// name=ID "(" attrib=STRING ")" "{" (children+=Node)* "};"
		public Group eleGroup() { return cGroup; }

		// name=ID "(" attrib=STRING ")" "{" (children+=Node)*
		public Group ele0Group() { return c0Group; }

		// name=ID "(" attrib=STRING ")" "{"
		public Group ele00Group() { return c00Group; }

		// name=ID "(" attrib=STRING ")"
		public Group ele000Group() { return c000Group; }

		// name=ID "(" attrib=STRING
		public Group ele0000Group() { return c0000Group; }

		// name=ID "("
		public Group ele00000Group() { return c00000Group; }

		// name=ID
		public Assignment ele000000AssignmentName() { return c000000AssignmentName; }

		// ID
		public RuleCall ele0000000LexerRuleCallID() { return c0000000LexerRuleCallID; }

		// "("
		public Keyword ele000001KeywordLeftParenthesis() { return c000001KeywordLeftParenthesis; }

		// attrib=STRING
		public Assignment ele00001AssignmentAttrib() { return c00001AssignmentAttrib; }

		// STRING
		public RuleCall ele000010LexerRuleCallSTRING() { return c000010LexerRuleCallSTRING; }

		// ")"
		public Keyword ele0001KeywordRightParenthesis() { return c0001KeywordRightParenthesis; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (children+=Node)*
		public Assignment ele01AssignmentChildren() { return c01AssignmentChildren; }

		// Node
		public RuleCall ele010ParserRuleCallNode() { return c010ParserRuleCallNode; }

		// "};"
		public Keyword ele1KeywordRightCurlyBracketSemicolon() { return c1KeywordRightCurlyBracketSemicolon; }
	}
	
	private ModelElements pModel;
	private NodeElements pNode;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public TreeTestLanguageGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// Model:   (children+=Node)*;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Node:   name=ID "(" attrib=STRING ")" "{" (children+=Node)* "};";
	public NodeElements prNode() {
		return (pNode != null) ? pNode : (pNode = new NodeElements());
	} 

	// lexer ID:   "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*";
	public LexerRule lrID() {
		return superGrammarAccess.lrID();
	} 

	// lexer INT returns EInt:   "(\'0\'..\'9\')+";
	public LexerRule lrINT() {
		return superGrammarAccess.lrINT();
	} 

	// lexer STRING:   "\n\t\t\t  \'\"\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\"\') )* \'\"\' | \n              \'\\\'\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\\\'\') )* \'\\\'\'\n              ";
	public LexerRule lrSTRING() {
		return superGrammarAccess.lrSTRING();
	} 

	// lexer ML_COMMENT:   "\'/*\' ( options {greedy=false;} : . )* \'*/\'";
	public LexerRule lrML_COMMENT() {
		return superGrammarAccess.lrML_COMMENT();
	} 

	// lexer SL_COMMENT:   "\'//\' ~(\'\\n\'|\'\\r\')* (\'\\r\'? \'\\n\')?";
	public LexerRule lrSL_COMMENT() {
		return superGrammarAccess.lrSL_COMMENT();
	} 

	// lexer WS:   "(\' \'|\'\\t\'|\'\\r\'|\'\\n\')+";
	public LexerRule lrWS() {
		return superGrammarAccess.lrWS();
	} 

	// lexer ANY_OTHER:   ".";
	public LexerRule lrANY_OTHER() {
		return superGrammarAccess.lrANY_OTHER();
	} 
}
