/*
Generated with Xtext
*/

package org.eclipse.xtext.dummy.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class DummyTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private ParserRule rule;
		private Assignment cAssignmentElements;
		private RuleCall c0ParserRuleCallElement;
		
		// Model : ( elements += Element ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// ( elements += Element ) *
		public Assignment eleAssignmentElements() {
			return (cAssignmentElements != null) ? cAssignmentElements : (cAssignmentElements = (Assignment)getRule().eContents().get(0)); 
		}

		// Element
		public RuleCall ele0ParserRuleCallElement() {
			return (c0ParserRuleCallElement != null) ? c0ParserRuleCallElement : (c0ParserRuleCallElement = (RuleCall)eleAssignmentElements().eContents().get(0)); 
		}
	}

	public class ElementElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Group c000Group;
		private Assignment c0000AssignmentOptional;
		private Keyword c00000KeywordOptional;
		private Keyword c0001KeywordElement;
		private Assignment c001AssignmentName;
		private RuleCall c0010LexerRuleCallID;
		private Assignment c01AssignmentDescriptions;
		private RuleCall c010LexerRuleCallSTRING;
		private Keyword c1Keyword;
		
		// Element : ( optional ?= 'optional' ) ? 'element' name = ID ( descriptions += STRING ) * ';' ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(2)); 
		}

		// ( optional ?= 'optional' ) ? 'element' name = ID ( descriptions += STRING ) * ';'
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// ( optional ?= 'optional' ) ? 'element' name = ID ( descriptions += STRING ) *
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// ( optional ?= 'optional' ) ? 'element' name = ID
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// ( optional ?= 'optional' ) ? 'element'
		public Group ele000Group() {
			return (c000Group != null) ? c000Group : (c000Group = (Group)ele00Group().eContents().get(0)); 
		}

		// ( optional ?= 'optional' ) ?
		public Assignment ele0000AssignmentOptional() {
			return (c0000AssignmentOptional != null) ? c0000AssignmentOptional : (c0000AssignmentOptional = (Assignment)ele000Group().eContents().get(0)); 
		}

		// 'optional'
		public Keyword ele00000KeywordOptional() {
			return (c00000KeywordOptional != null) ? c00000KeywordOptional : (c00000KeywordOptional = (Keyword)ele0000AssignmentOptional().eContents().get(0)); 
		}

		// 'element'
		public Keyword ele0001KeywordElement() {
			return (c0001KeywordElement != null) ? c0001KeywordElement : (c0001KeywordElement = (Keyword)ele000Group().eContents().get(1)); 
		}

		// name = ID
		public Assignment ele001AssignmentName() {
			return (c001AssignmentName != null) ? c001AssignmentName : (c001AssignmentName = (Assignment)ele00Group().eContents().get(1)); 
		}

		// ID
		public RuleCall ele0010LexerRuleCallID() {
			return (c0010LexerRuleCallID != null) ? c0010LexerRuleCallID : (c0010LexerRuleCallID = (RuleCall)ele001AssignmentName().eContents().get(0)); 
		}

		// ( descriptions += STRING ) *
		public Assignment ele01AssignmentDescriptions() {
			return (c01AssignmentDescriptions != null) ? c01AssignmentDescriptions : (c01AssignmentDescriptions = (Assignment)ele0Group().eContents().get(1)); 
		}

		// STRING
		public RuleCall ele010LexerRuleCallSTRING() {
			return (c010LexerRuleCallSTRING != null) ? c010LexerRuleCallSTRING : (c010LexerRuleCallSTRING = (RuleCall)ele01AssignmentDescriptions().eContents().get(0)); 
		}

		// ';'
		public Keyword ele1Keyword() {
			return (c1Keyword != null) ? c1Keyword : (c1Keyword = (Keyword)eleGroup().eContents().get(1)); 
		}
	}
	
	public final static DummyTestLanguageGrammarAccess INSTANCE = new DummyTestLanguageGrammarAccess();

	private static final String DUMMYTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/dummy/DummyTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;
	private static ElementElements pElement;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(DummyTestLanguageGrammarAccess.class.getClassLoader(),DUMMYTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;		
	}

	
	// Model : ( elements += Element ) * ;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// Element : ( optional ?= 'optional' ) ? 'element' name = ID ( descriptions += STRING ) * ';' ;
	public ElementElements prElement() {
		return (pElement != null) ? pElement : (pElement = new ElementElements());
	} 
}
