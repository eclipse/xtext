/*
Generated with Xtext
*/

package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class AbstractTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class InheritedParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordElement = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// InheritedParserRule returns AType : 'element' name = ID ;
		public ParserRule getRule() { return rule; }

		// 'element' name = ID
		public Group eleGroup() { return cGroup; }

		// 'element'
		public Keyword ele0KeywordElement() { return c0KeywordElement; }

		// name = ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
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

	
	// InheritedParserRule returns AType : 'element' name = ID ;
	public InheritedParserRuleElements prInheritedParserRule() {
		return (pInheritedParserRule != null) ? pInheritedParserRule : (pInheritedParserRule = new InheritedParserRuleElements());
	} 

	// lexer REAL returns EDouble : "RULE_INT '.' RULE_INT" ;
	public LexerRule lrREAL() {
		return (lREAL != null) ? lREAL : (lREAL = (LexerRule) getGrammar().eContents().get(3));
	} 

	// lexer ID : "('^')?('a'..'z'|'A'..'Z'|'ö'|'ä'|'ü'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*" ;
	public LexerRule lrID() {
		return (lID != null) ? lID : (lID = (LexerRule) getGrammar().eContents().get(4));
	} 
}
