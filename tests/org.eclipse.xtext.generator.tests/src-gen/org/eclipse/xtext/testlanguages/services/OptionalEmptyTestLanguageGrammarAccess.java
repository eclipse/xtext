/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class OptionalEmptyTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentChild;
		private RuleCall c0ParserRuleCallGreeting;
		
		// Model : ( child = Greeting ) ? ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// ( child = Greeting ) ?
		public Assignment eleAssignmentChild() {
			return (cAssignmentChild != null) ? cAssignmentChild : (cAssignmentChild = (Assignment)getRule().eContents().get(0)); 
		}

		// Greeting
		public RuleCall ele0ParserRuleCallGreeting() {
			return (c0ParserRuleCallGreeting != null) ? c0ParserRuleCallGreeting : (c0ParserRuleCallGreeting = (RuleCall)eleAssignmentChild().eContents().get(0)); 
		}
	}

	public class GreetingElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Keyword c0KeywordHallo;
		private Assignment c1AssignmentName;
		private RuleCall c10LexerRuleCallID;
		
		// Greeting : 'hallo' name = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// 'hallo' name = ID
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'hallo'
		public Keyword ele0KeywordHallo() {
			return (c0KeywordHallo != null) ? c0KeywordHallo : (c0KeywordHallo = (Keyword)eleGroup().eContents().get(0)); 
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

	// Greeting : 'hallo' name = ID ;
	public GreetingElements prGreeting() {
		return (pGreeting != null) ? pGreeting : (pGreeting = new GreetingElements());
	} 
}
