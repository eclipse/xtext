/*
Generated with Xtext
*/

package org.eclipse.xtext.generator.services;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.BaseEPackageAccess;
import org.eclipse.xtext.builtin.XtextBuiltinGrammarAccess;

public class LowerCaseNamedTestLanguageGrammarAccess extends BaseEPackageAccess implements IGrammarAccess {
	
	public class ModelElements implements IParserRuleAccess {
		private final ParserRule rule = (ParserRule) getGrammar().eContents().get(1);
		private final Assignment cAssignmentName = (Assignment)rule.eContents().get(1);
		private final RuleCall c0LexerRuleCallID = (RuleCall)cAssignmentName.eContents().get(0);
		
		// Model : name = ID ;
		public ParserRule getRule() { return rule; }

		// name = ID
		public Assignment eleAssignmentName() { return cAssignmentName; }

		// ID
		public RuleCall ele0LexerRuleCallID() { return c0LexerRuleCallID; }
	}
	
	public final static LowerCaseNamedTestLanguageGrammarAccess INSTANCE = new LowerCaseNamedTestLanguageGrammarAccess();

	private static final String LOWERCASENAMEDTESTLANGUAGE_GRAMMAR_CP_URI = "classpath:/org/eclipse/xtext/generator/lowerCaseNamedTestLanguage.xmi";
	private static Grammar GRAMMAR = null;
	private static ModelElements pModel;

	@SuppressWarnings("unused")
	public synchronized Grammar getGrammar() {	
		if (GRAMMAR==null) {
			// assert the XtextPackage implementation is loaded
			XtextPackage xtextPackage = XtextPackage.eINSTANCE;
			GRAMMAR = (Grammar) loadGrammarFile(LowerCaseNamedTestLanguageGrammarAccess.class.getClassLoader(),LOWERCASENAMEDTESTLANGUAGE_GRAMMAR_CP_URI);
		}
		return GRAMMAR;
	}
	
	public XtextBuiltinGrammarAccess getSuperGrammar() {
		return XtextBuiltinGrammarAccess.INSTANCE;
	}

	
	// Model : name = ID ;
	public ModelElements prModel() {
		return (pModel != null) ? pModel : (pModel = new ModelElements());
	} 
}
