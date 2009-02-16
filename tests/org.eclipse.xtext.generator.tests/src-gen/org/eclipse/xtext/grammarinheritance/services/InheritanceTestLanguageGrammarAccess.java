/*
Generated with Xtext
*/

package org.eclipse.xtext.grammarinheritance.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.grammarinheritance.services.BaseInheritanceTestLanguageGrammarAccess;

@Singleton
public class InheritanceTestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Group c000Group = (Group)c00Group.eContents().get(0);
		private final Keyword c0000KeywordModel = (Keyword)c000Group.eContents().get(0);
		private final Assignment c0001AssignmentName = (Assignment)c000Group.eContents().get(1);
		private final RuleCall c00010LexerRuleCallID = (RuleCall)c0001AssignmentName.eContents().get(0);
		private final Keyword c001KeywordLeftCurlyBracket = (Keyword)c00Group.eContents().get(1);
		private final Assignment c01AssignmentElements = (Assignment)c0Group.eContents().get(1);
		private final RuleCall c010ParserRuleCallElement = (RuleCall)c01AssignmentElements.eContents().get(0);
		private final Keyword c1KeywordRightCurlyBracket = (Keyword)cGroup.eContents().get(1);
		
		// Model:   "model" name=ID "{" (elements+=Element)* "}";
		public ParserRule getRule() { return rule; }

		// "model" name=ID "{" (elements+=Element)* "}"
		public Group eleGroup() { return cGroup; }

		// "model" name=ID "{" (elements+=Element)*
		public Group ele0Group() { return c0Group; }

		// "model" name=ID "{"
		public Group ele00Group() { return c00Group; }

		// "model" name=ID
		public Group ele000Group() { return c000Group; }

		// "model"
		public Keyword ele0000KeywordModel() { return c0000KeywordModel; }

		// name=ID
		public Assignment ele0001AssignmentName() { return c0001AssignmentName; }

		// ID
		public RuleCall ele00010LexerRuleCallID() { return c00010LexerRuleCallID; }

		// "{"
		public Keyword ele001KeywordLeftCurlyBracket() { return c001KeywordLeftCurlyBracket; }

		// (elements+=Element)*
		public Assignment ele01AssignmentElements() { return c01AssignmentElements; }

		// Element
		public RuleCall ele010ParserRuleCallElement() { return c010ParserRuleCallElement; }

		// "}"
		public Keyword ele1KeywordRightCurlyBracket() { return c1KeywordRightCurlyBracket; }
	}

	public class ElementElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Element");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordElement = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// Element:   "element" name=ID;
		public ParserRule getRule() { return rule; }

		// "element" name=ID
		public Group eleGroup() { return cGroup; }

		// "element"
		public Keyword ele0KeywordElement() { return c0KeywordElement; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}
	
	private ModelElements pModel;
	private ElementElements pElement;
	
	private final GrammarProvider grammarProvider;

	private BaseInheritanceTestLanguageGrammarAccess superGrammarAccess;

	@Inject
	public InheritanceTestLanguageGrammarAccess(GrammarProvider grammarProvider, BaseInheritanceTestLanguageGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public BaseInheritanceTestLanguageGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// Model:   "model" name=ID "{" (elements+=Element)* "}";
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Element:   "element" name=ID;
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
