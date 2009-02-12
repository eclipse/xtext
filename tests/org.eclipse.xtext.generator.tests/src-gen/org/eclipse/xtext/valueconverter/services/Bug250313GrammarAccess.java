/*
Generated with Xtext
*/

package org.eclipse.xtext.valueconverter.services;

import com.google.inject.Singleton;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

@Singleton
public class Bug250313GrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class Ref2Elements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Ref2");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordNumberSignDigitTwo = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentRef2 = (Assignment)cGroup.eContents().get(1);
		private final Alternatives c10Alternatives = (Alternatives)c1AssignmentRef2.eContents().get(0);
		private final Alternatives c100Alternatives = (Alternatives)c10Alternatives.eContents().get(0);
		private final Keyword c1000KeywordMykeyword1 = (Keyword)c100Alternatives.eContents().get(0);
		private final RuleCall c1001LexerRuleCallSTRING = (RuleCall)c100Alternatives.eContents().get(1);
		private final RuleCall c101LexerRuleCallID = (RuleCall)c10Alternatives.eContents().get(1);
		
		// Ref2:   "#2" ref2=("mykeyword1"|STRING|ID);
		public ParserRule getRule() { return rule; }

		// "#2" ref2=("mykeyword1"|STRING|ID)
		public Group eleGroup() { return cGroup; }

		// "#2"
		public Keyword ele0KeywordNumberSignDigitTwo() { return c0KeywordNumberSignDigitTwo; }

		// ref2=("mykeyword1"|STRING|ID)
		public Assignment ele1AssignmentRef2() { return c1AssignmentRef2; }

		// "mykeyword1"|STRING|ID
		public Alternatives ele10Alternatives() { return c10Alternatives; }

		// "mykeyword1"|STRING
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
	private static LexerRule lID;
	private static LexerRule lINT;
	private static LexerRule lSTRING;
	private static LexerRule lML_COMMENT;
	private static LexerRule lSL_COMMENT;
	private static LexerRule lWS;
	private static LexerRule lANY_OTHER;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(Bug250313GrammarAccess.class.getClassLoader(),BUG250313_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}

	
	// Ref2:   "#2" ref2=("mykeyword1"|STRING|ID);
	public Ref2Elements prRef2() {
		return (pRef2 != null) ? pRef2 : (pRef2 = new Ref2Elements());
	} 

	// lexer ID:   "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*";
	public LexerRule lrID() {
		return (lID != null) ? lID : (lID = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ID"));
	} 

	// lexer INT returns EInt:   "(\'0\'..\'9\')+";
	public LexerRule lrINT() {
		return (lINT != null) ? lINT : (lINT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "INT"));
	} 

	// lexer STRING:   "\n\t\t\t  \'\"\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\"\') )* \'\"\' | \n              \'\\\'\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\\\'\') )* \'\\\'\'\n              ";
	public LexerRule lrSTRING() {
		return (lSTRING != null) ? lSTRING : (lSTRING = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "STRING"));
	} 

	// lexer ML_COMMENT:   "\'/*\' ( options {greedy=false;} : . )* \'*/\'";
	public LexerRule lrML_COMMENT() {
		return (lML_COMMENT != null) ? lML_COMMENT : (lML_COMMENT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ML_COMMENT"));
	} 

	// lexer SL_COMMENT:   "\'//\' ~(\'\\n\'|\'\\r\')* (\'\\r\'? \'\\n\')?";
	public LexerRule lrSL_COMMENT() {
		return (lSL_COMMENT != null) ? lSL_COMMENT : (lSL_COMMENT = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "SL_COMMENT"));
	} 

	// lexer WS:   "(\' \'|\'\\t\'|\'\\r\'|\'\\n\')+";
	public LexerRule lrWS() {
		return (lWS != null) ? lWS : (lWS = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "WS"));
	} 

	// lexer ANY_OTHER:   ".";
	public LexerRule lrANY_OTHER() {
		return (lANY_OTHER != null) ? lANY_OTHER : (lANY_OTHER = (LexerRule) GrammarUtil.findRuleForName(getGrammar(), "ANY_OTHER"));
	} 
}
