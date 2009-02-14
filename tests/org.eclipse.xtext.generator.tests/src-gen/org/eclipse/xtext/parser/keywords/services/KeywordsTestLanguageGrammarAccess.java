/*
Generated with Xtext
*/

package org.eclipse.xtext.parser.keywords.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import org.eclipse.xtext.*;

import org.eclipse.xtext.service.GrammarProvider;

import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

@Singleton
public class KeywordsTestLanguageGrammarAccess implements IGrammarAccess {
	
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
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
		
		// Model:   first?="foo\\bar"|second?="foo\\"|third?="\\bar"|forth?="\\";
		public ParserRule getRule() { return rule; }

		// first?="foo\\bar"|second?="foo\\"|third?="\\bar"|forth?="\\"
		public Alternatives eleAlternatives() { return cAlternatives; }

		// first?="foo\\bar"|second?="foo\\"|third?="\\bar"
		public Alternatives ele0Alternatives() { return c0Alternatives; }

		// first?="foo\\bar"|second?="foo\\"
		public Alternatives ele00Alternatives() { return c00Alternatives; }

		// first?="foo\\bar"
		public Assignment ele000AssignmentFirst() { return c000AssignmentFirst; }

		// "foo\\bar"
		public Keyword ele0000KeywordFooBar() { return c0000KeywordFooBar; }

		// second?="foo\\"
		public Assignment ele001AssignmentSecond() { return c001AssignmentSecond; }

		// "foo\\"
		public Keyword ele0010KeywordFoo() { return c0010KeywordFoo; }

		// third?="\\bar"
		public Assignment ele01AssignmentThird() { return c01AssignmentThird; }

		// "\\bar"
		public Keyword ele010KeywordBar() { return c010KeywordBar; }

		// forth?="\\"
		public Assignment ele1AssignmentForth() { return c1AssignmentForth; }

		// "\\"
		public Keyword ele10KeywordReverseSolidus() { return c10KeywordReverseSolidus; }
	}
	
	private ModelElements pModel;
	
	private final GrammarProvider grammarProvider;

	private XtextBuiltinGrammarAccess superGrammarAccess;

	@Inject
	public KeywordsTestLanguageGrammarAccess(GrammarProvider grammarProvider, XtextBuiltinGrammarAccess superGrammarAccess) {
		this.grammarProvider = grammarProvider;
		this.superGrammarAccess = superGrammarAccess;
	}
	
	public Grammar getGrammar() {	
		return grammarProvider.getGrammar(this);
	}
	

	public XtextBuiltinGrammarAccess getSuperGrammarAccess() {
		return superGrammarAccess;
	}

	
	// Model:   first?="foo\\bar"|second?="foo\\"|third?="\\bar"|forth?="\\";
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 

	// lexer ID:   "(\'^\')?(\'a\'..\'z\'|\'A\'..\'Z\'|\'_\') (\'a\'..\'z\'|\'A\'..\'Z\'|\'_\'|\'0\'..\'9\')*";
	public LexerRule lrID() {
		return superGrammarAccess.lrID();
	} 

	// lexer INT returns EInt:   "(\'0\'..\'9\')+";
	public LexerRule lrINT() {
		return superGrammarAccess.lrINT();
	} 

	// lexer STRING:   "\n\t\t\t  \'\"\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\"\') )* \'\"\' | \n              \'\\\'\' ( \'\\\\\' (\'b\'|\'t\'|\'n\'|\'f\'|\'r\'|\'\\\"\'|\'\\\'\'|\'\\\\\') | ~(\'\\\\\'|\'\\\'\') )* \'\\\'\'\n              ";
	public LexerRule lrSTRING() {
		return superGrammarAccess.lrSTRING();
	} 

	// lexer ML_COMMENT:   "\'/*\' ( options {greedy=false;} : . )* \'*/\'";
	public LexerRule lrML_COMMENT() {
		return superGrammarAccess.lrML_COMMENT();
	} 

	// lexer SL_COMMENT:   "\'//\' ~(\'\\n\'|\'\\r\')* (\'\\r\'? \'\\n\')?";
	public LexerRule lrSL_COMMENT() {
		return superGrammarAccess.lrSL_COMMENT();
	} 

	// lexer WS:   "(\' \'|\'\\t\'|\'\\r\'|\'\\n\')+";
	public LexerRule lrWS() {
		return superGrammarAccess.lrWS();
	} 

	// lexer ANY_OTHER:   ".";
	public LexerRule lrANY_OTHER() {
		return superGrammarAccess.lrANY_OTHER();
	} 
}
