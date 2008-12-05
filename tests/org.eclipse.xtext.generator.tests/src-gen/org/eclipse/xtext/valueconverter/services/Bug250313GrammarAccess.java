/*
Generated with Xtext
*/

package org.eclipse.xtext.valueconverter.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class Bug250313GrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class Ref2Elements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Keyword c0Keyword;
		private Assignment c1AssignmentRef2;
		private Alternatives c10Alternatives;
		private Alternatives c100Alternatives;
		private Keyword c1000KeywordMykeyword1;
		private RuleCall c1001LexerRuleCallSTRING;
		private RuleCall c101LexerRuleCallID;
		
		// Ref2 : '#2' ref2 = ( 'mykeyword1' | STRING | ID ) ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// '#2' ref2 = ( 'mykeyword1' | STRING | ID )
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// '#2'
		public Keyword ele0Keyword() {
			return (c0Keyword != null) ? c0Keyword : (c0Keyword = (Keyword)eleGroup().eContents().get(0)); 
		}

		// ref2 = ( 'mykeyword1' | STRING | ID )
		public Assignment ele1AssignmentRef2() {
			return (c1AssignmentRef2 != null) ? c1AssignmentRef2 : (c1AssignmentRef2 = (Assignment)eleGroup().eContents().get(1)); 
		}

		// 'mykeyword1' | STRING | ID
		public Alternatives ele10Alternatives() {
			return (c10Alternatives != null) ? c10Alternatives : (c10Alternatives = (Alternatives)ele1AssignmentRef2().eContents().get(0)); 
		}

		// 'mykeyword1' | STRING
		public Alternatives ele100Alternatives() {
			return (c100Alternatives != null) ? c100Alternatives : (c100Alternatives = (Alternatives)ele10Alternatives().eContents().get(0)); 
		}

		// 'mykeyword1'
		public Keyword ele1000KeywordMykeyword1() {
			return (c1000KeywordMykeyword1 != null) ? c1000KeywordMykeyword1 : (c1000KeywordMykeyword1 = (Keyword)ele100Alternatives().eContents().get(0)); 
		}

		// STRING
		public RuleCall ele1001LexerRuleCallSTRING() {
			return (c1001LexerRuleCallSTRING != null) ? c1001LexerRuleCallSTRING : (c1001LexerRuleCallSTRING = (RuleCall)ele100Alternatives().eContents().get(1)); 
		}

		// ID
		public RuleCall ele101LexerRuleCallID() {
			return (c101LexerRuleCallID != null) ? c101LexerRuleCallID : (c101LexerRuleCallID = (RuleCall)ele10Alternatives().eContents().get(1)); 
		}
	}
	
	public final static Bug250313GrammarAccess INSTANCE = new Bug250313GrammarAccess();

	private static final String BUG250313_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/valueconverter/Bug250313.xmi";
	private static Grammar GRAMMAR = null;
	private static Ref2Elements pRef2;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(Bug250313GrammarAccess.class.getClassLoader(),BUG250313_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Ref2 : '#2' ref2 = ( 'mykeyword1' | STRING | ID ) ;
	public Ref2Elements prRef2() {
		return (pRef2 != null) ? pRef2 : (pRef2 = new Ref2Elements());
	} 
}
