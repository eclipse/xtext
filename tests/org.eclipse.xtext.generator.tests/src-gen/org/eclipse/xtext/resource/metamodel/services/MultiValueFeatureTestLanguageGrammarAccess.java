/*
Generated with Xtext
*/

package org.eclipse.xtext.resource.metamodel.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class MultiValueFeatureTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class StartElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Assignment cAssignmentFeatureA = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cAssignmentFeatureA.eContents().get(0);
		
		// Start:   (featureA+=ID)+;
		public ParserRule getRule() { return rule; }

		// (featureA+=ID)+
		public Assignment eleAssignmentFeatureA() { return cAssignmentFeatureA; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }
	}
	
	public final static MultiValueFeatureTestLanguageGrammarAccess INSTANCE = new MultiValueFeatureTestLanguageGrammarAccess();

	private static final String MULTIVALUEFEATURETESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/resource/metamodel/MultiValueFeatureTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static StartElements pStart;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(MultiValueFeatureTestLanguageGrammarAccess.class.getClassLoader(),MULTIVALUEFEATURETESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;
	}

	
	// Start:   (featureA+=ID)+;
	public StartElements prStart() {
		return (pStart != null) ? pStart : (pStart = new StartElements());
	} 
}
