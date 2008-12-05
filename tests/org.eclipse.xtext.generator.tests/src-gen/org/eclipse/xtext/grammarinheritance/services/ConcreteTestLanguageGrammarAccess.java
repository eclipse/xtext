/*
Generated with Xtext
*/

package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;

public class ConcreteTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ConcreteParserRuleElements implements IParserRuleAccess {
		private ParserRule rule;
		private Group cGroup;
		private Group c0Group;
		private Group c00Group;
		private Keyword c000KeywordModel;
		private Assignment c001AssignmentMagicNumber;
		private RuleCall c0010LexerRuleCallREAL;
		private Keyword c01Keyword;
		private Assignment c1AssignmentElements;
		private RuleCall c10ParserRuleCallInheritedParserRule;
		
		// ConcreteParserRule : 'model' magicNumber = REAL ':' ( elements += InheritedParserRule ) * ;
		public ParserRule getRule() {
			return (rule != null) ? rule : (rule = (ParserRule) getGrammar().eContents().get(1)); 
		}

		// 'model' magicNumber = REAL ':' ( elements += InheritedParserRule ) *
		public Group eleGroup() {
			return (cGroup != null) ? cGroup : (cGroup = (Group)getRule().eContents().get(0)); 
		}

		// 'model' magicNumber = REAL ':'
		public Group ele0Group() {
			return (c0Group != null) ? c0Group : (c0Group = (Group)eleGroup().eContents().get(0)); 
		}

		// 'model' magicNumber = REAL
		public Group ele00Group() {
			return (c00Group != null) ? c00Group : (c00Group = (Group)ele0Group().eContents().get(0)); 
		}

		// 'model'
		public Keyword ele000KeywordModel() {
			return (c000KeywordModel != null) ? c000KeywordModel : (c000KeywordModel = (Keyword)ele00Group().eContents().get(0)); 
		}

		// magicNumber = REAL
		public Assignment ele001AssignmentMagicNumber() {
			return (c001AssignmentMagicNumber != null) ? c001AssignmentMagicNumber : (c001AssignmentMagicNumber = (Assignment)ele00Group().eContents().get(1)); 
		}

		// REAL
		public RuleCall ele0010LexerRuleCallREAL() {
			return (c0010LexerRuleCallREAL != null) ? c0010LexerRuleCallREAL : (c0010LexerRuleCallREAL = (RuleCall)ele001AssignmentMagicNumber().eContents().get(0)); 
		}

		// ':'
		public Keyword ele01Keyword() {
			return (c01Keyword != null) ? c01Keyword : (c01Keyword = (Keyword)ele0Group().eContents().get(1)); 
		}

		// ( elements += InheritedParserRule ) *
		public Assignment ele1AssignmentElements() {
			return (c1AssignmentElements != null) ? c1AssignmentElements : (c1AssignmentElements = (Assignment)eleGroup().eContents().get(1)); 
		}

		// InheritedParserRule
		public RuleCall ele10ParserRuleCallInheritedParserRule() {
			return (c10ParserRuleCallInheritedParserRule != null) ? c10ParserRuleCallInheritedParserRule : (c10ParserRuleCallInheritedParserRule = (RuleCall)ele1AssignmentElements().eContents().get(0)); 
		}
	}
	
	public final static ConcreteTestLanguageGrammarAccess INSTANCE = new ConcreteTestLanguageGrammarAccess();

	private static final String CONCRETETESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/grammarinheritance/ConcreteTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ConcreteParserRuleElements pConcreteParserRule;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(ConcreteTestLanguageGrammarAccess.class.getClassLoader(),CONCRETETESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public AbstractTestLanguageGrammarAccess getSuperGrammar() {
		return AbstractTestLanguageGrammarAccess.INSTANCE;		
	}

	
	// ConcreteParserRule : 'model' magicNumber = REAL ':' ( elements += InheritedParserRule ) * ;
	public ConcreteParserRuleElements prConcreteParserRule() {
		return (pConcreteParserRule != null) ? pConcreteParserRule : (pConcreteParserRule = new ConcreteParserRuleElements());
	} 
}
