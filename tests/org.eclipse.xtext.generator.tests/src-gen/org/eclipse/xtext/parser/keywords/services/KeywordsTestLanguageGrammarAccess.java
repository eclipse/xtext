/*
Generated with Xtext
*/

package org.eclipse.xtext.parser.keywords.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class KeywordsTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final Alternatives c0Alternatives = (Alternatives)cAlternatives.eContents().get(0);
		private final Alternatives c00Alternatives = (Alternatives)c0Alternatives.eContents().get(0);
		private final Assignment c000AssignmentFirst = (Assignment)c00Alternatives.eContents().get(0);
		private final Keyword c0000KeywordFooBar = (Keyword)c000AssignmentFirst.eContents().get(0);
		private final Assignment c001AssignmentSecond = (Assignment)c00Alternatives.eContents().get(1);
		private final Keyword c0010KeywordFoo = (Keyword)c001AssignmentSecond.eContents().get(0);
		private final Assignment c01AssignmentThird = (Assignment)c0Alternatives.eContents().get(1);
		private final Keyword c010KeywordBar = (Keyword)c01AssignmentThird.eContents().get(0);
		private final Assignment c1AssignmentForth = (Assignment)cAlternatives.eContents().get(1);
		private final Keyword c10KeywordReverseSolidus = (Keyword)c1AssignmentForth.eContents().get(0);
		
		// Model hidden ( WS , ML_COMMENT , SL_COMMENT ) : first ?= "foo\\bar" | second ?= "foo\\" | third ?= "\\bar" | forth ?= "\\" ;
		public ParserRule getRule() { return rule; }

		// first ?= "foo\\bar" | second ?= "foo\\" | third ?= "\\bar" | forth ?= "\\"
		public Alternatives eleAlternatives() { return cAlternatives; }

		// first ?= "foo\\bar" | second ?= "foo\\" | third ?= "\\bar"
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// first ?= "foo\\bar" | second ?= "foo\\"
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// first ?= "foo\\bar"
		public Assignment ele000AssignmentFirst() { return c000AssignmentFirst; }

		// "foo\\bar"
		public Keyword ele0000KeywordFooBar() { return c0000KeywordFooBar; }

		// second ?= "foo\\"
		public Assignment ele001AssignmentSecond() { return c001AssignmentSecond; }

		// "foo\\"
		public Keyword ele0010KeywordFoo() { return c0010KeywordFoo; }

		// third ?= "\\bar"
		public Assignment ele01AssignmentThird() { return c01AssignmentThird; }

		// "\\bar"
		public Keyword ele010KeywordBar() { return c010KeywordBar; }

		// forth ?= "\\"
		public Assignment ele1AssignmentForth() { return c1AssignmentForth; }

		// "\\"
		public Keyword ele10KeywordReverseSolidus() { return c10KeywordReverseSolidus; }
	}
	
	public final static KeywordsTestLanguageGrammarAccess INSTANCE = new KeywordsTestLanguageGrammarAccess();

	private static final String KEYWORDSTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/parser/keywords/KeywordsTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(KeywordsTestLanguageGrammarAccess.class.getClassLoader(),KEYWORDSTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;
	}

	
	// Model hidden ( WS , ML_COMMENT , SL_COMMENT ) : first ?= "foo\\bar" | second ?= "foo\\" | third ?= "\\bar" | forth ?= "\\" ;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 
}
