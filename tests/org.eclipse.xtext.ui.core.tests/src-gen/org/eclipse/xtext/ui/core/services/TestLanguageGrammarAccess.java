/*
Generated with Xtext
*/

package org.eclipse.xtext.ui.core.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class TestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class FileElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Assignment cAssignmentStuff = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallStuff = (RuleCall)cAssignmentStuff.eContents().get(0);
		
		// File : ( stuff += Stuff ) * ;
		public ParserRule getRule() { return rule; }

		// ( stuff += Stuff ) *
		public Assignment eleAssignmentStuff() { return cAssignmentStuff; }

		// Stuff
		public RuleCall ele0ParserRuleCallStuff() { return c0ParserRuleCallStuff; }
	}

	public class StuffElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordStuff = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// Stuff : 'stuff' name = ID ;
		public ParserRule getRule() { return rule; }

		// 'stuff' name = ID
		public Group eleGroup() { return cGroup; }

		// 'stuff'
		public Keyword ele0KeywordStuff() { return c0KeywordStuff; }

		// name = ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
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
