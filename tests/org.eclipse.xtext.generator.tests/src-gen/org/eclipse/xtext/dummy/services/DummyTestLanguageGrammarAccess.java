/*
Generated with Xtext
*/

package org.eclipse.xtext.dummy.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class DummyTestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Assignment cAssignmentElements = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallElement = (RuleCall)cAssignmentElements.eContents().get(0);
		
		// Model:   (elements+=Element)*;
		public ParserRule getRule() { return rule; }

		// (elements+=Element)*
		public Assignment eleAssignmentElements() { return cAssignmentElements; }

		// Element
		public RuleCall ele0ParserRuleCallElement() { return c0ParserRuleCallElement; }
	}

	public class ElementElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Element");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Assignment c0000AssignmentOptional = (Assignment)c000Group.eContents().get(0);
		private final Keyword c00000KeywordOptional = (Keyword)c0000AssignmentOptional.eContents().get(0);
		private final Keyword c0001KeywordElement = (Keyword)c000Group.eContents().get(1);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Assignment c01AssignmentDescriptions = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010LexerRuleCallSTRING = (RuleCall)c01AssignmentDescriptions.eContents().get(0);
		private final Keyword c1KeywordSemicolon = (Keyword)cGroup.eContents().get(1);
		
		// Element:   (optional?="optional")? "element" name=ID (descriptions+=STRING)* ";";
		public ParserRule getRule() { return rule; }

		// (optional?="optional")? "element" name=ID (descriptions+=STRING)* ";"
		public Group eleGroup() { return cGroup; }

		// (optional?="optional")? "element" name=ID (descriptions+=STRING)*
		public Group ele0Group() { return c0Group; }

		// (optional?="optional")? "element" name=ID
		public Group ele00Group() { return c00Group; }

		// (optional?="optional")? "element"
		public Group ele000Group() { return c000Group; }

		// (optional?="optional")?
		public Assignment ele0000AssignmentOptional() { return c0000AssignmentOptional; }

		// "optional"
		public Keyword ele00000KeywordOptional() { return c00000KeywordOptional; }

		// "element"
		public Keyword ele0001KeywordElement() { return c0001KeywordElement; }

		// name=ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// (descriptions+=STRING)*
		public Assignment ele01AssignmentDescriptions() { return c01AssignmentDescriptions; }

		// STRING
		public RuleCall ele010LexerRuleCallSTRING() { return c010LexerRuleCallSTRING; }

		// ";"
		public Keyword ele1KeywordSemicolon() { return c1KeywordSemicolon; }
	}
	
	private ModelElements pModel;
	private ElementElements pElement;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public DummyTestLanguageGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// Model:   (elements+=Element)*;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Element:   (optional?="optional")? "element" name=ID (descriptions+=STRING)* ";";
	public ElementElements prElement() {
		return (pElement != null) ? pElement : (pElement = new ElementElements());
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
