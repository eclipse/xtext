/*
Generated with Xtext
*/

package org.eclipse.xtext.metamodelreferencing.tests.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class MetamodelRefTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
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
		private Assignment cAssignmentRule;
		private CrossReference c0CrossReferenceParserRule;
		
		// NameRef returns RuleCall : rule = [ ParserRule ] ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// rule = [ ParserRule ]
		public Assignment eleAssignmentRule() {
			return (cAssignmentRule != null) ? cAssignmentRule : (cAssignmentRule = (Assignment)getRule().eContents().get(1)); 
		}

		// [ ParserRule ]
		public CrossReference ele0CrossReferenceParserRule() {
			return (c0CrossReferenceParserRule != null) ? c0CrossReferenceParserRule : (c0CrossReferenceParserRule = (CrossReference)eleAssignmentRule().eContents().get(0)); 
		}
	}

	public class MyRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentName;
		private RuleCall c0LexerRuleCallID;
		
		// MyRule returns ParserRule : name = ID ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(4)); 
		}

		// name = ID
		public Assignment eleAssignmentName() {
			return (cAssignmentName != null) ? cAssignmentName : (cAssignmentName = (Assignment)getRule().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0LexerRuleCallID() {
			return (c0LexerRuleCallID != null) ? c0LexerRuleCallID : (c0LexerRuleCallID = (RuleCall)eleAssignmentName().eContents().get(0)); 
		}
	}
	
	public final static MetamodelRefTestLanguageGrammarAccess INSTANCE = new MetamodelRefTestLanguageGrammarAccess();

	private static final String METAMODELREFTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/metamodelreferencing/tests/MetamodelRefTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static FooElements pFoo;
	private static NameRefElements pNameRef;
	private static MyRuleElements pMyRule;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(MetamodelRefTestLanguageGrammarAccess.class.getClassLoader(),METAMODELREFTESTLANGUAGE_GRAMMAR_CP_URI);
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

	// NameRef returns RuleCall : rule = [ ParserRule ] ;
	public NameRefElements prNameRef() {
		return (pNameRef != null) ? pNameRef : (pNameRef = new NameRefElements());
	} 

	// MyRule returns ParserRule : name = ID ;
	public MyRuleElements prMyRule() {
		return (pMyRule != null) ? pMyRule : (pMyRule = new MyRuleElements());
	} 
}
