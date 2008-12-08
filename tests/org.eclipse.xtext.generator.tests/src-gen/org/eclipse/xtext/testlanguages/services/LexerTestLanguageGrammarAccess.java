/*
Generated with Xtext
*/

package org.eclipse.xtext.testlanguages.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class LexerTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentChildren;
		private RuleCall c0ParserRuleCallElement;
		
		// Model : ( children += Element ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// ( children += Element ) *
		public Assignment eleAssignmentChildren() {
			return (cAssignmentChildren != null) ? cAssignmentChildren : (cAssignmentChildren = (Assignment)getRule().eContents().get(0)); 
		}

		// Element
		public RuleCall ele0ParserRuleCallElement() {
			return (c0ParserRuleCallElement != null) ? c0ParserRuleCallElement : (c0ParserRuleCallElement = (RuleCall)eleAssignmentChildren().eContents().get(0)); 
		}
	}

	public class ElementElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Assignment c0AssignmentName;
		private RuleCall c00LexerRuleCallID;
		private Assignment c1AssignmentH;
		private RuleCall c10LexerRuleCallSTRING;
		
		// Element : name = ID h = STRING ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// name = ID h = STRING
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele0AssignmentName() {
			return (c0AssignmentName != null) ? c0AssignmentName : (c0AssignmentName = (Assignment)eleGroup().eContents().get(0)); 
		}

		// ID
		public RuleCall ele00LexerRuleCallID() {
			return (c00LexerRuleCallID != null) ? c00LexerRuleCallID : (c00LexerRuleCallID = (RuleCall)ele0AssignmentName().eContents().get(0)); 
		}

		// h = STRING
		public Assignment ele1AssignmentH() {
			return (c1AssignmentH != null) ? c1AssignmentH : (c1AssignmentH = (Assignment)eleGroup().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() {
			return (c10LexerRuleCallSTRING != null) ? c10LexerRuleCallSTRING : (c10LexerRuleCallSTRING = (RuleCall)ele1AssignmentH().eContents().get(0)); 
		}
	}
	
	public final static LexerTestLanguageGrammarAccess INSTANCE = new LexerTestLanguageGrammarAccess();

	private static final String LEXERTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/testlanguages/LexerTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;
	private static ElementElements pElement;
	private static LexerRule lSTRING;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(LexerTestLanguageGrammarAccess.class.getClassLoader(),LEXERTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Model : ( children += Element ) * ;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Element : name = ID h = STRING ;
	public ElementElements prElement() {
		return (pElement != null) ? pElement : (pElement = new ElementElements());
	} 

	// lexer STRING : " '#' ('B')+ " ;
	public LexerRule lrSTRING() {
		return (lSTRING != null) ? lSTRING : (lSTRING = (LexerRule) getGrammar().eContents().get(3));
	} 
}
