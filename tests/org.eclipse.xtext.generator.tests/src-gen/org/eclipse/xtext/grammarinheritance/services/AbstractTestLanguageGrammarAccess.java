/*
Generated with Xtext
*/

package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class AbstractTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class InheritedParserRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Keyword c0KeywordElement;
		private Assignment c1AssignmentName;
		private RuleCall c10LexerRuleCallID;
		
		// InheritedParserRule returns mm :: AType : 'element' name = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// 'element' name = ID
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// 'element'
		public Keyword ele0KeywordElement() {
			return (c0KeywordElement != null) ? c0KeywordElement : (c0KeywordElement = (Keyword)eleGroup().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele1AssignmentName() {
			return (c1AssignmentName != null) ? c1AssignmentName : (c1AssignmentName = (Assignment)eleGroup().eContents().get(1)); 
		}

		// ID
		public RuleCall ele10LexerRuleCallID() {
			return (c10LexerRuleCallID != null) ? c10LexerRuleCallID : (c10LexerRuleCallID = (RuleCall)ele1AssignmentName().eContents().get(0)); 
		}
	}
	
	public final static AbstractTestLanguageGrammarAccess INSTANCE = new AbstractTestLanguageGrammarAccess();

	private static final String ABSTRACTTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/grammarinheritance/AbstractTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static InheritedParserRuleElements pInheritedParserRule;
	private static LexerRule lREAL;
	private static LexerRule lID;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(AbstractTestLanguageGrammarAccess.class.getClassLoader(),ABSTRACTTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// InheritedParserRule returns mm :: AType : 'element' name = ID ;
	public InheritedParserRuleElements prInheritedParserRule() {
		return (pInheritedParserRule != null) ? pInheritedParserRule : (pInheritedParserRule = new InheritedParserRuleElements());
	} 

	// lexer REAL returns ecore :: EDouble : "RULE_INT '.' RULE_INT" ;
	public LexerRule lrREAL() {
		return (lREAL != null) ? lREAL : (lREAL = (LexerRule) getGrammar().eContents().get(3));
	} 

	// lexer ID : "('^')?('a'..'z'|'A'..'Z'|'ö'|'ä'|'ü'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*" ;
	public LexerRule lrID() {
		return (lID != null) ? lID : (lID = (LexerRule) getGrammar().eContents().get(4));
	} 
}
