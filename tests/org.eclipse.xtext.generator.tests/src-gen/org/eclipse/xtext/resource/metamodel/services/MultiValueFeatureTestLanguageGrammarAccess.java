/*
Generated with Xtext
*/

package org.eclipse.xtext.resource.metamodel.services;

import com.google.inject.Singleton;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;

@Singleton
public class MultiValueFeatureTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class StartElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Start");
		private final Assignment cAssignmentFeatureA = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cAssignmentFeatureA.eContents().get(0);
		
		// Start:   (featureA+=ID)+;
		public ParserRule getRule() { return rule; }

		// (featureA+=ID)+
		public Assignment eleAssignmentFeatureA() { return cAssignmentFeatureA; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }
	}
	
	public final static MultiValueFeatureTestLanguageGrammarAccess INSTANCE = new MultiValueFeatureTestLanguageGrammarAccess();

	private static final String MULTIVALUEFEATURETESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/resource/metamodel/MultiValueFeatureTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static StartElements pStart;
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
			GRAMMAR = (Grammar) loadGrammarFile(MultiValueFeatureTestLanguageGrammarAccess.class.getClassLoader(),MULTIVALUEFEATURETESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}

	
	// Start:   (featureA+=ID)+;
	public StartElements prStart() {
		return (pStart != null) ? pStart : (pStart = new StartElements());
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
