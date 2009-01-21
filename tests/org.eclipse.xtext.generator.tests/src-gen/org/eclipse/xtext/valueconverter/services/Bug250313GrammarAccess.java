/*
Generated with Xtext
*/

package org.eclipse.xtext.valueconverter.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class Bug250313GrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class Ref2Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordNumberSignDigitTwo = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentRef2 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives c10Alternatives = (Alternatives)c1AssignmentRef2.eContents().get(0);
		private final Alternatives c100Alternatives = (Alternatives)c10Alternatives.eContents().get(0);
		private final Keyword c1000KeywordMykeyword1 = (Keyword)c100Alternatives.eContents().get(0);
		private final RuleCall c1001LexerRuleCallSTRING = (RuleCall)c100Alternatives.eContents().get(1);
		private final RuleCall c101LexerRuleCallID = (RuleCall)c10Alternatives.eContents().get(1);
		
		// Ref2 : "#2" ref2 = ( "mykeyword1" | STRING | ID ) ;
		public ParserRule getRule() { return rule; }

		// "#2" ref2 = ( "mykeyword1" | STRING | ID )
		public Group eleGroup() { return cGroup; }

		// "#2"
		public Keyword ele0KeywordNumberSignDigitTwo() { return c0KeywordNumberSignDigitTwo; }

		// ref2 = ( "mykeyword1" | STRING | ID )
		public Assignment ele1AssignmentRef2() { return c1AssignmentRef2; }

		// "mykeyword1" | STRING | ID
		public Alternatives ele10Alternatives() { return c10Alternatives; }

		// "mykeyword1" | STRING
		public Alternatives ele100Alternatives() { return c100Alternatives; }

		// "mykeyword1"
		public Keyword ele1000KeywordMykeyword1() { return c1000KeywordMykeyword1; }

		// STRING
		public RuleCall ele1001LexerRuleCallSTRING() { return c1001LexerRuleCallSTRING; }

		// ID
		public RuleCall ele101LexerRuleCallID() { return c101LexerRuleCallID; }
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

	
	// Ref2 : "#2" ref2 = ( "mykeyword1" | STRING | ID ) ;
	public Ref2Elements prRef2() {
		return (pRef2 != null) ? pRef2 : (pRef2 = new Ref2Elements());
	} 
}
