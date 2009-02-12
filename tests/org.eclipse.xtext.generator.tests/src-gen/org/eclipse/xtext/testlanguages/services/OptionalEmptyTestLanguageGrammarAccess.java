/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import com.google.inject.Singleton;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

@Singleton
public class OptionalEmptyTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Assignment cAssignmentChild = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallGreeting = (RuleCall)cAssignmentChild.eContents().get(0);
		
		// Model:   (child=Greeting)?;
		public ParserRule getRule() { return rule; }

		// (child=Greeting)?
		public Assignment eleAssignmentChild() { return cAssignmentChild; }

		// Greeting
		public RuleCall ele0ParserRuleCallGreeting() { return c0ParserRuleCallGreeting; }
	}

	public class GreetingElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Greeting");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordHallo = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// Greeting:   "hallo" name=ID;
		public ParserRule getRule() { return rule; }

		// "hallo" name=ID
		public Group eleGroup() { return cGroup; }

		// "hallo"
		public Keyword ele0KeywordHallo() { return c0KeywordHallo; }

		// name=ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}
	
	public final static OptionalEmptyTestLanguageGrammarAccess INSTANCE = new OptionalEmptyTestLanguageGrammarAccess();

	private static final String OPTIONALEMPTYTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;
	private static GreetingElements pGreeting;
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
			GRAMMAR = (Grammar) loadGrammarFile(OptionalEmptyTestLanguageGrammarAccess.class.getClassLoader(),OPTIONALEMPTYTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}

	
	// Model:   (child=Greeting)?;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Greeting:   "hallo" name=ID;
	public GreetingElements prGreeting() {
		return (pGreeting != null) ? pGreeting : (pGreeting = new GreetingElements());
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
