/*
Generated with Xtext
*/

package org.eclipse.xtext.crossrefs.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class LangATestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class MainElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Assignment c0AssignmentImports;
		private RuleCall c00ParserRuleCallImport;
		private Assignment c1AssignmentTypes;
		private RuleCall c10ParserRuleCallType;
		
		// Main : ( imports += Import ) * ( types += Type ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// ( imports += Import ) * ( types += Type ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// ( imports += Import ) *
		public Assignment ele0AssignmentImports() {
			return (c0AssignmentImports != null) ? c0AssignmentImports : (c0AssignmentImports = (Assignment)eleGroup().eContents().get(0)); 
		}

		// Import
		public RuleCall ele00ParserRuleCallImport() {
			return (c00ParserRuleCallImport != null) ? c00ParserRuleCallImport : (c00ParserRuleCallImport = (RuleCall)ele0AssignmentImports().eContents().get(0)); 
		}

		// ( types += Type ) *
		public Assignment ele1AssignmentTypes() {
			return (c1AssignmentTypes != null) ? c1AssignmentTypes : (c1AssignmentTypes = (Assignment)eleGroup().eContents().get(1)); 
		}

		// Type
		public RuleCall ele10ParserRuleCallType() {
			return (c10ParserRuleCallType != null) ? c10ParserRuleCallType : (c10ParserRuleCallType = (RuleCall)ele1AssignmentTypes().eContents().get(0)); 
		}
	}

	public class ImportElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Keyword c0KeywordImport;
		private Assignment c1AssignmentUri;
		private RuleCall c10LexerRuleCallSTRING;
		
		// Import : 'import' uri = STRING ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// 'import' uri = STRING
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'import'
		public Keyword ele0KeywordImport() {
			return (c0KeywordImport != null) ? c0KeywordImport : (c0KeywordImport = (Keyword)eleGroup().eContents().get(0)); 
		}

		// uri = STRING
		public Assignment ele1AssignmentUri() {
			return (c1AssignmentUri != null) ? c1AssignmentUri : (c1AssignmentUri = (Assignment)eleGroup().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() {
			return (c10LexerRuleCallSTRING != null) ? c10LexerRuleCallSTRING : (c10LexerRuleCallSTRING = (RuleCall)ele1AssignmentUri().eContents().get(0)); 
		}
	}

	public class TypeElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000KeywordType;
		private Assignment c001AssignmentName;
		private RuleCall c0010LexerRuleCallID;
		private Keyword c01KeywordExtends;
		private Assignment c1AssignmentExtends;
		private CrossReference c10CrossReferenceType;
		
		// Type : 'type' name = ID 'extends' ^extends = [ Type ] ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(3)); 
		}

		// 'type' name = ID 'extends' ^extends = [ Type ]
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'type' name = ID 'extends'
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'type' name = ID
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'type'
		public Keyword ele000KeywordType() {
			return (c000KeywordType != null) ? c000KeywordType : (c000KeywordType = (Keyword)ele00Group().eContents().get(0)); 
		}

		// name = ID
		public Assignment ele001AssignmentName() {
			return (c001AssignmentName != null) ? c001AssignmentName : (c001AssignmentName = (Assignment)ele00Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0010LexerRuleCallID() {
			return (c0010LexerRuleCallID != null) ? c0010LexerRuleCallID : (c0010LexerRuleCallID = (RuleCall)ele001AssignmentName().eContents().get(0)); 
		}

		// 'extends'
		public Keyword ele01KeywordExtends() {
			return (c01KeywordExtends != null) ? c01KeywordExtends : (c01KeywordExtends = (Keyword)ele0Group().eContents().get(1)); 
		}

		// ^extends = [ Type ]
		public Assignment ele1AssignmentExtends() {
			return (c1AssignmentExtends != null) ? c1AssignmentExtends : (c1AssignmentExtends = (Assignment)eleGroup().eContents().get(1)); 
		}

		// [ Type ]
		public CrossReference ele10CrossReferenceType() {
			return (c10CrossReferenceType != null) ? c10CrossReferenceType : (c10CrossReferenceType = (CrossReference)ele1AssignmentExtends().eContents().get(0)); 
		}
	}
	
	public final static LangATestLanguageGrammarAccess INSTANCE = new LangATestLanguageGrammarAccess();

	private static final String LANGATESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/crossrefs/LangATestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static MainElements pMain;
	private static ImportElements pImport;
	private static TypeElements pType;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(LangATestLanguageGrammarAccess.class.getClassLoader(),LANGATESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Main : ( imports += Import ) * ( types += Type ) * ;
	public MainElements prMain() {
		return (pMain != null) ? pMain : (pMain = new MainElements());
	} 

	// Import : 'import' uri = STRING ;
	public ImportElements prImport() {
		return (pImport != null) ? pImport : (pImport = new ImportElements());
	} 

	// Type : 'type' name = ID 'extends' ^extends = [ Type ] ;
	public TypeElements prType() {
		return (pType != null) ? pType : (pType = new TypeElements());
	} 
}
