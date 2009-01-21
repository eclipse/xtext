/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class OptionalEmptyTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Assignment cAssignmentChild = (Assignment)rule.eContents().get(1);
		private final RuleCall c0ParserRuleCallGreeting = (RuleCall)cAssignmentChild.eContents().get(0);
		
		// Model : ( child = Greeting ) ? ;
		public ParserRule getRule() { return rule; }

		// ( child = Greeting ) ?
		public Assignment eleAssignmentChild() { return cAssignmentChild; }

		// Greeting
		public RuleCall ele0ParserRuleCallGreeting() { return c0ParserRuleCallGreeting; }
	}

	public class GreetingElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordHallo = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentName = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallID = (RuleCall)c1AssignmentName.eContents().get(0);
		
		// Greeting : "hallo" name = ID ;
		public ParserRule getRule() { return rule; }

		// "hallo" name = ID
		public Group eleGroup() { return cGroup; }

		// "hallo"
		public Keyword ele0KeywordHallo() { return c0KeywordHallo; }

		// name = ID
		public Assignment ele1AssignmentName() { return c1AssignmentName; }

		// ID
		public RuleCall ele10LexerRuleCallID() { return c10LexerRuleCallID; }
	}
	
	public final static OptionalEmptyTestLanguageGrammarAccess INSTANCE = new OptionalEmptyTestLanguageGrammarAccess();

	private static final String OPTIONALEMPTYTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/OptionalEmptyTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;
	private static GreetingElements pGreeting;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(OptionalEmptyTestLanguageGrammarAccess.class.getClassLoader(),OPTIONALEMPTYTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;
	}

	
	// Model : ( child = Greeting ) ? ;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Greeting : "hallo" name = ID ;
	public GreetingElements prGreeting() {
		return (pGreeting != null) ? pGreeting : (pGreeting = new GreetingElements());
	} 
}
