/*
Generated with Xtext
*/

package org.eclipse.xtext.crossrefs.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class ImportUriTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class MainElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Assignment c0AssignmentImports = (Assignment)cGroup.eContents().get(0);
		private final RuleCall c00ParserRuleCallImport = (RuleCall)c0AssignmentImports.eContents().get(0);
		private final Assignment c1AssignmentTypes = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallType = (RuleCall)c1AssignmentTypes.eContents().get(0);
		
		// Main : ( imports += Import ) * ( types += Type ) * ;
		public ParserRule getRule() { return rule; }

		// ( imports += Import ) * ( types += Type ) *
		public Group eleGroup() { return cGroup; }

		// ( imports += Import ) *
		public Assignment ele0AssignmentImports() { return c0AssignmentImports; }

		// Import
		public RuleCall ele00ParserRuleCallImport() { return c00ParserRuleCallImport; }

		// ( types += Type ) *
		public Assignment ele1AssignmentTypes() { return c1AssignmentTypes; }

		// Type
		public RuleCall ele10ParserRuleCallType() { return c10ParserRuleCallType; }
	}

	public class ImportElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(2);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword c0KeywordImport = (Keyword)cGroup.eContents().get(0);
		private final Assignment c1AssignmentImportURI = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10LexerRuleCallSTRING = (RuleCall)c1AssignmentImportURI.eContents().get(0);
		
		// Import : 'import' importURI = STRING ;
		public ParserRule getRule() { return rule; }

		// 'import' importURI = STRING
		public Group eleGroup() { return cGroup; }

		// 'import'
		public Keyword ele0KeywordImport() { return c0KeywordImport; }

		// importURI = STRING
		public Assignment ele1AssignmentImportURI() { return c1AssignmentImportURI; }

		// STRING
		public RuleCall ele10LexerRuleCallSTRING() { return c10LexerRuleCallSTRING; }
	}

	public class TypeElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(3);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordType = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentName = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallID = (RuleCall)c001AssignmentName.eContents().get(0);
		private final Keyword c01KeywordExtends = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentExtends = (Assignment)cGroup.eContents().get(1);
		private final CrossReference c10CrossReferenceEStringType = (CrossReference)c1AssignmentExtends.eContents().get(0);
		
		// Type : 'type' name = ID 'extends' ^extends = [ Type ] ;
		public ParserRule getRule() { return rule; }

		// 'type' name = ID 'extends' ^extends = [ Type ]
		public Group eleGroup() { return cGroup; }

		// 'type' name = ID 'extends'
		public Group ele0Group() { return c0Group; }

		// 'type' name = ID
		public Group ele00Group() { return c00Group; }

		// 'type'
		public Keyword ele000KeywordType() { return c000KeywordType; }

		// name = ID
		public Assignment ele001AssignmentName() { return c001AssignmentName; }

		// ID
		public RuleCall ele0010LexerRuleCallID() { return c0010LexerRuleCallID; }

		// 'extends'
		public Keyword ele01KeywordExtends() { return c01KeywordExtends; }

		// ^extends = [ Type ]
		public Assignment ele1AssignmentExtends() { return c1AssignmentExtends; }

		// [ Type ]
		public CrossReference ele10CrossReferenceEStringType() { return c10CrossReferenceEStringType; }
	}
	
	public final static ImportUriTestLanguageGrammarAccess INSTANCE = new ImportUriTestLanguageGrammarAccess();

	private static final String IMPORTURITESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/crossrefs/ImportUriTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static MainElements pMain;
	private static ImportElements pImport;
	private static TypeElements pType;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ImportUriTestLanguageGrammarAccess.class.getClassLoader(),IMPORTURITESTLANGUAGE_GRAMMAR_CP_URI);
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

	// Import : 'import' importURI = STRING ;
	public ImportElements prImport() {
		return (pImport != null) ? pImport : (pImport = new ImportElements());
	} 

	// Type : 'type' name = ID 'extends' ^extends = [ Type ] ;
	public TypeElements prType() {
		return (pType != null) ? pType : (pType = new TypeElements());
	} 
}
