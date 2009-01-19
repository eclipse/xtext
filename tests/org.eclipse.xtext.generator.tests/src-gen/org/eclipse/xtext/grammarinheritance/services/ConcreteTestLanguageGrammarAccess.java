/*
Generated with Xtext
*/

package org.eclipse.xtext.grammarinheritance.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;

public class ConcreteTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ConcreteParserRuleElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Group c0Group = (Group)cGroup.eContents().get(0);
		private final Group c00Group = (Group)c0Group.eContents().get(0);
		private final Keyword c000KeywordModel = (Keyword)c00Group.eContents().get(0);
		private final Assignment c001AssignmentMagicNumber = (Assignment)c00Group.eContents().get(1);
		private final RuleCall c0010LexerRuleCallREAL = (RuleCall)c001AssignmentMagicNumber.eContents().get(0);
		private final Keyword c01KeywordColon = (Keyword)c0Group.eContents().get(1);
		private final Assignment c1AssignmentElements = (Assignment)cGroup.eContents().get(1);
		private final RuleCall c10ParserRuleCallInheritedParserRule = (RuleCall)c1AssignmentElements.eContents().get(0);
		
		// ConcreteParserRule : 'model' magicNumber = REAL ':' ( elements += InheritedParserRule ) * ;
		public ParserRule getRule() { return rule; }

		// 'model' magicNumber = REAL ':' ( elements += InheritedParserRule ) *
		public Group eleGroup() { return cGroup; }

		// 'model' magicNumber = REAL ':'
		public Group ele0Group() { return c0Group; }

		// 'model' magicNumber = REAL
		public Group ele00Group() { return c00Group; }

		// 'model'
		public Keyword ele000KeywordModel() { return c000KeywordModel; }

		// magicNumber = REAL
		public Assignment ele001AssignmentMagicNumber() { return c001AssignmentMagicNumber; }

		// REAL
		public RuleCall ele0010LexerRuleCallREAL() { return c0010LexerRuleCallREAL; }

		// ':'
		public Keyword ele01KeywordColon() { return c01KeywordColon; }

		// ( elements += InheritedParserRule ) *
		public Assignment ele1AssignmentElements() { return c1AssignmentElements; }

		// InheritedParserRule
		public RuleCall ele10ParserRuleCallInheritedParserRule() { return c10ParserRuleCallInheritedParserRule; }
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
