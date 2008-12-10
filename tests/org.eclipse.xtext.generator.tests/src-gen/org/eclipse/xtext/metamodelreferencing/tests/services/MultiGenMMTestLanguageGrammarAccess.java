/*
Generated with Xtext
*/

package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class MultiGenMMTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class FooElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Assignment c0AssignmentName;
		private RuleCall c00LexerRuleCallID;
		private Assignment c1AssignmentNameRefs;
		private RuleCall c10ParserRuleCallNameRef;
		
		// Foo : name = ID ( nameRefs += NameRef ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// name = ID ( nameRefs += NameRef ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(1)); 
		}

		// name = ID
		public Assignment ele0AssignmentName() {
			return (c0AssignmentName != null) ? c0AssignmentName : (c0AssignmentName = (Assignment)eleGroup().eContents().get(0)); 
		}

		// ID
		public RuleCall ele00LexerRuleCallID() {
			return (c00LexerRuleCallID != null) ? c00LexerRuleCallID : (c00LexerRuleCallID = (RuleCall)ele0AssignmentName().eContents().get(0)); 
		}

		// ( nameRefs += NameRef ) *
		public Assignment ele1AssignmentNameRefs() {
			return (c1AssignmentNameRefs != null) ? c1AssignmentNameRefs : (c1AssignmentNameRefs = (Assignment)eleGroup().eContents().get(1)); 
		}

		// NameRef
		public RuleCall ele10ParserRuleCallNameRef() {
			return (c10ParserRuleCallNameRef != null) ? c10ParserRuleCallNameRef : (c10ParserRuleCallNameRef = (RuleCall)ele1AssignmentNameRefs().eContents().get(0)); 
		}
	}

	public class NameRefElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentName;
		private RuleCall c0LexerRuleCallSTRING;
		
		// NameRef returns FooBar : name = STRING ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// name = STRING
		public Assignment eleAssignmentName() {
			return (cAssignmentName != null) ? cAssignmentName : (cAssignmentName = (Assignment)getRule().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele0LexerRuleCallSTRING() {
			return (c0LexerRuleCallSTRING != null) ? c0LexerRuleCallSTRING : (c0LexerRuleCallSTRING = (RuleCall)eleAssignmentName().eContents().get(0)); 
		}
	}
	
	public final static MultiGenMMTestLanguageGrammarAccess INSTANCE = new MultiGenMMTestLanguageGrammarAccess();

	private static final String MULTIGENMMTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/metamodelreferencing/tests/MultiGenMMTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static FooElements pFoo;
	private static NameRefElements pNameRef;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(MultiGenMMTestLanguageGrammarAccess.class.getClassLoader(),MULTIGENMMTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Foo : name = ID ( nameRefs += NameRef ) * ;
	public FooElements prFoo() {
		return (pFoo != null) ? pFoo : (pFoo = new FooElements());
	} 

	// NameRef returns FooBar : name = STRING ;
	public NameRefElements prNameRef() {
		return (pNameRef != null) ? pNameRef : (pNameRef = new NameRefElements());
	} 
}
