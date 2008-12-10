/*
Generated with Xtext
*/

package org.eclipse.xtext.ui.core.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class TestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class FileElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentStuff;
		private RuleCall c0ParserRuleCallStuff;
		
		// File : ( stuff += Stuff ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// ( stuff += Stuff ) *
		public Assignment eleAssignmentStuff() {
			return (cAssignmentStuff != null) ? cAssignmentStuff : (cAssignmentStuff = (Assignment)getRule().eContents().get(1)); 
		}

		// Stuff
		public RuleCall ele0ParserRuleCallStuff() {
			return (c0ParserRuleCallStuff != null) ? c0ParserRuleCallStuff : (c0ParserRuleCallStuff = (RuleCall)eleAssignmentStuff().eContents().get(0)); 
		}
	}

	public class StuffElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Keyword c0KeywordStuff;
		private Assignment c1AssignmentName;
		private RuleCall c10LexerRuleCallID;
		
		// Stuff : 'stuff' name = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// 'stuff' name = ID
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// 'stuff'
		public Keyword ele0KeywordStuff() {
			return (c0KeywordStuff != null) ? c0KeywordStuff : (c0KeywordStuff = (Keyword)eleGroup().eContents().get(0)); 
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
	
	public final static TestLanguageGrammarAccess INSTANCE = new TestLanguageGrammarAccess();

	private static final String TESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/ui/core/TestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static FileElements pFile;
	private static StuffElements pStuff;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(TestLanguageGrammarAccess.class.getClassLoader(),TESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// File : ( stuff += Stuff ) * ;
	public FileElements prFile() {
		return (pFile != null) ? pFile : (pFile = new FileElements());
	} 

	// Stuff : 'stuff' name = ID ;
	public StuffElements prStuff() {
		return (pStuff != null) ? pStuff : (pStuff = new StuffElements());
	} 
}
